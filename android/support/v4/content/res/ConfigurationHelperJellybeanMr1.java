package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@TargetApi(17)
@RequiresApi(17)
class ConfigurationHelperJellybeanMr1 {
  static int getDensityDpi(@NonNull Resources paramResources) {
    return (paramResources.getConfiguration()).densityDpi;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\res\ConfigurationHelperJellybeanMr1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */