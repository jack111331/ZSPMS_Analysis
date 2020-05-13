package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader extends OneDReader {
  private static final int[] DEFAULT_ALLOWED_LENGTHS = new int[] { 6, 8, 10, 12, 14 };
  
  private static final int[][] END_PATTERN_REVERSED;
  
  private static final float MAX_AVG_VARIANCE = 0.38F;
  
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.5F;
  
  private static final int N = 1;
  
  private static final int[][] PATTERNS;
  
  private static final int[] START_PATTERN = new int[] { 1, 1, 1, 1 };
  
  private static final int W = 3;
  
  private static final int w = 2;
  
  private int narrowLineWidth = -1;
  
  static {
    END_PATTERN_REVERSED = new int[][] { { 1, 1, 2 }, { 1, 1, 3 } };
    int[] arrayOfInt1 = { 1, 1, 2, 2, 1 };
    int[] arrayOfInt2 = { 2, 1, 1, 1, 2 };
    int[] arrayOfInt3 = { 2, 2, 1, 1, 1 };
    int[] arrayOfInt4 = { 1, 1, 2, 1, 2 };
    int[] arrayOfInt5 = { 1, 1, 1, 2, 2 };
    int[] arrayOfInt6 = { 1, 2, 1, 2, 1 };
    int[] arrayOfInt7 = { 1, 1, 3, 3, 1 };
    int[] arrayOfInt8 = { 1, 3, 1, 1, 3 };
    int[] arrayOfInt9 = { 3, 3, 1, 1, 1 };
    int[] arrayOfInt10 = { 1, 1, 3, 1, 3 };
    int[] arrayOfInt11 = { 3, 1, 3, 1, 1 };
    int[] arrayOfInt12 = { 1, 3, 3, 1, 1 };
    int[] arrayOfInt13 = { 3, 1, 1, 3, 1 };
    PATTERNS = new int[][] { 
        arrayOfInt1, arrayOfInt2, { 1, 2, 1, 1, 2 }, arrayOfInt3, arrayOfInt4, { 2, 1, 2, 1, 1 }, { 1, 2, 2, 1, 1 }, arrayOfInt5, { 2, 1, 1, 2, 1 }, arrayOfInt6, 
        arrayOfInt7, { 3, 1, 1, 1, 3 }, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, { 1, 1, 1, 3, 3 }, arrayOfInt13, { 1, 3, 1, 3, 1 } };
  }
  
  private static int decodeDigit(int[] paramArrayOfint) throws NotFoundException {
    int i = PATTERNS.length;
    float f = 0.38F;
    byte b = 0;
    byte b1 = -1;
    while (b < i) {
      float f2;
      float f1 = patternMatchVariance(paramArrayOfint, PATTERNS[b], 0.5F);
      if (f1 < f) {
        b1 = b;
        f2 = f1;
      } else {
        f2 = f;
        if (f1 == f) {
          b1 = -1;
          f2 = f;
        } 
      } 
      b++;
      f = f2;
    } 
    if (b1 >= 0)
      return b1 % 10; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private int[] decodeEnd(BitArray paramBitArray) throws NotFoundException {
    paramBitArray.reverse();
    try {
      int[] arrayOfInt;
      int i = skipWhiteSpace(paramBitArray);
      try {
        arrayOfInt = findGuardPattern(paramBitArray, i, END_PATTERN_REVERSED[0]);
      } catch (NotFoundException notFoundException) {
        arrayOfInt = findGuardPattern(paramBitArray, i, END_PATTERN_REVERSED[1]);
      } 
      validateQuietZone(paramBitArray, arrayOfInt[0]);
      i = arrayOfInt[0];
      arrayOfInt[0] = paramBitArray.getSize() - arrayOfInt[1];
      arrayOfInt[1] = paramBitArray.getSize() - i;
      return arrayOfInt;
    } finally {
      paramBitArray.reverse();
    } 
  }
  
  private static void decodeMiddle(BitArray paramBitArray, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    label16: while (paramInt1 < paramInt2) {
      recordPattern(paramBitArray, paramInt1, arrayOfInt1);
      boolean bool = false;
      byte b;
      for (b = 0; b < 5; b++) {
        int j = b * 2;
        arrayOfInt2[b] = arrayOfInt1[j];
        arrayOfInt3[b] = arrayOfInt1[j + 1];
      } 
      paramStringBuilder.append((char)(decodeDigit(arrayOfInt2) + 48));
      paramStringBuilder.append((char)(decodeDigit(arrayOfInt3) + 48));
      int i = paramInt1;
      b = bool;
      while (true) {
        paramInt1 = i;
        if (b < 10) {
          i += arrayOfInt1[b];
          b++;
          continue;
        } 
        continue label16;
      } 
    } 
  }
  
  private int[] decodeStart(BitArray paramBitArray) throws NotFoundException {
    int[] arrayOfInt = findGuardPattern(paramBitArray, skipWhiteSpace(paramBitArray), START_PATTERN);
    this.narrowLineWidth = (arrayOfInt[1] - arrayOfInt[0]) / 4;
    validateQuietZone(paramBitArray, arrayOfInt[0]);
    return arrayOfInt;
  }
  
  private static int[] findGuardPattern(BitArray paramBitArray, int paramInt, int[] paramArrayOfint) throws NotFoundException {
    int i = paramArrayOfint.length;
    int[] arrayOfInt = new int[i];
    int j = paramBitArray.getSize();
    int k = paramInt;
    boolean bool = false;
    int m = 0;
    int n = paramInt;
    paramInt = k;
    k = m;
    while (n < j) {
      if (paramBitArray.get(n) != bool) {
        arrayOfInt[k] = arrayOfInt[k] + 1;
        m = paramInt;
      } else {
        if (k == i - 1) {
          if (patternMatchVariance(arrayOfInt, paramArrayOfint, 0.5F) < 0.38F)
            return new int[] { paramInt, n }; 
          m = paramInt + arrayOfInt[0] + arrayOfInt[1];
          paramInt = k - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, paramInt);
          arrayOfInt[paramInt] = 0;
          arrayOfInt[k] = 0;
          paramInt = k - 1;
          k = m;
        } else {
          m = k + 1;
          k = paramInt;
          paramInt = m;
        } 
        arrayOfInt[paramInt] = 1;
        int i1 = bool ^ true;
        m = k;
        k = paramInt;
      } 
      n++;
      paramInt = m;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int skipWhiteSpace(BitArray paramBitArray) throws NotFoundException {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    if (j != i)
      return j; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private void validateQuietZone(BitArray paramBitArray, int paramInt) throws NotFoundException {
    int i = this.narrowLineWidth * 10;
    if (i >= paramInt)
      i = paramInt; 
    while (i > 0 && --paramInt >= 0 && !paramBitArray.get(paramInt)) {
      i--;
      paramInt--;
    } 
    if (i == 0)
      return; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws FormatException, NotFoundException {
    int[] arrayOfInt1;
    int[] arrayOfInt2 = decodeStart(paramBitArray);
    int[] arrayOfInt3 = decodeEnd(paramBitArray);
    StringBuilder stringBuilder = new StringBuilder(20);
    decodeMiddle(paramBitArray, arrayOfInt2[1], arrayOfInt3[0], stringBuilder);
    String str = stringBuilder.toString();
    if (paramMap != null) {
      int[] arrayOfInt = (int[])paramMap.get(DecodeHintType.ALLOWED_LENGTHS);
    } else {
      paramBitArray = null;
    } 
    BitArray bitArray = paramBitArray;
    if (paramBitArray == null)
      arrayOfInt1 = DEFAULT_ALLOWED_LENGTHS; 
    int i = str.length();
    int j = arrayOfInt1.length;
    byte b1 = 0;
    int k = 0;
    while (true) {
      if (b1 < j) {
        int m = arrayOfInt1[b1];
        if (i == m) {
          b1 = 1;
          break;
        } 
        int n = k;
        if (m > k)
          n = m; 
        b1++;
        k = n;
        continue;
      } 
      b1 = 0;
      break;
    } 
    byte b2 = b1;
    if (b1 == 0) {
      b2 = b1;
      if (i > k)
        b2 = 1; 
    } 
    if (b2 != 0) {
      float f1 = arrayOfInt2[1];
      float f2 = paramInt;
      ResultPoint resultPoint1 = new ResultPoint(f1, f2);
      ResultPoint resultPoint2 = new ResultPoint(arrayOfInt3[0], f2);
      BarcodeFormat barcodeFormat = BarcodeFormat.ITF;
      return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
    } 
    throw FormatException.getFormatInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\ITFReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */