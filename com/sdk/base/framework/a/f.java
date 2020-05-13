package com.sdk.base.framework.a;

public final class f<T> {
  private int a;
  
  private T b;
  
  private final boolean c;
  
  public f(int paramInt, T paramT, boolean paramBoolean) {
    this.a = paramInt;
    this.b = paramT;
    this.c = paramBoolean;
  }
  
  public int a() {
    return this.a;
  }
  
  public T b() {
    return this.b;
  }
  
  public String toString() {
    return "{code:" + this.a + ", response:" + this.b + ", resultFormCache:" + this.c + "}";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */