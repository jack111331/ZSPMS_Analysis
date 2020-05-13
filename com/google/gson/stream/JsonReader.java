package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
  private static final String FALSE = "false";
  
  private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
  
  private static final String TRUE = "true";
  
  private final char[] buffer = new char[1024];
  
  private int bufferStartColumn = 1;
  
  private int bufferStartLine = 1;
  
  private final Reader in;
  
  private boolean lenient = false;
  
  private int limit = 0;
  
  private String name;
  
  private int pos = 0;
  
  private boolean skipping;
  
  private JsonScope[] stack = new JsonScope[32];
  
  private int stackSize = 0;
  
  private final StringPool stringPool = new StringPool();
  
  private JsonToken token;
  
  private String value;
  
  private int valueLength;
  
  private int valuePos;
  
  static {
    JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
        public void promoteNameToValue(JsonReader param1JsonReader) throws IOException {
          if (param1JsonReader instanceof JsonTreeReader) {
            ((JsonTreeReader)param1JsonReader).promoteNameToValue();
            return;
          } 
          param1JsonReader.peek();
          if (param1JsonReader.token != JsonToken.NAME)
            throw new IllegalStateException("Expected a name but was " + param1JsonReader.peek() + " " + " at line " + param1JsonReader.getLineNumber() + " column " + param1JsonReader.getColumnNumber()); 
          JsonReader.access$302(param1JsonReader, param1JsonReader.name);
          JsonReader.access$402(param1JsonReader, null);
          JsonReader.access$002(param1JsonReader, JsonToken.STRING);
        }
      };
  }
  
  public JsonReader(Reader paramReader) {
    push(JsonScope.EMPTY_DOCUMENT);
    this.skipping = false;
    if (paramReader == null)
      throw new NullPointerException("in == null"); 
    this.in = paramReader;
  }
  
  private JsonToken advance() throws IOException {
    peek();
    JsonToken jsonToken = this.token;
    this.token = null;
    this.value = null;
    this.name = null;
    return jsonToken;
  }
  
  private void checkLenient() throws IOException {
    if (!this.lenient)
      throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON"); 
  }
  
  private void consumeNonExecutePrefix() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokespecial nextNonWhitespace : (Z)I
    //   5: pop
    //   6: aload_0
    //   7: aload_0
    //   8: getfield pos : I
    //   11: iconst_1
    //   12: isub
    //   13: putfield pos : I
    //   16: aload_0
    //   17: getfield pos : I
    //   20: getstatic com/google/gson/stream/JsonReader.NON_EXECUTE_PREFIX : [C
    //   23: arraylength
    //   24: iadd
    //   25: aload_0
    //   26: getfield limit : I
    //   29: if_icmple -> 44
    //   32: aload_0
    //   33: getstatic com/google/gson/stream/JsonReader.NON_EXECUTE_PREFIX : [C
    //   36: arraylength
    //   37: invokespecial fillBuffer : (I)Z
    //   40: ifne -> 44
    //   43: return
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: getstatic com/google/gson/stream/JsonReader.NON_EXECUTE_PREFIX : [C
    //   50: arraylength
    //   51: if_icmpge -> 79
    //   54: aload_0
    //   55: getfield buffer : [C
    //   58: aload_0
    //   59: getfield pos : I
    //   62: iload_1
    //   63: iadd
    //   64: caload
    //   65: getstatic com/google/gson/stream/JsonReader.NON_EXECUTE_PREFIX : [C
    //   68: iload_1
    //   69: caload
    //   70: if_icmpne -> 43
    //   73: iinc #1, 1
    //   76: goto -> 46
    //   79: aload_0
    //   80: aload_0
    //   81: getfield pos : I
    //   84: getstatic com/google/gson/stream/JsonReader.NON_EXECUTE_PREFIX : [C
    //   87: arraylength
    //   88: iadd
    //   89: putfield pos : I
    //   92: goto -> 43
  }
  
  private JsonToken decodeLiteral() throws IOException {
    if (this.valuePos == -1)
      return JsonToken.STRING; 
    if (this.valueLength == 4 && ('n' == this.buffer[this.valuePos] || 'N' == this.buffer[this.valuePos]) && ('u' == this.buffer[this.valuePos + 1] || 'U' == this.buffer[this.valuePos + 1]) && ('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && ('l' == this.buffer[this.valuePos + 3] || 'L' == this.buffer[this.valuePos + 3])) {
      this.value = "null";
      return JsonToken.NULL;
    } 
    if (this.valueLength == 4 && ('t' == this.buffer[this.valuePos] || 'T' == this.buffer[this.valuePos]) && ('r' == this.buffer[this.valuePos + 1] || 'R' == this.buffer[this.valuePos + 1]) && ('u' == this.buffer[this.valuePos + 2] || 'U' == this.buffer[this.valuePos + 2]) && ('e' == this.buffer[this.valuePos + 3] || 'E' == this.buffer[this.valuePos + 3])) {
      this.value = "true";
      return JsonToken.BOOLEAN;
    } 
    if (this.valueLength == 5 && ('f' == this.buffer[this.valuePos] || 'F' == this.buffer[this.valuePos]) && ('a' == this.buffer[this.valuePos + 1] || 'A' == this.buffer[this.valuePos + 1]) && ('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && ('s' == this.buffer[this.valuePos + 3] || 'S' == this.buffer[this.valuePos + 3]) && ('e' == this.buffer[this.valuePos + 4] || 'E' == this.buffer[this.valuePos + 4])) {
      this.value = "false";
      return JsonToken.BOOLEAN;
    } 
    this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
    return decodeNumber(this.buffer, this.valuePos, this.valueLength);
  }
  
  private JsonToken decodeNumber(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_2
    //   1: istore #4
    //   3: aload_1
    //   4: iload #4
    //   6: caload
    //   7: istore #5
    //   9: iload #5
    //   11: istore #6
    //   13: iload #4
    //   15: istore #7
    //   17: iload #5
    //   19: bipush #45
    //   21: if_icmpne -> 36
    //   24: iload #4
    //   26: iconst_1
    //   27: iadd
    //   28: istore #7
    //   30: aload_1
    //   31: iload #7
    //   33: caload
    //   34: istore #6
    //   36: iload #6
    //   38: bipush #48
    //   40: if_icmpne -> 121
    //   43: iload #7
    //   45: iconst_1
    //   46: iadd
    //   47: istore #6
    //   49: aload_1
    //   50: iload #6
    //   52: caload
    //   53: istore #4
    //   55: iload #4
    //   57: istore #5
    //   59: iload #6
    //   61: istore #7
    //   63: iload #4
    //   65: bipush #46
    //   67: if_icmpne -> 195
    //   70: iinc #6, 1
    //   73: aload_1
    //   74: iload #6
    //   76: caload
    //   77: istore #4
    //   79: iload #4
    //   81: istore #5
    //   83: iload #6
    //   85: istore #7
    //   87: iload #4
    //   89: bipush #48
    //   91: if_icmplt -> 195
    //   94: iload #4
    //   96: istore #5
    //   98: iload #6
    //   100: istore #7
    //   102: iload #4
    //   104: bipush #57
    //   106: if_icmpgt -> 195
    //   109: iinc #6, 1
    //   112: aload_1
    //   113: iload #6
    //   115: caload
    //   116: istore #4
    //   118: goto -> 79
    //   121: iload #6
    //   123: bipush #49
    //   125: if_icmplt -> 189
    //   128: iload #6
    //   130: bipush #57
    //   132: if_icmpgt -> 189
    //   135: iload #7
    //   137: iconst_1
    //   138: iadd
    //   139: istore #5
    //   141: aload_1
    //   142: iload #5
    //   144: caload
    //   145: istore #7
    //   147: iload #7
    //   149: istore #4
    //   151: iload #5
    //   153: istore #6
    //   155: iload #7
    //   157: bipush #48
    //   159: if_icmplt -> 55
    //   162: iload #7
    //   164: istore #4
    //   166: iload #5
    //   168: istore #6
    //   170: iload #7
    //   172: bipush #57
    //   174: if_icmpgt -> 55
    //   177: iinc #5, 1
    //   180: aload_1
    //   181: iload #5
    //   183: caload
    //   184: istore #7
    //   186: goto -> 147
    //   189: getstatic com/google/gson/stream/JsonToken.STRING : Lcom/google/gson/stream/JsonToken;
    //   192: astore_1
    //   193: aload_1
    //   194: areturn
    //   195: iload #5
    //   197: bipush #101
    //   199: if_icmpeq -> 213
    //   202: iload #7
    //   204: istore #6
    //   206: iload #5
    //   208: bipush #69
    //   210: if_icmpne -> 323
    //   213: iload #7
    //   215: iconst_1
    //   216: iadd
    //   217: istore #4
    //   219: aload_1
    //   220: iload #4
    //   222: caload
    //   223: istore #5
    //   225: iload #5
    //   227: bipush #43
    //   229: if_icmpeq -> 247
    //   232: iload #5
    //   234: istore #6
    //   236: iload #4
    //   238: istore #7
    //   240: iload #5
    //   242: bipush #45
    //   244: if_icmpne -> 259
    //   247: iload #4
    //   249: iconst_1
    //   250: iadd
    //   251: istore #7
    //   253: aload_1
    //   254: iload #7
    //   256: caload
    //   257: istore #6
    //   259: iload #6
    //   261: bipush #48
    //   263: if_icmplt -> 316
    //   266: iload #6
    //   268: bipush #57
    //   270: if_icmpgt -> 316
    //   273: iinc #7, 1
    //   276: aload_1
    //   277: iload #7
    //   279: caload
    //   280: istore #4
    //   282: iload #7
    //   284: istore #6
    //   286: iload #4
    //   288: bipush #48
    //   290: if_icmplt -> 323
    //   293: iload #7
    //   295: istore #6
    //   297: iload #4
    //   299: bipush #57
    //   301: if_icmpgt -> 323
    //   304: iinc #7, 1
    //   307: aload_1
    //   308: iload #7
    //   310: caload
    //   311: istore #4
    //   313: goto -> 282
    //   316: getstatic com/google/gson/stream/JsonToken.STRING : Lcom/google/gson/stream/JsonToken;
    //   319: astore_1
    //   320: goto -> 193
    //   323: iload #6
    //   325: iload_2
    //   326: iload_3
    //   327: iadd
    //   328: if_icmpne -> 338
    //   331: getstatic com/google/gson/stream/JsonToken.NUMBER : Lcom/google/gson/stream/JsonToken;
    //   334: astore_1
    //   335: goto -> 193
    //   338: getstatic com/google/gson/stream/JsonToken.STRING : Lcom/google/gson/stream/JsonToken;
    //   341: astore_1
    //   342: goto -> 193
  }
  
  private void expect(JsonToken paramJsonToken) throws IOException {
    peek();
    if (this.token != paramJsonToken)
      throw new IllegalStateException("Expected " + paramJsonToken + " but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    advance();
  }
  
  private boolean fillBuffer(int paramInt) throws IOException {
    boolean bool = true;
    char[] arrayOfChar = this.buffer;
    int i = this.bufferStartLine;
    int j = this.bufferStartColumn;
    byte b = 0;
    int k = this.pos;
    while (b < k) {
      if (arrayOfChar[b] == '\n') {
        i++;
        j = 1;
      } else {
        j++;
      } 
      b++;
    } 
    this.bufferStartLine = i;
    this.bufferStartColumn = j;
    if (this.limit != this.pos) {
      this.limit -= this.pos;
      System.arraycopy(arrayOfChar, this.pos, arrayOfChar, 0, this.limit);
    } else {
      this.limit = 0;
    } 
    this.pos = 0;
    while (true) {
      j = this.in.read(arrayOfChar, this.limit, arrayOfChar.length - this.limit);
      if (j != -1) {
        this.limit += j;
        if (this.bufferStartLine == 1 && this.bufferStartColumn == 1 && this.limit > 0 && arrayOfChar[0] == '﻿') {
          this.pos++;
          this.bufferStartColumn--;
        } 
        if (this.limit >= paramInt)
          return bool; 
        continue;
      } 
      return false;
    } 
  }
  
  private int getColumnNumber() {
    int i = this.bufferStartColumn;
    for (byte b = 0; b < this.pos; b++) {
      if (this.buffer[b] == '\n') {
        i = 1;
      } else {
        i++;
      } 
    } 
    return i;
  }
  
  private int getLineNumber() {
    int i = this.bufferStartLine;
    byte b = 0;
    while (b < this.pos) {
      int j = i;
      if (this.buffer[b] == '\n')
        j = i + 1; 
      b++;
      i = j;
    } 
    return i;
  }
  
  private JsonToken nextInArray(boolean paramBoolean) throws IOException {
    if (paramBoolean)
      this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_ARRAY; 
    switch (nextNonWhitespace(true)) {
      case 44:
        switch (nextNonWhitespace(true)) {
          default:
            this.pos--;
            return nextValue();
          case 93:
            if (paramBoolean) {
              this.stackSize--;
              JsonToken jsonToken1 = JsonToken.END_ARRAY;
              this.token = jsonToken1;
              return jsonToken1;
            } 
            break;
          case 44:
          case 59:
            break;
        } 
        break;
      default:
        throw syntaxError("Unterminated array");
      case 93:
        this.stackSize--;
        jsonToken = JsonToken.END_ARRAY;
        this.token = jsonToken;
        return jsonToken;
      case 59:
        checkLenient();
    } 
    checkLenient();
    this.pos--;
    this.value = "null";
    JsonToken jsonToken = JsonToken.NULL;
    this.token = jsonToken;
    return jsonToken;
  }
  
  private JsonToken nextInObject(boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      JsonToken jsonToken1;
      switch (nextNonWhitespace(true)) {
        default:
          this.pos--;
        case 125:
          this.stackSize--;
          jsonToken1 = JsonToken.END_OBJECT;
          this.token = jsonToken1;
          return jsonToken1;
      } 
    } else {
      int i;
      JsonToken jsonToken1;
      switch (nextNonWhitespace(true)) {
        case 44:
        case 59:
          i = nextNonWhitespace(true);
          switch (i) {
            default:
              checkLenient();
              this.pos--;
              this.name = nextLiteral(false);
              if (this.name.length() == 0)
                throw syntaxError("Expected name"); 
              break;
            case 39:
              checkLenient();
              break;
            case 34:
              break;
          } 
          break;
        default:
          throw syntaxError("Unterminated object");
        case 125:
          this.stackSize--;
          jsonToken1 = JsonToken.END_OBJECT;
          this.token = jsonToken1;
          return jsonToken1;
      } 
      this.name = nextString((char)i);
    } 
    this.stack[this.stackSize - 1] = JsonScope.DANGLING_NAME;
    JsonToken jsonToken = JsonToken.NAME;
    this.token = jsonToken;
    return jsonToken;
  }
  
  private String nextLiteral(boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_m1
    //   4: putfield valuePos : I
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield valueLength : I
    //   12: iconst_0
    //   13: istore_3
    //   14: aload_0
    //   15: getfield pos : I
    //   18: iload_3
    //   19: iadd
    //   20: aload_0
    //   21: getfield limit : I
    //   24: if_icmpge -> 243
    //   27: aload_2
    //   28: astore #4
    //   30: iload_3
    //   31: istore #5
    //   33: aload_0
    //   34: getfield buffer : [C
    //   37: aload_0
    //   38: getfield pos : I
    //   41: iload_3
    //   42: iadd
    //   43: caload
    //   44: lookupswitch default -> 184, 9 -> 200, 10 -> 200, 12 -> 200, 13 -> 200, 32 -> 200, 35 -> 190, 44 -> 200, 47 -> 190, 58 -> 200, 59 -> 190, 61 -> 190, 91 -> 200, 92 -> 190, 93 -> 200, 123 -> 200, 125 -> 200
    //   184: iinc #3, 1
    //   187: goto -> 14
    //   190: aload_0
    //   191: invokespecial checkLenient : ()V
    //   194: iload_3
    //   195: istore #5
    //   197: aload_2
    //   198: astore #4
    //   200: iload_1
    //   201: ifeq -> 352
    //   204: aload #4
    //   206: ifnonnull -> 352
    //   209: aload_0
    //   210: aload_0
    //   211: getfield pos : I
    //   214: putfield valuePos : I
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_0
    //   220: aload_0
    //   221: getfield valueLength : I
    //   224: iload #5
    //   226: iadd
    //   227: putfield valueLength : I
    //   230: aload_0
    //   231: aload_0
    //   232: getfield pos : I
    //   235: iload #5
    //   237: iadd
    //   238: putfield pos : I
    //   241: aload_2
    //   242: areturn
    //   243: iload_3
    //   244: aload_0
    //   245: getfield buffer : [C
    //   248: arraylength
    //   249: if_icmpge -> 282
    //   252: aload_0
    //   253: iload_3
    //   254: iconst_1
    //   255: iadd
    //   256: invokespecial fillBuffer : (I)Z
    //   259: ifne -> 14
    //   262: aload_0
    //   263: getfield buffer : [C
    //   266: aload_0
    //   267: getfield limit : I
    //   270: iconst_0
    //   271: i2c
    //   272: castore
    //   273: aload_2
    //   274: astore #4
    //   276: iload_3
    //   277: istore #5
    //   279: goto -> 200
    //   282: aload_2
    //   283: astore #4
    //   285: aload_2
    //   286: ifnonnull -> 298
    //   289: new java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial <init> : ()V
    //   296: astore #4
    //   298: aload #4
    //   300: aload_0
    //   301: getfield buffer : [C
    //   304: aload_0
    //   305: getfield pos : I
    //   308: iload_3
    //   309: invokevirtual append : ([CII)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_0
    //   314: aload_0
    //   315: getfield valueLength : I
    //   318: iload_3
    //   319: iadd
    //   320: putfield valueLength : I
    //   323: aload_0
    //   324: aload_0
    //   325: getfield pos : I
    //   328: iload_3
    //   329: iadd
    //   330: putfield pos : I
    //   333: iconst_0
    //   334: istore #5
    //   336: iconst_0
    //   337: istore_3
    //   338: aload #4
    //   340: astore_2
    //   341: aload_0
    //   342: iconst_1
    //   343: invokespecial fillBuffer : (I)Z
    //   346: ifne -> 14
    //   349: goto -> 200
    //   352: aload_0
    //   353: getfield skipping : Z
    //   356: ifeq -> 366
    //   359: ldc_w 'skipped!'
    //   362: astore_2
    //   363: goto -> 219
    //   366: aload #4
    //   368: ifnonnull -> 392
    //   371: aload_0
    //   372: getfield stringPool : Lcom/google/gson/stream/StringPool;
    //   375: aload_0
    //   376: getfield buffer : [C
    //   379: aload_0
    //   380: getfield pos : I
    //   383: iload #5
    //   385: invokevirtual get : ([CII)Ljava/lang/String;
    //   388: astore_2
    //   389: goto -> 219
    //   392: aload #4
    //   394: aload_0
    //   395: getfield buffer : [C
    //   398: aload_0
    //   399: getfield pos : I
    //   402: iload #5
    //   404: invokevirtual append : ([CII)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload #4
    //   410: invokevirtual toString : ()Ljava/lang/String;
    //   413: astore_2
    //   414: goto -> 219
  }
  
  private int nextNonWhitespace(boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield buffer : [C
    //   4: astore_2
    //   5: aload_0
    //   6: getfield pos : I
    //   9: istore_3
    //   10: aload_0
    //   11: getfield limit : I
    //   14: istore #4
    //   16: iload #4
    //   18: istore #5
    //   20: iload_3
    //   21: istore #6
    //   23: iload_3
    //   24: iload #4
    //   26: if_icmpne -> 101
    //   29: aload_0
    //   30: iload_3
    //   31: putfield pos : I
    //   34: aload_0
    //   35: iconst_1
    //   36: invokespecial fillBuffer : (I)Z
    //   39: ifne -> 89
    //   42: iload_1
    //   43: ifeq -> 381
    //   46: new java/io/EOFException
    //   49: dup
    //   50: new java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: ldc_w 'End of input at line '
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: invokespecial getLineNumber : ()I
    //   67: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   70: ldc ' column '
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokespecial getColumnNumber : ()I
    //   79: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: athrow
    //   89: aload_0
    //   90: getfield pos : I
    //   93: istore #6
    //   95: aload_0
    //   96: getfield limit : I
    //   99: istore #5
    //   101: iload #6
    //   103: iconst_1
    //   104: iadd
    //   105: istore_3
    //   106: aload_2
    //   107: iload #6
    //   109: caload
    //   110: istore #4
    //   112: iload #4
    //   114: lookupswitch default -> 172, 9 -> 182, 10 -> 182, 13 -> 182, 32 -> 182, 35 -> 354, 47 -> 189
    //   172: aload_0
    //   173: iload_3
    //   174: putfield pos : I
    //   177: iload #4
    //   179: istore_3
    //   180: iload_3
    //   181: ireturn
    //   182: iload #5
    //   184: istore #4
    //   186: goto -> 16
    //   189: aload_0
    //   190: iload_3
    //   191: putfield pos : I
    //   194: iload_3
    //   195: iload #5
    //   197: if_icmpne -> 238
    //   200: aload_0
    //   201: aload_0
    //   202: getfield pos : I
    //   205: iconst_1
    //   206: isub
    //   207: putfield pos : I
    //   210: aload_0
    //   211: iconst_2
    //   212: invokespecial fillBuffer : (I)Z
    //   215: istore #7
    //   217: aload_0
    //   218: aload_0
    //   219: getfield pos : I
    //   222: iconst_1
    //   223: iadd
    //   224: putfield pos : I
    //   227: iload #7
    //   229: ifne -> 238
    //   232: iload #4
    //   234: istore_3
    //   235: goto -> 180
    //   238: aload_0
    //   239: invokespecial checkLenient : ()V
    //   242: aload_2
    //   243: aload_0
    //   244: getfield pos : I
    //   247: caload
    //   248: lookupswitch default -> 276, 42 -> 282, 47 -> 326
    //   276: iload #4
    //   278: istore_3
    //   279: goto -> 180
    //   282: aload_0
    //   283: aload_0
    //   284: getfield pos : I
    //   287: iconst_1
    //   288: iadd
    //   289: putfield pos : I
    //   292: aload_0
    //   293: ldc_w '*/'
    //   296: invokespecial skipTo : (Ljava/lang/String;)Z
    //   299: ifne -> 310
    //   302: aload_0
    //   303: ldc_w 'Unterminated comment'
    //   306: invokespecial syntaxError : (Ljava/lang/String;)Ljava/io/IOException;
    //   309: athrow
    //   310: aload_0
    //   311: getfield pos : I
    //   314: iconst_2
    //   315: iadd
    //   316: istore_3
    //   317: aload_0
    //   318: getfield limit : I
    //   321: istore #4
    //   323: goto -> 16
    //   326: aload_0
    //   327: aload_0
    //   328: getfield pos : I
    //   331: iconst_1
    //   332: iadd
    //   333: putfield pos : I
    //   336: aload_0
    //   337: invokespecial skipToEndOfLine : ()V
    //   340: aload_0
    //   341: getfield pos : I
    //   344: istore_3
    //   345: aload_0
    //   346: getfield limit : I
    //   349: istore #4
    //   351: goto -> 16
    //   354: aload_0
    //   355: iload_3
    //   356: putfield pos : I
    //   359: aload_0
    //   360: invokespecial checkLenient : ()V
    //   363: aload_0
    //   364: invokespecial skipToEndOfLine : ()V
    //   367: aload_0
    //   368: getfield pos : I
    //   371: istore_3
    //   372: aload_0
    //   373: getfield limit : I
    //   376: istore #4
    //   378: goto -> 16
    //   381: iconst_m1
    //   382: istore_3
    //   383: goto -> 180
  }
  
  private String nextString(char paramChar) throws IOException {
    char[] arrayOfChar = this.buffer;
    String str = null;
    while (true) {
      int i = this.pos;
      int j = this.limit;
      int k;
      for (k = i; i < j; k = n) {
        StringBuilder stringBuilder;
        int m = i + 1;
        char c = arrayOfChar[i];
        if (c == paramChar) {
          this.pos = m;
          if (this.skipping)
            return "skipped!"; 
          if (str == null)
            return this.stringPool.get(arrayOfChar, k, m - k - 1); 
          str.append(arrayOfChar, k, m - k - 1);
          return str.toString();
        } 
        String str1 = str;
        i = m;
        int n = k;
        if (c == '\\') {
          this.pos = m;
          str1 = str;
          if (str == null)
            stringBuilder = new StringBuilder(); 
          stringBuilder.append(arrayOfChar, k, m - k - 1);
          stringBuilder.append(readEscapeCharacter());
          i = this.pos;
          j = this.limit;
          n = i;
        } 
        stringBuilder1 = stringBuilder;
      } 
      StringBuilder stringBuilder2 = stringBuilder1;
      if (stringBuilder1 == null)
        stringBuilder2 = new StringBuilder(); 
      stringBuilder2.append(arrayOfChar, k, i - k);
      this.pos = i;
      StringBuilder stringBuilder1 = stringBuilder2;
      if (!fillBuffer(1))
        throw syntaxError("Unterminated string"); 
    } 
  }
  
  private JsonToken nextValue() throws IOException {
    int i = nextNonWhitespace(true);
    switch (i) {
      default:
        this.pos--;
        return readLiteral();
      case 123:
        push(JsonScope.EMPTY_OBJECT);
        jsonToken = JsonToken.BEGIN_OBJECT;
        this.token = jsonToken;
        return jsonToken;
      case 91:
        push(JsonScope.EMPTY_ARRAY);
        jsonToken = JsonToken.BEGIN_ARRAY;
        this.token = jsonToken;
        return jsonToken;
      case 39:
        checkLenient();
        break;
      case 34:
        break;
    } 
    this.value = nextString((char)i);
    JsonToken jsonToken = JsonToken.STRING;
    this.token = jsonToken;
    return jsonToken;
  }
  
  private JsonToken objectValue() throws IOException {
    switch (nextNonWhitespace(true)) {
      default:
        throw syntaxError("Expected ':'");
      case 61:
        checkLenient();
        if ((this.pos < this.limit || fillBuffer(1)) && this.buffer[this.pos] == '>')
          this.pos++; 
        break;
      case 58:
        break;
    } 
    this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
    return nextValue();
  }
  
  private void push(JsonScope paramJsonScope) {
    if (this.stackSize == this.stack.length) {
      JsonScope[] arrayOfJsonScope1 = new JsonScope[this.stackSize * 2];
      System.arraycopy(this.stack, 0, arrayOfJsonScope1, 0, this.stackSize);
      this.stack = arrayOfJsonScope1;
    } 
    JsonScope[] arrayOfJsonScope = this.stack;
    int i = this.stackSize;
    this.stackSize = i + 1;
    arrayOfJsonScope[i] = paramJsonScope;
  }
  
  private char readEscapeCharacter() throws IOException {
    int j;
    int k;
    if (this.pos == this.limit && !fillBuffer(1))
      throw syntaxError("Unterminated escape sequence"); 
    char[] arrayOfChar = this.buffer;
    int i = this.pos;
    this.pos = i + 1;
    i = arrayOfChar[i];
    switch (i) {
      default:
        return i;
      case 117:
        if (this.pos + 4 > this.limit && !fillBuffer(4))
          throw syntaxError("Unterminated escape sequence"); 
        i = 0;
        j = this.pos;
        for (k = j; k < j + 4; k++) {
          char c = this.buffer[k];
          i = (char)(i << 4);
          if (c >= '0' && c <= '9') {
            i = (char)(c - 48 + i);
          } else if (c >= 'a' && c <= 'f') {
            i = (char)(c - 97 + 10 + i);
          } else if (c >= 'A' && c <= 'F') {
            i = (char)(c - 65 + 10 + i);
          } else {
            throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
          } 
        } 
        this.pos += 4;
        return i;
      case 116:
        i = 9;
        return i;
      case 98:
        i = 8;
        return i;
      case 110:
        i = 10;
        return i;
      case 114:
        i = 13;
        return i;
      case 102:
        break;
    } 
    i = 12;
    return i;
  }
  
  private JsonToken readLiteral() throws IOException {
    this.value = nextLiteral(true);
    if (this.valueLength == 0)
      throw syntaxError("Expected literal value"); 
    this.token = decodeLiteral();
    if (this.token == JsonToken.STRING)
      checkLenient(); 
    return this.token;
  }
  
  private boolean skipTo(String paramString) throws IOException {
    label16: while (true) {
      if (this.pos + paramString.length() <= this.limit || fillBuffer(paramString.length())) {
        for (byte b = 0; b < paramString.length(); b++) {
          if (this.buffer[this.pos + b] != paramString.charAt(b)) {
            this.pos++;
            continue label16;
          } 
        } 
        return true;
      } 
      return false;
    } 
  }
  
  private void skipToEndOfLine() throws IOException {
    while (this.pos < this.limit || fillBuffer(1)) {
      char[] arrayOfChar = this.buffer;
      int i = this.pos;
      this.pos = i + 1;
      i = arrayOfChar[i];
      if (i == 13 || i == 10)
        break; 
    } 
  }
  
  private IOException syntaxError(String paramString) throws IOException {
    throw new MalformedJsonException(paramString + " at line " + getLineNumber() + " column " + getColumnNumber());
  }
  
  public void beginArray() throws IOException {
    expect(JsonToken.BEGIN_ARRAY);
  }
  
  public void beginObject() throws IOException {
    expect(JsonToken.BEGIN_OBJECT);
  }
  
  public void close() throws IOException {
    this.value = null;
    this.token = null;
    this.stack[0] = JsonScope.CLOSED;
    this.stackSize = 1;
    this.in.close();
  }
  
  public void endArray() throws IOException {
    expect(JsonToken.END_ARRAY);
  }
  
  public void endObject() throws IOException {
    expect(JsonToken.END_OBJECT);
  }
  
  public boolean hasNext() throws IOException {
    peek();
    return (this.token != JsonToken.END_OBJECT && this.token != JsonToken.END_ARRAY);
  }
  
  public final boolean isLenient() {
    return this.lenient;
  }
  
  public boolean nextBoolean() throws IOException {
    peek();
    if (this.token != JsonToken.BOOLEAN)
      throw new IllegalStateException("Expected a boolean but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    if (this.value == "true") {
      boolean bool1 = true;
      advance();
      return bool1;
    } 
    boolean bool = false;
    advance();
    return bool;
  }
  
  public double nextDouble() throws IOException {
    peek();
    if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER)
      throw new IllegalStateException("Expected a double but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    double d = Double.parseDouble(this.value);
    if (d >= 1.0D && this.value.startsWith("0"))
      throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d)))
      throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    advance();
    return d;
  }
  
  public int nextInt() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual peek : ()Lcom/google/gson/stream/JsonToken;
    //   4: pop
    //   5: aload_0
    //   6: getfield token : Lcom/google/gson/stream/JsonToken;
    //   9: getstatic com/google/gson/stream/JsonToken.STRING : Lcom/google/gson/stream/JsonToken;
    //   12: if_acmpeq -> 80
    //   15: aload_0
    //   16: getfield token : Lcom/google/gson/stream/JsonToken;
    //   19: getstatic com/google/gson/stream/JsonToken.NUMBER : Lcom/google/gson/stream/JsonToken;
    //   22: if_acmpeq -> 80
    //   25: new java/lang/IllegalStateException
    //   28: dup
    //   29: new java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: ldc_w 'Expected an int but was '
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield token : Lcom/google/gson/stream/JsonToken;
    //   46: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc ' at line '
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: invokespecial getLineNumber : ()I
    //   58: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   61: ldc ' column '
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: invokespecial getColumnNumber : ()I
    //   70: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: athrow
    //   80: aload_0
    //   81: getfield value : Ljava/lang/String;
    //   84: invokestatic parseInt : (Ljava/lang/String;)I
    //   87: istore_1
    //   88: iload_1
    //   89: i2l
    //   90: lconst_1
    //   91: lcmp
    //   92: iflt -> 242
    //   95: aload_0
    //   96: getfield value : Ljava/lang/String;
    //   99: ldc_w '0'
    //   102: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   105: ifeq -> 242
    //   108: new com/google/gson/stream/MalformedJsonException
    //   111: dup
    //   112: new java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: ldc_w 'JSON forbids octal prefixes: '
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield value : Ljava/lang/String;
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc ' at line '
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: invokespecial getLineNumber : ()I
    //   141: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   144: ldc ' column '
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokespecial getColumnNumber : ()I
    //   153: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   156: invokevirtual toString : ()Ljava/lang/String;
    //   159: invokespecial <init> : (Ljava/lang/String;)V
    //   162: athrow
    //   163: astore_2
    //   164: aload_0
    //   165: getfield value : Ljava/lang/String;
    //   168: invokestatic parseDouble : (Ljava/lang/String;)D
    //   171: dstore_3
    //   172: dload_3
    //   173: d2i
    //   174: istore #5
    //   176: iload #5
    //   178: istore_1
    //   179: iload #5
    //   181: i2d
    //   182: dload_3
    //   183: dcmpl
    //   184: ifeq -> 88
    //   187: new java/lang/NumberFormatException
    //   190: dup
    //   191: new java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial <init> : ()V
    //   198: ldc_w 'Expected an int but was '
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: getfield value : Ljava/lang/String;
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc ' at line '
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokespecial getLineNumber : ()I
    //   220: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   223: ldc ' column '
    //   225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: invokespecial getColumnNumber : ()I
    //   232: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   235: invokevirtual toString : ()Ljava/lang/String;
    //   238: invokespecial <init> : (Ljava/lang/String;)V
    //   241: athrow
    //   242: aload_0
    //   243: invokespecial advance : ()Lcom/google/gson/stream/JsonToken;
    //   246: pop
    //   247: iload_1
    //   248: ireturn
    // Exception table:
    //   from	to	target	type
    //   80	88	163	java/lang/NumberFormatException
  }
  
  public long nextLong() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual peek : ()Lcom/google/gson/stream/JsonToken;
    //   4: pop
    //   5: aload_0
    //   6: getfield token : Lcom/google/gson/stream/JsonToken;
    //   9: getstatic com/google/gson/stream/JsonToken.STRING : Lcom/google/gson/stream/JsonToken;
    //   12: if_acmpeq -> 80
    //   15: aload_0
    //   16: getfield token : Lcom/google/gson/stream/JsonToken;
    //   19: getstatic com/google/gson/stream/JsonToken.NUMBER : Lcom/google/gson/stream/JsonToken;
    //   22: if_acmpeq -> 80
    //   25: new java/lang/IllegalStateException
    //   28: dup
    //   29: new java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: ldc_w 'Expected a long but was '
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield token : Lcom/google/gson/stream/JsonToken;
    //   46: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc ' at line '
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: invokespecial getLineNumber : ()I
    //   58: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   61: ldc ' column '
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: invokespecial getColumnNumber : ()I
    //   70: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: athrow
    //   80: aload_0
    //   81: getfield value : Ljava/lang/String;
    //   84: invokestatic parseLong : (Ljava/lang/String;)J
    //   87: lstore_1
    //   88: lload_1
    //   89: lconst_1
    //   90: lcmp
    //   91: iflt -> 244
    //   94: aload_0
    //   95: getfield value : Ljava/lang/String;
    //   98: ldc_w '0'
    //   101: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   104: ifeq -> 244
    //   107: new com/google/gson/stream/MalformedJsonException
    //   110: dup
    //   111: new java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial <init> : ()V
    //   118: ldc_w 'JSON forbids octal prefixes: '
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield value : Ljava/lang/String;
    //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc ' at line '
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: invokespecial getLineNumber : ()I
    //   140: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   143: ldc ' column '
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokespecial getColumnNumber : ()I
    //   152: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: invokespecial <init> : (Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_3
    //   163: aload_0
    //   164: getfield value : Ljava/lang/String;
    //   167: invokestatic parseDouble : (Ljava/lang/String;)D
    //   170: dstore #4
    //   172: dload #4
    //   174: d2l
    //   175: lstore #6
    //   177: lload #6
    //   179: lstore_1
    //   180: lload #6
    //   182: l2d
    //   183: dload #4
    //   185: dcmpl
    //   186: ifeq -> 88
    //   189: new java/lang/NumberFormatException
    //   192: dup
    //   193: new java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial <init> : ()V
    //   200: ldc_w 'Expected a long but was '
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield value : Ljava/lang/String;
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc ' at line '
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: invokespecial getLineNumber : ()I
    //   222: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   225: ldc ' column '
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: invokespecial getColumnNumber : ()I
    //   234: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   237: invokevirtual toString : ()Ljava/lang/String;
    //   240: invokespecial <init> : (Ljava/lang/String;)V
    //   243: athrow
    //   244: aload_0
    //   245: invokespecial advance : ()Lcom/google/gson/stream/JsonToken;
    //   248: pop
    //   249: lload_1
    //   250: lreturn
    // Exception table:
    //   from	to	target	type
    //   80	88	162	java/lang/NumberFormatException
  }
  
  public String nextName() throws IOException {
    peek();
    if (this.token != JsonToken.NAME)
      throw new IllegalStateException("Expected a name but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    String str = this.name;
    advance();
    return str;
  }
  
  public void nextNull() throws IOException {
    peek();
    if (this.token != JsonToken.NULL)
      throw new IllegalStateException("Expected null but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    advance();
  }
  
  public String nextString() throws IOException {
    peek();
    if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER)
      throw new IllegalStateException("Expected a string but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber()); 
    String str = this.value;
    advance();
    return str;
  }
  
  public JsonToken peek() throws IOException {
    JsonToken jsonToken;
    if (this.token != null)
      return this.token; 
    switch (this.stack[this.stackSize - 1]) {
      default:
        throw new AssertionError();
      case EMPTY_DOCUMENT:
        if (this.lenient)
          consumeNonExecutePrefix(); 
        this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
        jsonToken = nextValue();
        null = jsonToken;
        if (!this.lenient) {
          null = jsonToken;
          if (this.token != JsonToken.BEGIN_ARRAY) {
            null = jsonToken;
            if (this.token != JsonToken.BEGIN_OBJECT)
              throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber()); 
          } 
        } 
        return null;
      case EMPTY_ARRAY:
        return nextInArray(true);
      case NONEMPTY_ARRAY:
        return nextInArray(false);
      case EMPTY_OBJECT:
        return nextInObject(true);
      case DANGLING_NAME:
        return objectValue();
      case NONEMPTY_OBJECT:
        return nextInObject(false);
      case NONEMPTY_DOCUMENT:
        if (nextNonWhitespace(false) == -1)
          return JsonToken.END_DOCUMENT; 
        this.pos--;
        if (!this.lenient)
          throw syntaxError("Expected EOF"); 
        return nextValue();
      case CLOSED:
        break;
    } 
    throw new IllegalStateException("JsonReader is closed");
  }
  
  public final void setLenient(boolean paramBoolean) {
    this.lenient = paramBoolean;
  }
  
  public void skipValue() throws IOException {
    this.skipping = true;
    boolean bool = false;
    try {
      while (true) {
        while (true) {
          JsonToken jsonToken = advance();
          break;
        } 
        if (SYNTHETIC_LOCAL_VARIABLE_4 == null)
          return; 
      } 
    } finally {
      this.skipping = false;
    } 
  }
  
  public String toString() {
    return getClass().getSimpleName() + " at line " + getLineNumber() + " column " + getColumnNumber();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\stream\JsonReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */