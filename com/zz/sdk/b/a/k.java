package com.zz.sdk.b.a;

import org.json.JSONObject;

public class k extends i {
  private static final long R = 7365501424243038691L;
  
  public static final String m = "phoneToken";
  
  public String n;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    jSONObject.put("phoneToken", this.n);
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.n = paramJSONObject.optString("phoneToken", null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */