package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import java.util.Iterator;

final class k implements AdapterView.OnItemClickListener {
  k(j paramj) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    paramView.setTag(Integer.valueOf(j.a(this.a)));
    if (j.b(this.a) != j.c(this.a)) {
      c c1 = (c)j.d(this.a).get(j.b(this.a));
      if (c1 instanceof c)
        ((c)c1).a(-1); 
    } 
    c c = (c)j.d(this.a).get(j.a(this.a));
    if (c instanceof c)
      ((c)c).a(paramInt); 
    j.a(this.a, j.a(this.a));
    j.b(this.a, paramInt);
    Iterator<AdapterView.OnItemClickListener> iterator = j.e(this.a).iterator();
    while (iterator.hasNext())
      ((AdapterView.OnItemClickListener)iterator.next()).onItemClick(paramAdapterView, paramView, paramInt, paramLong); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */