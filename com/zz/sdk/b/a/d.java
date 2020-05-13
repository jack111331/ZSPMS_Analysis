package com.zz.sdk.b.a;

import com.zz.sdk.b.i;
import java.io.Serializable;
import org.json.JSONObject;

public class d implements i, Serializable {
  static final String i = "clubEnable";
  
  static final String j = "clubUrl";
  
  static final String k = "enable";
  
  static final String l = "giftPkgEnable";
  
  static final String m = "shareRewardEnable";
  
  static final String n = "shareUrl";
  
  static final String o = "wikiEnable";
  
  static final String p = "wikiUrl";
  
  private static final long q = -5683998617966598505L;
  
  public int a;
  
  public String b;
  
  public int c;
  
  public int d;
  
  public int e;
  
  public String f;
  
  public int g;
  
  public String h;
  
  public JSONObject a() {
    return null;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.optInt("clubEnable", -1);
      this.b = paramJSONObject.optString("clubUrl");
      this.c = paramJSONObject.optInt("enable", -1);
      this.d = paramJSONObject.optInt("giftPkgEnable", -1);
      this.e = paramJSONObject.optInt("shareRewardEnable", -1);
      this.f = paramJSONObject.optString("shareUrl");
      this.g = paramJSONObject.optInt("wikiEnable", -1);
      this.h = paramJSONObject.optString("wikiUrl");
    } 
  }
  
  public String b() {
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */