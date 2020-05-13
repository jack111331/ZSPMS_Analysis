package com.herosdk.b;

import com.herosdk.a.d;

class r implements Runnable {
  r(p paramp, String paramString, int paramInt) {}
  
  public void run() {
    d d = (new d(this.c.b)).b("温馨提示").a(this.a).b("确定", null);
    d.setOnDismissListener(new s(this));
    d.show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */