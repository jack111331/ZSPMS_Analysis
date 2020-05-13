package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public interface ObjectDeserializer {
  <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject);
  
  int getFastMatchToken();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */