package com.unionpay.sdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class al {
  private final Object a;
  
  private final Method b;
  
  private final int c;
  
  private boolean d = true;
  
  al(Object paramObject, Method paramMethod) {
    if (paramObject == null)
      throw new NullPointerException("EventHandler target cannot be null."); 
    if (paramMethod == null)
      throw new NullPointerException("EventHandler method cannot be null."); 
    this.a = paramObject;
    this.b = paramMethod;
    paramMethod.setAccessible(true);
    this.c = (paramMethod.hashCode() + 31) * 31 + paramObject.hashCode();
  }
  
  public final boolean a() {
    return this.d;
  }
  
  public final void b() {
    this.d = false;
  }
  
  public final boolean equals(Object paramObject) {
    boolean bool = true;
    if (this != paramObject) {
      if (paramObject == null)
        return false; 
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (!this.b.equals(((al)paramObject).b) || this.a != ((al)paramObject).a)
        bool = false; 
    } 
    return bool;
  }
  
  public final void handleEvent(Object paramObject) {
    if (!this.d)
      throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events."); 
    try {
      this.b.invoke(this.a, new Object[] { paramObject });
      return;
    } catch (IllegalAccessException illegalAccessException) {
      throw new AssertionError(illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      if (invocationTargetException.getCause() instanceof Error)
        throw (Error)invocationTargetException.getCause(); 
      throw invocationTargetException;
    } 
  }
  
  public final int hashCode() {
    return this.c;
  }
  
  public final String toString() {
    return "[EventHandler " + this.b + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */