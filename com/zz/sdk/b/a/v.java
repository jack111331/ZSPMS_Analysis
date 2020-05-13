package com.zz.sdk.b.a;

import org.json.JSONObject;

public class v extends i {
  static final String m = "loginName";
  
  protected static final String n = "sdkuserid";
  
  public String R;
  
  private String S;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    jSONObject.put("loginName", this.S);
    jSONObject.put("sdkuserid", this.R);
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.S = paramJSONObject.optString("loginName", null);
      this.R = paramJSONObject.optString("sdkuserid", null);
    } 
  }
  
  public String q() {
    return this.S;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */