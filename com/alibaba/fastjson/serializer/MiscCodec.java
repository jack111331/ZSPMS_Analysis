package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class MiscCodec implements ObjectDeserializer, ObjectSerializer {
  public static final MiscCodec instance = new MiscCodec();
  
  private static Method method_paths_get;
  
  private static boolean method_paths_get_error = false;
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object1;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = 0;
    paramObject = null;
    if (paramType == InetSocketAddress.class) {
      if (jSONLexer.token() == 8) {
        jSONLexer.nextToken();
        return null;
      } 
      paramDefaultJSONParser.accept(12);
      object1 = paramObject;
      while (true) {
        paramObject = jSONLexer.stringVal();
        jSONLexer.nextToken(17);
        if (paramObject.equals("address")) {
          paramDefaultJSONParser.accept(17);
          object1 = paramDefaultJSONParser.parseObject(InetAddress.class);
        } else if (paramObject.equals("port")) {
          paramDefaultJSONParser.accept(17);
          if (jSONLexer.token() == 2) {
            i = jSONLexer.intValue();
            jSONLexer.nextToken();
          } else {
            throw new JSONException("port is not int");
          } 
        } else {
          paramDefaultJSONParser.accept(17);
          paramDefaultJSONParser.parse();
        } 
        if (jSONLexer.token() == 16) {
          jSONLexer.nextToken();
          continue;
        } 
        paramDefaultJSONParser.accept(13);
        return (T)new InetSocketAddress((InetAddress)object1, i);
      } 
    } 
    if (paramDefaultJSONParser.resolveStatus == 2) {
      paramDefaultJSONParser.resolveStatus = 0;
      paramDefaultJSONParser.accept(16);
      if (jSONLexer.token() == 4) {
        if ("val".equals(jSONLexer.stringVal())) {
          jSONLexer.nextToken();
          paramDefaultJSONParser.accept(17);
          paramObject = paramDefaultJSONParser.parse();
          paramDefaultJSONParser.accept(13);
        } else {
          throw new JSONException("syntax error");
        } 
      } else {
        throw new JSONException("syntax error");
      } 
    } else {
      paramObject = paramDefaultJSONParser.parse();
    } 
    if (paramObject == null) {
      paramObject = null;
    } else if (paramObject instanceof String) {
      paramObject = paramObject;
    } else {
      if (paramObject instanceof JSONObject) {
        JSONObject jSONObject = (JSONObject)paramObject;
        if (object1 == Currency.class) {
          paramObject = jSONObject.getString("currency");
          if (paramObject != null)
            return (T)Currency.getInstance((String)paramObject); 
          paramObject = jSONObject.getString("symbol");
          if (paramObject != null)
            return (T)Currency.getInstance((String)paramObject); 
        } 
        if (object1 == Map.Entry.class)
          return jSONObject.entrySet().iterator().next(); 
      } 
      throw new JSONException("expect string");
    } 
    if (paramObject == null || paramObject.length() == 0)
      return null; 
    if (object1 == UUID.class)
      return (T)UUID.fromString((String)paramObject); 
    if (object1 == URI.class)
      return (T)URI.create((String)paramObject); 
    if (object1 == URL.class)
      try {
        return (T)new URL((String)paramObject);
      } catch (MalformedURLException malformedURLException) {
        throw new JSONException("create url error", malformedURLException);
      }  
    if (object1 == Pattern.class)
      return (T)Pattern.compile((String)paramObject); 
    if (object1 == Locale.class)
      return (T)TypeUtils.toLocale((String)paramObject); 
    if (object1 == SimpleDateFormat.class) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String)paramObject, jSONLexer.getLocale());
      simpleDateFormat.setTimeZone(jSONLexer.getTimeZone());
      return (T)simpleDateFormat;
    } 
    if (object1 == InetAddress.class || object1 == Inet4Address.class || object1 == Inet6Address.class)
      try {
        return (T)InetAddress.getByName((String)paramObject);
      } catch (UnknownHostException unknownHostException) {
        throw new JSONException("deserialize inet adress error", unknownHostException);
      }  
    if (object1 == File.class)
      return (T)new File((String)paramObject); 
    if (object1 == TimeZone.class)
      return (T)TimeZone.getTimeZone((String)paramObject); 
    Object object2 = object1;
    if (object1 instanceof ParameterizedType)
      object2 = ((ParameterizedType)object1).getRawType(); 
    if (object2 == Class.class)
      return (T)TypeUtils.loadClass((String)paramObject, unknownHostException.getConfig().getDefaultClassLoader()); 
    if (object2 == Charset.class)
      return (T)Charset.forName((String)paramObject); 
    if (object2 == Currency.class)
      return (T)Currency.getInstance((String)paramObject); 
    if (object2 == JSONPath.class)
      return (T)new JSONPath((String)paramObject); 
    if (object2 instanceof Class) {
      String str = ((Class)object2).getName();
      if (str.equals("java.nio.file.Path"))
        try {
          if (method_paths_get == null && !method_paths_get_error)
            method_paths_get = TypeUtils.loadClass("java.nio.file.Paths").getMethod("get", new Class[] { String.class, String[].class }); 
          if (method_paths_get != null)
            return (T)method_paths_get.invoke(null, new Object[] { paramObject, new String[0] }); 
          object1 = new JSONException();
          super("Path deserialize erorr");
          throw object1;
        } catch (NoSuchMethodException noSuchMethodException) {
          method_paths_get_error = true;
        } catch (IllegalAccessException illegalAccessException) {
          throw new JSONException("Path deserialize erorr", illegalAccessException);
        } catch (InvocationTargetException invocationTargetException) {
          throw new JSONException("Path deserialize erorr", invocationTargetException);
        }  
      object1 = new StringBuilder();
      object1.append("MiscCodec not support ");
      object1.append((String)invocationTargetException);
      throw new JSONException(object1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MiscCodec not support ");
    stringBuilder.append(object2.toString());
    throw new JSONException(stringBuilder.toString());
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object<?> paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    paramObject2 = (Object<?>)paramObject1.getClass();
    if (paramObject2 == SimpleDateFormat.class) {
      String str = ((SimpleDateFormat)paramObject1).toPattern();
      paramObject2 = (Object<?>)str;
      if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
        paramObject2 = (Object<?>)str;
        if (paramObject1.getClass() != paramType) {
          serializeWriter.write(123);
          serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
          paramJSONSerializer.write(paramObject1.getClass().getName());
          serializeWriter.writeFieldValue(',', "val", str);
          serializeWriter.write(125);
          return;
        } 
      } 
    } else if (paramObject2 == Class.class) {
      paramObject2 = (Object<?>)((Class)paramObject1).getName();
    } else {
      if (paramObject2 == InetSocketAddress.class) {
        paramObject2 = (Object<?>)paramObject1;
        paramObject1 = paramObject2.getAddress();
        serializeWriter.write(123);
        if (paramObject1 != null) {
          serializeWriter.writeFieldName("address");
          paramJSONSerializer.write(paramObject1);
          serializeWriter.write(44);
        } 
        serializeWriter.writeFieldName("port");
        serializeWriter.writeInt(paramObject2.getPort());
        serializeWriter.write(125);
        return;
      } 
      if (paramObject1 instanceof File) {
        paramObject2 = (Object<?>)((File)paramObject1).getPath();
      } else if (paramObject1 instanceof InetAddress) {
        paramObject2 = (Object<?>)((InetAddress)paramObject1).getHostAddress();
      } else if (paramObject1 instanceof TimeZone) {
        paramObject2 = (Object<?>)((TimeZone)paramObject1).getID();
      } else if (paramObject1 instanceof Currency) {
        paramObject2 = (Object<?>)((Currency)paramObject1).getCurrencyCode();
      } else {
        if (paramObject1 instanceof JSONStreamAware) {
          ((JSONStreamAware)paramObject1).writeJSONString(serializeWriter);
          return;
        } 
        if (paramObject1 instanceof Iterator) {
          writeIterator(paramJSONSerializer, serializeWriter, (Iterator)paramObject1);
          return;
        } 
        if (paramObject1 instanceof Iterable) {
          writeIterator(paramJSONSerializer, serializeWriter, ((Iterable)paramObject1).iterator());
          return;
        } 
        if (paramObject1 instanceof Map.Entry) {
          paramObject2 = (Object<?>)paramObject1;
          paramObject1 = paramObject2.getKey();
          paramObject2 = paramObject2.getValue();
          if (paramObject1 instanceof String) {
            paramObject1 = paramObject1;
            if (paramObject2 instanceof String) {
              serializeWriter.writeFieldValueStringWithDoubleQuoteCheck('{', (String)paramObject1, (String)paramObject2);
            } else {
              serializeWriter.write(123);
              serializeWriter.writeFieldName((String)paramObject1);
              paramJSONSerializer.write(paramObject2);
            } 
          } else {
            serializeWriter.write(123);
            paramJSONSerializer.write(paramObject1);
            serializeWriter.write(58);
            paramJSONSerializer.write(paramObject2);
          } 
          serializeWriter.write(125);
          return;
        } 
        if (paramObject1.getClass().getName().equals("net.sf.json.JSONNull")) {
          serializeWriter.writeNull();
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not support class : ");
        stringBuilder.append(paramObject2);
        throw new JSONException(stringBuilder.toString());
      } 
    } 
    serializeWriter.writeString((String)paramObject2);
  }
  
  protected void writeIterator(JSONSerializer paramJSONSerializer, SerializeWriter paramSerializeWriter, Iterator<?> paramIterator) {
    paramSerializeWriter.write(91);
    for (byte b = 0; paramIterator.hasNext(); b++) {
      if (b)
        paramSerializeWriter.write(44); 
      paramJSONSerializer.write(paramIterator.next());
    } 
    paramSerializeWriter.write(93);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\MiscCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */