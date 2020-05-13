package com.herosdk.listener;

import android.util.Log;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.bb;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;

public class b implements IExitListener {
  private static String a = "frameLib.EL";
  
  private IExitListener b = null;
  
  public b(IExitListener paramIExitListener) {
    this.b = paramIExitListener;
  }
  
  public void onFailed(String paramString) {
    Log.d(a, "onFailed msg:" + paramString);
    bb.a(new d(this, paramString));
    try {
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_EXIT, new Object[] { x.a().x(), PluginStatus.EXIT_FAILED });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onSuccess() {
    Log.d(a, "onSuccess");
    bb.a(new c(this));
    try {
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_EXIT, new Object[] { x.a().x(), PluginStatus.EXIT_SUCCESS });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */