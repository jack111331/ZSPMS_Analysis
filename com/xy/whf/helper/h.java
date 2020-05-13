package com.xy.whf.helper;

import android.util.Log;

public class h {
  private static boolean a = true;
  
  public static void a(String paramString) {
    if (a)
      Log.i("com.xy.whf", paramString); 
  }
  
  public static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static void b(String paramString) {
    if (a)
      Log.e("com.xy.whf", paramString); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */