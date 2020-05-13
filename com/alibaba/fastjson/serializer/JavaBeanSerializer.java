package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
  protected SerializeBeanInfo beanInfo;
  
  protected final FieldSerializer[] getters;
  
  protected final FieldSerializer[] sortedGetters;
  
  public JavaBeanSerializer(SerializeBeanInfo paramSerializeBeanInfo) {
    this.beanInfo = paramSerializeBeanInfo;
    this.sortedGetters = new FieldSerializer[paramSerializeBeanInfo.sortedFields.length];
    boolean bool = false;
    byte b;
    for (b = 0; b < this.sortedGetters.length; b++)
      this.sortedGetters[b] = new FieldSerializer(paramSerializeBeanInfo.beanType, paramSerializeBeanInfo.sortedFields[b]); 
    if (paramSerializeBeanInfo.fields == paramSerializeBeanInfo.sortedFields) {
      this.getters = this.sortedGetters;
    } else {
      this.getters = new FieldSerializer[paramSerializeBeanInfo.fields.length];
      for (b = bool; b < this.getters.length; b++)
        this.getters[b] = getFieldSerializer((paramSerializeBeanInfo.fields[b]).name); 
    } 
  }
  
  public JavaBeanSerializer(Class<?> paramClass) {
    this(paramClass, (Map<String, String>)null);
  }
  
  public JavaBeanSerializer(Class<?> paramClass, Map<String, String> paramMap) {
    this(TypeUtils.buildBeanInfo(paramClass, paramMap, null));
  }
  
  public JavaBeanSerializer(Class<?> paramClass, String... paramVarArgs) {
    this(paramClass, createAliasMap(paramVarArgs));
  }
  
  static Map<String, String> createAliasMap(String... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str = paramVarArgs[b];
      hashMap.put(str, str);
    } 
    return (Map)hashMap;
  }
  
  protected boolean applyLabel(JSONSerializer paramJSONSerializer, String paramString) {
    if (paramJSONSerializer.labelFilters != null) {
      Iterator<LabelFilter> iterator = paramJSONSerializer.labelFilters.iterator();
      while (iterator.hasNext()) {
        if (!((LabelFilter)iterator.next()).apply(paramString))
          return false; 
      } 
    } 
    if (this.labelFilters != null) {
      Iterator<LabelFilter> iterator = this.labelFilters.iterator();
      while (iterator.hasNext()) {
        if (!((LabelFilter)iterator.next()).apply(paramString))
          return false; 
      } 
    } 
    return true;
  }
  
  protected BeanContext getBeanContext(int paramInt) {
    return (this.sortedGetters[paramInt]).fieldContext;
  }
  
  public FieldSerializer getFieldSerializer(String paramString) {
    if (paramString == null)
      return null; 
    int i = 0;
    int j = this.sortedGetters.length - 1;
    while (i <= j) {
      int k = i + j >>> 1;
      int m = (this.sortedGetters[k]).fieldInfo.name.compareTo(paramString);
      if (m < 0) {
        i = k + 1;
        continue;
      } 
      if (m > 0) {
        j = k - 1;
        continue;
      } 
      return this.sortedGetters[k];
    } 
    return null;
  }
  
  protected Type getFieldType(int paramInt) {
    return (this.sortedGetters[paramInt]).fieldInfo.fieldType;
  }
  
  public Object getFieldValue(Object paramObject, String paramString) {
    FieldSerializer fieldSerializer = getFieldSerializer(paramString);
    if (fieldSerializer != null)
      try {
        return fieldSerializer.getPropertyValue(paramObject);
      } catch (InvocationTargetException invocationTargetException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getFieldValue error.");
        stringBuilder.append(paramString);
        throw new JSONException(stringBuilder.toString(), invocationTargetException);
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getFieldValue error.");
        stringBuilder.append(paramString);
        throw new JSONException(stringBuilder.toString(), illegalAccessException);
      }  
    paramObject = new StringBuilder();
    paramObject.append("field not found. ");
    paramObject.append(paramString);
    throw new JSONException(paramObject.toString());
  }
  
  public List<Object> getFieldValues(Object paramObject) throws Exception {
    ArrayList<Object> arrayList = new ArrayList(this.sortedGetters.length);
    FieldSerializer[] arrayOfFieldSerializer = this.sortedGetters;
    int i = arrayOfFieldSerializer.length;
    for (byte b = 0; b < i; b++)
      arrayList.add(arrayOfFieldSerializer[b].getPropertyValue(paramObject)); 
    return arrayList;
  }
  
  public Map<String, Object> getFieldValuesMap(Object paramObject) throws Exception {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(this.sortedGetters.length);
    for (FieldSerializer fieldSerializer : this.sortedGetters)
      linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(paramObject)); 
    return (Map)linkedHashMap;
  }
  
  public List<Object> getObjectFieldValues(Object paramObject) throws Exception {
    ArrayList<Object> arrayList = new ArrayList(this.sortedGetters.length);
    for (FieldSerializer fieldSerializer : this.sortedGetters) {
      Class clazz = fieldSerializer.fieldInfo.fieldClass;
      if (!clazz.isPrimitive() && !clazz.getName().startsWith("java.lang."))
        arrayList.add(fieldSerializer.getPropertyValue(paramObject)); 
    } 
    return arrayList;
  }
  
  public int getSize(Object paramObject) throws Exception {
    FieldSerializer[] arrayOfFieldSerializer = this.sortedGetters;
    int i = arrayOfFieldSerializer.length;
    byte b = 0;
    int j;
    for (j = 0; b < i; j = k) {
      int k = j;
      if (arrayOfFieldSerializer[b].getPropertyValueDirect(paramObject) != null)
        k = j + 1; 
      b++;
    } 
    return j;
  }
  
  protected boolean isWriteAsArray(JSONSerializer paramJSONSerializer) {
    return isWriteAsArray(paramJSONSerializer, 0);
  }
  
  protected boolean isWriteAsArray(JSONSerializer paramJSONSerializer, int paramInt) {
    int i = SerializerFeature.BeanToArray.mask;
    return ((this.beanInfo.features & i) != 0 || paramJSONSerializer.out.beanToArray || (paramInt & i) != 0);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt, false);
  }
  
  protected void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_2
    //   1: astore #7
    //   3: aload #4
    //   5: astore #8
    //   7: aload_1
    //   8: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   11: astore #9
    //   13: aload #7
    //   15: ifnonnull -> 24
    //   18: aload #9
    //   20: invokevirtual writeNull : ()V
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: aload #7
    //   28: iload #5
    //   30: invokevirtual writeReference : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;I)Z
    //   33: ifeq -> 37
    //   36: return
    //   37: aload #9
    //   39: getfield sortField : Z
    //   42: ifeq -> 58
    //   45: aload_0
    //   46: getfield sortedGetters : [Lcom/alibaba/fastjson/serializer/FieldSerializer;
    //   49: astore #10
    //   51: aload #10
    //   53: astore #11
    //   55: goto -> 67
    //   58: aload_0
    //   59: getfield getters : [Lcom/alibaba/fastjson/serializer/FieldSerializer;
    //   62: astore #10
    //   64: goto -> 51
    //   67: aload_1
    //   68: getfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   71: astore #10
    //   73: aload_1
    //   74: aload #10
    //   76: aload_2
    //   77: aload_3
    //   78: aload_0
    //   79: getfield beanInfo : Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;
    //   82: getfield features : I
    //   85: iload #5
    //   87: invokevirtual setContext : (Lcom/alibaba/fastjson/serializer/SerialContext;Ljava/lang/Object;Ljava/lang/Object;II)V
    //   90: aload_0
    //   91: aload_1
    //   92: iload #5
    //   94: invokevirtual isWriteAsArray : (Lcom/alibaba/fastjson/serializer/JSONSerializer;I)Z
    //   97: istore #12
    //   99: iload #12
    //   101: ifeq -> 115
    //   104: bipush #91
    //   106: istore #5
    //   108: iload #5
    //   110: istore #13
    //   112: goto -> 123
    //   115: bipush #123
    //   117: istore #5
    //   119: iload #5
    //   121: istore #13
    //   123: iload #12
    //   125: ifeq -> 135
    //   128: bipush #93
    //   130: istore #14
    //   132: goto -> 139
    //   135: bipush #125
    //   137: istore #14
    //   139: iload #6
    //   141: ifne -> 183
    //   144: aload #10
    //   146: astore #15
    //   148: aload #10
    //   150: astore #16
    //   152: aload #9
    //   154: iload #13
    //   156: invokevirtual append : (C)Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   159: pop
    //   160: goto -> 183
    //   163: astore_2
    //   164: aload #15
    //   166: astore #4
    //   168: goto -> 1704
    //   171: astore #10
    //   173: aload_2
    //   174: astore #15
    //   176: aload #16
    //   178: astore #4
    //   180: goto -> 1544
    //   183: aload #10
    //   185: astore #15
    //   187: aload #10
    //   189: astore #16
    //   191: aload #11
    //   193: arraylength
    //   194: ifle -> 240
    //   197: aload #10
    //   199: astore #15
    //   201: aload #10
    //   203: astore #16
    //   205: aload #9
    //   207: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   210: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   213: ifeq -> 240
    //   216: aload #10
    //   218: astore #15
    //   220: aload #10
    //   222: astore #16
    //   224: aload_1
    //   225: invokevirtual incrementIndent : ()V
    //   228: aload #10
    //   230: astore #15
    //   232: aload #10
    //   234: astore #16
    //   236: aload_1
    //   237: invokevirtual println : ()V
    //   240: aload #10
    //   242: astore #15
    //   244: aload #10
    //   246: astore #16
    //   248: aload_0
    //   249: getfield beanInfo : Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;
    //   252: getfield features : I
    //   255: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteClassName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   258: getfield mask : I
    //   261: iand
    //   262: ifne -> 284
    //   265: aload #10
    //   267: astore #15
    //   269: aload #10
    //   271: astore #16
    //   273: aload_1
    //   274: aload #8
    //   276: aload #7
    //   278: invokevirtual isWriteClassName : (Ljava/lang/reflect/Type;Ljava/lang/Object;)Z
    //   281: ifeq -> 329
    //   284: aload #10
    //   286: astore #15
    //   288: aload #10
    //   290: astore #16
    //   292: aload_2
    //   293: invokevirtual getClass : ()Ljava/lang/Class;
    //   296: aload #8
    //   298: if_acmpeq -> 329
    //   301: aload #10
    //   303: astore #15
    //   305: aload #10
    //   307: astore #16
    //   309: aload_0
    //   310: aload_1
    //   311: aload_0
    //   312: getfield beanInfo : Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;
    //   315: getfield typeKey : Ljava/lang/String;
    //   318: aload #7
    //   320: invokevirtual writeClassName : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/String;Ljava/lang/Object;)V
    //   323: iconst_1
    //   324: istore #5
    //   326: goto -> 332
    //   329: iconst_0
    //   330: istore #5
    //   332: iload #5
    //   334: ifeq -> 348
    //   337: bipush #44
    //   339: istore #5
    //   341: iload #5
    //   343: istore #13
    //   345: goto -> 355
    //   348: iconst_0
    //   349: istore #5
    //   351: iload #5
    //   353: istore #13
    //   355: aload #10
    //   357: astore #15
    //   359: aload #10
    //   361: astore #16
    //   363: aload #9
    //   365: getfield quoteFieldNames : Z
    //   368: ifeq -> 393
    //   371: aload #10
    //   373: astore #15
    //   375: aload #10
    //   377: astore #16
    //   379: aload #9
    //   381: getfield useSingleQuotes : Z
    //   384: ifne -> 393
    //   387: iconst_1
    //   388: istore #17
    //   390: goto -> 396
    //   393: iconst_0
    //   394: istore #17
    //   396: aload #10
    //   398: astore #15
    //   400: aload #10
    //   402: astore #16
    //   404: aload_0
    //   405: aload_1
    //   406: aload #7
    //   408: iload #13
    //   410: invokevirtual writeBefore : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;C)C
    //   413: bipush #44
    //   415: if_icmpne -> 424
    //   418: iconst_1
    //   419: istore #5
    //   421: goto -> 427
    //   424: iconst_0
    //   425: istore #5
    //   427: aload #10
    //   429: astore #15
    //   431: aload #10
    //   433: astore #16
    //   435: aload #9
    //   437: getstatic com/alibaba/fastjson/serializer/SerializerFeature.SkipTransientField : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   440: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   443: istore #18
    //   445: aload #10
    //   447: astore #15
    //   449: aload #10
    //   451: astore #16
    //   453: aload #9
    //   455: getstatic com/alibaba/fastjson/serializer/SerializerFeature.IgnoreNonFieldGetter : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   458: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   461: istore #19
    //   463: iconst_0
    //   464: istore #20
    //   466: iload #14
    //   468: istore #13
    //   470: iload #20
    //   472: istore #14
    //   474: aload_2
    //   475: astore #7
    //   477: aload #10
    //   479: astore #15
    //   481: aload #10
    //   483: astore #16
    //   485: aload #11
    //   487: arraylength
    //   488: istore #20
    //   490: iload #14
    //   492: iload #20
    //   494: if_icmpge -> 1445
    //   497: aload #11
    //   499: iload #14
    //   501: aaload
    //   502: astore #8
    //   504: aload #10
    //   506: astore #15
    //   508: aload #8
    //   510: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   513: getfield field : Ljava/lang/reflect/Field;
    //   516: astore #16
    //   518: aload #10
    //   520: astore #15
    //   522: aload #8
    //   524: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   527: astore #21
    //   529: aload #10
    //   531: astore #15
    //   533: aload #21
    //   535: getfield name : Ljava/lang/String;
    //   538: astore #22
    //   540: aload #21
    //   542: getfield fieldClass : Ljava/lang/Class;
    //   545: astore #23
    //   547: iload #18
    //   549: ifeq -> 581
    //   552: aload #16
    //   554: ifnull -> 581
    //   557: aload #21
    //   559: getfield fieldTransient : Z
    //   562: istore #24
    //   564: iload #24
    //   566: ifeq -> 581
    //   569: goto -> 591
    //   572: astore #16
    //   574: aload #7
    //   576: astore #15
    //   578: goto -> 1536
    //   581: iload #19
    //   583: ifeq -> 594
    //   586: aload #16
    //   588: ifnonnull -> 594
    //   591: goto -> 1402
    //   594: aload_0
    //   595: aload_1
    //   596: aload #7
    //   598: aload #22
    //   600: invokevirtual applyName : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;)Z
    //   603: ifeq -> 591
    //   606: aload_0
    //   607: aload_1
    //   608: aload #21
    //   610: getfield label : Ljava/lang/String;
    //   613: invokevirtual applyLabel : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/String;)Z
    //   616: ifne -> 622
    //   619: goto -> 591
    //   622: aload_0
    //   623: getfield beanInfo : Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;
    //   626: getfield typeKey : Ljava/lang/String;
    //   629: astore #16
    //   631: aload #16
    //   633: ifnull -> 669
    //   636: aload #22
    //   638: aload_0
    //   639: getfield beanInfo : Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;
    //   642: getfield typeKey : Ljava/lang/String;
    //   645: invokevirtual equals : (Ljava/lang/Object;)Z
    //   648: ifeq -> 669
    //   651: aload_1
    //   652: aload #4
    //   654: aload #7
    //   656: invokevirtual isWriteClassName : (Ljava/lang/reflect/Type;Ljava/lang/Object;)Z
    //   659: istore #24
    //   661: iload #24
    //   663: ifeq -> 669
    //   666: goto -> 591
    //   669: aload #8
    //   671: aload #7
    //   673: invokevirtual getPropertyValueDirect : (Ljava/lang/Object;)Ljava/lang/Object;
    //   676: astore #16
    //   678: goto -> 697
    //   681: astore #16
    //   683: aload #9
    //   685: getstatic com/alibaba/fastjson/serializer/SerializerFeature.IgnoreErrorGetter : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   688: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   691: ifeq -> 1399
    //   694: aconst_null
    //   695: astore #16
    //   697: aload_0
    //   698: aload_1
    //   699: aload #7
    //   701: aload #22
    //   703: aload #16
    //   705: invokevirtual apply : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   708: ifne -> 714
    //   711: goto -> 591
    //   714: aload_0
    //   715: aload_1
    //   716: aload #7
    //   718: aload #22
    //   720: aload #16
    //   722: invokevirtual processKey : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   725: astore #25
    //   727: aload_0
    //   728: aload_1
    //   729: aload #8
    //   731: getfield fieldContext : Lcom/alibaba/fastjson/serializer/BeanContext;
    //   734: aload_2
    //   735: aload #22
    //   737: aload #16
    //   739: invokevirtual processValue : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Lcom/alibaba/fastjson/serializer/BeanContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   742: astore #7
    //   744: aload #7
    //   746: ifnonnull -> 776
    //   749: iload #12
    //   751: ifne -> 776
    //   754: aload #8
    //   756: getfield writeNull : Z
    //   759: ifne -> 776
    //   762: aload #9
    //   764: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WRITE_MAP_NULL_FEATURES : I
    //   767: invokevirtual isEnabled : (I)Z
    //   770: ifne -> 776
    //   773: goto -> 1402
    //   776: aload #7
    //   778: ifnull -> 1044
    //   781: aload #9
    //   783: getfield notWriteDefaultValue : Z
    //   786: ifne -> 821
    //   789: aload #21
    //   791: getfield serialzeFeatures : I
    //   794: getstatic com/alibaba/fastjson/serializer/SerializerFeature.NotWriteDefaultValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   797: getfield mask : I
    //   800: iand
    //   801: ifne -> 821
    //   804: aload_0
    //   805: getfield beanInfo : Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;
    //   808: getfield features : I
    //   811: getstatic com/alibaba/fastjson/serializer/SerializerFeature.NotWriteDefaultValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   814: getfield mask : I
    //   817: iand
    //   818: ifeq -> 1044
    //   821: aload #21
    //   823: getfield fieldClass : Ljava/lang/Class;
    //   826: astore #26
    //   828: aload #26
    //   830: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
    //   833: if_acmpne -> 858
    //   836: aload #7
    //   838: instanceof java/lang/Byte
    //   841: ifeq -> 858
    //   844: aload #7
    //   846: checkcast java/lang/Byte
    //   849: invokevirtual byteValue : ()B
    //   852: ifne -> 858
    //   855: goto -> 1078
    //   858: aload #26
    //   860: getstatic java/lang/Short.TYPE : Ljava/lang/Class;
    //   863: if_acmpne -> 888
    //   866: aload #7
    //   868: instanceof java/lang/Short
    //   871: ifeq -> 888
    //   874: aload #7
    //   876: checkcast java/lang/Short
    //   879: invokevirtual shortValue : ()S
    //   882: ifne -> 888
    //   885: goto -> 773
    //   888: aload #26
    //   890: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   893: if_acmpne -> 918
    //   896: aload #7
    //   898: instanceof java/lang/Integer
    //   901: ifeq -> 918
    //   904: aload #7
    //   906: checkcast java/lang/Integer
    //   909: invokevirtual intValue : ()I
    //   912: ifne -> 918
    //   915: goto -> 1078
    //   918: aload #26
    //   920: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   923: if_acmpne -> 950
    //   926: aload #7
    //   928: instanceof java/lang/Long
    //   931: ifeq -> 950
    //   934: aload #7
    //   936: checkcast java/lang/Long
    //   939: invokevirtual longValue : ()J
    //   942: lconst_0
    //   943: lcmp
    //   944: ifne -> 950
    //   947: goto -> 773
    //   950: aload #26
    //   952: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   955: if_acmpne -> 982
    //   958: aload #7
    //   960: instanceof java/lang/Float
    //   963: ifeq -> 982
    //   966: aload #7
    //   968: checkcast java/lang/Float
    //   971: invokevirtual floatValue : ()F
    //   974: fconst_0
    //   975: fcmpl
    //   976: ifne -> 982
    //   979: goto -> 1078
    //   982: aload #26
    //   984: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   987: if_acmpne -> 1014
    //   990: aload #7
    //   992: instanceof java/lang/Double
    //   995: ifeq -> 1014
    //   998: aload #7
    //   1000: checkcast java/lang/Double
    //   1003: invokevirtual doubleValue : ()D
    //   1006: dconst_0
    //   1007: dcmpl
    //   1008: ifne -> 1014
    //   1011: goto -> 885
    //   1014: aload #26
    //   1016: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1019: if_acmpne -> 1044
    //   1022: aload #7
    //   1024: instanceof java/lang/Boolean
    //   1027: ifeq -> 1044
    //   1030: aload #7
    //   1032: checkcast java/lang/Boolean
    //   1035: invokevirtual booleanValue : ()Z
    //   1038: ifne -> 1044
    //   1041: goto -> 1078
    //   1044: iload #5
    //   1046: ifeq -> 1103
    //   1049: aload #21
    //   1051: getfield unwrapped : Z
    //   1054: ifeq -> 1081
    //   1057: aload #7
    //   1059: instanceof java/util/Map
    //   1062: ifeq -> 1081
    //   1065: aload #7
    //   1067: checkcast java/util/Map
    //   1070: invokeinterface size : ()I
    //   1075: ifne -> 1081
    //   1078: goto -> 773
    //   1081: aload #9
    //   1083: bipush #44
    //   1085: invokevirtual write : (I)V
    //   1088: aload #9
    //   1090: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1093: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1096: ifeq -> 1103
    //   1099: aload_1
    //   1100: invokevirtual println : ()V
    //   1103: aload #25
    //   1105: aload #22
    //   1107: if_acmpeq -> 1135
    //   1110: iload #12
    //   1112: ifne -> 1126
    //   1115: aload #9
    //   1117: aload #25
    //   1119: iconst_1
    //   1120: invokevirtual writeFieldName : (Ljava/lang/String;Z)V
    //   1123: goto -> 1126
    //   1126: aload_1
    //   1127: aload #7
    //   1129: invokevirtual write : (Ljava/lang/Object;)V
    //   1132: goto -> 1393
    //   1135: aload #16
    //   1137: aload #7
    //   1139: if_acmpeq -> 1162
    //   1142: iload #12
    //   1144: ifne -> 1153
    //   1147: aload #8
    //   1149: aload_1
    //   1150: invokevirtual writePrefix : (Lcom/alibaba/fastjson/serializer/JSONSerializer;)V
    //   1153: aload_1
    //   1154: aload #7
    //   1156: invokevirtual write : (Ljava/lang/Object;)V
    //   1159: goto -> 1132
    //   1162: iload #12
    //   1164: ifne -> 1209
    //   1167: aload #21
    //   1169: getfield unwrapped : Z
    //   1172: ifne -> 1209
    //   1175: iload #17
    //   1177: ifeq -> 1200
    //   1180: aload #9
    //   1182: aload #21
    //   1184: getfield name_chars : [C
    //   1187: iconst_0
    //   1188: aload #21
    //   1190: getfield name_chars : [C
    //   1193: arraylength
    //   1194: invokevirtual write : ([CII)V
    //   1197: goto -> 1209
    //   1200: aload #8
    //   1202: aload_1
    //   1203: invokevirtual writePrefix : (Lcom/alibaba/fastjson/serializer/JSONSerializer;)V
    //   1206: goto -> 1209
    //   1209: iload #12
    //   1211: ifne -> 1385
    //   1214: aload #21
    //   1216: invokevirtual getAnnotation : ()Lcom/alibaba/fastjson/annotation/JSONField;
    //   1219: astore #16
    //   1221: aload #23
    //   1223: ldc java/lang/String
    //   1225: if_acmpne -> 1339
    //   1228: aload #16
    //   1230: ifnull -> 1246
    //   1233: aload #16
    //   1235: invokeinterface serializeUsing : ()Ljava/lang/Class;
    //   1240: ldc_w java/lang/Void
    //   1243: if_acmpne -> 1339
    //   1246: aload #7
    //   1248: ifnonnull -> 1303
    //   1251: aload #9
    //   1253: getfield features : I
    //   1256: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullStringAsEmpty : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1259: getfield mask : I
    //   1262: iand
    //   1263: ifne -> 1292
    //   1266: aload #8
    //   1268: getfield features : I
    //   1271: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullStringAsEmpty : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1274: getfield mask : I
    //   1277: iand
    //   1278: ifeq -> 1284
    //   1281: goto -> 1292
    //   1284: aload #9
    //   1286: invokevirtual writeNull : ()V
    //   1289: goto -> 1393
    //   1292: aload #9
    //   1294: ldc_w ''
    //   1297: invokevirtual writeString : (Ljava/lang/String;)V
    //   1300: goto -> 1393
    //   1303: aload #7
    //   1305: checkcast java/lang/String
    //   1308: astore #16
    //   1310: aload #9
    //   1312: getfield useSingleQuotes : Z
    //   1315: ifeq -> 1328
    //   1318: aload #9
    //   1320: aload #16
    //   1322: invokevirtual writeStringWithSingleQuote : (Ljava/lang/String;)V
    //   1325: goto -> 1393
    //   1328: aload #9
    //   1330: aload #16
    //   1332: iconst_0
    //   1333: invokevirtual writeStringWithDoubleQuote : (Ljava/lang/String;C)V
    //   1336: goto -> 1393
    //   1339: aload #21
    //   1341: getfield unwrapped : Z
    //   1344: ifeq -> 1374
    //   1347: aload #7
    //   1349: instanceof java/util/Map
    //   1352: ifeq -> 1374
    //   1355: aload #7
    //   1357: checkcast java/util/Map
    //   1360: invokeinterface size : ()I
    //   1365: ifne -> 1374
    //   1368: iconst_0
    //   1369: istore #5
    //   1371: goto -> 1402
    //   1374: aload #8
    //   1376: aload_1
    //   1377: aload #7
    //   1379: invokevirtual writeValue : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;)V
    //   1382: goto -> 1393
    //   1385: aload #8
    //   1387: aload_1
    //   1388: aload #7
    //   1390: invokevirtual writeValue : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;)V
    //   1393: iconst_1
    //   1394: istore #5
    //   1396: goto -> 1402
    //   1399: aload #16
    //   1401: athrow
    //   1402: iinc #14, 1
    //   1405: aload #15
    //   1407: astore #10
    //   1409: iload #13
    //   1411: istore #20
    //   1413: iload #20
    //   1415: istore #13
    //   1417: goto -> 474
    //   1420: astore #4
    //   1422: goto -> 1427
    //   1425: astore #4
    //   1427: aload #10
    //   1429: astore #16
    //   1431: aload_2
    //   1432: astore #15
    //   1434: aload #4
    //   1436: astore #10
    //   1438: aload #16
    //   1440: astore #4
    //   1442: goto -> 1544
    //   1445: bipush #44
    //   1447: istore #14
    //   1449: iload #5
    //   1451: ifeq -> 1461
    //   1454: iload #14
    //   1456: istore #27
    //   1458: goto -> 1468
    //   1461: iconst_0
    //   1462: istore #5
    //   1464: iload #5
    //   1466: istore #27
    //   1468: aload_2
    //   1469: astore #15
    //   1471: aload_0
    //   1472: aload_1
    //   1473: aload #15
    //   1475: iload #27
    //   1477: invokevirtual writeAfter : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;C)C
    //   1480: pop
    //   1481: aload #11
    //   1483: arraylength
    //   1484: ifle -> 1506
    //   1487: aload #9
    //   1489: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1492: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1495: ifeq -> 1506
    //   1498: aload_1
    //   1499: invokevirtual decrementIdent : ()V
    //   1502: aload_1
    //   1503: invokevirtual println : ()V
    //   1506: iload #6
    //   1508: ifne -> 1519
    //   1511: aload #9
    //   1513: iload #13
    //   1515: invokevirtual append : (C)Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   1518: pop
    //   1519: aload_1
    //   1520: aload #10
    //   1522: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   1525: return
    //   1526: astore_2
    //   1527: aload #10
    //   1529: astore #4
    //   1531: goto -> 1704
    //   1534: astore #16
    //   1536: aload #10
    //   1538: astore #4
    //   1540: aload #16
    //   1542: astore #10
    //   1544: ldc_w 'write javaBean error'
    //   1547: astore #16
    //   1549: aload #15
    //   1551: ifnull -> 1602
    //   1554: new java/lang/StringBuilder
    //   1557: astore #15
    //   1559: aload #15
    //   1561: invokespecial <init> : ()V
    //   1564: aload #15
    //   1566: ldc_w 'write javaBean error'
    //   1569: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: pop
    //   1573: aload #15
    //   1575: ldc_w ', class '
    //   1578: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1581: pop
    //   1582: aload #15
    //   1584: aload_2
    //   1585: invokevirtual getClass : ()Ljava/lang/Class;
    //   1588: invokevirtual getName : ()Ljava/lang/String;
    //   1591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: pop
    //   1595: aload #15
    //   1597: invokevirtual toString : ()Ljava/lang/String;
    //   1600: astore #16
    //   1602: aload #16
    //   1604: astore_2
    //   1605: aload_3
    //   1606: ifnull -> 1643
    //   1609: new java/lang/StringBuilder
    //   1612: astore_2
    //   1613: aload_2
    //   1614: invokespecial <init> : ()V
    //   1617: aload_2
    //   1618: aload #16
    //   1620: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: pop
    //   1624: aload_2
    //   1625: ldc_w ', fieldName : '
    //   1628: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: pop
    //   1632: aload_2
    //   1633: aload_3
    //   1634: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1637: pop
    //   1638: aload_2
    //   1639: invokevirtual toString : ()Ljava/lang/String;
    //   1642: astore_2
    //   1643: aload_2
    //   1644: astore_3
    //   1645: aload #10
    //   1647: invokevirtual getMessage : ()Ljava/lang/String;
    //   1650: ifnull -> 1690
    //   1653: new java/lang/StringBuilder
    //   1656: astore_3
    //   1657: aload_3
    //   1658: invokespecial <init> : ()V
    //   1661: aload_3
    //   1662: aload_2
    //   1663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: pop
    //   1667: aload_3
    //   1668: ldc_w ', '
    //   1671: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: pop
    //   1675: aload_3
    //   1676: aload #10
    //   1678: invokevirtual getMessage : ()Ljava/lang/String;
    //   1681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: pop
    //   1685: aload_3
    //   1686: invokevirtual toString : ()Ljava/lang/String;
    //   1689: astore_3
    //   1690: new com/alibaba/fastjson/JSONException
    //   1693: astore_2
    //   1694: aload_2
    //   1695: aload_3
    //   1696: aload #10
    //   1698: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1701: aload_2
    //   1702: athrow
    //   1703: astore_2
    //   1704: aload_1
    //   1705: aload #4
    //   1707: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   1710: aload_2
    //   1711: athrow
    // Exception table:
    //   from	to	target	type
    //   152	160	171	java/lang/Exception
    //   152	160	163	finally
    //   191	197	171	java/lang/Exception
    //   191	197	163	finally
    //   205	216	171	java/lang/Exception
    //   205	216	163	finally
    //   224	228	171	java/lang/Exception
    //   224	228	163	finally
    //   236	240	171	java/lang/Exception
    //   236	240	163	finally
    //   248	265	171	java/lang/Exception
    //   248	265	163	finally
    //   273	284	171	java/lang/Exception
    //   273	284	163	finally
    //   292	301	171	java/lang/Exception
    //   292	301	163	finally
    //   309	323	171	java/lang/Exception
    //   309	323	163	finally
    //   363	371	171	java/lang/Exception
    //   363	371	163	finally
    //   379	387	171	java/lang/Exception
    //   379	387	163	finally
    //   404	418	171	java/lang/Exception
    //   404	418	163	finally
    //   435	445	171	java/lang/Exception
    //   435	445	163	finally
    //   453	463	171	java/lang/Exception
    //   453	463	163	finally
    //   485	490	171	java/lang/Exception
    //   485	490	163	finally
    //   508	518	1425	java/lang/Exception
    //   508	518	163	finally
    //   522	529	1425	java/lang/Exception
    //   522	529	163	finally
    //   533	547	1420	java/lang/Exception
    //   533	547	1526	finally
    //   557	564	572	java/lang/Exception
    //   557	564	1526	finally
    //   594	619	1420	java/lang/Exception
    //   594	619	1526	finally
    //   622	631	1420	java/lang/Exception
    //   622	631	1526	finally
    //   636	661	572	java/lang/Exception
    //   636	661	1526	finally
    //   669	678	681	java/lang/reflect/InvocationTargetException
    //   669	678	572	java/lang/Exception
    //   669	678	1526	finally
    //   683	694	1420	java/lang/Exception
    //   683	694	1526	finally
    //   697	711	1420	java/lang/Exception
    //   697	711	1526	finally
    //   714	744	1420	java/lang/Exception
    //   714	744	1526	finally
    //   754	773	1420	java/lang/Exception
    //   754	773	1526	finally
    //   781	821	1420	java/lang/Exception
    //   781	821	1526	finally
    //   821	855	1420	java/lang/Exception
    //   821	855	1526	finally
    //   858	885	1420	java/lang/Exception
    //   858	885	1526	finally
    //   888	915	1420	java/lang/Exception
    //   888	915	1526	finally
    //   918	947	1420	java/lang/Exception
    //   918	947	1526	finally
    //   950	979	1420	java/lang/Exception
    //   950	979	1526	finally
    //   982	1011	1420	java/lang/Exception
    //   982	1011	1526	finally
    //   1014	1041	1420	java/lang/Exception
    //   1014	1041	1526	finally
    //   1049	1078	1420	java/lang/Exception
    //   1049	1078	1526	finally
    //   1081	1103	1420	java/lang/Exception
    //   1081	1103	1526	finally
    //   1115	1123	1420	java/lang/Exception
    //   1115	1123	1526	finally
    //   1126	1132	1420	java/lang/Exception
    //   1126	1132	1526	finally
    //   1147	1153	1420	java/lang/Exception
    //   1147	1153	1526	finally
    //   1153	1159	1420	java/lang/Exception
    //   1153	1159	1526	finally
    //   1167	1175	1420	java/lang/Exception
    //   1167	1175	1526	finally
    //   1180	1197	1420	java/lang/Exception
    //   1180	1197	1526	finally
    //   1200	1206	1420	java/lang/Exception
    //   1200	1206	1526	finally
    //   1214	1221	1420	java/lang/Exception
    //   1214	1221	1526	finally
    //   1233	1246	1420	java/lang/Exception
    //   1233	1246	1526	finally
    //   1251	1281	1420	java/lang/Exception
    //   1251	1281	1526	finally
    //   1284	1289	1420	java/lang/Exception
    //   1284	1289	1526	finally
    //   1292	1300	1420	java/lang/Exception
    //   1292	1300	1526	finally
    //   1303	1325	1420	java/lang/Exception
    //   1303	1325	1526	finally
    //   1328	1336	1420	java/lang/Exception
    //   1328	1336	1526	finally
    //   1339	1368	1420	java/lang/Exception
    //   1339	1368	1526	finally
    //   1374	1382	1420	java/lang/Exception
    //   1374	1382	1526	finally
    //   1385	1393	1420	java/lang/Exception
    //   1385	1393	1526	finally
    //   1399	1402	1420	java/lang/Exception
    //   1399	1402	1526	finally
    //   1471	1506	1534	java/lang/Exception
    //   1471	1506	1526	finally
    //   1511	1519	1534	java/lang/Exception
    //   1511	1519	1526	finally
    //   1554	1602	1703	finally
    //   1609	1643	1703	finally
    //   1645	1690	1703	finally
    //   1690	1703	1703	finally
  }
  
  protected char writeAfter(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar) {
    char c1 = paramChar;
    if (paramJSONSerializer.afterFilters != null) {
      Iterator<AfterFilter> iterator = paramJSONSerializer.afterFilters.iterator();
      char c = paramChar;
      while (true) {
        c1 = c;
        if (iterator.hasNext()) {
          paramChar = ((AfterFilter)iterator.next()).writeAfter(paramJSONSerializer, paramObject, c);
          c = paramChar;
          continue;
        } 
        break;
      } 
    } 
    char c2 = c1;
    if (this.afterFilters != null) {
      Iterator<AfterFilter> iterator = this.afterFilters.iterator();
      char c = c1;
      while (true) {
        c2 = c;
        if (iterator.hasNext()) {
          paramChar = ((AfterFilter)iterator.next()).writeAfter(paramJSONSerializer, paramObject, c);
          c = paramChar;
          continue;
        } 
        break;
      } 
    } 
    return c2;
  }
  
  public void writeAsArray(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt);
  }
  
  public void writeAsArrayNonContext(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt);
  }
  
  protected char writeBefore(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar) {
    char c1 = paramChar;
    if (paramJSONSerializer.beforeFilters != null) {
      Iterator<BeforeFilter> iterator = paramJSONSerializer.beforeFilters.iterator();
      char c = paramChar;
      while (true) {
        c1 = c;
        if (iterator.hasNext()) {
          paramChar = ((BeforeFilter)iterator.next()).writeBefore(paramJSONSerializer, paramObject, c);
          c = paramChar;
          continue;
        } 
        break;
      } 
    } 
    char c2 = c1;
    if (this.beforeFilters != null) {
      Iterator<BeforeFilter> iterator = this.beforeFilters.iterator();
      char c = c1;
      while (true) {
        c2 = c;
        if (iterator.hasNext()) {
          paramChar = ((BeforeFilter)iterator.next()).writeBefore(paramJSONSerializer, paramObject, c);
          c = paramChar;
          continue;
        } 
        break;
      } 
    } 
    return c2;
  }
  
  protected void writeClassName(JSONSerializer paramJSONSerializer, String paramString, Object<?> paramObject) {
    Object<?> object;
    String str = paramString;
    if (paramString == null)
      str = paramJSONSerializer.config.typeKey; 
    paramJSONSerializer.out.writeFieldName(str, false);
    str = this.beanInfo.typeName;
    paramString = str;
    if (str == null) {
      paramObject = (Object<?>)paramObject.getClass();
      object = paramObject;
      if (TypeUtils.isProxy((Class)paramObject))
        object = (Object<?>)paramObject.getSuperclass(); 
      object = (Object<?>)object.getName();
    } 
    paramJSONSerializer.write((String)object);
  }
  
  public void writeDirectNonContext(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt);
  }
  
  public boolean writeReference(JSONSerializer paramJSONSerializer, Object paramObject, int paramInt) {
    SerialContext serialContext = paramJSONSerializer.context;
    int i = SerializerFeature.DisableCircularReferenceDetect.mask;
    if (serialContext == null || (serialContext.features & i) != 0 || (paramInt & i) != 0)
      return false; 
    if (paramJSONSerializer.references != null && paramJSONSerializer.references.containsKey(paramObject)) {
      paramJSONSerializer.writeReference(paramObject);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\JavaBeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */