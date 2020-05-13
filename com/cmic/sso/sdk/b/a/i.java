package com.cmic.sso.sdk.b.a;

import com.cmic.sso.sdk.utils.o;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends h {
  private String a = "";
  
  private String b = "";
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private String i = "";
  
  private String j = "";
  
  private String k;
  
  private String l;
  
  public String a(String paramString1, String paramString2, o paramo) {
    return paramo.a((this.a + this.b + this.d + this.e + this.c + this.h + paramString2 + paramString1).getBytes());
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ver", this.a);
      jSONObject.put("sdkver", this.b);
      jSONObject.put("appid", this.c);
      jSONObject.put("msgid", this.d);
      jSONObject.put("timestamp", this.e);
      jSONObject.put("sourceid", this.f);
      jSONObject.put("msgtype", this.g);
      jSONObject.put("phonenumber", this.h);
      jSONObject.put("enccnonce", this.i);
      jSONObject.put("interfacever", this.l);
      jSONObject.put("sign", this.j);
      jSONObject.put("expandparams", this.k);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.l = paramString;
  }
  
  public void b(String paramString) {
    this.a = paramString;
  }
  
  public void c(String paramString) {
    this.b = paramString;
  }
  
  public void d(String paramString) {
    this.c = paramString;
  }
  
  public void e(String paramString) {
    this.d = paramString;
  }
  
  public void f(String paramString) {
    this.e = paramString;
  }
  
  public void g(String paramString) {
    this.g = paramString;
  }
  
  public void h(String paramString) {
    this.h = paramString;
  }
  
  public void i(String paramString) {
    this.i = paramString;
  }
  
  public void j(String paramString) {
    this.j = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */