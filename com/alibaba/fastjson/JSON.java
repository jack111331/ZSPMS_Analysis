package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class JSON implements JSONAware, JSONStreamAware {
  static {
    defaultLocale = Locale.getDefault();
    DEFAULT_TYPE_KEY = "@type";
    emptyFilters = new SerializeFilter[0];
    DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    DEFAULT_PARSER_FEATURE = Feature.AutoCloseSource.getMask() | 0x0 | Feature.InternFieldNames.getMask() | Feature.UseBigDecimal.getMask() | Feature.AllowUnQuotedFieldNames.getMask() | Feature.AllowSingleQuotes.getMask() | Feature.AllowArbitraryCommas.getMask() | Feature.SortFeidFastMatch.getMask() | Feature.IgnoreNotMatch.getMask();
    int i = 0x0 | SerializerFeature.QuoteFieldNames.getMask() | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
    String str = IOUtils.getStringProperty("fastjson.serializerFeatures.MapSortField");
    int j = SerializerFeature.MapSortField.getMask();
    if ("true".equals(str)) {
      k = i | j;
    } else {
      k = i;
      if ("false".equals(str))
        k = i & (j ^ 0xFFFFFFFF); 
    } 
    DEFAULT_GENERATE_FEATURE = k;
    bytesLocal = (ThreadLocal)new ThreadLocal<byte>();
    charsLocal = (ThreadLocal)new ThreadLocal<char>();
  }
  
  private static byte[] allocateBytes(int paramInt) {
    byte[] arrayOfByte2;
    byte[] arrayOfByte1 = bytesLocal.get();
    if (arrayOfByte1 == null) {
      if (paramInt <= 65536) {
        arrayOfByte2 = new byte[65536];
        bytesLocal.set(arrayOfByte2);
      } else {
        arrayOfByte2 = new byte[paramInt];
      } 
    } else {
      arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1.length < paramInt)
        arrayOfByte2 = new byte[paramInt]; 
    } 
    return arrayOfByte2;
  }
  
  private static char[] allocateChars(int paramInt) {
    char[] arrayOfChar2;
    char[] arrayOfChar1 = charsLocal.get();
    if (arrayOfChar1 == null) {
      if (paramInt <= 65536) {
        arrayOfChar2 = new char[65536];
        charsLocal.set(arrayOfChar2);
      } else {
        arrayOfChar2 = new char[paramInt];
      } 
    } else {
      arrayOfChar2 = arrayOfChar1;
      if (arrayOfChar1.length < paramInt)
        arrayOfChar2 = new char[paramInt]; 
    } 
    return arrayOfChar2;
  }
  
  public static <T> void handleResovleTask(DefaultJSONParser paramDefaultJSONParser, T paramT) {
    paramDefaultJSONParser.handleResovleTask(paramT);
  }
  
  public static Object parse(String paramString) {
    return parse(paramString, DEFAULT_PARSER_FEATURE);
  }
  
  public static Object parse(String paramString, int paramInt) {
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), paramInt);
    Object object = defaultJSONParser.parse();
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return object;
  }
  
  public static Object parse(String paramString, Feature... paramVarArgs) {
    int i = DEFAULT_PARSER_FEATURE;
    int j = paramVarArgs.length;
    for (byte b = 0; b < j; b++)
      i = Feature.config(i, paramVarArgs[b], true); 
    return parse(paramString, i);
  }
  
  public static Object parse(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, int paramInt3) {
    paramCharsetDecoder.reset();
    double d1 = paramInt2;
    double d2 = paramCharsetDecoder.maxCharsPerByte();
    Double.isNaN(d1);
    Double.isNaN(d2);
    char[] arrayOfChar = allocateChars((int)(d1 * d2));
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2);
    CharBuffer charBuffer = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, byteBuffer, charBuffer);
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(arrayOfChar, charBuffer.position(), ParserConfig.getGlobalInstance(), paramInt3);
    Object object = defaultJSONParser.parse();
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return object;
  }
  
  public static Object parse(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Feature... paramVarArgs) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    int i = DEFAULT_PARSER_FEATURE;
    int j = paramVarArgs.length;
    for (byte b = 0; b < j; b++)
      i = Feature.config(i, paramVarArgs[b], true); 
    return parse(paramArrayOfbyte, paramInt1, paramInt2, paramCharsetDecoder, i);
  }
  
  public static Object parse(byte[] paramArrayOfbyte, Feature... paramVarArgs) {
    char[] arrayOfChar = allocateChars(paramArrayOfbyte.length);
    int i = IOUtils.decodeUTF8(paramArrayOfbyte, 0, paramArrayOfbyte.length, arrayOfChar);
    return (i < 0) ? null : parse(new String(arrayOfChar, 0, i), paramVarArgs);
  }
  
  public static JSONArray parseArray(String paramString) {
    JSONArray jSONArray;
    JSONLexer jSONLexer2 = null;
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    JSONLexer jSONLexer1 = defaultJSONParser.lexer;
    if (jSONLexer1.token() == 8) {
      jSONLexer1.nextToken();
      jSONLexer1 = jSONLexer2;
    } else if (jSONLexer1.token() == 20) {
      jSONLexer1 = jSONLexer2;
    } else {
      jSONArray = new JSONArray();
      defaultJSONParser.parseArray(jSONArray);
      defaultJSONParser.handleResovleTask(jSONArray);
    } 
    defaultJSONParser.close();
    return jSONArray;
  }
  
  public static <T> List<T> parseArray(String paramString, Class<T> paramClass) {
    ArrayList<T> arrayList;
    JSONLexer jSONLexer2 = null;
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    JSONLexer jSONLexer1 = defaultJSONParser.lexer;
    int i = jSONLexer1.token();
    if (i == 8) {
      jSONLexer1.nextToken();
      jSONLexer1 = jSONLexer2;
    } else if (i == 20 && jSONLexer1.isBlankInput()) {
      jSONLexer1 = jSONLexer2;
    } else {
      arrayList = new ArrayList();
      defaultJSONParser.parseArray(paramClass, arrayList);
      defaultJSONParser.handleResovleTask(arrayList);
    } 
    defaultJSONParser.close();
    return arrayList;
  }
  
  public static List<Object> parseArray(String paramString, Type[] paramArrayOfType) {
    List<Object> list;
    Object[] arrayOfObject2 = null;
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    Object[] arrayOfObject1 = defaultJSONParser.parseArray(paramArrayOfType);
    if (arrayOfObject1 == null) {
      arrayOfObject1 = arrayOfObject2;
    } else {
      list = Arrays.asList(arrayOfObject1);
    } 
    defaultJSONParser.handleResovleTask(list);
    defaultJSONParser.close();
    return list;
  }
  
  public static JSONObject parseObject(String paramString) {
    Object object = parse(paramString);
    if (object instanceof JSONObject)
      return (JSONObject)object; 
    try {
      return (JSONObject)toJSON(object);
    } catch (RuntimeException runtimeException) {
      throw new JSONException("can not cast to JSONObject.", runtimeException);
    } 
  }
  
  public static JSONObject parseObject(String paramString, Feature... paramVarArgs) {
    return (JSONObject)parse(paramString, paramVarArgs);
  }
  
  public static <T> T parseObject(InputStream paramInputStream, Type paramType, Feature... paramVarArgs) throws IOException {
    return parseObject(paramInputStream, IOUtils.UTF8, paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(InputStream paramInputStream, Charset paramCharset, Type paramType, Feature... paramVarArgs) throws IOException {
    Charset charset = paramCharset;
    if (paramCharset == null)
      charset = IOUtils.UTF8; 
    byte[] arrayOfByte = allocateBytes(65536);
    int i = 0;
    while (true) {
      int j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
      if (j == -1)
        return parseObject(arrayOfByte, 0, i, charset, paramType, paramVarArgs); 
      j = i + j;
      i = j;
      if (j == arrayOfByte.length) {
        byte[] arrayOfByte1 = new byte[arrayOfByte.length * 3 / 2];
        System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, arrayOfByte.length);
        arrayOfByte = arrayOfByte1;
        i = j;
      } 
    } 
  }
  
  public static <T> T parseObject(String paramString, TypeReference<T> paramTypeReference, Feature... paramVarArgs) {
    return parseObject(paramString, paramTypeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass) {
    return parseObject(paramString, paramClass, new Feature[0]);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass, ParseProcess paramParseProcess, Feature... paramVarArgs) {
    return parseObject(paramString, paramClass, ParserConfig.global, paramParseProcess, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass, Feature... paramVarArgs) {
    return parseObject(paramString, paramClass, ParserConfig.global, (ParseProcess)null, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, int paramInt, Feature... paramVarArgs) {
    if (paramString == null)
      return null; 
    int i = paramVarArgs.length;
    boolean bool = false;
    int j = paramInt;
    for (paramInt = bool; paramInt < i; paramInt++)
      j = Feature.config(j, paramVarArgs[paramInt], true); 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), j);
    Object object = defaultJSONParser.parseObject(paramType);
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return (T)object;
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, int paramInt, Feature... paramVarArgs) {
    return parseObject(paramString, paramType, paramParserConfig, (ParseProcess)null, paramInt, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, ParseProcess paramParseProcess, int paramInt, Feature... paramVarArgs) {
    if (paramString == null)
      return null; 
    int i = paramInt;
    if (paramVarArgs != null) {
      int j = paramVarArgs.length;
      byte b = 0;
      while (true) {
        i = paramInt;
        if (b < j) {
          paramInt |= (paramVarArgs[b]).mask;
          b++;
          continue;
        } 
        break;
      } 
    } 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, paramParserConfig, i);
    if (paramParseProcess != null) {
      if (paramParseProcess instanceof ExtraTypeProvider)
        defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider)paramParseProcess); 
      if (paramParseProcess instanceof ExtraProcessor)
        defaultJSONParser.getExtraProcessors().add((ExtraProcessor)paramParseProcess); 
      if (paramParseProcess instanceof FieldTypeResolver)
        defaultJSONParser.setFieldTypeResolver((FieldTypeResolver)paramParseProcess); 
    } 
    Object object = defaultJSONParser.parseObject(paramType, null);
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return (T)object;
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, Feature... paramVarArgs) {
    return parseObject(paramString, paramType, paramParserConfig, (ParseProcess)null, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParseProcess paramParseProcess, Feature... paramVarArgs) {
    return parseObject(paramString, paramType, ParserConfig.global, paramParseProcess, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, Feature... paramVarArgs) {
    return parseObject(paramString, paramType, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Charset paramCharset, Type paramType, Feature... paramVarArgs) {
    String str;
    Charset charset = paramCharset;
    if (paramCharset == null)
      charset = IOUtils.UTF8; 
    if (charset == IOUtils.UTF8) {
      char[] arrayOfChar = allocateChars(paramArrayOfbyte.length);
      paramInt1 = IOUtils.decodeUTF8(paramArrayOfbyte, paramInt1, paramInt2, arrayOfChar);
      if (paramInt1 < 0)
        return null; 
      str = new String(arrayOfChar, 0, paramInt1);
    } else {
      if (paramInt2 < 0)
        return null; 
      str = new String((byte[])str, paramInt1, paramInt2, charset);
    } 
    return parseObject(str, paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Type paramType, Feature... paramVarArgs) {
    paramCharsetDecoder.reset();
    double d1 = paramInt2;
    double d2 = paramCharsetDecoder.maxCharsPerByte();
    Double.isNaN(d1);
    Double.isNaN(d2);
    char[] arrayOfChar = allocateChars((int)(d1 * d2));
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2);
    CharBuffer charBuffer = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, byteBuffer, charBuffer);
    return parseObject(arrayOfChar, charBuffer.position(), paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(byte[] paramArrayOfbyte, Type paramType, Feature... paramVarArgs) {
    return parseObject(paramArrayOfbyte, 0, paramArrayOfbyte.length, IOUtils.UTF8, paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(char[] paramArrayOfchar, int paramInt, Type paramType, Feature... paramVarArgs) {
    if (paramArrayOfchar == null || paramArrayOfchar.length == 0)
      return null; 
    int i = DEFAULT_PARSER_FEATURE;
    int j = paramVarArgs.length;
    for (byte b = 0; b < j; b++)
      i = Feature.config(i, paramVarArgs[b], true); 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramArrayOfchar, paramInt, ParserConfig.getGlobalInstance(), i);
    Object object = defaultJSONParser.parseObject(paramType);
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return (T)object;
  }
  
  public static void setDefaultTypeKey(String paramString) {
    DEFAULT_TYPE_KEY = paramString;
    ParserConfig.global.symbolTable.addSymbol(paramString, 0, paramString.length(), paramString.hashCode(), true);
  }
  
  public static Object toJSON(Object paramObject) {
    return toJSON(paramObject, SerializeConfig.globalInstance);
  }
  
  public static Object toJSON(Object paramObject, ParserConfig paramParserConfig) {
    return toJSON(paramObject, SerializeConfig.globalInstance);
  }
  
  public static Object toJSON(Object paramObject, SerializeConfig paramSerializeConfig) {
    JSONArray jSONArray;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof JSON)
      return paramObject; 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      paramObject = new JSONObject(map.size());
      for (Map.Entry entry : map.entrySet())
        paramObject.put(TypeUtils.castToString(entry.getKey()), toJSON(entry.getValue())); 
      return paramObject;
    } 
    if (paramObject instanceof Collection) {
      Collection collection = (Collection)paramObject;
      paramObject = new JSONArray(collection.size());
      Iterator iterator = collection.iterator();
      while (iterator.hasNext())
        paramObject.add(toJSON(iterator.next())); 
      return paramObject;
    } 
    Class<?> clazz = paramObject.getClass();
    if (clazz.isEnum())
      return ((Enum)paramObject).name(); 
    if (clazz.isArray()) {
      int i = Array.getLength(paramObject);
      jSONArray = new JSONArray(i);
      for (byte b = 0; b < i; b++)
        jSONArray.add(toJSON(Array.get(paramObject, b))); 
      return jSONArray;
    } 
    if (ParserConfig.isPrimitive2(clazz))
      return paramObject; 
    ObjectSerializer objectSerializer = jSONArray.getObjectWriter(clazz);
    if (objectSerializer instanceof JavaBeanSerializer) {
      JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer)objectSerializer;
      JSONObject jSONObject = new JSONObject();
      try {
        paramObject = javaBeanSerializer.getFieldValuesMap(paramObject).entrySet().iterator();
        while (paramObject.hasNext()) {
          Map.Entry entry = paramObject.next();
          jSONObject.put((String)entry.getKey(), toJSON(entry.getValue()));
        } 
        return jSONObject;
      } catch (Exception exception) {
        throw new JSONException("toJSON error", exception);
      } 
    } 
    return parse(toJSONString(exception));
  }
  
  public static byte[] toJSONBytes(Object paramObject, int paramInt, SerializerFeature... paramVarArgs) {
    return toJSONBytes(paramObject, SerializeConfig.globalInstance, paramInt, paramVarArgs);
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializeConfig paramSerializeConfig, int paramInt, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter(null, paramInt, paramVarArgs);
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter, paramSerializeConfig);
      jSONSerializer.write(paramObject);
      paramObject = serializeWriter.toBytes(IOUtils.UTF8);
      return (byte[])paramObject;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs) {
    return toJSONBytes(paramObject, paramSerializeConfig, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializerFeature... paramVarArgs) {
    return toJSONBytes(paramObject, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject) {
    return toJSONString(paramObject, emptyFilters, new SerializerFeature[0]);
  }
  
  public static String toJSONString(Object paramObject, int paramInt, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter((Writer)null, paramInt, paramVarArgs);
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter);
      jSONSerializer.write(paramObject);
      paramObject = serializeWriter.toString();
      return (String)paramObject;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs) {
    int i = DEFAULT_GENERATE_FEATURE;
    return toJSONString(paramObject, paramSerializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, i, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, String paramString, int paramInt, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter(null, paramInt, paramVarArgs);
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter, paramSerializeConfig);
      if (paramString != null && paramString.length() != 0) {
        jSONSerializer.setDateFormat(paramString);
        jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
      } 
      if (paramArrayOfSerializeFilter != null) {
        int i = paramArrayOfSerializeFilter.length;
        for (paramInt = 0; paramInt < i; paramInt++)
          jSONSerializer.addFilter(paramArrayOfSerializeFilter[paramInt]); 
      } 
      jSONSerializer.write(paramObject);
      paramObject = serializeWriter.toString();
      return (String)paramObject;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, paramSerializeConfig, paramArrayOfSerializeFilter, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, paramSerializeConfig, (SerializeFilter)null, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs) {
    SerializeConfig serializeConfig = SerializeConfig.globalInstance;
    int i = DEFAULT_GENERATE_FEATURE;
    return toJSONString(paramObject, serializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, i, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, boolean paramBoolean) {
    return !paramBoolean ? toJSONString(paramObject) : toJSONString(paramObject, new SerializerFeature[] { SerializerFeature.PrettyFormat });
  }
  
  public static String toJSONString(Object paramObject, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, SerializeConfig.globalInstance, paramArrayOfSerializeFilter, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONStringWithDateFormat(Object paramObject, String paramString, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, SerializeConfig.globalInstance, null, paramString, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONStringZ(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, paramSerializeConfig, emptyFilters, null, 0, paramVarArgs);
  }
  
  public static <T> T toJavaObject(JSON paramJSON, Class<T> paramClass) {
    return (T)TypeUtils.cast(paramJSON, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Object paramObject, int paramInt, SerializerFeature... paramVarArgs) throws IOException {
    return writeJSONString(paramOutputStream, IOUtils.UTF8, paramObject, SerializeConfig.globalInstance, null, null, paramInt, paramVarArgs);
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Object paramObject, SerializerFeature... paramVarArgs) throws IOException {
    return writeJSONString(paramOutputStream, paramObject, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Charset paramCharset, Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, String paramString, int paramInt, SerializerFeature... paramVarArgs) throws IOException {
    SerializeWriter serializeWriter = new SerializeWriter(null, paramInt, paramVarArgs);
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter, paramSerializeConfig);
      if (paramString != null && paramString.length() != 0) {
        jSONSerializer.setDateFormat(paramString);
        jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
      } 
      if (paramArrayOfSerializeFilter != null) {
        int i = paramArrayOfSerializeFilter.length;
        for (paramInt = 0; paramInt < i; paramInt++)
          jSONSerializer.addFilter(paramArrayOfSerializeFilter[paramInt]); 
      } 
      jSONSerializer.write(paramObject);
      paramInt = serializeWriter.writeToEx(paramOutputStream, paramCharset);
      return paramInt;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Charset paramCharset, Object paramObject, SerializerFeature... paramVarArgs) throws IOException {
    return writeJSONString(paramOutputStream, paramCharset, paramObject, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static void writeJSONString(Writer paramWriter, Object paramObject, int paramInt, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter(paramWriter, paramInt, paramVarArgs);
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter);
      jSONSerializer.write(paramObject);
      return;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static void writeJSONString(Writer paramWriter, Object paramObject, SerializerFeature... paramVarArgs) {
    writeJSONString(paramWriter, paramObject, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static void writeJSONStringTo(Object paramObject, Writer paramWriter, SerializerFeature... paramVarArgs) {
    writeJSONString(paramWriter, paramObject, paramVarArgs);
  }
  
  public String toJSONString() {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter);
      jSONSerializer.write(this);
      return serializeWriter.toString();
    } finally {
      serializeWriter.close();
    } 
  }
  
  public <T> T toJavaObject(TypeReference paramTypeReference) {
    if (paramTypeReference != null) {
      Type type = paramTypeReference.getType();
    } else {
      paramTypeReference = null;
    } 
    return (T)TypeUtils.cast(this, (Type)paramTypeReference, ParserConfig.getGlobalInstance());
  }
  
  public <T> T toJavaObject(Class<T> paramClass) {
    return (T)TypeUtils.cast(this, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public <T> T toJavaObject(Type paramType) {
    return (T)TypeUtils.cast(this, paramType, ParserConfig.getGlobalInstance());
  }
  
  public String toString() {
    return toJSONString();
  }
  
  public void writeJSONString(Appendable paramAppendable) {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter);
      jSONSerializer.write(this);
      paramAppendable.append(serializeWriter.toString());
      serializeWriter.close();
      return;
    } catch (IOException iOException) {
      JSONException jSONException = new JSONException();
      this(iOException.getMessage(), iOException);
      throw jSONException;
    } finally {}
    serializeWriter.close();
    throw paramAppendable;
  }
  
  static {
    int k;
  }
  
  public static int DEFAULT_GENERATE_FEATURE = 0;
  
  public static int DEFAULT_PARSER_FEATURE = 0;
  
  public static String DEFAULT_TYPE_KEY;
  
  public static String DEFFAULT_DATE_FORMAT;
  
  public static final String VERSION = "1.2.35";
  
  private static final ThreadLocal<byte[]> bytesLocal;
  
  private static final ThreadLocal<char[]> charsLocal;
  
  public static Locale defaultLocale;
  
  public static TimeZone defaultTimeZone = TimeZone.getDefault();
  
  static final SerializeFilter[] emptyFilters;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\JSON.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */