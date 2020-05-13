package com.zz.sdk.i;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import com.zz.sdk.ParamChain;
import com.zz.sdk.SDKManager;
import com.zz.sdk.a.bs;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.db;
import com.zz.sdk.a.gh;
import com.zz.sdk.a.ha;
import com.zz.sdk.a.hl;
import com.zz.sdk.a.hy;
import com.zz.sdk.a.jy;
import com.zz.sdk.a.w;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.ad;
import com.zz.sdk.b.a.g;
import com.zz.sdk.b.a.h;
import com.zz.sdk.b.a.i;
import com.zz.sdk.b.a.j;
import com.zz.sdk.b.a.k;
import com.zz.sdk.b.a.l;
import com.zz.sdk.b.a.m;
import com.zz.sdk.b.a.n;
import com.zz.sdk.b.a.q;
import com.zz.sdk.b.v;
import com.zz.sdk.b.w;
import com.zz.sdk.e.bi;
import com.zz.sdk.g;
import com.zz.sdk.third.a.a;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.regex.Pattern;

public class cq {
  private static WeakReference L;
  
  private static String M = null;
  
  static final int b = 6;
  
  static final int c = 16;
  
  static final String[] d = new String[] { "请输入登录账号", "账号应为“手机号/邮箱/用户名”", "请输入登录用户名", "用户名长度为%d~%d位", "登录账号以字母开头，6~16位字母、数字组成，不能包含特殊符号哦", "账号格式不正确，请重新输入", "用户名格式不正确，请重新输入" };
  
  static final String e = "[a-zA-Z0-9_]{6,16}";
  
  static final String f = "^1[0-9]{10}$";
  
  static final String[] g = new String[] { "请输入收到的短信验证码", "请输入11位有效手机号" };
  
  static final int h = 6;
  
  static final int i = 16;
  
  public static final String[] j = new String[] { 
      "请输入登录密码", "密码长度应为%d~%d位", "密码长度为%d~%d位字母、数字组成，区分大小写", "请设置登录密码", "请输入原登录密码", "原登录密码长度应为%d~%d位", "原登录密码格式错误", "请设置新登录密码", "新密码长度应为%d~%d位", "新密码长度为%d~%d位字母、数字组成，区分大小写", 
      "密码格式不正确，请重新输入", "原密码格式不正确，请重新输入", "新密码格式不正确，请重新输入" };
  
  static final String k = "[a-zA-Z0-9_]{6,16}";
  
  static final String l = "[0-9]*";
  
  public static final String[] m = new String[] { "请填写真实有效的姓名", "请输入有效的身份证号", "抱歉，实名认证需要18岁以上", "身份证号不能为空" };
  
  static final String n = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";
  
  private String A;
  
  private String B;
  
  private boolean C;
  
  private String D;
  
  private int E;
  
  private int F;
  
  private int G;
  
  private boolean H = true;
  
  private Timer I = null;
  
  private long J = 10L;
  
  private long K = 0L;
  
  public v a;
  
  private Context o;
  
  private t p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  private int t;
  
  private String u;
  
  private String v;
  
  private String w;
  
  private String x;
  
  private String y;
  
  private boolean z = false;
  
  protected cq(Context paramContext) {
    this.o = paramContext;
    this.p = t.a(paramContext);
  }
  
  public static String C() {
    return M;
  }
  
  private void D() {
    y();
    cr cr = new cr(this);
    this.I = new Timer();
    this.I.schedule(cr, this.J * 60L * 1000L, this.J * 60L * 1000L);
  }
  
  private void E() {
    this.a = new v();
    this.a.b = null;
    this.a.c = null;
    this.a.a = 0;
    this.u = null;
    this.s = null;
    this.t = 0;
    this.v = null;
    this.w = null;
    this.B = null;
    this.C = false;
    this.x = null;
    this.y = null;
    this.F = 0;
    this.G = 0;
    this.H = true;
  }
  
  public static a a(ParamChain paramParamChain, Context paramContext, boolean paramBoolean) {
    a a1;
    boolean bool2;
    boolean bool1 = true;
    a a2 = null;
    if (C() == null) {
      bp.a("i need secret key");
      return null;
    } 
    cq cq1 = a(paramContext);
    cq1.a(paramContext, paramBoolean);
    String str1 = cq1.j();
    String str2 = cq1.r();
    if (str1 != null && str2 != null) {
      a1 = cq1.b(str1, str2);
      if (a1.c()) {
        bool2 = false;
      } else {
        bp.a("自动登录失败！尝试自动注册");
        bool2 = true;
      } 
    } else {
      bool2 = true;
      paramContext = null;
    } 
    if (bool2) {
      a a = cq1.z();
      if (a.c()) {
        str1 = cq1.j();
        String str = cq1.r();
        bool2 = false;
        a2 = a;
        str2 = str;
        a1 = a2;
      } else {
        bp.a("自动注册失败！");
        a1 = a2;
      } 
    } 
    if (!bool2) {
      paramBoolean = bool1;
    } else {
      paramBoolean = false;
    } 
    cq1.a(paramParamChain, paramBoolean, str1, str2);
    return a1;
  }
  
  private a a(String paramString1, String paramString2, a parama, int paramInt) {
    E();
    this.a.h = paramInt;
    if (parama instanceof l) {
      a(paramString1, paramString2, (l)parama);
      this.a.m = ((i)parama).K;
      this.a.k = ((i)parama).J;
      this.a.n = ((i)parama).L;
      this.a.j = ((i)parama).I;
      this.a.o = ((i)parama).G;
      this.a.i = ((i)parama).N;
      this.F = ((i)parama).O;
      this.G = ((i)parama).P;
      if (paramString1 != null && paramString1.length() > 0) {
        this.a.b = paramString1;
      } else if (((l)parama).F != null) {
        this.a.b = ((i)parama).F;
      } 
    } else if (parama instanceof h) {
      a((h)parama);
      this.a.m = ((i)parama).K;
      this.a.k = ((i)parama).J;
      this.a.n = ((i)parama).L;
      this.a.j = ((i)parama).I;
      this.a.o = ((i)parama).G;
      this.a.i = ((i)parama).N;
      this.F = ((i)parama).O;
      this.G = ((i)parama).P;
      if (paramString1 != null && paramString1.length() > 0) {
        this.a.b = paramString1;
      } else if (((h)parama).F != null) {
        this.a.b = ((i)parama).F;
      } 
    } else if (parama instanceof i) {
      a(paramString1, paramString2, (i)parama, true);
      this.a.c = paramString2;
      this.a.m = ((i)parama).K;
      this.a.k = ((i)parama).J;
      this.a.n = ((i)parama).L;
      this.a.j = ((i)parama).I;
      this.a.o = ((i)parama).G;
      this.a.i = ((i)parama).N;
      this.F = ((i)parama).O;
      this.G = ((i)parama).P;
      if (paramString1 != null && paramString1.length() > 0) {
        this.a.b = paramString1;
      } else if (((i)parama).F != null) {
        this.a.b = ((i)parama).F;
      } 
    } 
    a a1 = parama;
    if (parama instanceof i) {
      i i = (i)parama;
      String str = C();
      a1 = parama;
      if (str != null) {
        a1 = parama;
        if (str.length() > 0) {
          a1 = parama;
          if (i.h() != null) {
            bp.a("try fetch token");
            j j = this.p.c(i.h(), str);
            if (j.c()) {
              this.v = null;
              this.w = j.h();
              n n = this.p.b(this.w);
              if (n.c()) {
                a(paramString1, paramString2, n);
                a1 = parama;
                if (paramString1 != null) {
                  a1 = parama;
                  if (paramString1.length() > 0) {
                    this.a.b = paramString1;
                    a1 = parama;
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return a1;
  }
  
  private v a(ad paramad, String paramString) {
    v v1 = new v();
    if (paramad.y != null)
      paramString = paramad.y; 
    v1.b = paramString;
    try {
      v1.a = Integer.parseInt(paramad.w);
    } catch (NumberFormatException numberFormatException) {}
    this.u = paramad.w;
    this.s = paramad.x;
    this.t = paramad.z;
    this.B = paramad.A;
    this.C = paramad.B;
    return v1;
  }
  
  public static cq a(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cq
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cq.L : Ljava/lang/ref/WeakReference;
    //   6: ifnonnull -> 44
    //   9: aconst_null
    //   10: astore_1
    //   11: aload_1
    //   12: astore_2
    //   13: aload_1
    //   14: ifnonnull -> 39
    //   17: new com/zz/sdk/i/cq
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: new java/lang/ref/WeakReference
    //   29: astore_0
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial <init> : (Ljava/lang/Object;)V
    //   35: aload_0
    //   36: putstatic com/zz/sdk/i/cq.L : Ljava/lang/ref/WeakReference;
    //   39: ldc com/zz/sdk/i/cq
    //   41: monitorexit
    //   42: aload_2
    //   43: areturn
    //   44: getstatic com/zz/sdk/i/cq.L : Ljava/lang/ref/WeakReference;
    //   47: invokevirtual get : ()Ljava/lang/Object;
    //   50: checkcast com/zz/sdk/i/cq
    //   53: astore_1
    //   54: goto -> 11
    //   57: astore_0
    //   58: ldc com/zz/sdk/i/cq
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	57	finally
    //   17	39	57	finally
    //   44	54	57	finally
  }
  
  public static void a(Activity paramActivity, bi parambi, v paramv, boolean paramBoolean) {
    h.a();
    (new gh(paramActivity, parambi, paramBoolean)).a(paramv);
  }
  
  private void a(h paramh) {
    a((String)null, paramh.n, (n)paramh);
    this.a.c = paramh.n;
  }
  
  private void a(String paramString1, String paramString2, i parami, boolean paramBoolean) {
    if (parami.h() != null)
      this.v = parami.h(); 
    this.t = parami.H;
    paramString1 = parami.i();
    if (paramBoolean || !TextUtils.isEmpty(paramString1))
      this.B = paramString1; 
  }
  
  private void a(String paramString1, String paramString2, l paraml) {
    a(paramString1, paramString2, (n)paraml);
    this.a.c = paramString2;
  }
  
  private void a(String paramString1, String paramString2, n paramn) {
    if (cv.h() != null)
      this.J = cv.h().o(); 
    a(paramString1, paramString2, (i)paramn, false);
    if (paramn.F != null) {
      this.a.b = paramn.F;
      try {
        if (paramn.G != null)
          this.a.a = Integer.parseInt(paramn.G); 
      } catch (NumberFormatException numberFormatException) {}
      this.u = String.valueOf(paramn.E);
      this.s = paramn.G;
      this.y = paramn.X;
      this.a.l = paramn.Y;
      if (this.a.l > 0) {
        bg.k = true;
        if (this.a.l >= 18) {
          bg.l = true;
        } else {
          bg.l = false;
        } 
      } else {
        bg.k = false;
        bg.l = false;
      } 
      if (o() == 2 || (cv.h().m() == 1 && paramn.Y < 18))
        D(); 
    } 
  }
  
  public static boolean a(Context paramContext, a parama, w paramw, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {
    paramw.r();
    return a(paramContext, parama, paramw.g(), paramw.q(), paramOnClickListener, paramBoolean);
  }
  
  public static boolean a(Context paramContext, a parama, bi parambi, Dialog paramDialog, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {
    ParamChain paramChain;
    if (paramDialog != null)
      try {
        paramDialog.dismiss();
      } catch (Exception exception) {} 
    if (parama != null && parama.c()) {
      (bs.a(paramContext)).l = "";
      (bs.a(paramContext)).m = "";
      (bs.a(paramContext)).i = "";
      (bs.a(paramContext)).k = "";
      (bs.a(paramContext)).j = "";
      parambi.o = 0;
      paramChain = parambi.getEnv();
      i i = (i)parama;
      a(paramContext).a(paramChain.getParent(g.class.getName()), true, i.G, (String)null, (String)null);
      if (cv.h().p() == 1) {
        if (cm.d(paramContext))
          return a(paramContext, (i)parama, parambi); 
        bv.a((Activity)paramContext, jy.class, (Map)bv.a().a("key_show_back", Boolean.valueOf(false)).a("key_show_close", Boolean.valueOf(false)).a("key_layout_main", parambi).a("result_auth_login", parama));
      } else {
        return a(paramContext, (i)parama, parambi);
      } 
    } else if (parama.d() != 20001 || paramBoolean) {
      h.a(paramContext, parama, (DialogInterface.OnClickListener)paramChain);
    } 
    return false;
  }
  
  private static boolean a(Context paramContext, i parami, bi parambi) {
    int m;
    boolean bool3;
    boolean bool1 = true;
    boolean bool2 = true;
    bp.a("onLoginSuccess");
    b(paramContext);
    cq cq1 = a(paramContext);
    Activity activity = (Activity)paramContext;
    SDKManager.loginSuccess();
    bv.a(activity, false);
    a((Context)activity).a(parami.j());
    a((Context)activity).c(parami.k());
    String str1 = cq1.l();
    String str2 = cq1.q();
    int j = cq1.o();
    int k = cq1.p();
    bp.a("tel:" + str1 + ", tempToken:" + str2 + ", idStat:" + j + ", aliasStat:" + k);
    if (j == 1 || j == 2) {
      j = 1;
    } else {
      j = 0;
    } 
    if (parami.N == 3 && parami.O == 3) {
      m = 1;
    } else {
      m = j;
    } 
    if (k == 1) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (str1 != null && str1.length() > 0 && m == 0) {
      a(activity, parambi, cq1.a, true);
      return bool2;
    } 
    if (TextUtils.isEmpty(str2)) {
      j = 0;
    } else {
      j = 1;
    } 
    k = j;
    if (str1 != null) {
      k = j;
      if (str1.length() > 0)
        k = 0; 
    } 
    bp.a("CachedLoginName:" + cq1.j());
    if ("saved".equals(cm.a(paramContext, cq1.j()))) {
      j = 1;
    } else {
      j = 0;
    } 
    if (k != 0 && bool3 && j == 0) {
      bv.a(activity, hl.class, (Map)bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)).a("account", cq1.j()).a("password", cq1.r()));
      bool2 = false;
    } else if (k != 0 && m == 0) {
      bv.a((Activity)paramContext, hy.class, (Map)bv.a().a("key_layout_main", parambi).a("KEY_NEED_ALIAS", Boolean.valueOf(bool3)).a("key_show_back", Boolean.valueOf(false)));
      bool2 = false;
    } else {
      String str;
      if (k == 0 && m != 0) {
        str = parami.j();
        if (str != null && str.length() > 0) {
          j = 1;
        } else {
          j = 0;
        } 
        if (cv.h() == null) {
          m = 0;
        } else {
          m = cv.h().j().c();
        } 
        if (m == 0) {
          m = 0;
        } else {
          m = 1;
        } 
        if (j != 0 || m == 0) {
          bv.a(activity, ha.class, (Map)bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
        } else {
          bv.a(activity, db.class, (Map)bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
        } 
        bool2 = false;
      } else {
        bool2 = bool1;
        if (k != 0) {
          bv.a((Activity)str, hy.class, (Map)bv.a().a("key_layout_main", parambi).a("KEY_NEED_ALIAS", Boolean.valueOf(bool3)).a("key_show_back", Boolean.valueOf(false)));
          bool2 = false;
        } 
      } 
    } 
    a(activity, parambi, cq1.a, false);
    return bool2;
  }
  
  private static void b(Context paramContext) {
    if (SDKManager.showFloatRemote)
      (new Thread(new cu(paramContext))).start(); 
  }
  
  public static Pair e(String paramString) {
    boolean bool = false;
    String str1 = null;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() < 2 || str2.length() > 10 || !f(str2)) {
      paramString = m[0];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static boolean f(String paramString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      if ("".equals(paramString.trim()))
        return bool1; 
    } else {
      return bool2;
    } 
    char[] arrayOfChar = paramString.toCharArray();
    byte b = 0;
    while (true) {
      bool2 = bool1;
      if (b < arrayOfChar.length) {
        if (Pattern.matches("[一-龥]", String.valueOf(arrayOfChar[b])))
          return true; 
        b++;
        continue;
      } 
      return bool2;
    } 
  }
  
  public static void g(String paramString) {
    M = paramString;
  }
  
  public static Pair h(String paramString) {
    boolean bool = false;
    String str1 = null;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() == 0) {
      paramString = d[0];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.length() < 6) {
      paramString = d[5];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair i(String paramString) {
    String str1 = null;
    boolean bool = false;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() == 0) {
      paramString = d[2];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.length() < 6 || str2.length() > 16) {
      paramString = d[6];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.matches("[0-9]*") || !str2.matches("[a-zA-Z0-9_]{6,16}")) {
      paramString = d[6];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair j(String paramString) {
    boolean bool = false;
    String str1 = null;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() == 0) {
      paramString = g[0];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair k(String paramString) {
    boolean bool = true;
    String str = paramString;
    if (paramString != null)
      str = paramString.trim(); 
    if (str == null || str.length() == 0 || !str.matches("^1[0-9]{10}$")) {
      paramString = g[1];
      bool = false;
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    paramString = null;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair l(String paramString) {
    boolean bool = false;
    String str1 = null;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() == 0) {
      paramString = j[0];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.length() < 6) {
      paramString = j[10];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair m(String paramString) {
    String str1 = null;
    boolean bool = false;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() == 0) {
      paramString = j[4];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.length() < 6) {
      paramString = j[11];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair n(String paramString) {
    String str1 = null;
    boolean bool = false;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() == 0) {
      paramString = j[7];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.length() < 6 || str2.length() > 16) {
      paramString = j[12];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.matches("[0-9]*") || !str2.matches("[a-zA-Z0-9_]{6,16}")) {
      paramString = j[12];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair o(String paramString) {
    String str1 = null;
    boolean bool = false;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() == 0) {
      paramString = j[3];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.length() < 6 || str2.length() > 16) {
      paramString = j[10];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (str2.matches("[0-9]*") || !str2.matches("[a-zA-Z0-9_]{6,16}")) {
      paramString = j[10];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair p(String paramString) {
    boolean bool = false;
    String str = paramString;
    if (paramString != null)
      str = paramString.trim(); 
    if (str == null || str.length() == 0) {
      paramString = m[3];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (!str.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$")) {
      paramString = m[1];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = null;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static boolean q(String paramString) {
    boolean bool;
    int i = Integer.parseInt(paramString.substring(6, 10));
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Date date2 = simpleDateFormat.parse(stringBuilder.append(String.valueOf(i + 18)).append(paramString.substring(10, 14)).toString());
      Date date1 = new Date();
      this();
      bool = date1.after(date2);
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  private boolean s(String paramString) {
    return !(paramString == null || paramString.length() == 0);
  }
  
  public void A() {}
  
  public String B() {
    return this.D;
  }
  
  public a a(v paramv) {
    switch (paramv.h) {
      default:
        return b(paramv.b, paramv.c);
      case 1:
        return c(paramv.b, paramv.c);
      case 2:
      case 3:
      case 4:
        break;
    } 
    a a = new a();
    a.d(paramv.c);
    return a(a);
  }
  
  public a a(a parama) {
    m m1 = this.p.a(parama, 1);
    m m2 = m1;
    if (m1 != null) {
      m2 = m1;
      if (m1.c()) {
        parama.e(m1.q());
        try {
          m1.Q = parama.h();
          a a1 = a(m1.F, parama.a().toString(), (a)m1, parama.h());
        } catch (Exception exception) {
          exception.printStackTrace();
          m2 = m1;
        } 
      } 
    } 
    return (a)m2;
  }
  
  public a a(String paramString1, int paramInt, String paramString2) {
    return this.p.a(paramString1, paramInt, paramString2);
  }
  
  public a a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    l l = this.p.a(paramString1, paramString2, paramString3, paramString4, "", paramString5, new String[0]);
    if (l != null && l.c()) {
      a(paramString1, paramString2, (a)l, 0);
      this.a.d = 1;
    } 
    return (a)l;
  }
  
  public g a(String paramString1, String paramString2, int paramInt) {
    g g = this.p.a(paramString1, paramString2, paramInt);
    if (g != null && g.c()) {
      v v1 = a((ad)g, paramString1);
      v1.c = paramString2;
      v1.d = 1;
      this.a = v1;
    } 
    return g;
  }
  
  public String a() {
    return this.x;
  }
  
  public void a(int paramInt) {
    this.E = paramInt;
  }
  
  public void a(Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore #4
    //   5: ldc_w 'UserUtil init'
    //   8: invokestatic a : (Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield o : Landroid/content/Context;
    //   15: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/b/w;
    //   18: astore #5
    //   20: aload #5
    //   22: invokevirtual a : ()Lcom/zz/sdk/b/v;
    //   25: astore #6
    //   27: aload #6
    //   29: ifnull -> 44
    //   32: aload_0
    //   33: aload #6
    //   35: getfield b : Ljava/lang/String;
    //   38: invokespecial s : (Ljava/lang/String;)Z
    //   41: ifne -> 210
    //   44: aload #5
    //   46: invokevirtual c : ()[Lcom/zz/sdk/b/v;
    //   49: astore #6
    //   51: aload #6
    //   53: ifnull -> 231
    //   56: aload #6
    //   58: arraylength
    //   59: ifle -> 231
    //   62: iload_2
    //   63: ifeq -> 201
    //   66: iload #4
    //   68: aload #6
    //   70: arraylength
    //   71: if_icmpge -> 231
    //   74: aload_0
    //   75: aload #6
    //   77: iload #4
    //   79: aaload
    //   80: getfield b : Ljava/lang/String;
    //   83: invokespecial s : (Ljava/lang/String;)Z
    //   86: ifeq -> 195
    //   89: aload #6
    //   91: iload #4
    //   93: aaload
    //   94: astore #6
    //   96: aload_0
    //   97: aload #6
    //   99: putfield a : Lcom/zz/sdk/b/v;
    //   102: aload_0
    //   103: getfield a : Lcom/zz/sdk/b/v;
    //   106: ifnull -> 135
    //   109: aload_0
    //   110: getfield a : Lcom/zz/sdk/b/v;
    //   113: getfield b : Ljava/lang/String;
    //   116: ifnull -> 135
    //   119: ldc_w ''
    //   122: aload_0
    //   123: getfield a : Lcom/zz/sdk/b/v;
    //   126: getfield b : Ljava/lang/String;
    //   129: invokevirtual equals : (Ljava/lang/Object;)Z
    //   132: ifeq -> 194
    //   135: aload_3
    //   136: astore #6
    //   138: iconst_0
    //   139: ifne -> 148
    //   142: aload_1
    //   143: invokestatic e : (Landroid/content/Context;)Landroid/util/Pair;
    //   146: astore #6
    //   148: aload #6
    //   150: ifnull -> 194
    //   153: aload_0
    //   154: new com/zz/sdk/b/v
    //   157: dup
    //   158: invokespecial <init> : ()V
    //   161: putfield a : Lcom/zz/sdk/b/v;
    //   164: aload_0
    //   165: getfield a : Lcom/zz/sdk/b/v;
    //   168: aload #6
    //   170: getfield first : Ljava/lang/Object;
    //   173: checkcast java/lang/String
    //   176: putfield b : Ljava/lang/String;
    //   179: aload_0
    //   180: getfield a : Lcom/zz/sdk/b/v;
    //   183: aload #6
    //   185: getfield second : Ljava/lang/Object;
    //   188: checkcast java/lang/String
    //   191: putfield c : Ljava/lang/String;
    //   194: return
    //   195: iinc #4, 1
    //   198: goto -> 66
    //   201: aload #6
    //   203: iconst_0
    //   204: aaload
    //   205: astore #6
    //   207: goto -> 96
    //   210: aload_0
    //   211: aload #6
    //   213: getfield b : Ljava/lang/String;
    //   216: putfield q : Ljava/lang/String;
    //   219: aload_0
    //   220: aload #6
    //   222: getfield c : Ljava/lang/String;
    //   225: putfield r : Ljava/lang/String;
    //   228: goto -> 96
    //   231: aconst_null
    //   232: astore #6
    //   234: goto -> 96
  }
  
  public void a(ParamChain paramParamChain, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    if (this.v != null && !this.v.equals(paramString5)) {
      bp.a("auth_code not match");
      return;
    } 
    if (this.w == null)
      this.w = paramString6; 
    if (paramString1 != null) {
      paramParamChain.add("global.user.nick_name", paramString2);
      paramParamChain.add("global.user.login_name", paramString1);
      paramParamChain.add("global.user.sdk_user_id", paramString4);
      paramParamChain.add("global.user.anti-addiction", Integer.valueOf(x()));
      if (this.z && this.a != null) {
        this.a.b = paramString1;
        a(Boolean.valueOf(true), paramParamChain);
      } 
    } 
    if (paramString3 != null)
      paramParamChain.add("global.user.password", paramString3); 
    if (paramString5 != null)
      paramParamChain.add("global.user.auth_code", paramString5); 
    if (paramString6 != null)
      paramParamChain.add("global.user.access_token", paramString6); 
    if (paramString7 != null) {
      co co = co.a();
      if (co != null)
        co.a(paramString7); 
    } 
  }
  
  public void a(ParamChain paramParamChain, boolean paramBoolean, String paramString1, String paramString2) {
    paramParamChain.remove("global.user.login_name");
    paramParamChain.remove("global.user.nick_name");
    paramParamChain.remove("global.user.password");
    paramParamChain.remove("global.user.sdk_user_id");
    paramParamChain.remove("global.user.login_state_success");
    paramParamChain.remove("global.user.auth_code");
    paramParamChain.remove("global.user.access_token");
    paramParamChain.remove("global.user.login_name_game_user");
    paramParamChain.remove("global.user.anti-addiction");
    if (paramBoolean) {
      paramParamChain.add("global.user.login_state_success", Boolean.TRUE);
      a(Boolean.valueOf(true), paramParamChain);
      paramString2 = s();
      paramString1 = j();
      this.D = paramString1;
      String str1 = r();
      String str2 = u();
      String str3 = v();
      String str4 = w();
      a(paramParamChain, paramString1, k(), str1, paramString2, str2, str3, str4);
    } 
  }
  
  public void a(ParamChain paramParamChain, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {
    this.a.o = paramString1;
    a(paramParamChain, paramBoolean, paramString2, paramString3);
  }
  
  public void a(String paramString) {
    this.x = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.H = paramBoolean;
  }
  
  public boolean a(v paramv, ParamChain paramParamChain) {
    this.z = false;
    w w = w.a(this.o);
    if (paramv.h == 0)
      cv.a(this.o, paramv.b, paramv.c); 
    ba.a(this.o, paramv.b, paramParamChain);
    return w.a(paramv);
  }
  
  public boolean a(Boolean paramBoolean, ParamChain paramParamChain) {
    boolean bool = false;
    if (this.a != null) {
      if (this.a.b == null) {
        this.z = true;
        return bool;
      } 
      v v1 = new v();
      v1.b = this.a.b;
      v1.c = this.a.c;
      v1.a = this.a.a;
      v1.o = this.a.o;
      v1.h = this.a.h;
      if (paramBoolean == null) {
        v1.d = this.a.d;
      } else if (paramBoolean.booleanValue()) {
        v1.d = 1;
      } else {
        v1.d = 0;
      } 
      v1.i = this.a.i;
      bool = a(v1, paramParamChain);
    } 
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2) {
    if (this.a != null && this.a.b != null) {
      w w = w.a(this.o);
      v v1 = w.a(this.a.b);
      if (v1 != null) {
        v1.o = this.a.o;
        v1.b = paramString1;
        if (paramString2 != null && paramString2.length() > 0)
          v1.c = paramString2; 
        boolean bool1 = w.a(v1);
        boolean bool2 = bool1;
        if (bool1) {
          this.a.b = v1.b;
          this.a.c = v1.c;
          bool2 = bool1;
        } 
        return bool2;
      } 
    } 
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3) {
    w w = w.a(this.o);
    v v1 = w.a(paramString2);
    v v2 = v1;
    if (v1 == null) {
      v2 = new v();
      v2.b = paramString2;
      v2.d = 1;
    } 
    v2.o = paramString1;
    v2.c = paramString3;
    return w.a(v2);
  }
  
  public a b(String paramString1, String paramString2) {
    a a;
    i i1 = this.p.a(paramString1, paramString2, new String[0]);
    i i2 = i1;
    if (i1 != null) {
      i2 = i1;
      if (i1.c())
        a = a(paramString1, paramString2, (a)i1, 0); 
    } 
    return a;
  }
  
  public a b(String paramString1, String paramString2, String paramString3) {
    q q = this.p.a(paramString1, paramString2, paramString3);
    if (q.c())
      this.a.c = paramString3; 
    return (a)q;
  }
  
  public a b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    l l = this.p.a(paramString1, paramString2, paramString3, paramString4, paramString5, new String[0]);
    if (l != null && l.c()) {
      a(paramString1, paramString3, (a)l, 0);
      this.a.d = 1;
    } 
    return (a)l;
  }
  
  public String b() {
    return this.y;
  }
  
  public void b(String paramString) {
    this.y = paramString;
  }
  
  public a c(String paramString1, String paramString2) {
    a a;
    k k1 = this.p.a(paramString1, paramString2);
    k k2 = k1;
    if (k1 != null) {
      k2 = k1;
      if (k1.c()) {
        k1.Q = 1;
        a = a(paramString1, paramString2, (a)k1, 1);
      } 
    } 
    return a;
  }
  
  public a c(String paramString1, String paramString2, String paramString3) {
    return this.p.e(paramString1, paramString2, paramString3);
  }
  
  public String c() {
    return this.A;
  }
  
  public void c(String paramString) {
    this.A = paramString;
  }
  
  public int d() {
    return (this.a == null) ? 0 : this.a.i;
  }
  
  public a d(String paramString1, String paramString2) {
    a a;
    k k2 = this.p.b(paramString1, paramString2);
    k k1 = k2;
    if (k2 != null) {
      k1 = k2;
      if (k2.c()) {
        k2.Q = 1;
        a = a(paramString1, k2.n, (a)k2, 1);
      } 
    } 
    return a;
  }
  
  public void d(String paramString) {
    this.B = paramString;
  }
  
  public int e() {
    return this.F;
  }
  
  public int f() {
    return this.G;
  }
  
  public int g() {
    return this.E;
  }
  
  public boolean h() {
    return this.H;
  }
  
  public Context i() {
    return this.o;
  }
  
  public String j() {
    return (this.a == null) ? null : this.a.b;
  }
  
  public String k() {
    return (this.a == null) ? null : h.a(this.a);
  }
  
  public String l() {
    return this.B;
  }
  
  public boolean m() {
    return this.C;
  }
  
  public int n() {
    if (this.a == null) {
      Integer integer1 = null;
      return integer1.intValue();
    } 
    Integer integer = Integer.valueOf(this.a.j);
    return integer.intValue();
  }
  
  public int o() {
    if (this.a == null) {
      Integer integer1 = null;
      return integer1.intValue();
    } 
    Integer integer = Integer.valueOf(this.a.k);
    return integer.intValue();
  }
  
  public int p() {
    if (this.a == null) {
      Integer integer1 = null;
      return integer1.intValue();
    } 
    Integer integer = Integer.valueOf(this.a.m);
    return integer.intValue();
  }
  
  public String q() {
    return (this.a == null) ? null : this.a.n;
  }
  
  public a r(String paramString) {
    a a;
    k k2 = this.p.a(paramString);
    k k1 = k2;
    if (k2 != null) {
      k1 = k2;
      if (k2.c()) {
        k2.Q = 1;
        a = a(k2.j(), k2.n, (a)k2, 1);
      } 
    } 
    return a;
  }
  
  public String r() {
    return (this.a == null) ? null : this.a.c;
  }
  
  public String s() {
    return this.s;
  }
  
  public String t() {
    return (this.a == null) ? null : this.a.o;
  }
  
  public String u() {
    return this.v;
  }
  
  public String v() {
    return this.w;
  }
  
  public String w() {
    return this.u;
  }
  
  public int x() {
    byte b = 1;
    if (this.t != 1) {
      if (this.t == 2)
        return 2; 
      b = 0;
    } 
    return b;
  }
  
  public void y() {
    if (this.I != null) {
      bp.a("stopTimer");
      this.I.purge();
      this.I.cancel();
      this.I = null;
    } 
  }
  
  public a z() {
    h h = this.p.d();
    if (h != null && h.c()) {
      a((String)null, (String)null, (a)h, 0);
      this.a.d = 1;
    } 
    return (a)h;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */