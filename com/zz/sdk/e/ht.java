package com.zz.sdk.e;

import com.alipay.sdk.app.PayTask;
import com.zz.sdk.i.bp;

class ht implements Runnable {
  ht(hg paramhg, String paramString) {}
  
  public void run() {
    bp.a("payInfo= " + this.a);
    String str = (new PayTask(this.b.getActivity())).pay(this.a, true);
    bp.a("ali: " + str);
    hg.e(this.b).post(new hu(this, str));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */