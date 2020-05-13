package com.zui.opendeviceidlibrary;

import android.support.annotation.Keep;
import com.zui.deviceidservice.IDeviceidInterface;

@Keep
public class OpenDeviceId {
  @Keep
  private static String c = "OpenDeviceId library";
  
  @Keep
  private static boolean d;
  
  @Keep
  private IDeviceidInterface a;
  
  @Keep
  private CallBack b;
  
  @Keep
  private native void a(String paramString);
  
  @Keep
  public static interface CallBack {
    @Keep
    void a(OpenDeviceId param1OpenDeviceId);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zui\opendeviceidlibrary\OpenDeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */