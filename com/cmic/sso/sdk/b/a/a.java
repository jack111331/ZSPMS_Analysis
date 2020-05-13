package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class a extends h {
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
  
  private String l;
  
  private String m;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  private String t;
  
  public String a(String paramString1, String paramString2) {
    return s(this.a + this.b + this.d + this.h + paramString2 + this.m + this.o + this.e + this.f + paramString1);
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ver", this.a);
      jSONObject.put("sdkver", this.b);
      jSONObject.put("sourceid", this.c);
      jSONObject.put("appid", this.d);
      jSONObject.put("msgid", this.e);
      jSONObject.put("timestamp", this.f);
      jSONObject.put("btid", this.g);
      jSONObject.put("authtype", this.h);
      jSONObject.put("phonescrip", this.i);
      jSONObject.put("account", this.j);
      jSONObject.put("getScrip", this.r);
      jSONObject.put("passwd", this.k);
      jSONObject.put("capaids", this.q);
      jSONObject.put("enccnonce", this.l);
      jSONObject.put("clienttype", this.m);
      jSONObject.put("imsi", this.n);
      jSONObject.put("imei", this.o);
      jSONObject.put("interfacever", this.s);
      jSONObject.put("randomNum", this.t);
      jSONObject.put("sign", this.p);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.s = paramString;
  }
  
  public void b(String paramString) {
    this.t = paramString;
  }
  
  public void c(String paramString) {
    this.r = paramString;
  }
  
  public void d(String paramString) {
    this.a = paramString;
  }
  
  public void e(String paramString) {
    this.b = paramString;
  }
  
  public void f(String paramString) {
    this.d = paramString;
  }
  
  public void g(String paramString) {
    this.e = paramString;
  }
  
  public void h(String paramString) {
    this.f = paramString;
  }
  
  public void i(String paramString) {
    this.g = paramString;
  }
  
  public void j(String paramString) {
    this.h = paramString;
  }
  
  public void k(String paramString) {
    this.j = paramString;
  }
  
  public void l(String paramString) {
    this.k = paramString;
  }
  
  public void m(String paramString) {
    this.l = paramString;
  }
  
  public void n(String paramString) {
    this.m = paramString;
  }
  
  public void o(String paramString) {
    this.n = paramString;
  }
  
  public void p(String paramString) {
    this.o = paramString;
  }
  
  public void q(String paramString) {
    this.q = paramString;
  }
  
  public void r(String paramString) {
    this.p = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */