package org.json.alipay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class c {
  private int a;
  
  private Reader b;
  
  private char c;
  
  private boolean d;
  
  private c(Reader paramReader) {
    if (!paramReader.markSupported())
      paramReader = new BufferedReader(paramReader); 
    this.b = paramReader;
    this.d = false;
    this.a = 0;
  }
  
  public c(String paramString) {
    this(new StringReader(paramString));
  }
  
  private String a(int paramInt) {
    int i = 0;
    if (paramInt == 0)
      return ""; 
    char[] arrayOfChar = new char[paramInt];
    if (this.d) {
      this.d = false;
      arrayOfChar[0] = (char)this.c;
      i = 1;
    } 
    while (i < paramInt) {
      try {
        int j = this.b.read(arrayOfChar, i, paramInt - i);
        if (j != -1)
          i += j; 
      } catch (IOException iOException) {
        throw new JSONException(iOException);
      } 
    } 
    this.a += i;
    if (i < paramInt)
      throw a("Substring bounds error"); 
    this.c = (char)iOException[paramInt - 1];
    return new String((char[])iOException);
  }
  
  public final JSONException a(String paramString) {
    return new JSONException(paramString + toString());
  }
  
  public final void a() {
    if (this.d || this.a <= 0)
      throw new JSONException("Stepping back two steps is not supported"); 
    this.a--;
    this.d = true;
  }
  
  public final char b() {
    int i;
    char c1 = Character.MIN_VALUE;
    if (this.d) {
      this.d = false;
      if (this.c != '\000')
        this.a++; 
      c1 = this.c;
      return c1;
    } 
    try {
      i = this.b.read();
      if (i <= 0) {
        this.c = (char)Character.MIN_VALUE;
        return c1;
      } 
    } catch (IOException iOException) {
      throw new JSONException(iOException);
    } 
    this.a++;
    this.c = (char)(char)i;
    c1 = this.c;
    return c1;
  }
  
  public final char c() {
    // Byte code:
    //   0: bipush #47
    //   2: istore_1
    //   3: aload_0
    //   4: invokevirtual b : ()C
    //   7: istore_2
    //   8: iload_2
    //   9: bipush #47
    //   11: if_icmpne -> 111
    //   14: aload_0
    //   15: invokevirtual b : ()C
    //   18: lookupswitch default -> 44, 42 -> 95, 47 -> 52
    //   44: aload_0
    //   45: invokevirtual a : ()V
    //   48: iload_1
    //   49: istore_3
    //   50: iload_3
    //   51: ireturn
    //   52: aload_0
    //   53: invokevirtual b : ()C
    //   56: istore_2
    //   57: iload_2
    //   58: bipush #10
    //   60: if_icmpeq -> 3
    //   63: iload_2
    //   64: bipush #13
    //   66: if_icmpeq -> 3
    //   69: iload_2
    //   70: ifne -> 52
    //   73: goto -> 3
    //   76: iload_2
    //   77: bipush #42
    //   79: if_icmpne -> 95
    //   82: aload_0
    //   83: invokevirtual b : ()C
    //   86: bipush #47
    //   88: if_icmpeq -> 3
    //   91: aload_0
    //   92: invokevirtual a : ()V
    //   95: aload_0
    //   96: invokevirtual b : ()C
    //   99: istore_2
    //   100: iload_2
    //   101: ifne -> 76
    //   104: aload_0
    //   105: ldc 'Unclosed comment'
    //   107: invokevirtual a : (Ljava/lang/String;)Lorg/json/alipay/JSONException;
    //   110: athrow
    //   111: iload_2
    //   112: bipush #35
    //   114: if_icmpne -> 141
    //   117: aload_0
    //   118: invokevirtual b : ()C
    //   121: istore_2
    //   122: iload_2
    //   123: bipush #10
    //   125: if_icmpeq -> 3
    //   128: iload_2
    //   129: bipush #13
    //   131: if_icmpeq -> 3
    //   134: iload_2
    //   135: ifne -> 117
    //   138: goto -> 3
    //   141: iload_2
    //   142: ifeq -> 151
    //   145: iload_2
    //   146: bipush #32
    //   148: if_icmple -> 3
    //   151: iload_2
    //   152: istore_3
    //   153: goto -> 50
  }
  
  public final Object d() {
    StringBuffer stringBuffer;
    Integer integer;
    char c2;
    char c3;
    char c1 = c();
    switch (c1) {
      default:
        stringBuffer = new StringBuffer();
        c2 = c1;
        for (c3 = c2; c3 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c3) < 0; c3 = c2) {
          stringBuffer.append(c3);
          c2 = b();
        } 
        break;
      case '"':
      case '\'':
        stringBuffer = new StringBuffer();
        while (true) {
          c3 = b();
          switch (c3) {
            default:
              if (c3 == c1)
                return stringBuffer.toString(); 
              break;
            case '\000':
            case '\n':
            case '\r':
              throw a("Unterminated string");
            case '\\':
              c3 = b();
              switch (c3) {
                case 'b':
                  stringBuffer.append('\b');
                  break;
                case 't':
                  stringBuffer.append('\t');
                  break;
                case 'n':
                  stringBuffer.append('\n');
                  break;
                case 'f':
                  stringBuffer.append('\f');
                  break;
                case 'r':
                  stringBuffer.append('\r');
                  break;
                case 'u':
                  stringBuffer.append((char)Integer.parseInt(a(4), 16));
                  break;
                case 'x':
                  stringBuffer.append((char)Integer.parseInt(a(2), 16));
                  break;
              } 
              continue;
          } 
          stringBuffer.append(c3);
        } 
      case '{':
        a();
        return new b(this);
      case '(':
      case '[':
        a();
        return new a(this);
    } 
    a();
    String str = stringBuffer.toString().trim();
    if (str.equals(""))
      throw a("Missing value"); 
    if (str.equalsIgnoreCase("true"))
      return Boolean.TRUE; 
    if (str.equalsIgnoreCase("false"))
      return Boolean.FALSE; 
    if (str.equalsIgnoreCase("null"))
      return b.a; 
    if ((c1 >= '0' && c1 <= '9') || c1 == '.' || c1 == '-' || c1 == '+') {
      if (c1 == '0') {
        if (str.length() > 2 && (str.charAt(1) == 'x' || str.charAt(1) == 'X')) {
          try {
            Integer integer1 = new Integer();
            this(Integer.parseInt(str.substring(2), 16));
            integer = integer1;
          } catch (Exception exception) {}
          return integer;
        } 
      } else {
        try {
          Integer integer1 = new Integer();
          this((String)integer);
          integer = integer1;
        } catch (Exception exception) {}
        return integer;
      } 
      try {
        Integer integer1 = new Integer(Integer.parseInt((String)integer, 8));
        integer = integer1;
      } catch (Exception exception) {}
    } 
    return integer;
  }
  
  public final String toString() {
    return " at character " + this.a;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\json\alipay\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */