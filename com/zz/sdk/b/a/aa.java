package com.zz.sdk.b.a;

import org.json.JSONObject;

public class aa extends a {
  private int m;
  
  private int n;
  
  public void a(int paramInt) {
    this.m = paramInt;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      if (c()) {
        this.m = paramJSONObject.optInt("bindGiftpkgStatus", 0);
        this.n = paramJSONObject.optInt("authGiftpkgStatus", 0);
        return;
      } 
      this.m = 0;
      this.n = 0;
    } 
  }
  
  public void b(int paramInt) {
    this.n = paramInt;
  }
  
  public int g() {
    return this.m;
  }
  
  public int h() {
    return this.n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */