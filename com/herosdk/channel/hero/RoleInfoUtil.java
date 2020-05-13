package com.herosdk.channel.hero;

import android.text.TextUtils;
import android.util.Log;
import com.herosdk.bean.RoleInfo;

public class RoleInfoUtil {
  private static String a = Sdk.c + "riUtil";
  
  private static String b;
  
  private static String c;
  
  private static RoleInfo d = null;
  
  private static String e;
  
  private static String f;
  
  private static String g;
  
  static {
    b = "null";
    f = "10000";
    g = "noServer";
    c = "1";
    e = "noRoleName";
  }
  
  public static String getPartyName() {
    if (d == null) {
      Log.e(a, "getPartyName but not call setRoleInfo error");
      return "";
    } 
    String str = d.getPartyName();
    if (!TextUtils.isEmpty(str)) {
      String str1 = str;
      if (str.equalsIgnoreCase(b)) {
        Log.e(a, "getPartyName error, value = " + str);
        return "";
      } 
      return str1;
    } 
    Log.e(a, "getPartyName error, value = " + str);
    return "";
  }
  
  public static String getRoleBalance() {
    if (d == null) {
      Log.e(a, "getRoleBalance but not call setRoleInfo error");
      return "0";
    } 
    String str = String.valueOf(d.getRoleBalance());
    if (!TextUtils.isEmpty(str)) {
      String str1 = str;
      if (str.equalsIgnoreCase(b)) {
        Log.e(a, "getRoleBalance error, value = " + str);
        return "0";
      } 
      return str1;
    } 
    Log.e(a, "getRoleBalance error, value = " + str);
    return "0";
  }
  
  public static String getRoleId() {
    if (d == null) {
      Log.e(a, "getRoleId but not call setRoleInfo error");
      return "roleId";
    } 
    null = d.getRoleId();
    if (TextUtils.isEmpty(null) || null.equalsIgnoreCase(b)) {
      Log.e(a, "getRoleId error, value = " + null);
      return c;
    } 
    c = null;
    return c;
  }
  
  public static RoleInfo getRoleInfo() {
    return d;
  }
  
  public static String getRoleLevel() {
    if (d == null) {
      Log.e(a, "getRoleLevel but not call setRoleInfo error");
      return "0";
    } 
    String str = d.getRoleLevel();
    if (!TextUtils.isEmpty(str)) {
      String str1 = str;
      if (str.equalsIgnoreCase(b)) {
        Log.e(a, "getRoleLevel error, value = " + str);
        return "0";
      } 
      return str1;
    } 
    Log.e(a, "getRoleLevel error, value = " + str);
    return "0";
  }
  
  public static String getRoleName() {
    if (d == null) {
      Log.e(a, "getRoleName but not call setRoleInfo error");
      return e;
    } 
    null = d.getRoleName();
    if (TextUtils.isEmpty(null) || null.equalsIgnoreCase(b)) {
      Log.e(a, "getRoleName error, value = " + null);
      return e;
    } 
    e = null;
    return e;
  }
  
  public static String getServerId() {
    if (d == null) {
      Log.e(a, "getServerId but not call setRoleInfo error");
      return f;
    } 
    null = String.valueOf(d.getServerId());
    if (TextUtils.isEmpty(null) || null.equalsIgnoreCase(b)) {
      Log.e(a, "getServerId error, value = " + null);
      return f;
    } 
    f = null;
    return f;
  }
  
  public static String getServerName() {
    if (d == null) {
      Log.e(a, "getServerName but not call setRoleInfo error");
      return g;
    } 
    null = d.getServerName();
    if (TextUtils.isEmpty(null) || null.equalsIgnoreCase(b)) {
      Log.e(a, "getServerName error, value = " + null);
      return g;
    } 
    g = null;
    return g;
  }
  
  public static String getVipLevel() {
    if (d == null) {
      Log.e(a, "getVipLevel but not call setRoleInfo error");
      return "0";
    } 
    String str = d.getVipLevel();
    if (!TextUtils.isEmpty(str)) {
      String str1 = str;
      if (str.equalsIgnoreCase(b)) {
        Log.e(a, "getVipLevel error, value = " + str);
        return "0";
      } 
      return str1;
    } 
    Log.e(a, "getVipLevel error, value = " + str);
    return "0";
  }
  
  public static void setRoleInfo(RoleInfo paramRoleInfo) {
    Log.d(a, "setRoleInfo");
    d = paramRoleInfo;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\RoleInfoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */