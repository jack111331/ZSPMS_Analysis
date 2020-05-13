package com.herosdk.listener;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.v;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class z implements Runnable {
  z(y paramy, String paramString1, String paramString2, String paramString3) {}
  
  public void run() {
    if (y.a(this.d) != null)
      if (!x.a().v()) {
        x.a().c(0);
        y.a(this.d).onSuccess(this.a, this.b, this.c);
      } else {
        (new Handler(Looper.getMainLooper())).postDelayed(new aa(this), 3000L);
      }  
    try {
      Activity activity = x.a().x();
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_PAY, new Object[] { activity, PluginStatus.PAY_SUCCESS, this.b, y.a(this.d, this.a, this.b) });
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("action", "pay");
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("status", "success");
      jSONObject2.put("sdkOrderId", this.a);
      jSONObject2.put("cpOrderId", this.b);
      jSONObject2.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("info", jSONObject2);
      v.a(activity).a(jSONObject1.toString());
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */