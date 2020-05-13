package com.sdk.base.framework.utils.i;

public final class c {
  private static final String a = c.class.getName();
  
  private static final Boolean b = Boolean.valueOf(com.sdk.base.framework.c.c.h);
  
  private static final char[] c = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/' };
  
  private static final byte[] d = new byte[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
      -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -1, -1, -1, -1, -1 };
  
  public static String a(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_1
    //   7: isub
    //   8: iconst_3
    //   9: idiv
    //   10: bipush #6
    //   12: ishl
    //   13: invokespecial <init> : (I)V
    //   16: astore_1
    //   17: iconst_0
    //   18: istore_2
    //   19: iconst_0
    //   20: istore_3
    //   21: iload_2
    //   22: aload_0
    //   23: arraylength
    //   24: if_icmpge -> 150
    //   27: iload_3
    //   28: aload_0
    //   29: iload_2
    //   30: baload
    //   31: bipush #16
    //   33: iload_2
    //   34: iconst_3
    //   35: irem
    //   36: bipush #8
    //   38: imul
    //   39: isub
    //   40: ishl
    //   41: sipush #255
    //   44: bipush #16
    //   46: iload_2
    //   47: iconst_3
    //   48: irem
    //   49: bipush #8
    //   51: imul
    //   52: isub
    //   53: ishl
    //   54: iand
    //   55: ior
    //   56: istore #4
    //   58: iload_2
    //   59: iconst_3
    //   60: irem
    //   61: iconst_2
    //   62: if_icmpeq -> 76
    //   65: iload #4
    //   67: istore_3
    //   68: iload_2
    //   69: aload_0
    //   70: arraylength
    //   71: iconst_1
    //   72: isub
    //   73: if_icmpne -> 144
    //   76: aload_1
    //   77: getstatic com/sdk/base/framework/utils/i/c.c : [C
    //   80: ldc 16515072
    //   82: iload #4
    //   84: iand
    //   85: bipush #18
    //   87: iushr
    //   88: caload
    //   89: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   92: pop
    //   93: aload_1
    //   94: getstatic com/sdk/base/framework/utils/i/c.c : [C
    //   97: ldc 258048
    //   99: iload #4
    //   101: iand
    //   102: bipush #12
    //   104: iushr
    //   105: caload
    //   106: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   109: pop
    //   110: aload_1
    //   111: getstatic com/sdk/base/framework/utils/i/c.c : [C
    //   114: iload #4
    //   116: sipush #4032
    //   119: iand
    //   120: bipush #6
    //   122: iushr
    //   123: caload
    //   124: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   127: pop
    //   128: aload_1
    //   129: getstatic com/sdk/base/framework/utils/i/c.c : [C
    //   132: iload #4
    //   134: bipush #63
    //   136: iand
    //   137: caload
    //   138: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   141: pop
    //   142: iconst_0
    //   143: istore_3
    //   144: iinc #2, 1
    //   147: goto -> 21
    //   150: aload_0
    //   151: arraylength
    //   152: iconst_3
    //   153: irem
    //   154: ifle -> 169
    //   157: aload_1
    //   158: aload_1
    //   159: invokevirtual length : ()I
    //   162: iconst_1
    //   163: isub
    //   164: bipush #61
    //   166: invokevirtual setCharAt : (IC)V
    //   169: aload_0
    //   170: arraylength
    //   171: iconst_3
    //   172: irem
    //   173: iconst_1
    //   174: if_icmpne -> 189
    //   177: aload_1
    //   178: aload_1
    //   179: invokevirtual length : ()I
    //   182: iconst_2
    //   183: isub
    //   184: bipush #61
    //   186: invokevirtual setCharAt : (IC)V
    //   189: aload_1
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: areturn
  }
  
  public static byte[] a(String paramString) {
    int i = 0;
    if (paramString == null)
      return null; 
    int j = paramString.length();
    if (j % 4 != 0)
      throw new IllegalArgumentException("Base64 string length must be 4*n"); 
    if (paramString.length() == 0)
      return new byte[0]; 
    if (paramString.charAt(j - 1) == '=') {
      k = 1;
    } else {
      k = 0;
    } 
    int m = k;
    if (paramString.charAt(j - 2) == '=')
      m = k + 1; 
    m = j / 4 * 3 - m;
    byte[] arrayOfByte = new byte[m];
    int k = i;
    while (true) {
      byte[] arrayOfByte1 = arrayOfByte;
      if (k < j) {
        i = k / 4 * 3;
        char c1 = paramString.charAt(k);
        char c2 = paramString.charAt(k + 1);
        char c3 = paramString.charAt(k + 2);
        char c4 = paramString.charAt(k + 3);
        int n = d[c1] << 18 | d[c2] << 12 | d[c3] << 6 | d[c4];
        arrayOfByte[i] = (byte)(byte)((0xFF0000 & n) >> 16);
        if (k < j - 4) {
          arrayOfByte[i + 1] = (byte)(byte)((n & 0xFF00) >> 8);
          arrayOfByte[i + 2] = (byte)(byte)(n & 0xFF);
        } else {
          if (i + 1 < m)
            arrayOfByte[i + 1] = (byte)(byte)((n & 0xFF00) >> 8); 
          if (i + 2 < m)
            arrayOfByte[i + 2] = (byte)(byte)(n & 0xFF); 
        } 
        k += 4;
        continue;
      } 
      return arrayOfByte1;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */