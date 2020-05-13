package com.zz.sdk.b.a;

import org.json.JSONObject;

public class at extends al {
  private static final long C = -4215573212577706831L;
  
  public static final String o = "p_a";
  
  public static final String p = "p_b";
  
  public static final String q = "p_c";
  
  public static final String r = "p_d";
  
  public static final String s = "p_e";
  
  public static final String t = "p_f";
  
  public static final String u = "p_g";
  
  public long A;
  
  public String B;
  
  public String v;
  
  public String w;
  
  public String x;
  
  public String y;
  
  public String z;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("p_a", this.v);
      jSONObject.put("p_b", this.w);
      jSONObject.put("p_c", this.x);
      jSONObject.put("p_d", this.y);
      jSONObject.put("p_f", this.z);
      jSONObject.put("p_e", this.A);
      jSONObject.put("p_g", this.B);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.v = paramJSONObject.optString("p_a", null);
      this.w = paramJSONObject.optString("p_b", null);
      this.x = paramJSONObject.optString("p_c", null);
      this.y = paramJSONObject.optString("p_d", null);
      this.z = paramJSONObject.optString("p_f", null);
      this.A = paramJSONObject.optLong("p_e");
      this.B = paramJSONObject.optString("p_g", null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */