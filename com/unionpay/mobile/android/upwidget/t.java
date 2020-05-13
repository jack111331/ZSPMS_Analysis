package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;

final class t extends Handler {
  t(UPRadiationView paramUPRadiationView) {}
  
  public final void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 0:
        break;
    } 
    UPRadiationView.a(this.a);
    this.a.invalidate();
    if (UPRadiationView.b(this.a) != null && UPRadiationView.b(this.a).size() > 0)
      UPRadiationView.c(this.a).sendEmptyMessageDelayed(0, 50L); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */