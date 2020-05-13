package com.herosdk.listener;

import com.herosdk.HeroSdk;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;

class ae implements Runnable {
  ae(y paramy, String paramString) {}
  
  public void run() {
    if (!x.a().v()) {
      y.a(this.b).onCancel(this.a);
    } else if (HeroSdk.getInstance().getSinglePayListener() != null) {
      HeroSdk.getInstance().getSinglePayListener().onFailed("", this.a, -99999);
    } 
    try {
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_PAY, new Object[] { x.a().x(), PluginStatus.PAY_CANCEL, this.a, y.a(this.b, "", this.a) });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */