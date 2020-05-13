package com.zz.sdk.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class bx {
  public static final int a = 123;
  
  @SuppressLint({"InlinedApi"})
  public static final String b = "android.permission.READ_EXTERNAL_STORAGE";
  
  public static final String c = "android.permission.WRITE_EXTERNAL_STORAGE";
  
  public static final String d = "android.permission.CALL_PHONE";
  
  public static final String e = "android.permission.ACCESS_FINE_LOCATION";
  
  public static final String f = "android.permission.READ_PHONE_STATE";
  
  public static final String g = "android.permission.READ_CONTACTS";
  
  public static void a(Activity paramActivity) {
    a(paramActivity, "android.permission.READ_EXTERNAL_STORAGE");
  }
  
  private static void a(Activity paramActivity, String paramString) {
    ActivityCompat.requestPermissions(paramActivity, new String[] { paramString }, 123);
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString) {
    ActivityCompat.requestPermissions(paramActivity, paramArrayOfString, 123);
  }
  
  public static boolean a(Context paramContext) {
    return a(paramContext, "android.permission.READ_EXTERNAL_STORAGE");
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      int i = ContextCompat.checkSelfPermission(paramContext, paramString);
      if (i == 0)
        bool = true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return bool;
  }
  
  public static void b(Activity paramActivity) {
    a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
  }
  
  public static boolean b(Context paramContext) {
    return a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE");
  }
  
  public static void c(Activity paramActivity) {
    a(paramActivity, "android.permission.CALL_PHONE");
  }
  
  public static boolean c(Context paramContext) {
    return a(paramContext, "android.permission.CALL_PHONE");
  }
  
  public static void d(Activity paramActivity) {
    a(paramActivity, "android.permission.ACCESS_FINE_LOCATION");
  }
  
  public static boolean d(Context paramContext) {
    return a(paramContext, "android.permission.ACCESS_FINE_LOCATION");
  }
  
  public static void e(Activity paramActivity) {
    a(paramActivity, "android.permission.READ_PHONE_STATE");
  }
  
  public static boolean e(Context paramContext) {
    return a(paramContext, "android.permission.READ_PHONE_STATE");
  }
  
  public static void f(Activity paramActivity) {
    a(paramActivity, "android.permission.READ_CONTACTS");
  }
  
  public static boolean f(Context paramContext) {
    return a(paramContext, "android.permission.READ_CONTACTS");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */