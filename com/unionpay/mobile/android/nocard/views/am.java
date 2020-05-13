package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class am implements View.OnClickListener {
  am(ak paramak) {}
  
  public final void onClick(View paramView) {
    ak.a(this.a).d();
    ((InputMethodManager)this.a.d.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    ak ak1 = this.a;
    ak.a(this.a.d, this.a.q + "_open_user_protocol");
    this.a.a(ak.b(this.a).d(), ak.b(this.a).c());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */