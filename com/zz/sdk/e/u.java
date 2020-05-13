package com.zz.sdk.e;

import android.os.Handler;
import android.os.Message;

class u extends Handler {
  u(t paramt) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what == 2102033 && paramMessage.arg1 == 1 && paramMessage.arg2 == 0)
      t.a(this.a, true); 
    super.handleMessage(paramMessage);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */