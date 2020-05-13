package com.herosdk.channel.hero;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.base.IUserBase;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.error.ErrorUtils;
import com.zz.sdk.SDKManager;

public class User implements IUserBase {
  private static volatile User b;
  
  public String a = Sdk.c + "user";
  
  private UserInfo c = null;
  
  public static User getInstance() {
    // Byte code:
    //   0: getstatic com/herosdk/channel/hero/User.b : Lcom/herosdk/channel/hero/User;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/channel/hero/User
    //   8: monitorenter
    //   9: getstatic com/herosdk/channel/hero/User.b : Lcom/herosdk/channel/hero/User;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/channel/hero/User
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/channel/hero/User.b : Lcom/herosdk/channel/hero/User;
    //   27: ldc com/herosdk/channel/hero/User
    //   29: monitorexit
    //   30: getstatic com/herosdk/channel/hero/User.b : Lcom/herosdk/channel/hero/User;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/channel/hero/User
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public static void kickCount(Activity paramActivity, String paramString) {
    SDKManager.getInstance((Context)paramActivity).cpKickOffCallBackWithResult(paramString);
  }
  
  public String getChannelLoginParams() {
    return null;
  }
  
  public void login(Activity paramActivity) {
    Log.d(this.a, "login");
    try {
      Sdk.f = true;
      Sdk.getInstance().hideFloat();
      SDKManager.getInstance((Context)paramActivity).showLoginView(Sdk.getInstance().getHandler(), 2014, true);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void loginCancel() {
    Log.d(this.a, "loginCancel");
    Sdk.f = false;
    if (HeroSdk.getInstance().getLoginListener() != null)
      HeroSdk.getInstance().getLoginListener().onCancel(); 
  }
  
  public void loginFailed(String paramString) {
    Log.e(this.a, "loginFailed msg:" + paramString);
    Sdk.f = false;
    if (HeroSdk.getInstance().getLoginListener() != null)
      HeroSdk.getInstance().getLoginListener().onFailed(paramString); 
  }
  
  public void loginSuccess(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
    Log.d(this.a, "loginSuccess");
    Sdk.f = false;
    this.c = new UserInfo();
    this.c.setUid(paramString1);
    this.c.setUsername(paramString2);
    this.c.setToken(paramString3);
    if (HeroSdk.getInstance().getLoginListener() != null)
      HeroSdk.huLogin(paramActivity, this.c, HeroSdk.getInstance().getLoginListener()); 
  }
  
  public void logout(Activity paramActivity) {
    Log.d(this.a, "logout");
    try {
      Sdk.getInstance().hideFloat();
      logoutSuccess();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void logoutFailed(String paramString) {
    Log.e(this.a, "logoutFailed msg:" + paramString);
    if (HeroSdk.getInstance().getLogoutListener() != null)
      HeroSdk.getInstance().getLogoutListener().onFailed(paramString); 
  }
  
  public void logoutSuccess() {
    Log.d(this.a, "logoutSuccess");
    Sdk.f = false;
    if (HeroSdk.getInstance().getLogoutListener() != null)
      HeroSdk.getInstance().getLogoutListener().onSuccess(); 
  }
  
  public void submitRoleInfo(Activity paramActivity, RoleInfo paramRoleInfo, int paramInt) {
    Log.d(this.a, "submitRoleInfo");
    try {
      RoleInfoUtil.setRoleInfo(paramRoleInfo);
      SDKManager.getInstance((Context)paramActivity).setRole(RoleInfoUtil.getServerId(), RoleInfoUtil.getServerName(), RoleInfoUtil.getRoleId(), RoleInfoUtil.getRoleName(), "");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void switchAccountCancel() {
    Log.d(this.a, "switchAccountCancel");
    if (HeroSdk.getInstance().getSwitchAccountListener() != null)
      HeroSdk.getInstance().getSwitchAccountListener().onCancel(); 
  }
  
  public void switchAccountFailed(String paramString) {
    Log.e(this.a, "switchAccountFailed msg:" + paramString);
    if (HeroSdk.getInstance().getSwitchAccountListener() != null)
      HeroSdk.getInstance().getSwitchAccountListener().onFailed(paramString); 
  }
  
  public void switchAccountSuccess(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
    Log.d(this.a, "switchAccountSuccess");
    this.c = new UserInfo();
    this.c.setUid(paramString1);
    this.c.setUsername(paramString2);
    this.c.setToken(paramString3);
    if (HeroSdk.getInstance().getSwitchAccountListener() != null)
      HeroSdk.huLogin(paramActivity, this.c, HeroSdk.getInstance().getSwitchAccountListener()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */