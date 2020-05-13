package com.zz.sdk.b.a;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ag extends a {
  protected static final String m = "payMessages";
  
  protected static final String n = "payMessage";
  
  protected static final String o = "url";
  
  protected static final String p = "message";
  
  private static final long s = 1600525483979834732L;
  
  public String q;
  
  public List r = new ArrayList();
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.q = paramJSONObject.optString("payMessages", null);
      JSONArray jSONArray = paramJSONObject.optJSONArray("payMessage");
      if (jSONArray != null && jSONArray.length() > 0) {
        byte b = 0;
        int i = jSONArray.length();
        while (true) {
          if (b < i) {
            JSONObject jSONObject = jSONArray.optJSONObject(b);
            if (jSONObject != null) {
              String str2 = jSONObject.optString("url", null);
              String str1 = jSONObject.optString("message", null);
              if (str2 != null && str1 != null) {
                Pair pair = new Pair(str2, str1);
                this.r.add(pair);
              } 
            } 
            b++;
            continue;
          } 
          return;
        } 
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */