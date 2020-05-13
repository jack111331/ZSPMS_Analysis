package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

public class ProvideMultiMessageForWeiboResponse extends BaseResponse {
  public WeiboMultiMessage multiMessage;
  
  public ProvideMultiMessageForWeiboResponse() {}
  
  public ProvideMultiMessageForWeiboResponse(Bundle paramBundle) {
    fromBundle(paramBundle);
  }
  
  final boolean check(Context paramContext, VersionCheckHandler paramVersionCheckHandler) {
    return (this.multiMessage == null) ? false : ((paramVersionCheckHandler != null && !paramVersionCheckHandler.checkResponse(paramContext, this.reqPackageName, this.multiMessage)) ? false : this.multiMessage.checkArgs());
  }
  
  public void fromBundle(Bundle paramBundle) {
    super.fromBundle(paramBundle);
    this.multiMessage = new WeiboMultiMessage(paramBundle);
  }
  
  public int getType() {
    return 2;
  }
  
  public void toBundle(Bundle paramBundle) {
    super.toBundle(paramBundle);
    paramBundle.putAll(this.multiMessage.toBundle(paramBundle));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\ProvideMultiMessageForWeiboResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */