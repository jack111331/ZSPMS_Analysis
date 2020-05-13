package com.zz.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.h;

class gz implements Runnable {
  gz(gy paramgy, a parama) {}
  
  public void run() {
    this.b.b.r();
    if (this.a != null && this.a.c()) {
      bx bx = this.b.b.z();
      bx.a("phone", this.b.a);
      if (TextUtils.isEmpty(gu.b(this.b.b))) {
        bx.a("action", "newPhoneBind");
      } else {
        bx.a("action", gu.b(this.b.b));
      } 
      bv.a(this.b.b.b, eb.class, bx);
      return;
    } 
    if (this.a.h == 5) {
      bv.a(this.b.b.b, lh.class, bv.a().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(false)).a("phone", this.b.a).a("boundAccount", this.a.j));
      return;
    } 
    h.a((Context)this.b.b.b, this.a, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */