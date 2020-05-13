package com.unionpay.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class at implements Application.ActivityLifecycleCallbacks {
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {
    w.a(paramActivity.getLocalClassName(), false);
  }
  
  public final void onActivityResumed(Activity paramActivity) {
    w.a(paramActivity, paramActivity.getLocalClassName(), false);
    ab.f = true;
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */