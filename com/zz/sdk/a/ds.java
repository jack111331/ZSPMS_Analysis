package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.zz.sdk.SDKManager;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.r;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.bx;
import com.zz.sdk.i.cp;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.third.a.a;
import com.zz.sdk.third.b.c;
import com.zz.sdk.third.c;
import com.zz.sdk.third.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ds extends w implements c {
  private static String o = "key_sys_config";
  
  private cq a;
  
  private boolean n = false;
  
  private boolean p;
  
  private boolean q;
  
  private List r = new ArrayList();
  
  private v s;
  
  private Runnable t = new ea(this);
  
  public ds(Activity paramActivity) {
    super(paramActivity);
  }
  
  public ds(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void G() {
    bv.a(this.b, fr.class, z().a("key_user", this.s), true);
  }
  
  private void H() {
    dw dw = new dw(this, new dt(this));
    cp.a().a(dw);
    p().setOnKeyListener(new dx(this));
  }
  
  private void I() {
    String str = cv.a(c.a.a(), "appId", "");
    if (!TextUtils.isEmpty(str)) {
      String str1 = cv.a(c.a.a(), "appKey", "");
      SDKManager.setThirdKey("QQ_APP_ID", str);
      SDKManager.setThirdKey("QQ_APP_KEY", str1);
    } 
    str = cv.a(c.c.a(), "appKey", "");
    if (!TextUtils.isEmpty(str))
      SDKManager.setThirdKey("WEIBO_APP_KEY", str); 
    str = cv.a(c.b.a(), "appId", "");
    if (!TextUtils.isEmpty(str)) {
      String str1 = cv.a(c.b.a(), "appSecret", "");
      SDKManager.setThirdKey("WE_CHAT_APP_ID", str);
      SDKManager.setThirdKey("WE_CHAT_APP_SECRET", str1);
    } 
  }
  
  private void a(r paramr) {
    if (paramr == null || !paramr.c()) {
      bv.d(this.b);
      h.a((Context)this.b, (a)paramr, null);
      return;
    } 
    cv.a(paramr);
    I();
    if (this.s != null) {
      if (this.q) {
        a(this.s);
        return;
      } 
      G();
      return;
    } 
    bv.a(this.b, fe.class, z().a("key_show_back", Boolean.valueOf(false)), true);
  }
  
  private void a(v paramv) {
    a.a().a((Context)this.b, paramv, new dy(this, paramv));
    b(2131165244, true);
  }
  
  private boolean a(Context paramContext) {
    if (!bx.e(paramContext))
      this.r.add("android.permission.READ_PHONE_STATE"); 
    if (!bx.b(paramContext))
      this.r.add("android.permission.WRITE_EXTERNAL_STORAGE"); 
    if (!bx.a(paramContext))
      this.r.add("android.permission.READ_EXTERNAL_STORAGE"); 
    if (!bx.a((Context)this.b, "android.permission.READ_SMS"))
      this.r.add("android.permission.READ_SMS"); 
    if (this.r.size() > 0) {
      String[] arrayOfString = (String[])this.r.toArray((Object[])new String[this.r.size()]);
      bx.a((Activity)paramContext, arrayOfString);
      return false;
    } 
    return true;
  }
  
  private void b(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      paramString = jSONObject.getJSONObject("buoyConf").getString("enable");
      if (paramString.equals("1")) {
        SDKManager.showFloatRemote = true;
        bp.b("浮标远程配置状态: 开启");
        return;
      } 
      if (paramString.equals("0")) {
        SDKManager.showFloatRemote = false;
        bp.b("浮标远程配置状态: 关闭");
      } 
    } catch (Exception exception) {}
  }
  
  void a() {
    this.a = cq.a((Context)this.b);
    this.j.getDelegate().a(0);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    super.a(paramInt1, paramInt2, paramIntent);
    d.a(this.b, paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent) {
    super.a(paramIntent);
    d.a(this.b, paramIntent);
  }
  
  public void a(c paramc) {
    this.n = false;
    this.k.removeCallbacks(this.t);
    r();
  }
  
  public void a(c paramc, a parama) {
    this.n = false;
    this.k.removeCallbacks(this.t);
    r();
    h.a((Context)this.b, this.a, parama, this.l);
  }
  
  public void a(c paramc, String paramString) {
    this.n = false;
    this.k.removeCallbacks(this.t);
    r();
    a(paramString);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.p = false;
    this.q = ((Boolean)a("key_auto_login", Boolean.valueOf(false))).booleanValue();
    this.m.o = 2;
  }
  
  int c() {
    return 0;
  }
  
  public void d() {
    super.d();
    d.a(this.b);
  }
  
  public void e() {
    super.e();
    d.b(this.b);
    if (this.n) {
      this.n = false;
      this.k.postDelayed(this.t, 1000L);
    } 
  }
  
  public void f() {
    t.a((Context)this.b).b("Login_main", "login_start", 1);
    b((CharSequence)null, false);
    a((Context)this.b);
    H();
  }
  
  protected View k() {
    return null;
  }
  
  public void s() {
    super.s();
    d.c(this.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */