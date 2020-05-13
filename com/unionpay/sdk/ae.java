package com.unionpay.sdk;

import android.content.Context;
import android.os.Message;

final class ae implements Runnable {
  ae(Throwable paramThrowable, Context paramContext) {}
  
  public final void run() {
    try {
      if (this.a != null) {
        if (this.b != null && !w.a)
          w.a(this.b, (String)null, (String)null); 
        w.a a = new w.a();
        this();
        a.a.put("apiType", Integer.valueOf(5));
        a.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
        a.a.put("throwable", this.a);
        Message.obtain(aw.a(), 102, a).sendToTarget();
      } 
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */