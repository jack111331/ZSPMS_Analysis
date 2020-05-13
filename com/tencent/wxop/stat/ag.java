package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.l;
import java.util.TimerTask;

final class ag extends TimerTask {
  ag(af paramaf) {}
  
  public final void run() {
    if (c.k())
      l.av().b("TimerTask run"); 
    e.q(af.a(this.de));
    cancel();
    this.de.ah();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */