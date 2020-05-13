package com.yingxiong.common;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class AppOperator {
  private static ExecutorService EXECUTORS_INSTANCE;
  
  private static Executor getExecutor() {
    // Byte code:
    //   0: getstatic com/yingxiong/common/AppOperator.EXECUTORS_INSTANCE : Ljava/util/concurrent/ExecutorService;
    //   3: ifnonnull -> 35
    //   6: ldc com/yingxiong/common/AppOperator
    //   8: monitorenter
    //   9: getstatic com/yingxiong/common/AppOperator.EXECUTORS_INSTANCE : Ljava/util/concurrent/ExecutorService;
    //   12: ifnonnull -> 23
    //   15: bipush #6
    //   17: invokestatic newFixedThreadPool : (I)Ljava/util/concurrent/ExecutorService;
    //   20: putstatic com/yingxiong/common/AppOperator.EXECUTORS_INSTANCE : Ljava/util/concurrent/ExecutorService;
    //   23: ldc com/yingxiong/common/AppOperator
    //   25: monitorexit
    //   26: goto -> 35
    //   29: astore_0
    //   30: ldc com/yingxiong/common/AppOperator
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    //   35: getstatic com/yingxiong/common/AppOperator.EXECUTORS_INSTANCE : Ljava/util/concurrent/ExecutorService;
    //   38: areturn
    // Exception table:
    //   from	to	target	type
    //   9	23	29	finally
    //   23	26	29	finally
    //   30	33	29	finally
  }
  
  public static void runOnThread(Runnable paramRunnable) {
    getExecutor().execute(paramRunnable);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\common\AppOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */