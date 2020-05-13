package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FloatCodec implements ObjectDeserializer, ObjectSerializer {
  public static FloatCodec instance = new FloatCodec();
  
  private NumberFormat decimalFormat;
  
  public FloatCodec() {}
  
  public FloatCodec(String paramString) {
    this(new DecimalFormat(paramString));
  }
  
  public FloatCodec(DecimalFormat paramDecimalFormat) {
    this.decimalFormat = paramDecimalFormat;
  }
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    String str;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 2) {
      str = jSONLexer.numberString();
      jSONLexer.nextToken(16);
      return (T)Float.valueOf(Float.parseFloat(str));
    } 
    if (jSONLexer.token() == 3) {
      float f = jSONLexer.floatValue();
      jSONLexer.nextToken(16);
      return (T)Float.valueOf(f);
    } 
    Object object = str.parse();
    return (T)((object == null) ? null : TypeUtils.castToFloat(object));
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
    float f = ((Float)paramObject1).floatValue();
    if (this.decimalFormat != null) {
      serializeWriter.write(this.decimalFormat.format(f));
    } else {
      serializeWriter.writeFloat(f, true);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\FloatCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */