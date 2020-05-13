package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN13Reader extends UPCEANReader {
  static final int[] FIRST_DIGIT_ENCODINGS = new int[] { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
  
  private final int[] decodeMiddleCounters = new int[4];
  
  private static void determineFirstDigit(StringBuilder paramStringBuilder, int paramInt) throws NotFoundException {
    for (byte b = 0; b < 10; b++) {
      if (paramInt == FIRST_DIGIT_ENCODINGS[b]) {
        paramStringBuilder.insert(0, (char)(b + 48));
        return;
      } 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    int j = paramArrayOfint[1];
    byte b = 0;
    int k;
    for (k = 0; b < 6 && j < i; k = i1) {
      int m = decodeDigit(paramBitArray, arrayOfInt, j, L_AND_G_PATTERNS);
      paramStringBuilder.append((char)(m % 10 + 48));
      int n = arrayOfInt.length;
      int i1;
      for (i1 = 0; i1 < n; i1++)
        j += arrayOfInt[i1]; 
      i1 = k;
      if (m >= 10)
        i1 = 1 << 5 - b | k; 
      b++;
    } 
    determineFirstDigit(paramStringBuilder, k);
    j = findGuardPattern(paramBitArray, j, true, MIDDLE_PATTERN)[1];
    for (b = 0; b < 6 && j < i; b++) {
      paramStringBuilder.append((char)(decodeDigit(paramBitArray, arrayOfInt, j, L_PATTERNS) + 48));
      int m = arrayOfInt.length;
      for (k = 0; k < m; k++)
        j += arrayOfInt[k]; 
    } 
    return j;
  }
  
  BarcodeFormat getBarcodeFormat() {
    return BarcodeFormat.EAN_13;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\EAN13Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */