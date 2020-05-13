package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN8Reader extends UPCEANReader {
  private final int[] decodeMiddleCounters = new int[4];
  
  protected int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    int j = paramArrayOfint[1];
    byte b;
    for (b = 0; b < 4 && j < i; b++) {
      paramStringBuilder.append((char)(decodeDigit(paramBitArray, arrayOfInt, j, L_PATTERNS) + 48));
      int k = arrayOfInt.length;
      for (byte b1 = 0; b1 < k; b1++)
        j += arrayOfInt[b1]; 
    } 
    j = findGuardPattern(paramBitArray, j, true, MIDDLE_PATTERN)[1];
    for (b = 0; b < 4 && j < i; b++) {
      paramStringBuilder.append((char)(decodeDigit(paramBitArray, arrayOfInt, j, L_PATTERNS) + 48));
      int k = arrayOfInt.length;
      for (byte b1 = 0; b1 < k; b1++)
        j += arrayOfInt[b1]; 
    } 
    return j;
  }
  
  BarcodeFormat getBarcodeFormat() {
    return BarcodeFormat.EAN_8;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\EAN8Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */