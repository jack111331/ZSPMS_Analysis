package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class AppOpsManagerCompat23 {
  public static int noteOp(Context paramContext, String paramString1, int paramInt, String paramString2) {
    return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteOp(paramString1, paramInt, paramString2);
  }
  
  public static int noteProxyOp(Context paramContext, String paramString1, String paramString2) {
    return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOp(paramString1, paramString2);
  }
  
  public static String permissionToOp(String paramString) {
    return AppOpsManager.permissionToOp(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\AppOpsManagerCompat23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */