package android.support.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication extends Application {
  protected void attachBaseContext(Context paramContext) {
    super.attachBaseContext(paramContext);
    MultiDex.install((Context)this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\multidex\MultiDexApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */