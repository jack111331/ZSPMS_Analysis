package com.haru.herousdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.herosdk.HeroSdk;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.listener.IExitListener;
import com.herosdk.listener.IInitListener;
import com.herosdk.listener.IKickListener;
import com.herosdk.listener.ILoginListener;
import com.herosdk.listener.ILogoutListener;
import com.herosdk.listener.IPayListener;
import com.herosdk.listener.ISwitchAccountListener;
import com.unity3d.player.UnityPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class HeroSdKAgent {
  private static Activity MainActivity;
  
  private static String SendMsgObj = "SdkAgent";
  
  public static void Init(Activity paramActivity) {
    MainActivity = paramActivity;
    addInitListener();
    addLoginListener();
    addSwitchAccountListener();
    addPayListener();
    addLogoutListener();
    addKickListener();
    addExitListener();
  }
  
  private static void addExitListener() {
    HeroSdk.getInstance().setExitListener(new IExitListener() {
          public void onFailed(String param1String) {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnExitFailed", param1String);
          }
          
          public void onSuccess() {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnExitSuccess", "");
            HeroSdKAgent.MainActivity.finish();
            System.exit(0);
          }
        });
  }
  
  private static void addInitListener() {
    HeroSdk.getInstance().setInitListener(new IInitListener() {
          public void onFailed(String param1String) {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnInitFailed", param1String);
          }
          
          public void onSuccess() {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnInitSuccess", "");
          }
        });
  }
  
  private static void addKickListener() {
    HeroSdk.getInstance().setKickListener(new IKickListener() {
          public void onKick(int param1Int, String param1String) {
            if (param1Int == 0) {
              String str = param1String;
              if (param1String == null)
                str = ""; 
              UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnSdkKickOff", str);
            } 
          }
        });
  }
  
  private static void addLoginListener() {
    HeroSdk.getInstance().setLoginListener(new ILoginListener() {
          public void onCancel() {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnLoginCancel", "");
          }
          
          public void onFailed(String param1String) {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnLoginFailed", param1String);
          }
          
          public void onSuccess(UserInfo param1UserInfo) {
            JSONObject jSONObject = new JSONObject();
            try {
              jSONObject.put("uid", param1UserInfo.getUid());
              jSONObject.put("username", param1UserInfo.getUsername());
              jSONObject.put("token", param1UserInfo.getToken());
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
            } 
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnLoginSuccess", jSONObject.toString());
          }
        });
  }
  
  private static void addLogoutListener() {
    HeroSdk.getInstance().setLogoutListener(new ILogoutListener() {
          public void onFailed(String param1String) {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnLogoutFailed", param1String);
          }
          
          public void onSuccess() {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnLogoutSuccess", "");
          }
        });
  }
  
  private static void addPayListener() {
    HeroSdk.getInstance().setPayListener(new IPayListener() {
          public void onCancel(String param1String) {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnPayCancel", param1String);
          }
          
          public void onFailed(String param1String1, String param1String2) {
            JSONObject jSONObject = new JSONObject();
            try {
              jSONObject.put("cpOrderId", param1String1);
              jSONObject.put("msg", param1String2);
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
            } 
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnPayFailed", jSONObject.toString());
          }
          
          public void onSuccess(String param1String1, String param1String2, String param1String3) {
            JSONObject jSONObject = new JSONObject();
            try {
              jSONObject.put("sdkOrderId", param1String1);
              jSONObject.put("cpOrderId", param1String2);
              jSONObject.put("extraParams", param1String3);
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
            } 
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnPaySuccess", jSONObject.toString());
          }
        });
  }
  
  private static void addSwitchAccountListener() {
    HeroSdk.getInstance().setSwitchAccountListener(new ISwitchAccountListener() {
          public void onCancel() {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnSwitchAccountCancel", "");
          }
          
          public void onFailed(String param1String) {
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnSwitchAccountFailed", param1String);
          }
          
          public void onSuccess(UserInfo param1UserInfo) {
            JSONObject jSONObject = new JSONObject();
            try {
              jSONObject.put("uid", param1UserInfo.getUid());
              jSONObject.put("username", param1UserInfo.getUsername());
              jSONObject.put("token", param1UserInfo.getToken());
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
            } 
            UnityPlayer.UnitySendMessage(HeroSdKAgent.SendMsgObj, "OnSwitchAccountSuccess", jSONObject.toString());
          }
        });
  }
  
  public static void createNewRole(RoleInfo paramRoleInfo) {
    HeroSdk.getInstance().createNewRole(MainActivity, paramRoleInfo);
  }
  
  public static void enterGame(RoleInfo paramRoleInfo) {
    HeroSdk.getInstance().enterGame(MainActivity, paramRoleInfo);
  }
  
  public static void exit() {
    if (HeroSdk.getInstance().isChannelHasExitDialog().booleanValue()) {
      HeroSdk.getInstance().exit(MainActivity);
    } else {
      (new AlertDialog.Builder((Context)MainActivity)).setTitle("退出").setMessage("确定退出游戏？").setCancelable(true).setPositiveButton("退出", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              HeroSdk.getInstance().exit(HeroSdKAgent.MainActivity);
            }
          }).setNeutralButton("取消", null).show();
    } 
  }
  
  public static String getAppChannelId() {
    return HeroSdk.getInstance().getProjectId(MainActivity);
  }
  
  public static String getAppProjectId() {
    return HeroSdk.getInstance().getProjectId(MainActivity);
  }
  
  public static int getChannelId() {
    return HeroSdk.getInstance().getChannelId();
  }
  
  public static String getChannelName() {
    return HeroSdk.getInstance().getChannelName();
  }
  
  public static void initWithProduct(String paramString1, String paramString2) {
    HeroSdk.getInstance().init(MainActivity, paramString1, paramString2);
  }
  
  public static boolean isLogined() {
    boolean bool;
    if (HeroSdk.getInstance().getUserInfo() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static void login() {
    HeroSdk.getInstance().login(MainActivity);
  }
  
  public static void logout() {
    HeroSdk.getInstance().logout(MainActivity);
  }
  
  public static void notifyKickResult(int paramInt) {
    String str;
    if (paramInt == 0) {
      str = "1";
    } else {
      str = "0";
    } 
    HeroSdk.getInstance().notifyKickResult(str);
  }
  
  public static void pay(OrderInfo paramOrderInfo, RoleInfo paramRoleInfo) {
    HeroSdk.getInstance().pay(MainActivity, paramOrderInfo, paramRoleInfo);
  }
  
  public static void roleLevelUp(RoleInfo paramRoleInfo) {
    HeroSdk.getInstance().roleLevelUp(MainActivity, paramRoleInfo);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\haru\herousdk\HeroSdKAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */