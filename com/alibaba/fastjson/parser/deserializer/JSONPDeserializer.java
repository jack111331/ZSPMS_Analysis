package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import java.lang.reflect.Type;

public class JSONPDeserializer implements ObjectDeserializer {
  public static final JSONPDeserializer instance = new JSONPDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    JSONLexerBase jSONLexerBase = (JSONLexerBase)paramDefaultJSONParser.getLexer();
    paramObject = jSONLexerBase.scanSymbolUnQuoted(paramDefaultJSONParser.getSymbolTable());
    jSONLexerBase.nextToken();
    int i = jSONLexerBase.token();
    int j = i;
    Object object = paramObject;
    if (i == 25) {
      object = jSONLexerBase.scanSymbolUnQuoted(paramDefaultJSONParser.getSymbolTable());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((String)paramObject);
      stringBuilder1.append(".");
      String str = stringBuilder1.toString();
      paramObject = new StringBuilder();
      paramObject.append(str);
      paramObject.append((String)object);
      object = paramObject.toString();
      jSONLexerBase.nextToken();
      j = jSONLexerBase.token();
    } 
    object = new JSONPObject((String)object);
    if (j == 10) {
      jSONLexerBase.nextToken();
      while (true) {
        object.addParameter(paramDefaultJSONParser.parse());
        j = jSONLexerBase.token();
        if (j == 16) {
          jSONLexerBase.nextToken();
          continue;
        } 
        if (j == 11) {
          jSONLexerBase.nextToken();
          if (jSONLexerBase.token() == 24)
            jSONLexerBase.nextToken(); 
          return (T)object;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("illegal jsonp : ");
        stringBuilder1.append(jSONLexerBase.info());
        throw new JSONException(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("illegal jsonp : ");
    stringBuilder.append(jSONLexerBase.info());
    throw new JSONException(stringBuilder.toString());
  }
  
  public int getFastMatchToken() {
    return 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\JSONPDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */