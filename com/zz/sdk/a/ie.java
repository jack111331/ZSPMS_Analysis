package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cq;

class ie implements Runnable {
  ie(id paramid, a parama) {}
  
  public void run() {
    String str;
    this.b.b.r();
    if (this.a != null && this.a.c()) {
      this.b.b.b(2131165274);
      cq.a((Context)this.b.b.b).a(this.b.a);
      if (hy.a(this.b.b)) {
        bv.a(this.b.b.b, ha.class, this.b.b.z().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)), true);
        return;
      } 
      bv.d(this.b.b.b);
      return;
    } 
    Activity activity = this.b.b.b;
    StringBuilder stringBuilder = (new StringBuilder()).append(this.b.b.e(2131165285));
    if (this.a != null) {
      str = ":" + this.a.f();
    } else {
      str = "";
    } 
    Toast.makeText((Context)activity, stringBuilder.append(str).toString(), 1).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */