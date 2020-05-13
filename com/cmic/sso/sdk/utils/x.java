package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.os.Bundle;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class x {
  private static ExecutorService a = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
  
  public static void a(a parama) {
    a.execute(parama);
  }
  
  public static abstract class a implements Runnable {
    private Thread.UncaughtExceptionHandler a = new Thread.UncaughtExceptionHandler(this) {
        public void uncaughtException(Thread param2Thread, Throwable param2Throwable) {
          param2Throwable.printStackTrace();
        }
      };
    
    protected a() {}
    
    protected a(Context param1Context, Bundle param1Bundle) {}
    
    protected abstract void a();
    
    public void run() {
      Thread.currentThread().setUncaughtExceptionHandler(this.a);
      a();
      Thread.currentThread().setUncaughtExceptionHandler(null);
    }
  }
  
  class null implements Thread.UncaughtExceptionHandler {
    null(x this$0) {}
    
    public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
      param1Throwable.printStackTrace();
    }
  }
  
  class null implements Thread.UncaughtExceptionHandler {
    null(x this$0, Context param1Context, Bundle param1Bundle) {}
    
    public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
      param1Throwable.printStackTrace();
      AuthnHelper.getInstance(this.a).callBackResult("200025", "发生未知错误", this.b, null, param1Throwable);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */