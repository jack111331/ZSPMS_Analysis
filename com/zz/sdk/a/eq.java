package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.i.ci;

class eq implements Runnable {
  eq(ep paramep) {}
  
  public void run() {
    eb.g(this.a.a).setText(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165371), new Object[] { String.valueOf(eb.f(this.a.a)) }));
    if (eb.f(this.a.a) == 0) {
      eb.h(this.a.a);
      eb.i(this.a.a);
      if (eb.j(this.a.a) < 2) {
        eb.g(this.a.a).setText(ci.a((Context)this.a.a.b, 2131165384));
      } else {
        eb.g(this.a.a).setText(ci.a((Context)this.a.a.b, 2131165219));
      } 
      eb.g(this.a.a).setEnabled(true);
      eb.a(this.a.a, 60);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */