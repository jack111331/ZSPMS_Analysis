package com.yingxiong.recordsdk;

import android.app.Application;
import android.content.Context;
import com.yingxiong.common.CrashHandler;

public class CrashApplication extends Application {
  public void onCreate() {
    super.onCreate();
    CrashHandler.getInstance().init((Context)this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\recordsdk\CrashApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */