package com.haru.herousdk;

import android.content.Context;
import com.herosdk.SdkApplication;
import com.yingxiong.common.CrashHandler;

public class HaruApplication extends SdkApplication {
  public void onCreate() {
    super.onCreate();
    CrashHandler.getInstance().init((Context)this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\haru\herousdk\HaruApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */