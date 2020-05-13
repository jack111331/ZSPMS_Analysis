package com.sdk.base.framework.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class d implements Executor {
  private static final ThreadFactory a = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public Thread newThread(Runnable param1Runnable) {
        return new Thread(param1Runnable, "PriorityExecutor #" + this.a.getAndIncrement());
      }
    };
  
  private final BlockingQueue<Runnable> b = new f<Runnable>();
  
  private final ThreadPoolExecutor c;
  
  public d() {
    this(5);
  }
  
  public d(int paramInt) {
    this.c = new ThreadPoolExecutor(paramInt, 256, 1L, TimeUnit.SECONDS, this.b, a);
  }
  
  public void execute(Runnable paramRunnable) {
    this.c.execute(paramRunnable);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */