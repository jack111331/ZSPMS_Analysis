package com.hu.plugin.bloc;

import android.app.Activity;
import android.util.Log;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IPluginListener;

public class OnDestroyPlugin implements IPluginListener {
  public void invokePlugin(Object... paramVarArgs) {
    try {
      Activity activity = (Activity)paramVarArgs[0];
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d("plugin.bloc", stringBuilder.append("call OnDestroyPlugin, activity = ").append(activity).toString());
      BlocSdk.onDestroy(activity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\plugin\bloc\OnDestroyPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */