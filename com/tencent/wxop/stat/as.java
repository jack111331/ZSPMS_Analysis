package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class as implements Runnable {
  as(String paramString, Context paramContext, f paramf) {}
  
  public final void run() {
    try {
      synchronized (e.M()) {
        if (e.M().size() >= c.v()) {
          b b = e.K();
          StringBuilder stringBuilder = new StringBuilder();
          this("The number of page events exceeds the maximum value ");
          b.error(stringBuilder.append(Integer.toString(c.v())).toString());
          return;
        } 
        e.q(this.a);
        if (e.M().containsKey(e.N())) {
          b b = e.K();
          StringBuilder stringBuilder = new StringBuilder();
          this("Duplicate PageID : ");
          b.d(stringBuilder.append(e.N()).append(", onResume() repeated?").toString());
          return;
        } 
      } 
    } catch (Throwable throwable) {
      e.K().b(throwable);
      e.a(this.co, throwable);
      return;
    } 
    e.M().put(e.N(), Long.valueOf(System.currentTimeMillis()));
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Throwable}, name=null} */
    e.a(this.co, true, this.bM);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */