package com.unionpay.mobile.android.widgets;

import android.view.View;

final class x implements View.OnFocusChangeListener {
  x(u paramu) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      if (u.b(this.a) && u.a(this.a) != null)
        u.a(this.a).setVisibility(0); 
    } else if (u.b(this.a) && u.a(this.a) != null) {
      u.a(this.a).setVisibility(8);
    } 
    if (u.d(this.a) != null)
      u.d(this.a).a(paramBoolean); 
    if (u.e(this.a) != null)
      u.e(this.a).a(paramBoolean); 
    u u1 = this.a;
    u.g();
    this.a.invalidate();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */