package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import java.util.HashMap;

final class ad implements Runnable {
  ad(y paramy, b paramb, c paramc, String paramString, HashMap paramHashMap) {}
  
  public final void run() {
    Bundle bundle = this.a.a(this.b, this.c, (y.u(this.e)).p, this.d, (y.v(this.e)).m);
    Handler handler1 = y.w(this.e);
    Handler handler2 = y.w(this.e);
    if (bundle == null)
      bundle = null; 
    handler1.sendMessage(handler2.obtainMessage(0, bundle));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */