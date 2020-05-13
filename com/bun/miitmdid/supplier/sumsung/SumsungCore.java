package com.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.samsung.android.deviceidservice.IDeviceIdService;

@Keep
public class SumsungCore {
  @Keep
  private static boolean DBG = false;
  
  @Keep
  private static String SAMSUNGTAG = "Samsung_DeviceIdService";
  
  @Keep
  private static String TAG = "SumsungCore library";
  
  @Keep
  private com.bun.miitmdid.c.e.a mCallerCallBack = null;
  
  @Keep
  private ServiceConnection mConnection;
  
  @Keep
  private Context mContext = null;
  
  @Keep
  private IDeviceIdService mDeviceidInterface;
  
  @Keep
  public SumsungCore(Context paramContext, com.bun.miitmdid.c.e.a parama) {
    if (paramContext != null) {
      this.mContext = paramContext;
      this.mCallerCallBack = parama;
      this.mConnection = new a(this);
      Intent intent = new Intent();
      intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
      if (this.mContext.bindService(intent, this.mConnection, 1)) {
        com.bun.lib.a.b(TAG, "bindService Successful!");
      } else {
        this.mContext.unbindService(this.mConnection);
        com.bun.lib.a.b(TAG, "bindService Failed!");
        com.bun.miitmdid.c.e.a a1 = this.mCallerCallBack;
        if (a1 != null)
          a1.b(); 
      } 
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  @Keep
  public native String getAAID();
  
  @Keep
  public native String getOAID();
  
  @Keep
  public native String getUDID();
  
  @Keep
  public native String getVAID();
  
  @Keep
  public native boolean isSupported();
  
  @Keep
  public native void shutdown();
  
  @Keep
  class a implements ServiceConnection {
    @Keep
    a(SumsungCore this$0) {}
    
    @Keep
    public synchronized native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
    
    @Keep
    public native void onServiceDisconnected(ComponentName param1ComponentName);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\supplier\sumsung\SumsungCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */