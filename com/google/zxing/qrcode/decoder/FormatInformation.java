package com.google.zxing.qrcode.decoder;

final class FormatInformation {
  private static final int[][] FORMAT_INFO_DECODE_LOOKUP;
  
  private static final int FORMAT_INFO_MASK_QR = 21522;
  
  private final byte dataMask;
  
  private final ErrorCorrectionLevel errorCorrectionLevel;
  
  static {
    int[] arrayOfInt1 = { 21522, 0 };
    int[] arrayOfInt2 = { 20773, 1 };
    int[] arrayOfInt3 = { 24188, 2 };
    int[] arrayOfInt4 = { 23371, 3 };
    int[] arrayOfInt5 = { 20375, 6 };
    int[] arrayOfInt6 = { 19104, 7 };
    int[] arrayOfInt7 = { 30660, 8 };
    int[] arrayOfInt8 = { 29427, 9 };
    int[] arrayOfInt9 = { 32170, 10 };
    int[] arrayOfInt10 = { 30877, 11 };
    int[] arrayOfInt11 = { 26159, 12 };
    int[] arrayOfInt12 = { 25368, 13 };
    int[] arrayOfInt13 = { 27713, 14 };
    int[] arrayOfInt14 = { 26998, 15 };
    int[] arrayOfInt15 = { 5769, 16 };
    int[] arrayOfInt16 = { 5054, 17 };
    int[] arrayOfInt17 = { 7399, 18 };
    int[] arrayOfInt18 = { 6608, 19 };
    int[] arrayOfInt19 = { 1890, 20 };
    int[] arrayOfInt20 = { 597, 21 };
    int[] arrayOfInt21 = { 3340, 22 };
    int[] arrayOfInt22 = { 2107, 23 };
    int[] arrayOfInt23 = { 13663, 24 };
    int[] arrayOfInt24 = { 12392, 25 };
    int[] arrayOfInt25 = { 16177, 26 };
    int[] arrayOfInt26 = { 14854, 27 };
    int[] arrayOfInt27 = { 9396, 28 };
    int[] arrayOfInt28 = { 8579, 29 };
    int[] arrayOfInt29 = { 11994, 30 };
    int[] arrayOfInt30 = { 11245, 31 };
    FORMAT_INFO_DECODE_LOOKUP = new int[][] { 
        arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 17913, 4 }, { 16590, 5 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, 
        arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, arrayOfInt17, arrayOfInt18, 
        arrayOfInt19, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27, arrayOfInt28, 
        arrayOfInt29, arrayOfInt30 };
  }
  
  private FormatInformation(int paramInt) {
    this.errorCorrectionLevel = ErrorCorrectionLevel.forBits(paramInt >> 3 & 0x3);
    this.dataMask = (byte)(byte)(paramInt & 0x7);
  }
  
  static FormatInformation decodeFormatInformation(int paramInt1, int paramInt2) {
    FormatInformation formatInformation = doDecodeFormatInformation(paramInt1, paramInt2);
    return (formatInformation != null) ? formatInformation : doDecodeFormatInformation(paramInt1 ^ 0x5412, paramInt2 ^ 0x5412);
  }
  
  private static FormatInformation doDecodeFormatInformation(int paramInt1, int paramInt2) {
    int[][] arrayOfInt = FORMAT_INFO_DECODE_LOOKUP;
    int i = arrayOfInt.length;
    byte b = 0;
    int j = Integer.MAX_VALUE;
    int k;
    for (k = 0; b < i; k = n) {
      int[] arrayOfInt1 = arrayOfInt[b];
      int m = arrayOfInt1[0];
      if (m == paramInt1 || m == paramInt2)
        return new FormatInformation(arrayOfInt1[1]); 
      int n = numBitsDiffering(paramInt1, m);
      int i1 = j;
      if (n < j) {
        k = arrayOfInt1[1];
        i1 = n;
      } 
      j = i1;
      n = k;
      if (paramInt1 != paramInt2) {
        m = numBitsDiffering(paramInt2, m);
        j = i1;
        n = k;
        if (m < i1) {
          n = arrayOfInt1[1];
          j = m;
        } 
      } 
      b++;
    } 
    return (j <= 3) ? new FormatInformation(k) : null;
  }
  
  static int numBitsDiffering(int paramInt1, int paramInt2) {
    return Integer.bitCount(paramInt1 ^ paramInt2);
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof FormatInformation))
      return false; 
    paramObject = paramObject;
    return (this.errorCorrectionLevel == ((FormatInformation)paramObject).errorCorrectionLevel && this.dataMask == ((FormatInformation)paramObject).dataMask);
  }
  
  byte getDataMask() {
    return this.dataMask;
  }
  
  ErrorCorrectionLevel getErrorCorrectionLevel() {
    return this.errorCorrectionLevel;
  }
  
  public int hashCode() {
    return this.errorCorrectionLevel.ordinal() << 3 | this.dataMask;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\FormatInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */