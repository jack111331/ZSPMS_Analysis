package com.tencent.a.a.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.tencent.wxop.stat.b.g;
import org.json.JSONObject;

public final class h {
  private static void a(String paramString, Throwable paramThrowable) {
    Log.e("MID", paramString, paramThrowable);
  }
  
  static void a(JSONObject paramJSONObject, String paramString1, String paramString2) {
    if (d(paramString2))
      paramJSONObject.put(paramString1, paramString2); 
  }
  
  static boolean a(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0)
        bool = true; 
    } catch (Throwable throwable) {
      a("checkPermission error", throwable);
    } 
    return bool;
  }
  
  static String b(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
        String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (str != null)
          return str; 
      } else {
        Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
      } 
    } catch (Throwable throwable) {
      Log.w("MID", throwable);
    } 
    return "";
  }
  
  static String c(Context paramContext) {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      String str;
      try {
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager == null)
          return ""; 
        str = wifiManager.getConnectionInfo().getMacAddress();
      } catch (Exception exception) {
        Log.i("MID", "get wifi address error" + exception);
        str = "";
      } 
      return str;
    } 
    Log.i("MID", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
    return "";
  }
  
  static boolean d(String paramString) {
    return !(paramString == null || paramString.trim().length() == 0);
  }
  
  public static boolean e(String paramString) {
    return (paramString != null && paramString.trim().length() >= 40);
  }
  
  static String f(String paramString) {
    if (paramString == null)
      return null; 
    String str = paramString;
    if (Build.VERSION.SDK_INT >= 8)
      try {
        byte[] arrayOfByte = g.c(Base64.decode(paramString.getBytes("UTF-8"), 0));
        String str2 = new String();
        this(arrayOfByte, "UTF-8");
        String str1 = str2.trim().replace("\t", "").replace("\n", "").replace("\r", "");
      } catch (Throwable throwable) {
        a("decode error", throwable);
        str = paramString;
      }  
    return str;
  }
  
  static String g(String paramString) {
    if (paramString == null)
      return null; 
    String str = paramString;
    if (Build.VERSION.SDK_INT >= 8)
      try {
        byte[] arrayOfByte = Base64.encode(g.b(paramString.getBytes("UTF-8")), 0);
        str = new String();
        this(arrayOfByte, "UTF-8");
        str = str.trim().replace("\t", "").replace("\n", "").replace("\r", "");
      } catch (Throwable throwable) {
        a("decode error", throwable);
        str = paramString;
      }  
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */