package com.zz.sdk;

import android.os.Handler;

class l extends Thread {
  private Handler e = this.a;
  
  private int f = this.b;
  
  private String g = this.c;
  
  l(SDKManager paramSDKManager, String paramString1, Handler paramHandler, int paramInt, String paramString2) {
    super(paramString1);
  }
  
  public void run() {
    int i = this.d.queryOrderState(this.g);
    if (this.e != null)
      this.e.obtainMessage(this.f, 2, i, this.g).sendToTarget(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */