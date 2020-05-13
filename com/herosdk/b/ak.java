package com.herosdk.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ak {
  private HashMap<String, List<String>> a;
  
  ak(al paramal) {
    this.a = paramal.a;
  }
  
  public String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.a != null && this.a.containsKey(paramString) && this.a.get(paramString) != null)
      for (byte b = 0; b < ((List)this.a.get(paramString)).size(); b++) {
        stringBuilder.append(((List<String>)this.a.get(paramString)).get(b));
        if (b > 0 && b < ((List)this.a.get(paramString)).size() - 1)
          stringBuilder.append(";"); 
      }  
    return stringBuilder.toString();
  }
  
  public HashMap<String, List<String>> a() {
    return this.a;
  }
  
  public void a(String paramString1, String paramString2) {
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(paramString2);
    this.a.put(paramString1, arrayList);
  }
  
  public List<String> b(String paramString) {
    return this.a.get(paramString);
  }
  
  public void b(String paramString1, String paramString2) {
    List<String> list1 = null;
    if (this.a.containsKey(paramString1))
      list1 = this.a.get(paramString1); 
    List<String> list2 = list1;
    if (list1 == null)
      list2 = new ArrayList(); 
    list2.add(paramString2);
    this.a.put(paramString1, list2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */