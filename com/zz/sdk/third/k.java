package com.zz.sdk.third;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.third.a.a;
import com.zz.sdk.third.b.c;
import java.util.Map;

public class k extends a {
  public static c d;
  
  public static String e = "";
  
  private static final String j = "snsapi_userinfo";
  
  private static final String k = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
  
  public String f;
  
  public String g;
  
  public String h;
  
  private Object i;
  
  public k(Activity paramActivity) {
    super(paramActivity);
  }
  
  private IWXAPI a(String paramString) {
    if (this.i != null)
      return (IWXAPI)this.i; 
    if (TextUtils.isEmpty(paramString)) {
      Toast.makeText((Context)this.a, "未配置[WE_CHAT_APP_ID]", 1).show();
      return null;
    } 
    IWXAPI iWXAPI = WXAPIFactory.createWXAPI((Context)this.a, paramString);
    iWXAPI.registerApp(paramString);
    this.i = iWXAPI;
    return iWXAPI;
  }
  
  public static void a(Activity paramActivity, BaseResp paramBaseResp) {
    b(paramActivity, paramBaseResp);
  }
  
  private static void b(Activity paramActivity, BaseResp paramBaseResp) {
    a a1;
    if (d == null)
      return; 
    try {
      if (!(paramBaseResp instanceof SendAuth.Resp)) {
        RuntimeException runtimeException = new RuntimeException();
        this("resp not instanceof SendAuth.Resp");
        throw runtimeException;
      } 
    } catch (Throwable throwable) {
      if (d != null)
        d.a(c.b, null); 
      d = null;
      return;
    } 
    SendAuth.Resp resp = (SendAuth.Resp)paramBaseResp;
    switch (paramBaseResp.errCode) {
      default:
        if (d != null)
          d.a(c.b, null); 
        d = null;
        return;
      case 0:
        a1 = new a();
        this(c.b);
        a1.c(resp.code);
        if (d != null)
          d.a(c.b, a1); 
        d = null;
        return;
      case -2:
        if (d != null)
          d.a(c.b); 
        d = null;
        return;
      case -4:
        break;
    } 
    if (d != null)
      d.a(c.b, null); 
    d = null;
  }
  
  public void a(c paramc) {
    d = new l(this, paramc);
    try {
      IWXAPI iWXAPI = a(this.f);
      if (iWXAPI == null) {
        throwable = new RuntimeException();
        this("IWXAPI is null");
        throw throwable;
      } 
    } catch (Throwable throwable) {
      d.a(e(), null);
      return;
    } 
    if (!throwable.isWXAppInstalled()) {
      d.a(e(), this.a.getString(ci.a((Context)this.a, 2131165260)));
      return;
    } 
    SendAuth.Req req = new SendAuth.Req();
    this();
    req.scope = this.h;
    req.state = "zz_sdk";
    throwable.sendReq((BaseReq)req);
  }
  
  void a(Map paramMap) {
    Object object = null;
    if (paramMap != null) {
      String str;
      Object object1 = paramMap.get("WE_CHAT_APP_ID");
      if (object1 == null) {
        object1 = null;
      } else {
        object1 = object1 + "";
      } 
      this.f = (String)object1;
      e = (String)object1;
      object1 = paramMap.get("WE_CHAT_APP_SECRET");
      if (object1 == null) {
        object1 = object;
      } else {
        object1 = object1 + "";
      } 
      this.g = (String)object1;
      paramMap = (Map)paramMap.get("WE_CHAT_SCOPE");
      if (paramMap == null) {
        str = "snsapi_userinfo";
      } else {
        str = str + "";
      } 
      this.h = str;
    } 
    if (TextUtils.isEmpty(this.f))
      bp.b("未配置[WE_CHAT_APP_ID]"); 
    if (TextUtils.isEmpty(this.g))
      bp.b("未配置[WE_CHAT_APP_SECRET]"); 
  }
  
  public void b() {
    super.b();
    if (this.i != null)
      ((IWXAPI)this.i).unregisterApp(); 
    d = null;
  }
  
  public c e() {
    return c.b;
  }
  
  public boolean f() {
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */