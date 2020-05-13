package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class b extends h {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String l = "0";
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ver", this.a);
      jSONObject.put("interfacever", "4.0");
      jSONObject.put("sdkver", this.c);
      jSONObject.put("appid", this.d);
      jSONObject.put("expandparams", this.e);
      jSONObject.put("msgid", this.f);
      jSONObject.put("timestamp", this.g);
      jSONObject.put("sign", this.i);
      jSONObject.put("keyid", this.h);
      jSONObject.put("apppackage", this.j);
      jSONObject.put("appsign", this.k);
      jSONObject.put("clienttype", this.l);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.k = paramString;
  }
  
  public void b(String paramString) {
    this.j = paramString;
  }
  
  public void c(String paramString) {
    this.a = paramString;
  }
  
  public void d(String paramString) {
    this.c = paramString;
  }
  
  public void e(String paramString) {
    this.d = paramString;
  }
  
  public void f(String paramString) {
    this.f = paramString;
  }
  
  public void g(String paramString) {
    this.g = paramString;
  }
  
  public void h(String paramString) {
    this.i = paramString;
  }
  
  public void i(String paramString) {
    this.h = paramString;
  }
  
  public void j(String paramString) {
    this.b = paramString;
  }
  
  public String k(String paramString) {
    return s(this.a + this.c + this.d + this.f + this.h + this.g + paramString);
  }
  
  public String toString() {
    return a().toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */