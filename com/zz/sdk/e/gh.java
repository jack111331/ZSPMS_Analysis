package com.zz.sdk.e;

import android.os.Handler;
import android.os.Message;
import com.zz.sdk.b.a.ae;

class gh extends Handler {
  gh(gg paramgg) {}
  
  public void handleMessage(Message paramMessage) {
    ae ae;
    switch (paramMessage.what) {
      default:
        return;
      case 100:
        break;
    } 
    gg gg1 = this.a;
    if (paramMessage.obj == null) {
      paramMessage = null;
    } else {
      ae = (ae)paramMessage.obj;
    } 
    gg.a(gg1, ae);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */