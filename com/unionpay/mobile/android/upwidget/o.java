package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.Iterator;

final class o implements View.OnClickListener {
  o(j paramj) {}
  
  public final void onClick(View paramView) {
    if (j.b(this.a) != j.c(this.a)) {
      c c = (c)j.d(this.a).get(j.b(this.a));
      if (c instanceof c)
        ((c)c).a(-1); 
    } 
    j.a(this.a, j.a(this.a));
    j.b(this.a, j.c(this.a));
    Iterator<View.OnClickListener> iterator = j.k(this.a).iterator();
    while (iterator.hasNext())
      ((View.OnClickListener)iterator.next()).onClick(paramView); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */