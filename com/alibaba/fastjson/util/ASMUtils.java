package com.alibaba.fastjson.util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ASMUtils {
  public static final boolean IS_ANDROID;
  
  public static final String JAVA_VM_NAME = System.getProperty("java.vm.name");
  
  static {
    IS_ANDROID = isAndroid(JAVA_VM_NAME);
  }
  
  public static boolean checkName(String paramString) {
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (c < '\001' || c > '' || c == '.')
        return false; 
    } 
    return true;
  }
  
  public static String desc(Class<?> paramClass) {
    if (paramClass.isPrimitive())
      return getPrimitiveLetter(paramClass); 
    if (paramClass.isArray()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[");
      stringBuilder1.append(desc(paramClass.getComponentType()));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("L");
    stringBuilder.append(type(paramClass));
    stringBuilder.append(";");
    return stringBuilder.toString();
  }
  
  public static String desc(Method paramMethod) {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuilder stringBuilder = new StringBuilder(arrayOfClass.length + 1 << 4);
    stringBuilder.append('(');
    for (byte b = 0; b < arrayOfClass.length; b++)
      stringBuilder.append(desc(arrayOfClass[b])); 
    stringBuilder.append(')');
    stringBuilder.append(desc(paramMethod.getReturnType()));
    return stringBuilder.toString();
  }
  
  public static Type getMethodType(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getMethod(paramString, new Class[0]).getGenericReturnType();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String getPrimitiveLetter(Class<?> paramClass) {
    if (int.class == paramClass)
      return "I"; 
    if (void.class == paramClass)
      return "V"; 
    if (boolean.class == paramClass)
      return "Z"; 
    if (char.class == paramClass)
      return "C"; 
    if (byte.class == paramClass)
      return "B"; 
    if (short.class == paramClass)
      return "S"; 
    if (float.class == paramClass)
      return "F"; 
    if (long.class == paramClass)
      return "J"; 
    if (double.class == paramClass)
      return "D"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Type: ");
    stringBuilder.append(paramClass.getCanonicalName());
    stringBuilder.append(" is not a primitive type");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public static boolean isAndroid(String paramString) {
    boolean bool = false;
    if (paramString == null)
      return false; 
    paramString = paramString.toLowerCase();
    if (paramString.contains("dalvik") || paramString.contains("lemur"))
      bool = true; 
    return bool;
  }
  
  public static String type(Class<?> paramClass) {
    if (paramClass.isArray()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(desc(paramClass.getComponentType()));
      return stringBuilder.toString();
    } 
    return !paramClass.isPrimitive() ? paramClass.getName().replace('.', '/') : getPrimitiveLetter(paramClass);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\ASMUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */