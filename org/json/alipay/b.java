package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b {
  public static final Object a = new a((byte)0);
  
  private Map b;
  
  public b() {
    this.b = new HashMap<Object, Object>();
  }
  
  public b(String paramString) {
    this(new c(paramString));
  }
  
  public b(Map<Object, Object> paramMap) {
    Map<Object, Object> map = paramMap;
    if (paramMap == null)
      map = new HashMap<Object, Object>(); 
    this.b = map;
  }
  
  public b(c paramc) {
    this();
    if (paramc.c() != '{')
      throw paramc.a("A JSONObject text must begin with '{'"); 
    while (true) {
      switch (paramc.c()) {
        case '\000':
          throw paramc.a("A JSONObject text must end with '}'");
        case '}':
          break;
      } 
    } 
  }
  
  static String a(Object paramObject) {
    if (paramObject == null || paramObject.equals(null))
      return "null"; 
    if (paramObject instanceof Number) {
      paramObject = paramObject;
      if (paramObject == null)
        throw new JSONException("Null pointer"); 
      b(paramObject);
      String str = paramObject.toString();
      paramObject = str;
      if (str.indexOf('.') > 0) {
        paramObject = str;
        if (str.indexOf('e') < 0) {
          paramObject = str;
          if (str.indexOf('E') < 0) {
            while (str.endsWith("0"))
              str = str.substring(0, str.length() - 1); 
            paramObject = str;
            if (str.endsWith("."))
              paramObject = str.substring(0, str.length() - 1); 
          } 
        } 
      } 
      return (String)paramObject;
    } 
    return (paramObject instanceof Boolean || paramObject instanceof b || paramObject instanceof a) ? paramObject.toString() : ((paramObject instanceof Map) ? (new b((Map)paramObject)).toString() : ((paramObject instanceof Collection) ? (new a((Collection)paramObject)).toString() : (paramObject.getClass().isArray() ? (new a(paramObject)).toString() : c(paramObject.toString()))));
  }
  
  private static void b(Object paramObject) {
    if (paramObject != null)
      if (paramObject instanceof Double) {
        if (((Double)paramObject).isInfinite() || ((Double)paramObject).isNaN())
          throw new JSONException("JSON does not allow non-finite numbers."); 
      } else if (paramObject instanceof Float && (((Float)paramObject).isInfinite() || ((Float)paramObject).isNaN())) {
        throw new JSONException("JSON does not allow non-finite numbers.");
      }  
  }
  
  public static String c(String paramString) {
    byte b1 = 0;
    if (paramString == null || paramString.length() == 0)
      return "\"\""; 
    int i = paramString.length();
    StringBuffer stringBuffer = new StringBuffer(i + 4);
    stringBuffer.append('"');
    for (char c = Character.MIN_VALUE;; c = c1) {
      char c1;
      if (b1 < i) {
        c1 = paramString.charAt(b1);
        switch (c1) {
          default:
            if (c1 < ' ' || (c1 >= '' && c1 < ' ') || (c1 >= ' ' && c1 < '℀')) {
              String str = "000" + Integer.toHexString(c1);
              stringBuffer.append("\\u" + str.substring(str.length() - 4));
            } else {
              break;
            } 
            b1++;
            c = c1;
            continue;
          case '"':
          case '\\':
            stringBuffer.append('\\');
            stringBuffer.append(c1);
            b1++;
            c = c1;
            continue;
          case '/':
            if (c == '<')
              stringBuffer.append('\\'); 
            stringBuffer.append(c1);
            b1++;
            c = c1;
            continue;
          case '\b':
            stringBuffer.append("\\b");
            b1++;
            c = c1;
            continue;
          case '\t':
            stringBuffer.append("\\t");
            b1++;
            c = c1;
            continue;
          case '\n':
            stringBuffer.append("\\n");
            b1++;
            c = c1;
            continue;
          case '\f':
            stringBuffer.append("\\f");
            b1++;
            c = c1;
            continue;
          case '\r':
            stringBuffer.append("\\r");
            b1++;
            c = c1;
            continue;
        } 
        stringBuffer.append(c1);
      } else {
        break;
      } 
      b1++;
    } 
    stringBuffer.append('"');
    return stringBuffer.toString();
  }
  
  public final Object a(String paramString) {
    Object object;
    if (paramString == null) {
      object = null;
    } else {
      object = this.b.get(paramString);
    } 
    if (object == null)
      throw new JSONException("JSONObject[" + c(paramString) + "] not found."); 
    return object;
  }
  
  public final Iterator a() {
    return this.b.keySet().iterator();
  }
  
  public final boolean b(String paramString) {
    return this.b.containsKey(paramString);
  }
  
  public String toString() {
    StringBuffer stringBuffer;
    try {
      Iterator<Object> iterator = a();
      stringBuffer = new StringBuffer();
      this("{");
      while (iterator.hasNext()) {
        if (stringBuffer.length() > 1)
          stringBuffer.append(','); 
        Object object = iterator.next();
        stringBuffer.append(c(object.toString()));
        stringBuffer.append(':');
        stringBuffer.append(a(this.b.get(object)));
      } 
    } catch (Exception null) {
      return null;
    } 
    stringBuffer.append('}');
    return stringBuffer.toString();
  }
  
  private static final class a {
    private a() {}
    
    protected final Object clone() {
      return this;
    }
    
    public final boolean equals(Object param1Object) {
      return (param1Object == null || param1Object == this);
    }
    
    public final String toString() {
      return "null";
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\json\alipay\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */