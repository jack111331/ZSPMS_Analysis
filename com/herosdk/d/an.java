package com.herosdk.d;

import android.content.Context;

public class an {
  public static boolean a(Context paramContext, String paramString) {
    try {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0)
        return true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */