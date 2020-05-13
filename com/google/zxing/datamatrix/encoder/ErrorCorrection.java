package com.google.zxing.datamatrix.encoder;

public final class ErrorCorrection {
  private static final int[] ALOG;
  
  private static final int[][] FACTORS;
  
  private static final int[] FACTOR_SETS = new int[] { 
      5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 
      36, 42, 48, 56, 62, 68 };
  
  private static final int[] LOG;
  
  private static final int MODULO_VALUE = 301;
  
  static {
    byte b = 0;
    FACTORS = new int[][] { 
        { 228, 48, 15, 111, 62 }, { 23, 68, 144, 134, 240, 92, 254 }, { 28, 24, 185, 166, 223, 248, 116, 255, 110, 61 }, { 
          175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 
          120 }, { 
          41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 
          100, 242 }, { 
          156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 
          18, 186, 83, 185 }, { 
          83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 
          109, 129, 94, 254, 225, 48, 90, 188 }, { 
          15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 
          153, 145, 253, 79, 108, 82, 27, 174, 186, 172 }, { 
          52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 
          251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 
          184, 96, 50, 193 }, { 
          211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 
          170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 
          141, 136, 120, 151, 233, 168, 93, 255 }, 
        { 
          245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 
          84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 
          68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 
          59, 25, 225, 98, 81, 112 }, { 
          77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 
          122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 
          167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 
          54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 
          9, 5 }, { 
          245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 
          238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 
          118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 
          66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 
          160, 175, 69, 213, 92, 253, 225, 19 }, { 
          175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 
          175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 
          38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 
          29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 
          164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 
          203, 107, 233, 53, 143, 46 }, { 
          242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 
          201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 
          245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 
          114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 
          87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 
          4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 
          11, 204 }, { 
          220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 
          147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 
          234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 
          227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 
          220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 
          59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 
          108, 153, 132, 63, 96, 103, 82, 186 } };
    LOG = new int[256];
    ALOG = new int[255];
    int i = 1;
    while (b < 'ÿ') {
      ALOG[b] = i;
      LOG[i] = b;
      int j = i << 1;
      i = j;
      if (j >= 256)
        i = j ^ 0x12D; 
      b++;
    } 
  }
  
  private static String createECCBlock(CharSequence paramCharSequence, int paramInt) {
    return createECCBlock(paramCharSequence, 0, paramCharSequence.length(), paramInt);
  }
  
  private static String createECCBlock(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iconst_0
    //   4: istore #5
    //   6: iload #5
    //   8: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.FACTOR_SETS : [I
    //   11: arraylength
    //   12: if_icmpge -> 34
    //   15: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.FACTOR_SETS : [I
    //   18: iload #5
    //   20: iaload
    //   21: iload_3
    //   22: if_icmpne -> 28
    //   25: goto -> 37
    //   28: iinc #5, 1
    //   31: goto -> 6
    //   34: iconst_m1
    //   35: istore #5
    //   37: iload #5
    //   39: iflt -> 279
    //   42: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.FACTORS : [[I
    //   45: iload #5
    //   47: aaload
    //   48: astore #6
    //   50: iload_3
    //   51: newarray char
    //   53: astore #7
    //   55: iconst_0
    //   56: istore #5
    //   58: iload #5
    //   60: iload_3
    //   61: if_icmpge -> 77
    //   64: aload #7
    //   66: iload #5
    //   68: iconst_0
    //   69: i2c
    //   70: castore
    //   71: iinc #5, 1
    //   74: goto -> 58
    //   77: iload_1
    //   78: istore #5
    //   80: iload #5
    //   82: iload_1
    //   83: iload_2
    //   84: iadd
    //   85: if_icmpge -> 244
    //   88: iload_3
    //   89: iconst_1
    //   90: isub
    //   91: istore #8
    //   93: aload #7
    //   95: iload #8
    //   97: caload
    //   98: aload_0
    //   99: iload #5
    //   101: invokeinterface charAt : (I)C
    //   106: ixor
    //   107: istore #9
    //   109: iload #8
    //   111: ifle -> 188
    //   114: iload #9
    //   116: ifeq -> 169
    //   119: aload #6
    //   121: iload #8
    //   123: iaload
    //   124: ifeq -> 169
    //   127: aload #7
    //   129: iload #8
    //   131: aload #7
    //   133: iload #8
    //   135: iconst_1
    //   136: isub
    //   137: caload
    //   138: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.ALOG : [I
    //   141: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.LOG : [I
    //   144: iload #9
    //   146: iaload
    //   147: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.LOG : [I
    //   150: aload #6
    //   152: iload #8
    //   154: iaload
    //   155: iaload
    //   156: iadd
    //   157: sipush #255
    //   160: irem
    //   161: iaload
    //   162: ixor
    //   163: i2c
    //   164: i2c
    //   165: castore
    //   166: goto -> 182
    //   169: aload #7
    //   171: iload #8
    //   173: aload #7
    //   175: iload #8
    //   177: iconst_1
    //   178: isub
    //   179: caload
    //   180: i2c
    //   181: castore
    //   182: iinc #8, -1
    //   185: goto -> 109
    //   188: iload #9
    //   190: ifeq -> 232
    //   193: aload #6
    //   195: iconst_0
    //   196: iaload
    //   197: ifeq -> 232
    //   200: aload #7
    //   202: iconst_0
    //   203: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.ALOG : [I
    //   206: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.LOG : [I
    //   209: iload #9
    //   211: iaload
    //   212: getstatic com/google/zxing/datamatrix/encoder/ErrorCorrection.LOG : [I
    //   215: aload #6
    //   217: iconst_0
    //   218: iaload
    //   219: iaload
    //   220: iadd
    //   221: sipush #255
    //   224: irem
    //   225: iaload
    //   226: i2c
    //   227: i2c
    //   228: castore
    //   229: goto -> 238
    //   232: aload #7
    //   234: iconst_0
    //   235: iconst_0
    //   236: i2c
    //   237: castore
    //   238: iinc #5, 1
    //   241: goto -> 80
    //   244: iload_3
    //   245: newarray char
    //   247: astore_0
    //   248: iload #4
    //   250: istore_1
    //   251: iload_1
    //   252: iload_3
    //   253: if_icmpge -> 274
    //   256: aload_0
    //   257: iload_1
    //   258: aload #7
    //   260: iload_3
    //   261: iload_1
    //   262: isub
    //   263: iconst_1
    //   264: isub
    //   265: caload
    //   266: i2c
    //   267: castore
    //   268: iinc #1, 1
    //   271: goto -> 251
    //   274: aload_0
    //   275: invokestatic valueOf : ([C)Ljava/lang/String;
    //   278: areturn
    //   279: new java/lang/IllegalArgumentException
    //   282: dup
    //   283: ldc 'Illegal number of error correction codewords specified: '
    //   285: iload_3
    //   286: invokestatic valueOf : (I)Ljava/lang/String;
    //   289: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   292: invokespecial <init> : (Ljava/lang/String;)V
    //   295: athrow
  }
  
  public static String encodeECC200(String paramString, SymbolInfo paramSymbolInfo) {
    if (paramString.length() == paramSymbolInfo.getDataCapacity()) {
      StringBuilder stringBuilder = new StringBuilder(paramSymbolInfo.getDataCapacity() + paramSymbolInfo.getErrorCodewords());
      stringBuilder.append(paramString);
      int i = paramSymbolInfo.getInterleavedBlockCount();
      if (i == 1) {
        stringBuilder.append(createECCBlock(paramString, paramSymbolInfo.getErrorCodewords()));
      } else {
        stringBuilder.setLength(stringBuilder.capacity());
        int[] arrayOfInt1 = new int[i];
        int[] arrayOfInt2 = new int[i];
        int[] arrayOfInt3 = new int[i];
        int j;
        for (j = 0; j < i; j = k) {
          int k = j + 1;
          arrayOfInt1[j] = paramSymbolInfo.getDataLengthForInterleavedBlock(k);
          arrayOfInt2[j] = paramSymbolInfo.getErrorLengthForInterleavedBlock(k);
          arrayOfInt3[j] = 0;
          if (j > 0)
            arrayOfInt3[j] = arrayOfInt3[j - 1] + arrayOfInt1[j]; 
        } 
        for (j = 0; j < i; j++) {
          StringBuilder stringBuilder1 = new StringBuilder(arrayOfInt1[j]);
          int k;
          for (k = j; k < paramSymbolInfo.getDataCapacity(); k += i)
            stringBuilder1.append(paramString.charAt(k)); 
          String str = createECCBlock(stringBuilder1.toString(), arrayOfInt2[j]);
          int m = j;
          for (k = 0; m < arrayOfInt2[j] * i; k++) {
            stringBuilder.setCharAt(paramSymbolInfo.getDataCapacity() + m, str.charAt(k));
            m += i;
          } 
        } 
      } 
      return stringBuilder.toString();
    } 
    throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\ErrorCorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */