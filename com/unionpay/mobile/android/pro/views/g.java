package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import java.util.HashMap;

final class g implements Runnable {
  g(a parama, String paramString, HashMap paramHashMap) {}
  
  public final void run() {
    a a1 = this.c;
    String str = this.a;
    HashMap hashMap = (a.w(this.c)).p;
    Bundle bundle = a1.a(str, this.b);
    Handler handler1 = a.x(this.c);
    Handler handler2 = a.x(this.c);
    if (bundle == null)
      bundle = null; 
    handler1.sendMessage(handler2.obtainMessage(0, bundle));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */