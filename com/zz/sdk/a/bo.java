package com.zz.sdk.a;

import android.content.Context;
import android.util.Log;
import com.zz.sdk.b.a.aj;
import com.zz.sdk.i.cq;

class bo implements Runnable {
  bo(bn parambn, aj paramaj) {}
  
  public void run() {
    this.b.b.r();
    if (this.a.c()) {
      if (!this.a.o) {
        boolean bool;
        String str = cq.a((Context)this.b.b.b).a();
        if (str != null && str.length() > 0) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool || this.b.a.j().c() == 0) {
          bv.a(this.b.b.b, ha.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)).a("payLayout", bm.a(this.b.b)).a("realnameType", Integer.valueOf(1)), true);
          return;
        } 
        bv.a(this.b.b.b, db.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)).a("payLayout", bm.a(this.b.b)).a("realnameType", Integer.valueOf(1)), true);
        return;
      } 
      if (this.b.a.l() == 0) {
        bv.f(this.b.b.b);
        return;
      } 
      if (this.a.p) {
        bv.f(this.b.b.b);
        return;
      } 
      bv.f(this.b.b.b);
      return;
    } 
    Log.e("zz_sdk", "checkRealName fail:" + this.a.f());
    bv.f(this.b.b.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */