package com.zz.sdk.a;

import android.text.TextUtils;
import com.zz.sdk.b.a.r;

class du implements Runnable {
  du(dt paramdt, r paramr) {}
  
  public void run() {
    String str;
    if (this.a == null) {
      str = "";
    } else {
      str = this.a.h();
    } 
    if (!TextUtils.isEmpty(str)) {
      this.b.a.r();
      hp.a(this.b.a.b, str).setOnDismissListener(new dv(this));
      return;
    } 
    ds.a(this.b.a, this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */