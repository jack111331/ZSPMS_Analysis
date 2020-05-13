package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class r {
  public static void a(Context paramContext, String paramString) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("ssoconfigs", 0);
    paramString = j.a(paramString);
    sharedPreferences.edit().remove(paramString).apply();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("ssoconfigs", 0);
    paramString = j.a(paramString);
    sharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("ssoconfigs", 0);
    paramString = j.a(paramString);
    sharedPreferences.edit().putLong(paramString, paramLong).apply();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("ssoconfigs", 0);
    paramString1 = j.a(paramString1);
    sharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("ssoconfigs", 0);
    paramString = j.a(paramString);
    sharedPreferences.edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static int b(Context paramContext, String paramString, int paramInt) {
    return paramContext.getSharedPreferences("ssoconfigs", 0).getInt(j.a(paramString), paramInt);
  }
  
  public static long b(Context paramContext, String paramString, long paramLong) {
    return paramContext.getSharedPreferences("ssoconfigs", 0).getLong(j.a(paramString), paramLong);
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2) {
    return paramContext.getSharedPreferences("ssoconfigs", 0).getString(j.a(paramString1), paramString2);
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean) {
    return paramContext.getSharedPreferences("ssoconfigs", 0).getBoolean(j.a(paramString), paramBoolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */