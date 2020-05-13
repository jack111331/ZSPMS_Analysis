package com.zz.sdk.e;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.Toast;
import com.zz.sdk.a.bs;

class ho implements DialogInterface.OnKeyListener {
  ho(hg paramhg, Context paramContext) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0 && paramInt == 4) {
      hg.b(this.b);
      if (hg.c(this.b) == 1) {
        Toast.makeText(this.a, "再按一次退出", 0).show();
        return false;
      } 
    } else {
      return false;
    } 
    if (hg.c(this.b) == 2) {
      bs.b(this.b.f);
      hg.c(this.b, 0);
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */