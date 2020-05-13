package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;
import android.os.SystemClock;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.chuanglan.shanyan_sdk.b;
import com.chuanglan.shanyan_sdk.utils.AbActivityUtils;
import com.chuanglan.shanyan_sdk.utils.AbUniqueCodeUtil;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.AppSysMgr;
import com.chuanglan.shanyan_sdk.utils.L;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
  private static k d = null;
  
  private String a = null;
  
  private String b = null;
  
  private String c = null;
  
  private Context e;
  
  private AuthnHelper f;
  
  private a g;
  
  public static k a() {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/k.d : Lcom/chuanglan/shanyan_sdk/tool/k;
    //   3: ifnonnull -> 30
    //   6: ldc com/chuanglan/shanyan_sdk/tool/k
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/k.d : Lcom/chuanglan/shanyan_sdk/tool/k;
    //   12: ifnonnull -> 27
    //   15: new com/chuanglan/shanyan_sdk/tool/k
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/chuanglan/shanyan_sdk/tool/k.d : Lcom/chuanglan/shanyan_sdk/tool/k;
    //   27: ldc com/chuanglan/shanyan_sdk/tool/k
    //   29: monitorexit
    //   30: getstatic com/chuanglan/shanyan_sdk/tool/k.d : Lcom/chuanglan/shanyan_sdk/tool/k;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/chuanglan/shanyan_sdk/tool/k
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong, boolean paramBoolean, String paramString4) {
    if (this.g != null)
      this.g.a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramLong, paramBoolean, paramString4); 
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt) {
    c();
    b.H = SystemClock.uptimeMillis();
    String str = AbUniqueCodeUtil.getUUID();
    SPTool.put(this.e, "uuid", str);
    byte b = -1;
    switch (paramString1.hashCode()) {
      default:
        switch (b) {
          default:
            return;
          case 0:
            this.f.getPhoneInfo(paramString2, paramString3, (((Integer)SPTool.get(this.e, "getPhoneInfoTimeOut", Integer.valueOf(4))).intValue() * 1000), new TokenListener(this, paramString1, paramInt) {
                  public void onGetTokenComplete(int param1Int, JSONObject param1JSONObject) {
                    if (param1JSONObject != null)
                      try {
                        if (param1JSONObject.has("resultCode")) {
                          param1Int = param1JSONObject.optInt("resultCode");
                          if (param1Int == 103000) {
                            k.a(this.c, 1022, "预取号成功", "", this.a, this.b, SystemClock.uptimeMillis() - b.H, false, "预取号成功");
                            long l = ((Long)SPTool.get(k.a(this.c), "cmccPreFlag", Long.valueOf(8L))).longValue();
                            SPTool.put(k.a(this.c), "timeend", Long.valueOf(l * 1000L + System.currentTimeMillis()));
                            return;
                          } 
                          k k2 = this.c;
                          StringBuilder stringBuilder3 = new StringBuilder();
                          this();
                          String str = stringBuilder3.append("getPhoneInfo()").append(param1JSONObject.toString()).toString();
                          int i = this.b;
                          StringBuilder stringBuilder4 = new StringBuilder();
                          this();
                          k2.a(1023, str, i, stringBuilder4.append(param1Int).append("").toString(), AbActivityUtils.getCMCCPreResMsg(param1JSONObject), SystemClock.uptimeMillis() - b.H, false);
                          return;
                        } 
                      } catch (Exception exception) {
                        exception.printStackTrace();
                        this.c.a(1014, "getPhoneInfo()" + exception.toString(), this.b, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.H, false);
                        return;
                      }  
                    k k1 = this.c;
                    StringBuilder stringBuilder1 = new StringBuilder();
                    this();
                    StringBuilder stringBuilder2 = stringBuilder1.append("getPhoneInfo()");
                    if (exception != null) {
                      String str = exception.toString();
                    } else {
                      stringBuilder1 = null;
                    } 
                    k1.a(1023, stringBuilder2.append((String)stringBuilder1).toString(), this.b, "1023", exception.toString(), SystemClock.uptimeMillis() - b.H, false);
                  }
                });
          case 1:
            paramString3 = (String)SPTool.get(this.e, "cuccAppid", new String());
            paramString2 = (String)SPTool.get(this.e, "cuccAppkey", new String());
            SDKManager.init(this.e, paramString2, paramString3);
            com.sdk.mobile.manager.login.cucc.a.a(this.e).a(((Integer)SPTool.get(this.e, "getPhoneInfoTimeOut", Integer.valueOf(4))).intValue(), new CallBack<Object>(this, paramString1, paramInt) {
                  public void onFailed(int param1Int1, int param1Int2, String param1String) {
                    try {
                      k k1 = this.c;
                      StringBuilder stringBuilder1 = new StringBuilder();
                      this();
                      String str = stringBuilder1.append("code=").append(param1Int1).append("msg=").append(param1String).append("status=").append(param1Int2).toString();
                      param1Int1 = this.b;
                      StringBuilder stringBuilder2 = new StringBuilder();
                      this();
                      k1.a(1023, str, param1Int1, stringBuilder2.append(param1Int2).append("").toString(), param1String, SystemClock.uptimeMillis() - b.H, false);
                    } catch (Exception exception) {
                      exception.printStackTrace();
                      this.c.a(1014, exception.toString(), this.b, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.H, false);
                    } 
                  }
                  
                  public void onSuccess(int param1Int1, String param1String1, int param1Int2, Object param1Object, String param1String2) {
                    if (param1Int1 == 0) {
                      try {
                        k.a(this.c, 1022, "预取号成功", "", this.a, this.b, SystemClock.uptimeMillis() - b.H, false, "预取号成功");
                        long l = ((Long)SPTool.get(k.a(this.c), "cuccPreFlag", Long.valueOf(1800L))).longValue();
                        SPTool.put(k.a(this.c), "timeend", Long.valueOf(l * 1000L + System.currentTimeMillis()));
                      } catch (Exception exception) {
                        exception.printStackTrace();
                        this.c.a(1014, exception.toString(), this.b, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.H, false);
                      } 
                      return;
                    } 
                    k k1 = this.c;
                    StringBuilder stringBuilder = new StringBuilder();
                    this();
                    param1String2 = stringBuilder.append("code=").append(param1Int1).append("msg=").append((String)exception).append("status=").append(param1Int2).append("response=").append(param1Object).append("seq=").append(param1String2).toString();
                    param1Int1 = this.b;
                    param1Object = new StringBuilder();
                    super();
                    k1.a(1023, param1String2, param1Int1, param1Object.append(param1Int2).append("").toString(), (String)exception, SystemClock.uptimeMillis() - b.H, false);
                  }
                });
          case 2:
            break;
        } 
        break;
      case 2072138:
        if (paramString1.equals("CMCC"))
          b = 0; 
      case 2079826:
        if (paramString1.equals("CUCC"))
          b = 1; 
      case 2078865:
        if (paramString1.equals("CTCC"))
          b = 2; 
    } 
    if (b.h) {
      CtAuth.getInstance().init(this.e, paramString2, paramString3, new TraceLogger(this) {
            public void debug(String param1String1, String param1String2) {
              L.d("TraceLogger", "debug===S==" + param1String1 + "S1==" + param1String2);
            }
            
            public void info(String param1String1, String param1String2) {
              L.d("TraceLogger", "info===S==" + param1String1 + "S1==" + param1String2);
            }
            
            public void warn(String param1String1, String param1String2, Throwable param1Throwable) {
              L.d("TraceLogger", "warn===S==" + param1String1 + "S1==" + param1String2 + "Throwable==" + param1Throwable);
            }
          });
    } else {
      CtAuth.getInstance().init(this.e, paramString2, paramString3, null);
    } 
    CtSetting ctSetting = new CtSetting(((Integer)SPTool.get(this.e, "getPhoneInfoTimeOut", Integer.valueOf(8))).intValue() * 1000 / 2, ((Integer)SPTool.get(this.e, "getPhoneInfoTimeOut", Integer.valueOf(8))).intValue() * 1000 / 2, ((Integer)SPTool.get(this.e, "initTimeOut", Integer.valueOf(8))).intValue() * 1000);
    CtAuth.getInstance().requestPreLogin(ctSetting, new ResultListener(this, paramString1, paramInt) {
          public void onResult(String param1String) {
            try {
              if (AppStringUtils.isNotEmpty(param1String)) {
                JSONObject jSONObject = new JSONObject();
                this(param1String);
                int i = jSONObject.optInt("result");
                if (i == 0) {
                  JSONObject jSONObject1 = jSONObject.optJSONObject("data");
                  if (jSONObject1 != null) {
                    String str2 = jSONObject1.optString("number");
                    String str3 = jSONObject1.optString("accessCode");
                    if (AppStringUtils.isNotEmpty(str2) && AppStringUtils.isNotEmpty(str3)) {
                      long l = ((Long)SPTool.get(k.a(this.c), "ctccPreFlag", Long.valueOf(60L))).longValue();
                      SPTool.put(k.a(this.c), "timeend", Long.valueOf(l * 1000L + System.currentTimeMillis()));
                      SPTool.put(k.a(this.c), "ctcc_number", str2);
                      SPTool.put(k.a(this.c), "ctcc_accessCode", str3);
                      k.a(this.c, 1022, "预取号成功", "", this.a, this.b, SystemClock.uptimeMillis() - b.H, false, "预取号成功");
                      return;
                    } 
                    k k3 = this.c;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    this();
                    String str4 = stringBuilder2.append("requestPreLogin()").append(param1String).toString();
                    int n = this.b;
                    stringBuilder2 = new StringBuilder();
                    this();
                    k3.a(1023, str4, n, stringBuilder2.append(i).append("").toString(), AbActivityUtils.getCTCCResMsg(param1String), SystemClock.uptimeMillis() - b.H, false);
                    return;
                  } 
                  k k2 = this.c;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  this();
                  String str1 = stringBuilder1.append("requestPreLogin()").append(param1String).toString();
                  int m = this.b;
                  stringBuilder1 = new StringBuilder();
                  this();
                  k2.a(1023, str1, m, stringBuilder1.append(i).append("").toString(), AbActivityUtils.getCTCCResMsg(param1String), SystemClock.uptimeMillis() - b.H, false);
                  return;
                } 
                k k1 = this.c;
                StringBuilder stringBuilder = new StringBuilder();
                this();
                String str = stringBuilder.append("requestPreLogin()").append(param1String).toString();
                int j = this.b;
                stringBuilder = new StringBuilder();
                this();
                k1.a(1023, str, j, stringBuilder.append(i).append("").toString(), AbActivityUtils.getCTCCResMsg(param1String), SystemClock.uptimeMillis() - b.H, false);
                return;
              } 
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
              this.c.a(1014, "requestPreLogin()" + jSONException.toString(), this.b, "1014", jSONException.getClass().getName(), SystemClock.uptimeMillis() - b.H, false);
              return;
            } 
            this.c.a(1023, "requestPreLogin():电信SDK未知异常", this.b, "1003", "电信SDK未知异常", SystemClock.uptimeMillis() - b.H, false);
          }
        });
  }
  
  private void a(boolean paramBoolean, int paramInt) {
    try {
      String str1 = (String)SPTool.get(this.e, "SIMSerial", "");
      String str2 = (String)SPTool.get(this.e, "SIMOperator", "");
      if (AppStringUtils.isNotEmpty(AppSysMgr.getSIMSerial(this.e)) && AppSysMgr.getSIMSerial(this.e).equals(str1) && AppStringUtils.isNotEmpty(AppSysMgr.getOperatorType(this.e)) && AppSysMgr.getOperatorType(this.e).equals(str2)) {
        if (System.currentTimeMillis() > ((Long)SPTool.get(this.e, "timeend", Long.valueOf(1L))).longValue()) {
          a(this.a, this.b, this.c, paramInt);
          return;
        } 
        if (paramBoolean) {
          if (AppStringUtils.isEmpty((String)SPTool.get(this.e, "uuid", ""))) {
            str2 = AbUniqueCodeUtil.getUUID();
            SPTool.put(this.e, "uuid", str2);
          } 
          a(1022, "预取号成功", "", this.a, paramInt, SystemClock.uptimeMillis() - b.G, true, "cache");
          return;
        } 
        if (AppStringUtils.isEmpty((String)SPTool.get(this.e, "uuid", ""))) {
          str2 = AbUniqueCodeUtil.getUUID();
          SPTool.put(this.e, "uuid", str2);
        } 
        a(1023, "预取号失败", paramInt, "1023", "cache", SystemClock.uptimeMillis() - b.G, true);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      a(1014, "getPhoneInfoMethod()" + exception.toString(), paramInt, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.G, false);
      return;
    } 
    a(this.a, this.b, this.c, paramInt);
  }
  
  private void b() {
    this.a = null;
    this.b = null;
    this.c = null;
    String str = AppSysMgr.getOperatorType(this.e);
    byte b = -1;
    switch (str.hashCode()) {
      default:
        switch (b) {
          default:
            this.a = "CMCC";
            this.b = (String)SPTool.get(this.e, "cmccAppid", "");
            this.c = (String)SPTool.get(this.e, "cmccAppkey", "");
            return;
          case 0:
            this.a = "CMCC";
            this.b = (String)SPTool.get(this.e, "cmccAppid", "");
            this.c = (String)SPTool.get(this.e, "cmccAppkey", "");
            return;
          case 1:
            this.a = "CUCC";
            this.b = (String)SPTool.get(this.e, "cuccAppid", "");
            this.c = (String)SPTool.get(this.e, "cuccAppkey", "");
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
    this.a = "CTCC";
    this.b = (String)SPTool.get(this.e, "ctccAppid", "");
    this.c = (String)SPTool.get(this.e, "ctccAppkey", "");
  }
  
  private void b(int paramInt) {
    b();
    String str = this.a;
    byte b = -1;
    switch (str.hashCode()) {
      default:
        switch (b) {
          default:
            return;
          case 0:
            if (((Integer)SPTool.get(this.e, "cmccSwitch", Integer.valueOf(1))).intValue() == 1)
              a(b.y, paramInt); 
            a(1001, "preOperatorMethod（）移动运营商通道未开启", paramInt, "1001", "check_error", SystemClock.uptimeMillis() - b.G, true);
          case 1:
            if (((Integer)SPTool.get(this.e, "cuccSwitch", Integer.valueOf(1))).intValue() == 1) {
              if (b.u) {
                SPTool.put(this.e, "timeend", Long.valueOf(0L));
                b.u = false;
              } 
              a(b.y, paramInt);
            } 
            a(1001, "preOperatorMethod（）联通运营商通道未开启", paramInt, "1001", "check_error", SystemClock.uptimeMillis() - b.G, true);
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
    if (((Integer)SPTool.get(this.e, "ctccSwitch", Integer.valueOf(1))).intValue() == 1) {
      if (b.u) {
        SPTool.put(this.e, "ctcc_number", "");
        SPTool.put(this.e, "ctcc_accessCode", "");
        SPTool.put(this.e, "timeend", Long.valueOf(0L));
        b.u = false;
      } 
      a(b.y, paramInt);
    } 
    a(1001, "preOperatorMethod（）电信运营商通道未开启", paramInt, "1001", "check_error", SystemClock.uptimeMillis() - b.G, true);
  }
  
  private void c() {
    if (this.g != null)
      this.g.a(); 
  }
  
  public void a(int paramInt) {
    L.d("ProcessLogger", "startGetPhoneInfo===processName=" + paramInt);
    b.F = System.currentTimeMillis();
    b.G = SystemClock.uptimeMillis();
    b(paramInt);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, long paramLong, boolean paramBoolean) {
    if (this.g != null)
      this.g.a(paramInt1, paramString1, paramInt2, paramString2, paramString3, paramLong, paramBoolean); 
  }
  
  public void a(Context paramContext, AuthnHelper paramAuthnHelper) {
    this.e = paramContext;
    this.f = paramAuthnHelper;
  }
  
  public void a(a parama) {
    this.g = parama;
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int1, String param1String1, int param1Int2, String param1String2, String param1String3, long param1Long, boolean param1Boolean);
    
    void a(int param1Int1, String param1String1, String param1String2, String param1String3, int param1Int2, long param1Long, boolean param1Boolean, String param1String4);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */