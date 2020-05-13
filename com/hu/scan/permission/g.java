package com.hu.scan.permission;

import android.support.a.aa;
import com.hu.scan.permission.a.n;
import com.hu.scan.permission.a.z;
import com.hu.scan.permission.c.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class g implements n {
  private static final n a = (n)new z();
  
  private d b;
  
  private String[] c;
  
  private a d;
  
  private a e;
  
  g(d paramd) {
    this.b = paramd;
  }
  
  private static List<String> a(@aa d paramd, @aa String... paramVarArgs) {
    ArrayList<String> arrayList = new ArrayList(1);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str = paramVarArgs[b];
      if (!a.a(paramd.a(), new String[] { str }))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  private void a(@aa List<String> paramList) {
    if (this.e != null)
      this.e.a(paramList); 
  }
  
  private void b() {
    if (this.d != null) {
      List<String> list = Arrays.asList(this.c);
      try {
        this.d.a(list);
      } catch (Exception exception) {
        if (this.e != null)
          this.e.a(list); 
      } 
    } 
  }
  
  @aa
  public n a(a parama) {
    this.d = parama;
    return this;
  }
  
  @aa
  public n a(m paramm) {
    return this;
  }
  
  @aa
  public n a(String... paramVarArgs) {
    this.c = paramVarArgs;
    return this;
  }
  
  @aa
  public n a(String[]... paramVarArgs) {
    ArrayList arrayList = new ArrayList();
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      arrayList.addAll(Arrays.asList(paramVarArgs[b])); 
    this.c = (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
    return this;
  }
  
  public void a() {
    List<String> list = a(this.b, this.c);
    if (list.isEmpty()) {
      b();
    } else {
      a(list);
    } 
  }
  
  @aa
  public n b(a parama) {
    this.e = parama;
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */