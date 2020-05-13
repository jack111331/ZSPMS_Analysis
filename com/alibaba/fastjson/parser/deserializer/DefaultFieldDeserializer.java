package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Type;
import java.util.Map;

public class DefaultFieldDeserializer extends FieldDeserializer {
  protected ObjectDeserializer fieldValueDeserilizer;
  
  public DefaultFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo) {
    super(paramClass, paramFieldInfo);
  }
  
  public int getFastMatchToken() {
    return (this.fieldValueDeserilizer != null) ? this.fieldValueDeserilizer.getFastMatchToken() : 2;
  }
  
  public ObjectDeserializer getFieldValueDeserilizer(ParserConfig paramParserConfig) {
    if (this.fieldValueDeserilizer == null) {
      JSONField jSONField = this.fieldInfo.getAnnotation();
      if (jSONField != null && jSONField.deserializeUsing() != Void.class) {
        Class<ObjectDeserializer> clazz = jSONField.deserializeUsing();
        try {
          this.fieldValueDeserilizer = clazz.newInstance();
        } catch (Exception exception) {
          throw new JSONException("create deserializeUsing ObjectDeserializer error", exception);
        } 
      } else {
        this.fieldValueDeserilizer = exception.getDeserializer(this.fieldInfo.fieldClass, this.fieldInfo.fieldType);
      } 
    } 
    return this.fieldValueDeserilizer;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {
    // Byte code:
    //   0: aload_0
    //   1: getfield fieldValueDeserilizer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   4: ifnonnull -> 16
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   12: invokevirtual getFieldValueDeserilizer : (Lcom/alibaba/fastjson/parser/ParserConfig;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   15: pop
    //   16: aload_0
    //   17: getfield fieldValueDeserilizer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   20: astore #5
    //   22: aload_0
    //   23: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   26: getfield fieldType : Ljava/lang/reflect/Type;
    //   29: astore #6
    //   31: aload #6
    //   33: astore #7
    //   35: aload_3
    //   36: instanceof java/lang/reflect/ParameterizedType
    //   39: ifeq -> 82
    //   42: aload_1
    //   43: invokevirtual getContext : ()Lcom/alibaba/fastjson/parser/ParseContext;
    //   46: astore #7
    //   48: aload #7
    //   50: ifnull -> 59
    //   53: aload #7
    //   55: aload_3
    //   56: putfield type : Ljava/lang/reflect/Type;
    //   59: aload_0
    //   60: getfield clazz : Ljava/lang/Class;
    //   63: aload_3
    //   64: aload #6
    //   66: invokestatic getFieldType : (Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;
    //   69: astore #7
    //   71: aload_1
    //   72: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   75: aload #7
    //   77: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   80: astore #5
    //   82: aload #5
    //   84: instanceof com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   87: ifeq -> 129
    //   90: aload_0
    //   91: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   94: getfield parserFeatures : I
    //   97: ifeq -> 129
    //   100: aload #5
    //   102: checkcast com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   105: aload_1
    //   106: aload #7
    //   108: aload_0
    //   109: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   112: getfield name : Ljava/lang/String;
    //   115: aload_0
    //   116: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   119: getfield parserFeatures : I
    //   122: invokevirtual deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;
    //   125: astore_3
    //   126: goto -> 201
    //   129: aload_0
    //   130: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   133: getfield format : Ljava/lang/String;
    //   136: ifnull -> 183
    //   139: aload #5
    //   141: instanceof com/alibaba/fastjson/parser/deserializer/ContextObjectDeserializer
    //   144: ifeq -> 183
    //   147: aload #5
    //   149: checkcast com/alibaba/fastjson/parser/deserializer/ContextObjectDeserializer
    //   152: aload_1
    //   153: aload #7
    //   155: aload_0
    //   156: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   159: getfield name : Ljava/lang/String;
    //   162: aload_0
    //   163: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   166: getfield format : Ljava/lang/String;
    //   169: aload_0
    //   170: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   173: getfield parserFeatures : I
    //   176: invokevirtual deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/String;I)Ljava/lang/Object;
    //   179: astore_3
    //   180: goto -> 201
    //   183: aload #5
    //   185: aload_1
    //   186: aload #7
    //   188: aload_0
    //   189: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   192: getfield name : Ljava/lang/String;
    //   195: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: astore_3
    //   201: aload_3
    //   202: astore #7
    //   204: aload_3
    //   205: instanceof [B
    //   208: ifeq -> 343
    //   211: ldc 'gzip'
    //   213: aload_0
    //   214: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   217: getfield format : Ljava/lang/String;
    //   220: invokevirtual equals : (Ljava/lang/Object;)Z
    //   223: ifne -> 244
    //   226: aload_3
    //   227: astore #7
    //   229: ldc 'gzip,base64'
    //   231: aload_0
    //   232: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   235: getfield format : Ljava/lang/String;
    //   238: invokevirtual equals : (Ljava/lang/Object;)Z
    //   241: ifeq -> 343
    //   244: aload_3
    //   245: checkcast [B
    //   248: astore #5
    //   250: new java/util/zip/GZIPInputStream
    //   253: astore_3
    //   254: new java/io/ByteArrayInputStream
    //   257: astore #7
    //   259: aload #7
    //   261: aload #5
    //   263: invokespecial <init> : ([B)V
    //   266: aload_3
    //   267: aload #7
    //   269: invokespecial <init> : (Ljava/io/InputStream;)V
    //   272: new java/io/ByteArrayOutputStream
    //   275: astore #7
    //   277: aload #7
    //   279: invokespecial <init> : ()V
    //   282: sipush #1024
    //   285: newarray byte
    //   287: astore #5
    //   289: aload_3
    //   290: aload #5
    //   292: invokevirtual read : ([B)I
    //   295: istore #8
    //   297: iload #8
    //   299: iconst_m1
    //   300: if_icmpne -> 313
    //   303: aload #7
    //   305: invokevirtual toByteArray : ()[B
    //   308: astore #7
    //   310: goto -> 343
    //   313: iload #8
    //   315: ifle -> 282
    //   318: aload #7
    //   320: aload #5
    //   322: iconst_0
    //   323: iload #8
    //   325: invokevirtual write : ([BII)V
    //   328: goto -> 282
    //   331: astore_1
    //   332: new com/alibaba/fastjson/JSONException
    //   335: dup
    //   336: ldc 'unzip bytes error.'
    //   338: aload_1
    //   339: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   342: athrow
    //   343: aload_1
    //   344: invokevirtual getResolveStatus : ()I
    //   347: iconst_1
    //   348: if_icmpne -> 377
    //   351: aload_1
    //   352: invokevirtual getLastResolveTask : ()Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
    //   355: astore_2
    //   356: aload_2
    //   357: aload_0
    //   358: putfield fieldDeserializer : Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   361: aload_2
    //   362: aload_1
    //   363: invokevirtual getContext : ()Lcom/alibaba/fastjson/parser/ParseContext;
    //   366: putfield ownerContext : Lcom/alibaba/fastjson/parser/ParseContext;
    //   369: aload_1
    //   370: iconst_0
    //   371: invokevirtual setResolveStatus : (I)V
    //   374: goto -> 408
    //   377: aload_2
    //   378: ifnonnull -> 401
    //   381: aload #4
    //   383: aload_0
    //   384: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   387: getfield name : Ljava/lang/String;
    //   390: aload #7
    //   392: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   397: pop
    //   398: goto -> 408
    //   401: aload_0
    //   402: aload_2
    //   403: aload #7
    //   405: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   408: return
    // Exception table:
    //   from	to	target	type
    //   250	282	331	java/io/IOException
    //   282	297	331	java/io/IOException
    //   303	310	331	java/io/IOException
    //   318	328	331	java/io/IOException
  }
  
  public void parseFieldUnwrapped(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {
    throw new JSONException("TODO");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\DefaultFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */