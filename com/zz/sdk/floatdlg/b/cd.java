package com.zz.sdk.floatdlg.b;

import android.content.Context;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

class cd implements Runnable {
  cd(cc paramcc) {}
  
  public void run() {
    try {
      FancyButton fancyButton = this.a.a.c;
      Context context = bw.a(this.a.a);
      int i = ci.a(bw.a(this.a.a), ci.a(bw.a(this.a.a), 2131165247));
      StringBuilder stringBuilder = new StringBuilder();
      this();
      fancyButton.setText(context.getString(i, new Object[] { stringBuilder.append(bw.e(this.a.a)).append("").toString() }));
      if (bw.e(this.a.a) == 0) {
        bw.f(this.a.a);
        if (!bw.g(this.a.a)) {
          this.a.a.c.setText(bw.a(this.a.a).getString(ci.a(bw.a(this.a.a), 2131165218)));
        } else {
          this.a.a.c.setText(bw.a(this.a.a).getString(ci.a(bw.a(this.a.a), 2131165219)));
        } 
        this.a.a.c.setEnabled(true);
        bw.a(this.a.a, 90);
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */