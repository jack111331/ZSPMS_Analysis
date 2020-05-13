package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.i;
import org.json.JSONObject;

public final class a {
  public static final int a = 3500;
  
  public static final String b = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";
  
  public static final int c = 1000;
  
  public static final int d = 20000;
  
  public static final String e = "alipay_cashier_dynamic_config";
  
  public static final String f = "timeout";
  
  public static final String g = "st_sdk_config";
  
  public static final String h = "tbreturl";
  
  private static a k;
  
  int i = 3500;
  
  public String j = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";
  
  private void a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        this.i = jSONObject.optInt("timeout", 3500);
        this.j = jSONObject.optString("tbreturl", "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&").trim();
      } catch (Throwable throwable) {} 
  }
  
  public static a b() {
    if (k == null) {
      a a1 = new a();
      k = a1;
      String str = i.b((b.a()).a, "alipay_cashier_dynamic_config", null);
      if (!TextUtils.isEmpty(str))
        try {
          JSONObject jSONObject = new JSONObject();
          this(str);
          a1.i = jSONObject.optInt("timeout", 3500);
          a1.j = jSONObject.optString("tbreturl", "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&").trim();
        } catch (Throwable throwable) {} 
    } 
    return k;
  }
  
  private void b(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        JSONObject jSONObject2 = new JSONObject();
        this(paramString);
        JSONObject jSONObject1 = jSONObject2.optJSONObject("st_sdk_config");
        this.i = jSONObject1.optInt("timeout", 3500);
        this.j = jSONObject1.optString("tbreturl", "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&").trim();
      } catch (Throwable throwable) {} 
  }
  
  private String c() {
    return this.j;
  }
  
  private void d() {
    String str = i.b((b.a()).a, "alipay_cashier_dynamic_config", null);
    if (!TextUtils.isEmpty(str))
      try {
        JSONObject jSONObject = new JSONObject();
        this(str);
        this.i = jSONObject.optInt("timeout", 3500);
        this.j = jSONObject.optString("tbreturl", "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&").trim();
      } catch (Throwable throwable) {} 
  }
  
  private void e() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("timeout", a());
      jSONObject.put("tbreturl", this.j);
      i.a((b.a()).a, "alipay_cashier_dynamic_config", jSONObject.toString());
    } catch (Exception exception) {}
  }
  
  public final int a() {
    if (this.i < 1000 || this.i > 20000)
      return 3500; 
    (new StringBuilder("DynamicConfig::getJumpTimeout >")).append(this.i);
    return this.i;
  }
  
  public final void a(Context paramContext) {
    (new Thread(new b(this, paramContext))).start();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\data\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */