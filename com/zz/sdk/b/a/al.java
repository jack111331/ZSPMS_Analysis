package com.zz.sdk.b.a;

import org.json.JSONObject;

public class al extends a {
  protected static final String m = "platformOrderNum";
  
  private static final long o = -8453873063884063578L;
  
  public String n;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("platformOrderNum", this.n);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.n = paramJSONObject.optString("platformOrderNum", null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */