package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import java.io.File;

@TargetApi(11)
@RequiresApi(11)
class ContextCompatHoneycomb {
  public static File getObbDir(Context paramContext) {
    return paramContext.getObbDir();
  }
  
  static void startActivities(Context paramContext, Intent[] paramArrayOfIntent) {
    paramContext.startActivities(paramArrayOfIntent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\ContextCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */