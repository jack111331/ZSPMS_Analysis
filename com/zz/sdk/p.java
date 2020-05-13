package com.zz.sdk;

import com.chuanglan.shanyan_sdk.listener.GetPhoneInfoListener;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.v;

class p implements GetPhoneInfoListener {
  p(o paramo) {}
  
  public void getPhoneInfoStatus(int paramInt, String paramString) {
    bp.a("getPhoneInfoStatus code:" + paramInt + ",result:" + paramString);
    if (paramInt == 1022) {
      v.y = true;
      return;
    } 
    v.y = false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */