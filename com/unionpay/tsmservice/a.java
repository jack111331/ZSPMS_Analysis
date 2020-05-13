package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;

public final class a extends ITsmActivityCallback.Stub {
  private Context a;
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  public final void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException {
    ComponentName componentName = new ComponentName(paramString1, paramString2);
    Intent intent = new Intent();
    intent.putExtras(paramBundle);
    if (paramInt != -1)
      intent.setFlags(paramInt); 
    intent.setComponent(componentName);
    this.a.startActivity(intent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */