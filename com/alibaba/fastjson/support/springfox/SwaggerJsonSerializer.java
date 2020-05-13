package com.alibaba.fastjson.support.springfox;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

public class SwaggerJsonSerializer implements ObjectSerializer {
  public static final SwaggerJsonSerializer instance = new SwaggerJsonSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramJSONSerializer.getWriter().write(((Json)paramObject1).value());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\springfox\SwaggerJsonSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */