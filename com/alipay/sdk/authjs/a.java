package com.alipay.sdk.authjs;

import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  public static final String a = "CallInfo";
  
  public static final String b = "call";
  
  public static final String c = "callback";
  
  public static final String d = "bundleName";
  
  public static final String e = "clientId";
  
  public static final String f = "param";
  
  public static final String g = "func";
  
  public static final String h = "msgType";
  
  public String i;
  
  public String j;
  
  public String k;
  
  public String l;
  
  public JSONObject m;
  
  private boolean n = false;
  
  public a(String paramString) {
    this.l = paramString;
  }
  
  private static String a(int paramInt) {
    switch (b.a[paramInt - 1]) {
      default:
        return "none";
      case 1:
        return "function not found";
      case 2:
        return "invalid parameter";
      case 3:
        break;
    } 
    return "runtime error";
  }
  
  private void a(String paramString) {
    this.i = paramString;
  }
  
  private void a(JSONObject paramJSONObject) {
    this.m = paramJSONObject;
  }
  
  private void a(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  private boolean a() {
    return this.n;
  }
  
  private String b() {
    return this.i;
  }
  
  private void b(String paramString) {
    this.j = paramString;
  }
  
  private String c() {
    return this.j;
  }
  
  private void c(String paramString) {
    this.k = paramString;
  }
  
  private String d() {
    return this.k;
  }
  
  private void d(String paramString) {
    this.l = paramString;
  }
  
  private String e() {
    return this.l;
  }
  
  private JSONObject f() {
    return this.m;
  }
  
  private String g() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("clientId", this.i);
    jSONObject.put("func", this.k);
    jSONObject.put("param", this.m);
    jSONObject.put("msgType", this.l);
    return jSONObject.toString();
  }
  
  public enum a {
    a, b, c, d, e;
    
    public static int[] a() {
      return (int[])f.clone();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\authjs\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */