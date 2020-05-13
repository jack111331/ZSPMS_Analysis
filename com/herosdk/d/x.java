package com.herosdk.d;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.b.a;
import com.herosdk.b.ao;
import com.herosdk.base.IFactoryBase;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.bean.c;
import com.herosdk.bean.d;
import com.herosdk.bean.e;
import com.herosdk.c.a;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ILoginListener;
import com.herosdk.widget.c;
import java.lang.reflect.Field;
import java.util.List;

public class x {
  private static final String a = "frameLib.mus";
  
  private static final int b = 1;
  
  private static volatile x c = null;
  
  private int A = 0;
  
  private int B = -35748;
  
  private String C = "";
  
  private boolean D = false;
  
  private boolean E = false;
  
  private boolean F = false;
  
  private boolean G = false;
  
  private int H = 0;
  
  private long I = 0L;
  
  private CountDownTimer J = null;
  
  private int K = 0;
  
  private boolean L = false;
  
  private c M = null;
  
  private int N = 21;
  
  private boolean O = false;
  
  private int P = 0;
  
  private IFactoryBase d = null;
  
  private UserInfo e = null;
  
  private RoleInfo f = null;
  
  private boolean g = false;
  
  private e h;
  
  private e i;
  
  private e j = null;
  
  private e k = null;
  
  private e l = null;
  
  private e m = null;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private a p = null;
  
  private Activity q;
  
  private Context r = null;
  
  private String s = "";
  
  private String t = "";
  
  private String u = "";
  
  private String v = "";
  
  private String w = "";
  
  private String x = "";
  
  private String y = "";
  
  private c z = new c();
  
  private x() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      this.d = (IFactoryBase)Class.forName(stringBuilder.append(o.c()).append(k.a().g()).append(o.e()).toString()).newInstance();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      this.d = null;
    } 
  }
  
  private Boolean V() {
    if (a().G() == 2 && a().H() != -35748) {
      boolean bool1 = true;
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  public static x a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/x.c : Lcom/herosdk/d/x;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/d/x
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/x.c : Lcom/herosdk/d/x;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/d/x
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/x.c : Lcom/herosdk/d/x;
    //   27: ldc com/herosdk/d/x
    //   29: monitorexit
    //   30: getstatic com/herosdk/d/x.c : Lcom/herosdk/d/x;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/d/x
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString1, String paramString2) {
    try {
      ae ae = new ae();
      this(this, paramActivity, paramString1, paramString2, paramInt);
      bb.a(ae);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  private void a(DialogInterface paramDialogInterface, Boolean paramBoolean) {
    try {
      Field field = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      field.setAccessible(true);
      field.set(paramDialogInterface, paramBoolean);
      paramDialogInterface.dismiss();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  private void f(Activity paramActivity) {
    if (a().G() == 1) {
      g(paramActivity);
      return;
    } 
    if (V().booleanValue())
      h(paramActivity); 
  }
  
  private void g(Activity paramActivity) {
    try {
      if (!K()) {
        e(true);
        if (this.J != null) {
          this.J.cancel();
          this.J = null;
        } 
        c c1 = F();
        a(c1.g());
        b(c1.h());
        c(c1.i());
        d(c1.j());
        e(c1.k());
        c(c1.m());
        b(c1.l().booleanValue());
        f(c1.n());
        if (c1.a() != -1)
          a(paramActivity, c1.a(), c1.b(), c1.c()); 
        if (c1.d() != -1)
          bb.a(paramActivity, c1.f(), c1.e()); 
        if (c1.l().booleanValue())
          c(paramActivity); 
        d(paramActivity);
        if (c() == 0) {
          if (HeroSdk.getInstance().getInitListener() != null) {
            HeroSdk.getInstance().getInitListener().onSuccess();
            return;
          } 
          Log.e("frameLib.mus", "初始化失败，请在init之前调用setInitListener");
          aa aa = new aa();
          this(this, paramActivity);
          bb.a(aa);
        } 
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  private void h(Activity paramActivity) {
    if (L()) {
      Log.d("frameLib.mus", "splIF...return");
      return;
    } 
    f(true);
    if (this.J != null) {
      this.J.cancel();
      this.J = null;
    } 
    int i = a().H();
    String str = a().I();
    Log.d("frameLib.mus", "splIF code:" + i + ",msg:" + str);
    if (i == 1)
      bb.a(paramActivity, str, Boolean.valueOf(true)); 
    if (c() == 0 && HeroSdk.getInstance().getInitListener() != null)
      HeroSdk.getInstance().getInitListener().onFailed("code:" + i + ",msg:" + str); 
  }
  
  public String A() {
    return this.u;
  }
  
  public String B() {
    return this.v;
  }
  
  public String C() {
    return this.w;
  }
  
  public String D() {
    return this.x;
  }
  
  public String E() {
    return this.y;
  }
  
  public c F() {
    return this.z;
  }
  
  public int G() {
    return this.A;
  }
  
  public int H() {
    return this.B;
  }
  
  public String I() {
    return this.C;
  }
  
  public boolean J() {
    return this.D;
  }
  
  public boolean K() {
    return this.F;
  }
  
  public boolean L() {
    return this.G;
  }
  
  public void M() {
    try {
      if (this.r != null && this.p != null) {
        this.r.unregisterReceiver((BroadcastReceiver)this.p);
        this.r = null;
        this.p = null;
      } 
    } catch (Exception exception) {
      this.r = null;
      this.p = null;
    } 
  }
  
  public Boolean N() {
    if (a().G() == 2 && a().H() == -35749) {
      boolean bool1 = true;
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  public void O() {
    Log.d("frameLib.mus", "cspc");
    ba.a().a(new ah(this));
  }
  
  public void P() {
    g(C() + "?pcode=" + k.a().j() + "&channel=" + f() + "&cid=" + c() + "&accessToken=" + ao.a);
  }
  
  public void Q() {
    try {
      aj aj = new aj();
      this(this);
      bb.a(aj);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean R() {
    return (this.N >= 28);
  }
  
  public boolean S() {
    return this.O;
  }
  
  public void T() {
    az.b = Boolean.valueOf(false);
    a().g(false);
    az.c = Boolean.valueOf(false);
  }
  
  public int U() {
    return this.P;
  }
  
  public String a(String paramString) {
    return k.a().a(paramString);
  }
  
  public void a(int paramInt) {
    this.A = paramInt;
  }
  
  public void a(int paramInt, String paramString) {
    this.B = paramInt;
    this.C = paramString;
  }
  
  public void a(Activity paramActivity) {
    this.q = paramActivity;
  }
  
  public void a(Activity paramActivity, UserInfo paramUserInfo, ILoginListener paramILoginListener) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #4
    //   4: aload #4
    //   6: astore #5
    //   8: aload_0
    //   9: getfield d : Lcom/herosdk/base/IFactoryBase;
    //   12: ifnull -> 74
    //   15: aload #4
    //   17: astore #5
    //   19: aload_0
    //   20: getfield d : Lcom/herosdk/base/IFactoryBase;
    //   23: invokeinterface getUser : ()Lcom/herosdk/base/IUserBase;
    //   28: ifnull -> 74
    //   31: aload_0
    //   32: getfield d : Lcom/herosdk/base/IFactoryBase;
    //   35: invokeinterface getUser : ()Lcom/herosdk/base/IUserBase;
    //   40: invokeinterface getChannelLoginParams : ()Ljava/lang/String;
    //   45: astore #4
    //   47: aload #4
    //   49: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   52: ifne -> 70
    //   55: aload #4
    //   57: astore #5
    //   59: aload #4
    //   61: ldc_w 'null'
    //   64: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   67: ifeq -> 74
    //   70: ldc ''
    //   72: astore #5
    //   74: invokestatic a : ()Lcom/herosdk/b/a;
    //   77: astore #4
    //   79: new com/herosdk/d/ac
    //   82: astore #6
    //   84: aload #6
    //   86: aload_0
    //   87: aload_3
    //   88: aload_1
    //   89: invokespecial <init> : (Lcom/herosdk/d/x;Lcom/herosdk/listener/ILoginListener;Landroid/app/Activity;)V
    //   92: aload #4
    //   94: aload_1
    //   95: aload_2
    //   96: aload #5
    //   98: aload #6
    //   100: invokevirtual a : (Landroid/content/Context;Lcom/herosdk/bean/UserInfo;Ljava/lang/String;Lcom/herosdk/listener/ILoginListener;)V
    //   103: return
    //   104: astore_1
    //   105: aload_1
    //   106: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   109: goto -> 103
    // Exception table:
    //   from	to	target	type
    //   8	15	104	java/lang/Exception
    //   19	55	104	java/lang/Exception
    //   59	70	104	java/lang/Exception
    //   74	103	104	java/lang/Exception
  }
  
  public void a(Activity paramActivity, String paramString) {
    try {
      Class<?> clazz = Class.forName("com.hu.zxlib.common.ScanUtils");
      if (clazz != null)
        clazz.getDeclaredMethod("launchBarcodeScanner", new Class[] { Activity.class, String.class }).invoke(clazz, new Object[] { paramActivity, paramString }); 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Context paramContext) {
    try {
      b((((Application)paramContext).getApplicationInfo()).targetSdkVersion);
      this.d.getLifecycle().onApplicationInit(paramContext);
      ap.a().a((Application)paramContext);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Context paramContext, Throwable paramThrowable) {
    try {
      if (System.currentTimeMillis() - this.I >= 500L) {
        this.I = System.currentTimeMillis();
        a.a().a(paramContext, ErrorUtils.a(paramThrowable));
        ErrorUtils.printExceptionInfo(paramThrowable);
      } 
    } catch (Exception exception) {}
  }
  
  public void a(RoleInfo paramRoleInfo) {
    this.f = paramRoleInfo;
  }
  
  public void a(UserInfo paramUserInfo) {
    this.e = paramUserInfo;
  }
  
  public void a(c paramc) {
    this.z = paramc;
  }
  
  public void a(e parame) {
    this.h = parame;
  }
  
  public void a(List<d> paramList) {
    Log.d("frameLib.mus", "ccsp");
    if (paramList != null && paramList.size() > 0 && this.H < paramList.size()) {
      d d = paramList.get(this.H);
      if (h() != null && d.a().equals(i().getRoleId())) {
        a.a().a((Context)x(), d.b(), d.c(), new ai(this, paramList));
        return;
      } 
      this.H = 0;
      Log.d("frameLib.mus", "ccsp else rid not equal");
      return;
    } 
    this.H = 0;
    Log.d("frameLib.mus", "ccsp else...finish");
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public boolean a(Activity paramActivity, int paramInt) {
    boolean bool;
    try {
      bool = this.d.getSdk().callExtendApi(paramActivity, paramInt);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public IFactoryBase b() {
    return this.d;
  }
  
  public String b(Context paramContext) {
    try {
      int i = c();
      if (i == 18 || i == 75 || i == 100 || i == 95 || i == 96) {
        Class<?> clazz = Class.forName("com.zz.sdk.SDKManager");
        if (clazz != null)
          return (String)clazz.getDeclaredMethod("getProjectId", new Class[] { Context.class }).invoke(clazz, new Object[] { paramContext }); 
      } else if (i == 85 || i == 116) {
        Class<?> clazz = Class.forName("com.herosdk.channel.youwan.Sdk");
        if (clazz != null)
          return (String)clazz.getDeclaredMethod("getProjectId", new Class[0]).invoke(clazz, new Object[0]); 
      } else {
        return a().a("channel_cps_id").trim();
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  public void b(int paramInt) {
    this.N = paramInt;
  }
  
  public void b(Activity paramActivity) {
    try {
      if (a().G() == 1) {
        g(paramActivity);
        return;
      } 
      if (N().booleanValue()) {
        a().e(paramActivity);
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    if (V().booleanValue()) {
      h((Activity)exception);
      return;
    } 
    if (a().G() == 0) {
      y y = new y();
      this(this, 9200L, 650L, (Activity)exception);
      this.J = y;
      this.J.start();
      return;
    } 
    Log.e("frameLib.mus", "dse error...else");
  }
  
  public void b(e parame) {
    this.i = parame;
  }
  
  public void b(String paramString) {
    this.s = paramString;
  }
  
  public void b(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public int c() {
    boolean bool;
    try {
      bool = k.a().d();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public String c(Context paramContext) {
    return m.a(paramContext).b();
  }
  
  public void c(int paramInt) {
    this.P = paramInt;
  }
  
  public void c(Activity paramActivity) {
    if (c() != 0) {
      m.a((Context)paramActivity).a(new ab(this, paramActivity));
      m.a((Context)paramActivity).c((Context)paramActivity);
    } 
  }
  
  public void c(e parame) {
    this.j = parame;
  }
  
  public void c(String paramString) {
    try {
      this.t = ao.a(paramString);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      this.t = "";
    } 
  }
  
  public void c(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  @Deprecated
  public int d() {
    boolean bool;
    try {
      bool = k.a().e();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void d(Activity paramActivity) {
    try {
      if (!this.E) {
        this.E = true;
        a.a().b((Context)paramActivity);
      } 
    } catch (Exception exception) {}
  }
  
  public void d(Context paramContext) {
    if (paramContext != null)
      try {
        if (this.p == null) {
          this.r = paramContext;
          a a1 = new a();
          this();
          this.p = a1;
          IntentFilter intentFilter = new IntentFilter();
          this();
          intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          paramContext.registerReceiver((BroadcastReceiver)this.p, intentFilter);
        } 
      } catch (Exception exception) {
        ErrorUtils.printExceptionInfo(exception);
      }  
  }
  
  public void d(e parame) {
    this.k = parame;
  }
  
  public void d(String paramString) {
    this.u = paramString;
  }
  
  public void d(boolean paramBoolean) {
    this.D = paramBoolean;
  }
  
  public int e() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: invokevirtual c : ()I
    //   8: istore_3
    //   9: iload_3
    //   10: bipush #67
    //   12: if_icmpne -> 120
    //   15: ldc_w 'com.quicksdk.Extend'
    //   18: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   21: astore #4
    //   23: aload #4
    //   25: ifnull -> 113
    //   28: aload #4
    //   30: invokevirtual getDeclaredConstructors : ()[Ljava/lang/reflect/Constructor;
    //   33: astore #5
    //   35: aload #5
    //   37: iconst_1
    //   38: invokestatic setAccessible : ([Ljava/lang/reflect/AccessibleObject;Z)V
    //   41: aload #5
    //   43: arraylength
    //   44: istore_1
    //   45: iload_2
    //   46: iload_1
    //   47: if_icmpge -> 113
    //   50: aload #5
    //   52: iload_2
    //   53: aaload
    //   54: astore #6
    //   56: aload #6
    //   58: invokevirtual isAccessible : ()Z
    //   61: ifeq -> 105
    //   64: aload #6
    //   66: iconst_0
    //   67: anewarray java/lang/Object
    //   70: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   73: astore #5
    //   75: aload #4
    //   77: ldc_w 'getChannelType'
    //   80: iconst_0
    //   81: anewarray java/lang/Class
    //   84: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   87: aload #5
    //   89: iconst_0
    //   90: anewarray java/lang/Object
    //   93: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast java/lang/Integer
    //   99: invokevirtual intValue : ()I
    //   102: istore_2
    //   103: iload_2
    //   104: ireturn
    //   105: iinc #2, 1
    //   108: goto -> 45
    //   111: astore #4
    //   113: sipush #134
    //   116: istore_2
    //   117: goto -> 103
    //   120: invokestatic a : ()Lcom/herosdk/d/k;
    //   123: invokevirtual e : ()I
    //   126: istore_2
    //   127: goto -> 103
    //   130: astore #4
    //   132: aload #4
    //   134: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   137: iload_1
    //   138: istore_2
    //   139: goto -> 103
    // Exception table:
    //   from	to	target	type
    //   4	9	130	java/lang/Exception
    //   15	23	111	java/lang/Exception
    //   28	45	111	java/lang/Exception
    //   56	103	111	java/lang/Exception
    //   120	127	130	java/lang/Exception
  }
  
  public void e(Activity paramActivity) {
    try {
      Log.d("frameLib.mus", "rei");
      a().a(0);
      a a1 = a.a();
      z z = new z();
      this(this);
      a1.a((Context)paramActivity, z);
    } catch (Exception exception) {
      a().a(2);
    } 
  }
  
  public void e(Context paramContext) {
    try {
      Log.d("frameLib.mus", "slpd");
      ak ak = new ak();
      this(this, paramContext);
      bb.a(ak);
    } catch (Exception exception) {}
  }
  
  public void e(e parame) {
    this.l = parame;
  }
  
  public void e(String paramString) {
    this.v = paramString;
  }
  
  public void e(boolean paramBoolean) {
    this.F = paramBoolean;
  }
  
  public String f() {
    return k.a().c();
  }
  
  public void f(e parame) {
    this.m = parame;
  }
  
  public void f(String paramString) {
    this.w = paramString;
  }
  
  public void f(boolean paramBoolean) {
    this.G = paramBoolean;
  }
  
  public String g() {
    return k.a().b();
  }
  
  public void g(String paramString) {
    this.x = paramString;
  }
  
  public void g(boolean paramBoolean) {
    this.O = paramBoolean;
  }
  
  public UserInfo h() {
    return this.e;
  }
  
  public void h(String paramString) {
    this.y = paramString;
  }
  
  public RoleInfo i() {
    return this.f;
  }
  
  public void i(String paramString) {
    byte b2;
    try {
      Log.d("frameLib.mus", "lfh");
      this.K++;
      if (paramString.contains("java.io.FileNotFoundException")) {
        Log.d("frameLib.mus", "lfh...if");
        j(paramString);
        return;
      } 
      if (!a().m().booleanValue()) {
        Log.d("frameLib.mus", "lfh...else r1");
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    if (this.L) {
      Log.d("frameLib.mus", "lfh...else r2");
      return;
    } 
    paramString = a().n().b();
    paramString = paramString.substring(paramString.indexOf("|") + 1, paramString.lastIndexOf("|"));
    byte b1 = 3;
    try {
      b2 = Integer.parseInt(paramString);
    } catch (NumberFormatException numberFormatException) {
      b2 = b1;
    } 
    if (this.K >= b2)
      e((Context)a().x()); 
  }
  
  public void j(String paramString) {
    try {
      String str = o.b("LsT/6A+XStpLI1E8QyW6cwZGmjhTPpQze7tri/btL8Q=", o.b());
      long l1 = ((Long)ax.b((Context)a().x(), str, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if (l1 <= 0L || l2 - l1 > 600000L) {
        ax.a((Context)a().x(), str, Long.valueOf(l2));
        a.a().c((Context)a().x(), paramString);
      } 
    } catch (Exception exception) {
      Log.e("frameLib.mus", "mu...rnfs exception");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean j() {
    return this.g;
  }
  
  public e k() {
    return this.h;
  }
  
  public e l() {
    return this.i;
  }
  
  public Boolean m() {
    if (this.j != null && this.j.a().booleanValue()) {
      boolean bool1 = true;
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  public e n() {
    return this.j;
  }
  
  public Boolean o() {
    if (this.k != null && this.k.a().booleanValue()) {
      boolean bool1 = true;
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  public e p() {
    return this.k;
  }
  
  public Boolean q() {
    if (this.l != null && this.l.a().booleanValue()) {
      boolean bool1 = true;
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  public e r() {
    return this.l;
  }
  
  public Boolean s() {
    if (this.m != null && this.m.a().booleanValue()) {
      boolean bool1 = true;
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  public e t() {
    return this.m;
  }
  
  public boolean u() {
    return this.n;
  }
  
  public boolean v() {
    return this.o;
  }
  
  public String w() {
    String str;
    try {
      str = this.d.getSdk().getChannelVersion();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      str = "";
    } 
    return str;
  }
  
  public Activity x() {
    return this.q;
  }
  
  public String y() {
    return this.s;
  }
  
  public String z() {
    return this.t;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */