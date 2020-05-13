package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class LongCodec implements ObjectDeserializer, ObjectSerializer {
  public static LongCodec instance = new LongCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object;
    paramObject = paramDefaultJSONParser.lexer;
    int i = paramObject.token();
    if (i == 2) {
      long l = paramObject.longValue();
      paramObject.nextToken(16);
      object = Long.valueOf(l);
    } else {
      if (i == 12) {
        paramObject = new JSONObject(true);
        object.parseObject((Map)paramObject);
        paramObject = TypeUtils.castToLong(paramObject);
      } else {
        paramObject = TypeUtils.castToLong(object.parse());
      } 
      object = paramObject;
      if (paramObject == null)
        return null; 
    } 
    paramObject = object;
    if (paramType == AtomicLong.class)
      paramObject = new AtomicLong(object.longValue()); 
    return (T)paramObject;
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
    } else {
      long l = ((Long)paramObject1).longValue();
      serializeWriter.writeLong(l);
      if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && l <= 2147483647L && l >= -2147483648L && paramType != Long.class && paramType != long.class)
        serializeWriter.write(76); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\LongCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */