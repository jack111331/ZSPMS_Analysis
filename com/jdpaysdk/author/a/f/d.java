package com.jdpaysdk.author.a.f;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

class d implements Executor {
  private final Handler a = new Handler(Looper.getMainLooper());
  
  public void execute(Runnable paramRunnable) {
    this.a.post(paramRunnable);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */