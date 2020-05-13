package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;

public final class h {
  public static final String a = "pref_trade_token";
  
  public static final String b = ";";
  
  public static final String c = "result={";
  
  public static final String d = "}";
  
  public static final String e = "trade_token=\"";
  
  public static final String f = "\"";
  
  public static final String g = "trade_token=";
  
  private static String a(Context paramContext) {
    return i.b(paramContext, "pref_trade_token", "");
  }
  
  private static String a(String paramString) {
    String str1 = null;
    String str2 = null;
    if (TextUtils.isEmpty(paramString))
      return str2; 
    String[] arrayOfString = paramString.split(";");
    byte b = 0;
    paramString = str1;
    label27: while (true) {
      str1 = paramString;
      if (b < arrayOfString.length) {
        str1 = paramString;
        if (arrayOfString[b].startsWith("result={")) {
          str1 = paramString;
          if (arrayOfString[b].endsWith("}")) {
            String[] arrayOfString1 = arrayOfString[b].substring(8, arrayOfString[b].length() - 1).split("&");
            byte b1 = 0;
            while (true) {
              str1 = paramString;
              if (b1 < arrayOfString1.length)
                if (arrayOfString1[b1].startsWith("trade_token=\"") && arrayOfString1[b1].endsWith("\"")) {
                  str1 = arrayOfString1[b1].substring(13, arrayOfString1[b1].length() - 1);
                } else if (arrayOfString1[b1].startsWith("trade_token=")) {
                  str1 = arrayOfString1[b1].substring(12);
                } else {
                  b1++;
                  continue;
                }  
              b++;
              paramString = str1;
              continue label27;
            } 
            break;
          } 
          continue;
        } 
        continue;
      } 
      return str1;
    } 
  }
  
  private static void a(Context paramContext, String paramString) {
    String[] arrayOfString1 = null;
    String[] arrayOfString2 = null;
    try {
      String str;
      if (TextUtils.isEmpty(paramString)) {
        arrayOfString1 = arrayOfString2;
      } else {
        arrayOfString2 = paramString.split(";");
        byte b = 0;
        String[] arrayOfString = arrayOfString1;
        label32: while (true) {
          arrayOfString1 = arrayOfString;
          if (b < arrayOfString2.length) {
            arrayOfString1 = arrayOfString;
            if (arrayOfString2[b].startsWith("result={")) {
              arrayOfString1 = arrayOfString;
              if (arrayOfString2[b].endsWith("}")) {
                String[] arrayOfString3 = arrayOfString2[b].substring(8, arrayOfString2[b].length() - 1).split("&");
                byte b1 = 0;
                while (true) {
                  arrayOfString1 = arrayOfString;
                  if (b1 < arrayOfString3.length)
                    if (arrayOfString3[b1].startsWith("trade_token=\"") && arrayOfString3[b1].endsWith("\"")) {
                      str = arrayOfString3[b1].substring(13, arrayOfString3[b1].length() - 1);
                    } else if (arrayOfString3[b1].startsWith("trade_token=")) {
                      str = arrayOfString3[b1].substring(12);
                    } else {
                      b1++;
                      continue;
                    }  
                  b++;
                  String str1 = str;
                  continue label32;
                } 
                break;
              } 
              continue;
            } 
            continue;
          } 
          if (!TextUtils.isEmpty(str))
            i.a(paramContext, "pref_trade_token", str); 
        } 
      } 
      if (!TextUtils.isEmpty(str))
        i.a(paramContext, "pref_trade_token", str); 
    } catch (Throwable throwable) {
      a.a("biz", "SaveTradeTokenError", throwable);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */