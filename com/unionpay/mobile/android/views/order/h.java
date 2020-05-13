package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.unionpay.mobile.android.utils.k;

final class h implements View.OnClickListener {
  h(CViewMethods paramCViewMethods, int paramInt) {}
  
  public final void onClick(View paramView) {
    k.c("uppay", " touched " + this.a);
    if (CViewMethods.a(this.b) != null)
      CViewMethods.a(this.b).c(this.a); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */