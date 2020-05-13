package com.herosdk.listener;

import android.app.Activity;
import com.herosdk.HeroSdk;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.v;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class ad implements Runnable {
  ad(y paramy, String paramString1, String paramString2) {}
  
  public void run() {
    if (!x.a().v()) {
      y.a(this.c).onFailed(this.a, this.b);
    } else if (HeroSdk.getInstance().getSinglePayListener() != null) {
      HeroSdk.getInstance().getSinglePayListener().onFailed("", this.a, -99999);
    } 
    try {
      Activity activity = x.a().x();
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_PAY, new Object[] { activity, PluginStatus.PAY_FAILED, this.a, this.b, y.a(this.c, "", this.a) });
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("action", "pay");
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("status", "failed");
      jSONObject2.put("msg", this.b);
      jSONObject2.put("cpOrderId", this.a);
      jSONObject2.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("info", jSONObject2);
      v.a(activity).a(jSONObject1.toString());
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */