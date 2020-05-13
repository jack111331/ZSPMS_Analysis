package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public abstract class JSONLexerBase implements JSONLexer, Closeable {
  protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
  
  protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
  
  private static final ThreadLocal<char[]> SBUF_LOCAL = (ThreadLocal)new ThreadLocal<char>();
  
  protected static final int[] digits;
  
  protected static final char[] typeFieldName;
  
  protected int bp;
  
  protected Calendar calendar = null;
  
  protected char ch;
  
  protected int eofPos;
  
  protected int features;
  
  protected boolean hasSpecial;
  
  protected Locale locale = JSON.defaultLocale;
  
  public int matchStat = 0;
  
  protected int np;
  
  protected int pos;
  
  protected char[] sbuf;
  
  protected int sp;
  
  protected String stringDefaultValue = null;
  
  protected TimeZone timeZone = JSON.defaultTimeZone;
  
  protected int token;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\"");
    stringBuilder.append(JSON.DEFAULT_TYPE_KEY);
    stringBuilder.append("\":\"");
    typeFieldName = stringBuilder.toString().toCharArray();
    digits = new int[103];
    byte b;
    for (b = 48; b <= 57; b++)
      digits[b] = b - 48; 
    for (b = 97; b <= 102; b++)
      digits[b] = b - 97 + 10; 
    for (b = 65; b <= 70; b++)
      digits[b] = b - 65 + 10; 
  }
  
  public JSONLexerBase(int paramInt) {
    this.features = paramInt;
    if ((paramInt & Feature.InitStringFieldAsEmpty.mask) != 0)
      this.stringDefaultValue = ""; 
    this.sbuf = SBUF_LOCAL.get();
    if (this.sbuf == null)
      this.sbuf = new char[512]; 
  }
  
  public static boolean isWhitespace(char paramChar) {
    boolean bool;
    if (paramChar <= ' ' && (paramChar == ' ' || paramChar == '\n' || paramChar == '\r' || paramChar == '\t' || paramChar == '\f' || paramChar == '\b')) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static String readString(char[] paramArrayOfchar, int paramInt) {
    char[] arrayOfChar = new char[paramInt];
    int i = 0;
    int j = 0;
    while (i < paramInt) {
      char c = paramArrayOfchar[i];
      if (c != '\\') {
        arrayOfChar[j] = (char)c;
        j++;
      } else {
        int[] arrayOfInt;
        int m;
        char c1;
        char c2;
        char c3;
        int k = i + 1;
        i = paramArrayOfchar[k];
        switch (i) {
          default:
            switch (i) {
              default:
                switch (i) {
                  default:
                    throw new JSONException("unclosed.str.lit");
                  case 'x':
                    i = j + 1;
                    arrayOfInt = digits;
                    m = arrayOfInt[paramArrayOfchar[++k]];
                    arrayOfInt = digits;
                    arrayOfChar[j] = (char)(char)(m * 16 + arrayOfInt[paramArrayOfchar[++k]]);
                    j = k;
                    break;
                  case 'r':
                    i = j + 1;
                    arrayOfChar[j] = (char)'\r';
                    j = k;
                    break;
                  case 'n':
                    i = j + 1;
                    arrayOfChar[j] = (char)'\n';
                    j = k;
                    break;
                  case 'b':
                    i = j + 1;
                    arrayOfChar[j] = (char)'\b';
                    j = k;
                    break;
                  case '\\':
                    i = j + 1;
                    arrayOfChar[j] = (char)'\\';
                    j = k;
                    break;
                  case 'F':
                  case 'f':
                    i = j + 1;
                    arrayOfChar[j] = (char)'\f';
                    j = k;
                    break;
                  case '\'':
                    i = j + 1;
                    arrayOfChar[j] = (char)'\'';
                    j = k;
                    break;
                  case '"':
                    i = j + 1;
                    arrayOfChar[j] = (char)'"';
                    j = k;
                    break;
                } 
                k = i;
                i = j;
                j = k;
                break;
              case 'v':
                i = j + 1;
                arrayOfChar[j] = (char)'\013';
                j = k;
                k = i;
                i = j;
                j = k;
                break;
              case 'u':
                i = j + 1;
                c1 = paramArrayOfchar[++k];
                c2 = paramArrayOfchar[++k];
                c3 = paramArrayOfchar[++k];
                k++;
                arrayOfChar[j] = (char)(char)Integer.parseInt(new String(new char[] { c1, c2, c3, paramArrayOfchar[k] }, ), 16);
                j = k;
                k = i;
                i = j;
                j = k;
                break;
              case 't':
                break;
            } 
            i = j + 1;
            arrayOfChar[j] = (char)'\t';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '7':
            i = j + 1;
            arrayOfChar[j] = (char)'\007';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '6':
            i = j + 1;
            arrayOfChar[j] = (char)'\006';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '5':
            i = j + 1;
            arrayOfChar[j] = (char)'\005';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '4':
            i = j + 1;
            arrayOfChar[j] = (char)'\004';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '3':
            i = j + 1;
            arrayOfChar[j] = (char)'\003';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '2':
            i = j + 1;
            arrayOfChar[j] = (char)'\002';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '1':
            i = j + 1;
            arrayOfChar[j] = (char)'\001';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '0':
            i = j + 1;
            arrayOfChar[j] = (char)Character.MIN_VALUE;
            j = k;
            k = i;
            i = j;
            j = k;
            break;
          case '/':
            i = j + 1;
            arrayOfChar[j] = (char)'/';
            j = k;
            k = i;
            i = j;
            j = k;
            break;
        } 
      } 
      i++;
    } 
    return new String(arrayOfChar, 0, j);
  }
  
  private void scanStringSingleQuote() {
    this.np = this.bp;
    this.hasSpecial = false;
    while (true) {
      char c = next();
      if (c == '\'') {
        this.token = 4;
        next();
        return;
      } 
      if (c == '\032') {
        if (!isEOF()) {
          putChar('\032');
          continue;
        } 
        throw new JSONException("unclosed single-quote string");
      } 
      if (c == '\\') {
        if (!this.hasSpecial) {
          this.hasSpecial = true;
          if (this.sp > this.sbuf.length) {
            char[] arrayOfChar1 = new char[this.sp * 2];
            System.arraycopy(this.sbuf, 0, arrayOfChar1, 0, this.sbuf.length);
            this.sbuf = arrayOfChar1;
          } 
          copyTo(this.np + 1, this.sp, this.sbuf);
        } 
        char c1 = next();
        switch (c1) {
          default:
            switch (c1) {
              default:
                switch (c1) {
                  default:
                    this.ch = (char)c1;
                    throw new JSONException("unclosed single-quote string");
                  case 'x':
                    putChar((char)(digits[next()] * 16 + digits[next()]));
                    continue;
                  case 'r':
                    putChar('\r');
                    continue;
                  case 'n':
                    putChar('\n');
                    continue;
                  case 'b':
                    putChar('\b');
                    continue;
                  case '\\':
                    putChar('\\');
                    continue;
                  case 'F':
                  case 'f':
                    putChar('\f');
                    continue;
                  case '\'':
                    putChar('\'');
                    continue;
                  case '"':
                    break;
                } 
                putChar('"');
                continue;
              case 'v':
                putChar('\013');
                continue;
              case 'u':
                putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }, ), 16));
                continue;
              case 't':
                break;
            } 
            putChar('\t');
            continue;
          case '7':
            putChar('\007');
            continue;
          case '6':
            putChar('\006');
            continue;
          case '5':
            putChar('\005');
            continue;
          case '4':
            putChar('\004');
            continue;
          case '3':
            putChar('\003');
            continue;
          case '2':
            putChar('\002');
            continue;
          case '1':
            putChar('\001');
            continue;
          case '0':
            putChar(false);
            continue;
          case '/':
            break;
        } 
        putChar('/');
        continue;
      } 
      if (!this.hasSpecial) {
        this.sp++;
        continue;
      } 
      if (this.sp == this.sbuf.length) {
        putChar(c);
        continue;
      } 
      char[] arrayOfChar = this.sbuf;
      int i = this.sp;
      this.sp = i + 1;
      arrayOfChar[i] = c;
    } 
  }
  
  public abstract String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable);
  
  protected abstract void arrayCopy(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3);
  
  public abstract byte[] bytesValue();
  
  protected abstract boolean charArrayCompare(char[] paramArrayOfchar);
  
  public abstract char charAt(int paramInt);
  
  public void close() {
    if (this.sbuf.length <= 8192)
      SBUF_LOCAL.set(this.sbuf); 
    this.sbuf = null;
  }
  
  public void config(Feature paramFeature, boolean paramBoolean) {
    this.features = Feature.config(this.features, paramFeature, paramBoolean);
    if ((this.features & Feature.InitStringFieldAsEmpty.mask) != 0)
      this.stringDefaultValue = ""; 
  }
  
  protected abstract void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfchar);
  
  public final Number decimalValue(boolean paramBoolean) {
    char c = charAt(this.np + this.sp - 1);
    if (c == 'F')
      try {
        return Float.valueOf(Float.parseFloat(numberString()));
      } catch (NumberFormatException numberFormatException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberFormatException.getMessage());
        stringBuilder.append(", ");
        stringBuilder.append(info());
        throw new JSONException(stringBuilder.toString());
      }  
    if (c == 'D')
      return Double.valueOf(Double.parseDouble(numberString())); 
    if (paramBoolean)
      return decimalValue(); 
    double d = doubleValue();
    return Double.valueOf(d);
  }
  
  public abstract BigDecimal decimalValue();
  
  public double doubleValue() {
    return Double.parseDouble(numberString());
  }
  
  public float floatValue() {
    String str = numberString();
    float f = Float.parseFloat(str);
    if (f == 0.0F || f == Float.POSITIVE_INFINITY) {
      char c = str.charAt(0);
      if (c > '0' && c <= '9') {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("float overflow : ");
        stringBuilder.append(str);
        throw new JSONException(stringBuilder.toString());
      } 
    } 
    return f;
  }
  
  public Calendar getCalendar() {
    return this.calendar;
  }
  
  public final char getCurrent() {
    return this.ch;
  }
  
  public Locale getLocale() {
    return this.locale;
  }
  
  public TimeZone getTimeZone() {
    return this.timeZone;
  }
  
  public abstract int indexOf(char paramChar, int paramInt);
  
  public String info() {
    return "";
  }
  
  public final int intValue() {
    boolean bool;
    int n;
    int i = this.np;
    int j = 0;
    if (i == -1)
      this.np = 0; 
    int k = this.np;
    int m = this.np + this.sp;
    if (charAt(this.np) == '-') {
      k++;
      bool = true;
      n = Integer.MIN_VALUE;
    } else {
      bool = false;
      n = -2147483647;
    } 
    i = k;
    if (k < m) {
      j = -(charAt(k) - 48);
      i = k + 1;
    } 
    while (true) {
      k = i;
      if (i < m) {
        k = i + 1;
        i = charAt(i);
        if (i == 76 || i == 83 || i == 66)
          break; 
        i -= 48;
        if (j >= -214748364L) {
          j *= 10;
          if (j >= n + i) {
            j -= i;
            i = k;
            continue;
          } 
          throw new NumberFormatException(numberString());
        } 
        throw new NumberFormatException(numberString());
      } 
      break;
    } 
    if (bool) {
      if (k > this.np + 1)
        return j; 
      throw new NumberFormatException(numberString());
    } 
    return -j;
  }
  
  public final Number integerValue() throws NumberFormatException {
    long l1;
    int i = this.np;
    boolean bool = false;
    if (i == -1)
      this.np = 0; 
    int j = this.np;
    i = this.np + this.sp;
    byte b = 32;
    char c = charAt(i - 1);
    if (c != 'B') {
      if (c != 'L') {
        if (c == 'S') {
          i--;
          b = 83;
        } 
      } else {
        i--;
        b = 76;
      } 
    } else {
      i--;
      b = 66;
    } 
    if (charAt(this.np) == '-') {
      l1 = Long.MIN_VALUE;
      j++;
      bool = true;
    } else {
      l1 = -9223372036854775807L;
    } 
    if (j < i) {
      l2 = -(charAt(j) - 48);
      j++;
    } else {
      l2 = 0L;
    } 
    while (j < i) {
      c = charAt(j);
      if (l2 < -922337203685477580L)
        return new BigInteger(numberString()); 
      long l = l2 * 10L;
      l2 = (c - 48);
      if (l < l1 + l2)
        return new BigInteger(numberString()); 
      l2 = l - l2;
      j++;
    } 
    if (bool) {
      if (j > this.np + 1)
        return (Number)((l2 >= -2147483648L && b != 76) ? ((b == 83) ? Short.valueOf((short)(int)l2) : ((b == 66) ? Byte.valueOf((byte)(int)l2) : Integer.valueOf((int)l2))) : Long.valueOf(l2)); 
      throw new NumberFormatException(numberString());
    } 
    long l2 = -l2;
    return (Number)((l2 <= 2147483647L && b != 76) ? ((b == 83) ? Short.valueOf((short)(int)l2) : ((b == 66) ? Byte.valueOf((byte)(int)l2) : Integer.valueOf((int)l2))) : Long.valueOf(l2));
  }
  
  public boolean isBlankInput() {
    for (byte b = 0;; b++) {
      char c = charAt(b);
      if (c == '\032') {
        this.token = 20;
        return true;
      } 
      if (!isWhitespace(c))
        return false; 
    } 
  }
  
  public abstract boolean isEOF();
  
  public final boolean isEnabled(int paramInt) {
    boolean bool;
    if ((paramInt & this.features) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isEnabled(int paramInt1, int paramInt2) {
    return ((this.features & paramInt2) != 0 || (paramInt1 & paramInt2) != 0);
  }
  
  public final boolean isEnabled(Feature paramFeature) {
    return isEnabled(paramFeature.mask);
  }
  
  public final boolean isRef() {
    int i = this.sp;
    boolean bool1 = false;
    if (i != 4)
      return false; 
    boolean bool2 = bool1;
    if (charAt(this.np + 1) == '$') {
      bool2 = bool1;
      if (charAt(this.np + 2) == 'r') {
        bool2 = bool1;
        if (charAt(this.np + 3) == 'e') {
          bool2 = bool1;
          if (charAt(this.np + 4) == 'f')
            bool2 = true; 
        } 
      } 
    } 
    return bool2;
  }
  
  protected void lexError(String paramString, Object... paramVarArgs) {
    this.token = 1;
  }
  
  public final long longValue() throws NumberFormatException {
    long l1;
    int k;
    long l2;
    int i = this.np;
    boolean bool = false;
    if (i == -1)
      this.np = 0; 
    i = this.np;
    int j = this.np + this.sp;
    if (charAt(this.np) == '-') {
      l1 = Long.MIN_VALUE;
      i++;
      bool = true;
    } else {
      l1 = -9223372036854775807L;
    } 
    if (i < j) {
      k = i + 1;
      l2 = -(charAt(i) - 48);
      i = k;
    } else {
      l2 = 0L;
    } 
    while (true) {
      k = i;
      if (i < j) {
        k = i + 1;
        i = charAt(i);
        if (i == 76 || i == 83 || i == 66)
          break; 
        if (l2 >= -922337203685477580L) {
          l2 *= 10L;
          long l = (i - 48);
          if (l2 >= l1 + l) {
            l2 -= l;
            i = k;
            continue;
          } 
          throw new NumberFormatException(numberString());
        } 
        throw new NumberFormatException(numberString());
      } 
      break;
    } 
    if (bool) {
      if (k > this.np + 1)
        return l2; 
      throw new NumberFormatException(numberString());
    } 
    return -l2;
  }
  
  public final boolean matchField(char[] paramArrayOfchar) {
    if (!charArrayCompare(paramArrayOfchar))
      return false; 
    this.bp += paramArrayOfchar.length;
    this.ch = charAt(this.bp);
    if (this.ch == '{') {
      next();
      this.token = 12;
    } else if (this.ch == '[') {
      next();
      this.token = 14;
    } else if (this.ch == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
      this.bp += 3;
      this.ch = charAt(this.bp);
      this.token = 21;
    } else {
      nextToken();
    } 
    return true;
  }
  
  public final int matchStat() {
    return this.matchStat;
  }
  
  public Collection<String> newCollectionByType(Class<?> paramClass) {
    if (paramClass.isAssignableFrom(HashSet.class))
      return new HashSet<String>(); 
    if (paramClass.isAssignableFrom(ArrayList.class))
      return new ArrayList<String>(); 
    try {
      return (Collection)paramClass.newInstance();
    } catch (Exception exception) {
      throw new JSONException(exception.getMessage(), exception);
    } 
  }
  
  public abstract char next();
  
  public final void nextIdent() {
    while (isWhitespace(this.ch))
      next(); 
    if (this.ch == '_' || Character.isLetter(this.ch)) {
      scanIdent();
      return;
    } 
    nextToken();
  }
  
  public final void nextToken() {
    this.sp = 0;
    while (true) {
      this.pos = this.bp;
      if (this.ch == '/') {
        skipComment();
        continue;
      } 
      if (this.ch == '"') {
        scanString();
        return;
      } 
      if (this.ch == ',') {
        next();
        this.token = 16;
        return;
      } 
      if (this.ch >= '0' && this.ch <= '9') {
        scanNumber();
        return;
      } 
      if (this.ch == '-') {
        scanNumber();
        return;
      } 
      switch (this.ch) {
        default:
          if (isEOF()) {
            if (this.token != 20) {
              this.token = 20;
              int i = this.eofPos;
              this.bp = i;
              this.pos = i;
            } else {
              throw new JSONException("EOF error");
            } 
            return;
          } 
          break;
        case '}':
          next();
          this.token = 13;
          return;
        case '{':
          next();
          this.token = 12;
          return;
        case 'x':
          scanHex();
          return;
        case 't':
          scanTrue();
          return;
        case 'n':
          scanNullOrNew();
          return;
        case 'f':
          scanFalse();
          return;
        case ']':
          next();
          this.token = 15;
          return;
        case '[':
          next();
          this.token = 14;
          return;
        case 'N':
        case 'S':
        case 'T':
        case 'u':
          scanIdent();
          return;
        case ';':
          next();
          this.token = 24;
          return;
        case ':':
          next();
          this.token = 17;
          return;
        case '.':
          next();
          this.token = 25;
          return;
        case '+':
          next();
          scanNumber();
          return;
        case ')':
          next();
          this.token = 11;
          return;
        case '(':
          next();
          this.token = 10;
          return;
        case '\'':
          if (isEnabled(Feature.AllowSingleQuotes)) {
            scanStringSingleQuote();
            return;
          } 
          throw new JSONException("Feature.AllowSingleQuotes is false");
        case '\b':
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
          next();
          continue;
      } 
      if (this.ch <= '\037' || this.ch == '') {
        next();
        continue;
      } 
      lexError("illegal.char", new Object[] { String.valueOf(this.ch) });
      next();
      return;
    } 
  }
  
  public final void nextToken(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield sp : I
    //   5: iload_1
    //   6: iconst_2
    //   7: if_icmpeq -> 363
    //   10: iload_1
    //   11: iconst_4
    //   12: if_icmpeq -> 268
    //   15: iload_1
    //   16: bipush #12
    //   18: if_icmpeq -> 226
    //   21: iload_1
    //   22: bipush #18
    //   24: if_icmpeq -> 221
    //   27: iload_1
    //   28: bipush #20
    //   30: if_icmpeq -> 205
    //   33: iload_1
    //   34: tableswitch default -> 60, 14 -> 163, 15 -> 142, 16 -> 63
    //   60: goto -> 458
    //   63: aload_0
    //   64: getfield ch : C
    //   67: bipush #44
    //   69: if_icmpne -> 84
    //   72: aload_0
    //   73: bipush #16
    //   75: putfield token : I
    //   78: aload_0
    //   79: invokevirtual next : ()C
    //   82: pop
    //   83: return
    //   84: aload_0
    //   85: getfield ch : C
    //   88: bipush #125
    //   90: if_icmpne -> 105
    //   93: aload_0
    //   94: bipush #13
    //   96: putfield token : I
    //   99: aload_0
    //   100: invokevirtual next : ()C
    //   103: pop
    //   104: return
    //   105: aload_0
    //   106: getfield ch : C
    //   109: bipush #93
    //   111: if_icmpne -> 126
    //   114: aload_0
    //   115: bipush #15
    //   117: putfield token : I
    //   120: aload_0
    //   121: invokevirtual next : ()C
    //   124: pop
    //   125: return
    //   126: aload_0
    //   127: getfield ch : C
    //   130: bipush #26
    //   132: if_icmpne -> 458
    //   135: aload_0
    //   136: bipush #20
    //   138: putfield token : I
    //   141: return
    //   142: aload_0
    //   143: getfield ch : C
    //   146: bipush #93
    //   148: if_icmpne -> 205
    //   151: aload_0
    //   152: bipush #15
    //   154: putfield token : I
    //   157: aload_0
    //   158: invokevirtual next : ()C
    //   161: pop
    //   162: return
    //   163: aload_0
    //   164: getfield ch : C
    //   167: bipush #91
    //   169: if_icmpne -> 184
    //   172: aload_0
    //   173: bipush #14
    //   175: putfield token : I
    //   178: aload_0
    //   179: invokevirtual next : ()C
    //   182: pop
    //   183: return
    //   184: aload_0
    //   185: getfield ch : C
    //   188: bipush #123
    //   190: if_icmpne -> 458
    //   193: aload_0
    //   194: bipush #12
    //   196: putfield token : I
    //   199: aload_0
    //   200: invokevirtual next : ()C
    //   203: pop
    //   204: return
    //   205: aload_0
    //   206: getfield ch : C
    //   209: bipush #26
    //   211: if_icmpne -> 458
    //   214: aload_0
    //   215: bipush #20
    //   217: putfield token : I
    //   220: return
    //   221: aload_0
    //   222: invokevirtual nextIdent : ()V
    //   225: return
    //   226: aload_0
    //   227: getfield ch : C
    //   230: bipush #123
    //   232: if_icmpne -> 247
    //   235: aload_0
    //   236: bipush #12
    //   238: putfield token : I
    //   241: aload_0
    //   242: invokevirtual next : ()C
    //   245: pop
    //   246: return
    //   247: aload_0
    //   248: getfield ch : C
    //   251: bipush #91
    //   253: if_icmpne -> 458
    //   256: aload_0
    //   257: bipush #14
    //   259: putfield token : I
    //   262: aload_0
    //   263: invokevirtual next : ()C
    //   266: pop
    //   267: return
    //   268: aload_0
    //   269: getfield ch : C
    //   272: bipush #34
    //   274: if_icmpne -> 290
    //   277: aload_0
    //   278: aload_0
    //   279: getfield bp : I
    //   282: putfield pos : I
    //   285: aload_0
    //   286: invokevirtual scanString : ()V
    //   289: return
    //   290: aload_0
    //   291: getfield ch : C
    //   294: bipush #48
    //   296: if_icmplt -> 321
    //   299: aload_0
    //   300: getfield ch : C
    //   303: bipush #57
    //   305: if_icmpgt -> 321
    //   308: aload_0
    //   309: aload_0
    //   310: getfield bp : I
    //   313: putfield pos : I
    //   316: aload_0
    //   317: invokevirtual scanNumber : ()V
    //   320: return
    //   321: aload_0
    //   322: getfield ch : C
    //   325: bipush #91
    //   327: if_icmpne -> 342
    //   330: aload_0
    //   331: bipush #14
    //   333: putfield token : I
    //   336: aload_0
    //   337: invokevirtual next : ()C
    //   340: pop
    //   341: return
    //   342: aload_0
    //   343: getfield ch : C
    //   346: bipush #123
    //   348: if_icmpne -> 458
    //   351: aload_0
    //   352: bipush #12
    //   354: putfield token : I
    //   357: aload_0
    //   358: invokevirtual next : ()C
    //   361: pop
    //   362: return
    //   363: aload_0
    //   364: getfield ch : C
    //   367: bipush #48
    //   369: if_icmplt -> 394
    //   372: aload_0
    //   373: getfield ch : C
    //   376: bipush #57
    //   378: if_icmpgt -> 394
    //   381: aload_0
    //   382: aload_0
    //   383: getfield bp : I
    //   386: putfield pos : I
    //   389: aload_0
    //   390: invokevirtual scanNumber : ()V
    //   393: return
    //   394: aload_0
    //   395: getfield ch : C
    //   398: bipush #34
    //   400: if_icmpne -> 416
    //   403: aload_0
    //   404: aload_0
    //   405: getfield bp : I
    //   408: putfield pos : I
    //   411: aload_0
    //   412: invokevirtual scanString : ()V
    //   415: return
    //   416: aload_0
    //   417: getfield ch : C
    //   420: bipush #91
    //   422: if_icmpne -> 437
    //   425: aload_0
    //   426: bipush #14
    //   428: putfield token : I
    //   431: aload_0
    //   432: invokevirtual next : ()C
    //   435: pop
    //   436: return
    //   437: aload_0
    //   438: getfield ch : C
    //   441: bipush #123
    //   443: if_icmpne -> 458
    //   446: aload_0
    //   447: bipush #12
    //   449: putfield token : I
    //   452: aload_0
    //   453: invokevirtual next : ()C
    //   456: pop
    //   457: return
    //   458: aload_0
    //   459: getfield ch : C
    //   462: bipush #32
    //   464: if_icmpeq -> 520
    //   467: aload_0
    //   468: getfield ch : C
    //   471: bipush #10
    //   473: if_icmpeq -> 520
    //   476: aload_0
    //   477: getfield ch : C
    //   480: bipush #13
    //   482: if_icmpeq -> 520
    //   485: aload_0
    //   486: getfield ch : C
    //   489: bipush #9
    //   491: if_icmpeq -> 520
    //   494: aload_0
    //   495: getfield ch : C
    //   498: bipush #12
    //   500: if_icmpeq -> 520
    //   503: aload_0
    //   504: getfield ch : C
    //   507: bipush #8
    //   509: if_icmpne -> 515
    //   512: goto -> 520
    //   515: aload_0
    //   516: invokevirtual nextToken : ()V
    //   519: return
    //   520: aload_0
    //   521: invokevirtual next : ()C
    //   524: pop
    //   525: goto -> 5
  }
  
  public final void nextTokenWithChar(char paramChar) {
    this.sp = 0;
    while (true) {
      if (this.ch == paramChar) {
        next();
        nextToken();
        return;
      } 
      if (this.ch == ' ' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
        next();
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not match ");
      stringBuilder.append(paramChar);
      stringBuilder.append(" - ");
      stringBuilder.append(this.ch);
      stringBuilder.append(", info : ");
      stringBuilder.append(info());
      throw new JSONException(stringBuilder.toString());
    } 
  }
  
  public final void nextTokenWithColon() {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithColon(int paramInt) {
    nextTokenWithChar(':');
  }
  
  public abstract String numberString();
  
  public final int pos() {
    return this.pos;
  }
  
  protected final void putChar(char paramChar) {
    if (this.sp == this.sbuf.length) {
      char[] arrayOfChar1 = new char[this.sbuf.length * 2];
      System.arraycopy(this.sbuf, 0, arrayOfChar1, 0, this.sbuf.length);
      this.sbuf = arrayOfChar1;
    } 
    char[] arrayOfChar = this.sbuf;
    int i = this.sp;
    this.sp = i + 1;
    arrayOfChar[i] = (char)paramChar;
  }
  
  public final void resetStringPosition() {
    this.sp = 0;
  }
  
  public boolean scanBoolean(char paramChar) {
    char c1;
    boolean bool = false;
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    byte b = 2;
    if (c == 't') {
      if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
        c = charAt(this.bp + 4);
        bool = true;
        b = 5;
        c1 = c;
      } else {
        this.matchStat = -1;
        return false;
      } 
    } else if (c == 'f') {
      if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
        c = charAt(this.bp + 5);
        b = 6;
        c1 = c;
      } else {
        this.matchStat = -1;
        return false;
      } 
    } else if (c == '1') {
      c = charAt(this.bp + 1);
      bool = true;
      c1 = c;
    } else if (c == '0') {
      c = charAt(this.bp + 1);
      c1 = c;
    } else {
      b = 1;
      c1 = c;
    } 
    while (true) {
      if (c1 == paramChar) {
        this.bp += b;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return bool;
      } 
      if (isWhitespace(c1)) {
        c = charAt(this.bp + b);
        b++;
        c1 = c;
        continue;
      } 
      this.matchStat = -1;
      return bool;
    } 
  }
  
  public final double scanDouble(char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c >= '0' && c <= '9') {
      int i;
      int k;
      int j = 1;
      while (true) {
        k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        if (j >= 48 && j <= 57) {
          j = i;
          continue;
        } 
        break;
      } 
      if (j == 46) {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i >= 48 && i <= 57) {
          i = j;
          while (true) {
            k = this.bp;
            j = i + 1;
            char c1 = charAt(k + i);
            k = j;
            i = c1;
            if (c1 >= '0') {
              k = j;
              i = c1;
              if (c1 <= '9') {
                i = j;
                continue;
              } 
            } 
            break;
          } 
        } else {
          this.matchStat = -1;
          return 0.0D;
        } 
      } else {
        k = i;
        i = j;
      } 
      j = this.bp;
      double d = Double.parseDouble(subString(j, this.bp + k - j - 1));
      if (i == paramChar) {
        this.bp += k;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return d;
      } 
      this.matchStat = -1;
      return d;
    } 
    this.matchStat = -1;
    return 0.0D;
  }
  
  public Enum<?> scanEnum(Class<?> paramClass, SymbolTable paramSymbolTable, char paramChar) {
    String str = scanSymbolWithSeperator(paramSymbolTable, paramChar);
    return (Enum<?>)((str == null) ? null : Enum.valueOf(paramClass, str));
  }
  
  public final void scanFalse() {
    if (this.ch == 'f') {
      next();
      if (this.ch == 'a') {
        next();
        if (this.ch == 'l') {
          next();
          if (this.ch == 's') {
            next();
            if (this.ch == 'e') {
              next();
              if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\032' || this.ch == '\f' || this.ch == '\b' || this.ch == ':' || this.ch == '/') {
                this.token = 7;
                return;
              } 
              throw new JSONException("scan false error");
            } 
            throw new JSONException("error parse false");
          } 
          throw new JSONException("error parse false");
        } 
        throw new JSONException("error parse false");
      } 
      throw new JSONException("error parse false");
    } 
    throw new JSONException("error parse false");
  }
  
  public boolean scanFieldBoolean(char[] paramArrayOfchar) {
    boolean bool;
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return false;
    } 
    int i = paramArrayOfchar.length;
    int j = this.bp;
    int k = i + 1;
    i = charAt(j + i);
    if (i == 116) {
      j = this.bp;
      i = k + 1;
      if (charAt(j + k) != 'r') {
        this.matchStat = -1;
        return false;
      } 
      k = this.bp;
      j = i + 1;
      if (charAt(k + i) != 'u') {
        this.matchStat = -1;
        return false;
      } 
      i = this.bp;
      k = j + 1;
      if (charAt(i + j) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      bool = true;
    } else if (i == 102) {
      j = this.bp;
      i = k + 1;
      if (charAt(j + k) != 'a') {
        this.matchStat = -1;
        return false;
      } 
      j = this.bp;
      k = i + 1;
      if (charAt(j + i) != 'l') {
        this.matchStat = -1;
        return false;
      } 
      j = this.bp;
      i = k + 1;
      if (charAt(j + k) != 's') {
        this.matchStat = -1;
        return false;
      } 
      if (charAt(this.bp + i) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      k = i + 1;
      bool = false;
    } else {
      this.matchStat = -1;
      return false;
    } 
    j = this.bp;
    i = k + 1;
    k = charAt(j + k);
    if (k == 44) {
      this.bp += i;
      this.ch = charAt(this.bp);
      this.matchStat = 3;
      this.token = 16;
      return bool;
    } 
    if (k == 125) {
      j = this.bp;
      k = i + 1;
      i = charAt(j + i);
      if (i == 44) {
        this.token = 16;
        this.bp += k;
        this.ch = charAt(this.bp);
      } else if (i == 93) {
        this.token = 15;
        this.bp += k;
        this.ch = charAt(this.bp);
      } else if (i == 125) {
        this.token = 13;
        this.bp += k;
        this.ch = charAt(this.bp);
      } else {
        if (i == 26) {
          this.token = 20;
          this.bp += k - 1;
          this.ch = (char)'\032';
          this.matchStat = 4;
          return bool;
        } 
        this.matchStat = -1;
        return false;
      } 
      this.matchStat = 4;
      return bool;
    } 
    this.matchStat = -1;
    return false;
  }
  
  public final double scanFieldDouble(char[] paramArrayOfchar) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual charArrayCompare : ([C)Z
    //   10: ifne -> 21
    //   13: aload_0
    //   14: bipush #-2
    //   16: putfield matchStat : I
    //   19: dconst_0
    //   20: dreturn
    //   21: aload_1
    //   22: arraylength
    //   23: istore_2
    //   24: aload_0
    //   25: getfield bp : I
    //   28: istore_3
    //   29: iload_2
    //   30: iconst_1
    //   31: iadd
    //   32: istore #4
    //   34: aload_0
    //   35: iload_3
    //   36: iload_2
    //   37: iadd
    //   38: invokevirtual charAt : (I)C
    //   41: istore_3
    //   42: iload_3
    //   43: bipush #48
    //   45: if_icmplt -> 600
    //   48: iload_3
    //   49: bipush #57
    //   51: if_icmpgt -> 600
    //   54: aload_0
    //   55: getfield bp : I
    //   58: istore_3
    //   59: iload #4
    //   61: iconst_1
    //   62: iadd
    //   63: istore_2
    //   64: aload_0
    //   65: iload_3
    //   66: iload #4
    //   68: iadd
    //   69: invokevirtual charAt : (I)C
    //   72: istore #5
    //   74: iload #5
    //   76: bipush #48
    //   78: if_icmplt -> 94
    //   81: iload #5
    //   83: bipush #57
    //   85: if_icmpgt -> 94
    //   88: iload_2
    //   89: istore #4
    //   91: goto -> 54
    //   94: iload #5
    //   96: istore_3
    //   97: iload_2
    //   98: istore #4
    //   100: iload #5
    //   102: bipush #46
    //   104: if_icmpne -> 196
    //   107: aload_0
    //   108: getfield bp : I
    //   111: istore_3
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore #4
    //   117: aload_0
    //   118: iload_3
    //   119: iload_2
    //   120: iadd
    //   121: invokevirtual charAt : (I)C
    //   124: istore_3
    //   125: iload_3
    //   126: bipush #48
    //   128: if_icmplt -> 189
    //   131: iload_3
    //   132: bipush #57
    //   134: if_icmpgt -> 189
    //   137: aload_0
    //   138: getfield bp : I
    //   141: istore_3
    //   142: iload #4
    //   144: iconst_1
    //   145: iadd
    //   146: istore_2
    //   147: aload_0
    //   148: iload_3
    //   149: iload #4
    //   151: iadd
    //   152: invokevirtual charAt : (I)C
    //   155: istore #5
    //   157: iload #5
    //   159: istore_3
    //   160: iload_2
    //   161: istore #4
    //   163: iload #5
    //   165: bipush #48
    //   167: if_icmplt -> 196
    //   170: iload #5
    //   172: istore_3
    //   173: iload_2
    //   174: istore #4
    //   176: iload #5
    //   178: bipush #57
    //   180: if_icmpgt -> 196
    //   183: iload_2
    //   184: istore #4
    //   186: goto -> 137
    //   189: aload_0
    //   190: iconst_m1
    //   191: putfield matchStat : I
    //   194: dconst_0
    //   195: dreturn
    //   196: iload_3
    //   197: bipush #101
    //   199: if_icmpeq -> 214
    //   202: iload_3
    //   203: istore #5
    //   205: iload #4
    //   207: istore_2
    //   208: iload_3
    //   209: bipush #69
    //   211: if_icmpne -> 333
    //   214: aload_0
    //   215: getfield bp : I
    //   218: istore_3
    //   219: iload #4
    //   221: iconst_1
    //   222: iadd
    //   223: istore_2
    //   224: aload_0
    //   225: iload_3
    //   226: iload #4
    //   228: iadd
    //   229: invokevirtual charAt : (I)C
    //   232: istore #5
    //   234: iload #5
    //   236: bipush #43
    //   238: if_icmpeq -> 268
    //   241: iload #5
    //   243: istore #4
    //   245: iload_2
    //   246: istore_3
    //   247: iload #5
    //   249: bipush #45
    //   251: if_icmpne -> 257
    //   254: goto -> 268
    //   257: iload_3
    //   258: istore_2
    //   259: iload #4
    //   261: istore_3
    //   262: iload_2
    //   263: istore #4
    //   265: goto -> 286
    //   268: aload_0
    //   269: getfield bp : I
    //   272: istore_3
    //   273: iload_2
    //   274: iconst_1
    //   275: iadd
    //   276: istore #4
    //   278: aload_0
    //   279: iload_3
    //   280: iload_2
    //   281: iadd
    //   282: invokevirtual charAt : (I)C
    //   285: istore_3
    //   286: iload_3
    //   287: istore #5
    //   289: iload #4
    //   291: istore_2
    //   292: iload_3
    //   293: bipush #48
    //   295: if_icmplt -> 333
    //   298: iload_3
    //   299: istore #5
    //   301: iload #4
    //   303: istore_2
    //   304: iload_3
    //   305: bipush #57
    //   307: if_icmpgt -> 333
    //   310: aload_0
    //   311: getfield bp : I
    //   314: istore_2
    //   315: iload #4
    //   317: iconst_1
    //   318: iadd
    //   319: istore_3
    //   320: aload_0
    //   321: iload_2
    //   322: iload #4
    //   324: iadd
    //   325: invokevirtual charAt : (I)C
    //   328: istore #4
    //   330: goto -> 257
    //   333: aload_0
    //   334: getfield bp : I
    //   337: aload_1
    //   338: arraylength
    //   339: iadd
    //   340: istore #4
    //   342: aload_0
    //   343: iload #4
    //   345: aload_0
    //   346: getfield bp : I
    //   349: iload_2
    //   350: iadd
    //   351: iload #4
    //   353: isub
    //   354: iconst_1
    //   355: isub
    //   356: invokevirtual subString : (II)Ljava/lang/String;
    //   359: invokestatic parseDouble : (Ljava/lang/String;)D
    //   362: dstore #6
    //   364: iload #5
    //   366: bipush #44
    //   368: if_icmpne -> 407
    //   371: aload_0
    //   372: aload_0
    //   373: getfield bp : I
    //   376: iload_2
    //   377: iadd
    //   378: putfield bp : I
    //   381: aload_0
    //   382: aload_0
    //   383: aload_0
    //   384: getfield bp : I
    //   387: invokevirtual charAt : (I)C
    //   390: putfield ch : C
    //   393: aload_0
    //   394: iconst_3
    //   395: putfield matchStat : I
    //   398: aload_0
    //   399: bipush #16
    //   401: putfield token : I
    //   404: dload #6
    //   406: dreturn
    //   407: iload #5
    //   409: bipush #125
    //   411: if_icmpne -> 593
    //   414: aload_0
    //   415: getfield bp : I
    //   418: istore_3
    //   419: iload_2
    //   420: iconst_1
    //   421: iadd
    //   422: istore #4
    //   424: aload_0
    //   425: iload_3
    //   426: iload_2
    //   427: iadd
    //   428: invokevirtual charAt : (I)C
    //   431: istore_3
    //   432: iload_3
    //   433: bipush #44
    //   435: if_icmpne -> 470
    //   438: aload_0
    //   439: bipush #16
    //   441: putfield token : I
    //   444: aload_0
    //   445: aload_0
    //   446: getfield bp : I
    //   449: iload #4
    //   451: iadd
    //   452: putfield bp : I
    //   455: aload_0
    //   456: aload_0
    //   457: aload_0
    //   458: getfield bp : I
    //   461: invokevirtual charAt : (I)C
    //   464: putfield ch : C
    //   467: goto -> 578
    //   470: iload_3
    //   471: bipush #93
    //   473: if_icmpne -> 508
    //   476: aload_0
    //   477: bipush #15
    //   479: putfield token : I
    //   482: aload_0
    //   483: aload_0
    //   484: getfield bp : I
    //   487: iload #4
    //   489: iadd
    //   490: putfield bp : I
    //   493: aload_0
    //   494: aload_0
    //   495: aload_0
    //   496: getfield bp : I
    //   499: invokevirtual charAt : (I)C
    //   502: putfield ch : C
    //   505: goto -> 578
    //   508: iload_3
    //   509: bipush #125
    //   511: if_icmpne -> 546
    //   514: aload_0
    //   515: bipush #13
    //   517: putfield token : I
    //   520: aload_0
    //   521: aload_0
    //   522: getfield bp : I
    //   525: iload #4
    //   527: iadd
    //   528: putfield bp : I
    //   531: aload_0
    //   532: aload_0
    //   533: aload_0
    //   534: getfield bp : I
    //   537: invokevirtual charAt : (I)C
    //   540: putfield ch : C
    //   543: goto -> 578
    //   546: iload_3
    //   547: bipush #26
    //   549: if_icmpne -> 586
    //   552: aload_0
    //   553: bipush #20
    //   555: putfield token : I
    //   558: aload_0
    //   559: aload_0
    //   560: getfield bp : I
    //   563: iload #4
    //   565: iconst_1
    //   566: isub
    //   567: iadd
    //   568: putfield bp : I
    //   571: aload_0
    //   572: bipush #26
    //   574: i2c
    //   575: putfield ch : C
    //   578: aload_0
    //   579: iconst_4
    //   580: putfield matchStat : I
    //   583: dload #6
    //   585: dreturn
    //   586: aload_0
    //   587: iconst_m1
    //   588: putfield matchStat : I
    //   591: dconst_0
    //   592: dreturn
    //   593: aload_0
    //   594: iconst_m1
    //   595: putfield matchStat : I
    //   598: dconst_0
    //   599: dreturn
    //   600: aload_0
    //   601: iconst_m1
    //   602: putfield matchStat : I
    //   605: dconst_0
    //   606: dreturn
  }
  
  public final float scanFieldFloat(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return 0.0F;
    } 
    int i = paramArrayOfchar.length;
    int j = this.bp;
    int k = i + 1;
    j = charAt(j + i);
    if (j >= 48 && j <= 57) {
      char c;
      while (true) {
        i = this.bp;
        j = k + 1;
        c = charAt(i + k);
        if (c >= '0' && c <= '9') {
          k = j;
          continue;
        } 
        break;
      } 
      i = c;
      k = j;
      if (c == '.') {
        i = this.bp;
        k = j + 1;
        j = charAt(i + j);
        if (j >= 48 && j <= 57) {
          while (true) {
            i = this.bp;
            j = k + 1;
            c = charAt(i + k);
            i = c;
            k = j;
            if (c >= '0') {
              i = c;
              k = j;
              if (c <= '9') {
                k = j;
                continue;
              } 
            } 
            break;
          } 
        } else {
          this.matchStat = -1;
          return 0.0F;
        } 
      } 
      j = this.bp + paramArrayOfchar.length;
      float f = Float.parseFloat(subString(j, this.bp + k - j - 1));
      if (i == 44) {
        this.bp += k;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return f;
      } 
      if (i == 125) {
        i = this.bp;
        j = k + 1;
        k = charAt(i + k);
        if (k == 44) {
          this.token = 16;
          this.bp += j;
          this.ch = charAt(this.bp);
        } else if (k == 93) {
          this.token = 15;
          this.bp += j;
          this.ch = charAt(this.bp);
        } else if (k == 125) {
          this.token = 13;
          this.bp += j;
          this.ch = charAt(this.bp);
        } else {
          if (k == 26) {
            this.bp += j - 1;
            this.token = 20;
            this.ch = (char)'\032';
            this.matchStat = 4;
            return f;
          } 
          this.matchStat = -1;
          return 0.0F;
        } 
        this.matchStat = 4;
        return f;
      } 
      this.matchStat = -1;
      return 0.0F;
    } 
    this.matchStat = -1;
    return 0.0F;
  }
  
  public final float[] scanFieldFloatArray(char[] paramArrayOfchar) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual charArrayCompare : ([C)Z
    //   10: ifne -> 21
    //   13: aload_0
    //   14: bipush #-2
    //   16: putfield matchStat : I
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: arraylength
    //   23: istore_2
    //   24: aload_0
    //   25: getfield bp : I
    //   28: istore_3
    //   29: iload_2
    //   30: iconst_1
    //   31: iadd
    //   32: istore #4
    //   34: aload_0
    //   35: iload_3
    //   36: iload_2
    //   37: iadd
    //   38: invokevirtual charAt : (I)C
    //   41: bipush #91
    //   43: if_icmpeq -> 54
    //   46: aload_0
    //   47: bipush #-2
    //   49: putfield matchStat : I
    //   52: aconst_null
    //   53: areturn
    //   54: aload_0
    //   55: getfield bp : I
    //   58: istore_3
    //   59: iload #4
    //   61: iconst_1
    //   62: iadd
    //   63: istore_2
    //   64: aload_0
    //   65: iload_3
    //   66: iload #4
    //   68: iadd
    //   69: invokevirtual charAt : (I)C
    //   72: istore #5
    //   74: bipush #16
    //   76: newarray float
    //   78: astore_1
    //   79: iconst_0
    //   80: istore #4
    //   82: aload_0
    //   83: getfield bp : I
    //   86: iload_2
    //   87: iadd
    //   88: iconst_1
    //   89: isub
    //   90: istore #6
    //   92: iload #5
    //   94: bipush #45
    //   96: if_icmpne -> 104
    //   99: iconst_1
    //   100: istore_3
    //   101: goto -> 106
    //   104: iconst_0
    //   105: istore_3
    //   106: iload #5
    //   108: istore #7
    //   110: iload_2
    //   111: istore #5
    //   113: iload_3
    //   114: ifeq -> 134
    //   117: aload_0
    //   118: aload_0
    //   119: getfield bp : I
    //   122: iload_2
    //   123: iadd
    //   124: invokevirtual charAt : (I)C
    //   127: istore #7
    //   129: iload_2
    //   130: iconst_1
    //   131: iadd
    //   132: istore #5
    //   134: iload #7
    //   136: bipush #48
    //   138: if_icmplt -> 1037
    //   141: iload #7
    //   143: bipush #57
    //   145: if_icmpgt -> 1037
    //   148: iinc #7, -48
    //   151: iload #5
    //   153: istore_2
    //   154: iload #7
    //   156: istore #5
    //   158: aload_0
    //   159: getfield bp : I
    //   162: istore #7
    //   164: iload_2
    //   165: iconst_1
    //   166: iadd
    //   167: istore #8
    //   169: aload_0
    //   170: iload #7
    //   172: iload_2
    //   173: iadd
    //   174: invokevirtual charAt : (I)C
    //   177: istore #9
    //   179: iload #9
    //   181: bipush #48
    //   183: if_icmplt -> 212
    //   186: iload #9
    //   188: bipush #57
    //   190: if_icmpgt -> 212
    //   193: iload #5
    //   195: bipush #10
    //   197: imul
    //   198: iload #9
    //   200: bipush #48
    //   202: isub
    //   203: iadd
    //   204: istore #5
    //   206: iload #8
    //   208: istore_2
    //   209: goto -> 158
    //   212: iload #9
    //   214: bipush #46
    //   216: if_icmpne -> 224
    //   219: iconst_1
    //   220: istore_2
    //   221: goto -> 226
    //   224: iconst_0
    //   225: istore_2
    //   226: iload_2
    //   227: ifeq -> 381
    //   230: aload_0
    //   231: getfield bp : I
    //   234: istore #7
    //   236: iload #8
    //   238: iconst_1
    //   239: iadd
    //   240: istore_2
    //   241: aload_0
    //   242: iload #7
    //   244: iload #8
    //   246: iadd
    //   247: invokevirtual charAt : (I)C
    //   250: istore #7
    //   252: iload #7
    //   254: bipush #48
    //   256: if_icmplt -> 374
    //   259: iload #7
    //   261: bipush #57
    //   263: if_icmpgt -> 374
    //   266: iload #5
    //   268: bipush #10
    //   270: imul
    //   271: iload #7
    //   273: bipush #48
    //   275: isub
    //   276: iadd
    //   277: istore #10
    //   279: bipush #10
    //   281: istore #7
    //   283: aload_0
    //   284: getfield bp : I
    //   287: istore #5
    //   289: iload_2
    //   290: iconst_1
    //   291: iadd
    //   292: istore #11
    //   294: aload_0
    //   295: iload #5
    //   297: iload_2
    //   298: iadd
    //   299: invokevirtual charAt : (I)C
    //   302: istore #12
    //   304: iload #12
    //   306: istore #9
    //   308: iload #10
    //   310: istore #5
    //   312: iload #7
    //   314: istore_2
    //   315: iload #11
    //   317: istore #8
    //   319: iload #12
    //   321: bipush #48
    //   323: if_icmplt -> 383
    //   326: iload #12
    //   328: istore #9
    //   330: iload #10
    //   332: istore #5
    //   334: iload #7
    //   336: istore_2
    //   337: iload #11
    //   339: istore #8
    //   341: iload #12
    //   343: bipush #57
    //   345: if_icmpgt -> 383
    //   348: iload #10
    //   350: bipush #10
    //   352: imul
    //   353: iload #12
    //   355: bipush #48
    //   357: isub
    //   358: iadd
    //   359: istore #10
    //   361: iload #7
    //   363: bipush #10
    //   365: imul
    //   366: istore #7
    //   368: iload #11
    //   370: istore_2
    //   371: goto -> 283
    //   374: aload_0
    //   375: iconst_m1
    //   376: putfield matchStat : I
    //   379: aconst_null
    //   380: areturn
    //   381: iconst_1
    //   382: istore_2
    //   383: iload #9
    //   385: bipush #101
    //   387: if_icmpeq -> 406
    //   390: iload #9
    //   392: bipush #69
    //   394: if_icmpne -> 400
    //   397: goto -> 406
    //   400: iconst_0
    //   401: istore #7
    //   403: goto -> 409
    //   406: iconst_1
    //   407: istore #7
    //   409: iload #5
    //   411: istore #13
    //   413: iload_2
    //   414: istore #14
    //   416: iload #4
    //   418: istore #12
    //   420: aload_1
    //   421: astore #15
    //   423: iload_3
    //   424: istore #16
    //   426: iload #7
    //   428: istore #17
    //   430: iload #8
    //   432: istore #10
    //   434: iload #7
    //   436: ifeq -> 611
    //   439: aload_0
    //   440: getfield bp : I
    //   443: istore #10
    //   445: iload #8
    //   447: iconst_1
    //   448: iadd
    //   449: istore #9
    //   451: aload_0
    //   452: iload #10
    //   454: iload #8
    //   456: iadd
    //   457: invokevirtual charAt : (I)C
    //   460: istore #11
    //   462: iload #11
    //   464: bipush #43
    //   466: if_icmpeq -> 486
    //   469: iload #11
    //   471: bipush #45
    //   473: if_icmpne -> 479
    //   476: goto -> 486
    //   479: iload #9
    //   481: istore #8
    //   483: goto -> 513
    //   486: aload_0
    //   487: getfield bp : I
    //   490: istore #8
    //   492: iload #9
    //   494: iconst_1
    //   495: iadd
    //   496: istore #10
    //   498: aload_0
    //   499: iload #8
    //   501: iload #9
    //   503: iadd
    //   504: invokevirtual charAt : (I)C
    //   507: istore #11
    //   509: iload #10
    //   511: istore #8
    //   513: iload #11
    //   515: istore #9
    //   517: iload #5
    //   519: istore #13
    //   521: iload_2
    //   522: istore #14
    //   524: iload #4
    //   526: istore #12
    //   528: aload_1
    //   529: astore #15
    //   531: iload_3
    //   532: istore #16
    //   534: iload #7
    //   536: istore #17
    //   538: iload #8
    //   540: istore #10
    //   542: iload #11
    //   544: bipush #48
    //   546: if_icmplt -> 611
    //   549: iload #11
    //   551: istore #9
    //   553: iload #5
    //   555: istore #13
    //   557: iload_2
    //   558: istore #14
    //   560: iload #4
    //   562: istore #12
    //   564: aload_1
    //   565: astore #15
    //   567: iload_3
    //   568: istore #16
    //   570: iload #7
    //   572: istore #17
    //   574: iload #8
    //   576: istore #10
    //   578: iload #11
    //   580: bipush #57
    //   582: if_icmpgt -> 611
    //   585: aload_0
    //   586: getfield bp : I
    //   589: istore #9
    //   591: iload #8
    //   593: iconst_1
    //   594: iadd
    //   595: istore #10
    //   597: aload_0
    //   598: iload #9
    //   600: iload #8
    //   602: iadd
    //   603: invokevirtual charAt : (I)C
    //   606: istore #11
    //   608: goto -> 509
    //   611: aload_0
    //   612: getfield bp : I
    //   615: iload #10
    //   617: iadd
    //   618: iload #6
    //   620: isub
    //   621: iconst_1
    //   622: isub
    //   623: istore #4
    //   625: iload #17
    //   627: ifne -> 663
    //   630: iload #4
    //   632: bipush #10
    //   634: if_icmpge -> 663
    //   637: iload #13
    //   639: i2f
    //   640: iload #14
    //   642: i2f
    //   643: fdiv
    //   644: fstore #18
    //   646: fload #18
    //   648: fstore #19
    //   650: iload #16
    //   652: ifeq -> 676
    //   655: fload #18
    //   657: fneg
    //   658: fstore #19
    //   660: goto -> 676
    //   663: aload_0
    //   664: iload #6
    //   666: iload #4
    //   668: invokevirtual subString : (II)Ljava/lang/String;
    //   671: invokestatic parseFloat : (Ljava/lang/String;)F
    //   674: fstore #19
    //   676: aload #15
    //   678: astore_1
    //   679: iload #12
    //   681: aload #15
    //   683: arraylength
    //   684: if_icmplt -> 707
    //   687: aload #15
    //   689: arraylength
    //   690: iconst_3
    //   691: imul
    //   692: iconst_2
    //   693: idiv
    //   694: newarray float
    //   696: astore_1
    //   697: aload #15
    //   699: iconst_0
    //   700: aload_1
    //   701: iconst_0
    //   702: iload #12
    //   704: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   707: iload #12
    //   709: iconst_1
    //   710: iadd
    //   711: istore #7
    //   713: aload_1
    //   714: iload #12
    //   716: fload #19
    //   718: fastore
    //   719: iload #9
    //   721: bipush #44
    //   723: if_icmpne -> 747
    //   726: aload_0
    //   727: aload_0
    //   728: getfield bp : I
    //   731: iload #10
    //   733: iadd
    //   734: invokevirtual charAt : (I)C
    //   737: istore #4
    //   739: iload #10
    //   741: iconst_1
    //   742: iadd
    //   743: istore_3
    //   744: goto -> 1024
    //   747: iload #9
    //   749: istore #4
    //   751: iload #10
    //   753: istore_3
    //   754: iload #9
    //   756: bipush #93
    //   758: if_icmpne -> 744
    //   761: aload_0
    //   762: getfield bp : I
    //   765: istore_3
    //   766: iload #10
    //   768: iconst_1
    //   769: iadd
    //   770: istore #4
    //   772: aload_0
    //   773: iload_3
    //   774: iload #10
    //   776: iadd
    //   777: invokevirtual charAt : (I)C
    //   780: istore_3
    //   781: aload_1
    //   782: astore #15
    //   784: iload #7
    //   786: aload_1
    //   787: arraylength
    //   788: if_icmpeq -> 807
    //   791: iload #7
    //   793: newarray float
    //   795: astore #15
    //   797: aload_1
    //   798: iconst_0
    //   799: aload #15
    //   801: iconst_0
    //   802: iload #7
    //   804: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   807: iload_3
    //   808: bipush #44
    //   810: if_icmpne -> 845
    //   813: aload_0
    //   814: aload_0
    //   815: getfield bp : I
    //   818: iload #4
    //   820: iconst_1
    //   821: isub
    //   822: iadd
    //   823: putfield bp : I
    //   826: aload_0
    //   827: invokevirtual next : ()C
    //   830: pop
    //   831: aload_0
    //   832: iconst_3
    //   833: putfield matchStat : I
    //   836: aload_0
    //   837: bipush #16
    //   839: putfield token : I
    //   842: aload #15
    //   844: areturn
    //   845: iload_3
    //   846: bipush #125
    //   848: if_icmpne -> 1017
    //   851: aload_0
    //   852: getfield bp : I
    //   855: istore_2
    //   856: iload #4
    //   858: iconst_1
    //   859: iadd
    //   860: istore_3
    //   861: aload_0
    //   862: iload_2
    //   863: iload #4
    //   865: iadd
    //   866: invokevirtual charAt : (I)C
    //   869: istore #4
    //   871: iload #4
    //   873: bipush #44
    //   875: if_icmpne -> 904
    //   878: aload_0
    //   879: bipush #16
    //   881: putfield token : I
    //   884: aload_0
    //   885: aload_0
    //   886: getfield bp : I
    //   889: iload_3
    //   890: iconst_1
    //   891: isub
    //   892: iadd
    //   893: putfield bp : I
    //   896: aload_0
    //   897: invokevirtual next : ()C
    //   900: pop
    //   901: goto -> 1002
    //   904: iload #4
    //   906: bipush #93
    //   908: if_icmpne -> 937
    //   911: aload_0
    //   912: bipush #15
    //   914: putfield token : I
    //   917: aload_0
    //   918: aload_0
    //   919: getfield bp : I
    //   922: iload_3
    //   923: iconst_1
    //   924: isub
    //   925: iadd
    //   926: putfield bp : I
    //   929: aload_0
    //   930: invokevirtual next : ()C
    //   933: pop
    //   934: goto -> 1002
    //   937: iload #4
    //   939: bipush #125
    //   941: if_icmpne -> 970
    //   944: aload_0
    //   945: bipush #13
    //   947: putfield token : I
    //   950: aload_0
    //   951: aload_0
    //   952: getfield bp : I
    //   955: iload_3
    //   956: iconst_1
    //   957: isub
    //   958: iadd
    //   959: putfield bp : I
    //   962: aload_0
    //   963: invokevirtual next : ()C
    //   966: pop
    //   967: goto -> 1002
    //   970: iload #4
    //   972: bipush #26
    //   974: if_icmpne -> 1010
    //   977: aload_0
    //   978: aload_0
    //   979: getfield bp : I
    //   982: iload_3
    //   983: iconst_1
    //   984: isub
    //   985: iadd
    //   986: putfield bp : I
    //   989: aload_0
    //   990: bipush #20
    //   992: putfield token : I
    //   995: aload_0
    //   996: bipush #26
    //   998: i2c
    //   999: putfield ch : C
    //   1002: aload_0
    //   1003: iconst_4
    //   1004: putfield matchStat : I
    //   1007: aload #15
    //   1009: areturn
    //   1010: aload_0
    //   1011: iconst_m1
    //   1012: putfield matchStat : I
    //   1015: aconst_null
    //   1016: areturn
    //   1017: aload_0
    //   1018: iconst_m1
    //   1019: putfield matchStat : I
    //   1022: aconst_null
    //   1023: areturn
    //   1024: iload #4
    //   1026: istore #5
    //   1028: iload_3
    //   1029: istore_2
    //   1030: iload #7
    //   1032: istore #4
    //   1034: goto -> 82
    //   1037: aload_0
    //   1038: iconst_m1
    //   1039: putfield matchStat : I
    //   1042: aconst_null
    //   1043: areturn
  }
  
  public final float[][] scanFieldFloatArray2(char[] paramArrayOfchar) {
    this.matchStat = 0;
    boolean bool = charArrayCompare(paramArrayOfchar);
    char[] arrayOfChar = null;
    if (!bool) {
      this.matchStat = -2;
      return (float[][])null;
    } 
    int i = paramArrayOfchar.length;
    int j = this.bp;
    int k = i + 1;
    if (charAt(j + i) != '[') {
      this.matchStat = -2;
      return (float[][])null;
    } 
    j = this.bp;
    i = k + 1;
    k = charAt(j + k);
    float[][] arrayOfFloat = new float[16][];
    boolean bool1 = false;
    for (paramArrayOfchar = arrayOfChar;; paramArrayOfchar = arrayOfChar) {
      float[] arrayOfFloat1;
      if (k == 91) {
        k = this.bp;
        j = i + 1;
        char c = charAt(k + i);
        float[] arrayOfFloat3 = new float[16];
        i = 0;
        char[] arrayOfChar1 = paramArrayOfchar;
        arrayOfFloat1 = arrayOfFloat3;
        while (true) {
          int m = this.bp + j - 1;
          arrayOfChar1 = null;
          object = SYNTHETIC_LOCAL_VARIABLE_17;
          arrayOfFloat4 = arrayOfFloat3;
        } 
        continue;
      } 
      float[] arrayOfFloat2 = arrayOfFloat1;
      continue;
    } 
  }
  
  public int scanFieldInt(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return 0;
    } 
    int i = paramArrayOfchar.length;
    int j = this.bp;
    int k = i + 1;
    char c = charAt(j + i);
    if (c == '-') {
      i = 1;
    } else {
      i = 0;
    } 
    j = k;
    if (i != 0) {
      c = charAt(this.bp + k);
      j = k + 1;
    } 
    if (c >= '0' && c <= '9') {
      k = c - 48;
      int m = j;
      j = k;
      while (true) {
        int n = this.bp;
        k = m + 1;
        m = charAt(n + m);
        if (m >= 48 && m <= 57) {
          j = j * 10 + m - 48;
          m = k;
          continue;
        } 
        break;
      } 
      if (m == 46) {
        this.matchStat = -1;
        return 0;
      } 
      if ((j < 0 || k > paramArrayOfchar.length + 14) && (j != Integer.MIN_VALUE || k != 17 || i == 0)) {
        this.matchStat = -1;
        return 0;
      } 
      if (m == 44) {
        this.bp += k;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        m = j;
        if (i != 0)
          m = -j; 
        return m;
      } 
      if (m == 125) {
        int n = this.bp;
        m = k + 1;
        k = charAt(n + k);
        if (k == 44) {
          this.token = 16;
          this.bp += m;
          this.ch = charAt(this.bp);
        } else if (k == 93) {
          this.token = 15;
          this.bp += m;
          this.ch = charAt(this.bp);
        } else if (k == 125) {
          this.token = 13;
          this.bp += m;
          this.ch = charAt(this.bp);
        } else if (k == 26) {
          this.token = 20;
          this.bp += m - 1;
          this.ch = (char)'\032';
        } else {
          this.matchStat = -1;
          return 0;
        } 
        this.matchStat = 4;
        m = j;
        if (i != 0)
          m = -j; 
        return m;
      } 
      this.matchStat = -1;
      return 0;
    } 
    this.matchStat = -1;
    return 0;
  }
  
  public final int[] scanFieldIntArray(char[] paramArrayOfchar) {
    int m;
    this.matchStat = 0;
    boolean bool = charArrayCompare(paramArrayOfchar);
    int[] arrayOfInt2 = null;
    if (!bool) {
      this.matchStat = -2;
      return null;
    } 
    int i = paramArrayOfchar.length;
    int j = this.bp;
    int k = i + 1;
    if (charAt(j + i) != '[') {
      this.matchStat = -2;
      return null;
    } 
    j = this.bp;
    i = k + 1;
    k = charAt(j + k);
    int[] arrayOfInt1 = new int[16];
    if (k == 93) {
      j = this.bp;
      k = i + 1;
      i = charAt(j + i);
      m = 0;
    } else {
      j = 0;
      for (int[] arrayOfInt = arrayOfInt1;; arrayOfInt = arrayOfInt1) {
        boolean bool1;
        if (k == 45) {
          k = charAt(this.bp + i);
          i++;
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (k >= 48 && k <= 57) {
          char c;
          k -= 48;
          m = i;
          while (true) {
            int i1 = this.bp;
            i = m + 1;
            c = charAt(i1 + m);
            if (c >= '0' && c <= '9') {
              k = k * 10 + c - 48;
              m = i;
              continue;
            } 
            break;
          } 
          arrayOfInt1 = arrayOfInt;
          if (j >= arrayOfInt.length) {
            arrayOfInt1 = new int[arrayOfInt.length * 3 / 2];
            System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, j);
          } 
          m = j + 1;
          int n = k;
          if (bool1)
            n = -k; 
          arrayOfInt1[j] = n;
          if (c == ',') {
            j = this.bp;
            k = i + 1;
            j = charAt(j + i);
            i = k;
            k = j;
          } else {
            if (c == ']') {
              j = this.bp;
              k = i + 1;
              i = charAt(j + i);
            } else {
              k = c;
              arrayOfInt2 = null;
              j = m;
              arrayOfInt = arrayOfInt1;
            } 
            if (m != arrayOfInt1.length) {
              arrayOfInt = new int[m];
              System.arraycopy(arrayOfInt1, 0, arrayOfInt, 0, m);
              arrayOfInt1 = arrayOfInt;
            } 
          } 
        } else {
          break;
        } 
        arrayOfInt2 = null;
        j = m;
      } 
      this.matchStat = -1;
      return arrayOfInt2;
    } 
    if (m != arrayOfInt1.length) {
      int[] arrayOfInt = new int[m];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt, 0, m);
      arrayOfInt1 = arrayOfInt;
    } 
  }
  
  public long scanFieldLong(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return 0L;
    } 
    int i = paramArrayOfchar.length;
    int j = this.bp;
    int k = i + 1;
    i = charAt(j + i);
    if (i == 45) {
      i = this.bp;
      j = k + 1;
      i = charAt(i + k);
      boolean bool = true;
      k = j;
      j = bool;
    } else {
      j = 0;
    } 
    if (i >= 48 && i <= 57) {
      long l = (i - 48);
      while (true) {
        int m = this.bp;
        i = k + 1;
        k = charAt(m + k);
        if (k >= 48 && k <= 57) {
          l = l * 10L + (k - 48);
          k = i;
          continue;
        } 
        break;
      } 
      if (k == 46) {
        this.matchStat = -1;
        return 0L;
      } 
      if (l < 0L || i > 21) {
        this.matchStat = -1;
        return 0L;
      } 
      if (k == 44) {
        this.bp += i;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        long l1 = l;
        if (j != 0)
          l1 = -l; 
        return l1;
      } 
      if (k == 125) {
        int m = this.bp;
        k = i + 1;
        i = charAt(m + i);
        if (i == 44) {
          this.token = 16;
          this.bp += k;
          this.ch = charAt(this.bp);
        } else if (i == 93) {
          this.token = 15;
          this.bp += k;
          this.ch = charAt(this.bp);
        } else if (i == 125) {
          this.token = 13;
          this.bp += k;
          this.ch = charAt(this.bp);
        } else if (i == 26) {
          this.token = 20;
          this.bp += k - 1;
          this.ch = (char)'\032';
        } else {
          this.matchStat = -1;
          return 0L;
        } 
        this.matchStat = 4;
        long l1 = l;
        if (j != 0)
          l1 = -l; 
        return l1;
      } 
      this.matchStat = -1;
      return 0L;
    } 
    this.matchStat = -1;
    return 0L;
  }
  
  public String scanFieldString(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return stringDefaultValue();
    } 
    int i = paramArrayOfchar.length;
    if (charAt(this.bp + i) != '"') {
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    int j = indexOf('"', this.bp + paramArrayOfchar.length + 1);
    if (j != -1) {
      int k = this.bp + paramArrayOfchar.length + 1;
      String str1 = subString(k, j - k);
      k = j;
      String str2 = str1;
      if (str1.indexOf('\\') != -1)
        while (true) {
          k = j - 1;
          byte b = 0;
          while (k >= 0 && charAt(k) == '\\') {
            b++;
            k--;
          } 
          if (b % 2 == 0) {
            k = j - this.bp + paramArrayOfchar.length + 1;
            str2 = readString(sub_chars(this.bp + paramArrayOfchar.length + 1, k), k);
            k = j;
            break;
          } 
          j = indexOf('"', j + 1);
        }  
      int m = i + 1 + k - this.bp + paramArrayOfchar.length + 1 + 1;
      k = this.bp;
      j = m + 1;
      k = charAt(k + m);
      if (k == 44) {
        this.bp += j;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return str2;
      } 
      if (k == 125) {
        m = this.bp;
        k = j + 1;
        j = charAt(m + j);
        if (j == 44) {
          this.token = 16;
          this.bp += k;
          this.ch = charAt(this.bp);
        } else if (j == 93) {
          this.token = 15;
          this.bp += k;
          this.ch = charAt(this.bp);
        } else if (j == 125) {
          this.token = 13;
          this.bp += k;
          this.ch = charAt(this.bp);
        } else {
          if (j == 26) {
            this.token = 20;
            this.bp += k - 1;
            this.ch = (char)'\032';
            this.matchStat = 4;
            return str2;
          } 
          this.matchStat = -1;
          return stringDefaultValue();
        } 
        this.matchStat = 4;
        return str2;
      } 
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    throw new JSONException("unclosed str");
  }
  
  public Collection<String> scanFieldStringArray(char[] paramArrayOfchar, Class<?> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual charArrayCompare : ([C)Z
    //   10: ifne -> 21
    //   13: aload_0
    //   14: bipush #-2
    //   16: putfield matchStat : I
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual newCollectionByType : (Ljava/lang/Class;)Ljava/util/Collection;
    //   26: astore_3
    //   27: aload_1
    //   28: arraylength
    //   29: istore #4
    //   31: aload_0
    //   32: getfield bp : I
    //   35: istore #5
    //   37: iload #4
    //   39: iconst_1
    //   40: iadd
    //   41: istore #6
    //   43: aload_0
    //   44: iload #5
    //   46: iload #4
    //   48: iadd
    //   49: invokevirtual charAt : (I)C
    //   52: bipush #91
    //   54: if_icmpeq -> 64
    //   57: aload_0
    //   58: iconst_m1
    //   59: putfield matchStat : I
    //   62: aconst_null
    //   63: areturn
    //   64: aload_0
    //   65: getfield bp : I
    //   68: istore #4
    //   70: iload #6
    //   72: iconst_1
    //   73: iadd
    //   74: istore #5
    //   76: aload_0
    //   77: iload #4
    //   79: iload #6
    //   81: iadd
    //   82: invokevirtual charAt : (I)C
    //   85: istore #6
    //   87: iload #6
    //   89: bipush #34
    //   91: if_icmpne -> 308
    //   94: aload_0
    //   95: bipush #34
    //   97: aload_0
    //   98: getfield bp : I
    //   101: iload #5
    //   103: iadd
    //   104: invokevirtual indexOf : (CI)I
    //   107: istore #6
    //   109: iload #6
    //   111: iconst_m1
    //   112: if_icmpeq -> 297
    //   115: aload_0
    //   116: getfield bp : I
    //   119: iload #5
    //   121: iadd
    //   122: istore #4
    //   124: aload_0
    //   125: iload #4
    //   127: iload #6
    //   129: iload #4
    //   131: isub
    //   132: invokevirtual subString : (II)Ljava/lang/String;
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: iload #6
    //   140: istore #4
    //   142: aload_2
    //   143: bipush #92
    //   145: invokevirtual indexOf : (I)I
    //   148: iconst_m1
    //   149: if_icmpeq -> 246
    //   152: iload #6
    //   154: iconst_1
    //   155: isub
    //   156: istore #7
    //   158: iconst_0
    //   159: istore #4
    //   161: iload #7
    //   163: iflt -> 186
    //   166: aload_0
    //   167: iload #7
    //   169: invokevirtual charAt : (I)C
    //   172: bipush #92
    //   174: if_icmpne -> 186
    //   177: iinc #4, 1
    //   180: iinc #7, -1
    //   183: goto -> 161
    //   186: iload #4
    //   188: iconst_2
    //   189: irem
    //   190: ifne -> 231
    //   193: iload #6
    //   195: aload_0
    //   196: getfield bp : I
    //   199: iload #5
    //   201: iadd
    //   202: isub
    //   203: istore #4
    //   205: aload_0
    //   206: aload_0
    //   207: getfield bp : I
    //   210: iload #5
    //   212: iadd
    //   213: iload #4
    //   215: invokevirtual sub_chars : (II)[C
    //   218: iload #4
    //   220: invokestatic readString : ([CI)Ljava/lang/String;
    //   223: astore_1
    //   224: iload #6
    //   226: istore #4
    //   228: goto -> 246
    //   231: aload_0
    //   232: bipush #34
    //   234: iload #6
    //   236: iconst_1
    //   237: iadd
    //   238: invokevirtual indexOf : (CI)I
    //   241: istore #6
    //   243: goto -> 152
    //   246: iload #5
    //   248: iload #4
    //   250: aload_0
    //   251: getfield bp : I
    //   254: iload #5
    //   256: iadd
    //   257: isub
    //   258: iconst_1
    //   259: iadd
    //   260: iadd
    //   261: istore #4
    //   263: aload_0
    //   264: getfield bp : I
    //   267: istore #5
    //   269: iload #4
    //   271: iconst_1
    //   272: iadd
    //   273: istore #6
    //   275: aload_0
    //   276: iload #5
    //   278: iload #4
    //   280: iadd
    //   281: invokevirtual charAt : (I)C
    //   284: istore #5
    //   286: aload_3
    //   287: aload_1
    //   288: invokeinterface add : (Ljava/lang/Object;)Z
    //   293: pop
    //   294: goto -> 401
    //   297: new com/alibaba/fastjson/JSONException
    //   300: dup
    //   301: ldc_w 'unclosed str'
    //   304: invokespecial <init> : (Ljava/lang/String;)V
    //   307: athrow
    //   308: iload #6
    //   310: bipush #110
    //   312: if_icmpne -> 482
    //   315: aload_0
    //   316: aload_0
    //   317: getfield bp : I
    //   320: iload #5
    //   322: iadd
    //   323: invokevirtual charAt : (I)C
    //   326: bipush #117
    //   328: if_icmpne -> 482
    //   331: aload_0
    //   332: aload_0
    //   333: getfield bp : I
    //   336: iload #5
    //   338: iadd
    //   339: iconst_1
    //   340: iadd
    //   341: invokevirtual charAt : (I)C
    //   344: bipush #108
    //   346: if_icmpne -> 482
    //   349: aload_0
    //   350: aload_0
    //   351: getfield bp : I
    //   354: iload #5
    //   356: iadd
    //   357: iconst_2
    //   358: iadd
    //   359: invokevirtual charAt : (I)C
    //   362: bipush #108
    //   364: if_icmpne -> 482
    //   367: iinc #5, 3
    //   370: aload_0
    //   371: getfield bp : I
    //   374: istore #4
    //   376: iload #5
    //   378: iconst_1
    //   379: iadd
    //   380: istore #6
    //   382: aload_0
    //   383: iload #4
    //   385: iload #5
    //   387: iadd
    //   388: invokevirtual charAt : (I)C
    //   391: istore #5
    //   393: aload_3
    //   394: aconst_null
    //   395: invokeinterface add : (Ljava/lang/Object;)Z
    //   400: pop
    //   401: iload #5
    //   403: bipush #44
    //   405: if_icmpne -> 434
    //   408: aload_0
    //   409: getfield bp : I
    //   412: istore #4
    //   414: iload #6
    //   416: iconst_1
    //   417: iadd
    //   418: istore #5
    //   420: aload_0
    //   421: iload #4
    //   423: iload #6
    //   425: iadd
    //   426: invokevirtual charAt : (I)C
    //   429: istore #6
    //   431: goto -> 87
    //   434: iload #5
    //   436: bipush #93
    //   438: if_icmpne -> 475
    //   441: aload_0
    //   442: getfield bp : I
    //   445: istore #4
    //   447: iload #6
    //   449: iconst_1
    //   450: iadd
    //   451: istore #5
    //   453: aload_0
    //   454: iload #4
    //   456: iload #6
    //   458: iadd
    //   459: invokevirtual charAt : (I)C
    //   462: istore #4
    //   464: iload #5
    //   466: istore #6
    //   468: iload #4
    //   470: istore #5
    //   472: goto -> 521
    //   475: aload_0
    //   476: iconst_m1
    //   477: putfield matchStat : I
    //   480: aconst_null
    //   481: areturn
    //   482: iload #6
    //   484: bipush #93
    //   486: if_icmpne -> 759
    //   489: aload_3
    //   490: invokeinterface size : ()I
    //   495: ifne -> 759
    //   498: aload_0
    //   499: getfield bp : I
    //   502: istore #4
    //   504: iload #5
    //   506: iconst_1
    //   507: iadd
    //   508: istore #6
    //   510: aload_0
    //   511: iload #4
    //   513: iload #5
    //   515: iadd
    //   516: invokevirtual charAt : (I)C
    //   519: istore #5
    //   521: iload #5
    //   523: bipush #44
    //   525: if_icmpne -> 558
    //   528: aload_0
    //   529: aload_0
    //   530: getfield bp : I
    //   533: iload #6
    //   535: iadd
    //   536: putfield bp : I
    //   539: aload_0
    //   540: aload_0
    //   541: aload_0
    //   542: getfield bp : I
    //   545: invokevirtual charAt : (I)C
    //   548: putfield ch : C
    //   551: aload_0
    //   552: iconst_3
    //   553: putfield matchStat : I
    //   556: aload_3
    //   557: areturn
    //   558: iload #5
    //   560: bipush #125
    //   562: if_icmpne -> 752
    //   565: aload_0
    //   566: getfield bp : I
    //   569: istore #4
    //   571: iload #6
    //   573: iconst_1
    //   574: iadd
    //   575: istore #5
    //   577: aload_0
    //   578: iload #4
    //   580: iload #6
    //   582: iadd
    //   583: invokevirtual charAt : (I)C
    //   586: istore #6
    //   588: iload #6
    //   590: bipush #44
    //   592: if_icmpne -> 627
    //   595: aload_0
    //   596: bipush #16
    //   598: putfield token : I
    //   601: aload_0
    //   602: aload_0
    //   603: getfield bp : I
    //   606: iload #5
    //   608: iadd
    //   609: putfield bp : I
    //   612: aload_0
    //   613: aload_0
    //   614: aload_0
    //   615: getfield bp : I
    //   618: invokevirtual charAt : (I)C
    //   621: putfield ch : C
    //   624: goto -> 738
    //   627: iload #6
    //   629: bipush #93
    //   631: if_icmpne -> 666
    //   634: aload_0
    //   635: bipush #15
    //   637: putfield token : I
    //   640: aload_0
    //   641: aload_0
    //   642: getfield bp : I
    //   645: iload #5
    //   647: iadd
    //   648: putfield bp : I
    //   651: aload_0
    //   652: aload_0
    //   653: aload_0
    //   654: getfield bp : I
    //   657: invokevirtual charAt : (I)C
    //   660: putfield ch : C
    //   663: goto -> 738
    //   666: iload #6
    //   668: bipush #125
    //   670: if_icmpne -> 705
    //   673: aload_0
    //   674: bipush #13
    //   676: putfield token : I
    //   679: aload_0
    //   680: aload_0
    //   681: getfield bp : I
    //   684: iload #5
    //   686: iadd
    //   687: putfield bp : I
    //   690: aload_0
    //   691: aload_0
    //   692: aload_0
    //   693: getfield bp : I
    //   696: invokevirtual charAt : (I)C
    //   699: putfield ch : C
    //   702: goto -> 738
    //   705: iload #6
    //   707: bipush #26
    //   709: if_icmpne -> 745
    //   712: aload_0
    //   713: aload_0
    //   714: getfield bp : I
    //   717: iload #5
    //   719: iconst_1
    //   720: isub
    //   721: iadd
    //   722: putfield bp : I
    //   725: aload_0
    //   726: bipush #20
    //   728: putfield token : I
    //   731: aload_0
    //   732: bipush #26
    //   734: i2c
    //   735: putfield ch : C
    //   738: aload_0
    //   739: iconst_4
    //   740: putfield matchStat : I
    //   743: aload_3
    //   744: areturn
    //   745: aload_0
    //   746: iconst_m1
    //   747: putfield matchStat : I
    //   750: aconst_null
    //   751: areturn
    //   752: aload_0
    //   753: iconst_m1
    //   754: putfield matchStat : I
    //   757: aconst_null
    //   758: areturn
    //   759: new com/alibaba/fastjson/JSONException
    //   762: dup
    //   763: ldc_w 'illega str'
    //   766: invokespecial <init> : (Ljava/lang/String;)V
    //   769: athrow
  }
  
  public long scanFieldSymbol(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return 0L;
    } 
    int i = paramArrayOfchar.length;
    int j = this.bp;
    int k = i + 1;
    if (charAt(j + i) != '"') {
      this.matchStat = -1;
      return 0L;
    } 
    long l = -2128831035L;
    while (true) {
      j = this.bp;
      i = k + 1;
      k = charAt(j + k);
      if (k == 34) {
        j = this.bp;
        k = i + 1;
        i = charAt(j + i);
        if (i == 44) {
          this.bp += k;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          return l;
        } 
        if (i == 125) {
          j = this.bp;
          i = k + 1;
          k = charAt(j + k);
          if (k == 44) {
            this.token = 16;
            this.bp += i;
            this.ch = charAt(this.bp);
          } else if (k == 93) {
            this.token = 15;
            this.bp += i;
            this.ch = charAt(this.bp);
          } else if (k == 125) {
            this.token = 13;
            this.bp += i;
            this.ch = charAt(this.bp);
          } else {
            if (k == 26) {
              this.token = 20;
              this.bp += i - 1;
              this.ch = (char)'\032';
              this.matchStat = 4;
              return l;
            } 
            this.matchStat = -1;
            return 0L;
          } 
          this.matchStat = 4;
          return l;
        } 
        this.matchStat = -1;
        return 0L;
      } 
      l = (l ^ k) * 16777619L;
      if (k == 92) {
        this.matchStat = -1;
        return 0L;
      } 
      k = i;
    } 
  }
  
  public final float scanFloat(char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c >= '0' && c <= '9') {
      int k;
      int j = 1;
      while (true) {
        k = this.bp;
        i = j + 1;
        k = charAt(k + j);
        if (k >= 48 && k <= 57) {
          j = i;
          continue;
        } 
        break;
      } 
      if (k == 46) {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i >= 48 && i <= 57) {
          while (true) {
            k = this.bp;
            i = j + 1;
            char c1 = charAt(k + j);
            k = c1;
            j = i;
            if (c1 >= '0') {
              k = c1;
              j = i;
              if (c1 <= '9') {
                j = i;
                continue;
              } 
            } 
            break;
          } 
        } else {
          this.matchStat = -1;
          return 0.0F;
        } 
      } else {
        j = i;
      } 
      int i = this.bp;
      float f = Float.parseFloat(subString(i, this.bp + j - i - 1));
      if (k == paramChar) {
        this.bp += j;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return f;
      } 
      this.matchStat = -1;
      return f;
    } 
    this.matchStat = -1;
    return 0.0F;
  }
  
  public final void scanHex() {
    if (this.ch == 'x') {
      next();
      if (this.ch == '\'') {
        char c;
        this.np = this.bp;
        next();
        while (true) {
          c = next();
          if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) {
            this.sp++;
            continue;
          } 
          break;
        } 
        if (c == '\'') {
          this.sp++;
          next();
          this.token = 26;
          return;
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("illegal state. ");
        stringBuilder2.append(c);
        throw new JSONException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("illegal state. ");
      stringBuilder1.append(this.ch);
      throw new JSONException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("illegal state. ");
    stringBuilder.append(this.ch);
    throw new JSONException(stringBuilder.toString());
  }
  
  public final void scanIdent() {
    this.np = this.bp - 1;
    this.hasSpecial = false;
    while (true) {
      this.sp++;
      next();
      if (Character.isLetterOrDigit(this.ch))
        continue; 
      String str = stringVal();
      if ("null".equalsIgnoreCase(str)) {
        this.token = 8;
      } else if ("new".equals(str)) {
        this.token = 9;
      } else if ("true".equals(str)) {
        this.token = 6;
      } else if ("false".equals(str)) {
        this.token = 7;
      } else if ("undefined".equals(str)) {
        this.token = 23;
      } else if ("Set".equals(str)) {
        this.token = 21;
      } else if ("TreeSet".equals(str)) {
        this.token = 22;
      } else {
        this.token = 18;
      } 
      return;
    } 
  }
  
  public int scanInt(char paramChar) {
    boolean bool;
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    int i = 1;
    if (c == '-') {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      c = charAt(this.bp + 1);
      i = 2;
    } 
    if (c >= '0' && c <= '9') {
      int j;
      c -= '0';
      int k = i;
      i = c;
      while (true) {
        int n = this.bp;
        j = k + 1;
        k = charAt(n + k);
        if (k >= 48 && k <= 57) {
          i = i * 10 + k - 48;
          k = j;
          continue;
        } 
        break;
      } 
      if (k == 46) {
        this.matchStat = -1;
        return 0;
      } 
      int m = k;
      if (i < 0) {
        this.matchStat = -1;
        return 0;
      } 
      while (true) {
        if (m == paramChar) {
          this.bp += j;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          this.token = 16;
          int i1 = i;
          if (bool)
            i1 = -i; 
          return i1;
        } 
        if (isWhitespace(m)) {
          k = charAt(this.bp + j);
          j++;
          m = k;
          continue;
        } 
        this.matchStat = -1;
        int n = i;
        if (bool)
          n = -i; 
        return n;
      } 
    } 
    this.matchStat = -1;
    return 0;
  }
  
  public long scanLong(char paramChar) {
    boolean bool = false;
    this.matchStat = 0;
    int i = charAt(this.bp + 0);
    int j = 1;
    if (i == 45)
      bool = true; 
    if (bool) {
      i = charAt(this.bp + 1);
      j = 2;
    } 
    if (i >= 48 && i <= 57) {
      int k;
      long l = (i - 48);
      i = j;
      while (true) {
        int n = this.bp;
        j = i + 1;
        char c = charAt(n + i);
        if (c >= '0' && c <= '9') {
          l = l * 10L + (c - 48);
          k = j;
          continue;
        } 
        break;
      } 
      if (k == 46) {
        this.matchStat = -1;
        return 0L;
      } 
      int m = k;
      if (l < 0L) {
        this.matchStat = -1;
        return 0L;
      } 
      while (true) {
        if (m == paramChar) {
          this.bp += j;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          this.token = 16;
          long l1 = l;
          if (bool)
            l1 = -l; 
          return l1;
        } 
        if (isWhitespace(m)) {
          char c = charAt(this.bp + j);
          j++;
          char c1 = c;
          continue;
        } 
        this.matchStat = -1;
        return l;
      } 
    } 
    this.matchStat = -1;
    return 0L;
  }
  
  public final void scanNullOrNew() {
    if (this.ch == 'n') {
      next();
      if (this.ch == 'u') {
        next();
        if (this.ch == 'l') {
          next();
          if (this.ch == 'l') {
            next();
            if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\032' || this.ch == '\f' || this.ch == '\b') {
              this.token = 8;
              return;
            } 
            throw new JSONException("scan null error");
          } 
          throw new JSONException("error parse null");
        } 
        throw new JSONException("error parse null");
      } 
      if (this.ch == 'e') {
        next();
        if (this.ch == 'w') {
          next();
          if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\032' || this.ch == '\f' || this.ch == '\b') {
            this.token = 9;
            return;
          } 
          throw new JSONException("scan new error");
        } 
        throw new JSONException("error parse new");
      } 
      throw new JSONException("error parse new");
    } 
    throw new JSONException("error parse null or new");
  }
  
  public final void scanNumber() {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield bp : I
    //   5: putfield np : I
    //   8: aload_0
    //   9: getfield ch : C
    //   12: istore_1
    //   13: iconst_1
    //   14: istore_2
    //   15: iload_1
    //   16: bipush #45
    //   18: if_icmpne -> 36
    //   21: aload_0
    //   22: aload_0
    //   23: getfield sp : I
    //   26: iconst_1
    //   27: iadd
    //   28: putfield sp : I
    //   31: aload_0
    //   32: invokevirtual next : ()C
    //   35: pop
    //   36: aload_0
    //   37: getfield ch : C
    //   40: bipush #48
    //   42: if_icmplt -> 72
    //   45: aload_0
    //   46: getfield ch : C
    //   49: bipush #57
    //   51: if_icmpgt -> 72
    //   54: aload_0
    //   55: aload_0
    //   56: getfield sp : I
    //   59: iconst_1
    //   60: iadd
    //   61: putfield sp : I
    //   64: aload_0
    //   65: invokevirtual next : ()C
    //   68: pop
    //   69: goto -> 36
    //   72: iconst_0
    //   73: istore_1
    //   74: aload_0
    //   75: getfield ch : C
    //   78: bipush #46
    //   80: if_icmpne -> 136
    //   83: aload_0
    //   84: aload_0
    //   85: getfield sp : I
    //   88: iconst_1
    //   89: iadd
    //   90: putfield sp : I
    //   93: aload_0
    //   94: invokevirtual next : ()C
    //   97: pop
    //   98: aload_0
    //   99: getfield ch : C
    //   102: bipush #48
    //   104: if_icmplt -> 134
    //   107: aload_0
    //   108: getfield ch : C
    //   111: bipush #57
    //   113: if_icmpgt -> 134
    //   116: aload_0
    //   117: aload_0
    //   118: getfield sp : I
    //   121: iconst_1
    //   122: iadd
    //   123: putfield sp : I
    //   126: aload_0
    //   127: invokevirtual next : ()C
    //   130: pop
    //   131: goto -> 98
    //   134: iconst_1
    //   135: istore_1
    //   136: aload_0
    //   137: getfield ch : C
    //   140: bipush #76
    //   142: if_icmpne -> 163
    //   145: aload_0
    //   146: aload_0
    //   147: getfield sp : I
    //   150: iconst_1
    //   151: iadd
    //   152: putfield sp : I
    //   155: aload_0
    //   156: invokevirtual next : ()C
    //   159: pop
    //   160: goto -> 296
    //   163: aload_0
    //   164: getfield ch : C
    //   167: bipush #83
    //   169: if_icmpne -> 190
    //   172: aload_0
    //   173: aload_0
    //   174: getfield sp : I
    //   177: iconst_1
    //   178: iadd
    //   179: putfield sp : I
    //   182: aload_0
    //   183: invokevirtual next : ()C
    //   186: pop
    //   187: goto -> 296
    //   190: aload_0
    //   191: getfield ch : C
    //   194: bipush #66
    //   196: if_icmpne -> 217
    //   199: aload_0
    //   200: aload_0
    //   201: getfield sp : I
    //   204: iconst_1
    //   205: iadd
    //   206: putfield sp : I
    //   209: aload_0
    //   210: invokevirtual next : ()C
    //   213: pop
    //   214: goto -> 296
    //   217: aload_0
    //   218: getfield ch : C
    //   221: bipush #70
    //   223: if_icmpne -> 246
    //   226: aload_0
    //   227: aload_0
    //   228: getfield sp : I
    //   231: iconst_1
    //   232: iadd
    //   233: putfield sp : I
    //   236: aload_0
    //   237: invokevirtual next : ()C
    //   240: pop
    //   241: iload_2
    //   242: istore_1
    //   243: goto -> 420
    //   246: aload_0
    //   247: getfield ch : C
    //   250: bipush #68
    //   252: if_icmpne -> 275
    //   255: aload_0
    //   256: aload_0
    //   257: getfield sp : I
    //   260: iconst_1
    //   261: iadd
    //   262: putfield sp : I
    //   265: aload_0
    //   266: invokevirtual next : ()C
    //   269: pop
    //   270: iload_2
    //   271: istore_1
    //   272: goto -> 420
    //   275: aload_0
    //   276: getfield ch : C
    //   279: bipush #101
    //   281: if_icmpeq -> 299
    //   284: aload_0
    //   285: getfield ch : C
    //   288: bipush #69
    //   290: if_icmpne -> 296
    //   293: goto -> 299
    //   296: goto -> 420
    //   299: aload_0
    //   300: aload_0
    //   301: getfield sp : I
    //   304: iconst_1
    //   305: iadd
    //   306: putfield sp : I
    //   309: aload_0
    //   310: invokevirtual next : ()C
    //   313: pop
    //   314: aload_0
    //   315: getfield ch : C
    //   318: bipush #43
    //   320: if_icmpeq -> 332
    //   323: aload_0
    //   324: getfield ch : C
    //   327: bipush #45
    //   329: if_icmpne -> 347
    //   332: aload_0
    //   333: aload_0
    //   334: getfield sp : I
    //   337: iconst_1
    //   338: iadd
    //   339: putfield sp : I
    //   342: aload_0
    //   343: invokevirtual next : ()C
    //   346: pop
    //   347: aload_0
    //   348: getfield ch : C
    //   351: bipush #48
    //   353: if_icmplt -> 383
    //   356: aload_0
    //   357: getfield ch : C
    //   360: bipush #57
    //   362: if_icmpgt -> 383
    //   365: aload_0
    //   366: aload_0
    //   367: getfield sp : I
    //   370: iconst_1
    //   371: iadd
    //   372: putfield sp : I
    //   375: aload_0
    //   376: invokevirtual next : ()C
    //   379: pop
    //   380: goto -> 347
    //   383: aload_0
    //   384: getfield ch : C
    //   387: bipush #68
    //   389: if_icmpeq -> 403
    //   392: iload_2
    //   393: istore_1
    //   394: aload_0
    //   395: getfield ch : C
    //   398: bipush #70
    //   400: if_icmpne -> 420
    //   403: aload_0
    //   404: aload_0
    //   405: getfield sp : I
    //   408: iconst_1
    //   409: iadd
    //   410: putfield sp : I
    //   413: aload_0
    //   414: invokevirtual next : ()C
    //   417: pop
    //   418: iload_2
    //   419: istore_1
    //   420: iload_1
    //   421: ifeq -> 432
    //   424: aload_0
    //   425: iconst_3
    //   426: putfield token : I
    //   429: goto -> 437
    //   432: aload_0
    //   433: iconst_2
    //   434: putfield token : I
    //   437: return
  }
  
  public String scanString(char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c == 'n') {
      if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
        if (charAt(this.bp + 4) == paramChar) {
          this.bp += 5;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          return null;
        } 
        this.matchStat = -1;
        return null;
      } 
      this.matchStat = -1;
      return null;
    } 
    if (c != '"') {
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    int i = this.bp + 1;
    int j = indexOf('"', i);
    if (j != -1) {
      String str1 = subString(this.bp + 1, j - i);
      int k = j;
      String str2 = str1;
      if (str1.indexOf('\\') != -1)
        for (k = j;; k = indexOf('"', k + 1)) {
          j = k - 1;
          byte b = 0;
          while (j >= 0 && charAt(j) == '\\') {
            b++;
            j--;
          } 
          if (b % 2 == 0) {
            j = k - i;
            str2 = readString(sub_chars(this.bp + 1, j), j);
            break;
          } 
        }  
      k = 1 + k - this.bp + 1 + 1;
      if (charAt(this.bp + k) == paramChar) {
        this.bp += k + 1;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return str2;
      } 
      this.matchStat = -1;
      return str2;
    } 
    throw new JSONException("unclosed str");
  }
  
  public final void scanString() {
    this.np = this.bp;
    this.hasSpecial = false;
    while (true) {
      char c = next();
      if (c == '"') {
        this.token = 4;
        this.ch = next();
        return;
      } 
      if (c == '\032') {
        if (!isEOF()) {
          putChar('\032');
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unclosed string : ");
        stringBuilder.append(c);
        throw new JSONException(stringBuilder.toString());
      } 
      if (c == '\\') {
        StringBuilder stringBuilder;
        char c1;
        char c2;
        if (!this.hasSpecial) {
          this.hasSpecial = true;
          if (this.sp >= this.sbuf.length) {
            int j = this.sbuf.length * 2;
            int k = j;
            if (this.sp > j)
              k = this.sp; 
            char[] arrayOfChar1 = new char[k];
            System.arraycopy(this.sbuf, 0, arrayOfChar1, 0, this.sbuf.length);
            this.sbuf = arrayOfChar1;
          } 
          copyTo(this.np + 1, this.sp, this.sbuf);
        } 
        c = next();
        switch (c) {
          default:
            switch (c) {
              default:
                switch (c) {
                  default:
                    this.ch = c;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("unclosed string : ");
                    stringBuilder.append(c);
                    throw new JSONException(stringBuilder.toString());
                  case 'x':
                    c1 = next();
                    c2 = next();
                    putChar((char)(digits[c1] * 16 + digits[c2]));
                    continue;
                  case 'r':
                    putChar('\r');
                    continue;
                  case 'n':
                    putChar('\n');
                    continue;
                  case 'b':
                    putChar('\b');
                    continue;
                  case '\\':
                    putChar('\\');
                    continue;
                  case 'F':
                  case 'f':
                    putChar('\f');
                    continue;
                  case '\'':
                    putChar('\'');
                    continue;
                  case '"':
                    break;
                } 
                putChar('"');
                continue;
              case 'v':
                putChar('\013');
                continue;
              case 'u':
                putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }, ), 16));
                continue;
              case 't':
                break;
            } 
            putChar('\t');
            continue;
          case '7':
            putChar('\007');
            continue;
          case '6':
            putChar('\006');
            continue;
          case '5':
            putChar('\005');
            continue;
          case '4':
            putChar('\004');
            continue;
          case '3':
            putChar('\003');
            continue;
          case '2':
            putChar('\002');
            continue;
          case '1':
            putChar('\001');
            continue;
          case '0':
            putChar(false);
            continue;
          case '/':
            break;
        } 
        putChar('/');
        continue;
      } 
      if (!this.hasSpecial) {
        this.sp++;
        continue;
      } 
      if (this.sp == this.sbuf.length) {
        putChar(c);
        continue;
      } 
      char[] arrayOfChar = this.sbuf;
      int i = this.sp;
      this.sp = i + 1;
      arrayOfChar[i] = c;
    } 
  }
  
  public void scanStringArray(Collection<String> paramCollection, char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l' && charAt(this.bp + 1 + 3) == paramChar) {
      this.bp += 5;
      this.ch = charAt(this.bp);
      this.matchStat = 5;
      return;
    } 
    if (c != '[') {
      this.matchStat = -1;
      return;
    } 
    c = charAt(this.bp + 1);
    int i = 2;
    while (true) {
      int j;
      if (c == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
        int k = i + 3;
        i = this.bp;
        j = k + 1;
        i = charAt(i + k);
        paramCollection.add(null);
      } else {
        if (j == 93 && paramCollection.size() == 0) {
          j = this.bp;
          int m = i + 1;
          j = charAt(j + i);
          i = m;
          continue;
        } 
        if (j != 34) {
          this.matchStat = -1;
          return;
        } 
        int k = this.bp + i;
        j = indexOf('"', k);
        if (j != -1) {
          String str1 = subString(this.bp + i, j - k);
          String str2 = str1;
          int m = j;
          if (str1.indexOf('\\') != -1)
            while (true) {
              int n = j - 1;
              m = 0;
              while (n >= 0 && charAt(n) == '\\') {
                m++;
                n--;
              } 
              if (m % 2 == 0) {
                m = j - k;
                str2 = readString(sub_chars(this.bp + i, m), m);
                m = j;
                break;
              } 
              j = indexOf('"', j + 1);
            }  
          i += m - this.bp + i + 1;
          m = this.bp;
          j = i + 1;
          i = charAt(m + i);
          paramCollection.add(str2);
        } else {
          throw new JSONException("unclosed str");
        } 
      } 
      if (i == 44) {
        int k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        continue;
      } 
      if (i == 93) {
        int k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        if (j == paramChar) {
          this.bp += i;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          return;
        } 
        this.matchStat = -1;
        return;
      } 
      this.matchStat = -1;
      return;
    } 
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable) {
    skipWhitespace();
    if (this.ch == '"')
      return scanSymbol(paramSymbolTable, '"'); 
    if (this.ch == '\'') {
      if (isEnabled(Feature.AllowSingleQuotes))
        return scanSymbol(paramSymbolTable, '\''); 
      throw new JSONException("syntax error");
    } 
    if (this.ch == '}') {
      next();
      this.token = 13;
      return null;
    } 
    if (this.ch == ',') {
      next();
      this.token = 16;
      return null;
    } 
    if (this.ch == '\032') {
      this.token = 20;
      return null;
    } 
    if (isEnabled(Feature.AllowUnQuotedFieldNames))
      return scanSymbolUnQuoted(paramSymbolTable); 
    throw new JSONException("syntax error");
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable, char paramChar) {
    this.np = this.bp;
    this.sp = 0;
    int i = 0;
    int j = 0;
    while (true) {
      char c = next();
      if (c == paramChar) {
        String str;
        this.token = 4;
        if (!i) {
          int k;
          if (this.np == -1) {
            paramChar = Character.MIN_VALUE;
          } else {
            k = this.np + 1;
          } 
          str = addSymbol(k, this.sp, j, paramSymbolTable);
        } else {
          str = str.addSymbol(this.sbuf, 0, this.sp, j);
        } 
        this.sp = 0;
        next();
        return str;
      } 
      if (c != '\032') {
        if (c == '\\') {
          char c1;
          int m = i;
          if (!i) {
            if (this.sp >= this.sbuf.length) {
              i = this.sbuf.length * 2;
              m = i;
              if (this.sp > i)
                m = this.sp; 
              char[] arrayOfChar1 = new char[m];
              System.arraycopy(this.sbuf, 0, arrayOfChar1, 0, this.sbuf.length);
              this.sbuf = arrayOfChar1;
            } 
            arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
            m = 1;
          } 
          i = next();
          switch (i) {
            default:
              switch (i) {
                default:
                  switch (i) {
                    default:
                      this.ch = (char)i;
                      throw new JSONException("unclosed.str.lit");
                    case 120:
                      c1 = next();
                      this.ch = (char)c1;
                      i = next();
                      this.ch = (char)i;
                      c = (char)(digits[c1] * 16 + digits[i]);
                      j = j * 31 + c;
                      putChar(c);
                      i = m;
                      continue;
                    case 114:
                      j = j * 31 + 13;
                      putChar('\r');
                      i = m;
                      continue;
                    case 110:
                      j = j * 31 + 10;
                      putChar('\n');
                      i = m;
                      continue;
                    case 98:
                      j = j * 31 + 8;
                      putChar('\b');
                      i = m;
                      continue;
                    case 92:
                      j = j * 31 + 92;
                      putChar('\\');
                      i = m;
                      continue;
                    case 70:
                    case 102:
                      j = j * 31 + 12;
                      putChar('\f');
                      i = m;
                      continue;
                    case 39:
                      j = j * 31 + 39;
                      putChar('\'');
                      i = m;
                      continue;
                    case 34:
                      break;
                  } 
                  j = j * 31 + 34;
                  putChar('"');
                  i = m;
                  continue;
                case 118:
                  j = j * 31 + 11;
                  putChar('\013');
                  i = m;
                  continue;
                case 117:
                  i = Integer.parseInt(new String(new char[] { next(), next(), next(), next() }, ), 16);
                  j = j * 31 + i;
                  putChar((char)i);
                  i = m;
                  continue;
                case 116:
                  break;
              } 
              j = j * 31 + 9;
              putChar('\t');
              i = m;
              continue;
            case 55:
              j = j * 31 + i;
              putChar('\007');
              i = m;
              continue;
            case 54:
              j = j * 31 + i;
              putChar('\006');
              i = m;
              continue;
            case 53:
              j = j * 31 + i;
              putChar('\005');
              i = m;
              continue;
            case 52:
              j = j * 31 + i;
              putChar('\004');
              i = m;
              continue;
            case 51:
              j = j * 31 + i;
              putChar('\003');
              i = m;
              continue;
            case 50:
              j = j * 31 + i;
              putChar('\002');
              i = m;
              continue;
            case 49:
              j = j * 31 + i;
              putChar('\001');
              i = m;
              continue;
            case 48:
              j = j * 31 + i;
              putChar(false);
              i = m;
              continue;
            case 47:
              break;
          } 
          j = j * 31 + 47;
          putChar('/');
          i = m;
          continue;
        } 
        j = j * 31 + c;
        if (i == 0) {
          this.sp++;
          continue;
        } 
        if (this.sp == this.sbuf.length) {
          putChar(c);
          continue;
        } 
        char[] arrayOfChar = this.sbuf;
        int k = this.sp;
        this.sp = k + 1;
        arrayOfChar[k] = c;
        continue;
      } 
      throw new JSONException("unclosed.str");
    } 
  }
  
  public final String scanSymbolUnQuoted(SymbolTable paramSymbolTable) {
    int i = this.token;
    int j = 0;
    if (i == 1 && this.pos == 0 && this.bp == 1)
      this.bp = 0; 
    boolean[] arrayOfBoolean = IOUtils.firstIdentifierFlags;
    i = this.ch;
    if (this.ch >= arrayOfBoolean.length || arrayOfBoolean[i])
      j = 1; 
    if (j) {
      arrayOfBoolean = IOUtils.identifierFlags;
      this.np = this.bp;
      this.sp = 1;
      j = i;
      while (true) {
        i = next();
        if (i < arrayOfBoolean.length && !arrayOfBoolean[i]) {
          this.ch = charAt(this.bp);
          this.token = 18;
          return (this.sp == 4 && j == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') ? null : ((paramSymbolTable == null) ? subString(this.np, this.sp) : addSymbol(this.np, this.sp, j, paramSymbolTable));
        } 
        j = j * 31 + i;
        this.sp++;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("illegal identifier : ");
    stringBuilder.append(this.ch);
    stringBuilder.append(info());
    throw new JSONException(stringBuilder.toString());
  }
  
  public String scanSymbolWithSeperator(SymbolTable paramSymbolTable, char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c == 'n') {
      if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
        if (charAt(this.bp + 4) == paramChar) {
          this.bp += 5;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          return null;
        } 
        this.matchStat = -1;
        return null;
      } 
      this.matchStat = -1;
      return null;
    } 
    if (c != '"') {
      this.matchStat = -1;
      return null;
    } 
    int i = 1;
    c = Character.MIN_VALUE;
    while (true) {
      int k = this.bp;
      int m = i + 1;
      i = charAt(k + i);
      if (i == 34) {
        i = this.bp + 0 + 1;
        String str = addSymbol(i, this.bp + m - i - 1, c, paramSymbolTable);
        i = this.bp;
        j = m + 1;
        i = charAt(i + m);
        int n = i;
        while (true) {
          if (n == paramChar) {
            this.bp += j;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            return str;
          } 
          if (isWhitespace(n)) {
            i = charAt(this.bp + j);
            j++;
            n = i;
            continue;
          } 
          this.matchStat = -1;
          return str;
        } 
        break;
      } 
      int j = j * 31 + i;
      if (i == 92) {
        this.matchStat = -1;
        return null;
      } 
      i = m;
    } 
  }
  
  public final void scanTrue() {
    if (this.ch == 't') {
      next();
      if (this.ch == 'r') {
        next();
        if (this.ch == 'u') {
          next();
          if (this.ch == 'e') {
            next();
            if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\032' || this.ch == '\f' || this.ch == '\b' || this.ch == ':' || this.ch == '/') {
              this.token = 6;
              return;
            } 
            throw new JSONException("scan true error");
          } 
          throw new JSONException("error parse true");
        } 
        throw new JSONException("error parse true");
      } 
      throw new JSONException("error parse true");
    } 
    throw new JSONException("error parse true");
  }
  
  public final int scanType(String paramString) {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(typeFieldName))
      return -2; 
    int j = this.bp + typeFieldName.length;
    int k = paramString.length();
    while (i < k) {
      if (paramString.charAt(i) != charAt(j + i))
        return -1; 
      i++;
    } 
    i = j + k;
    if (charAt(i) != '"')
      return -1; 
    j = i + 1;
    this.ch = charAt(j);
    if (this.ch == ',') {
      i = j + 1;
      this.ch = charAt(i);
      this.bp = i;
      this.token = 16;
      return 3;
    } 
    i = j;
    if (this.ch == '}') {
      i = j + 1;
      this.ch = charAt(i);
      if (this.ch == ',') {
        this.token = 16;
        this.ch = charAt(++i);
      } else if (this.ch == ']') {
        this.token = 15;
        this.ch = charAt(++i);
      } else if (this.ch == '}') {
        this.token = 13;
        this.ch = charAt(++i);
      } else if (this.ch == '\032') {
        this.token = 20;
      } else {
        return -1;
      } 
      this.matchStat = 4;
    } 
    this.bp = i;
    return this.matchStat;
  }
  
  public void setLocale(Locale paramLocale) {
    this.locale = paramLocale;
  }
  
  public void setTimeZone(TimeZone paramTimeZone) {
    this.timeZone = paramTimeZone;
  }
  
  public void setToken(int paramInt) {
    this.token = paramInt;
  }
  
  protected void skipComment() {
    next();
    if (this.ch == '/') {
      do {
        next();
        if (this.ch == '\n') {
          next();
          return;
        } 
      } while (this.ch != '\032');
      return;
    } 
    if (this.ch == '*') {
      next();
      while (this.ch != '\032') {
        if (this.ch == '*') {
          next();
          if (this.ch == '/') {
            next();
            return;
          } 
          continue;
        } 
        next();
      } 
      return;
    } 
    throw new JSONException("invalid comment");
  }
  
  public final void skipWhitespace() {
    while (this.ch <= '/') {
      if (this.ch == ' ' || this.ch == '\r' || this.ch == '\n' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
        next();
        continue;
      } 
      if (this.ch == '/')
        skipComment(); 
    } 
  }
  
  public final String stringDefaultValue() {
    return this.stringDefaultValue;
  }
  
  public abstract String stringVal();
  
  public abstract String subString(int paramInt1, int paramInt2);
  
  protected abstract char[] sub_chars(int paramInt1, int paramInt2);
  
  public final int token() {
    return this.token;
  }
  
  public final String tokenName() {
    return JSONToken.name(this.token);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\JSONLexerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */