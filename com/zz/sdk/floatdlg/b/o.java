package com.zz.sdk.floatdlg.b;

import android.content.Context;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

class o implements Runnable {
  o(n paramn) {}
  
  public void run() {
    try {
      FancyButton fancyButton = this.a.a.e;
      Context context = a.c(this.a.a);
      int i = ci.a(a.c(this.a.a), ci.a(a.c(this.a.a)).a(2131165247));
      StringBuilder stringBuilder = new StringBuilder();
      this();
      fancyButton.setText(context.getString(i, new Object[] { stringBuilder.append(a.i(this.a.a)).append("").toString() }));
      if (a.i(this.a.a) == 0) {
        a.j(this.a.a);
        a.k(this.a.a);
        if (a.l(this.a.a) < 2) {
          this.a.a.e.setText(a.c(this.a.a).getString(ci.a(a.c(this.a.a)).a(2131165218)));
        } else {
          this.a.a.e.setText(a.c(this.a.a).getString(ci.a(a.c(this.a.a)).a(2131165219)));
        } 
        this.a.a.e.setEnabled(true);
        a.a(this.a.a, 60);
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */