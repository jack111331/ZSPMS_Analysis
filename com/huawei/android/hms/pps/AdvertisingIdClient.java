package com.huawei.android.hms.pps;

import android.content.Context;
import android.support.annotation.Keep;

@Keep
public class AdvertisingIdClient {
  @Keep
  public static native Info getAdvertisingIdInfo(Context paramContext);
  
  @Keep
  private static native String getTag();
  
  @Keep
  public static final class Info {
    @Keep
    private final String advertisingId;
    
    @Keep
    private final boolean limitAdTrackingEnabled;
    
    @Keep
    Info(String param1String, boolean param1Boolean) {
      this.advertisingId = param1String;
      this.limitAdTrackingEnabled = param1Boolean;
    }
    
    @Keep
    public final native String getId();
    
    @Keep
    public final native boolean isLimitAdTrackingEnabled();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\huawei\android\hms\pps\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */