package com.xy.whf.helper;

import android.webkit.CookieManager;
import java.util.HashMap;

public class b {
  public static HashMap<String, Object> a(String paramString) {
    String str = CookieManager.getInstance().getCookie(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (!LangHelper.isNullOrEmpty(str)) {
      String[] arrayOfString = str.split(";");
      int i = arrayOfString.length;
      for (byte b1 = 0; b1 < i; b1++) {
        String[] arrayOfString1 = arrayOfString[b1].split("=");
        if (arrayOfString1.length > 1)
          hashMap.put(arrayOfString1[0], arrayOfString1[1]); 
      } 
    } 
    return (HashMap)hashMap;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */