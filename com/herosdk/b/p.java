package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.bean.UserInfo;
import com.herosdk.bean.e;
import com.herosdk.d.bb;
import com.herosdk.d.r;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ILoginListener;
import org.json.JSONObject;

class p implements Runnable {
  p(a parama, ILoginListener paramILoginListener, Context paramContext, UserInfo paramUserInfo, String paramString) {}
  
  public void run() {
    try {
      String str;
      if (this.a == null) {
        Log.e(a.b(), "l listener is null");
        return;
      } 
      ar ar = a.a(this.e).a(this.b, this.c.getUid(), this.c.getUsername(), this.c.getToken(), this.d);
      if (ar != null && ar.b()) {
        q q;
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0 || i == 1003) {
          Log.d(a.b(), "l success");
          UserInfo userInfo = new UserInfo();
          this();
          userInfo.setUid(jSONObject.optString("cUid"));
          userInfo.setUsername(jSONObject.optString("cName"));
          userInfo.setToken(jSONObject.optString("accessToken"));
          userInfo.setChannelToken(jSONObject.optString("cToken"));
          ao.a = jSONObject.optString("accessToken");
          userInfo.setServerMessage(jSONObject.optString("serverMsg"));
          if (jSONObject.optInt("firstLgn") == 1) {
            userInfo.setIsFirstLogin(Boolean.valueOf(true));
          } else {
            userInfo.setIsFirstLogin(Boolean.valueOf(false));
          } 
          if (jSONObject.optInt("swSingleLogin", -1) == 1) {
            if (jSONObject.optInt("isForce", -1) == 1) {
              x x = x.a();
              e e = new e();
              this(Boolean.valueOf(true), jSONObject.optString("swSingleLoginUrl"), Boolean.valueOf(true));
              x.f(e);
            } else {
              x x = x.a();
              e e = new e();
              this(Boolean.valueOf(true), jSONObject.optString("swSingleLoginUrl"), Boolean.valueOf(false));
              x.f(e);
            } 
          } else {
            x x = x.a();
            e e = new e();
            this(Boolean.valueOf(false), "");
            x.f(e);
          } 
          i = jSONObject.optInt("idStat", 0);
          String str1 = a.b();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          Log.d(str1, stringBuilder.append("l is:").append(i).toString());
          if (i == 0) {
            this.a.onSuccess(userInfo);
          } else {
            int j = jSONObject.optInt("cIdStat", 0);
            String str2 = a.b();
            StringBuilder stringBuilder1 = new StringBuilder();
            this();
            Log.d(str2, stringBuilder1.append("l cis:").append(j).toString());
            if (j == 1) {
              String str3 = jSONObject.optString("idStatMsg", "");
              str2 = a.b();
              stringBuilder1 = new StringBuilder();
              this();
              Log.d(str2, stringBuilder1.append("l c isMsg:").append(str3).toString());
              JSONObject jSONObject1 = new JSONObject();
              this();
              jSONObject1.put("cIdStatus", j);
              if (HeroSdk.getInstance().getIdentifyLoginListener() != null) {
                Log.d(a.b(), "l c onResult");
                HeroSdk.getInstance().getIdentifyLoginListener().onResult(this.a, userInfo, jSONObject1.toString(), i, str3);
              } else {
                Log.d(a.b(), "l c onSuccess");
                this.a.onSuccess(userInfo);
              } 
            } else {
              q = new q();
              this(this, userInfo);
              bb.a(i, q);
            } 
          } 
        } else if (i == 1001) {
          Log.d(a.b(), "l rak");
          this.e.a(this.b);
        } else {
          ILoginListener iLoginListener;
          if (i == 1005) {
            Log.d(a.b(), "l np");
            str = q.optString("msg");
            if (!TextUtils.isEmpty(str)) {
              r r = new r();
              this(this, str, i);
              bb.a(r);
            } else {
              Log.d(a.b(), "l np...else msg is empty");
              iLoginListener = this.a;
              StringBuilder stringBuilder = new StringBuilder();
              this();
              iLoginListener.onFailed(stringBuilder.append("code:").append(i).append(",msg:").append(str).toString());
            } 
          } else {
            str = iLoginListener.optString("msg");
            iLoginListener = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            this();
            iLoginListener.onFailed(stringBuilder.append("code:").append(i).append(",msg:").append(str).toString());
            String str1 = a.b();
            stringBuilder = new StringBuilder();
            this();
            Log.d(str1, stringBuilder.append("l failed code:").append(i).append(",msg:").append(str).toString());
          } 
        } 
      } else {
        String str1 = a.b();
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        Log.e(str1, stringBuilder2.append("do l but error:").append(str.a()).toString());
        ILoginListener iLoginListener = this.a;
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        iLoginListener.onFailed(stringBuilder1.append("code:").append(str.a()).append(",msg:登录失败").toString());
      } 
      return;
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      ILoginListener iLoginListener = this.a;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      iLoginListener.onFailed(stringBuilder.append("code:-100,msg:").append(exception.getMessage()).toString());
      return;
    } finally {
      r.a().b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */