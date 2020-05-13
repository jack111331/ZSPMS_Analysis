package com.jdpaysdk.author.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class d {
  public static String a(Context paramContext) {
    String str = "";
    if (paramContext == null)
      return str; 
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isConnected()) {
      if (networkInfo.getType() == 1)
        return "wifi"; 
      if (networkInfo.getType() == 0) {
        str = networkInfo.getSubtypeName();
        switch (networkInfo.getSubtype()) {
          default:
            if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA")) {
              String str1 = str;
              return str.equalsIgnoreCase("CDMA2000") ? "3G" : str1;
            } 
            return "3G";
          case 1:
          case 2:
          case 4:
          case 7:
          case 11:
            return "2G";
          case 3:
          case 5:
          case 6:
          case 8:
          case 9:
          case 10:
          case 12:
          case 14:
          case 15:
            return "3G";
          case 13:
            break;
        } 
        return "4G";
      } 
    } 
    return "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */