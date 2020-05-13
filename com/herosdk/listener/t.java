package com.herosdk.listener;

import android.app.Activity;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.v;
import com.herosdk.d.x;
import org.json.JSONException;
import org.json.JSONObject;

class t implements Runnable {
  t(r paramr, String paramString) {}
  
  public void run() {
    if (r.a(this.b) != null)
      r.a(this.b).onFailed(this.a); 
    x.a().i(this.a);
    try {
      Activity activity = x.a().x();
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_LOGIN, new Object[] { activity, PluginStatus.LOGIN_FAILED });
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("action", "login");
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("status", "failed");
      jSONObject2.put("msg", this.a);
      jSONObject2.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("info", jSONObject2);
      v.a(activity).a(jSONObject1.toString());
    } catch (JSONException jSONException) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */