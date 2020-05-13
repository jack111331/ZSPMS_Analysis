package com.zz.sdk.i;

import android.app.Activity;
import android.os.Handler;
import com.zz.sdk.IPayConfYDMM;

public class bv {
  static final int a = 2013;
  
  public static final int b = 2014;
  
  public static final int c = 2015;
  
  public static final int d = 2016;
  
  public static final int e = 2017;
  
  private static IPayConfYDMM f;
  
  private static String g;
  
  public static Object a(Activity paramActivity, Object paramObject) {
    return null;
  }
  
  public static Object a(Handler paramHandler) {
    return null;
  }
  
  public static String a(double paramDouble) {
    return (f == null) ? null : f.getPayCode(paramDouble);
  }
  
  public static void a(IPayConfYDMM paramIPayConfYDMM) {
    f = paramIPayConfYDMM;
  }
  
  public static void a(String paramString) {
    g = paramString;
  }
  
  public static boolean a() {
    return (f != null && f.isValid() && b(g));
  }
  
  public static boolean a(int paramInt) {
    return false;
  }
  
  public static boolean a(Activity paramActivity, Object paramObject1, String paramString1, String paramString2, Object paramObject2) {
    return false;
  }
  
  public static IPayConfYDMM b() {
    return f;
  }
  
  public static boolean b(int paramInt) {
    return false;
  }
  
  private static boolean b(String paramString) {
    return (paramString != null && (paramString.startsWith("46000") || paramString.startsWith("46002") || paramString.startsWith("46007")));
  }
  
  public static String c() {
    return (f == null) ? null : f.getAppID();
  }
  
  public static boolean c(int paramInt) {
    return false;
  }
  
  public static String d() {
    return (f == null) ? null : f.getAppKey();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */