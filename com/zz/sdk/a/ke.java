package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.b.a.v;
import com.zz.sdk.i.t;

class ke implements Runnable {
  ke(kc paramkc, String paramString1, String paramString2, String paramString3) {}
  
  public void run() {
    v v = t.a((Context)this.d.b).i(this.a, this.b, this.c);
    if (v.c()) {
      this.d.k.post(new kf(this));
      return;
    } 
    this.d.k.post(new kg(this, v));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */