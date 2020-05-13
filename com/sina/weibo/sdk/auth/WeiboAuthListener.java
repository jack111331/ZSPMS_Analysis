package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import com.sina.weibo.sdk.exception.WeiboException;

public interface WeiboAuthListener {
  void onCancel();
  
  void onComplete(Bundle paramBundle);
  
  void onWeiboException(WeiboException paramWeiboException);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\auth\WeiboAuthListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */