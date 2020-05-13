package com.herosdk.d;

import android.text.TextUtils;
import com.herosdk.bean.RoleInfo;

public class am {
  private static final String a = "10000";
  
  private static final String b = "noServer";
  
  private static final String c = "noRoleName";
  
  private static final String d = "1";
  
  private static final String e = "0";
  
  private static final String f = "0";
  
  private static final String g = "0";
  
  public static String a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String str = paramString;
      return paramString.equalsIgnoreCase("null") ? "10000" : str;
    } 
    return "10000";
  }
  
  public static void a(RoleInfo paramRoleInfo) {
    if (paramRoleInfo != null) {
      paramRoleInfo.setServerId(a(paramRoleInfo.getServerId()));
      paramRoleInfo.setServerName(b(paramRoleInfo.getServerName()));
      paramRoleInfo.setRoleName(c(paramRoleInfo.getRoleName()));
      paramRoleInfo.setRoleId(d(paramRoleInfo.getRoleId()));
      paramRoleInfo.setRoleBalance(e(paramRoleInfo.getRoleBalance()));
      paramRoleInfo.setVipLevel(f(paramRoleInfo.getVipLevel()));
      paramRoleInfo.setRoleLevel(g(paramRoleInfo.getRoleLevel()));
    } 
  }
  
  public static String b(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String str = paramString;
      return paramString.equalsIgnoreCase("null") ? "noServer" : str;
    } 
    return "noServer";
  }
  
  public static String c(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String str = paramString;
      return paramString.equalsIgnoreCase("null") ? "noRoleName" : str;
    } 
    return "noRoleName";
  }
  
  public static String d(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String str = paramString;
      return paramString.equalsIgnoreCase("null") ? "1" : str;
    } 
    return "1";
  }
  
  public static String e(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String str = paramString;
      return paramString.equalsIgnoreCase("null") ? "0" : str;
    } 
    return "0";
  }
  
  public static String f(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String str = paramString;
      return paramString.equalsIgnoreCase("null") ? "0" : str;
    } 
    return "0";
  }
  
  public static String g(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String str = paramString;
      return paramString.equalsIgnoreCase("null") ? "0" : str;
    } 
    return "0";
  }
  
  public static String h(String paramString) {
    if (!TextUtils.isEmpty(k.a().j()) && k.a().d() != 0)
      paramString = k.a().j(); 
    return paramString;
  }
  
  public static String i(String paramString) {
    if (!TextUtils.isEmpty(k.a().i()) && k.a().d() != 0)
      paramString = k.a().i(); 
    return paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */