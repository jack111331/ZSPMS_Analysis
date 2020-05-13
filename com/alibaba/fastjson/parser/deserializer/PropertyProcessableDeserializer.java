package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public class PropertyProcessableDeserializer implements ObjectDeserializer {
  public final Class<PropertyProcessable> type;
  
  public PropertyProcessableDeserializer(Class<PropertyProcessable> paramClass) {
    this.type = paramClass;
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    try {
      PropertyProcessable propertyProcessable = this.type.newInstance();
      return (T)paramDefaultJSONParser.parse(propertyProcessable, paramObject);
    } catch (Exception exception) {
      throw new JSONException("craete instance error");
    } 
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\PropertyProcessableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */