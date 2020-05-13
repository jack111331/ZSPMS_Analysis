package com.zz.sdk.b.a;

import org.json.JSONObject;

public class n extends i {
  protected static final String R = "pwdStatus";
  
  protected static final String S = "email";
  
  protected static final String T = "age";
  
  protected static final String U = "realname";
  
  protected static final String V = "idCard";
  
  public int W;
  
  public String X;
  
  public int Y;
  
  public String Z;
  
  public String aa;
  
  public JSONObject a() {
    return super.a();
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.W = paramJSONObject.optInt("pwdStatus", 0);
      this.X = paramJSONObject.optString("email", null);
      this.Y = paramJSONObject.optInt("age", 0);
      this.Z = paramJSONObject.optString("realname", "");
      this.aa = paramJSONObject.optString("idCard", "");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */