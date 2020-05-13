package com.alipay.sdk.app;

import android.content.DialogInterface;

final class e implements DialogInterface.OnClickListener {
  e(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    this.a.a.cancel();
    b.a(this.a.b, false);
    i.a = i.a();
    b.a(this.a.b).finish();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */