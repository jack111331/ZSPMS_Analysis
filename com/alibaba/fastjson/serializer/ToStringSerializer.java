package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class ToStringSerializer implements ObjectSerializer {
  public static final ToStringSerializer instance = new ToStringSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    serializeWriter.writeString(paramObject1.toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ToStringSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */