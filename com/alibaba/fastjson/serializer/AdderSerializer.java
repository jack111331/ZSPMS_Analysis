package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class AdderSerializer implements ObjectSerializer {
  public static final AdderSerializer instance = new AdderSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 instanceof LongAdder) {
      serializeWriter.writeFieldValue('{', "value", ((LongAdder)paramObject1).longValue());
      serializeWriter.write(125);
    } else if (paramObject1 instanceof DoubleAdder) {
      serializeWriter.writeFieldValue('{', "value", ((DoubleAdder)paramObject1).doubleValue());
      serializeWriter.write(125);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\AdderSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */