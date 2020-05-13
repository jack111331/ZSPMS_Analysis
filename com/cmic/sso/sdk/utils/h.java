package com.cmic.sso.sdk.utils;

import android.util.Log;

public class h {
  public static boolean a;
  
  private static final h b = new h();
  
  static {
    a = false;
  }
  
  public static final void a(String paramString1, String paramString2) {
    if (a)
      Log.e(paramString1, "CMCC-SDK:" + paramString2); 
  }
  
  public static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static final void b(String paramString1, String paramString2) {
    if (a)
      Log.d(paramString1, "CMCC-SDK:" + paramString2); 
  }
  
  public static final void c(String paramString1, String paramString2) {
    if (a)
      Log.i(paramString1, "CMCC-SDK:" + paramString2); 
  }
  
  public static final void d(String paramString1, String paramString2) {
    if (a)
      Log.d("CMCC-SDK:", "[" + paramString1 + "] : " + paramString2); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */