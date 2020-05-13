package com.zz.sdk.i;

import android.content.Context;
import android.content.SharedPreferences;

public class cm {
  private static SharedPreferences a = null;
  
  public static long a(Context paramContext) {
    return paramContext.getSharedPreferences("zzsdk_last_upload_contacts_time_sp", 0).getLong("zzsdk_last_upload_contacts_time", 0L);
  }
  
  public static String a(Context paramContext, String paramString) {
    return s.b(paramContext, paramString);
  }
  
  public static void a(Context paramContext, long paramLong) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("zzsdk_last_upload_contacts_time_sp", 0).edit();
    editor.putLong("zzsdk_last_upload_contacts_time", paramLong);
    editor.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt) {
    e(paramContext).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean) {
    e(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("zzsdk_is_closed_real_name_dialog_sp", 0).edit();
    editor.putBoolean("zzsdk_is_closed_real_name_dialog", paramBoolean);
    editor.commit();
    f(paramContext);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    return s.a(paramContext, paramString1, paramString2);
  }
  
  public static int b(Context paramContext, String paramString, int paramInt) {
    return e(paramContext).getInt(paramString, paramInt);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2) {
    e(paramContext).edit().putString(paramString1, paramString2).commit();
  }
  
  public static void b(Context paramContext, boolean paramBoolean) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("zzsdk_account_agree_protocol_sp", 0).edit();
    editor.putBoolean(cq.a(paramContext).s() + "_zzsdk_account_agree_protocol", paramBoolean);
    editor.commit();
  }
  
  public static boolean b(Context paramContext) {
    return paramContext.getSharedPreferences("zzsdk_is_closed_real_name_dialog_sp", 0).getBoolean("zzsdk_is_closed_real_name_dialog", false);
  }
  
  public static boolean b(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences("zzsdk_upload_contacts_sp", 0).getBoolean(paramString + "_zzsdk_upload_contacts", false);
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean) {
    return e(paramContext).getBoolean(paramString, paramBoolean);
  }
  
  public static int c(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences("zzsdk_is_show_contact_to_friends_sp", 0).getInt(paramString + "_zzsdk_is_show_contact_to_friends", 1);
  }
  
  public static long c(Context paramContext) {
    return paramContext.getSharedPreferences("TouristFirstTimeSP", 0).getLong("tourist_first_time", 0L);
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2) {
    return e(paramContext).getString(paramString1, paramString2);
  }
  
  public static void c(Context paramContext, String paramString, int paramInt) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("zzsdk_is_show_contact_to_friends_sp", 0).edit();
    editor.putInt(paramString + "_zzsdk_is_show_contact_to_friends", paramInt);
    editor.commit();
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("zzsdk_upload_contacts_sp", 0).edit();
    editor.putBoolean(paramString + "_zzsdk_upload_contacts", paramBoolean);
    editor.commit();
  }
  
  public static boolean d(Context paramContext) {
    return paramContext.getSharedPreferences("zzsdk_account_agree_protocol_sp", 0).getBoolean(cq.a(paramContext).s() + "_zzsdk_account_agree_protocol", false);
  }
  
  private static SharedPreferences e(Context paramContext) {
    if (a == null)
      a = paramContext.getSharedPreferences("zz_sdk", 0); 
    return a;
  }
  
  private static void f(Context paramContext) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("TouristFirstTimeSP", 0).edit();
    editor.putLong("tourist_first_time", System.currentTimeMillis());
    editor.commit();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */