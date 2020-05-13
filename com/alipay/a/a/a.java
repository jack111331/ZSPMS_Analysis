package com.alipay.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a implements i, j {
  public final Object a(Object paramObject) {
    paramObject = paramObject;
    ArrayList<Object> arrayList = new ArrayList();
    int k = paramObject.length;
    for (byte b = 0; b < k; b++)
      arrayList.add(f.b(paramObject[b])); 
    return arrayList;
  }
  
  public final Object a(Object paramObject, Type paramType) {
    if (!paramObject.getClass().equals(org.json.alipay.a.class))
      return null; 
    org.json.alipay.a a1 = (org.json.alipay.a)paramObject;
    if (paramType instanceof java.lang.reflect.GenericArrayType)
      throw new IllegalArgumentException("Does not support generic array!"); 
    Class<?> clazz = ((Class)paramType).getComponentType();
    int k = a1.a();
    Object object = Array.newInstance(clazz, k);
    byte b = 0;
    while (true) {
      paramObject = object;
      if (b < k) {
        Array.set(object, b, e.a(a1.a(b), clazz));
        b++;
        continue;
      } 
      return paramObject;
    } 
  }
  
  public final boolean a(Class<?> paramClass) {
    return paramClass.isArray();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */