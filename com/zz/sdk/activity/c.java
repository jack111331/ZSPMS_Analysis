package com.zz.sdk.activity;

import android.content.DialogInterface;
import android.webkit.ValueCallback;

class c implements DialogInterface.OnCancelListener {
  c(FloatActivity paramFloatActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface) {
    if (FloatActivity.a(this.a) != null) {
      FloatActivity.a(this.a).onReceiveValue(null);
      FloatActivity.a(this.a, (ValueCallback)null);
    } 
    if (FloatActivity.b(this.a) != null) {
      FloatActivity.b(this.a).onReceiveValue(null);
      FloatActivity.b(this.a, null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\activity\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */