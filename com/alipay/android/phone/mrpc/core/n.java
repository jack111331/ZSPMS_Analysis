package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class n implements ThreadFactory {
  private final AtomicInteger a = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable) {
    paramRunnable = new Thread(paramRunnable, "com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #" + this.a.getAndIncrement());
    paramRunnable.setPriority(4);
    return (Thread)paramRunnable;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */