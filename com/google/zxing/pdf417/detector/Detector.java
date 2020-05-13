package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {
  private static final int BARCODE_MIN_HEIGHT = 10;
  
  private static final int[] INDEXES_START_PATTERN = new int[] { 0, 4, 1, 5 };
  
  private static final int[] INDEXES_STOP_PATTERN = new int[] { 6, 2, 7, 3 };
  
  private static final float MAX_AVG_VARIANCE = 0.42F;
  
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.8F;
  
  private static final int MAX_PATTERN_DRIFT = 5;
  
  private static final int MAX_PIXEL_DRIFT = 3;
  
  private static final int ROW_STEP = 5;
  
  private static final int SKIPPED_ROW_COUNT_MAX = 25;
  
  private static final int[] START_PATTERN = new int[] { 8, 1, 1, 1, 1, 1, 1, 3 };
  
  private static final int[] STOP_PATTERN = new int[] { 7, 1, 1, 3, 1, 1, 1, 2, 1 };
  
  private static void copyToResult(ResultPoint[] paramArrayOfResultPoint1, ResultPoint[] paramArrayOfResultPoint2, int[] paramArrayOfint) {
    for (byte b = 0; b < paramArrayOfint.length; b++)
      paramArrayOfResultPoint1[paramArrayOfint[b]] = paramArrayOfResultPoint2[b]; 
  }
  
  public static PDF417DetectorResult detect(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean) throws NotFoundException {
    BitMatrix bitMatrix2 = paramBinaryBitmap.getBlackMatrix();
    List<ResultPoint[]> list2 = detect(paramBoolean, bitMatrix2);
    BitMatrix bitMatrix1 = bitMatrix2;
    List<ResultPoint[]> list1 = list2;
    if (list2.isEmpty()) {
      bitMatrix1 = bitMatrix2.clone();
      bitMatrix1.rotate180();
      list1 = detect(paramBoolean, bitMatrix1);
    } 
    return new PDF417DetectorResult(bitMatrix1, list1);
  }
  
  private static List<ResultPoint[]> detect(boolean paramBoolean, BitMatrix paramBitMatrix) {
    ArrayList<ResultPoint[]> arrayList = new ArrayList();
    int i = 0;
    label31: while (true) {
      int j = 0;
      int k = 0;
      while (i < paramBitMatrix.getHeight()) {
        ResultPoint[] arrayOfResultPoint = findVertices(paramBitMatrix, i, j);
        if (arrayOfResultPoint[0] == null && arrayOfResultPoint[3] == null) {
          if (k) {
            for (ResultPoint[] arrayOfResultPoint1 : arrayList) {
              k = i;
              if (arrayOfResultPoint1[1] != null)
                k = (int)Math.max(i, arrayOfResultPoint1[1].getY()); 
              i = k;
              if (arrayOfResultPoint1[3] != null)
                i = Math.max(k, (int)arrayOfResultPoint1[3].getY()); 
            } 
            i += 5;
            continue label31;
          } 
          break;
        } 
        arrayList.add(arrayOfResultPoint);
        if (paramBoolean) {
          if (arrayOfResultPoint[2] != null) {
            k = (int)arrayOfResultPoint[2].getX();
            i = (int)arrayOfResultPoint[2].getY();
          } else {
            k = (int)arrayOfResultPoint[4].getX();
            i = (int)arrayOfResultPoint[4].getY();
          } 
          boolean bool = true;
          j = k;
          k = bool;
        } 
      } 
      break;
    } 
    return (List<ResultPoint[]>)arrayList;
  }
  
  private static int[] findGuardPattern(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    Arrays.fill(paramArrayOfint2, 0, paramArrayOfint2.length, 0);
    int i;
    for (i = 0; paramBitMatrix.get(paramInt1, paramInt2) && paramInt1 > 0 && i < 3; i++)
      paramInt1--; 
    int j = paramArrayOfint1.length;
    i = paramInt1;
    int k = 0;
    int m = paramInt1;
    paramInt1 = i;
    i = k;
    while (true) {
      boolean bool = true;
      if (m < paramInt3) {
        if (paramBitMatrix.get(m, paramInt2) != paramBoolean) {
          paramArrayOfint2[i] = paramArrayOfint2[i] + 1;
          k = paramInt1;
        } else {
          if (i == j - 1) {
            if (patternMatchVariance(paramArrayOfint2, paramArrayOfint1, 0.8F) < 0.42F)
              return new int[] { paramInt1, m }; 
            k = paramInt1 + paramArrayOfint2[0] + paramArrayOfint2[1];
            paramInt1 = i - 1;
            System.arraycopy(paramArrayOfint2, 2, paramArrayOfint2, 0, paramInt1);
            paramArrayOfint2[paramInt1] = 0;
            paramArrayOfint2[i] = 0;
            paramInt1 = i - 1;
            i = k;
          } else {
            k = i + 1;
            i = paramInt1;
            paramInt1 = k;
          } 
          paramArrayOfint2[paramInt1] = 1;
          if (!paramBoolean) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          } 
          k = i;
          i = paramInt1;
        } 
        m++;
        paramInt1 = k;
        continue;
      } 
      return (i == j - 1 && patternMatchVariance(paramArrayOfint2, paramArrayOfint1, 0.8F) < 0.42F) ? new int[] { paramInt1, m - 1 } : null;
    } 
  }
  
  private static ResultPoint[] findRowsWithPattern(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    int i;
    ResultPoint[] arrayOfResultPoint = new ResultPoint[4];
    int[] arrayOfInt = new int[paramArrayOfint.length];
    while (true) {
      if (paramInt3 < paramInt1) {
        int[] arrayOfInt1 = findGuardPattern(paramBitMatrix, paramInt4, paramInt3, paramInt2, false, paramArrayOfint, arrayOfInt);
        if (arrayOfInt1 != null) {
          int[] arrayOfInt2;
          int k = paramInt3;
          while (true) {
            arrayOfInt2 = arrayOfInt1;
            paramInt3 = k;
            if (k > 0) {
              arrayOfInt1 = findGuardPattern(paramBitMatrix, paramInt4, --k, paramInt2, false, paramArrayOfint, arrayOfInt);
              if (arrayOfInt1 != null)
                continue; 
              paramInt3 = k + 1;
            } 
            break;
          } 
          float f1 = arrayOfInt2[0];
          float f2 = paramInt3;
          arrayOfResultPoint[0] = new ResultPoint(f1, f2);
          arrayOfResultPoint[1] = new ResultPoint(arrayOfInt2[1], f2);
          k = 1;
          paramInt4 = paramInt3;
          break;
        } 
        paramInt3 += 5;
        continue;
      } 
      i = 0;
      paramInt4 = paramInt3;
      break;
    } 
    int j = paramInt4 + 1;
    paramInt3 = j;
    if (i) {
      int[] arrayOfInt1 = { (int)arrayOfResultPoint[0].getX(), (int)arrayOfResultPoint[1].getX() };
      i = j;
      paramInt3 = 0;
      while (i < paramInt1) {
        int k = arrayOfInt1[0];
        j = paramInt3;
        int[] arrayOfInt2 = findGuardPattern(paramBitMatrix, k, i, paramInt2, false, paramArrayOfint, arrayOfInt);
        if (arrayOfInt2 != null && Math.abs(arrayOfInt1[0] - arrayOfInt2[0]) < 5 && Math.abs(arrayOfInt1[1] - arrayOfInt2[1]) < 5) {
          arrayOfInt1 = arrayOfInt2;
          paramInt3 = 0;
        } else if (j <= 25) {
          paramInt3 = j + 1;
        } else {
          break;
        } 
        i++;
      } 
      paramInt3 = i - paramInt3 + 1;
      float f2 = arrayOfInt1[0];
      float f1 = paramInt3;
      arrayOfResultPoint[2] = new ResultPoint(f2, f1);
      arrayOfResultPoint[3] = new ResultPoint(arrayOfInt1[1], f1);
    } 
    if (paramInt3 - paramInt4 < 10)
      Arrays.fill((Object[])arrayOfResultPoint, (Object)null); 
    return arrayOfResultPoint;
  }
  
  private static ResultPoint[] findVertices(BitMatrix paramBitMatrix, int paramInt1, int paramInt2) {
    int i = paramBitMatrix.getHeight();
    int j = paramBitMatrix.getWidth();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[8];
    copyToResult(arrayOfResultPoint, findRowsWithPattern(paramBitMatrix, i, j, paramInt1, paramInt2, START_PATTERN), INDEXES_START_PATTERN);
    if (arrayOfResultPoint[4] != null) {
      paramInt2 = (int)arrayOfResultPoint[4].getX();
      paramInt1 = (int)arrayOfResultPoint[4].getY();
    } 
    copyToResult(arrayOfResultPoint, findRowsWithPattern(paramBitMatrix, i, j, paramInt1, paramInt2, STOP_PATTERN), INDEXES_STOP_PATTERN);
    return arrayOfResultPoint;
  }
  
  private static float patternMatchVariance(int[] paramArrayOfint1, int[] paramArrayOfint2, float paramFloat) {
    int i = paramArrayOfint1.length;
    boolean bool = false;
    byte b = 0;
    int j = 0;
    int k = 0;
    while (b < i) {
      j += paramArrayOfint1[b];
      k += paramArrayOfint2[b];
      b++;
    } 
    if (j < k)
      return Float.POSITIVE_INFINITY; 
    float f1 = j;
    float f2 = f1 / k;
    float f3 = 0.0F;
    for (k = bool; k < i; k++) {
      j = paramArrayOfint1[k];
      float f4 = paramArrayOfint2[k] * f2;
      float f5 = j;
      if (f5 > f4) {
        f4 = f5 - f4;
      } else {
        f4 -= f5;
      } 
      if (f4 > paramFloat * f2)
        return Float.POSITIVE_INFINITY; 
      f3 += f4;
    } 
    return f3 / f1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */