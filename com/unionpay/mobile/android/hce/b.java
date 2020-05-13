package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.unionpay.mobile.android.hce.service.b;

public final class b extends b.a {
  private int a;
  
  private String b;
  
  private Handler c;
  
  public b(int paramInt, String paramString, Handler paramHandler) {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramHandler;
  }
  
  public final void a(String paramString) throws RemoteException {
    switch (this.a) {
      default:
        return;
      case 2003:
        bundle = new Bundle();
        bundle.putString("pkgName", this.b);
        bundle.putBoolean("success", false);
        bundle.putString("errCode", paramString);
        this.c.sendMessage(Message.obtain(this.c, 2003, bundle));
      case 2004:
        break;
    } 
    Bundle bundle = new Bundle();
    bundle.putBoolean("success", false);
    bundle.putString("errCode", paramString);
    this.c.sendMessage(Message.obtain(this.c, 2004, bundle));
  }
  
  public final void a(String paramString1, String paramString2) throws RemoteException {
    switch (this.a) {
      default:
        return;
      case 2003:
        bundle = new Bundle();
        bundle.putString("pkgName", this.b);
        bundle.putBoolean("success", true);
        bundle.putString("result", paramString1);
        bundle.putString("reserved", paramString2);
        this.c.sendMessage(Message.obtain(this.c, 2003, bundle));
      case 2004:
        break;
    } 
    Bundle bundle = new Bundle();
    bundle.putBoolean("success", true);
    bundle.putString("result", paramString1);
    bundle.putString("reserved", paramString2);
    this.c.sendMessage(Message.obtain(this.c, 2004, bundle));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */