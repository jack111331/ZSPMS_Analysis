package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(16)
@RequiresApi(16)
class ContextCompatJellybean {
  public static void startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle) {
    paramContext.startActivities(paramArrayOfIntent, paramBundle);
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, Bundle paramBundle) {
    paramContext.startActivity(paramIntent, paramBundle);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\ContextCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */