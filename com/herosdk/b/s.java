package com.herosdk.b;

import android.content.DialogInterface;
import android.util.Log;

class s implements DialogInterface.OnDismissListener {
  s(r paramr) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    Log.d(a.b(), "l np...if dismiss");
    this.a.c.a.onFailed("code:" + this.a.b + ",msg:" + this.a.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */