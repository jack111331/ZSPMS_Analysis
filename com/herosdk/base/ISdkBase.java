package com.herosdk.base;

import android.app.Activity;

public interface ISdkBase {
  boolean callExtendApi(Activity paramActivity, int paramInt);
  
  void exit(Activity paramActivity);
  
  String getChannelVersion();
  
  void init(Activity paramActivity);
  
  boolean isChannelHasExitDialog();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\base\ISdkBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */