package com.herosdk.b;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.d.ap;
import com.herosdk.d.r;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class t implements Runnable {
  t(a parama, RoleInfo paramRoleInfo, Context paramContext, int paramInt) {}
  
  public void run() {
    try {
      String str;
      UserInfo userInfo = x.a().h();
      if (userInfo == null) {
        Log.e(a.b(), "用户未登录");
        return;
      } 
      x.a().a(this.a);
      ar ar = a.a(this.d).a(this.b, userInfo.getUid(), userInfo.getUsername(), userInfo.getToken(), this.a, this.c);
      if (ar != null && ar.b()) {
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0) {
          Log.d(a.b(), "sr success");
        } else if (i == 1001) {
          Log.d(a.b(), "sr rak");
          this.d.a(this.b);
        } else if (i == 1002) {
          Log.d(a.b(), "sr ate");
          x.a().Q();
        } else {
          str = jSONObject.optString("msg");
          String str1 = a.b();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          Log.d(str1, stringBuilder.append("sr failed code:").append(i).append(",msg:").append(str).toString());
        } 
      } else {
        String str1 = a.b();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        Log.e(str1, stringBuilder.append("do sr but error:").append(str.a()).toString());
      } 
      if (this.c == 1 || this.c == 2)
        ap.a().a((Activity)this.b, this.a); 
      return;
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } finally {
      r.a().b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */