package com.zz.a.b;

import java.io.Serializable;
import org.json.JSONObject;

public class e extends b implements Serializable {
  private static final String A = "k";
  
  private static final String B = "z";
  
  public static final int a = 0;
  
  public static final int b = -1;
  
  public static final int c = -2;
  
  private static final long p = 5780667638751697330L;
  
  private static final String q = "a";
  
  private static final String r = "b";
  
  private static final String s = "c";
  
  private static final String t = "d";
  
  private static final String u = "e";
  
  private static final String v = "f";
  
  private static final String w = "g";
  
  private static final String x = "h";
  
  private static final String y = "i";
  
  private static final String z = "j";
  
  public int d;
  
  public String e;
  
  public String f;
  
  public int g = 0;
  
  public String h;
  
  public String i;
  
  public String j;
  
  public int k;
  
  public String l;
  
  public int m;
  
  public int n;
  
  public String o;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("a", this.d);
      a(jSONObject, "b", this.e);
      a(jSONObject, "c", this.f);
      a(jSONObject, "d", this.g);
      a(jSONObject, "e", this.h);
      a(jSONObject, "f", this.i);
      a(jSONObject, "g", this.j);
      a(jSONObject, "h", this.k);
      a(jSONObject, "i", this.l);
      a(jSONObject, "j", this.m);
      a(jSONObject, "k", this.n);
      a(jSONObject, "z", this.o);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      try {
        this.d = a(paramJSONObject, "a");
        this.e = c(paramJSONObject, "b");
        this.f = c(paramJSONObject, "c");
        this.g = a(paramJSONObject, "d");
        this.h = c(paramJSONObject, "e");
        this.i = c(paramJSONObject, "f");
        this.j = c(paramJSONObject, "g");
        this.k = a(paramJSONObject, "h");
        this.l = c(paramJSONObject, "i");
        if (paramJSONObject.has("j"))
          this.m = paramJSONObject.getInt("j"); 
        if (paramJSONObject.has("k"))
          this.n = paramJSONObject.getInt("k"); 
        this.o = c(paramJSONObject, "z");
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public boolean a(String... paramVarArgs) {
    if (this.o != null)
      try {
        String str = com.zz.a.c.e.a(paramVarArgs);
        return this.o.equals(str);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  public String b() {
    return "r";
  }
  
  public int c() {
    return 0;
  }
  
  public String toString() {
    return "Result [status=" + this.d + ", descr=" + this.e + ", account=" + this.f + ", userid" + this.g + ", time" + this.h + ", bindMobile" + this.i + ", bindEmail" + this.j + ", sign" + this.o + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */