package com.zz.sdk.e;

import android.os.Handler;
import android.os.Message;

class hh extends Handler {
  hh(hg paramhg) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what >= 65536) {
      int i = paramMessage.what;
      hg.a(this.a, i - 65536);
      return;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */