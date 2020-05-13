package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer implements ObjectDeserializer {
  public static MapDeserializer instance = new MapDeserializer();
  
  public static Object parseMap(DefaultJSONParser paramDefaultJSONParser, Map<Object, Object> paramMap, Type paramType1, Type paramType2, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
      ObjectDeserializer objectDeserializer1 = paramDefaultJSONParser.getConfig().getDeserializer(paramType1);
      ObjectDeserializer objectDeserializer2 = paramDefaultJSONParser.getConfig().getDeserializer(paramType2);
      jSONLexer.nextToken(objectDeserializer1.getFastMatchToken());
      paramObject = paramDefaultJSONParser.getContext();
      try {
        while (true) {
          JSONException jSONException1;
          StringBuilder stringBuilder2;
          if (jSONLexer.token() == 13) {
            jSONLexer.nextToken(16);
            return paramMap;
          } 
          int i = jSONLexer.token();
          Object object1 = null;
          if (i == 4 && jSONLexer.isRef() && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
            jSONLexer.nextTokenWithColon(4);
            if (jSONLexer.token() == 4) {
              Object object = jSONLexer.stringVal();
              if ("..".equals(object)) {
                object = ((ParseContext)paramObject).parent.object;
              } else if ("$".equals(object)) {
                for (object = paramObject; ((ParseContext)object).parent != null; object = ((ParseContext)object).parent);
                object = ((ParseContext)object).object;
              } else {
                DefaultJSONParser.ResolveTask resolveTask = new DefaultJSONParser.ResolveTask();
                this((ParseContext)paramObject, (String)object);
                paramDefaultJSONParser.addResolveTask(resolveTask);
                paramDefaultJSONParser.setResolveStatus(1);
                object = object1;
              } 
              jSONLexer.nextToken(13);
              if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                return object;
              } 
              object = new JSONException();
              super("illegal ref");
              throw object;
            } 
            jSONException1 = new JSONException();
            stringBuilder2 = new StringBuilder();
            this();
            stringBuilder2.append("illegal ref, ");
            stringBuilder2.append(JSONToken.name(jSONLexer.token()));
            this(stringBuilder2.toString());
            throw jSONException1;
          } 
          if (jSONException1.size() == 0 && jSONLexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
            jSONLexer.nextTokenWithColon(4);
            jSONLexer.nextToken(16);
            if (jSONLexer.token() == 13) {
              jSONLexer.nextToken();
              return jSONException1;
            } 
            jSONLexer.nextToken(objectDeserializer1.getFastMatchToken());
          } 
          Object object2 = objectDeserializer1.deserialze(paramDefaultJSONParser, (Type)stringBuilder2, null);
          if (jSONLexer.token() == 17) {
            jSONLexer.nextToken(objectDeserializer2.getFastMatchToken());
            object1 = objectDeserializer2.deserialze(paramDefaultJSONParser, paramType2, object2);
            paramDefaultJSONParser.checkMapResolve((Map)jSONException1, object2);
            jSONException1.put(object2, object1);
            if (jSONLexer.token() == 16)
              jSONLexer.nextToken(objectDeserializer1.getFastMatchToken()); 
            continue;
          } 
          JSONException jSONException2 = new JSONException();
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append("syntax error, expect :, actual ");
          stringBuilder1.append(jSONLexer.token());
          this(stringBuilder1.toString());
          throw jSONException2;
        } 
      } finally {
        paramDefaultJSONParser.setContext((ParseContext)paramObject);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect {, actual ");
    stringBuilder.append(jSONLexer.tokenName());
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Map parseMap(DefaultJSONParser paramDefaultJSONParser, Map<String, Object> paramMap, Type paramType, Object paramObject) {
    Object object;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = jSONLexer.token();
    byte b = 0;
    if (i != 12) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("syntax error, expect {, actual ");
      stringBuilder2.append(jSONLexer.tokenName());
      String str4 = stringBuilder2.toString();
      String str2 = str4;
      if (paramObject instanceof String) {
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str4);
        stringBuilder4.append(", fieldName ");
        str2 = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(str2);
        stringBuilder5.append(paramObject);
        str2 = stringBuilder5.toString();
      } 
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(str2);
      stringBuilder3.append(", ");
      String str3 = stringBuilder3.toString();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3);
      stringBuilder1.append(jSONLexer.info());
      String str1 = stringBuilder1.toString();
      JSONArray jSONArray = new JSONArray();
      paramDefaultJSONParser.parseArray((Collection)jSONArray, paramObject);
      if (jSONArray.size() == 1) {
        object = jSONArray.get(0);
        if (object instanceof JSONObject)
          return (Map)object; 
      } 
      throw new JSONException(str1);
    } 
    ParseContext parseContext = object.getContext();
    try {
      while (true) {
        JSONException jSONException;
        Map<ParserConfig, Object> map;
        StringBuilder stringBuilder;
        String str1;
        ParserConfig parserConfig;
        jSONLexer.skipWhitespace();
        i = jSONLexer.getCurrent();
        int j = i;
        if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas))
          while (true) {
            j = i;
            if (i == 44) {
              jSONLexer.next();
              jSONLexer.skipWhitespace();
              i = jSONLexer.getCurrent();
              continue;
            } 
            break;
          }  
        if (j == 34) {
          str1 = jSONLexer.scanSymbol(object.getSymbolTable(), '"');
          jSONLexer.skipWhitespace();
          if (jSONLexer.getCurrent() != ':') {
            jSONException = new JSONException();
            stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("expect ':' at ");
            stringBuilder.append(jSONLexer.pos());
            this(stringBuilder.toString());
            throw jSONException;
          } 
        } else {
          if (j == 125) {
            jSONLexer.next();
            jSONLexer.resetStringPosition();
            jSONLexer.nextToken(16);
            return (Map)jSONException;
          } 
          if (j == 39) {
            if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
              str1 = jSONLexer.scanSymbol(object.getSymbolTable(), '\'');
              jSONLexer.skipWhitespace();
              if (jSONLexer.getCurrent() != ':') {
                jSONException = new JSONException();
                stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("expect ':' at ");
                stringBuilder.append(jSONLexer.pos());
                this(stringBuilder.toString());
                throw jSONException;
              } 
            } else {
              jSONException = new JSONException();
              this("syntax error");
              throw jSONException;
            } 
          } else if (jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
            str1 = jSONLexer.scanSymbolUnQuoted(object.getSymbolTable());
            jSONLexer.skipWhitespace();
            char c = jSONLexer.getCurrent();
            if (c != ':') {
              jSONException = new JSONException();
              stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("expect ':' at ");
              stringBuilder.append(jSONLexer.pos());
              stringBuilder.append(", actual ");
              stringBuilder.append(c);
              this(stringBuilder.toString());
              throw jSONException;
            } 
          } else {
            jSONException = new JSONException();
            this("syntax error");
            throw jSONException;
          } 
        } 
        jSONLexer.next();
        jSONLexer.skipWhitespace();
        jSONLexer.getCurrent();
        jSONLexer.resetStringPosition();
        String str2 = JSON.DEFAULT_TYPE_KEY;
        String str3 = null;
        if (str1 == str2 && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
          str3 = jSONLexer.scanSymbol(object.getSymbolTable(), '"');
          parserConfig = object.getConfig();
          Class<?> clazz = parserConfig.checkAutoType(str3, null);
          if (Map.class.isAssignableFrom(clazz)) {
            jSONLexer.nextToken(16);
            if (jSONLexer.token() == 13) {
              jSONLexer.nextToken(16);
              return (Map)jSONException;
            } 
          } else {
            ObjectDeserializer objectDeserializer = parserConfig.getDeserializer(clazz);
            jSONLexer.nextToken(16);
            object.setResolveStatus(2);
            if (parseContext != null && !(paramObject instanceof Integer))
              object.popContext(); 
            map = objectDeserializer.<Map>deserialze((DefaultJSONParser)object, clazz, paramObject);
            return map;
          } 
        } else {
          Object object1;
          jSONLexer.nextToken();
          if (b)
            object.setContext(parseContext); 
          if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
          } else {
            object1 = object.parseObject((Type)stringBuilder, parserConfig);
          } 
          map.put(parserConfig, object1);
          object.checkMapResolve(map, parserConfig);
          object.setContext(parseContext, object1, parserConfig);
          object.setContext(parseContext);
          i = jSONLexer.token();
          if (i != 20) {
            if (i == 15)
              return map; 
            if (i == 13) {
              jSONLexer.nextToken();
              return map;
            } 
          } else {
            continue;
          } 
        } 
        b++;
      } 
    } finally {
      object.setContext(parseContext);
    } 
  }
  
  protected Map<Object, Object> createMap(Type paramType) {
    if (paramType == Properties.class)
      return new Properties(); 
    if (paramType == Hashtable.class)
      return new Hashtable<Object, Object>(); 
    if (paramType == IdentityHashMap.class)
      return new IdentityHashMap<Object, Object>(); 
    if (paramType == SortedMap.class || paramType == TreeMap.class)
      return new TreeMap<Object, Object>(); 
    if (paramType == ConcurrentMap.class || paramType == ConcurrentHashMap.class)
      return new ConcurrentHashMap<Object, Object>(); 
    if (paramType == Map.class || paramType == HashMap.class)
      return new HashMap<Object, Object>(); 
    if (paramType == LinkedHashMap.class)
      return new LinkedHashMap<Object, Object>(); 
    if (paramType instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType)paramType;
      paramType = parameterizedType.getRawType();
      return EnumMap.class.equals(paramType) ? new EnumMap<Object, Object>((Class)parameterizedType.getActualTypeArguments()[0]) : createMap(paramType);
    } 
    Class<Map> clazz = (Class)paramType;
    if (!clazz.isInterface())
      try {
        return clazz.newInstance();
      } catch (Exception exception) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("unsupport type ");
        stringBuilder1.append(paramType);
        throw new JSONException(stringBuilder1.toString(), exception);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unsupport type ");
    stringBuilder.append(paramType);
    throw new JSONException(stringBuilder.toString());
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    if (paramType == JSONObject.class && paramDefaultJSONParser.getFieldTypeResolver() == null)
      return (T)paramDefaultJSONParser.parseObject(); 
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 8) {
      jSONLexer.nextToken(16);
      return null;
    } 
    Map<Object, Object> map = createMap(paramType);
    ParseContext parseContext = paramDefaultJSONParser.getContext();
    try {
      paramDefaultJSONParser.setContext(parseContext, map, paramObject);
      return (T)deserialze(paramDefaultJSONParser, paramType, paramObject, map);
    } finally {
      paramDefaultJSONParser.setContext(parseContext);
    } 
  }
  
  protected Object deserialze(DefaultJSONParser paramDefaultJSONParser, Type<List> paramType, Object paramObject, Map<String, Object> paramMap) {
    if (paramType instanceof ParameterizedType) {
      paramType = paramType;
      Type type = paramType.getActualTypeArguments()[0];
      if (paramMap.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
        paramType = List.class;
      } else {
        paramType = paramType.getActualTypeArguments()[1];
      } 
      return (String.class == type) ? parseMap(paramDefaultJSONParser, paramMap, paramType, paramObject) : parseMap(paramDefaultJSONParser, (Map)paramMap, type, paramType, paramObject);
    } 
    return paramDefaultJSONParser.parseObject(paramMap, paramObject);
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\MapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */