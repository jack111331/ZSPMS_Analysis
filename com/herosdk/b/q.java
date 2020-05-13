package com.herosdk.b;

import android.util.Log;
import com.herosdk.bean.UserInfo;
import com.herosdk.listener.ICommonListener;

class q implements ICommonListener {
  q(p paramp, UserInfo paramUserInfo) {}
  
  public void onFailed(int paramInt, String paramString) {}
  
  public void onSuccess(int paramInt, String paramString) {
    Log.d(a.b(), "l id status success");
    this.b.a.onSuccess(this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */