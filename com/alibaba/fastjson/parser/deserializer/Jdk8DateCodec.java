package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectDeserializer, ContextObjectSerializer, ObjectSerializer {
  private static final DateTimeFormatter ISO_FIXED_FORMAT;
  
  private static final DateTimeFormatter defaultFormatter;
  
  private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
  
  private static final DateTimeFormatter formatter_d10_cn;
  
  private static final DateTimeFormatter formatter_d10_de;
  
  private static final DateTimeFormatter formatter_d10_eur;
  
  private static final DateTimeFormatter formatter_d10_in;
  
  private static final DateTimeFormatter formatter_d10_kr;
  
  private static final DateTimeFormatter formatter_d10_tw;
  
  private static final DateTimeFormatter formatter_d10_us;
  
  private static final DateTimeFormatter formatter_d8;
  
  private static final DateTimeFormatter formatter_dt19_cn;
  
  private static final DateTimeFormatter formatter_dt19_cn_1;
  
  private static final DateTimeFormatter formatter_dt19_de;
  
  private static final DateTimeFormatter formatter_dt19_eur;
  
  private static final DateTimeFormatter formatter_dt19_in;
  
  private static final DateTimeFormatter formatter_dt19_kr;
  
  private static final DateTimeFormatter formatter_dt19_tw;
  
  private static final DateTimeFormatter formatter_dt19_us;
  
  private static final DateTimeFormatter formatter_iso8601;
  
  private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
  
  public static final Jdk8DateCodec instance = new Jdk8DateCodec();
  
  static {
    defaultFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    formatter_dt19_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    formatter_dt19_cn = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    formatter_dt19_cn_1 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    formatter_dt19_kr = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    formatter_dt19_us = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    formatter_dt19_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    formatter_dt19_de = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    formatter_dt19_in = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    formatter_d8 = DateTimeFormatter.ofPattern("yyyyMMdd");
    formatter_d10_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    formatter_d10_cn = DateTimeFormatter.ofPattern("yyyy年M月d日");
    formatter_d10_kr = DateTimeFormatter.ofPattern("yyyy년M월d일");
    formatter_d10_us = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    formatter_d10_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    formatter_d10_de = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    formatter_d10_in = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    ISO_FIXED_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
    formatter_iso8601 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
  }
  
  private void write(SerializeWriter paramSerializeWriter, TemporalAccessor paramTemporalAccessor, String paramString) {
    DateTimeFormatter dateTimeFormatter;
    if (paramString == "yyyy-MM-dd'T'HH:mm:ss") {
      dateTimeFormatter = formatter_iso8601;
    } else {
      dateTimeFormatter = DateTimeFormatter.ofPattern((String)dateTimeFormatter);
    } 
    paramSerializeWriter.writeString(dateTimeFormatter.format(paramTemporalAccessor));
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, String paramString, int paramInt) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 8) {
      jSONLexer.nextToken();
      return null;
    } 
    if (jSONLexer.token() == 4) {
      LocalTime localTime;
      DateTimeFormatter dateTimeFormatter;
      paramObject = jSONLexer.stringVal();
      jSONLexer.nextToken();
      if (paramString != null) {
        if ("yyyy-MM-dd HH:mm:ss".equals(paramString)) {
          DateTimeFormatter dateTimeFormatter1 = defaultFormatter;
        } else {
          DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern(paramString);
        } 
      } else {
        jSONLexer = null;
      } 
      if ("".equals(paramObject))
        return null; 
      if (paramType == LocalDateTime.class)
        return (T)((paramObject.length() == 10 || paramObject.length() == 8) ? LocalDateTime.of(parseLocalDate((String)paramObject, paramString, (DateTimeFormatter)jSONLexer), LocalTime.MIN) : parseDateTime((String)paramObject, (DateTimeFormatter)jSONLexer)); 
      if (paramType == LocalDate.class) {
        LocalDate localDate;
        if (paramObject.length() == 23) {
          LocalDateTime localDateTime = LocalDateTime.parse((CharSequence)paramObject);
          localDate = LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
        } else {
          localDate = parseLocalDate((String)paramObject, paramString, (DateTimeFormatter)localDate);
        } 
        return (T)localDate;
      } 
      if (paramType == LocalTime.class) {
        if (paramObject.length() == 23) {
          LocalDateTime localDateTime = LocalDateTime.parse((CharSequence)paramObject);
          localTime = LocalTime.of(localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getNano());
        } else {
          localTime = LocalTime.parse((CharSequence)paramObject);
        } 
        return (T)localTime;
      } 
      if (paramType == ZonedDateTime.class) {
        LocalTime localTime1 = localTime;
        if (localTime == defaultFormatter)
          dateTimeFormatter = ISO_FIXED_FORMAT; 
        return (T)parseZonedDateTime((String)paramObject, dateTimeFormatter);
      } 
      return (T)((dateTimeFormatter == OffsetDateTime.class) ? OffsetDateTime.parse((CharSequence)paramObject) : ((dateTimeFormatter == OffsetTime.class) ? OffsetTime.parse((CharSequence)paramObject) : ((dateTimeFormatter == ZoneId.class) ? ZoneId.of((String)paramObject) : ((dateTimeFormatter == Period.class) ? Period.parse((CharSequence)paramObject) : ((dateTimeFormatter == Duration.class) ? Duration.parse((CharSequence)paramObject) : ((dateTimeFormatter == Instant.class) ? Instant.parse((CharSequence)paramObject) : null))))));
    } 
    throw new UnsupportedOperationException();
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  protected LocalDateTime parseDateTime(String paramString, DateTimeFormatter paramDateTimeFormatter) {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: aload_2
    //   3: ifnonnull -> 446
    //   6: aload_2
    //   7: astore #4
    //   9: aload_1
    //   10: invokevirtual length : ()I
    //   13: bipush #19
    //   15: if_icmpne -> 374
    //   18: aload_1
    //   19: iconst_4
    //   20: invokevirtual charAt : (I)C
    //   23: istore #5
    //   25: aload_1
    //   26: bipush #7
    //   28: invokevirtual charAt : (I)C
    //   31: istore #6
    //   33: aload_1
    //   34: bipush #10
    //   36: invokevirtual charAt : (I)C
    //   39: istore #7
    //   41: aload_1
    //   42: bipush #13
    //   44: invokevirtual charAt : (I)C
    //   47: istore #8
    //   49: aload_1
    //   50: bipush #16
    //   52: invokevirtual charAt : (I)C
    //   55: istore #9
    //   57: aload_2
    //   58: astore #4
    //   60: iload #8
    //   62: bipush #58
    //   64: if_icmpne -> 374
    //   67: aload_2
    //   68: astore #4
    //   70: iload #9
    //   72: bipush #58
    //   74: if_icmpne -> 374
    //   77: iload #5
    //   79: bipush #45
    //   81: if_icmpne -> 124
    //   84: iload #6
    //   86: bipush #45
    //   88: if_icmpne -> 124
    //   91: iload #7
    //   93: bipush #84
    //   95: if_icmpne -> 106
    //   98: getstatic java/time/format/DateTimeFormatter.ISO_LOCAL_DATE_TIME : Ljava/time/format/DateTimeFormatter;
    //   101: astore #4
    //   103: goto -> 374
    //   106: aload_2
    //   107: astore #4
    //   109: iload #7
    //   111: bipush #32
    //   113: if_icmpne -> 374
    //   116: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.defaultFormatter : Ljava/time/format/DateTimeFormatter;
    //   119: astore #4
    //   121: goto -> 374
    //   124: iload #5
    //   126: bipush #45
    //   128: if_icmpne -> 146
    //   131: iload #6
    //   133: bipush #45
    //   135: if_icmpne -> 146
    //   138: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.defaultFormatter : Ljava/time/format/DateTimeFormatter;
    //   141: astore #4
    //   143: goto -> 374
    //   146: iload #5
    //   148: bipush #47
    //   150: if_icmpne -> 168
    //   153: iload #6
    //   155: bipush #47
    //   157: if_icmpne -> 168
    //   160: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_tw : Ljava/time/format/DateTimeFormatter;
    //   163: astore #4
    //   165: goto -> 374
    //   168: aload_1
    //   169: iconst_0
    //   170: invokevirtual charAt : (I)C
    //   173: istore #8
    //   175: aload_1
    //   176: iconst_1
    //   177: invokevirtual charAt : (I)C
    //   180: istore #6
    //   182: aload_1
    //   183: iconst_2
    //   184: invokevirtual charAt : (I)C
    //   187: istore #10
    //   189: aload_1
    //   190: iconst_3
    //   191: invokevirtual charAt : (I)C
    //   194: istore #9
    //   196: aload_1
    //   197: iconst_5
    //   198: invokevirtual charAt : (I)C
    //   201: istore #7
    //   203: iload #10
    //   205: bipush #47
    //   207: if_icmpne -> 327
    //   210: iload #7
    //   212: bipush #47
    //   214: if_icmpne -> 327
    //   217: iload #8
    //   219: bipush #48
    //   221: isub
    //   222: bipush #10
    //   224: imul
    //   225: iload #6
    //   227: bipush #48
    //   229: isub
    //   230: iadd
    //   231: bipush #12
    //   233: if_icmple -> 244
    //   236: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_eur : Ljava/time/format/DateTimeFormatter;
    //   239: astore #4
    //   241: goto -> 374
    //   244: iload #9
    //   246: bipush #48
    //   248: isub
    //   249: bipush #10
    //   251: imul
    //   252: iload #5
    //   254: bipush #48
    //   256: isub
    //   257: iadd
    //   258: bipush #12
    //   260: if_icmple -> 271
    //   263: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_us : Ljava/time/format/DateTimeFormatter;
    //   266: astore #4
    //   268: goto -> 374
    //   271: invokestatic getDefault : ()Ljava/util/Locale;
    //   274: invokevirtual getCountry : ()Ljava/lang/String;
    //   277: astore_3
    //   278: aload_3
    //   279: ldc_w 'US'
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ifeq -> 296
    //   288: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_us : Ljava/time/format/DateTimeFormatter;
    //   291: astore #4
    //   293: goto -> 374
    //   296: aload_3
    //   297: ldc_w 'BR'
    //   300: invokevirtual equals : (Ljava/lang/Object;)Z
    //   303: ifne -> 319
    //   306: aload_2
    //   307: astore #4
    //   309: aload_3
    //   310: ldc_w 'AU'
    //   313: invokevirtual equals : (Ljava/lang/Object;)Z
    //   316: ifeq -> 374
    //   319: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_eur : Ljava/time/format/DateTimeFormatter;
    //   322: astore #4
    //   324: goto -> 374
    //   327: iload #10
    //   329: bipush #46
    //   331: if_icmpne -> 349
    //   334: iload #7
    //   336: bipush #46
    //   338: if_icmpne -> 349
    //   341: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_de : Ljava/time/format/DateTimeFormatter;
    //   344: astore #4
    //   346: goto -> 374
    //   349: aload_2
    //   350: astore #4
    //   352: iload #10
    //   354: bipush #45
    //   356: if_icmpne -> 374
    //   359: aload_2
    //   360: astore #4
    //   362: iload #7
    //   364: bipush #45
    //   366: if_icmpne -> 374
    //   369: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_in : Ljava/time/format/DateTimeFormatter;
    //   372: astore #4
    //   374: aload #4
    //   376: astore_3
    //   377: aload_1
    //   378: invokevirtual length : ()I
    //   381: bipush #17
    //   383: if_icmplt -> 446
    //   386: aload_1
    //   387: iconst_4
    //   388: invokevirtual charAt : (I)C
    //   391: istore #5
    //   393: iload #5
    //   395: sipush #24180
    //   398: if_icmpne -> 431
    //   401: aload_1
    //   402: aload_1
    //   403: invokevirtual length : ()I
    //   406: iconst_1
    //   407: isub
    //   408: invokevirtual charAt : (I)C
    //   411: sipush #31186
    //   414: if_icmpne -> 424
    //   417: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_cn_1 : Ljava/time/format/DateTimeFormatter;
    //   420: astore_3
    //   421: goto -> 446
    //   424: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_cn : Ljava/time/format/DateTimeFormatter;
    //   427: astore_3
    //   428: goto -> 446
    //   431: aload #4
    //   433: astore_3
    //   434: iload #5
    //   436: ldc_w 45380
    //   439: if_icmpne -> 446
    //   442: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_kr : Ljava/time/format/DateTimeFormatter;
    //   445: astore_3
    //   446: aload_3
    //   447: ifnonnull -> 458
    //   450: aload_1
    //   451: invokestatic parse : (Ljava/lang/CharSequence;)Ljava/time/LocalDateTime;
    //   454: astore_1
    //   455: goto -> 464
    //   458: aload_1
    //   459: aload_3
    //   460: invokestatic parse : (Ljava/lang/CharSequence;Ljava/time/format/DateTimeFormatter;)Ljava/time/LocalDateTime;
    //   463: astore_1
    //   464: aload_1
    //   465: areturn
  }
  
  protected LocalDate parseLocalDate(String paramString1, String paramString2, DateTimeFormatter paramDateTimeFormatter) {
    // Byte code:
    //   0: aload_3
    //   1: astore #4
    //   3: aload_3
    //   4: ifnonnull -> 325
    //   7: aload_1
    //   8: invokevirtual length : ()I
    //   11: bipush #8
    //   13: if_icmpne -> 20
    //   16: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d8 : Ljava/time/format/DateTimeFormatter;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_1
    //   23: invokevirtual length : ()I
    //   26: bipush #10
    //   28: if_icmpne -> 274
    //   31: aload_1
    //   32: iconst_4
    //   33: invokevirtual charAt : (I)C
    //   36: istore #5
    //   38: aload_1
    //   39: bipush #7
    //   41: invokevirtual charAt : (I)C
    //   44: istore #6
    //   46: aload_3
    //   47: astore #4
    //   49: iload #5
    //   51: bipush #47
    //   53: if_icmpne -> 71
    //   56: aload_3
    //   57: astore #4
    //   59: iload #6
    //   61: bipush #47
    //   63: if_icmpne -> 71
    //   66: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_tw : Ljava/time/format/DateTimeFormatter;
    //   69: astore #4
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual charAt : (I)C
    //   76: istore #6
    //   78: aload_1
    //   79: iconst_1
    //   80: invokevirtual charAt : (I)C
    //   83: istore #7
    //   85: aload_1
    //   86: iconst_2
    //   87: invokevirtual charAt : (I)C
    //   90: istore #8
    //   92: aload_1
    //   93: iconst_3
    //   94: invokevirtual charAt : (I)C
    //   97: istore #9
    //   99: aload_1
    //   100: iconst_5
    //   101: invokevirtual charAt : (I)C
    //   104: istore #10
    //   106: iload #8
    //   108: bipush #47
    //   110: if_icmpne -> 226
    //   113: iload #10
    //   115: bipush #47
    //   117: if_icmpne -> 226
    //   120: iload #6
    //   122: bipush #48
    //   124: isub
    //   125: bipush #10
    //   127: imul
    //   128: iload #7
    //   130: bipush #48
    //   132: isub
    //   133: iadd
    //   134: bipush #12
    //   136: if_icmple -> 146
    //   139: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_eur : Ljava/time/format/DateTimeFormatter;
    //   142: astore_2
    //   143: goto -> 274
    //   146: iload #9
    //   148: bipush #48
    //   150: isub
    //   151: bipush #10
    //   153: imul
    //   154: iload #5
    //   156: bipush #48
    //   158: isub
    //   159: iadd
    //   160: bipush #12
    //   162: if_icmple -> 172
    //   165: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_us : Ljava/time/format/DateTimeFormatter;
    //   168: astore_2
    //   169: goto -> 274
    //   172: invokestatic getDefault : ()Ljava/util/Locale;
    //   175: invokevirtual getCountry : ()Ljava/lang/String;
    //   178: astore_3
    //   179: aload_3
    //   180: ldc_w 'US'
    //   183: invokevirtual equals : (Ljava/lang/Object;)Z
    //   186: ifeq -> 196
    //   189: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_us : Ljava/time/format/DateTimeFormatter;
    //   192: astore_2
    //   193: goto -> 274
    //   196: aload_3
    //   197: ldc_w 'BR'
    //   200: invokevirtual equals : (Ljava/lang/Object;)Z
    //   203: ifne -> 219
    //   206: aload #4
    //   208: astore_2
    //   209: aload_3
    //   210: ldc_w 'AU'
    //   213: invokevirtual equals : (Ljava/lang/Object;)Z
    //   216: ifeq -> 274
    //   219: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_eur : Ljava/time/format/DateTimeFormatter;
    //   222: astore_2
    //   223: goto -> 274
    //   226: iload #8
    //   228: bipush #46
    //   230: if_icmpne -> 247
    //   233: iload #10
    //   235: bipush #46
    //   237: if_icmpne -> 247
    //   240: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_de : Ljava/time/format/DateTimeFormatter;
    //   243: astore_2
    //   244: goto -> 274
    //   247: aload #4
    //   249: astore_2
    //   250: iload #8
    //   252: bipush #45
    //   254: if_icmpne -> 274
    //   257: aload #4
    //   259: astore_2
    //   260: iload #10
    //   262: bipush #45
    //   264: if_icmpne -> 274
    //   267: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_in : Ljava/time/format/DateTimeFormatter;
    //   270: astore_2
    //   271: goto -> 244
    //   274: aload_2
    //   275: astore #4
    //   277: aload_1
    //   278: invokevirtual length : ()I
    //   281: bipush #9
    //   283: if_icmplt -> 325
    //   286: aload_1
    //   287: iconst_4
    //   288: invokevirtual charAt : (I)C
    //   291: istore #5
    //   293: iload #5
    //   295: sipush #24180
    //   298: if_icmpne -> 309
    //   301: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_cn : Ljava/time/format/DateTimeFormatter;
    //   304: astore #4
    //   306: goto -> 325
    //   309: aload_2
    //   310: astore #4
    //   312: iload #5
    //   314: ldc_w 45380
    //   317: if_icmpne -> 325
    //   320: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_d10_kr : Ljava/time/format/DateTimeFormatter;
    //   323: astore #4
    //   325: aload #4
    //   327: ifnonnull -> 338
    //   330: aload_1
    //   331: invokestatic parse : (Ljava/lang/CharSequence;)Ljava/time/LocalDate;
    //   334: astore_1
    //   335: goto -> 345
    //   338: aload_1
    //   339: aload #4
    //   341: invokestatic parse : (Ljava/lang/CharSequence;Ljava/time/format/DateTimeFormatter;)Ljava/time/LocalDate;
    //   344: astore_1
    //   345: aload_1
    //   346: areturn
  }
  
  protected ZonedDateTime parseZonedDateTime(String paramString, DateTimeFormatter paramDateTimeFormatter) {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: aload_2
    //   3: ifnonnull -> 446
    //   6: aload_2
    //   7: astore #4
    //   9: aload_1
    //   10: invokevirtual length : ()I
    //   13: bipush #19
    //   15: if_icmpne -> 374
    //   18: aload_1
    //   19: iconst_4
    //   20: invokevirtual charAt : (I)C
    //   23: istore #5
    //   25: aload_1
    //   26: bipush #7
    //   28: invokevirtual charAt : (I)C
    //   31: istore #6
    //   33: aload_1
    //   34: bipush #10
    //   36: invokevirtual charAt : (I)C
    //   39: istore #7
    //   41: aload_1
    //   42: bipush #13
    //   44: invokevirtual charAt : (I)C
    //   47: istore #8
    //   49: aload_1
    //   50: bipush #16
    //   52: invokevirtual charAt : (I)C
    //   55: istore #9
    //   57: aload_2
    //   58: astore #4
    //   60: iload #8
    //   62: bipush #58
    //   64: if_icmpne -> 374
    //   67: aload_2
    //   68: astore #4
    //   70: iload #9
    //   72: bipush #58
    //   74: if_icmpne -> 374
    //   77: iload #5
    //   79: bipush #45
    //   81: if_icmpne -> 124
    //   84: iload #6
    //   86: bipush #45
    //   88: if_icmpne -> 124
    //   91: iload #7
    //   93: bipush #84
    //   95: if_icmpne -> 106
    //   98: getstatic java/time/format/DateTimeFormatter.ISO_LOCAL_DATE_TIME : Ljava/time/format/DateTimeFormatter;
    //   101: astore #4
    //   103: goto -> 374
    //   106: aload_2
    //   107: astore #4
    //   109: iload #7
    //   111: bipush #32
    //   113: if_icmpne -> 374
    //   116: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.defaultFormatter : Ljava/time/format/DateTimeFormatter;
    //   119: astore #4
    //   121: goto -> 374
    //   124: iload #5
    //   126: bipush #45
    //   128: if_icmpne -> 146
    //   131: iload #6
    //   133: bipush #45
    //   135: if_icmpne -> 146
    //   138: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.defaultFormatter : Ljava/time/format/DateTimeFormatter;
    //   141: astore #4
    //   143: goto -> 374
    //   146: iload #5
    //   148: bipush #47
    //   150: if_icmpne -> 168
    //   153: iload #6
    //   155: bipush #47
    //   157: if_icmpne -> 168
    //   160: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_tw : Ljava/time/format/DateTimeFormatter;
    //   163: astore #4
    //   165: goto -> 374
    //   168: aload_1
    //   169: iconst_0
    //   170: invokevirtual charAt : (I)C
    //   173: istore #8
    //   175: aload_1
    //   176: iconst_1
    //   177: invokevirtual charAt : (I)C
    //   180: istore #9
    //   182: aload_1
    //   183: iconst_2
    //   184: invokevirtual charAt : (I)C
    //   187: istore #7
    //   189: aload_1
    //   190: iconst_3
    //   191: invokevirtual charAt : (I)C
    //   194: istore #10
    //   196: aload_1
    //   197: iconst_5
    //   198: invokevirtual charAt : (I)C
    //   201: istore #6
    //   203: iload #7
    //   205: bipush #47
    //   207: if_icmpne -> 327
    //   210: iload #6
    //   212: bipush #47
    //   214: if_icmpne -> 327
    //   217: iload #8
    //   219: bipush #48
    //   221: isub
    //   222: bipush #10
    //   224: imul
    //   225: iload #9
    //   227: bipush #48
    //   229: isub
    //   230: iadd
    //   231: bipush #12
    //   233: if_icmple -> 244
    //   236: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_eur : Ljava/time/format/DateTimeFormatter;
    //   239: astore #4
    //   241: goto -> 374
    //   244: iload #10
    //   246: bipush #48
    //   248: isub
    //   249: bipush #10
    //   251: imul
    //   252: iload #5
    //   254: bipush #48
    //   256: isub
    //   257: iadd
    //   258: bipush #12
    //   260: if_icmple -> 271
    //   263: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_us : Ljava/time/format/DateTimeFormatter;
    //   266: astore #4
    //   268: goto -> 374
    //   271: invokestatic getDefault : ()Ljava/util/Locale;
    //   274: invokevirtual getCountry : ()Ljava/lang/String;
    //   277: astore_3
    //   278: aload_3
    //   279: ldc_w 'US'
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ifeq -> 296
    //   288: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_us : Ljava/time/format/DateTimeFormatter;
    //   291: astore #4
    //   293: goto -> 374
    //   296: aload_3
    //   297: ldc_w 'BR'
    //   300: invokevirtual equals : (Ljava/lang/Object;)Z
    //   303: ifne -> 319
    //   306: aload_2
    //   307: astore #4
    //   309: aload_3
    //   310: ldc_w 'AU'
    //   313: invokevirtual equals : (Ljava/lang/Object;)Z
    //   316: ifeq -> 374
    //   319: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_eur : Ljava/time/format/DateTimeFormatter;
    //   322: astore #4
    //   324: goto -> 374
    //   327: iload #7
    //   329: bipush #46
    //   331: if_icmpne -> 349
    //   334: iload #6
    //   336: bipush #46
    //   338: if_icmpne -> 349
    //   341: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_de : Ljava/time/format/DateTimeFormatter;
    //   344: astore #4
    //   346: goto -> 374
    //   349: aload_2
    //   350: astore #4
    //   352: iload #7
    //   354: bipush #45
    //   356: if_icmpne -> 374
    //   359: aload_2
    //   360: astore #4
    //   362: iload #6
    //   364: bipush #45
    //   366: if_icmpne -> 374
    //   369: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_in : Ljava/time/format/DateTimeFormatter;
    //   372: astore #4
    //   374: aload #4
    //   376: astore_3
    //   377: aload_1
    //   378: invokevirtual length : ()I
    //   381: bipush #17
    //   383: if_icmplt -> 446
    //   386: aload_1
    //   387: iconst_4
    //   388: invokevirtual charAt : (I)C
    //   391: istore #5
    //   393: iload #5
    //   395: sipush #24180
    //   398: if_icmpne -> 431
    //   401: aload_1
    //   402: aload_1
    //   403: invokevirtual length : ()I
    //   406: iconst_1
    //   407: isub
    //   408: invokevirtual charAt : (I)C
    //   411: sipush #31186
    //   414: if_icmpne -> 424
    //   417: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_cn_1 : Ljava/time/format/DateTimeFormatter;
    //   420: astore_3
    //   421: goto -> 446
    //   424: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_cn : Ljava/time/format/DateTimeFormatter;
    //   427: astore_3
    //   428: goto -> 446
    //   431: aload #4
    //   433: astore_3
    //   434: iload #5
    //   436: ldc_w 45380
    //   439: if_icmpne -> 446
    //   442: getstatic com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.formatter_dt19_kr : Ljava/time/format/DateTimeFormatter;
    //   445: astore_3
    //   446: aload_3
    //   447: ifnonnull -> 458
    //   450: aload_1
    //   451: invokestatic parse : (Ljava/lang/CharSequence;)Ljava/time/ZonedDateTime;
    //   454: astore_1
    //   455: goto -> 464
    //   458: aload_1
    //   459: aload_3
    //   460: invokestatic parse : (Ljava/lang/CharSequence;Ljava/time/format/DateTimeFormatter;)Ljava/time/ZonedDateTime;
    //   463: astore_1
    //   464: aload_1
    //   465: areturn
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject, BeanContext paramBeanContext) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    String str = paramBeanContext.getFormat();
    write(serializeWriter, (TemporalAccessor)paramObject, str);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object<?> paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
    } else {
      paramObject2 = (Object<?>)paramType;
      if (paramType == null)
        paramObject2 = (Object<?>)paramObject1.getClass(); 
      if (paramObject2 == LocalDateTime.class) {
        int i = SerializerFeature.UseISO8601DateFormat.getMask();
        LocalDateTime localDateTime = (LocalDateTime)paramObject1;
        paramObject2 = (Object<?>)paramJSONSerializer.getDateFormatPattern();
        if ((paramObject2 == null && (i & paramInt) != 0) || paramJSONSerializer.isEnabled(SerializerFeature.UseISO8601DateFormat))
          paramObject2 = (Object<?>)"yyyy-MM-dd'T'HH:mm:ss"; 
        if (localDateTime.getNano() == 0 || paramObject2 != null) {
          Object<?> object = paramObject2;
          if (paramObject2 == null)
            object = (Object<?>)JSON.DEFFAULT_DATE_FORMAT; 
          write(serializeWriter, localDateTime, (String)object);
          return;
        } 
        serializeWriter.writeString(paramObject1.toString());
      } else {
        serializeWriter.writeString(paramObject1.toString());
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\Jdk8DateCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */