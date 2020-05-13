package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public interface ObjectSerializer {
  void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */