package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer extends Binarizer {
  private static final byte[] EMPTY = new byte[0];
  
  private static final int LUMINANCE_BITS = 5;
  
  private static final int LUMINANCE_BUCKETS = 32;
  
  private static final int LUMINANCE_SHIFT = 3;
  
  private final int[] buckets = new int[32];
  
  private byte[] luminances = EMPTY;
  
  public GlobalHistogramBinarizer(LuminanceSource paramLuminanceSource) {
    super(paramLuminanceSource);
  }
  
  private static int estimateBlackPoint(int[] paramArrayOfint) throws NotFoundException {
    int i = paramArrayOfint.length;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (k < i) {
      int i3 = m;
      if (paramArrayOfint[k] > m) {
        i3 = paramArrayOfint[k];
        i1 = k;
      } 
      int i4 = n;
      if (paramArrayOfint[k] > n)
        i4 = paramArrayOfint[k]; 
      k++;
      m = i3;
      n = i4;
    } 
    m = 0;
    k = 0;
    int i2 = j;
    while (i2 < i) {
      int i3 = i2 - i1;
      j = paramArrayOfint[i2] * i3 * i3;
      i3 = m;
      if (j > m) {
        k = i2;
        i3 = j;
      } 
      i2++;
      m = i3;
    } 
    m = k;
    i2 = i1;
    if (i1 > k) {
      i2 = k;
      m = i1;
    } 
    if (m - i2 > i / 16) {
      i1 = m - 1;
      int i3 = -1;
      k = i1;
      while (i1 > i2) {
        j = i1 - i2;
        i = j * j * (m - i1) * (n - paramArrayOfint[i1]);
        j = i3;
        if (i > i3) {
          k = i1;
          j = i;
        } 
        i1--;
        i3 = j;
      } 
      return k << 3;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private void initArrays(int paramInt) {
    if (this.luminances.length < paramInt)
      this.luminances = new byte[paramInt]; 
    for (paramInt = 0; paramInt < 32; paramInt++)
      this.buckets[paramInt] = 0; 
  }
  
  public Binarizer createBinarizer(LuminanceSource paramLuminanceSource) {
    return new GlobalHistogramBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix getBlackMatrix() throws NotFoundException {
    LuminanceSource luminanceSource = getLuminanceSource();
    int i = luminanceSource.getWidth();
    int j = luminanceSource.getHeight();
    BitMatrix bitMatrix = new BitMatrix(i, j);
    initArrays(i);
    int[] arrayOfInt = this.buckets;
    byte b;
    for (b = 1; b < 5; b++) {
      byte[] arrayOfByte1 = luminanceSource.getRow(j * b / 5, this.luminances);
      int m = (i << 2) / 5;
      for (int n = i / 5; n < m; n++) {
        int i1 = (arrayOfByte1[n] & 0xFF) >> 3;
        arrayOfInt[i1] = arrayOfInt[i1] + 1;
      } 
    } 
    int k = estimateBlackPoint(arrayOfInt);
    byte[] arrayOfByte = luminanceSource.getMatrix();
    for (b = 0; b < j; b++) {
      for (byte b1 = 0; b1 < i; b1++) {
        if ((arrayOfByte[b * i + b1] & 0xFF) < k)
          bitMatrix.set(b1, b); 
      } 
    } 
    return bitMatrix;
  }
  
  public BitArray getBlackRow(int paramInt, BitArray paramBitArray) throws NotFoundException {
    LuminanceSource luminanceSource = getLuminanceSource();
    int i = luminanceSource.getWidth();
    if (paramBitArray == null || paramBitArray.getSize() < i) {
      paramBitArray = new BitArray(i);
    } else {
      paramBitArray.clear();
    } 
    initArrays(i);
    byte[] arrayOfByte = luminanceSource.getRow(paramInt, this.luminances);
    int[] arrayOfInt = this.buckets;
    int j = 0;
    for (paramInt = 0; paramInt < i; paramInt++) {
      int m = (arrayOfByte[paramInt] & 0xFF) >> 3;
      arrayOfInt[m] = arrayOfInt[m] + 1;
    } 
    int k = estimateBlackPoint(arrayOfInt);
    if (i < 3) {
      for (paramInt = j; paramInt < i; paramInt++) {
        if ((arrayOfByte[paramInt] & 0xFF) < k)
          paramBitArray.set(paramInt); 
      } 
    } else {
      j = arrayOfByte[0];
      paramInt = arrayOfByte[1] & 0xFF;
      j &= 0xFF;
      int m = 1;
      while (m < i - 1) {
        int n = m + 1;
        int i1 = arrayOfByte[n] & 0xFF;
        if (((paramInt << 2) - j - i1) / 2 < k)
          paramBitArray.set(m); 
        j = paramInt;
        m = n;
        paramInt = i1;
      } 
    } 
    return paramBitArray;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\GlobalHistogramBinarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */