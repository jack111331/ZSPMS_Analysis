package com.tencent.wxop.stat.b;

import org.json.JSONException;
import org.json.JSONObject;

public final class c {
  private String W = "0";
  
  private String a = null;
  
  private String b = null;
  
  private int bf = 0;
  
  private String c = null;
  
  private int cu;
  
  private long cv = 0L;
  
  public c() {}
  
  public c(String paramString1, String paramString2, int paramInt) {
    this.a = paramString1;
    this.b = paramString2;
    this.cu = paramInt;
  }
  
  private JSONObject aq() {
    JSONObject jSONObject = new JSONObject();
    try {
      r.a(jSONObject, "ui", this.a);
      r.a(jSONObject, "mc", this.b);
      r.a(jSONObject, "mid", this.W);
      r.a(jSONObject, "aid", this.c);
      jSONObject.put("ts", this.cv);
      jSONObject.put("ver", this.bf);
    } catch (JSONException jSONException) {}
    return jSONObject;
  }
  
  public final String ar() {
    return this.b;
  }
  
  public final int as() {
    return this.cu;
  }
  
  public final String b() {
    return this.a;
  }
  
  public final String toString() {
    return aq().toString();
  }
  
  public final void z() {
    this.cu = 1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */