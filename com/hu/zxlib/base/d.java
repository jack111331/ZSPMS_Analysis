package com.hu.zxlib.base;

import android.app.Activity;
import android.content.DialogInterface;

public final class d implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
  private final Activity a;
  
  public d(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  private void a() {
    this.a.finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */