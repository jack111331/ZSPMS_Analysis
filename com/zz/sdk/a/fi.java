package com.zz.sdk.a;

import com.chuanglan.shanyan_sdk.OneKeyLoginManager;
import com.zz.sdk.i.h;

class fi implements Runnable {
  fi(fe paramfe) {}
  
  public void run() {
    OneKeyLoginManager.getInstance().setAuthThemeConfig(h.a(this.a.b.getApplicationContext()));
    OneKeyLoginManager.getInstance().openLoginAuth(true, new fj(this), new fk(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */