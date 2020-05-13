package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Message;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.utils.k;

final class f implements b {
  f(b paramb) {}
  
  public final void a() {
    k.c("uppay-spay", "tsmservice  init success");
    b.bn = false;
    if (b.b(this.a) != null) {
      if (!b.b(this.a).e()) {
        b.aB = false;
        b.a(this.a, 8);
      } 
      return;
    } 
    b.a(this.a, 8);
  }
  
  public final void b() {
    k.c("UPCardEngine", "mSE init failed");
    k.c("uppay-spay", "tsmservice  init fail");
    if (b.a(this.a) != null) {
      Message message = b.a(this.a).obtainMessage(8, null);
      b.a(this.a).sendMessage(message);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\pboc\engine\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */