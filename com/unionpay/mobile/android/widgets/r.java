package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import com.unionpay.mobile.android.utils.p;

final class r implements AdapterView.OnItemClickListener {
  r(p paramp) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    this.a.a(this.a.d, this.a.s() + this.a.d(), p.f, new Object[] { Integer.valueOf(paramInt) });
    p.a(this.a, paramInt);
    if (p.a(this.a) != null)
      p.a(this.a).dismiss(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */