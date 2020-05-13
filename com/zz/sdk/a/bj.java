package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.i.ci;

class bj implements Runnable {
  bj(bi parambi) {}
  
  public void run() {
    this.a.a.p.setText(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165247), new Object[] { ay.e(this.a.a) + "" }));
    if (ay.e(this.a.a) == 0) {
      ay.f(this.a.a);
      this.a.a.p.setEnabled(true);
      if (!ay.g(this.a.a)) {
        this.a.a.p.setText(this.a.a.e(2131165218));
      } else {
        this.a.a.p.setText(this.a.a.e(2131165219));
      } 
      ay.a(this.a.a, 90);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */