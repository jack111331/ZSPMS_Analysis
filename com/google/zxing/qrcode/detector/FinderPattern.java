package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint {
  private final int count;
  
  private final float estimatedModuleSize;
  
  FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3) {
    this(paramFloat1, paramFloat2, paramFloat3, 1);
  }
  
  private FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
    super(paramFloat1, paramFloat2);
    this.estimatedModuleSize = paramFloat3;
    this.count = paramInt;
  }
  
  boolean aboutEquals(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (Math.abs(paramFloat2 - getY()) <= paramFloat1 && Math.abs(paramFloat3 - getX()) <= paramFloat1) {
      paramFloat1 = Math.abs(paramFloat1 - this.estimatedModuleSize);
      return (paramFloat1 <= 1.0F || paramFloat1 <= this.estimatedModuleSize);
    } 
    return false;
  }
  
  FinderPattern combineEstimate(float paramFloat1, float paramFloat2, float paramFloat3) {
    int i = this.count + 1;
    float f1 = this.count;
    float f2 = getX();
    float f3 = i;
    return new FinderPattern((f1 * f2 + paramFloat2) / f3, (this.count * getY() + paramFloat1) / f3, (this.count * this.estimatedModuleSize + paramFloat3) / f3, i);
  }
  
  int getCount() {
    return this.count;
  }
  
  public float getEstimatedModuleSize() {
    return this.estimatedModuleSize;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\detector\FinderPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */