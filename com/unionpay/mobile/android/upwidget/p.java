package com.unionpay.mobile.android.upwidget;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Iterator;

final class p implements View.OnClickListener {
  p(j paramj) {}
  
  public final void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    if (i != j.a(this.a)) {
      j.c(this.a, i);
      if (j.l(this.a) && !TextUtils.isEmpty((j.m(this.a)[i]).d)) {
        paramView.setTag((j.m(this.a)[i]).d);
        Iterator<View.OnClickListener> iterator = j.n(this.a).iterator();
        while (iterator.hasNext())
          ((View.OnClickListener)iterator.next()).onClick(paramView); 
        j.a(this.a, (LinearLayout)(j.m(this.a)[i]).c, "正在查询。。。");
        j.o(this.a);
      } 
      paramView.setTag(Integer.valueOf(i));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */