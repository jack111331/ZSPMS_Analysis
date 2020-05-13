package com.herosdk.d;

import android.content.Context;
import android.widget.Toast;
import com.herosdk.HeroSdk;

class aj implements Runnable {
  aj(x paramx) {}
  
  public void run() {
    if (HeroSdk.getInstance().getLogoutListener() != null)
      HeroSdk.getInstance().getLogoutListener().onSuccess(); 
    Toast.makeText((Context)this.a.x(), "登录失效，请重新登录", 1).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */