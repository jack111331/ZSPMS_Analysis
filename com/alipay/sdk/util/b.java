package com.alipay.sdk.util;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    JSONObject jSONObject = new JSONObject();
    for (byte b1 = 0;; b1++) {
      if (b1 < 2) {
        try {
          (new JSONObject[2])[0] = paramJSONObject1;
          (new JSONObject[2])[1] = paramJSONObject2;
          JSONObject jSONObject1 = (new JSONObject[2])[b1];
          if (jSONObject1 != null) {
            Iterator<String> iterator = jSONObject1.keys();
            while (iterator.hasNext()) {
              String str = iterator.next();
              jSONObject.put(str, jSONObject1.get(str));
            } 
          } 
        } catch (JSONException jSONException) {
          return jSONObject;
        } 
      } else {
        return jSONObject;
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */