package com.zz.sdk.b.a;

import org.json.JSONObject;

public class x extends a {
  private static final String m = "data";
  
  private int n;
  
  public void a(int paramInt) {
    this.n = paramInt;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null)
        this.n = paramJSONObject.optInt("count", 0); 
    } 
  }
  
  public int g() {
    return this.n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */