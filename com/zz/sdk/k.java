package com.zz.sdk;

import com.zz.sdk.i.cq;

class k extends Thread {
  k(SDKManager paramSDKManager) {}
  
  public void run() {
    cq.a(SDKManager.b().getParent(g.class.getName()), SDKManager.a(this.a), false);
    SDKManager.loginSuccess();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */