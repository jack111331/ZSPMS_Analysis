package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  private long K = 0L;
  
  private int L = 0;
  
  private String M = "";
  
  private String c = "";
  
  private int g = 0;
  
  public final void a(long paramLong) {
    this.K = paramLong;
  }
  
  public final JSONObject i() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("tm", this.K);
      jSONObject.put("st", this.g);
      if (this.c != null)
        jSONObject.put("dm", this.c); 
      jSONObject.put("pt", this.L);
      if (this.M != null)
        jSONObject.put("rip", this.M); 
      jSONObject.put("ts", System.currentTimeMillis() / 1000L);
    } catch (JSONException jSONException) {}
    return jSONObject;
  }
  
  public final void k(String paramString) {
    this.M = paramString;
  }
  
  public final void setDomain(String paramString) {
    this.c = paramString;
  }
  
  public final void setPort(int paramInt) {
    this.L = paramInt;
  }
  
  public final void setStatusCode(int paramInt) {
    this.g = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */