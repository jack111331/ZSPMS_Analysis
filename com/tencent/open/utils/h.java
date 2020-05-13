package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h {
  public static final Executor a;
  
  private static Object b = new Object();
  
  private static Handler c;
  
  private static HandlerThread d;
  
  static {
    a = c();
  }
  
  public static Handler a() {
    // Byte code:
    //   0: getstatic com/tencent/open/utils/h.c : Landroid/os/Handler;
    //   3: ifnonnull -> 50
    //   6: ldc com/tencent/open/utils/h
    //   8: monitorenter
    //   9: new android/os/HandlerThread
    //   12: astore_0
    //   13: aload_0
    //   14: ldc 'SDK_SUB'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: aload_0
    //   20: putstatic com/tencent/open/utils/h.d : Landroid/os/HandlerThread;
    //   23: getstatic com/tencent/open/utils/h.d : Landroid/os/HandlerThread;
    //   26: invokevirtual start : ()V
    //   29: new android/os/Handler
    //   32: astore_0
    //   33: aload_0
    //   34: getstatic com/tencent/open/utils/h.d : Landroid/os/HandlerThread;
    //   37: invokevirtual getLooper : ()Landroid/os/Looper;
    //   40: invokespecial <init> : (Landroid/os/Looper;)V
    //   43: aload_0
    //   44: putstatic com/tencent/open/utils/h.c : Landroid/os/Handler;
    //   47: ldc com/tencent/open/utils/h
    //   49: monitorexit
    //   50: getstatic com/tencent/open/utils/h.c : Landroid/os/Handler;
    //   53: areturn
    //   54: astore_0
    //   55: ldc com/tencent/open/utils/h
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   9	50	54	finally
    //   55	58	54	finally
  }
  
  public static void a(Runnable paramRunnable) {
    a().post(paramRunnable);
  }
  
  public static Executor b() {
    return new a();
  }
  
  private static Executor c() {
    Executor executor;
    if (Build.VERSION.SDK_INT >= 11) {
      executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    } else {
      try {
        Field field = AsyncTask.class.getDeclaredField("sExecutor");
        field.setAccessible(true);
        executor = (Executor)field.get(null);
      } catch (Exception exception) {
        executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
      } 
    } 
    if (executor instanceof ThreadPoolExecutor)
      ((ThreadPoolExecutor)executor).setCorePoolSize(3); 
    return executor;
  }
  
  private static class a implements Executor {
    final Queue<Runnable> a = new LinkedList<Runnable>();
    
    Runnable b;
    
    private a() {}
    
    protected void a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/Queue;
      //   6: invokeinterface poll : ()Ljava/lang/Object;
      //   11: checkcast java/lang/Runnable
      //   14: astore_1
      //   15: aload_0
      //   16: aload_1
      //   17: putfield b : Ljava/lang/Runnable;
      //   20: aload_1
      //   21: ifnull -> 36
      //   24: getstatic com/tencent/open/utils/h.a : Ljava/util/concurrent/Executor;
      //   27: aload_0
      //   28: getfield b : Ljava/lang/Runnable;
      //   31: invokeinterface execute : (Ljava/lang/Runnable;)V
      //   36: aload_0
      //   37: monitorexit
      //   38: return
      //   39: astore_1
      //   40: aload_0
      //   41: monitorexit
      //   42: aload_1
      //   43: athrow
      // Exception table:
      //   from	to	target	type
      //   2	20	39	finally
      //   24	36	39	finally
    }
    
    public void execute(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/Queue;
      //   6: astore_2
      //   7: new com/tencent/open/utils/h$a$1
      //   10: astore_3
      //   11: aload_3
      //   12: aload_0
      //   13: aload_1
      //   14: invokespecial <init> : (Lcom/tencent/open/utils/h$a;Ljava/lang/Runnable;)V
      //   17: aload_2
      //   18: aload_3
      //   19: invokeinterface offer : (Ljava/lang/Object;)Z
      //   24: pop
      //   25: aload_0
      //   26: getfield b : Ljava/lang/Runnable;
      //   29: ifnonnull -> 36
      //   32: aload_0
      //   33: invokevirtual a : ()V
      //   36: aload_0
      //   37: monitorexit
      //   38: return
      //   39: astore_1
      //   40: aload_0
      //   41: monitorexit
      //   42: aload_1
      //   43: athrow
      // Exception table:
      //   from	to	target	type
      //   2	36	39	finally
    }
  }
  
  class null implements Runnable {
    null(h this$0, Runnable param1Runnable) {}
    
    public void run() {
      try {
        this.a.run();
        return;
      } finally {
        this.b.a();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */