package com.zz.sdk.b.a;

import org.json.JSONObject;

public class p extends a {
  protected static final String m = "zyCoin";
  
  private static final long o = -8456103310324367514L;
  
  public Double n;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("zyCoin", String.valueOf(this.n));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      Double double_;
      super.a(paramJSONObject);
      double d = paramJSONObject.optDouble("zyCoin");
      if (Double.isNaN(d)) {
        paramJSONObject = null;
      } else {
        double_ = Double.valueOf(d);
      } 
      this.n = double_;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */