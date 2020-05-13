package com.unionpay.mobile.android.widgets;

import android.os.Message;

final class ar extends Thread {
  ar(ap paramap, int paramInt) {}
  
  public final void run() {
    if (ap.b(this.b) != null) {
      long l = System.currentTimeMillis() + (this.a * 1000);
      label15: while (true) {
        long l1 = System.currentTimeMillis();
        if (l1 <= l) {
          int i = (int)((l - l1 + this.a) / 1000L);
          if (i > 0) {
            Message message = Message.obtain();
            message.what = 0;
            message.arg1 = i;
            ap.b(this.b).sendMessage(message);
            try {
              sleep(1000L);
            } catch (InterruptedException interruptedException) {
              ap.b(this.b).sendEmptyMessage(1);
              break label15;
            } 
            continue;
          } 
        } 
        break;
      } 
    } else {
      return;
    } 
    ap.b(this.b).sendEmptyMessage(1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */