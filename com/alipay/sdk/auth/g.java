package com.alipay.sdk.auth;

import android.content.DialogInterface;

final class g implements DialogInterface.OnClickListener {
  g(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    this.a.a.cancel();
    AuthActivity.a(this.a.b.a, false);
    String str = AuthActivity.c(this.a.b.a) + "?resultCode=150";
    h.a(this.a.b.a, str);
    this.a.b.a.finish();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */