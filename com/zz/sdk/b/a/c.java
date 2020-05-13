package com.zz.sdk.b.a;

import org.json.JSONObject;

public class c extends a {
  static final String m = "token";
  
  private static final long o = -7441222655384056558L;
  
  public String n;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    jSONObject.put("token", this.n);
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.n = paramJSONObject.optString("token", null);
    } 
  }
  
  public String g() {
    return this.n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */