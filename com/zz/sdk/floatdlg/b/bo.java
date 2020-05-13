package com.zz.sdk.floatdlg.b;

import android.content.Context;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

class bo implements Runnable {
  bo(bn parambn) {}
  
  public void run() {
    try {
      FancyButton fancyButton = be.o(this.a.a);
      Context context = be.c(this.a.a);
      int i = ci.a(be.c(this.a.a), 2131165247);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      fancyButton.setText(context.getString(i, new Object[] { stringBuilder.append(be.q(this.a.a)).append("").toString() }));
      if (be.q(this.a.a) == 0) {
        be.r(this.a.a);
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        bp.a(stringBuilder1.append("FragmentRealName...mContext:").append(be.c(this.a.a)).toString());
        if (be.s(this.a.a) < 2) {
          be.o(this.a.a).setText(be.c(this.a.a).getString(ci.a(be.c(this.a.a), 2131165218)));
        } else {
          be.o(this.a.a).setText(be.c(this.a.a).getString(ci.a(be.c(this.a.a), 2131165219)));
        } 
        be.o(this.a.a).setEnabled(true);
        be.a(this.a.a, 60);
        be.t(this.a.a);
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */