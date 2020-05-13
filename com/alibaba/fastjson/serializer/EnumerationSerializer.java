package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public class EnumerationSerializer implements ObjectSerializer {
  public static EnumerationSerializer instance = new EnumerationSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    } 
    Type type1 = null;
    boolean bool = serializeWriter.isEnabled(SerializerFeature.WriteClassName);
    paramInt = 0;
    Type type2 = type1;
    if (bool) {
      type2 = type1;
      if (paramType instanceof ParameterizedType)
        type2 = ((ParameterizedType)paramType).getActualTypeArguments()[0]; 
    } 
    Enumeration enumeration = (Enumeration)paramObject1;
    SerialContext serialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      serializeWriter.append('[');
      while (enumeration.hasMoreElements()) {
        paramObject1 = enumeration.nextElement();
        int i = paramInt + 1;
        if (paramInt != 0)
          serializeWriter.append(','); 
        if (paramObject1 == null) {
          serializeWriter.writeNull();
        } else {
          paramJSONSerializer.getObjectWriter(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(i - 1), type2, 0);
        } 
        paramInt = i;
      } 
      serializeWriter.append(']');
      return;
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\EnumerationSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */