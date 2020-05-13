package com.zz.sdk.i;

import android.annotation.SuppressLint;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class cp {
  private static final int a = Runtime.getRuntime().availableProcessors();
  
  private static final int b = Math.max(2, Math.min(a - 1, 4));
  
  private static final int c = a * 2 + 1;
  
  private static final int d = 30;
  
  private static volatile cp e;
  
  private ThreadPoolExecutor f = null;
  
  @SuppressLint({"NewApi"})
  private cp() {
    if (this.f == null)
      this.f = new ThreadPoolExecutor(b, c, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(128)); 
  }
  
  public static cp a() {
    // Byte code:
    //   0: getstatic com/zz/sdk/i/cp.e : Lcom/zz/sdk/i/cp;
    //   3: ifnonnull -> 30
    //   6: ldc com/zz/sdk/i/cp
    //   8: monitorenter
    //   9: getstatic com/zz/sdk/i/cp.e : Lcom/zz/sdk/i/cp;
    //   12: ifnonnull -> 27
    //   15: new com/zz/sdk/i/cp
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/zz/sdk/i/cp.e : Lcom/zz/sdk/i/cp;
    //   27: ldc com/zz/sdk/i/cp
    //   29: monitorexit
    //   30: getstatic com/zz/sdk/i/cp.e : Lcom/zz/sdk/i/cp;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/zz/sdk/i/cp
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(Runnable paramRunnable) {
    try {
      this.f.execute(paramRunnable);
    } catch (Exception exception) {
      bd.b(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */