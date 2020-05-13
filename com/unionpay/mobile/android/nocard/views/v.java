package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;

final class v implements View.OnClickListener {
  v(o paramo) {}
  
  public final void onClick(View paramView) {
    if (!this.a.o()) {
      o.b(this.a).d();
      a.a a = o.b(this.a).b();
      if (!a.a()) {
        this.a.a(a.b);
        return;
      } 
      if (o.c(this.a) != null && !o.c(this.a).e()) {
        this.a.a(o.c(this.a).b());
        return;
      } 
      String str1 = "";
      if (o.d(this.a) != null) {
        a.a a1 = o.d(this.a).b();
        if (!a1.a()) {
          this.a.a(a1.b);
          return;
        } 
        str1 = a1.b;
      } 
      String str2 = a.b;
      o o2 = this.a;
      if (o.b(str1)) {
        str1 = str2 + "," + str1;
      } else {
        str1 = str2;
      } 
      this.a.b.a(c.bD.U);
      o o1 = this.a;
      o.a(this.a.d, this.a.q + "_apply");
      o.b(this.a, str1);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */