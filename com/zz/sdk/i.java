package com.zz.sdk;

import android.content.Context;
import com.zz.sdk.b.a.ac;
import com.zz.sdk.i.s;
import com.zz.sdk.i.t;

class i extends Thread {
  i(SDKManager paramSDKManager, Context paramContext) {}
  
  public void run() {
    ac ac = t.a(this.a).a();
    if (ac.c()) {
      SDKManager.a(ac.p);
      s.a(this.a, "key_status_authentication", SDKManager.a());
    } else {
      SDKManager.a(s.b(this.a, "key_status_authentication", SDKManager.a()));
    } 
    SDKManager.a(this.b, true);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */