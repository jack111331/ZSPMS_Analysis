package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.a;
import com.alipay.apmobilesecuritysdk.f.a;
import com.alipay.security.mobile.module.a.a;
import org.json.JSONObject;

public final class e {
  public static f a(Context paramContext) {
    if (paramContext == null)
      return null; 
    String str2 = a.a(paramContext, "device_feature_prefs_name", "device_feature_prefs_key");
    String str1 = str2;
    if (a.a(str2))
      str1 = a.a("device_feature_file_name", "device_feature_file_key"); 
    if (a.a(str1))
      return null; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(str1);
      f f = new f();
      this();
      f.a(jSONObject.getString("imei"));
      f.b(jSONObject.getString("imsi"));
      f.c(jSONObject.getString("mac"));
      f.d(jSONObject.getString("bluetoothmac"));
      f.e(jSONObject.getString("gsi"));
    } catch (Exception exception) {
      a.a(exception);
      exception = null;
    } 
    return (f)exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */