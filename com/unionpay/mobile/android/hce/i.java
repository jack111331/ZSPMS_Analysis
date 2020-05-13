package com.unionpay.mobile.android.hce;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.unionpay.mobile.android.hce.service.a;
import com.unionpay.mobile.android.hce.service.b;
import com.unionpay.mobile.android.utils.k;

final class i implements ServiceConnection {
  i(f paramf, String paramString1, String paramString2) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    a a;
    ComponentName componentName = null;
    IBinder iBinder = null;
    f.d(this.c).removeMessages(2006, this.a);
    try {
      a = a.a.a(paramIBinder);
    } catch (Exception exception) {
      exception.printStackTrace();
      a = null;
    } 
    if (a != null) {
      String str1;
      String str2;
      paramIBinder = iBinder;
      paramComponentName = componentName;
      try {
        String str4 = f.f(this.c);
        paramIBinder = iBinder;
        paramComponentName = componentName;
        String str5 = f.g(this.c);
        paramIBinder = iBinder;
        paramComponentName = componentName;
        b b = new b();
        paramIBinder = iBinder;
        paramComponentName = componentName;
        this(2003, this.a, f.d(this.c));
        paramIBinder = iBinder;
        paramComponentName = componentName;
        String str3 = a.a(str4, str5, (b)b);
        str2 = str3;
        str1 = str3;
        Message message = f.d(this.c).obtainMessage(2006, this.a);
        str2 = str3;
        str1 = str3;
        f.d(this.c).sendMessageDelayed(message, f.e(this.c));
        str1 = str3;
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
        str1 = str2;
      } catch (Exception exception) {}
      if (str1 != null) {
        k.a("uppay-hce", "session Key: " + str1);
        k.a("uppay-hce", "3des key: " + this.b);
        String str = a.a(str1, this.b);
        k.a("uppay-hce", this.a + " sessionkey after: " + str);
        l l2 = (l)f.c(this.c).get(this.a);
        l l1 = l2;
        if (l2 == null)
          l1 = new l(this.a); 
        l1.a(str);
        l1.a(a);
        l1.d();
        f.c(this.c).put(this.a, l1);
        Message message = f.d(this.c).obtainMessage(2002, this.a);
        f.d(this.c).sendMessage(message);
      } 
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    f.d(this.c).removeMessages(2006, this.a);
    Message message = f.d(this.c).obtainMessage(2005, this.a);
    f.d(this.c).sendMessage(message);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */