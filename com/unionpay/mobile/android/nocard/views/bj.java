package com.unionpay.mobile.android.nocard.views;

import android.view.MotionEvent;
import android.view.View;

final class bj implements View.OnTouchListener {
  bj(bi parambi) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    switch (paramMotionEvent.getAction()) {
      default:
        return false;
      case 0:
      case 1:
        break;
    } 
    if (!paramView.hasFocus())
      paramView.requestFocus(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */