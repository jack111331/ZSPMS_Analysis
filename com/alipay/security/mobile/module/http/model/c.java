package com.alipay.security.mobile.module.http.model;

import com.alipay.security.mobile.module.a.a;

public final class c extends a {
  public static final int c = 1;
  
  public static final int d = 2;
  
  public static final int e = 3;
  
  public static final String f = "APPKEY_ERROR";
  
  public static final String g = "SUCCESS";
  
  public String h;
  
  public String i;
  
  public String j;
  
  public String k;
  
  public String l;
  
  public String m;
  
  public String n;
  
  public String o;
  
  public String p = "";
  
  private String a() {
    return this.p;
  }
  
  private void a(String paramString) {
    this.p = paramString;
  }
  
  private int b() {
    byte b = 2;
    if (this.a) {
      if (!a.a(this.h))
        b = 1; 
      return b;
    } 
    if ("APPKEY_ERROR".equals(this.b))
      b = 3; 
    return b;
  }
  
  private void b(String paramString) {
    this.h = paramString;
  }
  
  private void c(String paramString) {
    this.i = paramString;
  }
  
  private boolean c() {
    return "1".equals(this.j);
  }
  
  private String d() {
    return (this.k == null) ? "0" : this.k;
  }
  
  private void d(String paramString) {
    this.j = paramString;
  }
  
  private String e() {
    return this.h;
  }
  
  private void e(String paramString) {
    this.k = paramString;
  }
  
  private String f() {
    return this.i;
  }
  
  private void f(String paramString) {
    this.l = paramString;
  }
  
  private String g() {
    return this.j;
  }
  
  private void g(String paramString) {
    this.n = paramString;
  }
  
  private String h() {
    return this.l;
  }
  
  private void h(String paramString) {
    this.m = paramString;
  }
  
  private String i() {
    return this.n;
  }
  
  private void i(String paramString) {
    this.o = paramString;
  }
  
  private String j() {
    return this.m;
  }
  
  private String k() {
    return this.o;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\http\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */