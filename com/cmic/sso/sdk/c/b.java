package com.cmic.sso.sdk.c;

import android.content.Context;
import android.os.Bundle;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.b.a.f;
import com.cmic.sso.sdk.b.a.h;
import com.cmic.sso.sdk.b.c.a;
import com.cmic.sso.sdk.utils.aa;
import com.cmic.sso.sdk.utils.ab;
import com.cmic.sso.sdk.utils.ac;
import com.cmic.sso.sdk.utils.e;
import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.l;
import com.cmic.sso.sdk.utils.n;
import com.cmic.sso.sdk.utils.q;
import com.cmic.sso.sdk.utils.r;
import com.cmic.sso.sdk.utils.t;
import com.cmic.sso.sdk.utils.v;
import com.cmic.sso.sdk.utils.w;
import com.cmic.sso.sdk.utils.x;
import com.cmic.sso.sdk.utils.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private Bundle a;
  
  private Context b;
  
  private void a(Context paramContext, JSONArray paramJSONArray, com.cmic.sso.sdk.b.b.b paramb) {
    f f = new f();
    f.a a = new f.a();
    f.b b1 = new f.b();
    b1.d(ac.a());
    b1.e(y.a());
    b1.b(this.a.getString("appid", ""));
    b1.a("2.0");
    b1.c(b1.f());
    JSONArray jSONArray = paramJSONArray;
    if (paramJSONArray == null)
      jSONArray = new JSONArray(); 
    a.a(jSONArray);
    f.a(a);
    f.a(b1);
    String str = aa.i(paramContext);
    a.a(aa.a(paramContext, aa.i(paramContext)));
    a(str, f, paramb);
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject) {
    JSONArray jSONArray = new JSONArray();
    jSONArray.put(paramJSONObject);
    a(paramContext, jSONArray, new com.cmic.sso.sdk.b.b.b(this) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {}
        });
  }
  
  private <T extends h> void a(String paramString, T paramT, com.cmic.sso.sdk.b.b.b paramb) {
    if (aa.p(this.b) == 0 || aa.o(this.b) == 0 || System.currentTimeMillis() > r.b(this.b, "logCloseTime", 0L) + aa.p(this.b)) {
      h.a("SendLog", "request https url : " + aa.i(this.b) + ">>>>>>> PARAMS : " + paramT.a().toString());
      (new e()).a(paramString, (h)paramT, false, new e.a(this, paramString, paramb) {
            public void a(String param1String1, String param1String2) {
              h.a("SendLog", "request success , url : " + this.a + ">>>>result : " + param1String1);
              try {
                JSONObject jSONObject = new JSONObject();
                this(param1String1);
                this.b.a(jSONObject.optString("resultCode"), jSONObject.optString("desc"), jSONObject);
              } catch (Exception exception) {
                exception.printStackTrace();
                a("200021", "数据解析异常", param1String2);
              } 
            }
            
            public void a(String param1String1, String param1String2, String param1String3) {
              if (aa.p(b.a(this.c)) != 0 && aa.o(b.a(this.c)) != 0) {
                int i = r.b(b.a(this.c), "logFailTimes", 0) + 1;
                if (i >= aa.o(b.a(this.c))) {
                  r.a(b.a(this.c), "logFailTimes", 0);
                  r.a(b.a(this.c), "logCloseTime", System.currentTimeMillis());
                } else {
                  r.a(b.a(this.c), "logFailTimes", i);
                } 
              } 
              JSONObject jSONObject = new JSONObject();
              try {
                jSONObject.put("resultCode", param1String1);
                jSONObject.put("desc", param1String2);
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
              } 
              h.a("SendLog", "request failed , url : " + this.a + ">>>>>errorMsg : " + jSONObject.toString());
              if (this.b != null)
                this.b.a(param1String1, param1String2, jSONObject); 
            }
          }"POST", "", this.a);
    } 
  }
  
  public void a(Context paramContext, String paramString, Bundle paramBundle, Throwable paramThrowable) {
    this.b = paramContext;
    try {
      String str;
      a1 = new a();
      this();
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("resultCode", paramString);
      jSONObject.put("PGWResultCode", paramBundle.getString("PGWResultCode", null));
      jSONObject = new JSONObject();
      this();
      StringBuilder stringBuilder3 = new StringBuilder();
      this();
      a1.L(stringBuilder3.append(w.b(this.b)).append("").toString());
      jSONObject.put("timeOut", paramBundle.getString("timeOut"));
      jSONObject.put("imsiState", paramBundle.getString("imsiState"));
      if (paramBundle.getBoolean("isCacheScrip", false) && !"sms".equals(paramBundle.getString("loginMethod", ""))) {
        a1.D("scrip");
        paramBundle.putBoolean("isCacheScrip", n.a(this.b, paramBundle));
      } else if ("sms".equals(paramBundle.getString("loginMethod"))) {
        a1.D("sms");
        paramBundle.putBoolean("isCacheScrip", n.a(this.b, paramBundle));
      } else {
        a1.D("pgw");
        paramBundle.putBoolean("isCacheScrip", n.a(this.b, paramBundle));
      } 
      if ("loginAuth".equals(paramBundle.getString("loginMethod")) || "sms".equals(paramBundle.getString("loginMethod"))) {
        a1.I("loginAuth");
      } else if ("mobileAuth".equals(paramBundle.getString("loginMethod"))) {
        a1.I("mobileAuth");
      } else {
        a1.I("preGetMobile");
      } 
      a1.E(paramBundle.getString("traceId"));
      a1.J(paramBundle.getString("appid"));
      a1.v(l.c(this.b));
      a1.w(l.d(this.b));
      a1.K("quick_login_android_5.6.5.1");
      a1.t("android");
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      a1.u(stringBuilder2.append(a.a).append("").toString());
      a1.F(paramBundle.getString("starttime"));
      long l = System.currentTimeMillis();
      a1.H(y.a(l));
      stringBuilder2 = new StringBuilder();
      this();
      a1.r(stringBuilder2.append(l - paramBundle.getLong("starttimemills")).append("").toString());
      a1.q(paramBundle.getString("interfacetype", ""));
      paramBundle.putString("interfacetype", "");
      a1.e(paramBundle.getString("interfacecode", ""));
      paramBundle.putString("interfacecode", "");
      a1.f(paramBundle.getString("interfaceelasped", ""));
      paramBundle.putString("interfaceelasped", "");
      stringBuilder2 = new StringBuilder();
      this();
      a1.A(stringBuilder2.append(w.a(this.b)).append("").toString());
      if (paramBundle.getInt("startnetworkType", 0) == 0) {
        stringBuilder2 = new StringBuilder();
        this();
        a1.L(stringBuilder2.append(w.b(this.b)).append("").toString());
      } else {
        stringBuilder2 = new StringBuilder();
        this();
        a1.L(stringBuilder2.append(paramBundle.getInt("startnetworkType", 0)).append("").toString());
      } 
      a1.G(paramBundle.getString("networkClass"));
      a1.p(w.a());
      a1.B(w.b());
      a1.C(w.c());
      a1.y(t.d(this.b));
      a1.x(t.e(this.b));
      a1.n(ab.a());
      a1.o(ab.b());
      a1.m(q.a(this.b).c());
      a1.z(paramBundle.getString("simCardNum"));
      a1.l(q.a(this.b).a());
      a1.k(q.a(this.b).c());
      a1.h(t.f(this.b));
      a1.i(q.a(this.b).b());
      a1.g(t.g(this.b));
      if (Integer.parseInt(paramBundle.getString("simCardNum", "0")) <= 1) {
        a1.j(null);
      } else {
        a1.j(t.h(this.b));
      } 
      a1.d(paramString);
      if (v.a()) {
        str = "1";
      } else {
        str = "0";
      } 
      a1.c(str);
      a1.b(paramBundle.getString("imsiState", "0"));
      a1.a(paramBundle.getString("transCode", null));
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      a1.r(stringBuilder1.append(System.currentTimeMillis() - paramBundle.getLong("methodTimes", 0L)).append("").toString());
      stringBuilder1 = null;
      if (paramThrowable != null) {
        JSONArray jSONArray1 = new JSONArray();
        this();
        JSONObject jSONObject1 = new JSONObject();
        this();
        StringBuffer stringBuffer = new StringBuffer();
        this();
        for (StackTraceElement stackTraceElement : paramThrowable.getStackTrace())
          stringBuffer.append("\n").append(stackTraceElement.toString()); 
        jSONObject1.put("message", paramThrowable.toString());
        jSONObject1.put("stack", stringBuffer.toString());
        jSONArray1.put(jSONObject1);
      } 
    } catch (Exception exception1) {
      exception1.printStackTrace();
      return;
    } 
    Exception exception2 = exception1;
    if (a.a.size() > 0) {
      JSONArray jSONArray1;
      if (exception1 == null) {
        jSONArray1 = new JSONArray();
        this();
      } 
      for (Throwable throwable : a.a) {
        StringBuffer stringBuffer = new StringBuffer();
        this();
        JSONObject jSONObject = new JSONObject();
        this();
        for (StackTraceElement stackTraceElement : throwable.getStackTrace())
          stringBuffer.append("\n").append(stackTraceElement.toString()); 
        jSONObject.put("message", throwable.toString());
        jSONObject.put("stack", stringBuffer.toString());
        jSONArray1.put(jSONObject);
      } 
      a.a.clear();
      jSONArray = jSONArray1;
    } 
    if (jSONArray != null && jSONArray.length() > 0)
      a1.a(jSONArray); 
    StringBuilder stringBuilder = new StringBuilder();
    this();
    JSONArray jSONArray;
    a a1;
    h.a("SendLog", stringBuilder.append("登录日志").append(a1.a()).toString());
    a(this.b, a1.a(), paramBundle);
    x.a a = new x.a() {
        protected void a() {
          if (this.a.getBoolean("isNeedToGetCert", false)) {
            r.a(b.a(this.b), "isGetCert", "1");
            aa.a(b.a(this.b), this.a);
            return;
          } 
          if (aa.a(b.a(this.b)))
            aa.a(b.a(this.b), this.a); 
        }
      };
    super(this, this.b, paramBundle, paramBundle);
    x.a(a);
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject, Bundle paramBundle) {
    this.a = paramBundle;
    this.b = paramContext;
    x.a(new x.a(this, paramContext, paramJSONObject) {
          protected void a() {
            b.a(this.c, this.a, this.b);
          }
        });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */