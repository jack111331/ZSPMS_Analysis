package com.unionpay.mobile.android.widgets;

import android.view.ViewTreeObserver;
import com.unionpay.mobile.android.utils.k;

final class aw implements ViewTreeObserver.OnGlobalLayoutListener {
  aw(UPWidget paramUPWidget) {}
  
  public final void onGlobalLayout() {
    k.a("uppay", "onGlobalLayout() +++");
    int i = UPWidget.a(this.a).getRootView().getHeight() - UPWidget.a(this.a).getHeight();
    if (i <= UPWidget.m() && i <= UPWidget.m())
      this.a.l(); 
    k.a("uppay", "onGlobalLayout() ---");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */