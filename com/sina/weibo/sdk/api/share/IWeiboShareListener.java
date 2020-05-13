package com.sina.weibo.sdk.api.share;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;

public interface IWeiboShareListener {
  void onAuthorizeCancel();
  
  void onAuthorizeComplete(Oauth2AccessToken paramOauth2AccessToken);
  
  void onAuthorizeException(WeiboException paramWeiboException);
  
  void onTokenError(String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\IWeiboShareListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */