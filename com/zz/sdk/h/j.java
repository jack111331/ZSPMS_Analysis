package com.zz.sdk.h;

import android.content.Context;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.v;

class j implements Runnable {
  j(g paramg) {}
  
  public void run() {
    if (v.q) {
      g.b(this.a).setBackgroundDrawable(ca.e.a((Context)g.h(this.a)));
      return;
    } 
    g.b(this.a).setBackgroundDrawable(ca.d.a((Context)g.h(this.a)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */