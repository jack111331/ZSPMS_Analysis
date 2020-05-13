package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.utils.h;

final class c implements Handler.Callback {
  c(b paramb) {}
  
  public final boolean handleMessage(Message paramMessage) {
    Bundle bundle;
    switch (paramMessage.what) {
      default:
        return false;
      case 4000:
        b.a(this.a).removeMessages(4);
        bundle = (Bundle)paramMessage.obj;
        b.a(this.a, bundle);
      case 1:
        break;
    } 
    b.a(this.a).removeMessages(4);
    h.b("uppay", "msg error");
    int i = ((Message)bundle).arg1;
    String str = (String)((Message)bundle).obj;
    b.a(this.a, i, str);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */