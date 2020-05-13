package com.herosdk.listener;

import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.x;

class w implements Runnable {
  w(v paramv) {}
  
  public void run() {
    if (v.a(this.a) != null)
      v.a(this.a).onSuccess(); 
    PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_LOGOUT, new Object[] { x.a().x(), PluginStatus.LOGOUT_SUCCESS });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */