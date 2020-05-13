package com.zz.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.chuanglan.shanyan_sdk.OneKeyLoginManager;
import com.xy.whf.pay.WhfPay;
import com.zz.sdk.activity.BaseActivity;
import com.zz.sdk.activity.f;
import com.zz.sdk.b.a.ae;
import com.zz.sdk.b.t;
import com.zz.sdk.c.a;
import com.zz.sdk.h.f;
import com.zz.sdk.h.g;
import com.zz.sdk.i.a;
import com.zz.sdk.i.ay;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.bv;
import com.zz.sdk.i.bx;
import com.zz.sdk.i.bz;
import com.zz.sdk.i.c;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.co;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.dd;
import com.zz.sdk.i.t;
import com.zz.sdk.i.v;
import com.zz.sdk.listener.IKickOffListener;

public class SDKManager {
  public static final int STATUS_AUTHENTICATION_CHOOSE = 4;
  
  public static final int STATUS_AUTHENTICATION_FORCE = 5;
  
  public static final int STATUS_AUTHENTICATION_OLD = 3;
  
  private static SDKManager a;
  
  private static ParamChain c;
  
  private static boolean e = true;
  
  private static int g = 0;
  
  private static final String h = "key_status_authentication";
  
  public static boolean showFloatRemote = false;
  
  private cq b;
  
  private co d;
  
  private Context f;
  
  private boolean i = false;
  
  static {
    g = 3;
  }
  
  private SDKManager(Context paramContext) {
    this.f = paramContext;
    bp.a(paramContext);
    this.b = cq.a(this.f);
    this.d = co.a(this.f, this);
    c = a(paramContext, b(paramContext, init_device(paramContext, ay.a(paramContext, BaseActivity.a()))));
    bz.a(paramContext);
    resetFromAssets(paramContext);
    a(paramContext);
  }
  
  private ParamChain a(Context paramContext, ParamChain paramParamChain) {
    paramParamChain = paramParamChain.grow(SDKManager.class.getName());
    paramParamChain.add("global.help_title", cg.u.a());
    paramParamChain.add("global.help_topic", cg.v.a());
    paramParamChain.add("global.util_connection", t.a(paramContext));
    return paramParamChain;
  }
  
  @Deprecated
  private void a(Context paramContext) {
    (new i(this, paramContext)).start();
  }
  
  private static void a(Context paramContext, ParamChain paramParamChain, f paramf) {
    paramParamChain.add("global.ui_view_type", paramf);
    paramParamChain.getParent(BaseActivity.class.getName()).add(paramf.a(), paramParamChain, h.b);
    Intent intent = new Intent(paramContext, BaseActivity.class);
    intent.putExtra("global.ui_activity_name", paramf.a());
    intent.addFlags(268435456);
    paramContext.startActivity(intent);
  }
  
  @Deprecated
  private void a(Handler paramHandler, int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean, String paramString3) {
    a(paramHandler, paramInt1, paramString1, paramString2, paramInt2, false, paramBoolean, true, null, null, paramString3);
  }
  
  private void a(Handler paramHandler, int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, String paramString5) {
    String str = paramString1;
    if (paramString1 == null)
      str = getGameServerId(this.f); 
    ParamChain paramChain = c.grow(d.class.getName());
    paramChain.add("global.caller.msg_handler", paramHandler);
    paramChain.add("global.caller.msg_what", Integer.valueOf(paramInt1));
    paramChain.add("global.caller.cporder", paramString5);
    paramChain.add("global.caller.game_server_id", str);
    paramChain.add("global.caller.game_role", paramString2);
    paramChain.add("global.caller.amount", Integer.valueOf(paramInt2));
    paramChain.add("global.caller.is_close_window", Boolean.valueOf(paramBoolean2));
    paramChain.add("global.caller.coin_count", Boolean.valueOf(paramBoolean1));
    paramChain.add("global.caller.payment_zycoin_disabled", Boolean.valueOf(false));
    paramChain.add("global.caller.pay_is_buy_mode", Boolean.valueOf(paramBoolean3));
    if (paramString3 != null)
      paramChain.add("global.caller.prop_id", paramString3); 
    if (paramString4 != null)
      paramChain.add("global.caller.prop_name", paramString4); 
    a(this.f, paramChain, f.b);
  }
  
  private ParamChain b(Context paramContext, ParamChain paramParamChain) {
    return paramParamChain.grow(g.class.getName());
  }
  
  public static void burialPoint(Activity paramActivity, String paramString1, String paramString2, int paramInt) {
    t.a((Context)paramActivity).b(paramString1, paramString2, paramInt);
  }
  
  private void c() {
    (new j(this)).start();
  }
  
  private void d() {
    if (this.d != null) {
      this.d.b();
      this.d = null;
    } 
    if (this.b != null)
      this.b = null; 
    dd.b();
  }
  
  public static String getAppKey() {
    return cv.d();
  }
  
  public static String getGameServerId(Context paramContext) {
    return cv.j(paramContext);
  }
  
  public static SDKManager getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/SDKManager
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/SDKManager.a : Lcom/zz/sdk/SDKManager;
    //   6: ifnonnull -> 35
    //   9: new com/zz/sdk/SDKManager
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/zz/sdk/SDKManager.a : Lcom/zz/sdk/SDKManager;
    //   22: aload_0
    //   23: checkcast android/app/Activity
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull -> 35
    //   31: aload_0
    //   32: invokestatic a : (Landroid/app/Activity;)V
    //   35: getstatic com/zz/sdk/SDKManager.a : Lcom/zz/sdk/SDKManager;
    //   38: astore_0
    //   39: ldc com/zz/sdk/SDKManager
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc com/zz/sdk/SDKManager
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    //   50: astore_0
    //   51: goto -> 35
    // Exception table:
    //   from	to	target	type
    //   3	22	44	finally
    //   22	27	50	java/lang/Exception
    //   22	27	44	finally
    //   31	35	50	java/lang/Exception
    //   31	35	44	finally
    //   35	39	44	finally
  }
  
  public static String getProductId(Context paramContext) {
    return cv.h(paramContext);
  }
  
  public static String getProjectId(Context paramContext) {
    return cv.g(paramContext);
  }
  
  public static ParamChain getRootEnv() {
    return c;
  }
  
  public static int getVersionCode() {
    return 102;
  }
  
  public static String getVersionDesc() {
    return "Ver:3.4.4-102-20200224,weixin,alipp";
  }
  
  public static void initFloatLocation(Activity paramActivity, int paramInt1, int paramInt2) {
    try {
      if (isShowFloat())
        f.b(paramActivity).a(paramInt1, paramInt2); 
    } catch (Exception exception) {}
  }
  
  public static boolean isShowFloat() {
    return (showFloatRemote && e);
  }
  
  public static void loginSuccess() {
    try {
      if (isShowFloat()) {
        bp.b("SDKService loginSuccess");
        g g = g.b();
        if (g != null)
          g.d(); 
      } 
    } catch (Exception exception) {}
  }
  
  public static void recycle(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/SDKManager
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/SDKManager.a : Lcom/zz/sdk/SDKManager;
    //   6: ifnull -> 15
    //   9: getstatic com/zz/sdk/SDKManager.a : Lcom/zz/sdk/SDKManager;
    //   12: invokespecial d : ()V
    //   15: iconst_0
    //   16: putstatic com/zz/sdk/SDKManager.e : Z
    //   19: iconst_0
    //   20: putstatic com/zz/sdk/SDKManager.showFloatRemote : Z
    //   23: aconst_null
    //   24: putstatic com/zz/sdk/SDKManager.a : Lcom/zz/sdk/SDKManager;
    //   27: ldc com/zz/sdk/SDKManager
    //   29: monitorexit
    //   30: return
    //   31: astore_0
    //   32: ldc com/zz/sdk/SDKManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	31	finally
    //   15	27	31	finally
  }
  
  public static boolean registWXPayHandler(SampleWXPayEntryActivity paramSampleWXPayEntryActivity, Intent paramIntent) {
    return dd.a(paramSampleWXPayEntryActivity, paramIntent);
  }
  
  public static void resetFromAssets(Context paramContext) {
    cv.k(paramContext);
  }
  
  public static void setAccoAppKey(String paramString) {
    cv.m(paramString);
  }
  
  public static void setAccoAppSecret(String paramString) {
    cv.n(paramString);
  }
  
  public static void setAntiAddiction(boolean paramBoolean) {
    a.b(paramBoolean);
  }
  
  public static void setAppKey(String paramString) {
    cv.l(paramString);
  }
  
  public static void setAppSecretKey(String paramString) {
    cq.g(paramString);
  }
  
  public static void setCommon(boolean paramBoolean) {
    a.a(paramBoolean);
  }
  
  public static void setGameServerId(String paramString) {
    cv.j(paramString);
  }
  
  public static void setJdAppId(String paramString) {
    cv.g(paramString);
  }
  
  public static void setLoginBgAssetsPath(String paramString) {
    cv.o(paramString);
  }
  
  public static void setLoginBgResId(int paramInt) {
    cv.a(paramInt);
  }
  
  public static void setPayConfYDMM(IPayConfYDMM paramIPayConfYDMM) {
    bv.a(paramIPayConfYDMM);
  }
  
  public static void setProductId(String paramString) {
    cv.f(paramString);
  }
  
  public static void setProjectId(String paramString) {
    cv.e(paramString);
  }
  
  public static void setServerUrl(String[] paramArrayOfString) {
    v.a(paramArrayOfString);
  }
  
  public static void setShowFloat(boolean paramBoolean) {
    String str;
    e = paramBoolean;
    StringBuilder stringBuilder = (new StringBuilder()).append("浮标本地配置状态: ");
    if (paramBoolean) {
      str = "开启";
    } else {
      str = " 关闭";
    } 
    bp.b(stringBuilder.append(str).toString());
  }
  
  public static void setSyParams(String paramString1, String paramString2) {
    cv.h(paramString1);
    cv.i(paramString2);
  }
  
  public static void setThirdKey(String paramString1, String paramString2) {
    cv.a(paramString1, paramString2);
  }
  
  public static void tryDestroyFloat(Activity paramActivity) {
    try {
      if (isShowFloat()) {
        bp.b("SDKService tryDestroyFloat");
        f.b(paramActivity).b();
      } 
    } catch (Exception exception) {}
  }
  
  public static void tryHideFloat(Activity paramActivity) {
    try {
      if (isShowFloat()) {
        bp.b("SDKService tryHideFloat");
        f.b(paramActivity).d();
      } 
    } catch (Exception exception) {}
  }
  
  public static void tryInitFloat(Activity paramActivity) {
    if (paramActivity == null) {
      try {
        bp.b("tryInitFloat but context parameter is null error, return");
      } catch (Exception exception) {}
      return;
    } 
    cv.a((Activity)exception);
    if (isShowFloat()) {
      bp.a("tryInitFloat");
      f.a((Activity)exception);
    } 
    WhfPay.getInstance().initial((Context)exception);
    OneKeyLoginManager oneKeyLoginManager = OneKeyLoginManager.getInstance();
    Context context = exception.getApplicationContext();
    String str1 = cv.a();
    String str2 = cv.b();
    o o = new o();
    this();
    oneKeyLoginManager.init(context, str1, str2, o);
  }
  
  public static void tryShowFloat(Activity paramActivity, FloatSoundCallback paramFloatSoundCallback) {
    try {
      if (isShowFloat()) {
        bp.b("SDKService tryShowFloat");
        BaseActivity.a().add("com.zz.sdk.float.callback", paramFloatSoundCallback);
        f.b(paramActivity).e();
      } 
    } catch (Exception exception) {}
  }
  
  public static void unregistWXPayHandler(SampleWXPayEntryActivity paramSampleWXPayEntryActivity) {
    dd.a(paramSampleWXPayEntryActivity);
  }
  
  protected void a(Handler paramHandler, int paramInt) {}
  
  public void cpKickOffCallBackWithResult(String paramString) {
    byte b;
    try {
      b = Integer.parseInt(paramString);
    } catch (Exception exception) {
      b = -1;
    } 
    if (b == 1)
      cq.a(this.f).y(); 
    a.a().i(this.f, String.valueOf(paramString), v.D, new m(this));
  }
  
  public String getAccountName() {
    if (isLogined()) {
      String str1 = (String)c.get("global.user.nick_name", String.class);
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
        str2 = (String)c.get("global.user.login_name", String.class); 
      return str2;
    } 
    return null;
  }
  
  public String getGameUserName() {
    if (isLogined()) {
      String str1 = (String)c.get("global.user.login_name_game_user", String.class);
      String str2 = str1;
      if (str1 == null)
        str2 = getAccountName(); 
      return str2;
    } 
    return null;
  }
  
  public int getStatusAuthentication() {
    return this.i ? g : Integer.MIN_VALUE;
  }
  
  public ParamChain init_device(Context paramContext, ParamChain paramParamChain) {
    bp.a("SDKManager init_device");
    if (bx.e(paramContext)) {
      paramParamChain = paramParamChain.grow(e.class.getName());
      String str = cv.d(paramContext);
      bp.a("SDKManager init_device, imsi:" + str);
      paramParamChain.add("global.device.imsi", str);
      Object object = paramContext.getSystemService("phone");
      if (object instanceof TelephonyManager) {
        object = ((TelephonyManager)object).getDeviceId();
        bp.a("SDKManager init_device, imei:" + object);
        if (object != null)
          paramParamChain.add("global.device.imei", object); 
      } 
      paramParamChain.add("global.device.phone_model", "android");
    } 
    return paramParamChain;
  }
  
  public boolean isLogined() {
    Boolean bool = (Boolean)c.get("global.user.login_state_success", Boolean.class);
    return (bool != null && bool.booleanValue());
  }
  
  public void onStart() {
    cv.g(this.f);
  }
  
  public int queryOrderState(String paramString) {
    ae ae = t.a(this.f).d(paramString);
    return (ae == null || !ae.e()) ? 3 : (ae.c() ? (ae.l() ? 0 : 1) : 2);
  }
  
  public void queryOrderState(Handler paramHandler, int paramInt, String paramString) {
    (new l(this, "order-query", paramHandler, paramInt, paramString)).start();
  }
  
  public void setConfigInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    cv.e(this.f);
    if (!paramBoolean1)
      (new k(this)).start(); 
  }
  
  public void setKickOffListener(IKickOffListener paramIKickOffListener) {
    v.C = paramIKickOffListener;
  }
  
  public boolean setRole(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    return setRole(cq.a(this.f).v(), paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  @Deprecated
  public boolean setRole(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    boolean bool;
    if (TextUtils.isEmpty(paramString1))
      return false; 
    cv.k(paramString3);
    String str1 = paramString2 + paramString4;
    String str2 = "posted" + paramString3 + paramString5 + paramString6;
    if (str2.equals(cm.a(this.f, str1)))
      if (!cq.a(this.f).h()) {
        if (cq.a(this.f).g() != 1)
          return true; 
      } else {
        cq.a(this.f).a(false);
      }  
    t t = new t();
    t.a(paramString2);
    t.b(paramString3);
    t.c(paramString4);
    t.e(paramString5);
    t.d(paramString6);
    v.z = t;
    paramString4 = t.c();
    paramString2 = new String(c.d(paramString4.getBytes()));
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      paramString5 = cv.b(stringBuilder.append("rOLe").append(paramString4).append("jar").toString()).toUpperCase();
      t t1 = t.a(this.f);
      Thread thread = new Thread();
      n n = new n();
      this(this, t1, paramString1, paramString2, paramString5, str1, str2);
      this(n);
      thread.start();
      bool = true;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return bool;
  }
  
  public void showExchange(Handler paramHandler) {}
  
  public void showLoginView(Handler paramHandler, int paramInt, boolean paramBoolean) {
    v.r = true;
    bg.m = paramHandler;
    bg.n = paramInt;
    ParamChain paramChain = c.grow(d.class.getName());
    paramChain.add("global.caller.msg_handler", paramHandler);
    paramChain.add("global.caller.msg_what", Integer.valueOf(paramInt));
    paramChain.add("global.caller.login_auto_start", Boolean.valueOf(paramBoolean));
    a(this.f, paramChain, f.a);
  }
  
  public void showPaymentView(Handler paramHandler, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {
    a(paramHandler, paramInt1, getGameServerId(this.f), paramString1, paramInt2, false, true, true, null, paramString2, paramString3);
  }
  
  @Deprecated
  public void showPaymentView(Handler paramHandler, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2) {
    a(paramHandler, paramInt1, getGameServerId(this.f), paramString1, paramInt2, false, paramBoolean, true, null, null, paramString2);
  }
  
  @Deprecated
  public void showPaymentView(Handler paramHandler, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {
    a(paramHandler, paramInt1, getGameServerId(this.f), paramString1, paramInt2, false, paramBoolean, true, paramString2, paramString3, paramString4);
  }
  
  @Deprecated
  public void showPaymentView(Handler paramHandler, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3) {
    a(paramHandler, paramInt1, getGameServerId(this.f), paramString1, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, null, paramString2, paramString3);
  }
  
  public void showPaymentView2(Handler paramHandler, int paramInt1, String paramString1, int paramInt2, String paramString2) {
    ParamChain paramChain = c.grow(d.class.getName());
    paramChain.add("global.caller.msg_handler", paramHandler);
    paramChain.add("global.caller.msg_what", Integer.valueOf(paramInt1));
    paramChain.add("global.caller.game_server_id", getGameServerId(this.f));
    paramChain.add("global.caller.game_role", paramString1);
    paramChain.add("global.caller.amount", Integer.valueOf(paramInt2));
    paramChain.add("global.caller.is_close_window", Boolean.valueOf(true));
    paramChain.add("global.caller.payment_zycoin_disabled", Boolean.valueOf(false));
    paramChain.add("global.caller.pay_is_buy_mode", Boolean.valueOf(true));
    if (paramString2 != null)
      paramChain.add("global.caller.prop_name", paramString2); 
    a(this.f, paramChain, f.d);
  }
  
  public void showUserPlatformView(Handler paramHandler, int paramInt) {
    if (!isLogined()) {
      Log.e("zz_sdk", "请先登录！");
      return;
    } 
    ParamChain paramChain = c.grow(d.class.getName());
    paramChain.add("global.caller.msg_handler", paramHandler);
    paramChain.add("global.caller.msg_what", Integer.valueOf(paramInt));
    paramChain.add("global.caller.is_platform", Boolean.valueOf(true));
    a(this.f, paramChain, f.a);
  }
  
  public void updateLoginInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.b.a(c.getParent(g.class.getName()), paramString2, null, null, paramString3, paramString1, paramString4, paramString5);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\SDKManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */