package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import sun.reflect.annotation.AnnotationType;

public class AnnotationSerializer implements ObjectSerializer {
  public static AnnotationSerializer instance = new AnnotationSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object<String, Method> paramObject2, Type paramType, int paramInt) throws IOException {
    paramObject2 = (Object)paramObject1.getClass().getInterfaces();
    if (paramObject2.length == 1 && paramObject2[0].isAnnotation()) {
      paramObject2 = (Object<String, Method>)AnnotationType.getInstance((Class<? extends Annotation>)paramObject2[0]).members();
      JSONObject jSONObject = new JSONObject(paramObject2.size());
      Iterator<Map.Entry> iterator = paramObject2.entrySet().iterator();
      paramObject2 = null;
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          try {
            Object object = ((Method)entry.getValue()).invoke(paramObject1, new Object[0]);
            paramObject2 = (Object<String, Method>)object;
          } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {}
          jSONObject.put((String)entry.getKey(), JSON.toJSON(paramObject2));
          continue;
        } 
        paramJSONSerializer.write(jSONObject);
        return;
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\AnnotationSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */