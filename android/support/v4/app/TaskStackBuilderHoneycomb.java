package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;

@TargetApi(11)
@RequiresApi(11)
class TaskStackBuilderHoneycomb {
  public static PendingIntent getActivitiesPendingIntent(Context paramContext, int paramInt1, Intent[] paramArrayOfIntent, int paramInt2) {
    return PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\TaskStackBuilderHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */