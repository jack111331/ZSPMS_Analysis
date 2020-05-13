package com.unionpay;

import android.os.Message;
import com.unionpay.a.c;

final class d extends Thread {
  public final void run() {
    UPPayAssistEx.o().sendEmptyMessageDelayed(1001, 600L);
    c c = new c(UPPayAssistEx.p(), UPPayAssistEx.c());
    c.a();
    String str = c.b();
    if (UPPayAssistEx.o() != null) {
      Message message = UPPayAssistEx.o().obtainMessage();
      message.what = 1002;
      message.obj = str;
      UPPayAssistEx.o().removeMessages(1001);
      UPPayAssistEx.o().sendMessage(message);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */