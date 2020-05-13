package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;

class cc implements Runnable {
  cc(cb paramcb, a parama) {}
  
  public void run() {
    String str;
    this.b.b.r();
    if (this.a != null && this.a.c()) {
      cm.a((Context)this.b.b.b, "bind_email" + (cq.a((Context)this.b.b.b)).a.o, this.b.a);
      bv.a(this.b.b.b, cr.class, this.b.b.z().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(true)).a("email", this.b.a), true);
      return;
    } 
    by by = this.b.b;
    if (this.a != null) {
      str = this.a.f();
    } else {
      str = this.b.b.e(2131165340);
    } 
    by.a(str);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */