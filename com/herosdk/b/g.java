package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.d.az;
import com.herosdk.d.bb;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class g implements Runnable {
  g(a parama, Context paramContext, RoleInfo paramRoleInfo) {}
  
  public void run() {
    try {
      UserInfo userInfo = x.a().h();
      if (userInfo == null) {
        Log.e(a.b(), "用户未登录");
        return;
      } 
      ar ar = a.a(this.c).a(this.a, userInfo.getUid(), userInfo.getUsername(), userInfo.getToken(), this.b);
      if (ar != null && ar.b()) {
        h h;
        String str1;
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0 || i == 1003) {
          int j = jSONObject.optInt("idStat", 0);
          String str4 = a.b();
          StringBuilder stringBuilder2 = new StringBuilder();
          this();
          Log.d(str4, stringBuilder2.append("rom is:").append(j).toString());
          if (j != 0) {
            i = jSONObject.optInt("cIdStat", 0);
            String str5 = a.b();
            StringBuilder stringBuilder3 = new StringBuilder();
            this();
            Log.d(str5, stringBuilder3.append("rom cis:").append(i).toString());
            if (i == 1) {
              str1 = jSONObject.optString("idStatMsg", "");
              str5 = a.b();
              stringBuilder3 = new StringBuilder();
              this();
              Log.d(str5, stringBuilder3.append("rom isMsg:").append(str1).toString());
              if (HeroSdk.getInstance().getIdentifyOnlineListener() != null)
                HeroSdk.getInstance().getIdentifyOnlineListener().onResult(j, str1); 
              return;
            } 
            if (!az.a.booleanValue()) {
              h = new h();
              this(this);
              bb.a(j, h);
            } 
          } 
          return;
        } 
        if (i == 1001) {
          Log.d(a.b(), "rom rak");
          this.c.a(this.a);
          return;
        } 
        if (i == 1002) {
          Log.d(a.b(), "rom ate");
          x.a().Q();
          return;
        } 
        if (i == 1004) {
          Log.d(a.b(), "rom nk");
          if (!az.b.booleanValue()) {
            Log.d(a.b(), "rom nk...if");
            x.a().g(true);
            str1 = h.optString("msg");
            if (HeroSdk.getInstance().getChannelAccountOffLineListener() != null)
              HeroSdk.getInstance().getChannelAccountOffLineListener().onKick(0, str1); 
            if (HeroSdk.getInstance().getKickListener() != null)
              HeroSdk.getInstance().getKickListener().onKick(0, str1); 
          } 
          return;
        } 
        if (i == 1005 && !az.c.booleanValue()) {
          Log.d(a.b(), "rom np");
          str1 = str1.optString("msg");
          if (!TextUtils.isEmpty(str1)) {
            i i1 = new i();
            this(this, str1);
            bb.a(i1);
          } 
          return;
        } 
        String str2 = str1.optString("msg");
        String str3 = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.d(str3, stringBuilder1.append("rom failed code:").append(i).append(",msg:").append(str2).toString());
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    String str = a.b();
    StringBuilder stringBuilder = new StringBuilder();
    this();
    Log.e(str, stringBuilder.append("do rom but error:").append(exception.a()).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */