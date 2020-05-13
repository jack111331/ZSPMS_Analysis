package com.zz.a.a.c;

import android.annotation.TargetApi;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

@TargetApi(11)
class h implements Executor {
  final ArrayDeque a = new ArrayDeque();
  
  Runnable b;
  
  private h() {}
  
  protected void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/ArrayDeque;
    //   6: invokevirtual poll : ()Ljava/lang/Object;
    //   9: checkcast java/lang/Runnable
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: putfield b : Ljava/lang/Runnable;
    //   18: aload_1
    //   19: ifnull -> 34
    //   22: getstatic com/zz/a/a/c/a.a : Ljava/util/concurrent/Executor;
    //   25: aload_0
    //   26: getfield b : Ljava/lang/Runnable;
    //   29: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	37	finally
    //   22	34	37	finally
  }
  
  public void execute(Runnable paramRunnable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/ArrayDeque;
    //   6: astore_2
    //   7: new com/zz/a/a/c/i
    //   10: astore_3
    //   11: aload_3
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial <init> : (Lcom/zz/a/a/c/h;Ljava/lang/Runnable;)V
    //   17: aload_2
    //   18: aload_3
    //   19: invokevirtual offer : (Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: getfield b : Ljava/lang/Runnable;
    //   27: ifnonnull -> 34
    //   30: aload_0
    //   31: invokevirtual a : ()V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	37	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */