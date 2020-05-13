package com.unionpay.mobile.android.hce;

import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class k {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private JSONObject g;
  
  public k(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      this.g = paramJSONObject;
      this.a = j.a(paramJSONObject, "package");
      this.b = j.a(paramJSONObject, "issuer");
      this.c = j.a(paramJSONObject, "syn_key");
      this.d = j.a(paramJSONObject, "pub_key");
      this.e = j.a(paramJSONObject, "status");
      this.f = j.a(paramJSONObject, "priority");
    } 
  }
  
  public final boolean a() {
    return this.e.equals("D");
  }
  
  public final String b() {
    return this.a;
  }
  
  public final String c() {
    return this.b;
  }
  
  public final String d() {
    return this.c;
  }
  
  public final String e() {
    return this.d;
  }
  
  public final JSONObject f() {
    return this.g;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */