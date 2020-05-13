package com.chuanglan.shanyan_sdk.b;

import java.util.HashMap;
import java.util.Map;

public class g {
  private static g a = new g();
  
  public static g a() {
    return a;
  }
  
  public Map<String, String> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("appId", paramString1);
    hashMap.put("randoms", paramString2);
    hashMap.put("content", paramString3);
    hashMap.put("sign", paramString4);
    hashMap.put("packageName", paramString5);
    hashMap.put("packageSign", paramString6);
    return (Map)hashMap;
  }
  
  public Map<String, String> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("packageSign", paramString1);
    hashMap.put("appId", paramString3);
    hashMap.put("client", paramString5);
    hashMap.put("bundleld", paramString7);
    hashMap.put("packageName", paramString6);
    hashMap.put("randoms", paramString4);
    hashMap.put("version", paramString2);
    hashMap.put("sign", paramString8);
    return (Map)hashMap;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */