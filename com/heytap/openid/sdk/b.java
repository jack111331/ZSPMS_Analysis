package com.heytap.openid.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;

@Keep
public class b implements ServiceConnection {
  @Keep
  public b(c paramc) {}
  
  @Keep
  public native void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  @Keep
  public native void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\heytap\openid\sdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */