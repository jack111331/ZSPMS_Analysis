package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Service;
import android.support.annotation.RequiresApi;

@TargetApi(24)
@RequiresApi(24)
class ServiceCompatApi24 {
  public static void stopForeground(Service paramService, int paramInt) {
    paramService.stopForeground(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\ServiceCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */