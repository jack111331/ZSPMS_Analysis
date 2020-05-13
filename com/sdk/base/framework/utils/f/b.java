package com.sdk.base.framework.utils.f;

import android.util.Log;

public class b {
  public static int a(String paramString1, String paramString2, Boolean paramBoolean) {
    String str = paramString2;
    if (paramString2 == null)
      str = ""; 
    return paramBoolean.booleanValue() ? Log.i(paramString1, str) : -1;
  }
  
  public static int b(String paramString1, String paramString2, Boolean paramBoolean) {
    String str = paramString2;
    if (paramString2 == null)
      str = ""; 
    return paramBoolean.booleanValue() ? Log.d(paramString1, str) : -1;
  }
  
  public static int c(String paramString1, String paramString2, Boolean paramBoolean) {
    String str = paramString2;
    if (paramString2 == null)
      str = ""; 
    return paramBoolean.booleanValue() ? Log.e(paramString1, str) : -1;
  }
  
  public static int d(String paramString1, String paramString2, Boolean paramBoolean) {
    String str = paramString2;
    if (paramString2 == null)
      str = ""; 
    return paramBoolean.booleanValue() ? Log.w(paramString1, str) : -1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */