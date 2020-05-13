package com.zz.sdk.e;

import android.os.Handler;
import android.os.Message;

class fk extends Handler {
  fk(fj paramfj) {}
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 2014:
        fj.a(this.a);
      case 2015:
        fj.a(this.a, paramMessage.arg1);
      case 2016:
        fj.b(this.a);
      case 2017:
        break;
    } 
    fj.a(this.a, paramMessage.arg1, paramMessage.obj);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */