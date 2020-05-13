package com.unionpay.mobile.android.views.order;

import android.view.View;

final class f implements View.OnClickListener {
  f(b paramb) {}
  
  public final void onClick(View paramView) {
    if (this.a.e != null) {
      b b2 = this.a;
      b.a(this.a.b, "bankpay_support_bank");
      AbstractMethod.b b1 = this.a.e;
      b b3 = this.a;
      String str = b.a(b.c(this.a), "title");
      b3 = this.a;
      b1.a(str, b.a(b.c(this.a), "href"));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */