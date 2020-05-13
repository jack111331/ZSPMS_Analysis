package com.zz.sdk.e;

import com.zz.sdk.i.bp;

class bl implements Runnable {
  bl(bi parambi) {}
  
  public void run() {
    if (bi.b(this.a) != null && bi.b(this.a).isShowing()) {
      try {
        bi.b(this.a).cancel();
      } catch (Exception exception) {
        bp.a(exception.getClass().getName());
      } 
      this.a.a("正在登录……", new bm(this));
      bi.a(this.a, bi.d(this.a), bi.e(this.a));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */