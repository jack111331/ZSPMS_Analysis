package com.zz.sdk.b.a;

import org.json.JSONObject;

public class o extends ad {
  private static final long C = 7365501424243038691L;
  
  public static final String m = "user";
  
  public static final String n = "password";
  
  public String o;
  
  public String p;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("user", this.o);
      jSONObject.put("password", this.p);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.o = paramJSONObject.optString("user", null);
      this.p = paramJSONObject.optString("password", null);
    } 
  }
  
  public String f() {
    return a(a.l, 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */