package com.zz.sdk.a;

import android.view.KeyEvent;
import android.view.View;

class c implements View.OnKeyListener {
  c(a parama) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0 && paramInt == 67 && a.a(this.a) != null)
      a.a(this.a).setText(""); 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */