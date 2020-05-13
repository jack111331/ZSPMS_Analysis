package org.jar.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.Uri;

@TargetApi(22)
class ActivityCompat22 {
  public static Uri getReferrer(Activity paramActivity) {
    return paramActivity.getReferrer();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\app\ActivityCompat22.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */