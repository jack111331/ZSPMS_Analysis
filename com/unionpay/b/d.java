package com.unionpay.b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.utils.h;

final class d implements UPTsmAddon.UPTsmConnectionListener {
  d(b paramb) {}
  
  public final void onTsmConnected() {
    h.b("uppay", "TsmService connected.");
    this.a.b();
  }
  
  public final void onTsmDisconnected() {
    Log.e("uppay", "TsmService disconnected.");
    b.a(this.a, b.b(this.a), b.c(this.a), UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */