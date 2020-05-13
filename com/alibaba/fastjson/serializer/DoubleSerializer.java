package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

public class DoubleSerializer implements ObjectSerializer {
  public static final DoubleSerializer instance = new DoubleSerializer();
  
  private DecimalFormat decimalFormat = null;
  
  public DoubleSerializer() {}
  
  public DoubleSerializer(String paramString) {
    this(new DecimalFormat(paramString));
  }
  
  public DoubleSerializer(DecimalFormat paramDecimalFormat) {
    this.decimalFormat = paramDecimalFormat;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
      return;
    } 
    double d = ((Double)paramObject1).doubleValue();
    if (Double.isNaN(d) || Double.isInfinite(d)) {
      serializeWriter.writeNull();
      return;
    } 
    if (this.decimalFormat == null) {
      serializeWriter.writeDouble(d, true);
    } else {
      serializeWriter.write(this.decimalFormat.format(d));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\DoubleSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */