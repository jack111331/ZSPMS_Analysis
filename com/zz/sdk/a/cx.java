package com.zz.sdk.a;

import com.zz.sdk.b.a.v;

class cx implements Runnable {
  cx(cs paramcs, String paramString1, String paramString2, String paramString3) {}
  
  public void run() {
    v v = cs.c(this.d).i(this.a, this.b, this.c);
    if (v.c()) {
      this.d.k.post(new cy(this));
      return;
    } 
    this.d.k.post(new cz(this, v));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */