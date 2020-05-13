package com.zz.sdk.b.a;

import org.json.JSONObject;

public class z extends a {
  private int m;
  
  private int n;
  
  public void a(int paramInt) {
    this.m = paramInt;
  }
  
  public void a(JSONObject paramJSONObject) {
    super.a(paramJSONObject);
    if (paramJSONObject != null) {
      this.m = paramJSONObject.optInt("roleUpdate");
      this.n = paramJSONObject.optInt("isAdult", 0);
    } 
  }
  
  public z b(int paramInt) {
    this.n = paramInt;
    return this;
  }
  
  public int g() {
    return this.m;
  }
  
  public int h() {
    return this.n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */