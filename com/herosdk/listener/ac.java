package com.herosdk.listener;

import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.bean.RoleInfo;
import com.herosdk.d.e;
import com.herosdk.d.x;

class ac implements Runnable {
  ac(ab paramab, String paramString1, String paramString2, int paramInt) {}
  
  public void run() {
    y.b(this.d.b);
    if (y.c(this.d.b) <= 10) {
      Log.d(y.a(), "cspr...do check again");
      RoleInfo roleInfo = x.a().i();
      if (x.a().h() != null && roleInfo != null && !TextUtils.isEmpty(roleInfo.getRoleId()) && roleInfo.getRoleId().equals(this.d.a)) {
        y.a(this.d.b, this.d.a, this.a, this.b);
        return;
      } 
      y.a(this.d.b, 0);
      e.a().a(this.a, this.b);
      return;
    } 
    Log.d(y.a(), "cspr...check finish");
    y.a(this.d.b, 0);
    if (HeroSdk.getInstance().getSinglePayListener() != null) {
      Log.d(y.a(), "cspr...check finish,onFailed,return");
      e.a().a(this.a, this.b);
      HeroSdk.getInstance().getSinglePayListener().onFailed(this.a, this.b, this.c);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */