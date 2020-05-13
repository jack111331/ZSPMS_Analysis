package com.alipay.a.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.a;

public final class k implements i {
  public final Object a(Object<Object> paramObject, Type paramType) {
    byte b = 0;
    if (!paramObject.getClass().equals(a.class))
      return null; 
    a a = (a)paramObject;
    HashSet hashSet = new HashSet();
    if (paramType instanceof ParameterizedType) {
      paramObject = (Object<Object>)((ParameterizedType)paramType).getActualTypeArguments()[0];
    } else {
      paramObject = (Object<Object>)Object.class;
    } 
    while (b < a.a()) {
      hashSet.add(e.a(a.a(b), (Type)paramObject));
      b++;
    } 
    return hashSet;
  }
  
  public final boolean a(Class<?> paramClass) {
    return Set.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\a\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */