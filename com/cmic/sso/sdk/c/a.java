package com.cmic.sso.sdk.c;

import com.cmic.sso.sdk.b.a.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends h {
  public static ArrayList<Throwable> a = new ArrayList<Throwable>();
  
  private String A = null;
  
  private String B = null;
  
  private String C = null;
  
  private String D = null;
  
  private String E = null;
  
  private String F = null;
  
  private String G = null;
  
  private String H = null;
  
  private String I = null;
  
  private JSONObject J = null;
  
  private String K = null;
  
  private String L = null;
  
  private String M = null;
  
  private String N = null;
  
  private String b = null;
  
  private String c = null;
  
  private String d = null;
  
  private String e = null;
  
  private String f = null;
  
  private String g = null;
  
  private String h = null;
  
  private String i = null;
  
  private String j = null;
  
  private String k = null;
  
  private String l = null;
  
  private String m = null;
  
  private String n = null;
  
  private String o = null;
  
  private JSONArray p = null;
  
  private String q = null;
  
  private String r = null;
  
  private String s = null;
  
  private String t = null;
  
  private String u = null;
  
  private String v = null;
  
  private String w = null;
  
  private String x = null;
  
  private String y = null;
  
  private String z = null;
  
  public void A(String paramString) {
    this.q = paramString;
  }
  
  public void B(String paramString) {
    this.u = paramString;
  }
  
  public void C(String paramString) {
    this.v = paramString;
  }
  
  public void D(String paramString) {
    this.o = paramString;
  }
  
  public void E(String paramString) {
    this.b = paramString;
  }
  
  public void F(String paramString) {
    this.h = paramString;
  }
  
  public void G(String paramString) {
    this.s = paramString;
  }
  
  public void H(String paramString) {
    this.i = paramString;
  }
  
  public void I(String paramString) {
    this.k = paramString;
  }
  
  public void J(String paramString) {
    this.K = paramString;
  }
  
  public void K(String paramString) {
    this.e = paramString;
  }
  
  public void L(String paramString) {
    this.r = paramString;
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("traceId", this.b);
      jSONObject.put("requestTime", this.h);
      jSONObject.put("responseTime", this.i);
      jSONObject.put("requestType", this.k);
      jSONObject.put("loginType", this.o);
      jSONObject.put("sdkVersion", this.e);
      jSONObject.put("networkType", this.r);
      jSONObject.put("networkClass", this.s);
      jSONObject.put("reqDevice", this.u);
      jSONObject.put("reqSystem", this.v);
      jSONObject.put("operatorType", this.q);
      jSONObject.put("simCardNum", this.B);
      jSONObject.put("exceptionStackTrace", this.p);
      jSONObject.put("appName", this.c);
      jSONObject.put("appVersion", this.d);
      jSONObject.put("wifiIPAddr", this.w);
      jSONObject.put("wifiMac", this.x);
      jSONObject.put("IPv4List", this.y);
      jSONObject.put("IPv6List", this.z);
      jSONObject.put("interfaceCode", this.m);
      jSONObject.put("interfaceType", this.l);
      jSONObject.put("interfaceElasped", this.n);
      jSONObject.put("event", this.J);
      jSONObject.put("appid", this.K);
      jSONObject.put("imsi", this.F);
      jSONObject.put("imei", this.E);
      jSONObject.put("subimsi", this.H);
      jSONObject.put("subimei", this.G);
      jSONObject.put("brand", this.t);
      jSONObject.put("resultCode", this.I);
      jSONObject.put("iccid", this.C);
      jSONObject.put("is_root", this.L);
      jSONObject.put("subiccid", this.D);
      jSONObject.put("deviceid", this.A);
      jSONObject.put("imsiState", this.M);
      jSONObject.put("transCode", this.N);
      jSONObject.put("elapsedTime", this.j);
      jSONObject.put("clientType", this.f);
      jSONObject.put("timeOut", this.g);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.N = paramString;
  }
  
  public void a(JSONArray paramJSONArray) {
    this.p = paramJSONArray;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.J = paramJSONObject;
  }
  
  public void b(String paramString) {
    this.M = paramString;
  }
  
  public void c(String paramString) {
    this.L = paramString;
  }
  
  public void d(String paramString) {
    this.I = paramString;
  }
  
  public void e(String paramString) {
    this.m = paramString;
  }
  
  public void f(String paramString) {
    this.n = paramString;
  }
  
  public void g(String paramString) {
    this.C = paramString;
  }
  
  public void h(String paramString) {
    this.G = paramString;
  }
  
  public void i(String paramString) {
    this.H = paramString;
  }
  
  public void j(String paramString) {
    this.D = paramString;
  }
  
  public void k(String paramString) {
    this.E = paramString;
  }
  
  public void l(String paramString) {
    this.F = paramString;
  }
  
  public void m(String paramString) {
    this.A = paramString;
  }
  
  public void n(String paramString) {
    this.y = paramString;
  }
  
  public void o(String paramString) {
    this.z = paramString;
  }
  
  public void p(String paramString) {
    this.t = paramString;
  }
  
  public void q(String paramString) {
    this.l = paramString;
  }
  
  public void r(String paramString) {
    this.j = paramString;
  }
  
  public void t(String paramString) {
    this.f = paramString;
  }
  
  public void u(String paramString) {
    this.g = paramString;
  }
  
  public void v(String paramString) {
    this.c = paramString;
  }
  
  public void w(String paramString) {
    this.d = paramString;
  }
  
  public void x(String paramString) {
    this.x = paramString;
  }
  
  public void y(String paramString) {
    this.w = paramString;
  }
  
  public void z(String paramString) {
    this.B = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */