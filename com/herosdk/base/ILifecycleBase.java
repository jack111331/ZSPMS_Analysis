package com.herosdk.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public interface ILifecycleBase {
  void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  void onApplicationInit(Context paramContext);
  
  void onCreate(Activity paramActivity);
  
  void onDestroy(Activity paramActivity);
  
  void onNewIntent(Activity paramActivity, Intent paramIntent);
  
  void onPause(Activity paramActivity);
  
  void onRestart(Activity paramActivity);
  
  void onResume(Activity paramActivity);
  
  void onStart(Activity paramActivity);
  
  void onStop(Activity paramActivity);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\base\ILifecycleBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */