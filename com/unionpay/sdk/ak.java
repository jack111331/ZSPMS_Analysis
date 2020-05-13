package com.unionpay.sdk;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class ak {
  private static final Map a = new HashMap<Object, Object>();
  
  static Map a(Object paramObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      Class<?> clazz = paramObject.getClass();
      if (!a.containsKey(clazz))
        a(clazz); 
      Map map = (Map)a.get(clazz);
      if (map != null && !map.isEmpty()) {
        Iterator<Map.Entry> iterator = map.entrySet().iterator();
        while (true) {
          Map.Entry entry;
          HashSet<al> hashSet;
          if (iterator.hasNext()) {
            entry = iterator.next();
            hashSet = new HashSet();
            this();
            for (Method method : entry.getValue()) {
              al al = new al();
              this(paramObject, method);
              hashSet.add(al);
            } 
          } else {
            return hashMap;
          } 
          hashMap.put(entry.getKey(), hashSet);
        } 
      } 
    } catch (Throwable throwable) {}
    return hashMap;
  }
  
  private static void a(Class<?> paramClass) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Method method : paramClass.getDeclaredMethods()) {
      if (method.getName().startsWith("onTDEBEvent") && (method.getParameterTypes()).length == 1) {
        Class[] arrayOfClass = method.getParameterTypes();
        if (arrayOfClass.length != 1)
          throw new IllegalArgumentException("Method " + method + " must have one and only one argument."); 
        Class clazz = arrayOfClass[0];
        if (clazz.isInterface())
          throw new IllegalArgumentException("Method " + method + " must have a argument whose type is a class which can be instantialized."); 
        if ((method.getModifiers() & 0x1) == 0)
          throw new IllegalArgumentException("Method " + method + " must be 'public'."); 
        Set<Method> set2 = (Set)hashMap.get(clazz);
        Set<Method> set1 = set2;
        if (set2 == null) {
          set1 = new HashSet();
          hashMap.put(clazz, set1);
        } 
        set1.add(method);
      } 
    } 
    a.put(paramClass, hashMap);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */