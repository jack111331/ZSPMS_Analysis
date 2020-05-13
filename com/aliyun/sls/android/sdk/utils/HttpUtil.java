package com.aliyun.sls.android.sdk.utils;

import java.net.URLEncoder;

public class HttpUtil {
  public static String urlEncode(String paramString1, String paramString2) {
    if (paramString1 == null)
      return ""; 
    try {
      return URLEncoder.encode(paramString1, paramString2).replace("+", "%20").replace("*", "%2A").replace("%7E", "~").replace("%2F", "/");
    } catch (Exception exception) {
      throw new IllegalArgumentException("failed to encode url!", exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sd\\utils\HttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */