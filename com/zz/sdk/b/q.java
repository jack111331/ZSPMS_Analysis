package com.zz.sdk.b;

import java.io.Serializable;
import org.json.JSONObject;

public class q implements i, Serializable {
  static final String i = "id";
  
  static final String j = "productId";
  
  static final String k = "name";
  
  static final String l = "icon";
  
  static final String m = "bigIcon";
  
  static final String n = "price";
  
  static final String o = "desc";
  
  static final String p = "gameRole";
  
  private static final long q = -6997829973989537649L;
  
  public int a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public double f;
  
  public String g;
  
  public String h;
  
  public JSONObject a() {
    return null;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.optInt("id", -1);
      this.f = paramJSONObject.optDouble("price");
      this.c = paramJSONObject.optString("name");
      this.d = paramJSONObject.optString("icon");
      this.g = paramJSONObject.optString("desc");
      this.b = paramJSONObject.optString("productId");
      this.h = paramJSONObject.optString("gameRole");
      this.e = paramJSONObject.optString("bigIcon");
    } 
  }
  
  public String b() {
    return "prop";
  }
  
  public boolean c() {
    return (this.a >= 0 && !Double.isNaN(this.f));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */