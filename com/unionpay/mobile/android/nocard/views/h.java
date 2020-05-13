package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.j;

final class h implements View.OnClickListener {
  h(g paramg) {}
  
  public final void onClick(View paramView) {
    if (!this.a.o()) {
      g.a(this.a).d();
      a.a a = g.a(this.a).b();
      if (!a.a()) {
        this.a.a(a.b);
        return;
      } 
      if (g.b(this.a) != null && !g.b(this.a).e()) {
        this.a.a(g.b(this.a).b());
        return;
      } 
      this.a.b.a(c.bD.U);
      g g1 = this.a;
      g.a(this.a.d, this.a.q + "_open_apply");
      if (!g.c(this.a)) {
        String str = j.a(this.a.a.C, "action");
        this.a.e.c(str, a.b);
        g.a(this.a, 102);
        return;
      } 
      g.d(this.a);
      g.a(this.a, 104);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */