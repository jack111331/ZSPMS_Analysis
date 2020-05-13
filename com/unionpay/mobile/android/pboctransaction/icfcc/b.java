package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.gov.pbc.tsm.client.mobile.android.bank.service.a;

final class b implements ServiceConnection {
  b(a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    try {
      a.a(this.a, a.a.a(paramIBinder));
      if (a.a(this.a) != null)
        a.a(this.a).a(); 
    } catch (Exception exception) {}
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    a.a(this.a, (a)null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\icfcc\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */