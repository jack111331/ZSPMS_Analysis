package com.zz.sdk.i;

import android.os.Handler;
import android.os.Message;

class bn extends Handler {
  bn(bl parambl) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    for (byte b = 0; b < (bl.c(this.a)).length; b++) {
      if (b == i) {
        bl.c(this.a)[b].setImageDrawable(d.b(bl.d(this.a), "zz_res/dian_03.png"));
      } else {
        bl.c(this.a)[b].setImageDrawable(d.b(bl.d(this.a), "zz_res/dian_05.png"));
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */