package com.herosdk.listener;

import android.util.Log;
import com.herosdk.bean.UserInfo;

class h implements Runnable {
  h(g paramg, ILoginListener paramILoginListener, UserInfo paramUserInfo, String paramString1, int paramInt, String paramString2) {}
  
  public void run() {
    if (g.a(this.f) != null) {
      Log.d(g.a(), "onResult...if");
      g.a(this.f).onResult(this.a, this.b, this.c, this.d, this.e);
      return;
    } 
    Log.d(g.a(), "onResult...else");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */