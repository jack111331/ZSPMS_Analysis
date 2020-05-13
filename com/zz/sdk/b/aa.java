package com.zz.sdk.b;

import android.content.Context;
import android.content.DialogInterface;
import com.unionpay.UPPayAssistEx;

class aa implements DialogInterface.OnClickListener {
  aa(z paramz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    UPPayAssistEx.installUPPayPlugin((Context)z.a(this.a));
    paramDialogInterface.dismiss();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */