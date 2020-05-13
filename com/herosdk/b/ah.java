package com.herosdk.b;

import android.text.TextUtils;

public class ah {
  String a;
  
  String b;
  
  am c;
  
  int d;
  
  int e;
  
  boolean f;
  
  ak g;
  
  private boolean b() {
    null = false;
    if (this.a.regionMatches(true, 0, "http:", 0, 5)) {
      this.f = false;
    } else if (this.a.regionMatches(true, 0, "https:", 0, 6)) {
      this.f = true;
    } else {
      return null;
    } 
    return true;
  }
  
  private void c() {
    if (this.c != null && this.c.a().size() > 0) {
      if (this.a.contains("=")) {
        this.a += "&";
      } else {
        this.a += "?";
      } 
      this.a += this.c.toString();
    } 
  }
  
  public ae a() {
    if (TextUtils.isEmpty(this.a))
      throw new IllegalArgumentException("url不能为空"); 
    if (!b())
      throw new IllegalArgumentException("url不合法:" + this.a); 
    if (this.b.equalsIgnoreCase("GET"))
      c(); 
    if (this.d <= 0)
      this.d = 10000; 
    if (this.e <= 0)
      this.e = 10000; 
    return new ae(this);
  }
  
  public ah a(int paramInt) {
    this.d = paramInt;
    return this;
  }
  
  public ah a(ak paramak) {
    this.g = paramak;
    return this;
  }
  
  public ah a(am paramam) {
    this.c = paramam;
    return this;
  }
  
  public ah a(String paramString) {
    this.a = paramString;
    return this;
  }
  
  public ah b(int paramInt) {
    this.e = paramInt;
    return this;
  }
  
  public ah b(String paramString) {
    this.b = paramString;
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */