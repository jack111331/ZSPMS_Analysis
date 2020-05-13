package com.herosdk;

import android.app.Activity;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.r;
import com.herosdk.d.x;

class k implements Runnable {
  k(HeroSdk paramHeroSdk, Activity paramActivity) {}
  
  public void run() {
    r.a().c();
    if (!x.a().o().booleanValue() && !x.a().s().booleanValue()) {
      PluginUtils.getInstance().invokePlugin(PluginNode.BEFORE_EXIT, new Object[] { this.a });
      HeroSdk.a(this.b).getSdk().exit(this.a);
      return;
    } 
    if (this.b.getExitListener() != null)
      this.b.getExitListener().onSuccess(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */