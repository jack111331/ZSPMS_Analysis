package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class ay implements View.OnClickListener {
  ay(at paramat) {}
  
  public final void onClick(View paramView) {
    at.b(this.a).d();
    ((InputMethodManager)this.a.d.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    at at1 = this.a;
    at.a(this.a.d, this.a.q + "_open_user_protocol");
    this.a.a(at.c(this.a).d(), at.c(this.a).c());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */