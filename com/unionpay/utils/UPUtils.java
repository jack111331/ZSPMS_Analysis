package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.MessageDigest;

public class UPUtils {
  public static String a(Context paramContext, String paramString) {
    paramString = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(paramString, "");
    null = e.a(paramContext);
    paramString = b(paramString, (null + "23456789abcdef12123456786789abcd").substring(0, 32));
    return (paramString == null) ? "" : (!paramString.endsWith(null) ? "" : paramString.substring(0, paramString.length() - null.length()));
  }
  
  public static String a(String paramString) {
    try {
      byte[] arrayOfByte = paramString.getBytes();
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.reset();
      messageDigest.update(arrayOfByte);
      String str = a.a(messageDigest.digest());
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  private static String a(String paramString1, String paramString2) {
    String str;
    try {
      byte[] arrayOfByte = paramString1.getBytes("utf-8");
      str = a.a(d.a(a.a(paramString2), arrayOfByte));
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static void a(Context paramContext, long paramLong, String paramString) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
    editor.putLong(paramString, paramLong);
    editor.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    String str1 = e.a(paramContext);
    String str2 = (str1 + "23456789abcdef12123456786789abcd").substring(0, 32);
    str2 = a(paramString1 + str1, str2);
    paramString1 = str2;
    if (str2 == null)
      paramString1 = ""; 
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
    editor.putString(paramString2, paramString1);
    editor.commit();
  }
  
  private static String b(String paramString1, String paramString2) {
    String str;
    try {
      byte[] arrayOfByte = d.b(a.a(paramString2), a.a(paramString1));
      paramString2 = new String();
      this(arrayOfByte, "utf-8");
      str = paramString2.trim();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static void b(Context paramContext, String paramString) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).edit();
    editor.remove(paramString);
    editor.commit();
  }
  
  public static long c(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).getLong(paramString, 0L);
  }
  
  public static native String forConfig(int paramInt, String paramString);
  
  public static native String forUrl(int paramInt);
  
  public static native String forWap(int paramInt, String paramString);
  
  public static native String getIssuer(int paramInt);
  
  public static native String getSubject(int paramInt);
  
  public static native String getTalkingDataIdForAssist(int paramInt);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\UPUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */