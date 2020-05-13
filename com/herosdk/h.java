package com.herosdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.bb;
import com.herosdk.d.v;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class h implements Runnable {
  h(g paramg, String paramString1, String paramString2, String paramString3) {}
  
  public void run() {
    try {
      if (!TextUtils.isEmpty(this.a))
        this.d.a.b.setSdkOrderId(this.a); 
      if (!TextUtils.isEmpty(this.b))
        this.d.a.b.setExtraParams(this.b); 
      if (x.a().q().booleanValue()) {
        bb.b((Context)this.d.a.a, x.a().r().b());
        return;
      } 
      PluginUtils.getInstance().invokePlugin(PluginNode.BEFORE_CHANNEL_PAY, new Object[] { this.d.a.a, this.d.a.b, this.d.a.c, this.d.a.d.getUserInfo(), this.a, this.c, this.b });
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("action", "pay");
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("status", "channelPay");
      jSONObject2.put("roleId", this.d.a.c.getRoleId());
      jSONObject2.put("roleName", this.d.a.c.getRoleName());
      jSONObject2.put("serverId", this.d.a.c.getServerId());
      jSONObject2.put("serverName", this.d.a.c.getServerName());
      jSONObject2.put("roleLevel", this.d.a.c.getRoleLevel());
      jSONObject2.put("goodsId", this.d.a.b.getGoodsId());
      jSONObject2.put("amount", this.d.a.b.getAmount());
      jSONObject2.put("cpOrderId", this.d.a.b.getCpOrderId());
      jSONObject2.put("sdkOrderId", this.d.a.b.getSdkOrderId());
      jSONObject2.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("info", jSONObject2);
      v.a(this.d.a.a).a(jSONObject1.toString());
      Log.d("frameLib.HeroSdk", "do channel pay");
      HeroSdk.a(this.d.a.d).getPay().pay(this.d.a.a, this.d.a.b, this.d.a.c);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */