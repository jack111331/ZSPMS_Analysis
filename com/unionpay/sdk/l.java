package com.unionpay.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class l extends Handler {
  l(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    try {
      int i;
      if (paramMessage.obj != null && paramMessage.obj instanceof ba) {
        g.a((ba)paramMessage.obj);
        i = (g.b()).i;
        if ((g.b()).f == null) {
          g.a();
          g.c();
          return;
        } 
      } else {
        return;
      } 
      w.b = false;
      g.a(g.a(), (g.b()).a, (g.b()).b, (g.b()).c, (g.b()).e, (g.b()).f, (g.b()).g, i, (g.b()).h);
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */