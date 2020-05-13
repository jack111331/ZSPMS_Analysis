package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo implements Comparable<FieldInfo> {
  public final String[] alternateNames;
  
  public final Class<?> declaringClass;
  
  public final Field field;
  
  public final boolean fieldAccess;
  
  private final JSONField fieldAnnotation;
  
  public final Class<?> fieldClass;
  
  public final boolean fieldTransient;
  
  public final Type fieldType;
  
  public final String format;
  
  public final boolean getOnly;
  
  public final boolean isEnum;
  
  public final boolean jsonDirect;
  
  public final String label;
  
  public final Method method;
  
  private final JSONField methodAnnotation;
  
  public final String name;
  
  public final char[] name_chars;
  
  private int ordinal;
  
  public final int parserFeatures;
  
  public final int serialzeFeatures;
  
  public final boolean unwrapped;
  
  public FieldInfo(String paramString, Class<?> paramClass1, Class<?> paramClass2, Type paramType, Field paramField, int paramInt1, int paramInt2, int paramInt3) {
    this.ordinal = 0;
    this.name = paramString;
    this.declaringClass = paramClass1;
    this.fieldClass = paramClass2;
    this.fieldType = paramType;
    this.method = null;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.serialzeFeatures = paramInt2;
    this.parserFeatures = 0;
    this.isEnum = paramClass2.isEnum();
    if (paramField != null) {
      boolean bool;
      paramInt1 = paramField.getModifiers();
      if ((paramInt1 & 0x1) != 0 || this.method == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.fieldAccess = bool;
      this.fieldTransient = Modifier.isTransient(paramInt1);
    } else {
      this.fieldTransient = false;
      this.fieldAccess = false;
    } 
    this.name_chars = genFieldNameChars();
    if (paramField != null)
      TypeUtils.setAccessible(paramField); 
    this.label = "";
    this.fieldAnnotation = null;
    this.methodAnnotation = null;
    this.getOnly = false;
    this.jsonDirect = false;
    this.unwrapped = false;
    this.format = null;
    this.alternateNames = new String[0];
  }
  
  public FieldInfo(String paramString1, Method paramMethod, Field paramField, Class<?> paramClass, Type paramType, int paramInt1, int paramInt2, int paramInt3, JSONField paramJSONField1, JSONField paramJSONField2, String paramString2) {
    Type<?> type3;
    String str1;
    Type<?> type4;
    this.ordinal = 0;
    String str2 = paramString1;
    if (paramField != null) {
      String str = paramField.getName();
      str2 = paramString1;
      if (str.equals(paramString1))
        str2 = str; 
    } 
    this.name = str2;
    this.method = paramMethod;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.serialzeFeatures = paramInt2;
    this.parserFeatures = paramInt3;
    this.fieldAnnotation = paramJSONField1;
    this.methodAnnotation = paramJSONField2;
    boolean bool = true;
    if (paramField != null) {
      boolean bool1;
      paramInt1 = paramField.getModifiers();
      if ((paramInt1 & 0x1) != 0 || paramMethod == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.fieldAccess = bool1;
      if (Modifier.isTransient(paramInt1) || TypeUtils.isTransient(paramMethod)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.fieldTransient = bool1;
    } else {
      this.fieldAccess = false;
      this.fieldTransient = false;
    } 
    if (paramString2 != null && paramString2.length() > 0) {
      this.label = paramString2;
    } else {
      this.label = "";
    } 
    paramJSONField2 = getAnnotation();
    paramJSONField1 = null;
    paramString1 = null;
    if (paramJSONField2 != null) {
      str1 = paramJSONField2.format();
      if (str1.trim().length() != 0)
        paramString1 = str1; 
      boolean bool1 = paramJSONField2.jsonDirect();
      this.unwrapped = paramJSONField2.unwrapped();
      this.alternateNames = paramJSONField2.alternateNames();
    } else {
      this.unwrapped = false;
      this.alternateNames = new String[0];
      boolean bool1 = false;
      paramString1 = str1;
    } 
    this.format = paramString1;
    this.name_chars = genFieldNameChars();
    if (paramMethod != null)
      TypeUtils.setAccessible(paramMethod); 
    if (paramField != null)
      TypeUtils.setAccessible(paramField); 
    if (paramMethod != null) {
      Type<?> type;
      Class[] arrayOfClass = paramMethod.getParameterTypes();
      if (arrayOfClass.length == 1) {
        type4 = arrayOfClass[0];
        type = paramMethod.getGenericParameterTypes()[0];
      } else if (type.length == 2 && type[0] == String.class && type[1] == Object.class) {
        type4 = type[0];
        type = type4;
      } else {
        type4 = paramMethod.getReturnType();
        Type type5 = paramMethod.getGenericReturnType();
        boolean bool2 = true;
        this.declaringClass = paramMethod.getDeclaringClass();
        type = type4;
        type2 = type5;
      } 
      boolean bool1 = false;
      type3 = type;
    } else {
      Class<?> clazz = type3.getType();
      type2 = type3.getGenericType();
      this.declaringClass = type3.getDeclaringClass();
      boolean bool1 = Modifier.isFinal(type3.getModifiers());
      this.getOnly = bool1;
    } 
    this.declaringClass = type2.getDeclaringClass();
    Type<?> type1 = type4;
    Type<?> type2 = type3;
  }
  
  private static boolean getArgument(Type[] paramArrayOfType1, TypeVariable[] paramArrayOfTypeVariable, Type[] paramArrayOfType2) {
    if (paramArrayOfType2 == null || paramArrayOfTypeVariable.length == 0)
      return false; 
    byte b = 0;
    boolean bool;
    for (bool = false; b < paramArrayOfType1.length; bool = bool1) {
      Type[] arrayOfType;
      boolean bool1;
      Type type = paramArrayOfType1[b];
      if (type instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType)type;
        arrayOfType = parameterizedType.getActualTypeArguments();
        bool1 = bool;
        if (getArgument(arrayOfType, paramArrayOfTypeVariable, paramArrayOfType2)) {
          paramArrayOfType1[b] = new ParameterizedTypeImpl(arrayOfType, parameterizedType.getOwnerType(), parameterizedType.getRawType());
          bool1 = true;
        } 
      } else {
        bool1 = bool;
        if (arrayOfType instanceof TypeVariable) {
          bool1 = bool;
          for (byte b1 = 0; b1 < paramArrayOfTypeVariable.length; b1++) {
            if (arrayOfType.equals(paramArrayOfTypeVariable[b1])) {
              paramArrayOfType1[b] = paramArrayOfType2[b1];
              bool1 = true;
            } 
          } 
        } 
      } 
      b++;
    } 
    return bool;
  }
  
  public static Type getFieldType(Class<?> paramClass, Type paramType1, Type paramType2) {
    Type type;
    if (paramClass == null || paramType1 == null)
      return paramType2; 
    boolean bool = paramType2 instanceof GenericArrayType;
    byte b = 0;
    if (bool) {
      Type type1 = ((GenericArrayType)paramType2).getGenericComponentType();
      type = getFieldType(paramClass, paramType1, type1);
      return (type1 != type) ? Array.newInstance(TypeUtils.getClass(type), 0).getClass() : paramType2;
    } 
    if (!TypeUtils.isGenericParamType(paramType1))
      return paramType2; 
    if (paramType2 instanceof TypeVariable) {
      ParameterizedType parameterizedType = (ParameterizedType)TypeUtils.getGenericParamType(paramType1);
      Class<?> clazz = TypeUtils.getClass(parameterizedType);
      TypeVariable typeVariable = (TypeVariable)paramType2;
      TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
      while (b < arrayOfTypeVariable.length) {
        if (arrayOfTypeVariable[b].getName().equals(typeVariable.getName()))
          return parameterizedType.getActualTypeArguments()[b]; 
        b++;
      } 
    } 
    if (paramType2 instanceof ParameterizedType) {
      TypeVariable[] arrayOfTypeVariable;
      ParameterizedType parameterizedType = (ParameterizedType)paramType2;
      Type[] arrayOfType = parameterizedType.getActualTypeArguments();
      if (paramType1 instanceof ParameterizedType) {
        paramType1 = paramType1;
        arrayOfTypeVariable = type.getTypeParameters();
      } else if (arrayOfTypeVariable.getGenericSuperclass() instanceof ParameterizedType) {
        paramType1 = arrayOfTypeVariable.getGenericSuperclass();
        arrayOfTypeVariable = arrayOfTypeVariable.getSuperclass().getTypeParameters();
      } else {
        arrayOfTypeVariable = (TypeVariable[])paramType1.getClass().getTypeParameters();
        paramType1 = parameterizedType;
      } 
      if (getArgument(arrayOfType, arrayOfTypeVariable, paramType1.getActualTypeArguments()))
        return new ParameterizedTypeImpl(arrayOfType, parameterizedType.getOwnerType(), parameterizedType.getRawType()); 
    } 
    return paramType2;
  }
  
  private static Type getInheritGenericType(Class<?> paramClass, Type paramType, TypeVariable<?> paramTypeVariable) {
    Type[] arrayOfType;
    Class<?> clazz = (Class)paramTypeVariable.getGenericDeclaration();
    Type type = null;
    if (clazz == paramClass) {
      if (paramType instanceof ParameterizedType) {
        arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments();
      } else {
        paramClass = null;
      } 
    } else {
      Type[] arrayOfType1;
      paramType = null;
      while (paramClass != null && paramClass != Object.class && paramClass != clazz) {
        Type[] arrayOfType2;
        Type type1 = paramClass.getGenericSuperclass();
        Type type2 = paramType;
        if (type1 instanceof ParameterizedType) {
          arrayOfType2 = ((ParameterizedType)type1).getActualTypeArguments();
          getArgument(arrayOfType2, (TypeVariable[])paramClass.getTypeParameters(), (Type[])paramType);
        } 
        paramClass = paramClass.getSuperclass();
        arrayOfType1 = arrayOfType2;
      } 
      arrayOfType = arrayOfType1;
    } 
    if (arrayOfType == null)
      return null; 
    TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
    byte b = 0;
    while (true) {
      paramType = type;
      if (b < arrayOfTypeVariable.length) {
        if (paramTypeVariable.equals(arrayOfTypeVariable[b])) {
          paramType = arrayOfType[b];
          break;
        } 
        b++;
        continue;
      } 
      break;
    } 
    return paramType;
  }
  
  public int compareTo(FieldInfo paramFieldInfo) {
    if (this.ordinal < paramFieldInfo.ordinal)
      return -1; 
    if (this.ordinal > paramFieldInfo.ordinal)
      return 1; 
    int i = this.name.compareTo(paramFieldInfo.name);
    if (i != 0)
      return i; 
    Class<?> clazz1 = getDeclaredClass();
    Class<?> clazz2 = paramFieldInfo.getDeclaredClass();
    if (clazz1 != null && clazz2 != null && clazz1 != clazz2) {
      if (clazz1.isAssignableFrom(clazz2))
        return -1; 
      if (clazz2.isAssignableFrom(clazz1))
        return 1; 
    } 
    Field field = this.field;
    boolean bool1 = false;
    if (field != null && this.field.getType() == this.fieldClass) {
      i = 1;
    } else {
      i = 0;
    } 
    boolean bool2 = bool1;
    if (paramFieldInfo.field != null) {
      bool2 = bool1;
      if (paramFieldInfo.field.getType() == paramFieldInfo.fieldClass)
        bool2 = true; 
    } 
    return (i != 0 && !bool2) ? 1 : ((bool2 && i == 0) ? -1 : ((paramFieldInfo.fieldClass.isPrimitive() && !this.fieldClass.isPrimitive()) ? 1 : ((this.fieldClass.isPrimitive() && !paramFieldInfo.fieldClass.isPrimitive()) ? -1 : ((paramFieldInfo.fieldClass.getName().startsWith("java.") && !this.fieldClass.getName().startsWith("java.")) ? 1 : ((this.fieldClass.getName().startsWith("java.") && !paramFieldInfo.fieldClass.getName().startsWith("java.")) ? -1 : this.fieldClass.getName().compareTo(paramFieldInfo.fieldClass.getName()))))));
  }
  
  protected char[] genFieldNameChars() {
    int i = this.name.length();
    char[] arrayOfChar = new char[i + 3];
    this.name.getChars(0, this.name.length(), arrayOfChar, 1);
    arrayOfChar[0] = (char)'"';
    arrayOfChar[i + 1] = (char)'"';
    arrayOfChar[i + 2] = (char)':';
    return arrayOfChar;
  }
  
  public Object get(Object paramObject) throws IllegalAccessException, InvocationTargetException {
    return (this.method != null) ? this.method.invoke(paramObject, new Object[0]) : this.field.get(paramObject);
  }
  
  public <T extends java.lang.annotation.Annotation> T getAnnation(Class<T> paramClass) {
    if (paramClass == JSONField.class)
      return (T)getAnnotation(); 
    T t1 = null;
    if (this.method != null)
      t1 = this.method.getAnnotation((Class)paramClass); 
    T t2 = t1;
    if (t1 == null) {
      t2 = t1;
      if (this.field != null)
        t2 = this.field.getAnnotation((Class)paramClass); 
    } 
    return t2;
  }
  
  public JSONField getAnnotation() {
    return (this.fieldAnnotation != null) ? this.fieldAnnotation : this.methodAnnotation;
  }
  
  protected Class<?> getDeclaredClass() {
    return (this.method != null) ? this.method.getDeclaringClass() : ((this.field != null) ? this.field.getDeclaringClass() : null);
  }
  
  public String getFormat() {
    return this.format;
  }
  
  public Member getMember() {
    return (Member)((this.method != null) ? this.method : this.field);
  }
  
  public void set(Object paramObject1, Object paramObject2) throws IllegalAccessException, InvocationTargetException {
    if (this.method != null) {
      this.method.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    } 
    this.field.set(paramObject1, paramObject2);
  }
  
  public void setAccessible() throws SecurityException {
    if (this.method != null) {
      TypeUtils.setAccessible(this.method);
      return;
    } 
    TypeUtils.setAccessible(this.field);
  }
  
  public String toString() {
    return this.name;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\FieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */