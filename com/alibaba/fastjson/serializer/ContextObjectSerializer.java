package com.alibaba.fastjson.serializer;

import java.io.IOException;

public interface ContextObjectSerializer extends ObjectSerializer {
  void write(JSONSerializer paramJSONSerializer, Object paramObject, BeanContext paramBeanContext) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ContextObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */