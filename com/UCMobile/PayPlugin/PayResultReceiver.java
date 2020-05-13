package com.UCMobile.PayPlugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PayResultReceiver extends BroadcastReceiver {
  private static native void native_UCPayResultNotify(String paramString);
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    native_UCPayResultNotify(paramIntent.getStringExtra("ResultURL"));
    String str = paramContext.getPackageName();
    if (str.startsWith("com.UCMobile")) {
      paramIntent = new Intent("com.UCMobile.PluginApp.ActivityState");
      paramIntent.putExtra("ActivityState", "inactive");
      paramIntent.putExtra("PackageName", str);
      paramContext.sendBroadcast(paramIntent);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\UCMobile\PayPlugin\PayResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */