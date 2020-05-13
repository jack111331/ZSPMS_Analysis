package com.herosdk.d;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

class ag implements DialogInterface.OnClickListener {
  ag(ae paramae) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    Intent intent = new Intent();
    intent.setAction("android.intent.action.VIEW");
    intent.setData(Uri.parse(this.a.c));
    this.a.a.startActivity(intent);
    x.a(this.a.e, paramDialogInterface, Boolean.valueOf(false));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */