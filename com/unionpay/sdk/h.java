package com.unionpay.sdk;

import android.content.Context;

public class h {
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong) {
    try {
      paramContext.getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).commit();
    } catch (Throwable throwable) {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    try {
      paramContext.getSharedPreferences(paramString1, 0).edit().putString(paramString2, paramString3).commit();
    } catch (Throwable throwable) {}
  }
  
  public static long b(Context paramContext, String paramString1, String paramString2, long paramLong) {
    try {
      long l = paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, paramLong);
      paramLong = l;
    } catch (Throwable throwable) {}
    return paramLong;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    String str;
    try {
      str = paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
    } catch (Throwable throwable) {
      str = paramString3;
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */