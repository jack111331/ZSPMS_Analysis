package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.b;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.f;
import com.tencent.wxop.stat.a.i;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  private static volatile boolean S;
  
  static volatile int aI;
  
  private static f aK;
  
  private static volatile Map<b, Long> aL = new ConcurrentHashMap<b, Long>();
  
  private static volatile Map<String, Properties> aM = new ConcurrentHashMap<String, Properties>();
  
  private static volatile Map<Integer, Integer> aN = new ConcurrentHashMap<Integer, Integer>(10);
  
  private static volatile long aO = 0L;
  
  private static volatile long aP;
  
  private static volatile int aQ;
  
  private static volatile String aR;
  
  private static volatile String aS;
  
  private static Map<String, Long> aT;
  
  private static Map<String, Long> aU;
  
  private static b aV;
  
  private static Thread.UncaughtExceptionHandler aW;
  
  static volatile long aX;
  
  private static Context aY;
  
  static volatile long aZ;
  
  private static volatile long af = 0L;
  
  private static String al;
  
  static {
    aP = 0L;
    al = "";
    aQ = 0;
    aR = "";
    aS = "";
    aT = new ConcurrentHashMap<String, Long>();
    aU = new ConcurrentHashMap<String, Long>();
    aV = l.av();
    aW = null;
    S = true;
    aI = 0;
    aX = 0L;
    aY = null;
    aZ = 0L;
  }
  
  private static JSONObject G() {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      this();
      if (c.P.L != 0)
        jSONObject1.put("v", c.P.L); 
      jSONObject.put(Integer.toString(c.P.aI), jSONObject1);
      jSONObject1 = new JSONObject();
      this();
      if (c.O.L != 0)
        jSONObject1.put("v", c.O.L); 
      jSONObject.put(Integer.toString(c.O.aI), jSONObject1);
    } catch (JSONException jSONException) {
      aV.b((Throwable)jSONException);
    } 
    return jSONObject;
  }
  
  static void H() {
    aI = 0;
    aX = 0L;
  }
  
  static void I() {
    aI++;
    aX = System.currentTimeMillis();
    p(aY);
  }
  
  static int a(Context paramContext, boolean paramBoolean, f paramf) {
    boolean bool2;
    boolean bool1 = true;
    long l = System.currentTimeMillis();
    if (paramBoolean && l - af >= c.m()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    af = l;
    if (aP == 0L)
      aP = l.ad(); 
    if (l >= aP) {
      aP = l.ad();
      if (t.s(paramContext).t(paramContext).as() != 1)
        t.s(paramContext).t(paramContext).z(); 
      c.C();
      aI = 0;
      al = l.aw();
      bool2 = true;
    } 
    String str = al;
    if (l.a(paramf))
      str = paramf.S() + al; 
    if (!aU.containsKey(str))
      bool2 = bool1; 
    if (bool2) {
      if (!l.a(paramf)) {
        if (c.D() < c.A()) {
          l.O(paramContext);
          a(paramContext, (f)null);
        } else {
          aV.d("Exceed StatConfig.getMaxDaySessionNumbers().");
        } 
      } else {
        a(paramContext, paramf);
      } 
      aU.put(str, Long.valueOf(1L));
    } 
    if (S) {
      if (c.l()) {
        paramContext = i(paramContext);
        if (paramContext == null) {
          aV.error("The Context of StatService.testSpeed() can not be null!");
        } else if (k(paramContext) != null) {
          aK.a(new i(paramContext));
        } 
      } 
      S = false;
    } 
    return aQ;
  }
  
  private static void a(Context paramContext, f paramf) {
    if (k(paramContext) != null) {
      if (c.k())
        aV.e("start new session."); 
      if (paramf == null || aQ == 0)
        aQ = l.r(); 
      c.z();
      c.B();
      (new p((d)new i(paramContext, aQ, G(), paramf))).ah();
    } 
  }
  
  public static void a(Context paramContext, String paramString, f paramf) {
    if (c.l()) {
      paramContext = i(paramContext);
      if (paramContext == null || paramString == null || paramString.length() == 0) {
        aV.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
        return;
      } 
      paramString = new String(paramString);
      if (k(paramContext) != null)
        aK.a(new as(paramString, paramContext, paramf)); 
    } 
  }
  
  static void a(Context paramContext, Throwable paramThrowable) {
    if (c.l()) {
      paramContext = i(paramContext);
      if (paramContext == null) {
        aV.error("The Context of StatService.reportSdkSelfException() can not be null!");
        return;
      } 
      if (k(paramContext) != null)
        aK.a(new ap(paramContext, paramThrowable)); 
    } 
  }
  
  static boolean a() {
    if (aI >= 2) {
      aX = System.currentTimeMillis();
      return true;
    } 
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    String str;
    StringBuilder stringBuilder;
    null = false;
    try {
      if (!c.l()) {
        aV.error("MTA StatService is disable.");
        return null;
      } 
      if (c.k()) {
        b b1 = aV;
        StringBuilder stringBuilder1 = new StringBuilder();
        this("MTA SDK version, current: ");
        b1.e(stringBuilder1.append("2.0.3").append(" ,required: ").append(paramString2).toString());
      } 
      if (paramContext == null || paramString2 == null) {
        aV.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
        c.a(false);
        return null;
      } 
    } catch (Throwable throwable) {
      aV.b(throwable);
      return null;
    } 
    if (l.u("2.0.3") < l.u(paramString2)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      this("MTA SDK version conflicted, current: ");
      str = stringBuilder1.append("2.0.3").append(",required: ").append(paramString2).toString();
      stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(str).append(". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/").toString();
      aV.error(str);
      c.a(false);
      return null;
    } 
    paramString2 = c.e((Context)str);
    if (paramString2 == null || paramString2.length() == 0)
      c.n("-"); 
    if (stringBuilder != null)
      c.b((Context)str, (String)stringBuilder); 
    if (k((Context)str) != null) {
      f f1 = aK;
      m m = new m();
      this((Context)str);
      f1.a(m);
    } 
    return true;
  }
  
  public static void b(Context paramContext, String paramString, f paramf) {
    if (c.l()) {
      paramContext = i(paramContext);
      if (paramContext == null || paramString == null || paramString.length() == 0) {
        aV.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
        return;
      } 
      paramString = new String(paramString);
      if (k(paramContext) != null)
        aK.a(new k(paramContext, paramString, paramf)); 
    } 
  }
  
  public static void d(Context paramContext, String paramString) {
    if (c.l()) {
      boolean bool;
      paramContext = i(paramContext);
      if (paramContext == null) {
        aV.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      } 
      if (paramString == null || paramString.length() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        aV.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      } 
      b b1 = new b(paramString);
      if (k(paramContext) != null)
        aK.a(new ar(paramContext, b1)); 
    } 
  }
  
  private static Context i(Context paramContext) {
    if (paramContext == null)
      paramContext = aY; 
    return paramContext;
  }
  
  private static void j(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc com/tencent/wxop/stat/e
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull -> 13
    //   9: ldc com/tencent/wxop/stat/e
    //   11: monitorexit
    //   12: return
    //   13: getstatic com/tencent/wxop/stat/e.aK : Lcom/tencent/wxop/stat/b/f;
    //   16: ifnonnull -> 9
    //   19: aload_0
    //   20: getstatic com/tencent/wxop/stat/c.c : Ljava/lang/String;
    //   23: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)J
    //   26: lstore_2
    //   27: ldc_w '2.0.3'
    //   30: invokestatic u : (Ljava/lang/String;)J
    //   33: lstore #4
    //   35: iconst_1
    //   36: istore #6
    //   38: lload #4
    //   40: lload_2
    //   41: lcmp
    //   42: ifgt -> 91
    //   45: getstatic com/tencent/wxop/stat/e.aV : Lcom/tencent/wxop/stat/b/b;
    //   48: astore #7
    //   50: new java/lang/StringBuilder
    //   53: astore #8
    //   55: aload #8
    //   57: ldc_w 'MTA is disable for current version:'
    //   60: invokespecial <init> : (Ljava/lang/String;)V
    //   63: aload #7
    //   65: aload #8
    //   67: lload #4
    //   69: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   72: ldc_w ',wakeup version:'
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: lload_2
    //   79: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: invokevirtual error : (Ljava/lang/Object;)V
    //   88: iconst_0
    //   89: istore #6
    //   91: aload_0
    //   92: getstatic com/tencent/wxop/stat/c.W : Ljava/lang/String;
    //   95: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)J
    //   98: lstore_2
    //   99: lload_2
    //   100: invokestatic currentTimeMillis : ()J
    //   103: lcmp
    //   104: ifle -> 236
    //   107: getstatic com/tencent/wxop/stat/e.aV : Lcom/tencent/wxop/stat/b/b;
    //   110: astore #8
    //   112: new java/lang/StringBuilder
    //   115: astore #7
    //   117: aload #7
    //   119: ldc_w 'MTA is disable for current time:'
    //   122: invokespecial <init> : (Ljava/lang/String;)V
    //   125: aload #8
    //   127: aload #7
    //   129: invokestatic currentTimeMillis : ()J
    //   132: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   135: ldc_w ',wakeup time:'
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: lload_2
    //   142: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   145: invokevirtual toString : ()Ljava/lang/String;
    //   148: invokevirtual error : (Ljava/lang/Object;)V
    //   151: iload_1
    //   152: istore #6
    //   154: iload #6
    //   156: invokestatic a : (Z)V
    //   159: iload #6
    //   161: ifeq -> 9
    //   164: aload_0
    //   165: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   168: astore_0
    //   169: aload_0
    //   170: putstatic com/tencent/wxop/stat/e.aY : Landroid/content/Context;
    //   173: new com/tencent/wxop/stat/b/f
    //   176: astore #7
    //   178: aload #7
    //   180: invokespecial <init> : ()V
    //   183: aload #7
    //   185: putstatic com/tencent/wxop/stat/e.aK : Lcom/tencent/wxop/stat/b/f;
    //   188: invokestatic aw : ()Ljava/lang/String;
    //   191: putstatic com/tencent/wxop/stat/e.al : Ljava/lang/String;
    //   194: invokestatic currentTimeMillis : ()J
    //   197: getstatic com/tencent/wxop/stat/c.af : J
    //   200: ladd
    //   201: putstatic com/tencent/wxop/stat/e.aO : J
    //   204: getstatic com/tencent/wxop/stat/e.aK : Lcom/tencent/wxop/stat/b/f;
    //   207: astore #8
    //   209: new com/tencent/wxop/stat/an
    //   212: astore #7
    //   214: aload #7
    //   216: aload_0
    //   217: invokespecial <init> : (Landroid/content/Context;)V
    //   220: aload #8
    //   222: aload #7
    //   224: invokevirtual a : (Ljava/lang/Runnable;)V
    //   227: goto -> 9
    //   230: astore_0
    //   231: ldc com/tencent/wxop/stat/e
    //   233: monitorexit
    //   234: aload_0
    //   235: athrow
    //   236: goto -> 154
    // Exception table:
    //   from	to	target	type
    //   13	35	230	finally
    //   45	88	230	finally
    //   91	151	230	finally
    //   154	159	230	finally
    //   164	227	230	finally
  }
  
  private static f k(Context paramContext) {
    // Byte code:
    //   0: getstatic com/tencent/wxop/stat/e.aK : Lcom/tencent/wxop/stat/b/f;
    //   3: ifnonnull -> 24
    //   6: ldc com/tencent/wxop/stat/e
    //   8: monitorenter
    //   9: getstatic com/tencent/wxop/stat/e.aK : Lcom/tencent/wxop/stat/b/f;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull -> 21
    //   17: aload_0
    //   18: invokestatic j : (Landroid/content/Context;)V
    //   21: ldc com/tencent/wxop/stat/e
    //   23: monitorexit
    //   24: getstatic com/tencent/wxop/stat/e.aK : Lcom/tencent/wxop/stat/b/f;
    //   27: areturn
    //   28: astore_0
    //   29: getstatic com/tencent/wxop/stat/e.aV : Lcom/tencent/wxop/stat/b/b;
    //   32: aload_0
    //   33: invokevirtual a : (Ljava/lang/Throwable;)V
    //   36: iconst_0
    //   37: invokestatic a : (Z)V
    //   40: goto -> 21
    //   43: astore_0
    //   44: ldc com/tencent/wxop/stat/e
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   9	13	43	finally
    //   17	21	28	java/lang/Throwable
    //   17	21	43	finally
    //   21	24	43	finally
    //   29	40	43	finally
  }
  
  public static void l(Context paramContext) {
    if (c.l() && k(paramContext) != null)
      aK.a(new l(paramContext)); 
  }
  
  public static void m(Context paramContext) {
    if (c.l() && k(paramContext) != null)
      aK.a(new ao(paramContext)); 
  }
  
  static void n(Context paramContext) {
    if (c.l()) {
      Context context = i(paramContext);
      if (context == null) {
        aV.error("The Context of StatService.sendNetworkDetector() can not be null!");
        return;
      } 
      try {
        f f1 = new f();
        this(context);
        ak ak = ak.Z(context);
        aq aq = new aq();
        this();
        ak.a((d)f1, aq);
      } catch (Throwable throwable) {
        aV.b(throwable);
      } 
    } 
  }
  
  public static void o(Context paramContext) {
    if (c.l()) {
      if (c.k())
        aV.b("commitEvents, maxNumber=-1"); 
      paramContext = i(paramContext);
      if (paramContext == null) {
        aV.error("The Context of StatService.commitEvents() can not be null!");
        return;
      } 
      if (g.r(aY).X() && k(paramContext) != null)
        aK.a(new h(paramContext)); 
    } 
  }
  
  public static Properties p(String paramString) {
    return aM.get(paramString);
  }
  
  public static void p(Context paramContext) {
    if (c.l() && c.ay > 0) {
      paramContext = i(paramContext);
      if (paramContext == null) {
        aV.error("The Context of StatService.testSpeed() can not be null!");
        return;
      } 
      t.s(paramContext).H();
    } 
  }
  
  static void q(Context paramContext) {
    aZ = System.currentTimeMillis() + (60000 * c.u());
    q.a(paramContext, "last_period_ts", aZ);
    o(paramContext);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */