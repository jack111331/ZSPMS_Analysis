package com.herosdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.herosdk.b.a;
import com.herosdk.bean.e;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.bb;
import com.herosdk.d.x;

class c implements Runnable {
  c(HeroSdk paramHeroSdk, Activity paramActivity) {}
  
  public void run() {
    a.a().b((Context)this.a, "login");
    e e = x.a().k();
    if (e != null && e.a().booleanValue()) {
      Log.d("frameLib.HeroSdk", "login is been forbidden");
      bb.a(this.a, e.b(), Boolean.valueOf(false));
      return;
    } 
    if (x.a().o().booleanValue()) {
      bb.a((Context)this.a, x.a().p().b(), Boolean.valueOf(true));
      return;
    } 
    PluginUtils.getInstance().invokePlugin(PluginNode.BEFORE_LOGIN, new Object[] { this.a });
    Log.d("frameLib.HeroSdk", "channel login");
    HeroSdk.a(this.b).getUser().login(this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */