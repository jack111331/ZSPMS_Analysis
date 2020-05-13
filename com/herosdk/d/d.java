package com.herosdk.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.bean.ShareInfo;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IShareListener;

public class d {
  private static final String a = "frameLib.BlocUtils";
  
  private static volatile d b;
  
  public static d a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/d.b : Lcom/herosdk/d/d;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/d/d
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/d.b : Lcom/herosdk/d/d;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/d/d
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/d.b : Lcom/herosdk/d/d;
    //   27: ldc com/herosdk/d/d
    //   29: monitorexit
    //   30: getstatic com/herosdk/d/d.b : Lcom/herosdk/d/d;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/d/d
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void A(Activity paramActivity) {
    try {
      b().getDeclaredMethod("hideFloatView", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "hideFloatView...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void B(Activity paramActivity) {
    try {
      Log.d("frameLib.BlocUtils", "onDestroy");
      b().getDeclaredMethod("onDestroy", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "onDestroy...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    try {
      Log.d("frameLib.BlocUtils", "onActivityResult");
      b().getDeclaredMethod("onActivityResult", new Class[] { int.class, int.class, Intent.class }).invoke(b(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "onActivityResult...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Activity paramActivity) {
    String str1;
    String str2;
    int i;
    boolean bool;
    try {
      Log.d("frameLib.BlocUtils", "initBlocSdk");
      str1 = HeroSdk.getInstance().getCustomParams("hu_bloc_app_key");
      str2 = HeroSdk.getInstance().getCustomParams("hu_bloc_game_id");
      i = HeroSdk.getInstance().getChannelId();
      bool = HeroSdk.getInstance().getBlocDebugMode();
      if (TextUtils.isEmpty(str2)) {
        Log.d("frameLib.BlocUtils", "initBlocSdk...but gameId is empty, return");
        return;
      } 
      if (TextUtils.isEmpty(str1)) {
        Log.d("frameLib.BlocUtils", "initBlocSdk...but appKey is empty, return");
        return;
      } 
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "initBlocSdk...ex");
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    b().getDeclaredMethod("init", new Class[] { Activity.class, String.class, String.class, String.class, boolean.class }).invoke(b(), new Object[] { exception, str1, str2, String.valueOf(i), Boolean.valueOf(bool) });
  }
  
  public void a(Activity paramActivity, ShareInfo paramShareInfo, boolean paramBoolean, int paramInt, IShareListener paramIShareListener) {
    try {
      Log.d("frameLib.BlocUtils", "share");
      b().getDeclaredMethod("share", new Class[] { Activity.class, ShareInfo.class, boolean.class, int.class, IShareListener.class }).invoke(b(), new Object[] { paramActivity, paramShareInfo, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramIShareListener });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "share...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Activity paramActivity, String paramString) {
    try {
      b().getDeclaredMethod("showEntrance", new Class[] { Activity.class, String.class }).invoke(b(), new Object[] { paramActivity, paramString });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showEntrance...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3) {
    try {
      b().getDeclaredMethod("initFloatView", new Class[] { Activity.class, String.class, int.class, int.class, int.class }).invoke(b(), new Object[] { paramActivity, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "initFloatView...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2) {
    try {
      b().getDeclaredMethod("showEntrance", new Class[] { Activity.class, String.class, String.class }).invoke(b(), new Object[] { paramActivity, paramString1, paramString2 });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showEntrance...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong1, long paramLong2) {
    try {
      Log.d("frameLib.BlocUtils", "bloc submitRoleInfo");
      if (TextUtils.isEmpty(HeroSdk.getInstance().getCustomParams("hu_bloc_game_id"))) {
        Log.d("frameLib.BlocUtils", "bloc submitRoleInfo...but gameId is empty, return");
        return;
      } 
      if (TextUtils.isEmpty(HeroSdk.getInstance().getCustomParams("hu_bloc_app_key"))) {
        Log.d("frameLib.BlocUtils", "bloc submitRoleInfo...but appKey is empty, return");
        return;
      } 
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "bloc submitRoleInfo...ex");
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    b().getDeclaredMethod("submitRoleInfo", new Class[] { 
          Activity.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, int.class, long.class, 
          long.class }).invoke(b(), new Object[] { 
          exception, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, Integer.valueOf(paramInt), Long.valueOf(paramLong1), 
          Long.valueOf(paramLong2) });
  }
  
  public void a(boolean paramBoolean) {
    try {
      b().getDeclaredMethod("setDebugMode", new Class[] { boolean.class }).invoke(b(), new Object[] { Boolean.valueOf(paramBoolean) });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "setBlocDebugMode...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(String[] paramArrayOfString) {
    try {
      Log.d("frameLib.BlocUtils", "setServerUrl");
      b().getDeclaredMethod("setServerUrl", new Class[] { String[].class }).invoke(b(), new Object[] { paramArrayOfString });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "setServerUrl...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean a(Context paramContext, String paramString) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isShowEntrance", new Class[] { Context.class, String.class }).invoke(b(), new Object[] { paramContext, paramString })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isShowEntrance...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public Class<?> b() {
    try {
      Class<?> clazz = Class.forName("com.hu.plugin.bloc.BlocSdk");
    } catch (ClassNotFoundException classNotFoundException) {
      Log.d("frameLib.BlocUtils", "getBlocClass...ex");
      ErrorUtils.printExceptionInfo(classNotFoundException);
      classNotFoundException = null;
    } 
    return (Class<?>)classNotFoundException;
  }
  
  public void b(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showStrategy", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showStrategy...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void b(boolean paramBoolean) {
    try {
      b().getDeclaredMethod("setIsForbidFloat", new Class[] { boolean.class }).invoke(b(), new Object[] { Boolean.valueOf(paramBoolean) });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "setIsForbidFloat...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean b(Context paramContext, String paramString) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isShowRedPot", new Class[] { Context.class, String.class }).invoke(b(), new Object[] { paramContext, paramString })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isShowRedPot...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public boolean c() {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("getDebugMode", new Class[0]).invoke(b(), new Object[0])).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "getBlocDebugMode...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public boolean c(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isStrategyAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isStrategyAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void d(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showMatch", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showMatch...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public String[] d() {
    try {
      Log.d("frameLib.BlocUtils", "getServerUrl");
      String[] arrayOfString = (String[])b().getDeclaredMethod("getServerUrl", new Class[0]).invoke(b(), new Object[0]);
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "getServerUrl...ex");
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (String[])exception;
  }
  
  public boolean e(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isMatchAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isMatchAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void f(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showClub", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showClub...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean g(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isClubAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isClubAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void h(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showPullNew", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showPullNew...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean i(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isPullNewAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isPullNewAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void j(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showProduceForum", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showProduceForum...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean k(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isProduceForumAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isProduceForumAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void l(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showProduceZone", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showProduceZone...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean m(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isProduceZoneAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isProduceZoneAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void n(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showProduceAward", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showProduceAward...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean o(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isProduceAwardAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isProduceAwardAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void p(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showShop", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showShop...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean q(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isShopAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isShopAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void r(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showPray", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showPray...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean s(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isPrayAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isPrayAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void t(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showActivity", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showActivity...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean u(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isActivityAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isActivityAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void v(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showMinGame", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showMinGame...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean w(Activity paramActivity) {
    boolean bool;
    try {
      bool = ((Boolean)b().getDeclaredMethod("isMinGameAvailable", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity })).booleanValue();
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "isMinGameAvailable...ex");
      ErrorUtils.printExceptionInfo(exception);
      bool = false;
    } 
    return bool;
  }
  
  public void x(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showBindPhoneFloat", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showBindPhoneFloat...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void y(Activity paramActivity) {
    try {
      b().getDeclaredMethod("hideBindPhoneFloat", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "hideBindPhoneFloat...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void z(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showFloatView", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.BlocUtils", "showFloatView...ex");
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */