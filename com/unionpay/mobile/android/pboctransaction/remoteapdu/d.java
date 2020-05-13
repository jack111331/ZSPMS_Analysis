package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.os.RemoteException;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.tsm.connect.IInitCallback;

final class d extends IInitCallback.Stub {
  d(a parama) {}
  
  public final void initFailed() throws RemoteException {
    k.a("plugin-tsm", "mInitCallback.initFailed()");
    if (a.a(this.a) != null)
      a.a(this.a).removeMessages(3000); 
    if (this.a.a != null)
      this.a.a.b(); 
  }
  
  public final void initSucceed() throws RemoteException {
    k.a("plugin-tsm", "mInitCallback.initSucceed()");
    if (a.a(this.a) != null)
      a.a(this.a).removeMessages(3000); 
    if (this.a.a != null)
      this.a.a.a(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\remoteapdu\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */