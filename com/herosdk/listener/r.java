package com.herosdk.listener;

import android.util.Log;
import com.herosdk.bean.UserInfo;
import com.herosdk.d.bb;

public class r implements ILoginListener {
  private static String a = "frameLib.LIL";
  
  private ILoginListener b = null;
  
  public r(ILoginListener paramILoginListener) {
    this.b = paramILoginListener;
  }
  
  public void onCancel() {
    Log.d(a, "onCancel");
    bb.a(new u(this));
  }
  
  public void onFailed(String paramString) {
    Log.d(a, "onFailed msg:" + paramString);
    bb.a(new t(this, paramString));
  }
  
  public void onSuccess(UserInfo paramUserInfo) {
    Log.d(a, "onSuccess");
    bb.a(new s(this, paramUserInfo));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */