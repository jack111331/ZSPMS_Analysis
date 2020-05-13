package com.zz.sdk.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

class h extends Handler {
  h(g paramg) {}
  
  @SuppressLint({"NewApi"})
  public void handleMessage(Message paramMessage) {
    boolean bool1 = true;
    switch (paramMessage.what) {
      default:
        return;
      case 0:
        if (g.a(this.a) != null) {
          g.b(this.a).setAlpha(0.3F);
          g.a(this.a).h();
          g.q().p();
        } 
      case 1:
        g.b(this.a).setAlpha(0.7F);
        if (this.a.c != null)
          this.a.c.sendEmptyMessageDelayed(0, 2000L); 
      case 2:
        this.a.o();
      case 3:
        g.c(this.a).setVisibility(0);
        g.a(this.a, (View)g.b(this.a), (Interpolator)new DecelerateInterpolator());
        if (this.a.c != null)
          this.a.c.sendEmptyMessageDelayed(1, 2000L); 
      case 4:
        g.b(this.a).setAlpha(1.0F);
        if (this.a.c != null)
          this.a.c.sendEmptyMessageDelayed(2, 2000L); 
      case 5:
        break;
    } 
    g g1 = this.a;
    boolean bool2 = bool1;
    if (!g.d(this.a))
      if (g.e(this.a)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    g.a(g1, bool2);
    g.b(this.a, g.f(this.a));
    g.c(this.a, g.e(this.a));
    g.d(this.a, g.d(this.a));
    if (g.f(this.a)) {
      if (g.g(this.a))
        this.a.a(90, 0, 0); 
      g.b(this.a).setAlpha(1.0F);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */