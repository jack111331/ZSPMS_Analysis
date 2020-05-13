package com.zz.sdk.b.a;

import org.json.JSONObject;

public class ay extends a {
  private int m;
  
  private long n;
  
  private long o;
  
  private String p;
  
  public void a(JSONObject paramJSONObject) {
    super.a(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONObject("data");
    this.m = paramJSONObject.optInt("status");
    this.n = paramJSONObject.optLong("sumTime");
    this.o = paramJSONObject.optLong("surplusTime");
    this.p = paramJSONObject.optString("message");
  }
  
  public int g() {
    return this.m;
  }
  
  public long h() {
    return this.n;
  }
  
  public long i() {
    return this.o;
  }
  
  public String j() {
    return this.p;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */