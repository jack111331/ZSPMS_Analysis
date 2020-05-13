package com.alipay.a.a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;
import org.json.alipay.b;

public final class g implements i, j {
  public final Object a(Object paramObject) {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    Class<?> clazz = paramObject.getClass();
    for (Field[] arrayOfField = clazz.getDeclaredFields(); !clazz.equals(Object.class); arrayOfField = clazz.getDeclaredFields()) {
      if (arrayOfField != null && arrayOfField.length > 0) {
        int k = arrayOfField.length;
        for (byte b = 0; b < k; b++) {
          Object object;
          Field field = arrayOfField[b];
          if (field == null || paramObject == null) {
            object = null;
          } else if ("this$0".equals(field.getName())) {
            object = null;
          } else {
            boolean bool = field.isAccessible();
            field.setAccessible(true);
            object = field.get(paramObject);
            if (object == null) {
              object = null;
            } else {
              field.setAccessible(bool);
              object = f.b(object);
            } 
          } 
          if (object != null)
            treeMap.put(field.getName(), object); 
        } 
      } 
      clazz = clazz.getSuperclass();
    } 
    return treeMap;
  }
  
  public final Object a(Object paramObject, Type paramType) {
    if (!paramObject.getClass().equals(b.class))
      return null; 
    b b = (b)paramObject;
    paramObject = paramType;
    Type type = (Type)paramObject.newInstance();
    while (true) {
      Field[] arrayOfField;
      paramType = type;
      if (!paramObject.equals(Object.class)) {
        arrayOfField = paramObject.getDeclaredFields();
        if (arrayOfField != null && arrayOfField.length > 0) {
          int k = arrayOfField.length;
          for (byte b1 = 0; b1 < k; b1++) {
            Field field = arrayOfField[b1];
            String str = field.getName();
            Type type1 = field.getGenericType();
            if (b.b(str)) {
              field.setAccessible(true);
              field.set(type, e.a(b.a(str), type1));
            } 
          } 
        } 
        paramObject = paramObject.getSuperclass();
        continue;
      } 
      return arrayOfField;
    } 
  }
  
  public final boolean a(Class<?> paramClass) {
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */