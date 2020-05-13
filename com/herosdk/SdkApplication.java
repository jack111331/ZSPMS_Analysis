package com.herosdk;

import android.content.Context;
import android.support.multidex.MultiDex;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.k;
import com.herosdk.d.o;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.error.a;
import com.tencent.tpshell.TPShellApplication;

public class SdkApplication extends TPShellApplication {
  protected void attachBaseContext(Context paramContext) {
    super.attachBaseContext(paramContext);
    MultiDex.install((Context)this);
    o.a();
    k.a().a(paramContext);
    a.a().a((Context)this);
    x.a().b(paramContext.getPackageName());
    x.a().d(paramContext);
    PluginUtils.getInstance().initPlugin(paramContext);
    try {
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_APPLICATION_ATTACH, new Object[] { paramContext });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onCreate() {
    super.onCreate();
    x.a().a((Context)this);
    try {
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_APPLICATION_CREATE, new Object[] { this });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\SdkApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */