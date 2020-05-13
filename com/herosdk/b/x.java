package com.herosdk.b;

import com.herosdk.a.d;

class x implements Runnable {
  x(u paramu, String paramString, int paramInt) {}
  
  public void run() {
    d d = (new d(this.c.c)).b("温馨提示").a(this.a).b("确定", null);
    d.setOnDismissListener(new y(this));
    d.show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */