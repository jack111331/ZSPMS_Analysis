package com.unionpay.mobile.android.pboctransaction.samsung;

import android.util.Log;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.UPTsmAddon;

final class h implements UPTsmAddon.UPTsmConnectionListener {
  h(f paramf) {}
  
  public final void onTsmConnected() {
    k.c("uppay", "TsmService connected.");
    f.f(this.a);
  }
  
  public final void onTsmDisconnected() {
    Log.e("uppay", "TsmService disconnected.");
    f.a(this.a, false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\samsung\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */