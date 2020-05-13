package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class an implements Runnable {
  an(Context paramContext) {}
  
  public final void run() {
    g.r(e.J()).aa();
    l.a(this.e, true);
    t.s(this.e);
    ak.Z(this.e);
    e.a(Thread.getDefaultUncaughtExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new n());
    if (c.j() == d.aE)
      e.o(this.e); 
    if (c.k())
      e.K().e("Init MTA StatService success."); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */