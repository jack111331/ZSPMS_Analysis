package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;

class fa implements Runnable {
  fa(ez paramez, a parama) {}
  
  public void run() {
    this.b.c.r();
    if (this.a.c()) {
      boolean bool;
      int i;
      this.b.c.a(this.b.c.e(2131165303));
      ew.d(this.b.c).a(this.b.a, this.b.b);
      String str = cq.a((Context)this.b.c.b).a();
      if (str != null && str.length() > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (cv.h() == null) {
        i = 0;
      } else {
        i = cv.h().j().c();
      } 
      if (i == 0) {
        i = 0;
      } else {
        i = 1;
      } 
      if (bool || i == 0) {
        bv.a(this.b.c.b, ha.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
        return;
      } 
      bv.a(this.b.c.b, db.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
      return;
    } 
    this.b.c.a(this.b.c.e(2131165304) + this.a.f());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */