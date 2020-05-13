package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FieldSerializer implements Comparable<FieldSerializer> {
  protected boolean disableCircularReferenceDetect;
  
  private final String double_quoted_fieldPrefix;
  
  protected int features;
  
  protected BeanContext fieldContext;
  
  public final FieldInfo fieldInfo;
  
  private String format;
  
  protected boolean persistenceOneToMany;
  
  private RuntimeSerializerInfo runtimeInfo;
  
  protected boolean serializeUsing;
  
  private String single_quoted_fieldPrefix;
  
  private String un_quoted_fieldPrefix;
  
  protected boolean writeEnumUsingName;
  
  protected boolean writeEnumUsingToString;
  
  protected final boolean writeNull;
  
  public FieldSerializer(Class<?> paramClass, FieldInfo paramFieldInfo) {
    boolean bool1 = false;
    boolean bool2 = false;
    this.writeEnumUsingToString = false;
    this.writeEnumUsingName = false;
    this.disableCircularReferenceDetect = false;
    this.serializeUsing = false;
    this.persistenceOneToMany = false;
    this.fieldInfo = paramFieldInfo;
    this.fieldContext = new BeanContext(paramClass, paramFieldInfo);
    if (paramClass != null && paramFieldInfo.isEnum) {
      JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
      if (jSONType != null)
        for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
          if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
            this.writeEnumUsingToString = true;
          } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
            this.writeEnumUsingName = true;
          } else if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
            this.disableCircularReferenceDetect = true;
          } 
        }  
    } 
    paramFieldInfo.setAccessible();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('"');
    stringBuilder.append(paramFieldInfo.name);
    stringBuilder.append("\":");
    this.double_quoted_fieldPrefix = stringBuilder.toString();
    JSONField jSONField = paramFieldInfo.getAnnotation();
    if (jSONField != null) {
      SerializerFeature[] arrayOfSerializerFeature = jSONField.serialzeFeatures();
      int i = arrayOfSerializerFeature.length;
      byte b = 0;
      while (true) {
        if (b < i) {
          if ((arrayOfSerializerFeature[b].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
            bool1 = true;
            break;
          } 
          b++;
          continue;
        } 
        bool1 = false;
        break;
      } 
      this.format = jSONField.format();
      if (this.format.trim().length() == 0)
        this.format = null; 
      arrayOfSerializerFeature = jSONField.serialzeFeatures();
      i = arrayOfSerializerFeature.length;
      for (b = bool2; b < i; b++) {
        SerializerFeature serializerFeature = arrayOfSerializerFeature[b];
        if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
          this.writeEnumUsingToString = true;
        } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
          this.writeEnumUsingName = true;
        } else if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
          this.disableCircularReferenceDetect = true;
        } 
      } 
      this.features = SerializerFeature.of(jSONField.serialzeFeatures());
    } 
    this.writeNull = bool1;
    this.persistenceOneToMany = TypeUtils.isAnnotationPresentOneToMany(paramFieldInfo.method);
  }
  
  public int compareTo(FieldSerializer paramFieldSerializer) {
    return this.fieldInfo.compareTo(paramFieldSerializer.fieldInfo);
  }
  
  public Object getPropertyValue(Object paramObject) throws InvocationTargetException, IllegalAccessException {
    paramObject = this.fieldInfo.get(paramObject);
    if (this.format != null && paramObject != null && this.fieldInfo.fieldClass == Date.class) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.format);
      simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
      return simpleDateFormat.format(paramObject);
    } 
    return paramObject;
  }
  
  public Object getPropertyValueDirect(Object paramObject) throws InvocationTargetException, IllegalAccessException {
    paramObject = this.fieldInfo.get(paramObject);
    return (this.persistenceOneToMany && TypeUtils.isHibernateInitialized(paramObject)) ? null : paramObject;
  }
  
  public void writePrefix(JSONSerializer paramJSONSerializer) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (serializeWriter.quoteFieldNames) {
      if (serializeWriter.useSingleQuotes) {
        if (this.single_quoted_fieldPrefix == null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append('\'');
          stringBuilder.append(this.fieldInfo.name);
          stringBuilder.append("':");
          this.single_quoted_fieldPrefix = stringBuilder.toString();
        } 
        serializeWriter.write(this.single_quoted_fieldPrefix);
      } else {
        serializeWriter.write(this.double_quoted_fieldPrefix);
      } 
    } else {
      if (this.un_quoted_fieldPrefix == null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.fieldInfo.name);
        stringBuilder.append(":");
        this.un_quoted_fieldPrefix = stringBuilder.toString();
      } 
      serializeWriter.write(this.un_quoted_fieldPrefix);
    } 
  }
  
  public void writeValue(JSONSerializer paramJSONSerializer, Object paramObject) throws Exception {
    // Byte code:
    //   0: aload_0
    //   1: getfield runtimeInfo : Lcom/alibaba/fastjson/serializer/FieldSerializer$RuntimeSerializerInfo;
    //   4: ifnonnull -> 182
    //   7: aload_2
    //   8: ifnonnull -> 22
    //   11: aload_0
    //   12: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   15: getfield fieldClass : Ljava/lang/Class;
    //   18: astore_3
    //   19: goto -> 27
    //   22: aload_2
    //   23: invokevirtual getClass : ()Ljava/lang/Class;
    //   26: astore_3
    //   27: aconst_null
    //   28: astore #4
    //   30: aload_0
    //   31: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   34: invokevirtual getAnnotation : ()Lcom/alibaba/fastjson/annotation/JSONField;
    //   37: astore #5
    //   39: aload #5
    //   41: ifnull -> 79
    //   44: aload #5
    //   46: invokeinterface serializeUsing : ()Ljava/lang/Class;
    //   51: ldc java/lang/Void
    //   53: if_acmpeq -> 79
    //   56: aload #5
    //   58: invokeinterface serializeUsing : ()Ljava/lang/Class;
    //   63: invokevirtual newInstance : ()Ljava/lang/Object;
    //   66: checkcast com/alibaba/fastjson/serializer/ObjectSerializer
    //   69: astore #4
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield serializeUsing : Z
    //   76: goto -> 168
    //   79: aload #4
    //   81: astore #5
    //   83: aload_0
    //   84: getfield format : Ljava/lang/String;
    //   87: ifnull -> 152
    //   90: aload_3
    //   91: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   94: if_acmpeq -> 139
    //   97: aload_3
    //   98: ldc java/lang/Double
    //   100: if_acmpne -> 106
    //   103: goto -> 139
    //   106: aload_3
    //   107: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   110: if_acmpeq -> 123
    //   113: aload #4
    //   115: astore #5
    //   117: aload_3
    //   118: ldc java/lang/Float
    //   120: if_acmpne -> 152
    //   123: new com/alibaba/fastjson/serializer/FloatCodec
    //   126: dup
    //   127: aload_0
    //   128: getfield format : Ljava/lang/String;
    //   131: invokespecial <init> : (Ljava/lang/String;)V
    //   134: astore #5
    //   136: goto -> 152
    //   139: new com/alibaba/fastjson/serializer/DoubleSerializer
    //   142: dup
    //   143: aload_0
    //   144: getfield format : Ljava/lang/String;
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: astore #5
    //   152: aload #5
    //   154: astore #4
    //   156: aload #5
    //   158: ifnonnull -> 168
    //   161: aload_1
    //   162: aload_3
    //   163: invokevirtual getObjectWriter : (Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   166: astore #4
    //   168: aload_0
    //   169: new com/alibaba/fastjson/serializer/FieldSerializer$RuntimeSerializerInfo
    //   172: dup
    //   173: aload #4
    //   175: aload_3
    //   176: invokespecial <init> : (Lcom/alibaba/fastjson/serializer/ObjectSerializer;Ljava/lang/Class;)V
    //   179: putfield runtimeInfo : Lcom/alibaba/fastjson/serializer/FieldSerializer$RuntimeSerializerInfo;
    //   182: aload_0
    //   183: getfield runtimeInfo : Lcom/alibaba/fastjson/serializer/FieldSerializer$RuntimeSerializerInfo;
    //   186: astore #5
    //   188: aload_0
    //   189: getfield disableCircularReferenceDetect : Z
    //   192: ifeq -> 214
    //   195: aload_0
    //   196: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   199: getfield serialzeFeatures : I
    //   202: getstatic com/alibaba/fastjson/serializer/SerializerFeature.DisableCircularReferenceDetect : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   205: invokevirtual getMask : ()I
    //   208: ior
    //   209: istore #6
    //   211: goto -> 226
    //   214: aload_0
    //   215: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   218: getfield serialzeFeatures : I
    //   221: istore #6
    //   223: goto -> 211
    //   226: aload_2
    //   227: ifnonnull -> 395
    //   230: aload #5
    //   232: getfield runtimeFieldClass : Ljava/lang/Class;
    //   235: astore #4
    //   237: aload_1
    //   238: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   241: astore_2
    //   242: ldc_w java/lang/Number
    //   245: aload #4
    //   247: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   250: ifeq -> 268
    //   253: aload_2
    //   254: aload_0
    //   255: getfield features : I
    //   258: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullNumberAsZero : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   261: getfield mask : I
    //   264: invokevirtual writeNull : (II)V
    //   267: return
    //   268: ldc java/lang/String
    //   270: aload #4
    //   272: if_acmpne -> 290
    //   275: aload_2
    //   276: aload_0
    //   277: getfield features : I
    //   280: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullStringAsEmpty : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   283: getfield mask : I
    //   286: invokevirtual writeNull : (II)V
    //   289: return
    //   290: ldc_w java/lang/Boolean
    //   293: aload #4
    //   295: if_acmpne -> 313
    //   298: aload_2
    //   299: aload_0
    //   300: getfield features : I
    //   303: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullBooleanAsFalse : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   306: getfield mask : I
    //   309: invokevirtual writeNull : (II)V
    //   312: return
    //   313: ldc_w java/util/Collection
    //   316: aload #4
    //   318: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   321: ifeq -> 339
    //   324: aload_2
    //   325: aload_0
    //   326: getfield features : I
    //   329: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullListAsEmpty : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   332: getfield mask : I
    //   335: invokevirtual writeNull : (II)V
    //   338: return
    //   339: aload #5
    //   341: getfield fieldSerializer : Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   344: astore #5
    //   346: aload_2
    //   347: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WRITE_MAP_NULL_FEATURES : I
    //   350: invokevirtual isEnabled : (I)Z
    //   353: ifeq -> 369
    //   356: aload #5
    //   358: instanceof com/alibaba/fastjson/serializer/JavaBeanSerializer
    //   361: ifeq -> 369
    //   364: aload_2
    //   365: invokevirtual writeNull : ()V
    //   368: return
    //   369: aload #5
    //   371: aload_1
    //   372: aconst_null
    //   373: aload_0
    //   374: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   377: getfield name : Ljava/lang/String;
    //   380: aload_0
    //   381: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   384: getfield fieldType : Ljava/lang/reflect/Type;
    //   387: iload #6
    //   389: invokeinterface write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V
    //   394: return
    //   395: aload_0
    //   396: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   399: getfield isEnum : Z
    //   402: ifeq -> 449
    //   405: aload_0
    //   406: getfield writeEnumUsingName : Z
    //   409: ifeq -> 427
    //   412: aload_1
    //   413: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   416: aload_2
    //   417: checkcast java/lang/Enum
    //   420: invokevirtual name : ()Ljava/lang/String;
    //   423: invokevirtual writeString : (Ljava/lang/String;)V
    //   426: return
    //   427: aload_0
    //   428: getfield writeEnumUsingToString : Z
    //   431: ifeq -> 449
    //   434: aload_1
    //   435: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   438: aload_2
    //   439: checkcast java/lang/Enum
    //   442: invokevirtual toString : ()Ljava/lang/String;
    //   445: invokevirtual writeString : (Ljava/lang/String;)V
    //   448: return
    //   449: aload_2
    //   450: invokevirtual getClass : ()Ljava/lang/Class;
    //   453: astore #4
    //   455: aload #4
    //   457: aload #5
    //   459: getfield runtimeFieldClass : Ljava/lang/Class;
    //   462: if_acmpeq -> 486
    //   465: aload_0
    //   466: getfield serializeUsing : Z
    //   469: ifeq -> 475
    //   472: goto -> 486
    //   475: aload_1
    //   476: aload #4
    //   478: invokevirtual getObjectWriter : (Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   481: astore #5
    //   483: goto -> 493
    //   486: aload #5
    //   488: getfield fieldSerializer : Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   491: astore #5
    //   493: aload_0
    //   494: getfield format : Ljava/lang/String;
    //   497: ifnull -> 553
    //   500: aload #5
    //   502: instanceof com/alibaba/fastjson/serializer/DoubleSerializer
    //   505: ifne -> 553
    //   508: aload #5
    //   510: instanceof com/alibaba/fastjson/serializer/FloatCodec
    //   513: ifne -> 553
    //   516: aload #5
    //   518: instanceof com/alibaba/fastjson/serializer/ContextObjectSerializer
    //   521: ifeq -> 543
    //   524: aload #5
    //   526: checkcast com/alibaba/fastjson/serializer/ContextObjectSerializer
    //   529: aload_1
    //   530: aload_2
    //   531: aload_0
    //   532: getfield fieldContext : Lcom/alibaba/fastjson/serializer/BeanContext;
    //   535: invokeinterface write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Lcom/alibaba/fastjson/serializer/BeanContext;)V
    //   540: goto -> 552
    //   543: aload_1
    //   544: aload_2
    //   545: aload_0
    //   546: getfield format : Ljava/lang/String;
    //   549: invokevirtual writeWithFormat : (Ljava/lang/Object;Ljava/lang/String;)V
    //   552: return
    //   553: aload_0
    //   554: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   557: getfield unwrapped : Z
    //   560: ifeq -> 635
    //   563: aload #5
    //   565: instanceof com/alibaba/fastjson/serializer/JavaBeanSerializer
    //   568: ifeq -> 599
    //   571: aload #5
    //   573: checkcast com/alibaba/fastjson/serializer/JavaBeanSerializer
    //   576: aload_1
    //   577: aload_2
    //   578: aload_0
    //   579: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   582: getfield name : Ljava/lang/String;
    //   585: aload_0
    //   586: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   589: getfield fieldType : Ljava/lang/reflect/Type;
    //   592: iload #6
    //   594: iconst_1
    //   595: invokevirtual write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;IZ)V
    //   598: return
    //   599: aload #5
    //   601: instanceof com/alibaba/fastjson/serializer/MapSerializer
    //   604: ifeq -> 635
    //   607: aload #5
    //   609: checkcast com/alibaba/fastjson/serializer/MapSerializer
    //   612: aload_1
    //   613: aload_2
    //   614: aload_0
    //   615: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   618: getfield name : Ljava/lang/String;
    //   621: aload_0
    //   622: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   625: getfield fieldType : Ljava/lang/reflect/Type;
    //   628: iload #6
    //   630: iconst_1
    //   631: invokevirtual write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;IZ)V
    //   634: return
    //   635: aload #5
    //   637: aload_1
    //   638: aload_2
    //   639: aload_0
    //   640: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   643: getfield name : Ljava/lang/String;
    //   646: aload_0
    //   647: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   650: getfield fieldType : Ljava/lang/reflect/Type;
    //   653: iload #6
    //   655: invokeinterface write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V
    //   660: return
  }
  
  static class RuntimeSerializerInfo {
    final ObjectSerializer fieldSerializer;
    
    final Class<?> runtimeFieldClass;
    
    public RuntimeSerializerInfo(ObjectSerializer param1ObjectSerializer, Class<?> param1Class) {
      this.fieldSerializer = param1ObjectSerializer;
      this.runtimeFieldClass = param1Class;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\FieldSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */