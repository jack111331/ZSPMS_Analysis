package com.sina.weibo.sdk.utils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
  public static Object getByArray(Object paramObject, int paramInt) {
    return Array.get(paramObject, paramInt);
  }
  
  public static Object getProperty(Object paramObject, String paramString) throws Exception {
    return paramObject.getClass().getField(paramString).get(paramObject);
  }
  
  public static Object getStaticProperty(String paramString1, String paramString2) throws Exception {
    Class<?> clazz = Class.forName(paramString1);
    return clazz.getField(paramString2).get(clazz);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      return paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    return null;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject) throws Exception {
    Class<?> clazz = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = paramArrayOfObject.length;
    for (byte b = 0;; b++) {
      if (b >= i)
        return clazz.getMethod(paramString, arrayOfClass).invoke(paramObject, paramArrayOfObject); 
      arrayOfClass[b] = paramArrayOfObject[b].getClass();
    } 
  }
  
  public static Object invokeParamsMethod(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Method method = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
    method.setAccessible(true);
    return method.invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object invokeStaticMethod(Class paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      return paramClass.getMethod(paramString, paramArrayOfClass).invoke(null, paramArrayOfObject);
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      return Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject) throws Exception {
    Class<?> clazz = Class.forName(paramString1);
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = paramArrayOfObject.length;
    for (byte b = 0;; b++) {
      if (b >= i)
        return clazz.getMethod(paramString2, arrayOfClass).invoke(null, paramArrayOfObject); 
      arrayOfClass[b] = paramArrayOfObject[b].getClass();
    } 
  }
  
  public static void invokeVoidMethod(Object paramObject, String paramString, boolean paramBoolean) {
    try {
      paramObject.getClass().getMethod(paramString, new Class[] { boolean.class }).invoke(paramObject, new Object[] { Boolean.valueOf(paramBoolean) });
    } catch (SecurityException|NoSuchMethodException|IllegalArgumentException|IllegalAccessException|InvocationTargetException securityException) {}
  }
  
  public static boolean isInstance(Object paramObject, Class paramClass) {
    return paramClass.isInstance(paramObject);
  }
  
  public static Object newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) throws Exception {
    return Class.forName(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */