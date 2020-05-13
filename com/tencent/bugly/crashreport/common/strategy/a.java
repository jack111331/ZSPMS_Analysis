package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

public final class a {
  public static int a = 1000;
  
  private static a b;
  
  private static String h;
  
  private final List<com.tencent.bugly.a> c;
  
  private final w d;
  
  private final StrategyBean e;
  
  private StrategyBean f = null;
  
  private Context g;
  
  private a(Context paramContext, List<com.tencent.bugly.a> paramList) {
    this.g = paramContext;
    this.e = new StrategyBean();
    this.c = paramList;
    this.d = w.a();
  }
  
  public static a a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.a> paramList) {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   6: ifnonnull -> 23
    //   9: new com/tencent/bugly/crashreport/common/strategy/a
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial <init> : (Landroid/content/Context;Ljava/util/List;)V
    //   19: aload_2
    //   20: putstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   23: getstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   26: astore_0
    //   27: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	32	finally
    //   23	27	32	finally
  }
  
  public static void a(String paramString) {
    if (z.a(paramString) || !z.c(paramString)) {
      x.d("URL user set is invalid.", new Object[0]);
      return;
    } 
    h = paramString;
  }
  
  public static StrategyBean d() {
    List<r> list = p.a().a(2);
    if (list != null && list.size() > 0) {
      r r = list.get(0);
      if (r.g != null)
        return (StrategyBean)z.a(r.g, StrategyBean.CREATOR); 
    } 
    return null;
  }
  
  public final void a(long paramLong) {
    this.d.a(new Thread(this) {
          public final void run() {
            try {
              Map map = p.a().a(a.a, null, true);
              if (map != null) {
                byte[] arrayOfByte2 = (byte[])map.get("device");
                byte[] arrayOfByte1 = (byte[])map.get("gateway");
                if (arrayOfByte2 != null) {
                  com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a));
                  String str = new String();
                  this(arrayOfByte2);
                  a3.e(str);
                } 
                if (arrayOfByte1 != null) {
                  com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a));
                  String str = new String();
                  this(arrayOfByte1);
                  a3.d(str);
                } 
              } 
              a a1 = this.a;
              a a2 = this.a;
              a.a(a1, a.d());
              if (a.b(this.a) != null && !z.a(a.e()) && z.c(a.e())) {
                (a.b(this.a)).r = a.e();
                (a.b(this.a)).s = a.e();
              } 
            } catch (Throwable throwable) {
              if (!x.a(throwable))
                throwable.printStackTrace(); 
            } 
            this.a.a(a.b(this.a), false);
          }
        }paramLong);
  }
  
  protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean) {
    x.c("[Strategy] Notify %s", new Object[] { b.class.getName() });
    b.a(paramStrategyBean, paramBoolean);
    for (com.tencent.bugly.a a1 : this.c) {
      try {
        x.c("[Strategy] Notify %s", new Object[] { a1.getClass().getName() });
        a1.onServerStrategyChanged(paramStrategyBean);
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throwable.printStackTrace(); 
      } 
    } 
  }
  
  public final void a(as paramas) {
    if (paramas == null)
      return; 
    if (this.f != null && paramas.h == this.f.p)
      return; 
    StrategyBean strategyBean = new StrategyBean();
    strategyBean.g = paramas.a;
    strategyBean.i = paramas.c;
    strategyBean.h = paramas.b;
    if (z.a(h) || !z.c(h)) {
      if (z.c(paramas.d)) {
        x.c("[Strategy] Upload url changes to %s", new Object[] { paramas.d });
        strategyBean.r = paramas.d;
      } 
      if (z.c(paramas.e)) {
        x.c("[Strategy] Exception upload url changes to %s", new Object[] { paramas.e });
        strategyBean.s = paramas.e;
      } 
    } 
    if (paramas.f != null && !z.a(paramas.f.a))
      strategyBean.u = paramas.f.a; 
    if (paramas.h != 0L)
      strategyBean.p = paramas.h; 
    if (paramas.g != null && paramas.g.size() > 0) {
      strategyBean.v = paramas.g;
      String str2 = (String)paramas.g.get("B11");
      if (str2 != null && str2.equals("1")) {
        strategyBean.j = true;
      } else {
        strategyBean.j = false;
      } 
      str2 = (String)paramas.g.get("B3");
      if (str2 != null)
        strategyBean.y = Long.valueOf(str2).longValue(); 
      strategyBean.q = paramas.i;
      strategyBean.x = paramas.i;
      str2 = (String)paramas.g.get("B27");
      if (str2 != null && str2.length() > 0)
        try {
          int i = Integer.parseInt(str2);
          if (i > 0)
            strategyBean.w = i; 
        } catch (Exception exception) {
          if (!x.a(exception))
            exception.printStackTrace(); 
        }  
      String str1 = (String)paramas.g.get("B25");
      if (str1 != null && str1.equals("1")) {
        strategyBean.l = true;
      } else {
        strategyBean.l = false;
      } 
    } 
    x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.j), Boolean.valueOf(strategyBean.k), Boolean.valueOf(strategyBean.n), Boolean.valueOf(strategyBean.o), Long.valueOf(strategyBean.q), Boolean.valueOf(strategyBean.l), Long.valueOf(strategyBean.p) });
    this.f = strategyBean;
    p.a().b(2);
    r r = new r();
    r.b = 2;
    r.a = strategyBean.e;
    r.e = strategyBean.f;
    r.g = z.a(strategyBean);
    p.a().a(r);
    a(strategyBean, true);
  }
  
  public final boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c() {
    return (this.f != null) ? this.f : this.e;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */