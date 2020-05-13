package com.herosdk.listener;

import android.app.Activity;
import com.herosdk.bean.UserInfo;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginStatus;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.v;
import com.herosdk.d.x;
import org.json.JSONException;
import org.json.JSONObject;

class s implements Runnable {
  s(r paramr, UserInfo paramUserInfo) {}
  
  public void run() {
    x.a().a(this.a);
    x.a().T();
    x.a().P();
    if (r.a(this.b) != null)
      r.a(this.b).onSuccess(this.a); 
    try {
      Activity activity = x.a().x();
      PluginUtils.getInstance().invokePlugin(PluginNode.AFTER_LOGIN, new Object[] { x.a().x(), PluginStatus.LOGIN_SUCCESS, this.a });
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("action", "login");
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("status", "success");
      jSONObject2.put("uid", this.a.getUid());
      jSONObject2.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("info", jSONObject2);
      v.a(activity).a(jSONObject1.toString());
    } catch (JSONException jSONException) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */