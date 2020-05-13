package com.zz.sdk;

import com.chuanglan.shanyan_sdk.OneKeyLoginManager;
import com.chuanglan.shanyan_sdk.listener.InitListener;
import com.zz.sdk.i.bp;

final class o implements InitListener {
  public void getInitStatus(int paramInt, String paramString) {
    bp.a("getInitStatus code:" + paramInt + ",result:" + paramString);
    OneKeyLoginManager.getInstance().getPhoneInfo(new p(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */