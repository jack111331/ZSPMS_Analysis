package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern extends ResultPoint {
  private final float estimatedModuleSize;
  
  AlignmentPattern(float paramFloat1, float paramFloat2, float paramFloat3) {
    super(paramFloat1, paramFloat2);
    this.estimatedModuleSize = paramFloat3;
  }
  
  boolean aboutEquals(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (Math.abs(paramFloat2 - getY()) <= paramFloat1 && Math.abs(paramFloat3 - getX()) <= paramFloat1) {
      paramFloat1 = Math.abs(paramFloat1 - this.estimatedModuleSize);
      return (paramFloat1 <= 1.0F || paramFloat1 <= this.estimatedModuleSize);
    } 
    return false;
  }
  
  AlignmentPattern combineEstimate(float paramFloat1, float paramFloat2, float paramFloat3) {
    return new AlignmentPattern((getX() + paramFloat2) / 2.0F, (getY() + paramFloat1) / 2.0F, (this.estimatedModuleSize + paramFloat3) / 2.0F);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\detector\AlignmentPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */