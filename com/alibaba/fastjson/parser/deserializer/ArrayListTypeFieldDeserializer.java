package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
  private ObjectDeserializer deserializer;
  
  private int itemFastMatchToken;
  
  private final Type itemType;
  
  public ArrayListTypeFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo) {
    super(paramClass, paramFieldInfo);
    if (paramFieldInfo.fieldType instanceof ParameterizedType) {
      Type type2 = ((ParameterizedType)paramFieldInfo.fieldType).getActualTypeArguments()[0];
      Type type1 = type2;
      if (type2 instanceof WildcardType) {
        Type[] arrayOfType = ((WildcardType)type2).getUpperBounds();
        type1 = type2;
        if (arrayOfType.length == 1)
          type1 = arrayOfType[0]; 
      } 
      this.itemType = type1;
    } else {
      this.itemType = Object.class;
    } 
  }
  
  public int getFastMatchToken() {
    return 14;
  }
  
  public final void parseArray(DefaultJSONParser paramDefaultJSONParser, Type paramType, Collection paramCollection) {
    // Byte code:
    //   0: aload_0
    //   1: getfield itemType : Ljava/lang/reflect/Type;
    //   4: astore #4
    //   6: aload_0
    //   7: getfield deserializer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   10: astore #5
    //   12: aload_2
    //   13: instanceof java/lang/reflect/ParameterizedType
    //   16: istore #6
    //   18: iconst_0
    //   19: istore #7
    //   21: aload #4
    //   23: astore #8
    //   25: aload #5
    //   27: astore #9
    //   29: iload #6
    //   31: ifeq -> 431
    //   34: aload #4
    //   36: instanceof java/lang/reflect/TypeVariable
    //   39: istore #6
    //   41: aconst_null
    //   42: astore #10
    //   44: aconst_null
    //   45: astore #9
    //   47: iload #6
    //   49: ifeq -> 209
    //   52: aload #4
    //   54: checkcast java/lang/reflect/TypeVariable
    //   57: astore #8
    //   59: aload_2
    //   60: checkcast java/lang/reflect/ParameterizedType
    //   63: astore #10
    //   65: aload #9
    //   67: astore_2
    //   68: aload #10
    //   70: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   75: instanceof java/lang/Class
    //   78: ifeq -> 92
    //   81: aload #10
    //   83: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   88: checkcast java/lang/Class
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull -> 147
    //   96: aload_2
    //   97: invokevirtual getTypeParameters : ()[Ljava/lang/reflect/TypeVariable;
    //   100: arraylength
    //   101: istore #11
    //   103: iconst_0
    //   104: istore #12
    //   106: iload #12
    //   108: iload #11
    //   110: if_icmpge -> 147
    //   113: aload_2
    //   114: invokevirtual getTypeParameters : ()[Ljava/lang/reflect/TypeVariable;
    //   117: iload #12
    //   119: aaload
    //   120: invokeinterface getName : ()Ljava/lang/String;
    //   125: aload #8
    //   127: invokeinterface getName : ()Ljava/lang/String;
    //   132: invokevirtual equals : (Ljava/lang/Object;)Z
    //   135: ifeq -> 141
    //   138: goto -> 150
    //   141: iinc #12, 1
    //   144: goto -> 106
    //   147: iconst_m1
    //   148: istore #12
    //   150: aload #4
    //   152: astore #8
    //   154: aload #5
    //   156: astore #9
    //   158: iload #12
    //   160: iconst_m1
    //   161: if_icmpeq -> 431
    //   164: aload #10
    //   166: invokeinterface getActualTypeArguments : ()[Ljava/lang/reflect/Type;
    //   171: iload #12
    //   173: aaload
    //   174: astore_2
    //   175: aload_2
    //   176: astore #8
    //   178: aload #5
    //   180: astore #9
    //   182: aload_2
    //   183: aload_0
    //   184: getfield itemType : Ljava/lang/reflect/Type;
    //   187: invokevirtual equals : (Ljava/lang/Object;)Z
    //   190: ifne -> 431
    //   193: aload_1
    //   194: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   197: aload_2
    //   198: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   201: astore #9
    //   203: aload_2
    //   204: astore #8
    //   206: goto -> 431
    //   209: aload #4
    //   211: astore #8
    //   213: aload #5
    //   215: astore #9
    //   217: aload #4
    //   219: instanceof java/lang/reflect/ParameterizedType
    //   222: ifeq -> 431
    //   225: aload #4
    //   227: checkcast java/lang/reflect/ParameterizedType
    //   230: astore #13
    //   232: aload #13
    //   234: invokeinterface getActualTypeArguments : ()[Ljava/lang/reflect/Type;
    //   239: astore #14
    //   241: aload #4
    //   243: astore #8
    //   245: aload #5
    //   247: astore #9
    //   249: aload #14
    //   251: arraylength
    //   252: iconst_1
    //   253: if_icmpne -> 431
    //   256: aload #4
    //   258: astore #8
    //   260: aload #5
    //   262: astore #9
    //   264: aload #14
    //   266: iconst_0
    //   267: aaload
    //   268: instanceof java/lang/reflect/TypeVariable
    //   271: ifeq -> 431
    //   274: aload #14
    //   276: iconst_0
    //   277: aaload
    //   278: checkcast java/lang/reflect/TypeVariable
    //   281: astore #9
    //   283: aload_2
    //   284: checkcast java/lang/reflect/ParameterizedType
    //   287: astore #15
    //   289: aload #10
    //   291: astore_2
    //   292: aload #15
    //   294: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   299: instanceof java/lang/Class
    //   302: ifeq -> 316
    //   305: aload #15
    //   307: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   312: checkcast java/lang/Class
    //   315: astore_2
    //   316: aload_2
    //   317: ifnull -> 371
    //   320: aload_2
    //   321: invokevirtual getTypeParameters : ()[Ljava/lang/reflect/TypeVariable;
    //   324: arraylength
    //   325: istore #11
    //   327: iconst_0
    //   328: istore #12
    //   330: iload #12
    //   332: iload #11
    //   334: if_icmpge -> 371
    //   337: aload_2
    //   338: invokevirtual getTypeParameters : ()[Ljava/lang/reflect/TypeVariable;
    //   341: iload #12
    //   343: aaload
    //   344: invokeinterface getName : ()Ljava/lang/String;
    //   349: aload #9
    //   351: invokeinterface getName : ()Ljava/lang/String;
    //   356: invokevirtual equals : (Ljava/lang/Object;)Z
    //   359: ifeq -> 365
    //   362: goto -> 374
    //   365: iinc #12, 1
    //   368: goto -> 330
    //   371: iconst_m1
    //   372: istore #12
    //   374: aload #4
    //   376: astore #8
    //   378: aload #5
    //   380: astore #9
    //   382: iload #12
    //   384: iconst_m1
    //   385: if_icmpeq -> 431
    //   388: aload #14
    //   390: iconst_0
    //   391: aload #15
    //   393: invokeinterface getActualTypeArguments : ()[Ljava/lang/reflect/Type;
    //   398: iload #12
    //   400: aaload
    //   401: aastore
    //   402: new com/alibaba/fastjson/util/ParameterizedTypeImpl
    //   405: dup
    //   406: aload #14
    //   408: aload #13
    //   410: invokeinterface getOwnerType : ()Ljava/lang/reflect/Type;
    //   415: aload #13
    //   417: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   422: invokespecial <init> : ([Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V
    //   425: astore #8
    //   427: aload #5
    //   429: astore #9
    //   431: aload_1
    //   432: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   435: astore #5
    //   437: aload #5
    //   439: invokeinterface token : ()I
    //   444: bipush #14
    //   446: if_icmpne -> 614
    //   449: aload #9
    //   451: astore_2
    //   452: aload #9
    //   454: ifnonnull -> 485
    //   457: aload_1
    //   458: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   461: aload #8
    //   463: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   466: astore_2
    //   467: aload_0
    //   468: aload_2
    //   469: putfield deserializer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   472: aload_0
    //   473: aload_0
    //   474: getfield deserializer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   477: invokeinterface getFastMatchToken : ()I
    //   482: putfield itemFastMatchToken : I
    //   485: aload #5
    //   487: aload_0
    //   488: getfield itemFastMatchToken : I
    //   491: invokeinterface nextToken : (I)V
    //   496: iload #7
    //   498: istore #12
    //   500: aload #5
    //   502: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   505: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   510: ifeq -> 535
    //   513: aload #5
    //   515: invokeinterface token : ()I
    //   520: bipush #16
    //   522: if_icmpne -> 535
    //   525: aload #5
    //   527: invokeinterface nextToken : ()V
    //   532: goto -> 513
    //   535: aload #5
    //   537: invokeinterface token : ()I
    //   542: bipush #15
    //   544: if_icmpne -> 559
    //   547: aload #5
    //   549: bipush #16
    //   551: invokeinterface nextToken : (I)V
    //   556: goto -> 662
    //   559: aload_3
    //   560: aload_2
    //   561: aload_1
    //   562: aload #8
    //   564: iload #12
    //   566: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   569: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   574: invokeinterface add : (Ljava/lang/Object;)Z
    //   579: pop
    //   580: aload_1
    //   581: aload_3
    //   582: invokevirtual checkListResolve : (Ljava/util/Collection;)V
    //   585: aload #5
    //   587: invokeinterface token : ()I
    //   592: bipush #16
    //   594: if_icmpne -> 608
    //   597: aload #5
    //   599: aload_0
    //   600: getfield itemFastMatchToken : I
    //   603: invokeinterface nextToken : (I)V
    //   608: iinc #12, 1
    //   611: goto -> 500
    //   614: aload #9
    //   616: astore_2
    //   617: aload #9
    //   619: ifnonnull -> 637
    //   622: aload_1
    //   623: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   626: aload #8
    //   628: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   631: astore_2
    //   632: aload_0
    //   633: aload_2
    //   634: putfield deserializer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   637: aload_3
    //   638: aload_2
    //   639: aload_1
    //   640: aload #8
    //   642: iconst_0
    //   643: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   646: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   651: invokeinterface add : (Ljava/lang/Object;)Z
    //   656: pop
    //   657: aload_1
    //   658: aload_3
    //   659: invokevirtual checkListResolve : (Ljava/util/Collection;)V
    //   662: return
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = jSONLexer.token();
    if (i == 8 || (i == 4 && jSONLexer.stringVal().length() == 0)) {
      setValue(paramObject, (String)null);
      return;
    } 
    ArrayList arrayList = new ArrayList();
    ParseContext parseContext = paramDefaultJSONParser.getContext();
    paramDefaultJSONParser.setContext(parseContext, paramObject, this.fieldInfo.name);
    parseArray(paramDefaultJSONParser, paramType, arrayList);
    paramDefaultJSONParser.setContext(parseContext);
    if (paramObject == null) {
      paramMap.put(this.fieldInfo.name, arrayList);
    } else {
      setValue(paramObject, arrayList);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ArrayListTypeFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */