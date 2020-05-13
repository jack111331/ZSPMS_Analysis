package com.zz.sdk.b.a;

import org.json.JSONObject;

public class ad extends a {
  private static final long m = 4266148791284444072L;
  
  private static final String[] n = new String[] { "成功", "用户不存在", "密码错误" };
  
  protected static final String q = "id";
  
  protected static final String r = "sdkuserid";
  
  protected static final String s = "username";
  
  protected static final String t = "cmStatus";
  
  protected static final String u = "tel";
  
  protected static final String v = "bindForcus";
  
  public String A;
  
  public boolean B;
  
  public String w;
  
  public String x;
  
  public String y;
  
  public int z;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject1 = super.a();
      jSONObject1.put("id", this.w);
      jSONObject1.put("sdkuserid", this.x);
      jSONObject1.put("username", this.y);
      jSONObject1.put("cmStatus", this.z);
      if (this.A != null)
        jSONObject1.put("tel", this.A); 
      JSONObject jSONObject2 = jSONObject1;
      if (this.B) {
        jSONObject1.put("bindForcus", this.B);
        jSONObject2 = jSONObject1;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.w = paramJSONObject.optString("id", null);
      this.x = paramJSONObject.optString("sdkuserid", null);
      this.y = paramJSONObject.optString("username", null);
      this.z = paramJSONObject.optInt("cmStatus", 0);
      this.A = paramJSONObject.optString("tel", null);
      this.B = paramJSONObject.optBoolean("bindForcus", false);
    } 
  }
  
  public String f() {
    return a(n, 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */