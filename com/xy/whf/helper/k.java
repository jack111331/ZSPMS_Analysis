package com.xy.whf.helper;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

public class k {
  public static JSONObject a(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE")) {
        jSONObject.put("net_type", i.a(paramContext));
        jSONObject.put("phone", b(paramContext));
        jSONObject.put("imsi", c(paramContext));
        jSONObject.put("network_country_iso", d(paramContext));
        jSONObject.put("network_operator", e(paramContext));
        jSONObject.put("network_operator_name", f(paramContext));
        jSONObject.put("phone_type", g(paramContext));
        jSONObject.put("sim_country_iso", h(paramContext));
        jSONObject.put("sim_operator", i(paramContext));
        jSONObject.put("sim_operator_name", j(paramContext));
        jSONObject.put("sim_serial_number", k(paramContext));
        jSONObject.put("sim_state", l(paramContext));
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return jSONObject;
  }
  
  public static String b(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String c(Context paramContext) {
    String str;
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE")) {
        str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        try {
          boolean bool = LangHelper.isNullOrEmpty(str);
          if (!bool);
          return str;
        } catch (Exception null) {}
      } else {
        return "none";
      } 
    } catch (Exception exception) {
      str = "none";
    } 
    exception.printStackTrace();
    return str;
  }
  
  public static String d(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkCountryIso(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String e(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String f(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static int g(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return -1;
  }
  
  public static String h(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String i(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String j(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperatorName(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String k(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static int l(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ((TelephonyManager)paramContext.getSystemService("phone")).getSimState(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return -1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */