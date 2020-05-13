package com.herosdk;

import android.app.Activity;
import android.util.Log;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.am;
import com.herosdk.d.g;
import com.herosdk.d.k;
import com.herosdk.d.x;

class b implements Runnable {
  b(HeroSdk paramHeroSdk, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void run() {
    boolean bool;
    if (this.a == null) {
      Log.d("frameLib.HeroSdk", "init but activity is null error");
      return;
    } 
    x.a().a(this.a);
    PluginUtils.getInstance().invokePlugin(PluginNode.BEFORE_INIT, new Object[] { this.a });
    k.a().c(am.h(this.b));
    k.a().b(am.i(this.c));
    x x = x.a();
    if ((this.a.getResources().getConfiguration()).orientation == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    x.a(bool);
    x.a().b(this.a);
    if (x.a().o().booleanValue() || g.a().d().booleanValue()) {
      if (this.d.getInitListener() != null)
        this.d.getInitListener().onSuccess(); 
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_INIT, new Object[] { x.a().x(), PluginStatus.INIT_SUCCESS });
      return;
    } 
    PluginUtils.getInstance().invokePlugin(PluginNode.BEFORE_CHANNEL_INIT, new Object[] { this.a });
    HeroSdk.a(this.d).getSdk().init(this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */