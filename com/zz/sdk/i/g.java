package com.zz.sdk.i;

import java.lang.reflect.Field;

public class g {
  public static Object a(Object paramObject, String paramString) {
    IllegalAccessException illegalAccessException = null;
    try {
      Class<?> clazz = paramObject.getClass();
      Field field = null;
      while (true) {
        boolean bool = clazz.equals(Object.class);
        if (!bool) {
          try {
            Field field1 = clazz.getDeclaredField(paramString);
            field = field1;
          } catch (NoSuchFieldException noSuchFieldException) {}
          clazz = clazz.getSuperclass();
          continue;
        } 
        if (field == null)
          return illegalAccessException; 
        field.setAccessible(true);
        return field.get(paramObject);
      } 
    } catch (IllegalAccessException null) {
      exception.printStackTrace();
      exception = illegalAccessException;
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = illegalAccessException;
    } 
    return exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */