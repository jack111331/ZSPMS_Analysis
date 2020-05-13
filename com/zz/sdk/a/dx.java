package com.zz.sdk.a;

import android.content.DialogInterface;
import android.view.KeyEvent;

class dx implements DialogInterface.OnKeyListener {
  private int b = 0;
  
  dx(ds paramds) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0 && paramInt == 4) {
      this.b++;
      if (this.b == 1) {
        this.a.b(2131165259);
        return false;
      } 
    } else {
      return false;
    } 
    if (this.b == 2)
      bv.d(this.a.b); 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */