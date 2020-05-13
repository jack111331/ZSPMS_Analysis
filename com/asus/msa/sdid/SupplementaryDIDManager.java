package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

@Keep
public class SupplementaryDIDManager {
  @Keep
  public static boolean DEBUG = false;
  
  @Keep
  public static final String TAG = "SupplementaryDIDManager";
  
  @Keep
  public boolean isBinded = false;
  
  @Keep
  public Context mContext;
  
  @Keep
  public IDidAidlInterface mDidService;
  
  @Keep
  public IDIDBinderStatusListener mListener;
  
  @Keep
  public ServiceConnection mServiceConnection = new ServiceConnection(this) {
      @Keep
      public native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
      
      @Keep
      public native void onServiceDisconnected(ComponentName param1ComponentName);
    };
  
  @Keep
  public SupplementaryDIDManager(Context paramContext) {
    this.mContext = paramContext;
  }
  
  @Keep
  private native void notifyAllListeners(boolean paramBoolean);
  
  @Keep
  public native void deInit();
  
  @Keep
  public native void init(IDIDBinderStatusListener paramIDIDBinderStatusListener);
  
  @Keep
  public native void showLog(boolean paramBoolean);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\asus\msa\sdid\SupplementaryDIDManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */