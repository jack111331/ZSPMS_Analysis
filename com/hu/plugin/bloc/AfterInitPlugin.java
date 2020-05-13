package com.hu.plugin.bloc;

import android.app.Activity;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IPluginListener;

public class AfterInitPlugin implements IPluginListener {
  public void invokePlugin(Object... paramVarArgs) {
    try {
      Log.d("plugin.bloc", "call AfterInitPlugin");
      Activity activity = (Activity)paramVarArgs[0];
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d("plugin.bloc", stringBuilder.append("call AfterInitPlugin, activity = ").append(activity).toString());
      String str1 = HeroSdk.getInstance().getCustomParams("hu_bloc_app_key");
      String str2 = HeroSdk.getInstance().getCustomParams("hu_bloc_game_id");
      int i = HeroSdk.getInstance().getChannelId();
      boolean bool = HeroSdk.getInstance().getBlocDebugMode();
      stringBuilder = new StringBuilder();
      this();
      Log.d("plugin.bloc", stringBuilder.append("call AfterInitPlugin...isDebugMode:").append(bool).toString());
      BlocSdk.init(activity, str1, str2, String.valueOf(i), bool);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\plugin\bloc\AfterInitPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */