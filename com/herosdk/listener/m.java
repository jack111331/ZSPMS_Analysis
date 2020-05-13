package com.herosdk.listener;

import android.util.Log;
import com.herosdk.d.bb;

public class m implements IInitListener {
  private static String a = "frameLib.IL";
  
  private IInitListener b = null;
  
  public m(IInitListener paramIInitListener) {
    this.b = paramIInitListener;
  }
  
  public void onFailed(String paramString) {
    Log.d(a, "onFailed");
    bb.a(new o(this, paramString));
  }
  
  public void onSuccess() {
    Log.d(a, "onSuccess");
    bb.a(new n(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */