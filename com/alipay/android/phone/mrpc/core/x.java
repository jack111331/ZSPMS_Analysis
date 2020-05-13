package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

public final class x {
  private g a;
  
  private z b;
  
  public x(g paramg) {
    this.a = paramg;
    this.b = new z(this);
  }
  
  public final g a() {
    return this.a;
  }
  
  public final <T> T a(Class<T> paramClass) {
    ClassLoader classLoader = paramClass.getClassLoader();
    y y = new y(this.a, paramClass, this.b);
    return (T)Proxy.newProxyInstance(classLoader, new Class[] { paramClass }, y);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */