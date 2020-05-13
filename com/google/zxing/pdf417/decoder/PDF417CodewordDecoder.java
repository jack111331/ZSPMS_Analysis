package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;

final class PDF417CodewordDecoder {
  private static final float[][] RATIOS_TABLE = new float[PDF417Common.SYMBOL_TABLE.length][8];
  
  static {
    for (byte b = 0; b < PDF417Common.SYMBOL_TABLE.length; b++) {
      int i = PDF417Common.SYMBOL_TABLE[b];
      int j = i & 0x1;
      byte b1 = 0;
      while (b1 < 8) {
        float f = 0.0F;
        while (true) {
          int k = i & 0x1;
          if (k == j) {
            f++;
            i >>= 1;
            continue;
          } 
          RATIOS_TABLE[b][8 - b1 - 1] = f / 17.0F;
          b1++;
          j = k;
        } 
      } 
    } 
  }
  
  private static int getBitValue(int[] paramArrayOfint) {
    long l = 0L;
    for (byte b = 0; b < paramArrayOfint.length; b++) {
      for (byte b1 = 0; b1 < paramArrayOfint[b]; b1++) {
        boolean bool = true;
        if (b % 2 != 0)
          bool = false; 
        l = l << 1L | bool;
      } 
    } 
    return (int)l;
  }
  
  private static int getClosestDecodedValue(int[] paramArrayOfint) {
    int i = MathUtils.sum(paramArrayOfint);
    float[] arrayOfFloat = new float[8];
    if (i > 1)
      for (byte b1 = 0; b1 < 8; b1++)
        arrayOfFloat[b1] = paramArrayOfint[b1] / i;  
    i = -1;
    byte b = 0;
    float f;
    for (f = Float.MAX_VALUE; b < RATIOS_TABLE.length; f = f1) {
      float f2;
      float[] arrayOfFloat1 = RATIOS_TABLE[b];
      byte b1 = 0;
      float f1 = 0.0F;
      while (true) {
        f2 = f1;
        if (b1 < 8) {
          f2 = arrayOfFloat1[b1] - arrayOfFloat[b1];
          f1 += f2 * f2;
          f2 = f1;
          if (f1 < f) {
            b1++;
            continue;
          } 
        } 
        break;
      } 
      f1 = f;
      if (f2 < f) {
        i = PDF417Common.SYMBOL_TABLE[b];
        f1 = f2;
      } 
      b++;
    } 
    return i;
  }
  
  private static int getDecodedCodewordValue(int[] paramArrayOfint) {
    int i = getBitValue(paramArrayOfint);
    return (PDF417Common.getCodeword(i) == -1) ? -1 : i;
  }
  
  static int getDecodedValue(int[] paramArrayOfint) {
    int i = getDecodedCodewordValue(sampleBitCounts(paramArrayOfint));
    return (i != -1) ? i : getClosestDecodedValue(paramArrayOfint);
  }
  
  private static int[] sampleBitCounts(int[] paramArrayOfint) {
    float f = MathUtils.sum(paramArrayOfint);
    int[] arrayOfInt = new int[8];
    byte b = 0;
    int i = 0;
    int j;
    for (j = 0; b < 17; j = m) {
      float f1 = f / 34.0F;
      float f2 = b * f / 17.0F;
      int k = i;
      int m = j;
      if ((paramArrayOfint[j] + i) <= f1 + f2) {
        k = i + paramArrayOfint[j];
        m = j + 1;
      } 
      arrayOfInt[m] = arrayOfInt[m] + 1;
      b++;
      i = k;
    } 
    return arrayOfInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\PDF417CodewordDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */