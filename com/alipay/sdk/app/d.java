package com.alipay.sdk.app;

import android.content.DialogInterface;

final class d implements DialogInterface.OnClickListener {
  d(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    b.a(this.a.b, true);
    this.a.a.proceed();
    paramDialogInterface.dismiss();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */