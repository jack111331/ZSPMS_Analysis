package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class c extends h {
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
  
  private JSONObject l;
  
  private String m;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("version", this.a);
      jSONObject.put("msgid", this.b);
      jSONObject.put("appid", this.c);
      jSONObject.put("scrip", this.d);
      jSONObject.put("sign", this.e);
      jSONObject.put("interfacever", this.f);
      jSONObject.put("userCapaid", this.g);
      jSONObject.put("clienttype", this.h);
      jSONObject.put("sourceid", this.i);
      jSONObject.put("authenticated_appid", this.j);
      jSONObject.put("genTokenByAppid", this.k);
      jSONObject.put("rcData", this.l);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.h = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.l = paramJSONObject;
  }
  
  public void b(String paramString) {
    this.i = paramString;
  }
  
  public void c(String paramString) {
    this.m = paramString;
  }
  
  public void d(String paramString) {
    this.f = paramString;
  }
  
  public void e(String paramString) {
    this.g = paramString;
  }
  
  public void f(String paramString) {
    this.a = paramString;
  }
  
  public void g(String paramString) {
    this.b = paramString;
  }
  
  public void h(String paramString) {
    this.c = paramString;
  }
  
  public void i(String paramString) {
    this.d = paramString;
  }
  
  public void j(String paramString) {
    this.e = paramString;
  }
  
  public void k(String paramString) {
    this.j = paramString;
  }
  
  public void l(String paramString) {
    this.k = paramString;
  }
  
  public String m(String paramString) {
    return s(this.a + this.c + paramString + this.d);
  }
  
  public String toString() {
    return a().toString();
  }
  
  public static class a {
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
    
    private String u;
    
    private String v;
    
    private String w;
    
    private String x;
    
    private String y;
    
    private String z;
    
    public JSONObject a() {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("traceId", this.a);
        jSONObject.put("phone_id", this.b);
        jSONObject.put("os", this.c);
        jSONObject.put("dev_model", this.d);
        jSONObject.put("dev_brand", this.e);
        jSONObject.put("mnc", this.f);
        jSONObject.put("client_type", this.g);
        jSONObject.put("network_type", this.h);
        jSONObject.put("cpuid", this.i);
        jSONObject.put("sim_num", this.j);
        jSONObject.put("imei", this.k);
        jSONObject.put("imsi", this.l);
        jSONObject.put("sub_imei", this.m);
        jSONObject.put("sub_imsi", this.n);
        jSONObject.put("dev_mac", this.o);
        jSONObject.put("lac", this.p);
        jSONObject.put("loc_info", this.q);
        jSONObject.put("cell_id", this.r);
        jSONObject.put("is_wifi", this.s);
        jSONObject.put("wifi_mac", this.t);
        jSONObject.put("wifi_ssid", this.u);
        jSONObject.put("ipv4List", this.v);
        jSONObject.put("ipv6List", this.w);
        jSONObject.put("is_cert", this.x);
        jSONObject.put("server_addr", this.y);
        jSONObject.put("is_root", this.z);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      return jSONObject;
    }
    
    public void a(String param1String) {
      this.a = param1String;
    }
    
    public void b(String param1String) {
      this.b = param1String;
    }
    
    public void c(String param1String) {
      this.c = param1String;
    }
    
    public void d(String param1String) {
      this.d = param1String;
    }
    
    public void e(String param1String) {
      this.e = param1String;
    }
    
    public void f(String param1String) {
      this.f = param1String;
    }
    
    public void g(String param1String) {
      this.g = param1String;
    }
    
    public void h(String param1String) {
      this.h = param1String;
    }
    
    public void i(String param1String) {
      this.i = param1String;
    }
    
    public void j(String param1String) {
      this.j = param1String;
    }
    
    public void k(String param1String) {
      this.k = param1String;
    }
    
    public void l(String param1String) {
      this.l = param1String;
    }
    
    public void m(String param1String) {
      this.m = param1String;
    }
    
    public void n(String param1String) {
      this.n = param1String;
    }
    
    public void o(String param1String) {
      this.o = param1String;
    }
    
    public void p(String param1String) {
      this.p = param1String;
    }
    
    public void q(String param1String) {
      this.q = param1String;
    }
    
    public void r(String param1String) {
      this.r = param1String;
    }
    
    public void s(String param1String) {
      this.s = param1String;
    }
    
    public void t(String param1String) {
      this.t = param1String;
    }
    
    public void u(String param1String) {
      this.u = param1String;
    }
    
    public void v(String param1String) {
      this.v = param1String;
    }
    
    public void w(String param1String) {
      this.w = param1String;
    }
    
    public void x(String param1String) {
      this.x = param1String;
    }
    
    public void y(String param1String) {
      this.y = param1String;
    }
    
    public void z(String param1String) {
      this.z = param1String;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */