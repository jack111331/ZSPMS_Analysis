package com.zz.sdk.b.a;

import org.json.JSONObject;

public class i extends a {
  protected static final String A = "password";
  
  protected static final String B = "userType";
  
  protected static final String C = "touristLogin";
  
  protected static final String D = "touristPay";
  
  private static final String[] U = new String[] { "成功", "用户不存在", "密码错误" };
  
  private static final long m = 4266148791284444072L;
  
  protected static final String o = "code";
  
  protected static final String p = "tel";
  
  protected static final String q = "bindForcus";
  
  protected static final String r = "id";
  
  protected static final String s = "username";
  
  protected static final String t = "sdkuserid";
  
  protected static final String u = "cmStatus";
  
  protected static final String v = "loginCount";
  
  protected static final String w = "idStat";
  
  protected static final String x = "aliasStat";
  
  protected static final String y = "temp_token";
  
  protected static final String z = "phone";
  
  public int E;
  
  public String F;
  
  public String G;
  
  public int H;
  
  public int I;
  
  public int J;
  
  public int K;
  
  public String L;
  
  public String M;
  
  public int N;
  
  public int O;
  
  public int P;
  
  public int Q;
  
  private String R;
  
  private boolean S;
  
  private String T;
  
  private String n;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    if (this.n != null) {
      jSONObject.put("code", this.n);
      jSONObject.put("tel", this.R);
      if (this.S)
        jSONObject.put("bindForcus", this.S); 
      jSONObject.put("id", this.E);
      jSONObject.put("username", this.F);
      jSONObject.put("sdkuserid", this.G);
      jSONObject.put("cmStatus", this.H);
      jSONObject.put("loginCount", this.I);
      jSONObject.put("idStat", this.J);
      jSONObject.put("aliasStat", this.K);
      jSONObject.put("temp_token", this.L);
      jSONObject.put("phone", this.T);
      jSONObject.put("password", this.M);
      jSONObject.put("userType", this.N);
      jSONObject.put("touristLogin", this.O);
      jSONObject.put("touristPay", this.P);
    } 
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.n = paramJSONObject.optString("code", null);
      this.R = paramJSONObject.optString("tel", null);
      this.S = paramJSONObject.optBoolean("bindForcus", false);
      this.E = paramJSONObject.optInt("id", -1);
      this.F = paramJSONObject.optString("username", null);
      this.G = paramJSONObject.optString("sdkuserid", null);
      this.H = paramJSONObject.optInt("cmStatus", 0);
      this.I = paramJSONObject.optInt("loginCount", 0);
      this.J = paramJSONObject.optInt("idStat", 0);
      this.K = paramJSONObject.optInt("aliasStat", 0);
      this.L = paramJSONObject.optString("temp_token");
      this.T = paramJSONObject.optString("phone", null);
      this.M = paramJSONObject.optString("password", null);
      this.N = paramJSONObject.optInt("userType", 0);
      this.O = paramJSONObject.optInt("touristLogin");
      this.P = paramJSONObject.optInt("touristPay");
    } 
  }
  
  public String f() {
    return a(U, 0);
  }
  
  public String g() {
    return this.M;
  }
  
  public String h() {
    return this.n;
  }
  
  public String i() {
    return this.R;
  }
  
  public String j() {
    return this.T;
  }
  
  public String k() {
    return this.F;
  }
  
  public int l() {
    return this.I;
  }
  
  public int m() {
    return this.J;
  }
  
  public int n() {
    return this.K;
  }
  
  public String o() {
    return this.L;
  }
  
  public boolean p() {
    return this.S;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */