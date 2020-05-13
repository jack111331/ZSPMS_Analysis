package com.herosdk;

import android.view.animation.Animation;

class m implements Animation.AnimationListener {
  m(SdkSplashActivity paramSdkSplashActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation) {
    SdkSplashActivity.a(this.b).setVisibility(4);
    SdkSplashActivity.a(this.b, false);
    SdkSplashActivity.a(this.b, this.a + 1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */