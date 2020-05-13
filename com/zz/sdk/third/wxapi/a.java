package com.zz.sdk.third.wxapi;

import android.app.Activity;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

final class a implements IWXAPIEventHandler {
  a(Activity paramActivity) {}
  
  public void onReq(BaseReq paramBaseReq) {
    this.a.finish();
  }
  
  public void onResp(BaseResp paramBaseResp) {
    ZZWXEntryActivity.onWxResp(this.a, paramBaseResp);
    this.a.finish();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\wxapi\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */