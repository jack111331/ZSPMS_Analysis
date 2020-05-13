package com.herosdk.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

final class bc implements Runnable {
  bc(Activity paramActivity, String paramString, Boolean paramBoolean) {}
  
  public void run() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.a);
    builder.setTitle("提示");
    builder.setMessage(this.b);
    builder.setCancelable(false);
    builder.setPositiveButton("关闭", new bd(this));
    builder.show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */