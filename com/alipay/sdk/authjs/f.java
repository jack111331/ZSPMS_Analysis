package com.alipay.sdk.authjs;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

final class f extends TimerTask {
  f(d paramd, a parama) {}
  
  public final void run() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("toastCallBack", "true");
    } catch (JSONException jSONException) {}
    a a1 = new a("callback");
    a1.i = this.a.i;
    a1.m = jSONObject;
    this.b.a.a(a1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\authjs\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */