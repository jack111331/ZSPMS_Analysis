package com.litesuits.orm.db.utils;

import com.litesuits.orm.db.annotation.MapCollection;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;

public class ClassUtil {
  public static Object getDefaultPrimiticeValue(Class<boolean> paramClass) {
    if (paramClass.isPrimitive()) {
      Integer integer;
      if (paramClass == boolean.class) {
        Boolean bool = Boolean.valueOf(false);
      } else {
        integer = Integer.valueOf(0);
      } 
      return integer;
    } 
    return null;
  }
  
  public static boolean isArray(Class paramClass) {
    return paramClass.isArray();
  }
  
  public static boolean isBaseDataType(Class<?> paramClass) {
    return (paramClass.isPrimitive() || paramClass.equals(String.class) || paramClass.equals(Boolean.class) || paramClass.equals(Integer.class) || paramClass.equals(Long.class) || paramClass.equals(Float.class) || paramClass.equals(Double.class) || paramClass.equals(Byte.class) || paramClass.equals(Character.class) || paramClass.equals(Short.class) || paramClass.equals(Date.class) || paramClass.equals(byte[].class) || paramClass.equals(Byte[].class));
  }
  
  public static boolean isCollection(Class<?> paramClass) {
    return Collection.class.isAssignableFrom(paramClass);
  }
  
  public static Object newArray(Class<?> paramClass, int paramInt) {
    return Array.newInstance(paramClass, paramInt);
  }
  
  public static Object newCollection(Class<?> paramClass) throws IllegalAccessException, InstantiationException {
    return paramClass.newInstance();
  }
  
  public static Object newCollectionForField(Field paramField) throws IllegalAccessException, InstantiationException {
    MapCollection mapCollection = paramField.<MapCollection>getAnnotation(MapCollection.class);
    return (mapCollection == null) ? paramField.getType().newInstance() : mapCollection.value().newInstance();
  }
  
  public static <T> T newInstance(Class<T> paramClass) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor[] arrayOfConstructor = (Constructor[])paramClass.getDeclaredConstructors();
    if (arrayOfConstructor.length > 0) {
      byte b = 0;
      Constructor<T> constructor = arrayOfConstructor[0];
      Class[] arrayOfClass = constructor.getParameterTypes();
      if (arrayOfClass.length == 0) {
        constructor.setAccessible(true);
        return constructor.newInstance(new Object[0]);
      } 
      Object[] arrayOfObject = new Object[arrayOfClass.length];
      while (b < arrayOfClass.length) {
        arrayOfObject[b] = getDefaultPrimiticeValue(arrayOfClass[b]);
        b++;
      } 
      constructor.setAccessible(true);
      return constructor.newInstance(arrayOfObject);
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\d\\utils\ClassUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */