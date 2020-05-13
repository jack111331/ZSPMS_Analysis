package com.zz.sdk.b.a;

import org.json.JSONObject;

public class ac extends a {
  protected static final String m = "buoy";
  
  protected static final String o = "idStat";
  
  public int n;
  
  public int p;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    jSONObject.put("buoy", this.n);
    jSONObject.put("idStat", "idStat");
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.n = paramJSONObject.optInt("buoy", 0);
      this.p = paramJSONObject.optInt("idStat", 0);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */