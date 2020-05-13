package com.aliyun.sls.android.sdk.utils;

import android.os.Build;
import android.text.TextUtils;

public class VersionInfoUtils {
  private static String userAgent;
  
  public static String getDefaultUserAgent() {
    String str1 = System.getProperty("http.agent");
    String str2 = str1;
    if (!TextUtils.isEmpty(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(System.getProperty("os.name"));
      stringBuilder.append("/Android ");
      stringBuilder.append(Build.VERSION.RELEASE);
      stringBuilder.append("/");
      stringBuilder.append(Build.MODEL);
      stringBuilder.append("/");
      stringBuilder.append(Build.ID);
      stringBuilder.append(")");
      str2 = stringBuilder.toString();
    } 
    return str2.replaceAll("[^\\p{ASCII}]", "?");
  }
  
  public static String getUserAgent() {
    if (userAgent == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("aliyun-log-sdk-android/");
      stringBuilder.append(getVersion());
      stringBuilder.append("/");
      stringBuilder.append(getDefaultUserAgent());
      userAgent = stringBuilder.toString();
    } 
    return userAgent;
  }
  
  public static String getVersion() {
    return "0.4.0";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sd\\utils\VersionInfoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */