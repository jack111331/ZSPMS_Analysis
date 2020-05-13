package com.zz.sdk.b.a;

import org.json.JSONObject;

public class ar extends al {
  protected static final String o = "tn";
  
  private static final long q = -2912006021234183683L;
  
  public String p;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("tn", this.p);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.p = paramJSONObject.optString("tn", null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */