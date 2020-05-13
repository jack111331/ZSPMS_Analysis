package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public class TimeDeserializer implements ObjectDeserializer {
  public static final TimeDeserializer instance = new TimeDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface token : ()I
    //   11: bipush #16
    //   13: if_icmpne -> 125
    //   16: aload_2
    //   17: iconst_4
    //   18: invokeinterface nextToken : (I)V
    //   23: aload_2
    //   24: invokeinterface token : ()I
    //   29: iconst_4
    //   30: if_icmpne -> 115
    //   33: aload_2
    //   34: iconst_2
    //   35: invokeinterface nextTokenWithColon : (I)V
    //   40: aload_2
    //   41: invokeinterface token : ()I
    //   46: iconst_2
    //   47: if_icmpne -> 105
    //   50: aload_2
    //   51: invokeinterface longValue : ()J
    //   56: lstore #4
    //   58: aload_2
    //   59: bipush #13
    //   61: invokeinterface nextToken : (I)V
    //   66: aload_2
    //   67: invokeinterface token : ()I
    //   72: bipush #13
    //   74: if_icmpne -> 95
    //   77: aload_2
    //   78: bipush #16
    //   80: invokeinterface nextToken : (I)V
    //   85: new java/sql/Time
    //   88: dup
    //   89: lload #4
    //   91: invokespecial <init> : (J)V
    //   94: areturn
    //   95: new com/alibaba/fastjson/JSONException
    //   98: dup
    //   99: ldc 'syntax error'
    //   101: invokespecial <init> : (Ljava/lang/String;)V
    //   104: athrow
    //   105: new com/alibaba/fastjson/JSONException
    //   108: dup
    //   109: ldc 'syntax error'
    //   111: invokespecial <init> : (Ljava/lang/String;)V
    //   114: athrow
    //   115: new com/alibaba/fastjson/JSONException
    //   118: dup
    //   119: ldc 'syntax error'
    //   121: invokespecial <init> : (Ljava/lang/String;)V
    //   124: athrow
    //   125: aload_1
    //   126: invokevirtual parse : ()Ljava/lang/Object;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnonnull -> 136
    //   134: aconst_null
    //   135: areturn
    //   136: aload_1
    //   137: instanceof java/sql/Time
    //   140: ifeq -> 145
    //   143: aload_1
    //   144: areturn
    //   145: aload_1
    //   146: instanceof java/lang/Number
    //   149: ifeq -> 167
    //   152: new java/sql/Time
    //   155: dup
    //   156: aload_1
    //   157: checkcast java/lang/Number
    //   160: invokevirtual longValue : ()J
    //   163: invokespecial <init> : (J)V
    //   166: areturn
    //   167: aload_1
    //   168: instanceof java/lang/String
    //   171: ifeq -> 307
    //   174: aload_1
    //   175: checkcast java/lang/String
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual length : ()I
    //   183: ifne -> 188
    //   186: aconst_null
    //   187: areturn
    //   188: new com/alibaba/fastjson/parser/JSONScanner
    //   191: dup
    //   192: aload_1
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: astore_2
    //   197: aload_2
    //   198: invokevirtual scanISO8601DateIfMatch : ()Z
    //   201: ifeq -> 216
    //   204: aload_2
    //   205: invokevirtual getCalendar : ()Ljava/util/Calendar;
    //   208: invokevirtual getTimeInMillis : ()J
    //   211: lstore #4
    //   213: goto -> 293
    //   216: iconst_0
    //   217: istore #6
    //   219: iconst_0
    //   220: istore #7
    //   222: iload #7
    //   224: aload_1
    //   225: invokevirtual length : ()I
    //   228: if_icmpge -> 270
    //   231: aload_1
    //   232: iload #7
    //   234: invokevirtual charAt : (I)C
    //   237: istore #8
    //   239: iload #6
    //   241: istore #9
    //   243: iload #8
    //   245: bipush #48
    //   247: if_icmplt -> 273
    //   250: iload #8
    //   252: bipush #57
    //   254: if_icmple -> 264
    //   257: iload #6
    //   259: istore #9
    //   261: goto -> 273
    //   264: iinc #7, 1
    //   267: goto -> 222
    //   270: iconst_1
    //   271: istore #9
    //   273: iload #9
    //   275: ifne -> 287
    //   278: aload_2
    //   279: invokevirtual close : ()V
    //   282: aload_1
    //   283: invokestatic valueOf : (Ljava/lang/String;)Ljava/sql/Time;
    //   286: areturn
    //   287: aload_1
    //   288: invokestatic parseLong : (Ljava/lang/String;)J
    //   291: lstore #4
    //   293: aload_2
    //   294: invokevirtual close : ()V
    //   297: new java/sql/Time
    //   300: dup
    //   301: lload #4
    //   303: invokespecial <init> : (J)V
    //   306: areturn
    //   307: new com/alibaba/fastjson/JSONException
    //   310: dup
    //   311: ldc 'parse error'
    //   313: invokespecial <init> : (Ljava/lang/String;)V
    //   316: athrow
  }
  
  public int getFastMatchToken() {
    return 2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\TimeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */