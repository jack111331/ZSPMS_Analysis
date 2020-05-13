package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l implements ab {
  private static l b = null;
  
  private static final ThreadFactory i = new n();
  
  Context a;
  
  private ThreadPoolExecutor c;
  
  private b d;
  
  private long e;
  
  private long f;
  
  private long g;
  
  private int h;
  
  private l(Context paramContext) {
    this.a = paramContext;
    this.d = b.a("android");
    this.c = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
    try {
      this.c.allowCoreThreadTimeOut(true);
    } catch (Exception exception) {}
    CookieSyncManager.createInstance(this.a);
    CookieManager.getInstance().setAcceptCookie(true);
  }
  
  public static final l a(Context paramContext) {
    return (b != null) ? b : b(paramContext);
  }
  
  private static final l b(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/android/phone/mrpc/core/l
    //   2: monitorenter
    //   3: getstatic com/alipay/android/phone/mrpc/core/l.b : Lcom/alipay/android/phone/mrpc/core/l;
    //   6: ifnull -> 18
    //   9: getstatic com/alipay/android/phone/mrpc/core/l.b : Lcom/alipay/android/phone/mrpc/core/l;
    //   12: astore_0
    //   13: ldc com/alipay/android/phone/mrpc/core/l
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new com/alipay/android/phone/mrpc/core/l
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: invokespecial <init> : (Landroid/content/Context;)V
    //   27: aload_1
    //   28: putstatic com/alipay/android/phone/mrpc/core/l.b : Lcom/alipay/android/phone/mrpc/core/l;
    //   31: aload_1
    //   32: astore_0
    //   33: goto -> 13
    //   36: astore_0
    //   37: ldc com/alipay/android/phone/mrpc/core/l
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	36	finally
    //   18	31	36	finally
  }
  
  public final b a() {
    return this.d;
  }
  
  public final Future<u> a(t paramt) {
    long l1 = 0L;
    if (s.a(this.a)) {
      long l4;
      String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
      int i = this.c.getActiveCount();
      long l2 = this.c.getCompletedTaskCount();
      long l3 = this.c.getTaskCount();
      if (this.g == 0L) {
        l4 = 0L;
      } else {
        l4 = this.e * 1000L / this.g >> 10L;
      } 
      if (this.h != 0)
        l1 = this.f / this.h; 
      String.format(str, new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g), Integer.valueOf(this.h) });
    } 
    q q = new q(this, (o)paramt);
    m m = new m(this, q, q);
    this.c.execute(m);
    return m;
  }
  
  public final void a(long paramLong) {
    this.e += paramLong;
  }
  
  public final void b(long paramLong) {
    this.f += paramLong;
    this.h++;
  }
  
  public final void c(long paramLong) {
    this.g += paramLong;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */