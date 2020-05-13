package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.utils.p;

final class al implements View.OnClickListener {
  al(aj paramaj) {}
  
  public final void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a(this.a.d, this.a.s() + this.a.d(), p.h, new Object[] { aj.a(this.a, i, "type"), Integer.valueOf(0), aj.a(this.a, i, 0, "label") });
    aj.a(this.a, i, 0);
    if (aj.a(this.a) != null)
      aj.a(this.a).dismiss(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */