package com.qiniu.android.utils;

import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Json {
  public static String encodeList(Collection paramCollection) {
    return (new JSONArray(paramCollection)).toString();
  }
  
  public static String encodeMap(Map paramMap) {
    return (new JSONObject(paramMap)).toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\androi\\utils\Json.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */