package com.hu.zxlib.common;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.HashMap;

public class b {
  public static HashMap<String, Object> a = new HashMap<String, Object>();
  
  private static final String b = "anim";
  
  private static final String c = "attr";
  
  private static final String d = "color";
  
  private static final String e = "string";
  
  private static final String f = "drawable";
  
  private static final String g = "dimen";
  
  private static final String h = "id";
  
  private static final String i = "layout";
  
  private static final String j = "raw";
  
  private static final String k = "style";
  
  private static final String l = "integer";
  
  private static final String m = "styleable";
  
  public static int a(Context paramContext, String paramString) {
    return a(paramContext, paramString, "anim");
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2) {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, paramContext.getPackageName());
  }
  
  public static int b(Context paramContext, String paramString) {
    return a(paramContext, paramString, "attr");
  }
  
  public static int c(Context paramContext, String paramString) {
    return a(paramContext, paramString, "color");
  }
  
  public static int d(Context paramContext, String paramString) {
    return a(paramContext, paramString, "string");
  }
  
  public static int e(Context paramContext, String paramString) {
    return a(paramContext, paramString, "drawable");
  }
  
  public static int f(Context paramContext, String paramString) {
    return a(paramContext, paramString, "dimen");
  }
  
  public static int g(Context paramContext, String paramString) {
    return a(paramContext, paramString, "id");
  }
  
  public static int h(Context paramContext, String paramString) {
    return a(paramContext, paramString, "layout");
  }
  
  public static int i(Context paramContext, String paramString) {
    return a(paramContext, paramString, "raw");
  }
  
  public static int j(Context paramContext, String paramString) {
    return a(paramContext, paramString, "style");
  }
  
  public static int k(Context paramContext, String paramString) {
    return a(paramContext, paramString, "integer");
  }
  
  public static int l(Context paramContext, String paramString) {
    return ((Integer)n(paramContext, paramString)).intValue();
  }
  
  public static int[] m(Context paramContext, String paramString) {
    return (int[])n(paramContext, paramString);
  }
  
  private static Object n(Context paramContext, String paramString) {
    String str2;
    if (a.containsKey(paramString)) {
      Object object = a.get(paramString);
      str2 = (String)object;
      if (object != null)
        return object; 
    } else {
      str2 = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append(".R");
    String str1 = stringBuilder.toString();
    try {
      Object object;
      Class[] arrayOfClass = Class.forName(str1).getClasses();
      int i = arrayOfClass.length;
      str1 = str2;
      byte b1 = 0;
      while (b1 < i) {
        Object object1;
        Class clazz = arrayOfClass[b1];
        str2 = str1;
        if (clazz.getSimpleName().equals("styleable")) {
          Object object2;
          for (Field field : clazz.getFields()) {
            String str = field.getName();
            a.put(str, field.get(null));
            if (str.equals(paramString))
              object2 = field.get(null); 
          } 
          object1 = object2;
        } 
        b1++;
        object = object1;
      } 
      return object;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */