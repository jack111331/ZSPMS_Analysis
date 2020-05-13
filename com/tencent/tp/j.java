package com.tencent.tp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class j {
  public static Object a(Class paramClass, String paramString, Object paramObject, Class[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, IllegalAccessException {
    return paramClass.getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object a(String paramString1, Object paramObject, String paramString2) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Field field = Class.forName(paramString1).getDeclaredField(paramString2);
    field.setAccessible(true);
    return field.get(paramObject);
  }
  
  public static Object a(String paramString1, String paramString2) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Field field = Class.forName(paramString1).getDeclaredField(paramString2);
    field.setAccessible(true);
    return field.get(null);
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, IllegalAccessException {
    return Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, IllegalAccessException {
    return Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Field field = Class.forName(paramString1).getDeclaredField(paramString2);
    field.setAccessible(true);
    field.set(null, paramObject);
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Field field = Class.forName(paramString1).getDeclaredField(paramString2);
    field.setAccessible(true);
    field.set(paramObject1, paramObject2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */