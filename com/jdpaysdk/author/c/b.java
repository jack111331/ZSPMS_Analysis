package com.jdpaysdk.author.c;

import android.util.Log;

public class b {
  public static boolean a = true;
  
  public static boolean b = true;
  
  public static String c = "JDPaySDK";
  
  public static String d = "TD_SIGNE";
  
  public static String e = "SDDTAG";
  
  public static String f = "JDPAY_EXCEPTION";
  
  private static String g = "[DEBUG]--->";
  
  private static String h = "TRACE";
  
  private static StackTraceElement a(int paramInt) {
    Thread.currentThread().getStackTrace();
    return Thread.currentThread().getStackTrace()[paramInt];
  }
  
  private static String a(String paramString) {
    String str = paramString;
    if (b)
      str = paramString + " [" + a(5) + "]"; 
    return str;
  }
  
  public static void a(String paramString, int paramInt) {
    if (paramString.length() > paramInt) {
      String str = paramString.substring(0, paramInt);
      Log.i("响应信息", str + "");
      if (paramString.length() - paramInt > paramInt) {
        a(paramString.substring(paramInt, paramString.length()), paramInt);
        return;
      } 
      paramString = paramString.substring(paramInt, paramString.length());
      Log.i("响应信息", paramString + "");
      return;
    } 
    Log.i("响应信息", paramString + "");
  }
  
  public static void a(String paramString1, String paramString2) {
    if (a)
      Log.e(paramString1, a(paramString2)); 
    a(a(paramString2), 3000);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */