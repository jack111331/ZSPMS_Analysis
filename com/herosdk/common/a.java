package com.herosdk.common;

import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.b.ao;
import com.herosdk.bean.UserInfo;
import com.herosdk.d.g;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ILoginListener;
import org.json.JSONObject;

class a implements Runnable {
  a(JsCallbackUtils paramJsCallbackUtils, String paramString) {}
  
  public void run() {
    try {
      if (TextUtils.isEmpty(this.a)) {
        if (HeroSdk.getInstance().getLoginListener() != null)
          HeroSdk.getInstance().getLoginListener().onFailed("login result is empty"); 
        Log.d(JsCallbackUtils.a(), "l failed, data empty, return");
        return;
      } 
      jSONObject = new JSONObject();
      this(ao.c(this.a));
      i = jSONObject.optInt("code", -9999);
      if (i == 0) {
        Log.d(JsCallbackUtils.a(), "l success");
        UserInfo userInfo = new UserInfo();
        this();
        String str3 = jSONObject.optString("ocUid");
        userInfo.setUid(str3);
        String str4 = jSONObject.optString("roleId");
        userInfo.setUsername(jSONObject.optString("cName"));
        userInfo.setToken(jSONObject.optString("accessToken"));
        userInfo.setChannelToken(jSONObject.optString("cToken"));
        ao.a = jSONObject.optString("accessToken");
        userInfo.setServerMessage(jSONObject.optString("serverMsg"));
        if (!TextUtils.isEmpty(str3)) {
          g.a().a(str3, str4, userInfo);
        } else {
          Log.e(JsCallbackUtils.a(), "l but ocUid is empty error");
        } 
        if (HeroSdk.getInstance().getLoginListener() != null)
          HeroSdk.getInstance().getLoginListener().onSuccess(userInfo); 
        this.b.jsLoginRet(Boolean.valueOf(true));
        return;
      } 
    } catch (Exception exception) {
      Log.d(JsCallbackUtils.a(), "l Exception");
      this.b.jsLoginRet(Boolean.valueOf(false));
      ErrorUtils.printExceptionInfo(exception);
      if (HeroSdk.getInstance().getLoginListener() != null)
        HeroSdk.getInstance().getLoginListener().onFailed("code:-100,msg:" + exception.getMessage()); 
      return;
    } 
    String str2 = jSONObject.optString("msg");
    this.b.jsLoginRet(Boolean.valueOf(false));
    if (HeroSdk.getInstance().getLoginListener() != null) {
      ILoginListener iLoginListener = HeroSdk.getInstance().getLoginListener();
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      iLoginListener.onFailed(stringBuilder1.append("code:").append(i).append(",msg:").append(str2).toString());
    } 
    String str1 = JsCallbackUtils.a();
    StringBuilder stringBuilder = new StringBuilder();
    this();
    JSONObject jSONObject;
    int i;
    Log.d(str1, stringBuilder.append("l failed code:").append(i).append(",msg:").append(str2).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */