package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import java.util.HashMap;

final class s implements Runnable {
  s(k paramk, String paramString, HashMap paramHashMap) {}
  
  public final void run() {
    k k1 = this.c;
    String str = this.a;
    HashMap hashMap = (k.v(this.c)).p;
    Bundle bundle = k1.a(str, this.b);
    Handler handler2 = k.w(this.c);
    Handler handler1 = k.w(this.c);
    if (bundle == null)
      bundle = null; 
    handler2.sendMessage(handler1.obtainMessage(0, bundle));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */