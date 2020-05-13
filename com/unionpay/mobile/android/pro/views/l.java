package com.unionpay.mobile.android.pro.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;

final class l implements View.OnClickListener {
  l(k paramk) {}
  
  public final void onClick(View paramView) {
    if (!k.a(this.a)) {
      k.b(this.a).d();
      if (k.c(this.a) != null && !k.c(this.a).e()) {
        k.a(this.a, k.c(this.a).b());
        return;
      } 
      if (k.d(this.a) != null && !k.d(this.a).e()) {
        k.b(this.a, k.d(this.a).b());
        return;
      } 
      if ((k.e(this.a)).p != null) {
        a.a a = k.b(this.a).a();
        if (!a.a()) {
          k.c(this.a, a.b);
          return;
        } 
        k k1 = this.a;
        k.a(k.f(this.a), k.g(this.a) + "_apply");
        k.h(this.a).a(c.bD.U);
        k.i(this.a);
        k.a(this.a, (k.b(this.a).a()).b, k.j(this.a));
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */