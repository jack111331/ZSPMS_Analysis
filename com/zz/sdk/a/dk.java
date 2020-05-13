package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.i.ci;

class dk implements Runnable {
  dk(dj paramdj) {}
  
  public void run() {
    db.n(this.a.a).setText(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165247), new Object[] { db.p(this.a.a) + "" }));
    if (db.p(this.a.a) == 0) {
      db.q(this.a.a);
      db.r(this.a.a);
      if (db.s(this.a.a) < 2) {
        db.n(this.a.a).setText(this.a.a.e(2131165218));
      } else {
        db.n(this.a.a).setText(this.a.a.e(2131165219));
      } 
      db.n(this.a.a).setEnabled(true);
      db.a(this.a.a, 60);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */