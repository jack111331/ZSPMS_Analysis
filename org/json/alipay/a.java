package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class a {
  private ArrayList a;
  
  public a() {
    this.a = new ArrayList();
  }
  
  public a(Object paramObject) {
    this();
    if (paramObject.getClass().isArray()) {
      int i = Array.getLength(paramObject);
      for (byte b = 0; b < i; b++) {
        Object object = Array.get(paramObject, b);
        this.a.add(object);
      } 
    } else {
      throw new JSONException("JSONArray initial value should be a string or collection or array.");
    } 
  }
  
  public a(String paramString) {
    this(new c(paramString));
  }
  
  public a(Collection<?> paramCollection) {
    if (paramCollection == null) {
      paramCollection = new ArrayList();
    } else {
      paramCollection = new ArrayList(paramCollection);
    } 
    this.a = (ArrayList)paramCollection;
  }
  
  public a(c paramc) {
    this();
    char c2;
    char c1 = paramc.c();
    if (c1 == '[') {
      c1 = ']';
      c2 = c1;
    } else if (c1 == '(') {
      c1 = ')';
      c2 = c1;
    } else {
      throw paramc.a("A JSONArray text must start with '['");
    } 
    if (paramc.c() != ']') {
      paramc.a();
      while (true) {
        if (paramc.c() == ',') {
          paramc.a();
          this.a.add(null);
        } else {
          paramc.a();
          this.a.add(paramc.d());
        } 
        c1 = paramc.c();
        switch (c1) {
          default:
            throw paramc.a("Expected a ',' or ']'");
          case ',':
          case ';':
            if (paramc.c() != ']') {
              paramc.a();
              continue;
            } 
            return;
          case ')':
          case ']':
            break;
        } 
        if (c2 != c1)
          throw paramc.a("Expected a '" + new Character(c2) + "'"); 
        return;
      } 
    } 
  }
  
  private String a(String paramString) {
    int i = this.a.size();
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < i; b++) {
      if (b > 0)
        stringBuffer.append(paramString); 
      stringBuffer.append(b.a(this.a.get(b)));
    } 
    return stringBuffer.toString();
  }
  
  public final int a() {
    return this.a.size();
  }
  
  public final Object a(int paramInt) {
    Object object;
    if (paramInt < 0 || paramInt >= this.a.size()) {
      object = null;
    } else {
      object = this.a.get(paramInt);
    } 
    if (object == null)
      throw new JSONException("JSONArray[" + paramInt + "] not found."); 
    return object;
  }
  
  public String toString() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("[");
      String str = stringBuilder.append(a(",")).append(']').toString();
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\json\alipay\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */