package com.alibaba.fastjson.asm;

public class Type {
  public static final Type BOOLEAN_TYPE;
  
  public static final Type BYTE_TYPE;
  
  public static final Type CHAR_TYPE;
  
  public static final Type DOUBLE_TYPE;
  
  public static final Type FLOAT_TYPE;
  
  public static final Type INT_TYPE;
  
  public static final Type LONG_TYPE;
  
  public static final Type SHORT_TYPE;
  
  public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
  
  private final char[] buf;
  
  private final int len;
  
  private final int off;
  
  protected final int sort;
  
  static {
    BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    CHAR_TYPE = new Type(2, null, 1124075009, 1);
    BYTE_TYPE = new Type(3, null, 1107297537, 1);
    SHORT_TYPE = new Type(4, null, 1392510721, 1);
    INT_TYPE = new Type(5, null, 1224736769, 1);
    FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    LONG_TYPE = new Type(7, null, 1241579778, 1);
    DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
  }
  
  private Type(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
    this.sort = paramInt1;
    this.buf = paramArrayOfchar;
    this.off = paramInt2;
    this.len = paramInt3;
  }
  
  public static int getArgumentsAndReturnSizes(String paramString) {
    byte b1 = 1;
    int i = 1;
    byte b2 = 1;
    while (true) {
      int j = i + 1;
      i = paramString.charAt(i);
      if (i == 41) {
        j = paramString.charAt(j);
        if (j == 86) {
          i = 0;
        } else {
          if (j != 68) {
            i = b1;
            if (j == 74)
              i = 2; 
            return b2 << 2 | i;
          } 
          i = 2;
        } 
        return b2 << 2 | i;
      } 
      if (i == 76) {
        while (true) {
          i = j + 1;
          if (paramString.charAt(j) != ';') {
            j = i;
            continue;
          } 
          b2++;
        } 
        break;
      } 
      if (i == 68 || i == 74) {
        b2 += 2;
      } else {
        b2++;
      } 
      i = j;
    } 
  }
  
  public static Type getType(String paramString) {
    return getType(paramString.toCharArray(), 0);
  }
  
  private static Type getType(char[] paramArrayOfchar, int paramInt) {
    byte b;
    switch (paramArrayOfchar[paramInt]) {
      default:
        b = 1;
        break;
      case '[':
        b = 1;
        while (true) {
          int i = paramInt + b;
          if (paramArrayOfchar[i] == '[') {
            b++;
            continue;
          } 
          byte b1 = b;
          if (paramArrayOfchar[i] == 'L') {
            b++;
            while (true) {
              b1 = b;
              if (paramArrayOfchar[paramInt + b] != ';') {
                b++;
                continue;
              } 
              break;
            } 
          } 
          return new Type(9, paramArrayOfchar, paramInt, b1 + 1);
        } 
      case 'Z':
        return BOOLEAN_TYPE;
      case 'V':
        return VOID_TYPE;
      case 'S':
        return SHORT_TYPE;
      case 'J':
        return LONG_TYPE;
      case 'I':
        return INT_TYPE;
      case 'F':
        return FLOAT_TYPE;
      case 'D':
        return DOUBLE_TYPE;
      case 'C':
        return CHAR_TYPE;
      case 'B':
        return BYTE_TYPE;
    } 
    while (paramArrayOfchar[paramInt + b] != ';')
      b++; 
    return new Type(10, paramArrayOfchar, paramInt + 1, b - 1);
  }
  
  String getDescriptor() {
    return new String(this.buf, this.off, this.len);
  }
  
  public String getInternalName() {
    return new String(this.buf, this.off, this.len);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\asm\Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */