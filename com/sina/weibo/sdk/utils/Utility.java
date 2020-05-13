package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.UUID;

public class Utility {
  private static final String DEFAULT_CHARSET = "UTF-8";
  
  public static Bundle decodeUrl(String paramString) {
    Bundle bundle = new Bundle();
    if (paramString != null) {
      String[] arrayOfString = paramString.split("&");
      int i = arrayOfString.length;
      for (byte b = 0; b < i; b++) {
        String[] arrayOfString1 = arrayOfString[b].split("=");
        try {
          bundle.putString(URLDecoder.decode(arrayOfString1[0], "UTF-8"), URLDecoder.decode(arrayOfString1[1], "UTF-8"));
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        } 
      } 
    } 
    return bundle;
  }
  
  public static String generateGUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public static String generateUA(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append("-");
    stringBuilder.append(Build.MODEL);
    stringBuilder.append("_");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append("_");
    stringBuilder.append("weibosdk");
    stringBuilder.append("_");
    stringBuilder.append("0031105000");
    stringBuilder.append("_android");
    return stringBuilder.toString();
  }
  
  public static String getAid(Context paramContext, String paramString) {
    AidTask.AidInfo aidInfo = AidTask.getInstance(paramContext).getAidSync(paramString);
    return (aidInfo != null) ? aidInfo.getAid() : "";
  }
  
  public static String getSign(Context paramContext, String paramString) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      for (byte b = 0;; b++) {
        if (b >= packageInfo.signatures.length)
          return null; 
        byte[] arrayOfByte = packageInfo.signatures[b].toByteArray();
        if (arrayOfByte != null)
          return MD5.hexdigest(arrayOfByte); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static boolean isChineseLocale(Context paramContext) {
    try {
      Locale locale = (paramContext.getResources().getConfiguration()).locale;
      if (!Locale.CHINA.equals(locale) && !Locale.CHINESE.equals(locale) && !Locale.SIMPLIFIED_CHINESE.equals(locale)) {
        boolean bool = Locale.TAIWAN.equals(locale);
        if (!bool)
          return false; 
      } 
      return true;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public static Bundle parseUri(String paramString) {
    try {
      URI uRI = new URI();
      this(paramString);
      return decodeUrl(uRI.getQuery());
    } catch (Exception exception) {
      return new Bundle();
    } 
  }
  
  public static Bundle parseUrl(String paramString) {
    try {
      URL uRL = new URL();
      this(paramString);
      Bundle bundle = decodeUrl(uRL.getQuery());
      bundle.putAll(decodeUrl(uRL.getRef()));
      return bundle;
    } catch (MalformedURLException malformedURLException) {
      return new Bundle();
    } 
  }
  
  public static String safeString(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = ""; 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */