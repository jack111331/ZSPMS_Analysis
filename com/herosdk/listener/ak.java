package com.herosdk.listener;

import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.d.x;

class ak implements Runnable {
  ak(ai paramai, String paramString) {}
  
  public void run() {
    try {
      if (Integer.parseInt(this.a.substring(this.a.indexOf(":") + 1, this.a.indexOf(","))) != 1005) {
        Log.d(ai.a(), "onFailed if");
        if (ai.a(this.b) != null)
          ai.a(this.b).onFailed(this.a); 
        return;
      } 
      Log.d(ai.a(), "onFailed else");
      HeroSdk.getInstance().logout(x.a().x());
    } catch (Exception exception) {
      Log.d(ai.a(), "onFailed e");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */