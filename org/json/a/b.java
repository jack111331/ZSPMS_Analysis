package org.json.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class b {
  private ArrayList a;
  
  public b() {
    this.a = new ArrayList();
  }
  
  public b(Object paramObject) {
    this();
    if (paramObject.getClass().isArray()) {
      int i = Array.getLength(paramObject);
      for (byte b1 = 0; b1 < i; b1++) {
        Object object = Array.get(paramObject, b1);
        this.a.add(object);
      } 
    } else {
      throw new a("JSONArray initial value should be a string or collection or array.");
    } 
  }
  
  public b(String paramString) {
    this(new d(paramString));
  }
  
  public b(Collection<?> paramCollection) {
    if (paramCollection == null) {
      paramCollection = new ArrayList();
    } else {
      paramCollection = new ArrayList(paramCollection);
    } 
    this.a = (ArrayList)paramCollection;
  }
  
  public b(d paramd) {
    this();
    char c1;
    char c = paramd.c();
    if (c == '[') {
      c = ']';
      c1 = c;
    } else if (c == '(') {
      c = ')';
      c1 = c;
    } else {
      throw paramd.a("A JSONArray text must start with '['");
    } 
    if (paramd.c() != ']') {
      paramd.a();
      while (true) {
        if (paramd.c() == ',') {
          paramd.a();
          this.a.add(null);
        } else {
          paramd.a();
          this.a.add(paramd.d());
        } 
        c = paramd.c();
        switch (c) {
          default:
            throw paramd.a("Expected a ',' or ']'");
          case ',':
          case ';':
            if (paramd.c() != ']') {
              paramd.a();
              continue;
            } 
            return;
          case ')':
          case ']':
            break;
        } 
        if (c1 != c)
          throw paramd.a("Expected a '" + new Character(c1) + "'"); 
        return;
      } 
    } 
  }
  
  private String a(String paramString) {
    int i = this.a.size();
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b1 = 0; b1 < i; b1++) {
      if (b1 > 0)
        stringBuffer.append(paramString); 
      stringBuffer.append(c.a(this.a.get(b1)));
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
      throw new a("JSONArray[" + paramInt + "] not found."); 
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\json\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */