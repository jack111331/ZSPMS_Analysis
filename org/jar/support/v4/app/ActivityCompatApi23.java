package org.jar.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;

@TargetApi(23)
class ActivityCompatApi23 {
  public static void requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt) {
    if (paramActivity instanceof RequestPermissionsRequestCodeValidator)
      ((RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt); 
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
  }
  
  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString) {
    return paramActivity.shouldShowRequestPermissionRationale(paramString);
  }
  
  public static interface RequestPermissionsRequestCodeValidator {
    void validateRequestPermissionsRequestCode(int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\app\ActivityCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */