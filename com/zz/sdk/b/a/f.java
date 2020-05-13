package com.zz.sdk.b.a;

import org.json.JSONObject;

public class f extends a {
  private String m;
  
  public void a(String paramString) {
    this.m = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      if (c()) {
        this.m = paramJSONObject.optString("giftPkgCode");
        return;
      } 
      this.m = "";
    } 
  }
  
  public String g() {
    return this.m;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */