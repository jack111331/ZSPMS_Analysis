package com.tencent.mm.opensdk.openapi;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public interface IWXAPIEventHandler {
  void onReq(BaseReq paramBaseReq);
  
  void onResp(BaseResp paramBaseResp);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\openapi\IWXAPIEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */