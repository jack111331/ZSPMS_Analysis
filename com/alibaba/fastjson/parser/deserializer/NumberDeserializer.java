package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class NumberDeserializer implements ObjectDeserializer {
  public static final NumberDeserializer instance = new NumberDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    BigDecimal bigDecimal;
    StringBuilder stringBuilder;
    paramObject = paramDefaultJSONParser.lexer;
    if (paramObject.token() == 2) {
      if (paramType == double.class || paramType == Double.class) {
        String str = paramObject.numberString();
        paramObject.nextToken(16);
        return (T)Double.valueOf(Double.parseDouble(str));
      } 
      long l = paramObject.longValue();
      paramObject.nextToken(16);
      if (paramType == short.class || paramType == Short.class) {
        if (l <= 32767L && l >= -32768L)
          return (T)Short.valueOf((short)(int)l); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("short overflow : ");
        stringBuilder1.append(l);
        throw new JSONException(stringBuilder1.toString());
      } 
      if (paramType == byte.class || paramType == Byte.class) {
        if (l <= 127L && l >= -128L)
          return (T)Byte.valueOf((byte)(int)l); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("short overflow : ");
        stringBuilder1.append(l);
        throw new JSONException(stringBuilder1.toString());
      } 
      return (T)((l >= -2147483648L && l <= 2147483647L) ? Integer.valueOf((int)l) : Long.valueOf(l));
    } 
    if (paramObject.token() == 3) {
      if (paramType == double.class || paramType == Double.class) {
        String str = paramObject.numberString();
        paramObject.nextToken(16);
        return (T)Double.valueOf(Double.parseDouble(str));
      } 
      bigDecimal = paramObject.decimalValue();
      paramObject.nextToken(16);
      if (paramType == short.class || paramType == Short.class) {
        if (bigDecimal.compareTo(BigDecimal.valueOf(32767L)) <= 0 && bigDecimal.compareTo(BigDecimal.valueOf(-32768L)) >= 0)
          return (T)Short.valueOf(bigDecimal.shortValue()); 
        stringBuilder = new StringBuilder();
        stringBuilder.append("short overflow : ");
        stringBuilder.append(bigDecimal);
        throw new JSONException(stringBuilder.toString());
      } 
      return (T)((stringBuilder == byte.class || stringBuilder == Byte.class) ? Byte.valueOf(bigDecimal.byteValue()) : bigDecimal);
    } 
    Object object = bigDecimal.parse();
    return (T)((object == null) ? null : ((stringBuilder == double.class || stringBuilder == Double.class) ? TypeUtils.castToDouble(object) : ((stringBuilder == short.class || stringBuilder == Short.class) ? TypeUtils.castToShort(object) : ((stringBuilder == byte.class || stringBuilder == Byte.class) ? TypeUtils.castToByte(object) : TypeUtils.castToBigDecimal(object)))));
  }
  
  public int getFastMatchToken() {
    return 2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\NumberDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */