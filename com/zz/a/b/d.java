package com.zz.a.b;

import com.zz.a.c.e;
import java.io.Serializable;
import org.json.JSONObject;

class d extends b implements Serializable {
  private static final long K = -2713534923923387744L;
  
  private static final String L = "a";
  
  private static final String M = "b";
  
  private static final String N = "c";
  
  private static final String O = "d";
  
  private static final String P = "e";
  
  private static final String Q = "f";
  
  private static final String R = "g";
  
  private static final String S = "h";
  
  private static final String T = "i";
  
  private static final String U = "j";
  
  private static final String V = "k";
  
  private static final String W = "l";
  
  private static final String X = "m";
  
  private static final String Y = "n";
  
  private static final String Z = "o";
  
  private static final String aa = "p";
  
  private static final String ab = "q";
  
  private static final String ac = "r";
  
  private static final String ad = "s";
  
  private static final String ae = "t";
  
  private static final String af = "u";
  
  private static final String ag = "v";
  
  private static final String ah = "w";
  
  private static final String ai = "x";
  
  private static final String aj = "y";
  
  private static final String ak = "z";
  
  public static final int d = 1;
  
  public static final int e = 0;
  
  public String A;
  
  public String B;
  
  public int C;
  
  public String D;
  
  public String E;
  
  public int F;
  
  public String G;
  
  public String H;
  
  public String I;
  
  public String J;
  
  public String a = "";
  
  public String b = "";
  
  public String c = "";
  
  public String f;
  
  public String g;
  
  public String h;
  
  public String i;
  
  public String j;
  
  public String k;
  
  public int l;
  
  public String m;
  
  public int n;
  
  public String o;
  
  public String p;
  
  public String q;
  
  public int r;
  
  public int s;
  
  public int t;
  
  public int u;
  
  public String v;
  
  public String w;
  
  public int x;
  
  public String y;
  
  public int z;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      a(jSONObject, "a", this.f);
      a(jSONObject, "b", this.g);
      a(jSONObject, "c", this.h);
      a(jSONObject, "d", this.i);
      a(jSONObject, "e", this.j);
      a(jSONObject, "f", this.k);
      a(jSONObject, "g", this.l);
      a(jSONObject, "h", this.m);
      a(jSONObject, "i", this.n);
      a(jSONObject, "j", this.o);
      a(jSONObject, "k", this.p);
      a(jSONObject, "l", this.q);
      a(jSONObject, "m", this.r);
      a(jSONObject, "n", this.s);
      a(jSONObject, "o", this.t);
      a(jSONObject, "p", this.u);
      a(jSONObject, "q", this.v);
      a(jSONObject, "r", this.w);
      a(jSONObject, "s", this.x);
      a(jSONObject, "t", this.y);
      a(jSONObject, "u", this.z);
      a(jSONObject, "v", this.A);
      a(jSONObject, "w", this.B);
      a(jSONObject, "x", this.C);
      a(jSONObject, "y", this.D);
      a(jSONObject, "z", this.E);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(String paramString) {
    try {
      this.E = e.a(new String[] { this.f, this.g, String.valueOf(this.n), this.D, paramString });
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      try {
        this.f = c(paramJSONObject, "a");
        this.g = c(paramJSONObject, "b");
        this.h = c(paramJSONObject, "c");
        this.i = c(paramJSONObject, "d");
        this.j = c(paramJSONObject, "e");
        this.k = c(paramJSONObject, "f");
        this.l = a(paramJSONObject, "g");
        this.m = c(paramJSONObject, "h");
        this.n = a(paramJSONObject, "i");
        this.o = c(paramJSONObject, "j");
        this.p = c(paramJSONObject, "k");
        this.q = c(paramJSONObject, "l");
        this.r = a(paramJSONObject, "m");
        this.s = a(paramJSONObject, "n");
        this.t = a(paramJSONObject, "o");
        this.u = a(paramJSONObject, "p");
        this.v = c(paramJSONObject, "q");
        this.w = c(paramJSONObject, "r");
        this.x = a(paramJSONObject, "s");
        this.y = c(paramJSONObject, "t");
        this.z = a(paramJSONObject, "u");
        this.A = c(paramJSONObject, "v");
        this.B = c(paramJSONObject, "w");
        this.C = a(paramJSONObject, "x");
        this.D = c(paramJSONObject, "y");
        this.E = c(paramJSONObject, "z");
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public String b() {
    return "b";
  }
  
  public int c() {
    return 2;
  }
  
  public String toString() {
    return "register [account=" + this.f + ", md5pwd=" + this.g + ", bindMobile=" + this.h + ", bindEmail" + this.i + ", nickName" + this.j + ",email" + this.k + ",sex" + this.l + ",imageUrl" + this.m + ",type=" + this.n + ",deviceParams=" + this.o + ",product=" + this.p + ",networkInfo=" + this.q + ",gatewaytype=" + this.r + ",,densityDpi=" + this.s + ",displayScreenWidth=" + this.t + ",displayScreenHeight=" + this.u + ",regIP=" + this.v + ",douId=" + this.w + ",productId=" + this.x + ",imsi=" + this.y + ",channelId=" + this.z + ",versionName=" + this.A + ", isFast=" + this.C + ", app_secret" + this.D + ", sign" + this.E + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */