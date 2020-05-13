package com.zz.sdk.b.a;

import com.zz.sdk.b.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class w extends a {
  public List m = new ArrayList();
  
  public void a(JSONObject paramJSONObject) {
    super.a(paramJSONObject);
    JSONArray jSONArray = paramJSONObject.optJSONArray("data");
    if (jSONArray != null)
      for (byte b = 0; b < jSONArray.length(); b++) {
        paramJSONObject = jSONArray.optJSONObject(b);
        if (paramJSONObject != null) {
          g g = new g();
          g.b = paramJSONObject.optString("gameName");
          g.c = paramJSONObject.optString("gameTime");
          g.a = paramJSONObject.optString("gameIcon");
          this.m.add(g);
        } 
      }  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */