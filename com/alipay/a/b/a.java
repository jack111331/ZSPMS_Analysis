package com.alipay.a.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class a {
  public static Class<?> a(Type paramType) {
    while (true) {
      if (paramType instanceof Class)
        return (Class)paramType; 
      if (paramType instanceof ParameterizedType) {
        paramType = ((ParameterizedType)paramType).getRawType();
        continue;
      } 
      throw new IllegalArgumentException("TODO");
    } 
  }
  
  public static boolean a(Class<?> paramClass) {
    boolean bool1 = true;
    if (paramClass.isPrimitive())
      return bool1; 
    boolean bool2 = bool1;
    if (!paramClass.equals(String.class)) {
      bool2 = bool1;
      if (!paramClass.equals(Integer.class)) {
        bool2 = bool1;
        if (!paramClass.equals(Long.class)) {
          bool2 = bool1;
          if (!paramClass.equals(Double.class)) {
            bool2 = bool1;
            if (!paramClass.equals(Float.class)) {
              bool2 = bool1;
              if (!paramClass.equals(Boolean.class)) {
                bool2 = bool1;
                if (!paramClass.equals(Short.class)) {
                  bool2 = bool1;
                  if (!paramClass.equals(Character.class)) {
                    bool2 = bool1;
                    if (!paramClass.equals(Byte.class)) {
                      bool2 = bool1;
                      if (!paramClass.equals(Void.class))
                        bool2 = false; 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */