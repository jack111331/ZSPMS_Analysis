package org.jar.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

@TargetApi(16)
class ActivityCompatJB {
  public static void finishAffinity(Activity paramActivity) {
    paramActivity.finishAffinity();
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, Bundle paramBundle) {
    paramContext.startActivity(paramIntent, paramBundle);
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle) {
    paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\app\ActivityCompatJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */