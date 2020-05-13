package com.herosdk.listener;

import android.util.Log;
import com.herosdk.d.bb;

public class p implements IKickListener {
  private static String a = "frameLib.KL";
  
  private IKickListener b = null;
  
  public p(IKickListener paramIKickListener) {
    this.b = paramIKickListener;
  }
  
  public void onKick(int paramInt, String paramString) {
    Log.d(a, "onKick code:" + paramInt + ",msg:" + paramString);
    bb.a(new q(this, paramInt, paramString));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */