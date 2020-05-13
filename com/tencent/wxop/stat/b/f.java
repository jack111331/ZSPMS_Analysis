package com.tencent.wxop.stat.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class f {
  ExecutorService cG = null;
  
  public f() {
    this.cG = Executors.newSingleThreadExecutor();
  }
  
  public final void a(Runnable paramRunnable) {
    this.cG.execute(paramRunnable);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */