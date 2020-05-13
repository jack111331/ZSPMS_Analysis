package com.herosdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.herosdk.b.a;
import com.herosdk.base.IFactoryBase;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.ShareInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.bb;
import com.herosdk.d.d;
import com.herosdk.d.k;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IAdBannerListener;
import com.herosdk.listener.IAdVideoListener;
import com.herosdk.listener.IChannelAccountOffLineListener;
import com.herosdk.listener.ICommonListener;
import com.herosdk.listener.IEventListener;
import com.herosdk.listener.IExitListener;
import com.herosdk.listener.IGameVoiceListener;
import com.herosdk.listener.IIdentifyLoginListener;
import com.herosdk.listener.IIdentifyOnlineListener;
import com.herosdk.listener.IIdentifyPayListener;
import com.herosdk.listener.IInitListener;
import com.herosdk.listener.IInviteFriendListener;
import com.herosdk.listener.IKickListener;
import com.herosdk.listener.ILiveStateListener;
import com.herosdk.listener.ILoginListener;
import com.herosdk.listener.ILogoutListener;
import com.herosdk.listener.IPayListener;
import com.herosdk.listener.IShareListener;
import com.herosdk.listener.ISinglePayListener;
import com.herosdk.listener.ISwitchAccountListener;
import com.herosdk.listener.ITranslateListener;
import com.herosdk.listener.IVoiceDictateListener;
import com.herosdk.listener.a;
import com.herosdk.listener.af;
import com.herosdk.listener.ai;
import com.herosdk.listener.b;
import com.herosdk.listener.g;
import com.herosdk.listener.i;
import com.herosdk.listener.k;
import com.herosdk.listener.m;
import com.herosdk.listener.p;
import com.herosdk.listener.r;
import com.herosdk.listener.v;
import com.herosdk.listener.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class HeroSdk {
  private static final String a = "frameLib.HeroSdk";
  
  private static volatile HeroSdk b = null;
  
  private IFactoryBase c = null;
  
  private IInitListener d = null;
  
  private ILoginListener e = null;
  
  private ILoginListener f = null;
  
  private ILogoutListener g = null;
  
  private IKickListener h = null;
  
  private IChannelAccountOffLineListener i = null;
  
  private IPayListener j = null;
  
  private ISinglePayListener k = null;
  
  private IExitListener l = null;
  
  private ICommonListener m = null;
  
  private IEventListener n = null;
  
  private IGameVoiceListener o = null;
  
  private IInviteFriendListener p = null;
  
  private ILiveStateListener q = null;
  
  private IVoiceDictateListener r = null;
  
  private ITranslateListener s = null;
  
  private IAdBannerListener t = null;
  
  private IAdVideoListener u = null;
  
  private IIdentifyLoginListener v = null;
  
  private IIdentifyPayListener w = null;
  
  private IIdentifyOnlineListener x = null;
  
  private String y = "";
  
  private HeroSdk() {
    this.c = x.a().b();
  }
  
  private void a(Activity paramActivity, RoleInfo paramRoleInfo, int paramInt) {
    try {
      e e = new e();
      this(this, paramActivity, paramRoleInfo, paramInt);
      bb.a(e);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static HeroSdk getInstance() {
    // Byte code:
    //   0: getstatic com/herosdk/HeroSdk.b : Lcom/herosdk/HeroSdk;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/HeroSdk
    //   8: monitorenter
    //   9: getstatic com/herosdk/HeroSdk.b : Lcom/herosdk/HeroSdk;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/HeroSdk
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/HeroSdk.b : Lcom/herosdk/HeroSdk;
    //   27: ldc com/herosdk/HeroSdk
    //   29: monitorexit
    //   30: getstatic com/herosdk/HeroSdk.b : Lcom/herosdk/HeroSdk;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/HeroSdk
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public static void huLogin(Activity paramActivity, UserInfo paramUserInfo, ILoginListener paramILoginListener) {
    x.a().a(paramActivity, paramUserInfo, paramILoginListener);
  }
  
  public JSONObject cIdCard(Context paramContext, String paramString) {
    try {
      JSONObject jSONObject = a.a().f(paramContext, paramString);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public boolean callExtendApi(Activity paramActivity, int paramInt) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    try {
      if (!x.a().o().booleanValue()) {
        if (x.a().s().booleanValue())
          return bool1; 
      } else {
        return bool2;
      } 
      bool2 = x.a().a(paramActivity, paramInt);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public void createNewRole(Activity paramActivity, RoleInfo paramRoleInfo) {
    a(paramActivity, paramRoleInfo, 2);
  }
  
  public void enterGame(Activity paramActivity, RoleInfo paramRoleInfo) {
    a(paramActivity, paramRoleInfo, 1);
  }
  
  public void exit(Activity paramActivity) {
    try {
      k k = new k();
      this(this, paramActivity);
      bb.a(k);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public IAdBannerListener getAdBannerListener() {
    return this.t;
  }
  
  public IAdVideoListener getAdVideoListener() {
    return this.u;
  }
  
  public boolean getBlocDebugMode() {
    return d.a().c();
  }
  
  public String getCcn() {
    return x.a().g().trim();
  }
  
  public IChannelAccountOffLineListener getChannelAccountOffLineListener() {
    return this.i;
  }
  
  public int getChannelId() {
    return x.a().c();
  }
  
  public String getChannelMsg() {
    return this.y;
  }
  
  public String getChannelName() {
    return x.a().f().trim();
  }
  
  public String getChannelSdkVersionName() {
    return x.a().w();
  }
  
  public int getChannelType() {
    return x.a().e();
  }
  
  public ICommonListener getCommonListener() {
    return this.m;
  }
  
  public String getCustomParams(String paramString) {
    String str;
    try {
      paramString = x.a().a(paramString.trim()).trim();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      str = "";
    } 
    return str;
  }
  
  public String getDeviceId(Context paramContext) {
    return x.a().c(paramContext);
  }
  
  public IEventListener getEventListener() {
    return this.n;
  }
  
  public IExitListener getExitListener() {
    return this.l;
  }
  
  public IGameVoiceListener getGameVoiceListener() {
    return this.o;
  }
  
  public String getHeroSdkVersionCode() {
    return "204";
  }
  
  public String getHeroSdkVersionName() {
    return "2.0.4";
  }
  
  public IIdentifyLoginListener getIdentifyLoginListener() {
    return this.v;
  }
  
  public IIdentifyOnlineListener getIdentifyOnlineListener() {
    return this.x;
  }
  
  public IIdentifyPayListener getIdentifyPayListener() {
    return this.w;
  }
  
  public IInitListener getInitListener() {
    return this.d;
  }
  
  public IInviteFriendListener getInviteFriendListener() {
    return this.p;
  }
  
  public IKickListener getKickListener() {
    return this.h;
  }
  
  public ILiveStateListener getLiveStateListener() {
    return this.q;
  }
  
  public ILoginListener getLoginListener() {
    return this.e;
  }
  
  public ILogoutListener getLogoutListener() {
    return this.g;
  }
  
  public IPayListener getPayListener() {
    return this.j;
  }
  
  public String getProjectId(Activity paramActivity) {
    return x.a().b((Context)paramActivity);
  }
  
  public String[] getServerUrl() {
    return d.a().d();
  }
  
  public ISinglePayListener getSinglePayListener() {
    return this.k;
  }
  
  public ILoginListener getSwitchAccountListener() {
    return this.f;
  }
  
  @Deprecated
  public int getThirdChannelId() {
    return x.a().d();
  }
  
  public ITranslateListener getTranslateListener() {
    return this.s;
  }
  
  public UserInfo getUserInfo() {
    try {
      UserInfo userInfo = x.a().h();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (UserInfo)exception;
  }
  
  public IVoiceDictateListener getVoiceDictateListener() {
    return this.r;
  }
  
  public void hideBindPhoneFloat(Activity paramActivity) {
    d.a().y(paramActivity);
  }
  
  public void hideFloatView(Activity paramActivity) {
    d.a().A(paramActivity);
  }
  
  public JSONObject huCYB(Context paramContext, String paramString) {
    try {
      JSONObject jSONObject = a.a().e(paramContext, paramString);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public JSONObject huYP(Context paramContext, String paramString1, String paramString2, String paramString3) {
    try {
      JSONObject jSONObject = a.a().b(paramContext, paramString1, paramString2, paramString3);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void init(Activity paramActivity, String paramString1, String paramString2) {
    try {
      b b = new b();
      this(this, paramActivity, paramString1, paramString2);
      bb.a(b);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void initBlocSdk(Activity paramActivity) {
    d.a().a(paramActivity);
  }
  
  public void initFloatView(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3) {
    d.a().a(paramActivity, "phone", paramInt1, paramInt2, paramInt3);
  }
  
  public void initFloatView(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3) {
    d.a().a(paramActivity, paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean isActivityAvailable(Activity paramActivity) {
    return d.a().u(paramActivity);
  }
  
  public Boolean isChannelHasExitDialog() {
    Boolean bool;
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        return Boolean.valueOf(this.c.getSdk().isChannelHasExitDialog()); 
      bool = Boolean.valueOf(false);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      bool = Boolean.valueOf(false);
    } 
    return bool;
  }
  
  public boolean isClubAvailable(Activity paramActivity) {
    return d.a().g(paramActivity);
  }
  
  public boolean isHuKicking() {
    return x.a().S();
  }
  
  public Boolean isLandScape() {
    Boolean bool;
    try {
      boolean bool1 = x.a().j();
      bool = Boolean.valueOf(bool1);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      bool = Boolean.valueOf(false);
    } 
    return bool;
  }
  
  public boolean isMatchAvailable(Activity paramActivity) {
    return d.a().e(paramActivity);
  }
  
  public boolean isMinGameAvailable(Activity paramActivity) {
    return d.a().w(paramActivity);
  }
  
  public boolean isPrayAvailable(Activity paramActivity) {
    return d.a().s(paramActivity);
  }
  
  public boolean isProduceAwardAvailable(Activity paramActivity) {
    return d.a().o(paramActivity);
  }
  
  public boolean isProduceForumAvailable(Activity paramActivity) {
    return d.a().k(paramActivity);
  }
  
  public boolean isProduceZoneAvailable(Activity paramActivity) {
    return d.a().m(paramActivity);
  }
  
  public boolean isPullNewAvailable(Activity paramActivity) {
    return d.a().i(paramActivity);
  }
  
  public boolean isShopAvailable(Activity paramActivity) {
    return d.a().q(paramActivity);
  }
  
  public boolean isShowEntrance(Context paramContext, String paramString) {
    return d.a().a(paramContext, paramString);
  }
  
  public boolean isShowRedPot(Context paramContext, String paramString) {
    return d.a().b(paramContext, paramString);
  }
  
  public boolean isStrategyAvailable(Activity paramActivity) {
    return d.a().c(paramActivity);
  }
  
  public void launchBarcodeScanner(Activity paramActivity, String paramString) {
    x.a().a(paramActivity, paramString);
  }
  
  public void login(Activity paramActivity) {
    try {
      c c = new c();
      this(this, paramActivity);
      bb.a(c);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void logout(Activity paramActivity) {
    try {
      d d = new d();
      this(this, paramActivity);
      bb.a(d);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void notifyKickResult(String paramString) {
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      Log.d("frameLib.HeroSdk", stringBuilder1.append("nkr:").append(paramString).toString());
      Activity activity = x.a().x();
      if (x.a().S()) {
        Log.d("frameLib.HeroSdk", "nkr..hu");
        a.a().g((Context)activity, paramString);
        return;
      } 
      String str = this.c.getUser().getClass().getName();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      Log.d("frameLib.HeroSdk", stringBuilder2.append("nkr..c n:").append(str).toString());
      Class<?> clazz = Class.forName(str);
      clazz.getDeclaredMethod("kickCount", new Class[] { Activity.class, String.class }).invoke(clazz, new Object[] { activity, paramString });
    } catch (Exception exception) {}
  }
  
  public void notifyPaySuccess(String paramString1, String paramString2, String paramString3) {
    try {
      a.a().a((Context)x.a().x(), paramString1, paramString2, paramString3);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    Log.d("frameLib.HeroSdk", "onActivityResult");
    if (paramInt1 == 48056932 && paramInt2 == -1) {
      if (paramIntent != null)
        try {
          String str1 = paramIntent.getStringExtra("codedContent");
          String str2 = "";
          try {
            String str = URLEncoder.encode(paramIntent.getStringExtra("zxingExtra"), "UTF-8");
          } catch (UnsupportedEncodingException unsupportedEncodingException) {}
          StringBuilder stringBuilder = new StringBuilder();
          this();
          bb.a((Context)paramActivity, stringBuilder.append(x.a().E()).append("/v2/scanqr/qrck?q=").append(str1).append("&t=").append(getUserInfo().getToken()).append("&pcode=").append(k.a().j()).append("&ext=").append((String)unsupportedEncodingException).toString());
        } catch (Exception exception) {
          ErrorUtils.printExceptionInfo(exception);
        }  
      return;
    } 
    if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
      this.c.getLifecycle().onActivityResult((Activity)exception, paramInt1, paramInt2, (Intent)unsupportedEncodingException); 
    PluginUtils.getInstance().invokePlugin(PluginNode.ON_ACTIVITY_RESULT, new Object[] { exception, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), unsupportedEncodingException });
  }
  
  public void onCreate(Activity paramActivity) {
    Log.d("frameLib.HeroSdk", "onCreate");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onCreate(paramActivity); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_CREATE, new Object[] { paramActivity });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onDestroy(Activity paramActivity) {
    Log.d("frameLib.HeroSdk", "onDestroy");
    try {
      x.a().M();
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onDestroy(paramActivity); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_DESTROY, new Object[] { paramActivity });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent) {
    Log.d("frameLib.HeroSdk", "onNewIntent");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onNewIntent(paramActivity, paramIntent); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_NEW_INTENT, new Object[] { paramActivity, paramIntent });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onPause(Activity paramActivity) {
    Log.d("frameLib.HeroSdk", "onPause");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onPause(paramActivity); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_PAUSE, new Object[] { paramActivity });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    Log.d("frameLib.HeroSdk", "onRequestPermissionsResult");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue()) {
        Class<?> clazz = Class.forName(this.c.getLifecycle().getClass().getName());
        clazz.getDeclaredMethod("onRequestPermissionsResults", new Class[] { Activity.class, int.class, String[].class, int[].class }).invoke(clazz, new Object[] { paramActivity, Integer.valueOf(paramInt), paramArrayOfString, paramArrayOfint });
      } 
    } catch (Exception exception) {}
  }
  
  public void onRestart(Activity paramActivity) {
    Log.d("frameLib.HeroSdk", "onRestart");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onRestart(paramActivity); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_RESTART, new Object[] { paramActivity });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onResume(Activity paramActivity) {
    Log.d("frameLib.HeroSdk", "onResume");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onResume(paramActivity); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_RESUME, new Object[] { paramActivity });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onStart(Activity paramActivity) {
    Log.d("frameLib.HeroSdk", "onStart");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onStart(paramActivity); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_START, new Object[] { paramActivity });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void onStop(Activity paramActivity) {
    Log.d("frameLib.HeroSdk", "onStop");
    try {
      if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
        this.c.getLifecycle().onStop(paramActivity); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_STOP, new Object[] { paramActivity });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void openUrl(Activity paramActivity, String paramString) {
    d.a().a(paramActivity, paramString);
  }
  
  public void pay(Activity paramActivity, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo) {
    try {
      PluginUtils.getInstance().invokePlugin(PluginNode.BEFORE_PAY, new Object[] { paramActivity, paramOrderInfo, paramRoleInfo, getUserInfo() });
      f f = new f();
      this(this, paramActivity, paramOrderInfo, paramRoleInfo);
      bb.a(f);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void repay(Context paramContext, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo, String paramString, IPayListener paramIPayListener) {
    try {
      a.a().b(paramContext, paramOrderInfo, paramRoleInfo, paramString, paramIPayListener);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void roleLevelUp(Activity paramActivity, RoleInfo paramRoleInfo) {
    a(paramActivity, paramRoleInfo, 3);
  }
  
  public void setAdBannerListener(IAdBannerListener paramIAdBannerListener) {
    this.t = paramIAdBannerListener;
  }
  
  public void setAdVideoListener(IAdVideoListener paramIAdVideoListener) {
    this.u = paramIAdVideoListener;
  }
  
  public void setBlocDebugMode(boolean paramBoolean) {
    d.a().a(paramBoolean);
  }
  
  public HeroSdk setChannelAccountOffLineListener(IChannelAccountOffLineListener paramIChannelAccountOffLineListener) {
    Log.d("frameLib.HeroSdk", "sckl");
    this.i = paramIChannelAccountOffLineListener;
    return b;
  }
  
  public void setChannelMsg(String paramString) {
    this.y = paramString;
  }
  
  public HeroSdk setCommonListener(ICommonListener paramICommonListener) {
    this.m = (ICommonListener)new a(paramICommonListener);
    return b;
  }
  
  public void setDebugMode(Boolean paramBoolean) {
    k.a().a(paramBoolean);
  }
  
  public void setEventListener(IEventListener paramIEventListener) {
    this.n = paramIEventListener;
  }
  
  public HeroSdk setExitListener(IExitListener paramIExitListener) {
    this.l = (IExitListener)new b(paramIExitListener);
    return b;
  }
  
  public void setGameVoiceListener(IGameVoiceListener paramIGameVoiceListener) {
    this.o = paramIGameVoiceListener;
  }
  
  public void setIdentifyLoginListener(IIdentifyLoginListener paramIIdentifyLoginListener) {
    this.v = (IIdentifyLoginListener)new g(paramIIdentifyLoginListener);
  }
  
  public void setIdentifyOnlineListener(IIdentifyOnlineListener paramIIdentifyOnlineListener) {
    this.x = (IIdentifyOnlineListener)new i(paramIIdentifyOnlineListener);
  }
  
  public void setIdentifyPayListener(IIdentifyPayListener paramIIdentifyPayListener) {
    this.w = (IIdentifyPayListener)new k(paramIIdentifyPayListener);
  }
  
  public HeroSdk setInitListener(IInitListener paramIInitListener) {
    this.d = (IInitListener)new m(paramIInitListener);
    return b;
  }
  
  public void setInviteFriendListener(IInviteFriendListener paramIInviteFriendListener) {
    this.p = paramIInviteFriendListener;
  }
  
  public void setIsForbidFloat(boolean paramBoolean) {
    d.a().b(paramBoolean);
  }
  
  public HeroSdk setKickListener(IKickListener paramIKickListener) {
    Log.d("frameLib.HeroSdk", "skl");
    this.h = (IKickListener)new p(paramIKickListener);
    return b;
  }
  
  public void setLiveStateListener(ILiveStateListener paramILiveStateListener) {
    this.q = paramILiveStateListener;
  }
  
  public HeroSdk setLoginListener(ILoginListener paramILoginListener) {
    this.e = (ILoginListener)new r(paramILoginListener);
    return b;
  }
  
  public HeroSdk setLogoutListener(ILogoutListener paramILogoutListener) {
    this.g = (ILogoutListener)new v(paramILogoutListener);
    return b;
  }
  
  public HeroSdk setPayListener(IPayListener paramIPayListener) {
    this.j = (IPayListener)new y(paramIPayListener);
    return b;
  }
  
  public void setServerUrl(String[] paramArrayOfString) {
    d.a().a(paramArrayOfString);
  }
  
  public HeroSdk setSinglePayListener(ISinglePayListener paramISinglePayListener) {
    setPayListener(new l(this));
    this.k = (ISinglePayListener)new af(paramISinglePayListener);
    return b;
  }
  
  public HeroSdk setSwitchAccountListener(ISwitchAccountListener paramISwitchAccountListener) {
    this.f = (ILoginListener)new ai(paramISwitchAccountListener);
    return b;
  }
  
  public void setTranslateListener(ITranslateListener paramITranslateListener) {
    this.s = paramITranslateListener;
  }
  
  public void setVoiceDictateListener(IVoiceDictateListener paramIVoiceDictateListener) {
    this.r = paramIVoiceDictateListener;
  }
  
  public void share(Activity paramActivity, ShareInfo paramShareInfo, boolean paramBoolean, int paramInt, IShareListener paramIShareListener) {
    d.a().a(paramActivity, paramShareInfo, paramBoolean, paramInt, paramIShareListener);
  }
  
  public void showActivity(Activity paramActivity) {
    d.a().t(paramActivity);
  }
  
  public void showBindPhoneFloat(Activity paramActivity) {
    d.a().x(paramActivity);
  }
  
  public void showClub(Activity paramActivity) {
    d.a().f(paramActivity);
  }
  
  public void showEntrance(Activity paramActivity, String paramString) {
    d.a().a(paramActivity, paramString);
  }
  
  public void showEntrance(Activity paramActivity, String paramString1, String paramString2) {
    d.a().a(paramActivity, paramString1, paramString2);
  }
  
  public void showFloatView(Activity paramActivity) {
    d.a().z(paramActivity);
  }
  
  public void showMatch(Activity paramActivity) {
    d.a().d(paramActivity);
  }
  
  public void showMinGame(Activity paramActivity) {
    d.a().v(paramActivity);
  }
  
  public void showPray(Activity paramActivity) {
    d.a().r(paramActivity);
  }
  
  public void showProduceAward(Activity paramActivity) {
    d.a().n(paramActivity);
  }
  
  public void showProduceForum(Activity paramActivity) {
    d.a().j(paramActivity);
  }
  
  public void showProduceZone(Activity paramActivity) {
    d.a().l(paramActivity);
  }
  
  public void showPullNew(Activity paramActivity) {
    d.a().h(paramActivity);
  }
  
  public void showShop(Activity paramActivity) {
    d.a().p(paramActivity);
  }
  
  public void showSinglePayRecord(Activity paramActivity) {
    if (getInstance().getUserInfo() == null) {
      Log.e("frameLib.HeroSdk", "登录成功之后才能查看充值记录");
      return;
    } 
    bb.c((Context)paramActivity, x.a().D());
  }
  
  public void showStrategy(Activity paramActivity) {
    d.a().b(paramActivity);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\HeroSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */