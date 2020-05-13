package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class r implements View.OnClickListener {
  r(k paramk) {}
  
  public final void onClick(View paramView) {
    k.b(this.a).d();
    ((InputMethodManager)k.s(this.a).getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    k k1 = this.a;
    k.a(k.t(this.a), k.u(this.a) + "_open_user_protocol");
    k.c(this.a, k.c(this.a).d(), k.c(this.a).c());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */