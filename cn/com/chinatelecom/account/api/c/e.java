package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import cn.com.chinatelecom.account.api.CtAuth;
import java.lang.reflect.Method;

public class e {
  private static int a(int paramInt) {
    switch (paramInt) {
      default:
        return paramInt;
      case -1:
        paramInt = -1;
      case -101:
        paramInt = -101;
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
      case 16:
        paramInt = 1;
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
      case 17:
        paramInt = 2;
      case 13:
      case 18:
      case 19:
        break;
    } 
    paramInt = 3;
  }
  
  public static NetworkInfo a(Context paramContext) {
    return (paramContext == null) ? null : ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static boolean b(Context paramContext) {
    NetworkInfo networkInfo = a(paramContext);
    return (networkInfo != null && networkInfo.isAvailable());
  }
  
  public static boolean c(Context paramContext) {
    boolean bool = true;
    NetworkInfo networkInfo = a(paramContext);
    if (networkInfo == null || networkInfo.getType() != 1)
      bool = false; 
    return bool;
  }
  
  public static boolean d(Context paramContext) {
    NetworkInfo networkInfo = a(paramContext);
    return (networkInfo != null && networkInfo.getType() == 0);
  }
  
  public static boolean e(Context paramContext) {
    boolean bool;
    if (paramContext == null)
      return true; 
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      Method method = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      method.setAccessible(true);
      bool = ((Boolean)method.invoke(connectivityManager, new Object[0])).booleanValue();
    } catch (Throwable throwable) {
      CtAuth.warn("NetUtil", "isMobileEnable error ", throwable);
      bool = true;
    } 
    return bool;
  }
  
  public static String f(Context paramContext) {
    String str1 = "";
    boolean bool1 = c(paramContext);
    boolean bool2 = e(paramContext);
    if (bool1 && !bool2)
      return "2"; 
    if (bool2 && !bool1)
      return "0"; 
    if (bool1 && bool2)
      return "1"; 
    String str2 = str1;
    if (!bool1) {
      str2 = str1;
      if (!bool2) {
        str2 = str1;
        if (d(paramContext))
          str2 = "0"; 
      } 
    } 
    return str2;
  }
  
  public static String g(Context paramContext) {
    int i = h(paramContext);
    switch (i) {
      default:
        return Integer.toString(i);
      case -1:
        return "unnet";
      case -101:
        return "wifi";
      case 1:
        return "2g";
      case 2:
        return "3g";
      case 3:
        return "4g";
      case 0:
        break;
    } 
    return "-1";
  }
  
  private static int h(Context paramContext) {
    try {
      NetworkInfo networkInfo = a(paramContext);
      if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
        int i = networkInfo.getType();
        if (i == 1) {
          i = -101;
          return a(i);
        } 
        if (i == 0) {
          try {
            int j = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
            i = j;
            if (j == 0)
              try {
                i = networkInfo.getSubtype();
              } catch (NullPointerException nullPointerException) {
                i = j;
              } catch (Exception exception) {
                i = j;
                exception.printStackTrace();
              }  
          } catch (Exception exception) {}
          return a(i);
        } 
      } else {
        byte b = -1;
        return a(b);
      } 
    } catch (NullPointerException nullPointerException) {
      boolean bool1 = false;
      nullPointerException.printStackTrace();
      return a(bool1);
    } catch (Exception exception) {
      boolean bool1 = false;
      exception.printStackTrace();
    } 
    boolean bool = false;
    return a(bool);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */