package com.alipay.security.mobile.module.b;

import android.content.Context;

public final class a {
  private static a a = new a();
  
  public static a a() {
    return a;
  }
  
  public static String a(Context paramContext) {
    String str;
    try {
      str = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16)).versionName;
    } catch (Exception exception) {
      str = "0.0.0";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */