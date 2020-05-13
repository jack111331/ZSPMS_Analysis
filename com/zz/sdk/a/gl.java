package com.zz.sdk.a;

import android.animation.Animator;

class gl implements Animator.AnimatorListener {
  gl(gh paramgh, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {
    gh.c = true;
    try {
      gh.f(this.b).removeView(gh.e(this.b));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    if (!this.a && (gh.j(this.b) || bv.b(gh.b(this.b)) <= 0))
      bv.d(gh.b(this.b)); 
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */