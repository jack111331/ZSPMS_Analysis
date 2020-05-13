package com.zz.a.b;

import com.zz.a.c.e;
import java.io.Serializable;
import org.json.JSONObject;

class c extends b implements Serializable {
  public static final int a = 1;
  
  public static final int b = 2;
  
  public static final int c = 3;
  
  public static final int d = 4;
  
  public static final int e = 1;
  
  public static final int f = 2;
  
  public static final int g = 3;
  
  private static final long o = 965609947231704326L;
  
  private static final String p = "a";
  
  private static final String q = "b";
  
  private static final String r = "c";
  
  private static final String s = "d";
  
  private static final String t = "f";
  
  private static final String u = "y";
  
  private static final String v = "z";
  
  public String h;
  
  public String i;
  
  public int j;
  
  public int k = 0;
  
  public String l;
  
  public String m;
  
  public String n;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      a(jSONObject, "a", this.h);
      a(jSONObject, "b", this.i);
      a(jSONObject, "c", this.j);
      a(jSONObject, "d", this.k);
      a(jSONObject, "f", this.l);
      a(jSONObject, "y", this.m);
      a(jSONObject, "z", this.n);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(String paramString) {
    try {
      this.n = e.a(new String[] { this.h, this.i, String.valueOf(this.j), String.valueOf(this.k), this.m, paramString });
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      try {
        this.h = c(paramJSONObject, "a");
        this.i = c(paramJSONObject, "b");
        this.j = a(paramJSONObject, "c");
        this.k = a(paramJSONObject, "d");
        this.l = c(paramJSONObject, "f");
        this.m = c(paramJSONObject, "y");
        this.n = c(paramJSONObject, "z");
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public String b() {
    return "a";
  }
  
  public int c() {
    return 1;
  }
  
  public String toString() {
    return "Login [account=" + this.h + ", md5pwd=" + this.i + ", atype=" + this.j + ", dtype" + this.k + ", lastIP" + this.l + ", app_secret" + this.m + ", sign" + this.n + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */