package com.herosdk.listener;

import android.app.Activity;
import android.content.Context;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.v;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class o implements Runnable {
  o(m paramm, String paramString) {}
  
  public void run() {
    if (m.a(this.b) != null)
      m.a(this.b).onFailed(this.a); 
    try {
      Activity activity = x.a().x();
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_INIT, new Object[] { x.a().x(), PluginStatus.INIT_FAILED });
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("action", "init");
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("status", "failed");
      jSONObject2.put("deviceId", x.a().c((Context)x.a().x()));
      jSONObject2.put("msg", this.a);
      jSONObject2.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("info", jSONObject2);
      v.a(activity).a(jSONObject1.toString());
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */