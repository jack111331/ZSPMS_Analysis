package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CalendarCodec implements ObjectDeserializer, ObjectSerializer {
  public static final CalendarCodec instance = new CalendarCodec();
  
  private DatatypeFactory dateFactory;
  
  public XMLGregorianCalendar createXMLGregorianCalendar(Calendar paramCalendar) {
    if (this.dateFactory == null)
      try {
        this.dateFactory = DatatypeFactory.newInstance();
      } catch (DatatypeConfigurationException datatypeConfigurationException) {
        throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", datatypeConfigurationException);
      }  
    return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar)datatypeConfigurationException);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    paramObject = DateCodec.instance.deserialze(paramDefaultJSONParser, paramType, paramObject);
    if (paramObject instanceof Calendar)
      return (T)paramObject; 
    paramObject = paramObject;
    if (paramObject == null)
      return null; 
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    Calendar calendar = Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
    calendar.setTime((Date)paramObject);
    return (T)((paramType == XMLGregorianCalendar.class) ? createXMLGregorianCalendar(calendar) : calendar);
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    char[] arrayOfChar;
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null) {
      paramObject2.writeNull();
      return;
    } 
    if (paramObject1 instanceof XMLGregorianCalendar) {
      paramObject1 = ((XMLGregorianCalendar)paramObject1).toGregorianCalendar();
    } else {
      paramObject1 = paramObject1;
    } 
    if (paramObject2.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
      int i;
      if (paramObject2.isEnabled(SerializerFeature.UseSingleQuotes)) {
        paramInt = 39;
        i = paramInt;
      } else {
        paramInt = 34;
        i = paramInt;
      } 
      paramObject2.append(i);
      int j = paramObject1.get(1);
      int k = paramObject1.get(2) + 1;
      paramInt = paramObject1.get(5);
      int m = paramObject1.get(11);
      int n = paramObject1.get(12);
      int i1 = paramObject1.get(13);
      int i2 = paramObject1.get(14);
      if (i2 != 0) {
        arrayOfChar = "0000-00-00T00:00:00.000".toCharArray();
        IOUtils.getChars(i2, 23, arrayOfChar);
        IOUtils.getChars(i1, 19, arrayOfChar);
        IOUtils.getChars(n, 16, arrayOfChar);
        IOUtils.getChars(m, 13, arrayOfChar);
        IOUtils.getChars(paramInt, 10, arrayOfChar);
        IOUtils.getChars(k, 7, arrayOfChar);
        IOUtils.getChars(j, 4, arrayOfChar);
      } else if (i1 == 0 && n == 0 && m == 0) {
        arrayOfChar = "0000-00-00".toCharArray();
        IOUtils.getChars(paramInt, 10, arrayOfChar);
        IOUtils.getChars(k, 7, arrayOfChar);
        IOUtils.getChars(j, 4, arrayOfChar);
      } else {
        arrayOfChar = "0000-00-00T00:00:00".toCharArray();
        IOUtils.getChars(i1, 19, arrayOfChar);
        IOUtils.getChars(n, 16, arrayOfChar);
        IOUtils.getChars(m, 13, arrayOfChar);
        IOUtils.getChars(paramInt, 10, arrayOfChar);
        IOUtils.getChars(k, 7, arrayOfChar);
        IOUtils.getChars(j, 4, arrayOfChar);
      } 
      paramObject2.write(arrayOfChar);
      paramInt = paramObject1.getTimeZone().getRawOffset() / 3600000;
      if (paramInt == 0) {
        paramObject2.append("Z");
      } else if (paramInt > 0) {
        paramObject2.append("+").append(String.format("%02d", new Object[] { Integer.valueOf(paramInt) })).append(":00");
      } else {
        paramObject2.append("-").append(String.format("%02d", new Object[] { Integer.valueOf(-paramInt) })).append(":00");
      } 
      paramObject2.append(i);
    } else {
      arrayOfChar.write(paramObject1.getTime());
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\CalendarCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */