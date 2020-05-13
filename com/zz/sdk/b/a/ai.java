package com.zz.sdk.b.a;

import com.zz.sdk.b.i;
import org.json.JSONObject;

public class ai implements i {
  private int a;
  
  private int b;
  
  public JSONObject a() {
    return null;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject == null) {
      this.b = 0;
      this.a = 0;
      return;
    } 
    this.a = paramJSONObject.optInt("enabled");
    this.b = paramJSONObject.optInt("force");
  }
  
  public String b() {
    return null;
  }
  
  public void b(int paramInt) {
    this.b = paramInt;
  }
  
  public int c() {
    return this.a;
  }
  
  public int d() {
    return this.b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */