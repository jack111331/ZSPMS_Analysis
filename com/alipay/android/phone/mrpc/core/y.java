package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class y implements InvocationHandler {
  protected g a;
  
  protected Class<?> b;
  
  protected z c;
  
  public y(g paramg, Class<?> paramClass, z paramz) {
    this.a = paramg;
    this.b = paramClass;
    this.c = paramz;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
    return this.c.a(paramMethod, paramArrayOfObject);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */