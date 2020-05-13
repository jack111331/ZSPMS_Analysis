package com.zz.sdk.e;

import android.content.DialogInterface;
import android.text.ClipboardManager;
import com.zz.sdk.i.cg;

class fm implements DialogInterface.OnClickListener {
  fm(fj paramfj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    ClipboardManager clipboardManager = (ClipboardManager)this.a.f.getSystemService("clipboard");
    if (clipboardManager != null) {
      clipboardManager.setText(fj.c(this.a));
      this.a.b(cg.aX);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */