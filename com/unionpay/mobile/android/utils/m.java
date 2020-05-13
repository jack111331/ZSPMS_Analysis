package com.unionpay.mobile.android.utils;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.nocard.views.l;

final class m implements Handler.Callback {
  m(l paraml) {}
  
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return true;
      case 1:
        if (l.a(this.a) != null)
          ((l)l.a(this.a)).v(); 
      case 2:
        break;
    } 
    if (l.a(this.a) != null)
      ((l)l.a(this.a)).v(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */