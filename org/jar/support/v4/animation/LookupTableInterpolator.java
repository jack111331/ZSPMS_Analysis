package org.jar.support.v4.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
  private final float mStepSize;
  
  private final float[] mValues;
  
  public LookupTableInterpolator(float[] paramArrayOffloat) {
    this.mValues = paramArrayOffloat;
    this.mStepSize = 1.0F / (this.mValues.length - 1);
  }
  
  public float getInterpolation(float paramFloat) {
    if (paramFloat >= 1.0F)
      return 1.0F; 
    if (paramFloat <= 0.0F)
      return 0.0F; 
    int i = Math.min((int)((this.mValues.length - 1) * paramFloat), this.mValues.length - 2);
    paramFloat = (paramFloat - i * this.mStepSize) / this.mStepSize;
    return this.mValues[i] + paramFloat * (this.mValues[i + 1] - this.mValues[i]);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\animation\LookupTableInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */