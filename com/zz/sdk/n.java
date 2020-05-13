package com.zz.sdk;

import com.zz.sdk.b.a.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;

class n implements Runnable {
  n(SDKManager paramSDKManager, t paramt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run() {
    a a = this.a.h(this.b, this.c, this.d);
    if (a.c()) {
      cm.a(SDKManager.a(this.g), this.e, this.f);
      cq.a(SDKManager.a(this.g)).a(0);
      bp.b("postRole() 上传成功: " + a.f);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */