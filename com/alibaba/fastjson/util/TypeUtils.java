package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TypeUtils {
  private static Class<? extends Annotation> class_OneToMany;
  
  private static boolean class_OneToMany_error = false;
  
  public static boolean compatibleWithFieldName = false;
  
  public static boolean compatibleWithJavaBean = false;
  
  private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap<String, Class<?>>(16, 0.75F, 1);
  
  private static Method method_HibernateIsInitialized;
  
  private static boolean method_HibernateIsInitialized_error = false;
  
  private static Class<?> optionalClass;
  
  private static boolean optionalClassInited = false;
  
  private static Method oracleDateMethod;
  
  private static boolean oracleDateMethodInited = false;
  
  private static Method oracleTimestampMethod;
  
  private static boolean oracleTimestampMethodInited = false;
  
  private static Class<?> pathClass;
  
  private static boolean pathClass_error = false;
  
  private static boolean setAccessibleEnable = true;
  
  private static Class<? extends Annotation> transientClass;
  
  private static boolean transientClassInited;
  
  private static void addBaseClassMappings() {
    mappings.put("byte", byte.class);
    mappings.put("short", short.class);
    mappings.put("int", int.class);
    mappings.put("long", long.class);
    mappings.put("float", float.class);
    mappings.put("double", double.class);
    mappings.put("boolean", boolean.class);
    mappings.put("char", char.class);
    mappings.put("[byte", byte[].class);
    mappings.put("[short", short[].class);
    mappings.put("[int", int[].class);
    mappings.put("[long", long[].class);
    mappings.put("[float", float[].class);
    mappings.put("[double", double[].class);
    mappings.put("[boolean", boolean[].class);
    mappings.put("[char", char[].class);
    mappings.put("[B", byte[].class);
    mappings.put("[S", short[].class);
    mappings.put("[I", int[].class);
    mappings.put("[J", long[].class);
    mappings.put("[F", float[].class);
    mappings.put("[D", double[].class);
    mappings.put("[C", char[].class);
    mappings.put("[Z", boolean[].class);
    Class[] arrayOfClass = new Class[58];
    boolean bool = false;
    arrayOfClass[0] = Object.class;
    arrayOfClass[1] = Cloneable.class;
    arrayOfClass[2] = loadClass("java.lang.AutoCloseable");
    arrayOfClass[3] = Exception.class;
    arrayOfClass[4] = RuntimeException.class;
    arrayOfClass[5] = IllegalAccessError.class;
    arrayOfClass[6] = IllegalAccessException.class;
    arrayOfClass[7] = IllegalArgumentException.class;
    arrayOfClass[8] = IllegalMonitorStateException.class;
    arrayOfClass[9] = IllegalStateException.class;
    arrayOfClass[10] = IllegalThreadStateException.class;
    arrayOfClass[11] = IndexOutOfBoundsException.class;
    arrayOfClass[12] = InstantiationError.class;
    arrayOfClass[13] = InstantiationException.class;
    arrayOfClass[14] = InternalError.class;
    arrayOfClass[15] = InterruptedException.class;
    arrayOfClass[16] = LinkageError.class;
    arrayOfClass[17] = NegativeArraySizeException.class;
    arrayOfClass[18] = NoClassDefFoundError.class;
    arrayOfClass[19] = NoSuchFieldError.class;
    arrayOfClass[20] = NoSuchFieldException.class;
    arrayOfClass[21] = NoSuchMethodError.class;
    arrayOfClass[22] = NoSuchMethodException.class;
    arrayOfClass[23] = NullPointerException.class;
    arrayOfClass[24] = NumberFormatException.class;
    arrayOfClass[25] = OutOfMemoryError.class;
    arrayOfClass[26] = SecurityException.class;
    arrayOfClass[27] = StackOverflowError.class;
    arrayOfClass[28] = StringIndexOutOfBoundsException.class;
    arrayOfClass[29] = TypeNotPresentException.class;
    arrayOfClass[30] = VerifyError.class;
    arrayOfClass[31] = StackTraceElement.class;
    arrayOfClass[32] = HashMap.class;
    arrayOfClass[33] = Hashtable.class;
    arrayOfClass[34] = TreeMap.class;
    arrayOfClass[35] = IdentityHashMap.class;
    arrayOfClass[36] = WeakHashMap.class;
    arrayOfClass[37] = LinkedHashMap.class;
    arrayOfClass[38] = HashSet.class;
    arrayOfClass[39] = LinkedHashSet.class;
    arrayOfClass[40] = TreeSet.class;
    arrayOfClass[41] = TimeUnit.class;
    arrayOfClass[42] = ConcurrentHashMap.class;
    arrayOfClass[43] = loadClass("java.util.concurrent.ConcurrentSkipListMap");
    arrayOfClass[44] = loadClass("java.util.concurrent.ConcurrentSkipListSet");
    arrayOfClass[45] = AtomicInteger.class;
    arrayOfClass[46] = AtomicLong.class;
    arrayOfClass[47] = Collections.EMPTY_MAP.getClass();
    arrayOfClass[48] = BitSet.class;
    arrayOfClass[49] = Calendar.class;
    arrayOfClass[50] = Date.class;
    arrayOfClass[51] = Locale.class;
    arrayOfClass[52] = UUID.class;
    arrayOfClass[53] = Time.class;
    arrayOfClass[54] = Date.class;
    arrayOfClass[55] = Timestamp.class;
    arrayOfClass[56] = SimpleDateFormat.class;
    arrayOfClass[57] = JSONObject.class;
    int i = arrayOfClass.length;
    byte b;
    for (b = 0; b < i; b++) {
      Class<?> clazz = arrayOfClass[b];
      if (clazz != null)
        mappings.put(clazz.getName(), clazz); 
    } 
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "java.awt.Rectangle";
    arrayOfString[1] = "java.awt.Point";
    arrayOfString[2] = "java.awt.Font";
    arrayOfString[3] = "java.awt.Color";
    i = arrayOfString.length;
    for (b = 0; b < i; b++) {
      Class<?> clazz = loadClass(arrayOfString[b]);
      if (clazz == null)
        break; 
      mappings.put(clazz.getName(), clazz);
    } 
    arrayOfString = new String[4];
    arrayOfString[0] = "org.springframework.util.LinkedMultiValueMap";
    arrayOfString[1] = "org.springframework.util.LinkedCaseInsensitiveMap";
    arrayOfString[2] = "org.springframework.remoting.support.RemoteInvocation";
    arrayOfString[3] = "org.springframework.remoting.support.RemoteInvocationResult";
    i = arrayOfString.length;
    for (b = bool; b < i; b++) {
      Class<?> clazz = loadClass(arrayOfString[b]);
      if (clazz == null)
        break; 
      mappings.put(clazz.getName(), clazz);
    } 
  }
  
  public static SerializeBeanInfo buildBeanInfo(Class<?> paramClass, Map<String, String> paramMap, PropertyNamingStrategy paramPropertyNamingStrategy) {
    return buildBeanInfo(paramClass, paramMap, paramPropertyNamingStrategy, false);
  }
  
  public static SerializeBeanInfo buildBeanInfo(Class<?> paramClass, Map<String, String> paramMap, PropertyNamingStrategy paramPropertyNamingStrategy, boolean paramBoolean) {
    List<FieldInfo> list1;
    FieldInfo[] arrayOfFieldInfo1;
    List<FieldInfo> list2;
    FieldInfo[] arrayOfFieldInfo3;
    FieldInfo[] arrayOfFieldInfo4;
    boolean bool;
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    if (jSONType != null) {
      String[] arrayOfString = jSONType.orders();
      String str1 = jSONType.typeName();
      String str2 = str1;
      if (str1.length() == 0)
        str2 = null; 
      bool = SerializerFeature.of(jSONType.serialzeFeatures());
      Class<?> clazz = paramClass.getSuperclass();
      str1 = null;
      while (true) {
        arrayOfFieldInfo6 = (FieldInfo[])str1;
        if (clazz != null) {
          arrayOfFieldInfo6 = (FieldInfo[])str1;
          if (clazz != Object.class) {
            JSONType jSONType1 = clazz.<JSONType>getAnnotation(JSONType.class);
            if (jSONType1 == null) {
              arrayOfFieldInfo6 = (FieldInfo[])str1;
              break;
            } 
            str1 = arrayOfFieldInfo6.typeKey();
            if (str1.length() != 0) {
              arrayOfFieldInfo6 = (FieldInfo[])str1;
              break;
            } 
            clazz = clazz.getSuperclass();
            continue;
          } 
        } 
        break;
      } 
      Class[] arrayOfClass = paramClass.getInterfaces();
      int i = arrayOfClass.length;
      byte b = 0;
      while (true) {
        str1 = (String)arrayOfFieldInfo6;
        if (b < i) {
          JSONType jSONType1 = arrayOfClass[b].<JSONType>getAnnotation(JSONType.class);
          if (jSONType1 != null) {
            str1 = jSONType1.typeKey();
            arrayOfFieldInfo6 = (FieldInfo[])str1;
            if (str1.length() != 0)
              break; 
          } 
          b++;
          continue;
        } 
        break;
      } 
      if (str1 != null && str1.length() == 0) {
        str1 = null;
        String[] arrayOfString1 = arrayOfString;
      } else {
        String[] arrayOfString1 = arrayOfString;
      } 
    } else {
      arrayOfFieldInfo6 = null;
      arrayOfFieldInfo4 = arrayOfFieldInfo6;
      arrayOfFieldInfo3 = arrayOfFieldInfo4;
      bool = false;
    } 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    ParserConfig.parserAllFieldToCache(paramClass, hashMap);
    if (paramBoolean) {
      list2 = computeGettersWithFieldBase(paramClass, paramMap, false, paramPropertyNamingStrategy);
    } else {
      list2 = computeGetters(paramClass, jSONType, paramMap, (Map)hashMap, false, paramPropertyNamingStrategy);
    } 
    FieldInfo[] arrayOfFieldInfo5 = new FieldInfo[list2.size()];
    list2.toArray(arrayOfFieldInfo5);
    if (arrayOfFieldInfo6 != null && arrayOfFieldInfo6.length != 0) {
      if (paramBoolean) {
        list1 = computeGettersWithFieldBase(paramClass, paramMap, true, paramPropertyNamingStrategy);
      } else {
        list1 = computeGetters(paramClass, jSONType, (Map)list1, (Map)hashMap, true, paramPropertyNamingStrategy);
      } 
    } else {
      list1 = new ArrayList<FieldInfo>(list2);
      Collections.sort(list1);
    } 
    FieldInfo[] arrayOfFieldInfo2 = arrayOfFieldInfo5;
    FieldInfo[] arrayOfFieldInfo6 = new FieldInfo[list1.size()];
    list1.toArray(arrayOfFieldInfo6);
    if (Arrays.equals((Object[])arrayOfFieldInfo6, (Object[])arrayOfFieldInfo2)) {
      arrayOfFieldInfo1 = arrayOfFieldInfo2;
    } else {
      arrayOfFieldInfo1 = arrayOfFieldInfo6;
    } 
    return new SerializeBeanInfo(paramClass, jSONType, (String)arrayOfFieldInfo4, (String)arrayOfFieldInfo3, bool, arrayOfFieldInfo2, arrayOfFieldInfo1);
  }
  
  public static <T> T cast(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig) {
    byte b = 0;
    if (paramObject == null)
      return (T)((paramClass == int.class) ? Integer.valueOf(0) : ((paramClass == long.class) ? Long.valueOf(0L) : ((paramClass == short.class) ? Short.valueOf((short)0) : ((paramClass == byte.class) ? Byte.valueOf((byte)0) : ((paramClass == float.class) ? Float.valueOf(0.0F) : ((paramClass == double.class) ? Double.valueOf(0.0D) : ((paramClass == boolean.class) ? Boolean.FALSE : null))))))); 
    if (paramClass != null) {
      Calendar calendar;
      Date date;
      if (paramClass == paramObject.getClass())
        return (T)paramObject; 
      if (paramObject instanceof Map) {
        if (paramClass == Map.class)
          return (T)paramObject; 
        Map<String, Object> map = (Map)paramObject;
        return (T)((paramClass == Object.class && !map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? paramObject : (Object)castToJavaBean(map, paramClass, paramParserConfig));
      } 
      if (paramClass.isArray()) {
        if (paramObject instanceof Collection) {
          Collection collection = (Collection)paramObject;
          paramObject = Array.newInstance(paramClass.getComponentType(), collection.size());
          Iterator iterator = collection.iterator();
          while (iterator.hasNext()) {
            Array.set(paramObject, b, cast(iterator.next(), paramClass.getComponentType(), paramParserConfig));
            b++;
          } 
          return (T)paramObject;
        } 
        if (paramClass == byte[].class)
          return (T)castToBytes(paramObject); 
      } 
      if (paramClass.isAssignableFrom(paramObject.getClass()))
        return (T)paramObject; 
      if (paramClass == boolean.class || paramClass == Boolean.class)
        return (T)castToBoolean(paramObject); 
      if (paramClass == byte.class || paramClass == Byte.class)
        return (T)castToByte(paramObject); 
      if (paramClass == char.class || paramClass == Character.class)
        return (T)castToChar(paramObject); 
      if (paramClass == short.class || paramClass == Short.class)
        return (T)castToShort(paramObject); 
      if (paramClass == int.class || paramClass == Integer.class)
        return (T)castToInt(paramObject); 
      if (paramClass == long.class || paramClass == Long.class)
        return (T)castToLong(paramObject); 
      if (paramClass == float.class || paramClass == Float.class)
        return (T)castToFloat(paramObject); 
      if (paramClass == double.class || paramClass == Double.class)
        return (T)castToDouble(paramObject); 
      if (paramClass == String.class)
        return (T)castToString(paramObject); 
      if (paramClass == BigDecimal.class)
        return (T)castToBigDecimal(paramObject); 
      if (paramClass == BigInteger.class)
        return (T)castToBigInteger(paramObject); 
      if (paramClass == Date.class)
        return (T)castToDate(paramObject); 
      if (paramClass == Date.class)
        return (T)castToSqlDate(paramObject); 
      if (paramClass == Timestamp.class)
        return (T)castToTimestamp(paramObject); 
      if (paramClass.isEnum())
        return castToEnum(paramObject, paramClass, paramParserConfig); 
      if (Calendar.class.isAssignableFrom(paramClass)) {
        StringBuilder stringBuilder1;
        Date date1 = castToDate(paramObject);
        if (paramClass == Calendar.class) {
          paramObject = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
        } else {
          try {
            paramObject = (Calendar)paramClass.newInstance();
            paramObject.setTime(date1);
            return (T)paramObject;
          } catch (Exception exception) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("can not cast to : ");
            stringBuilder1.append(paramClass.getName());
            throw new JSONException(stringBuilder1.toString(), exception);
          } 
        } 
        exception.setTime((Date)stringBuilder1);
        return (T)exception;
      } 
      if (paramClass.getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
        date = castToDate(exception);
        calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
        calendar.setTime(date);
        return (T)CalendarCodec.instance.createXMLGregorianCalendar(calendar);
      } 
      if (calendar instanceof String) {
        String str = (String)calendar;
        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
          return null; 
        if (date == Currency.class)
          return (T)Currency.getInstance(str); 
        if (date == Locale.class)
          return (T)toLocale(str); 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can not cast to : ");
      stringBuilder.append(date.getName());
      throw new JSONException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("clazz is null");
  }
  
  public static <T> T cast(Object paramObject, ParameterizedType paramParameterizedType, ParserConfig paramParserConfig) {
    ArrayList arrayList;
    HashMap<Object, Object> hashMap;
    Type type = paramParameterizedType.getRawType();
    if (type == Set.class || type == HashSet.class || type == TreeSet.class || type == List.class || type == ArrayList.class) {
      Type type1 = paramParameterizedType.getActualTypeArguments()[0];
      if (paramObject instanceof Iterable) {
        if (type == Set.class || type == HashSet.class) {
          HashSet hashSet = new HashSet();
        } else if (type == TreeSet.class) {
          TreeSet treeSet = new TreeSet();
        } else {
          arrayList = new ArrayList();
        } 
        paramObject = ((Iterable)paramObject).iterator();
        while (paramObject.hasNext())
          arrayList.add(cast(paramObject.next(), type1, paramParserConfig)); 
        return (T)arrayList;
      } 
    } 
    if (type == Map.class || type == HashMap.class) {
      Type type2 = arrayList.getActualTypeArguments()[0];
      Type type1 = arrayList.getActualTypeArguments()[1];
      if (paramObject instanceof Map) {
        hashMap = new HashMap<Object, Object>();
        for (Object paramObject : ((Map)paramObject).entrySet())
          hashMap.put(cast(paramObject.getKey(), type2, paramParserConfig), cast(paramObject.getValue(), type1, paramParserConfig)); 
        return (T)hashMap;
      } 
    } 
    if (paramObject instanceof String && ((String)paramObject).length() == 0)
      return null; 
    if ((hashMap.getActualTypeArguments()).length == 1 && hashMap.getActualTypeArguments()[0] instanceof WildcardType)
      return cast(paramObject, type, paramParserConfig); 
    paramObject = new StringBuilder();
    paramObject.append("can not cast to : ");
    paramObject.append(hashMap);
    throw new JSONException(paramObject.toString());
  }
  
  public static <T> T cast(Object paramObject, Type paramType, ParserConfig paramParserConfig) {
    if (paramObject == null)
      return null; 
    if (paramType instanceof Class)
      return cast(paramObject, (Class<T>)paramType, paramParserConfig); 
    if (paramType instanceof ParameterizedType)
      return cast(paramObject, (ParameterizedType)paramType, paramParserConfig); 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
    } 
    if (paramType instanceof TypeVariable)
      return (T)paramObject; 
    paramObject = new StringBuilder();
    paramObject.append("can not cast to : ");
    paramObject.append(paramType);
    throw new JSONException(paramObject.toString());
  }
  
  public static BigDecimal castToBigDecimal(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof BigDecimal)
      return (BigDecimal)paramObject; 
    if (paramObject instanceof BigInteger)
      return new BigDecimal((BigInteger)paramObject); 
    String str = paramObject.toString();
    return (str.length() == 0) ? null : ((paramObject instanceof Map && ((Map)paramObject).size() == 0) ? null : new BigDecimal(str));
  }
  
  public static BigInteger castToBigInteger(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof BigInteger)
      return (BigInteger)paramObject; 
    if (paramObject instanceof Float || paramObject instanceof Double)
      return BigInteger.valueOf(((Number)paramObject).longValue()); 
    paramObject = paramObject.toString();
    return (paramObject.length() == 0 || "null".equals(paramObject) || "NULL".equals(paramObject)) ? null : new BigInteger((String)paramObject);
  }
  
  public static Boolean castToBoolean(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Boolean)
      return (Boolean)paramObject; 
    if (paramObject instanceof Number) {
      int i = ((Number)paramObject).intValue();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      return Boolean.valueOf(bool);
    } 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
      if ("true".equalsIgnoreCase(str) || "1".equals(str))
        return Boolean.TRUE; 
      if ("false".equalsIgnoreCase(str) || "0".equals(str))
        return Boolean.FALSE; 
      if ("Y".equalsIgnoreCase(str) || "T".equals(str))
        return Boolean.TRUE; 
      if ("F".equalsIgnoreCase(str) || "N".equals(str))
        return Boolean.FALSE; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to boolean, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Byte castToByte(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Byte.valueOf(((Number)paramObject).byteValue()); 
    if (paramObject instanceof String) {
      paramObject = paramObject;
      return (paramObject.length() == 0 || "null".equals(paramObject) || "NULL".equals(paramObject)) ? null : Byte.valueOf(Byte.parseByte((String)paramObject));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to byte, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static byte[] castToBytes(Object paramObject) {
    if (paramObject instanceof byte[])
      return (byte[])paramObject; 
    if (paramObject instanceof String)
      return IOUtils.decodeBase64((String)paramObject); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to int, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Character castToChar(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Character)
      return (Character)paramObject; 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0)
        return null; 
      if (str.length() == 1)
        return Character.valueOf(str.charAt(0)); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("can not cast to char, value : ");
      stringBuilder1.append(paramObject);
      throw new JSONException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to char, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Date castToDate(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Date)
      return (Date)paramObject; 
    if (paramObject instanceof Calendar)
      return ((Calendar)paramObject).getTime(); 
    long l = -1L;
    if (paramObject instanceof Number)
      return new Date(((Number)paramObject).longValue()); 
    if (paramObject instanceof String) {
      String str2;
      String str1 = (String)paramObject;
      JSONScanner jSONScanner = new JSONScanner(str1);
      try {
        if (jSONScanner.scanISO8601DateIfMatch(false)) {
          paramObject = jSONScanner.getCalendar().getTime();
          return (Date)paramObject;
        } 
        jSONScanner.close();
        str2 = str1;
        if (str1.startsWith("/Date(")) {
          str2 = str1;
          if (str1.endsWith(")/"))
            str2 = str1.substring(6, str1.length() - 2); 
        } 
        if (str2.indexOf('-') != -1) {
          if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
            paramObject = JSON.DEFFAULT_DATE_FORMAT;
          } else if (str2.length() == 10) {
            paramObject = "yyyy-MM-dd";
          } else if (str2.length() == "yyyy-MM-dd HH:mm:ss".length()) {
            paramObject = "yyyy-MM-dd HH:mm:ss";
          } else if (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') {
            paramObject = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
          } else {
            paramObject = "yyyy-MM-dd HH:mm:ss.SSS";
          } 
          paramObject = new SimpleDateFormat((String)paramObject, JSON.defaultLocale);
          paramObject.setTimeZone(JSON.defaultTimeZone);
          try {
            return paramObject.parse(str2);
          } catch (ParseException parseException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("can not cast to Date, value : ");
            stringBuilder.append(str2);
            throw new JSONException(stringBuilder.toString());
          } 
        } 
        if (str2.length() == 0)
          return null; 
      } finally {
        str2.close();
      } 
    } 
    if (l < 0L) {
      Class<?> clazz = paramObject.getClass();
      if ("oracle.sql.TIMESTAMP".equals(clazz.getName())) {
        if (oracleTimestampMethod == null && !oracleTimestampMethodInited)
          try {
            oracleTimestampMethod = clazz.getMethod("toJdbc", new Class[0]);
          } catch (NoSuchMethodException noSuchMethodException) {
          
          } finally {
            oracleTimestampMethodInited = true;
          }  
        try {
          paramObject = oracleTimestampMethod.invoke(paramObject, new Object[0]);
          return (Date)paramObject;
        } catch (Exception null) {
          throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", exception);
        } 
      } 
      if ("oracle.sql.DATE".equals(noSuchMethodException.getName())) {
        if (oracleDateMethod == null && !oracleDateMethodInited)
          try {
            oracleDateMethod = noSuchMethodException.getMethod("toJdbc", new Class[0]);
          } catch (NoSuchMethodException noSuchMethodException1) {
          
          } finally {
            oracleDateMethodInited = true;
          }  
        try {
          paramObject = oracleDateMethod.invoke(paramObject, new Object[0]);
          return (Date)paramObject;
        } catch (Exception exception) {
          throw new JSONException("can not cast oracle.sql.DATE to Date", exception);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can not cast to Date, value : ");
      stringBuilder.append(exception);
      throw new JSONException(stringBuilder.toString());
    } 
    return new Date(l);
  }
  
  public static Double castToDouble(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Double.valueOf(((Number)paramObject).doubleValue()); 
    if (paramObject instanceof String) {
      String str = paramObject.toString();
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
      paramObject = str;
      if (str.indexOf(',') != 0)
        paramObject = str.replaceAll(",", ""); 
      return Double.valueOf(Double.parseDouble((String)paramObject));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to double, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static <T> T castToEnum(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig) {
    try {
      if (paramObject instanceof String) {
        paramObject = paramObject;
        return (T)((paramObject.length() == 0) ? null : Enum.valueOf((Class)paramClass, (String)paramObject));
      } 
      if (paramObject instanceof Number) {
        int i = ((Number)paramObject).intValue();
        paramObject = paramClass.getEnumConstants();
        if (i < paramObject.length)
          return (T)paramObject[i]; 
      } 
      paramObject = new StringBuilder();
      paramObject.append("can not cast to : ");
      paramObject.append(paramClass.getName());
      throw new JSONException(paramObject.toString());
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can not cast to : ");
      stringBuilder.append(paramClass.getName());
      throw new JSONException(stringBuilder.toString(), exception);
    } 
  }
  
  public static Float castToFloat(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Float.valueOf(((Number)paramObject).floatValue()); 
    if (paramObject instanceof String) {
      String str = paramObject.toString();
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
      paramObject = str;
      if (str.indexOf(',') != 0)
        paramObject = str.replaceAll(",", ""); 
      return Float.valueOf(Float.parseFloat((String)paramObject));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to float, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Integer castToInt(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Integer)
      return (Integer)paramObject; 
    if (paramObject instanceof Number)
      return Integer.valueOf(((Number)paramObject).intValue()); 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
      paramObject = str;
      if (str.indexOf(',') != 0)
        paramObject = str.replaceAll(",", ""); 
      return Integer.valueOf(Integer.parseInt((String)paramObject));
    } 
    if (paramObject instanceof Boolean)
      return Integer.valueOf(((Boolean)paramObject).booleanValue()); 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
        paramObject = map.values().iterator();
        paramObject.next();
        return castToInt(paramObject.next());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to int, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static <T> T castToJavaBean(Object paramObject, Class<T> paramClass) {
    return cast(paramObject, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static <T> T castToJavaBean(Map<String, Object> paramMap, Class<T> paramClass, ParserConfig paramParserConfig) {
    int i = 0;
    if (paramClass == StackTraceElement.class)
      try {
        str1 = (String)paramMap.get("className");
        String str = (String)paramMap.get("methodName");
        str2 = (String)paramMap.get("fileName");
        Number number = (Number)paramMap.get("lineNumber");
        if (number != null)
          i = number.intValue(); 
        return (T)new StackTraceElement(str1, str, str2, i);
      } catch (Exception exception) {
        throw new JSONException(exception.getMessage(), exception);
      }  
    Object object3 = exception.get(JSON.DEFAULT_TYPE_KEY);
    boolean bool = object3 instanceof String;
    Object object = null;
    Object object2 = str2;
    if (bool) {
      object2 = object3;
      object3 = str2;
      if (str2 == null)
        object3 = ParserConfig.global; 
      Class<T> clazz = object3.checkAutoType((String)object2, null);
      if (clazz != null) {
        object2 = object3;
        if (!clazz.equals(str1))
          return castToJavaBean((Map<String, Object>)exception, clazz, (ParserConfig)object3); 
      } else {
        classNotFoundException = new ClassNotFoundException();
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append((String)object2);
        stringBuilder.append(" not found");
        this(stringBuilder.toString());
        throw classNotFoundException;
      } 
    } 
    if (classNotFoundException.isInterface()) {
      if (stringBuilder instanceof JSONObject) {
        jSONObject = (JSONObject)stringBuilder;
      } else {
        jSONObject = new JSONObject((Map)jSONObject);
      } 
      Object object4 = object2;
      if (object2 == null)
        object4 = ParserConfig.getGlobalInstance(); 
      return (T)(((ObjectDeserializer)object4.getDeserializers().get(classNotFoundException) != null) ? JSON.parseObject(JSON.toJSONString(jSONObject), (Class)classNotFoundException) : Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { (Class)classNotFoundException }, (InvocationHandler)jSONObject));
    } 
    if (classNotFoundException == Locale.class) {
      object3 = jSONObject.get("language");
      str2 = (String)jSONObject.get("country");
      if (object3 instanceof String) {
        object3 = object3;
        if (str2 instanceof String)
          return (T)new Locale((String)object3, str2); 
        if (str2 == null)
          return (T)new Locale((String)object3); 
      } 
    } 
    if (classNotFoundException == String.class && jSONObject instanceof JSONObject)
      return (T)jSONObject.toString(); 
    Object object1 = object2;
    if (object2 == null)
      object1 = ParserConfig.getGlobalInstance(); 
    object3 = object1.getDeserializer((Type)classNotFoundException);
    object2 = object;
    if (object3 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer)
      object2 = object3; 
    if (object2 != null)
      return (T)object2.createInstance((Map)jSONObject, (ParserConfig)object1); 
    JSONException jSONException = new JSONException();
    object1 = new StringBuilder();
    super();
    StringBuilder stringBuilder;
    JSONObject jSONObject;
    String str1;
    ClassNotFoundException classNotFoundException;
    String str2;
    object1.append("can not get javaBeanDeserializer. ");
    object1.append(classNotFoundException.getName());
    this(object1.toString());
    throw jSONException;
  }
  
  public static Long castToLong(Object paramObject) {
    String str = null;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Long.valueOf(((Number)paramObject).longValue()); 
    if (paramObject instanceof String) {
      String str1 = (String)paramObject;
      if (str1.length() == 0 || "null".equals(str1) || "NULL".equals(str1))
        return null; 
      String str2 = str1;
      if (str1.indexOf(',') != 0)
        str2 = str1.replaceAll(",", ""); 
      try {
        long l = Long.parseLong(str2);
        return Long.valueOf(l);
      } catch (NumberFormatException numberFormatException) {
        Calendar calendar;
        JSONScanner jSONScanner = new JSONScanner(str2);
        str2 = str;
        if (jSONScanner.scanISO8601DateIfMatch(false))
          calendar = jSONScanner.getCalendar(); 
        jSONScanner.close();
        if (calendar != null)
          return Long.valueOf(calendar.getTimeInMillis()); 
      } 
    } 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
        paramObject = map.values().iterator();
        paramObject.next();
        return castToLong(paramObject.next());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to long, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Short castToShort(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Short.valueOf(((Number)paramObject).shortValue()); 
    if (paramObject instanceof String) {
      paramObject = paramObject;
      return (paramObject.length() == 0 || "null".equals(paramObject) || "NULL".equals(paramObject)) ? null : Short.valueOf(Short.parseShort((String)paramObject));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to short, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Date castToSqlDate(Object paramObject) {
    long l;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Date)
      return (Date)paramObject; 
    if (paramObject instanceof Date)
      return new Date(((Date)paramObject).getTime()); 
    if (paramObject instanceof Calendar)
      return new Date(((Calendar)paramObject).getTimeInMillis()); 
    if (paramObject instanceof Number) {
      l = ((Number)paramObject).longValue();
    } else {
      l = 0L;
    } 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
      if (isNumber(str)) {
        l = Long.parseLong(str);
      } else {
        JSONScanner jSONScanner = new JSONScanner(str);
        if (jSONScanner.scanISO8601DateIfMatch(false)) {
          l = jSONScanner.getCalendar().getTime().getTime();
        } else {
          paramObject = new StringBuilder();
          paramObject.append("can not cast to Timestamp, value : ");
          paramObject.append(str);
          throw new JSONException(paramObject.toString());
        } 
      } 
    } 
    if (l > 0L)
      return new Date(l); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to Date, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static String castToString(Object paramObject) {
    return (paramObject == null) ? null : paramObject.toString();
  }
  
  public static Timestamp castToTimestamp(Object paramObject) {
    long l;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Calendar)
      return new Timestamp(((Calendar)paramObject).getTimeInMillis()); 
    if (paramObject instanceof Timestamp)
      return (Timestamp)paramObject; 
    if (paramObject instanceof Date)
      return new Timestamp(((Date)paramObject).getTime()); 
    if (paramObject instanceof Number) {
      l = ((Number)paramObject).longValue();
    } else {
      l = 0L;
    } 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
      if (isNumber(str)) {
        l = Long.parseLong(str);
      } else {
        JSONScanner jSONScanner = new JSONScanner(str);
        if (jSONScanner.scanISO8601DateIfMatch(false)) {
          l = jSONScanner.getCalendar().getTime().getTime();
        } else {
          paramObject = new StringBuilder();
          paramObject.append("can not cast to Timestamp, value : ");
          paramObject.append(str);
          throw new JSONException(paramObject.toString());
        } 
      } 
    } 
    if (l > 0L)
      return new Timestamp(l); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to Timestamp, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static void clearClassMapping() {
    mappings.clear();
    addBaseClassMappings();
  }
  
  private static void computeFields(Class<?> paramClass, Map<String, String> paramMap, PropertyNamingStrategy paramPropertyNamingStrategy, Map<String, FieldInfo> paramMap1, Field[] paramArrayOfField) {
    int i = paramArrayOfField.length;
    for (byte b = 0; b < i; b++) {
      boolean bool1;
      boolean bool2;
      String str3;
      boolean bool3;
      Field field = paramArrayOfField[b];
      if (Modifier.isStatic(field.getModifiers()))
        continue; 
      JSONField jSONField = field.<JSONField>getAnnotation(JSONField.class);
      String str1 = field.getName();
      String str2 = null;
      if (jSONField != null) {
        if (!jSONField.serialize())
          continue; 
        bool1 = jSONField.ordinal();
        bool2 = SerializerFeature.of(jSONField.serialzeFeatures());
        int j = Feature.of(jSONField.parseFeatures());
        if (jSONField.name().length() != 0)
          str1 = jSONField.name(); 
        if (jSONField.label().length() != 0)
          str2 = jSONField.label(); 
        str3 = str2;
        str2 = str1;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = j;
      } else {
        str3 = null;
        bool3 = false;
        bool1 = false;
        bool2 = false;
        str2 = str1;
      } 
      str1 = str2;
      if (paramMap != null) {
        str2 = paramMap.get(str2);
        str1 = str2;
        if (str2 == null)
          continue; 
      } 
      str2 = str1;
      if (paramPropertyNamingStrategy != null)
        str2 = paramPropertyNamingStrategy.translate(str1); 
      if (!paramMap1.containsKey(str2))
        paramMap1.put(str2, new FieldInfo(str2, null, field, paramClass, null, bool3, bool1, bool2, null, jSONField, str3)); 
      continue;
    } 
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, JSONType paramJSONType, Map<String, String> paramMap, Map<String, Field> paramMap1, boolean paramBoolean, PropertyNamingStrategy paramPropertyNamingStrategy) {
    // Byte code:
    //   0: aload_2
    //   1: astore #6
    //   3: aload #5
    //   5: astore_1
    //   6: new java/util/LinkedHashMap
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #7
    //   15: aload_0
    //   16: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   19: astore #8
    //   21: aload #8
    //   23: arraylength
    //   24: istore #9
    //   26: iconst_0
    //   27: istore #10
    //   29: aload_3
    //   30: astore #11
    //   32: aload_0
    //   33: astore #12
    //   35: iload #10
    //   37: iload #9
    //   39: if_icmpge -> 1521
    //   42: aload #8
    //   44: iload #10
    //   46: aaload
    //   47: astore #13
    //   49: aload #13
    //   51: invokevirtual getName : ()Ljava/lang/String;
    //   54: astore #14
    //   56: aconst_null
    //   57: astore #15
    //   59: aload #13
    //   61: invokevirtual getModifiers : ()I
    //   64: invokestatic isStatic : (I)Z
    //   67: ifeq -> 73
    //   70: goto -> 1515
    //   73: aload #13
    //   75: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   78: getstatic java/lang/Void.TYPE : Ljava/lang/Class;
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifeq -> 90
    //   87: goto -> 70
    //   90: aload #13
    //   92: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   95: arraylength
    //   96: ifeq -> 102
    //   99: goto -> 70
    //   102: aload #13
    //   104: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   107: ldc_w java/lang/ClassLoader
    //   110: if_acmpne -> 116
    //   113: goto -> 70
    //   116: aload #13
    //   118: invokevirtual getName : ()Ljava/lang/String;
    //   121: ldc_w 'getMetaClass'
    //   124: invokevirtual equals : (Ljava/lang/Object;)Z
    //   127: ifeq -> 150
    //   130: aload #13
    //   132: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   135: invokevirtual getName : ()Ljava/lang/String;
    //   138: ldc_w 'groovy.lang.MetaClass'
    //   141: invokevirtual equals : (Ljava/lang/Object;)Z
    //   144: ifeq -> 150
    //   147: goto -> 70
    //   150: aload #13
    //   152: ldc_w com/alibaba/fastjson/annotation/JSONField
    //   155: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   158: checkcast com/alibaba/fastjson/annotation/JSONField
    //   161: astore #16
    //   163: aload #16
    //   165: astore #17
    //   167: aload #16
    //   169: ifnonnull -> 181
    //   172: aload #12
    //   174: aload #13
    //   176: invokestatic getSuperMethodAnnotation : (Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   179: astore #17
    //   181: aload #17
    //   183: ifnull -> 375
    //   186: aload #17
    //   188: invokeinterface serialize : ()Z
    //   193: ifne -> 199
    //   196: goto -> 70
    //   199: aload #17
    //   201: invokeinterface ordinal : ()I
    //   206: istore #18
    //   208: aload #17
    //   210: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   215: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   218: istore #19
    //   220: aload #17
    //   222: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   227: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   230: istore #20
    //   232: aload #17
    //   234: invokeinterface name : ()Ljava/lang/String;
    //   239: invokevirtual length : ()I
    //   242: ifeq -> 326
    //   245: aload #17
    //   247: invokeinterface name : ()Ljava/lang/String;
    //   252: astore #12
    //   254: aload #12
    //   256: astore #15
    //   258: aload #6
    //   260: ifnull -> 289
    //   263: aload #6
    //   265: aload #12
    //   267: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast java/lang/String
    //   275: astore #12
    //   277: aload #12
    //   279: astore #15
    //   281: aload #12
    //   283: ifnonnull -> 289
    //   286: goto -> 70
    //   289: aload #7
    //   291: aload #15
    //   293: new com/alibaba/fastjson/util/FieldInfo
    //   296: dup
    //   297: aload #15
    //   299: aload #13
    //   301: aconst_null
    //   302: aload_0
    //   303: aconst_null
    //   304: iload #18
    //   306: iload #19
    //   308: iload #20
    //   310: aload #17
    //   312: aconst_null
    //   313: aconst_null
    //   314: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   317: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   322: pop
    //   323: goto -> 408
    //   326: iload #18
    //   328: istore #21
    //   330: iload #19
    //   332: istore #22
    //   334: iload #20
    //   336: istore #23
    //   338: aload #17
    //   340: invokeinterface label : ()Ljava/lang/String;
    //   345: invokevirtual length : ()I
    //   348: ifeq -> 384
    //   351: aload #17
    //   353: invokeinterface label : ()Ljava/lang/String;
    //   358: astore #15
    //   360: iload #18
    //   362: istore #21
    //   364: iload #19
    //   366: istore #22
    //   368: iload #20
    //   370: istore #23
    //   372: goto -> 384
    //   375: iconst_0
    //   376: istore #21
    //   378: iconst_0
    //   379: istore #22
    //   381: iconst_0
    //   382: istore #23
    //   384: aload #7
    //   386: astore #24
    //   388: aload #14
    //   390: ldc_w 'get'
    //   393: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   396: ifeq -> 978
    //   399: aload #14
    //   401: invokevirtual length : ()I
    //   404: iconst_4
    //   405: if_icmpge -> 411
    //   408: goto -> 1512
    //   411: aload #14
    //   413: ldc_w 'getClass'
    //   416: invokevirtual equals : (Ljava/lang/Object;)Z
    //   419: ifeq -> 425
    //   422: goto -> 408
    //   425: aload #14
    //   427: ldc_w 'getDeclaringClass'
    //   430: invokevirtual equals : (Ljava/lang/Object;)Z
    //   433: ifeq -> 446
    //   436: aload_0
    //   437: invokevirtual isEnum : ()Z
    //   440: ifeq -> 446
    //   443: goto -> 408
    //   446: aload #14
    //   448: iconst_3
    //   449: invokevirtual charAt : (I)C
    //   452: istore #25
    //   454: iload #25
    //   456: invokestatic isUpperCase : (C)Z
    //   459: ifne -> 541
    //   462: iload #25
    //   464: sipush #512
    //   467: if_icmple -> 473
    //   470: goto -> 541
    //   473: iload #25
    //   475: bipush #95
    //   477: if_icmpne -> 490
    //   480: aload #14
    //   482: iconst_4
    //   483: invokevirtual substring : (I)Ljava/lang/String;
    //   486: astore_1
    //   487: goto -> 608
    //   490: iload #25
    //   492: bipush #102
    //   494: if_icmpne -> 507
    //   497: aload #14
    //   499: iconst_3
    //   500: invokevirtual substring : (I)Ljava/lang/String;
    //   503: astore_1
    //   504: goto -> 608
    //   507: aload #14
    //   509: invokevirtual length : ()I
    //   512: iconst_5
    //   513: if_icmplt -> 408
    //   516: aload #14
    //   518: iconst_4
    //   519: invokevirtual charAt : (I)C
    //   522: invokestatic isUpperCase : (C)Z
    //   525: ifeq -> 408
    //   528: aload #14
    //   530: iconst_3
    //   531: invokevirtual substring : (I)Ljava/lang/String;
    //   534: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   537: astore_1
    //   538: goto -> 608
    //   541: getstatic com/alibaba/fastjson/util/TypeUtils.compatibleWithJavaBean : Z
    //   544: ifeq -> 560
    //   547: aload #14
    //   549: iconst_3
    //   550: invokevirtual substring : (I)Ljava/lang/String;
    //   553: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   556: astore_1
    //   557: goto -> 598
    //   560: new java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial <init> : ()V
    //   567: astore_1
    //   568: aload_1
    //   569: aload #14
    //   571: iconst_3
    //   572: invokevirtual charAt : (I)C
    //   575: invokestatic toLowerCase : (C)C
    //   578: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload_1
    //   583: aload #14
    //   585: iconst_4
    //   586: invokevirtual substring : (I)Ljava/lang/String;
    //   589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_1
    //   594: invokevirtual toString : ()Ljava/lang/String;
    //   597: astore_1
    //   598: aload #11
    //   600: aload #14
    //   602: aload_1
    //   603: iconst_3
    //   604: invokestatic getPropertyNameByCompatibleFieldName : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   607: astore_1
    //   608: aload #12
    //   610: aload_1
    //   611: invokestatic isJSONTypeIgnore : (Ljava/lang/Class;Ljava/lang/String;)Z
    //   614: ifeq -> 620
    //   617: goto -> 408
    //   620: aload_1
    //   621: aload #11
    //   623: invokestatic getFieldFromCache : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/reflect/Field;
    //   626: astore #12
    //   628: aload #12
    //   630: astore #26
    //   632: aload #12
    //   634: ifnonnull -> 694
    //   637: aload #12
    //   639: astore #26
    //   641: aload_1
    //   642: invokevirtual length : ()I
    //   645: iconst_1
    //   646: if_icmple -> 694
    //   649: aload_1
    //   650: iconst_1
    //   651: invokevirtual charAt : (I)C
    //   654: istore #18
    //   656: aload #12
    //   658: astore #26
    //   660: iload #18
    //   662: bipush #65
    //   664: if_icmplt -> 694
    //   667: aload #12
    //   669: astore #26
    //   671: iload #18
    //   673: bipush #90
    //   675: if_icmpgt -> 694
    //   678: aload #14
    //   680: iconst_3
    //   681: invokevirtual substring : (I)Ljava/lang/String;
    //   684: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   687: aload #11
    //   689: invokestatic getFieldFromCache : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/reflect/Field;
    //   692: astore #26
    //   694: aload #26
    //   696: ifnull -> 887
    //   699: aload #26
    //   701: ldc_w com/alibaba/fastjson/annotation/JSONField
    //   704: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   707: checkcast com/alibaba/fastjson/annotation/JSONField
    //   710: astore #16
    //   712: aload_1
    //   713: astore #12
    //   715: aload #16
    //   717: ifnull -> 877
    //   720: aload #16
    //   722: invokeinterface serialize : ()Z
    //   727: ifne -> 733
    //   730: goto -> 408
    //   733: aload #16
    //   735: invokeinterface ordinal : ()I
    //   740: istore #23
    //   742: aload #16
    //   744: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   749: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   752: istore #22
    //   754: aload #16
    //   756: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   761: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   764: istore #21
    //   766: aload #16
    //   768: invokeinterface name : ()Ljava/lang/String;
    //   773: invokevirtual length : ()I
    //   776: ifeq -> 821
    //   779: aload #16
    //   781: invokeinterface name : ()Ljava/lang/String;
    //   786: astore #12
    //   788: aload #12
    //   790: astore_1
    //   791: aload #6
    //   793: ifnull -> 821
    //   796: aload #6
    //   798: aload #12
    //   800: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   805: checkcast java/lang/String
    //   808: astore #12
    //   810: aload #12
    //   812: astore_1
    //   813: aload #12
    //   815: ifnonnull -> 821
    //   818: goto -> 408
    //   821: aload #16
    //   823: invokeinterface label : ()Ljava/lang/String;
    //   828: invokevirtual length : ()I
    //   831: ifeq -> 862
    //   834: aload #16
    //   836: invokeinterface label : ()Ljava/lang/String;
    //   841: astore #15
    //   843: aload #16
    //   845: astore #12
    //   847: iload #21
    //   849: istore #18
    //   851: iload #23
    //   853: istore #21
    //   855: iload #18
    //   857: istore #23
    //   859: goto -> 890
    //   862: iload #23
    //   864: istore #18
    //   866: iload #21
    //   868: istore #23
    //   870: iload #18
    //   872: istore #21
    //   874: aload_1
    //   875: astore #12
    //   877: aload #12
    //   879: astore_1
    //   880: aload #16
    //   882: astore #12
    //   884: goto -> 890
    //   887: aconst_null
    //   888: astore #12
    //   890: aload_1
    //   891: astore #16
    //   893: aload #6
    //   895: ifnull -> 920
    //   898: aload #6
    //   900: aload_1
    //   901: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   906: checkcast java/lang/String
    //   909: astore_1
    //   910: aload_1
    //   911: astore #16
    //   913: aload_1
    //   914: ifnonnull -> 920
    //   917: goto -> 408
    //   920: aload #16
    //   922: astore_1
    //   923: aload #5
    //   925: ifnull -> 936
    //   928: aload #5
    //   930: aload #16
    //   932: invokevirtual translate : (Ljava/lang/String;)Ljava/lang/String;
    //   935: astore_1
    //   936: aload #24
    //   938: aload_1
    //   939: new com/alibaba/fastjson/util/FieldInfo
    //   942: dup
    //   943: aload_1
    //   944: aload #13
    //   946: aload #26
    //   948: aload_0
    //   949: aconst_null
    //   950: iload #21
    //   952: iload #22
    //   954: iload #23
    //   956: aload #17
    //   958: aload #12
    //   960: aload #15
    //   962: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   965: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   970: pop
    //   971: aload #15
    //   973: astore #6
    //   975: goto -> 982
    //   978: aload #15
    //   980: astore #6
    //   982: aload #24
    //   984: astore_1
    //   985: aload #14
    //   987: ldc_w 'is'
    //   990: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   993: ifeq -> 1506
    //   996: aload #14
    //   998: invokevirtual length : ()I
    //   1001: iconst_3
    //   1002: if_icmpge -> 1008
    //   1005: goto -> 1506
    //   1008: aload #13
    //   1010: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   1013: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1016: if_acmpeq -> 1032
    //   1019: aload #13
    //   1021: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   1024: ldc java/lang/Boolean
    //   1026: if_acmpeq -> 1032
    //   1029: goto -> 1506
    //   1032: aload #14
    //   1034: iconst_2
    //   1035: invokevirtual charAt : (I)C
    //   1038: istore #25
    //   1040: iload #25
    //   1042: invokestatic isUpperCase : (C)Z
    //   1045: ifeq -> 1126
    //   1048: getstatic com/alibaba/fastjson/util/TypeUtils.compatibleWithJavaBean : Z
    //   1051: ifeq -> 1068
    //   1054: aload #14
    //   1056: iconst_2
    //   1057: invokevirtual substring : (I)Ljava/lang/String;
    //   1060: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   1063: astore #7
    //   1065: goto -> 1111
    //   1068: new java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial <init> : ()V
    //   1075: astore #7
    //   1077: aload #7
    //   1079: aload #14
    //   1081: iconst_2
    //   1082: invokevirtual charAt : (I)C
    //   1085: invokestatic toLowerCase : (C)C
    //   1088: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload #7
    //   1094: aload #14
    //   1096: iconst_3
    //   1097: invokevirtual substring : (I)Ljava/lang/String;
    //   1100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload #7
    //   1106: invokevirtual toString : ()Ljava/lang/String;
    //   1109: astore #7
    //   1111: aload #11
    //   1113: aload #14
    //   1115: aload #7
    //   1117: iconst_2
    //   1118: invokestatic getPropertyNameByCompatibleFieldName : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1121: astore #7
    //   1123: goto -> 1141
    //   1126: iload #25
    //   1128: bipush #95
    //   1130: if_icmpne -> 1144
    //   1133: aload #14
    //   1135: iconst_3
    //   1136: invokevirtual substring : (I)Ljava/lang/String;
    //   1139: astore #7
    //   1141: goto -> 1162
    //   1144: iload #25
    //   1146: bipush #102
    //   1148: if_icmpne -> 1506
    //   1151: aload #14
    //   1153: iconst_2
    //   1154: invokevirtual substring : (I)Ljava/lang/String;
    //   1157: astore #7
    //   1159: goto -> 1141
    //   1162: aload_0
    //   1163: aload #7
    //   1165: invokestatic isJSONTypeIgnore : (Ljava/lang/Class;Ljava/lang/String;)Z
    //   1168: ifeq -> 1174
    //   1171: goto -> 1029
    //   1174: aload #7
    //   1176: aload #11
    //   1178: invokestatic getFieldFromCache : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/reflect/Field;
    //   1181: astore #24
    //   1183: aload #24
    //   1185: ifnonnull -> 1200
    //   1188: aload #14
    //   1190: aload #11
    //   1192: invokestatic getFieldFromCache : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/reflect/Field;
    //   1195: astore #24
    //   1197: goto -> 1200
    //   1200: aload #24
    //   1202: ifnull -> 1368
    //   1205: aload #24
    //   1207: ldc_w com/alibaba/fastjson/annotation/JSONField
    //   1210: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1213: checkcast com/alibaba/fastjson/annotation/JSONField
    //   1216: astore #15
    //   1218: aload #15
    //   1220: ifnull -> 1361
    //   1223: aload #15
    //   1225: invokeinterface serialize : ()Z
    //   1230: ifne -> 1236
    //   1233: goto -> 1506
    //   1236: aload #15
    //   1238: invokeinterface ordinal : ()I
    //   1243: istore #21
    //   1245: aload #15
    //   1247: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1252: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1255: istore #22
    //   1257: aload #15
    //   1259: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   1264: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   1267: istore #23
    //   1269: aload #15
    //   1271: invokeinterface name : ()Ljava/lang/String;
    //   1276: invokevirtual length : ()I
    //   1279: ifeq -> 1329
    //   1282: aload #15
    //   1284: invokeinterface name : ()Ljava/lang/String;
    //   1289: astore #16
    //   1291: aload_2
    //   1292: astore #12
    //   1294: aload #16
    //   1296: astore #7
    //   1298: aload #12
    //   1300: ifnull -> 1329
    //   1303: aload #12
    //   1305: aload #16
    //   1307: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1312: checkcast java/lang/String
    //   1315: astore #12
    //   1317: aload #12
    //   1319: astore #7
    //   1321: aload #12
    //   1323: ifnonnull -> 1329
    //   1326: goto -> 1410
    //   1329: aload #15
    //   1331: invokeinterface label : ()Ljava/lang/String;
    //   1336: invokevirtual length : ()I
    //   1339: ifeq -> 1354
    //   1342: aload #15
    //   1344: invokeinterface label : ()Ljava/lang/String;
    //   1349: astore #26
    //   1351: goto -> 1375
    //   1354: aload #6
    //   1356: astore #26
    //   1358: goto -> 1375
    //   1361: aload #6
    //   1363: astore #26
    //   1365: goto -> 1375
    //   1368: aconst_null
    //   1369: astore #15
    //   1371: aload #6
    //   1373: astore #26
    //   1375: aload_2
    //   1376: astore #6
    //   1378: aload #7
    //   1380: astore #16
    //   1382: aload #6
    //   1384: ifnull -> 1419
    //   1387: aload #6
    //   1389: aload #7
    //   1391: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1396: checkcast java/lang/String
    //   1399: astore #7
    //   1401: aload #7
    //   1403: astore #16
    //   1405: aload #7
    //   1407: ifnonnull -> 1419
    //   1410: aload_2
    //   1411: astore #6
    //   1413: aload_1
    //   1414: astore #7
    //   1416: goto -> 1512
    //   1419: aload #5
    //   1421: astore #12
    //   1423: aload #16
    //   1425: astore #7
    //   1427: aload #12
    //   1429: ifnull -> 1441
    //   1432: aload #12
    //   1434: aload #16
    //   1436: invokevirtual translate : (Ljava/lang/String;)Ljava/lang/String;
    //   1439: astore #7
    //   1441: aload_1
    //   1442: aload #7
    //   1444: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   1449: ifeq -> 1461
    //   1452: aload_1
    //   1453: astore #7
    //   1455: aload #12
    //   1457: astore_1
    //   1458: goto -> 70
    //   1461: aload_1
    //   1462: aload #7
    //   1464: new com/alibaba/fastjson/util/FieldInfo
    //   1467: dup
    //   1468: aload #7
    //   1470: aload #13
    //   1472: aload #24
    //   1474: aload_0
    //   1475: aconst_null
    //   1476: iload #21
    //   1478: iload #22
    //   1480: iload #23
    //   1482: aload #17
    //   1484: aload #15
    //   1486: aload #26
    //   1488: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1491: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1496: pop
    //   1497: aload_1
    //   1498: astore #7
    //   1500: aload #12
    //   1502: astore_1
    //   1503: goto -> 1515
    //   1506: aload_2
    //   1507: astore #6
    //   1509: aload_1
    //   1510: astore #7
    //   1512: aload #5
    //   1514: astore_1
    //   1515: iinc #10, 1
    //   1518: goto -> 29
    //   1521: aload_0
    //   1522: aload #6
    //   1524: aload_1
    //   1525: aload #7
    //   1527: aload_0
    //   1528: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   1531: invokestatic computeFields : (Ljava/lang/Class;Ljava/util/Map;Lcom/alibaba/fastjson/PropertyNamingStrategy;Ljava/util/Map;[Ljava/lang/reflect/Field;)V
    //   1534: aload_0
    //   1535: iload #4
    //   1537: aload #7
    //   1539: invokestatic getFieldInfos : (Ljava/lang/Class;ZLjava/util/Map;)Ljava/util/List;
    //   1542: areturn
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, Map<String, String> paramMap) {
    return computeGetters(paramClass, paramMap, true);
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, Map<String, String> paramMap, boolean paramBoolean) {
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    ParserConfig.parserAllFieldToCache(paramClass, hashMap);
    return computeGetters(paramClass, jSONType, paramMap, (Map)hashMap, paramBoolean, PropertyNamingStrategy.CamelCase);
  }
  
  public static List<FieldInfo> computeGettersWithFieldBase(Class<?> paramClass, Map<String, String> paramMap, boolean paramBoolean, PropertyNamingStrategy paramPropertyNamingStrategy) {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    for (Class<?> clazz = paramClass; clazz != null; clazz = clazz.getSuperclass())
      computeFields(clazz, paramMap, paramPropertyNamingStrategy, (Map)linkedHashMap, clazz.getDeclaredFields()); 
    return getFieldInfos(paramClass, paramBoolean, (Map)linkedHashMap);
  }
  
  public static Collection createCollection(Type paramType) {
    StringBuilder stringBuilder;
    Class<?> clazz = getRawClass(paramType);
    if (clazz == AbstractCollection.class || clazz == Collection.class)
      return new ArrayList(); 
    if (clazz.isAssignableFrom(HashSet.class)) {
      HashSet hashSet = new HashSet();
    } else if (clazz.isAssignableFrom(LinkedHashSet.class)) {
      LinkedHashSet linkedHashSet = new LinkedHashSet();
    } else if (clazz.isAssignableFrom(TreeSet.class)) {
      TreeSet treeSet = new TreeSet();
    } else {
      ArrayList arrayList;
      if (clazz.isAssignableFrom(ArrayList.class)) {
        arrayList = new ArrayList();
      } else if (clazz.isAssignableFrom(EnumSet.class)) {
        Type type;
        if (arrayList instanceof ParameterizedType) {
          type = ((ParameterizedType)arrayList).getActualTypeArguments()[0];
        } else {
          type = Object.class;
        } 
        EnumSet<Enum> enumSet = EnumSet.noneOf((Class<Enum>)type);
      } else {
        try {
          Collection collection = (Collection)clazz.newInstance();
        } catch (Exception exception) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("create instance error, class ");
          stringBuilder.append(clazz.getName());
          throw new JSONException(stringBuilder.toString());
        } 
      } 
    } 
    return (Collection)stringBuilder;
  }
  
  public static String decapitalize(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return paramString; 
    if (paramString.length() > 1 && Character.isUpperCase(paramString.charAt(1)) && Character.isUpperCase(paramString.charAt(0)))
      return paramString; 
    char[] arrayOfChar = paramString.toCharArray();
    arrayOfChar[0] = Character.toLowerCase(arrayOfChar[0]);
    return new String(arrayOfChar);
  }
  
  public static Class<?> getClass(Type paramType) {
    return (paramType.getClass() == Class.class) ? (Class)paramType : ((paramType instanceof ParameterizedType) ? getClass(((ParameterizedType)paramType).getRawType()) : ((paramType instanceof TypeVariable) ? (Class)((TypeVariable)paramType).getBounds()[0] : Object.class));
  }
  
  public static Class<?> getClassFromMapping(String paramString) {
    return mappings.get(paramString);
  }
  
  public static Class<?> getCollectionItemClass(Type paramType) {
    if (paramType instanceof ParameterizedType) {
      Type type = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      paramType = type;
      if (type instanceof WildcardType) {
        Type[] arrayOfType = ((WildcardType)type).getUpperBounds();
        paramType = type;
        if (arrayOfType.length == 1)
          paramType = arrayOfType[0]; 
      } 
      if (paramType instanceof Class) {
        paramType = paramType;
        if (Modifier.isPublic(paramType.getModifiers()))
          return (Class<?>)paramType; 
        throw new JSONException("can not create ASMParser");
      } 
      throw new JSONException("can not create ASMParser");
    } 
    return Object.class;
  }
  
  public static Type getCollectionItemType(Type paramType) {
    // Byte code:
    //   0: aload_0
    //   1: instanceof java/lang/reflect/ParameterizedType
    //   4: ifeq -> 53
    //   7: aload_0
    //   8: checkcast java/lang/reflect/ParameterizedType
    //   11: invokeinterface getActualTypeArguments : ()[Ljava/lang/reflect/Type;
    //   16: iconst_0
    //   17: aaload
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: aload_1
    //   22: instanceof java/lang/reflect/WildcardType
    //   25: ifeq -> 91
    //   28: aload_1
    //   29: checkcast java/lang/reflect/WildcardType
    //   32: invokeinterface getUpperBounds : ()[Ljava/lang/reflect/Type;
    //   37: astore_2
    //   38: aload_1
    //   39: astore_0
    //   40: aload_2
    //   41: arraylength
    //   42: iconst_1
    //   43: if_icmpne -> 91
    //   46: aload_2
    //   47: iconst_0
    //   48: aaload
    //   49: astore_0
    //   50: goto -> 91
    //   53: aload_0
    //   54: instanceof java/lang/Class
    //   57: ifeq -> 89
    //   60: aload_0
    //   61: checkcast java/lang/Class
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual getName : ()Ljava/lang/String;
    //   69: ldc_w 'java.'
    //   72: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   75: ifne -> 89
    //   78: aload_0
    //   79: invokevirtual getGenericSuperclass : ()Ljava/lang/reflect/Type;
    //   82: invokestatic getCollectionItemType : (Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;
    //   85: astore_0
    //   86: goto -> 91
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: astore_1
    //   93: aload_0
    //   94: ifnonnull -> 100
    //   97: ldc java/lang/Object
    //   99: astore_1
    //   100: aload_1
    //   101: areturn
  }
  
  public static Field getField(Class<?> paramClass, String paramString, Field[] paramArrayOfField) {
    int i = paramArrayOfField.length;
    for (byte b = 0; b < i; b++) {
      Field field = paramArrayOfField[b];
      if (paramString.equals(field.getName()))
        return field; 
    } 
    paramClass = paramClass.getSuperclass();
    return (paramClass != null && paramClass != Object.class) ? getField(paramClass, paramString, paramClass.getDeclaredFields()) : null;
  }
  
  private static List<FieldInfo> getFieldInfos(Class<?> paramClass, boolean paramBoolean, Map<String, FieldInfo> paramMap) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: aload_0
    //   9: ldc_w com/alibaba/fastjson/annotation/JSONType
    //   12: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   15: checkcast com/alibaba/fastjson/annotation/JSONType
    //   18: astore_0
    //   19: iconst_0
    //   20: istore #4
    //   22: aload_0
    //   23: ifnull -> 107
    //   26: aload_0
    //   27: invokeinterface orders : ()[Ljava/lang/String;
    //   32: astore #5
    //   34: aload #5
    //   36: astore_0
    //   37: aload #5
    //   39: ifnull -> 109
    //   42: aload #5
    //   44: astore_0
    //   45: aload #5
    //   47: arraylength
    //   48: aload_2
    //   49: invokeinterface size : ()I
    //   54: if_icmpne -> 109
    //   57: aload #5
    //   59: arraylength
    //   60: istore #6
    //   62: iconst_0
    //   63: istore #7
    //   65: iload #7
    //   67: iload #6
    //   69: if_icmpge -> 98
    //   72: aload_2
    //   73: aload #5
    //   75: iload #7
    //   77: aaload
    //   78: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   83: ifne -> 92
    //   86: aload #5
    //   88: astore_0
    //   89: goto -> 109
    //   92: iinc #7, 1
    //   95: goto -> 65
    //   98: iconst_1
    //   99: istore #7
    //   101: aload #5
    //   103: astore_0
    //   104: goto -> 112
    //   107: aconst_null
    //   108: astore_0
    //   109: iconst_0
    //   110: istore #7
    //   112: iload #7
    //   114: ifeq -> 158
    //   117: aload_0
    //   118: arraylength
    //   119: istore #6
    //   121: iload #4
    //   123: istore #7
    //   125: iload #7
    //   127: iload #6
    //   129: if_icmpge -> 206
    //   132: aload_3
    //   133: aload_2
    //   134: aload_0
    //   135: iload #7
    //   137: aaload
    //   138: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   143: checkcast com/alibaba/fastjson/util/FieldInfo
    //   146: invokeinterface add : (Ljava/lang/Object;)Z
    //   151: pop
    //   152: iinc #7, 1
    //   155: goto -> 125
    //   158: aload_2
    //   159: invokeinterface values : ()Ljava/util/Collection;
    //   164: invokeinterface iterator : ()Ljava/util/Iterator;
    //   169: astore_0
    //   170: aload_0
    //   171: invokeinterface hasNext : ()Z
    //   176: ifeq -> 198
    //   179: aload_3
    //   180: aload_0
    //   181: invokeinterface next : ()Ljava/lang/Object;
    //   186: checkcast com/alibaba/fastjson/util/FieldInfo
    //   189: invokeinterface add : (Ljava/lang/Object;)Z
    //   194: pop
    //   195: goto -> 170
    //   198: iload_1
    //   199: ifeq -> 206
    //   202: aload_3
    //   203: invokestatic sort : (Ljava/util/List;)V
    //   206: aload_3
    //   207: areturn
  }
  
  public static Type getGenericParamType(Type paramType) {
    return (paramType instanceof ParameterizedType) ? paramType : ((paramType instanceof Class) ? getGenericParamType(((Class)paramType).getGenericSuperclass()) : paramType);
  }
  
  public static int getParserFeatures(Class<?> paramClass) {
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    return (jSONType == null) ? 0 : Feature.of(jSONType.parseFeatures());
  }
  
  private static String getPropertyNameByCompatibleFieldName(Map<String, Field> paramMap, String paramString1, String paramString2, int paramInt) {
    if (compatibleWithFieldName && !paramMap.containsKey(paramString2)) {
      paramString1 = paramString1.substring(paramInt);
      if (paramMap.containsKey(paramString1))
        paramString2 = paramString1; 
      return paramString2;
    } 
    return paramString2;
  }
  
  public static Class<?> getRawClass(Type paramType) {
    if (paramType instanceof Class)
      return (Class)paramType; 
    if (paramType instanceof ParameterizedType)
      return getRawClass(((ParameterizedType)paramType).getRawType()); 
    throw new JSONException("TODO");
  }
  
  public static int getSerializeFeatures(Class<?> paramClass) {
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    return (jSONType == null) ? 0 : SerializerFeature.of(jSONType.serialzeFeatures());
  }
  
  public static JSONField getSuperMethodAnnotation(Class<?> paramClass, Method paramMethod) {
    Class[] arrayOfClass = paramClass.getInterfaces();
    if (arrayOfClass.length > 0) {
      Class[] arrayOfClass1 = paramMethod.getParameterTypes();
      int i = arrayOfClass.length;
      for (byte b = 0; b < i; b++) {
        for (Method method : arrayOfClass[b].getMethods()) {
          Class[] arrayOfClass2 = method.getParameterTypes();
          if (arrayOfClass2.length == arrayOfClass1.length && method.getName().equals(paramMethod.getName())) {
            byte b1 = 0;
            while (true) {
              if (b1 < arrayOfClass1.length) {
                if (!arrayOfClass2[b1].equals(arrayOfClass1[b1])) {
                  b1 = 0;
                  break;
                } 
                b1++;
                continue;
              } 
              b1 = 1;
              break;
            } 
            if (b1 != 0) {
              JSONField jSONField = method.<JSONField>getAnnotation(JSONField.class);
              if (jSONField != null)
                return jSONField; 
            } 
          } 
        } 
      } 
    } 
    Class<?> clazz = paramClass.getSuperclass();
    if (clazz == null)
      return null; 
    if (Modifier.isAbstract(clazz.getModifiers())) {
      Class[] arrayOfClass1 = paramMethod.getParameterTypes();
      for (Method method : clazz.getMethods()) {
        Class[] arrayOfClass2 = method.getParameterTypes();
        if (arrayOfClass2.length == arrayOfClass1.length && method.getName().equals(paramMethod.getName())) {
          byte b = 0;
          while (true) {
            if (b < arrayOfClass1.length) {
              if (!arrayOfClass2[b].equals(arrayOfClass1[b])) {
                b = 0;
                break;
              } 
              b++;
              continue;
            } 
            b = 1;
            break;
          } 
          if (b != 0) {
            JSONField jSONField = method.<JSONField>getAnnotation(JSONField.class);
            if (jSONField != null)
              return jSONField; 
          } 
        } 
      } 
    } 
    return null;
  }
  
  public static boolean isAnnotationPresentOneToMany(Method paramMethod) {
    if (paramMethod == null)
      return false; 
    if (class_OneToMany == null && !class_OneToMany_error)
      try {
        class_OneToMany = (Class)Class.forName("javax.persistence.OneToMany");
      } catch (Throwable throwable) {
        class_OneToMany_error = true;
      }  
    return (class_OneToMany == null) ? false : paramMethod.isAnnotationPresent(class_OneToMany);
  }
  
  public static boolean isGenericParamType(Type paramType) {
    if (paramType instanceof ParameterizedType)
      return true; 
    if (paramType instanceof Class) {
      paramType = ((Class)paramType).getGenericSuperclass();
      return (paramType == Object.class) ? false : isGenericParamType(paramType);
    } 
    return false;
  }
  
  public static boolean isHibernateInitialized(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error)
      try {
        method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", new Class[] { Object.class });
      } catch (Throwable throwable) {
        method_HibernateIsInitialized_error = true;
      }  
    if (method_HibernateIsInitialized != null)
      try {
        return ((Boolean)method_HibernateIsInitialized.invoke((Object)null, new Object[] { paramObject })).booleanValue();
      } catch (Throwable throwable) {} 
    return true;
  }
  
  private static boolean isJSONTypeIgnore(Class<?> paramClass, String paramString) {
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    if (jSONType != null) {
      String[] arrayOfString2 = jSONType.includes();
      if (arrayOfString2.length > 0) {
        for (byte b1 = 0; b1 < arrayOfString2.length; b1++) {
          if (paramString.equals(arrayOfString2[b1]))
            return false; 
        } 
        return true;
      } 
      String[] arrayOfString1 = jSONType.ignores();
      for (byte b = 0; b < arrayOfString1.length; b++) {
        if (paramString.equals(arrayOfString1[b]))
          return true; 
      } 
    } 
    return (paramClass.getSuperclass() != Object.class && paramClass.getSuperclass() != null && isJSONTypeIgnore(paramClass.getSuperclass(), paramString));
  }
  
  public static boolean isNumber(String paramString) {
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (c == '+' || c == '-') {
        if (b != 0)
          return false; 
      } else if (c < '0' || c > '9') {
        return false;
      } 
    } 
    return true;
  }
  
  public static boolean isPath(Class<?> paramClass) {
    if (pathClass == null && !pathClass_error)
      try {
        pathClass = Class.forName("java.nio.file.Path");
      } catch (Throwable throwable) {
        pathClass_error = true;
      }  
    return (pathClass != null) ? pathClass.isAssignableFrom(paramClass) : false;
  }
  
  public static boolean isProxy(Class<?> paramClass) {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    for (byte b = 0; b < i; b++) {
      String str = arrayOfClass[b].getName();
      if (str.equals("net.sf.cglib.proxy.Factory") || str.equals("org.springframework.cglib.proxy.Factory"))
        return true; 
      if (str.equals("javassist.util.proxy.ProxyObject") || str.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject"))
        return true; 
    } 
    return false;
  }
  
  public static boolean isTransient(Method paramMethod) {
    boolean bool = false;
    if (paramMethod == null)
      return false; 
    if (!transientClassInited)
      try {
        transientClass = (Class)Class.forName("java.beans.Transient");
      } catch (Exception exception) {
      
      } finally {
        transientClassInited = true;
      }  
    if (transientClass != null) {
      if (paramMethod.getAnnotation(transientClass) != null)
        bool = true; 
      return bool;
    } 
    return false;
  }
  
  public static Class<?> loadClass(String paramString) {
    return loadClass(paramString, null);
  }
  
  public static Class<?> loadClass(String paramString, ClassLoader paramClassLoader) {
    Throwable throwable2;
    Throwable throwable3;
    if (paramString == null || paramString.length() == 0)
      return null; 
    Class<?> clazz1 = mappings.get(paramString);
    if (clazz1 != null)
      return clazz1; 
    if (paramString.charAt(0) == '[')
      return Array.newInstance(loadClass(paramString.substring(1), paramClassLoader), 0).getClass(); 
    if (paramString.startsWith("L") && paramString.endsWith(";"))
      return loadClass(paramString.substring(1, paramString.length() - 1), paramClassLoader); 
    Class<?> clazz2 = clazz1;
    if (paramClassLoader != null) {
      try {
        clazz2 = paramClassLoader.loadClass(paramString);
        try {
          mappings.put(paramString, clazz2);
          return clazz2;
        } catch (Throwable null) {}
      } catch (Throwable throwable) {
        throwable3 = throwable2;
        throwable2 = throwable;
      } 
      throwable2.printStackTrace();
    } 
    try {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      throwable2 = throwable3;
      if (classLoader != null) {
        throwable2 = throwable3;
        if (classLoader != paramClassLoader) {
          Class<?> clazz = classLoader.loadClass(paramString);
          try {
            mappings.put(paramString, clazz);
            return clazz;
          } catch (Throwable throwable) {}
        } 
      } 
    } catch (Throwable throwable) {
      throwable2 = throwable3;
    } 
    try {
      Class<?> clazz = Class.forName(paramString);
      try {
        mappings.put(paramString, clazz);
        return clazz;
      } catch (Throwable throwable) {
        Class<?> clazz3 = clazz;
      } 
    } catch (Throwable throwable1) {
      throwable1 = throwable2;
    } 
    return (Class<?>)throwable1;
  }
  
  static void setAccessible(AccessibleObject paramAccessibleObject) {
    if (!setAccessibleEnable)
      return; 
    if (paramAccessibleObject.isAccessible())
      return; 
    try {
      paramAccessibleObject.setAccessible(true);
    } catch (AccessControlException accessControlException) {
      setAccessibleEnable = false;
    } 
  }
  
  public static Locale toLocale(String paramString) {
    String[] arrayOfString = paramString.split("_");
    return (arrayOfString.length == 1) ? new Locale(arrayOfString[0]) : ((arrayOfString.length == 2) ? new Locale(arrayOfString[0], arrayOfString[1]) : new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]));
  }
  
  public static Type unwrapOptional(Type paramType) {
    if (!optionalClassInited)
      try {
        optionalClass = Class.forName("java.util.Optional");
      } catch (Exception exception) {
      
      } finally {
        optionalClassInited = true;
      }  
    if (paramType instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType)paramType;
      if (parameterizedType.getRawType() == optionalClass)
        return parameterizedType.getActualTypeArguments()[0]; 
    } 
    return paramType;
  }
  
  static {
    try {
      compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty("fastjson.compatibleWithJavaBean"));
      compatibleWithFieldName = "true".equals(IOUtils.getStringProperty("fastjson.compatibleWithFieldName"));
    } catch (Throwable throwable) {}
  }
  
  static {
    addBaseClassMappings();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\TypeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */