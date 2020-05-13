package com.zz.sdk.a;

import android.content.DialogInterface;

class fx implements DialogInterface.OnCancelListener {
  fx(fr paramfr) {}
  
  public void onCancel(DialogInterface paramDialogInterface) {
    this.a.k.removeCallbacks(fr.a(this.a));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */