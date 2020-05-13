package com.zz.sdk.b.a;

import org.json.JSONObject;

public class au extends al {
  protected static final String o = "message";
  
  private static final long q = -9041206761013762640L;
  
  public String p;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("message", this.p);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.p = paramJSONObject.optString("message", null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */