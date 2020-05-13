package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.Uri;
import android.support.annotation.RequiresApi;

@TargetApi(22)
@RequiresApi(22)
class ActivityCompatApi22 {
  public static Uri getReferrer(Activity paramActivity) {
    return paramActivity.getReferrer();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\ActivityCompatApi22.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */