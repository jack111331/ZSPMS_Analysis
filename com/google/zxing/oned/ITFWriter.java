package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class ITFWriter extends OneDimensionalCodeWriter {
  private static final int[] END_PATTERN;
  
  private static final int N = 1;
  
  private static final int[][] PATTERNS;
  
  private static final int[] START_PATTERN = new int[] { 1, 1, 1, 1 };
  
  private static final int W = 3;
  
  static {
    END_PATTERN = new int[] { 3, 1, 1 };
    int[] arrayOfInt1 = { 1, 1, 3, 3, 1 };
    int[] arrayOfInt2 = { 1, 3, 1, 1, 3 };
    int[] arrayOfInt3 = { 3, 1, 3, 1, 1 };
    PATTERNS = new int[][] { arrayOfInt1, { 3, 1, 1, 1, 3 }, arrayOfInt2, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, arrayOfInt3, { 1, 3, 3, 1, 1 }, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.ITF)
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
  
  public boolean[] encode(String paramString) {
    int i = paramString.length();
    if (i % 2 == 0) {
      if (i <= 80) {
        boolean[] arrayOfBoolean = new boolean[i * 9 + 9];
        int j = appendPattern(arrayOfBoolean, 0, START_PATTERN, true);
        for (byte b = 0; b < i; b += 2) {
          int k = Character.digit(paramString.charAt(b), 10);
          int m = Character.digit(paramString.charAt(b + 1), 10);
          int[] arrayOfInt = new int[10];
          for (byte b1 = 0; b1 < 5; b1++) {
            int n = b1 * 2;
            arrayOfInt[n] = PATTERNS[k][b1];
            arrayOfInt[n + 1] = PATTERNS[m][b1];
          } 
          j += appendPattern(arrayOfBoolean, j, arrayOfInt, true);
        } 
        appendPattern(arrayOfBoolean, j, END_PATTERN, true);
        return arrayOfBoolean;
      } 
      throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(i)));
    } 
    throw new IllegalArgumentException("The length of the input should be even");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\ITFWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */