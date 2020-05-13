package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class ArraySerializer implements ObjectSerializer {
  private final ObjectSerializer compObjectSerializer;
  
  private final Class<?> componentType;
  
  public ArraySerializer(Class<?> paramClass, ObjectSerializer paramObjectSerializer) {
    this.componentType = paramClass;
    this.compObjectSerializer = paramObjectSerializer;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    } 
    Object[] arrayOfObject = (Object[])paramObject1;
    int i = arrayOfObject.length;
    SerialContext serialContext = paramJSONSerializer.context;
    paramInt = 0;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      serializeWriter.append('[');
      while (paramInt < i) {
        if (paramInt != 0)
          serializeWriter.append(','); 
        paramObject2 = arrayOfObject[paramInt];
        if (paramObject2 == null) {
          if (serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty) && paramObject1 instanceof String[]) {
            serializeWriter.writeString("");
          } else {
            serializeWriter.append("null");
          } 
        } else if (paramObject2.getClass() == this.componentType) {
          this.compObjectSerializer.write(paramJSONSerializer, paramObject2, Integer.valueOf(paramInt), null, 0);
        } else {
          paramJSONSerializer.getObjectWriter(paramObject2.getClass()).write(paramJSONSerializer, paramObject2, Integer.valueOf(paramInt), null, 0);
        } 
        paramInt++;
      } 
      serializeWriter.append(']');
      return;
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */