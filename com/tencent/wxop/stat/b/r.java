package com.tencent.wxop.stat.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {
  private static String a = "";
  
  private static WifiInfo T(Context paramContext) {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      WifiManager wifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (wifiManager != null)
        return wifiManager.getConnectionInfo(); 
    } 
    return null;
  }
  
  public static String U(Context paramContext) {
    try {
      WifiInfo wifiInfo = T(paramContext);
      if (wifiInfo != null)
        return wifiInfo.getBSSID(); 
    } catch (Throwable throwable) {
      Log.e("MtaSDK", "encode error", throwable);
    } 
    return null;
  }
  
  public static String V(Context paramContext) {
    try {
      WifiInfo wifiInfo = T(paramContext);
      if (wifiInfo != null)
        return wifiInfo.getSSID(); 
    } catch (Throwable throwable) {
      Log.e("MtaSDK", "encode error", throwable);
    } 
    return null;
  }
  
  public static boolean W(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.INTERNET") && a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (connectivityManager != null) {
          NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
          if (networkInfo != null && networkInfo.isAvailable())
            return true; 
          Log.w("MtaSDK", "Network error");
          return false;
        } 
      } else {
        Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
      } 
    } catch (Throwable throwable) {
      Log.e("MtaSDK", "isNetworkAvailable error", throwable);
    } 
    return false;
  }
  
  public static JSONArray X(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.INTERNET") && a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager != null) {
          List<?> list = wifiManager.getScanResults();
          if (list != null && list.size() > 0) {
            s s = new s();
            this();
            Collections.sort(list, s);
            JSONArray jSONArray = new JSONArray();
            this();
            for (byte b = 0; b < list.size() && b < 10; b++) {
              ScanResult scanResult = (ScanResult)list.get(b);
              JSONObject jSONObject = new JSONObject();
              this();
              jSONObject.put("bs", scanResult.BSSID);
              jSONObject.put("ss", scanResult.SSID);
              jSONArray.put(jSONObject);
            } 
            return jSONArray;
          } 
        } 
      } else {
        Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
      } 
    } catch (Throwable throwable) {
      Log.e("MtaSDK", "isWifiNet error", throwable);
    } 
    return null;
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2) {
    if (paramString2 != null)
      try {
        if (paramString2.length() > 0)
          paramJSONObject.put(paramString1, paramString2); 
      } catch (Throwable throwable) {
        Log.e("MtaSDK", "jsonPut error", throwable);
      }  
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0)
        bool = true; 
    } catch (Throwable throwable) {
      Log.e("MtaSDK", "checkPermission error", throwable);
    } 
    return bool;
  }
  
  public static String b(Context paramContext) {
    try {
      if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
        String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (str != null)
          return str; 
      } else {
        Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
      } 
    } catch (Throwable throwable) {
      Log.e("MtaSDK", "get device id error", throwable);
    } 
    return null;
  }
  
  public static String c(Context paramContext) {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      String str;
      try {
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager == null)
          return ""; 
        str = wifiManager.getConnectionInfo().getMacAddress();
      } catch (Exception exception) {
        Log.e("MtaSDK", "get wifi address error", exception);
        str = "";
      } 
      return str;
    } 
    Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
    return "";
  }
  
  public static String q(String paramString) {
    if (paramString == null)
      return null; 
    String str = paramString;
    if (Build.VERSION.SDK_INT >= 8)
      try {
        byte[] arrayOfByte = h.e(g.b(paramString.getBytes("UTF-8")));
        str = new String();
        this(arrayOfByte, "UTF-8");
      } catch (Throwable throwable) {
        Log.e("MtaSDK", "encode error", throwable);
        str = paramString;
      }  
    return str;
  }
  
  public static String t(String paramString) {
    if (paramString == null)
      return null; 
    String str = paramString;
    if (Build.VERSION.SDK_INT >= 8)
      try {
        byte[] arrayOfByte = g.c(h.d(paramString.getBytes("UTF-8")));
        str = new String();
        this(arrayOfByte, "UTF-8");
      } catch (Throwable throwable) {
        Log.e("MtaSDK", "decode error", throwable);
        str = paramString;
      }  
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */