package com.zz.sdk.e;

import android.view.KeyEvent;
import com.zz.sdk.g.b;

class eb extends b {
  eb(du paramdu) {}
  
  public Boolean a(int paramInt, KeyEvent paramKeyEvent) {
    Boolean bool;
    KeyEvent keyEvent = null;
    paramKeyEvent = keyEvent;
    if (paramInt == 4) {
      paramKeyEvent = keyEvent;
      if (du.c(this.a) != null) {
        paramKeyEvent = keyEvent;
        if (du.c(this.a).canGoBack()) {
          du.c(this.a).goBack();
          bool = Boolean.TRUE;
        } 
      } 
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */