package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

public class SendMessageToWeiboResponse extends BaseResponse {
  public SendMessageToWeiboResponse() {}
  
  public SendMessageToWeiboResponse(Bundle paramBundle) {
    fromBundle(paramBundle);
  }
  
  final boolean check(Context paramContext, VersionCheckHandler paramVersionCheckHandler) {
    return true;
  }
  
  public int getType() {
    return 1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\SendMessageToWeiboResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */