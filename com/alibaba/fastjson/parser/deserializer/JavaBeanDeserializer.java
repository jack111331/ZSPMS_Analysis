package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer implements ObjectDeserializer {
  private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
  
  public final JavaBeanInfo beanInfo;
  
  protected final Class<?> clazz;
  
  private ConcurrentMap<String, Object> extraFieldDeserializers;
  
  private final FieldDeserializer[] fieldDeserializers;
  
  protected final FieldDeserializer[] sortedFieldDeserializers;
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo) {
    HashMap<Object, Object> hashMap;
    this.clazz = paramJavaBeanInfo.clazz;
    this.beanInfo = paramJavaBeanInfo;
    this.sortedFieldDeserializers = new FieldDeserializer[paramJavaBeanInfo.sortedFields.length];
    int i = paramJavaBeanInfo.sortedFields.length;
    boolean bool = false;
    FieldInfo fieldInfo = null;
    byte b;
    for (b = 0; b < i; b++) {
      FieldInfo fieldInfo1 = paramJavaBeanInfo.sortedFields[b];
      FieldDeserializer fieldDeserializer = paramParserConfig.createFieldDeserializer(paramParserConfig, paramJavaBeanInfo, fieldInfo1);
      this.sortedFieldDeserializers[b] = fieldDeserializer;
      String[] arrayOfString = fieldInfo1.alternateNames;
      int k = arrayOfString.length;
      byte b1 = 0;
      while (b1 < k) {
        HashMap<Object, Object> hashMap1;
        String str = arrayOfString[b1];
        fieldInfo1 = fieldInfo;
        if (fieldInfo == null)
          hashMap1 = new HashMap<Object, Object>(); 
        hashMap1.put(str, fieldDeserializer);
        b1++;
        hashMap = hashMap1;
      } 
    } 
    this.alterNameFieldDeserializers = (Map)hashMap;
    this.fieldDeserializers = new FieldDeserializer[paramJavaBeanInfo.fields.length];
    int j = paramJavaBeanInfo.fields.length;
    for (b = bool; b < j; b++) {
      FieldDeserializer fieldDeserializer = getFieldDeserializer((paramJavaBeanInfo.fields[b]).name);
      this.fieldDeserializers[b] = fieldDeserializer;
    } 
  }
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass) {
    this(paramParserConfig, paramClass, paramClass);
  }
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType) {
    this(paramParserConfig, JavaBeanInfo.build(paramClass, paramType, paramParserConfig.propertyNamingStrategy, paramParserConfig.fieldBased, paramParserConfig.compatibleWithJavaBean));
  }
  
  static boolean isSetFlag(int paramInt, int[] paramArrayOfint) {
    if (paramArrayOfint == null)
      return false; 
    int i = paramInt / 32;
    return (i < paramArrayOfint.length && (1 << paramInt % 32 & paramArrayOfint[i]) != 0);
  }
  
  protected static void parseArray(Collection paramCollection, ObjectDeserializer paramObjectDeserializer, DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    paramObject = paramDefaultJSONParser.lexer;
    int i = paramObject.token();
    if (i == 8) {
      paramObject.nextToken(16);
      paramObject.token();
      return;
    } 
    if (i != 14)
      paramDefaultJSONParser.throwException(i); 
    if (paramObject.getCurrent() == '[') {
      paramObject.next();
      paramObject.setToken(14);
    } else {
      paramObject.nextToken(14);
    } 
    if (paramObject.token() == 15) {
      paramObject.nextToken();
      return;
    } 
    i = 0;
    while (true) {
      paramCollection.add(paramObjectDeserializer.deserialze(paramDefaultJSONParser, paramType, Integer.valueOf(i)));
      i++;
      if (paramObject.token() == 16) {
        if (paramObject.getCurrent() == '[') {
          paramObject.next();
          paramObject.setToken(14);
          continue;
        } 
        paramObject.nextToken(14);
        continue;
      } 
      i = paramObject.token();
      if (i != 15)
        paramDefaultJSONParser.throwException(i); 
      if (paramObject.getCurrent() == ',') {
        paramObject.next();
        paramObject.setToken(16);
      } else {
        paramObject.nextToken(16);
      } 
      return;
    } 
  }
  
  protected void check(JSONLexer paramJSONLexer, int paramInt) {
    if (paramJSONLexer.token() == paramInt)
      return; 
    throw new JSONException("syntax error");
  }
  
  public Object createInstance(DefaultJSONParser paramDefaultJSONParser, Type paramType) {
    // Byte code:
    //   0: aload_2
    //   1: instanceof java/lang/Class
    //   4: istore_3
    //   5: iconst_0
    //   6: istore #4
    //   8: iload_3
    //   9: ifeq -> 58
    //   12: aload_0
    //   13: getfield clazz : Ljava/lang/Class;
    //   16: invokevirtual isInterface : ()Z
    //   19: ifeq -> 58
    //   22: aload_2
    //   23: checkcast java/lang/Class
    //   26: astore_1
    //   27: invokestatic currentThread : ()Ljava/lang/Thread;
    //   30: invokevirtual getContextClassLoader : ()Ljava/lang/ClassLoader;
    //   33: astore #5
    //   35: new com/alibaba/fastjson/JSONObject
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: astore_2
    //   43: aload #5
    //   45: iconst_1
    //   46: anewarray java/lang/Class
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: aload_2
    //   54: invokestatic newProxyInstance : (Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   57: areturn
    //   58: aload_0
    //   59: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   62: getfield defaultConstructor : Ljava/lang/reflect/Constructor;
    //   65: astore #6
    //   67: aconst_null
    //   68: astore #5
    //   70: aload #6
    //   72: ifnonnull -> 87
    //   75: aload_0
    //   76: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   79: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   82: ifnonnull -> 87
    //   85: aconst_null
    //   86: areturn
    //   87: aload_0
    //   88: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   91: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   94: ifnull -> 109
    //   97: aload_0
    //   98: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   101: getfield defaultConstructorParameterSize : I
    //   104: ifle -> 109
    //   107: aconst_null
    //   108: areturn
    //   109: aload_0
    //   110: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   113: getfield defaultConstructor : Ljava/lang/reflect/Constructor;
    //   116: astore #6
    //   118: aload_0
    //   119: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   122: getfield defaultConstructorParameterSize : I
    //   125: ifne -> 165
    //   128: aload #6
    //   130: ifnull -> 146
    //   133: aload #6
    //   135: iconst_0
    //   136: anewarray java/lang/Object
    //   139: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   142: astore_2
    //   143: goto -> 366
    //   146: aload_0
    //   147: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   150: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   153: aconst_null
    //   154: iconst_0
    //   155: anewarray java/lang/Object
    //   158: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   161: astore_2
    //   162: goto -> 366
    //   165: aload_1
    //   166: invokevirtual getContext : ()Lcom/alibaba/fastjson/parser/ParseContext;
    //   169: astore #7
    //   171: aload #7
    //   173: ifnull -> 508
    //   176: aload #7
    //   178: getfield object : Ljava/lang/Object;
    //   181: ifnull -> 508
    //   184: aload_2
    //   185: instanceof java/lang/Class
    //   188: ifeq -> 495
    //   191: aload_2
    //   192: checkcast java/lang/Class
    //   195: invokevirtual getName : ()Ljava/lang/String;
    //   198: astore_2
    //   199: aload_2
    //   200: iconst_0
    //   201: aload_2
    //   202: bipush #36
    //   204: invokevirtual lastIndexOf : (I)I
    //   207: invokevirtual substring : (II)Ljava/lang/String;
    //   210: astore #8
    //   212: aload #7
    //   214: getfield object : Ljava/lang/Object;
    //   217: astore_2
    //   218: aload_2
    //   219: invokevirtual getClass : ()Ljava/lang/Class;
    //   222: invokevirtual getName : ()Ljava/lang/String;
    //   225: astore #9
    //   227: aload #9
    //   229: aload #8
    //   231: invokevirtual equals : (Ljava/lang/Object;)Z
    //   234: ifne -> 348
    //   237: aload #7
    //   239: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   242: astore #7
    //   244: aload #5
    //   246: astore_2
    //   247: aload #7
    //   249: ifnull -> 348
    //   252: aload #5
    //   254: astore_2
    //   255: aload #7
    //   257: getfield object : Ljava/lang/Object;
    //   260: ifnull -> 348
    //   263: ldc 'java.util.ArrayList'
    //   265: aload #9
    //   267: invokevirtual equals : (Ljava/lang/Object;)Z
    //   270: ifne -> 320
    //   273: ldc_w 'java.util.List'
    //   276: aload #9
    //   278: invokevirtual equals : (Ljava/lang/Object;)Z
    //   281: ifne -> 320
    //   284: ldc_w 'java.util.Collection'
    //   287: aload #9
    //   289: invokevirtual equals : (Ljava/lang/Object;)Z
    //   292: ifne -> 320
    //   295: ldc_w 'java.util.Map'
    //   298: aload #9
    //   300: invokevirtual equals : (Ljava/lang/Object;)Z
    //   303: ifne -> 320
    //   306: aload #5
    //   308: astore_2
    //   309: ldc_w 'java.util.HashMap'
    //   312: aload #9
    //   314: invokevirtual equals : (Ljava/lang/Object;)Z
    //   317: ifeq -> 348
    //   320: aload #5
    //   322: astore_2
    //   323: aload #7
    //   325: getfield object : Ljava/lang/Object;
    //   328: invokevirtual getClass : ()Ljava/lang/Class;
    //   331: invokevirtual getName : ()Ljava/lang/String;
    //   334: aload #8
    //   336: invokevirtual equals : (Ljava/lang/Object;)Z
    //   339: ifeq -> 348
    //   342: aload #7
    //   344: getfield object : Ljava/lang/Object;
    //   347: astore_2
    //   348: aload_2
    //   349: ifnull -> 482
    //   352: aload #6
    //   354: iconst_1
    //   355: anewarray java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload_2
    //   361: aastore
    //   362: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   365: astore_2
    //   366: aload_1
    //   367: ifnull -> 480
    //   370: aload_1
    //   371: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   374: getstatic com/alibaba/fastjson/parser/Feature.InitStringFieldAsEmpty : Lcom/alibaba/fastjson/parser/Feature;
    //   377: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   382: ifeq -> 480
    //   385: aload_0
    //   386: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   389: getfield fields : [Lcom/alibaba/fastjson/util/FieldInfo;
    //   392: astore #5
    //   394: aload #5
    //   396: arraylength
    //   397: istore #10
    //   399: iload #4
    //   401: iload #10
    //   403: if_icmpge -> 480
    //   406: aload #5
    //   408: iload #4
    //   410: aaload
    //   411: astore_1
    //   412: aload_1
    //   413: getfield fieldClass : Ljava/lang/Class;
    //   416: ldc java/lang/String
    //   418: if_acmpne -> 474
    //   421: aload_1
    //   422: aload_2
    //   423: ldc_w ''
    //   426: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   429: goto -> 474
    //   432: astore_1
    //   433: new java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial <init> : ()V
    //   440: astore_2
    //   441: aload_2
    //   442: ldc_w 'create instance error, class '
    //   445: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_2
    //   450: aload_0
    //   451: getfield clazz : Ljava/lang/Class;
    //   454: invokevirtual getName : ()Ljava/lang/String;
    //   457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: new com/alibaba/fastjson/JSONException
    //   464: dup
    //   465: aload_2
    //   466: invokevirtual toString : ()Ljava/lang/String;
    //   469: aload_1
    //   470: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   473: athrow
    //   474: iinc #4, 1
    //   477: goto -> 399
    //   480: aload_2
    //   481: areturn
    //   482: new com/alibaba/fastjson/JSONException
    //   485: astore_1
    //   486: aload_1
    //   487: ldc_w 'can't create non-static inner class instance.'
    //   490: invokespecial <init> : (Ljava/lang/String;)V
    //   493: aload_1
    //   494: athrow
    //   495: new com/alibaba/fastjson/JSONException
    //   498: astore_1
    //   499: aload_1
    //   500: ldc_w 'can't create non-static inner class instance.'
    //   503: invokespecial <init> : (Ljava/lang/String;)V
    //   506: aload_1
    //   507: athrow
    //   508: new com/alibaba/fastjson/JSONException
    //   511: astore_1
    //   512: aload_1
    //   513: ldc_w 'can't create non-static inner class instance.'
    //   516: invokespecial <init> : (Ljava/lang/String;)V
    //   519: aload_1
    //   520: athrow
    //   521: astore_1
    //   522: new java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial <init> : ()V
    //   529: astore_2
    //   530: aload_2
    //   531: ldc_w 'create instance error, class '
    //   534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_2
    //   539: aload_0
    //   540: getfield clazz : Ljava/lang/Class;
    //   543: invokevirtual getName : ()Ljava/lang/String;
    //   546: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: new com/alibaba/fastjson/JSONException
    //   553: dup
    //   554: aload_2
    //   555: invokevirtual toString : ()Ljava/lang/String;
    //   558: aload_1
    //   559: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   562: athrow
    //   563: astore_1
    //   564: aload_1
    //   565: athrow
    // Exception table:
    //   from	to	target	type
    //   109	128	563	com/alibaba/fastjson/JSONException
    //   109	128	521	java/lang/Exception
    //   133	143	563	com/alibaba/fastjson/JSONException
    //   133	143	521	java/lang/Exception
    //   146	162	563	com/alibaba/fastjson/JSONException
    //   146	162	521	java/lang/Exception
    //   165	171	563	com/alibaba/fastjson/JSONException
    //   165	171	521	java/lang/Exception
    //   176	227	563	com/alibaba/fastjson/JSONException
    //   176	227	521	java/lang/Exception
    //   227	244	563	com/alibaba/fastjson/JSONException
    //   227	244	521	java/lang/Exception
    //   255	306	563	com/alibaba/fastjson/JSONException
    //   255	306	521	java/lang/Exception
    //   309	320	563	com/alibaba/fastjson/JSONException
    //   309	320	521	java/lang/Exception
    //   323	348	563	com/alibaba/fastjson/JSONException
    //   323	348	521	java/lang/Exception
    //   352	366	563	com/alibaba/fastjson/JSONException
    //   352	366	521	java/lang/Exception
    //   421	429	432	java/lang/Exception
    //   482	495	563	com/alibaba/fastjson/JSONException
    //   482	495	521	java/lang/Exception
    //   495	508	563	com/alibaba/fastjson/JSONException
    //   495	508	521	java/lang/Exception
    //   508	521	563	com/alibaba/fastjson/JSONException
    //   508	521	521	java/lang/Exception
  }
  
  public Object createInstance(Map<String, Object> paramMap, ParserConfig paramParserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Constructor constructor = this.beanInfo.creatorConstructor;
    Object object = null;
    if (constructor == null && this.beanInfo.factoryMethod == null) {
      object = createInstance((DefaultJSONParser)null, this.clazz);
      for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
        String str = (String)entry.getKey();
        entry = (Map.Entry<String, Object>)entry.getValue();
        FieldDeserializer fieldDeserializer = smartMatch(str);
        if (fieldDeserializer == null)
          continue; 
        fieldDeserializer.setValue(object, TypeUtils.cast(entry, fieldDeserializer.fieldInfo.fieldType, paramParserConfig));
      } 
      if (this.beanInfo.buildMethod != null)
        try {
          return this.beanInfo.buildMethod.invoke(object, new Object[0]);
        } catch (Exception null) {
          throw new JSONException("build object error", exception);
        }  
      return object;
    } 
    FieldInfo[] arrayOfFieldInfo = this.beanInfo.fields;
    int i = arrayOfFieldInfo.length;
    Object[] arrayOfObject = new Object[i];
    for (byte b = 0; b < i; b++) {
      Boolean bool;
      FieldInfo fieldInfo = arrayOfFieldInfo[b];
      constructor = (Constructor)exception.get(fieldInfo.name);
      Constructor constructor1 = constructor;
      if (constructor == null) {
        Class<int> clazz = fieldInfo.fieldClass;
        if (clazz == int.class) {
          Integer integer = Integer.valueOf(0);
        } else if (clazz == long.class) {
          Long long_ = Long.valueOf(0L);
        } else if (clazz == short.class) {
          Short short_ = Short.valueOf((short)0);
        } else if (clazz == byte.class) {
          Byte byte_ = Byte.valueOf((byte)0);
        } else if (clazz == float.class) {
          Float float_ = Float.valueOf(0.0F);
        } else if (clazz == double.class) {
          Double double_ = Double.valueOf(0.0D);
        } else if (clazz == char.class) {
          Character character = Character.valueOf('0');
        } else {
          constructor1 = constructor;
          if (clazz == boolean.class)
            bool = Boolean.valueOf(false); 
        } 
      } 
      arrayOfObject[b] = bool;
    } 
    if (this.beanInfo.creatorConstructor != null) {
      try {
        exception = this.beanInfo.creatorConstructor.newInstance(arrayOfObject);
      } catch (Exception exception1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create instance error, ");
        stringBuilder.append(this.beanInfo.creatorConstructor.toGenericString());
        throw new JSONException(stringBuilder.toString(), exception1);
      } 
    } else {
      Object object1 = object;
      if (this.beanInfo.factoryMethod != null)
        try {
          object1 = this.beanInfo.factoryMethod.invoke(null, arrayOfObject);
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("create factory method error, ");
          stringBuilder.append(this.beanInfo.factoryMethod.toString());
          throw new JSONException(stringBuilder.toString(), exception);
        }  
    } 
    return exception;
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser, paramType, paramObject, 0);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, int paramInt) {
    return deserialze(paramDefaultJSONParser, paramType, paramObject, null, paramInt, null);
  }
  
  protected <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2, int paramInt, int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w com/alibaba/fastjson/JSON
    //   4: if_acmpeq -> 3524
    //   7: aload_2
    //   8: ldc com/alibaba/fastjson/JSONObject
    //   10: if_acmpne -> 16
    //   13: goto -> 3524
    //   16: aload_1
    //   17: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   20: checkcast com/alibaba/fastjson/parser/JSONLexerBase
    //   23: astore #7
    //   25: aload_1
    //   26: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   29: astore #8
    //   31: aload #7
    //   33: invokevirtual token : ()I
    //   36: istore #9
    //   38: aconst_null
    //   39: astore #10
    //   41: iload #9
    //   43: bipush #8
    //   45: if_icmpne -> 57
    //   48: aload #7
    //   50: bipush #16
    //   52: invokevirtual nextToken : (I)V
    //   55: aconst_null
    //   56: areturn
    //   57: aload_1
    //   58: invokevirtual getContext : ()Lcom/alibaba/fastjson/parser/ParseContext;
    //   61: astore #11
    //   63: aload #11
    //   65: astore #12
    //   67: aload #4
    //   69: ifnull -> 88
    //   72: aload #11
    //   74: astore #12
    //   76: aload #11
    //   78: ifnull -> 88
    //   81: aload #11
    //   83: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   86: astore #12
    //   88: iload #9
    //   90: bipush #13
    //   92: if_icmpne -> 144
    //   95: aload #7
    //   97: bipush #16
    //   99: invokevirtual nextToken : (I)V
    //   102: aload #4
    //   104: ifnonnull -> 120
    //   107: aload_0
    //   108: aload_1
    //   109: aload_2
    //   110: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   113: astore_2
    //   114: aload_2
    //   115: astore #4
    //   117: goto -> 120
    //   120: aload_1
    //   121: aload #12
    //   123: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   126: aload #4
    //   128: areturn
    //   129: astore_2
    //   130: aload #4
    //   132: astore_3
    //   133: aload #10
    //   135: astore #4
    //   137: aload #4
    //   139: astore #10
    //   141: goto -> 3505
    //   144: iconst_0
    //   145: istore #13
    //   147: iload #9
    //   149: bipush #14
    //   151: if_icmpne -> 229
    //   154: getstatic com/alibaba/fastjson/parser/Feature.SupportArrayToBean : Lcom/alibaba/fastjson/parser/Feature;
    //   157: getfield mask : I
    //   160: istore #14
    //   162: aload_0
    //   163: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   166: getfield parserFeatures : I
    //   169: iload #14
    //   171: iand
    //   172: ifne -> 203
    //   175: aload #7
    //   177: getstatic com/alibaba/fastjson/parser/Feature.SupportArrayToBean : Lcom/alibaba/fastjson/parser/Feature;
    //   180: invokevirtual isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   183: ifne -> 203
    //   186: iload #5
    //   188: iload #14
    //   190: iand
    //   191: ifeq -> 197
    //   194: goto -> 203
    //   197: iconst_0
    //   198: istore #5
    //   200: goto -> 206
    //   203: iconst_1
    //   204: istore #5
    //   206: iload #5
    //   208: ifeq -> 229
    //   211: aload_0
    //   212: aload_1
    //   213: aload_2
    //   214: aload_3
    //   215: aload #4
    //   217: invokevirtual deserialzeArrayMapping : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: astore_2
    //   221: aload_1
    //   222: aload #12
    //   224: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   227: aload_2
    //   228: areturn
    //   229: iload #9
    //   231: bipush #12
    //   233: if_icmpeq -> 501
    //   236: iload #9
    //   238: bipush #16
    //   240: if_icmpeq -> 501
    //   243: aload #7
    //   245: invokevirtual isBlankInput : ()Z
    //   248: istore #15
    //   250: iload #15
    //   252: ifeq -> 263
    //   255: aload_1
    //   256: aload #12
    //   258: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   261: aconst_null
    //   262: areturn
    //   263: iload #9
    //   265: iconst_4
    //   266: if_icmpne -> 370
    //   269: aload #7
    //   271: invokevirtual stringVal : ()Ljava/lang/String;
    //   274: astore_2
    //   275: aload_2
    //   276: invokevirtual length : ()I
    //   279: ifne -> 295
    //   282: aload #7
    //   284: invokevirtual nextToken : ()V
    //   287: aload_1
    //   288: aload #12
    //   290: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   293: aconst_null
    //   294: areturn
    //   295: aload_0
    //   296: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   299: getfield jsonType : Lcom/alibaba/fastjson/annotation/JSONType;
    //   302: invokeinterface seeAlso : ()[Ljava/lang/Class;
    //   307: astore #6
    //   309: aload #6
    //   311: arraylength
    //   312: istore #14
    //   314: iload #13
    //   316: istore #5
    //   318: iload #5
    //   320: iload #14
    //   322: if_icmpge -> 370
    //   325: aload #6
    //   327: iload #5
    //   329: aaload
    //   330: astore #11
    //   332: ldc_w java/lang/Enum
    //   335: aload #11
    //   337: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   340: istore #15
    //   342: iload #15
    //   344: ifeq -> 364
    //   347: aload #11
    //   349: aload_2
    //   350: invokestatic valueOf : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
    //   353: astore #11
    //   355: aload_1
    //   356: aload #12
    //   358: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   361: aload #11
    //   363: areturn
    //   364: iinc #5, 1
    //   367: goto -> 318
    //   370: iload #9
    //   372: bipush #14
    //   374: if_icmpne -> 406
    //   377: aload #7
    //   379: invokevirtual getCurrent : ()C
    //   382: bipush #93
    //   384: if_icmpne -> 406
    //   387: aload #7
    //   389: invokevirtual next : ()C
    //   392: pop
    //   393: aload #7
    //   395: invokevirtual nextToken : ()V
    //   398: aload_1
    //   399: aload #12
    //   401: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   404: aconst_null
    //   405: areturn
    //   406: new java/lang/StringBuffer
    //   409: astore_2
    //   410: aload_2
    //   411: invokespecial <init> : ()V
    //   414: aload_2
    //   415: ldc_w 'syntax error, expect {, actual '
    //   418: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   421: pop
    //   422: aload_2
    //   423: aload #7
    //   425: invokevirtual tokenName : ()Ljava/lang/String;
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   431: pop
    //   432: aload_2
    //   433: ldc_w ', pos '
    //   436: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   439: pop
    //   440: aload_2
    //   441: aload #7
    //   443: invokevirtual pos : ()I
    //   446: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   449: pop
    //   450: aload_3
    //   451: instanceof java/lang/String
    //   454: ifeq -> 471
    //   457: aload_2
    //   458: ldc_w ', fieldName '
    //   461: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   464: pop
    //   465: aload_2
    //   466: aload_3
    //   467: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   470: pop
    //   471: aload_2
    //   472: ldc_w ', fastjson-version '
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   478: pop
    //   479: aload_2
    //   480: ldc_w '1.2.35'
    //   483: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   486: pop
    //   487: new com/alibaba/fastjson/JSONException
    //   490: astore_3
    //   491: aload_3
    //   492: aload_2
    //   493: invokevirtual toString : ()Ljava/lang/String;
    //   496: invokespecial <init> : (Ljava/lang/String;)V
    //   499: aload_3
    //   500: athrow
    //   501: aload_1
    //   502: getfield resolveStatus : I
    //   505: istore #5
    //   507: iload #5
    //   509: iconst_2
    //   510: if_icmpne -> 518
    //   513: aload_1
    //   514: iconst_0
    //   515: putfield resolveStatus : I
    //   518: aload_0
    //   519: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   522: getfield typeKey : Ljava/lang/String;
    //   525: astore #16
    //   527: aconst_null
    //   528: astore #10
    //   530: aload #10
    //   532: astore #11
    //   534: iconst_0
    //   535: istore #5
    //   537: aload #6
    //   539: astore #17
    //   541: aload #4
    //   543: astore #6
    //   545: aload #6
    //   547: astore #18
    //   549: iload #5
    //   551: aload_0
    //   552: getfield sortedFieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   555: arraylength
    //   556: if_icmpge -> 608
    //   559: aload #6
    //   561: astore #18
    //   563: aload_0
    //   564: getfield sortedFieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   567: iload #5
    //   569: aaload
    //   570: astore #19
    //   572: aload #6
    //   574: astore #18
    //   576: aload #19
    //   578: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   581: astore #20
    //   583: aload #6
    //   585: astore #18
    //   587: aload #20
    //   589: getfield fieldClass : Ljava/lang/Class;
    //   592: astore #21
    //   594: aload #6
    //   596: astore #18
    //   598: aload #20
    //   600: invokevirtual getAnnotation : ()Lcom/alibaba/fastjson/annotation/JSONField;
    //   603: astore #4
    //   605: goto -> 620
    //   608: aconst_null
    //   609: astore #20
    //   611: aconst_null
    //   612: astore #21
    //   614: aconst_null
    //   615: astore #19
    //   617: aconst_null
    //   618: astore #4
    //   620: aload #19
    //   622: ifnull -> 1349
    //   625: aload #6
    //   627: astore #18
    //   629: aload #20
    //   631: getfield name_chars : [C
    //   634: astore #22
    //   636: aload #6
    //   638: astore #18
    //   640: aload #21
    //   642: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   645: if_acmpeq -> 1295
    //   648: aload #21
    //   650: ldc java/lang/Integer
    //   652: if_acmpne -> 658
    //   655: goto -> 1295
    //   658: aload #6
    //   660: astore #18
    //   662: aload #21
    //   664: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   667: if_acmpeq -> 1247
    //   670: aload #21
    //   672: ldc_w java/lang/Long
    //   675: if_acmpne -> 681
    //   678: goto -> 1247
    //   681: aload #21
    //   683: ldc java/lang/String
    //   685: if_acmpne -> 733
    //   688: aload #6
    //   690: astore #18
    //   692: aload #7
    //   694: aload #22
    //   696: invokevirtual scanFieldString : ([C)Ljava/lang/String;
    //   699: astore #4
    //   701: aload #6
    //   703: astore #18
    //   705: aload #7
    //   707: getfield matchStat : I
    //   710: ifle -> 716
    //   713: goto -> 1323
    //   716: aload #6
    //   718: astore #18
    //   720: aload #7
    //   722: getfield matchStat : I
    //   725: bipush #-2
    //   727: if_icmpne -> 1352
    //   730: goto -> 1346
    //   733: aload #6
    //   735: astore #18
    //   737: aload #21
    //   739: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   742: if_acmpeq -> 1199
    //   745: aload #21
    //   747: ldc_w java/lang/Boolean
    //   750: if_acmpne -> 756
    //   753: goto -> 1199
    //   756: aload #6
    //   758: astore #18
    //   760: aload #21
    //   762: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   765: if_acmpeq -> 1151
    //   768: aload #21
    //   770: ldc_w java/lang/Float
    //   773: if_acmpne -> 779
    //   776: goto -> 1151
    //   779: aload #6
    //   781: astore #18
    //   783: aload #21
    //   785: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   788: if_acmpeq -> 1103
    //   791: aload #21
    //   793: ldc_w java/lang/Double
    //   796: if_acmpne -> 802
    //   799: goto -> 1103
    //   802: aload #6
    //   804: astore #18
    //   806: aload #21
    //   808: invokevirtual isEnum : ()Z
    //   811: ifeq -> 921
    //   814: aload #6
    //   816: astore #18
    //   818: aload_1
    //   819: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   822: aload #21
    //   824: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   827: instanceof com/alibaba/fastjson/parser/deserializer/EnumDeserializer
    //   830: ifeq -> 921
    //   833: aload #4
    //   835: ifnull -> 855
    //   838: aload #6
    //   840: astore #18
    //   842: aload #4
    //   844: invokeinterface deserializeUsing : ()Ljava/lang/Class;
    //   849: ldc_w java/lang/Void
    //   852: if_acmpne -> 921
    //   855: aload #6
    //   857: astore #18
    //   859: aload #19
    //   861: instanceof com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer
    //   864: ifeq -> 1349
    //   867: aload #6
    //   869: astore #18
    //   871: aload_0
    //   872: aload #7
    //   874: aload #22
    //   876: aload #19
    //   878: checkcast com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer
    //   881: getfield fieldValueDeserilizer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   884: invokevirtual scanEnum : (Lcom/alibaba/fastjson/parser/JSONLexerBase;[CLcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;)Ljava/lang/Enum;
    //   887: astore #4
    //   889: aload #6
    //   891: astore #18
    //   893: aload #7
    //   895: getfield matchStat : I
    //   898: ifle -> 904
    //   901: goto -> 1323
    //   904: aload #6
    //   906: astore #18
    //   908: aload #7
    //   910: getfield matchStat : I
    //   913: bipush #-2
    //   915: if_icmpne -> 1352
    //   918: goto -> 1346
    //   921: aload #21
    //   923: ldc_w [I
    //   926: if_acmpne -> 974
    //   929: aload #6
    //   931: astore #18
    //   933: aload #7
    //   935: aload #22
    //   937: invokevirtual scanFieldIntArray : ([C)[I
    //   940: astore #4
    //   942: aload #6
    //   944: astore #18
    //   946: aload #7
    //   948: getfield matchStat : I
    //   951: ifle -> 957
    //   954: goto -> 1323
    //   957: aload #6
    //   959: astore #18
    //   961: aload #7
    //   963: getfield matchStat : I
    //   966: bipush #-2
    //   968: if_icmpne -> 1352
    //   971: goto -> 1346
    //   974: aload #21
    //   976: ldc_w [F
    //   979: if_acmpne -> 1027
    //   982: aload #6
    //   984: astore #18
    //   986: aload #7
    //   988: aload #22
    //   990: invokevirtual scanFieldFloatArray : ([C)[F
    //   993: astore #4
    //   995: aload #6
    //   997: astore #18
    //   999: aload #7
    //   1001: getfield matchStat : I
    //   1004: ifle -> 1010
    //   1007: goto -> 1323
    //   1010: aload #6
    //   1012: astore #18
    //   1014: aload #7
    //   1016: getfield matchStat : I
    //   1019: bipush #-2
    //   1021: if_icmpne -> 1352
    //   1024: goto -> 1346
    //   1027: aload #21
    //   1029: ldc_w [[F
    //   1032: if_acmpne -> 1080
    //   1035: aload #6
    //   1037: astore #18
    //   1039: aload #7
    //   1041: aload #22
    //   1043: invokevirtual scanFieldFloatArray2 : ([C)[[F
    //   1046: astore #4
    //   1048: aload #6
    //   1050: astore #18
    //   1052: aload #7
    //   1054: getfield matchStat : I
    //   1057: ifle -> 1063
    //   1060: goto -> 1323
    //   1063: aload #6
    //   1065: astore #18
    //   1067: aload #7
    //   1069: getfield matchStat : I
    //   1072: bipush #-2
    //   1074: if_icmpne -> 1352
    //   1077: goto -> 1346
    //   1080: aload #6
    //   1082: astore #18
    //   1084: aload #7
    //   1086: aload #22
    //   1088: invokevirtual matchField : ([C)Z
    //   1091: ifeq -> 1346
    //   1094: aconst_null
    //   1095: astore #4
    //   1097: iconst_1
    //   1098: istore #13
    //   1100: goto -> 1355
    //   1103: aload #6
    //   1105: astore #18
    //   1107: aload #7
    //   1109: aload #22
    //   1111: invokevirtual scanFieldDouble : ([C)D
    //   1114: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1117: astore #4
    //   1119: aload #6
    //   1121: astore #18
    //   1123: aload #7
    //   1125: getfield matchStat : I
    //   1128: ifle -> 1134
    //   1131: goto -> 1323
    //   1134: aload #6
    //   1136: astore #18
    //   1138: aload #7
    //   1140: getfield matchStat : I
    //   1143: bipush #-2
    //   1145: if_icmpne -> 1352
    //   1148: goto -> 1346
    //   1151: aload #6
    //   1153: astore #18
    //   1155: aload #7
    //   1157: aload #22
    //   1159: invokevirtual scanFieldFloat : ([C)F
    //   1162: invokestatic valueOf : (F)Ljava/lang/Float;
    //   1165: astore #4
    //   1167: aload #6
    //   1169: astore #18
    //   1171: aload #7
    //   1173: getfield matchStat : I
    //   1176: ifle -> 1182
    //   1179: goto -> 1323
    //   1182: aload #6
    //   1184: astore #18
    //   1186: aload #7
    //   1188: getfield matchStat : I
    //   1191: bipush #-2
    //   1193: if_icmpne -> 1352
    //   1196: goto -> 1346
    //   1199: aload #6
    //   1201: astore #18
    //   1203: aload #7
    //   1205: aload #22
    //   1207: invokevirtual scanFieldBoolean : ([C)Z
    //   1210: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   1213: astore #4
    //   1215: aload #6
    //   1217: astore #18
    //   1219: aload #7
    //   1221: getfield matchStat : I
    //   1224: ifle -> 1230
    //   1227: goto -> 1323
    //   1230: aload #6
    //   1232: astore #18
    //   1234: aload #7
    //   1236: getfield matchStat : I
    //   1239: bipush #-2
    //   1241: if_icmpne -> 1352
    //   1244: goto -> 1346
    //   1247: aload #6
    //   1249: astore #18
    //   1251: aload #7
    //   1253: aload #22
    //   1255: invokevirtual scanFieldLong : ([C)J
    //   1258: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1261: astore #4
    //   1263: aload #6
    //   1265: astore #18
    //   1267: aload #7
    //   1269: getfield matchStat : I
    //   1272: ifle -> 1278
    //   1275: goto -> 1323
    //   1278: aload #6
    //   1280: astore #18
    //   1282: aload #7
    //   1284: getfield matchStat : I
    //   1287: bipush #-2
    //   1289: if_icmpne -> 1352
    //   1292: goto -> 1346
    //   1295: aload #6
    //   1297: astore #18
    //   1299: aload #7
    //   1301: aload #22
    //   1303: invokevirtual scanFieldInt : ([C)I
    //   1306: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1309: astore #4
    //   1311: aload #6
    //   1313: astore #18
    //   1315: aload #7
    //   1317: getfield matchStat : I
    //   1320: ifle -> 1332
    //   1323: iconst_1
    //   1324: istore #14
    //   1326: iconst_1
    //   1327: istore #9
    //   1329: goto -> 1362
    //   1332: aload #6
    //   1334: astore #18
    //   1336: aload #7
    //   1338: getfield matchStat : I
    //   1341: bipush #-2
    //   1343: if_icmpne -> 1352
    //   1346: goto -> 2228
    //   1349: aconst_null
    //   1350: astore #4
    //   1352: iconst_0
    //   1353: istore #13
    //   1355: iconst_0
    //   1356: istore #9
    //   1358: iload #13
    //   1360: istore #14
    //   1362: iload #5
    //   1364: istore #13
    //   1366: iload #14
    //   1368: ifne -> 2270
    //   1371: aload #6
    //   1373: astore #18
    //   1375: aload #7
    //   1377: aload_1
    //   1378: getfield symbolTable : Lcom/alibaba/fastjson/parser/SymbolTable;
    //   1381: invokevirtual scanSymbol : (Lcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   1384: astore #22
    //   1386: aload #22
    //   1388: ifnonnull -> 1448
    //   1391: aload #6
    //   1393: astore #18
    //   1395: aload #7
    //   1397: invokevirtual token : ()I
    //   1400: istore #23
    //   1402: iload #23
    //   1404: bipush #13
    //   1406: if_icmpne -> 1423
    //   1409: aload #6
    //   1411: astore #18
    //   1413: aload #7
    //   1415: bipush #16
    //   1417: invokevirtual nextToken : (I)V
    //   1420: goto -> 2217
    //   1423: iload #23
    //   1425: bipush #16
    //   1427: if_icmpne -> 1448
    //   1430: aload #6
    //   1432: astore #18
    //   1434: aload #7
    //   1436: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   1439: invokevirtual isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   1442: ifeq -> 1448
    //   1445: goto -> 1346
    //   1448: ldc_w '$ref'
    //   1451: aload #22
    //   1453: if_acmpne -> 1934
    //   1456: aload #12
    //   1458: ifnull -> 1934
    //   1461: aload #6
    //   1463: astore #18
    //   1465: aload #7
    //   1467: iconst_4
    //   1468: invokevirtual nextTokenWithColon : (I)V
    //   1471: aload #6
    //   1473: astore #18
    //   1475: aload #7
    //   1477: invokevirtual token : ()I
    //   1480: istore #5
    //   1482: iload #5
    //   1484: iconst_4
    //   1485: if_icmpne -> 1866
    //   1488: aload #6
    //   1490: astore #18
    //   1492: aload #7
    //   1494: invokevirtual stringVal : ()Ljava/lang/String;
    //   1497: astore #4
    //   1499: aload #6
    //   1501: astore #18
    //   1503: ldc_w '@'
    //   1506: aload #4
    //   1508: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1511: ifeq -> 1530
    //   1514: aload #6
    //   1516: astore #18
    //   1518: aload #12
    //   1520: getfield object : Ljava/lang/Object;
    //   1523: astore_2
    //   1524: aload_2
    //   1525: astore #6
    //   1527: goto -> 1770
    //   1530: aload #6
    //   1532: astore #18
    //   1534: ldc_w '..'
    //   1537: aload #4
    //   1539: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1542: ifeq -> 1625
    //   1545: aload #6
    //   1547: astore #18
    //   1549: aload #12
    //   1551: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1554: astore #11
    //   1556: aload #6
    //   1558: astore #18
    //   1560: aload #11
    //   1562: getfield object : Ljava/lang/Object;
    //   1565: ifnull -> 1581
    //   1568: aload #6
    //   1570: astore #18
    //   1572: aload #11
    //   1574: getfield object : Ljava/lang/Object;
    //   1577: astore_2
    //   1578: goto -> 1524
    //   1581: aload #6
    //   1583: astore #18
    //   1585: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1588: astore_2
    //   1589: aload #6
    //   1591: astore #18
    //   1593: aload_2
    //   1594: aload #11
    //   1596: aload #4
    //   1598: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1601: aload #6
    //   1603: astore #18
    //   1605: aload_1
    //   1606: aload_2
    //   1607: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1610: aload #6
    //   1612: astore #18
    //   1614: aload_1
    //   1615: iconst_1
    //   1616: putfield resolveStatus : I
    //   1619: aload #6
    //   1621: astore_2
    //   1622: goto -> 1524
    //   1625: aload #6
    //   1627: astore #18
    //   1629: ldc_w '$'
    //   1632: aload #4
    //   1634: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1637: ifeq -> 1732
    //   1640: aload #12
    //   1642: astore_2
    //   1643: aload #6
    //   1645: astore #18
    //   1647: aload_2
    //   1648: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1651: ifnull -> 1666
    //   1654: aload #6
    //   1656: astore #18
    //   1658: aload_2
    //   1659: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1662: astore_2
    //   1663: goto -> 1643
    //   1666: aload #6
    //   1668: astore #18
    //   1670: aload_2
    //   1671: getfield object : Ljava/lang/Object;
    //   1674: ifnull -> 1689
    //   1677: aload #6
    //   1679: astore #18
    //   1681: aload_2
    //   1682: getfield object : Ljava/lang/Object;
    //   1685: astore_2
    //   1686: goto -> 1524
    //   1689: aload #6
    //   1691: astore #18
    //   1693: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1696: astore #11
    //   1698: aload #6
    //   1700: astore #18
    //   1702: aload #11
    //   1704: aload_2
    //   1705: aload #4
    //   1707: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1710: aload #6
    //   1712: astore #18
    //   1714: aload_1
    //   1715: aload #11
    //   1717: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1720: aload #6
    //   1722: astore #18
    //   1724: aload_1
    //   1725: iconst_1
    //   1726: putfield resolveStatus : I
    //   1729: goto -> 1619
    //   1732: aload #6
    //   1734: astore #18
    //   1736: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1739: astore_2
    //   1740: aload #6
    //   1742: astore #18
    //   1744: aload_2
    //   1745: aload #12
    //   1747: aload #4
    //   1749: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1752: aload #6
    //   1754: astore #18
    //   1756: aload_1
    //   1757: aload_2
    //   1758: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1761: aload #6
    //   1763: astore #18
    //   1765: aload_1
    //   1766: iconst_1
    //   1767: putfield resolveStatus : I
    //   1770: aload #6
    //   1772: astore #18
    //   1774: aload #7
    //   1776: bipush #13
    //   1778: invokevirtual nextToken : (I)V
    //   1781: aload #6
    //   1783: astore #18
    //   1785: aload #7
    //   1787: invokevirtual token : ()I
    //   1790: bipush #13
    //   1792: if_icmpne -> 1841
    //   1795: aload #6
    //   1797: astore #18
    //   1799: aload #7
    //   1801: bipush #16
    //   1803: invokevirtual nextToken : (I)V
    //   1806: aload #6
    //   1808: astore #18
    //   1810: aload_1
    //   1811: aload #12
    //   1813: aload #6
    //   1815: aload_3
    //   1816: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   1819: pop
    //   1820: aload #10
    //   1822: ifnull -> 1832
    //   1825: aload #10
    //   1827: aload #6
    //   1829: putfield object : Ljava/lang/Object;
    //   1832: aload_1
    //   1833: aload #12
    //   1835: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1838: aload #6
    //   1840: areturn
    //   1841: aload #6
    //   1843: astore #18
    //   1845: new com/alibaba/fastjson/JSONException
    //   1848: astore_2
    //   1849: aload #6
    //   1851: astore #18
    //   1853: aload_2
    //   1854: ldc_w 'illegal ref'
    //   1857: invokespecial <init> : (Ljava/lang/String;)V
    //   1860: aload #6
    //   1862: astore #18
    //   1864: aload_2
    //   1865: athrow
    //   1866: aload #6
    //   1868: astore #18
    //   1870: new com/alibaba/fastjson/JSONException
    //   1873: astore_2
    //   1874: aload #6
    //   1876: astore #18
    //   1878: new java/lang/StringBuilder
    //   1881: astore_3
    //   1882: aload #6
    //   1884: astore #18
    //   1886: aload_3
    //   1887: invokespecial <init> : ()V
    //   1890: aload #6
    //   1892: astore #18
    //   1894: aload_3
    //   1895: ldc_w 'illegal ref, '
    //   1898: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: pop
    //   1902: aload #6
    //   1904: astore #18
    //   1906: aload_3
    //   1907: iload #5
    //   1909: invokestatic name : (I)Ljava/lang/String;
    //   1912: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: pop
    //   1916: aload #6
    //   1918: astore #18
    //   1920: aload_2
    //   1921: aload_3
    //   1922: invokevirtual toString : ()Ljava/lang/String;
    //   1925: invokespecial <init> : (Ljava/lang/String;)V
    //   1928: aload #6
    //   1930: astore #18
    //   1932: aload_2
    //   1933: athrow
    //   1934: aload #16
    //   1936: ifnull -> 1959
    //   1939: aload #6
    //   1941: astore #18
    //   1943: aload #16
    //   1945: aload #22
    //   1947: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1950: ifne -> 1956
    //   1953: goto -> 1959
    //   1956: goto -> 1974
    //   1959: aload #6
    //   1961: astore #18
    //   1963: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   1966: aload #22
    //   1968: if_acmpne -> 2267
    //   1971: goto -> 1956
    //   1974: aload #6
    //   1976: astore #18
    //   1978: aload #7
    //   1980: iconst_4
    //   1981: invokevirtual nextTokenWithColon : (I)V
    //   1984: aload #6
    //   1986: astore #18
    //   1988: aload #7
    //   1990: invokevirtual token : ()I
    //   1993: iconst_4
    //   1994: if_icmpne -> 2243
    //   1997: aload #6
    //   1999: astore #18
    //   2001: aload #7
    //   2003: invokevirtual stringVal : ()Ljava/lang/String;
    //   2006: astore #21
    //   2008: aload #6
    //   2010: astore #18
    //   2012: aload #7
    //   2014: bipush #16
    //   2016: invokevirtual nextToken : (I)V
    //   2019: aload #6
    //   2021: astore #18
    //   2023: aload #21
    //   2025: aload_0
    //   2026: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2029: getfield typeName : Ljava/lang/String;
    //   2032: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2035: ifne -> 2194
    //   2038: aload #6
    //   2040: astore #18
    //   2042: aload_1
    //   2043: getstatic com/alibaba/fastjson/parser/Feature.IgnoreAutoType : Lcom/alibaba/fastjson/parser/Feature;
    //   2046: invokevirtual isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   2049: ifeq -> 2055
    //   2052: goto -> 2194
    //   2055: aload #6
    //   2057: astore #18
    //   2059: aload_0
    //   2060: aload #8
    //   2062: aload_0
    //   2063: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2066: aload #21
    //   2068: invokevirtual getSeeAlso : (Lcom/alibaba/fastjson/parser/ParserConfig;Lcom/alibaba/fastjson/util/JavaBeanInfo;Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer;
    //   2071: astore #11
    //   2073: aload #11
    //   2075: ifnonnull -> 2112
    //   2078: aload #6
    //   2080: astore #18
    //   2082: aload #8
    //   2084: aload #21
    //   2086: aload_2
    //   2087: invokestatic getClass : (Ljava/lang/reflect/Type;)Ljava/lang/Class;
    //   2090: invokevirtual checkAutoType : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Class;
    //   2093: astore #4
    //   2095: aload #6
    //   2097: astore #18
    //   2099: aload_1
    //   2100: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   2103: aload #4
    //   2105: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   2108: astore_2
    //   2109: goto -> 2118
    //   2112: aconst_null
    //   2113: astore #4
    //   2115: aload #11
    //   2117: astore_2
    //   2118: aload #6
    //   2120: astore #18
    //   2122: aload_2
    //   2123: aload_1
    //   2124: aload #4
    //   2126: aload_3
    //   2127: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   2132: astore_3
    //   2133: aload #6
    //   2135: astore #18
    //   2137: aload_2
    //   2138: instanceof com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   2141: ifeq -> 2174
    //   2144: aload #6
    //   2146: astore #18
    //   2148: aload_2
    //   2149: checkcast com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   2152: astore_2
    //   2153: aload #16
    //   2155: ifnull -> 2174
    //   2158: aload #6
    //   2160: astore #18
    //   2162: aload_2
    //   2163: aload #16
    //   2165: invokevirtual getFieldDeserializer : (Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   2168: aload_3
    //   2169: aload #21
    //   2171: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   2174: aload #10
    //   2176: ifnull -> 2186
    //   2179: aload #10
    //   2181: aload #6
    //   2183: putfield object : Ljava/lang/Object;
    //   2186: aload_1
    //   2187: aload #12
    //   2189: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2192: aload_3
    //   2193: areturn
    //   2194: aload #6
    //   2196: astore #18
    //   2198: aload #7
    //   2200: invokevirtual token : ()I
    //   2203: bipush #13
    //   2205: if_icmpne -> 2228
    //   2208: aload #6
    //   2210: astore #18
    //   2212: aload #7
    //   2214: invokevirtual nextToken : ()V
    //   2217: aload #10
    //   2219: astore #4
    //   2221: aload #11
    //   2223: astore #17
    //   2225: goto -> 2692
    //   2228: aload #11
    //   2230: astore #4
    //   2232: aload #17
    //   2234: astore #11
    //   2236: aload #10
    //   2238: astore #18
    //   2240: goto -> 3406
    //   2243: aload #6
    //   2245: astore #18
    //   2247: new com/alibaba/fastjson/JSONException
    //   2250: astore_2
    //   2251: aload #6
    //   2253: astore #18
    //   2255: aload_2
    //   2256: ldc 'syntax error'
    //   2258: invokespecial <init> : (Ljava/lang/String;)V
    //   2261: aload #6
    //   2263: astore #18
    //   2265: aload_2
    //   2266: athrow
    //   2267: goto -> 2273
    //   2270: aconst_null
    //   2271: astore #22
    //   2273: aload #4
    //   2275: astore #24
    //   2277: aload #21
    //   2279: astore #25
    //   2281: aload #6
    //   2283: ifnonnull -> 2405
    //   2286: aload #11
    //   2288: ifnonnull -> 2405
    //   2291: aload #6
    //   2293: astore #18
    //   2295: aload_0
    //   2296: aload_1
    //   2297: aload_2
    //   2298: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   2301: astore #21
    //   2303: aload #21
    //   2305: ifnonnull -> 2333
    //   2308: new java/util/HashMap
    //   2311: astore #4
    //   2313: aload #4
    //   2315: aload_0
    //   2316: getfield fieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   2319: arraylength
    //   2320: invokespecial <init> : (I)V
    //   2323: goto -> 2337
    //   2326: astore_2
    //   2327: aload #21
    //   2329: astore_3
    //   2330: goto -> 3505
    //   2333: aload #11
    //   2335: astore #4
    //   2337: aload_1
    //   2338: aload #12
    //   2340: aload #21
    //   2342: aload_3
    //   2343: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2346: astore #11
    //   2348: aload #17
    //   2350: astore #6
    //   2352: aload #17
    //   2354: ifnonnull -> 2382
    //   2357: aload_0
    //   2358: getfield fieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   2361: arraylength
    //   2362: bipush #32
    //   2364: idiv
    //   2365: iconst_1
    //   2366: iadd
    //   2367: newarray int
    //   2369: astore #6
    //   2371: goto -> 2382
    //   2374: astore_2
    //   2375: aload #11
    //   2377: astore #10
    //   2379: goto -> 2327
    //   2382: aload #11
    //   2384: astore #17
    //   2386: aload #4
    //   2388: astore #10
    //   2390: aload #21
    //   2392: astore #4
    //   2394: aload #6
    //   2396: astore #11
    //   2398: aload #17
    //   2400: astore #6
    //   2402: goto -> 2429
    //   2405: aload #10
    //   2407: astore #4
    //   2409: aload #11
    //   2411: astore #10
    //   2413: aload #6
    //   2415: astore #18
    //   2417: aload #17
    //   2419: astore #11
    //   2421: aload #4
    //   2423: astore #6
    //   2425: aload #18
    //   2427: astore #4
    //   2429: iload #14
    //   2431: ifeq -> 2598
    //   2434: iload #9
    //   2436: ifne -> 2460
    //   2439: aload #19
    //   2441: aload_1
    //   2442: aload #4
    //   2444: aload_2
    //   2445: aload #10
    //   2447: invokevirtual parseField : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)V
    //   2450: goto -> 2646
    //   2453: astore_2
    //   2454: aload #4
    //   2456: astore_3
    //   2457: goto -> 3484
    //   2460: aload #4
    //   2462: ifnonnull -> 2483
    //   2465: aload #10
    //   2467: aload #20
    //   2469: getfield name : Ljava/lang/String;
    //   2472: aload #24
    //   2474: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2479: pop
    //   2480: goto -> 2549
    //   2483: aload #24
    //   2485: ifnonnull -> 2540
    //   2488: aload #25
    //   2490: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   2493: if_acmpeq -> 2549
    //   2496: aload #25
    //   2498: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   2501: if_acmpeq -> 2549
    //   2504: aload #25
    //   2506: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   2509: if_acmpeq -> 2549
    //   2512: aload #25
    //   2514: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   2517: if_acmpeq -> 2549
    //   2520: aload #25
    //   2522: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   2525: if_acmpeq -> 2549
    //   2528: aload #19
    //   2530: aload #4
    //   2532: aload #24
    //   2534: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   2537: goto -> 2549
    //   2540: aload #19
    //   2542: aload #4
    //   2544: aload #24
    //   2546: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   2549: aload #11
    //   2551: ifnull -> 2582
    //   2554: iload #13
    //   2556: bipush #32
    //   2558: idiv
    //   2559: istore #5
    //   2561: aload #11
    //   2563: iload #5
    //   2565: iconst_1
    //   2566: iload #13
    //   2568: bipush #32
    //   2570: irem
    //   2571: ishr
    //   2572: aload #11
    //   2574: iload #5
    //   2576: iaload
    //   2577: ior
    //   2578: iastore
    //   2579: goto -> 2582
    //   2582: aload #7
    //   2584: getfield matchStat : I
    //   2587: istore #5
    //   2589: iload #5
    //   2591: iconst_4
    //   2592: if_icmpne -> 2450
    //   2595: goto -> 2676
    //   2598: aload_0
    //   2599: aload_1
    //   2600: aload #22
    //   2602: aload #4
    //   2604: aload_2
    //   2605: aload #10
    //   2607: aload #11
    //   2609: invokevirtual parseField : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;[I)Z
    //   2612: ifne -> 2636
    //   2615: aload #7
    //   2617: invokevirtual token : ()I
    //   2620: bipush #13
    //   2622: if_icmpne -> 2633
    //   2625: aload #7
    //   2627: invokevirtual nextToken : ()V
    //   2630: goto -> 2676
    //   2633: goto -> 3390
    //   2636: aload #7
    //   2638: invokevirtual token : ()I
    //   2641: bipush #17
    //   2643: if_icmpeq -> 3467
    //   2646: aload #7
    //   2648: invokevirtual token : ()I
    //   2651: bipush #16
    //   2653: if_icmpne -> 2659
    //   2656: goto -> 2633
    //   2659: aload #7
    //   2661: invokevirtual token : ()I
    //   2664: bipush #13
    //   2666: if_icmpne -> 3371
    //   2669: aload #7
    //   2671: bipush #16
    //   2673: invokevirtual nextToken : (I)V
    //   2676: aload #4
    //   2678: astore #11
    //   2680: aload #6
    //   2682: astore #4
    //   2684: aload #11
    //   2686: astore #6
    //   2688: aload #10
    //   2690: astore #17
    //   2692: aload #6
    //   2694: astore #11
    //   2696: aload #6
    //   2698: ifnonnull -> 3265
    //   2701: aload #17
    //   2703: ifnonnull -> 2765
    //   2706: aload #6
    //   2708: astore #10
    //   2710: aload_0
    //   2711: aload_1
    //   2712: aload_2
    //   2713: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   2716: astore #6
    //   2718: aload #4
    //   2720: astore_2
    //   2721: aload #4
    //   2723: ifnonnull -> 2746
    //   2726: aload_1
    //   2727: aload #12
    //   2729: aload #6
    //   2731: aload_3
    //   2732: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2735: astore_2
    //   2736: goto -> 2746
    //   2739: astore_2
    //   2740: aload #6
    //   2742: astore_3
    //   2743: goto -> 137
    //   2746: aload_2
    //   2747: ifnull -> 2756
    //   2750: aload_2
    //   2751: aload #6
    //   2753: putfield object : Ljava/lang/Object;
    //   2756: aload_1
    //   2757: aload #12
    //   2759: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2762: aload #6
    //   2764: areturn
    //   2765: aload #6
    //   2767: astore #10
    //   2769: aload_0
    //   2770: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2773: getfield fields : [Lcom/alibaba/fastjson/util/FieldInfo;
    //   2776: astore #11
    //   2778: aload #6
    //   2780: astore #10
    //   2782: aload #11
    //   2784: arraylength
    //   2785: istore #13
    //   2787: aload #6
    //   2789: astore #10
    //   2791: iload #13
    //   2793: anewarray java/lang/Object
    //   2796: astore #18
    //   2798: iconst_0
    //   2799: istore #5
    //   2801: iload #5
    //   2803: iload #13
    //   2805: if_icmpge -> 3027
    //   2808: aload #11
    //   2810: iload #5
    //   2812: aaload
    //   2813: astore #21
    //   2815: aload #6
    //   2817: astore #10
    //   2819: aload #17
    //   2821: aload #21
    //   2823: getfield name : Ljava/lang/String;
    //   2826: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2831: astore_3
    //   2832: aload_3
    //   2833: astore_2
    //   2834: aload_3
    //   2835: ifnonnull -> 3015
    //   2838: aload #6
    //   2840: astore #10
    //   2842: aload #21
    //   2844: getfield fieldType : Ljava/lang/reflect/Type;
    //   2847: astore #21
    //   2849: aload #6
    //   2851: astore #10
    //   2853: aload #21
    //   2855: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
    //   2858: if_acmpne -> 2873
    //   2861: aload #6
    //   2863: astore #10
    //   2865: iconst_0
    //   2866: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   2869: astore_2
    //   2870: goto -> 3015
    //   2873: aload #6
    //   2875: astore #10
    //   2877: aload #21
    //   2879: getstatic java/lang/Short.TYPE : Ljava/lang/Class;
    //   2882: if_acmpne -> 2897
    //   2885: aload #6
    //   2887: astore #10
    //   2889: iconst_0
    //   2890: invokestatic valueOf : (S)Ljava/lang/Short;
    //   2893: astore_2
    //   2894: goto -> 3015
    //   2897: aload #6
    //   2899: astore #10
    //   2901: aload #21
    //   2903: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   2906: if_acmpne -> 2921
    //   2909: aload #6
    //   2911: astore #10
    //   2913: iconst_0
    //   2914: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2917: astore_2
    //   2918: goto -> 3015
    //   2921: aload #6
    //   2923: astore #10
    //   2925: aload #21
    //   2927: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   2930: if_acmpne -> 2945
    //   2933: aload #6
    //   2935: astore #10
    //   2937: lconst_0
    //   2938: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2941: astore_2
    //   2942: goto -> 3015
    //   2945: aload #6
    //   2947: astore #10
    //   2949: aload #21
    //   2951: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   2954: if_acmpne -> 2969
    //   2957: aload #6
    //   2959: astore #10
    //   2961: fconst_0
    //   2962: invokestatic valueOf : (F)Ljava/lang/Float;
    //   2965: astore_2
    //   2966: goto -> 3015
    //   2969: aload #6
    //   2971: astore #10
    //   2973: aload #21
    //   2975: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   2978: if_acmpne -> 2993
    //   2981: aload #6
    //   2983: astore #10
    //   2985: dconst_0
    //   2986: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2989: astore_2
    //   2990: goto -> 3015
    //   2993: aload_3
    //   2994: astore_2
    //   2995: aload #6
    //   2997: astore #10
    //   2999: aload #21
    //   3001: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   3004: if_acmpne -> 3015
    //   3007: aload #6
    //   3009: astore #10
    //   3011: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   3014: astore_2
    //   3015: aload #18
    //   3017: iload #5
    //   3019: aload_2
    //   3020: aastore
    //   3021: iinc #5, 1
    //   3024: goto -> 2801
    //   3027: aload #6
    //   3029: astore #10
    //   3031: aload_0
    //   3032: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   3035: getfield creatorConstructor : Ljava/lang/reflect/Constructor;
    //   3038: astore_2
    //   3039: aload_2
    //   3040: ifnull -> 3144
    //   3043: aload #6
    //   3045: astore #10
    //   3047: aload_0
    //   3048: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   3051: getfield creatorConstructor : Ljava/lang/reflect/Constructor;
    //   3054: aload #18
    //   3056: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   3059: astore_2
    //   3060: aload_2
    //   3061: astore #11
    //   3063: goto -> 3265
    //   3066: astore_3
    //   3067: aload #6
    //   3069: astore #10
    //   3071: new com/alibaba/fastjson/JSONException
    //   3074: astore #11
    //   3076: aload #6
    //   3078: astore #10
    //   3080: new java/lang/StringBuilder
    //   3083: astore_2
    //   3084: aload #6
    //   3086: astore #10
    //   3088: aload_2
    //   3089: invokespecial <init> : ()V
    //   3092: aload #6
    //   3094: astore #10
    //   3096: aload_2
    //   3097: ldc_w 'create instance error, '
    //   3100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: pop
    //   3104: aload #6
    //   3106: astore #10
    //   3108: aload_2
    //   3109: aload_0
    //   3110: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   3113: getfield creatorConstructor : Ljava/lang/reflect/Constructor;
    //   3116: invokevirtual toGenericString : ()Ljava/lang/String;
    //   3119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3122: pop
    //   3123: aload #6
    //   3125: astore #10
    //   3127: aload #11
    //   3129: aload_2
    //   3130: invokevirtual toString : ()Ljava/lang/String;
    //   3133: aload_3
    //   3134: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3137: aload #6
    //   3139: astore #10
    //   3141: aload #11
    //   3143: athrow
    //   3144: aload #6
    //   3146: astore #10
    //   3148: aload_0
    //   3149: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   3152: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   3155: astore_2
    //   3156: aload #6
    //   3158: astore #11
    //   3160: aload_2
    //   3161: ifnull -> 3265
    //   3164: aload #6
    //   3166: astore #10
    //   3168: aload_0
    //   3169: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   3172: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   3175: aconst_null
    //   3176: aload #18
    //   3178: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3181: astore_2
    //   3182: goto -> 3060
    //   3185: astore_3
    //   3186: aload #6
    //   3188: astore #10
    //   3190: new com/alibaba/fastjson/JSONException
    //   3193: astore_2
    //   3194: aload #6
    //   3196: astore #10
    //   3198: new java/lang/StringBuilder
    //   3201: astore #11
    //   3203: aload #6
    //   3205: astore #10
    //   3207: aload #11
    //   3209: invokespecial <init> : ()V
    //   3212: aload #6
    //   3214: astore #10
    //   3216: aload #11
    //   3218: ldc_w 'create factory method error, '
    //   3221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3224: pop
    //   3225: aload #6
    //   3227: astore #10
    //   3229: aload #11
    //   3231: aload_0
    //   3232: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   3235: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   3238: invokevirtual toString : ()Ljava/lang/String;
    //   3241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3244: pop
    //   3245: aload #6
    //   3247: astore #10
    //   3249: aload_2
    //   3250: aload #11
    //   3252: invokevirtual toString : ()Ljava/lang/String;
    //   3255: aload_3
    //   3256: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3259: aload #6
    //   3261: astore #10
    //   3263: aload_2
    //   3264: athrow
    //   3265: aload #11
    //   3267: astore #10
    //   3269: aload_0
    //   3270: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   3273: getfield buildMethod : Ljava/lang/reflect/Method;
    //   3276: astore_2
    //   3277: aload_2
    //   3278: ifnonnull -> 3302
    //   3281: aload #4
    //   3283: ifnull -> 3293
    //   3286: aload #4
    //   3288: aload #11
    //   3290: putfield object : Ljava/lang/Object;
    //   3293: aload_1
    //   3294: aload #12
    //   3296: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3299: aload #11
    //   3301: areturn
    //   3302: aload #11
    //   3304: astore #10
    //   3306: aload_2
    //   3307: aload #11
    //   3309: iconst_0
    //   3310: anewarray java/lang/Object
    //   3313: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3316: astore_2
    //   3317: aload #4
    //   3319: ifnull -> 3329
    //   3322: aload #4
    //   3324: aload #11
    //   3326: putfield object : Ljava/lang/Object;
    //   3329: aload_1
    //   3330: aload #12
    //   3332: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3335: aload_2
    //   3336: areturn
    //   3337: astore_2
    //   3338: aload #11
    //   3340: astore #10
    //   3342: new com/alibaba/fastjson/JSONException
    //   3345: astore_3
    //   3346: aload #11
    //   3348: astore #10
    //   3350: aload_3
    //   3351: ldc_w 'build object error'
    //   3354: aload_2
    //   3355: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3358: aload #11
    //   3360: astore #10
    //   3362: aload_3
    //   3363: athrow
    //   3364: astore_2
    //   3365: aload #10
    //   3367: astore_3
    //   3368: goto -> 137
    //   3371: aload #7
    //   3373: invokevirtual token : ()I
    //   3376: bipush #18
    //   3378: if_icmpeq -> 3424
    //   3381: aload #7
    //   3383: invokevirtual token : ()I
    //   3386: iconst_1
    //   3387: if_icmpeq -> 3424
    //   3390: iload #13
    //   3392: istore #5
    //   3394: aload #6
    //   3396: astore #18
    //   3398: aload #4
    //   3400: astore #6
    //   3402: aload #10
    //   3404: astore #4
    //   3406: iinc #5, 1
    //   3409: aload #11
    //   3411: astore #17
    //   3413: aload #18
    //   3415: astore #10
    //   3417: aload #4
    //   3419: astore #11
    //   3421: goto -> 545
    //   3424: new com/alibaba/fastjson/JSONException
    //   3427: astore_2
    //   3428: new java/lang/StringBuilder
    //   3431: astore_3
    //   3432: aload_3
    //   3433: invokespecial <init> : ()V
    //   3436: aload_3
    //   3437: ldc_w 'syntax error, unexpect token '
    //   3440: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3443: pop
    //   3444: aload_3
    //   3445: aload #7
    //   3447: invokevirtual token : ()I
    //   3450: invokestatic name : (I)Ljava/lang/String;
    //   3453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3456: pop
    //   3457: aload_2
    //   3458: aload_3
    //   3459: invokevirtual toString : ()Ljava/lang/String;
    //   3462: invokespecial <init> : (Ljava/lang/String;)V
    //   3465: aload_2
    //   3466: athrow
    //   3467: new com/alibaba/fastjson/JSONException
    //   3470: astore_2
    //   3471: aload_2
    //   3472: ldc_w 'syntax error, unexpect token ':''
    //   3475: invokespecial <init> : (Ljava/lang/String;)V
    //   3478: aload_2
    //   3479: athrow
    //   3480: astore_2
    //   3481: aload #4
    //   3483: astore_3
    //   3484: aload #6
    //   3486: astore #10
    //   3488: goto -> 3505
    //   3491: astore_2
    //   3492: aload #18
    //   3494: astore_3
    //   3495: goto -> 3505
    //   3498: astore_2
    //   3499: aload #4
    //   3501: astore_3
    //   3502: aconst_null
    //   3503: astore #10
    //   3505: aload #10
    //   3507: ifnull -> 3516
    //   3510: aload #10
    //   3512: aload_3
    //   3513: putfield object : Ljava/lang/Object;
    //   3516: aload_1
    //   3517: aload #12
    //   3519: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3522: aload_2
    //   3523: athrow
    //   3524: aload_1
    //   3525: invokevirtual parse : ()Ljava/lang/Object;
    //   3528: areturn
    //   3529: astore #11
    //   3531: goto -> 364
    // Exception table:
    //   from	to	target	type
    //   95	102	129	finally
    //   107	114	129	finally
    //   154	186	129	finally
    //   211	221	129	finally
    //   243	250	129	finally
    //   269	287	129	finally
    //   295	314	129	finally
    //   332	342	129	finally
    //   347	355	3529	java/lang/IllegalArgumentException
    //   347	355	129	finally
    //   377	398	129	finally
    //   406	471	129	finally
    //   471	501	129	finally
    //   501	507	3498	finally
    //   513	518	129	finally
    //   518	527	3498	finally
    //   549	559	3491	finally
    //   563	572	3491	finally
    //   576	583	3491	finally
    //   587	594	3491	finally
    //   598	605	3491	finally
    //   629	636	3491	finally
    //   640	648	3491	finally
    //   662	670	3491	finally
    //   692	701	3491	finally
    //   705	713	3491	finally
    //   720	730	3491	finally
    //   737	745	3491	finally
    //   760	768	3491	finally
    //   783	791	3491	finally
    //   806	814	3491	finally
    //   818	833	3491	finally
    //   842	855	3491	finally
    //   859	867	3491	finally
    //   871	889	3491	finally
    //   893	901	3491	finally
    //   908	918	3491	finally
    //   933	942	3491	finally
    //   946	954	3491	finally
    //   961	971	3491	finally
    //   986	995	3491	finally
    //   999	1007	3491	finally
    //   1014	1024	3491	finally
    //   1039	1048	3491	finally
    //   1052	1060	3491	finally
    //   1067	1077	3491	finally
    //   1084	1094	3491	finally
    //   1107	1119	3491	finally
    //   1123	1131	3491	finally
    //   1138	1148	3491	finally
    //   1155	1167	3491	finally
    //   1171	1179	3491	finally
    //   1186	1196	3491	finally
    //   1203	1215	3491	finally
    //   1219	1227	3491	finally
    //   1234	1244	3491	finally
    //   1251	1263	3491	finally
    //   1267	1275	3491	finally
    //   1282	1292	3491	finally
    //   1299	1311	3491	finally
    //   1315	1323	3491	finally
    //   1336	1346	3491	finally
    //   1375	1386	3491	finally
    //   1395	1402	3491	finally
    //   1413	1420	3491	finally
    //   1434	1445	3491	finally
    //   1465	1471	3491	finally
    //   1475	1482	3491	finally
    //   1492	1499	3491	finally
    //   1503	1514	3491	finally
    //   1518	1524	3491	finally
    //   1534	1545	3491	finally
    //   1549	1556	3491	finally
    //   1560	1568	3491	finally
    //   1572	1578	3491	finally
    //   1585	1589	3491	finally
    //   1593	1601	3491	finally
    //   1605	1610	3491	finally
    //   1614	1619	3491	finally
    //   1629	1640	3491	finally
    //   1647	1654	3491	finally
    //   1658	1663	3491	finally
    //   1670	1677	3491	finally
    //   1681	1686	3491	finally
    //   1693	1698	3491	finally
    //   1702	1710	3491	finally
    //   1714	1720	3491	finally
    //   1724	1729	3491	finally
    //   1736	1740	3491	finally
    //   1744	1752	3491	finally
    //   1756	1761	3491	finally
    //   1765	1770	3491	finally
    //   1774	1781	3491	finally
    //   1785	1795	3491	finally
    //   1799	1806	3491	finally
    //   1810	1820	3491	finally
    //   1845	1849	3491	finally
    //   1853	1860	3491	finally
    //   1864	1866	3491	finally
    //   1870	1874	3491	finally
    //   1878	1882	3491	finally
    //   1886	1890	3491	finally
    //   1894	1902	3491	finally
    //   1906	1916	3491	finally
    //   1920	1928	3491	finally
    //   1932	1934	3491	finally
    //   1943	1953	3491	finally
    //   1963	1971	3491	finally
    //   1978	1984	3491	finally
    //   1988	1997	3491	finally
    //   2001	2008	3491	finally
    //   2012	2019	3491	finally
    //   2023	2038	3491	finally
    //   2042	2052	3491	finally
    //   2059	2073	3491	finally
    //   2082	2095	3491	finally
    //   2099	2109	3491	finally
    //   2122	2133	3491	finally
    //   2137	2144	3491	finally
    //   2148	2153	3491	finally
    //   2162	2174	3491	finally
    //   2198	2208	3491	finally
    //   2212	2217	3491	finally
    //   2247	2251	3491	finally
    //   2255	2261	3491	finally
    //   2265	2267	3491	finally
    //   2295	2303	3491	finally
    //   2308	2323	2326	finally
    //   2337	2348	2326	finally
    //   2357	2371	2374	finally
    //   2439	2450	2453	finally
    //   2465	2480	2453	finally
    //   2488	2537	2453	finally
    //   2540	2549	2453	finally
    //   2554	2561	2453	finally
    //   2582	2589	2453	finally
    //   2598	2630	3480	finally
    //   2636	2646	3480	finally
    //   2646	2656	3480	finally
    //   2659	2676	3480	finally
    //   2710	2718	3364	finally
    //   2726	2736	2739	finally
    //   2769	2778	3364	finally
    //   2782	2787	3364	finally
    //   2791	2798	3364	finally
    //   2819	2832	3364	finally
    //   2842	2849	3364	finally
    //   2853	2861	3364	finally
    //   2865	2870	3364	finally
    //   2877	2885	3364	finally
    //   2889	2894	3364	finally
    //   2901	2909	3364	finally
    //   2913	2918	3364	finally
    //   2925	2933	3364	finally
    //   2937	2942	3364	finally
    //   2949	2957	3364	finally
    //   2961	2966	3364	finally
    //   2973	2981	3364	finally
    //   2985	2990	3364	finally
    //   2999	3007	3364	finally
    //   3011	3015	3364	finally
    //   3031	3039	3364	finally
    //   3047	3060	3066	java/lang/Exception
    //   3047	3060	3364	finally
    //   3071	3076	3364	finally
    //   3080	3084	3364	finally
    //   3088	3092	3364	finally
    //   3096	3104	3364	finally
    //   3108	3123	3364	finally
    //   3127	3137	3364	finally
    //   3141	3144	3364	finally
    //   3148	3156	3364	finally
    //   3168	3182	3185	java/lang/Exception
    //   3168	3182	3364	finally
    //   3190	3194	3364	finally
    //   3198	3203	3364	finally
    //   3207	3212	3364	finally
    //   3216	3225	3364	finally
    //   3229	3245	3364	finally
    //   3249	3259	3364	finally
    //   3263	3265	3364	finally
    //   3269	3277	3364	finally
    //   3306	3317	3337	java/lang/Exception
    //   3306	3317	3364	finally
    //   3342	3346	3364	finally
    //   3350	3358	3364	finally
    //   3362	3364	3364	finally
    //   3371	3390	3480	finally
    //   3424	3467	3480	finally
    //   3467	3480	3480	finally
  }
  
  public <T> T deserialzeArrayMapping(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    paramObject1 = paramDefaultJSONParser.lexer;
    if (paramObject1.token() == 14) {
      paramObject2 = createInstance(paramDefaultJSONParser, paramType);
      byte b = 0;
      int i = this.sortedFieldDeserializers.length;
      while (true) {
        int j = 16;
        if (b < i) {
          byte b1;
          if (b == i - 1) {
            byte b2 = 93;
            b1 = b2;
          } else {
            byte b2 = 44;
            b1 = b2;
          } 
          FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[b];
          paramType = fieldDeserializer.fieldInfo.fieldClass;
          if (paramType == int.class) {
            fieldDeserializer.setValue(paramObject2, paramObject1.scanInt(b1));
          } else if (paramType == String.class) {
            fieldDeserializer.setValue(paramObject2, paramObject1.scanString(b1));
          } else if (paramType == long.class) {
            fieldDeserializer.setValue(paramObject2, paramObject1.scanLong(b1));
          } else {
            Enum<?> enum_;
            if (paramType.isEnum()) {
              j = paramObject1.getCurrent();
              if (j == 34 || j == 110) {
                enum_ = paramObject1.scanEnum((Class)paramType, paramDefaultJSONParser.getSymbolTable(), b1);
              } else if (j >= 48 && j <= 57) {
                j = paramObject1.scanInt(b1);
                enum_ = ((EnumDeserializer)((DefaultFieldDeserializer)fieldDeserializer).getFieldValueDeserilizer(paramDefaultJSONParser.getConfig())).valueOf(j);
              } else {
                enum_ = scanEnum((JSONLexer)paramObject1, b1);
              } 
              fieldDeserializer.setValue(paramObject2, enum_);
            } else if (enum_ == boolean.class) {
              fieldDeserializer.setValue(paramObject2, paramObject1.scanBoolean(b1));
            } else if (enum_ == float.class) {
              fieldDeserializer.setValue(paramObject2, Float.valueOf(paramObject1.scanFloat(b1)));
            } else if (enum_ == double.class) {
              fieldDeserializer.setValue(paramObject2, Double.valueOf(paramObject1.scanDouble(b1)));
            } else if (enum_ == Date.class && paramObject1.getCurrent() == '1') {
              fieldDeserializer.setValue(paramObject2, new Date(paramObject1.scanLong(b1)));
            } else {
              paramObject1.nextToken(14);
              fieldDeserializer.setValue(paramObject2, paramDefaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType));
              if (b1 == 93)
                j = 15; 
              check((JSONLexer)paramObject1, j);
            } 
          } 
          b++;
          continue;
        } 
        paramObject1.nextToken(16);
        return (T)paramObject2;
      } 
    } 
    throw new JSONException("error");
  }
  
  public int getFastMatchToken() {
    return 12;
  }
  
  public FieldDeserializer getFieldDeserializer(String paramString) {
    return getFieldDeserializer(paramString, null);
  }
  
  public FieldDeserializer getFieldDeserializer(String paramString, int[] paramArrayOfint) {
    if (paramString == null)
      return null; 
    int i = 0;
    int j = this.sortedFieldDeserializers.length - 1;
    while (i <= j) {
      int k = i + j >>> 1;
      int m = (this.sortedFieldDeserializers[k]).fieldInfo.name.compareTo(paramString);
      if (m < 0) {
        i = k + 1;
        continue;
      } 
      if (m > 0) {
        j = k - 1;
        continue;
      } 
      return isSetFlag(k, paramArrayOfint) ? null : this.sortedFieldDeserializers[k];
    } 
    return (this.alterNameFieldDeserializers != null) ? this.alterNameFieldDeserializers.get(paramString) : null;
  }
  
  public Type getFieldType(int paramInt) {
    return (this.sortedFieldDeserializers[paramInt]).fieldInfo.fieldType;
  }
  
  protected JavaBeanDeserializer getSeeAlso(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, String paramString) {
    if (paramJavaBeanInfo.jsonType == null)
      return null; 
    Class[] arrayOfClass = paramJavaBeanInfo.jsonType.seeAlso();
    int i = arrayOfClass.length;
    for (byte b = 0; b < i; b++) {
      ObjectDeserializer objectDeserializer = paramParserConfig.getDeserializer(arrayOfClass[b]);
      if (objectDeserializer instanceof JavaBeanDeserializer) {
        JavaBeanDeserializer javaBeanDeserializer2 = (JavaBeanDeserializer)objectDeserializer;
        JavaBeanInfo javaBeanInfo = javaBeanDeserializer2.beanInfo;
        if (javaBeanInfo.typeName.equals(paramString))
          return javaBeanDeserializer2; 
        JavaBeanDeserializer javaBeanDeserializer1 = getSeeAlso(paramParserConfig, javaBeanInfo, paramString);
        if (javaBeanDeserializer1 != null)
          return javaBeanDeserializer1; 
      } 
    } 
    return null;
  }
  
  public boolean parseField(DefaultJSONParser paramDefaultJSONParser, String paramString, Object paramObject, Type paramType, Map<String, Object> paramMap) {
    return parseField(paramDefaultJSONParser, paramString, paramObject, paramType, paramMap, null);
  }
  
  public boolean parseField(DefaultJSONParser paramDefaultJSONParser, String paramString, Object paramObject, Type paramType, Map<String, Object> paramMap, int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_1
    //   1: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: astore #7
    //   6: getstatic com/alibaba/fastjson/parser/Feature.DisableFieldSmartMatch : Lcom/alibaba/fastjson/parser/Feature;
    //   9: getfield mask : I
    //   12: istore #8
    //   14: aload #7
    //   16: iload #8
    //   18: invokeinterface isEnabled : (I)Z
    //   23: ifne -> 54
    //   26: iload #8
    //   28: aload_0
    //   29: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   32: getfield parserFeatures : I
    //   35: iand
    //   36: ifeq -> 42
    //   39: goto -> 54
    //   42: aload_0
    //   43: aload_2
    //   44: aload #6
    //   46: invokevirtual smartMatch : (Ljava/lang/String;[I)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   49: astore #9
    //   51: goto -> 61
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual getFieldDeserializer : (Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   59: astore #9
    //   61: getstatic com/alibaba/fastjson/parser/Feature.SupportNonPublicField : Lcom/alibaba/fastjson/parser/Feature;
    //   64: getfield mask : I
    //   67: istore #8
    //   69: aload #9
    //   71: astore #10
    //   73: aload #9
    //   75: ifnonnull -> 262
    //   78: aload #7
    //   80: iload #8
    //   82: invokeinterface isEnabled : (I)Z
    //   87: ifne -> 107
    //   90: aload #9
    //   92: astore #10
    //   94: iload #8
    //   96: aload_0
    //   97: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   100: getfield parserFeatures : I
    //   103: iand
    //   104: ifeq -> 262
    //   107: aload_0
    //   108: getfield extraFieldDeserializers : Ljava/util/concurrent/ConcurrentMap;
    //   111: ifnonnull -> 226
    //   114: new java/util/concurrent/ConcurrentHashMap
    //   117: dup
    //   118: iconst_1
    //   119: ldc_w 0.75
    //   122: iconst_1
    //   123: invokespecial <init> : (IFI)V
    //   126: astore #11
    //   128: aload_0
    //   129: getfield clazz : Ljava/lang/Class;
    //   132: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   135: astore #10
    //   137: aload #10
    //   139: arraylength
    //   140: istore #12
    //   142: iconst_0
    //   143: istore #8
    //   145: iload #8
    //   147: iload #12
    //   149: if_icmpge -> 220
    //   152: aload #10
    //   154: iload #8
    //   156: aaload
    //   157: astore #13
    //   159: aload #13
    //   161: invokevirtual getName : ()Ljava/lang/String;
    //   164: astore #14
    //   166: aload_0
    //   167: aload #14
    //   169: invokevirtual getFieldDeserializer : (Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   172: ifnull -> 178
    //   175: goto -> 214
    //   178: aload #13
    //   180: invokevirtual getModifiers : ()I
    //   183: istore #15
    //   185: iload #15
    //   187: bipush #16
    //   189: iand
    //   190: ifne -> 214
    //   193: iload #15
    //   195: bipush #8
    //   197: iand
    //   198: ifeq -> 204
    //   201: goto -> 214
    //   204: aload #11
    //   206: aload #14
    //   208: aload #13
    //   210: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: pop
    //   214: iinc #8, 1
    //   217: goto -> 145
    //   220: aload_0
    //   221: aload #11
    //   223: putfield extraFieldDeserializers : Ljava/util/concurrent/ConcurrentMap;
    //   226: aload_0
    //   227: getfield extraFieldDeserializers : Ljava/util/concurrent/ConcurrentMap;
    //   230: aload_2
    //   231: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   236: astore #13
    //   238: aload #9
    //   240: astore #10
    //   242: aload #13
    //   244: ifnull -> 262
    //   247: aload #13
    //   249: instanceof com/alibaba/fastjson/parser/deserializer/FieldDeserializer
    //   252: ifeq -> 265
    //   255: aload #13
    //   257: checkcast com/alibaba/fastjson/parser/deserializer/FieldDeserializer
    //   260: astore #10
    //   262: goto -> 340
    //   265: aload #13
    //   267: checkcast java/lang/reflect/Field
    //   270: astore #9
    //   272: aload #9
    //   274: iconst_1
    //   275: invokevirtual setAccessible : (Z)V
    //   278: new com/alibaba/fastjson/util/FieldInfo
    //   281: dup
    //   282: aload_2
    //   283: aload #9
    //   285: invokevirtual getDeclaringClass : ()Ljava/lang/Class;
    //   288: aload #9
    //   290: invokevirtual getType : ()Ljava/lang/Class;
    //   293: aload #9
    //   295: invokevirtual getGenericType : ()Ljava/lang/reflect/Type;
    //   298: aload #9
    //   300: iconst_0
    //   301: iconst_0
    //   302: iconst_0
    //   303: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Field;III)V
    //   306: astore #9
    //   308: new com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer
    //   311: dup
    //   312: aload_1
    //   313: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   316: aload_0
    //   317: getfield clazz : Ljava/lang/Class;
    //   320: aload #9
    //   322: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParserConfig;Ljava/lang/Class;Lcom/alibaba/fastjson/util/FieldInfo;)V
    //   325: astore #10
    //   327: aload_0
    //   328: getfield extraFieldDeserializers : Ljava/util/concurrent/ConcurrentMap;
    //   331: aload_2
    //   332: aload #10
    //   334: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aload #7
    //   342: astore #9
    //   344: aload #10
    //   346: ifnonnull -> 767
    //   349: aload #9
    //   351: getstatic com/alibaba/fastjson/parser/Feature.IgnoreNotMatch : Lcom/alibaba/fastjson/parser/Feature;
    //   354: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   359: ifeq -> 713
    //   362: aload_0
    //   363: getfield sortedFieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   366: astore #6
    //   368: aload #6
    //   370: arraylength
    //   371: istore #12
    //   373: iconst_0
    //   374: istore #8
    //   376: iload #8
    //   378: iload #12
    //   380: if_icmpge -> 705
    //   383: aload #6
    //   385: iload #8
    //   387: aaload
    //   388: astore #10
    //   390: aload #10
    //   392: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   395: astore #7
    //   397: aload #7
    //   399: getfield unwrapped : Z
    //   402: ifeq -> 699
    //   405: aload #10
    //   407: instanceof com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer
    //   410: ifeq -> 699
    //   413: aload #7
    //   415: getfield field : Ljava/lang/reflect/Field;
    //   418: ifnull -> 636
    //   421: aload #10
    //   423: checkcast com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer
    //   426: astore #11
    //   428: aload #11
    //   430: aload_1
    //   431: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   434: invokevirtual getFieldValueDeserilizer : (Lcom/alibaba/fastjson/parser/ParserConfig;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   437: astore #14
    //   439: aload #14
    //   441: instanceof com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   444: ifeq -> 542
    //   447: aload #14
    //   449: checkcast com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   452: aload_2
    //   453: invokevirtual getFieldDeserializer : (Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   456: astore #13
    //   458: aload #13
    //   460: ifnull -> 699
    //   463: aload #7
    //   465: getfield field : Ljava/lang/reflect/Field;
    //   468: aload_3
    //   469: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   472: astore #6
    //   474: aload #6
    //   476: astore_2
    //   477: aload #6
    //   479: ifnonnull -> 504
    //   482: aload #14
    //   484: checkcast com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   487: aload_1
    //   488: aload #7
    //   490: getfield fieldType : Ljava/lang/reflect/Type;
    //   493: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   496: astore_2
    //   497: aload #10
    //   499: aload_3
    //   500: aload_2
    //   501: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   504: aload #9
    //   506: aload #11
    //   508: invokevirtual getFastMatchToken : ()I
    //   511: invokeinterface nextTokenWithColon : (I)V
    //   516: aload #13
    //   518: aload_1
    //   519: aload_2
    //   520: aload #4
    //   522: aload #5
    //   524: invokevirtual parseField : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)V
    //   527: iconst_1
    //   528: ireturn
    //   529: astore_1
    //   530: new com/alibaba/fastjson/JSONException
    //   533: dup
    //   534: ldc_w 'parse unwrapped field error.'
    //   537: aload_1
    //   538: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   541: athrow
    //   542: aload #14
    //   544: instanceof com/alibaba/fastjson/parser/deserializer/MapDeserializer
    //   547: ifeq -> 699
    //   550: aload #14
    //   552: checkcast com/alibaba/fastjson/parser/deserializer/MapDeserializer
    //   555: astore #6
    //   557: aload #7
    //   559: getfield field : Ljava/lang/reflect/Field;
    //   562: aload_3
    //   563: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   566: checkcast java/util/Map
    //   569: astore #5
    //   571: aload #5
    //   573: astore #4
    //   575: aload #5
    //   577: ifnonnull -> 600
    //   580: aload #6
    //   582: aload #7
    //   584: getfield fieldType : Ljava/lang/reflect/Type;
    //   587: invokevirtual createMap : (Ljava/lang/reflect/Type;)Ljava/util/Map;
    //   590: astore #4
    //   592: aload #10
    //   594: aload_3
    //   595: aload #4
    //   597: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   600: aload #9
    //   602: invokeinterface nextTokenWithColon : ()V
    //   607: aload #4
    //   609: aload_2
    //   610: aload_1
    //   611: aload_2
    //   612: invokevirtual parse : (Ljava/lang/Object;)Ljava/lang/Object;
    //   615: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   620: pop
    //   621: iconst_1
    //   622: ireturn
    //   623: astore_1
    //   624: new com/alibaba/fastjson/JSONException
    //   627: dup
    //   628: ldc_w 'parse unwrapped field error.'
    //   631: aload_1
    //   632: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   635: athrow
    //   636: aload #7
    //   638: getfield method : Ljava/lang/reflect/Method;
    //   641: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   644: arraylength
    //   645: iconst_2
    //   646: if_icmpne -> 699
    //   649: aload #9
    //   651: invokeinterface nextTokenWithColon : ()V
    //   656: aload_1
    //   657: aload_2
    //   658: invokevirtual parse : (Ljava/lang/Object;)Ljava/lang/Object;
    //   661: astore_1
    //   662: aload #7
    //   664: getfield method : Ljava/lang/reflect/Method;
    //   667: aload_3
    //   668: iconst_2
    //   669: anewarray java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: aload_2
    //   675: aastore
    //   676: dup
    //   677: iconst_1
    //   678: aload_1
    //   679: aastore
    //   680: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   683: pop
    //   684: iconst_1
    //   685: ireturn
    //   686: astore_1
    //   687: new com/alibaba/fastjson/JSONException
    //   690: dup
    //   691: ldc_w 'parse unwrapped field error.'
    //   694: aload_1
    //   695: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   698: athrow
    //   699: iinc #8, 1
    //   702: goto -> 376
    //   705: aload_1
    //   706: aload_3
    //   707: aload_2
    //   708: invokevirtual parseExtra : (Ljava/lang/Object;Ljava/lang/String;)V
    //   711: iconst_0
    //   712: ireturn
    //   713: new java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial <init> : ()V
    //   720: astore_1
    //   721: aload_1
    //   722: ldc_w 'setter not found, class '
    //   725: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload_1
    //   730: aload_0
    //   731: getfield clazz : Ljava/lang/Class;
    //   734: invokevirtual getName : ()Ljava/lang/String;
    //   737: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload_1
    //   742: ldc_w ', property '
    //   745: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload_1
    //   750: aload_2
    //   751: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: new com/alibaba/fastjson/JSONException
    //   758: dup
    //   759: aload_1
    //   760: invokevirtual toString : ()Ljava/lang/String;
    //   763: invokespecial <init> : (Ljava/lang/String;)V
    //   766: athrow
    //   767: iconst_0
    //   768: istore #8
    //   770: iload #8
    //   772: aload_0
    //   773: getfield sortedFieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   776: arraylength
    //   777: if_icmpge -> 801
    //   780: aload_0
    //   781: getfield sortedFieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   784: iload #8
    //   786: aaload
    //   787: aload #10
    //   789: if_acmpne -> 795
    //   792: goto -> 804
    //   795: iinc #8, 1
    //   798: goto -> 770
    //   801: iconst_m1
    //   802: istore #8
    //   804: iload #8
    //   806: iconst_m1
    //   807: if_icmpeq -> 843
    //   810: aload #6
    //   812: ifnull -> 843
    //   815: aload_2
    //   816: ldc_w '_'
    //   819: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   822: ifeq -> 843
    //   825: iload #8
    //   827: aload #6
    //   829: invokestatic isSetFlag : (I[I)Z
    //   832: ifeq -> 843
    //   835: aload_1
    //   836: aload_3
    //   837: aload_2
    //   838: invokevirtual parseExtra : (Ljava/lang/Object;Ljava/lang/String;)V
    //   841: iconst_0
    //   842: ireturn
    //   843: aload #9
    //   845: aload #10
    //   847: invokevirtual getFastMatchToken : ()I
    //   850: invokeinterface nextTokenWithColon : (I)V
    //   855: aload #10
    //   857: aload_1
    //   858: aload_3
    //   859: aload #4
    //   861: aload #5
    //   863: invokevirtual parseField : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)V
    //   866: iconst_1
    //   867: ireturn
    // Exception table:
    //   from	to	target	type
    //   463	474	529	java/lang/Exception
    //   482	504	529	java/lang/Exception
    //   504	527	529	java/lang/Exception
    //   557	571	623	java/lang/Exception
    //   580	600	623	java/lang/Exception
    //   600	621	623	java/lang/Exception
    //   662	684	686	java/lang/Exception
  }
  
  protected Object parseRest(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2, int paramInt) {
    return parseRest(paramDefaultJSONParser, paramType, paramObject1, paramObject2, paramInt, new int[0]);
  }
  
  protected Object parseRest(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2, int paramInt, int[] paramArrayOfint) {
    return deserialze(paramDefaultJSONParser, paramType, paramObject1, paramObject2, paramInt, paramArrayOfint);
  }
  
  protected Enum<?> scanEnum(JSONLexer paramJSONLexer, char paramChar) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("illegal enum. ");
    stringBuilder.append(paramJSONLexer.info());
    throw new JSONException(stringBuilder.toString());
  }
  
  protected Enum scanEnum(JSONLexerBase paramJSONLexerBase, char[] paramArrayOfchar, ObjectDeserializer paramObjectDeserializer) {
    if (paramObjectDeserializer instanceof EnumDeserializer) {
      paramObjectDeserializer = paramObjectDeserializer;
    } else {
      paramObjectDeserializer = null;
    } 
    if (paramObjectDeserializer == null) {
      paramJSONLexerBase.matchStat = -1;
      return null;
    } 
    long l = paramJSONLexerBase.scanFieldSymbol(paramArrayOfchar);
    return (paramJSONLexerBase.matchStat > 0) ? paramObjectDeserializer.getEnumByHashCode(l) : null;
  }
  
  public FieldDeserializer smartMatch(String paramString) {
    return smartMatch(paramString, null);
  }
  
  public FieldDeserializer smartMatch(String paramString, int[] paramArrayOfint) {
    String str = null;
    if (paramString == null)
      return null; 
    FieldDeserializer fieldDeserializer1 = getFieldDeserializer(paramString, paramArrayOfint);
    boolean bool = false;
    FieldDeserializer fieldDeserializer2 = fieldDeserializer1;
    if (fieldDeserializer1 == null) {
      boolean bool1 = paramString.startsWith("is");
      byte b = 0;
      while (true) {
        fieldDeserializer2 = fieldDeserializer1;
        if (b < this.sortedFieldDeserializers.length) {
          if (!isSetFlag(b, paramArrayOfint)) {
            fieldDeserializer2 = this.sortedFieldDeserializers[b];
            FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
            if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0)
              return null; 
            Class<boolean> clazz = fieldInfo.fieldClass;
            String str1 = fieldInfo.name;
            if (str1.equalsIgnoreCase(paramString) || (bool1 && (clazz == boolean.class || clazz == Boolean.class) && str1.equalsIgnoreCase(paramString.substring(2))))
              break; 
          } 
          b++;
          continue;
        } 
        break;
      } 
    } 
    fieldDeserializer1 = fieldDeserializer2;
    if (fieldDeserializer2 == null) {
      byte b = 0;
      while (true) {
        int i = paramString.length();
        boolean bool1 = true;
        if (b < i) {
          i = paramString.charAt(b);
          if (i == 95) {
            paramString = paramString.replaceAll("_", "");
            b = bool1;
            break;
          } 
          if (i == 45) {
            paramString = paramString.replaceAll("-", "");
            b = bool1;
            break;
          } 
          b++;
          continue;
        } 
        b = 0;
        paramString = str;
        break;
      } 
      fieldDeserializer1 = fieldDeserializer2;
      if (b != 0) {
        fieldDeserializer2 = getFieldDeserializer(paramString, paramArrayOfint);
        fieldDeserializer1 = fieldDeserializer2;
        if (fieldDeserializer2 == null) {
          b = bool;
          while (true) {
            fieldDeserializer1 = fieldDeserializer2;
            if (b < this.sortedFieldDeserializers.length) {
              if (!isSetFlag(b, paramArrayOfint)) {
                fieldDeserializer1 = this.sortedFieldDeserializers[b];
                if (fieldDeserializer1.fieldInfo.name.equalsIgnoreCase(paramString))
                  break; 
              } 
              b++;
              continue;
            } 
            break;
          } 
        } 
      } 
    } 
    return fieldDeserializer1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\JavaBeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */