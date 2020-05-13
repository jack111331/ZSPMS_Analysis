package com.alibaba.fastjson.serializer;

import com.google.common.collect.Multimap;
import java.io.IOException;
import java.lang.reflect.Type;

public class GuavaCodec implements ObjectSerializer {
  public static GuavaCodec instance = new GuavaCodec();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 instanceof Multimap)
      paramJSONSerializer.write(((Multimap)paramObject1).asMap()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\GuavaCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */