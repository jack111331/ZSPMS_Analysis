package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionCodec implements ObjectDeserializer, ObjectSerializer {
  public static final CollectionCodec instance = new CollectionCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    JSONArray jSONArray;
    if (paramDefaultJSONParser.lexer.token() == 8) {
      paramDefaultJSONParser.lexer.nextToken(16);
      return null;
    } 
    if (paramType == JSONArray.class) {
      jSONArray = new JSONArray();
      paramDefaultJSONParser.parseArray((Collection)jSONArray);
      return (T)jSONArray;
    } 
    Collection collection = TypeUtils.createCollection((Type)jSONArray);
    paramDefaultJSONParser.parseArray(TypeUtils.getCollectionItemType((Type)jSONArray), collection, paramObject);
    return (T)collection;
  }
  
  public int getFastMatchToken() {
    return 14;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object<?> paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    } 
    Type type = null;
    if (serializeWriter.isEnabled(SerializerFeature.WriteClassName))
      type = TypeUtils.getCollectionItemType(paramType); 
    Collection collection = (Collection)paramObject1;
    SerialContext serialContext = paramJSONSerializer.context;
    paramInt = 0;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    if (serializeWriter.isEnabled(SerializerFeature.WriteClassName))
      if (HashSet.class == collection.getClass()) {
        serializeWriter.append("Set");
      } else if (TreeSet.class == collection.getClass()) {
        serializeWriter.append("TreeSet");
      }  
    try {
      serializeWriter.append('[');
      for (Object paramObject1 : collection) {
        int i = paramInt + 1;
        if (paramInt != 0)
          serializeWriter.append(','); 
        if (paramObject1 == null) {
          serializeWriter.writeNull();
        } else {
          paramObject2 = (Object<?>)paramObject1.getClass();
          if (paramObject2 == Integer.class) {
            serializeWriter.writeInt(((Integer)paramObject1).intValue());
          } else if (paramObject2 == Long.class) {
            serializeWriter.writeLong(((Long)paramObject1).longValue());
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName))
              serializeWriter.write(76); 
          } else {
            paramJSONSerializer.getObjectWriter((Class<?>)paramObject2).write(paramJSONSerializer, paramObject1, Integer.valueOf(i - 1), type, 0);
          } 
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\CollectionCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */