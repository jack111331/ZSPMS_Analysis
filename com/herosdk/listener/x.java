package com.herosdk.listener;

import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;

class x implements Runnable {
  x(v paramv, String paramString) {}
  
  public void run() {
    if (v.a(this.b) != null)
      v.a(this.b).onFailed(this.a); 
    PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_LOGOUT, new Object[] { com.herosdk.d.x.a().x(), PluginStatus.LOGOUT_FAILED });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */