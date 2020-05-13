package org.jar.support.v4.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
  private TimeInterpolator mDefaultInterpolator;
  
  public void clearInterpolator(View paramView) {
    if (this.mDefaultInterpolator == null)
      this.mDefaultInterpolator = (new ValueAnimator()).getInterpolator(); 
    paramView.animate().setInterpolator(this.mDefaultInterpolator);
  }
  
  public ValueAnimatorCompat emptyValueAnimator() {
    return new HoneycombValueAnimatorCompat((Animator)ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
  }
  
  static class AnimatorListenerCompatWrapper implements Animator.AnimatorListener {
    final ValueAnimatorCompat mValueAnimatorCompat;
    
    final AnimatorListenerCompat mWrapped;
    
    public AnimatorListenerCompatWrapper(AnimatorListenerCompat param1AnimatorListenerCompat, ValueAnimatorCompat param1ValueAnimatorCompat) {
      this.mWrapped = param1AnimatorListenerCompat;
      this.mValueAnimatorCompat = param1ValueAnimatorCompat;
    }
    
    public void onAnimationCancel(Animator param1Animator) {
      this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
    }
    
    public void onAnimationEnd(Animator param1Animator) {
      this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
    }
    
    public void onAnimationRepeat(Animator param1Animator) {
      this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
    }
    
    public void onAnimationStart(Animator param1Animator) {
      this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
    }
  }
  
  static class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
    final Animator mWrapped;
    
    public HoneycombValueAnimatorCompat(Animator param1Animator) {
      this.mWrapped = param1Animator;
    }
    
    public void addListener(AnimatorListenerCompat param1AnimatorListenerCompat) {
      this.mWrapped.addListener(new HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper(param1AnimatorListenerCompat, this));
    }
    
    public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListener) {
      if (this.mWrapped instanceof ValueAnimator)
        ((ValueAnimator)this.mWrapped).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
              public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                animatorUpdateListener.onAnimationUpdate(HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.this);
              }
            }); 
    }
    
    public void cancel() {
      this.mWrapped.cancel();
    }
    
    public float getAnimatedFraction() {
      return ((ValueAnimator)this.mWrapped).getAnimatedFraction();
    }
    
    public void setDuration(long param1Long) {
      this.mWrapped.setDuration(param1Long);
    }
    
    public void setTarget(View param1View) {
      this.mWrapped.setTarget(param1View);
    }
    
    public void start() {
      this.mWrapped.start();
    }
  }
  
  class null implements ValueAnimator.AnimatorUpdateListener {
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      animatorUpdateListener.onAnimationUpdate(this.this$0);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\animation\HoneycombMr1AnimatorCompatProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */