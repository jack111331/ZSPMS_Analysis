package com.zz.sdk.a;

import android.widget.RadioButton;

class fd implements Runnable {
  fd(fc paramfc) {}
  
  public void run() {
    fc.a(this.a);
    if (fc.b(this.a) >= fc.c(this.a) || fc.b(this.a) < 0)
      fc.a(this.a, 0); 
    ((RadioButton)fc.d(this.a).getChildAt(fc.b(this.a))).setChecked(true);
    fc.f(this.a).removeCallbacks(fc.e(this.a));
    fc.f(this.a).postDelayed(fc.e(this.a), 500L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */