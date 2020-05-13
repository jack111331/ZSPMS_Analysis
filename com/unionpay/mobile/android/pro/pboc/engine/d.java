package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.b;

final class d implements b {
  d(b paramb) {}
  
  public final void a() {
    b.a(this.a, 2);
  }
  
  public final void b() {
    if (b.a(this.a) != null) {
      Message message = b.a(this.a).obtainMessage(2, null);
      b.a(this.a).sendMessage(message);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\pboc\engine\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */