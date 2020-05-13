package com.herosdk.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.herosdk.error.ErrorUtils;

public class a extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    try {
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
        NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null) {
          if (networkInfo.getType() == 1) {
            c.a(1);
            return;
          } 
          String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
          switch (networkInfo.getSubtype()) {
            default:
              c.a(0);
              return;
            case 13:
              if ("46002".equals(str) || "46000".equals(str)) {
                c.a(2);
                return;
              } 
              if ("46003".equals(str)) {
                c.a(5);
                return;
              } 
              if ("46001".equals(str))
                c.a(8); 
              return;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
              if ("46002".equals(str) || "46000".equals(str)) {
                c.a(3);
                return;
              } 
              if ("46003".equals(str)) {
                c.a(6);
                return;
              } 
              if ("46001".equals(str))
                c.a(9); 
              return;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
              break;
          } 
          if ("46002".equals(str) || "46000".equals(str)) {
            c.a(4);
            return;
          } 
          if ("46003".equals(str)) {
            c.a(7);
            return;
          } 
          if ("46001".equals(str))
            c.a(10); 
          return;
        } 
      } else {
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    c.a(-1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */