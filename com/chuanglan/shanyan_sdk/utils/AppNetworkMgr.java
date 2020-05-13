package com.chuanglan.shanyan_sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class AppNetworkMgr {
  private static final int a = -1231545315;
  
  private static int a(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo != null) ? networkInfo.getType() : -1231545315;
  }
  
  public static boolean getMobileDataState(Context paramContext, Object[] paramArrayOfObject) {
    boolean bool;
    try {
      if (hasSimCard(paramContext)) {
        Class[] arrayOfClass;
        ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        Class<?> clazz = connectivityManager.getClass();
        paramContext = null;
        if (paramArrayOfObject != null) {
          arrayOfClass = new Class[1];
          arrayOfClass[0] = paramArrayOfObject.getClass();
        } 
        return ((Boolean)clazz.getMethod("getMobileDataEnabled", arrayOfClass).invoke(connectivityManager, paramArrayOfObject)).booleanValue();
      } 
      bool = false;
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "getMobileDataState()Exception == " + exception.toString());
      bool = false;
    } 
    return bool;
  }
  
  public static boolean hasSimCard(Context paramContext) {
    boolean bool1;
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (telephonyManager != null) {
      bool1 = telephonyManager.getSimState();
    } else {
      bool1 = false;
    } 
    boolean bool2 = true;
    switch (bool1) {
      default:
        return bool2;
      case true:
        bool2 = false;
      case false:
        break;
    } 
    bool2 = false;
  }
  
  public static boolean isWifiByType(Context paramContext) {
    boolean bool = true;
    if (a(paramContext) != 1)
      bool = false; 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\AppNetworkMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */