package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

public final class SerializeWriter extends Writer {
  private static final Charset UTF8 = Charset.forName("UTF-8");
  
  private static final ThreadLocal<char[]> bufLocal = (ThreadLocal)new ThreadLocal<char>();
  
  private static final ThreadLocal<byte[]> bytesBufLocal = (ThreadLocal)new ThreadLocal<byte>();
  
  static final int nonDirectFeautres = SerializerFeature.UseSingleQuotes.mask | 0x0 | SerializerFeature.BrowserSecure.mask | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
  
  protected boolean beanToArray;
  
  protected char[] buf;
  
  protected int count;
  
  protected boolean disableCircularReferenceDetect;
  
  protected int features;
  
  protected char keySeperator;
  
  protected int maxBufSize = -1;
  
  protected boolean notWriteDefaultValue;
  
  protected boolean quoteFieldNames;
  
  protected boolean sortField;
  
  protected boolean useSingleQuotes;
  
  protected boolean writeDirect;
  
  protected boolean writeEnumUsingName;
  
  protected boolean writeEnumUsingToString;
  
  protected boolean writeNonStringValueAsString;
  
  private final Writer writer;
  
  public SerializeWriter() {
    this((Writer)null);
  }
  
  public SerializeWriter(int paramInt) {
    this((Writer)null, paramInt);
  }
  
  public SerializeWriter(Writer paramWriter) {
    this(paramWriter, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt) {
    this.writer = paramWriter;
    if (paramInt > 0) {
      this.buf = new char[paramInt];
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Negative initial size: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt, SerializerFeature... paramVarArgs) {
    this.writer = paramWriter;
    this.buf = bufLocal.get();
    if (this.buf != null) {
      bufLocal.set(null);
    } else {
      this.buf = new char[2048];
    } 
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      paramInt |= paramVarArgs[b].getMask(); 
    this.features = paramInt;
    computeFeatures();
  }
  
  public SerializeWriter(Writer paramWriter, SerializerFeature... paramVarArgs) {
    this(paramWriter, 0, paramVarArgs);
  }
  
  public SerializeWriter(SerializerFeature... paramVarArgs) {
    this((Writer)null, paramVarArgs);
  }
  
  private int encodeToUTF8(OutputStream paramOutputStream) throws IOException {
    double d = this.count;
    Double.isNaN(d);
    int i = (int)(d * 3.0D);
    byte[] arrayOfByte1 = bytesBufLocal.get();
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1 == null) {
      arrayOfByte2 = new byte[8192];
      bytesBufLocal.set(arrayOfByte2);
    } 
    arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2.length < i)
      arrayOfByte1 = new byte[i]; 
    i = IOUtils.encodeUTF8(this.buf, 0, this.count, arrayOfByte1);
    paramOutputStream.write(arrayOfByte1, 0, i);
    return i;
  }
  
  private byte[] encodeToUTF8Bytes() {
    double d = this.count;
    Double.isNaN(d);
    int i = (int)(d * 3.0D);
    byte[] arrayOfByte1 = bytesBufLocal.get();
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1 == null) {
      arrayOfByte2 = new byte[8192];
      bytesBufLocal.set(arrayOfByte2);
    } 
    arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2.length < i)
      arrayOfByte1 = new byte[i]; 
    i = IOUtils.encodeUTF8(this.buf, 0, this.count, arrayOfByte1);
    arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    return arrayOfByte2;
  }
  
  static boolean isSpecial(char paramChar, int paramInt) {
    boolean bool = false;
    if (paramChar == ' ')
      return false; 
    if (paramChar == '/') {
      if ((SerializerFeature.WriteSlashAsSpecial.mask & paramInt) != 0)
        bool = true; 
      return bool;
    } 
    return (paramChar > '#' && paramChar != '\\') ? false : ((paramChar <= '\037' || paramChar == '\\' || paramChar == '"'));
  }
  
  private void writeEnumFieldValue(char paramChar, String paramString1, String paramString2) {
    if (this.useSingleQuotes) {
      writeFieldValue(paramChar, paramString1, paramString2);
    } else {
      writeFieldValueStringWithDoubleQuote(paramChar, paramString1, paramString2);
    } 
  }
  
  private void writeKeyWithSingleQuoteIfHasSpecial(String paramString) {
    char[] arrayOfChar;
    byte[] arrayOfByte = IOUtils.specicalFlags_singleQuotes;
    int i = paramString.length();
    int j = this.count;
    int k = 1;
    int m = j + i + 1;
    j = this.buf.length;
    int n = 0;
    if (m > j) {
      if (this.writer != null) {
        if (i == 0) {
          write(39);
          write(39);
          write(58);
          return;
        } 
        j = 0;
        while (true) {
          if (j < i) {
            char c = paramString.charAt(j);
            if (c < arrayOfByte.length && arrayOfByte[c] != 0) {
              j = k;
              break;
            } 
            j++;
            continue;
          } 
          j = 0;
          break;
        } 
        k = n;
        if (j != 0) {
          write(39);
          k = n;
        } 
        while (k < i) {
          n = paramString.charAt(k);
          if (n < arrayOfByte.length && arrayOfByte[n] != 0) {
            write(92);
            write(IOUtils.replaceChars[n]);
          } else {
            write(n);
          } 
          k++;
        } 
        if (j != 0)
          write(39); 
        write(58);
        return;
      } 
      expandCapacity(m);
    } 
    if (i == 0) {
      if (this.count + 3 > this.buf.length)
        expandCapacity(this.count + 3); 
      arrayOfChar = this.buf;
      j = this.count;
      this.count = j + 1;
      arrayOfChar[j] = (char)'\'';
      arrayOfChar = this.buf;
      j = this.count;
      this.count = j + 1;
      arrayOfChar[j] = (char)'\'';
      arrayOfChar = this.buf;
      j = this.count;
      this.count = j + 1;
      arrayOfChar[j] = (char)':';
      return;
    } 
    int i2 = this.count;
    int i1 = i2 + i;
    arrayOfChar.getChars(0, i, this.buf, i2);
    this.count = m;
    j = i2;
    boolean bool = false;
    while (j < i1) {
      char c = this.buf[j];
      i = j;
      boolean bool1 = bool;
      n = m;
      k = i1;
      if (c < arrayOfByte.length) {
        i = j;
        bool1 = bool;
        n = m;
        k = i1;
        if (arrayOfByte[c] != 0)
          if (!bool) {
            n = m + 3;
            if (n > this.buf.length)
              expandCapacity(n); 
            this.count = n;
            arrayOfChar = this.buf;
            k = j + 1;
            System.arraycopy(arrayOfChar, k, this.buf, j + 3, i1 - j - 1);
            System.arraycopy(this.buf, 0, this.buf, 1, j);
            this.buf[i2] = (char)'\'';
            this.buf[k] = (char)'\\';
            arrayOfChar = this.buf;
            i = k + 1;
            arrayOfChar[i] = (char)IOUtils.replaceChars[c];
            k = i1 + 2;
            this.buf[this.count - 2] = (char)'\'';
            bool1 = true;
          } else {
            n = m + 1;
            if (n > this.buf.length)
              expandCapacity(n); 
            this.count = n;
            arrayOfChar = this.buf;
            i = j + 1;
            System.arraycopy(arrayOfChar, i, this.buf, j + 2, i1 - j);
            this.buf[j] = (char)'\\';
            this.buf[i] = (char)IOUtils.replaceChars[c];
            k = i1 + 1;
            bool1 = bool;
          }  
      } 
      j = i + 1;
      bool = bool1;
      m = n;
      i1 = k;
    } 
    this.buf[m - 1] = (char)':';
  }
  
  public SerializeWriter append(char paramChar) {
    write(paramChar);
    return this;
  }
  
  public SerializeWriter append(CharSequence paramCharSequence) {
    if (paramCharSequence == null) {
      paramCharSequence = "null";
    } else {
      paramCharSequence = paramCharSequence.toString();
    } 
    write((String)paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public SerializeWriter append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence == null)
      charSequence = "null"; 
    paramCharSequence = charSequence.subSequence(paramInt1, paramInt2).toString();
    write((String)paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public void close() {
    if (this.writer != null && this.count > 0)
      flush(); 
    if (this.buf.length <= 65536)
      bufLocal.set(this.buf); 
    this.buf = null;
  }
  
  protected void computeFeatures() {
    // Byte code:
    //   0: aload_0
    //   1: getfield features : I
    //   4: istore_1
    //   5: getstatic com/alibaba/fastjson/serializer/SerializerFeature.QuoteFieldNames : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   8: getfield mask : I
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_3
    //   14: iload_1
    //   15: iload_2
    //   16: iand
    //   17: ifeq -> 26
    //   20: iconst_1
    //   21: istore #4
    //   23: goto -> 29
    //   26: iconst_0
    //   27: istore #4
    //   29: aload_0
    //   30: iload #4
    //   32: putfield quoteFieldNames : Z
    //   35: aload_0
    //   36: getfield features : I
    //   39: getstatic com/alibaba/fastjson/serializer/SerializerFeature.UseSingleQuotes : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   42: getfield mask : I
    //   45: iand
    //   46: ifeq -> 55
    //   49: iconst_1
    //   50: istore #4
    //   52: goto -> 58
    //   55: iconst_0
    //   56: istore #4
    //   58: aload_0
    //   59: iload #4
    //   61: putfield useSingleQuotes : Z
    //   64: aload_0
    //   65: getfield features : I
    //   68: getstatic com/alibaba/fastjson/serializer/SerializerFeature.SortField : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   71: getfield mask : I
    //   74: iand
    //   75: ifeq -> 84
    //   78: iconst_1
    //   79: istore #4
    //   81: goto -> 87
    //   84: iconst_0
    //   85: istore #4
    //   87: aload_0
    //   88: iload #4
    //   90: putfield sortField : Z
    //   93: aload_0
    //   94: getfield features : I
    //   97: getstatic com/alibaba/fastjson/serializer/SerializerFeature.DisableCircularReferenceDetect : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   100: getfield mask : I
    //   103: iand
    //   104: ifeq -> 113
    //   107: iconst_1
    //   108: istore #4
    //   110: goto -> 116
    //   113: iconst_0
    //   114: istore #4
    //   116: aload_0
    //   117: iload #4
    //   119: putfield disableCircularReferenceDetect : Z
    //   122: aload_0
    //   123: getfield features : I
    //   126: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BeanToArray : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   129: getfield mask : I
    //   132: iand
    //   133: ifeq -> 142
    //   136: iconst_1
    //   137: istore #4
    //   139: goto -> 145
    //   142: iconst_0
    //   143: istore #4
    //   145: aload_0
    //   146: iload #4
    //   148: putfield beanToArray : Z
    //   151: aload_0
    //   152: getfield features : I
    //   155: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNonStringValueAsString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   158: getfield mask : I
    //   161: iand
    //   162: ifeq -> 171
    //   165: iconst_1
    //   166: istore #4
    //   168: goto -> 174
    //   171: iconst_0
    //   172: istore #4
    //   174: aload_0
    //   175: iload #4
    //   177: putfield writeNonStringValueAsString : Z
    //   180: aload_0
    //   181: getfield features : I
    //   184: getstatic com/alibaba/fastjson/serializer/SerializerFeature.NotWriteDefaultValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   187: getfield mask : I
    //   190: iand
    //   191: ifeq -> 200
    //   194: iconst_1
    //   195: istore #4
    //   197: goto -> 203
    //   200: iconst_0
    //   201: istore #4
    //   203: aload_0
    //   204: iload #4
    //   206: putfield notWriteDefaultValue : Z
    //   209: aload_0
    //   210: getfield features : I
    //   213: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteEnumUsingName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   216: getfield mask : I
    //   219: iand
    //   220: ifeq -> 229
    //   223: iconst_1
    //   224: istore #4
    //   226: goto -> 232
    //   229: iconst_0
    //   230: istore #4
    //   232: aload_0
    //   233: iload #4
    //   235: putfield writeEnumUsingName : Z
    //   238: aload_0
    //   239: getfield features : I
    //   242: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteEnumUsingToString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   245: getfield mask : I
    //   248: iand
    //   249: ifeq -> 258
    //   252: iconst_1
    //   253: istore #4
    //   255: goto -> 261
    //   258: iconst_0
    //   259: istore #4
    //   261: aload_0
    //   262: iload #4
    //   264: putfield writeEnumUsingToString : Z
    //   267: iload_3
    //   268: istore #4
    //   270: aload_0
    //   271: getfield quoteFieldNames : Z
    //   274: ifeq -> 311
    //   277: iload_3
    //   278: istore #4
    //   280: aload_0
    //   281: getfield features : I
    //   284: getstatic com/alibaba/fastjson/serializer/SerializeWriter.nonDirectFeautres : I
    //   287: iand
    //   288: ifne -> 311
    //   291: aload_0
    //   292: getfield beanToArray : Z
    //   295: ifne -> 308
    //   298: iload_3
    //   299: istore #4
    //   301: aload_0
    //   302: getfield writeEnumUsingName : Z
    //   305: ifeq -> 311
    //   308: iconst_1
    //   309: istore #4
    //   311: aload_0
    //   312: iload #4
    //   314: putfield writeDirect : Z
    //   317: aload_0
    //   318: getfield useSingleQuotes : Z
    //   321: ifeq -> 330
    //   324: bipush #39
    //   326: istore_2
    //   327: goto -> 333
    //   330: bipush #34
    //   332: istore_2
    //   333: aload_0
    //   334: iload_2
    //   335: i2c
    //   336: putfield keySeperator : C
    //   339: return
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    if (paramBoolean) {
      this.features |= paramSerializerFeature.getMask();
      if (paramSerializerFeature == SerializerFeature.WriteEnumUsingToString) {
        this.features &= SerializerFeature.WriteEnumUsingName.getMask() ^ 0xFFFFFFFF;
      } else if (paramSerializerFeature == SerializerFeature.WriteEnumUsingName) {
        this.features &= SerializerFeature.WriteEnumUsingToString.getMask() ^ 0xFFFFFFFF;
      } 
    } else {
      int i = this.features;
      this.features = (paramSerializerFeature.getMask() ^ 0xFFFFFFFF) & i;
    } 
    computeFeatures();
  }
  
  public void expandCapacity(int paramInt) {
    if (this.maxBufSize == -1 || paramInt < this.maxBufSize) {
      int i = this.buf.length * 3 / 2 + 1;
      if (i >= paramInt)
        paramInt = i; 
      char[] arrayOfChar = new char[paramInt];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      this.buf = arrayOfChar;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("serialize exceeded MAX_OUTPUT_LENGTH=");
    stringBuilder.append(this.maxBufSize);
    stringBuilder.append(", minimumCapacity=");
    stringBuilder.append(paramInt);
    throw new JSONException(stringBuilder.toString());
  }
  
  public void flush() {
    if (this.writer == null)
      return; 
    try {
      this.writer.write(this.buf, 0, this.count);
      this.writer.flush();
      this.count = 0;
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } 
  }
  
  public int getBufferLength() {
    return this.buf.length;
  }
  
  public int getMaxBufSize() {
    return this.maxBufSize;
  }
  
  public boolean isEnabled(int paramInt) {
    boolean bool;
    if ((paramInt & this.features) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature) {
    boolean bool;
    int i = this.features;
    if ((paramSerializerFeature.mask & i) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isNotWriteDefaultValue() {
    return this.notWriteDefaultValue;
  }
  
  public boolean isSortField() {
    return this.sortField;
  }
  
  public void setMaxBufSize(int paramInt) {
    if (paramInt >= this.buf.length) {
      this.maxBufSize = paramInt;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("must > ");
    stringBuilder.append(this.buf.length);
    throw new JSONException(stringBuilder.toString());
  }
  
  public int size() {
    return this.count;
  }
  
  public byte[] toBytes(String paramString) {
    if (paramString == null || "UTF-8".equals(paramString)) {
      charset = UTF8;
      return toBytes(charset);
    } 
    Charset charset = Charset.forName((String)charset);
    return toBytes(charset);
  }
  
  public byte[] toBytes(Charset paramCharset) {
    if (this.writer == null)
      return (paramCharset == UTF8) ? encodeToUTF8Bytes() : (new String(this.buf, 0, this.count)).getBytes(paramCharset); 
    throw new UnsupportedOperationException("writer not null");
  }
  
  public char[] toCharArray() {
    if (this.writer == null) {
      char[] arrayOfChar = new char[this.count];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      return arrayOfChar;
    } 
    throw new UnsupportedOperationException("writer not null");
  }
  
  public char[] toCharArrayForSpringWebSocket() {
    if (this.writer == null) {
      char[] arrayOfChar = new char[this.count - 2];
      System.arraycopy(this.buf, 1, arrayOfChar, 0, this.count - 2);
      return arrayOfChar;
    } 
    throw new UnsupportedOperationException("writer not null");
  }
  
  public String toString() {
    return new String(this.buf, 0, this.count);
  }
  
  public void write(int paramInt) {
    int i = this.count + 1;
    int j = i;
    if (i > this.buf.length)
      if (this.writer == null) {
        expandCapacity(i);
        j = i;
      } else {
        flush();
        j = 1;
      }  
    this.buf[this.count] = (char)(char)paramInt;
    this.count = j;
  }
  
  public void write(String paramString) {
    if (paramString == null) {
      writeNull();
      return;
    } 
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2) {
    int i = this.count + paramInt2;
    int j = i;
    int k = paramInt1;
    int m = paramInt2;
    if (i > this.buf.length) {
      j = paramInt1;
      k = paramInt2;
      if (this.writer == null) {
        expandCapacity(i);
        j = i;
        k = paramInt1;
        m = paramInt2;
      } else {
        while (true) {
          paramInt1 = this.buf.length - this.count;
          paramInt2 = j + paramInt1;
          paramString.getChars(j, paramInt2, this.buf, this.count);
          this.count = this.buf.length;
          flush();
          paramInt1 = k - paramInt1;
          if (paramInt1 <= this.buf.length) {
            j = paramInt1;
            k = paramInt2;
            m = paramInt1;
            break;
          } 
          j = paramInt2;
          k = paramInt1;
        } 
      } 
    } 
    paramString.getChars(k, m + k, this.buf, this.count);
    this.count = j;
  }
  
  public void write(List<String> paramList) {
    if (paramList.isEmpty()) {
      write("[]");
      return;
    } 
    int i = this.count;
    int j = paramList.size();
    int k = i;
    byte b = 0;
    while (b < j) {
      String str = paramList.get(b);
      if (str == null) {
        m = 1;
      } else {
        int i1 = str.length();
        byte b1 = 0;
        m = 0;
        while (b1 < i1) {
          m = str.charAt(b1);
          if (m < 32 || m > 126 || m == 34 || m == 92) {
            m = 1;
          } else {
            m = 0;
          } 
          if (m != 0)
            break; 
          b1++;
        } 
      } 
      if (m != 0) {
        this.count = i;
        write(91);
        for (m = 0; m < paramList.size(); m++) {
          str = paramList.get(m);
          if (m != 0)
            write(44); 
          if (str == null) {
            write("null");
          } else {
            writeStringWithDoubleQuote(str, false);
          } 
        } 
        write(93);
        return;
      } 
      int n = str.length() + k + 3;
      int m = n;
      if (b == paramList.size() - 1)
        m = n + 1; 
      if (m > this.buf.length) {
        this.count = k;
        expandCapacity(m);
      } 
      if (b == 0) {
        char[] arrayOfChar1 = this.buf;
        m = k + 1;
        arrayOfChar1[k] = (char)'[';
      } else {
        char[] arrayOfChar1 = this.buf;
        m = k + 1;
        arrayOfChar1[k] = (char)',';
      } 
      char[] arrayOfChar = this.buf;
      k = m + 1;
      arrayOfChar[m] = (char)'"';
      str.getChars(0, str.length(), this.buf, k);
      m = k + str.length();
      this.buf[m] = (char)'"';
      b++;
      k = m + 1;
    } 
    this.buf[k] = (char)']';
    this.count = k + 1;
  }
  
  public void write(boolean paramBoolean) {
    if (paramBoolean) {
      write("true");
    } else {
      write("false");
    } 
  }
  
  public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (paramInt1 >= 0 && paramInt1 <= paramArrayOfchar.length && paramInt2 >= 0) {
      int i = paramInt1 + paramInt2;
      if (i <= paramArrayOfchar.length && i >= 0) {
        if (paramInt2 == 0)
          return; 
        int j = this.count + paramInt2;
        int k = j;
        int m = paramInt1;
        i = paramInt2;
        if (j > this.buf.length) {
          i = paramInt1;
          m = paramInt2;
          if (this.writer == null) {
            expandCapacity(j);
            k = j;
            m = paramInt1;
            i = paramInt2;
          } else {
            while (true) {
              paramInt2 = this.buf.length - this.count;
              System.arraycopy(paramArrayOfchar, i, this.buf, this.count, paramInt2);
              this.count = this.buf.length;
              flush();
              paramInt1 = m - paramInt2;
              paramInt2 = i + paramInt2;
              i = paramInt2;
              m = paramInt1;
              if (paramInt1 <= this.buf.length) {
                k = paramInt1;
                i = paramInt1;
                m = paramInt2;
                break;
              } 
            } 
          } 
        } 
        System.arraycopy(paramArrayOfchar, m, this.buf, this.count, i);
        this.count = k;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException();
  }
  
  public void writeByteArray(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteClassName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   4: getfield mask : I
    //   7: invokevirtual isEnabled : (I)Z
    //   10: ifeq -> 19
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual writeHex : ([B)V
    //   18: return
    //   19: aload_1
    //   20: arraylength
    //   21: istore_2
    //   22: aload_0
    //   23: getfield useSingleQuotes : Z
    //   26: ifeq -> 35
    //   29: bipush #39
    //   31: istore_3
    //   32: goto -> 38
    //   35: bipush #34
    //   37: istore_3
    //   38: iload_2
    //   39: ifne -> 66
    //   42: aload_0
    //   43: getfield useSingleQuotes : Z
    //   46: ifeq -> 56
    //   49: ldc_w ''''
    //   52: astore_1
    //   53: goto -> 60
    //   56: ldc_w '""'
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual write : (Ljava/lang/String;)V
    //   65: return
    //   66: getstatic com/alibaba/fastjson/util/IOUtils.CA : [C
    //   69: astore #4
    //   71: iload_2
    //   72: iconst_3
    //   73: idiv
    //   74: iconst_3
    //   75: imul
    //   76: istore #5
    //   78: iload_2
    //   79: iconst_1
    //   80: isub
    //   81: istore #6
    //   83: iload #6
    //   85: iconst_3
    //   86: idiv
    //   87: istore #7
    //   89: aload_0
    //   90: getfield count : I
    //   93: istore #8
    //   95: aload_0
    //   96: getfield count : I
    //   99: iload #7
    //   101: iconst_1
    //   102: iadd
    //   103: iconst_2
    //   104: ishl
    //   105: iadd
    //   106: iconst_2
    //   107: iadd
    //   108: istore #9
    //   110: aload_0
    //   111: getfield buf : [C
    //   114: arraylength
    //   115: istore #7
    //   117: iconst_0
    //   118: istore #10
    //   120: iconst_0
    //   121: istore #11
    //   123: iload #9
    //   125: iload #7
    //   127: if_icmple -> 390
    //   130: aload_0
    //   131: getfield writer : Ljava/io/Writer;
    //   134: ifnull -> 384
    //   137: aload_0
    //   138: iload_3
    //   139: invokevirtual write : (I)V
    //   142: iconst_0
    //   143: istore #7
    //   145: iload #7
    //   147: iload #5
    //   149: if_icmpge -> 265
    //   152: iload #7
    //   154: iconst_1
    //   155: iadd
    //   156: istore #10
    //   158: aload_1
    //   159: iload #7
    //   161: baload
    //   162: istore #9
    //   164: iload #10
    //   166: iconst_1
    //   167: iadd
    //   168: istore #7
    //   170: iload #9
    //   172: sipush #255
    //   175: iand
    //   176: bipush #16
    //   178: ishl
    //   179: aload_1
    //   180: iload #10
    //   182: baload
    //   183: sipush #255
    //   186: iand
    //   187: bipush #8
    //   189: ishl
    //   190: ior
    //   191: aload_1
    //   192: iload #7
    //   194: baload
    //   195: sipush #255
    //   198: iand
    //   199: ior
    //   200: istore #10
    //   202: aload_0
    //   203: aload #4
    //   205: iload #10
    //   207: bipush #18
    //   209: iushr
    //   210: bipush #63
    //   212: iand
    //   213: caload
    //   214: invokevirtual write : (I)V
    //   217: aload_0
    //   218: aload #4
    //   220: iload #10
    //   222: bipush #12
    //   224: iushr
    //   225: bipush #63
    //   227: iand
    //   228: caload
    //   229: invokevirtual write : (I)V
    //   232: aload_0
    //   233: aload #4
    //   235: iload #10
    //   237: bipush #6
    //   239: iushr
    //   240: bipush #63
    //   242: iand
    //   243: caload
    //   244: invokevirtual write : (I)V
    //   247: aload_0
    //   248: aload #4
    //   250: iload #10
    //   252: bipush #63
    //   254: iand
    //   255: caload
    //   256: invokevirtual write : (I)V
    //   259: iinc #7, 1
    //   262: goto -> 145
    //   265: iload_2
    //   266: iload #5
    //   268: isub
    //   269: istore #10
    //   271: iload #10
    //   273: ifle -> 378
    //   276: aload_1
    //   277: iload #5
    //   279: baload
    //   280: istore_2
    //   281: iload #11
    //   283: istore #7
    //   285: iload #10
    //   287: iconst_2
    //   288: if_icmpne -> 303
    //   291: aload_1
    //   292: iload #6
    //   294: baload
    //   295: sipush #255
    //   298: iand
    //   299: iconst_2
    //   300: ishl
    //   301: istore #7
    //   303: iload_2
    //   304: sipush #255
    //   307: iand
    //   308: bipush #10
    //   310: ishl
    //   311: iload #7
    //   313: ior
    //   314: istore #7
    //   316: aload_0
    //   317: aload #4
    //   319: iload #7
    //   321: bipush #12
    //   323: ishr
    //   324: caload
    //   325: invokevirtual write : (I)V
    //   328: aload_0
    //   329: aload #4
    //   331: iload #7
    //   333: bipush #6
    //   335: iushr
    //   336: bipush #63
    //   338: iand
    //   339: caload
    //   340: invokevirtual write : (I)V
    //   343: iload #10
    //   345: iconst_2
    //   346: if_icmpne -> 362
    //   349: aload #4
    //   351: iload #7
    //   353: bipush #63
    //   355: iand
    //   356: caload
    //   357: istore #7
    //   359: goto -> 366
    //   362: bipush #61
    //   364: istore #7
    //   366: aload_0
    //   367: iload #7
    //   369: invokevirtual write : (I)V
    //   372: aload_0
    //   373: bipush #61
    //   375: invokevirtual write : (I)V
    //   378: aload_0
    //   379: iload_3
    //   380: invokevirtual write : (I)V
    //   383: return
    //   384: aload_0
    //   385: iload #9
    //   387: invokevirtual expandCapacity : (I)V
    //   390: aload_0
    //   391: iload #9
    //   393: putfield count : I
    //   396: aload_0
    //   397: getfield buf : [C
    //   400: astore #12
    //   402: iload #8
    //   404: iconst_1
    //   405: iadd
    //   406: istore #7
    //   408: aload #12
    //   410: iload #8
    //   412: iload_3
    //   413: i2c
    //   414: castore
    //   415: iconst_0
    //   416: istore #11
    //   418: iload #11
    //   420: iload #5
    //   422: if_icmpge -> 587
    //   425: iload #11
    //   427: iconst_1
    //   428: iadd
    //   429: istore #8
    //   431: aload_1
    //   432: iload #11
    //   434: baload
    //   435: istore #13
    //   437: iload #8
    //   439: iconst_1
    //   440: iadd
    //   441: istore #11
    //   443: iload #13
    //   445: sipush #255
    //   448: iand
    //   449: bipush #16
    //   451: ishl
    //   452: aload_1
    //   453: iload #8
    //   455: baload
    //   456: sipush #255
    //   459: iand
    //   460: bipush #8
    //   462: ishl
    //   463: ior
    //   464: aload_1
    //   465: iload #11
    //   467: baload
    //   468: sipush #255
    //   471: iand
    //   472: ior
    //   473: istore #8
    //   475: aload_0
    //   476: getfield buf : [C
    //   479: astore #12
    //   481: iload #7
    //   483: iconst_1
    //   484: iadd
    //   485: istore #13
    //   487: aload #12
    //   489: iload #7
    //   491: aload #4
    //   493: iload #8
    //   495: bipush #18
    //   497: iushr
    //   498: bipush #63
    //   500: iand
    //   501: caload
    //   502: i2c
    //   503: castore
    //   504: aload_0
    //   505: getfield buf : [C
    //   508: astore #12
    //   510: iload #13
    //   512: iconst_1
    //   513: iadd
    //   514: istore #14
    //   516: aload #12
    //   518: iload #13
    //   520: aload #4
    //   522: iload #8
    //   524: bipush #12
    //   526: iushr
    //   527: bipush #63
    //   529: iand
    //   530: caload
    //   531: i2c
    //   532: castore
    //   533: aload_0
    //   534: getfield buf : [C
    //   537: astore #12
    //   539: iload #14
    //   541: iconst_1
    //   542: iadd
    //   543: istore #7
    //   545: aload #12
    //   547: iload #14
    //   549: aload #4
    //   551: iload #8
    //   553: bipush #6
    //   555: iushr
    //   556: bipush #63
    //   558: iand
    //   559: caload
    //   560: i2c
    //   561: castore
    //   562: aload_0
    //   563: getfield buf : [C
    //   566: iload #7
    //   568: aload #4
    //   570: iload #8
    //   572: bipush #63
    //   574: iand
    //   575: caload
    //   576: i2c
    //   577: castore
    //   578: iinc #11, 1
    //   581: iinc #7, 1
    //   584: goto -> 418
    //   587: iload_2
    //   588: iload #5
    //   590: isub
    //   591: istore #11
    //   593: iload #11
    //   595: ifle -> 726
    //   598: aload_1
    //   599: iload #5
    //   601: baload
    //   602: istore_2
    //   603: iload #10
    //   605: istore #7
    //   607: iload #11
    //   609: iconst_2
    //   610: if_icmpne -> 625
    //   613: aload_1
    //   614: iload #6
    //   616: baload
    //   617: sipush #255
    //   620: iand
    //   621: iconst_2
    //   622: ishl
    //   623: istore #7
    //   625: iload_2
    //   626: sipush #255
    //   629: iand
    //   630: bipush #10
    //   632: ishl
    //   633: iload #7
    //   635: ior
    //   636: istore #7
    //   638: aload_0
    //   639: getfield buf : [C
    //   642: iload #9
    //   644: iconst_5
    //   645: isub
    //   646: aload #4
    //   648: iload #7
    //   650: bipush #12
    //   652: ishr
    //   653: caload
    //   654: i2c
    //   655: castore
    //   656: aload_0
    //   657: getfield buf : [C
    //   660: iload #9
    //   662: iconst_4
    //   663: isub
    //   664: aload #4
    //   666: iload #7
    //   668: bipush #6
    //   670: iushr
    //   671: bipush #63
    //   673: iand
    //   674: caload
    //   675: i2c
    //   676: castore
    //   677: aload_0
    //   678: getfield buf : [C
    //   681: astore_1
    //   682: iload #11
    //   684: iconst_2
    //   685: if_icmpne -> 701
    //   688: aload #4
    //   690: iload #7
    //   692: bipush #63
    //   694: iand
    //   695: caload
    //   696: istore #7
    //   698: goto -> 705
    //   701: bipush #61
    //   703: istore #7
    //   705: aload_1
    //   706: iload #9
    //   708: iconst_3
    //   709: isub
    //   710: iload #7
    //   712: i2c
    //   713: castore
    //   714: aload_0
    //   715: getfield buf : [C
    //   718: iload #9
    //   720: iconst_2
    //   721: isub
    //   722: bipush #61
    //   724: i2c
    //   725: castore
    //   726: aload_0
    //   727: getfield buf : [C
    //   730: iload #9
    //   732: iconst_1
    //   733: isub
    //   734: iload_3
    //   735: i2c
    //   736: castore
    //   737: return
  }
  
  public void writeDouble(double paramDouble, boolean paramBoolean) {
    if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble)) {
      writeNull();
      return;
    } 
    String str1 = Double.toString(paramDouble);
    String str2 = str1;
    if (isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
      str2 = str1;
      if (str1.endsWith(".0"))
        str2 = str1.substring(0, str1.length() - 2); 
    } 
    write(str2);
    if (paramBoolean && isEnabled(SerializerFeature.WriteClassName))
      write(68); 
  }
  
  public void writeEnum(Enum<?> paramEnum) {
    if (paramEnum == null) {
      writeNull();
      return;
    } 
    String str = null;
    if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
      str = paramEnum.name();
    } else if (this.writeEnumUsingToString) {
      str = paramEnum.toString();
    } 
    if (str != null) {
      byte b;
      if (isEnabled(SerializerFeature.UseSingleQuotes)) {
        b = 39;
      } else {
        b = 34;
      } 
      write(b);
      write(str);
      write(b);
    } else {
      writeInt(paramEnum.ordinal());
    } 
  }
  
  public void writeFieldName(String paramString) {
    writeFieldName(paramString, false);
  }
  
  public void writeFieldName(String paramString, boolean paramBoolean) {
    if (paramString == null) {
      write("null:");
      return;
    } 
    if (this.useSingleQuotes) {
      if (this.quoteFieldNames) {
        writeStringWithSingleQuote(paramString);
        write(58);
      } else {
        writeKeyWithSingleQuoteIfHasSpecial(paramString);
      } 
    } else if (this.quoteFieldNames) {
      writeStringWithDoubleQuote(paramString, ':');
    } else {
      boolean bool1;
      boolean bool2;
      if (paramString.length() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      byte b = 0;
      while (true) {
        bool2 = bool1;
        if (b < paramString.length()) {
          if (isSpecial(paramString.charAt(b), 0)) {
            bool2 = true;
            break;
          } 
          b++;
          continue;
        } 
        break;
      } 
      if (bool2) {
        writeStringWithDoubleQuote(paramString, ':');
      } else {
        write(paramString);
        write(58);
      } 
    } 
  }
  
  public void writeFieldNameDirect(String paramString) {
    int i = paramString.length();
    int j = this.count + i + 3;
    if (j > this.buf.length)
      expandCapacity(j); 
    int k = this.count;
    this.buf[this.count] = (char)'"';
    paramString.getChars(0, i, this.buf, k + 1);
    this.count = j;
    this.buf[this.count - 2] = (char)'"';
    this.buf[this.count - 1] = (char)':';
  }
  
  public void writeFieldValue(char paramChar1, String paramString, char paramChar2) {
    write(paramChar1);
    writeFieldName(paramString);
    if (paramChar2 == '\000') {
      writeString("\000");
    } else {
      writeString(Character.toString(paramChar2));
    } 
  }
  
  public void writeFieldValue(char paramChar, String paramString, double paramDouble) {
    write(paramChar);
    writeFieldName(paramString);
    writeDouble(paramDouble, false);
  }
  
  public void writeFieldValue(char paramChar, String paramString, float paramFloat) {
    write(paramChar);
    writeFieldName(paramString);
    writeFloat(paramFloat, false);
  }
  
  public void writeFieldValue(char paramChar, String paramString, int paramInt) {
    if (paramInt == Integer.MIN_VALUE || !this.quoteFieldNames) {
      write(paramChar);
      writeFieldName(paramString);
      writeInt(paramInt);
      return;
    } 
    if (paramInt < 0) {
      j = IOUtils.stringSize(-paramInt) + 1;
    } else {
      j = IOUtils.stringSize(paramInt);
    } 
    int k = paramString.length();
    int m = this.count + k + 4 + j;
    if (m > this.buf.length) {
      if (this.writer != null) {
        write(paramChar);
        writeFieldName(paramString);
        writeInt(paramInt);
        return;
      } 
      expandCapacity(m);
    } 
    int j = this.count;
    this.count = m;
    this.buf[j] = (char)paramChar;
    int i = j + k + 1;
    this.buf[j + 1] = (char)this.keySeperator;
    paramString.getChars(0, k, this.buf, j + 2);
    this.buf[i + 1] = (char)this.keySeperator;
    this.buf[i + 2] = (char)':';
    IOUtils.getChars(paramInt, this.count, this.buf);
  }
  
  public void writeFieldValue(char paramChar, String paramString, long paramLong) {
    if (paramLong == Long.MIN_VALUE || !this.quoteFieldNames) {
      write(paramChar);
      writeFieldName(paramString);
      writeLong(paramLong);
      return;
    } 
    if (paramLong < 0L) {
      j = IOUtils.stringSize(-paramLong) + 1;
    } else {
      j = IOUtils.stringSize(paramLong);
    } 
    int k = paramString.length();
    int m = this.count + k + 4 + j;
    if (m > this.buf.length) {
      if (this.writer != null) {
        write(paramChar);
        writeFieldName(paramString);
        writeLong(paramLong);
        return;
      } 
      expandCapacity(m);
    } 
    int j = this.count;
    this.count = m;
    this.buf[j] = (char)paramChar;
    int i = j + k + 1;
    this.buf[j + 1] = (char)this.keySeperator;
    paramString.getChars(0, k, this.buf, j + 2);
    this.buf[i + 1] = (char)this.keySeperator;
    this.buf[i + 2] = (char)':';
    IOUtils.getChars(paramLong, this.count, this.buf);
  }
  
  public void writeFieldValue(char paramChar, String paramString, Enum<?> paramEnum) {
    if (paramEnum == null) {
      write(paramChar);
      writeFieldName(paramString);
      writeNull();
      return;
    } 
    if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
      writeEnumFieldValue(paramChar, paramString, paramEnum.name());
    } else if (this.writeEnumUsingToString) {
      writeEnumFieldValue(paramChar, paramString, paramEnum.toString());
    } else {
      writeFieldValue(paramChar, paramString, paramEnum.ordinal());
    } 
  }
  
  public void writeFieldValue(char paramChar, String paramString1, String paramString2) {
    if (this.quoteFieldNames) {
      if (this.useSingleQuotes) {
        write(paramChar);
        writeFieldName(paramString1);
        if (paramString2 == null) {
          writeNull();
        } else {
          writeString(paramString2);
        } 
      } else if (isEnabled(SerializerFeature.BrowserSecure)) {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, false);
      } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, false);
      } else {
        writeFieldValueStringWithDoubleQuoteCheck(paramChar, paramString1, paramString2);
      } 
    } else {
      write(paramChar);
      writeFieldName(paramString1);
      if (paramString2 == null) {
        writeNull();
      } else {
        writeString(paramString2);
      } 
    } 
  }
  
  public void writeFieldValue(char paramChar, String paramString, BigDecimal paramBigDecimal) {
    write(paramChar);
    writeFieldName(paramString);
    if (paramBigDecimal == null) {
      writeNull();
    } else {
      write(paramBigDecimal.toString());
    } 
  }
  
  public void writeFieldValue(char paramChar, String paramString, boolean paramBoolean) {
    if (!this.quoteFieldNames) {
      write(paramChar);
      writeFieldName(paramString);
      write(paramBoolean);
      return;
    } 
    if (paramBoolean) {
      j = 4;
    } else {
      j = 5;
    } 
    int k = paramString.length();
    int m = this.count + k + 4 + j;
    if (m > this.buf.length) {
      if (this.writer != null) {
        write(paramChar);
        writeString(paramString);
        write(58);
        write(paramBoolean);
        return;
      } 
      expandCapacity(m);
    } 
    int j = this.count;
    this.count = m;
    this.buf[j] = (char)paramChar;
    int i = j + k + 1;
    this.buf[j + 1] = (char)this.keySeperator;
    paramString.getChars(0, k, this.buf, j + 2);
    this.buf[i + 1] = (char)this.keySeperator;
    if (paramBoolean) {
      System.arraycopy(":true".toCharArray(), 0, this.buf, i + 2, 5);
    } else {
      System.arraycopy(":false".toCharArray(), 0, this.buf, i + 2, 6);
    } 
  }
  
  public void writeFieldValueStringWithDoubleQuote(char paramChar, String paramString1, String paramString2) {
    int j = paramString1.length();
    int k = this.count;
    int m = paramString2.length();
    k += j + m + 6;
    if (k > this.buf.length) {
      if (this.writer != null) {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, false);
        return;
      } 
      expandCapacity(k);
    } 
    this.buf[this.count] = (char)paramChar;
    int i = this.count + 2;
    int n = i + j;
    this.buf[this.count + 1] = (char)'"';
    paramString1.getChars(0, j, this.buf, i);
    this.count = k;
    this.buf[n] = (char)'"';
    j = n + 1;
    char[] arrayOfChar = this.buf;
    i = j + 1;
    arrayOfChar[j] = (char)':';
    this.buf[i] = (char)'"';
    paramString2.getChars(0, m, this.buf, i + 1);
    this.buf[this.count - 1] = (char)'"';
  }
  
  public void writeFieldValueStringWithDoubleQuoteCheck(char paramChar, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual length : ()I
    //   4: istore #4
    //   6: aload_0
    //   7: getfield count : I
    //   10: istore #5
    //   12: aload_3
    //   13: ifnonnull -> 32
    //   16: iload #5
    //   18: iload #4
    //   20: bipush #8
    //   22: iadd
    //   23: iadd
    //   24: istore #5
    //   26: iconst_4
    //   27: istore #6
    //   29: goto -> 51
    //   32: aload_3
    //   33: invokevirtual length : ()I
    //   36: istore #6
    //   38: iload #5
    //   40: iload #4
    //   42: iload #6
    //   44: iadd
    //   45: bipush #6
    //   47: iadd
    //   48: iadd
    //   49: istore #5
    //   51: aload_0
    //   52: getfield buf : [C
    //   55: arraylength
    //   56: istore #7
    //   58: iconst_0
    //   59: istore #8
    //   61: iload #5
    //   63: iload #7
    //   65: if_icmple -> 100
    //   68: aload_0
    //   69: getfield writer : Ljava/io/Writer;
    //   72: ifnull -> 94
    //   75: aload_0
    //   76: iload_1
    //   77: invokevirtual write : (I)V
    //   80: aload_0
    //   81: aload_2
    //   82: bipush #58
    //   84: invokevirtual writeStringWithDoubleQuote : (Ljava/lang/String;C)V
    //   87: aload_0
    //   88: aload_3
    //   89: iconst_0
    //   90: invokevirtual writeStringWithDoubleQuote : (Ljava/lang/String;C)V
    //   93: return
    //   94: aload_0
    //   95: iload #5
    //   97: invokevirtual expandCapacity : (I)V
    //   100: aload_0
    //   101: getfield buf : [C
    //   104: aload_0
    //   105: getfield count : I
    //   108: iload_1
    //   109: i2c
    //   110: castore
    //   111: aload_0
    //   112: getfield count : I
    //   115: iconst_2
    //   116: iadd
    //   117: istore_1
    //   118: iload_1
    //   119: iload #4
    //   121: iadd
    //   122: istore #7
    //   124: aload_0
    //   125: getfield buf : [C
    //   128: aload_0
    //   129: getfield count : I
    //   132: iconst_1
    //   133: iadd
    //   134: bipush #34
    //   136: i2c
    //   137: castore
    //   138: aload_2
    //   139: iconst_0
    //   140: iload #4
    //   142: aload_0
    //   143: getfield buf : [C
    //   146: iload_1
    //   147: invokevirtual getChars : (II[CI)V
    //   150: aload_0
    //   151: iload #5
    //   153: putfield count : I
    //   156: aload_0
    //   157: getfield buf : [C
    //   160: iload #7
    //   162: bipush #34
    //   164: i2c
    //   165: castore
    //   166: iload #7
    //   168: iconst_1
    //   169: iadd
    //   170: istore #4
    //   172: aload_0
    //   173: getfield buf : [C
    //   176: astore_2
    //   177: iload #4
    //   179: iconst_1
    //   180: iadd
    //   181: istore_1
    //   182: aload_2
    //   183: iload #4
    //   185: bipush #58
    //   187: i2c
    //   188: castore
    //   189: aload_3
    //   190: ifnonnull -> 247
    //   193: aload_0
    //   194: getfield buf : [C
    //   197: astore_2
    //   198: iload_1
    //   199: iconst_1
    //   200: iadd
    //   201: istore #5
    //   203: aload_2
    //   204: iload_1
    //   205: bipush #110
    //   207: i2c
    //   208: castore
    //   209: aload_0
    //   210: getfield buf : [C
    //   213: astore_2
    //   214: iload #5
    //   216: iconst_1
    //   217: iadd
    //   218: istore_1
    //   219: aload_2
    //   220: iload #5
    //   222: bipush #117
    //   224: i2c
    //   225: castore
    //   226: aload_0
    //   227: getfield buf : [C
    //   230: iload_1
    //   231: bipush #108
    //   233: i2c
    //   234: castore
    //   235: aload_0
    //   236: getfield buf : [C
    //   239: iload_1
    //   240: iconst_1
    //   241: iadd
    //   242: bipush #108
    //   244: i2c
    //   245: castore
    //   246: return
    //   247: aload_0
    //   248: getfield buf : [C
    //   251: astore_2
    //   252: iload_1
    //   253: iconst_1
    //   254: iadd
    //   255: istore #9
    //   257: aload_2
    //   258: iload_1
    //   259: bipush #34
    //   261: i2c
    //   262: castore
    //   263: iload #9
    //   265: iload #6
    //   267: iadd
    //   268: istore #10
    //   270: aload_3
    //   271: iconst_0
    //   272: iload #6
    //   274: aload_0
    //   275: getfield buf : [C
    //   278: iload #9
    //   280: invokevirtual getChars : (II[CI)V
    //   283: iload #5
    //   285: istore #4
    //   287: iload #9
    //   289: istore_1
    //   290: iconst_0
    //   291: istore #11
    //   293: iconst_m1
    //   294: istore #5
    //   296: iconst_m1
    //   297: istore #12
    //   299: iload_1
    //   300: iload #10
    //   302: if_icmpge -> 571
    //   305: aload_0
    //   306: getfield buf : [C
    //   309: iload_1
    //   310: caload
    //   311: istore #13
    //   313: iload #13
    //   315: bipush #93
    //   317: if_icmplt -> 419
    //   320: iload #4
    //   322: istore #7
    //   324: iload #8
    //   326: istore #14
    //   328: iload #11
    //   330: istore #15
    //   332: iload #5
    //   334: istore #16
    //   336: iload #12
    //   338: istore #6
    //   340: iload #13
    //   342: bipush #127
    //   344: if_icmplt -> 545
    //   347: iload #13
    //   349: sipush #8232
    //   352: if_icmpeq -> 391
    //   355: iload #13
    //   357: sipush #8233
    //   360: if_icmpeq -> 391
    //   363: iload #4
    //   365: istore #7
    //   367: iload #8
    //   369: istore #14
    //   371: iload #11
    //   373: istore #15
    //   375: iload #5
    //   377: istore #16
    //   379: iload #12
    //   381: istore #6
    //   383: iload #13
    //   385: sipush #160
    //   388: if_icmpge -> 545
    //   391: iload #5
    //   393: istore #16
    //   395: iload #5
    //   397: iconst_m1
    //   398: if_icmpne -> 404
    //   401: iload_1
    //   402: istore #16
    //   404: iload #8
    //   406: iconst_1
    //   407: iadd
    //   408: istore #14
    //   410: iload #4
    //   412: iconst_4
    //   413: iadd
    //   414: istore #7
    //   416: goto -> 538
    //   419: iload #4
    //   421: istore #7
    //   423: iload #8
    //   425: istore #14
    //   427: iload #11
    //   429: istore #15
    //   431: iload #5
    //   433: istore #16
    //   435: iload #12
    //   437: istore #6
    //   439: iload #13
    //   441: aload_0
    //   442: getfield features : I
    //   445: invokestatic isSpecial : (CI)Z
    //   448: ifeq -> 545
    //   451: iload #8
    //   453: iconst_1
    //   454: iadd
    //   455: istore #15
    //   457: iload #4
    //   459: istore #6
    //   461: iload #13
    //   463: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   466: arraylength
    //   467: if_icmpge -> 490
    //   470: iload #4
    //   472: istore #6
    //   474: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   477: iload #13
    //   479: baload
    //   480: iconst_4
    //   481: if_icmpne -> 490
    //   484: iload #4
    //   486: iconst_4
    //   487: iadd
    //   488: istore #6
    //   490: iload #6
    //   492: istore #7
    //   494: iload #15
    //   496: istore #14
    //   498: iload #5
    //   500: istore #16
    //   502: iload #5
    //   504: iconst_m1
    //   505: if_icmpne -> 538
    //   508: iload #13
    //   510: istore #4
    //   512: iload_1
    //   513: istore #16
    //   515: iload #16
    //   517: istore #5
    //   519: iload #6
    //   521: istore #7
    //   523: iload #15
    //   525: istore #14
    //   527: iload #4
    //   529: istore #15
    //   531: iload #5
    //   533: istore #6
    //   535: goto -> 545
    //   538: iload #13
    //   540: istore #15
    //   542: iload_1
    //   543: istore #6
    //   545: iinc #1, 1
    //   548: iload #7
    //   550: istore #4
    //   552: iload #14
    //   554: istore #8
    //   556: iload #15
    //   558: istore #11
    //   560: iload #16
    //   562: istore #5
    //   564: iload #6
    //   566: istore #12
    //   568: goto -> 299
    //   571: iload #8
    //   573: ifle -> 1473
    //   576: iload #4
    //   578: iload #8
    //   580: iadd
    //   581: istore_1
    //   582: iload_1
    //   583: aload_0
    //   584: getfield buf : [C
    //   587: arraylength
    //   588: if_icmple -> 596
    //   591: aload_0
    //   592: iload_1
    //   593: invokevirtual expandCapacity : (I)V
    //   596: aload_0
    //   597: iload_1
    //   598: putfield count : I
    //   601: iload #8
    //   603: iconst_1
    //   604: if_icmpne -> 1053
    //   607: iload #11
    //   609: sipush #8232
    //   612: if_icmpne -> 719
    //   615: iload #12
    //   617: iconst_1
    //   618: iadd
    //   619: istore_1
    //   620: aload_0
    //   621: getfield buf : [C
    //   624: iload_1
    //   625: aload_0
    //   626: getfield buf : [C
    //   629: iload #12
    //   631: bipush #6
    //   633: iadd
    //   634: iload #10
    //   636: iload #12
    //   638: isub
    //   639: iconst_1
    //   640: isub
    //   641: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   644: aload_0
    //   645: getfield buf : [C
    //   648: iload #12
    //   650: bipush #92
    //   652: i2c
    //   653: castore
    //   654: aload_0
    //   655: getfield buf : [C
    //   658: iload_1
    //   659: bipush #117
    //   661: i2c
    //   662: castore
    //   663: aload_0
    //   664: getfield buf : [C
    //   667: astore_2
    //   668: iinc #1, 1
    //   671: aload_2
    //   672: iload_1
    //   673: bipush #50
    //   675: i2c
    //   676: castore
    //   677: aload_0
    //   678: getfield buf : [C
    //   681: astore_2
    //   682: iinc #1, 1
    //   685: aload_2
    //   686: iload_1
    //   687: bipush #48
    //   689: i2c
    //   690: castore
    //   691: aload_0
    //   692: getfield buf : [C
    //   695: astore_2
    //   696: iinc #1, 1
    //   699: aload_2
    //   700: iload_1
    //   701: bipush #50
    //   703: i2c
    //   704: castore
    //   705: aload_0
    //   706: getfield buf : [C
    //   709: iload_1
    //   710: iconst_1
    //   711: iadd
    //   712: bipush #56
    //   714: i2c
    //   715: castore
    //   716: goto -> 1473
    //   719: iload #11
    //   721: sipush #8233
    //   724: if_icmpne -> 831
    //   727: iload #12
    //   729: iconst_1
    //   730: iadd
    //   731: istore_1
    //   732: aload_0
    //   733: getfield buf : [C
    //   736: iload_1
    //   737: aload_0
    //   738: getfield buf : [C
    //   741: iload #12
    //   743: bipush #6
    //   745: iadd
    //   746: iload #10
    //   748: iload #12
    //   750: isub
    //   751: iconst_1
    //   752: isub
    //   753: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   756: aload_0
    //   757: getfield buf : [C
    //   760: iload #12
    //   762: bipush #92
    //   764: i2c
    //   765: castore
    //   766: aload_0
    //   767: getfield buf : [C
    //   770: iload_1
    //   771: bipush #117
    //   773: i2c
    //   774: castore
    //   775: aload_0
    //   776: getfield buf : [C
    //   779: astore_2
    //   780: iinc #1, 1
    //   783: aload_2
    //   784: iload_1
    //   785: bipush #50
    //   787: i2c
    //   788: castore
    //   789: aload_0
    //   790: getfield buf : [C
    //   793: astore_2
    //   794: iinc #1, 1
    //   797: aload_2
    //   798: iload_1
    //   799: bipush #48
    //   801: i2c
    //   802: castore
    //   803: aload_0
    //   804: getfield buf : [C
    //   807: astore_2
    //   808: iinc #1, 1
    //   811: aload_2
    //   812: iload_1
    //   813: bipush #50
    //   815: i2c
    //   816: castore
    //   817: aload_0
    //   818: getfield buf : [C
    //   821: iload_1
    //   822: iconst_1
    //   823: iadd
    //   824: bipush #57
    //   826: i2c
    //   827: castore
    //   828: goto -> 1473
    //   831: iload #11
    //   833: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   836: arraylength
    //   837: if_icmpge -> 999
    //   840: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   843: iload #11
    //   845: baload
    //   846: iconst_4
    //   847: if_icmpne -> 999
    //   850: iload #12
    //   852: iconst_1
    //   853: iadd
    //   854: istore_1
    //   855: aload_0
    //   856: getfield buf : [C
    //   859: iload_1
    //   860: aload_0
    //   861: getfield buf : [C
    //   864: iload #12
    //   866: bipush #6
    //   868: iadd
    //   869: iload #10
    //   871: iload #12
    //   873: isub
    //   874: iconst_1
    //   875: isub
    //   876: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   879: aload_0
    //   880: getfield buf : [C
    //   883: iload #12
    //   885: bipush #92
    //   887: i2c
    //   888: castore
    //   889: aload_0
    //   890: getfield buf : [C
    //   893: astore_2
    //   894: iload_1
    //   895: iconst_1
    //   896: iadd
    //   897: istore #5
    //   899: aload_2
    //   900: iload_1
    //   901: bipush #117
    //   903: i2c
    //   904: castore
    //   905: aload_0
    //   906: getfield buf : [C
    //   909: astore_2
    //   910: iload #5
    //   912: iconst_1
    //   913: iadd
    //   914: istore_1
    //   915: aload_2
    //   916: iload #5
    //   918: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   921: iload #11
    //   923: bipush #12
    //   925: iushr
    //   926: bipush #15
    //   928: iand
    //   929: caload
    //   930: i2c
    //   931: castore
    //   932: aload_0
    //   933: getfield buf : [C
    //   936: astore_2
    //   937: iload_1
    //   938: iconst_1
    //   939: iadd
    //   940: istore #5
    //   942: aload_2
    //   943: iload_1
    //   944: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   947: iload #11
    //   949: bipush #8
    //   951: iushr
    //   952: bipush #15
    //   954: iand
    //   955: caload
    //   956: i2c
    //   957: castore
    //   958: aload_0
    //   959: getfield buf : [C
    //   962: iload #5
    //   964: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   967: iload #11
    //   969: iconst_4
    //   970: iushr
    //   971: bipush #15
    //   973: iand
    //   974: caload
    //   975: i2c
    //   976: castore
    //   977: aload_0
    //   978: getfield buf : [C
    //   981: iload #5
    //   983: iconst_1
    //   984: iadd
    //   985: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   988: iload #11
    //   990: bipush #15
    //   992: iand
    //   993: caload
    //   994: i2c
    //   995: castore
    //   996: goto -> 1473
    //   999: iload #12
    //   1001: iconst_1
    //   1002: iadd
    //   1003: istore_1
    //   1004: aload_0
    //   1005: getfield buf : [C
    //   1008: iload_1
    //   1009: aload_0
    //   1010: getfield buf : [C
    //   1013: iload #12
    //   1015: iconst_2
    //   1016: iadd
    //   1017: iload #10
    //   1019: iload #12
    //   1021: isub
    //   1022: iconst_1
    //   1023: isub
    //   1024: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1027: aload_0
    //   1028: getfield buf : [C
    //   1031: iload #12
    //   1033: bipush #92
    //   1035: i2c
    //   1036: castore
    //   1037: aload_0
    //   1038: getfield buf : [C
    //   1041: iload_1
    //   1042: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   1045: iload #11
    //   1047: caload
    //   1048: i2c
    //   1049: castore
    //   1050: goto -> 1473
    //   1053: iload #8
    //   1055: iconst_1
    //   1056: if_icmple -> 1473
    //   1059: iload #5
    //   1061: iload #9
    //   1063: isub
    //   1064: istore #6
    //   1066: iload #5
    //   1068: istore_1
    //   1069: iload #6
    //   1071: istore #5
    //   1073: iload #5
    //   1075: aload_3
    //   1076: invokevirtual length : ()I
    //   1079: if_icmpge -> 1473
    //   1082: aload_3
    //   1083: iload #5
    //   1085: invokevirtual charAt : (I)C
    //   1088: istore #6
    //   1090: iload #6
    //   1092: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   1095: arraylength
    //   1096: if_icmpge -> 1108
    //   1099: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   1102: iload #6
    //   1104: baload
    //   1105: ifne -> 1125
    //   1108: iload #6
    //   1110: bipush #47
    //   1112: if_icmpne -> 1300
    //   1115: aload_0
    //   1116: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1119: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1122: ifeq -> 1300
    //   1125: aload_0
    //   1126: getfield buf : [C
    //   1129: astore_2
    //   1130: iload_1
    //   1131: iconst_1
    //   1132: iadd
    //   1133: istore #4
    //   1135: aload_2
    //   1136: iload_1
    //   1137: bipush #92
    //   1139: i2c
    //   1140: castore
    //   1141: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   1144: iload #6
    //   1146: baload
    //   1147: iconst_4
    //   1148: if_icmpne -> 1276
    //   1151: aload_0
    //   1152: getfield buf : [C
    //   1155: astore_2
    //   1156: iload #4
    //   1158: iconst_1
    //   1159: iadd
    //   1160: istore #7
    //   1162: aload_2
    //   1163: iload #4
    //   1165: bipush #117
    //   1167: i2c
    //   1168: castore
    //   1169: aload_0
    //   1170: getfield buf : [C
    //   1173: astore_2
    //   1174: iload #7
    //   1176: iconst_1
    //   1177: iadd
    //   1178: istore_1
    //   1179: aload_2
    //   1180: iload #7
    //   1182: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1185: iload #6
    //   1187: bipush #12
    //   1189: iushr
    //   1190: bipush #15
    //   1192: iand
    //   1193: caload
    //   1194: i2c
    //   1195: castore
    //   1196: aload_0
    //   1197: getfield buf : [C
    //   1200: astore_2
    //   1201: iload_1
    //   1202: iconst_1
    //   1203: iadd
    //   1204: istore #7
    //   1206: aload_2
    //   1207: iload_1
    //   1208: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1211: iload #6
    //   1213: bipush #8
    //   1215: iushr
    //   1216: bipush #15
    //   1218: iand
    //   1219: caload
    //   1220: i2c
    //   1221: castore
    //   1222: aload_0
    //   1223: getfield buf : [C
    //   1226: astore_2
    //   1227: iload #7
    //   1229: iconst_1
    //   1230: iadd
    //   1231: istore #4
    //   1233: aload_2
    //   1234: iload #7
    //   1236: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1239: iload #6
    //   1241: iconst_4
    //   1242: iushr
    //   1243: bipush #15
    //   1245: iand
    //   1246: caload
    //   1247: i2c
    //   1248: castore
    //   1249: aload_0
    //   1250: getfield buf : [C
    //   1253: astore_2
    //   1254: iload #4
    //   1256: iconst_1
    //   1257: iadd
    //   1258: istore_1
    //   1259: aload_2
    //   1260: iload #4
    //   1262: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1265: iload #6
    //   1267: bipush #15
    //   1269: iand
    //   1270: caload
    //   1271: i2c
    //   1272: castore
    //   1273: goto -> 1467
    //   1276: aload_0
    //   1277: getfield buf : [C
    //   1280: astore_2
    //   1281: iload #4
    //   1283: iconst_1
    //   1284: iadd
    //   1285: istore_1
    //   1286: aload_2
    //   1287: iload #4
    //   1289: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   1292: iload #6
    //   1294: caload
    //   1295: i2c
    //   1296: castore
    //   1297: goto -> 1273
    //   1300: iload #6
    //   1302: sipush #8232
    //   1305: if_icmpeq -> 1334
    //   1308: iload #6
    //   1310: sipush #8233
    //   1313: if_icmpne -> 1319
    //   1316: goto -> 1334
    //   1319: aload_0
    //   1320: getfield buf : [C
    //   1323: iload_1
    //   1324: iload #6
    //   1326: i2c
    //   1327: castore
    //   1328: iinc #1, 1
    //   1331: goto -> 1273
    //   1334: aload_0
    //   1335: getfield buf : [C
    //   1338: astore_2
    //   1339: iload_1
    //   1340: iconst_1
    //   1341: iadd
    //   1342: istore #4
    //   1344: aload_2
    //   1345: iload_1
    //   1346: bipush #92
    //   1348: i2c
    //   1349: castore
    //   1350: aload_0
    //   1351: getfield buf : [C
    //   1354: astore_2
    //   1355: iload #4
    //   1357: iconst_1
    //   1358: iadd
    //   1359: istore_1
    //   1360: aload_2
    //   1361: iload #4
    //   1363: bipush #117
    //   1365: i2c
    //   1366: castore
    //   1367: aload_0
    //   1368: getfield buf : [C
    //   1371: astore_2
    //   1372: iload_1
    //   1373: iconst_1
    //   1374: iadd
    //   1375: istore #4
    //   1377: aload_2
    //   1378: iload_1
    //   1379: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1382: iload #6
    //   1384: bipush #12
    //   1386: iushr
    //   1387: bipush #15
    //   1389: iand
    //   1390: caload
    //   1391: i2c
    //   1392: castore
    //   1393: aload_0
    //   1394: getfield buf : [C
    //   1397: astore_2
    //   1398: iload #4
    //   1400: iconst_1
    //   1401: iadd
    //   1402: istore_1
    //   1403: aload_2
    //   1404: iload #4
    //   1406: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1409: iload #6
    //   1411: bipush #8
    //   1413: iushr
    //   1414: bipush #15
    //   1416: iand
    //   1417: caload
    //   1418: i2c
    //   1419: castore
    //   1420: aload_0
    //   1421: getfield buf : [C
    //   1424: astore_2
    //   1425: iload_1
    //   1426: iconst_1
    //   1427: iadd
    //   1428: istore #4
    //   1430: aload_2
    //   1431: iload_1
    //   1432: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1435: iload #6
    //   1437: iconst_4
    //   1438: iushr
    //   1439: bipush #15
    //   1441: iand
    //   1442: caload
    //   1443: i2c
    //   1444: castore
    //   1445: aload_0
    //   1446: getfield buf : [C
    //   1449: iload #4
    //   1451: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1454: iload #6
    //   1456: bipush #15
    //   1458: iand
    //   1459: caload
    //   1460: i2c
    //   1461: castore
    //   1462: iload #4
    //   1464: iconst_1
    //   1465: iadd
    //   1466: istore_1
    //   1467: iinc #5, 1
    //   1470: goto -> 1073
    //   1473: aload_0
    //   1474: getfield buf : [C
    //   1477: aload_0
    //   1478: getfield count : I
    //   1481: iconst_1
    //   1482: isub
    //   1483: bipush #34
    //   1485: i2c
    //   1486: castore
    //   1487: return
  }
  
  public void writeFloat(float paramFloat, boolean paramBoolean) {
    if (Float.isNaN(paramFloat) || Float.isInfinite(paramFloat)) {
      writeNull();
      return;
    } 
    String str1 = Float.toString(paramFloat);
    String str2 = str1;
    if (isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
      str2 = str1;
      if (str1.endsWith(".0"))
        str2 = str1.substring(0, str1.length() - 2); 
    } 
    write(str2);
    if (paramBoolean && isEnabled(SerializerFeature.WriteClassName))
      write(70); 
  }
  
  public void writeHex(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: getfield count : I
    //   4: istore_2
    //   5: aload_1
    //   6: arraylength
    //   7: istore_3
    //   8: iconst_2
    //   9: istore #4
    //   11: iload_2
    //   12: iload_3
    //   13: iconst_2
    //   14: imul
    //   15: iadd
    //   16: iconst_3
    //   17: iadd
    //   18: istore #5
    //   20: aload_0
    //   21: getfield buf : [C
    //   24: arraylength
    //   25: istore #6
    //   27: iconst_0
    //   28: istore_2
    //   29: iconst_0
    //   30: istore_3
    //   31: iload #5
    //   33: iload #6
    //   35: if_icmple -> 208
    //   38: aload_0
    //   39: getfield writer : Ljava/io/Writer;
    //   42: ifnull -> 202
    //   45: aload_1
    //   46: arraylength
    //   47: iconst_3
    //   48: iadd
    //   49: newarray char
    //   51: astore #7
    //   53: aload #7
    //   55: iconst_0
    //   56: bipush #120
    //   58: i2c
    //   59: castore
    //   60: aload #7
    //   62: iconst_1
    //   63: bipush #39
    //   65: i2c
    //   66: castore
    //   67: iload_3
    //   68: istore_2
    //   69: iload_2
    //   70: aload_1
    //   71: arraylength
    //   72: if_icmpge -> 171
    //   75: aload_1
    //   76: iload_2
    //   77: baload
    //   78: sipush #255
    //   81: iand
    //   82: istore_3
    //   83: iload_3
    //   84: iconst_4
    //   85: ishr
    //   86: istore #8
    //   88: iload_3
    //   89: bipush #15
    //   91: iand
    //   92: istore #6
    //   94: iload #4
    //   96: iconst_1
    //   97: iadd
    //   98: istore #5
    //   100: iload #8
    //   102: bipush #10
    //   104: if_icmpge -> 113
    //   107: bipush #48
    //   109: istore_3
    //   110: goto -> 116
    //   113: bipush #55
    //   115: istore_3
    //   116: aload #7
    //   118: iload #4
    //   120: iload #8
    //   122: iload_3
    //   123: iadd
    //   124: i2c
    //   125: i2c
    //   126: castore
    //   127: iload #5
    //   129: iconst_1
    //   130: iadd
    //   131: istore_3
    //   132: iload #6
    //   134: bipush #10
    //   136: if_icmpge -> 146
    //   139: bipush #48
    //   141: istore #4
    //   143: goto -> 150
    //   146: bipush #55
    //   148: istore #4
    //   150: aload #7
    //   152: iload #5
    //   154: iload #6
    //   156: iload #4
    //   158: iadd
    //   159: i2c
    //   160: i2c
    //   161: castore
    //   162: iinc #2, 1
    //   165: iload_3
    //   166: istore #4
    //   168: goto -> 69
    //   171: aload #7
    //   173: iload #4
    //   175: bipush #39
    //   177: i2c
    //   178: castore
    //   179: aload_0
    //   180: getfield writer : Ljava/io/Writer;
    //   183: aload #7
    //   185: invokevirtual write : ([C)V
    //   188: return
    //   189: astore_1
    //   190: new com/alibaba/fastjson/JSONException
    //   193: dup
    //   194: ldc_w 'writeBytes error.'
    //   197: aload_1
    //   198: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: athrow
    //   202: aload_0
    //   203: iload #5
    //   205: invokevirtual expandCapacity : (I)V
    //   208: aload_0
    //   209: getfield buf : [C
    //   212: astore #7
    //   214: aload_0
    //   215: getfield count : I
    //   218: istore #4
    //   220: aload_0
    //   221: iload #4
    //   223: iconst_1
    //   224: iadd
    //   225: putfield count : I
    //   228: aload #7
    //   230: iload #4
    //   232: bipush #120
    //   234: i2c
    //   235: castore
    //   236: aload_0
    //   237: getfield buf : [C
    //   240: astore #7
    //   242: aload_0
    //   243: getfield count : I
    //   246: istore #4
    //   248: aload_0
    //   249: iload #4
    //   251: iconst_1
    //   252: iadd
    //   253: putfield count : I
    //   256: aload #7
    //   258: iload #4
    //   260: bipush #39
    //   262: i2c
    //   263: castore
    //   264: iload_2
    //   265: aload_1
    //   266: arraylength
    //   267: if_icmpge -> 395
    //   270: aload_1
    //   271: iload_2
    //   272: baload
    //   273: sipush #255
    //   276: iand
    //   277: istore #4
    //   279: iload #4
    //   281: iconst_4
    //   282: ishr
    //   283: istore #6
    //   285: iload #4
    //   287: bipush #15
    //   289: iand
    //   290: istore_3
    //   291: aload_0
    //   292: getfield buf : [C
    //   295: astore #7
    //   297: aload_0
    //   298: getfield count : I
    //   301: istore #5
    //   303: aload_0
    //   304: iload #5
    //   306: iconst_1
    //   307: iadd
    //   308: putfield count : I
    //   311: iload #6
    //   313: bipush #10
    //   315: if_icmpge -> 325
    //   318: bipush #48
    //   320: istore #4
    //   322: goto -> 329
    //   325: bipush #55
    //   327: istore #4
    //   329: aload #7
    //   331: iload #5
    //   333: iload #6
    //   335: iload #4
    //   337: iadd
    //   338: i2c
    //   339: i2c
    //   340: castore
    //   341: aload_0
    //   342: getfield buf : [C
    //   345: astore #7
    //   347: aload_0
    //   348: getfield count : I
    //   351: istore #6
    //   353: aload_0
    //   354: iload #6
    //   356: iconst_1
    //   357: iadd
    //   358: putfield count : I
    //   361: iload_3
    //   362: bipush #10
    //   364: if_icmpge -> 374
    //   367: bipush #48
    //   369: istore #4
    //   371: goto -> 378
    //   374: bipush #55
    //   376: istore #4
    //   378: aload #7
    //   380: iload #6
    //   382: iload_3
    //   383: iload #4
    //   385: iadd
    //   386: i2c
    //   387: i2c
    //   388: castore
    //   389: iinc #2, 1
    //   392: goto -> 264
    //   395: aload_0
    //   396: getfield buf : [C
    //   399: astore_1
    //   400: aload_0
    //   401: getfield count : I
    //   404: istore_2
    //   405: aload_0
    //   406: iload_2
    //   407: iconst_1
    //   408: iadd
    //   409: putfield count : I
    //   412: aload_1
    //   413: iload_2
    //   414: bipush #39
    //   416: i2c
    //   417: castore
    //   418: return
    // Exception table:
    //   from	to	target	type
    //   179	188	189	java/io/IOException
  }
  
  public void writeInt(int paramInt) {
    int i;
    if (paramInt == Integer.MIN_VALUE) {
      write("-2147483648");
      return;
    } 
    if (paramInt < 0) {
      i = IOUtils.stringSize(-paramInt) + 1;
    } else {
      i = IOUtils.stringSize(paramInt);
    } 
    int j = this.count + i;
    if (j > this.buf.length)
      if (this.writer == null) {
        expandCapacity(j);
      } else {
        char[] arrayOfChar = new char[i];
        IOUtils.getChars(paramInt, i, arrayOfChar);
        write(arrayOfChar, 0, arrayOfChar.length);
        return;
      }  
    IOUtils.getChars(paramInt, j, this.buf);
    this.count = j;
  }
  
  public void writeLong(long paramLong) {
    int i;
    int j;
    if (isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (paramLong > 9007199254740991L || paramLong < -9007199254740991L)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramLong == Long.MIN_VALUE) {
      if (i) {
        write("\"-9223372036854775808\"");
      } else {
        write("-9223372036854775808");
      } 
      return;
    } 
    if (paramLong < 0L) {
      j = IOUtils.stringSize(-paramLong) + 1;
    } else {
      j = IOUtils.stringSize(paramLong);
    } 
    int k = this.count + j;
    int m = k;
    if (i)
      m = k + 2; 
    if (m > this.buf.length)
      if (this.writer == null) {
        expandCapacity(m);
      } else {
        char[] arrayOfChar = new char[j];
        IOUtils.getChars(paramLong, j, arrayOfChar);
        if (i) {
          write(34);
          write(arrayOfChar, 0, arrayOfChar.length);
          write(34);
        } else {
          write(arrayOfChar, 0, arrayOfChar.length);
        } 
        return;
      }  
    if (i) {
      this.buf[this.count] = (char)'"';
      i = m - 1;
      IOUtils.getChars(paramLong, i, this.buf);
      this.buf[i] = (char)'"';
    } else {
      IOUtils.getChars(paramLong, m, this.buf);
    } 
    this.count = m;
  }
  
  public void writeNull() {
    write("null");
  }
  
  public void writeNull(int paramInt1, int paramInt2) {
    if ((paramInt1 & paramInt2) == 0 && (this.features & paramInt2) == 0) {
      writeNull();
      return;
    } 
    if (paramInt2 == SerializerFeature.WriteNullListAsEmpty.mask) {
      write("[]");
    } else if (paramInt2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
      writeString("");
    } else if (paramInt2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
      write("false");
    } else if (paramInt2 == SerializerFeature.WriteNullNumberAsZero.mask) {
      write(48);
    } else {
      writeNull();
    } 
  }
  
  public void writeNull(SerializerFeature paramSerializerFeature) {
    writeNull(0, paramSerializerFeature.mask);
  }
  
  public void writeString(String paramString) {
    if (this.useSingleQuotes) {
      writeStringWithSingleQuote(paramString);
    } else {
      writeStringWithDoubleQuote(paramString, false);
    } 
  }
  
  public void writeString(String paramString, char paramChar) {
    if (this.useSingleQuotes) {
      writeStringWithSingleQuote(paramString);
      write(paramChar);
    } else {
      writeStringWithDoubleQuote(paramString, paramChar);
    } 
  }
  
  public void writeStringWithDoubleQuote(String paramString, char paramChar) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 18
    //   4: aload_0
    //   5: invokevirtual writeNull : ()V
    //   8: iload_2
    //   9: ifeq -> 17
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual write : (I)V
    //   17: return
    //   18: aload_1
    //   19: invokevirtual length : ()I
    //   22: istore_3
    //   23: aload_0
    //   24: getfield count : I
    //   27: iload_3
    //   28: iadd
    //   29: iconst_2
    //   30: iadd
    //   31: istore #4
    //   33: iload #4
    //   35: istore #5
    //   37: iload_2
    //   38: ifeq -> 47
    //   41: iload #4
    //   43: iconst_1
    //   44: iadd
    //   45: istore #5
    //   47: iload #5
    //   49: aload_0
    //   50: getfield buf : [C
    //   53: arraylength
    //   54: if_icmple -> 675
    //   57: aload_0
    //   58: getfield writer : Ljava/io/Writer;
    //   61: ifnull -> 669
    //   64: aload_0
    //   65: bipush #34
    //   67: invokevirtual write : (I)V
    //   70: iconst_0
    //   71: istore #5
    //   73: iload #5
    //   75: aload_1
    //   76: invokevirtual length : ()I
    //   79: if_icmpge -> 653
    //   82: aload_1
    //   83: iload #5
    //   85: invokevirtual charAt : (I)C
    //   88: istore #4
    //   90: aload_0
    //   91: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserSecure : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   94: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   97: ifeq -> 272
    //   100: iload #4
    //   102: bipush #60
    //   104: if_icmpne -> 117
    //   107: aload_0
    //   108: ldc_w '&lt;'
    //   111: invokevirtual write : (Ljava/lang/String;)V
    //   114: goto -> 647
    //   117: iload #4
    //   119: bipush #62
    //   121: if_icmpne -> 134
    //   124: aload_0
    //   125: ldc_w '&gt;'
    //   128: invokevirtual write : (Ljava/lang/String;)V
    //   131: goto -> 647
    //   134: iload #4
    //   136: bipush #48
    //   138: if_icmplt -> 148
    //   141: iload #4
    //   143: bipush #57
    //   145: if_icmple -> 641
    //   148: iload #4
    //   150: bipush #97
    //   152: if_icmplt -> 162
    //   155: iload #4
    //   157: bipush #122
    //   159: if_icmple -> 641
    //   162: iload #4
    //   164: bipush #65
    //   166: if_icmplt -> 176
    //   169: iload #4
    //   171: bipush #90
    //   173: if_icmple -> 641
    //   176: iload #4
    //   178: bipush #44
    //   180: if_icmpeq -> 641
    //   183: iload #4
    //   185: bipush #46
    //   187: if_icmpeq -> 641
    //   190: iload #4
    //   192: bipush #95
    //   194: if_icmpeq -> 641
    //   197: aload_0
    //   198: bipush #92
    //   200: invokevirtual write : (I)V
    //   203: aload_0
    //   204: bipush #117
    //   206: invokevirtual write : (I)V
    //   209: aload_0
    //   210: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   213: iload #4
    //   215: bipush #12
    //   217: iushr
    //   218: bipush #15
    //   220: iand
    //   221: caload
    //   222: invokevirtual write : (I)V
    //   225: aload_0
    //   226: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   229: iload #4
    //   231: bipush #8
    //   233: iushr
    //   234: bipush #15
    //   236: iand
    //   237: caload
    //   238: invokevirtual write : (I)V
    //   241: aload_0
    //   242: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   245: iload #4
    //   247: iconst_4
    //   248: iushr
    //   249: bipush #15
    //   251: iand
    //   252: caload
    //   253: invokevirtual write : (I)V
    //   256: aload_0
    //   257: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   260: iload #4
    //   262: bipush #15
    //   264: iand
    //   265: caload
    //   266: invokevirtual write : (I)V
    //   269: goto -> 647
    //   272: aload_0
    //   273: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserCompatible : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   276: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   279: ifeq -> 508
    //   282: iload #4
    //   284: bipush #8
    //   286: if_icmpeq -> 489
    //   289: iload #4
    //   291: bipush #12
    //   293: if_icmpeq -> 489
    //   296: iload #4
    //   298: bipush #10
    //   300: if_icmpeq -> 489
    //   303: iload #4
    //   305: bipush #13
    //   307: if_icmpeq -> 489
    //   310: iload #4
    //   312: bipush #9
    //   314: if_icmpeq -> 489
    //   317: iload #4
    //   319: bipush #34
    //   321: if_icmpeq -> 489
    //   324: iload #4
    //   326: bipush #47
    //   328: if_icmpeq -> 489
    //   331: iload #4
    //   333: bipush #92
    //   335: if_icmpne -> 341
    //   338: goto -> 489
    //   341: iload #4
    //   343: bipush #32
    //   345: if_icmpge -> 407
    //   348: aload_0
    //   349: bipush #92
    //   351: invokevirtual write : (I)V
    //   354: aload_0
    //   355: bipush #117
    //   357: invokevirtual write : (I)V
    //   360: aload_0
    //   361: bipush #48
    //   363: invokevirtual write : (I)V
    //   366: aload_0
    //   367: bipush #48
    //   369: invokevirtual write : (I)V
    //   372: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   375: astore #6
    //   377: iload #4
    //   379: iconst_2
    //   380: imul
    //   381: istore #4
    //   383: aload_0
    //   384: aload #6
    //   386: iload #4
    //   388: caload
    //   389: invokevirtual write : (I)V
    //   392: aload_0
    //   393: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   396: iload #4
    //   398: iconst_1
    //   399: iadd
    //   400: caload
    //   401: invokevirtual write : (I)V
    //   404: goto -> 647
    //   407: iload #4
    //   409: bipush #127
    //   411: if_icmplt -> 641
    //   414: aload_0
    //   415: bipush #92
    //   417: invokevirtual write : (I)V
    //   420: aload_0
    //   421: bipush #117
    //   423: invokevirtual write : (I)V
    //   426: aload_0
    //   427: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   430: iload #4
    //   432: bipush #12
    //   434: iushr
    //   435: bipush #15
    //   437: iand
    //   438: caload
    //   439: invokevirtual write : (I)V
    //   442: aload_0
    //   443: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   446: iload #4
    //   448: bipush #8
    //   450: iushr
    //   451: bipush #15
    //   453: iand
    //   454: caload
    //   455: invokevirtual write : (I)V
    //   458: aload_0
    //   459: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   462: iload #4
    //   464: iconst_4
    //   465: iushr
    //   466: bipush #15
    //   468: iand
    //   469: caload
    //   470: invokevirtual write : (I)V
    //   473: aload_0
    //   474: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   477: iload #4
    //   479: bipush #15
    //   481: iand
    //   482: caload
    //   483: invokevirtual write : (I)V
    //   486: goto -> 647
    //   489: aload_0
    //   490: bipush #92
    //   492: invokevirtual write : (I)V
    //   495: aload_0
    //   496: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   499: iload #4
    //   501: caload
    //   502: invokevirtual write : (I)V
    //   505: goto -> 647
    //   508: iload #4
    //   510: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   513: arraylength
    //   514: if_icmpge -> 526
    //   517: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   520: iload #4
    //   522: baload
    //   523: ifne -> 543
    //   526: iload #4
    //   528: bipush #47
    //   530: if_icmpne -> 641
    //   533: aload_0
    //   534: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   537: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   540: ifeq -> 641
    //   543: aload_0
    //   544: bipush #92
    //   546: invokevirtual write : (I)V
    //   549: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   552: iload #4
    //   554: baload
    //   555: iconst_4
    //   556: if_icmpne -> 628
    //   559: aload_0
    //   560: bipush #117
    //   562: invokevirtual write : (I)V
    //   565: aload_0
    //   566: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   569: iload #4
    //   571: bipush #12
    //   573: iushr
    //   574: bipush #15
    //   576: iand
    //   577: caload
    //   578: invokevirtual write : (I)V
    //   581: aload_0
    //   582: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   585: iload #4
    //   587: bipush #8
    //   589: iushr
    //   590: bipush #15
    //   592: iand
    //   593: caload
    //   594: invokevirtual write : (I)V
    //   597: aload_0
    //   598: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   601: iload #4
    //   603: iconst_4
    //   604: iushr
    //   605: bipush #15
    //   607: iand
    //   608: caload
    //   609: invokevirtual write : (I)V
    //   612: aload_0
    //   613: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   616: iload #4
    //   618: bipush #15
    //   620: iand
    //   621: caload
    //   622: invokevirtual write : (I)V
    //   625: goto -> 647
    //   628: aload_0
    //   629: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   632: iload #4
    //   634: caload
    //   635: invokevirtual write : (I)V
    //   638: goto -> 647
    //   641: aload_0
    //   642: iload #4
    //   644: invokevirtual write : (I)V
    //   647: iinc #5, 1
    //   650: goto -> 73
    //   653: aload_0
    //   654: bipush #34
    //   656: invokevirtual write : (I)V
    //   659: iload_2
    //   660: ifeq -> 668
    //   663: aload_0
    //   664: iload_2
    //   665: invokevirtual write : (I)V
    //   668: return
    //   669: aload_0
    //   670: iload #5
    //   672: invokevirtual expandCapacity : (I)V
    //   675: aload_0
    //   676: getfield count : I
    //   679: iconst_1
    //   680: iadd
    //   681: istore #7
    //   683: iload #7
    //   685: iload_3
    //   686: iadd
    //   687: istore #8
    //   689: aload_0
    //   690: getfield buf : [C
    //   693: aload_0
    //   694: getfield count : I
    //   697: bipush #34
    //   699: i2c
    //   700: castore
    //   701: aload_1
    //   702: iconst_0
    //   703: iload_3
    //   704: aload_0
    //   705: getfield buf : [C
    //   708: iload #7
    //   710: invokevirtual getChars : (II[CI)V
    //   713: aload_0
    //   714: iload #5
    //   716: putfield count : I
    //   719: aload_0
    //   720: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserSecure : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   723: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   726: istore #9
    //   728: iconst_m1
    //   729: istore #10
    //   731: iload #9
    //   733: ifeq -> 1418
    //   736: iload #7
    //   738: istore_3
    //   739: iload #10
    //   741: istore #4
    //   743: iload #5
    //   745: istore #10
    //   747: iload_3
    //   748: istore #5
    //   750: iload #5
    //   752: iload #8
    //   754: if_icmpge -> 923
    //   757: aload_0
    //   758: getfield buf : [C
    //   761: iload #5
    //   763: caload
    //   764: istore #11
    //   766: iload #11
    //   768: bipush #48
    //   770: if_icmplt -> 787
    //   773: iload #10
    //   775: istore #12
    //   777: iload #4
    //   779: istore_3
    //   780: iload #11
    //   782: bipush #57
    //   784: if_icmple -> 910
    //   787: iload #11
    //   789: bipush #97
    //   791: if_icmplt -> 808
    //   794: iload #10
    //   796: istore #12
    //   798: iload #4
    //   800: istore_3
    //   801: iload #11
    //   803: bipush #122
    //   805: if_icmple -> 910
    //   808: iload #11
    //   810: bipush #65
    //   812: if_icmplt -> 829
    //   815: iload #10
    //   817: istore #12
    //   819: iload #4
    //   821: istore_3
    //   822: iload #11
    //   824: bipush #90
    //   826: if_icmple -> 910
    //   829: iload #10
    //   831: istore #12
    //   833: iload #4
    //   835: istore_3
    //   836: iload #11
    //   838: bipush #44
    //   840: if_icmpeq -> 910
    //   843: iload #10
    //   845: istore #12
    //   847: iload #4
    //   849: istore_3
    //   850: iload #11
    //   852: bipush #46
    //   854: if_icmpeq -> 910
    //   857: iload #10
    //   859: istore #12
    //   861: iload #4
    //   863: istore_3
    //   864: iload #11
    //   866: bipush #95
    //   868: if_icmpeq -> 910
    //   871: iload #11
    //   873: bipush #60
    //   875: if_icmpeq -> 897
    //   878: iload #11
    //   880: bipush #62
    //   882: if_icmpne -> 888
    //   885: goto -> 897
    //   888: iload #10
    //   890: iconst_5
    //   891: iadd
    //   892: istore #4
    //   894: goto -> 903
    //   897: iload #10
    //   899: iconst_3
    //   900: iadd
    //   901: istore #4
    //   903: iload #5
    //   905: istore_3
    //   906: iload #4
    //   908: istore #12
    //   910: iinc #5, 1
    //   913: iload #12
    //   915: istore #10
    //   917: iload_3
    //   918: istore #4
    //   920: goto -> 750
    //   923: iload #10
    //   925: aload_0
    //   926: getfield buf : [C
    //   929: arraylength
    //   930: if_icmple -> 939
    //   933: aload_0
    //   934: iload #10
    //   936: invokevirtual expandCapacity : (I)V
    //   939: aload_0
    //   940: iload #10
    //   942: putfield count : I
    //   945: iload #4
    //   947: iload #7
    //   949: if_icmplt -> 1369
    //   952: aload_0
    //   953: getfield buf : [C
    //   956: iload #4
    //   958: caload
    //   959: istore_3
    //   960: iload_3
    //   961: bipush #48
    //   963: if_icmplt -> 976
    //   966: iload #8
    //   968: istore #5
    //   970: iload_3
    //   971: bipush #57
    //   973: if_icmple -> 1359
    //   976: iload_3
    //   977: bipush #97
    //   979: if_icmplt -> 992
    //   982: iload #8
    //   984: istore #5
    //   986: iload_3
    //   987: bipush #122
    //   989: if_icmple -> 1359
    //   992: iload_3
    //   993: bipush #65
    //   995: if_icmplt -> 1008
    //   998: iload #8
    //   1000: istore #5
    //   1002: iload_3
    //   1003: bipush #90
    //   1005: if_icmple -> 1359
    //   1008: iload #8
    //   1010: istore #5
    //   1012: iload_3
    //   1013: bipush #44
    //   1015: if_icmpeq -> 1359
    //   1018: iload #8
    //   1020: istore #5
    //   1022: iload_3
    //   1023: bipush #46
    //   1025: if_icmpeq -> 1359
    //   1028: iload #8
    //   1030: istore #5
    //   1032: iload_3
    //   1033: bipush #95
    //   1035: if_icmpeq -> 1359
    //   1038: iload_3
    //   1039: bipush #60
    //   1041: if_icmpne -> 1129
    //   1044: aload_0
    //   1045: getfield buf : [C
    //   1048: astore_1
    //   1049: iload #4
    //   1051: iconst_1
    //   1052: iadd
    //   1053: istore #5
    //   1055: aload_1
    //   1056: iload #5
    //   1058: aload_0
    //   1059: getfield buf : [C
    //   1062: iload #4
    //   1064: iconst_4
    //   1065: iadd
    //   1066: iload #8
    //   1068: iload #4
    //   1070: isub
    //   1071: iconst_1
    //   1072: isub
    //   1073: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1076: aload_0
    //   1077: getfield buf : [C
    //   1080: iload #4
    //   1082: bipush #38
    //   1084: i2c
    //   1085: castore
    //   1086: aload_0
    //   1087: getfield buf : [C
    //   1090: iload #5
    //   1092: bipush #108
    //   1094: i2c
    //   1095: castore
    //   1096: aload_0
    //   1097: getfield buf : [C
    //   1100: iload #4
    //   1102: iconst_2
    //   1103: iadd
    //   1104: bipush #116
    //   1106: i2c
    //   1107: castore
    //   1108: aload_0
    //   1109: getfield buf : [C
    //   1112: iload #4
    //   1114: iconst_3
    //   1115: iadd
    //   1116: bipush #59
    //   1118: i2c
    //   1119: castore
    //   1120: iload #8
    //   1122: iconst_3
    //   1123: iadd
    //   1124: istore #5
    //   1126: goto -> 1359
    //   1129: iload_3
    //   1130: bipush #62
    //   1132: if_icmpne -> 1220
    //   1135: aload_0
    //   1136: getfield buf : [C
    //   1139: astore_1
    //   1140: iload #4
    //   1142: iconst_1
    //   1143: iadd
    //   1144: istore #5
    //   1146: aload_1
    //   1147: iload #5
    //   1149: aload_0
    //   1150: getfield buf : [C
    //   1153: iload #4
    //   1155: iconst_4
    //   1156: iadd
    //   1157: iload #8
    //   1159: iload #4
    //   1161: isub
    //   1162: iconst_1
    //   1163: isub
    //   1164: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1167: aload_0
    //   1168: getfield buf : [C
    //   1171: iload #4
    //   1173: bipush #38
    //   1175: i2c
    //   1176: castore
    //   1177: aload_0
    //   1178: getfield buf : [C
    //   1181: iload #5
    //   1183: bipush #103
    //   1185: i2c
    //   1186: castore
    //   1187: aload_0
    //   1188: getfield buf : [C
    //   1191: iload #4
    //   1193: iconst_2
    //   1194: iadd
    //   1195: bipush #116
    //   1197: i2c
    //   1198: castore
    //   1199: aload_0
    //   1200: getfield buf : [C
    //   1203: iload #4
    //   1205: iconst_3
    //   1206: iadd
    //   1207: bipush #59
    //   1209: i2c
    //   1210: castore
    //   1211: iload #8
    //   1213: iconst_3
    //   1214: iadd
    //   1215: istore #5
    //   1217: goto -> 1359
    //   1220: aload_0
    //   1221: getfield buf : [C
    //   1224: astore_1
    //   1225: iload #4
    //   1227: iconst_1
    //   1228: iadd
    //   1229: istore #5
    //   1231: aload_1
    //   1232: iload #5
    //   1234: aload_0
    //   1235: getfield buf : [C
    //   1238: iload #4
    //   1240: bipush #6
    //   1242: iadd
    //   1243: iload #8
    //   1245: iload #4
    //   1247: isub
    //   1248: iconst_1
    //   1249: isub
    //   1250: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1253: aload_0
    //   1254: getfield buf : [C
    //   1257: iload #4
    //   1259: bipush #92
    //   1261: i2c
    //   1262: castore
    //   1263: aload_0
    //   1264: getfield buf : [C
    //   1267: iload #5
    //   1269: bipush #117
    //   1271: i2c
    //   1272: castore
    //   1273: aload_0
    //   1274: getfield buf : [C
    //   1277: iload #4
    //   1279: iconst_2
    //   1280: iadd
    //   1281: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1284: iload_3
    //   1285: bipush #12
    //   1287: iushr
    //   1288: bipush #15
    //   1290: iand
    //   1291: caload
    //   1292: i2c
    //   1293: castore
    //   1294: aload_0
    //   1295: getfield buf : [C
    //   1298: iload #4
    //   1300: iconst_3
    //   1301: iadd
    //   1302: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1305: iload_3
    //   1306: bipush #8
    //   1308: iushr
    //   1309: bipush #15
    //   1311: iand
    //   1312: caload
    //   1313: i2c
    //   1314: castore
    //   1315: aload_0
    //   1316: getfield buf : [C
    //   1319: iload #4
    //   1321: iconst_4
    //   1322: iadd
    //   1323: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1326: iload_3
    //   1327: iconst_4
    //   1328: iushr
    //   1329: bipush #15
    //   1331: iand
    //   1332: caload
    //   1333: i2c
    //   1334: castore
    //   1335: aload_0
    //   1336: getfield buf : [C
    //   1339: iload #4
    //   1341: iconst_5
    //   1342: iadd
    //   1343: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1346: iload_3
    //   1347: bipush #15
    //   1349: iand
    //   1350: caload
    //   1351: i2c
    //   1352: castore
    //   1353: iload #8
    //   1355: iconst_5
    //   1356: iadd
    //   1357: istore #5
    //   1359: iinc #4, -1
    //   1362: iload #5
    //   1364: istore #8
    //   1366: goto -> 945
    //   1369: iload_2
    //   1370: ifeq -> 1403
    //   1373: aload_0
    //   1374: getfield buf : [C
    //   1377: aload_0
    //   1378: getfield count : I
    //   1381: iconst_2
    //   1382: isub
    //   1383: bipush #34
    //   1385: i2c
    //   1386: castore
    //   1387: aload_0
    //   1388: getfield buf : [C
    //   1391: aload_0
    //   1392: getfield count : I
    //   1395: iconst_1
    //   1396: isub
    //   1397: iload_2
    //   1398: i2c
    //   1399: castore
    //   1400: goto -> 1417
    //   1403: aload_0
    //   1404: getfield buf : [C
    //   1407: aload_0
    //   1408: getfield count : I
    //   1411: iconst_1
    //   1412: isub
    //   1413: bipush #34
    //   1415: i2c
    //   1416: castore
    //   1417: return
    //   1418: aload_0
    //   1419: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserCompatible : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1422: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1425: ifeq -> 2121
    //   1428: iload #7
    //   1430: istore #4
    //   1432: iload #10
    //   1434: istore_3
    //   1435: iload #4
    //   1437: iload #8
    //   1439: if_icmpge -> 1569
    //   1442: aload_0
    //   1443: getfield buf : [C
    //   1446: iload #4
    //   1448: caload
    //   1449: istore #12
    //   1451: iload #12
    //   1453: bipush #34
    //   1455: if_icmpeq -> 1549
    //   1458: iload #12
    //   1460: bipush #47
    //   1462: if_icmpeq -> 1549
    //   1465: iload #12
    //   1467: bipush #92
    //   1469: if_icmpne -> 1475
    //   1472: goto -> 1549
    //   1475: iload #12
    //   1477: bipush #8
    //   1479: if_icmpeq -> 1543
    //   1482: iload #12
    //   1484: bipush #12
    //   1486: if_icmpeq -> 1543
    //   1489: iload #12
    //   1491: bipush #10
    //   1493: if_icmpeq -> 1543
    //   1496: iload #12
    //   1498: bipush #13
    //   1500: if_icmpeq -> 1543
    //   1503: iload #12
    //   1505: bipush #9
    //   1507: if_icmpne -> 1513
    //   1510: goto -> 1543
    //   1513: iload #12
    //   1515: bipush #32
    //   1517: if_icmpge -> 1526
    //   1520: iinc #5, 5
    //   1523: goto -> 1552
    //   1526: iload #5
    //   1528: istore #10
    //   1530: iload #12
    //   1532: bipush #127
    //   1534: if_icmplt -> 1559
    //   1537: iinc #5, 5
    //   1540: goto -> 1552
    //   1543: iinc #5, 1
    //   1546: goto -> 1552
    //   1549: iinc #5, 1
    //   1552: iload #4
    //   1554: istore_3
    //   1555: iload #5
    //   1557: istore #10
    //   1559: iinc #4, 1
    //   1562: iload #10
    //   1564: istore #5
    //   1566: goto -> 1435
    //   1569: iload #5
    //   1571: aload_0
    //   1572: getfield buf : [C
    //   1575: arraylength
    //   1576: if_icmple -> 1585
    //   1579: aload_0
    //   1580: iload #5
    //   1582: invokevirtual expandCapacity : (I)V
    //   1585: aload_0
    //   1586: iload #5
    //   1588: putfield count : I
    //   1591: iload_3
    //   1592: iload #7
    //   1594: if_icmplt -> 2072
    //   1597: aload_0
    //   1598: getfield buf : [C
    //   1601: iload_3
    //   1602: caload
    //   1603: istore #4
    //   1605: iload #4
    //   1607: bipush #8
    //   1609: if_icmpeq -> 2004
    //   1612: iload #4
    //   1614: bipush #12
    //   1616: if_icmpeq -> 2004
    //   1619: iload #4
    //   1621: bipush #10
    //   1623: if_icmpeq -> 2004
    //   1626: iload #4
    //   1628: bipush #13
    //   1630: if_icmpeq -> 2004
    //   1633: iload #4
    //   1635: bipush #9
    //   1637: if_icmpne -> 1643
    //   1640: goto -> 2004
    //   1643: iload #4
    //   1645: bipush #34
    //   1647: if_icmpeq -> 1947
    //   1650: iload #4
    //   1652: bipush #47
    //   1654: if_icmpeq -> 1947
    //   1657: iload #4
    //   1659: bipush #92
    //   1661: if_icmpne -> 1667
    //   1664: goto -> 1947
    //   1667: iload #4
    //   1669: bipush #32
    //   1671: if_icmpge -> 1798
    //   1674: aload_0
    //   1675: getfield buf : [C
    //   1678: astore_1
    //   1679: iload_3
    //   1680: iconst_1
    //   1681: iadd
    //   1682: istore #5
    //   1684: aload_1
    //   1685: iload #5
    //   1687: aload_0
    //   1688: getfield buf : [C
    //   1691: iload_3
    //   1692: bipush #6
    //   1694: iadd
    //   1695: iload #8
    //   1697: iload_3
    //   1698: isub
    //   1699: iconst_1
    //   1700: isub
    //   1701: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1704: aload_0
    //   1705: getfield buf : [C
    //   1708: iload_3
    //   1709: bipush #92
    //   1711: i2c
    //   1712: castore
    //   1713: aload_0
    //   1714: getfield buf : [C
    //   1717: iload #5
    //   1719: bipush #117
    //   1721: i2c
    //   1722: castore
    //   1723: aload_0
    //   1724: getfield buf : [C
    //   1727: iload_3
    //   1728: iconst_2
    //   1729: iadd
    //   1730: bipush #48
    //   1732: i2c
    //   1733: castore
    //   1734: aload_0
    //   1735: getfield buf : [C
    //   1738: iload_3
    //   1739: iconst_3
    //   1740: iadd
    //   1741: bipush #48
    //   1743: i2c
    //   1744: castore
    //   1745: aload_0
    //   1746: getfield buf : [C
    //   1749: astore #6
    //   1751: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   1754: astore_1
    //   1755: iload #4
    //   1757: iconst_2
    //   1758: imul
    //   1759: istore #5
    //   1761: aload #6
    //   1763: iload_3
    //   1764: iconst_4
    //   1765: iadd
    //   1766: aload_1
    //   1767: iload #5
    //   1769: caload
    //   1770: i2c
    //   1771: castore
    //   1772: aload_0
    //   1773: getfield buf : [C
    //   1776: iload_3
    //   1777: iconst_5
    //   1778: iadd
    //   1779: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   1782: iload #5
    //   1784: iconst_1
    //   1785: iadd
    //   1786: caload
    //   1787: i2c
    //   1788: castore
    //   1789: iload #8
    //   1791: iconst_5
    //   1792: iadd
    //   1793: istore #5
    //   1795: goto -> 2062
    //   1798: iload #8
    //   1800: istore #5
    //   1802: iload #4
    //   1804: bipush #127
    //   1806: if_icmplt -> 2062
    //   1809: aload_0
    //   1810: getfield buf : [C
    //   1813: astore_1
    //   1814: iload_3
    //   1815: iconst_1
    //   1816: iadd
    //   1817: istore #5
    //   1819: aload_1
    //   1820: iload #5
    //   1822: aload_0
    //   1823: getfield buf : [C
    //   1826: iload_3
    //   1827: bipush #6
    //   1829: iadd
    //   1830: iload #8
    //   1832: iload_3
    //   1833: isub
    //   1834: iconst_1
    //   1835: isub
    //   1836: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1839: aload_0
    //   1840: getfield buf : [C
    //   1843: iload_3
    //   1844: bipush #92
    //   1846: i2c
    //   1847: castore
    //   1848: aload_0
    //   1849: getfield buf : [C
    //   1852: iload #5
    //   1854: bipush #117
    //   1856: i2c
    //   1857: castore
    //   1858: aload_0
    //   1859: getfield buf : [C
    //   1862: iload_3
    //   1863: iconst_2
    //   1864: iadd
    //   1865: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1868: iload #4
    //   1870: bipush #12
    //   1872: iushr
    //   1873: bipush #15
    //   1875: iand
    //   1876: caload
    //   1877: i2c
    //   1878: castore
    //   1879: aload_0
    //   1880: getfield buf : [C
    //   1883: iload_3
    //   1884: iconst_3
    //   1885: iadd
    //   1886: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1889: iload #4
    //   1891: bipush #8
    //   1893: iushr
    //   1894: bipush #15
    //   1896: iand
    //   1897: caload
    //   1898: i2c
    //   1899: castore
    //   1900: aload_0
    //   1901: getfield buf : [C
    //   1904: iload_3
    //   1905: iconst_4
    //   1906: iadd
    //   1907: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1910: iload #4
    //   1912: iconst_4
    //   1913: iushr
    //   1914: bipush #15
    //   1916: iand
    //   1917: caload
    //   1918: i2c
    //   1919: castore
    //   1920: aload_0
    //   1921: getfield buf : [C
    //   1924: iload_3
    //   1925: iconst_5
    //   1926: iadd
    //   1927: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1930: iload #4
    //   1932: bipush #15
    //   1934: iand
    //   1935: caload
    //   1936: i2c
    //   1937: castore
    //   1938: iload #8
    //   1940: iconst_5
    //   1941: iadd
    //   1942: istore #5
    //   1944: goto -> 2062
    //   1947: aload_0
    //   1948: getfield buf : [C
    //   1951: astore_1
    //   1952: iload_3
    //   1953: iconst_1
    //   1954: iadd
    //   1955: istore #5
    //   1957: aload_1
    //   1958: iload #5
    //   1960: aload_0
    //   1961: getfield buf : [C
    //   1964: iload_3
    //   1965: iconst_2
    //   1966: iadd
    //   1967: iload #8
    //   1969: iload_3
    //   1970: isub
    //   1971: iconst_1
    //   1972: isub
    //   1973: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1976: aload_0
    //   1977: getfield buf : [C
    //   1980: iload_3
    //   1981: bipush #92
    //   1983: i2c
    //   1984: castore
    //   1985: aload_0
    //   1986: getfield buf : [C
    //   1989: iload #5
    //   1991: iload #4
    //   1993: i2c
    //   1994: castore
    //   1995: iload #8
    //   1997: iconst_1
    //   1998: iadd
    //   1999: istore #5
    //   2001: goto -> 2062
    //   2004: aload_0
    //   2005: getfield buf : [C
    //   2008: astore_1
    //   2009: iload_3
    //   2010: iconst_1
    //   2011: iadd
    //   2012: istore #5
    //   2014: aload_1
    //   2015: iload #5
    //   2017: aload_0
    //   2018: getfield buf : [C
    //   2021: iload_3
    //   2022: iconst_2
    //   2023: iadd
    //   2024: iload #8
    //   2026: iload_3
    //   2027: isub
    //   2028: iconst_1
    //   2029: isub
    //   2030: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2033: aload_0
    //   2034: getfield buf : [C
    //   2037: iload_3
    //   2038: bipush #92
    //   2040: i2c
    //   2041: castore
    //   2042: aload_0
    //   2043: getfield buf : [C
    //   2046: iload #5
    //   2048: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   2051: iload #4
    //   2053: caload
    //   2054: i2c
    //   2055: castore
    //   2056: iload #8
    //   2058: iconst_1
    //   2059: iadd
    //   2060: istore #5
    //   2062: iinc #3, -1
    //   2065: iload #5
    //   2067: istore #8
    //   2069: goto -> 1591
    //   2072: iload_2
    //   2073: ifeq -> 2106
    //   2076: aload_0
    //   2077: getfield buf : [C
    //   2080: aload_0
    //   2081: getfield count : I
    //   2084: iconst_2
    //   2085: isub
    //   2086: bipush #34
    //   2088: i2c
    //   2089: castore
    //   2090: aload_0
    //   2091: getfield buf : [C
    //   2094: aload_0
    //   2095: getfield count : I
    //   2098: iconst_1
    //   2099: isub
    //   2100: iload_2
    //   2101: i2c
    //   2102: castore
    //   2103: goto -> 2120
    //   2106: aload_0
    //   2107: getfield buf : [C
    //   2110: aload_0
    //   2111: getfield count : I
    //   2114: iconst_1
    //   2115: isub
    //   2116: bipush #34
    //   2118: i2c
    //   2119: castore
    //   2120: return
    //   2121: iload #5
    //   2123: istore_3
    //   2124: iload #7
    //   2126: istore #5
    //   2128: iconst_0
    //   2129: istore #13
    //   2131: iconst_m1
    //   2132: istore #4
    //   2134: iconst_0
    //   2135: istore #12
    //   2137: iconst_m1
    //   2138: istore #10
    //   2140: iload #5
    //   2142: iload #8
    //   2144: if_icmpge -> 2447
    //   2147: aload_0
    //   2148: getfield buf : [C
    //   2151: iload #5
    //   2153: caload
    //   2154: istore #14
    //   2156: iload #14
    //   2158: sipush #8232
    //   2161: if_icmpeq -> 2357
    //   2164: iload #14
    //   2166: sipush #8233
    //   2169: if_icmpne -> 2175
    //   2172: goto -> 2357
    //   2175: iload #14
    //   2177: bipush #93
    //   2179: if_icmplt -> 2266
    //   2182: iload #13
    //   2184: istore #15
    //   2186: iload_3
    //   2187: istore #16
    //   2189: iload #4
    //   2191: istore #17
    //   2193: iload #12
    //   2195: istore #18
    //   2197: iload #10
    //   2199: istore #11
    //   2201: iload #14
    //   2203: bipush #127
    //   2205: if_icmplt -> 2422
    //   2208: iload #13
    //   2210: istore #15
    //   2212: iload_3
    //   2213: istore #16
    //   2215: iload #4
    //   2217: istore #17
    //   2219: iload #12
    //   2221: istore #18
    //   2223: iload #10
    //   2225: istore #11
    //   2227: iload #14
    //   2229: sipush #160
    //   2232: if_icmpge -> 2422
    //   2235: iload #4
    //   2237: istore #11
    //   2239: iload #4
    //   2241: iconst_m1
    //   2242: if_icmpne -> 2249
    //   2245: iload #5
    //   2247: istore #11
    //   2249: iload #13
    //   2251: iconst_1
    //   2252: iadd
    //   2253: istore #4
    //   2255: iload_3
    //   2256: iconst_4
    //   2257: iadd
    //   2258: istore #10
    //   2260: iload #4
    //   2262: istore_3
    //   2263: goto -> 2399
    //   2266: iload #13
    //   2268: istore #15
    //   2270: iload_3
    //   2271: istore #16
    //   2273: iload #4
    //   2275: istore #17
    //   2277: iload #12
    //   2279: istore #18
    //   2281: iload #10
    //   2283: istore #11
    //   2285: iload #14
    //   2287: aload_0
    //   2288: getfield features : I
    //   2291: invokestatic isSpecial : (CI)Z
    //   2294: ifeq -> 2422
    //   2297: iinc #13, 1
    //   2300: iload_3
    //   2301: istore #12
    //   2303: iload #14
    //   2305: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2308: arraylength
    //   2309: if_icmpge -> 2330
    //   2312: iload_3
    //   2313: istore #12
    //   2315: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2318: iload #14
    //   2320: baload
    //   2321: iconst_4
    //   2322: if_icmpne -> 2330
    //   2325: iload_3
    //   2326: iconst_4
    //   2327: iadd
    //   2328: istore #12
    //   2330: iload #13
    //   2332: istore_3
    //   2333: iload #12
    //   2335: istore #10
    //   2337: iload #4
    //   2339: istore #11
    //   2341: iload #4
    //   2343: iconst_m1
    //   2344: if_icmpne -> 2399
    //   2347: iload #13
    //   2349: istore_3
    //   2350: iload #12
    //   2352: istore #10
    //   2354: goto -> 2392
    //   2357: iload #13
    //   2359: iconst_1
    //   2360: iadd
    //   2361: istore #12
    //   2363: iload_3
    //   2364: iconst_4
    //   2365: iadd
    //   2366: istore #13
    //   2368: iload #12
    //   2370: istore_3
    //   2371: iload #13
    //   2373: istore #10
    //   2375: iload #4
    //   2377: istore #11
    //   2379: iload #4
    //   2381: iconst_m1
    //   2382: if_icmpne -> 2399
    //   2385: iload #13
    //   2387: istore #10
    //   2389: iload #12
    //   2391: istore_3
    //   2392: iload #5
    //   2394: istore #4
    //   2396: goto -> 2403
    //   2399: iload #11
    //   2401: istore #4
    //   2403: iload #5
    //   2405: istore #11
    //   2407: iload #14
    //   2409: istore #18
    //   2411: iload #4
    //   2413: istore #17
    //   2415: iload #10
    //   2417: istore #16
    //   2419: iload_3
    //   2420: istore #15
    //   2422: iinc #5, 1
    //   2425: iload #15
    //   2427: istore #13
    //   2429: iload #16
    //   2431: istore_3
    //   2432: iload #17
    //   2434: istore #4
    //   2436: iload #18
    //   2438: istore #12
    //   2440: iload #11
    //   2442: istore #10
    //   2444: goto -> 2140
    //   2447: iload #13
    //   2449: ifle -> 3409
    //   2452: iload_3
    //   2453: iload #13
    //   2455: iadd
    //   2456: istore #5
    //   2458: iload #5
    //   2460: aload_0
    //   2461: getfield buf : [C
    //   2464: arraylength
    //   2465: if_icmple -> 2474
    //   2468: aload_0
    //   2469: iload #5
    //   2471: invokevirtual expandCapacity : (I)V
    //   2474: aload_0
    //   2475: iload #5
    //   2477: putfield count : I
    //   2480: iload #13
    //   2482: iconst_1
    //   2483: if_icmpne -> 2956
    //   2486: iload #12
    //   2488: sipush #8232
    //   2491: if_icmpne -> 2605
    //   2494: iload #10
    //   2496: iconst_1
    //   2497: iadd
    //   2498: istore #5
    //   2500: aload_0
    //   2501: getfield buf : [C
    //   2504: iload #5
    //   2506: aload_0
    //   2507: getfield buf : [C
    //   2510: iload #10
    //   2512: bipush #6
    //   2514: iadd
    //   2515: iload #8
    //   2517: iload #10
    //   2519: isub
    //   2520: iconst_1
    //   2521: isub
    //   2522: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2525: aload_0
    //   2526: getfield buf : [C
    //   2529: iload #10
    //   2531: bipush #92
    //   2533: i2c
    //   2534: castore
    //   2535: aload_0
    //   2536: getfield buf : [C
    //   2539: iload #5
    //   2541: bipush #117
    //   2543: i2c
    //   2544: castore
    //   2545: aload_0
    //   2546: getfield buf : [C
    //   2549: astore_1
    //   2550: iinc #5, 1
    //   2553: aload_1
    //   2554: iload #5
    //   2556: bipush #50
    //   2558: i2c
    //   2559: castore
    //   2560: aload_0
    //   2561: getfield buf : [C
    //   2564: astore_1
    //   2565: iinc #5, 1
    //   2568: aload_1
    //   2569: iload #5
    //   2571: bipush #48
    //   2573: i2c
    //   2574: castore
    //   2575: aload_0
    //   2576: getfield buf : [C
    //   2579: astore_1
    //   2580: iinc #5, 1
    //   2583: aload_1
    //   2584: iload #5
    //   2586: bipush #50
    //   2588: i2c
    //   2589: castore
    //   2590: aload_0
    //   2591: getfield buf : [C
    //   2594: iload #5
    //   2596: iconst_1
    //   2597: iadd
    //   2598: bipush #56
    //   2600: i2c
    //   2601: castore
    //   2602: goto -> 3409
    //   2605: iload #12
    //   2607: sipush #8233
    //   2610: if_icmpne -> 2724
    //   2613: iload #10
    //   2615: iconst_1
    //   2616: iadd
    //   2617: istore #5
    //   2619: aload_0
    //   2620: getfield buf : [C
    //   2623: iload #5
    //   2625: aload_0
    //   2626: getfield buf : [C
    //   2629: iload #10
    //   2631: bipush #6
    //   2633: iadd
    //   2634: iload #8
    //   2636: iload #10
    //   2638: isub
    //   2639: iconst_1
    //   2640: isub
    //   2641: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2644: aload_0
    //   2645: getfield buf : [C
    //   2648: iload #10
    //   2650: bipush #92
    //   2652: i2c
    //   2653: castore
    //   2654: aload_0
    //   2655: getfield buf : [C
    //   2658: iload #5
    //   2660: bipush #117
    //   2662: i2c
    //   2663: castore
    //   2664: aload_0
    //   2665: getfield buf : [C
    //   2668: astore_1
    //   2669: iinc #5, 1
    //   2672: aload_1
    //   2673: iload #5
    //   2675: bipush #50
    //   2677: i2c
    //   2678: castore
    //   2679: aload_0
    //   2680: getfield buf : [C
    //   2683: astore_1
    //   2684: iinc #5, 1
    //   2687: aload_1
    //   2688: iload #5
    //   2690: bipush #48
    //   2692: i2c
    //   2693: castore
    //   2694: aload_0
    //   2695: getfield buf : [C
    //   2698: astore_1
    //   2699: iinc #5, 1
    //   2702: aload_1
    //   2703: iload #5
    //   2705: bipush #50
    //   2707: i2c
    //   2708: castore
    //   2709: aload_0
    //   2710: getfield buf : [C
    //   2713: iload #5
    //   2715: iconst_1
    //   2716: iadd
    //   2717: bipush #57
    //   2719: i2c
    //   2720: castore
    //   2721: goto -> 3409
    //   2724: iload #12
    //   2726: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2729: arraylength
    //   2730: if_icmpge -> 2899
    //   2733: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2736: iload #12
    //   2738: baload
    //   2739: iconst_4
    //   2740: if_icmpne -> 2899
    //   2743: iload #10
    //   2745: iconst_1
    //   2746: iadd
    //   2747: istore #5
    //   2749: aload_0
    //   2750: getfield buf : [C
    //   2753: iload #5
    //   2755: aload_0
    //   2756: getfield buf : [C
    //   2759: iload #10
    //   2761: bipush #6
    //   2763: iadd
    //   2764: iload #8
    //   2766: iload #10
    //   2768: isub
    //   2769: iconst_1
    //   2770: isub
    //   2771: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2774: aload_0
    //   2775: getfield buf : [C
    //   2778: iload #10
    //   2780: bipush #92
    //   2782: i2c
    //   2783: castore
    //   2784: aload_0
    //   2785: getfield buf : [C
    //   2788: astore_1
    //   2789: iload #5
    //   2791: iconst_1
    //   2792: iadd
    //   2793: istore #4
    //   2795: aload_1
    //   2796: iload #5
    //   2798: bipush #117
    //   2800: i2c
    //   2801: castore
    //   2802: aload_0
    //   2803: getfield buf : [C
    //   2806: astore_1
    //   2807: iload #4
    //   2809: iconst_1
    //   2810: iadd
    //   2811: istore #5
    //   2813: aload_1
    //   2814: iload #4
    //   2816: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2819: iload #12
    //   2821: bipush #12
    //   2823: iushr
    //   2824: bipush #15
    //   2826: iand
    //   2827: caload
    //   2828: i2c
    //   2829: castore
    //   2830: aload_0
    //   2831: getfield buf : [C
    //   2834: astore_1
    //   2835: iload #5
    //   2837: iconst_1
    //   2838: iadd
    //   2839: istore #4
    //   2841: aload_1
    //   2842: iload #5
    //   2844: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2847: iload #12
    //   2849: bipush #8
    //   2851: iushr
    //   2852: bipush #15
    //   2854: iand
    //   2855: caload
    //   2856: i2c
    //   2857: castore
    //   2858: aload_0
    //   2859: getfield buf : [C
    //   2862: iload #4
    //   2864: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2867: iload #12
    //   2869: iconst_4
    //   2870: iushr
    //   2871: bipush #15
    //   2873: iand
    //   2874: caload
    //   2875: i2c
    //   2876: castore
    //   2877: aload_0
    //   2878: getfield buf : [C
    //   2881: iload #4
    //   2883: iconst_1
    //   2884: iadd
    //   2885: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2888: iload #12
    //   2890: bipush #15
    //   2892: iand
    //   2893: caload
    //   2894: i2c
    //   2895: castore
    //   2896: goto -> 3409
    //   2899: iload #10
    //   2901: iconst_1
    //   2902: iadd
    //   2903: istore #5
    //   2905: aload_0
    //   2906: getfield buf : [C
    //   2909: iload #5
    //   2911: aload_0
    //   2912: getfield buf : [C
    //   2915: iload #10
    //   2917: iconst_2
    //   2918: iadd
    //   2919: iload #8
    //   2921: iload #10
    //   2923: isub
    //   2924: iconst_1
    //   2925: isub
    //   2926: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2929: aload_0
    //   2930: getfield buf : [C
    //   2933: iload #10
    //   2935: bipush #92
    //   2937: i2c
    //   2938: castore
    //   2939: aload_0
    //   2940: getfield buf : [C
    //   2943: iload #5
    //   2945: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   2948: iload #12
    //   2950: caload
    //   2951: i2c
    //   2952: castore
    //   2953: goto -> 3409
    //   2956: iload #13
    //   2958: iconst_1
    //   2959: if_icmple -> 3409
    //   2962: iload #4
    //   2964: iload #7
    //   2966: isub
    //   2967: istore_3
    //   2968: iload #4
    //   2970: istore #5
    //   2972: iload_3
    //   2973: istore #4
    //   2975: iload #4
    //   2977: aload_1
    //   2978: invokevirtual length : ()I
    //   2981: if_icmpge -> 3409
    //   2984: aload_1
    //   2985: iload #4
    //   2987: invokevirtual charAt : (I)C
    //   2990: istore_3
    //   2991: iload_3
    //   2992: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2995: arraylength
    //   2996: if_icmpge -> 3013
    //   2999: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   3002: iload_3
    //   3003: baload
    //   3004: ifne -> 3010
    //   3007: goto -> 3013
    //   3010: goto -> 3029
    //   3013: iload_3
    //   3014: bipush #47
    //   3016: if_icmpne -> 3219
    //   3019: aload_0
    //   3020: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   3023: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   3026: ifeq -> 3219
    //   3029: aload_0
    //   3030: getfield buf : [C
    //   3033: astore #6
    //   3035: iload #5
    //   3037: iconst_1
    //   3038: iadd
    //   3039: istore #10
    //   3041: aload #6
    //   3043: iload #5
    //   3045: bipush #92
    //   3047: i2c
    //   3048: castore
    //   3049: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   3052: iload_3
    //   3053: baload
    //   3054: iconst_4
    //   3055: if_icmpne -> 3193
    //   3058: aload_0
    //   3059: getfield buf : [C
    //   3062: astore #6
    //   3064: iload #10
    //   3066: iconst_1
    //   3067: iadd
    //   3068: istore #5
    //   3070: aload #6
    //   3072: iload #10
    //   3074: bipush #117
    //   3076: i2c
    //   3077: castore
    //   3078: aload_0
    //   3079: getfield buf : [C
    //   3082: astore #6
    //   3084: iload #5
    //   3086: iconst_1
    //   3087: iadd
    //   3088: istore #10
    //   3090: aload #6
    //   3092: iload #5
    //   3094: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3097: iload_3
    //   3098: bipush #12
    //   3100: iushr
    //   3101: bipush #15
    //   3103: iand
    //   3104: caload
    //   3105: i2c
    //   3106: castore
    //   3107: aload_0
    //   3108: getfield buf : [C
    //   3111: astore #6
    //   3113: iload #10
    //   3115: iconst_1
    //   3116: iadd
    //   3117: istore #5
    //   3119: aload #6
    //   3121: iload #10
    //   3123: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3126: iload_3
    //   3127: bipush #8
    //   3129: iushr
    //   3130: bipush #15
    //   3132: iand
    //   3133: caload
    //   3134: i2c
    //   3135: castore
    //   3136: aload_0
    //   3137: getfield buf : [C
    //   3140: astore #6
    //   3142: iload #5
    //   3144: iconst_1
    //   3145: iadd
    //   3146: istore #10
    //   3148: aload #6
    //   3150: iload #5
    //   3152: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3155: iload_3
    //   3156: iconst_4
    //   3157: iushr
    //   3158: bipush #15
    //   3160: iand
    //   3161: caload
    //   3162: i2c
    //   3163: castore
    //   3164: aload_0
    //   3165: getfield buf : [C
    //   3168: astore #6
    //   3170: iload #10
    //   3172: iconst_1
    //   3173: iadd
    //   3174: istore #5
    //   3176: aload #6
    //   3178: iload #10
    //   3180: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3183: iload_3
    //   3184: bipush #15
    //   3186: iand
    //   3187: caload
    //   3188: i2c
    //   3189: castore
    //   3190: goto -> 3403
    //   3193: aload_0
    //   3194: getfield buf : [C
    //   3197: astore #6
    //   3199: iload #10
    //   3201: iconst_1
    //   3202: iadd
    //   3203: istore #5
    //   3205: aload #6
    //   3207: iload #10
    //   3209: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   3212: iload_3
    //   3213: caload
    //   3214: i2c
    //   3215: castore
    //   3216: goto -> 3403
    //   3219: iload_3
    //   3220: sipush #8232
    //   3223: if_icmpeq -> 3251
    //   3226: iload_3
    //   3227: sipush #8233
    //   3230: if_icmpne -> 3236
    //   3233: goto -> 3251
    //   3236: aload_0
    //   3237: getfield buf : [C
    //   3240: iload #5
    //   3242: iload_3
    //   3243: i2c
    //   3244: castore
    //   3245: iinc #5, 1
    //   3248: goto -> 3403
    //   3251: aload_0
    //   3252: getfield buf : [C
    //   3255: astore #6
    //   3257: iload #5
    //   3259: iconst_1
    //   3260: iadd
    //   3261: istore #10
    //   3263: aload #6
    //   3265: iload #5
    //   3267: bipush #92
    //   3269: i2c
    //   3270: castore
    //   3271: aload_0
    //   3272: getfield buf : [C
    //   3275: astore #6
    //   3277: iload #10
    //   3279: iconst_1
    //   3280: iadd
    //   3281: istore #5
    //   3283: aload #6
    //   3285: iload #10
    //   3287: bipush #117
    //   3289: i2c
    //   3290: castore
    //   3291: aload_0
    //   3292: getfield buf : [C
    //   3295: astore #6
    //   3297: iload #5
    //   3299: iconst_1
    //   3300: iadd
    //   3301: istore #10
    //   3303: aload #6
    //   3305: iload #5
    //   3307: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3310: iload_3
    //   3311: bipush #12
    //   3313: iushr
    //   3314: bipush #15
    //   3316: iand
    //   3317: caload
    //   3318: i2c
    //   3319: castore
    //   3320: aload_0
    //   3321: getfield buf : [C
    //   3324: astore #6
    //   3326: iload #10
    //   3328: iconst_1
    //   3329: iadd
    //   3330: istore #5
    //   3332: aload #6
    //   3334: iload #10
    //   3336: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3339: iload_3
    //   3340: bipush #8
    //   3342: iushr
    //   3343: bipush #15
    //   3345: iand
    //   3346: caload
    //   3347: i2c
    //   3348: castore
    //   3349: aload_0
    //   3350: getfield buf : [C
    //   3353: astore #6
    //   3355: iload #5
    //   3357: iconst_1
    //   3358: iadd
    //   3359: istore #10
    //   3361: aload #6
    //   3363: iload #5
    //   3365: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3368: iload_3
    //   3369: iconst_4
    //   3370: iushr
    //   3371: bipush #15
    //   3373: iand
    //   3374: caload
    //   3375: i2c
    //   3376: castore
    //   3377: aload_0
    //   3378: getfield buf : [C
    //   3381: astore #6
    //   3383: iload #10
    //   3385: iconst_1
    //   3386: iadd
    //   3387: istore #5
    //   3389: aload #6
    //   3391: iload #10
    //   3393: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   3396: iload_3
    //   3397: bipush #15
    //   3399: iand
    //   3400: caload
    //   3401: i2c
    //   3402: castore
    //   3403: iinc #4, 1
    //   3406: goto -> 2975
    //   3409: iload_2
    //   3410: ifeq -> 3443
    //   3413: aload_0
    //   3414: getfield buf : [C
    //   3417: aload_0
    //   3418: getfield count : I
    //   3421: iconst_2
    //   3422: isub
    //   3423: bipush #34
    //   3425: i2c
    //   3426: castore
    //   3427: aload_0
    //   3428: getfield buf : [C
    //   3431: aload_0
    //   3432: getfield count : I
    //   3435: iconst_1
    //   3436: isub
    //   3437: iload_2
    //   3438: i2c
    //   3439: castore
    //   3440: goto -> 3457
    //   3443: aload_0
    //   3444: getfield buf : [C
    //   3447: aload_0
    //   3448: getfield count : I
    //   3451: iconst_1
    //   3452: isub
    //   3453: bipush #34
    //   3455: i2c
    //   3456: castore
    //   3457: return
  }
  
  protected void writeStringWithSingleQuote(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: ifnonnull -> 50
    //   8: aload_0
    //   9: getfield count : I
    //   12: iconst_4
    //   13: iadd
    //   14: istore_3
    //   15: iload_3
    //   16: aload_0
    //   17: getfield buf : [C
    //   20: arraylength
    //   21: if_icmple -> 29
    //   24: aload_0
    //   25: iload_3
    //   26: invokevirtual expandCapacity : (I)V
    //   29: ldc 'null'
    //   31: iconst_0
    //   32: iconst_4
    //   33: aload_0
    //   34: getfield buf : [C
    //   37: aload_0
    //   38: getfield count : I
    //   41: invokevirtual getChars : (II[CI)V
    //   44: aload_0
    //   45: iload_3
    //   46: putfield count : I
    //   49: return
    //   50: aload_1
    //   51: invokevirtual length : ()I
    //   54: istore #4
    //   56: aload_0
    //   57: getfield count : I
    //   60: iload #4
    //   62: iadd
    //   63: iconst_2
    //   64: iadd
    //   65: istore #5
    //   67: iload #5
    //   69: aload_0
    //   70: getfield buf : [C
    //   73: arraylength
    //   74: if_icmple -> 190
    //   77: aload_0
    //   78: getfield writer : Ljava/io/Writer;
    //   81: ifnull -> 184
    //   84: aload_0
    //   85: bipush #39
    //   87: invokevirtual write : (I)V
    //   90: iload_3
    //   91: aload_1
    //   92: invokevirtual length : ()I
    //   95: if_icmpge -> 177
    //   98: aload_1
    //   99: iload_3
    //   100: invokevirtual charAt : (I)C
    //   103: istore #4
    //   105: iload #4
    //   107: bipush #13
    //   109: if_icmple -> 155
    //   112: iload #4
    //   114: bipush #92
    //   116: if_icmpeq -> 155
    //   119: iload #4
    //   121: bipush #39
    //   123: if_icmpeq -> 155
    //   126: iload #4
    //   128: bipush #47
    //   130: if_icmpne -> 146
    //   133: aload_0
    //   134: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   137: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   140: ifeq -> 146
    //   143: goto -> 155
    //   146: aload_0
    //   147: iload #4
    //   149: invokevirtual write : (I)V
    //   152: goto -> 171
    //   155: aload_0
    //   156: bipush #92
    //   158: invokevirtual write : (I)V
    //   161: aload_0
    //   162: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   165: iload #4
    //   167: caload
    //   168: invokevirtual write : (I)V
    //   171: iinc #3, 1
    //   174: goto -> 90
    //   177: aload_0
    //   178: bipush #39
    //   180: invokevirtual write : (I)V
    //   183: return
    //   184: aload_0
    //   185: iload #5
    //   187: invokevirtual expandCapacity : (I)V
    //   190: aload_0
    //   191: getfield count : I
    //   194: iconst_1
    //   195: iadd
    //   196: istore #6
    //   198: iload #6
    //   200: iload #4
    //   202: iadd
    //   203: istore #7
    //   205: aload_0
    //   206: getfield buf : [C
    //   209: aload_0
    //   210: getfield count : I
    //   213: bipush #39
    //   215: i2c
    //   216: castore
    //   217: aload_1
    //   218: iconst_0
    //   219: iload #4
    //   221: aload_0
    //   222: getfield buf : [C
    //   225: iload #6
    //   227: invokevirtual getChars : (II[CI)V
    //   230: aload_0
    //   231: iload #5
    //   233: putfield count : I
    //   236: iload #6
    //   238: istore_3
    //   239: iconst_m1
    //   240: istore #8
    //   242: iconst_0
    //   243: istore #4
    //   245: iload_3
    //   246: iload #7
    //   248: if_icmpge -> 348
    //   251: aload_0
    //   252: getfield buf : [C
    //   255: iload_3
    //   256: caload
    //   257: istore #9
    //   259: iload #9
    //   261: bipush #13
    //   263: if_icmple -> 319
    //   266: iload #9
    //   268: bipush #92
    //   270: if_icmpeq -> 319
    //   273: iload #9
    //   275: bipush #39
    //   277: if_icmpeq -> 319
    //   280: iload_2
    //   281: istore #10
    //   283: iload #8
    //   285: istore #11
    //   287: iload #4
    //   289: istore #12
    //   291: iload #9
    //   293: bipush #47
    //   295: if_icmpne -> 331
    //   298: iload_2
    //   299: istore #10
    //   301: iload #8
    //   303: istore #11
    //   305: iload #4
    //   307: istore #12
    //   309: aload_0
    //   310: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   313: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   316: ifeq -> 331
    //   319: iload_2
    //   320: iconst_1
    //   321: iadd
    //   322: istore #10
    //   324: iload_3
    //   325: istore #11
    //   327: iload #9
    //   329: istore #12
    //   331: iinc #3, 1
    //   334: iload #10
    //   336: istore_2
    //   337: iload #11
    //   339: istore #8
    //   341: iload #12
    //   343: istore #4
    //   345: goto -> 245
    //   348: iload #5
    //   350: iload_2
    //   351: iadd
    //   352: istore_3
    //   353: iload_3
    //   354: aload_0
    //   355: getfield buf : [C
    //   358: arraylength
    //   359: if_icmple -> 367
    //   362: aload_0
    //   363: iload_3
    //   364: invokevirtual expandCapacity : (I)V
    //   367: aload_0
    //   368: iload_3
    //   369: putfield count : I
    //   372: iload_2
    //   373: iconst_1
    //   374: if_icmpne -> 433
    //   377: aload_0
    //   378: getfield buf : [C
    //   381: astore_1
    //   382: iload #8
    //   384: iconst_1
    //   385: iadd
    //   386: istore_3
    //   387: aload_1
    //   388: iload_3
    //   389: aload_0
    //   390: getfield buf : [C
    //   393: iload #8
    //   395: iconst_2
    //   396: iadd
    //   397: iload #7
    //   399: iload #8
    //   401: isub
    //   402: iconst_1
    //   403: isub
    //   404: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   407: aload_0
    //   408: getfield buf : [C
    //   411: iload #8
    //   413: bipush #92
    //   415: i2c
    //   416: castore
    //   417: aload_0
    //   418: getfield buf : [C
    //   421: iload_3
    //   422: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   425: iload #4
    //   427: caload
    //   428: i2c
    //   429: castore
    //   430: goto -> 634
    //   433: iload_2
    //   434: iconst_1
    //   435: if_icmple -> 634
    //   438: aload_0
    //   439: getfield buf : [C
    //   442: astore_1
    //   443: iload #8
    //   445: iconst_1
    //   446: iadd
    //   447: istore #12
    //   449: aload_1
    //   450: iload #12
    //   452: aload_0
    //   453: getfield buf : [C
    //   456: iload #8
    //   458: iconst_2
    //   459: iadd
    //   460: iload #7
    //   462: iload #8
    //   464: isub
    //   465: iconst_1
    //   466: isub
    //   467: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   470: aload_0
    //   471: getfield buf : [C
    //   474: iload #8
    //   476: bipush #92
    //   478: i2c
    //   479: castore
    //   480: aload_0
    //   481: getfield buf : [C
    //   484: iload #12
    //   486: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   489: iload #4
    //   491: caload
    //   492: i2c
    //   493: castore
    //   494: iload #7
    //   496: iconst_1
    //   497: iadd
    //   498: istore_3
    //   499: iload #12
    //   501: iconst_2
    //   502: isub
    //   503: istore #4
    //   505: iload #4
    //   507: iload #6
    //   509: if_icmplt -> 634
    //   512: aload_0
    //   513: getfield buf : [C
    //   516: iload #4
    //   518: caload
    //   519: istore #12
    //   521: iload #12
    //   523: bipush #13
    //   525: if_icmple -> 565
    //   528: iload #12
    //   530: bipush #92
    //   532: if_icmpeq -> 565
    //   535: iload #12
    //   537: bipush #39
    //   539: if_icmpeq -> 565
    //   542: iload_3
    //   543: istore #8
    //   545: iload #12
    //   547: bipush #47
    //   549: if_icmpne -> 625
    //   552: iload_3
    //   553: istore #8
    //   555: aload_0
    //   556: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   559: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   562: ifeq -> 625
    //   565: aload_0
    //   566: getfield buf : [C
    //   569: astore_1
    //   570: iload #4
    //   572: iconst_1
    //   573: iadd
    //   574: istore #8
    //   576: aload_1
    //   577: iload #8
    //   579: aload_0
    //   580: getfield buf : [C
    //   583: iload #4
    //   585: iconst_2
    //   586: iadd
    //   587: iload_3
    //   588: iload #4
    //   590: isub
    //   591: iconst_1
    //   592: isub
    //   593: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   596: aload_0
    //   597: getfield buf : [C
    //   600: iload #4
    //   602: bipush #92
    //   604: i2c
    //   605: castore
    //   606: aload_0
    //   607: getfield buf : [C
    //   610: iload #8
    //   612: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   615: iload #12
    //   617: caload
    //   618: i2c
    //   619: castore
    //   620: iload_3
    //   621: iconst_1
    //   622: iadd
    //   623: istore #8
    //   625: iinc #4, -1
    //   628: iload #8
    //   630: istore_3
    //   631: goto -> 505
    //   634: aload_0
    //   635: getfield buf : [C
    //   638: aload_0
    //   639: getfield count : I
    //   642: iconst_1
    //   643: isub
    //   644: bipush #39
    //   646: i2c
    //   647: castore
    //   648: return
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString) throws IOException {
    writeTo(paramOutputStream, Charset.forName(paramString));
  }
  
  public void writeTo(OutputStream paramOutputStream, Charset paramCharset) throws IOException {
    writeToEx(paramOutputStream, paramCharset);
  }
  
  public void writeTo(Writer paramWriter) throws IOException {
    if (this.writer == null) {
      paramWriter.write(this.buf, 0, this.count);
      return;
    } 
    throw new UnsupportedOperationException("writer not null");
  }
  
  public int writeToEx(OutputStream paramOutputStream, Charset paramCharset) throws IOException {
    if (this.writer == null) {
      if (paramCharset == UTF8)
        return encodeToUTF8(paramOutputStream); 
      byte[] arrayOfByte = (new String(this.buf, 0, this.count)).getBytes(paramCharset);
      paramOutputStream.write(arrayOfByte);
      return arrayOfByte.length;
    } 
    throw new UnsupportedOperationException("writer not null");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */