package com.unionpay.mobile.android.upwidget;

import android.view.ViewTreeObserver;

final class u implements ViewTreeObserver.OnGlobalLayoutListener {
  u(UPScrollView paramUPScrollView) {}
  
  public final void onGlobalLayout() {
    UPScrollView.a(this.a).sendMessageDelayed(UPScrollView.a(this.a).obtainMessage(), 5L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidge\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */