package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.content.Intent;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

public interface IWeiboShareAPI {
  int getWeiboAppSupportAPI();
  
  boolean handleWeiboRequest(Intent paramIntent, IWeiboHandler.Request paramRequest);
  
  boolean handleWeiboResponse(Intent paramIntent, IWeiboHandler.Response paramResponse);
  
  boolean isSupportWeiboPay();
  
  boolean isWeiboAppInstalled();
  
  boolean isWeiboAppSupportAPI();
  
  boolean launchWeibo(Activity paramActivity);
  
  boolean launchWeiboPay(Activity paramActivity, String paramString);
  
  boolean registerApp();
  
  boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest);
  
  boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest, AuthInfo paramAuthInfo, String paramString, WeiboAuthListener paramWeiboAuthListener);
  
  boolean sendResponse(BaseResponse paramBaseResponse);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\IWeiboShareAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */