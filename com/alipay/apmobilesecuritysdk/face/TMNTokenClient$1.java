package com.alipay.apmobilesecuritysdk.face;

import com.alipay.apmobilesecuritysdk.a.a;
import java.util.Map;

class TMNTokenClient$1 implements Runnable {
  TMNTokenClient$1(TMNTokenClient paramTMNTokenClient, Map paramMap, TMNTokenClient.InitResultListener paramInitResultListener, String paramString) {}
  
  public void run() {
    int i = (new a(TMNTokenClient.a(this.d))).a(this.a);
    if (this.b != null) {
      if (i == 0) {
        String str = a.a(TMNTokenClient.a(this.d), this.c);
        this.b.onResult(str, 0);
        return;
      } 
      this.b.onResult("", i);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\TMNTokenClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */