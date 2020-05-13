package com.unionpay.mobile.android.upviews;

import java.util.TimerTask;

final class c extends TimerTask {
  c(b.d paramd) {}
  
  public final void run() {
    if (!b.b(this.a.a))
      b.a(this.a.a).sendEmptyMessage(3); 
    b.c(this.a.a).cancel();
    b.c(this.a.a).purge();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upviews\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */