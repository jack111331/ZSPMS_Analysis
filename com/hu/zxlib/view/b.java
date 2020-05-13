package com.hu.zxlib.view;

import android.animation.ValueAnimator;

class b implements ValueAnimator.AnimatorUpdateListener {
  b(ViewfinderView paramViewfinderView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {
    ViewfinderView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */