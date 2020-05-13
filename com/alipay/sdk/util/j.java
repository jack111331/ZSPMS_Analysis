package com.alipay.sdk.util;

import com.alipay.sdk.app.statistic.a;
import java.util.HashMap;
import java.util.Map;

public final class j {
  public static final String a = "resultStatus";
  
  public static final String b = "memo";
  
  public static final String c = "result";
  
  private static String a(String paramString1, String paramString2) {
    paramString2 = paramString2 + "={";
    int i = paramString1.indexOf(paramString2);
    return paramString1.substring(paramString2.length() + i, paramString1.lastIndexOf("}"));
  }
  
  private static Map<String, String> a() {
    com.alipay.sdk.app.j j1 = com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c.h);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("resultStatus", Integer.toString(j1.h));
    hashMap.put("memo", j1.i);
    hashMap.put("result", "");
    return (Map)hashMap;
  }
  
  public static Map<String, String> a(String paramString) {
    HashMap<Object, Object> hashMap1;
    com.alipay.sdk.app.j j1 = com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c.h);
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    hashMap2.put("resultStatus", Integer.toString(j1.h));
    hashMap2.put("memo", j1.i);
    hashMap2.put("result", "");
    try {
      Map<String, String> map = b(paramString);
    } catch (Throwable throwable) {
      a.a("biz", "FormatResultEx", throwable);
      hashMap1 = hashMap2;
    } 
    return (Map)hashMap1;
  }
  
  private static Map<String, String> b(String paramString) {
    String[] arrayOfString = paramString.split(";");
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = arrayOfString.length;
    for (byte b = 0; b < i; b++) {
      paramString = arrayOfString[b];
      String str1 = paramString.substring(0, paramString.indexOf("={"));
      String str2 = str1 + "={";
      int k = paramString.indexOf(str2);
      hashMap.put(str1, paramString.substring(str2.length() + k, paramString.lastIndexOf("}")));
    } 
    return (Map)hashMap;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */