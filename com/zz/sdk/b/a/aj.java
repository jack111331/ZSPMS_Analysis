package com.zz.sdk.b.a;

import org.json.JSONObject;

public class aj extends a {
  protected static final String m = "icStat";
  
  protected static final String n = "isAdult";
  
  public boolean o;
  
  public boolean p;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    jSONObject.put("icStat", this.o);
    jSONObject.put("isAdult", this.p);
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.o = paramJSONObject.optBoolean("icStat", false);
      this.p = paramJSONObject.optBoolean("isAdult", false);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */