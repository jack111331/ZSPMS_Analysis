package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeReference<T> {
  public static final Type LIST_STRING;
  
  static ConcurrentMap<Type, Type> classTypeCache = new ConcurrentHashMap<Type, Type>(16, 0.75F, 1);
  
  protected final Type type;
  
  static {
    LIST_STRING = (new TypeReference<List<String>>() {
      
      }).getType();
  }
  
  protected TypeReference() {
    Type type1 = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    Type type2 = classTypeCache.get(type1);
    Type type3 = type2;
    if (type2 == null) {
      classTypeCache.putIfAbsent(type1, type1);
      type3 = classTypeCache.get(type1);
    } 
    this.type = type3;
  }
  
  protected TypeReference(Type... paramVarArgs) {
    Class<?> clazz = getClass();
    Type[] arrayOfType1 = ((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments();
    byte b = 0;
    ParameterizedType parameterizedType = (ParameterizedType)arrayOfType1[0];
    Type type3 = parameterizedType.getRawType();
    Type[] arrayOfType2 = parameterizedType.getActualTypeArguments();
    int i;
    for (i = 0; b < arrayOfType2.length; i = j) {
      int j = i;
      if (arrayOfType2[b] instanceof java.lang.reflect.TypeVariable) {
        j = i + 1;
        arrayOfType2[b] = paramVarArgs[i];
        if (j >= paramVarArgs.length)
          break; 
      } 
      b++;
    } 
    ParameterizedTypeImpl parameterizedTypeImpl = new ParameterizedTypeImpl(arrayOfType2, clazz, type3);
    Type type2 = classTypeCache.get(parameterizedTypeImpl);
    Type type1 = type2;
    if (type2 == null) {
      classTypeCache.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
      type1 = classTypeCache.get(parameterizedTypeImpl);
    } 
    this.type = type1;
  }
  
  public Type getType() {
    return this.type;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\TypeReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */