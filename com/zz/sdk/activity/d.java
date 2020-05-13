package com.zz.sdk.activity;

import android.content.DialogInterface;
import com.zz.sdk.i.bj;

class d implements DialogInterface.OnClickListener {
  d(FloatActivity paramFloatActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    if (paramInt == 0) {
      FloatActivity.a(this.a, bj.a());
      this.a.startActivityForResult(FloatActivity.c(this.a), 0);
      return;
    } 
    FloatActivity.a(this.a, bj.b());
    this.a.startActivityForResult(FloatActivity.c(this.a), 1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\activity\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */