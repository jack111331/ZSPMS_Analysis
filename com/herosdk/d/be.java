package com.herosdk.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

final class be implements Runnable {
  be(Activity paramActivity, String paramString1, String paramString2) {}
  
  public void run() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.a);
    builder.setTitle(this.b);
    builder.setMessage(this.c);
    builder.setCancelable(true);
    builder.setPositiveButton("关闭", new bf(this));
    builder.show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */