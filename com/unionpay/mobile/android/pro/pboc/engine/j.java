package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;

final class j implements Runnable {
  j(b paramb) {}
  
  public final void run() {
    synchronized (this.a) {
      k.c("UPCardEngine", " se_return : 8");
      if (b.bm) {
        if (b.a(this.a) != null) {
          Handler handler = b.a(this.a);
          ArrayList arrayList = new ArrayList();
          this();
          Message message = handler.obtainMessage(8, arrayList);
          b.a(this.a).sendMessage(message);
        } 
      } else if (b.f(this.a) != null) {
        ArrayList arrayList = b.f(this.a).b();
        if (!b.a(this.a, "com.unionpay.tsmservice") && b.a(this.a) != null) {
          Message message = b.a(this.a).obtainMessage(8, arrayList);
          b.a(this.a).sendMessage(message);
        } 
      } 
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\pboc\engine\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */