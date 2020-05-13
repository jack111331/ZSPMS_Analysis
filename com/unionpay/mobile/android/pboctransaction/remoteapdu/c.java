package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.tsm.connect.IInitCallback;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;

final class c implements ServiceConnection {
  c(a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    k.a("plugin-tsm", "mConnection.onServiceConnected()");
    if (a.a(this.a) != null)
      a.a(this.a).removeMessages(3000); 
    try {
      a.b(this.a);
      a.a(this.a, IRemoteApdu.Stub.asInterface(paramIBinder));
      if (a.a(this.a) != null)
        a.a(this.a).sendMessageDelayed(Message.obtain(a.a(this.a), 3000), 8000L); 
      a.d(this.a).registerCallback((IInitCallback)a.c(this.a));
      a.d(this.a).init();
    } catch (Exception exception) {}
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    k.a("plugin-tsm", "mConnection.onServiceDisconnected()");
    if (a.a(this.a) != null)
      a.a(this.a).removeMessages(3000); 
    a.a(this.a, (IRemoteApdu)null);
    if (this.a.a != null)
      this.a.a.b(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\remoteapdu\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */