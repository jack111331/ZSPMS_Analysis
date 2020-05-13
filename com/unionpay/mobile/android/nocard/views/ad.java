package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.widget.AdapterView;

final class ad implements AdapterView.OnItemClickListener {
  ad(o.b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    o.b.a(this.a).dismiss();
    if (o.b.b(this.a) != null && paramInt - o.b.c(this.a).c() < o.b.b(this.a).size()) {
      o.b.a(this.a, paramInt);
      o.b.c(this.a).a(o.b.d(this.a));
    } 
    if (o.b.e(this.a) != null)
      o.b.e(this.a).a(paramInt - o.b.c(this.a).c()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */