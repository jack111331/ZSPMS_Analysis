package com.zz.sdk.e;

import android.content.DialogInterface;

class hp implements DialogInterface.OnDismissListener {
  hp(hg paramhg) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    this.a.postDelayed(new hq(this), 100L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */