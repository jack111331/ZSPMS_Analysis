package com.chuanglan.shanyan_sdk.utils;

import android.util.Log;
import com.chuanglan.shanyan_sdk.b;

public class L {
  private static boolean a = b.h;
  
  private static void a(String paramString1, String paramString2) {
    if (a)
      Log.w(paramString1, paramString2); 
  }
  
  private static void b(String paramString1, String paramString2) {
    if (a)
      Log.i(paramString1, paramString2); 
  }
  
  private static void c(String paramString1, String paramString2) {
    if (a)
      Log.v(paramString1, paramString2); 
  }
  
  public static void d(String paramString) {
    d("debug", paramString);
  }
  
  public static void d(String paramString1, String paramString2) {
    if (a)
      Log.d(paramString1, paramString2); 
  }
  
  public static void e(String paramString) {
    e("error", paramString);
  }
  
  public static void e(String paramString1, String paramString2) {
    if (a)
      Log.e(paramString1, paramString2); 
  }
  
  public static void i(String paramString) {
    b("info", paramString);
  }
  
  public static void v(String paramString) {
    c("verbose", paramString);
  }
  
  public static void w(String paramString) {
    a("warn", paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\L.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */