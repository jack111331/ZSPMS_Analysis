package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {
  private static final float MAX_AVG_VARIANCE = 0.2F;
  
  private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713F;
  
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.45F;
  
  private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667F;
  
  private final int[] dataCharacterCounters = new int[8];
  
  private final int[] decodeFinderCounters = new int[4];
  
  private final int[] evenCounts = new int[this.dataCharacterCounters.length / 2];
  
  private final float[] evenRoundingErrors = new float[4];
  
  private final int[] oddCounts = new int[this.dataCharacterCounters.length / 2];
  
  private final float[] oddRoundingErrors = new float[4];
  
  @Deprecated
  protected static int count(int[] paramArrayOfint) {
    return MathUtils.sum(paramArrayOfint);
  }
  
  protected static void decrement(int[] paramArrayOfint, float[] paramArrayOffloat) {
    float f = paramArrayOffloat[0];
    byte b1 = 1;
    byte b2 = 0;
    while (b1 < paramArrayOfint.length) {
      float f1 = f;
      if (paramArrayOffloat[b1] < f) {
        f1 = paramArrayOffloat[b1];
        b2 = b1;
      } 
      b1++;
      f = f1;
    } 
    paramArrayOfint[b2] = paramArrayOfint[b2] - 1;
  }
  
  protected static void increment(int[] paramArrayOfint, float[] paramArrayOffloat) {
    float f = paramArrayOffloat[0];
    byte b1 = 1;
    byte b2 = 0;
    while (b1 < paramArrayOfint.length) {
      float f1 = f;
      if (paramArrayOffloat[b1] > f) {
        f1 = paramArrayOffloat[b1];
        b2 = b1;
      } 
      b1++;
      f = f1;
    } 
    paramArrayOfint[b2] = paramArrayOfint[b2] + 1;
  }
  
  protected static boolean isFinderPattern(int[] paramArrayOfint) {
    int i = paramArrayOfint[0] + paramArrayOfint[1];
    int j = paramArrayOfint[2];
    int k = paramArrayOfint[3];
    float f = i / (j + i + k);
    if (f >= 0.7916667F && f <= 0.89285713F) {
      int m = Integer.MIN_VALUE;
      int n = paramArrayOfint.length;
      i = 0;
      for (k = Integer.MAX_VALUE; i < n; k = i2) {
        int i1 = paramArrayOfint[i];
        j = m;
        if (i1 > m)
          j = i1; 
        int i2 = k;
        if (i1 < k)
          i2 = i1; 
        i++;
        m = j;
      } 
      return (m < k * 10);
    } 
    return false;
  }
  
  protected static int parseFinderValue(int[] paramArrayOfint, int[][] paramArrayOfint1) throws NotFoundException {
    for (byte b = 0; b < paramArrayOfint1.length; b++) {
      if (patternMatchVariance(paramArrayOfint, paramArrayOfint1[b], 0.45F) < 0.2F)
        return b; 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected final int[] getDataCharacterCounters() {
    return this.dataCharacterCounters;
  }
  
  protected final int[] getDecodeFinderCounters() {
    return this.decodeFinderCounters;
  }
  
  protected final int[] getEvenCounts() {
    return this.evenCounts;
  }
  
  protected final float[] getEvenRoundingErrors() {
    return this.evenRoundingErrors;
  }
  
  protected final int[] getOddCounts() {
    return this.oddCounts;
  }
  
  protected final float[] getOddRoundingErrors() {
    return this.oddRoundingErrors;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\AbstractRSSReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */