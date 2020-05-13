package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.a.g;
import com.cmic.sso.sdk.c.b;
import java.util.HashMap;
import org.json.JSONObject;

public class d {
  private static a<String, String> a = new a<String, String>();
  
  public static void a() {
    String str = String.valueOf(0);
    a.put("authPageIn", str);
    a.put("authPageOut", str);
    a.put("SMSIn", str);
    a.put("SMSOut", str);
    a.put("auth2SMS", str);
    a.put("SMSClick", str);
    a.put("authPageReturn", str);
    a.put("authClickFailed", str);
    a.put("authClickSuccess", str);
    a.put("timeOnAuthPage", str);
    a.put("getSMSCodeFailed", str);
    a.put("getSMSCodeSuccess", str);
    a.put("SMSVerifyFailed", str);
    a.put("SMSVerifySuccess", str);
    a.put("timeOnSMSPage", str);
    a.put("authPrivacyState", str);
    a.put("SMSPageReturn", str);
    a.put("SMSPageOut", str);
  }
  
  public static void a(Context paramContext, Bundle paramBundle) {
    try {
      if (!aa.n(paramContext)) {
        String str5;
        String str3;
        g g = new g();
        this();
        String str2 = String.valueOf(0);
        if (!((String)a.a("authPageIn", str2)).equals(str2)) {
          str5 = a.get("authPageIn");
        } else {
          str5 = null;
        } 
        g.o(str5);
        if (!((String)a.a("authPageOut", str2)).equals(str2)) {
          str5 = a.get("authPageOut");
        } else {
          str5 = null;
        } 
        g.p(str5);
        if (!((String)a.a("SMSIn", str2)).equals(str2)) {
          str5 = a.get("SMSIn");
        } else {
          str5 = null;
        } 
        g.m(str5);
        if (!((String)a.a("auth2SMS", str2)).equals(str2)) {
          str5 = a.get("auth2SMS");
        } else {
          str5 = null;
        } 
        g.n(str5);
        if (!((String)a.a("authPageReturn", str2)).equals(str2)) {
          str5 = a.get("authPageReturn");
        } else {
          str5 = null;
        } 
        g.l(str5);
        if (!((String)a.a("authClickSuccess", str2)).equals(str2)) {
          str5 = a.get("authClickSuccess");
        } else {
          str5 = null;
        } 
        g.e(str5);
        if (!((String)a.a("authClickFailed", str2)).equals(str2)) {
          str5 = a.get("authClickFailed");
        } else {
          str5 = null;
        } 
        g.d(str5);
        if (!((String)a.a("timeOnAuthPage", str2)).equals(str2)) {
          str5 = a.get("timeOnAuthPage");
        } else {
          str5 = null;
        } 
        g.f(str5);
        if (!((String)a.a("getSMSCodeSuccess", str2)).equals(str2)) {
          str5 = a.get("getSMSCodeSuccess");
        } else {
          str5 = null;
        } 
        g.h(str5);
        if (!((String)a.a("getSMSCodeFailed", str2)).equals(str2)) {
          str5 = a.get("getSMSCodeFailed");
        } else {
          str5 = null;
        } 
        g.g(str5);
        if (!((String)a.a("SMSVerifySuccess", str2)).equals(str2)) {
          str5 = a.get("SMSVerifySuccess");
        } else {
          str5 = null;
        } 
        g.j(str5);
        if (!((String)a.a("SMSVerifyFailed", str2)).equals(str2)) {
          str5 = a.get("SMSVerifyFailed");
        } else {
          str5 = null;
        } 
        g.i(str5);
        if (!((String)a.a("timeOnSMSPage", str2)).equals(str2)) {
          str5 = a.get("timeOnSMSPage");
        } else {
          str5 = null;
        } 
        g.k(str5);
        g.c(a.a("authPrivacyState", str2));
        if (!((String)a.a("SMSPageReturn", str2)).equals(str2)) {
          str5 = a.get("SMSPageReturn");
        } else {
          str5 = null;
        } 
        g.b(str5);
        if (!((String)a.a("SMSPageOut", str2)).equals(str2)) {
          str5 = a.get("SMSPageOut");
        } else {
          str5 = null;
        } 
        g.a(str5);
        JSONObject jSONObject = g.a();
        com.cmic.sso.sdk.c.a a1 = new com.cmic.sso.sdk.c.a();
        this();
        if (paramBundle != null)
          a1.J(paramBundle.getString("appid", "")); 
        a1.E(paramBundle.getString("traceId"));
        a1.J(paramBundle.getString("appid"));
        a1.v(l.c(paramContext));
        a1.w(l.d(paramContext));
        a1.K("quick_login_android_5.6.5.1");
        a1.t("android");
        StringBuilder stringBuilder3 = new StringBuilder();
        this();
        a1.u(stringBuilder3.append(com.cmic.sso.sdk.a.a).append("").toString());
        String str1 = a.a("authPageInTime", "");
        String str4 = str1;
        if (TextUtils.isEmpty(str1))
          str4 = a.a("SMSInTime", ""); 
        a1.F(str4);
        str1 = a.a("authPageOutTime", "");
        str4 = str1;
        if (TextUtils.isEmpty(str1))
          str4 = a.a("SMSOutTime", ""); 
        a1.H(str4);
        a1.I("eventTracking5");
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        a1.A(stringBuilder2.append(w.a(paramContext)).append("").toString());
        if (paramBundle.getInt("startnetworkType", 0) == 0) {
          stringBuilder2 = new StringBuilder();
          this();
          a1.L(stringBuilder2.append(w.b(paramContext)).append("").toString());
        } else {
          stringBuilder2 = new StringBuilder();
          this();
          a1.L(stringBuilder2.append(paramBundle.getInt("startnetworkType", 0)).append("").toString());
        } 
        a1.G(paramBundle.getString("networkClass"));
        a1.p(w.a());
        a1.B(w.b());
        a1.C(w.c());
        a1.y(t.d(paramContext));
        a1.x(t.e(paramContext));
        a1.n(ab.a());
        a1.o(ab.b());
        a1.m(q.a(paramContext).c());
        a1.z(paramBundle.getString("simCardNum"));
        a1.l(q.a(paramContext).a());
        a1.k(q.a(paramContext).c());
        a1.h(t.f(paramContext));
        a1.i(q.a(paramContext).b());
        a1.g(t.g(paramContext));
        if (Integer.parseInt(paramBundle.getString("simCardNum", "0")) <= 1) {
          a1.j(null);
        } else {
          a1.j(t.h(paramContext));
        } 
        a1.a(jSONObject);
        if (v.a()) {
          str3 = "1";
        } else {
          str3 = "0";
        } 
        a1.c(str3);
        a1.b(paramBundle.getString("imsiState", "0"));
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        a1.r(stringBuilder1.append(System.currentTimeMillis() - paramBundle.getLong("methodTimes", 0L)).append("").toString());
        stringBuilder1 = new StringBuilder();
        this();
        h.a("EventUtils", stringBuilder1.append("埋点日志上报").append(a1.a()).toString());
        b b = new b();
        this();
        b.a(paramContext, a1.a(), paramBundle);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(String paramString) {
    byte b;
    String str = a.get(paramString);
    if (!TextUtils.isEmpty(str)) {
      b = Integer.valueOf(str).intValue();
    } else {
      b = 0;
    } 
    a.put(paramString, String.valueOf(b + 1));
    a.put(paramString + "Time", y.a());
  }
  
  public static void a(String paramString1, String paramString2) {
    a.put(paramString1, paramString2);
  }
  
  private static class a<K, V> extends HashMap<K, V> {
    private a() {}
    
    public V a(Object param1Object, V param1V) {
      V v = param1V;
      if (containsKey(param1Object)) {
        v = param1V;
        if (get(param1Object) != null)
          v = get(param1Object); 
      } 
      return v;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */