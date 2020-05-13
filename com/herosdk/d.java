package com.herosdk;

import android.app.Activity;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.x;

class d implements Runnable {
  d(HeroSdk paramHeroSdk, Activity paramActivity) {}
  
  public void run() {
    if (!x.a().o().booleanValue() && !x.a().s().booleanValue()) {
      PluginUtils.getInstance().invokePlugin(PluginNode.BEFORE_LOGOUT, new Object[] { this.a });
      HeroSdk.a(this.b).getUser().logout(this.a);
      return;
    } 
    if (this.b.getLogoutListener() != null)
      this.b.getLogoutListener().onSuccess(); 
    PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_LOGOUT, new Object[] { this.a, PluginStatus.LOGOUT_SUCCESS });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */