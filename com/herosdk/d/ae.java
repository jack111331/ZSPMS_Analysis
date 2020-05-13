package com.herosdk.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

class ae implements Runnable {
  ae(x paramx, Activity paramActivity, String paramString1, String paramString2, int paramInt) {}
  
  public void run() {
    (new AlertDialog.Builder((Context)this.a)).setTitle("检查更新").setMessage(this.b).setCancelable(false).setPositiveButton("下载", new ag(this)).setNeutralButton("取消", new af(this)).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */