package com.unity3d.player;

import android.os.Build;

final class m implements Thread.UncaughtExceptionHandler {
  private volatile Thread.UncaughtExceptionHandler a;
  
  final boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic getDefaultUncaughtExceptionHandler : ()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   5: astore_1
    //   6: aload_1
    //   7: aload_0
    //   8: if_acmpne -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: aload_1
    //   19: putfield a : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   22: aload_0
    //   23: invokestatic setDefaultUncaughtExceptionHandler : (Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   26: iconst_1
    //   27: istore_2
    //   28: goto -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	31	finally
    //   17	26	31	finally
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    /* monitor enter ThisExpression{ObjectType{com/unity3d/player/m}} */
    try {
      Error error = new Error();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(String.format("FATAL EXCEPTION [%s]\n", new Object[] { paramThread.getName() }));
      stringBuilder.append(String.format("Unity version     : %s\n", new Object[] { "2018.4.19f1" }));
      stringBuilder.append(String.format("Device model      : %s %s\n", new Object[] { Build.MANUFACTURER, Build.MODEL }));
      stringBuilder.append(String.format("Device fingerprint: %s\n", new Object[] { Build.FINGERPRINT }));
      this(stringBuilder.toString());
      error.setStackTrace(new StackTraceElement[0]);
      error.initCause(paramThrowable);
      this.a.uncaughtException(paramThread, error);
      /* monitor exit ThisExpression{ObjectType{com/unity3d/player/m}} */
      return;
    } catch (Throwable throwable) {
      this.a.uncaughtException(paramThread, paramThrowable);
      /* monitor exit ThisExpression{ObjectType{com/unity3d/player/m}} */
      return;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/unity3d/player/m}} */
    throw paramThread;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */