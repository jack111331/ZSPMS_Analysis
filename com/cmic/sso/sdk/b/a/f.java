package com.cmic.sso.sdk.b.a;

import com.cmic.sso.sdk.utils.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends h {
  private b a;
  
  private a b;
  
  public JSONObject a() {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    JSONObject jSONObject3 = new JSONObject();
    try {
      jSONObject2.put("sign", this.a.c());
      jSONObject2.put("msgid", this.a.d());
      jSONObject2.put("systemtime", this.a.e());
      jSONObject2.put("appid", this.a.b());
      jSONObject2.put("version", this.a.a());
      jSONObject1.put("header", jSONObject2);
      jSONObject3.put("log", this.b.a());
      jSONObject1.put("body", jSONObject3);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject1;
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public void a(b paramb) {
    this.a = paramb;
  }
  
  public static class a {
    private JSONArray a;
    
    public JSONArray a() {
      return this.a;
    }
    
    public void a(JSONArray param1JSONArray) {
      this.a = param1JSONArray;
    }
  }
  
  public static class b {
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    public String a() {
      return this.e;
    }
    
    public void a(String param1String) {
      this.e = param1String;
    }
    
    public String b() {
      return this.d;
    }
    
    public void b(String param1String) {
      this.d = param1String;
    }
    
    public String c() {
      return this.a;
    }
    
    public void c(String param1String) {
      this.a = param1String;
    }
    
    public String d() {
      return this.b;
    }
    
    public void d(String param1String) {
      this.b = param1String;
    }
    
    public String e() {
      return this.c;
    }
    
    public void e(String param1String) {
      this.c = param1String;
    }
    
    public String f() {
      return j.a(this.e + this.d + this.c + this.b + "@Fdiwmxy7CBDDQNUI");
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */