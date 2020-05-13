package com.sdk.mobile.manager.login.a;

import java.io.Serializable;

public class h implements Serializable {
  private String a;
  
  private int b;
  
  private boolean c;
  
  private boolean d = true;
  
  public h() {}
  
  public h(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public int b() {
    return this.b;
  }
  
  public void b(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public boolean c() {
    return this.c;
  }
  
  public boolean d() {
    return this.d;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\login\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */