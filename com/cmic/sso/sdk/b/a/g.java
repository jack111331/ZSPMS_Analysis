package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class g {
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
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("authPageOut", this.b);
      jSONObject.put("authPageIn", this.a);
      jSONObject.put("auth2SMS", this.e);
      jSONObject.put("SMSIn", this.c);
      jSONObject.put("SMSOut", this.d);
      jSONObject.put("SMSClick", this.f);
      jSONObject.put("authPageReturn", this.g);
      jSONObject.put("authClickSuccess", this.i);
      jSONObject.put("timeOnAuthPage", this.j);
      jSONObject.put("authClickFailed", this.h);
      jSONObject.put("getSMSCodeFailed", this.k);
      jSONObject.put("getSMSCodeSuccess", this.l);
      jSONObject.put("SMSVerifyFailed", this.m);
      jSONObject.put("SMSVerifySuccess", this.n);
      jSONObject.put("timeOnSMSPage", this.o);
      jSONObject.put("authPrivacyState", this.p);
      jSONObject.put("SMSPageOut", this.r);
      jSONObject.put("SMSPageReturn", this.q);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.r = paramString;
  }
  
  public void b(String paramString) {
    this.q = paramString;
  }
  
  public void c(String paramString) {
    this.p = paramString;
  }
  
  public void d(String paramString) {
    this.h = paramString;
  }
  
  public void e(String paramString) {
    this.i = paramString;
  }
  
  public void f(String paramString) {
    this.j = paramString;
  }
  
  public void g(String paramString) {
    this.k = paramString;
  }
  
  public void h(String paramString) {
    this.l = paramString;
  }
  
  public void i(String paramString) {
    this.m = paramString;
  }
  
  public void j(String paramString) {
    this.n = paramString;
  }
  
  public void k(String paramString) {
    this.o = paramString;
  }
  
  public void l(String paramString) {
    this.g = paramString;
  }
  
  public void m(String paramString) {
    this.c = paramString;
  }
  
  public void n(String paramString) {
    this.e = paramString;
  }
  
  public void o(String paramString) {
    this.a = paramString;
  }
  
  public void p(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */