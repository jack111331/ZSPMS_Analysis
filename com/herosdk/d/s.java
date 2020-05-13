package com.herosdk.d;

import android.content.Context;

class s implements Runnable {
  s(r paramr, Context paramContext) {}
  
  public void run() {
    try {
      if (r.a(this.b) == null)
        r.a(this.b, this.a); 
      if (r.d() != this.a)
        if (r.a(this.b).isShowing()) {
          r.a(this.b).dismiss();
          r.a(this.b, this.a);
        } else {
          r.a(this.b, this.a);
        }  
      if (r.a(this.b) != null && !r.a(this.b).isShowing()) {
        r.a(this.b).show();
        if (r.b(this.b) != null && r.c(this.b) != null)
          r.b(this.b).startAnimation(r.c(this.b)); 
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */