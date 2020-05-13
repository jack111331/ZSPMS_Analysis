package com.herosdk.listener;

import android.util.Log;
import com.herosdk.bean.UserInfo;
import com.herosdk.d.bb;

public class ai implements ISwitchAccountListener {
  private static String a = "frameLib.SL";
  
  private static final int c = 1005;
  
  private ISwitchAccountListener b = null;
  
  public ai(ISwitchAccountListener paramISwitchAccountListener) {
    this.b = paramISwitchAccountListener;
  }
  
  public void onCancel() {
    Log.d(a, "onCancel");
    bb.a(new al(this));
  }
  
  public void onFailed(String paramString) {
    Log.d(a, "onFailed msg:" + paramString);
    bb.a(new ak(this, paramString));
  }
  
  public void onSuccess(UserInfo paramUserInfo) {
    Log.d(a, "onSuccess");
    bb.a(new aj(this, paramUserInfo));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */