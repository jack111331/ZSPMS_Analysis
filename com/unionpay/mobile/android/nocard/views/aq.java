package com.unionpay.mobile.android.nocard.views;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.views.order.l;

final class aq implements Handler.Callback {
  aq(ao paramao) {}
  
  public final boolean handleMessage(Message paramMessage) {
    if (this.a.a.aP == l.a.intValue() && !this.a.a.J) {
      if (!TextUtils.isEmpty(this.a.a.u)) {
        this.a.a(13, this.a.p);
        return true;
      } 
    } else {
      return true;
    } 
    if (this.a.a.aC)
      ao.d(this.a); 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */