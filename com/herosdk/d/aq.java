package com.herosdk.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.herosdk.HeroSdk;

class aq implements Application.ActivityLifecycleCallbacks {
  aq(ap paramap) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {
    ap.a(this.a, true);
    if (ap.b(this.a) != null)
      ap.c(this.a).removeCallbacks(ap.b(this.a)); 
    ap.c(this.a).postDelayed(ap.a(this.a, new ar(this)), 500L);
  }
  
  public void onActivityResumed(Activity paramActivity) {
    boolean bool;
    ap.a(this.a, false);
    if (!ap.a(this.a)) {
      bool = true;
    } else {
      bool = false;
    } 
    ap.b(this.a, true);
    if (ap.b(this.a) != null)
      ap.c(this.a).removeCallbacks(ap.b(this.a)); 
    if (bool) {
      Log.d("frameLib.rous", "b2f");
      this.a.d();
      if (HeroSdk.getInstance().getUserInfo() != null && ap.d(this.a).booleanValue()) {
        ap.a(this.a, Boolean.valueOf(false));
        this.a.a(ap.e(this.a), ap.f(this.a));
      } 
      return;
    } 
    Log.d("frameLib.rous", "still in f");
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */