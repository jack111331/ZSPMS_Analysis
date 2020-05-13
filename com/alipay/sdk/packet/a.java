package com.alipay.sdk.packet;

import android.text.TextUtils;

public final class a {
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    String[] arrayOfString = paramString.split("&");
    if (arrayOfString.length == 0)
      return ""; 
    int i = arrayOfString.length;
    byte b = 0;
    CharSequence charSequence1 = null;
    CharSequence charSequence2 = null;
    CharSequence charSequence3 = null;
    String str2 = null;
    while (b < i) {
      String str = arrayOfString[b];
      paramString = str2;
      if (TextUtils.isEmpty(str2))
        if (!str.contains("biz_type")) {
          paramString = null;
        } else {
          paramString = e(str);
        }  
      CharSequence charSequence4 = charSequence3;
      if (TextUtils.isEmpty(charSequence3))
        if (!str.contains("biz_no")) {
          charSequence4 = null;
        } else {
          charSequence4 = e(str);
        }  
      CharSequence charSequence5 = charSequence2;
      if (TextUtils.isEmpty(charSequence2))
        if (!str.contains("trade_no") || str.startsWith("out_trade_no")) {
          charSequence5 = null;
        } else {
          charSequence5 = e(str);
        }  
      charSequence2 = charSequence1;
      if (TextUtils.isEmpty(charSequence1))
        if (!str.contains("app_userid")) {
          charSequence2 = null;
        } else {
          charSequence2 = e(str);
        }  
      b++;
      charSequence1 = charSequence2;
      str2 = paramString;
      charSequence3 = charSequence4;
      charSequence2 = charSequence5;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(str2))
      stringBuilder.append("biz_type=" + str2 + ";"); 
    if (!TextUtils.isEmpty(charSequence3))
      stringBuilder.append("biz_no=" + charSequence3 + ";"); 
    if (!TextUtils.isEmpty(charSequence2))
      stringBuilder.append("trade_no=" + charSequence2 + ";"); 
    if (!TextUtils.isEmpty(charSequence1))
      stringBuilder.append("app_userid=" + charSequence1 + ";"); 
    String str3 = stringBuilder.toString();
    String str1 = str3;
    if (str3.endsWith(";"))
      str1 = str3.substring(0, str3.length() - 1); 
    return str1;
  }
  
  private static String b(String paramString) {
    return !paramString.contains("biz_type") ? null : e(paramString);
  }
  
  private static String c(String paramString) {
    return !paramString.contains("biz_no") ? null : e(paramString);
  }
  
  private static String d(String paramString) {
    return (!paramString.contains("trade_no") || paramString.startsWith("out_trade_no")) ? null : e(paramString);
  }
  
  private static String e(String paramString) {
    String[] arrayOfString = paramString.split("=");
    paramString = null;
    if (arrayOfString.length > 1) {
      String str = arrayOfString[1];
      paramString = str;
      if (str.contains("\""))
        paramString = str.replaceAll("\"", ""); 
    } 
    return paramString;
  }
  
  private static String f(String paramString) {
    return !paramString.contains("app_userid") ? null : e(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\packet\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */