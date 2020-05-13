package com.zz.sdk.a;

import android.content.Context;
import android.widget.Toast;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.h;

class eo implements Runnable {
  eo(en paramen, a parama) {}
  
  public void run() {
    this.b.c.r();
    if (this.a != null && this.a.c()) {
      Toast.makeText((Context)this.b.c.b, this.b.c.e(2131165278), 0).show();
      bv.a(this.b.c.b, cs.class, this.b.c.z().a("type", "email").a("email", this.b.a).a("code", this.b.b), true);
      return;
    } 
    h.a((Context)this.b.c.b, this.a, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */