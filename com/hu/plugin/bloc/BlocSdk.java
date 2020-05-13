package com.hu.plugin.bloc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.bean.ShareInfo;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IShareListener;
import java.util.Map;
import org.jar.bloc.BlocConfig;
import org.jar.bloc.BlocManager;
import org.jar.bloc.ISDKCallBack;
import org.jar.bloc.IUserData;
import org.jar.bloc.interfaces.CallBack;
import org.jar.bloc.interfaces.OnEntranceListener;
import org.jar.bloc.third.domain.ShareContent;
import org.jar.bloc.third.interfaces.OnShareListener;
import org.jar.bloc.usercenter.MType;
import org.jar.bloc.usercenter.entry.TaskRoleAttr;
import org.json.JSONObject;

public class BlocSdk {
  private static final String TAG = "plugin.bloc.BlocSdk";
  
  private static boolean isDebugMode = false;
  
  private static String[] sServerUrl;
  
  public static void bindFloatMain(Activity paramActivity) {
    try {
      BlocManager.setBindFloatScene(paramActivity, 0);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void bindFloatOther(Activity paramActivity) {
    try {
      BlocManager.setBindFloatScene(paramActivity, 1);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  private static void fillRole(Activity paramActivity, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2) {
    try {
      int i;
      IUserData iUserData = BlocManager.userData((Context)paramActivity);
      try {
        i = Integer.parseInt(paramString1);
      } catch (NumberFormatException numberFormatException) {
        i = 0;
      } 
      iUserData.setLevel(i);
      try {
        i = Integer.parseInt(paramString2);
      } catch (NumberFormatException numberFormatException) {
        i = 0;
      } 
      iUserData.setVipLevel(i);
      iUserData.setSumPay(paramInt);
      iUserData.setGold1(paramLong1);
      iUserData.setGold2(paramLong2);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static boolean getDebugMode() {
    return isDebugMode;
  }
  
  public static String[] getServerUrl() {
    return sServerUrl;
  }
  
  public static void hideBindPhoneFloat(Activity paramActivity) {
    try {
      BlocManager.setBindFloatScene(paramActivity, 1);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void hideFloatView(Activity paramActivity) {
    try {
      BlocManager.hideFloatView(paramActivity, "phone");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void init(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    try {
      boolean bool;
      BlocConfig blocConfig = new BlocConfig();
      this();
      blocConfig.setAppKey(paramString1);
      try {
        bool = Integer.parseInt(paramString2);
      } catch (NumberFormatException numberFormatException) {
        bool = false;
      } 
      blocConfig.setGameId(bool);
      blocConfig.setChannelId(paramString3);
      if (getServerUrl() != null && (getServerUrl()).length > 0)
        blocConfig.setUrlServer(getServerUrl()); 
      blocConfig.setLog(false);
      blocConfig.setDebugUrlSwitch(paramBoolean);
      blocConfig.setRefreshSwitch(false);
      BlocManager.init(paramActivity, blocConfig);
      initListeners();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void initFloatView(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3) {
    try {
      BlocManager.initFloatView(paramActivity, paramString, paramInt1, paramInt2, paramInt3);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void initListeners() {
    try {
      OnEntranceListener onEntranceListener = new OnEntranceListener() {
          public void onEntranceStatus(int param1Int) {
            if (param1Int == 0) {
              Log.d("plugin.bloc.BlocSdk", "打开了助手入口模块");
              return;
            } 
            if (param1Int == 1)
              Log.d("plugin.bloc.BlocSdk", "关闭了助手入口模块"); 
          }
        };
      super();
      BlocManager.setOnEntranceListener(onEntranceListener);
      ISDKCallBack iSDKCallBack = new ISDKCallBack() {
          public void onEntranceChange() {
            if (HeroSdk.getInstance().getEventListener() != null)
              HeroSdk.getInstance().getEventListener().onEntranceChange(); 
          }
          
          public void onMessageRecharge(JSONObject param1JSONObject) {
            String str;
            StringBuilder stringBuilder = (new StringBuilder()).append("onMessageRecharge:");
            if (param1JSONObject != null) {
              str = "传透消息为" + param1JSONObject.toString() + "需要解析";
            } else {
              str = "传透消息为null,联系管理人员";
            } 
            Log.d("plugin.bloc.BlocSdk", stringBuilder.append(str).toString());
          }
          
          public void onReceiveMessage(String param1String) {
            if (HeroSdk.getInstance().getEventListener() != null)
              HeroSdk.getInstance().getEventListener().onReceiveMessage(param1String); 
          }
          
          public void onSdkRedirectMessage(String param1String1, String param1String2) {
            Log.d("plugin.bloc.BlocSdk", "onSdkRedirectMessage, redirectMessage action:" + param1String1 + " data:" + param1String2);
          }
        };
      super();
      BlocManager.setSDKEventCallback(iSDKCallBack);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static boolean isActivityAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, "activity");
  }
  
  public static boolean isClubAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_CLUB.mark());
  }
  
  public static boolean isMatchAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_MATCH.mark());
  }
  
  public static boolean isMinGameAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, "mingame");
  }
  
  public static boolean isPrayAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, "pray");
  }
  
  public static boolean isProduceAwardAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_BBSAWARD.mark());
  }
  
  public static boolean isProduceForumAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_BBS.mark());
  }
  
  public static boolean isProduceZoneAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_CREATEZONE.mark());
  }
  
  public static boolean isPullNewAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_SPREAD.mark());
  }
  
  public static boolean isShopAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_SHOP.mark());
  }
  
  public static boolean isShowEntrance(Context paramContext, String paramString) {
    return BlocManager.isShowEntrance(paramContext, paramString);
  }
  
  public static boolean isShowRedPot(Context paramContext, String paramString) {
    return BlocManager.isShowRedPot(paramContext, paramString);
  }
  
  public static boolean isStrategyAvailable(Activity paramActivity) {
    return BlocManager.isShowEntrance((Context)paramActivity, MType.K_TACTIC.mark());
  }
  
  public static void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    try {
      BlocManager.onActivityResult(paramInt1, paramInt2, paramIntent);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void onDestroy(Activity paramActivity) {
    try {
      BlocManager.destroy(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void setDebugMode(boolean paramBoolean) {
    isDebugMode = paramBoolean;
  }
  
  public static void setIsForbidFloat(boolean paramBoolean) {
    try {
      BlocManager.setIsForbidFloat(paramBoolean);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void setServerUrl(String[] paramArrayOfString) {
    sServerUrl = paramArrayOfString;
  }
  
  public static void share(Activity paramActivity, ShareInfo paramShareInfo, boolean paramBoolean, int paramInt, IShareListener paramIShareListener) {
    if (paramShareInfo != null) {
      ShareContent shareContent;
      try {
        shareContent = new ShareContent();
        this();
        shareContent.setTitle(paramShareInfo.getTitle());
        shareContent.setText(paramShareInfo.getText());
        shareContent.setImagePath(paramShareInfo.getImagePath());
        shareContent.setUrl(paramShareInfo.getUrl());
        if (paramShareInfo.getExtra().size() > 0)
          for (Map.Entry entry : paramShareInfo.getExtra().entrySet())
            shareContent.putExtra((String)entry.getKey(), entry.getValue());  
      } catch (Exception exception) {
        ErrorUtils.printExceptionInfo(exception);
        return;
      } 
      OnShareListener onShareListener = new OnShareListener() {
          public void onShareCancel(int param1Int) {
            if (shareListener != null)
              shareListener.onShareCancel(param1Int); 
          }
          
          public void onShareFailed(int param1Int, String param1String) {
            if (shareListener != null)
              shareListener.onShareFailed(param1Int, param1String); 
          }
          
          public void onShareSucceed(int param1Int) {
            if (shareListener != null)
              shareListener.onShareSucceed(param1Int); 
          }
        };
      super(paramIShareListener);
      BlocManager.share((Activity)exception, shareContent, paramBoolean, paramInt, onShareListener);
    } 
  }
  
  public static void showActivity(Activity paramActivity) {
    try {
      BlocManager.showEntrance(paramActivity, "activity", "activity/index.html");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showBindPhoneFloat(Activity paramActivity) {
    try {
      BlocManager.setBindFloatScene(paramActivity, 0);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showClub(Activity paramActivity) {
    try {
      BlocManager.showEntranceClub(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showEntrance(Activity paramActivity, String paramString) {
    try {
      BlocManager.showEntrance(paramActivity, paramString, false);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showEntrance(Activity paramActivity, String paramString1, String paramString2) {
    try {
      BlocManager.showEntrance(paramActivity, paramString1, paramString2);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showFloatView(Activity paramActivity) {
    try {
      BlocManager.showFloatView(paramActivity, "phone");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showMatch(Activity paramActivity) {
    try {
      BlocManager.showEntranceMatch(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showMinGame(Activity paramActivity) {
    try {
      BlocManager.showEntrance(paramActivity, "mingame", "mingame/index.html");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showPray(Activity paramActivity) {
    try {
      BlocManager.showEntrance(paramActivity, "pray", "pray/index.html");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showProduceAward(Activity paramActivity) {
    try {
      BlocManager.showEntranceProduceAward(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showProduceForum(Activity paramActivity) {
    try {
      BlocManager.showEntranceProduceForum(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showProduceZone(Activity paramActivity) {
    try {
      BlocManager.showEntranceProduceZone(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showPullNew(Activity paramActivity) {
    try {
      BlocManager.showEntranceSpread(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showShop(Activity paramActivity) {
    try {
      BlocManager.showEntrance(paramActivity, "shop", "shop/index.html");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void showStrategy(Activity paramActivity) {
    try {
      BlocManager.showEntranceTactic(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void submitRoleInfo(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong1, long paramLong2) {
    try {
      int i = Integer.parseInt(paramString2);
      BlocManager.userBase((Context)paramActivity).setChannelUserId(paramString1).setGameUserId(paramString1).setServer(i, paramString3).setRole(paramString4, paramString5);
      uploadUserData(paramActivity, paramString6, paramString7, paramInt, paramLong1, paramLong2);
      BlocManager.loginSucceed(paramActivity);
    } catch (NumberFormatException numberFormatException) {
      boolean bool = false;
      BlocManager.userBase((Context)paramActivity).setChannelUserId(paramString1).setGameUserId(paramString1).setServer(bool, paramString3).setRole(paramString4, paramString5);
      uploadUserData(paramActivity, paramString6, paramString7, paramInt, paramLong1, paramLong2);
      BlocManager.loginSucceed(paramActivity);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  private static void uploadUserData(Activity paramActivity, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2) {
    try {
      fillRole(paramActivity, paramString1, paramString2, paramInt, paramLong1, paramLong2);
      CallBack<TaskRoleAttr> callBack = new CallBack<TaskRoleAttr>() {
          public void onCall(TaskRoleAttr param1TaskRoleAttr) {
            String str;
            if (param1TaskRoleAttr != null && param1TaskRoleAttr.isSuccess()) {
              str = "角色信息上报成功";
            } else {
              str = "角色信息上报失败";
            } 
            Log.d("plugin.bloc.BlocSdk", str);
          }
        };
      super();
      BlocManager.uploadGameRoleAttr(paramActivity, callBack);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\plugin\bloc\BlocSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */