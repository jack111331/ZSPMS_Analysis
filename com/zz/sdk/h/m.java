package com.zz.sdk.h;

import android.content.DialogInterface;
import com.zz.sdk.SDKManager;

class m implements DialogInterface.OnClickListener {
  m(g paramg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    paramDialogInterface.dismiss();
    SDKManager.tryDestroyFloat(g.h(this.a));
    SDKManager.setShowFloat(false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */