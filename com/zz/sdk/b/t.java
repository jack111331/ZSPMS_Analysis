package com.zz.sdk.b;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class t implements i, Serializable {
  static final String a = "serverId";
  
  static final String b = "serverName";
  
  static final String c = "roleId";
  
  static final String d = "roleName";
  
  static final String e = "roleAvatar";
  
  public String f;
  
  public String g;
  
  public String h;
  
  public String i;
  
  public String j;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("serverId", this.f);
      jSONObject.put("serverName", this.g);
      jSONObject.put("roleId", this.h);
      jSONObject.put("roleName", this.i);
      jSONObject.put("roleAvatar", this.j);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    return (JSONObject)jSONException;
  }
  
  public void a(String paramString) {
    this.f = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public String b() {
    return "role";
  }
  
  public void b(String paramString) {
    this.g = paramString;
  }
  
  public String c() {
    try {
      String str = a().toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
  
  public void c(String paramString) {
    this.h = paramString;
  }
  
  public String d() {
    return this.f;
  }
  
  public void d(String paramString) {
    this.j = paramString;
  }
  
  public String e() {
    return this.g;
  }
  
  public void e(String paramString) {
    this.i = paramString;
  }
  
  public String f() {
    return this.h;
  }
  
  public String g() {
    return this.i;
  }
  
  public String h() {
    return this.j;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */