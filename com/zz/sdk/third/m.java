package com.zz.sdk.third;

import android.os.Handler;
import android.text.TextUtils;
import com.zz.sdk.i.t;
import com.zz.sdk.third.a.a;
import org.json.JSONObject;

class m extends Thread {
  m(l paraml, String paramString, a parama, c paramc) {}
  
  public void run() {
    String str = t.a(this.d.b.a.getApplicationContext()).a(String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", new Object[] { this.d.b.f, this.d.b.g, this.a }), 1);
    if (!TextUtils.isEmpty(str))
      try {
        JSONObject jSONObject = new JSONObject();
        this(str);
        if (jSONObject.optInt("errcode", 0) == 0) {
          str = jSONObject.optString("access_token", null);
          int i = jSONObject.optInt("expires_in");
          String str1 = jSONObject.optString("openid", null);
          if (!TextUtils.isEmpty(str)) {
            this.b.c(str);
            this.b.a(i);
            this.b.b(str1);
            Handler handler = this.d.b.c;
            n n = new n();
            this(this);
            handler.post(n);
            return;
          } 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    this.d.b.c.post(new o(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */