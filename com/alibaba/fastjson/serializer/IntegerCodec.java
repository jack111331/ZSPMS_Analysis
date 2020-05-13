package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerCodec implements ObjectDeserializer, ObjectSerializer {
  public static IntegerCodec instance = new IntegerCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Integer integer;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = jSONLexer.token();
    if (i == 8) {
      jSONLexer.nextToken(16);
      return null;
    } 
    if (i == 2) {
      try {
        i = jSONLexer.intValue();
        jSONLexer.nextToken(16);
        integer = Integer.valueOf(i);
      } catch (NumberFormatException numberFormatException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("int value overflow, field : ");
        stringBuilder.append(paramObject);
        throw new JSONException(stringBuilder.toString(), numberFormatException);
      } 
    } else if (i == 3) {
      BigDecimal bigDecimal = jSONLexer.decimalValue();
      jSONLexer.nextToken(16);
      integer = Integer.valueOf(bigDecimal.intValue());
    } else if (i == 12) {
      paramObject = new JSONObject(true);
      integer.parseObject((Map)paramObject);
      integer = TypeUtils.castToInt(paramObject);
    } else {
      integer = TypeUtils.castToInt(integer.parse());
    } 
    return (T)((numberFormatException == AtomicInteger.class) ? new AtomicInteger(integer.intValue()) : integer);
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object<?> paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    paramObject2 = paramObject1;
    if (paramObject2 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
      return;
    } 
    if (paramObject1 instanceof Long) {
      serializeWriter.writeLong(paramObject2.longValue());
    } else {
      serializeWriter.writeInt(paramObject2.intValue());
    } 
    if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
      paramObject1 = (Object<?>)paramObject2.getClass();
      if (paramObject1 == Byte.class) {
        serializeWriter.write(66);
      } else if (paramObject1 == Short.class) {
        serializeWriter.write(83);
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\IntegerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */