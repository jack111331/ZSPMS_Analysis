package com.zz.sdk.b;

import java.io.Serializable;
import org.json.JSONObject;

public class d implements i, Serializable {
  static final String i = "uid";
  
  static final String j = "loginName";
  
  static final String k = "contactName";
  
  static final String l = "tel";
  
  static final String m = "serverId";
  
  static final String n = "serverName";
  
  static final String o = "roleId";
  
  static final String p = "roleName";
  
  private static final long q = -3537655438719591298L;
  
  public String a;
  
  public long b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public String g;
  
  public String h;
  
  public JSONObject a() {
    return null;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.optString("uid");
      this.b = paramJSONObject.optLong("loginName", -1L);
      this.c = paramJSONObject.optString("contactName");
      this.d = paramJSONObject.optString("tel");
      this.e = paramJSONObject.optString("serverId");
      this.f = paramJSONObject.optString("serverName");
      this.g = paramJSONObject.optString("roleId");
      this.h = paramJSONObject.optString("roleName");
    } 
  }
  
  public String b() {
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */