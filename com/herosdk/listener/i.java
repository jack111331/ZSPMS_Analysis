package com.herosdk.listener;

import com.herosdk.d.bb;

public class i implements IIdentifyOnlineListener {
  private static String a = "frameLib.IOL";
  
  private IIdentifyOnlineListener b = null;
  
  public i(IIdentifyOnlineListener paramIIdentifyOnlineListener) {
    this.b = paramIIdentifyOnlineListener;
  }
  
  public void onResult(int paramInt, String paramString) {
    bb.a(new j(this, paramInt, paramString));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */