package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;

class gf implements Runnable {
  gf(ge paramge, a parama) {}
  
  public void run() {
    if (this.b.a.h == 0) {
      cq.a((Context)this.b.b.b, this.a, this.b.b.l, fr.e(this.b.b), false);
    } else if (this.b.a.h == 1) {
      cq.a((Context)this.b.b.b, this.a, this.b.b.l, new gg(this), true);
    } else {
      cq.a((Context)this.b.b.b, this.a, this.b.b.l, null, false);
    } 
    if (this.b.a.h != 1)
      h.a((Context)this.b.b.b, this.a, this.b.a, this.b.b.z(), this.b.b, this.b.b); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */