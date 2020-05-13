package com.sdk.base.framework.a;

import com.sdk.base.framework.b.b;
import com.sdk.base.framework.c.b;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import com.sdk.base.framework.utils.i.d;
import com.sdk.base.framework.utils.k.a;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class e<T> implements Serializable {
  private static final String a = e.class.getName();
  
  private static final Boolean b = Boolean.valueOf(c.h);
  
  private String c = d.a.a.toString();
  
  private String d;
  
  private String e;
  
  private TreeMap<String, Object> f;
  
  private ArrayList<File> g;
  
  private HashMap<String, Object> h;
  
  private int i = 0;
  
  private b<T> j;
  
  private b k;
  
  public String a() {
    return this.c;
  }
  
  public void a(int paramInt) {
    this.i = paramInt;
  }
  
  public void a(b<T> paramb) {
    this.j = paramb;
  }
  
  public void a(b paramb) {
    this.k = paramb;
  }
  
  public void a(String paramString) {
    if (a.b(paramString).booleanValue())
      this.c = paramString; 
  }
  
  public void a(ArrayList<File> paramArrayList) {
    this.g = paramArrayList;
  }
  
  public void a(HashMap<String, Object> paramHashMap) {
    this.h = paramHashMap;
  }
  
  public void a(TreeMap<String, Object> paramTreeMap) {
    this.f = paramTreeMap;
  }
  
  public String b(TreeMap<String, Object> paramTreeMap) {
    TreeMap treeMap = null;
    if (paramTreeMap != null) {
      StringBuilder stringBuilder2;
      try {
        stringBuilder2 = new StringBuilder();
        this();
        for (Map.Entry<String, Object> entry : paramTreeMap.entrySet()) {
          String str = (String)entry.getKey();
          entry = (Map.Entry<String, Object>)entry.getValue();
          if (entry != null && a.b(str).booleanValue()) {
            String str1 = URLEncoder.encode(entry.toString(), "UTF-8");
            if (c.j) {
              if ("sign".equals(str) || "unikey".equals(str)) {
                stringBuilder2.append(str).append("=").append(str1).append("&");
                continue;
              } 
              stringBuilder2.append(str).append("=").append(d.a(str1)).append("&");
              continue;
            } 
            stringBuilder2.append(str).append("=").append(str1).append("&");
          } 
        } 
      } catch (Exception exception) {
        b.c(a, exception.getMessage(), b);
        throw new Exception("http请求参数出错");
      } 
      stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
      StringBuilder stringBuilder1 = stringBuilder2;
    } else {
      paramTreeMap = null;
    } 
    return (String)((paramTreeMap == null) ? treeMap : paramTreeMap.toString());
  }
  
  public ArrayList<File> b() {
    return this.g;
  }
  
  public void b(String paramString) {
    this.d = paramString;
  }
  
  public boolean c() {
    return !(this.g == null || this.g.size() == 0);
  }
  
  public String d() {
    return this.d;
  }
  
  public TreeMap<String, Object> e() {
    return this.f;
  }
  
  public int f() {
    return this.i;
  }
  
  public String g() {
    return this.e;
  }
  
  public b<T> h() {
    return this.j;
  }
  
  public HashMap<String, Object> i() {
    return this.h;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */