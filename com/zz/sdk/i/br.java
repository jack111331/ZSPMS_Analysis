package com.zz.sdk.i;

import java.util.logging.Level;

final class br implements Thread.UncaughtExceptionHandler {
  Thread.UncaughtExceptionHandler a = this.b;
  
  br(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (bp.a() != null)
      bp.a().log(Level.SEVERE, String.valueOf(paramThread), paramThrowable); 
    if (this.a != null)
      this.a.uncaughtException(paramThread, paramThrowable); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */