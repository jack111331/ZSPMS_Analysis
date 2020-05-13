package com.xy.whf.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class i {
  public static int a(Context paramContext) {
    boolean bool;
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return 0; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo == null || !networkInfo.isAvailable())
        return 0; 
      networkInfo = connectivityManager.getNetworkInfo(1);
      if (networkInfo != null) {
        NetworkInfo.State state = networkInfo.getState();
        if (state != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING))
          return 1; 
      } 
      null = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      switch (null) {
        default:
          return 5;
        case 1:
        case 2:
        case 4:
        case 7:
        case 11:
          return 2;
        case 3:
        case 5:
        case 6:
        case 8:
        case 9:
        case 10:
        case 12:
        case 14:
        case 15:
          return 3;
        case 13:
          break;
      } 
      bool = true;
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */