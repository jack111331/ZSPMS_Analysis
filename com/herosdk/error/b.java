package com.herosdk.error;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.herosdk.d.x;

public class b implements Thread.UncaughtExceptionHandler {
  private static final String a = "frameLib.sch";
  
  private static volatile b b = null;
  
  private static Context c = null;
  
  private Thread.UncaughtExceptionHandler d;
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/herosdk/error/b.b : Lcom/herosdk/error/b;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/error/b
    //   8: monitorenter
    //   9: getstatic com/herosdk/error/b.b : Lcom/herosdk/error/b;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/error/b
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/error/b.b : Lcom/herosdk/error/b;
    //   27: ldc com/herosdk/error/b
    //   29: monitorexit
    //   30: getstatic com/herosdk/error/b.b : Lcom/herosdk/error/b;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/error/b
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(Context paramContext) {
    if (paramContext == null) {
      try {
        Log.e("frameLib.sch", "init...but context is null error");
      } catch (Exception exception) {
        ErrorUtils.printExceptionInfo(exception);
      } 
      return;
    } 
    c = (Context)exception;
    this.d = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    try {
      if (c == null) {
        Log.e("frameLib.sch", "uce...but context is null error");
        return;
      } 
      x.a().a(c, paramThrowable);
      if (this.d != null) {
        this.d.uncaughtException(paramThread, paramThrowable);
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    Process.killProcess(Process.myPid());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\error\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */