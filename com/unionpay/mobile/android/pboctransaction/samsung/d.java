package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.mobile.android.utils.k;

final class d implements ServiceConnection {
  d(b paramb) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    k.a("plugin-clientV3", "startSamsungService onServiceConnected");
    try {
      b.a(this.a, ITsmConnection.Stub.asInterface(paramIBinder));
      b.a(this.a).removeMessages(1);
      b.a(this.a, true);
    } catch (Exception exception) {
      b.a(this.a, false);
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    k.a("plugin-clientV3", "startSamsungService onServiceDisconnected");
    b.a(this.a, (ITsmConnection)null);
    b.a(this.a).removeMessages(1);
    b.a(this.a, false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\samsung\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */