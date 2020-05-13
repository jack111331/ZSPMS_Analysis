package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

public final class b {
  private static b a = new b();
  
  private Thread b = null;
  
  private LinkedList<Runnable> c = new LinkedList<Runnable>();
  
  public static b a() {
    return a;
  }
  
  public final void a(Runnable paramRunnable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/LinkedList;
    //   6: aload_1
    //   7: invokevirtual add : (Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield b : Ljava/lang/Thread;
    //   15: ifnonnull -> 48
    //   18: new java/lang/Thread
    //   21: astore_2
    //   22: new com/alipay/apmobilesecuritysdk/f/c
    //   25: astore_1
    //   26: aload_1
    //   27: aload_0
    //   28: invokespecial <init> : (Lcom/alipay/apmobilesecuritysdk/f/b;)V
    //   31: aload_2
    //   32: aload_1
    //   33: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   36: aload_0
    //   37: aload_2
    //   38: putfield b : Ljava/lang/Thread;
    //   41: aload_0
    //   42: getfield b : Ljava/lang/Thread;
    //   45: invokevirtual start : ()V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	48	51	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */