package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.Iterator;

final class d implements View.OnClickListener {
  d(c paramc) {}
  
  public final void onClick(View paramView) {
    Iterator<View.OnClickListener> iterator = c.a(this.a).iterator();
    while (iterator.hasNext())
      ((View.OnClickListener)iterator.next()).onClick(paramView); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */