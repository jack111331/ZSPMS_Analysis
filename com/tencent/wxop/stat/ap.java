package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.c;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.f;

final class ap implements Runnable {
  ap(Context paramContext, Throwable paramThrowable) {}
  
  public final void run() {
    try {
      if (c.l()) {
        c c = new c();
        this(this.e, e.a(this.e, false, (f)null), this.dn, f.bw);
        p p = new p();
        this((d)c);
        p.ah();
      } 
    } catch (Throwable throwable) {
      e.K().d("reportSdkSelfException error: " + throwable);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */