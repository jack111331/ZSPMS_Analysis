package com.hu.zxlib.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class h extends BroadcastReceiver {
  private h(e parame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction())) {
      boolean bool;
      if (paramIntent.getIntExtra("plugged", -1) <= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        this.a.a();
      } else {
        e.a(this.a);
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */