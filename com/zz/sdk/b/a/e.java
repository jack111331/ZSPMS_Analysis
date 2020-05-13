package com.zz.sdk.b.a;

import org.json.JSONObject;

public class e {
  private static final String f = "data";
  
  private static final String g = "all";
  
  private static final String h = "custom";
  
  private static final String i = "safe";
  
  private static final String j = "status";
  
  private static final String k = "msg";
  
  public boolean a = false;
  
  public String b = null;
  
  public boolean c = false;
  
  public boolean d = false;
  
  public boolean e = false;
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null && paramJSONObject.length() > 0) {
      this.a = paramJSONObject.optBoolean("status");
      this.b = paramJSONObject.optString("msg");
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null && paramJSONObject.length() > 0) {
        this.c = paramJSONObject.optBoolean("all");
        this.d = paramJSONObject.optBoolean("custom");
        this.e = paramJSONObject.optBoolean("safe");
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */