package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.connect.a.a;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.tauth.IUiListener;

public class c {
  private AuthAgent a;
  
  private QQToken b;
  
  private c(String paramString, Context paramContext) {
    f.c("openSDK_LOG.QQAuth", "new QQAuth() --start");
    this.b = new QQToken(paramString);
    this.a = new AuthAgent(this.b);
    a.c(paramContext, this.b);
    f.c("openSDK_LOG.QQAuth", "new QQAuth() --end");
  }
  
  private int a(Activity paramActivity, Fragment paramFragment, String paramString1, IUiListener paramIUiListener, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   4: invokevirtual getPackageName : ()Ljava/lang/String;
    //   7: astore #5
    //   9: aload_1
    //   10: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   13: astore #6
    //   15: aload #6
    //   17: sipush #128
    //   20: invokevirtual getInstalledApplications : (I)Ljava/util/List;
    //   23: invokeinterface iterator : ()Ljava/util/Iterator;
    //   28: astore #6
    //   30: aload #6
    //   32: invokeinterface hasNext : ()Z
    //   37: ifeq -> 198
    //   40: aload #6
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast android/content/pm/ApplicationInfo
    //   50: astore #7
    //   52: aload #5
    //   54: aload #7
    //   56: getfield packageName : Ljava/lang/String;
    //   59: invokevirtual equals : (Ljava/lang/Object;)Z
    //   62: ifeq -> 30
    //   65: aload #7
    //   67: getfield sourceDir : Ljava/lang/String;
    //   70: astore #5
    //   72: aload #5
    //   74: ifnull -> 169
    //   77: new java/io/File
    //   80: astore #6
    //   82: aload #6
    //   84: aload #5
    //   86: invokespecial <init> : (Ljava/lang/String;)V
    //   89: aload #6
    //   91: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   94: astore #6
    //   96: aload #6
    //   98: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   101: ifne -> 169
    //   104: new java/lang/StringBuilder
    //   107: astore #5
    //   109: aload #5
    //   111: invokespecial <init> : ()V
    //   114: ldc 'openSDK_LOG.QQAuth'
    //   116: aload #5
    //   118: ldc '-->login channelId: '
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload #6
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: aload_1
    //   136: aload_3
    //   137: aload #4
    //   139: aload #6
    //   141: aload #6
    //   143: ldc ''
    //   145: invokevirtual a : (Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/tauth/IUiListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   148: istore #8
    //   150: iload #8
    //   152: ireturn
    //   153: astore #5
    //   155: ldc 'openSDK_LOG.QQAuth'
    //   157: ldc '-->login get channel id exception.'
    //   159: aload #5
    //   161: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload #5
    //   166: invokevirtual printStackTrace : ()V
    //   169: ldc 'openSDK_LOG.QQAuth'
    //   171: ldc '-->login channelId is null '
    //   173: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   176: iconst_0
    //   177: putstatic com/tencent/connect/common/BaseApi.isOEM : Z
    //   180: aload_0
    //   181: getfield a : Lcom/tencent/connect/auth/AuthAgent;
    //   184: aload_1
    //   185: aload_3
    //   186: aload #4
    //   188: iconst_0
    //   189: aload_2
    //   190: invokevirtual doLogin : (Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/tauth/IUiListener;ZLandroid/support/v4/app/Fragment;)I
    //   193: istore #8
    //   195: goto -> 150
    //   198: aconst_null
    //   199: astore #5
    //   201: goto -> 72
    // Exception table:
    //   from	to	target	type
    //   15	30	153	java/lang/Throwable
    //   30	72	153	java/lang/Throwable
    //   77	150	153	java/lang/Throwable
  }
  
  public static c a(String paramString, Context paramContext) {
    d.a(paramContext.getApplicationContext());
    f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      ComponentName componentName = new ComponentName();
      this(paramContext.getPackageName(), "com.tencent.tauth.AuthActivity");
      packageManager.getActivityInfo(componentName, 0);
      componentName = new ComponentName();
      this(paramContext.getPackageName(), "com.tencent.connect.common.AssistActivity");
      packageManager.getActivityInfo(componentName, 0);
      c c1 = new c(paramString, paramContext);
      f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      f.b("openSDK_LOG.QQAuth", "createInstance() error --end", (Throwable)nameNotFoundException);
      Toast.makeText(paramContext.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
      nameNotFoundException = null;
    } 
    return (c)nameNotFoundException;
  }
  
  public int a(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQAuth", "login()");
    return a(paramActivity, paramString, paramIUiListener, "");
  }
  
  public int a(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2) {
    f.c("openSDK_LOG.QQAuth", "-->login activity: " + paramActivity);
    return a(paramActivity, null, paramString1, paramIUiListener, paramString2);
  }
  
  @Deprecated
  public int a(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2, String paramString3, String paramString4) {
    f.c("openSDK_LOG.QQAuth", "loginWithOEM");
    BaseApi.isOEM = true;
    String str = paramString2;
    if (paramString2.equals(""))
      str = "null"; 
    paramString2 = paramString3;
    if (paramString3.equals(""))
      paramString2 = "null"; 
    paramString3 = paramString4;
    if (paramString4.equals(""))
      paramString3 = "null"; 
    BaseApi.installChannel = paramString2;
    BaseApi.registerChannel = str;
    BaseApi.businessId = paramString3;
    return this.a.doLogin(paramActivity, paramString1, paramIUiListener);
  }
  
  public int a(Fragment paramFragment, String paramString1, IUiListener paramIUiListener, String paramString2) {
    FragmentActivity fragmentActivity = paramFragment.getActivity();
    f.c("openSDK_LOG.QQAuth", "-->login activity: " + fragmentActivity);
    return a((Activity)fragmentActivity, paramFragment, paramString1, paramIUiListener, paramString2);
  }
  
  public void a() {
    this.a.a((IUiListener)null);
  }
  
  public void a(Context paramContext, String paramString) {
    f.a("openSDK_LOG.QQAuth", "setOpenId() --start");
    this.b.setOpenId(paramString);
    a.d(paramContext, this.b);
    f.a("openSDK_LOG.QQAuth", "setOpenId() --end");
  }
  
  public void a(IUiListener paramIUiListener) {
    this.a.b(paramIUiListener);
  }
  
  public void a(String paramString1, String paramString2) {
    f.a("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + paramString2 + "");
    this.b.setAccessToken(paramString1, paramString2);
  }
  
  public int b(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQAuth", "reAuth()");
    return this.a.doLogin(paramActivity, paramString, paramIUiListener, true, null);
  }
  
  public QQToken b() {
    return this.b;
  }
  
  public boolean c() {
    StringBuilder stringBuilder = (new StringBuilder()).append("isSessionValid(), result = ");
    if (this.b.isSessionValid()) {
      String str1 = "true";
      f.a("openSDK_LOG.QQAuth", stringBuilder.append(str1).append("").toString());
      return this.b.isSessionValid();
    } 
    String str = "false";
    f.a("openSDK_LOG.QQAuth", stringBuilder.append(str).append("").toString());
    return this.b.isSessionValid();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\auth\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */