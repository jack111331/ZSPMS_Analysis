package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;

public class EnumDeserializer implements ObjectDeserializer {
  private final Class<?> enumClass;
  
  protected long[] enumNameHashCodes;
  
  protected final Enum[] enums;
  
  protected final Enum[] ordinalEnums;
  
  public EnumDeserializer(Class<?> paramClass) {
    this.enumClass = paramClass;
    this.ordinalEnums = (Enum[])paramClass.getEnumConstants();
    long[] arrayOfLong = new long[this.ordinalEnums.length];
    this.enumNameHashCodes = new long[this.ordinalEnums.length];
    byte b;
    for (b = 0; b < this.ordinalEnums.length; b++) {
      String str = this.ordinalEnums[b].name();
      long l = -2128831035L;
      for (byte b1 = 0; b1 < str.length(); b1++)
        l = (l ^ str.charAt(b1)) * 16777619L; 
      arrayOfLong[b] = l;
      this.enumNameHashCodes[b] = l;
    } 
    Arrays.sort(this.enumNameHashCodes);
    this.enums = new Enum[this.ordinalEnums.length];
    for (b = 0; b < this.enumNameHashCodes.length; b++) {
      for (byte b1 = 0; b1 < arrayOfLong.length; b1++) {
        if (this.enumNameHashCodes[b] == arrayOfLong[b1]) {
          this.enums[b] = this.ordinalEnums[b1];
          break;
        } 
      } 
    } 
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    try {
      String str;
      StringBuilder stringBuilder;
      JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
      int i = jSONLexer.token();
      if (i == 2) {
        i = jSONLexer.intValue();
        jSONLexer.nextToken(16);
        if (i >= 0 && i <= this.ordinalEnums.length)
          return (T)this.ordinalEnums[i]; 
        JSONException jSONException1 = new JSONException();
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("parse enum ");
        stringBuilder.append(this.enumClass.getName());
        stringBuilder.append(" error, value : ");
        stringBuilder.append(i);
        this(stringBuilder.toString());
        throw jSONException1;
      } 
      if (i == 4) {
        str = stringBuilder.stringVal();
        stringBuilder.nextToken(16);
        return (T)((str.length() == 0) ? null : Enum.valueOf(this.enumClass, str));
      } 
      if (i == 8) {
        stringBuilder.nextToken(16);
        return null;
      } 
      Object object = str.parse();
      JSONException jSONException = new JSONException();
      paramObject = new StringBuilder();
      super();
      paramObject.append("parse enum ");
      paramObject.append(this.enumClass.getName());
      paramObject.append(" error, value : ");
      paramObject.append(object);
      this(paramObject.toString());
      throw jSONException;
    } catch (JSONException jSONException) {
      throw jSONException;
    } catch (Exception exception) {
      throw new JSONException(exception.getMessage(), exception);
    } 
  }
  
  public Enum getEnumByHashCode(long paramLong) {
    if (this.enums == null)
      return null; 
    int i = Arrays.binarySearch(this.enumNameHashCodes, paramLong);
    return (i < 0) ? null : this.enums[i];
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public Enum<?> valueOf(int paramInt) {
    return this.ordinalEnums[paramInt];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\EnumDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */