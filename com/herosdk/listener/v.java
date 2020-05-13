package com.herosdk.listener;

import android.util.Log;
import com.herosdk.d.ap;
import com.herosdk.d.bb;
import com.herosdk.d.j;
import com.herosdk.d.x;

public class v implements ILogoutListener {
  private static String a = "frameLib.LOL";
  
  private ILogoutListener b = null;
  
  public v(ILogoutListener paramILogoutListener) {
    this.b = paramILogoutListener;
  }
  
  public void onFailed(String paramString) {
    Log.d(a, "onFailed msg:" + paramString);
    bb.a(new x(this, paramString));
  }
  
  public void onSuccess() {
    Log.d(a, "onSuccess");
    x.a().a(null);
    x.a().T();
    ap.a().b();
    j.a();
    bb.a(new w(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */