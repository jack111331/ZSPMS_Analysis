package com.zz.sdk.b.a;

import org.json.JSONObject;

public class q extends a {
  protected static final String m = "code";
  
  protected static final String n = "loginName";
  
  protected static final String o = "sdkuserid";
  
  private static final long q = -7441222655384056558L;
  
  private static final String[] t = new String[] { "成功", "用户不存在", "密码错误" };
  
  public String p;
  
  private String r;
  
  private String s;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    if (this.r != null) {
      jSONObject.put("code", this.r);
      jSONObject.put("loginName", this.s);
      jSONObject.put("sdkuserid", this.p);
    } 
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.r = paramJSONObject.optString("code", null);
      this.s = paramJSONObject.optString("loginName", null);
      this.p = paramJSONObject.optString("sdkuserid", null);
    } 
  }
  
  public String f() {
    return a(t, 0);
  }
  
  public String g() {
    return this.r;
  }
  
  public String h() {
    return this.s;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */