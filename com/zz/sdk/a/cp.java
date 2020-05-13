package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;

class cp implements Runnable {
  cp(co paramco, a parama) {}
  
  public void run() {
    String str;
    this.b.a.r();
    if (this.a != null && this.a.c()) {
      cm.a((Context)this.b.a.b, "bind_email" + (cq.a((Context)this.b.a.b)).a.o, cn.a(this.b.a));
      bv.a(this.b.a.b, cr.class, this.b.a.z().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(true)).a("email", cn.a(this.b.a)), true);
      return;
    } 
    cn cn = this.b.a;
    if (this.a != null) {
      str = this.a.f();
    } else {
      str = this.b.a.e(2131165340);
    } 
    cn.a(str);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */