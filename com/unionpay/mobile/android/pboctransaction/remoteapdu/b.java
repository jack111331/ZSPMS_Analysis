package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.os.Handler;
import android.os.Message;

final class b implements Handler.Callback {
  b(a parama) {}
  
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return false;
      case 3000:
        break;
    } 
    if (this.a.a != null)
      this.a.a.b(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\remoteapdu\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */