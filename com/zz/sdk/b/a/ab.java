package com.zz.sdk.b.a;

import org.json.JSONObject;

public class ab extends a {
  private static final long A = -8297558378738556411L;
  
  public static final String m = "bptip";
  
  public static final String n = "pubemail";
  
  public static final String o = "pubtel";
  
  public static final String p = "ubemail";
  
  public static final String q = "ubtel";
  
  public static final String r = "pubwechat";
  
  public static final String s = "ubwechat";
  
  public String t;
  
  public String u;
  
  public String v;
  
  public String w;
  
  public String x;
  
  public String y;
  
  public String z;
  
  public JSONObject a() {
    JSONObject jSONObject;
    try {
      jSONObject = super.a();
      try {
        jSONObject.put("bptip", this.t);
        jSONObject.put("pubemail", this.u);
        jSONObject.put("pubtel", this.x);
        jSONObject.put("ubemail", this.y);
        jSONObject.put("ubtel", this.z);
        jSONObject.put("pubwechat", this.v);
        jSONObject.put("ubwechat", this.w);
        return jSONObject;
      } catch (Exception null) {}
    } catch (Exception exception) {
      jSONObject = null;
    } 
    exception.printStackTrace();
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.v = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.t = paramJSONObject.optString("bptip", null);
      this.u = paramJSONObject.optString("pubemail", null);
      this.x = paramJSONObject.optString("pubtel", null);
      this.y = paramJSONObject.optString("ubemail", null);
      this.z = paramJSONObject.optString("ubtel", null);
      this.v = paramJSONObject.optString("pubwechat", null);
      this.w = paramJSONObject.optString("ubwechat", null);
    } 
  }
  
  public void b(String paramString) {
    this.w = paramString;
  }
  
  public void c(String paramString) {
    this.t = paramString;
  }
  
  public void d(String paramString) {
    this.u = paramString;
  }
  
  public void e(String paramString) {
    this.x = paramString;
  }
  
  public void f(String paramString) {
    this.y = paramString;
  }
  
  public String g() {
    return this.t;
  }
  
  public void g(String paramString) {
    this.z = paramString;
  }
  
  public String h() {
    return this.v;
  }
  
  public String i() {
    return this.w;
  }
  
  public String j() {
    return this.u;
  }
  
  public String k() {
    return this.x;
  }
  
  public String l() {
    return this.y;
  }
  
  public String m() {
    return this.z;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */