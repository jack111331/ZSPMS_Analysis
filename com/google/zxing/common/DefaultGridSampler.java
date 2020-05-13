package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler extends GridSampler {
  public BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16) throws NotFoundException {
    return sampleGrid(paramBitMatrix, paramInt1, paramInt2, PerspectiveTransform.quadrilateralToQuadrilateral(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16));
  }
  
  public BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform) throws NotFoundException {
    if (paramInt1 > 0 && paramInt2 > 0) {
      BitMatrix bitMatrix = new BitMatrix(paramInt1, paramInt2);
      float[] arrayOfFloat = new float[paramInt1 * 2];
      for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
        int i = arrayOfFloat.length;
        float f = paramInt1;
        byte b;
        for (b = 0; b < i; b += 2) {
          arrayOfFloat[b] = (b / 2) + 0.5F;
          arrayOfFloat[b + 1] = f + 0.5F;
        } 
        paramPerspectiveTransform.transformPoints(arrayOfFloat);
        checkAndNudgePoints(paramBitMatrix, arrayOfFloat);
        b = 0;
        while (b < i) {
          try {
            if (paramBitMatrix.get((int)arrayOfFloat[b], (int)arrayOfFloat[b + 1]))
              bitMatrix.set(b / 2, paramInt1); 
            b += 2;
          } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw NotFoundException.getNotFoundInstance();
          } 
        } 
      } 
      return bitMatrix;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\DefaultGridSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */