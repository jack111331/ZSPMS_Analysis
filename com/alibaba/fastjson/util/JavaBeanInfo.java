package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class JavaBeanInfo {
  public final Method buildMethod;
  
  public final Class<?> builderClass;
  
  public final Class<?> clazz;
  
  public final Constructor<?> creatorConstructor;
  
  public final Constructor<?> defaultConstructor;
  
  public final int defaultConstructorParameterSize;
  
  public final Method factoryMethod;
  
  public final FieldInfo[] fields;
  
  public final JSONType jsonType;
  
  public final int parserFeatures;
  
  public final FieldInfo[] sortedFields;
  
  public final String typeKey;
  
  public final String typeName;
  
  public JavaBeanInfo(Class<?> paramClass1, Class<?> paramClass2, Constructor<?> paramConstructor1, Constructor<?> paramConstructor2, Method paramMethod1, Method paramMethod2, JSONType paramJSONType, List<FieldInfo> paramList) {
    this.clazz = paramClass1;
    this.builderClass = paramClass2;
    this.defaultConstructor = paramConstructor1;
    this.creatorConstructor = paramConstructor2;
    this.factoryMethod = paramMethod1;
    this.parserFeatures = TypeUtils.getParserFeatures(paramClass1);
    this.buildMethod = paramMethod2;
    this.jsonType = paramJSONType;
    paramClass2 = null;
    if (paramJSONType != null) {
      String str1;
      String str3 = paramJSONType.typeName();
      String str2 = paramJSONType.typeKey();
      if (str2.length() > 0)
        str1 = str2; 
      this.typeKey = str1;
      if (str3.length() != 0) {
        this.typeName = str3;
      } else {
        this.typeName = paramClass1.getName();
      } 
    } else {
      this.typeName = paramClass1.getName();
      this.typeKey = null;
    } 
    this.fields = new FieldInfo[paramList.size()];
    paramList.toArray(this.fields);
    FieldInfo[] arrayOfFieldInfo2 = new FieldInfo[this.fields.length];
    System.arraycopy(this.fields, 0, arrayOfFieldInfo2, 0, this.fields.length);
    Arrays.sort((Object[])arrayOfFieldInfo2);
    FieldInfo[] arrayOfFieldInfo1 = arrayOfFieldInfo2;
    if (Arrays.equals((Object[])this.fields, (Object[])arrayOfFieldInfo2))
      arrayOfFieldInfo1 = this.fields; 
    this.sortedFields = arrayOfFieldInfo1;
    if (paramConstructor1 != null) {
      this.defaultConstructorParameterSize = (paramConstructor1.getParameterTypes()).length;
    } else if (paramMethod1 != null) {
      this.defaultConstructorParameterSize = (paramMethod1.getParameterTypes()).length;
    } else {
      this.defaultConstructorParameterSize = 0;
    } 
  }
  
  static boolean add(List<FieldInfo> paramList, FieldInfo paramFieldInfo) {
    int i = paramList.size() - 1;
    while (i >= 0) {
      FieldInfo fieldInfo = paramList.get(i);
      if (!fieldInfo.name.equals(paramFieldInfo.name) || (fieldInfo.getOnly && !paramFieldInfo.getOnly)) {
        i--;
        continue;
      } 
      if (fieldInfo.fieldClass.isAssignableFrom(paramFieldInfo.fieldClass)) {
        paramList.remove(i);
        break;
      } 
      if (fieldInfo.compareTo(paramFieldInfo) < 0) {
        paramList.remove(i);
        break;
      } 
      return false;
    } 
    paramList.add(paramFieldInfo);
    return true;
  }
  
  public static JavaBeanInfo build(Class<?> paramClass, Type paramType, PropertyNamingStrategy paramPropertyNamingStrategy) {
    return build(paramClass, paramType, paramPropertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean);
  }
  
  public static JavaBeanInfo build(Class<?> paramClass, Type paramType, PropertyNamingStrategy paramPropertyNamingStrategy, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: ldc com/alibaba/fastjson/annotation/JSONType
    //   3: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   6: checkcast com/alibaba/fastjson/annotation/JSONType
    //   9: astore #5
    //   11: aload #5
    //   13: invokestatic getBuilderClass : (Lcom/alibaba/fastjson/annotation/JSONType;)Ljava/lang/Class;
    //   16: astore #6
    //   18: aload_0
    //   19: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   22: astore #7
    //   24: aload_0
    //   25: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   28: astore #8
    //   30: aload #6
    //   32: ifnonnull -> 41
    //   35: aload_0
    //   36: astore #9
    //   38: goto -> 45
    //   41: aload #6
    //   43: astore #9
    //   45: aload #9
    //   47: invokestatic getDefaultConstructor : (Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   50: astore #10
    //   52: aconst_null
    //   53: astore #11
    //   55: new java/util/ArrayList
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: astore #9
    //   64: iload_3
    //   65: ifeq -> 119
    //   68: aload_0
    //   69: astore #12
    //   71: aload #12
    //   73: ifnull -> 99
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: aload #9
    //   81: aload #12
    //   83: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   86: invokestatic computeFields : (Ljava/lang/Class;Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/PropertyNamingStrategy;Ljava/util/List;[Ljava/lang/reflect/Field;)V
    //   89: aload #12
    //   91: invokevirtual getSuperclass : ()Ljava/lang/Class;
    //   94: astore #12
    //   96: goto -> 71
    //   99: new com/alibaba/fastjson/util/JavaBeanInfo
    //   102: dup
    //   103: aload_0
    //   104: aload #6
    //   106: aload #10
    //   108: aconst_null
    //   109: aconst_null
    //   110: aconst_null
    //   111: aload #5
    //   113: aload #9
    //   115: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   118: areturn
    //   119: aload_0
    //   120: invokevirtual isInterface : ()Z
    //   123: ifne -> 145
    //   126: aload_0
    //   127: invokevirtual getModifiers : ()I
    //   130: invokestatic isAbstract : (I)Z
    //   133: ifeq -> 139
    //   136: goto -> 145
    //   139: iconst_0
    //   140: istore #13
    //   142: goto -> 148
    //   145: iconst_1
    //   146: istore #13
    //   148: aload #10
    //   150: ifnull -> 167
    //   153: iload #13
    //   155: ifeq -> 161
    //   158: goto -> 167
    //   161: aconst_null
    //   162: astore #14
    //   164: goto -> 678
    //   167: aload_0
    //   168: invokestatic getCreatorConstructor : (Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   171: astore #14
    //   173: aload #14
    //   175: ifnull -> 417
    //   178: iload #13
    //   180: ifne -> 417
    //   183: aload #14
    //   185: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   188: aload #14
    //   190: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   193: astore_2
    //   194: aload #9
    //   196: astore #12
    //   198: aload_2
    //   199: arraylength
    //   200: ifle -> 397
    //   203: aload #14
    //   205: invokevirtual getParameterAnnotations : ()[[Ljava/lang/annotation/Annotation;
    //   208: astore_1
    //   209: iconst_0
    //   210: istore #13
    //   212: aload #9
    //   214: astore #12
    //   216: iload #13
    //   218: aload_2
    //   219: arraylength
    //   220: if_icmpge -> 397
    //   223: aload_1
    //   224: iload #13
    //   226: aaload
    //   227: astore #12
    //   229: aload #12
    //   231: arraylength
    //   232: istore #15
    //   234: iconst_0
    //   235: istore #16
    //   237: iload #16
    //   239: iload #15
    //   241: if_icmpge -> 275
    //   244: aload #12
    //   246: iload #16
    //   248: aaload
    //   249: astore #8
    //   251: aload #8
    //   253: instanceof com/alibaba/fastjson/annotation/JSONField
    //   256: ifeq -> 269
    //   259: aload #8
    //   261: checkcast com/alibaba/fastjson/annotation/JSONField
    //   264: astore #12
    //   266: goto -> 278
    //   269: iinc #16, 1
    //   272: goto -> 237
    //   275: aconst_null
    //   276: astore #12
    //   278: aload #12
    //   280: ifnull -> 386
    //   283: aload_2
    //   284: iload #13
    //   286: aaload
    //   287: astore #17
    //   289: aload #14
    //   291: invokevirtual getGenericParameterTypes : ()[Ljava/lang/reflect/Type;
    //   294: iload #13
    //   296: aaload
    //   297: astore #18
    //   299: aload_0
    //   300: aload #12
    //   302: invokeinterface name : ()Ljava/lang/String;
    //   307: aload #7
    //   309: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   312: astore #8
    //   314: aload #12
    //   316: invokeinterface ordinal : ()I
    //   321: istore #15
    //   323: aload #12
    //   325: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   330: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   333: istore #19
    //   335: aload #12
    //   337: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   342: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   345: istore #16
    //   347: aload #9
    //   349: new com/alibaba/fastjson/util/FieldInfo
    //   352: dup
    //   353: aload #12
    //   355: invokeinterface name : ()Ljava/lang/String;
    //   360: aload_0
    //   361: aload #17
    //   363: aload #18
    //   365: aload #8
    //   367: iload #15
    //   369: iload #19
    //   371: iload #16
    //   373: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Field;III)V
    //   376: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   379: pop
    //   380: iinc #13, 1
    //   383: goto -> 212
    //   386: new com/alibaba/fastjson/JSONException
    //   389: dup
    //   390: ldc_w 'illegal json creator'
    //   393: invokespecial <init> : (Ljava/lang/String;)V
    //   396: athrow
    //   397: new com/alibaba/fastjson/util/JavaBeanInfo
    //   400: dup
    //   401: aload_0
    //   402: aload #6
    //   404: aconst_null
    //   405: aload #14
    //   407: aconst_null
    //   408: aconst_null
    //   409: aload #5
    //   411: aload #12
    //   413: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   416: areturn
    //   417: aload #9
    //   419: astore #17
    //   421: aload_0
    //   422: aload #8
    //   424: invokestatic getFactoryMethod : (Ljava/lang/Class;[Ljava/lang/reflect/Method;)Ljava/lang/reflect/Method;
    //   427: astore #12
    //   429: aload #12
    //   431: ifnull -> 669
    //   434: aload #12
    //   436: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   439: aload #12
    //   441: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   444: astore #18
    //   446: aload #12
    //   448: astore #14
    //   450: aload #18
    //   452: arraylength
    //   453: ifle -> 678
    //   456: aload #12
    //   458: invokevirtual getParameterAnnotations : ()[[Ljava/lang/annotation/Annotation;
    //   461: astore_1
    //   462: iconst_0
    //   463: istore #13
    //   465: aload #18
    //   467: astore_2
    //   468: iload #13
    //   470: aload_2
    //   471: arraylength
    //   472: if_icmpge -> 649
    //   475: aload_1
    //   476: iload #13
    //   478: aaload
    //   479: astore #14
    //   481: aload #14
    //   483: arraylength
    //   484: istore #15
    //   486: iconst_0
    //   487: istore #16
    //   489: iload #16
    //   491: iload #15
    //   493: if_icmpge -> 527
    //   496: aload #14
    //   498: iload #16
    //   500: aaload
    //   501: astore #9
    //   503: aload #9
    //   505: instanceof com/alibaba/fastjson/annotation/JSONField
    //   508: ifeq -> 521
    //   511: aload #9
    //   513: checkcast com/alibaba/fastjson/annotation/JSONField
    //   516: astore #9
    //   518: goto -> 530
    //   521: iinc #16, 1
    //   524: goto -> 489
    //   527: aconst_null
    //   528: astore #9
    //   530: aload #9
    //   532: ifnull -> 638
    //   535: aload_2
    //   536: iload #13
    //   538: aaload
    //   539: astore #14
    //   541: aload #12
    //   543: invokevirtual getGenericParameterTypes : ()[Ljava/lang/reflect/Type;
    //   546: iload #13
    //   548: aaload
    //   549: astore #8
    //   551: aload_0
    //   552: aload #9
    //   554: invokeinterface name : ()Ljava/lang/String;
    //   559: aload #7
    //   561: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   564: astore #18
    //   566: aload #9
    //   568: invokeinterface ordinal : ()I
    //   573: istore #19
    //   575: aload #9
    //   577: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   582: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   585: istore #15
    //   587: aload #9
    //   589: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   594: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   597: istore #16
    //   599: aload #17
    //   601: new com/alibaba/fastjson/util/FieldInfo
    //   604: dup
    //   605: aload #9
    //   607: invokeinterface name : ()Ljava/lang/String;
    //   612: aload_0
    //   613: aload #14
    //   615: aload #8
    //   617: aload #18
    //   619: iload #19
    //   621: iload #15
    //   623: iload #16
    //   625: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Field;III)V
    //   628: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   631: pop
    //   632: iinc #13, 1
    //   635: goto -> 468
    //   638: new com/alibaba/fastjson/JSONException
    //   641: dup
    //   642: ldc_w 'illegal json creator'
    //   645: invokespecial <init> : (Ljava/lang/String;)V
    //   648: athrow
    //   649: new com/alibaba/fastjson/util/JavaBeanInfo
    //   652: dup
    //   653: aload_0
    //   654: aload #6
    //   656: aconst_null
    //   657: aconst_null
    //   658: aload #12
    //   660: aconst_null
    //   661: aload #5
    //   663: aload #17
    //   665: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   668: areturn
    //   669: iload #13
    //   671: ifeq -> 2545
    //   674: aload #12
    //   676: astore #14
    //   678: aload #9
    //   680: astore #20
    //   682: aload #10
    //   684: ifnull -> 692
    //   687: aload #10
    //   689: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   692: aload #6
    //   694: ifnull -> 1308
    //   697: aload #6
    //   699: ldc_w com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   702: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   705: checkcast com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   708: astore #9
    //   710: aload #9
    //   712: ifnull -> 727
    //   715: aload #9
    //   717: invokeinterface withPrefix : ()Ljava/lang/String;
    //   722: astore #12
    //   724: goto -> 730
    //   727: aconst_null
    //   728: astore #12
    //   730: aload #12
    //   732: ifnull -> 753
    //   735: aload #12
    //   737: astore #9
    //   739: aload #12
    //   741: invokevirtual length : ()I
    //   744: ifne -> 750
    //   747: goto -> 753
    //   750: goto -> 761
    //   753: ldc_w 'with'
    //   756: astore #9
    //   758: goto -> 750
    //   761: aload #6
    //   763: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   766: astore #17
    //   768: aload #17
    //   770: arraylength
    //   771: istore #13
    //   773: iconst_0
    //   774: istore #16
    //   776: aload #5
    //   778: astore #12
    //   780: aload #6
    //   782: astore #5
    //   784: aload #7
    //   786: astore #6
    //   788: aload #8
    //   790: astore #7
    //   792: aload #17
    //   794: astore #8
    //   796: iload #16
    //   798: iload #13
    //   800: if_icmpge -> 1115
    //   803: aload #8
    //   805: iload #16
    //   807: aaload
    //   808: astore #21
    //   810: aload #21
    //   812: invokevirtual getModifiers : ()I
    //   815: invokestatic isStatic : (I)Z
    //   818: ifeq -> 824
    //   821: goto -> 1109
    //   824: aload #21
    //   826: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   829: aload #5
    //   831: invokevirtual equals : (Ljava/lang/Object;)Z
    //   834: ifne -> 840
    //   837: goto -> 821
    //   840: aload #21
    //   842: ldc com/alibaba/fastjson/annotation/JSONField
    //   844: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   847: checkcast com/alibaba/fastjson/annotation/JSONField
    //   850: astore #18
    //   852: aload #18
    //   854: astore #17
    //   856: aload #18
    //   858: ifnonnull -> 869
    //   861: aload_0
    //   862: aload #21
    //   864: invokestatic getSuperMethodAnnotation : (Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   867: astore #17
    //   869: aload #17
    //   871: ifnull -> 974
    //   874: aload #17
    //   876: invokeinterface deserialize : ()Z
    //   881: ifne -> 887
    //   884: goto -> 821
    //   887: aload #17
    //   889: invokeinterface ordinal : ()I
    //   894: istore #19
    //   896: aload #17
    //   898: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   903: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   906: istore #22
    //   908: aload #17
    //   910: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   915: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   918: istore #15
    //   920: aload #17
    //   922: invokeinterface name : ()Ljava/lang/String;
    //   927: invokevirtual length : ()I
    //   930: ifeq -> 971
    //   933: aload #20
    //   935: new com/alibaba/fastjson/util/FieldInfo
    //   938: dup
    //   939: aload #17
    //   941: invokeinterface name : ()Ljava/lang/String;
    //   946: aload #21
    //   948: aconst_null
    //   949: aload_0
    //   950: aload_1
    //   951: iload #19
    //   953: iload #22
    //   955: iload #15
    //   957: aload #17
    //   959: aconst_null
    //   960: aconst_null
    //   961: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   964: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   967: pop
    //   968: goto -> 1109
    //   971: goto -> 983
    //   974: iconst_0
    //   975: istore #19
    //   977: iconst_0
    //   978: istore #22
    //   980: iconst_0
    //   981: istore #15
    //   983: aload #21
    //   985: invokevirtual getName : ()Ljava/lang/String;
    //   988: astore #18
    //   990: aload #18
    //   992: aload #9
    //   994: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   997: ifne -> 1003
    //   1000: goto -> 1109
    //   1003: aload #18
    //   1005: invokevirtual length : ()I
    //   1008: aload #9
    //   1010: invokevirtual length : ()I
    //   1013: if_icmpgt -> 1019
    //   1016: goto -> 1000
    //   1019: aload #18
    //   1021: aload #9
    //   1023: invokevirtual length : ()I
    //   1026: invokevirtual charAt : (I)C
    //   1029: istore #23
    //   1031: iload #23
    //   1033: invokestatic isUpperCase : (C)Z
    //   1036: ifne -> 1042
    //   1039: goto -> 1000
    //   1042: new java/lang/StringBuilder
    //   1045: dup
    //   1046: aload #18
    //   1048: aload #9
    //   1050: invokevirtual length : ()I
    //   1053: invokevirtual substring : (I)Ljava/lang/String;
    //   1056: invokespecial <init> : (Ljava/lang/String;)V
    //   1059: astore #18
    //   1061: aload #18
    //   1063: iconst_0
    //   1064: iload #23
    //   1066: invokestatic toLowerCase : (C)C
    //   1069: invokevirtual setCharAt : (IC)V
    //   1072: aload #18
    //   1074: invokevirtual toString : ()Ljava/lang/String;
    //   1077: astore #18
    //   1079: aload #20
    //   1081: new com/alibaba/fastjson/util/FieldInfo
    //   1084: dup
    //   1085: aload #18
    //   1087: aload #21
    //   1089: aconst_null
    //   1090: aload_0
    //   1091: aload_1
    //   1092: iload #19
    //   1094: iload #22
    //   1096: iload #15
    //   1098: aload #17
    //   1100: aconst_null
    //   1101: aconst_null
    //   1102: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1105: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1108: pop
    //   1109: iinc #16, 1
    //   1112: goto -> 796
    //   1115: aload #7
    //   1117: astore #8
    //   1119: aload #6
    //   1121: astore #17
    //   1123: aload #12
    //   1125: astore #18
    //   1127: aload #5
    //   1129: astore #21
    //   1131: aload #21
    //   1133: astore #9
    //   1135: aload #11
    //   1137: astore #7
    //   1139: aload #8
    //   1141: astore #12
    //   1143: aload #17
    //   1145: astore #6
    //   1147: aload #18
    //   1149: astore #5
    //   1151: aload #21
    //   1153: ifnull -> 1324
    //   1156: aload #21
    //   1158: ldc_w com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   1161: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1164: checkcast com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   1167: astore #9
    //   1169: aload #9
    //   1171: ifnull -> 1186
    //   1174: aload #9
    //   1176: invokeinterface buildMethod : ()Ljava/lang/String;
    //   1181: astore #9
    //   1183: goto -> 1189
    //   1186: aconst_null
    //   1187: astore #9
    //   1189: aload #9
    //   1191: ifnull -> 1212
    //   1194: aload #9
    //   1196: astore #6
    //   1198: aload #9
    //   1200: invokevirtual length : ()I
    //   1203: ifne -> 1209
    //   1206: goto -> 1212
    //   1209: goto -> 1220
    //   1212: ldc_w 'build'
    //   1215: astore #6
    //   1217: goto -> 1209
    //   1220: aload #21
    //   1222: aload #6
    //   1224: iconst_0
    //   1225: anewarray java/lang/Class
    //   1228: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1231: astore #9
    //   1233: goto -> 1241
    //   1236: astore #9
    //   1238: aconst_null
    //   1239: astore #9
    //   1241: aload #9
    //   1243: astore #6
    //   1245: aload #9
    //   1247: ifnonnull -> 1264
    //   1250: aload #21
    //   1252: ldc_w 'create'
    //   1255: iconst_0
    //   1256: anewarray java/lang/Class
    //   1259: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1262: astore #6
    //   1264: aload #6
    //   1266: ifnull -> 1297
    //   1269: aload #6
    //   1271: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   1274: aload #21
    //   1276: astore #9
    //   1278: aload #6
    //   1280: astore #7
    //   1282: aload #8
    //   1284: astore #12
    //   1286: aload #17
    //   1288: astore #6
    //   1290: aload #18
    //   1292: astore #5
    //   1294: goto -> 1324
    //   1297: new com/alibaba/fastjson/JSONException
    //   1300: dup
    //   1301: ldc_w 'buildMethod not found.'
    //   1304: invokespecial <init> : (Ljava/lang/String;)V
    //   1307: athrow
    //   1308: aload #8
    //   1310: astore #12
    //   1312: aload #6
    //   1314: astore #9
    //   1316: aload #7
    //   1318: astore #6
    //   1320: aload #11
    //   1322: astore #7
    //   1324: aload #12
    //   1326: astore #8
    //   1328: aload #8
    //   1330: arraylength
    //   1331: istore #19
    //   1333: iconst_0
    //   1334: istore #22
    //   1336: aload #9
    //   1338: astore #12
    //   1340: iload #22
    //   1342: iload #19
    //   1344: if_icmpge -> 2128
    //   1347: aload #8
    //   1349: iload #22
    //   1351: aaload
    //   1352: astore #24
    //   1354: iconst_0
    //   1355: istore #13
    //   1357: iconst_0
    //   1358: istore #15
    //   1360: iconst_0
    //   1361: istore #16
    //   1363: aload #24
    //   1365: invokevirtual getName : ()Ljava/lang/String;
    //   1368: astore #9
    //   1370: aload #24
    //   1372: invokevirtual getModifiers : ()I
    //   1375: invokestatic isStatic : (I)Z
    //   1378: ifeq -> 1384
    //   1381: goto -> 2122
    //   1384: aload #24
    //   1386: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   1389: astore #17
    //   1391: aload #17
    //   1393: getstatic java/lang/Void.TYPE : Ljava/lang/Class;
    //   1396: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1399: ifne -> 1418
    //   1402: aload #17
    //   1404: aload #24
    //   1406: invokevirtual getDeclaringClass : ()Ljava/lang/Class;
    //   1409: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1412: ifne -> 1418
    //   1415: goto -> 1381
    //   1418: aload #24
    //   1420: invokevirtual getDeclaringClass : ()Ljava/lang/Class;
    //   1423: ldc java/lang/Object
    //   1425: if_acmpne -> 1431
    //   1428: goto -> 1381
    //   1431: aload #24
    //   1433: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   1436: astore #21
    //   1438: aload #21
    //   1440: arraylength
    //   1441: ifeq -> 1381
    //   1444: aload #21
    //   1446: arraylength
    //   1447: iconst_2
    //   1448: if_icmple -> 1454
    //   1451: goto -> 1381
    //   1454: aload #24
    //   1456: ldc com/alibaba/fastjson/annotation/JSONField
    //   1458: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1461: checkcast com/alibaba/fastjson/annotation/JSONField
    //   1464: astore #17
    //   1466: aload #17
    //   1468: ifnull -> 1527
    //   1471: aload #21
    //   1473: arraylength
    //   1474: iconst_2
    //   1475: if_icmpne -> 1527
    //   1478: aload #21
    //   1480: iconst_0
    //   1481: aaload
    //   1482: ldc java/lang/String
    //   1484: if_acmpne -> 1527
    //   1487: aload #21
    //   1489: iconst_1
    //   1490: aaload
    //   1491: ldc java/lang/Object
    //   1493: if_acmpne -> 1527
    //   1496: aload #20
    //   1498: new com/alibaba/fastjson/util/FieldInfo
    //   1501: dup
    //   1502: ldc_w ''
    //   1505: aload #24
    //   1507: aconst_null
    //   1508: aload_0
    //   1509: aload_1
    //   1510: iconst_0
    //   1511: iconst_0
    //   1512: iconst_0
    //   1513: aload #17
    //   1515: aconst_null
    //   1516: aconst_null
    //   1517: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1520: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1523: pop
    //   1524: goto -> 1381
    //   1527: aload #21
    //   1529: arraylength
    //   1530: iconst_1
    //   1531: if_icmpeq -> 1537
    //   1534: goto -> 1381
    //   1537: aload #17
    //   1539: ifnonnull -> 1553
    //   1542: aload_0
    //   1543: aload #24
    //   1545: invokestatic getSuperMethodAnnotation : (Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   1548: astore #17
    //   1550: goto -> 1553
    //   1553: aload #17
    //   1555: ifnonnull -> 1570
    //   1558: aload #9
    //   1560: invokevirtual length : ()I
    //   1563: iconst_4
    //   1564: if_icmpge -> 1570
    //   1567: goto -> 1534
    //   1570: aload #17
    //   1572: ifnull -> 1675
    //   1575: aload #17
    //   1577: invokeinterface deserialize : ()Z
    //   1582: ifne -> 1588
    //   1585: goto -> 1534
    //   1588: aload #17
    //   1590: invokeinterface ordinal : ()I
    //   1595: istore #13
    //   1597: aload #17
    //   1599: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1604: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1607: istore #15
    //   1609: aload #17
    //   1611: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   1616: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   1619: istore #16
    //   1621: aload #17
    //   1623: invokeinterface name : ()Ljava/lang/String;
    //   1628: invokevirtual length : ()I
    //   1631: ifeq -> 1672
    //   1634: aload #20
    //   1636: new com/alibaba/fastjson/util/FieldInfo
    //   1639: dup
    //   1640: aload #17
    //   1642: invokeinterface name : ()Ljava/lang/String;
    //   1647: aload #24
    //   1649: aconst_null
    //   1650: aload_0
    //   1651: aload_1
    //   1652: iload #13
    //   1654: iload #15
    //   1656: iload #16
    //   1658: aload #17
    //   1660: aconst_null
    //   1661: aconst_null
    //   1662: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1665: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1668: pop
    //   1669: goto -> 1381
    //   1672: goto -> 1675
    //   1675: aload #17
    //   1677: ifnonnull -> 1694
    //   1680: aload #9
    //   1682: ldc_w 'set'
    //   1685: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   1688: ifne -> 1694
    //   1691: goto -> 1381
    //   1694: aload #9
    //   1696: iconst_3
    //   1697: invokevirtual charAt : (I)C
    //   1700: istore #23
    //   1702: iload #23
    //   1704: invokestatic isUpperCase : (C)Z
    //   1707: ifne -> 1792
    //   1710: iload #23
    //   1712: sipush #512
    //   1715: if_icmple -> 1721
    //   1718: goto -> 1792
    //   1721: iload #23
    //   1723: bipush #95
    //   1725: if_icmpne -> 1739
    //   1728: aload #9
    //   1730: iconst_4
    //   1731: invokevirtual substring : (I)Ljava/lang/String;
    //   1734: astore #9
    //   1736: goto -> 1809
    //   1739: iload #23
    //   1741: bipush #102
    //   1743: if_icmpne -> 1757
    //   1746: aload #9
    //   1748: iconst_3
    //   1749: invokevirtual substring : (I)Ljava/lang/String;
    //   1752: astore #9
    //   1754: goto -> 1809
    //   1757: aload #9
    //   1759: invokevirtual length : ()I
    //   1762: iconst_5
    //   1763: if_icmplt -> 1381
    //   1766: aload #9
    //   1768: iconst_4
    //   1769: invokevirtual charAt : (I)C
    //   1772: invokestatic isUpperCase : (C)Z
    //   1775: ifeq -> 1381
    //   1778: aload #9
    //   1780: iconst_3
    //   1781: invokevirtual substring : (I)Ljava/lang/String;
    //   1784: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   1787: astore #9
    //   1789: goto -> 1809
    //   1792: getstatic com/alibaba/fastjson/util/TypeUtils.compatibleWithJavaBean : Z
    //   1795: ifeq -> 1812
    //   1798: aload #9
    //   1800: iconst_3
    //   1801: invokevirtual substring : (I)Ljava/lang/String;
    //   1804: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   1807: astore #9
    //   1809: goto -> 1858
    //   1812: new java/lang/StringBuilder
    //   1815: dup
    //   1816: invokespecial <init> : ()V
    //   1819: astore #18
    //   1821: aload #18
    //   1823: aload #9
    //   1825: iconst_3
    //   1826: invokevirtual charAt : (I)C
    //   1829: invokestatic toLowerCase : (C)C
    //   1832: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1835: pop
    //   1836: aload #18
    //   1838: aload #9
    //   1840: iconst_4
    //   1841: invokevirtual substring : (I)Ljava/lang/String;
    //   1844: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: pop
    //   1848: aload #18
    //   1850: invokevirtual toString : ()Ljava/lang/String;
    //   1853: astore #9
    //   1855: goto -> 1809
    //   1858: aload_0
    //   1859: aload #9
    //   1861: aload #6
    //   1863: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   1866: astore #18
    //   1868: aload #18
    //   1870: ifnonnull -> 1944
    //   1873: aload #21
    //   1875: iconst_0
    //   1876: aaload
    //   1877: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1880: if_acmpne -> 1944
    //   1883: new java/lang/StringBuilder
    //   1886: dup
    //   1887: invokespecial <init> : ()V
    //   1890: astore #18
    //   1892: aload #18
    //   1894: ldc_w 'is'
    //   1897: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: pop
    //   1901: aload #18
    //   1903: aload #9
    //   1905: iconst_0
    //   1906: invokevirtual charAt : (I)C
    //   1909: invokestatic toUpperCase : (C)C
    //   1912: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1915: pop
    //   1916: aload #18
    //   1918: aload #9
    //   1920: iconst_1
    //   1921: invokevirtual substring : (I)Ljava/lang/String;
    //   1924: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1927: pop
    //   1928: aload_0
    //   1929: aload #18
    //   1931: invokevirtual toString : ()Ljava/lang/String;
    //   1934: aload #6
    //   1936: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   1939: astore #18
    //   1941: goto -> 1944
    //   1944: aload #18
    //   1946: ifnull -> 2071
    //   1949: aload #18
    //   1951: ldc com/alibaba/fastjson/annotation/JSONField
    //   1953: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1956: checkcast com/alibaba/fastjson/annotation/JSONField
    //   1959: astore #21
    //   1961: aload #21
    //   1963: ifnull -> 2068
    //   1966: aload #21
    //   1968: invokeinterface deserialize : ()Z
    //   1973: ifne -> 1979
    //   1976: goto -> 1381
    //   1979: aload #21
    //   1981: invokeinterface ordinal : ()I
    //   1986: istore #13
    //   1988: aload #21
    //   1990: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1995: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1998: istore #15
    //   2000: aload #21
    //   2002: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   2007: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   2010: istore #16
    //   2012: aload #21
    //   2014: invokeinterface name : ()Ljava/lang/String;
    //   2019: invokevirtual length : ()I
    //   2022: ifeq -> 2065
    //   2025: aload #20
    //   2027: new com/alibaba/fastjson/util/FieldInfo
    //   2030: dup
    //   2031: aload #21
    //   2033: invokeinterface name : ()Ljava/lang/String;
    //   2038: aload #24
    //   2040: aload #18
    //   2042: aload_0
    //   2043: aload_1
    //   2044: iload #13
    //   2046: iload #15
    //   2048: iload #16
    //   2050: aload #17
    //   2052: aload #21
    //   2054: aconst_null
    //   2055: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   2058: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   2061: pop
    //   2062: goto -> 2122
    //   2065: goto -> 2068
    //   2068: goto -> 2074
    //   2071: aconst_null
    //   2072: astore #21
    //   2074: aload #9
    //   2076: astore #11
    //   2078: aload_2
    //   2079: ifnull -> 2090
    //   2082: aload_2
    //   2083: aload #9
    //   2085: invokevirtual translate : (Ljava/lang/String;)Ljava/lang/String;
    //   2088: astore #11
    //   2090: aload #20
    //   2092: new com/alibaba/fastjson/util/FieldInfo
    //   2095: dup
    //   2096: aload #11
    //   2098: aload #24
    //   2100: aload #18
    //   2102: aload_0
    //   2103: aload_1
    //   2104: iload #13
    //   2106: iload #15
    //   2108: iload #16
    //   2110: aload #17
    //   2112: aload #21
    //   2114: aconst_null
    //   2115: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   2118: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   2121: pop
    //   2122: iinc #22, 1
    //   2125: goto -> 1340
    //   2128: aload #6
    //   2130: astore #9
    //   2132: aload_0
    //   2133: aload_1
    //   2134: aload_2
    //   2135: aload #20
    //   2137: aload_0
    //   2138: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   2141: invokestatic computeFields : (Ljava/lang/Class;Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/PropertyNamingStrategy;Ljava/util/List;[Ljava/lang/reflect/Field;)V
    //   2144: aload_0
    //   2145: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   2148: astore #8
    //   2150: aload #8
    //   2152: arraylength
    //   2153: istore #13
    //   2155: iconst_0
    //   2156: istore #16
    //   2158: iload #16
    //   2160: iload #13
    //   2162: if_icmpge -> 2523
    //   2165: aload #8
    //   2167: iload #16
    //   2169: aaload
    //   2170: astore #18
    //   2172: aload #18
    //   2174: invokevirtual getName : ()Ljava/lang/String;
    //   2177: astore #17
    //   2179: aload #17
    //   2181: invokevirtual length : ()I
    //   2184: iconst_4
    //   2185: if_icmpge -> 2191
    //   2188: goto -> 2517
    //   2191: aload #18
    //   2193: invokevirtual getModifiers : ()I
    //   2196: invokestatic isStatic : (I)Z
    //   2199: ifeq -> 2205
    //   2202: goto -> 2188
    //   2205: aload #17
    //   2207: ldc_w 'get'
    //   2210: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   2213: ifeq -> 2188
    //   2216: aload #17
    //   2218: iconst_3
    //   2219: invokevirtual charAt : (I)C
    //   2222: invokestatic isUpperCase : (C)Z
    //   2225: ifeq -> 2188
    //   2228: aload #18
    //   2230: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   2233: arraylength
    //   2234: ifeq -> 2240
    //   2237: goto -> 2188
    //   2240: ldc_w java/util/Collection
    //   2243: aload #18
    //   2245: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2248: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   2251: ifne -> 2301
    //   2254: ldc_w java/util/Map
    //   2257: aload #18
    //   2259: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2262: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   2265: ifne -> 2301
    //   2268: ldc_w java/util/concurrent/atomic/AtomicBoolean
    //   2271: aload #18
    //   2273: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2276: if_acmpeq -> 2301
    //   2279: ldc_w java/util/concurrent/atomic/AtomicInteger
    //   2282: aload #18
    //   2284: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2287: if_acmpeq -> 2301
    //   2290: ldc_w java/util/concurrent/atomic/AtomicLong
    //   2293: aload #18
    //   2295: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2298: if_acmpne -> 2188
    //   2301: aload #18
    //   2303: ldc com/alibaba/fastjson/annotation/JSONField
    //   2305: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   2308: checkcast com/alibaba/fastjson/annotation/JSONField
    //   2311: astore #21
    //   2313: aload #21
    //   2315: ifnull -> 2331
    //   2318: aload #21
    //   2320: invokeinterface deserialize : ()Z
    //   2325: ifeq -> 2331
    //   2328: goto -> 2188
    //   2331: aload #21
    //   2333: ifnull -> 2361
    //   2336: aload #21
    //   2338: invokeinterface name : ()Ljava/lang/String;
    //   2343: invokevirtual length : ()I
    //   2346: ifle -> 2361
    //   2349: aload #21
    //   2351: invokeinterface name : ()Ljava/lang/String;
    //   2356: astore #6
    //   2358: goto -> 2461
    //   2361: new java/lang/StringBuilder
    //   2364: dup
    //   2365: invokespecial <init> : ()V
    //   2368: astore #6
    //   2370: aload #6
    //   2372: aload #17
    //   2374: iconst_3
    //   2375: invokevirtual charAt : (I)C
    //   2378: invokestatic toLowerCase : (C)C
    //   2381: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   2384: pop
    //   2385: aload #6
    //   2387: aload #17
    //   2389: iconst_4
    //   2390: invokevirtual substring : (I)Ljava/lang/String;
    //   2393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: pop
    //   2397: aload #6
    //   2399: invokevirtual toString : ()Ljava/lang/String;
    //   2402: astore #17
    //   2404: aload_0
    //   2405: aload #17
    //   2407: aload #9
    //   2409: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   2412: astore #11
    //   2414: aload #17
    //   2416: astore #6
    //   2418: aload #11
    //   2420: ifnull -> 2461
    //   2423: aload #11
    //   2425: ldc com/alibaba/fastjson/annotation/JSONField
    //   2427: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   2430: checkcast com/alibaba/fastjson/annotation/JSONField
    //   2433: astore #11
    //   2435: aload #17
    //   2437: astore #6
    //   2439: aload #11
    //   2441: ifnull -> 2461
    //   2444: aload #17
    //   2446: astore #6
    //   2448: aload #11
    //   2450: invokeinterface deserialize : ()Z
    //   2455: ifne -> 2461
    //   2458: goto -> 2471
    //   2461: aload #20
    //   2463: aload #6
    //   2465: invokestatic getField : (Ljava/util/List;Ljava/lang/String;)Lcom/alibaba/fastjson/util/FieldInfo;
    //   2468: ifnull -> 2474
    //   2471: goto -> 2188
    //   2474: aload #6
    //   2476: astore #17
    //   2478: aload_2
    //   2479: ifnull -> 2490
    //   2482: aload_2
    //   2483: aload #6
    //   2485: invokevirtual translate : (Ljava/lang/String;)Ljava/lang/String;
    //   2488: astore #17
    //   2490: aload #20
    //   2492: new com/alibaba/fastjson/util/FieldInfo
    //   2495: dup
    //   2496: aload #17
    //   2498: aload #18
    //   2500: aconst_null
    //   2501: aload_0
    //   2502: aload_1
    //   2503: iconst_0
    //   2504: iconst_0
    //   2505: iconst_0
    //   2506: aload #21
    //   2508: aconst_null
    //   2509: aconst_null
    //   2510: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   2513: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   2516: pop
    //   2517: iinc #16, 1
    //   2520: goto -> 2158
    //   2523: new com/alibaba/fastjson/util/JavaBeanInfo
    //   2526: dup
    //   2527: aload_0
    //   2528: aload #12
    //   2530: aload #10
    //   2532: aconst_null
    //   2533: aload #14
    //   2535: aload #7
    //   2537: aload #5
    //   2539: aload #20
    //   2541: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   2544: areturn
    //   2545: new java/lang/StringBuilder
    //   2548: dup
    //   2549: invokespecial <init> : ()V
    //   2552: astore_1
    //   2553: aload_1
    //   2554: ldc_w 'default constructor not found. '
    //   2557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2560: pop
    //   2561: aload_1
    //   2562: aload_0
    //   2563: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2566: pop
    //   2567: new com/alibaba/fastjson/JSONException
    //   2570: dup
    //   2571: aload_1
    //   2572: invokevirtual toString : ()Ljava/lang/String;
    //   2575: invokespecial <init> : (Ljava/lang/String;)V
    //   2578: athrow
    //   2579: astore #6
    //   2581: aload #9
    //   2583: astore #6
    //   2585: goto -> 1264
    // Exception table:
    //   from	to	target	type
    //   1220	1233	1236	java/lang/NoSuchMethodException
    //   1220	1233	1236	java/lang/SecurityException
    //   1250	1264	2579	java/lang/NoSuchMethodException
    //   1250	1264	2579	java/lang/SecurityException
  }
  
  private static void computeFields(Class<?> paramClass, Type paramType, PropertyNamingStrategy paramPropertyNamingStrategy, List<FieldInfo> paramList, Field[] paramArrayOfField) {
    // Byte code:
    //   0: aload #4
    //   2: arraylength
    //   3: istore #5
    //   5: iconst_0
    //   6: istore #6
    //   8: iload #6
    //   10: iload #5
    //   12: if_icmpge -> 348
    //   15: aload #4
    //   17: iload #6
    //   19: aaload
    //   20: astore #7
    //   22: aload #7
    //   24: invokevirtual getModifiers : ()I
    //   27: istore #8
    //   29: iload #8
    //   31: bipush #8
    //   33: iand
    //   34: ifeq -> 40
    //   37: goto -> 342
    //   40: iconst_1
    //   41: istore #9
    //   43: iload #8
    //   45: bipush #16
    //   47: iand
    //   48: ifeq -> 133
    //   51: aload #7
    //   53: invokevirtual getType : ()Ljava/lang/Class;
    //   56: astore #10
    //   58: ldc_w java/util/Map
    //   61: aload #10
    //   63: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   66: ifne -> 122
    //   69: ldc_w java/util/Collection
    //   72: aload #10
    //   74: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   77: ifne -> 122
    //   80: ldc_w java/util/concurrent/atomic/AtomicLong
    //   83: aload #10
    //   85: invokevirtual equals : (Ljava/lang/Object;)Z
    //   88: ifne -> 122
    //   91: ldc_w java/util/concurrent/atomic/AtomicInteger
    //   94: aload #10
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifne -> 122
    //   102: ldc_w java/util/concurrent/atomic/AtomicBoolean
    //   105: aload #10
    //   107: invokevirtual equals : (Ljava/lang/Object;)Z
    //   110: ifeq -> 116
    //   113: goto -> 122
    //   116: iconst_0
    //   117: istore #8
    //   119: goto -> 125
    //   122: iconst_1
    //   123: istore #8
    //   125: iload #8
    //   127: ifne -> 133
    //   130: goto -> 37
    //   133: aload_3
    //   134: invokeinterface iterator : ()Ljava/util/Iterator;
    //   139: astore #10
    //   141: aload #10
    //   143: invokeinterface hasNext : ()Z
    //   148: ifeq -> 182
    //   151: aload #10
    //   153: invokeinterface next : ()Ljava/lang/Object;
    //   158: checkcast com/alibaba/fastjson/util/FieldInfo
    //   161: getfield name : Ljava/lang/String;
    //   164: aload #7
    //   166: invokevirtual getName : ()Ljava/lang/String;
    //   169: invokevirtual equals : (Ljava/lang/Object;)Z
    //   172: ifeq -> 141
    //   175: iload #9
    //   177: istore #8
    //   179: goto -> 185
    //   182: iconst_0
    //   183: istore #8
    //   185: iload #8
    //   187: ifeq -> 193
    //   190: goto -> 37
    //   193: aload #7
    //   195: invokevirtual getName : ()Ljava/lang/String;
    //   198: astore #10
    //   200: aload #7
    //   202: ldc com/alibaba/fastjson/annotation/JSONField
    //   204: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   207: checkcast com/alibaba/fastjson/annotation/JSONField
    //   210: astore #11
    //   212: aload #11
    //   214: ifnull -> 288
    //   217: aload #11
    //   219: invokeinterface deserialize : ()Z
    //   224: ifne -> 230
    //   227: goto -> 37
    //   230: aload #11
    //   232: invokeinterface ordinal : ()I
    //   237: istore #12
    //   239: aload #11
    //   241: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   246: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   249: istore #8
    //   251: aload #11
    //   253: invokeinterface parseFeatures : ()[Lcom/alibaba/fastjson/parser/Feature;
    //   258: invokestatic of : ([Lcom/alibaba/fastjson/parser/Feature;)I
    //   261: istore #9
    //   263: aload #11
    //   265: invokeinterface name : ()Ljava/lang/String;
    //   270: invokevirtual length : ()I
    //   273: ifeq -> 285
    //   276: aload #11
    //   278: invokeinterface name : ()Ljava/lang/String;
    //   283: astore #10
    //   285: goto -> 297
    //   288: iconst_0
    //   289: istore #12
    //   291: iconst_0
    //   292: istore #8
    //   294: iconst_0
    //   295: istore #9
    //   297: aload #10
    //   299: astore #13
    //   301: aload_2
    //   302: ifnull -> 313
    //   305: aload_2
    //   306: aload #10
    //   308: invokevirtual translate : (Ljava/lang/String;)Ljava/lang/String;
    //   311: astore #13
    //   313: aload_3
    //   314: new com/alibaba/fastjson/util/FieldInfo
    //   317: dup
    //   318: aload #13
    //   320: aconst_null
    //   321: aload #7
    //   323: aload_0
    //   324: aload_1
    //   325: iload #12
    //   327: iload #8
    //   329: iload #9
    //   331: aconst_null
    //   332: aload #11
    //   334: aconst_null
    //   335: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   338: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   341: pop
    //   342: iinc #6, 1
    //   345: goto -> 8
    //   348: return
  }
  
  public static Class<?> getBuilderClass(JSONType paramJSONType) {
    if (paramJSONType == null)
      return null; 
    Class<Void> clazz = paramJSONType.builder();
    return (clazz == Void.class) ? null : clazz;
  }
  
  public static Constructor<?> getCreatorConstructor(Class<?> paramClass) {
    Constructor<JSONCreator> constructor;
    Constructor[] arrayOfConstructor = (Constructor[])paramClass.getDeclaredConstructors();
    int i = arrayOfConstructor.length;
    Class clazz = null;
    byte b = 0;
    while (b < i) {
      Constructor<JSONCreator> constructor1;
      Constructor<JSONCreator> constructor2 = arrayOfConstructor[b];
      paramClass = clazz;
      if ((JSONCreator)constructor2.<JSONCreator>getAnnotation(JSONCreator.class) != null)
        if (clazz == null) {
          constructor1 = constructor2;
        } else {
          throw new JSONException("multi-JSONCreator");
        }  
      b++;
      constructor = constructor1;
    } 
    return constructor;
  }
  
  static Constructor<?> getDefaultConstructor(Class<?> paramClass) {
    Constructor<?> constructor2;
    boolean bool = Modifier.isAbstract(paramClass.getModifiers());
    Constructor<?> constructor1 = null;
    if (bool)
      return null; 
    Constructor[] arrayOfConstructor = (Constructor[])paramClass.getDeclaredConstructors();
    int i = arrayOfConstructor.length;
    byte b = 0;
    while (true) {
      constructor2 = constructor1;
      if (b < i) {
        constructor2 = arrayOfConstructor[b];
        if ((constructor2.getParameterTypes()).length == 0)
          break; 
        b++;
        continue;
      } 
      break;
    } 
    constructor1 = constructor2;
    if (constructor2 == null) {
      constructor1 = constructor2;
      if (paramClass.isMemberClass()) {
        constructor1 = constructor2;
        if (!Modifier.isStatic(paramClass.getModifiers())) {
          i = arrayOfConstructor.length;
          b = 0;
          while (true) {
            constructor1 = constructor2;
            if (b < i) {
              constructor1 = arrayOfConstructor[b];
              Class[] arrayOfClass = constructor1.getParameterTypes();
              if (arrayOfClass.length == 1 && arrayOfClass[0].equals(paramClass.getDeclaringClass()))
                break; 
              b++;
              continue;
            } 
            break;
          } 
        } 
      } 
    } 
    return constructor1;
  }
  
  private static Method getFactoryMethod(Class<?> paramClass, Method[] paramArrayOfMethod) {
    int i = paramArrayOfMethod.length;
    Method method = null;
    byte b = 0;
    while (b < i) {
      Method method2;
      Method method1 = paramArrayOfMethod[b];
      if (!Modifier.isStatic(method1.getModifiers())) {
        method2 = method;
      } else if (!paramClass.isAssignableFrom(method1.getReturnType())) {
        method2 = method;
      } else {
        method2 = method;
        if ((JSONCreator)method1.<JSONCreator>getAnnotation(JSONCreator.class) != null)
          if (method == null) {
            method2 = method1;
          } else {
            throw new JSONException("multi-JSONCreator");
          }  
      } 
      b++;
      method = method2;
    } 
    return method;
  }
  
  private static FieldInfo getField(List<FieldInfo> paramList, String paramString) {
    for (FieldInfo fieldInfo : paramList) {
      if (fieldInfo.name.equals(paramString))
        return fieldInfo; 
      Field field = fieldInfo.field;
      if (field != null && fieldInfo.getAnnotation() != null && field.getName().equals(paramString))
        return fieldInfo; 
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\JavaBeanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */