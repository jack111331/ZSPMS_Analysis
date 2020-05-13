package com.huawei.android.hms.pps.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;
import java.util.concurrent.LinkedBlockingQueue;

@Keep
public final class a implements ServiceConnection {
  @Keep
  public boolean a = false;
  
  @Keep
  public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<IBinder>(1);
  
  @Keep
  public final native void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  @Keep
  public final native void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\huawei\android\hms\pps\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */