package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class a {
  private static a af;
  
  public HashMap<String, String> A = new HashMap<String, String>();
  
  public boolean B = true;
  
  public List<String> C = new ArrayList<String>();
  
  public com.tencent.bugly.crashreport.a D = null;
  
  public SharedPreferences E;
  
  private final Context F;
  
  private String G;
  
  private String H;
  
  private String I;
  
  private String J = "unknown";
  
  private String K = "unknown";
  
  private String L = "";
  
  private String M = null;
  
  private String N = null;
  
  private String O = null;
  
  private String P = null;
  
  private long Q = -1L;
  
  private long R = -1L;
  
  private long S = -1L;
  
  private String T = null;
  
  private String U = null;
  
  private Map<String, PlugInBean> V = null;
  
  private boolean W = true;
  
  private String X = null;
  
  private String Y = null;
  
  private Boolean Z = null;
  
  public final long a = System.currentTimeMillis();
  
  private String aa = null;
  
  private String ab = null;
  
  private String ac = null;
  
  private Map<String, PlugInBean> ad = null;
  
  private Map<String, PlugInBean> ae = null;
  
  private int ag = -1;
  
  private int ah = -1;
  
  private Map<String, String> ai = new HashMap<String, String>();
  
  private Map<String, String> aj = new HashMap<String, String>();
  
  private Map<String, String> ak = new HashMap<String, String>();
  
  private boolean al = true;
  
  private Boolean am = null;
  
  private Boolean an = null;
  
  private String ao = null;
  
  private String ap = null;
  
  private String aq = null;
  
  private String ar = null;
  
  private String as = null;
  
  private final Object at = new Object();
  
  private final Object au = new Object();
  
  private final Object av = new Object();
  
  private final Object aw = new Object();
  
  private final Object ax = new Object();
  
  private final Object ay = new Object();
  
  private final Object az = new Object();
  
  public final byte b;
  
  public String c;
  
  public final String d;
  
  public boolean e = true;
  
  public final String f;
  
  public final String g;
  
  public final String h;
  
  public long i;
  
  public String j = null;
  
  public String k = null;
  
  public String l = null;
  
  public String m = null;
  
  public String n = null;
  
  public List<String> o = null;
  
  public String p = "unknown";
  
  public long q = 0L;
  
  public long r = 0L;
  
  public long s = 0L;
  
  public long t = 0L;
  
  public boolean u = false;
  
  public String v = null;
  
  public String w = null;
  
  public String x = null;
  
  public boolean y = false;
  
  public boolean z = false;
  
  private a(Context paramContext) {
    this.F = z.a(paramContext);
    this.b = (byte)1;
    PackageInfo packageInfo = AppInfo.b(paramContext);
    if (packageInfo != null)
      try {
        this.j = packageInfo.versionName;
        this.v = this.j;
        this.w = Integer.toString(packageInfo.versionCode);
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throwable.printStackTrace(); 
      }  
    this.c = AppInfo.a(paramContext);
    this.d = AppInfo.a(Process.myPid());
    this.f = b.o();
    this.g = b.a();
    this.k = AppInfo.c(paramContext);
    StringBuilder stringBuilder = new StringBuilder("Android ");
    stringBuilder.append(b.b());
    stringBuilder.append(",level ");
    stringBuilder.append(b.c());
    this.h = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.g);
    stringBuilder.append(";");
    stringBuilder.append(this.h);
    stringBuilder.toString();
    Map<String, String> map = AppInfo.d(paramContext);
    if (map != null)
      try {
        this.o = AppInfo.a(map);
        String str2 = map.get("BUGLY_APPID");
        if (str2 != null) {
          this.Y = str2;
          c("APP_ID", this.Y);
        } 
        str2 = map.get("BUGLY_APP_VERSION");
        if (str2 != null)
          this.j = str2; 
        str2 = map.get("BUGLY_APP_CHANNEL");
        if (str2 != null)
          this.l = str2; 
        str2 = map.get("BUGLY_ENABLE_DEBUG");
        if (str2 != null)
          this.u = str2.equalsIgnoreCase("true"); 
        String str1 = map.get("com.tencent.rdm.uuid");
        if (str1 != null)
          this.x = str1; 
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throwable.printStackTrace(); 
      }  
    try {
      if (!paramContext.getDatabasePath("bugly_db_").exists()) {
        this.z = true;
        x.c("App is first time to be installed on the device.", new Object[0]);
      } 
    } catch (Throwable throwable) {
      if (b.c)
        throwable.printStackTrace(); 
    } 
    this.E = z.a("BUGLY_COMMON_VALUES", paramContext);
    x.c("com info create end", new Object[0]);
  }
  
  public static int K() {
    return b.c();
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/common/info/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/info/a.af : Lcom/tencent/bugly/crashreport/common/info/a;
    //   6: ifnonnull -> 22
    //   9: new com/tencent/bugly/crashreport/common/info/a
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/tencent/bugly/crashreport/common/info/a.af : Lcom/tencent/bugly/crashreport/common/info/a;
    //   22: getstatic com/tencent/bugly/crashreport/common/info/a.af : Lcom/tencent/bugly/crashreport/common/info/a;
    //   25: astore_0
    //   26: ldc com/tencent/bugly/crashreport/common/info/a
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/tencent/bugly/crashreport/common/info/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  public static a b() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/common/info/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/info/a.af : Lcom/tencent/bugly/crashreport/common/info/a;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/crashreport/common/info/a
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/crashreport/common/info/a
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String c() {
    return "3.1.0";
  }
  
  public final String A() {
    if (this.ac == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b.g());
      this.ac = stringBuilder.toString();
      x.a("Hardware serial number: %s", new Object[] { this.ac });
    } 
    return this.ac;
  }
  
  public final Map<String, String> B() {
    synchronized (this.av) {
      if (this.ai.size() <= 0)
        return null; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this((Map)this.ai);
      return (Map)hashMap;
    } 
  }
  
  public final void C() {
    synchronized (this.av) {
      this.ai.clear();
      return;
    } 
  }
  
  public final int D() {
    synchronized (this.av) {
      return this.ai.size();
    } 
  }
  
  public final Set<String> E() {
    synchronized (this.av) {
      return this.ai.keySet();
    } 
  }
  
  public final Map<String, String> F() {
    synchronized (this.az) {
      if (this.aj.size() <= 0)
        return null; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this((Map)this.aj);
      return (Map)hashMap;
    } 
  }
  
  public final Map<String, String> G() {
    synchronized (this.aw) {
      if (this.ak.size() <= 0)
        return null; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this((Map)this.ak);
      return (Map)hashMap;
    } 
  }
  
  public final int H() {
    synchronized (this.ax) {
      return this.ag;
    } 
  }
  
  public final int I() {
    return this.ah;
  }
  
  public final Map<String, PlugInBean> J() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    return null;
  }
  
  public final String L() {
    if (this.ao == null)
      this.ao = b.q(); 
    return this.ao;
  }
  
  public final String M() {
    if (this.ap == null)
      this.ap = b.f(this.F); 
    return this.ap;
  }
  
  public final String N() {
    if (this.aq == null)
      this.aq = b.g(this.F); 
    return this.aq;
  }
  
  public final String O() {
    Context context = this.F;
    return b.r();
  }
  
  public final String P() {
    if (this.ar == null)
      this.ar = b.h(this.F); 
    return this.ar;
  }
  
  public final long Q() {
    Context context = this.F;
    return b.s();
  }
  
  public final boolean R() {
    if (this.am == null) {
      this.am = Boolean.valueOf(b.i(this.F));
      StringBuilder stringBuilder = new StringBuilder("Is it a virtual machine? ");
      stringBuilder.append(this.am);
      x.a(stringBuilder.toString(), new Object[0]);
    } 
    return this.am.booleanValue();
  }
  
  public final boolean S() {
    if (this.an == null) {
      this.an = Boolean.valueOf(b.j(this.F));
      StringBuilder stringBuilder = new StringBuilder("Does it has hook frame? ");
      stringBuilder.append(this.an);
      x.a(stringBuilder.toString(), new Object[0]);
    } 
    return this.an.booleanValue();
  }
  
  public final String T() {
    if (this.H == null) {
      this.H = AppInfo.g(this.F);
      StringBuilder stringBuilder = new StringBuilder("Beacon channel ");
      stringBuilder.append(this.H);
      x.a(stringBuilder.toString(), new Object[0]);
    } 
    return this.H;
  }
  
  public final void a(int paramInt) {
    synchronized (this.ax) {
      int i = this.ag;
      if (i != paramInt) {
        this.ag = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ag) });
      } 
      return;
    } 
  }
  
  public final void a(String paramString) {
    this.Y = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      return; 
    synchronized (this.au) {
      this.A.put(paramString1, paramString2);
      return;
    } 
  }
  
  public final void a(boolean paramBoolean) {
    this.al = paramBoolean;
    if (this.D != null)
      this.D.setNativeIsAppForeground(paramBoolean); 
  }
  
  public final boolean a() {
    return this.al;
  }
  
  public final void b(int paramInt) {
    paramInt = this.ah;
    if (paramInt != 24096) {
      this.ah = 24096;
      x.a("server scene tag %d changed to tag %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ah) });
    } 
  }
  
  public final void b(String paramString) {
    Object object = this.ay;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    String str = paramString;
    if (paramString == null)
      str = "10000"; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(str);
      this.J = stringBuilder.toString();
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    } finally {}
  }
  
  public final void b(String paramString1, String paramString2) {
    if (z.a(paramString1) || z.a(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      String str = stringBuilder.toString();
      null = new StringBuilder();
      null.append(paramString2);
      x.d("key&value should not be empty %s %s", new Object[] { str, null.toString() });
      return;
    } 
    synchronized (this.av) {
      this.ai.put(null, paramString2);
      return;
    } 
  }
  
  public final void b(boolean paramBoolean) {
    this.W = paramBoolean;
  }
  
  public final void c(String paramString) {
    this.I = paramString;
    synchronized (this.az) {
      this.aj.put("E8", paramString);
      return;
    } 
  }
  
  public final void c(String paramString1, String paramString2) {
    if (z.a(paramString1) || z.a(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      x.d("server key&value should not be empty %s %s", new Object[] { paramString1, stringBuilder.toString() });
      return;
    } 
    synchronized (this.aw) {
      this.ak.put(paramString1, paramString2);
      return;
    } 
  }
  
  public final void d() {
    synchronized (this.at) {
      this.G = UUID.randomUUID().toString();
      return;
    } 
  }
  
  public final void d(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: astore_2
    //   6: aload_2
    //   7: invokespecial <init> : ()V
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: putfield K : Ljava/lang/String;
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  public final String e() {
    synchronized (this.at) {
      if (this.G == null)
        synchronized (this.at) {
          this.G = UUID.randomUUID().toString();
        }  
      return this.G;
    } 
  }
  
  public final void e(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: astore_2
    //   6: aload_2
    //   7: invokespecial <init> : ()V
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: putfield L : Ljava/lang/String;
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  public final String f() {
    return !z.a(null) ? null : this.Y;
  }
  
  public final String f(String paramString) {
    if (z.a(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      x.d("key should not be empty %s", new Object[] { stringBuilder.toString() });
      return null;
    } 
    synchronized (this.av) {
      paramString = this.ai.remove(paramString);
      return paramString;
    } 
  }
  
  public final String g() {
    synchronized (this.ay) {
      return this.J;
    } 
  }
  
  public final String g(String paramString) {
    if (z.a(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      x.d("key should not be empty %s", new Object[] { stringBuilder.toString() });
      return null;
    } 
    synchronized (this.av) {
      paramString = this.ai.get(paramString);
      return paramString;
    } 
  }
  
  public final String h() {
    if (this.I != null)
      return this.I; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(k());
    stringBuilder.append("|");
    stringBuilder.append(m());
    stringBuilder.append("|");
    stringBuilder.append(n());
    this.I = stringBuilder.toString();
    return this.I;
  }
  
  public final String i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield K : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final String j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield L : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final String k() {
    if (!this.W)
      return ""; 
    if (this.M == null) {
      Context context = this.F;
      this.M = b.d();
    } 
    return this.M;
  }
  
  public final String l() {
    if (!this.W)
      return ""; 
    if (this.N == null || !this.N.contains(":")) {
      Context context = this.F;
      this.N = b.f();
    } 
    return this.N;
  }
  
  public final String m() {
    if (!this.W)
      return ""; 
    if (this.O == null) {
      Context context = this.F;
      this.O = b.e();
    } 
    return this.O;
  }
  
  public final String n() {
    if (!this.W)
      return ""; 
    if (this.P == null)
      this.P = b.a(this.F); 
    return this.P;
  }
  
  public final long o() {
    if (this.Q <= 0L)
      this.Q = b.h(); 
    return this.Q;
  }
  
  public final long p() {
    if (this.R <= 0L)
      this.R = b.j(); 
    return this.R;
  }
  
  public final long q() {
    if (this.S <= 0L)
      this.S = b.l(); 
    return this.S;
  }
  
  public final String r() {
    if (this.T == null)
      this.T = b.a(this.F, true); 
    return this.T;
  }
  
  public final String s() {
    if (this.U == null)
      this.U = b.e(this.F); 
    return this.U;
  }
  
  public final String t() {
    try {
      Map map = this.F.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!map.isEmpty())
        synchronized (this.au) {
          for (Map.Entry entry : map.entrySet()) {
            try {
              this.A.put((String)entry.getKey(), entry.getValue().toString());
            } catch (Throwable throwable) {
              x.a(throwable);
            } 
          } 
        }  
    } catch (Throwable throwable) {
      x.a(throwable);
    } 
    if (!this.A.isEmpty()) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Map.Entry<String, String> entry : this.A.entrySet()) {
        stringBuilder.append("[");
        stringBuilder.append((String)entry.getKey());
        stringBuilder.append(",");
        stringBuilder.append((String)entry.getValue());
        stringBuilder.append("] ");
      } 
      c("SDK_INFO", stringBuilder.toString());
      return stringBuilder.toString();
    } 
    return null;
  }
  
  public final String u() {
    if (this.as == null)
      this.as = AppInfo.e(this.F); 
    return this.as;
  }
  
  public final Map<String, PlugInBean> v() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    return null;
  }
  
  public final String w() {
    if (this.X == null)
      this.X = b.n(); 
    return this.X;
  }
  
  public final Boolean x() {
    if (this.Z == null)
      this.Z = Boolean.valueOf(b.p()); 
    return this.Z;
  }
  
  public final String y() {
    if (this.aa == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b.d(this.F));
      this.aa = stringBuilder.toString();
      x.a("ROM ID: %s", new Object[] { this.aa });
    } 
    return this.aa;
  }
  
  public final String z() {
    if (this.ab == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b.b(this.F));
      this.ab = stringBuilder.toString();
      x.a("SIM serial number: %s", new Object[] { this.ab });
    } 
    return this.ab;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */