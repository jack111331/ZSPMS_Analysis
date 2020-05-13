package com.zz.sdk.b;

public class m {
  public static final String a = "a_pay";
  
  public static final String b = "id";
  
  public static final String c = "user";
  
  public static final String d = "a_ordernum";
  
  public static final String e = "a_time";
  
  public static final String f = "a_way";
  
  public static final String g = "status";
  
  public static final String h = "submitAmount";
  
  public String i;
  
  public String j;
  
  public String k;
  
  public String l;
  
  public String m;
  
  public String n;
  
  public String o;
  
  public m() {}
  
  public m(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramString3;
    this.l = paramString4;
    this.m = paramString5;
    this.n = paramString6;
  }
  
  public String a() {
    return this.i;
  }
  
  public void a(m paramm) {
    this.i = paramm.a();
    this.j = paramm.d();
    this.k = paramm.e();
    this.l = paramm.f();
    this.m = paramm.g();
    this.n = paramm.c();
  }
  
  public void a(String paramString) {
    this.n = paramString;
  }
  
  public String b() {
    return this.o;
  }
  
  public void b(String paramString) {
    this.o = paramString;
  }
  
  public String c() {
    return this.n;
  }
  
  public void c(String paramString) {
    this.i = paramString;
  }
  
  public String d() {
    return this.j;
  }
  
  public void d(String paramString) {
    this.j = paramString;
  }
  
  public String e() {
    return this.k;
  }
  
  public void e(String paramString) {
    this.k = paramString;
  }
  
  public String f() {
    return this.l;
  }
  
  public void f(String paramString) {
    this.l = paramString;
  }
  
  public String g() {
    return this.m;
  }
  
  public void g(String paramString) {
    this.m = paramString;
  }
  
  public String toString() {
    return "PayInfo[user=" + this.i + ", orderNum=" + this.j + ", orderTime=" + this.k + ", payWay=" + this.l + ", status=" + this.m + ",submitAmount=" + this.n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */