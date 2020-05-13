package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.Iterator;

final class m implements View.OnClickListener {
  m(j paramj) {}
  
  public final void onClick(View paramView) {
    Iterator<View.OnClickListener> iterator = j.g(this.a).iterator();
    while (iterator.hasNext())
      ((View.OnClickListener)iterator.next()).onClick(paramView); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */