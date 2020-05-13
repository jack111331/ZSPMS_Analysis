package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.b.a.z;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.lib.widget.a;

class de implements Runnable {
  de(dd paramdd, z paramz) {}
  
  public void run() {
    if (this.a.h() == 1)
      bg.l = true; 
    db.a(this.b.a, true);
    bg.k = true;
    cq.a((Context)this.b.a.b).a(this.a.g());
    this.b.a.r();
    a a = (new a((Context)this.b.a.b)).b(this.b.a.e(2131165299)).a(this.b.a.b.getString(ci.a((Context)this.b.a.b, 2131165326))).b(this.b.a.b.getString(ci.a((Context)this.b.a.b, 2131165251)), null);
    a.setOnDismissListener(new df(this));
    a.show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */