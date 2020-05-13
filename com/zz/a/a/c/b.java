package com.zz.a.a.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class b implements ThreadFactory {
  private final AtomicInteger a = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable) {
    return new Thread(paramRunnable, "AsyncTask #" + this.a.getAndIncrement());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */