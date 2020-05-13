package com.zz.a.a.c;

import android.os.Handler;
import android.os.Message;

class g extends Handler {
  private g() {}
  
  public void handleMessage(Message paramMessage) {
    f f = (f)paramMessage.obj;
    switch (paramMessage.what) {
      default:
        return;
      case 1:
        a.c(f.a, f.b[0]);
      case 2:
        break;
    } 
    f.a.b(f.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */