package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.i.ci;

class ji implements Runnable {
  ji(jh paramjh) {}
  
  public void run() {
    this.a.a.p.setText(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165247), new Object[] { iz.e(this.a.a) + "" }));
    if (iz.e(this.a.a) == 0) {
      iz.f(this.a.a);
      if (!iz.g(this.a.a)) {
        this.a.a.p.setText(this.a.a.e(2131165218));
      } else {
        this.a.a.p.setText(this.a.a.e(2131165219));
      } 
      this.a.a.p.setEnabled(true);
      iz.a(this.a.a, 90);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */