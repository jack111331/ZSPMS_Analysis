package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class Tencent {
  public static final int REQUEST_LOGIN = 10001;
  
  private static Tencent b;
  
  private final c a;
  
  private Tencent(String paramString, Context paramContext) {
    this.a = c.a(paramString, paramContext);
  }
  
  private static boolean a(Context paramContext, String paramString) {
    ComponentName componentName;
    boolean bool = false;
    try {
      ComponentName componentName1 = new ComponentName();
      this(paramContext.getPackageName(), "com.tencent.tauth.AuthActivity");
      paramContext.getPackageManager().getActivityInfo(componentName1, 0);
      try {
        componentName = new ComponentName();
        this(paramContext.getPackageName(), "com.tencent.connect.common.AssistActivity");
        paramContext.getPackageManager().getActivityInfo(componentName, 0);
        bool = true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        String str = "没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档." + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>";
        f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + str);
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      String str = "没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + componentName + "\" />,详细信息请查看官网文档.";
      str = str + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + componentName + "\" />\n" + "</intent-filter>\n" + "</activity>";
      f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + str);
    } 
    return bool;
  }
  
  public static Tencent createInstance(String paramString, Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/tauth/Tencent
    //   2: monitorenter
    //   3: aload_1
    //   4: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   7: invokestatic a : (Landroid/content/Context;)V
    //   10: new java/lang/StringBuilder
    //   13: astore_2
    //   14: aload_2
    //   15: invokespecial <init> : ()V
    //   18: ldc 'openSDK_LOG.Tencent'
    //   20: aload_2
    //   21: ldc 'createInstance()  -- start, appId = '
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic com/tencent/tauth/Tencent.b : Lcom/tencent/tauth/Tencent;
    //   39: ifnonnull -> 73
    //   42: new com/tencent/tauth/Tencent
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial <init> : (Ljava/lang/String;Landroid/content/Context;)V
    //   52: aload_2
    //   53: putstatic com/tencent/tauth/Tencent.b : Lcom/tencent/tauth/Tencent;
    //   56: aload_1
    //   57: aload_0
    //   58: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   61: istore_3
    //   62: iload_3
    //   63: ifne -> 116
    //   66: aconst_null
    //   67: astore_0
    //   68: ldc com/tencent/tauth/Tencent
    //   70: monitorexit
    //   71: aload_0
    //   72: areturn
    //   73: aload_0
    //   74: getstatic com/tencent/tauth/Tencent.b : Lcom/tencent/tauth/Tencent;
    //   77: invokevirtual getAppId : ()Ljava/lang/String;
    //   80: invokevirtual equals : (Ljava/lang/Object;)Z
    //   83: ifne -> 56
    //   86: getstatic com/tencent/tauth/Tencent.b : Lcom/tencent/tauth/Tencent;
    //   89: aload_1
    //   90: invokevirtual logout : (Landroid/content/Context;)V
    //   93: new com/tencent/tauth/Tencent
    //   96: astore_2
    //   97: aload_2
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial <init> : (Ljava/lang/String;Landroid/content/Context;)V
    //   103: aload_2
    //   104: putstatic com/tencent/tauth/Tencent.b : Lcom/tencent/tauth/Tencent;
    //   107: goto -> 56
    //   110: astore_0
    //   111: ldc com/tencent/tauth/Tencent
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    //   116: aload_1
    //   117: aload_0
    //   118: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/open/utils/e;
    //   121: pop
    //   122: ldc 'openSDK_LOG.Tencent'
    //   124: ldc 'createInstance()  -- end'
    //   126: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   129: getstatic com/tencent/tauth/Tencent.b : Lcom/tencent/tauth/Tencent;
    //   132: astore_0
    //   133: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   3	56	110	finally
    //   56	62	110	finally
    //   73	107	110	finally
    //   116	133	110	finally
  }
  
  public static void handleResultData(Intent paramIntent, IUiListener paramIUiListener) {
    boolean bool2;
    boolean bool1 = true;
    StringBuilder stringBuilder = (new StringBuilder()).append("handleResultData() data = null ? ");
    if (paramIntent == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    stringBuilder = stringBuilder.append(bool2).append(", listener = null ? ");
    if (paramIUiListener == null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    f.c("openSDK_LOG.Tencent", stringBuilder.append(bool2).toString());
    UIListenerManager.getInstance().handleDataToListener(paramIntent, paramIUiListener);
  }
  
  public static boolean onActivityResultData(int paramInt1, int paramInt2, Intent paramIntent, IUiListener paramIUiListener) {
    boolean bool1 = true;
    StringBuilder stringBuilder = (new StringBuilder()).append("onActivityResultData() reqcode = ").append(paramInt1).append(", resultcode = ").append(paramInt2).append(", data = null ? ");
    if (paramIntent == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    stringBuilder = stringBuilder.append(bool2).append(", listener = null ? ");
    if (paramIUiListener == null) {
      bool2 = bool1;
      f.c("openSDK_LOG.Tencent", stringBuilder.append(bool2).toString());
      return UIListenerManager.getInstance().onActivityResult(paramInt1, paramInt2, paramIntent, paramIUiListener);
    } 
    boolean bool2 = false;
    f.c("openSDK_LOG.Tencent", stringBuilder.append(bool2).toString());
    return UIListenerManager.getInstance().onActivityResult(paramInt1, paramInt2, paramIntent, paramIUiListener);
  }
  
  public int ask(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "ask()");
    (new SocialApi(this.a.b())).ask(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }
  
  public void checkLogin(IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "checkLogin()");
    this.a.a(paramIUiListener);
  }
  
  public String getAccessToken() {
    return this.a.b().getAccessToken();
  }
  
  public String getAppId() {
    return this.a.b().getAppId();
  }
  
  public long getExpiresIn() {
    return this.a.b().getExpireTimeInSecond();
  }
  
  public String getOpenId() {
    return this.a.b().getOpenId();
  }
  
  public QQToken getQQToken() {
    return this.a.b();
  }
  
  public int gift(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "gift()");
    (new SocialApi(this.a.b())).gift(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }
  
  @Deprecated
  public void handleLoginData(Intent paramIntent, IUiListener paramIUiListener) {
    boolean bool2;
    boolean bool1 = true;
    StringBuilder stringBuilder = (new StringBuilder()).append("handleLoginData() data = null ? ");
    if (paramIntent == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    stringBuilder = stringBuilder.append(bool2).append(", listener = null ? ");
    if (paramIUiListener == null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    f.c("openSDK_LOG.Tencent", stringBuilder.append(bool2).toString());
    UIListenerManager.getInstance().handleDataToListener(paramIntent, paramIUiListener);
  }
  
  public int invite(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "invite()");
    (new SocialApi(this.a.b())).invite(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }
  
  public boolean isReady() {
    return (isSessionValid() && getOpenId() != null);
  }
  
  public boolean isSessionValid() {
    return this.a.c();
  }
  
  public boolean isSupportSSOLogin(Activity paramActivity) {
    boolean bool1 = true;
    if (i.d((Context)paramActivity) && g.a((Context)paramActivity, "com.tencent.minihd.qq") != null)
      return bool1; 
    boolean bool2 = bool1;
    if (g.c((Context)paramActivity, "4.1") < 0) {
      bool2 = bool1;
      if (g.d((Context)paramActivity, "1.1") < 0) {
        bool2 = bool1;
        if (g.e((Context)paramActivity, "1.0") < 0)
          bool2 = false; 
      } 
    } 
    return bool2;
  }
  
  public int login(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "login() with activity, scope is " + paramString);
    return this.a.a(paramActivity, paramString, paramIUiListener);
  }
  
  public int login(Fragment paramFragment, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "login() with fragment, scope is " + paramString);
    return this.a.a(paramFragment, paramString, paramIUiListener, "");
  }
  
  public int loginServerSide(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + paramString + ",server_side");
    return this.a.a(paramActivity, paramString + ",server_side", paramIUiListener);
  }
  
  public int loginServerSide(Fragment paramFragment, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + paramString + ",server_side");
    return this.a.a(paramFragment, paramString + ",server_side", paramIUiListener, "");
  }
  
  public int loginWithOEM(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2, String paramString3, String paramString4) {
    f.c("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + paramString1);
    return this.a.a(paramActivity, paramString1, paramIUiListener, paramString2, paramString3, paramString4);
  }
  
  public void logout(Context paramContext) {
    f.c("openSDK_LOG.Tencent", "logout()");
    this.a.b().setAccessToken(null, "0");
    this.a.b().setOpenId(null);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    f.c("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
    return false;
  }
  
  public void publishToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "publishToQzone()");
    (new QzonePublish((Context)paramActivity, this.a.b())).publishToQzone(paramActivity, paramBundle, paramIUiListener);
  }
  
  public int reAuth(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + paramString);
    return this.a.b(paramActivity, paramString, paramIUiListener);
  }
  
  public void releaseResource() {}
  
  public void reportDAU() {
    this.a.a();
  }
  
  public JSONObject request(String paramString1, Bundle paramBundle, String paramString2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
    f.c("openSDK_LOG.Tencent", "request()");
    return HttpUtils.request(this.a.b(), d.a(), paramString1, paramBundle, paramString2);
  }
  
  public void requestAsync(String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener, Object paramObject) {
    f.c("openSDK_LOG.Tencent", "requestAsync()");
    HttpUtils.requestAsync(this.a.b(), d.a(), paramString1, paramBundle, paramString2, paramIRequestListener);
  }
  
  public void setAccessToken(String paramString1, String paramString2) {
    f.a("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + paramString2 + "");
    this.a.a(paramString1, paramString2);
  }
  
  public void setOpenId(String paramString) {
    f.a("openSDK_LOG.Tencent", "setOpenId() --start");
    this.a.a(d.a(), paramString);
    f.a("openSDK_LOG.Tencent", "setOpenId() --end");
  }
  
  public void shareToQQ(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "shareToQQ()");
    (new QQShare((Context)paramActivity, this.a.b())).shareToQQ(paramActivity, paramBundle, paramIUiListener);
  }
  
  public void shareToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "shareToQzone()");
    (new QzoneShare((Context)paramActivity, this.a.b())).shareToQzone(paramActivity, paramBundle, paramIUiListener);
  }
  
  public int story(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.Tencent", "story()");
    (new SocialApi(this.a.b())).story(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tauth\Tencent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */