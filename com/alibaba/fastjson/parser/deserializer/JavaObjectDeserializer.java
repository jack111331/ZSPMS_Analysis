package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

public class JavaObjectDeserializer implements ObjectDeserializer {
  public static final JavaObjectDeserializer instance = new JavaObjectDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object[] arrayOfObject;
    Object object;
    if (paramType instanceof GenericArrayType) {
      paramObject = ((GenericArrayType)paramType).getGenericComponentType();
      object = paramObject;
      if (paramObject instanceof TypeVariable)
        object = ((TypeVariable)paramObject).getBounds()[0]; 
      paramObject = new ArrayList();
      paramDefaultJSONParser.parseArray((Type)object, (Collection)paramObject);
      if (object instanceof Class) {
        arrayOfObject = (Object[])Array.newInstance((Class)object, paramObject.size());
        paramObject.toArray(arrayOfObject);
        return (T)arrayOfObject;
      } 
      return (T)paramObject.toArray();
    } 
    return (T)((object instanceof Class && object != Object.class && object != Serializable.class) ? arrayOfObject.parseObject((Type)object) : arrayOfObject.parse(paramObject));
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\JavaObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */