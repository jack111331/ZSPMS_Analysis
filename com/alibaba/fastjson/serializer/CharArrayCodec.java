package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Iterator;

public class CharArrayCodec implements ObjectDeserializer {
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    Number number;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 4) {
      String str = jSONLexer.stringVal();
      jSONLexer.nextToken(16);
      return (T)str.toCharArray();
    } 
    if (jSONLexer.token() == 2) {
      number = jSONLexer.integerValue();
      jSONLexer.nextToken(16);
      return (T)number.toString().toCharArray();
    } 
    Object object = number.parse();
    if (object instanceof String)
      return (T)((String)object).toCharArray(); 
    if (object instanceof java.util.Collection) {
      byte b;
      object = object;
      Iterator<JSONLexer> iterator = object.iterator();
      while (true) {
        boolean bool = iterator.hasNext();
        b = 1;
        if (bool) {
          jSONLexer = iterator.next();
          if (jSONLexer instanceof String && ((String)jSONLexer).length() != 1) {
            b = 0;
            break;
          } 
          continue;
        } 
        break;
      } 
      if (b) {
        char[] arrayOfChar = new char[object.size()];
        object = object.iterator();
        for (b = 0; object.hasNext(); b++)
          arrayOfChar[b] = ((String)object.next()).charAt(0); 
        return (T)arrayOfChar;
      } 
      throw new JSONException("can not cast to char[]");
    } 
    if (object == null) {
      object = null;
    } else {
      object = JSON.toJSONString(object).toCharArray();
    } 
    return (T)object;
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken() {
    return 4;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\CharArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */