package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class an extends k {
  private static ArrayList<am> A;
  
  private static Map<String, String> B;
  
  private static Map<String, String> C;
  
  private static Map<String, String> v = new HashMap<String, String>();
  
  private static al w = new al();
  
  private static ak x = new ak();
  
  private static ArrayList<ak> y = new ArrayList<ak>();
  
  private static ArrayList<ak> z = new ArrayList<ak>();
  
  public String a = "";
  
  public long b = 0L;
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public String f = "";
  
  public String g = "";
  
  public Map<String, String> h = null;
  
  public String i = "";
  
  public al j = null;
  
  public int k = 0;
  
  public String l = "";
  
  public String m = "";
  
  public ak n = null;
  
  public ArrayList<ak> o = null;
  
  public ArrayList<ak> p = null;
  
  public ArrayList<am> q = null;
  
  public Map<String, String> r = null;
  
  public Map<String, String> s = null;
  
  public String t = "";
  
  private boolean u = true;
  
  static {
    ak1 = new ak();
    z.add(ak1);
    A = new ArrayList<am>();
    am am = new am();
    A.add(am);
    B = new HashMap<String, String>();
    B.put("", "");
    C = new HashMap<String, String>();
    C.put("", "");
  }
  
  public final void a(i parami) {
    this.a = parami.b(0, true);
    this.b = parami.a(this.b, 1, true);
    this.c = parami.b(2, true);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = parami.b(5, false);
    this.g = parami.b(6, false);
    this.h = (Map<String, String>)parami.<Map<String, String>>a(v, 7, false);
    this.i = parami.b(8, false);
    this.j = (al)parami.a(w, 9, false);
    this.k = parami.a(this.k, 10, false);
    this.l = parami.b(11, false);
    this.m = parami.b(12, false);
    this.n = (ak)parami.a(x, 13, false);
    this.o = (ArrayList<ak>)parami.<ArrayList<ak>>a(y, 14, false);
    this.p = (ArrayList<ak>)parami.<ArrayList<ak>>a(z, 15, false);
    this.q = (ArrayList<am>)parami.<ArrayList<am>>a(A, 16, false);
    this.r = (Map<String, String>)parami.<Map<String, String>>a(B, 17, false);
    this.s = (Map<String, String>)parami.<Map<String, String>>a(C, 18, false);
    this.t = parami.b(19, false);
    boolean bool = this.u;
    this.u = parami.a(20, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    if (this.d != null)
      paramj.a(this.d, 3); 
    if (this.e != null)
      paramj.a(this.e, 4); 
    if (this.f != null)
      paramj.a(this.f, 5); 
    if (this.g != null)
      paramj.a(this.g, 6); 
    if (this.h != null)
      paramj.a(this.h, 7); 
    if (this.i != null)
      paramj.a(this.i, 8); 
    if (this.j != null)
      paramj.a(this.j, 9); 
    paramj.a(this.k, 10);
    if (this.l != null)
      paramj.a(this.l, 11); 
    if (this.m != null)
      paramj.a(this.m, 12); 
    if (this.n != null)
      paramj.a(this.n, 13); 
    if (this.o != null)
      paramj.a(this.o, 14); 
    if (this.p != null)
      paramj.a(this.p, 15); 
    if (this.q != null)
      paramj.a(this.q, 16); 
    if (this.r != null)
      paramj.a(this.r, 17); 
    if (this.s != null)
      paramj.a(this.s, 18); 
    if (this.t != null)
      paramj.a(this.t, 19); 
    paramj.a(this.u, 20);
  }
  
  static {
    v.put("", "");
  }
  
  static {
    ak ak1 = new ak();
    y.add(ak1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */