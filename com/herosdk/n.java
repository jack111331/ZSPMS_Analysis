package com.herosdk;

import android.app.Activity;
import android.util.Log;
import com.herosdk.bean.c;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.f;

class n implements f {
  n(SdkSplashActivity paramSdkSplashActivity, Activity paramActivity) {}
  
  public void a(int paramInt, String paramString) {
    Log.d("frameLib.Splash", "dSplhI...f code:" + paramInt + ",msg:" + paramString);
    x.a().a(2);
    x.a().a(paramInt, paramString);
  }
  
  public void a(c paramc) {
    try {
      Log.d("frameLib.Splash", "dSplhI...s");
      x.a().a(paramc);
      x.a().a(1);
      if (x.a().J())
        x.a().d(this.a); 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */