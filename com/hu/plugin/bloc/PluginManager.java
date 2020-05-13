package com.hu.plugin.bloc;

import android.util.Log;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.listener.IPluginInitListener;

public class PluginManager implements IPluginInitListener {
  public static final String TAG = "plugin.bloc";
  
  public void registerPlugins(PluginUtils paramPluginUtils) {
    Log.d("plugin.bloc", "=>registerPlugins");
    paramPluginUtils.addPlugin(PluginNode.AFTER_INIT, new AfterInitPlugin());
    paramPluginUtils.addPlugin(PluginNode.SUBMIT_ROLE_INFO, new SubmitRoleInfoPlugin());
    paramPluginUtils.addPlugin(PluginNode.ON_ACTIVITY_RESULT, new OnActivityResultPlugin());
    paramPluginUtils.addPlugin(PluginNode.ON_DESTROY, new OnDestroyPlugin());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\plugin\bloc\PluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */