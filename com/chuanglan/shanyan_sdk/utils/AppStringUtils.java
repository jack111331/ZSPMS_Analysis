package com.chuanglan.shanyan_sdk.utils;

public class AppStringUtils {
  private static String a(Object paramObject, String paramString) {
    if (paramObject != null)
      paramString = String.valueOf(paramObject); 
    return paramString;
  }
  
  public static boolean isEmpty(String paramString) {
    return (paramString == null || "".equals(paramString) || paramString.trim().length() == 0);
  }
  
  public static boolean isNotEmpty(String paramString) {
    return (paramString != null && !"null".equals(paramString) && !"".equals(paramString));
  }
  
  public static String toString(Object paramObject) {
    return a(paramObject, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\AppStringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */