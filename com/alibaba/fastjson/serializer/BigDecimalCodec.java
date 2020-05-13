package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalCodec implements ObjectDeserializer, ObjectSerializer {
  public static final BigDecimalCodec instance = new BigDecimalCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    BigDecimal bigDecimal;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 2) {
      bigDecimal = jSONLexer.decimalValue();
      jSONLexer.nextToken(16);
      return (T)bigDecimal;
    } 
    if (jSONLexer.token() == 3) {
      bigDecimal = jSONLexer.decimalValue();
      jSONLexer.nextToken(16);
      return (T)bigDecimal;
    } 
    Object object = bigDecimal.parse();
    if (object == null) {
      object = null;
    } else {
      object = TypeUtils.castToBigDecimal(object);
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
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null) {
      paramObject2.writeNull(SerializerFeature.WriteNullNumberAsZero);
    } else {
      String str;
      paramObject1 = paramObject1;
      if (paramObject2.isEnabled(SerializerFeature.WriteBigDecimalAsPlain)) {
        str = paramObject1.toPlainString();
      } else {
        str = paramObject1.toString();
      } 
      paramObject2.write(str);
      if (paramObject2.isEnabled(SerializerFeature.WriteClassName) && paramType != BigDecimal.class && paramObject1.scale() == 0)
        paramObject2.write(46); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\BigDecimalCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */