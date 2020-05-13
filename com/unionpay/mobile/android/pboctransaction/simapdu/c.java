package com.unionpay.mobile.android.pboctransaction.simapdu;

import android.os.Handler;
import android.os.Message;

final class c implements Handler.Callback {
  c(b paramb) {}
  
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return true;
      case 1:
        if (b.a(this.a) != null) {
          b.a(this.a).a();
          b.b(this.a);
        } 
      case 2:
        break;
    } 
    if (b.a(this.a) != null) {
      b.a(this.a).b();
      b.b(this.a);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\simapdu\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */