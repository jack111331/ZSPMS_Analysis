package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ThrowableDeserializer extends JavaBeanDeserializer {
  public ThrowableDeserializer(ParserConfig paramParserConfig, Class<?> paramClass) {
    super(paramParserConfig, paramClass, paramClass);
  }
  
  private Throwable createException(String paramString, Throwable paramThrowable, Class<?> paramClass) throws Exception {
    Constructor<Throwable> constructor;
    Constructor[] arrayOfConstructor = (Constructor[])paramClass.getConstructors();
    int i = arrayOfConstructor.length;
    Class clazz = null;
    paramClass = clazz;
    Class<?> clazz1 = paramClass;
    byte b = 0;
    Class<?> clazz2 = paramClass;
    while (b < i) {
      Constructor<Throwable> constructor2;
      Class<?> clazz3;
      Class<?> clazz4;
      Constructor<Throwable> constructor1 = arrayOfConstructor[b];
      Class[] arrayOfClass = constructor1.getParameterTypes();
      if (arrayOfClass.length == 0) {
        Class clazz5 = clazz;
        clazz3 = clazz2;
        Constructor<Throwable> constructor3 = constructor1;
      } else if (arrayOfClass.length == 1 && arrayOfClass[0] == String.class) {
        Class clazz5 = clazz;
        Constructor<Throwable> constructor3 = constructor1;
        clazz4 = clazz1;
      } else {
        Class clazz5 = clazz;
        clazz3 = clazz2;
        clazz4 = clazz1;
        if (arrayOfClass.length == 2) {
          clazz5 = clazz;
          clazz3 = clazz2;
          clazz4 = clazz1;
          if (arrayOfClass[0] == String.class) {
            clazz5 = clazz;
            clazz3 = clazz2;
            clazz4 = clazz1;
            if (arrayOfClass[1] == Throwable.class) {
              clazz4 = clazz1;
              clazz3 = clazz2;
              constructor2 = constructor1;
            } 
          } 
        } 
      } 
      b++;
      constructor = constructor2;
      clazz2 = clazz3;
      clazz1 = clazz4;
    } 
    return (constructor != null) ? constructor.newInstance(new Object[] { paramString, paramThrowable }) : ((clazz2 != null) ? (Throwable)clazz2.newInstance(new Object[] { paramString }) : ((clazz1 != null) ? (Throwable)clazz1.newInstance(new Object[0]) : null));
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: astore #4
    //   6: aload #4
    //   8: invokeinterface token : ()I
    //   13: bipush #8
    //   15: if_icmpne -> 27
    //   18: aload #4
    //   20: invokeinterface nextToken : ()V
    //   25: aconst_null
    //   26: areturn
    //   27: aload_1
    //   28: invokevirtual getResolveStatus : ()I
    //   31: iconst_2
    //   32: if_icmpne -> 43
    //   35: aload_1
    //   36: iconst_0
    //   37: invokevirtual setResolveStatus : (I)V
    //   40: goto -> 55
    //   43: aload #4
    //   45: invokeinterface token : ()I
    //   50: bipush #12
    //   52: if_icmpne -> 678
    //   55: aload_2
    //   56: ifnull -> 83
    //   59: aload_2
    //   60: instanceof java/lang/Class
    //   63: ifeq -> 83
    //   66: aload_2
    //   67: checkcast java/lang/Class
    //   70: astore_2
    //   71: ldc java/lang/Throwable
    //   73: aload_2
    //   74: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   77: ifeq -> 83
    //   80: goto -> 85
    //   83: aconst_null
    //   84: astore_2
    //   85: new java/util/HashMap
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore #5
    //   94: aload_2
    //   95: astore #6
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_2
    //   100: astore #7
    //   102: aload #7
    //   104: astore_3
    //   105: aload #4
    //   107: aload_1
    //   108: invokevirtual getSymbolTable : ()Lcom/alibaba/fastjson/parser/SymbolTable;
    //   111: invokeinterface scanSymbol : (Lcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   116: astore #8
    //   118: aload #8
    //   120: ifnonnull -> 175
    //   123: aload #4
    //   125: invokeinterface token : ()I
    //   130: bipush #13
    //   132: if_icmpne -> 147
    //   135: aload #4
    //   137: bipush #16
    //   139: invokeinterface nextToken : (I)V
    //   144: goto -> 486
    //   147: aload #4
    //   149: invokeinterface token : ()I
    //   154: bipush #16
    //   156: if_icmpne -> 175
    //   159: aload #4
    //   161: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   164: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   169: ifeq -> 175
    //   172: goto -> 105
    //   175: aload #4
    //   177: iconst_4
    //   178: invokeinterface nextTokenWithColon : (I)V
    //   183: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   186: aload #8
    //   188: invokevirtual equals : (Ljava/lang/Object;)Z
    //   191: ifeq -> 259
    //   194: aload #4
    //   196: invokeinterface token : ()I
    //   201: iconst_4
    //   202: if_icmpne -> 249
    //   205: aload #4
    //   207: invokeinterface stringVal : ()Ljava/lang/String;
    //   212: astore #6
    //   214: aload_1
    //   215: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   218: aload #6
    //   220: ldc java/lang/Throwable
    //   222: invokevirtual checkAutoType : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Class;
    //   225: astore #8
    //   227: aload #4
    //   229: bipush #16
    //   231: invokeinterface nextToken : (I)V
    //   236: aload #7
    //   238: astore #9
    //   240: aload_3
    //   241: astore #10
    //   243: aload_2
    //   244: astore #11
    //   246: goto -> 437
    //   249: new com/alibaba/fastjson/JSONException
    //   252: dup
    //   253: ldc 'syntax error'
    //   255: invokespecial <init> : (Ljava/lang/String;)V
    //   258: athrow
    //   259: ldc 'message'
    //   261: aload #8
    //   263: invokevirtual equals : (Ljava/lang/Object;)Z
    //   266: ifeq -> 337
    //   269: aload #4
    //   271: invokeinterface token : ()I
    //   276: bipush #8
    //   278: if_icmpne -> 287
    //   281: aconst_null
    //   282: astore #9
    //   284: goto -> 307
    //   287: aload #4
    //   289: invokeinterface token : ()I
    //   294: iconst_4
    //   295: if_icmpne -> 327
    //   298: aload #4
    //   300: invokeinterface stringVal : ()Ljava/lang/String;
    //   305: astore #9
    //   307: aload #4
    //   309: invokeinterface nextToken : ()V
    //   314: aload #6
    //   316: astore #8
    //   318: aload_3
    //   319: astore #10
    //   321: aload_2
    //   322: astore #11
    //   324: goto -> 437
    //   327: new com/alibaba/fastjson/JSONException
    //   330: dup
    //   331: ldc 'syntax error'
    //   333: invokespecial <init> : (Ljava/lang/String;)V
    //   336: athrow
    //   337: ldc 'cause'
    //   339: aload #8
    //   341: invokevirtual equals : (Ljava/lang/Object;)Z
    //   344: ifeq -> 374
    //   347: aload_0
    //   348: aload_1
    //   349: aconst_null
    //   350: ldc 'cause'
    //   352: invokevirtual deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast java/lang/Throwable
    //   358: astore #11
    //   360: aload #6
    //   362: astore #8
    //   364: aload #7
    //   366: astore #9
    //   368: aload_3
    //   369: astore #10
    //   371: goto -> 437
    //   374: ldc 'stackTrace'
    //   376: aload #8
    //   378: invokevirtual equals : (Ljava/lang/Object;)Z
    //   381: ifeq -> 409
    //   384: aload_1
    //   385: ldc [Ljava/lang/StackTraceElement;
    //   387: invokevirtual parseObject : (Ljava/lang/Class;)Ljava/lang/Object;
    //   390: checkcast [Ljava/lang/StackTraceElement;
    //   393: astore #10
    //   395: aload #6
    //   397: astore #8
    //   399: aload #7
    //   401: astore #9
    //   403: aload_2
    //   404: astore #11
    //   406: goto -> 437
    //   409: aload #5
    //   411: aload #8
    //   413: aload_1
    //   414: invokevirtual parse : ()Ljava/lang/Object;
    //   417: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   422: pop
    //   423: aload_2
    //   424: astore #11
    //   426: aload_3
    //   427: astore #10
    //   429: aload #7
    //   431: astore #9
    //   433: aload #6
    //   435: astore #8
    //   437: aload #8
    //   439: astore #6
    //   441: aload #9
    //   443: astore #7
    //   445: aload #10
    //   447: astore_3
    //   448: aload #11
    //   450: astore_2
    //   451: aload #4
    //   453: invokeinterface token : ()I
    //   458: bipush #13
    //   460: if_icmpne -> 105
    //   463: aload #4
    //   465: bipush #16
    //   467: invokeinterface nextToken : (I)V
    //   472: aload #11
    //   474: astore_2
    //   475: aload #10
    //   477: astore_3
    //   478: aload #9
    //   480: astore #7
    //   482: aload #8
    //   484: astore #6
    //   486: aload #6
    //   488: ifnonnull -> 505
    //   491: new java/lang/Exception
    //   494: dup
    //   495: aload #7
    //   497: aload_2
    //   498: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   501: astore_1
    //   502: goto -> 545
    //   505: ldc java/lang/Throwable
    //   507: aload #6
    //   509: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   512: ifeq -> 641
    //   515: aload_0
    //   516: aload #7
    //   518: aload_2
    //   519: aload #6
    //   521: invokespecial createException : (Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/Class;)Ljava/lang/Throwable;
    //   524: astore #6
    //   526: aload #6
    //   528: astore_1
    //   529: aload #6
    //   531: ifnonnull -> 545
    //   534: new java/lang/Exception
    //   537: dup
    //   538: aload #7
    //   540: aload_2
    //   541: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   544: astore_1
    //   545: aload_3
    //   546: ifnull -> 554
    //   549: aload_1
    //   550: aload_3
    //   551: invokevirtual setStackTrace : ([Ljava/lang/StackTraceElement;)V
    //   554: aload #5
    //   556: invokeinterface entrySet : ()Ljava/util/Set;
    //   561: invokeinterface iterator : ()Ljava/util/Iterator;
    //   566: astore_2
    //   567: aload_2
    //   568: invokeinterface hasNext : ()Z
    //   573: ifeq -> 627
    //   576: aload_2
    //   577: invokeinterface next : ()Ljava/lang/Object;
    //   582: checkcast java/util/Map$Entry
    //   585: astore #7
    //   587: aload #7
    //   589: invokeinterface getKey : ()Ljava/lang/Object;
    //   594: checkcast java/lang/String
    //   597: astore_3
    //   598: aload #7
    //   600: invokeinterface getValue : ()Ljava/lang/Object;
    //   605: astore #7
    //   607: aload_0
    //   608: aload_3
    //   609: invokevirtual getFieldDeserializer : (Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   612: astore_3
    //   613: aload_3
    //   614: ifnull -> 567
    //   617: aload_3
    //   618: aload_1
    //   619: aload #7
    //   621: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   624: goto -> 567
    //   627: aload_1
    //   628: areturn
    //   629: astore_1
    //   630: new com/alibaba/fastjson/JSONException
    //   633: dup
    //   634: ldc 'create instance error'
    //   636: aload_1
    //   637: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   640: athrow
    //   641: new java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial <init> : ()V
    //   648: astore_1
    //   649: aload_1
    //   650: ldc 'type not match, not Throwable. '
    //   652: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload_1
    //   657: aload #6
    //   659: invokevirtual getName : ()Ljava/lang/String;
    //   662: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: new com/alibaba/fastjson/JSONException
    //   669: dup
    //   670: aload_1
    //   671: invokevirtual toString : ()Ljava/lang/String;
    //   674: invokespecial <init> : (Ljava/lang/String;)V
    //   677: athrow
    //   678: new com/alibaba/fastjson/JSONException
    //   681: dup
    //   682: ldc 'syntax error'
    //   684: invokespecial <init> : (Ljava/lang/String;)V
    //   687: athrow
    // Exception table:
    //   from	to	target	type
    //   515	526	629	java/lang/Exception
    //   534	545	629	java/lang/Exception
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ThrowableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */