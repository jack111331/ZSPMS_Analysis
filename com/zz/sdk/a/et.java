package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.at;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;
import com.zz.sdk.listener.a;

class et implements Runnable {
  et(eb parameb, String paramString, a parama) {}
  
  public void run() {
    a a1 = null;
    if (eb.c(this.c).equals("phoneLogin")) {
      a1 = (a)t.a((Context)this.c.b).a(a.class, at.l.a(), 1, new String[] { "phone", this.a });
    } else if (eb.c(this.c).equals("newPhoneBind")) {
      a1 = t.a((Context)this.c.b).g(cq.a((Context)this.c.b).v(), this.a);
    } else if (eb.c(this.c).equals("phoneBind")) {
      a1 = t.a((Context)this.c.b).g(cq.a((Context)this.c.b).v(), this.a);
    } else if (eb.c(this.c).equals("forgetPwd")) {
      a1 = t.a((Context)this.c.b).f(this.a);
    } else if (eb.c(this.c).equals("upgradeAccount")) {
      a1 = t.a((Context)this.c.b).g(cq.a((Context)this.c.b).v(), this.a);
    } 
    if (a1 != null)
      this.b.a(a1); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */