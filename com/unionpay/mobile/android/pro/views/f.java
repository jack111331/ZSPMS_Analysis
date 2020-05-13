package com.unionpay.mobile.android.pro.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;

final class f implements View.OnClickListener {
  f(a parama) {}
  
  public final void onClick(View paramView) {
    if (!a.n(this.a)) {
      a.e(this.a).d();
      if (a.o(this.a)) {
        a.p(this.a);
        return;
      } 
      if ((a.q(this.a)).p != null) {
        a.a a2 = a.e(this.a).a();
        if (!a2.a()) {
          a.g(this.a, a2.b);
          return;
        } 
        a a1 = this.a;
        a.a(a.r(this.a), a.s(this.a) + "_apply");
        a.t(this.a).a(c.bD.U);
        a.u(this.a);
        this.a.a((a.v(this.a)).p);
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */