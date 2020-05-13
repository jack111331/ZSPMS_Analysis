package com.tencent.mm.sdk.openapi;

import android.content.Intent;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public interface IWXAPI {
  void detach();
  
  int getWXAppSupportAPI();
  
  boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler);
  
  boolean isWXAppInstalled();
  
  boolean isWXAppSupportAPI();
  
  boolean openWXApp();
  
  boolean registerApp(String paramString);
  
  boolean sendReq(BaseReq paramBaseReq);
  
  boolean sendResp(BaseResp paramBaseResp);
  
  void unregisterApp();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\openapi\IWXAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */