package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import com.unionpay.mobile.android.utils.p;

final class am implements AdapterView.OnItemClickListener {
  am(aj paramaj) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a(this.a.d, this.a.s() + this.a.d(), p.h, new Object[] { aj.a(this.a, i, "type"), Integer.valueOf(paramInt), aj.a(this.a, i, paramInt, "label") });
    aj.a(this.a, i, paramInt);
    if (aj.a(this.a) != null)
      aj.a(this.a).dismiss(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */