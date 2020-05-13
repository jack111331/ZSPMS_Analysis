package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;

final class ax implements View.OnClickListener {
  ax(at paramat) {}
  
  public final void onClick(View paramView) {
    if (c.a(this.a.d, this.a.a) == l.c.intValue()) {
      this.a.n();
      this.a.n();
      return;
    } 
    this.a.n();
    if (this.a.a.J) {
      this.a.n();
      this.a.a.J = false;
    } 
    this.a.a.aP = l.c.intValue();
    this.a.d(2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */