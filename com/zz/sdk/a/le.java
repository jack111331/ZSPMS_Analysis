package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.i.ci;

class le implements Runnable {
  le(ld paramld) {}
  
  public void run() {
    ky.c(this.a.a).setText(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165247), new Object[] { ky.e(this.a.a) + "" }));
    if (ky.e(this.a.a) == 0) {
      ky.f(this.a.a);
      ky.g(this.a.a);
      if (ky.h(this.a.a) < 2) {
        ky.c(this.a.a).setText(this.a.a.e(2131165218));
      } else {
        ky.c(this.a.a).setText(this.a.a.e(2131165219));
      } 
      ky.c(this.a.a).setEnabled(true);
      ky.a(this.a.a, 60);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\le.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */