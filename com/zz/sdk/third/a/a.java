package com.zz.sdk.third.a;

import com.zz.sdk.b.i;
import com.zz.sdk.third.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements i {
  private int a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private long e;
  
  private String f;
  
  private final Map g = new HashMap<Object, Object>();
  
  public a() {}
  
  public a(c paramc) {
    a(paramc);
  }
  
  public a(String paramString1, String paramString2, long paramLong) {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramLong;
  }
  
  public JSONObject a() {
    JSONObject jSONObject1 = new JSONObject();
    jSONObject1.put("typeInt", this.a);
    jSONObject1.put("tag", this.b);
    jSONObject1.put("uid", this.c);
    jSONObject1.put("accessToken", this.d);
    jSONObject1.put("expiresIn", this.e);
    jSONObject1.put("nickName", this.f);
    JSONObject jSONObject2 = new JSONObject();
    Map map = g();
    for (Map.Entry entry : map.entrySet())
      jSONObject2.put((String)entry.getKey(), entry.getValue()); 
    jSONObject1.put("extra", map);
    return jSONObject1;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(long paramLong) {
    this.e = paramLong;
  }
  
  public void a(c paramc) {
    this.b = paramc.a();
    this.a = paramc.d();
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public void a(String paramString, Object paramObject) {
    this.g.put(paramString, paramObject);
  }
  
  public void a(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optInt("typeInt", 0);
    this.b = paramJSONObject.optString("tag", "");
    this.c = paramJSONObject.optString("uid", "");
    this.d = paramJSONObject.optString("accessToken", "");
    this.e = paramJSONObject.optLong("expiresIn", 0L);
    this.f = paramJSONObject.optString("nickName", "");
    this.g.clear();
    paramJSONObject = paramJSONObject.optJSONObject("extra");
    if (paramJSONObject != null) {
      Iterator<String> iterator = paramJSONObject.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        a(str, paramJSONObject.opt(str));
      } 
    } 
  }
  
  public String b() {
    return "LoginResult";
  }
  
  public void b(String paramString) {
    this.c = paramString;
  }
  
  public String c() {
    return this.b;
  }
  
  public void c(String paramString) {
    this.d = paramString;
  }
  
  public String d() {
    return this.c;
  }
  
  public void d(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      a(jSONObject);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  public String e() {
    return this.d;
  }
  
  public void e(String paramString) {
    this.f = paramString;
  }
  
  public long f() {
    return this.e;
  }
  
  public Map g() {
    return this.g;
  }
  
  public int h() {
    return this.a;
  }
  
  public String i() {
    return this.f;
  }
  
  public String toString() {
    return "LoginResult{typeInt=" + this.a + ", tag='" + this.b + '\'' + ", uid='" + this.c + '\'' + ", accessToken='" + this.d + '\'' + ", expiresIn=" + this.e + ", extra=" + this.g + '}';
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */