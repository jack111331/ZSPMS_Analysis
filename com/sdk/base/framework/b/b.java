package com.sdk.base.framework.b;

import com.sdk.base.framework.a.f;

public abstract class b<T> {
  private int a = 1000;
  
  public final int a() {
    int i = 200;
    if (this.a >= 200)
      i = this.a; 
    return i;
  }
  
  public abstract void a(int paramInt, Object paramObject);
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public abstract void a(f<T> paramf, String paramString);
  
  public void b() {}
  
  public void c() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */