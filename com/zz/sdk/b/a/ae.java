package com.zz.sdk.b.a;

import com.zz.sdk.i.aq;
import org.json.JSONObject;

public class ae extends a {
  static final String m = "msg";
  
  static final String n = "status";
  
  static final String o = "submitTime";
  
  static final String p = "submitAmount";
  
  static final String q = "type";
  
  static final String r = "platformOrderNum";
  
  private static final long s = 3506165587612135158L;
  
  private String t;
  
  private aq u;
  
  private String v;
  
  private String w;
  
  private String x;
  
  private String y;
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    jSONObject.put("type", this.v);
    jSONObject.put("msg", this.t);
    if (this.u == null) {
      String str1 = "";
      jSONObject.put("status", str1);
      jSONObject.put("submitTime", this.w);
      jSONObject.put("submitAmount", this.y);
      jSONObject.put("platformOrderNum", this.x);
      return jSONObject;
    } 
    String str = this.u.a();
    jSONObject.put("status", str);
    jSONObject.put("submitTime", this.w);
    jSONObject.put("submitAmount", this.y);
    jSONObject.put("platformOrderNum", this.x);
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.t = paramJSONObject.optString("msg", null);
      this.y = paramJSONObject.optString("submitAmount", null);
      this.x = paramJSONObject.optString("platformOrderNum", null);
      this.w = paramJSONObject.optString("submitTime", null);
      this.v = paramJSONObject.optString("type", null);
      this.u = aq.a(paramJSONObject.optString("status", null));
    } 
  }
  
  public boolean c() {
    return (super.c() && this.u != null);
  }
  
  public String g() {
    return this.t;
  }
  
  public String h() {
    return this.y;
  }
  
  public aq i() {
    return this.u;
  }
  
  public String j() {
    return this.v;
  }
  
  public String k() {
    return this.w;
  }
  
  public boolean l() {
    return (this.u == aq.c);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */