package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.open.a.f;

public class a {
  protected static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  
  public static String a(Context paramContext) {
    int i = d(paramContext);
    if (i == 2)
      return "wifi"; 
    if (i == 1)
      return "cmwap"; 
    if (i == 4)
      return "cmnet"; 
    if (i == 16)
      return "uniwap"; 
    if (i == 8)
      return "uninet"; 
    if (i == 64)
      return "wap"; 
    if (i == 32)
      return "net"; 
    if (i == 512)
      return "ctwap"; 
    if (i == 256)
      return "ctnet"; 
    if (i == 2048)
      return "3gnet"; 
    if (i == 1024)
      return "3gwap"; 
    String str = b(paramContext);
    if (str != null) {
      String str1 = str;
      return (str.length() == 0) ? "none" : str1;
    } 
    return "none";
  }
  
  public static String b(Context paramContext) {
    try {
      Cursor cursor = paramContext.getContentResolver().query(a, null, null, null, null);
      if (cursor == null)
        return null; 
      cursor.moveToFirst();
      if (cursor.isAfterLast()) {
        if (cursor != null)
          cursor.close(); 
        return null;
      } 
      String str2 = cursor.getString(cursor.getColumnIndex("apn"));
      String str1 = str2;
      if (cursor != null) {
        cursor.close();
        str1 = str2;
      } 
      return str1;
    } catch (SecurityException securityException) {
      f.e("openSDK_LOG.APNUtil", "getApn has exception: " + securityException.getMessage());
    } catch (Exception exception) {
      f.e("openSDK_LOG.APNUtil", "getApn has exception: " + exception.getMessage());
    } 
    return "";
  }
  
  public static String c(Context paramContext) {
    String str;
    try {
      Cursor cursor = paramContext.getContentResolver().query(a, null, null, null, null);
      if (cursor == null)
        return null; 
      cursor.moveToFirst();
      if (cursor.isAfterLast()) {
        if (cursor != null)
          cursor.close(); 
        return null;
      } 
      String str1 = cursor.getString(cursor.getColumnIndex("proxy"));
      str = str1;
      if (cursor != null) {
        cursor.close();
        str = str1;
      } 
    } catch (SecurityException securityException) {
      f.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + securityException.getMessage());
      str = "";
    } 
    return str;
  }
  
  public static int d(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return 128; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo == null)
        return 128; 
      if (networkInfo.getTypeName().toUpperCase().equals("WIFI"))
        return 2; 
      String str = networkInfo.getExtraInfo().toLowerCase();
      if (str.startsWith("cmwap"))
        return 1; 
      if (str.startsWith("cmnet") || str.startsWith("epc.tmobile.com"))
        return 4; 
      if (str.startsWith("uniwap"))
        return 16; 
      if (str.startsWith("uninet"))
        return 8; 
      if (str.startsWith("wap"))
        return 64; 
      if (str.startsWith("net"))
        return 32; 
      if (str.startsWith("ctwap"))
        return 512; 
      if (str.startsWith("ctnet"))
        return 256; 
      if (str.startsWith("3gwap"))
        return 1024; 
      if (str.startsWith("3gnet"))
        return 2048; 
      if (str.startsWith("#777")) {
        String str1 = c(paramContext);
        if (str1 != null) {
          int i = str1.length();
          if (i > 0)
            return 512; 
        } 
        return 256;
      } 
    } catch (Exception exception) {
      f.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + exception.getMessage());
    } 
    return 128;
  }
  
  public static String e(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (connectivityManager == null)
      return "MOBILE"; 
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    return (networkInfo != null) ? networkInfo.getTypeName() : "MOBILE";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */