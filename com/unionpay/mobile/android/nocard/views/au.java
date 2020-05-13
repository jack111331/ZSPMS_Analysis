package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;

final class au implements View.OnClickListener {
  au(at paramat) {}
  
  public final void onClick(View paramView) {
    if (!this.a.o()) {
      String str1 = "";
      if (at.a(this.a) != null) {
        at.a(this.a).d();
        a.a a1 = at.a(this.a).b();
        if (!a1.a()) {
          this.a.a(a1.b);
          return;
        } 
        str1 = a1.b;
      } 
      at.b(this.a).d();
      a.a a = at.b(this.a).b();
      if (!a.a()) {
        this.a.a(a.b);
        return;
      } 
      if (at.c(this.a) != null && !at.c(this.a).e()) {
        this.a.a(at.c(this.a).b());
        return;
      } 
      if (at.d(this.a) != null && !at.d(this.a).e()) {
        this.a.a(at.d(this.a).b());
        return;
      } 
      String str2 = a.b;
      at at2 = this.a;
      if (at.b(str1)) {
        str1 = str2 + "," + str1;
      } else {
        str1 = str2;
      } 
      this.a.b.a(c.bD.U);
      at at1 = this.a;
      at.a(this.a.d, this.a.q + "_apply");
      if (this.a.a.E != null && this.a.a.E.length() > 0) {
        at.a(this.a, at.e(this.a), str1);
        return;
      } 
      at.a(this.a, str1);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */