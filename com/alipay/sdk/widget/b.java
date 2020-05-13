package com.alipay.sdk.widget;

import android.content.Context;

final class b implements Runnable {
  b(a parama) {}
  
  public final void run() {
    if (a.c(this.a) == null) {
      a.a(this.a, new a.a(this.a, (Context)a.a(this.a)));
      a.c(this.a).setCancelable(a.d(this.a));
    } 
    try {
      if (!a.c(this.a).isShowing())
        a.c(this.a).show(); 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */