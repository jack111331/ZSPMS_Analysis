package com.herosdk.d;

import android.app.Activity;
import android.content.Context;
import com.herosdk.bean.UserInfo;
import com.herosdk.listener.ILoginListener;

class ac implements ILoginListener {
  ac(x paramx, ILoginListener paramILoginListener, Activity paramActivity) {}
  
  public void onCancel() {
    this.a.onCancel();
  }
  
  public void onFailed(String paramString) {
    bb.a(new ad(this, paramString));
  }
  
  public void onSuccess(UserInfo paramUserInfo) {
    this.a.onSuccess(paramUserInfo);
    if (this.c.s().booleanValue())
      bb.a((Context)this.b, this.c.t().b(), this.c.t().c()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */