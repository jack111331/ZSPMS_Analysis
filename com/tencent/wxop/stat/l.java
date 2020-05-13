package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class l implements Runnable {
  l(Context paramContext) {}
  
  public final void run() {
    if (this.e == null) {
      e.K().error("The Context of StatService.onResume() can not be null!");
      return;
    } 
    e.a(this.e, l.B(this.e), this.bN);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */