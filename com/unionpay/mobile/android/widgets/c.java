package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;

final class c implements AdapterView.OnItemClickListener {
  c(a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    this.a.a(this.a.d, this.a.s() + this.a.d());
    a.a(this.a, paramInt);
    if (a.a(this.a) != null)
      a.a(this.a).dismiss(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */