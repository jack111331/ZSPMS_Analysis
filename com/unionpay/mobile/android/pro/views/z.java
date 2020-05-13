package com.unionpay.mobile.android.pro.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;

final class z implements View.OnClickListener {
  z(y paramy) {}
  
  public final void onClick(View paramView) {
    if (!y.a(this.a)) {
      y.b(this.a).d();
      a.a a = y.b(this.a).a();
      if (!a.a()) {
        y.a(this.a, a.b);
        return;
      } 
      if (y.c(this.a) != null && !y.c(this.a).e()) {
        y.b(this.a, y.c(this.a).b());
        return;
      } 
      if (y.d(this.a) != null && !y.d(this.a).e()) {
        y.c(this.a, y.d(this.a).b());
        return;
      } 
      y.e(this.a).a(c.bD.U);
      y y1 = this.a;
      y.a(y.f(this.a), y.g(this.a) + "_apply");
      if ((y.h(this.a)).br) {
        y.a(this.a, (y.i(this.a)).bs, (y.b(this.a).a()).b, y.j(this.a));
        return;
      } 
      y.a(this.a, (y.l(this.a)).q.get((y.k(this.a)).N), (y.b(this.a).a()).b, y.j(this.a));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */