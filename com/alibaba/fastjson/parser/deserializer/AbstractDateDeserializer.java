package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractDateDeserializer extends ContextObjectDeserializer implements ObjectDeserializer {
  protected abstract <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2);
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser, paramType, paramObject, null, 0);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, String paramString, int paramInt) {
    StringBuilder stringBuilder;
    Object object;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    paramInt = jSONLexer.token();
    Type type1 = null;
    Type type2 = null;
    if (paramInt == 2) {
      object = Long.valueOf(jSONLexer.longValue());
      jSONLexer.nextToken(16);
      type2 = paramType;
    } else {
      JSONScanner jSONScanner;
      if (jSONLexer.token() == 4) {
        Type type4;
        String str = jSONLexer.stringVal();
        type1 = type2;
        if (object != null) {
          String str1;
          try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            this((String)object, JSON.defaultLocale);
          } catch (IllegalArgumentException illegalArgumentException) {
            if (object.equals("yyyy-MM-ddTHH:mm:ss.SSS")) {
              str1 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            } else if (str1.equals("yyyy-MM-ddTHH:mm:ss")) {
              str1 = "yyyy-MM-dd'T'HH:mm:ss";
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            } else {
              illegalArgumentException = null;
            } 
          } 
          try {
            Date date = illegalArgumentException.parse(str);
          } catch (ParseException parseException) {
            type4 = type2;
            if (str1.equals("yyyy-MM-dd'T'HH:mm:ss.SSS")) {
              type4 = type2;
              if (str.length() == 19)
                try {
                  SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                  this("yyyy-MM-dd'T'HH:mm:ss");
                  Date date = simpleDateFormat.parse(str);
                } catch (ParseException parseException1) {
                  type4 = type2;
                }  
            } 
          } 
        } 
        Type type3 = type4;
        type2 = paramType;
        if (type4 == null) {
          jSONLexer.nextToken(16);
          String str1 = str;
          if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
            jSONScanner = new JSONScanner(str);
            str1 = str;
            if (jSONScanner.scanISO8601DateIfMatch())
              Date date = jSONScanner.getCalendar().getTime(); 
            jSONScanner.close();
          } 
          type2 = paramType;
        } 
      } else if (jSONLexer.token() == 8) {
        jSONLexer.nextToken();
        JSONScanner jSONScanner1 = jSONScanner;
        type2 = paramType;
      } else if (jSONLexer.token() == 12) {
        jSONLexer.nextToken();
        if (jSONLexer.token() == 4) {
          String str = jSONLexer.stringVal();
          Type type = paramType;
          if (JSON.DEFAULT_TYPE_KEY.equals(str)) {
            jSONLexer.nextToken();
            paramDefaultJSONParser.accept(17);
            str = jSONLexer.stringVal();
            Class clazz = paramDefaultJSONParser.getConfig().checkAutoType(str, null);
            if (clazz != null)
              paramType = clazz; 
            paramDefaultJSONParser.accept(4);
            paramDefaultJSONParser.accept(16);
            type = paramType;
          } 
          jSONLexer.nextTokenWithColon(2);
          if (jSONLexer.token() == 2) {
            long l = jSONLexer.longValue();
            jSONLexer.nextToken();
            Long long_ = Long.valueOf(l);
            paramDefaultJSONParser.accept(13);
            type2 = type;
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("syntax error : ");
            stringBuilder.append(jSONLexer.tokenName());
            throw new JSONException(stringBuilder.toString());
          } 
        } else {
          throw new JSONException("syntax error");
        } 
      } else if (stringBuilder.getResolveStatus() == 2) {
        stringBuilder.setResolveStatus(0);
        stringBuilder.accept(16);
        if (jSONLexer.token() == 4) {
          if ("val".equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            stringBuilder.accept(17);
            Object object1 = stringBuilder.parse();
            stringBuilder.accept(13);
            type2 = paramType;
          } else {
            throw new JSONException("syntax error");
          } 
        } else {
          throw new JSONException("syntax error");
        } 
      } else {
        object = stringBuilder.parse();
        type2 = paramType;
      } 
    } 
    return cast((DefaultJSONParser)stringBuilder, type2, paramObject, object);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\AbstractDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */