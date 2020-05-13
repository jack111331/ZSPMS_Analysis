package com.unionpay.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class m {
  static final class a implements o {
    String a = "";
    
    long b = 0L;
    
    int c = 0;
    
    String d = "";
    
    public final void messagePack(p param1p) {
      param1p.b(4);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      param1p.a(this.d);
    }
    
    public final String toString() {
      return "Activity{name:" + this.a + ",start:" + this.b + ",duration:" + this.c + ",refer:" + this.d;
    }
  }
  
  static final class b implements o {
    String a = "";
    
    String b = "";
    
    int c = 0;
    
    long d;
    
    Map e;
    
    public final void messagePack(p param1p) {
      param1p.b(5);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      param1p.a(this.d);
      Map map = this.e;
      if (map == null) {
        param1p.a();
        return;
      } 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      for (String str : map.keySet()) {
        Object object = map.get(str);
        if (object instanceof String) {
          hashMap.put(str, object.toString());
          continue;
        } 
        if (object instanceof Number)
          hashMap.put(str, Double.valueOf(((Number)object).doubleValue())); 
      } 
      param1p.d(hashMap.size());
      Iterator<Map.Entry> iterator = hashMap.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          param1p.a((String)entry.getKey());
          entry = (Map.Entry)entry.getValue();
          if (entry instanceof Number) {
            param1p.a(((Number)entry).doubleValue());
            continue;
          } 
          if (entry instanceof String)
            param1p.a(entry.toString()); 
          continue;
        } 
        return;
      } 
    }
    
    public final String toString() {
      return "AppEvent{id:" + this.a + ",label:" + this.b + ",count:" + this.c + ",ts:" + this.d + ",kv:" + this.e + '}';
    }
  }
  
  static final class c implements o {
    long a = 0L;
    
    int b = 1;
    
    String c = "";
    
    byte[] d = new byte[0];
    
    String e = "";
    
    public final void messagePack(p param1p) {
      param1p.b(5);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      byte[] arrayOfByte = this.d;
      if (arrayOfByte == null) {
        param1p.a();
      } else {
        param1p.e(arrayOfByte.length);
        param1p.a(arrayOfByte);
      } 
      param1p.a(this.e);
    }
  }
  
  static final class d implements o {
    String a = "";
    
    String b = "";
    
    String c = "";
    
    long d = 0L;
    
    String e = "";
    
    String f = "";
    
    boolean g = false;
    
    long h = 0L;
    
    long i = 0L;
    
    public final void messagePack(p param1p) {
      param1p.b(9);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      param1p.a(this.d);
      param1p.a(this.e);
      param1p.a(this.f);
      param1p.a(this.g);
      param1p.a(this.h);
      param1p.a(this.i);
    }
  }
  
  static final class e implements o {
    String a = "";
    
    String b = "";
    
    m.h c = new m.h();
    
    String d = "";
    
    String e = "";
    
    String f = "";
    
    String g = "";
    
    String h = "";
    
    int i = 8;
    
    String j = "";
    
    int k = -1;
    
    String l = "";
    
    boolean m = false;
    
    String n = "";
    
    String o = "";
    
    String p = "";
    
    String q = "";
    
    long r = 0L;
    
    String s = "";
    
    String t = "";
    
    String u = "";
    
    int v;
    
    int w;
    
    String x = "";
    
    public final void messagePack(p param1p) {
      param1p.b(24);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      param1p.a(this.d);
      param1p.a(this.e);
      param1p.a(this.f);
      param1p.a(this.g);
      param1p.a(this.h);
      param1p.a(this.i);
      param1p.a(this.j);
      param1p.a(this.k);
      param1p.a(this.l);
      param1p.a(this.m);
      param1p.a(this.n);
      param1p.a(this.o);
      param1p.a(this.p);
      param1p.a(this.q);
      param1p.a(this.r).a(this.s).a(this.t).a(this.u).a(this.v).a(this.w).a(this.x);
    }
  }
  
  static final class f implements o {
    String a = "";
    
    String b = "";
    
    m.d c = new m.d();
    
    m.e d = new m.e();
    
    List e = new ArrayList();
    
    long f = 0L;
    
    long g = 0L;
    
    long h = 0L;
    
    Long[][] i;
    
    public final void messagePack(p param1p) {
      param1p.b(6);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      param1p.a(this.d);
      param1p.b(this.e.size());
      Iterator<m.i> iterator = this.e.iterator();
      while (iterator.hasNext())
        param1p.a(iterator.next()); 
      if (this.i == null) {
        param1p.a();
        return;
      } 
      param1p.b(this.i.length);
      Long[][] arrayOfLong = this.i;
      int i = arrayOfLong.length;
      byte b = 0;
      label23: while (true) {
        if (b < i) {
          Long[] arrayOfLong1 = arrayOfLong[b];
          if (arrayOfLong1 == null || arrayOfLong1.length == 0) {
            param1p.a();
            continue;
          } 
          param1p.b(arrayOfLong1.length);
          int j = arrayOfLong1.length;
          byte b1 = 0;
          while (true) {
            if (b1 < j) {
              param1p.a(arrayOfLong1[b1].longValue());
              b1++;
              continue;
            } 
            b++;
            continue label23;
          } 
          break;
        } 
        return;
      } 
    }
  }
  
  static final class g implements o {
    String A = "";
    
    String B = "";
    
    String C = "";
    
    String a = "";
    
    int b = 0;
    
    float c = 0.0F;
    
    String d = "";
    
    String e = "";
    
    String f = "";
    
    int g = 0;
    
    int h = 0;
    
    int i = 0;
    
    int j = 0;
    
    int k = 0;
    
    int l = 0;
    
    int m = 0;
    
    float n = 0.0F;
    
    float o = 0.0F;
    
    int p = 0;
    
    String q = "";
    
    String r = "";
    
    String s = "";
    
    String t = "";
    
    String u = "";
    
    String v = "";
    
    String w = "";
    
    boolean x = false;
    
    String y = "";
    
    String z = "";
    
    public final void messagePack(p param1p) {
      param1p.b(29);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      param1p.a(this.d);
      param1p.a(this.e);
      param1p.a(this.f);
      param1p.a(this.g);
      param1p.a(this.h);
      param1p.a(this.i);
      param1p.a(this.j);
      param1p.a(this.k);
      param1p.a(this.l);
      param1p.a(this.m);
      param1p.a(this.n);
      param1p.a(this.o);
      param1p.a(this.p);
      param1p.a(this.q);
      param1p.a(this.r);
      param1p.a(this.s);
      param1p.a(this.t);
      param1p.a(this.u);
      param1p.a(this.v);
      param1p.a(this.w);
      param1p.a(this.x);
      param1p.a(this.y);
      param1p.a(this.z);
      param1p.a(this.A);
      param1p.a(this.B);
      param1p.a(this.C);
    }
  }
  
  static final class h implements o {
    double a = 0.0D;
    
    double b = 0.0D;
    
    public final void messagePack(p param1p) {
      param1p.b(2);
      param1p.a(this.a);
      param1p.a(this.b);
    }
  }
  
  static final class i implements o {
    int a = -1;
    
    m.j b;
    
    m.g c;
    
    m.c d;
    
    public final void messagePack(p param1p) {
      param1p.b(2);
      param1p.a(this.a);
      switch (this.a) {
        default:
          throw new IOException("unknown TMessageType");
        case 1:
          param1p.a(this.c);
          return;
        case 2:
          param1p.a(this.b);
          return;
        case 3:
          break;
      } 
      param1p.a(this.d);
    }
  }
  
  static final class j implements o {
    String a = "";
    
    long b = 0L;
    
    int c = 0;
    
    int d = 0;
    
    List e = new ArrayList();
    
    List f = new ArrayList();
    
    int g = 0;
    
    int h = 0;
    
    long i = 0L;
    
    public final int a() {
      int i = p.c(8);
      int k = p.b(this.a);
      int m = p.b(this.b);
      int n = p.c(this.c);
      int i1 = p.c(this.d);
      int i2 = p.c(this.h);
      int i3 = p.c(this.e.size());
      Iterator<m.a> iterator = this.e.iterator();
      for (i2 = i + k + m + n + i1 + i2 + i3; iterator.hasNext(); i2 = p.b(a.d) + i3 + i1 + k + i + i2) {
        m.a a = iterator.next();
        i3 = p.c(4);
        i1 = p.b(a.a);
        k = p.b(a.b);
        i = p.c(a.c);
      } 
      i1 = p.c(this.f.size());
      iterator = this.f.iterator();
      for (i2 = i1 + i2; iterator.hasNext(); i2 = p.c(b.c) + i3 + i1 + i + i2) {
        m.b b = (m.b)iterator.next();
        i3 = p.c(3);
        i1 = p.b(b.a);
        i = p.b(b.b);
      } 
      return p.b(this.i) + i2;
    }
    
    public final void messagePack(p param1p) {
      param1p.b(8);
      param1p.a(this.a);
      param1p.a(this.b);
      param1p.a(this.c);
      param1p.a(this.d);
      param1p.b(this.e.size());
      Iterator<m.a> iterator = this.e.iterator();
      while (iterator.hasNext())
        param1p.a(iterator.next()); 
      param1p.b(this.f.size());
      iterator = this.f.iterator();
      while (iterator.hasNext())
        param1p.a((m.b)iterator.next()); 
      param1p.a(this.h);
      param1p.a(this.i);
    }
    
    public final String toString() {
      return "Session{id:" + this.a + ",start:" + this.b + ",status:" + this.c + ",duration:" + this.d + ",connected:" + this.h + ",time_gap:" + this.i + '}';
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */