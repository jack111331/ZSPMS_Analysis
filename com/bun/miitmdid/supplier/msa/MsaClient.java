package com.bun.miitmdid.supplier.msa;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.bun.lib.c;

@Keep
public class MsaClient {
  @Keep
  private static String TAG = "MSA Client library";
  
  @Keep
  private static String TARGET_PACKAGE = "com.mdid.msa";
  
  @Keep
  private com.bun.miitmdid.c.e.a _BindService;
  
  @Keep
  private ServiceConnection mConnection;
  
  @Keep
  private Context mContext;
  
  @Keep
  private c mDeviceidInterface;
  
  @Keep
  public MsaClient(Context paramContext, com.bun.miitmdid.c.e.a parama) {
    if (paramContext != null) {
      this.mContext = paramContext;
      this._BindService = parama;
      this.mConnection = new a(this, parama);
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  @Keep
  public static native boolean CheckService(Context paramContext);
  
  @Keep
  public static native void StartMsaKlService(Context paramContext, String paramString);
  
  @Keep
  public native void BindService(String paramString);
  
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
    a(MsaClient this$0, com.bun.miitmdid.c.e.a param1a) {}
    
    @Keep
    public synchronized native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
    
    @Keep
    public native void onServiceDisconnected(ComponentName param1ComponentName);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\supplier\msa\MsaClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */