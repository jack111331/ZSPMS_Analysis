package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cq;

class ag implements Runnable {
  ag(af paramaf, a parama) {}
  
  public void run() {
    String str;
    this.b.b.r();
    if (this.a != null && this.a.c()) {
      cq.a((Context)this.b.b.b).a(this.b.a);
      bv.a(this.b.b.b, ax.class, this.b.b.z(), true);
      return;
    } 
    Activity activity = this.b.b.b;
    if (this.a != null) {
      str = this.a.f();
    } else {
      str = this.b.b.e(2131165382);
    } 
    Toast.makeText((Context)activity, str, 1).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */