package com.sina.weibo.sdk.api.share;

public interface IWeiboHandler {
  public static interface Request {
    void onRequest(BaseRequest param1BaseRequest);
  }
  
  public static interface Response {
    void onResponse(BaseResponse param1BaseResponse);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\IWeiboHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */