package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;

final class al implements View.OnClickListener {
  al(ak paramak) {}
  
  public final void onClick(View paramView) {
    if (!this.a.o()) {
      ak.a(this.a).d();
      a.a a = ak.a(this.a).b();
      if (!a.a()) {
        this.a.a(a.b);
        return;
      } 
      if (ak.b(this.a) != null && !ak.b(this.a).e()) {
        this.a.a(ak.b(this.a).b());
        return;
      } 
      String str = a.b;
      this.a.b.a(c.bD.U);
      this.a.e.l(str);
      ak.c(this.a);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */