package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.alipay.sdk.util.k;
import org.json.JSONObject;

final class b implements Runnable {
  b(a parama, Context paramContext) {}
  
  public final void run() {
    try {
      com.alipay.sdk.packet.impl.b b2 = new com.alipay.sdk.packet.impl.b();
      this();
      Context context = this.a;
      com.alipay.sdk.packet.b b1 = b2.a(context, "", k.a(context), true);
      if (b1 != null) {
        a a1 = this.b;
        String str = b1.b;
        boolean bool = TextUtils.isEmpty(str);
        if (!bool)
          try {
            JSONObject jSONObject2 = new JSONObject();
            this(str);
            JSONObject jSONObject1 = jSONObject2.optJSONObject("st_sdk_config");
            a1.i = jSONObject1.optInt("timeout", 3500);
            a1.j = jSONObject1.optString("tbreturl", "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&").trim();
          } catch (Throwable throwable) {} 
        a1 = this.b;
        try {
          JSONObject jSONObject = new JSONObject();
          this();
          jSONObject.put("timeout", a1.a());
          jSONObject.put("tbreturl", a1.j);
          i.a((com.alipay.sdk.sys.b.a()).a, "alipay_cashier_dynamic_config", jSONObject.toString());
        } catch (Exception exception) {}
      } 
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\data\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */