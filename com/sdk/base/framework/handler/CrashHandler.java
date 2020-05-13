package com.sdk.base.framework.handler;

import android.content.Context;
import android.support.annotation.Keep;
import com.sdk.base.framework.utils.f.a;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
  private static final String a = CrashHandler.class.getSimpleName();
  
  private static Thread.UncaughtExceptionHandler c;
  
  private static CrashHandler d;
  
  private Thread.UncaughtExceptionHandler b;
  
  private Context e;
  
  public static CrashHandler a() {
    // Byte code:
    //   0: getstatic com/sdk/base/framework/handler/CrashHandler.d : Lcom/sdk/base/framework/handler/CrashHandler;
    //   3: ifnonnull -> 30
    //   6: ldc com/sdk/base/framework/handler/CrashHandler
    //   8: monitorenter
    //   9: getstatic com/sdk/base/framework/handler/CrashHandler.d : Lcom/sdk/base/framework/handler/CrashHandler;
    //   12: ifnonnull -> 27
    //   15: new com/sdk/base/framework/handler/CrashHandler
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/sdk/base/framework/handler/CrashHandler.d : Lcom/sdk/base/framework/handler/CrashHandler;
    //   27: ldc com/sdk/base/framework/handler/CrashHandler
    //   29: monitorexit
    //   30: getstatic com/sdk/base/framework/handler/CrashHandler.d : Lcom/sdk/base/framework/handler/CrashHandler;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/sdk/base/framework/handler/CrashHandler
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private void a(Throwable paramThrowable) {
    a.a(this.e, paramThrowable);
  }
  
  @Keep
  public static void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
    c = paramUncaughtExceptionHandler;
  }
  
  public void a(Context paramContext) {
    this.e = paramContext;
    this.b = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    System.out.println("----" + paramThrowable);
    a(paramThrowable);
    if (c != null) {
      c.uncaughtException(paramThread, paramThrowable);
      return;
    } 
    if (this.b != null)
      this.b.uncaughtException(paramThread, paramThrowable); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\handler\CrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */