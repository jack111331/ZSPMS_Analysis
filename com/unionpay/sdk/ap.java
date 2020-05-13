package com.unionpay.sdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class ap implements InvocationHandler {
  ap(i parami, Object paramObject) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
    this.a.a(paramObject, paramMethod, paramArrayOfObject);
    Object object = paramMethod.invoke(this.b, paramArrayOfObject);
    this.a.a(paramObject, paramMethod, paramArrayOfObject, object);
    return object;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */