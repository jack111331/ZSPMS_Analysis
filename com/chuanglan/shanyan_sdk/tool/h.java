package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;
import android.os.SystemClock;
import com.chuanglan.shanyan_sdk.OneKeyLoginManager;
import com.chuanglan.shanyan_sdk.b;
import com.chuanglan.shanyan_sdk.utils.AbActivityUtils;
import com.chuanglan.shanyan_sdk.utils.AbObtainUtil;
import com.chuanglan.shanyan_sdk.utils.AbScreenUtils;
import com.chuanglan.shanyan_sdk.utils.AbUniqueCodeUtil;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.AppSysMgr;
import com.chuanglan.shanyan_sdk.utils.Base64;
import com.chuanglan.shanyan_sdk.utils.L;
import com.chuanglan.shanyan_sdk.utils.MultiClickUtilstwo;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.sdk.base.api.UiOauthListener;
import com.sdk.base.framework.bean.OauthResultMode;
import com.sdk.mobile.manager.login.a.c;
import com.sdk.mobile.manager.login.b;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
  public static boolean a;
  
  private static h b = null;
  
  private Context c;
  
  private AuthnHelper d;
  
  private a e;
  
  private com.sdk.mobile.c.a f;
  
  private boolean g = false;
  
  private String h = null;
  
  private String i = null;
  
  private String j = null;
  
  static {
    a = false;
  }
  
  public static h a() {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/h.b : Lcom/chuanglan/shanyan_sdk/tool/h;
    //   3: ifnonnull -> 30
    //   6: ldc com/chuanglan/shanyan_sdk/tool/h
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/h.b : Lcom/chuanglan/shanyan_sdk/tool/h;
    //   12: ifnonnull -> 27
    //   15: new com/chuanglan/shanyan_sdk/tool/h
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/chuanglan/shanyan_sdk/tool/h.b : Lcom/chuanglan/shanyan_sdk/tool/h;
    //   27: ldc com/chuanglan/shanyan_sdk/tool/h
    //   29: monitorexit
    //   30: getstatic com/chuanglan/shanyan_sdk/tool/h.b : Lcom/chuanglan/shanyan_sdk/tool/h;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/chuanglan/shanyan_sdk/tool/h
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private String a(OauthResultMode paramOauthResultMode) {
    JSONObject jSONObject = new JSONObject();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      jSONObject.put("code", stringBuilder.append(paramOauthResultMode.getCode()).append("").toString());
      stringBuilder = new StringBuilder();
      this();
      jSONObject.put("status", stringBuilder.append(paramOauthResultMode.getStatus()).append("").toString());
      if (paramOauthResultMode.getMsg() != null)
        jSONObject.put("msg", paramOauthResultMode.getMsg()); 
      if (paramOauthResultMode.getObject() != null)
        jSONObject.put("obj", paramOauthResultMode.getObject()); 
      if (paramOauthResultMode.getSeq() != null)
        jSONObject.put("seq", paramOauthResultMode.getSeq()); 
    } catch (Exception exception) {
      exception.printStackTrace();
      a(1014, "CUCCtoJsonString" + exception.toString(), 4, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.K);
    } 
    return jSONObject.toString();
  }
  
  private void a(String paramString1, String paramString2, com.sdk.mobile.c.a parama, boolean paramBoolean) {
    try {
      String str2 = (String)SPTool.get(this.c, "appId", "");
      String str3 = (String)SPTool.get(this.c, "appKey", "");
      this.f = parama;
      String str4 = AbUniqueCodeUtil.getNetworkTime();
      String str1 = AbUniqueCodeUtil.getUUID();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      String str5 = stringBuilder.append("device=").append(AppSysMgr.getManufacturer()).append("|ip=").append(AppSysMgr.getIP(this.c)).append("|DID=").append(SPTool.get(this.c, "DID", "")).append("|uuid=").append(SPTool.get(this.c, "uuid", "")).toString();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      hashMap.put("appId", str2);
      hashMap.put("accessToken", paramString2);
      hashMap.put("telecom", paramString1);
      hashMap.put("timestamp", str4);
      hashMap.put("randoms", str1);
      hashMap.put("version", "2.2.1");
      hashMap.put("device", Base64.encode(str5.getBytes()));
      str3 = AbObtainUtil.getSign(hashMap, str3);
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("appId", str2);
      jSONObject.put("accessToken", paramString2);
      jSONObject.put("telecom", paramString1);
      jSONObject.put("timestamp", str4);
      jSONObject.put("randoms", str1);
      jSONObject.put("device", Base64.encode(str5.getBytes()));
      jSONObject.put("version", "2.2.1");
      jSONObject.put("sign", str3);
      a(1000, jSONObject.toString(), paramString2, SystemClock.uptimeMillis() - b.O);
      if (paramBoolean) {
        b();
        if (this.d != null)
          this.d.quitAuthActivity(); 
      } 
    } catch (JSONException jSONException) {
      a(1014, "getMobileNum()" + jSONException.toString(), 3, "1014", jSONException.getClass().getName(), SystemClock.uptimeMillis() - b.O);
    } 
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean) {
    String str1 = (String)SPTool.get(this.c, "ctcc_number", "");
    String str2 = (String)SPTool.get(this.c, "ctcc_accessCode", "");
    String str3 = (String)SPTool.get(this.c, "SIMSerial", "");
    String str4 = (String)SPTool.get(this.c, "SIMOperator", "");
    if (AppStringUtils.isNotEmpty(str1) && AppStringUtils.isNotEmpty(str2) && AppStringUtils.isNotEmpty(AppSysMgr.getSIMSerial(this.c)) && AppSysMgr.getSIMSerial(this.c).equals(str3) && AppStringUtils.isNotEmpty(AppSysMgr.getOperatorType(this.c)) && AppSysMgr.getOperatorType(this.c).equals(str4) && System.currentTimeMillis() < ((Long)SPTool.get(this.c, "timeend", Long.valueOf(1L))).longValue()) {
      if (OneKeyLoginManager.getInstance().getPreIntStatus()) {
        if (AppStringUtils.isEmpty((String)SPTool.get(this.c, "uuid", ""))) {
          str4 = AbUniqueCodeUtil.getUUID();
          SPTool.put(this.c, "uuid", str4);
        } 
        OneKeyLoginManager.getInstance().setAuthThemeConfig();
        AbActivityUtils.startShanYanOneKeyActivity(this.c, str2, str1, paramString1, paramString2, paramBoolean);
        return;
      } 
      a(1031, "预取号请求频繁", 3, "1031", "预取号请求频繁", SystemClock.uptimeMillis() - b.K);
      return;
    } 
    k.a().a(3);
  }
  
  private void a(boolean paramBoolean) {
    String str1 = (String)SPTool.get(this.c, "SIMSerial", "");
    String str2 = (String)SPTool.get(this.c, "SIMOperator", "");
    if (AppStringUtils.isNotEmpty(AppSysMgr.getSIMSerial(this.c)) && AppSysMgr.getSIMSerial(this.c).equals(str1) && AppStringUtils.isNotEmpty(AppSysMgr.getOperatorType(this.c)) && AppSysMgr.getOperatorType(this.c).equals(str2) && System.currentTimeMillis() < ((Long)SPTool.get(this.c, "timeend", Long.valueOf(1L))).longValue()) {
      if (AppStringUtils.isEmpty((String)SPTool.get(this.c, "uuid", ""))) {
        str2 = AbUniqueCodeUtil.getUUID();
        SPTool.put(this.c, "uuid", str2);
      } 
      if (OneKeyLoginManager.getInstance().getPreIntStatus()) {
        OneKeyLoginManager.getInstance().setAuthThemeConfig();
        b(paramBoolean);
        return;
      } 
      a(1031, "预取号请求频繁", 2, "1031", "预取号请求频繁", SystemClock.uptimeMillis() - b.K);
      return;
    } 
    k.a().a(3);
  }
  
  private String b(OauthResultMode paramOauthResultMode) {
    JSONObject jSONObject = new JSONObject();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      jSONObject.put("code", stringBuilder.append(paramOauthResultMode.getCode()).append("").toString());
      stringBuilder = new StringBuilder();
      this();
      jSONObject.put("status", stringBuilder.append(paramOauthResultMode.getStatus()).append("").toString());
      if (paramOauthResultMode.getMsg() != null)
        jSONObject.put("msg", paramOauthResultMode.getMsg()); 
      if (paramOauthResultMode.getSeq() != null)
        jSONObject.put("seq", paramOauthResultMode.getSeq()); 
    } catch (Exception exception) {
      exception.printStackTrace();
      a(1014, "CUCCtoJsonString" + exception.toString(), 4, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.K);
    } 
    return jSONObject.toString();
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean) {
    a = true;
    b.Q = SystemClock.uptimeMillis();
    this.d.loginAuth(paramString1, paramString2, new TokenListener(this, paramBoolean) {
          public void onGetTokenComplete(int param1Int, JSONObject param1JSONObject) {
            if (h.a) {
              h.a = false;
              if (param1JSONObject != null) {
                try {
                  if (param1JSONObject.has("resultCode")) {
                    Thread thread;
                    param1Int = param1JSONObject.optInt("resultCode");
                    if (param1JSONObject.has("token") && param1Int == 103000) {
                      String str1 = param1JSONObject.optString("token");
                      thread = new Thread();
                      Runnable runnable = new Runnable() {
                          public void run() {
                            h.a(this.b.b, "CMCC", this.a, null, this.b.a);
                          }
                        };
                      super(this, str1);
                      this(runnable);
                      thread.start();
                      return;
                    } 
                    if (param1Int == 102101 || param1Int == 102102 || param1Int == 102103 || param1Int == 200025 || param1Int == 102507) {
                      h h3 = this.b;
                      StringBuilder stringBuilder3 = new StringBuilder();
                      this();
                      String str1 = stringBuilder3.append("loginAuth()").append(thread.toString()).toString();
                      stringBuilder3 = new StringBuilder();
                      this();
                      h3.a(1007, str1, 4, stringBuilder3.append(param1Int).append("").toString(), AbActivityUtils.getCMCCResMsg((JSONObject)thread), SystemClock.uptimeMillis() - b.K);
                      if (this.a && h.h(this.b) != null)
                        h.h(this.b).quitAuthActivity(); 
                      return;
                    } 
                    if (param1Int == 200020) {
                      h h3 = this.b;
                      StringBuilder stringBuilder3 = new StringBuilder();
                      this();
                      h3.a(1011, "点击返回，用户取消免密登录", 4, stringBuilder3.append(param1Int).append("").toString(), thread.toString(), SystemClock.uptimeMillis() - b.K);
                      return;
                    } 
                    h h2 = this.b;
                    StringBuilder stringBuilder1 = new StringBuilder();
                    this();
                    String str = stringBuilder1.append("loginAuth()").append(thread.toString()).toString();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    this();
                    h2.a(1003, str, 4, stringBuilder2.append(param1Int).append("").toString(), AbActivityUtils.getCMCCResMsg((JSONObject)thread), SystemClock.uptimeMillis() - b.K);
                    if (this.a && h.h(this.b) != null)
                      h.h(this.b).quitAuthActivity(); 
                    return;
                  } 
                } catch (Exception exception) {
                  exception.printStackTrace();
                  this.b.a(1014, "loginAuth()" + exception.toString(), 4, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.K);
                  if (this.a && h.h(this.b) != null)
                    h.h(this.b).quitAuthActivity(); 
                  return;
                } 
                h h1 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                this();
                h1.a(1003, stringBuilder.append("loginAuth()").append(exception.toString()).toString(), 4, "1003", AbActivityUtils.getCMCCResMsg((JSONObject)exception), SystemClock.uptimeMillis() - b.K);
                if (this.a && h.h(this.b) != null)
                  h.h(this.b).quitAuthActivity(); 
                return;
              } 
            } else {
              return;
            } 
            this.b.a(1003, "loginAuth()SDK获取token失败", 4, "1003", "SDK获取token失败", SystemClock.uptimeMillis() - b.K);
            if (this.a && h.h(this.b) != null)
              h.h(this.b).quitAuthActivity(); 
          }
        });
  }
  
  private void b(boolean paramBoolean) {
    b.Q = SystemClock.uptimeMillis();
    b b = new b();
    b.a(true);
    b.b(false);
    b.a(new c(AbScreenUtils.dp2px(this.c, 100.0F), AbScreenUtils.dp2px(this.c, 100.0F), 0, -16776961));
    b.c(true);
    this.g = true;
    SPTool.put(this.c, "timeend", Long.valueOf(0L));
    com.sdk.mobile.manager.login.cucc.a.a(this.c).a(b, new UiOauthListener(this, paramBoolean) {
          public void onFailed(OauthResultMode param1OauthResultMode, com.sdk.mobile.c.a param1a) {
            if (this.a)
              param1a.c(); 
            this.b.a(1007, h.b(this.b, param1OauthResultMode), 4, "1007", h.a(this.b, param1OauthResultMode), SystemClock.uptimeMillis() - b.K);
          }
          
          public void onSuccess(OauthResultMode param1OauthResultMode, com.sdk.mobile.c.a param1a) {
            if (h.g(this.b)) {
              h.b(this.b, false);
              try {
                if (param1OauthResultMode.getObject() != null) {
                  Runnable runnable;
                  String str1 = param1OauthResultMode.getObject().toString();
                  JSONObject jSONObject = new JSONObject();
                  this(str1);
                  String str2 = jSONObject.optString("accessCode");
                  int i = param1OauthResultMode.getCode();
                  int j = param1OauthResultMode.getStatus();
                  if (AppStringUtils.isNotEmpty(str2) && i == 0) {
                    Thread thread = new Thread();
                    runnable = new Runnable() {
                        public void run() {
                          h.a(this.c.b, "CUCC", this.a, this.b, this.c.a);
                        }
                      };
                    super(this, str2, param1a);
                    this(runnable);
                    thread.start();
                    return;
                  } 
                  if (100018 == j) {
                    h h1 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    this();
                    h1.a(1011, "点击返回，用户取消免密登录", 4, stringBuilder.append(j).append("").toString(), h.a(this.b, (OauthResultMode)runnable), SystemClock.uptimeMillis() - b.K);
                  } 
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                if (this.a)
                  param1a.c(); 
                this.b.a(1014, "mCUCCLogin()" + exception.toString(), 4, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.K);
                return;
              } 
            } else {
              return;
            } 
            this.b.a(1003, h.b(this.b, (OauthResultMode)exception), 4, "1003", h.a(this.b, (OauthResultMode)exception), SystemClock.uptimeMillis() - b.K);
            if (this.a)
              param1a.c(); 
          }
        });
  }
  
  private void c() {
    this.h = null;
    this.i = null;
    this.j = null;
    String str = AppSysMgr.getOperatorType(this.c);
    byte b = -1;
    switch (str.hashCode()) {
      default:
        switch (b) {
          default:
            this.h = "CMCC";
            this.i = (String)SPTool.get(this.c, "cmccAppid", "");
            this.j = (String)SPTool.get(this.c, "cmccAppkey", "");
            return;
          case 0:
            this.h = "CMCC";
            this.i = (String)SPTool.get(this.c, "cmccAppid", "");
            this.j = (String)SPTool.get(this.c, "cmccAppkey", "");
            return;
          case 1:
            this.h = "CUCC";
            this.i = (String)SPTool.get(this.c, "cuccAppid", "");
            this.j = (String)SPTool.get(this.c, "cuccAppkey", "");
            return;
          case 2:
            break;
        } 
        break;
      case 2072138:
        if (str.equals("CMCC"))
          b = 0; 
      case 2079826:
        if (str.equals("CUCC"))
          b = 1; 
      case 2078865:
        if (str.equals("CTCC"))
          b = 2; 
    } 
    this.h = "CTCC";
    this.i = (String)SPTool.get(this.c, "ctccAppid", "");
    this.j = (String)SPTool.get(this.c, "ctccAppkey", "");
  }
  
  private void d() {
    if (this.e != null)
      this.e.a(); 
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, long paramLong) {
    if (this.e != null)
      this.e.a(paramInt1, paramString1, paramInt2, paramString2, paramString3, paramLong); 
  }
  
  public void a(int paramInt, String paramString1, String paramString2, long paramLong) {
    if (this.e != null)
      this.e.a(paramInt, paramString1, paramString2, paramLong); 
  }
  
  public void a(Context paramContext, AuthnHelper paramAuthnHelper) {
    this.c = paramContext;
    this.d = paramAuthnHelper;
  }
  
  public void a(a parama) {
    this.e = parama;
  }
  
  public void a(ExecutorService paramExecutorService, boolean paramBoolean) {
    Runnable runnable = new Runnable(this, paramExecutorService, paramBoolean) {
        public void run() {
          b.I = System.currentTimeMillis();
          b.J = SystemClock.uptimeMillis();
          try {
            String str1 = (String)SPTool.get(h.a(this.c), "cmccAppid", "");
            String str2 = (String)SPTool.get(h.a(this.c), "cmccAppkey", "");
            String str3 = (String)SPTool.get(h.a(this.c), "ctccAppid", "");
            String str4 = (String)SPTool.get(h.a(this.c), "ctccAppkey", "");
            String str5 = (String)SPTool.get(h.a(this.c), "cuccAppid", "");
            String str6 = (String)SPTool.get(h.a(this.c), "cuccAppkey", "");
            String str7 = (String)SPTool.get(h.a(this.c), "appId", "");
            String str8 = (String)SPTool.get(h.a(this.c), "appKey", "");
            if (AppStringUtils.isEmpty(str1) || AppStringUtils.isEmpty(str2) || AppStringUtils.isEmpty(str3) || AppStringUtils.isEmpty(str4) || AppStringUtils.isEmpty(str5) || AppStringUtils.isEmpty(str6) || AppStringUtils.isEmpty(str7) || AppStringUtils.isEmpty(str8) || b.v == 0) {
              if (((Integer)SPTool.get(h.a(this.c), "accOff", Integer.valueOf(0))).intValue() == 1) {
                this.c.a(1032, "用户被禁用", 3, "1032", "check_error", SystemClock.uptimeMillis() - b.J);
                return;
              } 
              b.v = 0;
              b.z = true;
              b.x = false;
              g.a().a(this.a, 3);
              return;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            this.c.a(1014, "openLoginAuthMethod()" + exception.toString(), 3, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.J);
            return;
          } 
          if (b.v == 2) {
            if (b.w) {
              b.z = true;
              return;
            } 
            b.z = false;
            if (MultiClickUtilstwo.isFastClick(h.a(this.c)) && b.r) {
              this.c.b(this.a, this.b);
              b.q = false;
              return;
            } 
            this.c.a(1031, "拉起授权页请求频繁", 3, "1031", "拉起授权页请求频繁", SystemClock.uptimeMillis() - b.J);
            return;
          } 
          if (b.v == 1)
            b.z = true; 
        }
      };
    if (paramExecutorService != null) {
      paramExecutorService.execute(runnable);
      return;
    } 
    a(1014, "openLoginAuthMethod()未初始化", 3, "1014", "未初始化", SystemClock.uptimeMillis() - b.J);
  }
  
  public void b() {
    if (this.f != null) {
      this.f.b();
      this.f.c();
      this.f = null;
    } 
  }
  
  public void b(ExecutorService paramExecutorService, boolean paramBoolean) {
    paramExecutorService.execute(new Runnable(this, paramBoolean) {
          public void run() {
            b.K = SystemClock.uptimeMillis();
            try {
              StringBuilder stringBuilder = new StringBuilder();
              this();
              L.d("ProcessLogger", stringBuilder.append("startOpenLoginAuth===isFinish=").append(this.a).toString());
              h.b(this.b);
              h.c(this.b);
              String str = h.d(this.b);
              byte b = -1;
              switch (str.hashCode()) {
                default:
                  switch (b) {
                    default:
                      if (((Integer)SPTool.get(h.a(this.b), "cmccSwitch", Integer.valueOf(1))).intValue() == 1) {
                        OneKeyLoginManager.getInstance().setAuthThemeConfig();
                        h.a(this.b, h.e(this.b), h.f(this.b), this.a);
                        return;
                      } 
                      break;
                    case 0:
                      if (((Integer)SPTool.get(h.a(this.b), "cmccSwitch", Integer.valueOf(1))).intValue() == 1) {
                        OneKeyLoginManager.getInstance().setAuthThemeConfig();
                        h.a(this.b, h.e(this.b), h.f(this.b), this.a);
                        return;
                      } 
                      this.b.a(1001, "startOpenLoginAuth()移动运营商通道未开启", 3, "1001", "check_error", SystemClock.uptimeMillis() - b.K);
                      return;
                    case 1:
                      if (((Integer)SPTool.get(h.a(this.b), "cuccSwitch", Integer.valueOf(1))).intValue() == 1) {
                        h.a(this.b, this.a);
                        return;
                      } 
                      this.b.a(1001, "startOpenLoginAuth()联通运营商通道未开启", 3, "1001", "check_error", SystemClock.uptimeMillis() - b.K);
                      return;
                    case 2:
                      break;
                  } 
                  if (((Integer)SPTool.get(h.a(this.b), "ctccSwitch", Integer.valueOf(1))).intValue() == 1) {
                    h.b(this.b, h.e(this.b), h.f(this.b), this.a);
                    return;
                  } 
                  this.b.a(1001, "startOpenLoginAuth()电信运营商通道未开启", 3, "1001", "check_error", SystemClock.uptimeMillis() - b.K);
                  return;
                case 2072138:
                  if (str.equals("CMCC"))
                    b = 0; 
                case 2079826:
                  if (str.equals("CUCC"))
                    b = 1; 
                case 2078865:
                  if (str.equals("CTCC"))
                    b = 2; 
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              this.b.a(1014, "prestart()" + exception.toString(), 3, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.K);
              return;
            } 
            this.b.a(1001, "startOpenLoginAuth()移动运营商通道未开启", 3, "1001", "check_error", SystemClock.uptimeMillis() - b.K);
          }
        });
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int1, String param1String1, int param1Int2, String param1String2, String param1String3, long param1Long);
    
    void a(int param1Int, String param1String1, String param1String2, long param1Long);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */