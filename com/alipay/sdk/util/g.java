package com.alipay.sdk.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback;

final class g extends IRemoteServiceCallback.Stub {
  g(e parame) {}
  
  public final boolean isHideLoadingScreen() throws RemoteException {
    return false;
  }
  
  public final void payEnd(boolean paramBoolean, String paramString) throws RemoteException {}
  
  public final void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException {
    Intent intent = new Intent("android.intent.action.MAIN", null);
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    try {
      bundle.putInt("CallingPid", paramInt);
      intent.putExtras(bundle);
    } catch (Exception exception) {}
    intent.setClassName(paramString1, paramString2);
    if (e.b(this.a) != null)
      e.b(this.a).startActivity(intent); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */