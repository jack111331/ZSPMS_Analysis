package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import java.util.Iterator;

final class h implements AdapterView.OnItemClickListener {
  h(g paramg) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    Iterator<AdapterView.OnItemClickListener> iterator = g.a(this.a).iterator();
    while (iterator.hasNext())
      ((AdapterView.OnItemClickListener)iterator.next()).onItemClick(paramAdapterView, paramView, paramInt, paramLong); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */