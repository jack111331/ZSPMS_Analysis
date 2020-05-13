package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

public interface ExtraTypeProvider extends ParseProcess {
  Type getExtraType(Object paramObject, String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ExtraTypeProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */