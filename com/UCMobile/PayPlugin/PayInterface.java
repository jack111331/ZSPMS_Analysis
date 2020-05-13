package com.UCMobile.PayPlugin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.unionpay.mobile.android.utils.k;

public class PayInterface {
  private static boolean a = false;
  
  public static int show(Context paramContext, String paramString) {
    boolean bool1 = false;
    boolean bool2 = true;
    k.a("uppay", "UC.PayInterface.show() +++ ");
    if (!a) {
      IntentFilter intentFilter = new IntentFilter("com.unionpay.uppay.resultURL");
      paramContext.registerReceiver(new PayResultReceiver(), intentFilter);
      a = true;
    } 
    if (paramString == null) {
      k.a("uppay", "data == null!!!!");
      return -1;
    } 
    String[] arrayOfString = paramString.split(",");
    null = bool2;
    if (arrayOfString != null)
      if (arrayOfString.length == 1) {
        null = bool2;
      } else {
        null = false;
      }  
    Bundle bundle = new Bundle();
    bundle.putInt("reqOriginalId", 4);
    if (null) {
      bundle.putString("paydata", paramString);
    } else {
      bundle.putString("oldVersionPlugin", "true");
    } 
    paramString = paramContext.getPackageName();
    if (paramString != null && paramString.startsWith("com.UCMobile")) {
      Intent intent2 = new Intent();
      intent2.setFlags(33554432);
      intent2.putExtras(bundle);
      intent2.putExtra("PackageName", paramString);
      intent2.setClassName("com.unionpay.uppay", "com.unionpay.uppay.PayActivity");
      paramContext.startActivity(intent2);
      Intent intent1 = new Intent("com.UCMobile.PluginApp.ActivityState");
      intent1.putExtra("ActivityState", "active");
      intent1.putExtra("PackageName", paramString);
      intent1.addCategory("android.intent.category.DEFAULT");
      paramContext.sendBroadcast(intent1);
    } 
    k.a("uppay", "UC.PayInterface.show() +++ ");
    return bool1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\UCMobile\PayPlugin\PayInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */