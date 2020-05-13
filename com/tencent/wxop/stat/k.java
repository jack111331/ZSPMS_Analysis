package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.h;
import com.tencent.wxop.stat.b.b;
import java.util.Map;

final class k implements Runnable {
  k(Context paramContext, String paramString, f paramf) {}
  
  public final void run() {
    try {
      Map map;
      p p;
      e.p(this.e);
      synchronized (e.M()) {
        Long long_ = (Long)e.M().remove(this.b);
        if (long_ != null) {
          long_ = Long.valueOf((System.currentTimeMillis() - long_.longValue()) / 1000L);
          Long long_1 = long_;
          if (long_.longValue() <= 0L)
            long_1 = Long.valueOf(1L); 
          String str2 = e.O();
          String str1 = str2;
          if (str2 != null) {
            str1 = str2;
            if (str2.equals(this.b) == true)
              str1 = "-"; 
          } 
          h h = new h();
          this(this.e, str1, this.b, e.a(this.e, false, this.bM), long_1, this.bM);
          if (!this.b.equals(e.N()))
            e.K().warn("Invalid invocation since previous onResume on diff page."); 
          p = new p();
          this((d)h);
          p.ah();
          e.r(this.b);
          return;
        } 
      } 
    } catch (Throwable throwable) {
      e.K().b(throwable);
      e.a(this.e, throwable);
      return;
    } 
    b b = e.K();
    StringBuilder stringBuilder = new StringBuilder();
    this("Starttime for PageID:");
    b.d(stringBuilder.append(this.b).append(" not found, lost onResume()?").toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */