package org.json.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class d {
  private int a;
  
  private Reader b;
  
  private char c;
  
  private boolean d;
  
  private d(Reader paramReader) {
    if (!paramReader.markSupported())
      paramReader = new BufferedReader(paramReader); 
    this.b = paramReader;
    this.d = false;
    this.a = 0;
  }
  
  public d(String paramString) {
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
        throw new a(iOException);
      } 
    } 
    this.a += i;
    if (i < paramInt)
      throw a("Substring bounds error"); 
    this.c = (char)iOException[paramInt - 1];
    return new String((char[])iOException);
  }
  
  public final a a(String paramString) {
    return new a(paramString + toString());
  }
  
  public final void a() {
    if (this.d || this.a <= 0)
      throw new a("Stepping back two steps is not supported"); 
    this.a--;
    this.d = true;
  }
  
  public final char b() {
    int i;
    char c = Character.MIN_VALUE;
    if (this.d) {
      this.d = false;
      if (this.c != '\000')
        this.a++; 
      c = this.c;
      return c;
    } 
    try {
      i = this.b.read();
      if (i <= 0) {
        this.c = (char)Character.MIN_VALUE;
        return c;
      } 
    } catch (IOException iOException) {
      throw new a(iOException);
    } 
    this.a++;
    this.c = (char)(char)i;
    c = this.c;
    return c;
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
    //   107: invokevirtual a : (Ljava/lang/String;)Lorg/json/a/a;
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
    char c1;
    char c2;
    char c = c();
    switch (c) {
      default:
        stringBuffer = new StringBuffer();
        c1 = c;
        for (c2 = c1; c2 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c2) < 0; c2 = c1) {
          stringBuffer.append(c2);
          c1 = b();
        } 
        break;
      case '"':
      case '\'':
        stringBuffer = new StringBuffer();
        while (true) {
          c2 = b();
          switch (c2) {
            default:
              if (c2 == c)
                return stringBuffer.toString(); 
              break;
            case '\000':
            case '\n':
            case '\r':
              throw a("Unterminated string");
            case '\\':
              c2 = b();
              switch (c2) {
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
          stringBuffer.append(c2);
        } 
      case '{':
        a();
        return new c(this);
      case '(':
      case '[':
        a();
        return new b(this);
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
      return c.a; 
    if ((c >= '0' && c <= '9') || c == '.' || c == '-' || c == '+') {
      if (c == '0') {
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\json\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */