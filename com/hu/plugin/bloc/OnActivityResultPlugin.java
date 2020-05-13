package com.hu.plugin.bloc;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IPluginListener;

public class OnActivityResultPlugin implements IPluginListener {
  public void invokePlugin(Object... paramVarArgs) {
    try {
      Activity activity = (Activity)paramVarArgs[0];
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d("plugin.bloc", stringBuilder.append("call OnActivityResultPlugin, activity = ").append(activity).toString());
      BlocSdk.onActivityResult(((Integer)paramVarArgs[1]).intValue(), ((Integer)paramVarArgs[2]).intValue(), (Intent)paramVarArgs[3]);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\plugin\bloc\OnActivityResultPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */