package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.LogUtil;

public class VersionCheckHandler implements IVersionCheckHandler {
  private static final String TAG = "com.sina.weibo.sdk.api.share.VersionCheckHandler";
  
  public boolean checkRequest(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, WeiboMessage paramWeiboMessage) {
    if (paramWeiboInfo == null || !paramWeiboInfo.isLegal())
      return false; 
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder("WeiboMessage WeiboInfo package : ");
    stringBuilder.append(paramWeiboInfo.getPackageName());
    LogUtil.d(str, stringBuilder.toString());
    str = TAG;
    stringBuilder = new StringBuilder("WeiboMessage WeiboInfo supportApi : ");
    stringBuilder.append(paramWeiboInfo.getSupportApi());
    LogUtil.d(str, stringBuilder.toString());
    if (paramWeiboInfo.getSupportApi() < 10351 && paramWeiboMessage.mediaObject != null && paramWeiboMessage.mediaObject instanceof com.sina.weibo.sdk.api.VoiceObject)
      paramWeiboMessage.mediaObject = null; 
    if (paramWeiboInfo.getSupportApi() < 10352 && paramWeiboMessage.mediaObject != null && paramWeiboMessage.mediaObject instanceof com.sina.weibo.sdk.api.CmdObject)
      paramWeiboMessage.mediaObject = null; 
    return true;
  }
  
  public boolean checkRequest(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, WeiboMultiMessage paramWeiboMultiMessage) {
    if (paramWeiboInfo == null || !paramWeiboInfo.isLegal())
      return false; 
    String str2 = TAG;
    StringBuilder stringBuilder1 = new StringBuilder("WeiboMultiMessage WeiboInfo package : ");
    stringBuilder1.append(paramWeiboInfo.getPackageName());
    LogUtil.d(str2, stringBuilder1.toString());
    String str1 = TAG;
    StringBuilder stringBuilder2 = new StringBuilder("WeiboMultiMessage WeiboInfo supportApi : ");
    stringBuilder2.append(paramWeiboInfo.getSupportApi());
    LogUtil.d(str1, stringBuilder2.toString());
    if (paramWeiboInfo.getSupportApi() < 10351)
      return false; 
    if (paramWeiboInfo.getSupportApi() < 10352 && paramWeiboMultiMessage.mediaObject != null && paramWeiboMultiMessage.mediaObject instanceof com.sina.weibo.sdk.api.CmdObject)
      paramWeiboMultiMessage.mediaObject = null; 
    return true;
  }
  
  public boolean checkResponse(Context paramContext, String paramString, WeiboMessage paramWeiboMessage) {
    return TextUtils.isEmpty(paramString) ? false : checkRequest(paramContext, WeiboAppManager.getInstance(paramContext).parseWeiboInfoByAsset(paramString), paramWeiboMessage);
  }
  
  public boolean checkResponse(Context paramContext, String paramString, WeiboMultiMessage paramWeiboMultiMessage) {
    return TextUtils.isEmpty(paramString) ? false : checkRequest(paramContext, WeiboAppManager.getInstance(paramContext).parseWeiboInfoByAsset(paramString), paramWeiboMultiMessage);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\VersionCheckHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */