package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

final class c implements Runnable {
  c(b paramb) {}
  
  public final void run() {
    try {
      Process.setThreadPriority(0);
      while (!b.a(this.a).isEmpty()) {
        Runnable runnable = b.a(this.a).get(0);
        b.a(this.a).remove(0);
        if (runnable != null)
          runnable.run(); 
      } 
      return;
    } catch (Exception exception) {
      return;
    } finally {
      b.b(this.a);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */