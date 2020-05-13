package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;

public class ParserConfig {
  public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
  
  public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
  
  public static final boolean AUTO_SUPPORT;
  
  private static final String[] AUTO_TYPE_ACCEPT_LIST;
  
  public static final String[] DENYS = splitItemsFormProperty(IOUtils.getStringProperty("fastjson.parser.deny"));
  
  public static final String DENY_PROPERTY = "fastjson.parser.deny";
  
  private static boolean awtError;
  
  public static ParserConfig global;
  
  private static boolean jdk8Error;
  
  private String[] acceptList = AUTO_TYPE_ACCEPT_LIST;
  
  private boolean asmEnable = ASMUtils.IS_ANDROID ^ true;
  
  protected ASMDeserializerFactory asmFactory;
  
  private boolean autoTypeSupport = AUTO_SUPPORT;
  
  public boolean compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
  
  protected ClassLoader defaultClassLoader;
  
  private String[] denyList = "bsh,com.mchange,com.sun.,java.lang.Thread,java.net.Socket,java.rmi,javax.xml,org.apache.bcel,org.apache.commons.beanutils,org.apache.commons.collections.Transformer,org.apache.commons.collections.functors,org.apache.commons.collections4.comparators,org.apache.commons.fileupload,org.apache.myfaces.context.servlet,org.apache.tomcat,org.apache.wicket.util,org.apache.xalan,org.codehaus.groovy.runtime,org.hibernate,org.jboss,org.mozilla.javascript,org.python.core,org.springframework".split(",");
  
  private final IdentityHashMap<Type, ObjectDeserializer> deserializers = new IdentityHashMap();
  
  public final boolean fieldBased;
  
  private int maxTypeNameLength = 256;
  
  public PropertyNamingStrategy propertyNamingStrategy;
  
  public final SymbolTable symbolTable = new SymbolTable(4096);
  
  static {
    AUTO_SUPPORT = "true".equals(IOUtils.getStringProperty("fastjson.parser.autoTypeSupport"));
    String[] arrayOfString1 = splitItemsFormProperty(IOUtils.getStringProperty("fastjson.parser.autoTypeAccept"));
    String[] arrayOfString2 = arrayOfString1;
    if (arrayOfString1 == null)
      arrayOfString2 = new String[0]; 
    AUTO_TYPE_ACCEPT_LIST = arrayOfString2;
    global = new ParserConfig();
    awtError = false;
    jdk8Error = false;
  }
  
  public ParserConfig() {
    this(false);
  }
  
  public ParserConfig(ASMDeserializerFactory paramASMDeserializerFactory) {
    this(paramASMDeserializerFactory, null, false);
  }
  
  private ParserConfig(ASMDeserializerFactory paramASMDeserializerFactory, ClassLoader paramClassLoader, boolean paramBoolean) {
    this.fieldBased = paramBoolean;
    ASMDeserializerFactory aSMDeserializerFactory = paramASMDeserializerFactory;
    if (paramASMDeserializerFactory == null) {
      aSMDeserializerFactory = paramASMDeserializerFactory;
      if (!ASMUtils.IS_ANDROID)
        if (paramClassLoader == null) {
          try {
            aSMDeserializerFactory = new ASMDeserializerFactory();
            ASMClassLoader aSMClassLoader = new ASMClassLoader();
            this();
            this((ClassLoader)aSMClassLoader);
          } catch (ExceptionInInitializerError|java.security.AccessControlException|NoClassDefFoundError exceptionInInitializerError) {
            aSMDeserializerFactory = paramASMDeserializerFactory;
          } 
        } else {
          aSMDeserializerFactory = new ASMDeserializerFactory((ClassLoader)exceptionInInitializerError);
        }  
    } 
    this.asmFactory = aSMDeserializerFactory;
    if (aSMDeserializerFactory == null)
      this.asmEnable = false; 
    this.deserializers.put(SimpleDateFormat.class, MiscCodec.instance);
    this.deserializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
    this.deserializers.put(Date.class, SqlDateDeserializer.instance);
    this.deserializers.put(Time.class, TimeDeserializer.instance);
    this.deserializers.put(Date.class, DateCodec.instance);
    this.deserializers.put(Calendar.class, CalendarCodec.instance);
    this.deserializers.put(XMLGregorianCalendar.class, CalendarCodec.instance);
    this.deserializers.put(JSONObject.class, MapDeserializer.instance);
    this.deserializers.put(JSONArray.class, CollectionCodec.instance);
    this.deserializers.put(Map.class, MapDeserializer.instance);
    this.deserializers.put(HashMap.class, MapDeserializer.instance);
    this.deserializers.put(LinkedHashMap.class, MapDeserializer.instance);
    this.deserializers.put(TreeMap.class, MapDeserializer.instance);
    this.deserializers.put(ConcurrentMap.class, MapDeserializer.instance);
    this.deserializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
    this.deserializers.put(Collection.class, CollectionCodec.instance);
    this.deserializers.put(List.class, CollectionCodec.instance);
    this.deserializers.put(ArrayList.class, CollectionCodec.instance);
    this.deserializers.put(Object.class, JavaObjectDeserializer.instance);
    this.deserializers.put(String.class, StringCodec.instance);
    this.deserializers.put(StringBuffer.class, StringCodec.instance);
    this.deserializers.put(StringBuilder.class, StringCodec.instance);
    this.deserializers.put(char.class, CharacterCodec.instance);
    this.deserializers.put(Character.class, CharacterCodec.instance);
    this.deserializers.put(byte.class, NumberDeserializer.instance);
    this.deserializers.put(Byte.class, NumberDeserializer.instance);
    this.deserializers.put(short.class, NumberDeserializer.instance);
    this.deserializers.put(Short.class, NumberDeserializer.instance);
    this.deserializers.put(int.class, IntegerCodec.instance);
    this.deserializers.put(Integer.class, IntegerCodec.instance);
    this.deserializers.put(long.class, LongCodec.instance);
    this.deserializers.put(Long.class, LongCodec.instance);
    this.deserializers.put(BigInteger.class, BigIntegerCodec.instance);
    this.deserializers.put(BigDecimal.class, BigDecimalCodec.instance);
    this.deserializers.put(float.class, FloatCodec.instance);
    this.deserializers.put(Float.class, FloatCodec.instance);
    this.deserializers.put(double.class, NumberDeserializer.instance);
    this.deserializers.put(Double.class, NumberDeserializer.instance);
    this.deserializers.put(boolean.class, BooleanCodec.instance);
    this.deserializers.put(Boolean.class, BooleanCodec.instance);
    this.deserializers.put(Class.class, MiscCodec.instance);
    this.deserializers.put(char[].class, new CharArrayCodec());
    this.deserializers.put(AtomicBoolean.class, BooleanCodec.instance);
    this.deserializers.put(AtomicInteger.class, IntegerCodec.instance);
    this.deserializers.put(AtomicLong.class, LongCodec.instance);
    this.deserializers.put(AtomicReference.class, ReferenceCodec.instance);
    this.deserializers.put(WeakReference.class, ReferenceCodec.instance);
    this.deserializers.put(SoftReference.class, ReferenceCodec.instance);
    this.deserializers.put(UUID.class, MiscCodec.instance);
    this.deserializers.put(TimeZone.class, MiscCodec.instance);
    this.deserializers.put(Locale.class, MiscCodec.instance);
    this.deserializers.put(Currency.class, MiscCodec.instance);
    this.deserializers.put(InetAddress.class, MiscCodec.instance);
    this.deserializers.put(Inet4Address.class, MiscCodec.instance);
    this.deserializers.put(Inet6Address.class, MiscCodec.instance);
    this.deserializers.put(InetSocketAddress.class, MiscCodec.instance);
    this.deserializers.put(File.class, MiscCodec.instance);
    this.deserializers.put(URI.class, MiscCodec.instance);
    this.deserializers.put(URL.class, MiscCodec.instance);
    this.deserializers.put(Pattern.class, MiscCodec.instance);
    this.deserializers.put(Charset.class, MiscCodec.instance);
    this.deserializers.put(JSONPath.class, MiscCodec.instance);
    this.deserializers.put(Number.class, NumberDeserializer.instance);
    this.deserializers.put(AtomicIntegerArray.class, AtomicCodec.instance);
    this.deserializers.put(AtomicLongArray.class, AtomicCodec.instance);
    this.deserializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
    this.deserializers.put(Serializable.class, JavaObjectDeserializer.instance);
    this.deserializers.put(Cloneable.class, JavaObjectDeserializer.instance);
    this.deserializers.put(Comparable.class, JavaObjectDeserializer.instance);
    this.deserializers.put(Closeable.class, JavaObjectDeserializer.instance);
    this.deserializers.put(JSONPObject.class, new JSONPDeserializer());
    addItemsToDeny(DENYS);
    addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
  }
  
  public ParserConfig(ClassLoader paramClassLoader) {
    this(null, paramClassLoader, false);
  }
  
  public ParserConfig(boolean paramBoolean) {
    this(null, null, paramBoolean);
  }
  
  private void addItemsToAccept(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    for (byte b = 0; b < paramArrayOfString.length; b++)
      addAccept(paramArrayOfString[b]); 
  }
  
  private void addItemsToDeny(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    for (byte b = 0; b < paramArrayOfString.length; b++)
      addDeny(paramArrayOfString[b]); 
  }
  
  public static Field getFieldFromCache(String paramString, Map<String, Field> paramMap) {
    Field field1 = paramMap.get(paramString);
    Field field2 = field1;
    if (field1 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_");
      stringBuilder.append(paramString);
      field2 = paramMap.get(stringBuilder.toString());
    } 
    field1 = field2;
    if (field2 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("m_");
      stringBuilder.append(paramString);
      field1 = paramMap.get(stringBuilder.toString());
    } 
    field2 = field1;
    if (field1 == null) {
      char c = paramString.charAt(0);
      field2 = field1;
      if (c >= 'a') {
        field2 = field1;
        if (c <= 'z') {
          char[] arrayOfChar = paramString.toCharArray();
          arrayOfChar[0] = (char)(char)(arrayOfChar[0] - 32);
          field2 = paramMap.get(new String(arrayOfChar));
        } 
      } 
    } 
    return field2;
  }
  
  public static ParserConfig getGlobalInstance() {
    return global;
  }
  
  public static boolean isPrimitive2(Class<?> paramClass) {
    return (paramClass.isPrimitive() || paramClass == Boolean.class || paramClass == Character.class || paramClass == Byte.class || paramClass == Short.class || paramClass == Integer.class || paramClass == Long.class || paramClass == Float.class || paramClass == Double.class || paramClass == BigInteger.class || paramClass == BigDecimal.class || paramClass == String.class || paramClass == Date.class || paramClass == Date.class || paramClass == Time.class || paramClass == Timestamp.class || paramClass.isEnum());
  }
  
  public static void parserAllFieldToCache(Class<?> paramClass, Map<String, Field> paramMap) {
    for (Field field : paramClass.getDeclaredFields()) {
      String str = field.getName();
      if (!paramMap.containsKey(str))
        paramMap.put(str, field); 
    } 
    if (paramClass.getSuperclass() != null && paramClass.getSuperclass() != Object.class)
      parserAllFieldToCache(paramClass.getSuperclass(), paramMap); 
  }
  
  private static String[] splitItemsFormProperty(String paramString) {
    return (paramString != null && paramString.length() > 0) ? paramString.split(",") : null;
  }
  
  public void addAccept(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return; 
    String[] arrayOfString = this.acceptList;
    int i = arrayOfString.length;
    for (byte b = 0; b < i; b++) {
      if (paramString.equals(arrayOfString[b]))
        return; 
    } 
    arrayOfString = new String[this.acceptList.length + 1];
    System.arraycopy(this.acceptList, 0, arrayOfString, 0, this.acceptList.length);
    arrayOfString[arrayOfString.length - 1] = paramString;
    this.acceptList = arrayOfString;
  }
  
  public void addDeny(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return; 
    String[] arrayOfString = this.denyList;
    int i = arrayOfString.length;
    for (byte b = 0; b < i; b++) {
      if (paramString.equals(arrayOfString[b]))
        return; 
    } 
    arrayOfString = new String[this.denyList.length + 1];
    System.arraycopy(this.denyList, 0, arrayOfString, 0, this.denyList.length);
    arrayOfString[arrayOfString.length - 1] = paramString;
    this.denyList = arrayOfString;
  }
  
  public Class<?> checkAutoType(String paramString, Class<?> paramClass) {
    if (paramString == null)
      return null; 
    if (paramString.length() < this.maxTypeNameLength) {
      StringBuilder stringBuilder2;
      String str = paramString.replace('$', '.');
      boolean bool = this.autoTypeSupport;
      byte b = 0;
      if (bool || paramClass != null) {
        byte b1;
        for (b1 = 0; b1 < this.acceptList.length; b1++) {
          if (str.startsWith(this.acceptList[b1]))
            return TypeUtils.loadClass(paramString, this.defaultClassLoader); 
        } 
        b1 = 0;
        while (b1 < this.denyList.length) {
          if (!str.startsWith(this.denyList[b1]) || TypeUtils.getClassFromMapping(paramString) != null) {
            b1++;
            continue;
          } 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("autoType is not support. ");
          stringBuilder1.append(paramString);
          throw new JSONException(stringBuilder1.toString());
        } 
      } 
      Class<?> clazz1 = TypeUtils.getClassFromMapping(paramString);
      Class<?> clazz2 = clazz1;
      if (clazz1 == null)
        clazz2 = this.deserializers.findClass(paramString); 
      if (clazz2 != null) {
        if (stringBuilder1 == null || stringBuilder1.isAssignableFrom(clazz2))
          return clazz2; 
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("type not match. ");
        stringBuilder2.append(paramString);
        stringBuilder2.append(" -> ");
        stringBuilder2.append(stringBuilder1.getName());
        throw new JSONException(stringBuilder2.toString());
      } 
      if (!this.autoTypeSupport) {
        byte b1;
        byte b2 = 0;
        while (true) {
          b1 = b;
          if (b2 < this.denyList.length) {
            if (!str.startsWith(this.denyList[b2])) {
              b2++;
              continue;
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("autoType is not support. ");
            stringBuilder1.append(paramString);
            throw new JSONException(stringBuilder1.toString());
          } 
          break;
        } 
        while (b1 < this.acceptList.length) {
          if (str.startsWith(this.acceptList[b1])) {
            clazz2 = TypeUtils.loadClass(paramString, this.defaultClassLoader);
            if (stringBuilder1 == null || !stringBuilder1.isAssignableFrom(clazz2))
              return clazz2; 
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("type not match. ");
            stringBuilder2.append(paramString);
            stringBuilder2.append(" -> ");
            stringBuilder2.append(stringBuilder1.getName());
            throw new JSONException(stringBuilder2.toString());
          } 
          b1++;
        } 
      } 
      if (this.autoTypeSupport || stringBuilder1 != null)
        clazz2 = TypeUtils.loadClass(paramString, this.defaultClassLoader); 
      if (clazz2 != null)
        if (!ClassLoader.class.isAssignableFrom(clazz2) && !DataSource.class.isAssignableFrom(clazz2)) {
          if (stringBuilder1 != null) {
            if (stringBuilder1.isAssignableFrom(clazz2))
              return clazz2; 
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("type not match. ");
            stringBuilder2.append(paramString);
            stringBuilder2.append(" -> ");
            stringBuilder2.append(stringBuilder1.getName());
            throw new JSONException(stringBuilder2.toString());
          } 
        } else {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("autoType is not support. ");
          stringBuilder1.append(paramString);
          throw new JSONException(stringBuilder1.toString());
        }  
      if (this.autoTypeSupport)
        return (Class<?>)stringBuilder2; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("autoType is not support. ");
      stringBuilder1.append(paramString);
      throw new JSONException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("autoType is not support. ");
    stringBuilder.append(paramString);
    throw new JSONException(stringBuilder.toString());
  }
  
  public void configFromPropety(Properties paramProperties) {
    addItemsToDeny(splitItemsFormProperty(paramProperties.getProperty("fastjson.parser.deny")));
    addItemsToAccept(splitItemsFormProperty(paramProperties.getProperty("fastjson.parser.autoTypeAccept")));
    String str = paramProperties.getProperty("fastjson.parser.autoTypeSupport");
    if ("true".equals(str)) {
      this.autoTypeSupport = true;
    } else if ("false".equals(str)) {
      this.autoTypeSupport = false;
    } 
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, FieldInfo paramFieldInfo) {
    JavaBeanInfo javaBeanInfo1;
    Class clazz = paramJavaBeanInfo.clazz;
    Class<List> clazz1 = paramFieldInfo.fieldClass;
    JSONField jSONField = paramFieldInfo.getAnnotation();
    JavaBeanInfo javaBeanInfo2 = null;
    paramJavaBeanInfo = javaBeanInfo2;
    if (jSONField != null) {
      Class<Void> clazz2 = jSONField.deserializeUsing();
      if (clazz2 == Void.class)
        javaBeanInfo1 = javaBeanInfo2; 
    } 
    return (FieldDeserializer)((javaBeanInfo1 == null && (clazz1 == List.class || clazz1 == ArrayList.class)) ? new ArrayListTypeFieldDeserializer(paramParserConfig, clazz, paramFieldInfo) : new DefaultFieldDeserializer(paramParserConfig, clazz, paramFieldInfo));
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(Class<?> paramClass, Type paramType) {
    int i = this.asmEnable & (this.fieldBased ^ true);
    int j = i;
    if (i != 0) {
      boolean bool;
      JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
      if (jSONType != null) {
        Class<Void> clazz = jSONType.deserializer();
        if (clazz != Void.class)
          try {
            clazz = (Class<Void>)clazz.newInstance();
            if (clazz instanceof ObjectDeserializer)
              return (ObjectDeserializer)clazz; 
          } catch (Throwable throwable) {} 
        bool = jSONType.asm();
      } 
      bool2 = bool;
      if (bool) {
        Class<?> clazz2 = JavaBeanInfo.getBuilderClass(jSONType);
        Class<?> clazz1 = clazz2;
        if (clazz2 == null)
          clazz1 = paramClass; 
        while (true) {
          if (!Modifier.isPublic(clazz1.getModifiers())) {
            bool2 = false;
            break;
          } 
          clazz2 = clazz1.getSuperclass();
          bool2 = bool;
          if (clazz2 != Object.class) {
            clazz1 = clazz2;
            if (clazz2 == null) {
              bool2 = bool;
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
    } 
    boolean bool1 = bool2;
    if ((paramClass.getTypeParameters()).length != 0)
      bool1 = false; 
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = bool1;
      if (this.asmFactory != null) {
        bool2 = bool1;
        if (this.asmFactory.classLoader.isExternalClass(paramClass))
          bool2 = false; 
      } 
    } 
    bool1 = bool2;
    if (bool2)
      bool1 = ASMUtils.checkName(paramClass.getSimpleName()); 
    bool2 = bool1;
    if (bool1) {
      if (paramClass.isInterface())
        bool1 = false; 
      JavaBeanInfo javaBeanInfo1 = JavaBeanInfo.build(paramClass, paramType, this.propertyNamingStrategy);
      bool2 = bool1;
      if (bool1) {
        bool2 = bool1;
        if (javaBeanInfo1.fields.length > 200)
          bool2 = false; 
      } 
      Constructor constructor = javaBeanInfo1.defaultConstructor;
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
        if (constructor == null) {
          bool1 = bool2;
          if (!paramClass.isInterface())
            bool1 = false; 
        } 
      } 
      FieldInfo[] arrayOfFieldInfo = javaBeanInfo1.fields;
      int k = arrayOfFieldInfo.length;
      byte b = 0;
      while (true) {
        bool2 = bool1;
        if (b < k) {
          FieldInfo fieldInfo = arrayOfFieldInfo[b];
          if (!fieldInfo.getOnly) {
            Class clazz = fieldInfo.fieldClass;
            if (Modifier.isPublic(clazz.getModifiers()) && (!clazz.isMemberClass() || Modifier.isStatic(clazz.getModifiers())) && (fieldInfo.getMember() == null || ASMUtils.checkName(fieldInfo.getMember().getName()))) {
              JSONField jSONField = fieldInfo.getAnnotation();
              if ((jSONField == null || (ASMUtils.checkName(jSONField.name()) && jSONField.format().length() == 0 && jSONField.deserializeUsing() == Void.class && !jSONField.unwrapped())) && (!clazz.isEnum() || getDeserializer(clazz) instanceof EnumDeserializer)) {
                b++;
                continue;
              } 
            } 
          } 
          bool2 = false;
        } 
        break;
      } 
    } 
    bool1 = bool2;
    if (bool2) {
      bool1 = bool2;
      if (paramClass.isMemberClass()) {
        bool1 = bool2;
        if (!Modifier.isStatic(paramClass.getModifiers()))
          bool1 = false; 
      } 
    } 
    if (!bool1)
      return (ObjectDeserializer)new JavaBeanDeserializer(this, paramClass, paramType); 
    JavaBeanInfo javaBeanInfo = JavaBeanInfo.build(paramClass, paramType, this.propertyNamingStrategy);
    try {
      return this.asmFactory.createJavaBeanDeserializer(this, javaBeanInfo);
    } catch (NoSuchMethodException noSuchMethodException) {
      return (ObjectDeserializer)new JavaBeanDeserializer(this, paramClass, paramType);
    } catch (JSONException jSONException) {
      return (ObjectDeserializer)new JavaBeanDeserializer(this, (JavaBeanInfo)noSuchMethodException);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create asm deserializer error, ");
      stringBuilder.append(jSONException.getName());
      throw new JSONException(stringBuilder.toString(), exception);
    } 
  }
  
  public ClassLoader getDefaultClassLoader() {
    return this.defaultClassLoader;
  }
  
  public ObjectDeserializer getDeserializer(FieldInfo paramFieldInfo) {
    return getDeserializer(paramFieldInfo.fieldClass, paramFieldInfo.fieldType);
  }
  
  public ObjectDeserializer getDeserializer(Class<?> paramClass, Type<?> paramType) {
    EnumDeserializer enumDeserializer;
    ObjectDeserializer objectDeserializer1;
    AwtCodec awtCodec3;
    ObjectDeserializer objectDeserializer3;
    ObjectDeserializer objectDeserializer5 = (ObjectDeserializer)this.deserializers.get(paramType);
    if (objectDeserializer5 != null)
      return objectDeserializer5; 
    Type<?> type = paramType;
    if (paramType == null)
      type = paramClass; 
    ObjectDeserializer objectDeserializer2 = (ObjectDeserializer)this.deserializers.get(type);
    if (objectDeserializer2 != null)
      return objectDeserializer2; 
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    if (jSONType != null) {
      Class<Void> clazz = jSONType.mappingTo();
      if (clazz != Void.class)
        return getDeserializer(clazz, clazz); 
    } 
    if (type instanceof java.lang.reflect.WildcardType || type instanceof java.lang.reflect.TypeVariable || type instanceof ParameterizedType)
      objectDeserializer2 = (ObjectDeserializer)this.deserializers.get(paramClass); 
    if (objectDeserializer2 != null)
      return objectDeserializer2; 
    String str = paramClass.getName().replace('$', '.');
    ObjectDeserializer objectDeserializer4 = objectDeserializer2;
    if (str.startsWith("java.awt.")) {
      objectDeserializer4 = objectDeserializer2;
      if (AwtCodec.support(paramClass)) {
        objectDeserializer4 = objectDeserializer2;
        if (!awtError) {
          try {
            this.deserializers.put(Class.forName("java.awt.Point"), AwtCodec.instance);
            this.deserializers.put(Class.forName("java.awt.Font"), AwtCodec.instance);
            this.deserializers.put(Class.forName("java.awt.Rectangle"), AwtCodec.instance);
            this.deserializers.put(Class.forName("java.awt.Color"), AwtCodec.instance);
          } catch (Throwable throwable) {
            awtError = true;
          } 
          awtCodec3 = AwtCodec.instance;
        } 
      } 
    } 
    AwtCodec awtCodec1 = awtCodec3;
    if (!jdk8Error)
      try {
        if (str.startsWith("java.time.")) {
          this.deserializers.put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.ZoneId"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
          this.deserializers.put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
          ObjectDeserializer objectDeserializer = (ObjectDeserializer)this.deserializers.get(paramClass);
        } else {
          awtCodec1 = awtCodec3;
          if (str.startsWith("java.util.Optional")) {
            this.deserializers.put(Class.forName("java.util.Optional"), OptionalCodec.instance);
            this.deserializers.put(Class.forName("java.util.OptionalDouble"), OptionalCodec.instance);
            this.deserializers.put(Class.forName("java.util.OptionalInt"), OptionalCodec.instance);
            this.deserializers.put(Class.forName("java.util.OptionalLong"), OptionalCodec.instance);
            ObjectDeserializer objectDeserializer = (ObjectDeserializer)this.deserializers.get(paramClass);
          } 
        } 
      } catch (Throwable throwable) {
        jdk8Error = true;
        awtCodec1 = awtCodec3;
      }  
    if (str.equals("java.nio.file.Path"))
      this.deserializers.put(paramClass, MiscCodec.instance); 
    if (paramClass == Map.Entry.class)
      this.deserializers.put(paramClass, MiscCodec.instance); 
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      for (AutowiredObjectDeserializer autowiredObjectDeserializer : ServiceLoader.load(AutowiredObjectDeserializer.class, classLoader)) {
        for (Type type1 : autowiredObjectDeserializer.getAutowiredFor())
          this.deserializers.put(type1, autowiredObjectDeserializer); 
      } 
    } catch (Exception exception) {}
    AwtCodec awtCodec2 = awtCodec1;
    if (awtCodec1 == null)
      objectDeserializer3 = (ObjectDeserializer)this.deserializers.get(type); 
    if (objectDeserializer3 != null)
      return objectDeserializer3; 
    if (paramClass.isEnum()) {
      enumDeserializer = new EnumDeserializer(paramClass);
    } else {
      ObjectArrayCodec objectArrayCodec;
      if (enumDeserializer.isArray()) {
        objectArrayCodec = ObjectArrayCodec.instance;
      } else {
        CollectionCodec collectionCodec;
        if (objectArrayCodec == Set.class || objectArrayCodec == HashSet.class || objectArrayCodec == Collection.class || objectArrayCodec == List.class || objectArrayCodec == ArrayList.class) {
          collectionCodec = CollectionCodec.instance;
          putDeserializer(type, (ObjectDeserializer)collectionCodec);
          return (ObjectDeserializer)collectionCodec;
        } 
        if (Collection.class.isAssignableFrom((Class<?>)collectionCodec)) {
          collectionCodec = CollectionCodec.instance;
        } else {
          MapDeserializer mapDeserializer;
          if (Map.class.isAssignableFrom((Class<?>)collectionCodec)) {
            mapDeserializer = MapDeserializer.instance;
          } else {
            ThrowableDeserializer throwableDeserializer;
            if (Throwable.class.isAssignableFrom((Class<?>)mapDeserializer)) {
              throwableDeserializer = new ThrowableDeserializer(this, (Class)mapDeserializer);
            } else {
              PropertyProcessableDeserializer propertyProcessableDeserializer;
              if (PropertyProcessable.class.isAssignableFrom((Class<?>)throwableDeserializer)) {
                propertyProcessableDeserializer = new PropertyProcessableDeserializer((Class)throwableDeserializer);
              } else {
                objectDeserializer1 = createJavaBeanDeserializer((Class<?>)propertyProcessableDeserializer, type);
              } 
            } 
          } 
        } 
      } 
    } 
    putDeserializer(type, objectDeserializer1);
    return objectDeserializer1;
  }
  
  public ObjectDeserializer getDeserializer(Type paramType) {
    ObjectDeserializer objectDeserializer = (ObjectDeserializer)this.deserializers.get(paramType);
    if (objectDeserializer != null)
      return objectDeserializer; 
    if (paramType instanceof Class)
      return getDeserializer((Class)paramType, paramType); 
    if (paramType instanceof ParameterizedType) {
      Type type = ((ParameterizedType)paramType).getRawType();
      return (type instanceof Class) ? getDeserializer((Class)type, paramType) : getDeserializer(type);
    } 
    return (ObjectDeserializer)JavaObjectDeserializer.instance;
  }
  
  public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
    return this.deserializers;
  }
  
  public void initJavaBeanDeserializers(Class<?>... paramVarArgs) {
    if (paramVarArgs == null)
      return; 
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      Class<?> clazz = paramVarArgs[b];
      if (clazz != null)
        putDeserializer(clazz, createJavaBeanDeserializer(clazz, clazz)); 
    } 
  }
  
  public boolean isAsmEnable() {
    return this.asmEnable;
  }
  
  public boolean isAutoTypeSupport() {
    return this.autoTypeSupport;
  }
  
  public boolean isPrimitive(Class<?> paramClass) {
    return isPrimitive2(paramClass);
  }
  
  public void putDeserializer(Type paramType, ObjectDeserializer paramObjectDeserializer) {
    this.deserializers.put(paramType, paramObjectDeserializer);
  }
  
  public void setAsmEnable(boolean paramBoolean) {
    this.asmEnable = paramBoolean;
  }
  
  public void setAutoTypeSupport(boolean paramBoolean) {
    this.autoTypeSupport = paramBoolean;
  }
  
  public void setDefaultClassLoader(ClassLoader paramClassLoader) {
    this.defaultClassLoader = paramClassLoader;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\ParserConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */