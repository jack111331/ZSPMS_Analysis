package com.sdk.mobile.manager.login.a;

import java.io.Serializable;

public class c implements Serializable {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private boolean e = true;
  
  public c() {}
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramBoolean;
  }
  
  public int a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public int b() {
    return this.b;
  }
  
  public void b(int paramInt) {
    this.b = paramInt;
  }
  
  public int c() {
    return this.c;
  }
  
  public void c(int paramInt) {
    this.c = paramInt;
  }
  
  public int d() {
    return this.d;
  }
  
  public void d(int paramInt) {
    this.d = paramInt;
  }
  
  public boolean e() {
    return this.e;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\login\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */