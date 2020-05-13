package com.zz.sdk.b.a;

import com.zz.sdk.b.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aw implements i {
  private int a;
  
  private List b = new ArrayList();
  
  public JSONObject a() {
    return null;
  }
  
  public void a(JSONObject paramJSONObject) {
    byte b = 0;
    if (paramJSONObject != null)
      try {
        this.a = paramJSONObject.optInt("rewardSwitch");
        this.b.clear();
        if (paramJSONObject.has("list")) {
          JSONArray jSONArray = paramJSONObject.optJSONArray("list");
          if (jSONArray != null)
            while (true) {
              if (b < jSONArray.length()) {
                paramJSONObject = jSONArray.optJSONObject(b);
                if (paramJSONObject != null) {
                  ax ax = new ax();
                  this();
                  ax.b = paramJSONObject.optString("name", "");
                  ax.a = paramJSONObject.optInt("num", 0);
                  ax.c = paramJSONObject.optString("url", "");
                  this.b.add(ax);
                } 
                b++;
                continue;
              } 
              return;
            }  
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public String b() {
    return null;
  }
  
  public int c() {
    return this.a;
  }
  
  public List d() {
    return this.b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */