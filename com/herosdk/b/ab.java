package com.herosdk.b;

import android.content.DialogInterface;
import android.util.Log;

class ab implements DialogInterface.OnDismissListener {
  ab(aa paramaa) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    Log.d(a.b(), "rp np...if dismiss");
    this.a.c.e.onFailed(this.a.c.b.getCpOrderId(), "code:" + this.a.b + ",msg:" + this.a.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */