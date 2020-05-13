package com.sdk.base.framework.utils.c;

import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
  private static final String a = a.class.getName();
  
  private static final boolean b = c.h;
  
  public static String a(Object paramObject) {
    JSONObject jSONObject;
    try {
      Field[] arrayOfField = Class.forName(paramObject.getClass().getName()).getDeclaredFields();
      jSONObject = new JSONObject();
      this();
      for (byte b = 0; b < arrayOfField.length; b++) {
        Field field = arrayOfField[b];
        field.setAccessible(true);
        String str = field.getName();
        if (!"serialVersionUID".equals(str)) {
          Object object = field.get(paramObject);
          if (field.getType().equals(ArrayList.class)) {
            JSONArray jSONArray = new JSONArray();
            this();
            ArrayList arrayList = (ArrayList)object;
            if (arrayList != null)
              for (byte b1 = 0; b1 < arrayList.size(); b1++) {
                object = arrayList.get(b1);
                Class<?> clazz = object.getClass();
                if (clazz.equals(KInfo.class)) {
                  Field[] arrayOfField1 = clazz.getDeclaredFields();
                  JSONObject jSONObject1 = new JSONObject();
                  this();
                  for (byte b2 = 0; b2 < arrayOfField1.length; b2++) {
                    Field field1 = arrayOfField1[b2];
                    field1.setAccessible(true);
                    jSONObject1.put(field1.getName(), field1.get(object));
                  } 
                  jSONArray.put(jSONObject1);
                } else {
                  jSONArray.put(object);
                } 
              }  
            jSONObject.put(str, jSONArray);
          } else {
            jSONObject.put(str, object);
          } 
        } 
      } 
    } catch (Exception null) {
      b.c(a, null.getMessage(), Boolean.valueOf(b));
      return null;
    } 
    return jSONObject.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */