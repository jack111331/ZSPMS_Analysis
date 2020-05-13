package com.litesuits.orm.db.utils;

import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.model.Primarykey;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class FieldUtil {
  public static Object get(Field paramField, Object paramObject) throws IllegalArgumentException, IllegalAccessException {
    paramField.setAccessible(true);
    return paramField.get(paramObject);
  }
  
  public static List<Field> getAllDeclaredFields(Class<?> paramClass) {
    LinkedList<Field> linkedList = new LinkedList();
    while (paramClass != null && paramClass != Object.class) {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      for (byte b = 0; b < arrayOfField.length; b++) {
        Field field = arrayOfField[b];
        if (!isInvalid(field))
          linkedList.addLast(field); 
      } 
      paramClass = paramClass.getSuperclass();
    } 
    return linkedList;
  }
  
  public static Object getAssignedKeyObject(Primarykey paramPrimarykey, Object paramObject) throws IllegalArgumentException, IllegalAccessException {
    paramObject = get(paramPrimarykey.field, paramObject);
    return (paramPrimarykey.isAssignedByMyself() || (paramPrimarykey.isAssignedBySystem() && paramObject != null && ((Number)paramObject).longValue() > 0L)) ? paramObject : null;
  }
  
  public static Class<?> getComponentType(Field paramField) {
    return paramField.getType().getComponentType();
  }
  
  public static Class<?> getGenericType(Field paramField) {
    Type type = paramField.getGenericType();
    if (type instanceof ParameterizedType) {
      type = ((ParameterizedType)type).getActualTypeArguments()[0];
      if (type instanceof Class)
        return (Class)type; 
    } else if (type instanceof Class) {
      return (Class)type;
    } 
    return null;
  }
  
  public static boolean isIgnored(Field paramField) {
    boolean bool;
    if (paramField.getAnnotation(Ignore.class) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isInteger(Field paramField) {
    return (paramField.getType() == int.class || paramField.getType() != Integer.class);
  }
  
  public static boolean isInvalid(Field paramField) {
    return ((Modifier.isStatic(paramField.getModifiers()) && Modifier.isFinal(paramField.getModifiers())) || isIgnored(paramField) || paramField.isSynthetic());
  }
  
  public static boolean isLong(Field paramField) {
    return (paramField.getType() == long.class || paramField.getType() == Long.class);
  }
  
  public static boolean isNumber(Class<?> paramClass) {
    return (paramClass == long.class || paramClass == Long.class || paramClass == int.class || paramClass == Integer.class || paramClass == short.class || paramClass == Short.class || paramClass == byte.class || paramClass == Byte.class);
  }
  
  public static boolean isSerializable(Field paramField) {
    Class[] arrayOfClass = paramField.getType().getInterfaces();
    int i = arrayOfClass.length;
    for (byte b = 0; b < i; b++) {
      if (Serializable.class == arrayOfClass[b])
        return true; 
    } 
    return false;
  }
  
  public static void set(Field paramField, Object paramObject1, Object paramObject2) throws IllegalArgumentException, IllegalAccessException {
    paramField.setAccessible(true);
    paramField.set(paramObject1, paramObject2);
  }
  
  public static boolean setKeyValueIfneed(Object paramObject1, Primarykey paramPrimarykey, Object paramObject2, long paramLong) throws IllegalArgumentException, IllegalAccessException {
    if (paramPrimarykey != null && paramPrimarykey.isAssignedBySystem() && (paramObject2 == null || ((Number)paramObject2).longValue() < 1L)) {
      setNumber(paramObject1, paramPrimarykey.field, paramLong);
      return true;
    } 
    return false;
  }
  
  public static void setNumber(Object paramObject, Field paramField, long paramLong) throws IllegalAccessException {
    paramField.setAccessible(true);
    Class<?> clazz = paramField.getType();
    if (clazz == long.class) {
      paramField.setLong(paramObject, paramLong);
    } else if (clazz == int.class) {
      paramField.setInt(paramObject, (int)paramLong);
    } else if (clazz == short.class) {
      paramField.setShort(paramObject, (short)(int)paramLong);
    } else if (clazz == byte.class) {
      paramField.setByte(paramObject, (byte)(int)paramLong);
    } else if (clazz == Long.class) {
      paramField.set(paramObject, new Long(paramLong));
    } else if (clazz == Integer.class) {
      paramField.set(paramObject, new Integer((int)paramLong));
    } else if (clazz == Short.class) {
      paramField.set(paramObject, new Short((short)(int)paramLong));
    } else {
      if (clazz == Byte.class) {
        paramField.set(paramObject, new Byte((byte)(int)paramLong));
        return;
      } 
      throw new RuntimeException("field is not a number class");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\d\\utils\FieldUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */