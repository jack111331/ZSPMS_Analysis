package org.jar.mvchelper.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
  public static boolean hasNetwork(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null) {
        boolean bool = networkInfo.isAvailable();
        if (bool)
          return true; 
      } 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return false;
  }
  
  public static boolean isWifi(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool = false;
    if (networkInfo == null)
      return false; 
    if (networkInfo.getType() == 1)
      bool = true; 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelpe\\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */