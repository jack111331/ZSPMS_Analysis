package com.herosdk.a;

import android.widget.RadioButton;

class m implements Runnable {
  m(l paraml) {}
  
  public void run() {
    l.a(this.a);
    if (l.b(this.a) >= l.c(this.a) || l.b(this.a) < 0)
      l.a(this.a, 0); 
    ((RadioButton)l.d(this.a).getChildAt(l.b(this.a))).setChecked(true);
    l.f(this.a).removeCallbacks(l.e(this.a));
    l.f(this.a).postDelayed(l.e(this.a), 500L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */