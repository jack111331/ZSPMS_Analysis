package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.cmic.sso.sdk.AuthRegisterViewConfig;
import com.cmic.sso.sdk.AuthThemeConfig;
import com.cmic.sso.sdk.a.b;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.utils.aa;
import com.cmic.sso.sdk.utils.ac;
import com.cmic.sso.sdk.utils.g;
import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.i;
import com.cmic.sso.sdk.utils.k;
import com.cmic.sso.sdk.utils.m;
import com.cmic.sso.sdk.utils.n;
import com.cmic.sso.sdk.utils.q;
import com.cmic.sso.sdk.utils.w;
import com.cmic.sso.sdk.utils.x;
import com.cmic.sso.sdk.utils.y;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthnHelper {
  public static final String SDK_VERSION = "quick_login_android_5.6.5.1";
  
  private static final String TAG = "AuthnHelper";
  
  private static AuthThemeConfig mAuthThemeConfig;
  
  @SuppressLint({"StaticFieldLeak"})
  private static AuthnHelper mInstance = null;
  
  private HashMap<String, AuthRegisterViewConfig> loginAuthMap = new HashMap<String, AuthRegisterViewConfig>();
  
  private a mAuthBusiness;
  
  private Context mContext;
  
  private Handler mHandler;
  
  private boolean smsAuthOn = false;
  
  private AuthnHelper(Context paramContext) {
    this.mHandler = new Handler(paramContext.getMainLooper());
    this.mContext = paramContext.getApplicationContext();
    this.mAuthBusiness = a.a(this.mContext);
    x.a(new x.a(this) {
          protected void a() {
            if (g.a(this.a.mContext)) {
              h.b("AuthnHelper", "生成androidkeystore成功");
              return;
            } 
            h.b("AuthnHelper", "生成androidkeystore失败");
          }
        });
  }
  
  private boolean commonInit(Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, TokenListener paramTokenListener) {
    String str1 = ac.b();
    paramBundle.putString("traceId", str1);
    k.a(str1, paramTokenListener);
    long l = System.currentTimeMillis();
    paramBundle.putString("starttime", y.a(l));
    paramBundle.putLong("starttimemills", l);
    paramBundle.putString("loginMethod", paramString3);
    paramBundle.putString("appkey", paramString2);
    paramBundle.putString("appid", paramString1);
    paramBundle.putString("timeOut", paramLong + "");
    paramBundle.putInt("logintype", paramInt);
    paramBundle.putBoolean("CLOSE_CERT_VERIFY", aa.k(this.mContext));
    if (!m.a(this.mContext, "android.permission.READ_PHONE_STATE")) {
      callBackResult("200005", "用户未授权READ_PHONE_STATE", paramBundle, null, null);
      h.a("AuthnHelper", "缺少必要权限---READ_PHONE_STATE");
      return false;
    } 
    b.a().b(this.mContext);
    paramBundle.putString("networkClass", b.a().c(this.mContext));
    paramBundle.putString("simCardNum", b.a().a(this.mContext).i() + "");
    int i = w.b(this.mContext);
    paramBundle.putInt("startnetworkType", i);
    null = n.a(this.mContext, paramBundle);
    paramBundle.putBoolean("isCacheScrip", null);
    h.b("AuthnHelper", "isCachePhoneScrip = " + null);
    paramString3 = q.a(this.mContext).a();
    String str2 = q.a(this.mContext).c();
    str1 = q.a(this.mContext).a(paramString3);
    paramBundle.putString("imei", str2);
    if (paramTokenListener == null) {
      callBackResult("200026", "listener不能为空", paramBundle, null, null);
      return false;
    } 
    if (paramString1 == null) {
      paramString1 = "";
    } else {
      paramString1 = paramString1.trim();
    } 
    if (TextUtils.isEmpty(paramString1)) {
      callBackResult("200026", "appId 不能为空", paramBundle, null, null);
      return false;
    } 
    if (paramString2 == null) {
      paramString1 = "";
    } else {
      paramString1 = paramString2.trim();
    } 
    if (TextUtils.isEmpty(paramString1)) {
      callBackResult("200026", "appkey不能为空", paramBundle, null, null);
      return false;
    } 
    if (i == 0) {
      callBackResult("200022", "未检测到网络", paramBundle, null, null);
      return false;
    } 
    if (!"1".equals(str1) && paramInt == 0) {
      callBackResult("200080", "本机号码校验仅支持移动手机号", paramBundle, null, null);
      return false;
    } 
    if ("2".equals(str1) && aa.l(this.mContext)) {
      callBackResult("200082", "服务器繁忙，请稍后重试", paramBundle, null, null);
      return false;
    } 
    if ("3".equals(str1) && aa.m(this.mContext)) {
      callBackResult("200082", "服务器繁忙，请稍后重试", paramBundle, null, null);
      return false;
    } 
    if (TextUtils.isEmpty(paramString3)) {
      paramBundle.putString("authtype", "0");
      if (paramInt == 3) {
        callBackResult("200010", "imsi获取失败或者没有sim卡，预取号失败", paramBundle, null, null);
        return false;
      } 
      if (paramInt == 1 && b.a().contains("2") && getSmsAuthOn() && aa.e(this.mContext)) {
        callBackResult("200082", "服务器繁忙，请稍后重试", paramBundle, null, null);
        return false;
      } 
      if (paramInt == 1 && b.a().contains("2") && getSmsAuthOn()) {
        paramBundle.putString("transCode", "200048");
        ac.b(this.mContext, paramBundle);
        return false;
      } 
      callBackResult("200048", "手机未安装SIM卡", paramBundle, null, null);
      return false;
    } 
    if (i == 2 && !null) {
      if (paramInt == 1 && b.a().contains("2") && getSmsAuthOn() && !aa.e(this.mContext)) {
        paramBundle.putString("transCode", "200027");
        ac.b(this.mContext, paramBundle);
        return false;
      } 
      callBackResult("200027", "无数据网络", paramBundle, null, null);
      return false;
    } 
    paramBundle.putString("imsi", paramString3);
    return true;
  }
  
  private String getCallActivity() {
    byte b = 0;
    try {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      int i = arrayOfStackTraceElement.length;
      byte b1 = 0;
      while (true) {
        if (b < i) {
          String str = arrayOfStackTraceElement[b].getClassName();
          if (TextUtils.isEmpty(str) || !str.contains("AuthnHelper")) {
            b1++;
            b++;
            continue;
          } 
        } 
        if (b1 + 2 < arrayOfStackTraceElement.length)
          stringBuilder.append(arrayOfStackTraceElement[b1 + 2].getClassName()).append(";"); 
        if (b1 + 3 < arrayOfStackTraceElement.length)
          stringBuilder.append(arrayOfStackTraceElement[b1 + 3].getClassName()).append(";"); 
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  public static AuthnHelper getInstance(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   3: ifnonnull -> 31
    //   6: ldc com/cmic/sso/sdk/auth/AuthnHelper
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   12: ifnonnull -> 28
    //   15: new com/cmic/sso/sdk/auth/AuthnHelper
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   28: ldc com/cmic/sso/sdk/auth/AuthnHelper
    //   30: monitorexit
    //   31: getstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/cmic/sso/sdk/auth/AuthnHelper
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  private boolean getSmsAuthOn() {
    return this.smsAuthOn;
  }
  
  public static void setDebugMode(boolean paramBoolean) {
    h.a(paramBoolean);
  }
  
  private void startGetPrePhonescript(String paramString, Bundle paramBundle, long paramLong) {
    a a1 = new a(this, paramBundle);
    this.mHandler.postDelayed(a1, paramLong);
    paramBundle.putString("authTypeInput", paramString);
    this.mAuthBusiness.a(paramString, paramBundle, new b(this, a1, paramBundle, paramString) {
          public void a(String param1String1, String param1String2, Bundle param1Bundle, JSONObject param1JSONObject) {
            this.d.mHandler.removeCallbacks(this.a);
            if (!k.b(param1Bundle.getString("traceId"))) {
              if (1 == param1Bundle.getInt("logintype") && "显示登录取号成功".equals(param1String2)) {
                ac.a(this.d.mContext, param1Bundle);
                return;
              } 
              if (("200012".equals(param1String1) || "200007".equals(param1String1)) && !aa.e(this.d.mContext)) {
                h.a("AuthnHelper", "短信验证码登录，进入");
                this.b.putString("transCode", param1String1);
                ac.b(this.d.mContext, param1Bundle);
                return;
              } 
              if ("200082".equals(param1String1) && this.c.contains("2") && !aa.e(this.d.mContext)) {
                h.a("AuthnHelper", "关闭业务，短信验证码登录，进入");
                this.b.putString("transCode", param1String1);
                ac.b(this.d.mContext, param1Bundle);
                return;
              } 
              this.d.callBackResult(param1String1, param1String2, param1Bundle, param1JSONObject, null);
            } 
          }
        });
  }
  
  public void SMSAuthOn(boolean paramBoolean) {
    this.smsAuthOn = paramBoolean;
  }
  
  public AuthnHelper addAuthRegistViewConfig(String paramString, AuthRegisterViewConfig paramAuthRegisterViewConfig) {
    try {
      if (this.loginAuthMap == null) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        this();
        this.loginAuthMap = (HashMap)hashMap;
      } 
      this.loginAuthMap.put(paramString, paramAuthRegisterViewConfig);
    } catch (Exception exception) {
      exception.printStackTrace();
      h.a("AuthnHelper", "动态添加控件失败");
    } 
    return this;
  }
  
  public void callBackResult(String paramString1, String paramString2, Bundle paramBundle, JSONObject paramJSONObject, Throwable paramThrowable) {
    // Byte code:
    //   0: aload_3
    //   1: ldc 'traceId'
    //   3: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   6: astore #6
    //   8: aload_3
    //   9: ldc_w 'SDKRequestCode'
    //   12: iconst_m1
    //   13: invokevirtual getInt : (Ljava/lang/String;I)I
    //   16: istore #7
    //   18: aload #6
    //   20: invokestatic a : (Ljava/lang/String;)Z
    //   23: ifne -> 147
    //   26: aload_0
    //   27: monitorenter
    //   28: aload #6
    //   30: invokestatic e : (Ljava/lang/String;)Lcom/cmic/sso/sdk/auth/TokenListener;
    //   33: astore #8
    //   35: aload #6
    //   37: invokestatic d : (Ljava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload #8
    //   44: ifnull -> 117
    //   47: aload_3
    //   48: ldc 'logintype'
    //   50: iconst_m1
    //   51: invokevirtual getInt : (Ljava/lang/String;I)I
    //   54: istore #9
    //   56: aload #4
    //   58: ifnonnull -> 177
    //   61: aload_1
    //   62: aload_2
    //   63: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   66: astore #4
    //   68: aload #4
    //   70: astore #6
    //   72: iload #9
    //   74: iconst_3
    //   75: if_icmpeq -> 88
    //   78: aload_1
    //   79: aload_2
    //   80: aload_3
    //   81: aload #4
    //   83: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   86: astore #6
    //   88: aload_0
    //   89: getfield mHandler : Landroid/os/Handler;
    //   92: astore_2
    //   93: new com/cmic/sso/sdk/auth/AuthnHelper$6
    //   96: astore #4
    //   98: aload #4
    //   100: aload_0
    //   101: aload #8
    //   103: iload #7
    //   105: aload #6
    //   107: invokespecial <init> : (Lcom/cmic/sso/sdk/auth/AuthnHelper;Lcom/cmic/sso/sdk/auth/TokenListener;ILorg/json/JSONObject;)V
    //   110: aload_2
    //   111: aload #4
    //   113: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   116: pop
    //   117: aload_0
    //   118: getfield mContext : Landroid/content/Context;
    //   121: invokestatic n : (Landroid/content/Context;)Z
    //   124: ifne -> 147
    //   127: new com/cmic/sso/sdk/c/b
    //   130: astore_2
    //   131: aload_2
    //   132: invokespecial <init> : ()V
    //   135: aload_2
    //   136: aload_0
    //   137: getfield mContext : Landroid/content/Context;
    //   140: aload_1
    //   141: aload_3
    //   142: aload #5
    //   144: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Throwable;)V
    //   147: invokestatic a : ()Z
    //   150: ifeq -> 163
    //   153: aload_0
    //   154: getfield mContext : Landroid/content/Context;
    //   157: invokestatic a : (Landroid/content/Context;)Lcom/cmic/sso/sdk/utils/ad;
    //   160: invokevirtual a : ()V
    //   163: return
    //   164: astore_1
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual printStackTrace : ()V
    //   174: goto -> 163
    //   177: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   0	28	169	java/lang/Exception
    //   28	42	164	finally
    //   47	56	169	java/lang/Exception
    //   61	68	169	java/lang/Exception
    //   78	88	169	java/lang/Exception
    //   88	117	169	java/lang/Exception
    //   117	147	169	java/lang/Exception
    //   147	163	169	java/lang/Exception
    //   165	167	164	finally
    //   167	169	169	java/lang/Exception
  }
  
  public void delScrip() {
    try {
      n.a(this.mContext, true);
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
    } 
  }
  
  public HashMap<String, AuthRegisterViewConfig> getAuthRegistViewConfigList() {
    return this.loginAuthMap;
  }
  
  public AuthThemeConfig getAuthThemeConfig() {
    if (mAuthThemeConfig == null)
      mAuthThemeConfig = (new AuthThemeConfig.Builder()).build(); 
    return mAuthThemeConfig;
  }
  
  public JSONObject getNetworkType(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      if (!m.a(paramContext, "android.permission.READ_PHONE_STATE")) {
        h.a("AuthnHelper", "用户未授权READ_PHONE_STATE");
        jSONObject.put("errorDes", "用户未授权READ_PHONE_STATE");
        return jSONObject;
      } 
      b.a().b(paramContext);
      int i = w.a(paramContext);
      int j = w.b(paramContext);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      jSONObject.put("operatorType", stringBuilder.append(i).append("").toString());
      stringBuilder = new StringBuilder();
      this();
      jSONObject.put("networkType", stringBuilder.append(j).append("").toString());
      stringBuilder = new StringBuilder();
      this();
      h.c("AuthnHelper", stringBuilder.append("网络类型: ").append(j).toString());
      stringBuilder = new StringBuilder();
      this();
      h.c("AuthnHelper", stringBuilder.append("运营商类型: ").append(i).toString());
    } catch (Exception exception) {}
    return jSONObject;
  }
  
  public void getPhoneInfo(String paramString1, String paramString2, long paramLong, TokenListener paramTokenListener) {
    getPhoneInfo(paramString1, paramString2, paramLong, paramTokenListener, -1);
  }
  
  public void getPhoneInfo(String paramString1, String paramString2, long paramLong, TokenListener paramTokenListener, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "general");
    bundle.putString("caller", getCallActivity());
    bundle.putLong("methodTimes", System.currentTimeMillis());
    x.a(new x.a(this, this.mContext, bundle, bundle, paramString1, paramString2, paramLong, paramTokenListener) {
          protected void a() {
            long l1 = 8000L;
            AuthnHelper authnHelper = this.f;
            Bundle bundle1 = this.a;
            String str1 = this.b;
            String str2 = this.c;
            if (this.d >= 2000L && this.d <= 8000L) {
              l2 = this.d;
            } else {
              l2 = 8000L;
            } 
            if (authnHelper.commonInit(bundle1, str1, str2, "preGetMobile", 3, l2, this.e)) {
              StringBuilder stringBuilder = (new StringBuilder()).append("超时时间：");
              if (this.d >= 2000L && this.d <= 8000L) {
                l2 = this.d;
              } else {
                l2 = 8000L;
              } 
              h.a("AuthnHelper", stringBuilder.append(l2).toString());
              if (aa.f(this.f.mContext)) {
                this.f.callBackResult("200082", "服务器繁忙，请稍后重试", this.a, null, null);
                return;
              } 
            } else {
              return;
            } 
            authnHelper = this.f;
            Bundle bundle2 = this.a;
            long l2 = l1;
            if (this.d >= 2000L) {
              l2 = l1;
              if (this.d <= 8000L)
                l2 = this.d; 
            } 
            authnHelper.startGetPrePhonescript(String.valueOf(3), bundle2, l2);
          }
        });
  }
  
  public void loginAuth(String paramString1, String paramString2, TokenListener paramTokenListener) {
    loginAuth(paramString1, paramString2, paramTokenListener, -1);
  }
  
  public void loginAuth(String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "login");
    bundle.putString("caller", getCallActivity());
    bundle.putLong("methodTimes", System.currentTimeMillis());
    x.a(new x.a(this, this.mContext, bundle, bundle, paramString1, paramString2, paramTokenListener) {
          protected void a() {
            if (this.e.commonInit(this.a, this.b, this.c, "loginAuth", 1, 8000L, this.d)) {
              if (aa.f(this.e.mContext)) {
                this.e.callBackResult("200082", "服务器繁忙，请稍后重试", this.a, null, null);
                return;
              } 
            } else {
              return;
            } 
            String str = String.valueOf(3);
            if (this.e.getSmsAuthOn())
              str = String.valueOf(3) + String.valueOf(2); 
            h.a("AuthnHelper", "超时时间：8000");
            this.e.startGetPrePhonescript(str, this.a, 8000L);
          }
        });
  }
  
  public void mobileAuth(String paramString1, String paramString2, TokenListener paramTokenListener) {
    mobileAuth(paramString1, paramString2, paramTokenListener, -1);
  }
  
  public void mobileAuth(String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "authentication");
    bundle.putLong("methodTimes", System.currentTimeMillis());
    x.a(new x.a(this, this.mContext, bundle, bundle, paramString1, paramString2, paramTokenListener) {
          protected void a() {
            if (this.e.commonInit(this.a, this.b, this.c, "mobileAuth", 0, 8000L, this.d)) {
              h.a("AuthnHelper", "超时时间：8000");
              if (aa.d(this.e.mContext)) {
                this.e.callBackResult("200082", "服务器繁忙，请稍后重试", this.a, null, null);
                return;
              } 
            } else {
              return;
            } 
            this.e.startGetPrePhonescript(String.valueOf(3), this.a, 8000L);
          }
        });
  }
  
  public void quitAuthActivity() {
    try {
      if (i.a().b() != null)
        i.a().b().a(); 
    } catch (Exception exception) {
      exception.printStackTrace();
      h.a("AuthnHelper", "关闭授权页失败");
    } 
  }
  
  public void quitSmsActivity() {
    try {
      if (i.a().c() != null)
        i.a().c().a(); 
    } catch (Exception exception) {
      exception.printStackTrace();
      h.a("AuthnHelper", "关闭短验页失败");
    } 
  }
  
  public void removeAuthRegisterViewConfig() {
    try {
      this.loginAuthMap = null;
    } catch (Exception exception) {
      exception.printStackTrace();
      h.a("AuthnHelper", "清除失败");
    } 
  }
  
  public void setAuthThemeConfig(AuthThemeConfig paramAuthThemeConfig) {
    mAuthThemeConfig = paramAuthThemeConfig;
  }
  
  private class a implements Runnable {
    private Bundle b;
    
    a(AuthnHelper this$0, Bundle param1Bundle) {
      this.b = param1Bundle;
    }
    
    public void run() {
      if (1 == this.b.getInt("logintype") && b.a().contains("2") && this.b.getString("authTypeInput", "").contains("2") && !aa.e(this.a.mContext)) {
        h.a("AuthnHelper", "短信验证码登录，进入");
        k.c(this.b.getString("traceId"));
        this.b.putString("transCode", "200023");
        ac.b(this.a.mContext, this.b);
        return;
      } 
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("resultCode", "200023");
        jSONObject.put("resultString", "登录超时");
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      this.a.callBackResult("200023", "登录超时", this.b, jSONObject, null);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\auth\AuthnHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */