package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.a;
import com.alipay.apmobilesecuritysdk.e.e;
import com.alipay.apmobilesecuritysdk.e.f;
import com.alipay.apmobilesecuritysdk.f.a;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c {
  public static Map<String, String> a(Context paramContext) {
    String str6;
    b b = b.a();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    f f1 = e.a(paramContext);
    String str1 = b.a(paramContext);
    String str2 = b.b(paramContext);
    String str3 = b.k(paramContext);
    String str4 = b.n(paramContext);
    String str5 = b.m(paramContext);
    if (f1 != null) {
      str6 = str1;
      if (a.a(str1))
        str6 = f1.a(); 
      str1 = str2;
      if (a.a(str2))
        str1 = f1.b(); 
      str2 = str3;
      if (a.a(str3))
        str2 = f1.c(); 
      str3 = str4;
      if (a.a(str4))
        str3 = f1.d(); 
      str4 = str5;
      if (a.a(str5))
        str4 = f1.e(); 
      str5 = str6;
      str6 = str4;
      str4 = str3;
      str3 = str2;
      str2 = str5;
    } else {
      str6 = str5;
      str5 = str2;
      str2 = str1;
      str1 = str5;
    } 
    f f2 = new f(str2, str1, str3, str4, str6);
    if (paramContext != null)
      try {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put("imei", f2.a());
        jSONObject.put("imsi", f2.b());
        jSONObject.put("mac", f2.c());
        jSONObject.put("bluetoothmac", f2.d());
        jSONObject.put("gsi", f2.e());
        String str = jSONObject.toString();
        a.a("device_feature_file_name", "device_feature_file_key", str);
        a.a(paramContext, "device_feature_prefs_name", "device_feature_prefs_key", str);
      } catch (Exception exception) {
        a.a(exception);
      }  
    hashMap.put("AD1", str2);
    hashMap.put("AD2", str1);
    hashMap.put("AD3", b.f(paramContext));
    hashMap.put("AD5", b.h(paramContext));
    hashMap.put("AD6", b.i(paramContext));
    hashMap.put("AD7", b.j(paramContext));
    hashMap.put("AD8", str3);
    hashMap.put("AD9", b.l(paramContext));
    hashMap.put("AD10", str6);
    hashMap.put("AD11", b.e());
    hashMap.put("AD12", b.f());
    hashMap.put("AD13", b.g());
    hashMap.put("AD14", b.i());
    hashMap.put("AD15", b.j());
    hashMap.put("AD16", b.k());
    hashMap.put("AD17", "");
    hashMap.put("AD18", str4);
    hashMap.put("AD19", b.o(paramContext));
    hashMap.put("AD20", b.l());
    hashMap.put("AD21", b.d());
    hashMap.put("AD22", "");
    hashMap.put("AD23", b.m());
    hashMap.put("AD24", a.g(b.g(paramContext)));
    hashMap.put("AD26", b.e(paramContext));
    hashMap.put("AD27", b.r());
    hashMap.put("AD28", b.t());
    hashMap.put("AD29", b.v());
    hashMap.put("AD30", b.s());
    hashMap.put("AD31", b.u());
    hashMap.put("AD32", b.p());
    hashMap.put("AD33", b.q());
    hashMap.put("AD34", b.s(paramContext));
    hashMap.put("AD35", b.t(paramContext));
    hashMap.put("AD36", b.r(paramContext));
    hashMap.put("AD37", b.o());
    hashMap.put("AD38", b.n());
    hashMap.put("AD39", b.c(paramContext));
    hashMap.put("AD40", b.d(paramContext));
    hashMap.put("AD41", b.b());
    hashMap.put("AD42", b.c());
    hashMap.put("AL3", b.p(paramContext));
    return (Map)hashMap;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */