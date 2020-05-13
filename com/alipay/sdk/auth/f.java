package com.alipay.sdk.auth;

import android.content.DialogInterface;

final class f implements DialogInterface.OnClickListener {
  f(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    AuthActivity.a(this.a.b.a, true);
    this.a.a.proceed();
    paramDialogInterface.dismiss();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */