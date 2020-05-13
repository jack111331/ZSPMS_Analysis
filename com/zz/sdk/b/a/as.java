package com.zz.sdk.b.a;

import org.json.JSONObject;

public class as extends al {
  public static final String o = "orderAmount";
  
  public static final String p = "newUrl";
  
  private static final long s = -4504235996548755137L;
  
  public int q;
  
  public String r;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("orderAmount", this.q);
      jSONObject.put("newUrl", this.r);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.q = paramJSONObject.optInt("orderAmount", 0);
      this.r = paramJSONObject.optString("newUrl", null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */