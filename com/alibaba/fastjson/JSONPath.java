package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class JSONPath implements JSONAware {
  private static int CACHE_SIZE = 1024;
  
  private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap<String, JSONPath>(128, 0.75F, 1);
  
  private ParserConfig parserConfig;
  
  private final String path;
  
  private Segement[] segments;
  
  private SerializeConfig serializeConfig;
  
  public JSONPath(String paramString) {
    this(paramString, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
  }
  
  public JSONPath(String paramString, SerializeConfig paramSerializeConfig, ParserConfig paramParserConfig) {
    if (paramString != null && paramString.length() != 0) {
      this.path = paramString;
      this.serializeConfig = paramSerializeConfig;
      this.parserConfig = paramParserConfig;
      return;
    } 
    throw new JSONPathException("json-path can not be null or empty");
  }
  
  public static void arrayAdd(Object paramObject, String paramString, Object... paramVarArgs) {
    compile(paramString).arrayAdd(paramObject, paramVarArgs);
  }
  
  public static JSONPath compile(String paramString) {
    if (paramString != null) {
      JSONPath jSONPath1 = pathCache.get(paramString);
      JSONPath jSONPath2 = jSONPath1;
      if (jSONPath1 == null) {
        jSONPath1 = new JSONPath(paramString);
        jSONPath2 = jSONPath1;
        if (pathCache.size() < CACHE_SIZE) {
          pathCache.putIfAbsent(paramString, jSONPath1);
          jSONPath2 = pathCache.get(paramString);
        } 
      } 
      return jSONPath2;
    } 
    throw new JSONPathException("jsonpath can not be null");
  }
  
  public static boolean contains(Object paramObject, String paramString) {
    return (paramObject == null) ? false : compile(paramString).contains(paramObject);
  }
  
  public static boolean containsValue(Object paramObject1, String paramString, Object paramObject2) {
    return compile(paramString).containsValue(paramObject1, paramObject2);
  }
  
  static boolean eq(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2) ? true : ((paramObject1 == null || paramObject2 == null) ? false : ((paramObject1.getClass() == paramObject2.getClass()) ? paramObject1.equals(paramObject2) : ((paramObject1 instanceof Number) ? ((paramObject2 instanceof Number) ? eqNotNull((Number)paramObject1, (Number)paramObject2) : false) : paramObject1.equals(paramObject2))));
  }
  
  static boolean eqNotNull(Number paramNumber1, Number paramNumber2) {
    Class<?> clazz1 = paramNumber1.getClass();
    boolean bool1 = isInt(clazz1);
    Class<?> clazz2 = paramNumber2.getClass();
    boolean bool2 = isInt(clazz2);
    if (paramNumber1 instanceof BigDecimal) {
      BigDecimal bigDecimal = (BigDecimal)paramNumber1;
      if (bool2)
        return bigDecimal.equals(BigDecimal.valueOf(paramNumber2.longValue())); 
    } 
    boolean bool3 = true;
    boolean bool4 = true;
    if (bool1) {
      if (bool2) {
        if (paramNumber1.longValue() == paramNumber2.longValue()) {
          bool3 = bool4;
        } else {
          bool3 = false;
        } 
        return bool3;
      } 
      if (paramNumber2 instanceof BigInteger) {
        paramNumber2 = paramNumber1;
        return BigInteger.valueOf(paramNumber1.longValue()).equals(paramNumber2);
      } 
    } 
    if (bool2 && paramNumber1 instanceof BigInteger)
      return ((BigInteger)paramNumber1).equals(BigInteger.valueOf(paramNumber2.longValue())); 
    boolean bool5 = isDouble(clazz1);
    bool4 = isDouble(clazz2);
    if ((bool5 && bool4) || (bool5 && bool2) || (bool4 && bool1)) {
      if (paramNumber1.doubleValue() != paramNumber2.doubleValue())
        bool3 = false; 
      return bool3;
    } 
    return false;
  }
  
  public static Object eval(Object paramObject, String paramString) {
    return compile(paramString).eval(paramObject);
  }
  
  protected static boolean isDouble(Class<?> paramClass) {
    return (paramClass == Float.class || paramClass == Double.class);
  }
  
  protected static boolean isInt(Class<?> paramClass) {
    return (paramClass == Byte.class || paramClass == Short.class || paramClass == Integer.class || paramClass == Long.class);
  }
  
  public static Map<String, Object> paths(Object paramObject) {
    return paths(paramObject, SerializeConfig.globalInstance);
  }
  
  public static Map<String, Object> paths(Object<Object, Object> paramObject, SerializeConfig paramSerializeConfig) {
    IdentityHashMap<Object, Object> identityHashMap = new IdentityHashMap<Object, Object>();
    paths((Map)identityHashMap, "/", paramObject, paramSerializeConfig);
    paramObject = (Object<Object, Object>)new HashMap<Object, Object>();
    for (Map.Entry<Object, Object> entry : identityHashMap.entrySet())
      paramObject.put(entry.getValue(), entry.getKey()); 
    return (Map)paramObject;
  }
  
  private static void paths(Map<Object, String> paramMap, String paramString, Object paramObject, SerializeConfig paramSerializeConfig) {
    String str;
    if (paramObject == null)
      return; 
    if (paramMap.containsKey(paramObject))
      return; 
    paramMap.put(paramObject, paramString);
    if (paramObject instanceof Map) {
      for (Map.Entry entry : ((Map)paramObject).entrySet()) {
        Object object = entry.getKey();
        if (object instanceof String) {
          if (paramString.equals("/")) {
            paramObject = new StringBuilder();
          } else {
            paramObject = new StringBuilder();
            paramObject.append(paramString);
          } 
          paramObject.append("/");
          paramObject.append(object);
          paramObject = paramObject.toString();
          paths(paramMap, (String)paramObject, entry.getValue(), paramSerializeConfig);
        } 
      } 
      return;
    } 
    boolean bool = paramObject instanceof Collection;
    int i = 0;
    int j = 0;
    if (bool) {
      Iterator<Object> iterator = ((Collection)paramObject).iterator();
      for (i = j; iterator.hasNext(); i++) {
        str = (String)iterator.next();
        if (paramString.equals("/")) {
          paramObject = new StringBuilder();
        } else {
          paramObject = new StringBuilder();
          paramObject.append(paramString);
        } 
        paramObject.append("/");
        paramObject.append(i);
        paramObject = paramObject.toString();
        paths(paramMap, (String)paramObject, str, paramSerializeConfig);
      } 
      return;
    } 
    Class<?> clazz = paramObject.getClass();
    if (clazz.isArray()) {
      j = Array.getLength(paramObject);
      while (i < j) {
        StringBuilder stringBuilder;
        Object object = Array.get(paramObject, i);
        if (paramString.equals("/")) {
          stringBuilder = new StringBuilder();
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramString);
        } 
        stringBuilder.append("/");
        stringBuilder.append(i);
        str = stringBuilder.toString();
        paths(paramMap, str, object, paramSerializeConfig);
        i++;
      } 
      return;
    } 
    if (ParserConfig.isPrimitive2((Class)str) || str.isEnum())
      return; 
    ObjectSerializer objectSerializer = paramSerializeConfig.getObjectWriter((Class)str);
    if (objectSerializer instanceof JavaBeanSerializer) {
      JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer)objectSerializer;
      try {
        for (Map.Entry entry : javaBeanSerializer.getFieldValuesMap(paramObject).entrySet()) {
          String str1 = (String)entry.getKey();
          if (str1 instanceof String) {
            if (paramString.equals("/")) {
              paramObject = new StringBuilder();
              super();
              paramObject.append("/");
              paramObject.append(str1);
            } else {
              paramObject = new StringBuilder();
              super();
              paramObject.append(paramString);
              paramObject.append("/");
              paramObject.append(str1);
            } 
            paramObject = paramObject.toString();
            paths(paramMap, (String)paramObject, entry.getValue(), paramSerializeConfig);
          } 
        } 
        return;
      } catch (Exception exception) {
        throw new JSONException("toJSON error", exception);
      } 
    } 
  }
  
  public static Object read(String paramString1, String paramString2) {
    Object object = JSON.parse(paramString1);
    return compile(paramString2).eval(object);
  }
  
  public static boolean remove(Object paramObject, String paramString) {
    return compile(paramString).remove(paramObject);
  }
  
  public static boolean set(Object paramObject1, String paramString, Object paramObject2) {
    return compile(paramString).set(paramObject1, paramObject2);
  }
  
  public static int size(Object paramObject, String paramString) {
    JSONPath jSONPath = compile(paramString);
    return jSONPath.evalSize(jSONPath.eval(paramObject));
  }
  
  public void arrayAdd(Object<?> paramObject, Object... paramVarArgs) {
    if (paramVarArgs == null || paramVarArgs.length == 0)
      return; 
    if (paramObject == null)
      return; 
    init();
    int i = 0;
    int j = 0;
    Object<?> object1 = paramObject;
    Object<?> object2 = null;
    int k;
    for (k = 0; k < this.segments.length; k++) {
      if (k == this.segments.length - 1)
        object2 = object1; 
      object1 = (Object<?>)this.segments[k].eval(this, paramObject, object1);
    } 
    if (object1 != null) {
      if (object1 instanceof Collection) {
        paramObject = object1;
        i = paramVarArgs.length;
        for (k = j; k < i; k++)
          paramObject.add(paramVarArgs[k]); 
        return;
      } 
      paramObject = (Object<?>)object1.getClass();
      if (paramObject.isArray()) {
        j = Array.getLength(object1);
        paramObject = (Object<?>)Array.newInstance(paramObject.getComponentType(), paramVarArgs.length + j);
        System.arraycopy(object1, 0, paramObject, 0, j);
        for (k = i; k < paramVarArgs.length; k++)
          Array.set(paramObject, j + k, paramVarArgs[k]); 
        Segement segement = this.segments[this.segments.length - 1];
        if (segement instanceof PropertySegement) {
          ((PropertySegement)segement).setValue(this, object2, paramObject);
          return;
        } 
        if (segement instanceof ArrayAccessSegement) {
          ((ArrayAccessSegement)segement).setValue(this, object2, paramObject);
          return;
        } 
        throw new UnsupportedOperationException();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unsupported array put operation. ");
      stringBuilder.append(paramObject);
      throw new JSONException(stringBuilder.toString());
    } 
    paramObject = (Object<?>)new StringBuilder();
    paramObject.append("value not found in path ");
    paramObject.append(this.path);
    throw new JSONPathException(paramObject.toString());
  }
  
  public boolean contains(Object paramObject) {
    if (paramObject == null)
      return false; 
    init();
    Object object = paramObject;
    for (byte b = 0; b < this.segments.length; b++) {
      object = this.segments[b].eval(this, paramObject, object);
      if (object == null)
        return false; 
    } 
    return true;
  }
  
  public boolean containsValue(Object paramObject1, Object paramObject2) {
    paramObject1 = eval(paramObject1);
    if (paramObject1 == paramObject2)
      return true; 
    if (paramObject1 == null)
      return false; 
    if (paramObject1 instanceof Iterable) {
      paramObject1 = ((Iterable)paramObject1).iterator();
      while (paramObject1.hasNext()) {
        if (eq(paramObject1.next(), paramObject2))
          return true; 
      } 
      return false;
    } 
    return eq(paramObject1, paramObject2);
  }
  
  protected void deepScan(Object paramObject, String paramString, List<Object> paramList) {
    StringBuilder stringBuilder;
    if (paramObject == null)
      return; 
    if (paramObject instanceof Map) {
      paramObject = paramObject;
      if (paramObject.containsKey(paramString)) {
        paramList.add(paramObject.get(paramString));
        return;
      } 
      paramObject = paramObject.values().iterator();
      while (paramObject.hasNext())
        deepScan(paramObject.next(), paramString, paramList); 
      return;
    } 
    JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(paramObject.getClass());
    if (javaBeanSerializer != null)
      try {
        JSONException jSONException;
        StringBuilder stringBuilder1;
        FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(paramString);
        if (fieldSerializer != null)
          try {
            paramList.add(fieldSerializer.getPropertyValueDirect(paramObject));
            return;
          } catch (InvocationTargetException invocationTargetException) {
            JSONException jSONException1 = new JSONException();
            paramObject = new StringBuilder();
            super();
            paramObject.append("getFieldValue error.");
            paramObject.append(paramString);
            this(paramObject.toString(), invocationTargetException);
            throw jSONException1;
          } catch (IllegalAccessException illegalAccessException) {
            jSONException = new JSONException();
            stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append("getFieldValue error.");
            stringBuilder1.append(paramString);
            this(stringBuilder1.toString(), illegalAccessException);
            throw jSONException;
          }  
        Iterator iterator = stringBuilder1.getFieldValues(illegalAccessException).iterator();
        while (iterator.hasNext())
          deepScan(iterator.next(), paramString, (List<Object>)jSONException); 
        return;
      } catch (Exception exception) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("jsonpath error, path ");
        stringBuilder.append(this.path);
        stringBuilder.append(", segement ");
        stringBuilder.append(paramString);
        throw new JSONPathException(stringBuilder.toString(), exception);
      }  
    if (exception instanceof List) {
      List list = (List)exception;
      for (byte b = 0; b < list.size(); b++)
        deepScan(list.get(b), paramString, (List<Object>)stringBuilder); 
      return;
    } 
  }
  
  protected void deepSet(Object paramObject1, String paramString, Object paramObject2) {
    if (paramObject1 == null)
      return; 
    if (paramObject1 instanceof Map) {
      paramObject1 = paramObject1;
      if (paramObject1.containsKey(paramString)) {
        paramObject1.get(paramString);
        paramObject1.put(paramString, paramObject2);
        return;
      } 
      paramObject1 = paramObject1.values().iterator();
      while (paramObject1.hasNext())
        deepSet(paramObject1.next(), paramString, paramObject2); 
      return;
    } 
    Class<?> clazz = paramObject1.getClass();
    JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(clazz);
    if (javaBeanDeserializer != null)
      try {
        FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(paramString);
        if (fieldDeserializer != null) {
          fieldDeserializer.setValue(paramObject1, paramObject2);
          return;
        } 
        paramObject1 = getJavaBeanSerializer(clazz).getObjectFieldValues(paramObject1).iterator();
        while (paramObject1.hasNext())
          deepSet(paramObject1.next(), paramString, paramObject2); 
        return;
      } catch (Exception exception) {
        paramObject2 = new StringBuilder();
        paramObject2.append("jsonpath error, path ");
        paramObject2.append(this.path);
        paramObject2.append(", segement ");
        paramObject2.append(paramString);
        throw new JSONPathException(paramObject2.toString(), exception);
      }  
    if (exception instanceof List) {
      List list = (List)exception;
      for (byte b = 0; b < list.size(); b++)
        deepSet(list.get(b), paramString, paramObject2); 
      return;
    } 
  }
  
  public Object eval(Object paramObject) {
    if (paramObject == null)
      return null; 
    init();
    byte b = 0;
    Object object = paramObject;
    while (b < this.segments.length) {
      object = this.segments[b].eval(this, paramObject, object);
      b++;
    } 
    return object;
  }
  
  int evalSize(Object paramObject) {
    if (paramObject == null)
      return -1; 
    if (paramObject instanceof Collection)
      return ((Collection)paramObject).size(); 
    if (paramObject instanceof Object[])
      return ((Object[])paramObject).length; 
    if (paramObject.getClass().isArray())
      return Array.getLength(paramObject); 
    if (paramObject instanceof Map) {
      byte b = 0;
      paramObject = ((Map)paramObject).values().iterator();
      while (paramObject.hasNext()) {
        if (paramObject.next() != null)
          b++; 
      } 
      return b;
    } 
    JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(paramObject.getClass());
    if (javaBeanSerializer == null)
      return -1; 
    try {
      return javaBeanSerializer.getSize(paramObject);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("evalSize error : ");
      stringBuilder.append(this.path);
      throw new JSONPathException(stringBuilder.toString(), exception);
    } 
  }
  
  protected Object getArrayItem(Object paramObject, int paramInt) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof List) {
      paramObject = paramObject;
      return (paramInt >= 0) ? ((paramInt < paramObject.size()) ? paramObject.get(paramInt) : null) : ((Math.abs(paramInt) <= paramObject.size()) ? paramObject.get(paramObject.size() + paramInt) : null);
    } 
    if (paramObject.getClass().isArray()) {
      int i = Array.getLength(paramObject);
      return (paramInt >= 0) ? ((paramInt < i) ? Array.get(paramObject, paramInt) : null) : ((Math.abs(paramInt) <= i) ? Array.get(paramObject, i + paramInt) : null);
    } 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      Object object = map.get(Integer.valueOf(paramInt));
      paramObject = object;
      if (object == null)
        paramObject = map.get(Integer.toString(paramInt)); 
      return paramObject;
    } 
    throw new UnsupportedOperationException();
  }
  
  protected JavaBeanDeserializer getJavaBeanDeserializer(Class<?> paramClass) {
    ObjectDeserializer objectDeserializer = this.parserConfig.getDeserializer(paramClass);
    if (objectDeserializer instanceof JavaBeanDeserializer) {
      JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer)objectDeserializer;
    } else {
      objectDeserializer = null;
    } 
    return (JavaBeanDeserializer)objectDeserializer;
  }
  
  protected JavaBeanSerializer getJavaBeanSerializer(Class<?> paramClass) {
    ObjectSerializer objectSerializer = this.serializeConfig.getObjectWriter(paramClass);
    if (objectSerializer instanceof JavaBeanSerializer) {
      JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer)objectSerializer;
    } else {
      objectSerializer = null;
    } 
    return (JavaBeanSerializer)objectSerializer;
  }
  
  public String getPath() {
    return this.path;
  }
  
  protected Object getPropertyValue(Object paramObject, String paramString, boolean paramBoolean) {
    JSONArray jSONArray;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      Object object = map.get(paramString);
      paramObject = object;
      if (object == null) {
        paramObject = object;
        if ("size".equals(paramString))
          paramObject = Integer.valueOf(map.size()); 
      } 
      return paramObject;
    } 
    JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(paramObject.getClass());
    if (javaBeanSerializer != null)
      try {
        return javaBeanSerializer.getFieldValue(paramObject, paramString);
      } catch (Exception exception) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("jsonpath error, path ");
        stringBuilder1.append(this.path);
        stringBuilder1.append(", segement ");
        stringBuilder1.append(paramString);
        throw new JSONPathException(stringBuilder1.toString(), exception);
      }  
    if (exception instanceof List) {
      List list = (List)exception;
      if ("size".equals(paramString))
        return Integer.valueOf(list.size()); 
      jSONArray = new JSONArray(list.size());
      for (byte b = 0; b < list.size(); b++) {
        Object object = getPropertyValue(list.get(b), paramString, paramBoolean);
        if (object instanceof Collection) {
          jSONArray.addAll((Collection)object);
        } else {
          jSONArray.add(object);
        } 
      } 
      return jSONArray;
    } 
    if (jSONArray instanceof Enum) {
      Enum enum_ = (Enum)jSONArray;
      if ("name".equals(paramString))
        return enum_.name(); 
      if ("ordinal".equals(paramString))
        return Integer.valueOf(enum_.ordinal()); 
    } 
    if (jSONArray instanceof Calendar) {
      Calendar calendar = (Calendar)jSONArray;
      if ("year".equals(paramString))
        return Integer.valueOf(calendar.get(1)); 
      if ("month".equals(paramString))
        return Integer.valueOf(calendar.get(2)); 
      if ("day".equals(paramString))
        return Integer.valueOf(calendar.get(5)); 
      if ("hour".equals(paramString))
        return Integer.valueOf(calendar.get(11)); 
      if ("minute".equals(paramString))
        return Integer.valueOf(calendar.get(12)); 
      if ("second".equals(paramString))
        return Integer.valueOf(calendar.get(13)); 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("jsonpath error, path ");
    stringBuilder.append(this.path);
    stringBuilder.append(", segement ");
    stringBuilder.append(paramString);
    throw new JSONPathException(stringBuilder.toString());
  }
  
  protected Collection<Object> getPropertyValues(Object paramObject) {
    JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(paramObject.getClass());
    if (javaBeanSerializer != null)
      try {
        return javaBeanSerializer.getFieldValues(paramObject);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jsonpath error, path ");
        stringBuilder.append(this.path);
        throw new JSONPathException(stringBuilder.toString(), exception);
      }  
    if (exception instanceof Map)
      return ((Map)exception).values(); 
    throw new UnsupportedOperationException();
  }
  
  protected void init() {
    if (this.segments != null)
      return; 
    if ("*".equals(this.path)) {
      this.segments = new Segement[] { WildCardSegement.instance };
    } else {
      this.segments = (new JSONPathParser(this.path)).explain();
    } 
  }
  
  public boolean remove(Object paramObject) {
    Object object2;
    boolean bool = false;
    if (paramObject == null)
      return false; 
    init();
    Object object = null;
    Object object1 = paramObject;
    byte b = 0;
    while (true) {
      object2 = object;
      if (b < this.segments.length) {
        if (b == this.segments.length - 1) {
          object2 = object1;
          break;
        } 
        object1 = this.segments[b].eval(this, paramObject, object1);
        if (object1 == null) {
          object2 = object;
          break;
        } 
        b++;
        continue;
      } 
      break;
    } 
    if (object2 == null)
      return false; 
    paramObject = this.segments[this.segments.length - 1];
    if (paramObject instanceof PropertySegement) {
      paramObject = paramObject;
      if (object2 instanceof Collection && this.segments.length > 1) {
        object1 = this.segments[this.segments.length - 2];
        if (object1 instanceof RangeSegement || object1 instanceof MultiIndexSegement) {
          object1 = ((Collection)object2).iterator();
          while (object1.hasNext()) {
            if (paramObject.remove(this, object1.next()))
              bool = true; 
          } 
          return bool;
        } 
      } 
      return paramObject.remove(this, object2);
    } 
    if (paramObject instanceof ArrayAccessSegement)
      return ((ArrayAccessSegement)paramObject).remove(this, object2); 
    throw new UnsupportedOperationException();
  }
  
  public boolean removeArrayItem(JSONPath paramJSONPath, Object paramObject, int paramInt) {
    if (paramObject instanceof List) {
      List list = (List)paramObject;
      if (paramInt >= 0) {
        if (paramInt >= list.size())
          return false; 
        list.remove(paramInt);
      } else {
        paramInt = list.size() + paramInt;
        if (paramInt < 0)
          return false; 
        list.remove(paramInt);
      } 
      return true;
    } 
    Class<?> clazz = paramObject.getClass();
    paramObject = new StringBuilder();
    paramObject.append("unsupported set operation.");
    paramObject.append(clazz);
    throw new JSONPathException(paramObject.toString());
  }
  
  protected boolean removePropertyValue(Object paramObject, String paramString) {
    boolean bool = paramObject instanceof Map;
    boolean bool1 = false;
    if (bool) {
      if (((Map)paramObject).remove(paramString) != null)
        bool1 = true; 
      return bool1;
    } 
    ObjectDeserializer objectDeserializer = this.parserConfig.getDeserializer(paramObject.getClass());
    if (objectDeserializer instanceof JavaBeanDeserializer) {
      JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer)objectDeserializer;
    } else {
      objectDeserializer = null;
    } 
    if (objectDeserializer != null) {
      FieldDeserializer fieldDeserializer = objectDeserializer.getFieldDeserializer(paramString);
      if (fieldDeserializer == null)
        return false; 
      fieldDeserializer.setValue(paramObject, null);
      return true;
    } 
    throw new UnsupportedOperationException();
  }
  
  public boolean set(Object paramObject1, Object paramObject2) {
    return set(paramObject1, paramObject2, true);
  }
  
  public boolean set(Object paramObject1, Object paramObject2, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual init : ()V
    //   10: aload_1
    //   11: astore #4
    //   13: aconst_null
    //   14: astore #5
    //   16: iconst_0
    //   17: istore #6
    //   19: iload #6
    //   21: aload_0
    //   22: getfield segments : [Lcom/alibaba/fastjson/JSONPath$Segement;
    //   25: arraylength
    //   26: if_icmpge -> 307
    //   29: aload_0
    //   30: getfield segments : [Lcom/alibaba/fastjson/JSONPath$Segement;
    //   33: iload #6
    //   35: aaload
    //   36: astore #7
    //   38: aload #7
    //   40: aload_0
    //   41: aload_1
    //   42: aload #4
    //   44: invokeinterface eval : (Lcom/alibaba/fastjson/JSONPath;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore #8
    //   51: aload #8
    //   53: astore #5
    //   55: aload #8
    //   57: ifnonnull -> 289
    //   60: iload #6
    //   62: aload_0
    //   63: getfield segments : [Lcom/alibaba/fastjson/JSONPath$Segement;
    //   66: arraylength
    //   67: iconst_1
    //   68: isub
    //   69: if_icmpge -> 86
    //   72: aload_0
    //   73: getfield segments : [Lcom/alibaba/fastjson/JSONPath$Segement;
    //   76: iload #6
    //   78: iconst_1
    //   79: iadd
    //   80: aaload
    //   81: astore #5
    //   83: goto -> 89
    //   86: aconst_null
    //   87: astore #5
    //   89: aload #5
    //   91: instanceof com/alibaba/fastjson/JSONPath$PropertySegement
    //   94: ifeq -> 207
    //   97: aload #7
    //   99: instanceof com/alibaba/fastjson/JSONPath$PropertySegement
    //   102: ifeq -> 157
    //   105: aload #7
    //   107: checkcast com/alibaba/fastjson/JSONPath$PropertySegement
    //   110: invokestatic access$000 : (Lcom/alibaba/fastjson/JSONPath$PropertySegement;)Ljava/lang/String;
    //   113: astore #5
    //   115: aload_0
    //   116: aload #4
    //   118: invokevirtual getClass : ()Ljava/lang/Class;
    //   121: invokevirtual getJavaBeanDeserializer : (Ljava/lang/Class;)Lcom/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer;
    //   124: astore #8
    //   126: aload #8
    //   128: ifnull -> 157
    //   131: aload #8
    //   133: aload #5
    //   135: invokevirtual getFieldDeserializer : (Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   138: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   141: getfield fieldClass : Ljava/lang/Class;
    //   144: astore #8
    //   146: aload_0
    //   147: aload #8
    //   149: invokevirtual getJavaBeanDeserializer : (Ljava/lang/Class;)Lcom/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer;
    //   152: astore #5
    //   154: goto -> 164
    //   157: aconst_null
    //   158: astore #8
    //   160: aload #8
    //   162: astore #5
    //   164: aload #5
    //   166: ifnull -> 195
    //   169: aload #5
    //   171: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   174: getfield defaultConstructor : Ljava/lang/reflect/Constructor;
    //   177: ifnull -> 193
    //   180: aload #5
    //   182: aconst_null
    //   183: aload #8
    //   185: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   188: astore #5
    //   190: goto -> 230
    //   193: iconst_0
    //   194: ireturn
    //   195: new com/alibaba/fastjson/JSONObject
    //   198: dup
    //   199: invokespecial <init> : ()V
    //   202: astore #5
    //   204: goto -> 230
    //   207: aload #5
    //   209: instanceof com/alibaba/fastjson/JSONPath$ArrayAccessSegement
    //   212: ifeq -> 227
    //   215: new com/alibaba/fastjson/JSONArray
    //   218: dup
    //   219: invokespecial <init> : ()V
    //   222: astore #5
    //   224: goto -> 230
    //   227: aconst_null
    //   228: astore #5
    //   230: aload #4
    //   232: astore #8
    //   234: aload #5
    //   236: ifnull -> 311
    //   239: aload #7
    //   241: instanceof com/alibaba/fastjson/JSONPath$PropertySegement
    //   244: ifeq -> 263
    //   247: aload #7
    //   249: checkcast com/alibaba/fastjson/JSONPath$PropertySegement
    //   252: aload_0
    //   253: aload #4
    //   255: aload #5
    //   257: invokevirtual setValue : (Lcom/alibaba/fastjson/JSONPath;Ljava/lang/Object;Ljava/lang/Object;)V
    //   260: goto -> 289
    //   263: aload #4
    //   265: astore #8
    //   267: aload #7
    //   269: instanceof com/alibaba/fastjson/JSONPath$ArrayAccessSegement
    //   272: ifeq -> 311
    //   275: aload #7
    //   277: checkcast com/alibaba/fastjson/JSONPath$ArrayAccessSegement
    //   280: aload_0
    //   281: aload #4
    //   283: aload #5
    //   285: invokevirtual setValue : (Lcom/alibaba/fastjson/JSONPath;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   288: pop
    //   289: iinc #6, 1
    //   292: aload #4
    //   294: astore #8
    //   296: aload #5
    //   298: astore #4
    //   300: aload #8
    //   302: astore #5
    //   304: goto -> 19
    //   307: aload #5
    //   309: astore #8
    //   311: aload #8
    //   313: ifnonnull -> 318
    //   316: iconst_0
    //   317: ireturn
    //   318: aload_0
    //   319: getfield segments : [Lcom/alibaba/fastjson/JSONPath$Segement;
    //   322: aload_0
    //   323: getfield segments : [Lcom/alibaba/fastjson/JSONPath$Segement;
    //   326: arraylength
    //   327: iconst_1
    //   328: isub
    //   329: aaload
    //   330: astore_1
    //   331: aload_1
    //   332: instanceof com/alibaba/fastjson/JSONPath$PropertySegement
    //   335: ifeq -> 351
    //   338: aload_1
    //   339: checkcast com/alibaba/fastjson/JSONPath$PropertySegement
    //   342: aload_0
    //   343: aload #8
    //   345: aload_2
    //   346: invokevirtual setValue : (Lcom/alibaba/fastjson/JSONPath;Ljava/lang/Object;Ljava/lang/Object;)V
    //   349: iconst_1
    //   350: ireturn
    //   351: aload_1
    //   352: instanceof com/alibaba/fastjson/JSONPath$ArrayAccessSegement
    //   355: ifeq -> 370
    //   358: aload_1
    //   359: checkcast com/alibaba/fastjson/JSONPath$ArrayAccessSegement
    //   362: aload_0
    //   363: aload #8
    //   365: aload_2
    //   366: invokevirtual setValue : (Lcom/alibaba/fastjson/JSONPath;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   369: ireturn
    //   370: new java/lang/UnsupportedOperationException
    //   373: dup
    //   374: invokespecial <init> : ()V
    //   377: athrow
  }
  
  public boolean setArrayItem(JSONPath paramJSONPath, Object paramObject1, int paramInt, Object paramObject2) {
    if (paramObject1 instanceof List) {
      List<Object> list = (List)paramObject1;
      if (paramInt >= 0) {
        list.set(paramInt, paramObject2);
      } else {
        list.set(list.size() + paramInt, paramObject2);
      } 
      return true;
    } 
    Class<?> clazz = paramObject1.getClass();
    if (clazz.isArray()) {
      int i = Array.getLength(paramObject1);
      if (paramInt >= 0) {
        if (paramInt < i)
          Array.set(paramObject1, paramInt, paramObject2); 
      } else if (Math.abs(paramInt) <= i) {
        Array.set(paramObject1, i + paramInt, paramObject2);
      } 
      return true;
    } 
    paramObject1 = new StringBuilder();
    paramObject1.append("unsupported set operation.");
    paramObject1.append(clazz);
    throw new JSONPathException(paramObject1.toString());
  }
  
  protected boolean setPropertyValue(Object paramObject1, String paramString, Object paramObject2) {
    if (paramObject1 instanceof Map) {
      ((Map<String, Object>)paramObject1).put(paramString, paramObject2);
      return true;
    } 
    if (paramObject1 instanceof List) {
      for (Object paramObject1 : paramObject1) {
        if (paramObject1 == null)
          continue; 
        setPropertyValue(paramObject1, paramString, paramObject2);
      } 
      return true;
    } 
    ObjectDeserializer objectDeserializer = this.parserConfig.getDeserializer(paramObject1.getClass());
    JavaBeanDeserializer javaBeanDeserializer = null;
    if (objectDeserializer instanceof JavaBeanDeserializer)
      javaBeanDeserializer = (JavaBeanDeserializer)objectDeserializer; 
    if (javaBeanDeserializer != null) {
      FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(paramString);
      if (fieldDeserializer == null)
        return false; 
      fieldDeserializer.setValue(paramObject1, paramObject2);
      return true;
    } 
    throw new UnsupportedOperationException();
  }
  
  public int size(Object paramObject) {
    if (paramObject == null)
      return -1; 
    init();
    byte b = 0;
    Object object = paramObject;
    while (b < this.segments.length) {
      object = this.segments[b].eval(this, paramObject, object);
      b++;
    } 
    return evalSize(object);
  }
  
  public String toJSONString() {
    return JSON.toJSONString(this.path);
  }
  
  static class ArrayAccessSegement implements Segement {
    private final int index;
    
    public ArrayAccessSegement(int param1Int) {
      this.index = param1Int;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1JSONPath.getArrayItem(param1Object2, this.index);
    }
    
    public boolean remove(JSONPath param1JSONPath, Object param1Object) {
      return param1JSONPath.removeArrayItem(param1JSONPath, param1Object, this.index);
    }
    
    public boolean setValue(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1JSONPath.setArrayItem(param1JSONPath, param1Object1, this.index, param1Object2);
    }
  }
  
  static class DoubleOpSegement implements Filter {
    private final JSONPath.Operator op;
    
    private final String propertyName;
    
    private final double value;
    
    public DoubleOpSegement(String param1String, double param1Double, JSONPath.Operator param1Operator) {
      this.propertyName = param1String;
      this.value = param1Double;
      this.op = param1Operator;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null)
        return false; 
      if (!(object instanceof Number))
        return false; 
      double d = ((Number)object).doubleValue();
      if (this.op == JSONPath.Operator.EQ) {
        if (d == this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.NE) {
        bool6 = bool1;
        if (d != this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.GE) {
        bool6 = bool2;
        if (d >= this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.GT) {
        bool6 = bool3;
        if (d > this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.LE) {
        bool6 = bool4;
        if (d <= this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.LT) {
        bool6 = bool5;
        if (d < this.value)
          bool6 = true; 
        return bool6;
      } 
      return false;
    }
  }
  
  static interface Filter {
    boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3);
  }
  
  public static class FilterSegement implements Segement {
    private final JSONPath.Filter filter;
    
    public FilterSegement(JSONPath.Filter param1Filter) {
      this.filter = param1Filter;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      if (param1Object2 == null)
        return null; 
      JSONArray jSONArray = new JSONArray();
      if (param1Object2 instanceof Iterable) {
        for (Object object : param1Object2) {
          if (this.filter.apply(param1JSONPath, param1Object1, param1Object2, object))
            jSONArray.add(object); 
        } 
        return jSONArray;
      } 
      return this.filter.apply(param1JSONPath, param1Object1, param1Object2, param1Object2) ? param1Object2 : null;
    }
  }
  
  static class IntBetweenSegement implements Filter {
    private final long endValue;
    
    private final boolean not;
    
    private final String propertyName;
    
    private final long startValue;
    
    public IntBetweenSegement(String param1String, long param1Long1, long param1Long2, boolean param1Boolean) {
      this.propertyName = param1String;
      this.startValue = param1Long1;
      this.endValue = param1Long2;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      Object object = param1JSONPath.getPropertyValue(param1Object3, this.propertyName, false);
      if (object == null)
        return false; 
      if (object instanceof Number) {
        long l = ((Number)object).longValue();
        if (l >= this.startValue && l <= this.endValue)
          return this.not ^ true; 
      } 
      return this.not;
    }
  }
  
  static class IntInSegement implements Filter {
    private final boolean not;
    
    private final String propertyName;
    
    private final long[] values;
    
    public IntInSegement(String param1String, long[] param1ArrayOflong, boolean param1Boolean) {
      this.propertyName = param1String;
      this.values = param1ArrayOflong;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      byte b = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null)
        return false; 
      if (object instanceof Number) {
        long l = ((Number)object).longValue();
        object = this.values;
        int i = object.length;
        while (b < i) {
          if (object[b] == l)
            return this.not ^ true; 
          b++;
        } 
      } 
      return this.not;
    }
  }
  
  static class IntObjInSegement implements Filter {
    private final boolean not;
    
    private final String propertyName;
    
    private final Long[] values;
    
    public IntObjInSegement(String param1String, Long[] param1ArrayOfLong, boolean param1Boolean) {
      this.propertyName = param1String;
      this.values = param1ArrayOfLong;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      int i = 0;
      int j = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null) {
        object = this.values;
        i = object.length;
        while (j < i) {
          if (object[j] == null)
            return this.not ^ true; 
          j++;
        } 
        return this.not;
      } 
      if (object instanceof Number) {
        long l = ((Number)object).longValue();
        object = this.values;
        int k = object.length;
        for (j = i; j < k; j++) {
          param1Object1 = object[j];
          if (param1Object1 != null && param1Object1.longValue() == l)
            return this.not ^ true; 
        } 
      } 
      return this.not;
    }
  }
  
  static class IntOpSegement implements Filter {
    private final JSONPath.Operator op;
    
    private final String propertyName;
    
    private final long value;
    
    public IntOpSegement(String param1String, long param1Long, JSONPath.Operator param1Operator) {
      this.propertyName = param1String;
      this.value = param1Long;
      this.op = param1Operator;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null)
        return false; 
      if (!(object instanceof Number))
        return false; 
      long l = ((Number)object).longValue();
      if (this.op == JSONPath.Operator.EQ) {
        if (l == this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.NE) {
        bool6 = bool1;
        if (l != this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.GE) {
        bool6 = bool2;
        if (l >= this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.GT) {
        bool6 = bool3;
        if (l > this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.LE) {
        bool6 = bool4;
        if (l <= this.value)
          bool6 = true; 
        return bool6;
      } 
      if (this.op == JSONPath.Operator.LT) {
        bool6 = bool5;
        if (l < this.value)
          bool6 = true; 
        return bool6;
      } 
      return false;
    }
  }
  
  static class JSONPathParser {
    private char ch;
    
    private int level;
    
    private final String path;
    
    private int pos;
    
    public JSONPathParser(String param1String) {
      this.path = param1String;
      next();
    }
    
    static boolean isDigitFirst(char param1Char) {
      return (param1Char == '-' || param1Char == '+' || (param1Char >= '0' && param1Char <= '9'));
    }
    
    void accept(char param1Char) {
      if (this.ch == param1Char) {
        if (!isEOF())
          next(); 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("expect '");
      stringBuilder.append(param1Char);
      stringBuilder.append(", but '");
      stringBuilder.append(this.ch);
      stringBuilder.append("'");
      throw new JSONPathException(stringBuilder.toString());
    }
    
    JSONPath.Segement buildArraySegement(String param1String) {
      String[] arrayOfString;
      int[] arrayOfInt;
      int i = param1String.length();
      int j = 0;
      int k = 0;
      char c1 = param1String.charAt(0);
      int m = 1;
      int n = i - 1;
      char c2 = param1String.charAt(n);
      int i1 = param1String.indexOf(',');
      int i2 = param1String.length();
      i = -1;
      if (i2 > 2 && c1 == '\'' && c2 == '\'') {
        if (i1 == -1)
          return new JSONPath.PropertySegement(param1String.substring(1, n), false); 
        String[] arrayOfString1 = param1String.split(",");
        arrayOfString = new String[arrayOfString1.length];
        for (j = k; j < arrayOfString1.length; j++) {
          String str = arrayOfString1[j];
          arrayOfString[j] = str.substring(1, str.length() - 1);
        } 
        return new JSONPath.MultiPropertySegement(arrayOfString);
      } 
      k = arrayOfString.indexOf(':');
      if (i1 == -1 && k == -1) {
        if (TypeUtils.isNumber((String)arrayOfString))
          try {
            return new JSONPath.ArrayAccessSegement(Integer.parseInt((String)arrayOfString));
          } catch (NumberFormatException numberFormatException) {
            return new JSONPath.PropertySegement((String)arrayOfString, false);
          }  
        return new JSONPath.PropertySegement((String)arrayOfString, false);
      } 
      if (i1 != -1) {
        String[] arrayOfString1 = arrayOfString.split(",");
        arrayOfInt = new int[arrayOfString1.length];
        while (j < arrayOfString1.length) {
          arrayOfInt[j] = Integer.parseInt(arrayOfString1[j]);
          j++;
        } 
        return new JSONPath.MultiIndexSegement(arrayOfInt);
      } 
      if (k != -1) {
        String[] arrayOfString1 = arrayOfInt.split(":");
        int[] arrayOfInt1 = new int[arrayOfString1.length];
        for (j = 0; j < arrayOfString1.length; j++) {
          String str = arrayOfString1[j];
          if (str.length() == 0) {
            if (j == 0) {
              arrayOfInt1[j] = 0;
            } else {
              throw new UnsupportedOperationException();
            } 
          } else {
            arrayOfInt1[j] = Integer.parseInt(str);
          } 
        } 
        k = arrayOfInt1[0];
        j = i;
        if (arrayOfInt1.length > 1)
          j = arrayOfInt1[1]; 
        if (arrayOfInt1.length == 3)
          m = arrayOfInt1[2]; 
        if (j < 0 || j >= k) {
          if (m > 0)
            return new JSONPath.RangeSegement(k, j, m); 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("step must greater than zero : ");
          stringBuilder1.append(m);
          throw new UnsupportedOperationException(stringBuilder1.toString());
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("end must greater than or equals start. start ");
        stringBuilder.append(k);
        stringBuilder.append(",  end ");
        stringBuilder.append(j);
        throw new UnsupportedOperationException(stringBuilder.toString());
      } 
      throw new UnsupportedOperationException();
    }
    
    public JSONPath.Segement[] explain() {
      if (this.path != null && this.path.length() != 0)
        for (JSONPath.Segement[] arrayOfSegement = new JSONPath.Segement[8];; arrayOfSegement = arrayOfSegement1) {
          JSONPath.Segement segement = readSegement();
          if (segement == null) {
            if (this.level == arrayOfSegement.length)
              return arrayOfSegement; 
            JSONPath.Segement[] arrayOfSegement2 = new JSONPath.Segement[this.level];
            System.arraycopy(arrayOfSegement, 0, arrayOfSegement2, 0, this.level);
            return arrayOfSegement2;
          } 
          JSONPath.Segement[] arrayOfSegement1 = arrayOfSegement;
          if (this.level == arrayOfSegement.length) {
            arrayOfSegement1 = new JSONPath.Segement[this.level * 3 / 2];
            System.arraycopy(arrayOfSegement, 0, arrayOfSegement1, 0, this.level);
          } 
          int i = this.level;
          this.level = i + 1;
          arrayOfSegement1[i] = segement;
        }  
      throw new IllegalArgumentException();
    }
    
    boolean isEOF() {
      boolean bool;
      if (this.pos >= this.path.length()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void next() {
      String str = this.path;
      int i = this.pos;
      this.pos = i + 1;
      this.ch = str.charAt(i);
    }
    
    JSONPath.Segement parseArrayAccess(boolean param1Boolean) {
      String str2;
      String[] arrayOfString;
      if (param1Boolean)
        accept('['); 
      int i = this.ch;
      boolean bool1 = false;
      boolean bool2 = false;
      if (i == 63) {
        next();
        accept('(');
        if (this.ch == '@') {
          next();
          accept('.');
        } 
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0 || IOUtils.firstIdentifier(this.ch)) {
        String[] arrayOfString1;
        str2 = readName();
        skipWhitespace();
        if (i != 0 && this.ch == ')') {
          next();
          if (param1Boolean)
            accept(']'); 
          return new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2));
        } 
        if (param1Boolean && this.ch == ']') {
          next();
          return new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2));
        } 
        JSONPath.Operator operator = readOp();
        skipWhitespace();
        if (operator == JSONPath.Operator.BETWEEN || operator == JSONPath.Operator.NOT_BETWEEN) {
          if (operator == JSONPath.Operator.NOT_BETWEEN) {
            param1Boolean = true;
          } else {
            param1Boolean = false;
          } 
          Object object = readValue();
          if ("and".equalsIgnoreCase(readName())) {
            Object object1 = readValue();
            if (object != null && object1 != null) {
              if (JSONPath.isInt(object.getClass()) && JSONPath.isInt(object1.getClass()))
                return new JSONPath.FilterSegement(new JSONPath.IntBetweenSegement(str2, ((Number)object).longValue(), ((Number)object1).longValue(), param1Boolean)); 
              throw new JSONPathException(this.path);
            } 
            throw new JSONPathException(this.path);
          } 
          throw new JSONPathException(this.path);
        } 
        if (operator == JSONPath.Operator.IN || operator == JSONPath.Operator.NOT_IN) {
          boolean bool;
          if (operator == JSONPath.Operator.NOT_IN) {
            bool = true;
          } else {
            bool = false;
          } 
          accept('(');
          JSONArray jSONArray = new JSONArray();
          jSONArray.add(readValue());
          while (true) {
            JSONPath.Operator operator1;
            skipWhitespace();
            if (this.ch != ',') {
              accept(')');
              if (i != 0)
                accept(')'); 
              if (param1Boolean)
                accept(']'); 
              Iterator<Object> iterator = jSONArray.iterator();
              i = 1;
              boolean bool3 = true;
              boolean bool4 = true;
              while (iterator.hasNext()) {
                Class<?> clazz = (Class<?>)iterator.next();
                if (clazz == null) {
                  if (i != 0)
                    i = 0; 
                  continue;
                } 
                clazz = clazz.getClass();
                char c = i;
                boolean bool5 = bool4;
                if (i != 0) {
                  c = i;
                  bool5 = bool4;
                  if (clazz != Byte.class) {
                    c = i;
                    bool5 = bool4;
                    if (clazz != Short.class) {
                      c = i;
                      bool5 = bool4;
                      if (clazz != Integer.class) {
                        c = i;
                        bool5 = bool4;
                        if (clazz != Long.class) {
                          c = Character.MIN_VALUE;
                          bool5 = false;
                        } 
                      } 
                    } 
                  } 
                } 
                i = c;
                bool4 = bool5;
                if (bool3) {
                  i = c;
                  bool4 = bool5;
                  if (clazz != String.class) {
                    bool3 = false;
                    i = c;
                    bool4 = bool5;
                  } 
                } 
              } 
              if (jSONArray.size() == 1 && jSONArray.get(0) == null)
                return bool ? new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2)) : new JSONPath.FilterSegement(new JSONPath.NullSegement(str2)); 
              if (i != 0) {
                if (jSONArray.size() == 1) {
                  long l = ((Number)jSONArray.get(0)).longValue();
                  if (bool) {
                    operator1 = JSONPath.Operator.NE;
                  } else {
                    operator1 = JSONPath.Operator.EQ;
                  } 
                  return new JSONPath.FilterSegement(new JSONPath.IntOpSegement(str2, l, operator1));
                } 
                long[] arrayOfLong = new long[operator1.size()];
                for (i = bool2; i < arrayOfLong.length; i++)
                  arrayOfLong[i] = ((Number)operator1.get(i)).longValue(); 
                return new JSONPath.FilterSegement(new JSONPath.IntInSegement(str2, arrayOfLong, bool));
              } 
              if (bool3) {
                if (operator1.size() == 1) {
                  String str = operator1.get(0);
                  if (bool) {
                    operator1 = JSONPath.Operator.NE;
                  } else {
                    operator1 = JSONPath.Operator.EQ;
                  } 
                  return new JSONPath.FilterSegement(new JSONPath.StringOpSegement(str2, str, operator1));
                } 
                String[] arrayOfString2 = new String[operator1.size()];
                operator1.toArray((Object[])arrayOfString2);
                return new JSONPath.FilterSegement(new JSONPath.StringInSegement(str2, arrayOfString2, bool));
              } 
              if (bool4) {
                Long[] arrayOfLong = new Long[operator1.size()];
                for (i = bool1; i < arrayOfLong.length; i++) {
                  Number number = operator1.get(i);
                  if (number != null)
                    arrayOfLong[i] = Long.valueOf(number.longValue()); 
                } 
                return new JSONPath.FilterSegement(new JSONPath.IntObjInSegement(str2, arrayOfLong, bool));
              } 
              throw new UnsupportedOperationException();
            } 
            next();
            operator1.add(readValue());
          } 
        } 
        if (this.ch == '\'' || this.ch == '"') {
          String str5;
          String str6 = readString();
          if (i != 0)
            accept(')'); 
          if (param1Boolean)
            accept(']'); 
          if (operator == JSONPath.Operator.RLIKE)
            return new JSONPath.FilterSegement(new JSONPath.RlikeSegement(str2, str6, false)); 
          if (operator == JSONPath.Operator.NOT_RLIKE)
            return new JSONPath.FilterSegement(new JSONPath.RlikeSegement(str2, str6, true)); 
          String str4 = str6;
          if (operator != JSONPath.Operator.LIKE) {
            str4 = str6;
            JSONPath.Operator operator1 = operator;
            if (operator == JSONPath.Operator.NOT_LIKE) {
              str4 = str6;
            } else {
              return new JSONPath.FilterSegement(new JSONPath.StringOpSegement(str2, str4, operator1));
            } 
          } 
          while (str4.indexOf("%%") != -1)
            str4 = str4.replaceAll("%%", "%"); 
          if (operator == JSONPath.Operator.NOT_LIKE) {
            param1Boolean = true;
          } else {
            param1Boolean = false;
          } 
          i = str4.indexOf('%');
          if (i == -1) {
            JSONPath.Operator operator1;
            if (operator == JSONPath.Operator.LIKE) {
              operator1 = JSONPath.Operator.EQ;
            } else {
              operator1 = JSONPath.Operator.NE;
            } 
            return new JSONPath.FilterSegement(new JSONPath.StringOpSegement(str2, str4, operator1));
          } 
          String[] arrayOfString2 = str4.split("%");
          if (i == 0) {
            if (str4.charAt(str4.length() - 1) == '%') {
              String[] arrayOfString3 = new String[arrayOfString2.length - 1];
              System.arraycopy(arrayOfString2, 1, arrayOfString3, 0, arrayOfString3.length);
              arrayOfString2 = arrayOfString3;
            } else {
              String str = arrayOfString2[arrayOfString2.length - 1];
              if (arrayOfString2.length > 2) {
                String[] arrayOfString3 = new String[arrayOfString2.length - 2];
                System.arraycopy(arrayOfString2, 1, arrayOfString3, 0, arrayOfString3.length);
                arrayOfString2 = arrayOfString3;
                arrayOfString3 = null;
              } else {
                str4 = null;
                str5 = str4;
              } 
              return new JSONPath.FilterSegement(new JSONPath.MatchSegement(str2, str4, str, (String[])str5, param1Boolean));
            } 
          } else {
            String str;
            if (str4.charAt(str4.length() - 1) == '%') {
              str4 = null;
              str = str4;
              return new JSONPath.FilterSegement(new JSONPath.MatchSegement(str2, str4, str, (String[])str5, param1Boolean));
            } 
            if (str5.length == 1) {
              str4 = str5[0];
              str = null;
              str5 = str;
            } else if (str5.length == 2) {
              str4 = str5[0];
              str = str5[1];
              str5 = null;
            } else {
              str4 = str5[0];
              str = str5[str5.length - 1];
              arrayOfString1 = new String[str5.length - 2];
              System.arraycopy(str5, 1, arrayOfString1, 0, arrayOfString1.length);
              arrayOfString = arrayOfString1;
            } 
            return new JSONPath.FilterSegement(new JSONPath.MatchSegement(str2, str4, str, arrayOfString, param1Boolean));
          } 
        } else {
          if (isDigitFirst(this.ch)) {
            double d;
            long l = readLongValue();
            if (this.ch == '.') {
              d = readDoubleValue(l);
            } else {
              d = 0.0D;
            } 
            if (i != 0)
              accept(')'); 
            if (param1Boolean)
              accept(']'); 
            return (d == 0.0D) ? new JSONPath.FilterSegement(new JSONPath.IntOpSegement(str2, l, (JSONPath.Operator)arrayOfString1)) : new JSONPath.FilterSegement(new JSONPath.DoubleOpSegement(str2, d, (JSONPath.Operator)arrayOfString1));
          } 
          if (this.ch == 'n') {
            if ("null".equals(readName())) {
              if (i != 0)
                accept(')'); 
              accept(']');
              if (arrayOfString1 == JSONPath.Operator.EQ)
                return new JSONPath.FilterSegement(new JSONPath.NullSegement(str2)); 
              if (arrayOfString1 == JSONPath.Operator.NE)
                return new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2)); 
              throw new UnsupportedOperationException();
            } 
          } else if (this.ch == 't') {
            if ("true".equals(readName())) {
              if (i != 0)
                accept(')'); 
              accept(']');
              if (arrayOfString1 == JSONPath.Operator.EQ)
                return new JSONPath.FilterSegement(new JSONPath.ValueSegment(str2, Boolean.TRUE, true)); 
              if (arrayOfString1 == JSONPath.Operator.NE)
                return new JSONPath.FilterSegement(new JSONPath.ValueSegment(str2, Boolean.TRUE, false)); 
              throw new UnsupportedOperationException();
            } 
          } else if (this.ch == 'f' && "false".equals(readName())) {
            if (i != 0)
              accept(')'); 
            accept(']');
            if (arrayOfString1 == JSONPath.Operator.EQ)
              return new JSONPath.FilterSegement(new JSONPath.ValueSegment(str2, Boolean.FALSE, true)); 
            if (arrayOfString1 == JSONPath.Operator.NE)
              return new JSONPath.FilterSegement(new JSONPath.ValueSegment(str2, Boolean.FALSE, false)); 
            throw new UnsupportedOperationException();
          } 
          throw new UnsupportedOperationException();
        } 
      } else {
        int j = this.pos;
        while (this.ch != ']' && this.ch != '/' && !isEOF() && (this.ch != '.' || i != 0 || i != 0)) {
          if (this.ch == '\\')
            next(); 
          next();
        } 
        if (param1Boolean) {
          i = this.pos - 1;
        } else if (this.ch == '/' || this.ch == '.') {
          i = this.pos - 1;
        } else {
          i = this.pos;
        } 
        String str = this.path.substring(j - 1, i);
        if (str.indexOf("\\.") != -1)
          return new JSONPath.PropertySegement(str.replaceAll("\\\\\\.", "\\."), false); 
        JSONPath.Segement segement = buildArraySegement(str);
        if (param1Boolean && !isEOF())
          accept(']'); 
        return segement;
      } 
      String str1 = null;
      String str3 = str1;
      return new JSONPath.FilterSegement(new JSONPath.MatchSegement(str2, str1, str3, arrayOfString, param1Boolean));
    }
    
    protected double readDoubleValue(long param1Long) {
      int i = this.pos;
      next();
      while (this.ch >= '0' && this.ch <= '9')
        next(); 
      int j = this.pos;
      double d1 = Double.parseDouble(this.path.substring(i - 1, j - 1));
      double d2 = param1Long;
      Double.isNaN(d2);
      return d1 + d2;
    }
    
    protected long readLongValue() {
      int i = this.pos;
      if (this.ch == '+' || this.ch == '-')
        next(); 
      while (this.ch >= '0' && this.ch <= '9')
        next(); 
      int j = this.pos;
      return Long.parseLong(this.path.substring(i - 1, j - 1));
    }
    
    String readName() {
      skipWhitespace();
      if (this.ch == '\\' || IOUtils.firstIdentifier(this.ch)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        while (!isEOF()) {
          if (this.ch == '\\') {
            next();
            stringBuilder1.append(this.ch);
            if (isEOF())
              break; 
            next();
            continue;
          } 
          if (!IOUtils.isIdent(this.ch))
            break; 
          stringBuilder1.append(this.ch);
          next();
        } 
        if (isEOF() && IOUtils.isIdent(this.ch))
          stringBuilder1.append(this.ch); 
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("illeal jsonpath syntax. ");
      stringBuilder.append(this.path);
      throw new JSONPathException(stringBuilder.toString());
    }
    
    protected JSONPath.Operator readOp() {
      String str1;
      JSONPath.Operator operator;
      if (this.ch == '=') {
        next();
        str1 = (String)JSONPath.Operator.EQ;
      } else if (this.ch == '!') {
        next();
        accept('=');
        str1 = (String)JSONPath.Operator.NE;
      } else if (this.ch == '<') {
        next();
        if (this.ch == '=') {
          next();
          str1 = (String)JSONPath.Operator.LE;
        } else {
          str1 = (String)JSONPath.Operator.LT;
        } 
      } else if (this.ch == '>') {
        next();
        if (this.ch == '=') {
          next();
          str1 = (String)JSONPath.Operator.GE;
        } else {
          str1 = (String)JSONPath.Operator.GT;
        } 
      } else {
        str1 = null;
      } 
      String str2 = str1;
      if (str1 == null) {
        str2 = readName();
        if ("not".equalsIgnoreCase(str2)) {
          skipWhitespace();
          str2 = readName();
          if ("like".equalsIgnoreCase(str2)) {
            operator = JSONPath.Operator.NOT_LIKE;
          } else if ("rlike".equalsIgnoreCase((String)operator)) {
            operator = JSONPath.Operator.NOT_RLIKE;
          } else if ("in".equalsIgnoreCase((String)operator)) {
            operator = JSONPath.Operator.NOT_IN;
          } else if ("between".equalsIgnoreCase((String)operator)) {
            operator = JSONPath.Operator.NOT_BETWEEN;
          } else {
            throw new UnsupportedOperationException();
          } 
        } else if ("like".equalsIgnoreCase((String)operator)) {
          operator = JSONPath.Operator.LIKE;
        } else if ("rlike".equalsIgnoreCase((String)operator)) {
          operator = JSONPath.Operator.RLIKE;
        } else if ("in".equalsIgnoreCase((String)operator)) {
          operator = JSONPath.Operator.IN;
        } else if ("between".equalsIgnoreCase((String)operator)) {
          operator = JSONPath.Operator.BETWEEN;
        } else {
          throw new UnsupportedOperationException();
        } 
      } 
      return operator;
    }
    
    JSONPath.Segement readSegement() {
      int i = this.level;
      boolean bool = true;
      if (i == 0 && this.path.length() == 1) {
        if (isDigitFirst(this.ch))
          return new JSONPath.ArrayAccessSegement(this.ch - 48); 
        if ((this.ch >= 'a' && this.ch <= 'z') || (this.ch >= 'A' && this.ch <= 'Z'))
          return new JSONPath.PropertySegement(Character.toString(this.ch), false); 
      } 
      while (!isEOF()) {
        skipWhitespace();
        if (this.ch == '$') {
          next();
          continue;
        } 
        if (this.ch == '.' || this.ch == '/') {
          i = this.ch;
          next();
          if (i == 46 && this.ch == '.') {
            next();
          } else {
            bool = false;
          } 
          if (this.ch == '*') {
            if (!isEOF())
              next(); 
            return JSONPath.WildCardSegement.instance;
          } 
          if (isDigitFirst(this.ch))
            return parseArrayAccess(false); 
          String str = readName();
          if (this.ch == '(') {
            next();
            if (this.ch == ')') {
              if (!isEOF())
                next(); 
              if ("size".equals(str))
                return JSONPath.SizeSegement.instance; 
              throw new UnsupportedOperationException();
            } 
            throw new UnsupportedOperationException();
          } 
          return new JSONPath.PropertySegement(str, bool);
        } 
        if (this.ch == '[')
          return parseArrayAccess(true); 
        if (this.level == 0)
          return new JSONPath.PropertySegement(readName(), false); 
        throw new UnsupportedOperationException();
      } 
      return null;
    }
    
    String readString() {
      int j;
      char c = this.ch;
      next();
      int i = this.pos;
      while (this.ch != c && !isEOF())
        next(); 
      String str = this.path;
      if (isEOF()) {
        j = this.pos;
      } else {
        j = this.pos - 1;
      } 
      str = str.substring(i - 1, j);
      accept(c);
      return str;
    }
    
    protected Object readValue() {
      skipWhitespace();
      if (isDigitFirst(this.ch))
        return Long.valueOf(readLongValue()); 
      if (this.ch == '"' || this.ch == '\'')
        return readString(); 
      if (this.ch == 'n') {
        if ("null".equals(readName()))
          return null; 
        throw new JSONPathException(this.path);
      } 
      throw new UnsupportedOperationException();
    }
    
    public final void skipWhitespace() {
      while (this.ch <= ' ' && (this.ch == ' ' || this.ch == '\r' || this.ch == '\n' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b'))
        next(); 
    }
  }
  
  static class MatchSegement implements Filter {
    private final String[] containsValues;
    
    private final String endsWithValue;
    
    private final int minLength;
    
    private final boolean not;
    
    private final String propertyName;
    
    private final String startsWithValue;
    
    public MatchSegement(String param1String1, String param1String2, String param1String3, String[] param1ArrayOfString, boolean param1Boolean) {
      this.propertyName = param1String1;
      this.startsWithValue = param1String2;
      this.endsWithValue = param1String3;
      this.containsValues = param1ArrayOfString;
      this.not = param1Boolean;
      byte b = 0;
      if (param1String2 != null) {
        i = param1String2.length() + 0;
      } else {
        i = 0;
      } 
      int j = i;
      if (param1String3 != null)
        j = i + param1String3.length(); 
      int i = j;
      if (param1ArrayOfString != null) {
        int k = param1ArrayOfString.length;
        while (true) {
          i = j;
          if (b < k) {
            j += param1ArrayOfString[b].length();
            b++;
            continue;
          } 
          break;
        } 
      } 
      this.minLength = i;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      int i;
      param1Object1 = this.propertyName;
      byte b = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null)
        return false; 
      param1Object1 = object.toString();
      if (param1Object1.length() < this.minLength)
        return this.not; 
      if (this.startsWithValue != null) {
        if (!param1Object1.startsWith(this.startsWithValue))
          return this.not; 
        i = this.startsWithValue.length() + 0;
      } else {
        i = 0;
      } 
      if (this.containsValues != null) {
        object = this.containsValues;
        int j = object.length;
        while (b < j) {
          param1Object2 = object[b];
          i = param1Object1.indexOf((String)param1Object2, i);
          if (i == -1)
            return this.not; 
          i += param1Object2.length();
          b++;
        } 
      } 
      return (this.endsWithValue != null && !param1Object1.endsWith(this.endsWithValue)) ? this.not : (this.not ^ true);
    }
  }
  
  static class MultiIndexSegement implements Segement {
    private final int[] indexes;
    
    public MultiIndexSegement(int[] param1ArrayOfint) {
      this.indexes = param1ArrayOfint;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      param1Object1 = new ArrayList(this.indexes.length);
      for (byte b = 0; b < this.indexes.length; b++)
        param1Object1.add(param1JSONPath.getArrayItem(param1Object2, this.indexes[b])); 
      return param1Object1;
    }
  }
  
  static class MultiPropertySegement implements Segement {
    private final String[] propertyNames;
    
    public MultiPropertySegement(String[] param1ArrayOfString) {
      this.propertyNames = param1ArrayOfString;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      ArrayList<Object> arrayList = new ArrayList(this.propertyNames.length);
      param1Object1 = this.propertyNames;
      int i = param1Object1.length;
      for (byte b = 0; b < i; b++)
        arrayList.add(param1JSONPath.getPropertyValue(param1Object2, (String)param1Object1[b], true)); 
      return arrayList;
    }
  }
  
  static class NotNullSegement implements Filter {
    private final String propertyName;
    
    public NotNullSegement(String param1String) {
      this.propertyName = param1String;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool = false;
      if (param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false) != null)
        bool = true; 
      return bool;
    }
  }
  
  static class NullSegement implements Filter {
    private final String propertyName;
    
    public NullSegement(String param1String) {
      this.propertyName = param1String;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool = false;
      if (param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false) == null)
        bool = true; 
      return bool;
    }
  }
  
  enum Operator {
    BETWEEN, EQ, GE, GT, IN, LE, LIKE, LT, NE, NOT_BETWEEN, NOT_IN, NOT_LIKE, NOT_RLIKE, RLIKE;
    
    static {
      GE = new Operator("GE", 3);
      LT = new Operator("LT", 4);
      LE = new Operator("LE", 5);
      LIKE = new Operator("LIKE", 6);
      NOT_LIKE = new Operator("NOT_LIKE", 7);
      RLIKE = new Operator("RLIKE", 8);
      NOT_RLIKE = new Operator("NOT_RLIKE", 9);
      IN = new Operator("IN", 10);
      NOT_IN = new Operator("NOT_IN", 11);
      BETWEEN = new Operator("BETWEEN", 12);
      NOT_BETWEEN = new Operator("NOT_BETWEEN", 13);
      $VALUES = new Operator[] { 
          EQ, NE, GT, GE, LT, LE, LIKE, NOT_LIKE, RLIKE, NOT_RLIKE, 
          IN, NOT_IN, BETWEEN, NOT_BETWEEN };
    }
  }
  
  static class PropertySegement implements Segement {
    private final boolean deep;
    
    private final String propertyName;
    
    public PropertySegement(String param1String, boolean param1Boolean) {
      this.propertyName = param1String;
      this.deep = param1Boolean;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      if (this.deep) {
        param1Object1 = new ArrayList();
        param1JSONPath.deepScan(param1Object2, this.propertyName, (List<Object>)param1Object1);
        return param1Object1;
      } 
      return param1JSONPath.getPropertyValue(param1Object2, this.propertyName, true);
    }
    
    public boolean remove(JSONPath param1JSONPath, Object param1Object) {
      return param1JSONPath.removePropertyValue(param1Object, this.propertyName);
    }
    
    public void setValue(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      if (this.deep) {
        param1JSONPath.deepSet(param1Object1, this.propertyName, param1Object2);
      } else {
        param1JSONPath.setPropertyValue(param1Object1, this.propertyName, param1Object2);
      } 
    }
  }
  
  static class RangeSegement implements Segement {
    private final int end;
    
    private final int start;
    
    private final int step;
    
    public RangeSegement(int param1Int1, int param1Int2, int param1Int3) {
      this.start = param1Int1;
      this.end = param1Int2;
      this.step = param1Int3;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      int j;
      int k;
      int i = JSONPath.SizeSegement.instance.eval(param1JSONPath, param1Object1, param1Object2).intValue();
      if (this.start >= 0) {
        j = this.start;
      } else {
        j = this.start + i;
      } 
      if (this.end >= 0) {
        k = this.end;
      } else {
        k = this.end + i;
      } 
      int m = (k - j) / this.step + 1;
      if (m == -1)
        return null; 
      param1Object1 = new ArrayList(m);
      while (j <= k && j < i) {
        param1Object1.add(param1JSONPath.getArrayItem(param1Object2, j));
        j += this.step;
      } 
      return param1Object1;
    }
  }
  
  static class RlikeSegement implements Filter {
    private final boolean not;
    
    private final Pattern pattern;
    
    private final String propertyName;
    
    public RlikeSegement(String param1String1, String param1String2, boolean param1Boolean) {
      this.propertyName = param1String1;
      this.pattern = Pattern.compile(param1String2);
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      int i;
      Object object = param1JSONPath.getPropertyValue(param1Object3, this.propertyName, false);
      if (object == null)
        return false; 
      object = object.toString();
      boolean bool1 = this.pattern.matcher((CharSequence)object).matches();
      boolean bool2 = bool1;
      if (this.not)
        i = bool1 ^ true; 
      return i;
    }
  }
  
  static interface Segement {
    Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2);
  }
  
  static class SizeSegement implements Segement {
    public static final SizeSegement instance = new SizeSegement();
    
    public Integer eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return Integer.valueOf(param1JSONPath.evalSize(param1Object2));
    }
  }
  
  static class StringInSegement implements Filter {
    private final boolean not;
    
    private final String propertyName;
    
    private final String[] values;
    
    public StringInSegement(String param1String, String[] param1ArrayOfString, boolean param1Boolean) {
      this.propertyName = param1String;
      this.values = param1ArrayOfString;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      byte b = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      param1Object1 = this.values;
      int i = param1Object1.length;
      while (b < i) {
        param1Object2 = param1Object1[b];
        if (param1Object2 == object)
          return this.not ^ true; 
        if (param1Object2 != null && param1Object2.equals(object))
          return this.not ^ true; 
        b++;
      } 
      return this.not;
    }
  }
  
  static class StringOpSegement implements Filter {
    private final JSONPath.Operator op;
    
    private final String propertyName;
    
    private final String value;
    
    public StringOpSegement(String param1String1, String param1String2, JSONPath.Operator param1Operator) {
      this.propertyName = param1String1;
      this.value = param1String2;
      this.op = param1Operator;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (this.op == JSONPath.Operator.EQ)
        return this.value.equals(object); 
      if (this.op == JSONPath.Operator.NE)
        return this.value.equals(object) ^ true; 
      if (object == null)
        return false; 
      int i = this.value.compareTo(object.toString());
      if (this.op == JSONPath.Operator.GE) {
        if (i <= 0)
          bool4 = true; 
        return bool4;
      } 
      if (this.op == JSONPath.Operator.GT) {
        bool4 = bool1;
        if (i < 0)
          bool4 = true; 
        return bool4;
      } 
      if (this.op == JSONPath.Operator.LE) {
        bool4 = bool2;
        if (i >= 0)
          bool4 = true; 
        return bool4;
      } 
      if (this.op == JSONPath.Operator.LT) {
        bool4 = bool3;
        if (i > 0)
          bool4 = true; 
        return bool4;
      } 
      return false;
    }
  }
  
  static class ValueSegment implements Filter {
    private boolean eq = true;
    
    private final String propertyName;
    
    private final Object value;
    
    public ValueSegment(String param1String, Object param1Object, boolean param1Boolean) {
      if (param1Object != null) {
        this.propertyName = param1String;
        this.value = param1Object;
        this.eq = param1Boolean;
        return;
      } 
      throw new IllegalArgumentException("value is null");
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      int i;
      Object object = param1JSONPath.getPropertyValue(param1Object3, this.propertyName, false);
      boolean bool1 = this.value.equals(object);
      boolean bool2 = bool1;
      if (!this.eq)
        i = bool1 ^ true; 
      return i;
    }
  }
  
  static class WildCardSegement implements Segement {
    public static WildCardSegement instance = new WildCardSegement();
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1JSONPath.getPropertyValues(param1Object2);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\JSONPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */