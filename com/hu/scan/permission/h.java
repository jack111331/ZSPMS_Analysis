package com.hu.scan.permission;

import android.os.Handler;
import android.os.Looper;
import android.support.a.aa;
import android.support.a.af;
import com.hu.scan.permission.a.k;
import com.hu.scan.permission.a.n;
import com.hu.scan.permission.a.w;
import com.hu.scan.permission.c.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@af(b = 23)
class h implements l, n, o {
  private static final Handler a = new Handler(Looper.getMainLooper());
  
  private static final n b = (n)new w();
  
  private static final n c = (n)new k();
  
  private d d;
  
  private String[] e;
  
  private m f;
  
  private a g;
  
  private a h;
  
  private String[] i;
  
  h(d paramd) {
    this.d = paramd;
  }
  
  private static List<String> a(@aa d paramd, @aa String... paramVarArgs) {
    ArrayList<String> arrayList = new ArrayList(1);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str = paramVarArgs[b];
      if (paramd.a(str))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  private void a(@aa List<String> paramList) {
    if (this.h != null)
      this.h.a(paramList); 
  }
  
  private static List<String> b(n paramn, @aa d paramd, @aa String... paramVarArgs) {
    ArrayList<String> arrayList = new ArrayList(1);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str = paramVarArgs[b];
      if (!paramn.a(paramd.a(), new String[] { str }))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  private void e() {
    if (this.g != null) {
      List<String> list = Arrays.asList(this.e);
      try {
        this.g.a(list);
      } catch (Exception exception) {
        if (this.h != null)
          this.h.a(list); 
      } 
    } 
  }
  
  @aa
  public n a(a parama) {
    this.g = parama;
    return this;
  }
  
  @aa
  public n a(m paramm) {
    this.f = paramm;
    return this;
  }
  
  @aa
  public n a(String... paramVarArgs) {
    this.e = paramVarArgs;
    return this;
  }
  
  @aa
  public n a(String[]... paramVarArgs) {
    ArrayList arrayList = new ArrayList();
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      arrayList.addAll(Arrays.asList(paramVarArgs[b])); 
    this.e = (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
    return this;
  }
  
  public void a() {
    List<String> list = b(b, this.d, this.e);
    this.i = list.<String>toArray(new String[list.size()]);
    if (this.i.length > 0) {
      list = a(this.d, this.i);
      if (list.size() > 0 && this.f != null) {
        this.f.a(this.d.a(), list, this);
      } else {
        b();
      } 
    } else {
      e();
    } 
  }
  
  @aa
  public n b(a parama) {
    this.h = parama;
    return this;
  }
  
  @af(b = 23)
  public void b() {
    PermissionActivity.a(this.d.a(), this.i, this);
  }
  
  public void b(@aa String[] paramArrayOfString) {
    a.postDelayed(new i(this, paramArrayOfString), 250L);
  }
  
  public void c() {
    b(this.i);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */