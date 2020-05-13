package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class UPCEReader extends UPCEANReader {
  private static final int[] MIDDLE_END_PATTERN = new int[] { 1, 1, 1, 1, 1, 1 };
  
  static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = new int[][] { { 56, 52, 50, 49, 44, 38, 35, 42, 41, 37 }, { 7, 11, 13, 14, 19, 25, 28, 21, 22, 26 } };
  
  private final int[] decodeMiddleCounters = new int[4];
  
  public static String convertUPCEtoUPCA(String paramString) {
    char[] arrayOfChar = new char[6];
    paramString.getChars(1, 7, arrayOfChar, 0);
    StringBuilder stringBuilder = new StringBuilder(12);
    stringBuilder.append(paramString.charAt(0));
    char c = arrayOfChar[5];
    switch (c) {
      default:
        stringBuilder.append(arrayOfChar, 0, 5);
        stringBuilder.append("0000");
        stringBuilder.append(c);
        break;
      case '4':
        stringBuilder.append(arrayOfChar, 0, 4);
        stringBuilder.append("00000");
        stringBuilder.append(arrayOfChar[4]);
        break;
      case '3':
        stringBuilder.append(arrayOfChar, 0, 3);
        stringBuilder.append("00000");
        stringBuilder.append(arrayOfChar, 3, 2);
        break;
      case '0':
      case '1':
      case '2':
        stringBuilder.append(arrayOfChar, 0, 2);
        stringBuilder.append(c);
        stringBuilder.append("0000");
        stringBuilder.append(arrayOfChar, 2, 3);
        break;
    } 
    if (paramString.length() >= 8)
      stringBuilder.append(paramString.charAt(7)); 
    return stringBuilder.toString();
  }
  
  private static void determineNumSysAndCheckDigit(StringBuilder paramStringBuilder, int paramInt) throws NotFoundException {
    for (byte b = 0; b <= 1; b++) {
      for (byte b1 = 0; b1 < 10; b1++) {
        if (paramInt == NUMSYS_AND_CHECK_DIGIT_PATTERNS[b][b1]) {
          paramStringBuilder.insert(0, (char)(b + 48));
          paramStringBuilder.append((char)(b1 + 48));
          return;
        } 
      } 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected boolean checkChecksum(String paramString) throws FormatException {
    return super.checkChecksum(convertUPCEtoUPCA(paramString));
  }
  
  protected int[] decodeEnd(BitArray paramBitArray, int paramInt) throws NotFoundException {
    return findGuardPattern(paramBitArray, paramInt, true, MIDDLE_END_PATTERN);
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
    determineNumSysAndCheckDigit(paramStringBuilder, k);
    return j;
  }
  
  BarcodeFormat getBarcodeFormat() {
    return BarcodeFormat.UPC_E;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCEReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */