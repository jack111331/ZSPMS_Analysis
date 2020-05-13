package com.alipay.apmobilesecuritysdk.face;

import com.alipay.apmobilesecuritysdk.a.a;
import java.util.Map;

class APSecuritySdk$1 implements Runnable {
  APSecuritySdk$1(APSecuritySdk paramAPSecuritySdk, Map paramMap, APSecuritySdk.InitResultListener paramInitResultListener) {}
  
  public void run() {
    (new a(APSecuritySdk.a(this.c))).a(this.a);
    if (this.b != null)
      this.b.onResult(this.c.getTokenResult()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\APSecuritySdk$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */