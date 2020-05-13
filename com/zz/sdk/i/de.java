package com.zz.sdk.i;

import android.util.Log;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

final class de implements IWXAPIEventHandler {
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {
    Log.d("zz_sdk", "onPayFinish：errCode=" + String.valueOf(paramBaseResp.errCode) + ", errStr=" + paramBaseResp.errStr);
    if (paramBaseResp.getType() != 5 || (paramBaseResp.errCode != 0 && paramBaseResp.errCode == -2));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */