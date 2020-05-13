package com.zz.sdk.floatdlg.b;

import android.content.Context;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

class y implements Runnable {
  y(x paramx) {}
  
  public void run() {
    try {
      FancyButton fancyButton = this.a.a.d;
      Context context = p.a(this.a.a);
      int i = ci.a(p.a(this.a.a), 2131165247);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      fancyButton.setText(context.getString(i, new Object[] { stringBuilder.append(p.f(this.a.a)).append("").toString() }));
      if (p.f(this.a.a) == 0) {
        p.g(this.a.a);
        if (!p.h(this.a.a)) {
          this.a.a.d.setText(p.a(this.a.a).getString(ci.a(p.a(this.a.a)).a(2131165218)));
        } else {
          this.a.a.d.setText(p.a(this.a.a).getString(ci.a(p.a(this.a.a)).a(2131165219)));
        } 
        this.a.a.d.setEnabled(true);
        p.a(this.a.a, 90);
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */