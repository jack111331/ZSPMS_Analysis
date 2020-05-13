package com.zz.sdk.a;

import android.animation.Animator;

class gk implements Animator.AnimatorListener {
  gk(gh paramgh) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {
    gh.c = false;
    gh.a(this.a, bv.a(gh.b(this.a)));
    gh.h(this.a).postDelayed(gh.g(this.a), 500L);
    gh.h(this.a).postDelayed(gh.i(this.a), 1500L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {
    gh.c = false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */