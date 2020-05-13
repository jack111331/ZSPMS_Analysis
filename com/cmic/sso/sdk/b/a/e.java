package com.cmic.sso.sdk.b.a;

import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends h {
  private a a;
  
  private String b;
  
  private String c;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("encrypted", this.c);
      jSONObject.put("reqdata", com.cmic.sso.sdk.utils.a.a(this.b, this.a.toString()));
      h.a("GETpre", this.a.toString());
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public void a(a parama) {
    this.a = parama;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public a b() {
    return this.a;
  }
  
  public void b(String paramString) {
    this.c = paramString;
  }
  
  public static class a {
    private String A = "";
    
    private String B = "";
    
    private String C = "";
    
    private String D;
    
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
    
    private String k = "";
    
    private String l = "";
    
    private String m = "";
    
    private String n = "";
    
    private String o = "";
    
    private String p = "";
    
    private String q = "";
    
    private String r = "";
    
    private String s = "";
    
    private String t = "";
    
    private String u = "";
    
    private String v = "";
    
    private String w = "";
    
    private String x = "";
    
    private String y = "";
    
    private String z = "";
    
    private String x(String param1String) {
      String str = param1String;
      if (param1String == null)
        str = ""; 
      return str;
    }
    
    public void a(String param1String) {
      this.B = param1String;
    }
    
    public void b(String param1String) {
      this.C = param1String;
    }
    
    public void c(String param1String) {
      this.x = x(param1String);
    }
    
    public void d(String param1String) {
      this.y = x(param1String);
    }
    
    public void e(String param1String) {
      this.a = x(param1String);
    }
    
    public void f(String param1String) {
      this.b = x(param1String);
    }
    
    public void g(String param1String) {
      this.c = x(param1String);
    }
    
    public void h(String param1String) {
      this.d = x(param1String);
    }
    
    public void i(String param1String) {
      this.e = x(param1String);
    }
    
    public void j(String param1String) {
      this.f = x(param1String);
    }
    
    public void k(String param1String) {
      this.g = x(param1String);
    }
    
    public void l(String param1String) {
      this.h = x(param1String);
    }
    
    public void m(String param1String) {
      this.i = x(param1String);
    }
    
    public void n(String param1String) {
      String str = x(param1String);
      try {
        this.j = URLEncoder.encode(str, "UTF-8");
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        this.j = str;
      } 
    }
    
    public void o(String param1String) {
      String str = x(param1String);
      try {
        this.k = URLEncoder.encode(str, "UTF-8");
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        this.k = str;
      } 
    }
    
    public void p(String param1String) {
      this.l = x(param1String);
    }
    
    public void q(String param1String) {
      this.m = x(param1String);
    }
    
    public void r(String param1String) {
      this.o = x(param1String);
    }
    
    public void s(String param1String) {
      this.p = x(param1String);
    }
    
    public void t(String param1String) {
      this.z = x(param1String);
    }
    
    public String toString() {
      return this.a + "&" + this.b + "&" + this.c + "&" + this.d + "&" + this.e + "&" + this.f + "&" + this.g + "&" + this.h + "&" + this.i + "&" + this.j + "&" + this.k + "&" + this.l + "&" + this.m + "&" + "7.0" + "&" + this.n + "&" + this.o + "&" + this.p + "&" + this.q + "&" + this.r + "&" + this.s + "&" + this.t + "&" + this.u + "&" + this.v + "&" + this.w + "&" + this.x + "&" + this.y + "&" + this.z + "&" + this.A + "&" + this.D + "&&" + this.B + "&" + this.C;
    }
    
    public void u(String param1String) {
      this.A = x(param1String);
    }
    
    public void v(String param1String) {
      this.D = x(param1String);
    }
    
    public String w(String param1String) {
      return j.a(this.b + this.c + this.d + this.e + this.f + this.g + this.h + this.i + this.j + this.k + this.l + this.m + this.o + this.p + param1String + this.q + this.r + this.s + this.t + this.u + this.v + this.w + this.x + this.y + this.z + this.A + this.B + this.C);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */