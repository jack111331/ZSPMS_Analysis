package com.sina.weibo.sdk.call;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;
import java.util.Iterator;

class CommonUtils {
  public static String buildUriQuery(HashMap<String, String> paramHashMap) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = paramHashMap.keySet().iterator();
    while (true) {
      if (!iterator.hasNext())
        return stringBuilder.toString().replaceFirst("&", "?"); 
      String str1 = iterator.next();
      String str2 = paramHashMap.get(str1);
      if (str2 != null) {
        stringBuilder.append("&");
        stringBuilder.append(str1);
        stringBuilder.append("=");
        stringBuilder.append(str2);
      } 
    } 
  }
  
  public static void openWeiboActivity(Context paramContext, String paramString1, String paramString2) throws WeiboNotInstalledException {
    try {
      Intent intent = new Intent();
      this();
      intent.setAction(paramString1);
      intent.setData(Uri.parse(paramString2));
      paramContext.startActivity(intent);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      throw new WeiboNotInstalledException("无法找到微博官方客户端");
    } 
  }
  
  public static void openWeiboActivity(Context paramContext, String paramString1, String paramString2, String paramString3) throws WeiboNotInstalledException {
    if (paramString3 != null) {
      try {
        Intent intent = new Intent();
        this();
        intent.setAction(paramString1);
        intent.setData(Uri.parse(paramString2));
        intent.setPackage(paramString3);
        paramContext.startActivity(intent);
      } catch (ActivityNotFoundException activityNotFoundException1) {
        if (paramString3 != null)
          try {
            Intent intent = new Intent();
            this();
            intent.setAction(paramString1);
            intent.setData(Uri.parse(paramString2));
            paramContext.startActivity(intent);
            return;
          } catch (ActivityNotFoundException activityNotFoundException) {
            throw new WeiboNotInstalledException("无法找到微博官方客户端");
          }  
      } 
    } else {
      Intent intent = new Intent();
      this();
      intent.setAction(paramString1);
      intent.setData(Uri.parse(paramString2));
      activityNotFoundException.startActivity(intent);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\call\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */