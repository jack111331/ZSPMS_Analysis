package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;

final class j implements Runnable {
  j(f paramf) {}
  
  public final void run() {
    Bundle bundle = f.a(this.a, f.h(this.a), f.i(this.a), f.j(this.a));
    f.k(this.a);
    if (f.d(this.a) != null) {
      Handler handler1 = f.d(this.a);
      Handler handler2 = f.d(this.a);
      if (bundle == null)
        bundle = null; 
      handler1.sendMessage(handler2.obtainMessage(2001, bundle));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */