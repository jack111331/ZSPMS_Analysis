package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class ae implements View.OnClickListener {
  ae(y paramy) {}
  
  public final void onClick(View paramView) {
    y.b(this.a).d();
    ((InputMethodManager)y.x(this.a).getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    y y1 = this.a;
    y.a(y.y(this.a), y.z(this.a) + "_open_user_protocol");
    y.c(this.a, y.c(this.a).d(), y.c(this.a).c());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */