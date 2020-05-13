package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

public class BigIntegerCodec implements ObjectDeserializer, ObjectSerializer {
  public static final BigIntegerCodec instance = new BigIntegerCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    String str;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 2) {
      str = jSONLexer.numberString();
      jSONLexer.nextToken(16);
      return (T)new BigInteger(str);
    } 
    Object object = str.parse();
    if (object == null) {
      object = null;
    } else {
      object = TypeUtils.castToBigInteger(object);
    } 
    return (T)object;
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
      return;
    } 
    serializeWriter.write(((BigInteger)paramObject1).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\BigIntegerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */