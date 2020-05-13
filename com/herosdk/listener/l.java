package com.herosdk.listener;

import android.util.Log;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;

class l implements Runnable {
  l(k paramk, IPayListener paramIPayListener, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo, String paramString1, int paramInt, String paramString2) {}
  
  public void run() {
    if (k.a(this.g) != null) {
      Log.d(k.a(), "onResult...if");
      k.a(this.g).onResult(this.a, this.b, this.c, this.d, this.e, this.f);
      return;
    } 
    Log.d(k.a(), "onResult...else");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */