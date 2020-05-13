package com.zz.sdk.h;

import android.content.Context;
import com.zz.sdk.SDKManager;
import com.zz.sdk.b.a.e;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;

class i implements Runnable {
  i(g paramg) {}
  
  public void run() {
    g.a(this.a, String.valueOf(System.currentTimeMillis() / 1000L));
    g.b(this.a, cq.a((Context)g.h(this.a)).v());
    bp.a("token: " + g.i(this.a));
    if (g.i(this.a) == null)
      g.b(this.a, ""); 
    e e = (new t((Context)g.h(this.a))).a(new String[] { 
          "productid", SDKManager.getProductId((Context)g.h(this.a)), "os", "1", "service", g.j(this.a), "serviceid", SDKManager.getGameServerId((Context)g.h(this.a)), "access_token", g.i(this.a), 
          "platform", "android", "timestamp", g.k(this.a), "sign", g.l(this.a) });
    if (e.a) {
      bp.a("红点访问网络: " + e.c + " : " + e.d + " : " + e.e);
      g.a(this.a, e.c);
      g.e(this.a, e.d);
      g.f(this.a, e.e);
      if (this.a.c != null)
        this.a.c.sendEmptyMessage(5); 
      return;
    } 
    bp.a("红点访问网络失败: " + e.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */