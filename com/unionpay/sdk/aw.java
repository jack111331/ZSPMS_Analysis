package com.unionpay.sdk;

import android.os.Handler;
import android.os.HandlerThread;

final class aw {
  private static Handler a = null;
  
  private static final HandlerThread b;
  
  static {
    HandlerThread handlerThread = new HandlerThread("ProcessingThread");
    b = handlerThread;
    handlerThread.start();
    a = new ax(b.getLooper());
  }
  
  static final Handler a() {
    return a;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */