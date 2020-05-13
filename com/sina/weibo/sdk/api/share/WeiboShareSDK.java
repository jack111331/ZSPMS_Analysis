package com.sina.weibo.sdk.api.share;

import android.content.Context;

public class WeiboShareSDK {
  public static IWeiboShareAPI createWeiboAPI(Context paramContext, String paramString) {
    return createWeiboAPI(paramContext, paramString, false);
  }
  
  public static IWeiboShareAPI createWeiboAPI(Context paramContext, String paramString, boolean paramBoolean) {
    return new WeiboShareAPIImpl(paramContext, paramString, false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\WeiboShareSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */