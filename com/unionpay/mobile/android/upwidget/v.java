package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;

final class v extends Handler {
  v(UPScrollView paramUPScrollView) {}
  
  public final void handleMessage(Message paramMessage) {
    int i = this.a.getScrollY();
    if (UPScrollView.b(this.a) != i) {
      UPScrollView.a(this.a, i);
      UPScrollView.a(this.a).sendMessageDelayed(UPScrollView.a(this.a).obtainMessage(), 5L);
    } 
    if (UPScrollView.c(this.a) != null && UPScrollView.c(this.a).get() != null)
      ((UPScrollView.a)UPScrollView.c(this.a).get()).e(i); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */