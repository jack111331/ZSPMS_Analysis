package com.zz.sdk.b.a;

import org.json.JSONObject;

public class an extends al {
  protected static final String o = "payParameters";
  
  private static final long t = 4907704153938318284L;
  
  public String p;
  
  public String q;
  
  public String r;
  
  public String s;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("orderId", this.p);
      jSONObject.put("merchant", this.q);
      jSONObject.put("appId", this.r);
      jSONObject.put("signData", this.s);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.p = paramJSONObject.optString("orderId", "");
      this.q = paramJSONObject.optString("merchant", "");
      this.r = paramJSONObject.optString("appId", "");
      this.s = paramJSONObject.optString("signData", "");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */