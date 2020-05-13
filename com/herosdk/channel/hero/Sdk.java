package com.herosdk.channel.hero;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.base.ISdkBase;
import com.herosdk.error.ErrorUtils;
import com.zz.sdk.SDKManager;

public class Sdk implements ISdkBase {
  public static final int a = 2014;
  
  public static final int b = 2015;
  
  public static String c = "herosdk." + HeroSdk.getInstance().getCcn() + ".";
  
  public static final int d = 2013;
  
  public static String e = "";
  
  public static boolean f = false;
  
  private static volatile Sdk h;
  
  public String g = c + "sdk";
  
  private boolean i = false;
  
  private Activity j = null;
  
  private Handler k = new Sdk$2(this);
  
  public static Sdk getInstance() {
    // Byte code:
    //   0: getstatic com/herosdk/channel/hero/Sdk.h : Lcom/herosdk/channel/hero/Sdk;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/channel/hero/Sdk
    //   8: monitorenter
    //   9: getstatic com/herosdk/channel/hero/Sdk.h : Lcom/herosdk/channel/hero/Sdk;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/channel/hero/Sdk
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/channel/hero/Sdk.h : Lcom/herosdk/channel/hero/Sdk;
    //   27: ldc com/herosdk/channel/hero/Sdk
    //   29: monitorexit
    //   30: getstatic com/herosdk/channel/hero/Sdk.h : Lcom/herosdk/channel/hero/Sdk;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/channel/hero/Sdk
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public boolean callExtendApi(Activity paramActivity, int paramInt) {
    Log.d(this.g, "callExtendApi");
    if (paramInt == 12) {
      Log.d(this.g, "callExtendApi...if");
      SDKManager.setAppKey(HeroSdk.getInstance().getCustomParams("channel_app_key"));
      SDKManager.setAppSecretKey(HeroSdk.getInstance().getCustomParams("channel_app_secret_key"));
      SDKManager.setAccoAppKey(HeroSdk.getInstance().getCustomParams("channel_acco_app_key"));
      SDKManager.setAccoAppSecret(HeroSdk.getInstance().getCustomParams("channel_acco_app_secret"));
      SDKManager.setCommon(HeroSdk.getInstance().getCustomParams("channel_app_is_common").equalsIgnoreCase("true"));
      SDKManager.resetFromAssets((Context)paramActivity);
      SDKManager.getInstance((Context)paramActivity).onStart();
      return true;
    } 
    return false;
  }
  
  public void exit(Activity paramActivity) {
    Log.d(this.g, "exit");
    try {
      exitSuccess();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void exitFailed(String paramString) {
    Log.e(this.g, "exitFailed msg:" + paramString);
    if (HeroSdk.getInstance().getExitListener() != null)
      HeroSdk.getInstance().getExitListener().onFailed(paramString); 
  }
  
  public void exitSuccess() {
    Log.d(this.g, "exitSuccess");
    if (HeroSdk.getInstance().getExitListener() != null)
      HeroSdk.getInstance().getExitListener().onSuccess(); 
  }
  
  public String getChannelVersion() {
    return "3.4.4";
  }
  
  public Handler getHandler() {
    return this.k;
  }
  
  public String getToken() {
    return e;
  }
  
  public void hideFloat() {
    Log.d(this.g, "hideFloat");
    SDKManager.tryHideFloat(this.j);
  }
  
  public void init(Activity paramActivity) {
    Log.d(this.g, "init");
    try {
      this.j = paramActivity;
      SDKManager.setAppKey(HeroSdk.getInstance().getCustomParams("channel_app_key"));
      SDKManager.setAppSecretKey(HeroSdk.getInstance().getCustomParams("channel_app_secret_key"));
      SDKManager.setAccoAppKey(HeroSdk.getInstance().getCustomParams("channel_acco_app_key"));
      SDKManager.setAccoAppSecret(HeroSdk.getInstance().getCustomParams("channel_acco_app_secret"));
      SDKManager.setCommon(HeroSdk.getInstance().getCustomParams("channel_app_is_common").equalsIgnoreCase("true"));
      SDKManager.resetFromAssets((Context)paramActivity);
      SDKManager.setJdAppId(HeroSdk.getInstance().getCustomParams("channel_jd_pay_app_id"));
      SDKManager.setAntiAddiction(true);
      SDKManager.setShowFloat(HeroSdk.getInstance().getCustomParams("channel_is_show_float").equalsIgnoreCase("true"));
      SDKManager.tryInitFloat(this.j);
      SDKManager.getInstance((Context)this.j).onStart();
      SDKManager sDKManager = SDKManager.getInstance((Context)this.j);
      Sdk$1 sdk$1 = new Sdk$1();
      this(this);
      sDKManager.setKickOffListener(sdk$1);
      initSuccess();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void initFailed(String paramString) {
    Log.e(this.g, "initFailed msg:" + paramString);
    if (HeroSdk.getInstance().getInitListener() != null)
      HeroSdk.getInstance().getInitListener().onFailed(paramString); 
  }
  
  public void initSuccess() {
    Log.d(this.g, "initSuccess");
    if (HeroSdk.getInstance().getInitListener() != null)
      HeroSdk.getInstance().getInitListener().onSuccess(); 
  }
  
  public boolean isChannelHasExitDialog() {
    return this.i;
  }
  
  public void showFloat() {
    Log.d(this.g, "showFloat");
    SDKManager.tryShowFloat(this.j, new Sdk$3(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\Sdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */