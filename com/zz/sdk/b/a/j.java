package com.zz.sdk.b.a;

import org.json.JSONObject;

public class j extends a {
  static final String m = "expires_in";
  
  static final String n = "access_token";
  
  private int o;
  
  private String p;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    jSONObject.put("expires_in", this.o);
    jSONObject.put("access_token", this.p);
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.o = paramJSONObject.optInt("expires_in", 0);
      this.p = paramJSONObject.optString("access_token", null);
    } 
  }
  
  public int g() {
    return this.o;
  }
  
  public String h() {
    return this.p;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */