package com.zz.sdk.third;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.zz.sdk.i.bp;
import com.zz.sdk.third.a.a;
import com.zz.sdk.third.b.c;
import java.util.Map;

public class h extends a {
  private static final String d = "https://api.weibo.com/oauth2/default.html";
  
  private static final String e = "";
  
  private String f;
  
  private String g;
  
  private String h;
  
  private c i;
  
  private Object j;
  
  public h(Activity paramActivity) {
    super(paramActivity);
  }
  
  private SsoHandler a(String paramString1, String paramString2, String paramString3, c paramc) {
    String str = null;
    if (this.j != null)
      return (SsoHandler)this.j; 
    if (TextUtils.isEmpty(paramString1)) {
      Toast.makeText((Context)this.a, "未配置[WEIBO_APP_KEY]", 1).show();
      paramString1 = str;
      if (paramc != null) {
        paramc.a(e(), null);
        paramString1 = str;
      } 
      return (SsoHandler)paramString1;
    } 
    AuthInfo authInfo = new AuthInfo((Context)this.a, paramString1, paramString2, paramString3);
    SsoHandler ssoHandler = new SsoHandler(this.a, authInfo);
    this.j = ssoHandler;
    return ssoHandler;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.j != null)
      ((SsoHandler)this.j).authorizeCallBack(paramInt1, paramInt2, paramIntent); 
  }
  
  public void a(c paramc) {
    SsoHandler ssoHandler = a(this.f, this.g, this.h, paramc);
    if (ssoHandler != null) {
      this.i = paramc;
      ssoHandler.authorize(new j(this, null));
    } 
  }
  
  void a(Map paramMap) {
    if (paramMap != null) {
      String str;
      Object object = paramMap.get("WEIBO_APP_KEY");
      if (object == null) {
        object = null;
      } else {
        object = object + "";
      } 
      this.f = (String)object;
      object = paramMap.get("WEIBO_REDIRECT_URL");
      if (object == null) {
        object = "https://api.weibo.com/oauth2/default.html";
      } else {
        object = object + "";
      } 
      this.g = (String)object;
      paramMap = (Map)paramMap.get("WEIBO_SCOPE");
      if (paramMap == null) {
        str = "";
      } else {
        str = str + "";
      } 
      this.h = str;
    } 
    if (TextUtils.isEmpty(this.f))
      bp.b("未配置[QQ_APP_ID]"); 
  }
  
  public c e() {
    return c.c;
  }
  
  public boolean f() {
    a a1 = c();
    return (a1 == null) ? false : (new Oauth2AccessToken(a1.e(), a1.f() + "")).isSessionValid();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */