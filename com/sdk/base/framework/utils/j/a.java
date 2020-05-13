package com.sdk.base.framework.utils.j;

import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import com.sdk.base.framework.utils.f.b;
import com.sdk.base.framework.utils.i.e;
import java.util.Map;
import java.util.TreeMap;

public class a extends a {
  private static final String a = a.class.getName();
  
  private static boolean b = c.h;
  
  public static String a(String paramString1, String paramString2, TreeMap<String, Object> paramTreeMap) {
    StringBuffer stringBuffer;
    String str = null;
    if (paramTreeMap == null)
      return str; 
    try {
      stringBuffer = new StringBuffer();
      this();
      stringBuffer.append(paramString1).append(paramString2).append('?');
      for (Map.Entry<String, Object> entry : paramTreeMap.entrySet()) {
        paramString2 = (String)entry.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        String str1 = stringBuilder.append(entry.getValue()).append("").toString();
        if (entry.getValue() != null && str1.length() > 0 && !"null".equals(str1) && !"sign".equals(paramString2) && !paramString2.startsWith("_") && !"file".equals(paramString2))
          stringBuffer.append(paramString2).append('=').append(entry.getValue()).append('&'); 
      } 
    } catch (Exception null) {
      b.c(a, null.getMessage(), Boolean.valueOf(b));
      return null;
    } 
    if (stringBuffer.charAt(stringBuffer.length() - 1) == '&')
      stringBuffer.deleteCharAt(stringBuffer.length() - 1); 
    return e.a(stringBuffer.toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */