package com.hu.zxlib.common;

import android.app.Activity;
import android.util.Log;

public class ScanUtils {
  public static void launchBarcodeScanner(Activity paramActivity, String paramString) {
    if (paramActivity == null) {
      Log.e("plugin", "launchBarcodeScanner but activity is null error");
      return;
    } 
    paramActivity.runOnUiThread(new c(paramActivity, paramString));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\common\ScanUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */