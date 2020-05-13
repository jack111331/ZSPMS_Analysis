package com.herosdk.listener;

import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.x;

class u implements Runnable {
  u(r paramr) {}
  
  public void run() {
    if (r.a(this.a) != null)
      r.a(this.a).onCancel(); 
    PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_LOGIN, new Object[] { x.a().x(), PluginStatus.LOGIN_CANCEL });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listene\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */