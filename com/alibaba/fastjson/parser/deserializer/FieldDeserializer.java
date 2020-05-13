package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class FieldDeserializer {
  protected BeanContext beanContext;
  
  protected final Class<?> clazz;
  
  public final FieldInfo fieldInfo;
  
  public FieldDeserializer(Class<?> paramClass, FieldInfo paramFieldInfo) {
    this.clazz = paramClass;
    this.fieldInfo = paramFieldInfo;
  }
  
  public int getFastMatchToken() {
    return 0;
  }
  
  public abstract void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap);
  
  public void setValue(Object paramObject, int paramInt) {
    setValue(paramObject, Integer.valueOf(paramInt));
  }
  
  public void setValue(Object paramObject, long paramLong) {
    setValue(paramObject, Long.valueOf(paramLong));
  }
  
  public void setValue(Object paramObject1, Object paramObject2) {
    if (paramObject2 == null && this.fieldInfo.fieldClass.isPrimitive())
      return; 
    try {
      Method method = this.fieldInfo.method;
      if (method != null) {
        if (this.fieldInfo.getOnly) {
          if (this.fieldInfo.fieldClass == AtomicInteger.class) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null)
              paramObject1.set(((AtomicInteger)paramObject2).get()); 
          } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null)
              paramObject1.set(((AtomicLong)paramObject2).get()); 
          } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null)
              paramObject1.set(((AtomicBoolean)paramObject2).get()); 
          } else if (Map.class.isAssignableFrom(method.getReturnType())) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null)
              paramObject1.putAll((Map)paramObject2); 
          } else {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null && paramObject2 != null) {
              paramObject1.clear();
              paramObject1.addAll((Collection)paramObject2);
            } 
          } 
        } else {
          method.invoke(paramObject1, new Object[] { paramObject2 });
        } 
      } else {
        Field field = this.fieldInfo.field;
        if (this.fieldInfo.getOnly) {
          if (this.fieldInfo.fieldClass == AtomicInteger.class) {
            paramObject1 = field.get(paramObject1);
            if (paramObject1 != null)
              paramObject1.set(((AtomicInteger)paramObject2).get()); 
          } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
            paramObject1 = field.get(paramObject1);
            if (paramObject1 != null)
              paramObject1.set(((AtomicLong)paramObject2).get()); 
          } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
            paramObject1 = field.get(paramObject1);
            if (paramObject1 != null)
              paramObject1.set(((AtomicBoolean)paramObject2).get()); 
          } else if (Map.class.isAssignableFrom(this.fieldInfo.fieldClass)) {
            paramObject1 = field.get(paramObject1);
            if (paramObject1 != null)
              paramObject1.putAll((Map)paramObject2); 
          } else {
            paramObject1 = field.get(paramObject1);
            if (paramObject1 != null && paramObject2 != null) {
              paramObject1.clear();
              paramObject1.addAll((Collection)paramObject2);
            } 
          } 
        } else if (field != null) {
          field.set(paramObject1, paramObject2);
        } 
      } 
      return;
    } catch (Exception exception) {
      paramObject2 = new StringBuilder();
      paramObject2.append("set property error, ");
      paramObject2.append(this.fieldInfo.name);
      throw new JSONException(paramObject2.toString(), exception);
    } 
  }
  
  public void setValue(Object paramObject, String paramString) {
    setValue(paramObject, paramString);
  }
  
  public void setValue(Object paramObject, boolean paramBoolean) {
    setValue(paramObject, Boolean.valueOf(paramBoolean));
  }
  
  public void setWrappedValue(String paramString, Object paramObject) {
    throw new JSONException("TODO");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\FieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */