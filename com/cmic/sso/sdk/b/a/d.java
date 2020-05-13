package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class d extends h {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("version", this.a);
      jSONObject.put("apptype", this.b);
      jSONObject.put("phone_ID", this.c);
      jSONObject.put("certflag", this.d);
      jSONObject.put("sdkversion", this.e);
      jSONObject.put("appid", this.f);
      jSONObject.put("expandparams", this.g);
      jSONObject.put("sign", this.h);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public String b() {
    return s(this.a + this.e + this.f + "iYm0HAnkxQtpvN44").toLowerCase();
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public void c(String paramString) {
    this.c = paramString;
  }
  
  public void d(String paramString) {
    this.d = paramString;
  }
  
  public void e(String paramString) {
    this.e = paramString;
  }
  
  public void f(String paramString) {
    this.f = paramString;
  }
  
  public void g(String paramString) {
    this.h = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */