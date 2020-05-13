package com.unionpay.mobile.android.hce;

import android.os.Message;

final class h extends Thread {
  h(f paramf, String paramString1, String paramString2) {}
  
  public final void run() {
    if (f.a(this.c, this.a, this.b)) {
      if (f.d(this.c) != null) {
        Message message = f.d(this.c).obtainMessage(2006, this.a);
        f.d(this.c).sendMessageDelayed(message, f.e(this.c));
      } 
      return;
    } 
    if (f.d(this.c) != null) {
      Message message = f.d(this.c).obtainMessage(2005, this.a);
      f.d(this.c).sendMessage(message);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */