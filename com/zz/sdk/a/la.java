package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cq;

class la implements Runnable {
  la(kz paramkz, a parama) {}
  
  public void run() {
    String str;
    this.b.a.r();
    if (this.a != null && this.a.c()) {
      cq.a((Context)this.b.a.b).a(ky.a(this.b.a));
      bv.a(this.b.a.b, li.class, bv.a().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(false)));
      return;
    } 
    Activity activity = this.b.a.b;
    if (this.a != null) {
      str = this.a.f();
    } else {
      str = this.b.a.e(2131165285);
    } 
    Toast.makeText((Context)activity, str, 1).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\la.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */