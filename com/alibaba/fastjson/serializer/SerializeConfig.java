package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
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
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

public class SerializeConfig {
  private static boolean awtError;
  
  public static final SerializeConfig globalInstance = new SerializeConfig();
  
  private static boolean guavaError;
  
  private static boolean jdk8Error;
  
  private static boolean oracleJdbcError;
  
  private static boolean springfoxError;
  
  private boolean asm = ASMUtils.IS_ANDROID ^ true;
  
  private ASMSerializerFactory asmFactory;
  
  private final boolean fieldBased;
  
  public PropertyNamingStrategy propertyNamingStrategy;
  
  private final IdentityHashMap<Type, ObjectSerializer> serializers;
  
  protected String typeKey = JSON.DEFAULT_TYPE_KEY;
  
  static {
    awtError = false;
    jdk8Error = false;
    oracleJdbcError = false;
    springfoxError = false;
    guavaError = false;
  }
  
  public SerializeConfig() {
    this(1024);
  }
  
  public SerializeConfig(int paramInt) {
    this(paramInt, false);
  }
  
  public SerializeConfig(int paramInt, boolean paramBoolean) {
    this.fieldBased = paramBoolean;
    this.serializers = new IdentityHashMap(1024);
    try {
      if (this.asm) {
        ASMSerializerFactory aSMSerializerFactory = new ASMSerializerFactory();
        this();
        this.asmFactory = aSMSerializerFactory;
      } 
    } catch (Throwable throwable) {
      this.asm = false;
    } 
    put(Boolean.class, BooleanCodec.instance);
    put(Character.class, CharacterCodec.instance);
    put(Byte.class, IntegerCodec.instance);
    put(Short.class, IntegerCodec.instance);
    put(Integer.class, IntegerCodec.instance);
    put(Long.class, LongCodec.instance);
    put(Float.class, FloatCodec.instance);
    put(Double.class, DoubleSerializer.instance);
    put(BigDecimal.class, BigDecimalCodec.instance);
    put(BigInteger.class, BigIntegerCodec.instance);
    put(String.class, StringCodec.instance);
    put(byte[].class, PrimitiveArraySerializer.instance);
    put(short[].class, PrimitiveArraySerializer.instance);
    put(int[].class, PrimitiveArraySerializer.instance);
    put(long[].class, PrimitiveArraySerializer.instance);
    put(float[].class, PrimitiveArraySerializer.instance);
    put(double[].class, PrimitiveArraySerializer.instance);
    put(boolean[].class, PrimitiveArraySerializer.instance);
    put(char[].class, PrimitiveArraySerializer.instance);
    put(Object[].class, ObjectArrayCodec.instance);
    put(Class.class, MiscCodec.instance);
    put(SimpleDateFormat.class, MiscCodec.instance);
    put(Currency.class, new MiscCodec());
    put(TimeZone.class, MiscCodec.instance);
    put(InetAddress.class, MiscCodec.instance);
    put(Inet4Address.class, MiscCodec.instance);
    put(Inet6Address.class, MiscCodec.instance);
    put(InetSocketAddress.class, MiscCodec.instance);
    put(File.class, MiscCodec.instance);
    put(Appendable.class, AppendableSerializer.instance);
    put(StringBuffer.class, AppendableSerializer.instance);
    put(StringBuilder.class, AppendableSerializer.instance);
    put(Charset.class, ToStringSerializer.instance);
    put(Pattern.class, ToStringSerializer.instance);
    put(Locale.class, ToStringSerializer.instance);
    put(URI.class, ToStringSerializer.instance);
    put(URL.class, ToStringSerializer.instance);
    put(UUID.class, ToStringSerializer.instance);
    put(AtomicBoolean.class, AtomicCodec.instance);
    put(AtomicInteger.class, AtomicCodec.instance);
    put(AtomicLong.class, AtomicCodec.instance);
    put(AtomicReference.class, ReferenceCodec.instance);
    put(AtomicIntegerArray.class, AtomicCodec.instance);
    put(AtomicLongArray.class, AtomicCodec.instance);
    put(WeakReference.class, ReferenceCodec.instance);
    put(SoftReference.class, ReferenceCodec.instance);
  }
  
  public SerializeConfig(boolean paramBoolean) {
    this(1024, paramBoolean);
  }
  
  private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo paramSerializeBeanInfo) throws Exception {
    JavaBeanSerializer javaBeanSerializer = this.asmFactory.createJavaBeanSerializer(paramSerializeBeanInfo);
    for (byte b = 0; b < javaBeanSerializer.sortedGetters.length; b++) {
      Class clazz = (javaBeanSerializer.sortedGetters[b]).fieldInfo.fieldClass;
      if (clazz.isEnum() && !(getObjectWriter(clazz) instanceof EnumSerializer))
        javaBeanSerializer.writeDirect = false; 
    } 
    return javaBeanSerializer;
  }
  
  public static SerializeConfig getGlobalInstance() {
    return globalInstance;
  }
  
  private ObjectSerializer getObjectWriter(Class<?> paramClass, boolean paramBoolean) {
    ObjectSerializer objectSerializer1 = (ObjectSerializer)this.serializers.get(paramClass);
    objectSerializer2 = objectSerializer1;
    if (objectSerializer1 == null) {
      try {
        for (ObjectSerializer objectSerializer2 : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
          if (!(objectSerializer2 instanceof AutowiredObjectSerializer))
            continue; 
          objectSerializer2 = objectSerializer2;
          Iterator<Type> iterator = objectSerializer2.getAutowiredFor().iterator();
          while (iterator.hasNext())
            put(iterator.next(), objectSerializer2); 
        } 
      } catch (ClassCastException classCastException) {}
      objectSerializer2 = (ObjectSerializer)this.serializers.get(paramClass);
    } 
    objectSerializer1 = objectSerializer2;
    if (objectSerializer2 == null) {
      ClassLoader classLoader = JSON.class.getClassLoader();
      objectSerializer1 = objectSerializer2;
      if (classLoader != Thread.currentThread().getContextClassLoader()) {
        try {
          for (ObjectSerializer objectSerializer2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
            if (!(objectSerializer2 instanceof AutowiredObjectSerializer))
              continue; 
            AutowiredObjectSerializer autowiredObjectSerializer = (AutowiredObjectSerializer)objectSerializer2;
            Iterator<Type> iterator = autowiredObjectSerializer.getAutowiredFor().iterator();
            while (iterator.hasNext())
              put(iterator.next(), autowiredObjectSerializer); 
          } 
        } catch (ClassCastException classCastException) {}
        objectSerializer1 = (ObjectSerializer)this.serializers.get(paramClass);
      } 
    } 
    objectSerializer2 = objectSerializer1;
    if (objectSerializer1 == null) {
      String str = paramClass.getName();
      if (Map.class.isAssignableFrom(paramClass)) {
        put(paramClass, MapSerializer.instance);
      } else if (List.class.isAssignableFrom(paramClass)) {
        put(paramClass, ListSerializer.instance);
      } else if (Collection.class.isAssignableFrom(paramClass)) {
        put(paramClass, CollectionCodec.instance);
      } else if (Date.class.isAssignableFrom(paramClass)) {
        put(paramClass, DateCodec.instance);
      } else if (JSONAware.class.isAssignableFrom(paramClass)) {
        put(paramClass, JSONAwareSerializer.instance);
      } else if (JSONSerializable.class.isAssignableFrom(paramClass)) {
        put(paramClass, JSONSerializableSerializer.instance);
      } else if (JSONStreamAware.class.isAssignableFrom(paramClass)) {
        put(paramClass, MiscCodec.instance);
      } else if (paramClass.isEnum() || (paramClass.getSuperclass() != null && paramClass.getSuperclass().isEnum())) {
        JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
        if (jSONType != null && jSONType.serializeEnumAsJavaBean()) {
          put(paramClass, createJavaBeanSerializer(paramClass));
        } else {
          put(paramClass, EnumSerializer.instance);
        } 
      } else if (paramClass.isArray()) {
        Class<?> clazz = paramClass.getComponentType();
        put(paramClass, new ArraySerializer(clazz, getObjectWriter(clazz)));
      } else {
        SerializeBeanInfo serializeBeanInfo;
        if (Throwable.class.isAssignableFrom(paramClass)) {
          serializeBeanInfo = TypeUtils.buildBeanInfo(paramClass, null, this.propertyNamingStrategy);
          serializeBeanInfo.features |= SerializerFeature.WriteClassName.mask;
          put(paramClass, new JavaBeanSerializer(serializeBeanInfo));
        } else if (TimeZone.class.isAssignableFrom(paramClass) || Map.Entry.class.isAssignableFrom(paramClass)) {
          put(paramClass, MiscCodec.instance);
        } else if (Appendable.class.isAssignableFrom(paramClass)) {
          put(paramClass, AppendableSerializer.instance);
        } else if (Charset.class.isAssignableFrom(paramClass)) {
          put(paramClass, ToStringSerializer.instance);
        } else if (Enumeration.class.isAssignableFrom(paramClass)) {
          put(paramClass, EnumerationSerializer.instance);
        } else if (Calendar.class.isAssignableFrom(paramClass) || XMLGregorianCalendar.class.isAssignableFrom(paramClass)) {
          put(paramClass, CalendarCodec.instance);
        } else if (Clob.class.isAssignableFrom(paramClass)) {
          put(paramClass, ClobSeriliazer.instance);
        } else if (TypeUtils.isPath(paramClass)) {
          put(paramClass, ToStringSerializer.instance);
        } else if (Iterator.class.isAssignableFrom(paramClass)) {
          put(paramClass, MiscCodec.instance);
        } else {
          if (serializeBeanInfo.startsWith("java.awt.") && AwtCodec.support(paramClass)) {
            if (!awtError)
              try {
                put(Class.forName("java.awt.Color"), AwtCodec.instance);
                put(Class.forName("java.awt.Font"), AwtCodec.instance);
                put(Class.forName("java.awt.Point"), AwtCodec.instance);
                put(Class.forName("java.awt.Rectangle"), AwtCodec.instance);
              } catch (Throwable throwable) {
                awtError = true;
              }  
            return AwtCodec.instance;
          } 
          if (!jdk8Error && (serializeBeanInfo.startsWith("java.time.") || serializeBeanInfo.startsWith("java.util.Optional") || serializeBeanInfo.equals("java.util.concurrent.atomic.LongAdder") || serializeBeanInfo.equals("java.util.concurrent.atomic.DoubleAdder")))
            try {
              put(Class.forName("java.time.LocalDateTime"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.LocalDate"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.LocalTime"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.ZonedDateTime"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.OffsetDateTime"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.OffsetTime"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.ZoneOffset"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.ZoneRegion"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.Period"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.Duration"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.time.Instant"), (ObjectSerializer)Jdk8DateCodec.instance);
              put(Class.forName("java.util.Optional"), (ObjectSerializer)OptionalCodec.instance);
              put(Class.forName("java.util.OptionalDouble"), (ObjectSerializer)OptionalCodec.instance);
              put(Class.forName("java.util.OptionalInt"), (ObjectSerializer)OptionalCodec.instance);
              put(Class.forName("java.util.OptionalLong"), (ObjectSerializer)OptionalCodec.instance);
              put(Class.forName("java.util.concurrent.atomic.LongAdder"), AdderSerializer.instance);
              put(Class.forName("java.util.concurrent.atomic.DoubleAdder"), AdderSerializer.instance);
              objectSerializer2 = (ObjectSerializer)this.serializers.get(throwable);
              if (objectSerializer2 != null)
                return objectSerializer2; 
            } catch (Throwable throwable1) {
              jdk8Error = true;
            }  
          if (!oracleJdbcError && serializeBeanInfo.startsWith("oracle.sql."))
            try {
              put(Class.forName("oracle.sql.DATE"), DateCodec.instance);
              put(Class.forName("oracle.sql.TIMESTAMP"), DateCodec.instance);
              objectSerializer2 = (ObjectSerializer)this.serializers.get(throwable);
              if (objectSerializer2 != null)
                return objectSerializer2; 
            } catch (Throwable throwable1) {
              oracleJdbcError = true;
            }  
          if (!springfoxError && serializeBeanInfo.equals("springfox.documentation.spring.web.json.Json"))
            try {
              put(Class.forName("springfox.documentation.spring.web.json.Json"), (ObjectSerializer)SwaggerJsonSerializer.instance);
              objectSerializer2 = (ObjectSerializer)this.serializers.get(throwable);
              if (objectSerializer2 != null)
                return objectSerializer2; 
            } catch (ClassNotFoundException classNotFoundException) {
              springfoxError = true;
            }  
          if (!guavaError && serializeBeanInfo.startsWith("com.google.common.collect."))
            try {
              put(Class.forName("com.google.common.collect.HashMultimap"), GuavaCodec.instance);
              put(Class.forName("com.google.common.collect.LinkedListMultimap"), GuavaCodec.instance);
              put(Class.forName("com.google.common.collect.ArrayListMultimap"), GuavaCodec.instance);
              put(Class.forName("com.google.common.collect.TreeMultimap"), GuavaCodec.instance);
              objectSerializer2 = (ObjectSerializer)this.serializers.get(throwable);
              if (objectSerializer2 != null)
                return objectSerializer2; 
            } catch (ClassNotFoundException classNotFoundException) {
              guavaError = true;
            }  
          if (serializeBeanInfo.equals("net.sf.json.JSONNull")) {
            try {
              put(Class.forName("net.sf.json.JSONNull"), MiscCodec.instance);
            } catch (ClassNotFoundException classNotFoundException) {}
            ObjectSerializer objectSerializer = (ObjectSerializer)this.serializers.get(throwable);
            if (objectSerializer != null)
              return objectSerializer; 
          } 
          Class[] arrayOfClass = throwable.getInterfaces();
          if (arrayOfClass.length == 1 && arrayOfClass[0].isAnnotation())
            return AnnotationSerializer.instance; 
          if (TypeUtils.isProxy((Class)throwable)) {
            ObjectSerializer objectSerializer = getObjectWriter(throwable.getSuperclass());
            put((Type)throwable, objectSerializer);
            return objectSerializer;
          } 
          if (paramBoolean)
            put((Type)throwable, createJavaBeanSerializer((Class<?>)throwable)); 
        } 
      } 
      objectSerializer2 = (ObjectSerializer)this.serializers.get(throwable);
    } 
    return objectSerializer2;
  }
  
  public void addFilter(Class<?> paramClass, SerializeFilter paramSerializeFilter) {
    ObjectSerializer objectSerializer = getObjectWriter(paramClass);
    if (objectSerializer instanceof SerializeFilterable) {
      SerializeFilterable serializeFilterable = (SerializeFilterable)objectSerializer;
      if (this != globalInstance && serializeFilterable == MapSerializer.instance) {
        serializeFilterable = new MapSerializer();
        put(paramClass, (ObjectSerializer)serializeFilterable);
        serializeFilterable.addFilter(paramSerializeFilter);
        return;
      } 
      serializeFilterable.addFilter(paramSerializeFilter);
    } 
  }
  
  public void config(Class<?> paramClass, SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    SerializeBeanInfo serializeBeanInfo;
    ObjectSerializer objectSerializer = getObjectWriter(paramClass, false);
    if (objectSerializer == null) {
      serializeBeanInfo = TypeUtils.buildBeanInfo(paramClass, null, this.propertyNamingStrategy);
      if (paramBoolean) {
        int i = serializeBeanInfo.features;
        serializeBeanInfo.features = paramSerializerFeature.mask | i;
      } else {
        int i = serializeBeanInfo.features;
        serializeBeanInfo.features = (paramSerializerFeature.mask ^ 0xFFFFFFFF) & i;
      } 
      put(paramClass, createJavaBeanSerializer(serializeBeanInfo));
      return;
    } 
    if (serializeBeanInfo instanceof JavaBeanSerializer) {
      SerializeBeanInfo serializeBeanInfo1 = ((JavaBeanSerializer)serializeBeanInfo).beanInfo;
      int i = serializeBeanInfo1.features;
      if (paramBoolean) {
        int j = serializeBeanInfo1.features;
        serializeBeanInfo1.features = paramSerializerFeature.mask | j;
      } else {
        int j = serializeBeanInfo1.features;
        serializeBeanInfo1.features = (paramSerializerFeature.mask ^ 0xFFFFFFFF) & j;
      } 
      if (i == serializeBeanInfo1.features)
        return; 
      if (serializeBeanInfo.getClass() != JavaBeanSerializer.class)
        put(paramClass, createJavaBeanSerializer(serializeBeanInfo1)); 
    } 
  }
  
  public void configEnumAsJavaBean(Class<? extends Enum>... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      Class<? extends Enum> clazz = paramVarArgs[b];
      put(clazz, createJavaBeanSerializer(clazz));
    } 
  }
  
  public ObjectSerializer createJavaBeanSerializer(SerializeBeanInfo paramSerializeBeanInfo) {
    // Byte code:
    //   0: aload_1
    //   1: getfield jsonType : Lcom/alibaba/fastjson/annotation/JSONType;
    //   4: astore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_2
    //   8: ifnull -> 131
    //   11: aload_2
    //   12: invokeinterface serializer : ()Ljava/lang/Class;
    //   17: astore #4
    //   19: aload #4
    //   21: ldc_w java/lang/Void
    //   24: if_acmpeq -> 52
    //   27: aload #4
    //   29: invokevirtual newInstance : ()Ljava/lang/Object;
    //   32: astore #4
    //   34: aload #4
    //   36: instanceof com/alibaba/fastjson/serializer/ObjectSerializer
    //   39: ifeq -> 52
    //   42: aload #4
    //   44: checkcast com/alibaba/fastjson/serializer/ObjectSerializer
    //   47: astore #4
    //   49: aload #4
    //   51: areturn
    //   52: aload_2
    //   53: invokeinterface asm : ()Z
    //   58: ifne -> 66
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield asm : Z
    //   66: aload_2
    //   67: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   72: astore_2
    //   73: aload_2
    //   74: arraylength
    //   75: istore #5
    //   77: iconst_0
    //   78: istore #6
    //   80: iload #6
    //   82: iload #5
    //   84: if_icmpge -> 131
    //   87: aload_2
    //   88: iload #6
    //   90: aaload
    //   91: astore #4
    //   93: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNonStringValueAsString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   96: aload #4
    //   98: if_acmpeq -> 126
    //   101: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteEnumUsingToString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   104: aload #4
    //   106: if_acmpeq -> 126
    //   109: getstatic com/alibaba/fastjson/serializer/SerializerFeature.NotWriteDefaultValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   112: aload #4
    //   114: if_acmpne -> 120
    //   117: goto -> 126
    //   120: iinc #6, 1
    //   123: goto -> 80
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield asm : Z
    //   131: aload_1
    //   132: getfield beanType : Ljava/lang/Class;
    //   135: astore_2
    //   136: aload_1
    //   137: getfield beanType : Ljava/lang/Class;
    //   140: invokevirtual getModifiers : ()I
    //   143: invokestatic isPublic : (I)Z
    //   146: ifne -> 158
    //   149: new com/alibaba/fastjson/serializer/JavaBeanSerializer
    //   152: dup
    //   153: aload_1
    //   154: invokespecial <init> : (Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;)V
    //   157: areturn
    //   158: aload_0
    //   159: getfield asm : Z
    //   162: ifeq -> 178
    //   165: aload_0
    //   166: getfield fieldBased : Z
    //   169: ifne -> 178
    //   172: iconst_1
    //   173: istore #5
    //   175: goto -> 181
    //   178: iconst_0
    //   179: istore #5
    //   181: iload #5
    //   183: ifeq -> 200
    //   186: aload_0
    //   187: getfield asmFactory : Lcom/alibaba/fastjson/serializer/ASMSerializerFactory;
    //   190: getfield classLoader : Lcom/alibaba/fastjson/util/ASMClassLoader;
    //   193: aload_2
    //   194: invokevirtual isExternalClass : (Ljava/lang/Class;)Z
    //   197: ifne -> 213
    //   200: aload_2
    //   201: ldc_w java/io/Serializable
    //   204: if_acmpeq -> 213
    //   207: aload_2
    //   208: ldc java/lang/Object
    //   210: if_acmpne -> 216
    //   213: iconst_0
    //   214: istore #5
    //   216: iload #5
    //   218: istore #6
    //   220: iload #5
    //   222: ifeq -> 242
    //   225: iload #5
    //   227: istore #6
    //   229: aload_2
    //   230: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   233: invokestatic checkName : (Ljava/lang/String;)Z
    //   236: ifne -> 242
    //   239: iconst_0
    //   240: istore #6
    //   242: iload #6
    //   244: ifeq -> 537
    //   247: aload_1
    //   248: getfield fields : [Lcom/alibaba/fastjson/util/FieldInfo;
    //   251: astore #4
    //   253: aload #4
    //   255: arraylength
    //   256: istore #7
    //   258: iconst_0
    //   259: istore #8
    //   261: iload #8
    //   263: iload #7
    //   265: if_icmpge -> 530
    //   268: aload #4
    //   270: iload #8
    //   272: aaload
    //   273: astore #9
    //   275: aload #9
    //   277: getfield field : Ljava/lang/reflect/Field;
    //   280: astore #10
    //   282: aload #10
    //   284: ifnull -> 309
    //   287: aload #10
    //   289: invokevirtual getType : ()Ljava/lang/Class;
    //   292: aload #9
    //   294: getfield fieldClass : Ljava/lang/Class;
    //   297: invokevirtual equals : (Ljava/lang/Object;)Z
    //   300: ifne -> 309
    //   303: iload_3
    //   304: istore #5
    //   306: goto -> 541
    //   309: aload #9
    //   311: getfield method : Ljava/lang/reflect/Method;
    //   314: astore #10
    //   316: aload #10
    //   318: ifnull -> 343
    //   321: aload #10
    //   323: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   326: aload #9
    //   328: getfield fieldClass : Ljava/lang/Class;
    //   331: invokevirtual equals : (Ljava/lang/Object;)Z
    //   334: ifne -> 343
    //   337: iload_3
    //   338: istore #5
    //   340: goto -> 541
    //   343: aload #9
    //   345: invokevirtual getAnnotation : ()Lcom/alibaba/fastjson/annotation/JSONField;
    //   348: astore #9
    //   350: aload #9
    //   352: ifnonnull -> 358
    //   355: goto -> 524
    //   358: iload_3
    //   359: istore #5
    //   361: aload #9
    //   363: invokeinterface name : ()Ljava/lang/String;
    //   368: invokestatic checkName : (Ljava/lang/String;)Z
    //   371: ifeq -> 541
    //   374: iload_3
    //   375: istore #5
    //   377: aload #9
    //   379: invokeinterface format : ()Ljava/lang/String;
    //   384: invokevirtual length : ()I
    //   387: ifne -> 541
    //   390: iload_3
    //   391: istore #5
    //   393: aload #9
    //   395: invokeinterface jsonDirect : ()Z
    //   400: ifne -> 541
    //   403: iload_3
    //   404: istore #5
    //   406: aload #9
    //   408: invokeinterface serializeUsing : ()Ljava/lang/Class;
    //   413: ldc_w java/lang/Void
    //   416: if_acmpne -> 541
    //   419: aload #9
    //   421: invokeinterface unwrapped : ()Z
    //   426: ifeq -> 435
    //   429: iload_3
    //   430: istore #5
    //   432: goto -> 541
    //   435: aload #9
    //   437: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   442: astore #11
    //   444: aload #11
    //   446: arraylength
    //   447: istore #12
    //   449: iconst_0
    //   450: istore #13
    //   452: iload #6
    //   454: istore #5
    //   456: iload #13
    //   458: iload #12
    //   460: if_icmpge -> 506
    //   463: aload #11
    //   465: iload #13
    //   467: aaload
    //   468: astore #9
    //   470: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNonStringValueAsString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   473: aload #9
    //   475: if_acmpeq -> 503
    //   478: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteEnumUsingToString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   481: aload #9
    //   483: if_acmpeq -> 503
    //   486: getstatic com/alibaba/fastjson/serializer/SerializerFeature.NotWriteDefaultValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   489: aload #9
    //   491: if_acmpne -> 497
    //   494: goto -> 503
    //   497: iinc #13, 1
    //   500: goto -> 452
    //   503: iconst_0
    //   504: istore #5
    //   506: iload #5
    //   508: istore #6
    //   510: aload #10
    //   512: invokestatic isAnnotationPresentOneToMany : (Ljava/lang/reflect/Method;)Z
    //   515: ifeq -> 524
    //   518: iconst_1
    //   519: istore #5
    //   521: goto -> 541
    //   524: iinc #8, 1
    //   527: goto -> 261
    //   530: iload #6
    //   532: istore #5
    //   534: goto -> 541
    //   537: iload #6
    //   539: istore #5
    //   541: iload #5
    //   543: ifeq -> 599
    //   546: aload_0
    //   547: aload_1
    //   548: invokespecial createASMSerializer : (Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;)Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;
    //   551: astore #4
    //   553: aload #4
    //   555: ifnull -> 599
    //   558: aload #4
    //   560: areturn
    //   561: astore #4
    //   563: new java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial <init> : ()V
    //   570: astore_1
    //   571: aload_1
    //   572: ldc_w 'create asm serializer error, class '
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_1
    //   580: aload_2
    //   581: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: new com/alibaba/fastjson/JSONException
    //   588: dup
    //   589: aload_1
    //   590: invokevirtual toString : ()Ljava/lang/String;
    //   593: aload #4
    //   595: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   598: athrow
    //   599: new com/alibaba/fastjson/serializer/JavaBeanSerializer
    //   602: dup
    //   603: aload_1
    //   604: invokespecial <init> : (Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;)V
    //   607: areturn
    //   608: astore #4
    //   610: goto -> 52
    //   613: astore_2
    //   614: goto -> 599
    // Exception table:
    //   from	to	target	type
    //   27	49	608	java/lang/Throwable
    //   546	553	613	java/lang/ClassNotFoundException
    //   546	553	613	java/lang/ClassFormatError
    //   546	553	613	java/lang/ClassCastException
    //   546	553	561	java/lang/Throwable
  }
  
  public final ObjectSerializer createJavaBeanSerializer(Class<?> paramClass) {
    SerializeBeanInfo serializeBeanInfo = TypeUtils.buildBeanInfo(paramClass, null, this.propertyNamingStrategy, this.fieldBased);
    return (serializeBeanInfo.fields.length == 0 && Iterable.class.isAssignableFrom(paramClass)) ? MiscCodec.instance : createJavaBeanSerializer(serializeBeanInfo);
  }
  
  public final ObjectSerializer get(Type paramType) {
    return (ObjectSerializer)this.serializers.get(paramType);
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass) {
    return getObjectWriter(paramClass, true);
  }
  
  public String getTypeKey() {
    return this.typeKey;
  }
  
  public boolean isAsmEnable() {
    return this.asm;
  }
  
  public boolean put(Object paramObject1, Object paramObject2) {
    return put((Type)paramObject1, (ObjectSerializer)paramObject2);
  }
  
  public boolean put(Type paramType, ObjectSerializer paramObjectSerializer) {
    return this.serializers.put(paramType, paramObjectSerializer);
  }
  
  public void setAsmEnable(boolean paramBoolean) {
    if (ASMUtils.IS_ANDROID)
      return; 
    this.asm = paramBoolean;
  }
  
  public void setTypeKey(String paramString) {
    this.typeKey = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */