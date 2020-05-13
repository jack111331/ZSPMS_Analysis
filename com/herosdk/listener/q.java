package com.herosdk.listener;

import com.herosdk.error.ErrorUtils;

class q implements Runnable {
  q(p paramp, int paramInt, String paramString) {}
  
  public void run() {
    try {
      if (p.a(this.c) != null)
        p.a(this.c).onKick(this.a, this.b); 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */