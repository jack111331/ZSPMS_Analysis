package com.herosdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.herosdk.b.a;
import com.herosdk.bean.RoleInfo;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.g;
import com.herosdk.d.v;
import com.herosdk.d.x;
import org.json.JSONException;
import org.json.JSONObject;

class e implements Runnable {
  e(HeroSdk paramHeroSdk, Activity paramActivity, RoleInfo paramRoleInfo, int paramInt) {}
  
  public void run() {
    if (this.d.getUserInfo() == null) {
      Log.e("frameLib.HeroSdk", "用户未登录，无法上传角色");
      return;
    } 
    a.a().a((Context)this.a, this.b, this.c);
    if (!x.a().o().booleanValue() && !x.a().s().booleanValue())
      HeroSdk.a(this.d).getUser().submitRoleInfo(this.a, this.b, this.c); 
    g.a().a(this.b);
    x.a().O();
    PluginUtils.getInstance().invokePlugin(PluginNode.SUBMIT_ROLE_INFO, new Object[] { this.a, this.b, this.d.getUserInfo(), Integer.valueOf(this.c) });
    try {
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("action", "submitRoleInfo");
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("type", this.c);
      jSONObject2.put("roleId", this.b.getRoleId());
      jSONObject2.put("roleName", this.b.getRoleName());
      jSONObject2.put("serverId", this.b.getServerId());
      jSONObject2.put("serverName", this.b.getServerName());
      jSONObject2.put("roleLevel", this.b.getRoleLevel());
      jSONObject2.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("info", jSONObject2);
      v.a(this.a).a(jSONObject1.toString());
    } catch (JSONException jSONException) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */