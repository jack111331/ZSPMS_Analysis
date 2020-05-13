package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.c;
import com.tencent.wxop.stat.a.d;

final class n implements Thread.UncaughtExceptionHandler {
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (c.l() && e.J() != null) {
      if (c.x()) {
        t.s(e.J()).b((d)new c(e.J(), e.a(e.J(), false, (f)null), paramThrowable, paramThread), null, false, true);
        e.K().debug("MTA has caught the following uncaught exception:");
        e.K().a(paramThrowable);
      } 
      e.p(e.J());
      if (e.L() != null) {
        e.K().e("Call the original uncaught exception handler.");
        if (!(e.L() instanceof n))
          e.L().uncaughtException(paramThread, paramThrowable); 
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */