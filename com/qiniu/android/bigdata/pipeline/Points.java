package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.utils.FastDatePrinter;
import com.qiniu.android.utils.Json;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class Points {
  private static String buildString(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Integer || paramObject instanceof Long || paramObject instanceof Float || paramObject instanceof Double || paramObject instanceof Boolean)
      return paramObject.toString(); 
    if (paramObject instanceof String) {
      paramObject = ((String)paramObject).replace("\n", "\\n").replace("\t", "\\t");
    } else if (paramObject instanceof Collection) {
      paramObject = Json.encodeList((Collection)paramObject);
    } else if (paramObject instanceof Map) {
      paramObject = Json.encodeMap((Map)paramObject);
    } else if (paramObject instanceof Date) {
      paramObject = LazyHolder.INSTANCE.format((Date)paramObject);
    } else {
      paramObject = paramObject.toString();
    } 
    return (String)paramObject;
  }
  
  public static StringBuilder formatPoint(Object paramObject, StringBuilder paramStringBuilder) {
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    new Points();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = arrayOfField.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        Field field = arrayOfField[b];
        try {
          Object object = field.get(paramObject);
          hashMap.put(field.getName(), object);
        } catch (IllegalAccessException illegalAccessException) {}
        b++;
        continue;
      } 
      return formatPoint((Map)hashMap, paramStringBuilder);
    } 
  }
  
  public static <V> StringBuilder formatPoint(Map<String, V> paramMap, StringBuilder paramStringBuilder) {
    for (Map.Entry<String, V> entry : paramMap.entrySet()) {
      paramStringBuilder.append((String)entry.getKey());
      paramStringBuilder.append("=");
      paramStringBuilder.append(buildString(entry.getValue()));
      paramStringBuilder.append("\t");
    } 
    paramStringBuilder.replace(paramStringBuilder.length() - 1, paramStringBuilder.length(), "\n");
    return paramStringBuilder;
  }
  
  public static <V> StringBuilder formatPoints(List<Map<String, V>> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<Map<String, V>> iterator = paramList.iterator();
    while (iterator.hasNext())
      formatPoint(iterator.next(), stringBuilder); 
    return stringBuilder;
  }
  
  public static StringBuilder formatPoints(Object[] paramArrayOfObject) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfObject.length;
    for (byte b = 0; b < i; b++)
      formatPoint(paramArrayOfObject[b], stringBuilder); 
    return stringBuilder;
  }
  
  public static <V> StringBuilder formatPoints(Map<String, V>[] paramArrayOfMap) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfMap.length;
    for (byte b = 0; b < i; b++)
      formatPoint(paramArrayOfMap[b], stringBuilder); 
    return stringBuilder;
  }
  
  public static <V> StringBuilder formatPointsObjects(List<V> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<V> iterator = paramList.iterator();
    while (iterator.hasNext())
      formatPoint(iterator.next(), stringBuilder); 
    return stringBuilder;
  }
  
  private static class LazyHolder {
    private static final FastDatePrinter INSTANCE = new FastDatePrinter("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Calendar.getInstance().getTimeZone(), Locale.getDefault());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\bigdata\pipeline\Points.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */