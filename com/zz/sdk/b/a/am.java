package com.zz.sdk.b.a;

import org.json.JSONObject;

public class am extends al {
  protected static final String o = "url";
  
  protected static final String p = "urlGuard";
  
  protected static final String q = "aliC";
  
  protected static final String r = "aliS";
  
  private static final long w = -346832685778620577L;
  
  public String s;
  
  public String t;
  
  public String u;
  
  public String v;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("url", this.s);
      jSONObject.put("urlGuard", this.t);
      jSONObject.put("aliC", this.u);
      jSONObject.put("aliS", this.v);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.s = paramJSONObject.optString("url", null);
      this.t = paramJSONObject.optString("urlGuard", null);
      this.u = paramJSONObject.optString("aliC", null);
      this.v = paramJSONObject.optString("aliS", null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */