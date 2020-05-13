package com.cmic.sso.sdk.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.a.b;
import com.cmic.sso.sdk.b.a.c;
import com.cmic.sso.sdk.b.a.d;
import com.cmic.sso.sdk.b.a.e;
import com.cmic.sso.sdk.b.a.h;
import com.cmic.sso.sdk.utils.aa;
import com.cmic.sso.sdk.utils.ab;
import com.cmic.sso.sdk.utils.ac;
import com.cmic.sso.sdk.utils.ad;
import com.cmic.sso.sdk.utils.e;
import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.k;
import com.cmic.sso.sdk.utils.o;
import com.cmic.sso.sdk.utils.q;
import com.cmic.sso.sdk.utils.r;
import com.cmic.sso.sdk.utils.t;
import com.cmic.sso.sdk.utils.v;
import com.cmic.sso.sdk.utils.w;
import com.cmic.sso.sdk.utils.y;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static a b = null;
  
  private Context a;
  
  protected a() {}
  
  protected a(Context paramContext) {
    this.a = paramContext;
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   3: ifnonnull -> 31
    //   6: ldc com/cmic/sso/sdk/b/b/a
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   12: ifnonnull -> 28
    //   15: new com/cmic/sso/sdk/b/b/a
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   28: ldc com/cmic/sso/sdk/b/b/a
    //   30: monitorexit
    //   31: getstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/cmic/sso/sdk/b/b/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  public void a(Context paramContext, Bundle paramBundle, b paramb) {
    int i = paramBundle.getInt("networkType");
    String str1 = paramBundle.getString("authtype");
    e e = new e();
    e.a a1 = new e.a();
    a1.e("1.0");
    a1.f("quick_login_android_5.6.5.1");
    a1.g(paramBundle.getString("appid"));
    a1.h(str1);
    a1.i(paramBundle.getString("smskey", ""));
    a1.j(paramBundle.getString("imsi", ""));
    a1.k(q.a(paramContext).c());
    a1.d(t.f(this.a));
    a1.c(q.a(this.a).b());
    a1.l(paramBundle.getString("operatorType"));
    a1.m(i + "");
    a1.n(w.a());
    a1.o(w.b());
    a1.p(w.c());
    a1.q("0");
    a1.r(ac.a());
    a1.s(y.a());
    a1.t(paramBundle.getString("apppackage"));
    a1.u(paramBundle.getString("appsign"));
    if (!aa.b(this.a))
      a1.a(ab.a()); 
    if (!aa.c(this.a))
      a1.b(ab.b()); 
    a1.t(paramBundle.getString("apppackage"));
    a1.u(paramBundle.getString("appsign"));
    a1.v(a1.w(paramBundle.getString("appkey")));
    e.a(paramBundle.getString(com.cmic.sso.sdk.a.a.a));
    e.b(o.a().a(paramBundle.getString(com.cmic.sso.sdk.a.a.a)));
    e.a(a1);
    String str2 = paramBundle.getString("interfacetype", "");
    paramBundle.putString("interfacetype", str2 + "getPrePhonescrip;");
    paramBundle.putString("interfaceVersion", "7.0");
    paramBundle.putBoolean("isCloseIpv4", aa.b(paramContext));
    paramBundle.putBoolean("isCloseIpv6", aa.c(paramContext));
    str2 = aa.g(paramContext) + "rs/getPrePhonescrip";
    if (i == 3 && str1.equals("3")) {
      ad.a(paramContext);
      h.b("BaseRequest", "使用wifi下取号" + i);
      a(str2, e, true, paramBundle, paramb);
      return;
    } 
    h.b("BaseRequest", "不使用wifi下取号" + i);
    a(str2, e, false, paramBundle, paramb);
  }
  
  public void a(Bundle paramBundle, b paramb) {
    b b1 = new b();
    b1.c("1.0");
    b1.j("4.0");
    b1.d("quick_login_android_5.6.5.1");
    b1.e(paramBundle.getString("appid"));
    b1.f(ac.a());
    b1.g(y.a());
    b1.i(paramBundle.getString("keyid"));
    b1.b(paramBundle.getString("apppackage"));
    b1.a(paramBundle.getString("appsign"));
    b1.h(b1.k(paramBundle.getString("appkey")));
    a("https://onekey1.cmpassport.com:443/unisdk/rs/ckRequest", b1, false, paramBundle, paramb);
  }
  
  public <T extends h> void a(String paramString, T paramT, boolean paramBoolean, Bundle paramBundle, b paramb) {
    JSONObject jSONObject;
    String str = paramBundle.getString("traceId");
    h.a("BaseRequest", "request https url : " + paramString + ">>>>>>> PARAMS : " + paramT.a().toString());
    if (w.b(this.a) == 0) {
      jSONObject = new JSONObject();
      try {
        jSONObject.put("resultCode", "200022");
        jSONObject.put("desc", "网络未连接");
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      h.a("BaseRequest", "request failed , url : " + paramString + ">>>>>errorMsg : " + jSONObject.toString());
      if (paramb != null)
        paramb.a("200022", "网络未连接", jSONObject); 
      return;
    } 
    try {
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("timeOut", jSONException.getString("timeOut"));
      jSONObject1.put("imsiState", jSONException.getString("imsiState"));
    } catch (JSONException jSONException1) {
      jSONException1.printStackTrace();
    } 
    (new e()).a(paramString, (h)jSONObject, paramBoolean, new e.a(this, paramString, (Bundle)jSONException, paramb) {
          private boolean e = false;
          
          public void a(String param1String1, String param1String2) {
            if (!this.e) {
              this.e = true;
              h.a("BaseRequest", "request success , url : " + this.a + ">>>>result : " + param1String1);
              try {
                JSONObject jSONObject1 = new JSONObject();
                this();
                JSONObject jSONObject2 = new JSONObject();
                this(param1String1);
                if (jSONObject2.has("resultCode"))
                  jSONObject1.put("resultCode", jSONObject2.get("resultCode")); 
                if (!k.a(this.b.getString("traceId")) || this.a.contains("Config"))
                  this.c.a(jSONObject2.optString("resultCode"), jSONObject2.optString("desc"), jSONObject2); 
              } catch (Exception exception) {
                exception.printStackTrace();
                a("200021", "数据解析异常", param1String2);
              } 
            } 
          }
          
          public void a(String param1String1, String param1String2, String param1String3) {
            if (!this.e) {
              this.e = true;
              JSONObject jSONObject = new JSONObject();
              try {
                jSONObject.put("resultCode", param1String1);
                jSONObject.put("desc", param1String2);
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
              } 
              h.a("BaseRequest", "request failed , url : " + this.a + ">>>>>errorMsg : " + jSONObject.toString());
              if (this.c != null && (!k.a(this.b.getString("traceId")) || this.a.contains("Config")))
                this.c.a(param1String1, param1String2, jSONObject); 
            } 
          }
        }"POST", str, (Bundle)jSONException);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, b paramb) {
    String str;
    d d = new d();
    d.a("1.0");
    d.b("Android");
    d.c(paramBundle.getString("imei"));
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    } 
    d.d(str);
    d.e("quick_login_android_5.6.5.1");
    d.f(paramBundle.getString("appid"));
    d.g(d.b());
    a("https://config.cmpassport.com/client/uniConfig", d, false, paramBundle, paramb);
  }
  
  public void b(Context paramContext, Bundle paramBundle, b paramb) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("resultCode", "200046");
      jSONObject.put("desc", "没申请短信验证码登录能力");
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    h.a("BaseRequest", "request failed , >>>>> " + jSONObject.toString());
    if (paramb != null)
      paramb.a("200046", "没申请短信验证码登录能力", jSONObject); 
  }
  
  public void b(Bundle paramBundle, b paramb) {
    com.cmic.sso.sdk.b.a.a a1 = new com.cmic.sso.sdk.b.a.a();
    String str1 = ac.a();
    a1.d("1.0");
    a1.e("quick_login_android_5.6.5.1");
    a1.f(paramBundle.getString("appid"));
    a1.i("null");
    a1.j(paramBundle.getString("authtype"));
    a1.n("0");
    a1.p(paramBundle.getString("imei"));
    a1.o(paramBundle.getString("imsi"));
    a1.g(ac.a());
    a1.k(paramBundle.getString("account"));
    a1.l(paramBundle.getString("passwd"));
    a1.m(o.a().a(str1));
    String str2 = paramBundle.getString("capaids", "");
    if (!TextUtils.isEmpty(str2)) {
      a1.q(str2);
    } else {
      a1.q("aa");
    } 
    if (paramBundle.getInt("logintype") == 0);
    a1.c("1");
    a1.h(y.a());
    a1.a("2.0");
    a1.b(r.b(this.a, "randomnum", ""));
    a1.r(a1.a(paramBundle.getString("appkey"), str1));
    if (paramBundle.getString("authtype", "").equals("2")) {
      str2 = aa.j(this.a) + "rs/authRequest";
      com.cmic.sso.sdk.b.c.a.a(aa.a(this.a, aa.j(this.a)));
    } else {
      str2 = aa.h(this.a) + "rs/authRequest";
      com.cmic.sso.sdk.b.c.a.a(aa.a(this.a, aa.h(this.a)));
    } 
    str1 = paramBundle.getString("interfacetype", "");
    paramBundle.putString("interfacetype", str1 + "authRequest;");
    a(str2, a1, false, paramBundle, paramb);
  }
  
  public void c(Bundle paramBundle, b paramb) {
    String str2;
    c c = new c();
    c.a a1 = new c.a();
    c.f("0.1");
    c.i(paramBundle.getString("phonescrip"));
    c.h(paramBundle.getString("appid"));
    c.g(ac.a());
    c.c(y.a());
    if ("2".equals(paramBundle.getString("authtype"))) {
      c.d("2.0");
    } else {
      c.d("6.0");
    } 
    c.e(paramBundle.getString("userCapaid", "50"));
    c.a("0");
    c.b(paramBundle.getString("sourceid"));
    c.k(paramBundle.getString("authenticated_appid"));
    c.l(paramBundle.getString("genTokenByAppid"));
    c.j(c.m(paramBundle.getString("appkey")));
    a1.a(paramBundle.getString("traceId", ""));
    a1.b(q.a(this.a).c());
    a1.c(w.c());
    a1.d(w.b());
    a1.e(w.a());
    a1.f(w.a(this.a) + "");
    a1.g("0");
    int i = w.b(this.a);
    a1.h(i + "");
    a1.i(t.a());
    a1.j(t.a(this.a));
    a1.k(q.a(this.a).c());
    a1.l(q.a(this.a).a());
    a1.m(t.f(this.a));
    a1.n(q.a(this.a).b());
    a1.o(t.e(this.a));
    a1.p("");
    a1.q(t.c(this.a));
    a1.r("");
    if (paramBundle.getInt("networkType", 0) == 3 || paramBundle.getInt("networkType", 0) == 2) {
      a1.s("1");
    } else {
      a1.s("0");
    } 
    a1.t(t.e(this.a));
    a1.u(t.b(this.a));
    a1.v(ab.a());
    a1.w(ab.b());
    if (aa.k(this.a)) {
      str2 = "0";
    } else {
      str2 = "1";
    } 
    a1.x(str2);
    if (paramBundle.getString("authtype", "").equals("2")) {
      a1.y(aa.j(this.a));
    } else {
      a1.y(aa.h(this.a));
    } 
    if (v.a()) {
      a1.z("1");
    } else {
      a1.z("0");
    } 
    c.a(a1.a());
    if (paramBundle.getString("authtype", "").equals("2")) {
      str2 = aa.j(this.a) + "api/getAuthToken";
      com.cmic.sso.sdk.b.c.a.a(aa.a(this.a, aa.j(this.a)));
    } else {
      str2 = aa.h(this.a) + "api/getAuthToken";
      com.cmic.sso.sdk.b.c.a.a(aa.a(this.a, aa.h(this.a)));
    } 
    String str1 = paramBundle.getString("interfacetype", "");
    paramBundle.putString("interfacetype", str1 + "getAuthToken;");
    paramBundle.putString("interfaceVersion", "6.0");
    a(str2, c, false, paramBundle, paramb);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */