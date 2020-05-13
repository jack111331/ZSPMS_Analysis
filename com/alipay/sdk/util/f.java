package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay;

final class f implements ServiceConnection {
  f(e parame) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    synchronized (e.a(this.a)) {
      e.a(this.a, IAlixPay.Stub.asInterface(paramIBinder));
      e.a(this.a).notify();
      return;
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    e.a(this.a, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */