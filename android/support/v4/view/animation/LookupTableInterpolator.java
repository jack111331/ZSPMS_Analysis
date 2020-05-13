package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
  private final float mStepSize;
  
  private final float[] mValues;
  
  public LookupTableInterpolator(float[] paramArrayOffloat) {
    this.mValues = paramArrayOffloat;
    this.mStepSize = 1.0F / (this.mValues.length - 1);
  }
  
  public float getInterpolation(float paramFloat) {
    float f = 1.0F;
    if (paramFloat >= 1.0F)
      return f; 
    if (paramFloat <= 0.0F)
      return 0.0F; 
    int i = Math.min((int)((this.mValues.length - 1) * paramFloat), this.mValues.length - 2);
    f = (paramFloat - i * this.mStepSize) / this.mStepSize;
    paramFloat = this.mValues[i];
    return (this.mValues[i + 1] - this.mValues[i]) * f + paramFloat;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\animation\LookupTableInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */