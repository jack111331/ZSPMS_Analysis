package com.unionpay;

import android.content.Context;
import android.content.DialogInterface;

final class h implements DialogInterface.OnClickListener {
  h(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    UPPayAssistEx.a(this.a, UPPayAssistEx.k(), UPPayAssistEx.q());
    paramDialogInterface.dismiss();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */