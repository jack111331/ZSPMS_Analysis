package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.utils.k;

final class ax implements View.OnClickListener {
  ax(UPWidget paramUPWidget) {}
  
  public final void onClick(View paramView) {
    String str;
    int i = paramView.getId();
    int j = this.a.c;
    if (i == 10) {
      k.c("kb", " [ FIN ]");
      UPWidget.b(this.a);
      return;
    } 
    if (i == 20) {
      k.c("kb", " [ DEL ]");
      if (j > 0) {
        UPWidget.a(this.a, UPWidget.c(this.a));
        UPWidget uPWidget1 = this.a;
        uPWidget1.c--;
        str = this.a.b.b().toString().substring(0, j - 1);
        this.a.b.c(str);
        this.a.b.b(str.length());
      } 
      i = this.a.c;
      return;
    } 
    if (this.a.c == 6) {
      k.c("kb", " [ FIN ]");
      return;
    } 
    UPWidget.a(this.a, UPWidget.c(this.a), Integer.toString(i));
    if (j == 0) {
      str = "*";
    } else {
      str = this.a.b.b() + "*";
    } 
    this.a.b.c(str);
    this.a.b.b(str.length());
    UPWidget uPWidget = this.a;
    uPWidget.c++;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */