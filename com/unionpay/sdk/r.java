package com.unionpay.sdk;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

final class r {
  private static m.d a = null;
  
  private static m.e b = null;
  
  static m.f a(as paramas) {
    Context context = ab.mContext;
    m.f f = new m.f();
    f.a = d.a(context);
    f.b = ab.i;
    f.c = b();
    f.d = c();
    int i = p.c(5);
    int j = p.b(f.a);
    int k = p.b(f.b);
    m.d d1 = f.c;
    int m = p.c(9);
    int n = p.b(d1.a);
    int i1 = p.b(d1.b);
    int i2 = p.b(d1.c);
    int i3 = p.b(d1.d);
    int i4 = p.b(d1.e);
    int i5 = p.b(d1.f);
    boolean bool = d1.g;
    int i6 = p.b(d1.h);
    int i7 = p.b(d1.i);
    m.e e1 = f.d;
    int i8 = p.c(24);
    int i9 = p.b(e1.a);
    int i10 = p.b(e1.b);
    m.h h = e1.c;
    int i11 = p.c(2);
    double d2 = h.a;
    d2 = h.b;
    int i12 = p.b(e1.d);
    int i13 = p.b(e1.e);
    int i14 = p.b(e1.f);
    int i15 = p.b(e1.g);
    int i16 = p.b(e1.h);
    int i17 = p.c(e1.i);
    int i18 = p.b(e1.j);
    int i19 = p.c(e1.k);
    int i20 = p.b(e1.l);
    bool = e1.m;
    int i21 = p.b(e1.n);
    int i22 = p.b(e1.o);
    int i23 = p.b(e1.p);
    int i24 = p.b(e1.q);
    int i25 = p.b(e1.r);
    int i26 = p.b(e1.s);
    int i27 = p.b(e1.t);
    int i28 = p.b(e1.u);
    int i29 = p.c(e1.v);
    int i30 = p.c(e1.w);
    i18 = i + j + k + i7 + m + n + i1 + i2 + i3 + i4 + i5 + 1 + i6 + p.b(e1.x) + i8 + i9 + i10 + i11 + 9 + 9 + i12 + i13 + i14 + i15 + i16 + i17 + i18 + i19 + i20 + 1 + i21 + i22 + i23 + i24 + i25 + i26 + i27 + i28 + i29 + i30 + 3 + 0;
    if (e()) {
      m.i i31 = new m.i();
      i31.a = 1;
      i31.c = a();
      f.e.add(i31);
      i20 = p.c(i31.a);
      m.g g = i31.c;
      i27 = p.c(29);
      i7 = p.b(g.a);
      i11 = p.c(g.b);
      float f1 = g.c;
      n = p.b(g.d);
      i24 = p.b(g.e);
      i5 = p.b(g.f);
      i30 = p.c(g.g);
      i22 = p.c(g.h);
      i8 = p.c(g.i);
      i23 = p.c(g.j);
      i2 = p.c(g.k);
      i4 = p.c(g.l);
      i3 = p.c(g.m);
      f1 = g.n;
      f1 = g.o;
      i15 = p.c(g.p);
      m = p.b(g.q);
      i6 = p.b(g.r);
      i9 = p.b(g.s);
      i = p.b(g.t);
      i26 = p.b(g.u);
      i17 = p.b(g.v);
      i10 = p.b(g.w);
      bool = g.x;
      i12 = p.b(g.y);
      i13 = p.b(g.z);
      i21 = p.b(g.A);
      k = p.b(g.B);
      i1 = p.b(g.C);
      i25 = 1;
      i18 += i1 + i27 + i7 + i11 + 5 + n + i24 + i5 + i30 + i22 + i8 + i23 + i2 + i4 + i3 + 5 + 5 + i15 + m + i6 + i9 + i + i26 + i17 + i10 + 1 + i12 + i13 + i21 + k + i20;
    } else {
      i25 = 0;
    } 
    paramas.a();
    f.h = paramas.g("error_report");
    List list = paramas.c();
    ArrayList<m.j> arrayList = new ArrayList();
    k = 0;
    for (m.j j1 : list) {
      k++;
      String str = j1.a;
      long l = f.f;
      j1.e = paramas.d(str);
      str = j1.a;
      l = f.g;
      j1.f = paramas.f(str);
      i24 = 0;
      i11 = i24;
      if (j1.f != null) {
        Iterator iterator = j1.f.iterator();
        while (true) {
          i11 = i24;
          if (iterator.hasNext()) {
            if (!((m.b)iterator.next()).a.startsWith("__")) {
              i11 = 1;
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
      m.i i31 = new m.i();
      i31.a = 2;
      i31.b = j1;
      i24 = j1.a();
      if (i24 + i18 <= 20480 || k == 1) {
        i18 = i24 + i18;
        arrayList.add(j1);
        if (SystemClock.elapsedRealtime() - ab.e >= 7200000L || j1.c != 2 || j1.e.size() != 0 || (j1.f.size() != 0 && (i11 != 0 || w.b)))
          f.e.add(i31); 
      } 
    } 
    f.f = paramas.a(arrayList);
    f.g = paramas.b(arrayList);
    if (f.h > 0L)
      for (m.i i31 : paramas.d(f.h))
        f.e.add(i31);  
    paramas.b();
    return (i25 == 0 && f.e.size() == 0) ? null : f;
  }
  
  private static m.g a() {
    Context context = ab.mContext;
    m.g g = new m.g();
    String[] arrayOfString = e.k();
    try {
      g.a = arrayOfString[0];
      try {
        g.b = Integer.valueOf(arrayOfString[1]).intValue();
      } catch (Throwable throwable) {}
      g.d = arrayOfString[2];
      try {
        g.c = Float.valueOf(arrayOfString[3]).floatValue();
      } catch (Throwable throwable) {}
      JSONObject jSONObject = e.a(ab.mContext);
      if (jSONObject != null)
        g.C = jSONObject.toString(); 
    } catch (Exception exception) {}
    int[] arrayOfInt = e.m();
    g.g = arrayOfInt[0];
    g.h = arrayOfInt[1];
    try {
      arrayOfInt = e.n();
      g.i = arrayOfInt[0];
      g.j = arrayOfInt[1];
      g.k = arrayOfInt[2];
      g.l = arrayOfInt[3];
    } catch (Throwable throwable) {}
    g.m = e.o();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    g.n = displayMetrics.widthPixels / displayMetrics.xdpi;
    g.o = displayMetrics.heightPixels / displayMetrics.ydpi;
    g.p = displayMetrics.densityDpi;
    g.q = Build.DISPLAY;
    g.r = "unknown";
    try {
      g.r = (String)Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class }).invoke(null, new Object[] { "gsm.version.baseband" });
    } catch (Exception exception) {}
    String str = d.c(context);
    if (str != null)
      g.s = str; 
    str = d.f(context);
    if (str != null)
      g.t = str; 
    try {
      g.y = d.e(context);
      g.A = d.d(context);
      g.B = d.b(context);
    } catch (Exception exception) {}
    return g;
  }
  
  static void a(m.f paramf, as paramas) {
    paramas.a();
    List list = paramf.e;
    paramas.a(paramf.f);
    paramas.b(paramf.g);
    paramas.c(paramf.h);
    for (m.i i : list) {
      m.j j;
      switch (i.a) {
        case 1:
          h.a(ab.mContext, "UPpref_longtime", "UPpref.profile.key", 0L);
          break;
        case 2:
          j = i.b;
          if (j.c == 1) {
            paramas.a(j.a);
            break;
          } 
          if (j.c == 3) {
            paramas.b(j.a);
            paramas.c(j.a);
            paramas.e(j.a);
          } 
          break;
      } 
    } 
    paramas.b();
  }
  
  private static m.d b() {
    // Byte code:
    //   0: ldc com/unionpay/sdk/r
    //   2: monitorenter
    //   3: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   6: ifnull -> 18
    //   9: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   12: astore_0
    //   13: ldc com/unionpay/sdk/r
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   21: ifnonnull -> 29
    //   24: aconst_null
    //   25: astore_0
    //   26: goto -> 13
    //   29: new com/unionpay/sdk/m$d
    //   32: astore_0
    //   33: aload_0
    //   34: invokespecial <init> : ()V
    //   37: aload_0
    //   38: putstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   41: aload_0
    //   42: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   45: invokevirtual getPackageName : ()Ljava/lang/String;
    //   48: putfield a : Ljava/lang/String;
    //   51: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   54: invokestatic i : ()Ljava/lang/String;
    //   57: putfield b : Ljava/lang/String;
    //   60: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   63: invokestatic h : ()I
    //   66: invokestatic valueOf : (I)Ljava/lang/String;
    //   69: putfield c : Ljava/lang/String;
    //   72: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   75: invokestatic e : ()J
    //   78: putfield d : J
    //   81: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   84: ldc_w 'Android+UP+V2.2.33 gp'
    //   87: putfield e : Ljava/lang/String;
    //   90: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   93: getstatic com/unionpay/sdk/ab.j : Ljava/lang/String;
    //   96: putfield f : Ljava/lang/String;
    //   99: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   102: invokestatic a : ()Lcom/unionpay/sdk/a;
    //   105: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   108: invokevirtual d : (Landroid/content/Context;)J
    //   111: putfield h : J
    //   114: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   117: invokestatic a : ()Lcom/unionpay/sdk/a;
    //   120: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   123: invokevirtual e : (Landroid/content/Context;)J
    //   126: putfield i : J
    //   129: getstatic com/unionpay/sdk/r.a : Lcom/unionpay/sdk/m$d;
    //   132: astore_0
    //   133: goto -> 13
    //   136: astore_0
    //   137: ldc com/unionpay/sdk/r
    //   139: monitorexit
    //   140: aload_0
    //   141: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	136	finally
    //   18	24	136	finally
    //   29	133	136	finally
  }
  
  private static m.e c() {
    // Byte code:
    //   0: ldc com/unionpay/sdk/r
    //   2: monitorenter
    //   3: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   6: ifnonnull -> 203
    //   9: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull -> 24
    //   17: aconst_null
    //   18: astore_0
    //   19: ldc com/unionpay/sdk/r
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: new com/unionpay/sdk/m$e
    //   27: astore_0
    //   28: aload_0
    //   29: invokespecial <init> : ()V
    //   32: aload_0
    //   33: putstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   36: aload_0
    //   37: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   40: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
    //   43: putfield s : Ljava/lang/String;
    //   46: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   49: invokestatic f : ()Ljava/lang/String;
    //   52: putfield a : Ljava/lang/String;
    //   55: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   58: invokestatic g : ()I
    //   61: invokestatic valueOf : (I)Ljava/lang/String;
    //   64: putfield b : Ljava/lang/String;
    //   67: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   70: getstatic android/os/Build.CPU_ABI : Ljava/lang/String;
    //   73: putfield d : Ljava/lang/String;
    //   76: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   79: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   82: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   85: putfield e : Ljava/lang/String;
    //   88: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   91: invokestatic j : ()Ljava/lang/String;
    //   94: putfield f : Ljava/lang/String;
    //   97: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   100: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   103: invokestatic p : (Landroid/content/Context;)Ljava/lang/String;
    //   106: putfield g : Ljava/lang/String;
    //   109: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   112: invokestatic i : ()Ljava/lang/String;
    //   115: putfield h : Ljava/lang/String;
    //   118: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   121: invokestatic getDefault : ()Ljava/util/TimeZone;
    //   124: invokevirtual getRawOffset : ()I
    //   127: sipush #1000
    //   130: idiv
    //   131: bipush #60
    //   133: idiv
    //   134: bipush #60
    //   136: idiv
    //   137: putfield i : I
    //   140: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   143: astore_1
    //   144: new java/lang/StringBuilder
    //   147: astore_0
    //   148: aload_0
    //   149: ldc_w 'Android+'
    //   152: invokespecial <init> : (Ljava/lang/String;)V
    //   155: aload_1
    //   156: aload_0
    //   157: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual toString : ()Ljava/lang/String;
    //   166: putfield j : Ljava/lang/String;
    //   169: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   172: invokestatic currentTimeMillis : ()J
    //   175: invokestatic elapsedRealtime : ()J
    //   178: lsub
    //   179: putfield r : J
    //   182: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   185: invokestatic a : (Landroid/content/Context;)Lorg/json/JSONObject;
    //   188: astore_0
    //   189: aload_0
    //   190: ifnull -> 203
    //   193: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   196: aload_0
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: putfield x : Ljava/lang/String;
    //   203: invokestatic d : ()V
    //   206: getstatic com/unionpay/sdk/r.b : Lcom/unionpay/sdk/m$e;
    //   209: astore_0
    //   210: goto -> 19
    //   213: astore_0
    //   214: ldc com/unionpay/sdk/r
    //   216: monitorexit
    //   217: aload_0
    //   218: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	213	finally
    //   24	189	213	finally
    //   193	203	213	finally
    //   203	210	213	finally
  }
  
  private static void d() {
    List list = j.a(ab.mContext);
    Location location = null;
    Iterator<Location> iterator = list.iterator();
    while (true) {
      boolean bool;
      if (iterator.hasNext()) {
        Location location2 = iterator.next();
        Location location1 = location2;
        if (location != null)
          if (location2.getTime() > location.getTime()) {
            location1 = location2;
          } else {
            location1 = location;
          }  
        location = location1;
        continue;
      } 
      m.h h = new m.h();
      if (location != null) {
        h.b = location.getLatitude();
        h.a = location.getLongitude();
      } 
      b.c = h;
      m.e e1 = b;
      if (f.g(ab.mContext)) {
        bool = false;
      } else {
        bool = true;
      } 
      e1.k = bool;
      b.l = f.i(ab.mContext);
      b.o = f.k(ab.mContext);
      b.n = f.l(ab.mContext);
      b.p = j.b(ab.mContext);
      b.t = f.r(ab.mContext).toString();
      JSONArray jSONArray = j.d(ab.mContext);
      if (e() || (new Random()).nextInt(100) > 90) {
        String str;
        m.e e2 = b;
        if (jSONArray == null) {
          str = "";
        } else {
          str = str.toString();
        } 
        e2.u = str;
      } 
      return;
    } 
  }
  
  private static boolean e() {
    // Byte code:
    //   0: ldc com/unionpay/sdk/r
    //   2: monitorenter
    //   3: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   6: ldc_w 'UPpref_longtime'
    //   9: ldc_w 'UPpref.profile.key'
    //   12: lconst_1
    //   13: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   16: lstore_0
    //   17: lload_0
    //   18: lconst_0
    //   19: lcmp
    //   20: ifeq -> 30
    //   23: iconst_1
    //   24: istore_2
    //   25: ldc com/unionpay/sdk/r
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_2
    //   32: goto -> 25
    //   35: astore_3
    //   36: ldc com/unionpay/sdk/r
    //   38: monitorexit
    //   39: aload_3
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	35	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */