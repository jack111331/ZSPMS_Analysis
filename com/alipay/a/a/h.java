package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.alipay.b;

public final class h implements i, j {
  private static Map<Object, Object> a(Type paramType) {
    // Byte code:
    //   0: aload_0
    //   1: ldc java/util/Properties
    //   3: if_acmpne -> 16
    //   6: new java/util/Properties
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: aload_0
    //   17: ldc java/util/Hashtable
    //   19: if_acmpne -> 33
    //   22: new java/util/Hashtable
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore_0
    //   30: goto -> 14
    //   33: aload_0
    //   34: ldc java/util/IdentityHashMap
    //   36: if_acmpne -> 50
    //   39: new java/util/IdentityHashMap
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: astore_0
    //   47: goto -> 14
    //   50: aload_0
    //   51: ldc java/util/SortedMap
    //   53: if_acmpeq -> 62
    //   56: aload_0
    //   57: ldc java/util/TreeMap
    //   59: if_acmpne -> 73
    //   62: new java/util/TreeMap
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore_0
    //   70: goto -> 14
    //   73: aload_0
    //   74: ldc java/util/concurrent/ConcurrentMap
    //   76: if_acmpeq -> 85
    //   79: aload_0
    //   80: ldc java/util/concurrent/ConcurrentHashMap
    //   82: if_acmpne -> 96
    //   85: new java/util/concurrent/ConcurrentHashMap
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_0
    //   93: goto -> 14
    //   96: aload_0
    //   97: ldc java/util/Map
    //   99: if_acmpeq -> 108
    //   102: aload_0
    //   103: ldc java/util/HashMap
    //   105: if_acmpne -> 119
    //   108: new java/util/HashMap
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: astore_0
    //   116: goto -> 14
    //   119: aload_0
    //   120: ldc java/util/LinkedHashMap
    //   122: if_acmpne -> 136
    //   125: new java/util/LinkedHashMap
    //   128: dup
    //   129: invokespecial <init> : ()V
    //   132: astore_0
    //   133: goto -> 14
    //   136: aload_0
    //   137: instanceof java/lang/reflect/ParameterizedType
    //   140: ifeq -> 156
    //   143: aload_0
    //   144: checkcast java/lang/reflect/ParameterizedType
    //   147: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   152: astore_0
    //   153: goto -> 0
    //   156: aload_0
    //   157: checkcast java/lang/Class
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual isInterface : ()Z
    //   165: ifeq -> 192
    //   168: new java/lang/IllegalArgumentException
    //   171: dup
    //   172: new java/lang/StringBuilder
    //   175: dup
    //   176: ldc 'unsupport type '
    //   178: invokespecial <init> : (Ljava/lang/String;)V
    //   181: aload_0
    //   182: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: invokevirtual toString : ()Ljava/lang/String;
    //   188: invokespecial <init> : (Ljava/lang/String;)V
    //   191: athrow
    //   192: aload_1
    //   193: invokevirtual newInstance : ()Ljava/lang/Object;
    //   196: checkcast java/util/Map
    //   199: astore_1
    //   200: aload_1
    //   201: astore_0
    //   202: goto -> 14
    //   205: astore_1
    //   206: new java/lang/IllegalArgumentException
    //   209: dup
    //   210: new java/lang/StringBuilder
    //   213: dup
    //   214: ldc 'unsupport type '
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual toString : ()Ljava/lang/String;
    //   226: aload_1
    //   227: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: athrow
    // Exception table:
    //   from	to	target	type
    //   192	200	205	java/lang/Exception
  }
  
  public final Object a(Object paramObject) {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    paramObject = ((Map)paramObject).entrySet().iterator();
    while (paramObject.hasNext()) {
      Map.Entry entry = paramObject.next();
      if (!(entry.getKey() instanceof String))
        throw new IllegalArgumentException("Map key must be String!"); 
      treeMap.put(entry.getKey(), f.b(entry.getValue()));
    } 
    return treeMap;
  }
  
  public final Object a(Object<Object, Object> paramObject, Type paramType) {
    if (!paramObject.getClass().equals(b.class))
      return null; 
    b b = (b)paramObject;
    paramObject = (Object<Object, Object>)a(paramType);
    if (paramType instanceof java.lang.reflect.ParameterizedType) {
      paramType = paramType;
      Type type = paramType.getActualTypeArguments()[0];
      paramType = paramType.getActualTypeArguments()[1];
      if (String.class == type) {
        Iterator<String> iterator = b.a();
        while (true) {
          if (iterator.hasNext()) {
            String str = iterator.next();
            if (a.a((Class)paramType)) {
              paramObject.put(str, b.a(str));
              continue;
            } 
            paramObject.put(str, e.a(b.a(str), paramType));
            continue;
          } 
          return paramObject;
        } 
      } 
      throw new IllegalArgumentException("Deserialize Map Key must be String.class");
    } 
    throw new IllegalArgumentException("Deserialize Map must be Generics!");
  }
  
  public final boolean a(Class<?> paramClass) {
    return Map.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */