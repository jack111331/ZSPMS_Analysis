package com.herosdk.listener;

import com.herosdk.bean.UserInfo;
import com.herosdk.d.bb;

public class g implements IIdentifyLoginListener {
  private static String a = "frameLib.ILL";
  
  private IIdentifyLoginListener b = null;
  
  public g(IIdentifyLoginListener paramIIdentifyLoginListener) {
    this.b = paramIIdentifyLoginListener;
  }
  
  public void onResult(ILoginListener paramILoginListener, UserInfo paramUserInfo, String paramString1, int paramInt, String paramString2) {
    bb.a(new h(this, paramILoginListener, paramUserInfo, paramString1, paramInt, paramString2));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */