package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Message;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;

final class h implements Runnable {
  h(b paramb) {}
  
  public final void run() {
    synchronized (this.a) {
      k.c("UPCardEngine", " cmcc_return : 2");
      ArrayList arrayList = b.d(this.a).b();
      if (b.a(this.a) != null) {
        Message message = b.a(this.a).obtainMessage(2, arrayList);
        b.a(this.a).sendMessage(message);
      } 
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\pboc\engine\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */