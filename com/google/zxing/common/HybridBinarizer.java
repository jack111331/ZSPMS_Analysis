package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
  private static final int BLOCK_SIZE = 8;
  
  private static final int BLOCK_SIZE_MASK = 7;
  
  private static final int BLOCK_SIZE_POWER = 3;
  
  private static final int MINIMUM_DIMENSION = 40;
  
  private static final int MIN_DYNAMIC_RANGE = 24;
  
  private BitMatrix matrix;
  
  public HybridBinarizer(LuminanceSource paramLuminanceSource) {
    super(paramLuminanceSource);
  }
  
  private static int[][] calculateBlackPoints(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = paramInt4 - 8;
    int j = paramInt3 - 8;
    int[][] arrayOfInt = new int[paramInt2][paramInt1];
    for (byte b = 0; b < paramInt2; b++) {
      paramInt4 = b << 3;
      int k = paramInt4;
      if (paramInt4 > i)
        k = i; 
      for (byte b1 = 0; b1 < paramInt1; b1++) {
        int m = b1 << 3;
        paramInt4 = m;
        if (m > j)
          paramInt4 = j; 
        m = k * paramInt3 + paramInt4;
        int n = 255;
        paramInt4 = 0;
        int i1 = 0;
        int i2 = 0;
        while (paramInt4 < 8) {
          int i3 = 0;
          int i4 = n;
          n = i1;
          i1 = i3;
          while (i1 < 8) {
            int i6 = paramArrayOfbyte[m + i1] & 0xFF;
            int i7 = n + i6;
            i3 = i4;
            if (i6 < i4)
              i3 = i6; 
            n = i2;
            if (i6 > i2)
              n = i6; 
            i1++;
            i2 = n;
            n = i7;
            i4 = i3;
          } 
          int i5 = paramInt4;
          i1 = n;
          i3 = m;
          if (i2 - i4 > 24) {
            i1 = m;
            m = paramInt4;
            while (true) {
              m++;
              paramInt4 = i1 + paramInt3;
              i5 = m;
              i1 = n;
              i3 = paramInt4;
              if (m < 8) {
                for (i1 = 0; i1 < 8; i1++)
                  n += paramArrayOfbyte[paramInt4 + i1] & 0xFF; 
                i1 = paramInt4;
                continue;
              } 
              break;
            } 
          } 
          paramInt4 = i5 + 1;
          m = i3 + paramInt3;
          n = i4;
        } 
        paramInt4 = i1 >> 6;
        if (i2 - n <= 24) {
          m = n / 2;
          paramInt4 = m;
          if (b > 0) {
            paramInt4 = m;
            if (b1 > 0) {
              int i3 = b - 1;
              paramInt4 = arrayOfInt[i3][b1];
              int[] arrayOfInt1 = arrayOfInt[b];
              i2 = b1 - 1;
              i2 = (paramInt4 + arrayOfInt1[i2] * 2 + arrayOfInt[i3][i2]) / 4;
              paramInt4 = m;
              if (n < i2)
                paramInt4 = i2; 
            } 
          } 
        } 
        arrayOfInt[b][b1] = paramInt4;
      } 
    } 
    return arrayOfInt;
  }
  
  private static void calculateThresholdForBlock(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfint, BitMatrix paramBitMatrix) {
    int i = paramInt4 - 8;
    int j = paramInt3 - 8;
    for (paramInt4 = 0; paramInt4 < paramInt2; paramInt4++) {
      int k = paramInt4 << 3;
      if (k > i)
        k = i; 
      int m = cap(paramInt4, 2, paramInt2 - 3);
      for (byte b = 0; b < paramInt1; b++) {
        int n = b << 3;
        if (n > j)
          n = j; 
        int i1 = cap(b, 2, paramInt1 - 3);
        byte b1 = -2;
        int i2 = 0;
        while (b1 <= 2) {
          int[] arrayOfInt = paramArrayOfint[m + b1];
          i2 += arrayOfInt[i1 - 2] + arrayOfInt[i1 - 1] + arrayOfInt[i1] + arrayOfInt[i1 + 1] + arrayOfInt[i1 + 2];
          b1++;
        } 
        thresholdBlock(paramArrayOfbyte, n, k, i2 / 25, paramInt3, paramBitMatrix);
      } 
    } 
  }
  
  private static int cap(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 < paramInt2) ? paramInt2 : ((paramInt1 > paramInt3) ? paramInt3 : paramInt1);
  }
  
  private static void thresholdBlock(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix) {
    int i = paramInt2 * paramInt4 + paramInt1;
    byte b = 0;
    while (b < 8) {
      for (byte b1 = 0; b1 < 8; b1++) {
        if ((paramArrayOfbyte[i + b1] & 0xFF) <= paramInt3)
          paramBitMatrix.set(paramInt1 + b1, paramInt2 + b); 
      } 
      b++;
      i += paramInt4;
    } 
  }
  
  public Binarizer createBinarizer(LuminanceSource paramLuminanceSource) {
    return new HybridBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix getBlackMatrix() throws NotFoundException {
    if (this.matrix != null)
      return this.matrix; 
    LuminanceSource luminanceSource = getLuminanceSource();
    int i = luminanceSource.getWidth();
    int j = luminanceSource.getHeight();
    if (i >= 40 && j >= 40) {
      byte[] arrayOfByte = luminanceSource.getMatrix();
      int k = i >> 3;
      int m = k;
      if ((i & 0x7) != 0)
        m = k + 1; 
      int n = j >> 3;
      k = n;
      if ((j & 0x7) != 0)
        k = n + 1; 
      int[][] arrayOfInt = calculateBlackPoints(arrayOfByte, m, k, i, j);
      BitMatrix bitMatrix = new BitMatrix(i, j);
      calculateThresholdForBlock(arrayOfByte, m, k, i, j, arrayOfInt, bitMatrix);
      this.matrix = bitMatrix;
    } else {
      this.matrix = super.getBlackMatrix();
    } 
    return this.matrix;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\HybridBinarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */