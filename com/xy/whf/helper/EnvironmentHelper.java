package com.xy.whf.helper;

public class EnvironmentHelper {
  private static boolean a = false;
  
  public static String getBaseUrl() {
    return a ? "http://test3.wanhoufu.com/whf" : "https://pay.wanhoufu.com";
  }
  
  public static void setTest(boolean paramBoolean) {
    a = paramBoolean;
    h.a(paramBoolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\EnvironmentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */