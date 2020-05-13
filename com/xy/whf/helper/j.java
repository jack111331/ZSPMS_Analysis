package com.xy.whf.helper;

import android.content.Context;
import android.content.pm.PackageManager;

public class j {
  public static String a(Context paramContext, String paramString) {
    try {
      String str = String.valueOf((paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.get(paramString));
      boolean bool = LangHelper.isNullOrEmpty(str);
      if (!bool)
        return str; 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
    } 
    return "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */