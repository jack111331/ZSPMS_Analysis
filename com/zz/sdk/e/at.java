package com.zz.sdk.e;

import android.view.KeyEvent;
import android.view.View;
import com.zz.sdk.i.bp;

class at implements View.OnKeyListener {
  at(al paramal) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    null = true;
    if (paramInt == 4 && al.a(this.a).canGoBack()) {
      al.a(this.a).goBack();
      al.a(this.a, true);
      bp.a("isOnReceivedTitle = " + al.b(this.a));
      return null;
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */