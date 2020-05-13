package com.cmic.sso.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;

public class m {
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt) {
    ActivityCompat.requestPermissions(paramActivity, paramArrayOfString, paramInt);
  }
  
  public static boolean a(Context paramContext, String paramString) {
    return (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */