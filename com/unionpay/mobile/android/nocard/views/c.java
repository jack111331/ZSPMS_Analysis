package com.unionpay.mobile.android.nocard.views;

import android.view.ViewTreeObserver;

final class c implements ViewTreeObserver.OnPreDrawListener {
  c(b paramb) {}
  
  public final boolean onPreDraw() {
    b.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    b.a(this.a, b.a(this.a).getMeasuredHeight());
    b.b(this.a, b.a(this.a).getTop());
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */