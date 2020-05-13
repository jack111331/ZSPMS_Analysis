package com.zz.sdk.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import com.zz.sdk.LoginCallbackInfo;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.i;
import com.zz.sdk.g.a;
import com.zz.sdk.i.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.bx;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class bi extends a {
  private Handler A = new Handler();
  
  private Runnable B = new bl(this);
  
  public int o;
  
  private cq p;
  
  private String q;
  
  private int r;
  
  private String s;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private bn w;
  
  private Stack x = new Stack();
  
  private List y = new ArrayList();
  
  private int z = 0;
  
  public bi(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    bp.a("LoginMainLayout constructor");
    d(paramContext);
    Drawable drawable = cv.r(paramContext);
    if (drawable == null) {
      setBackgroundColor(0);
    } else {
      setBackgroundDrawable(drawable);
    } 
    b(paramContext);
  }
  
  private View a(Context paramContext, boolean paramBoolean) {
    return null;
  }
  
  private void a(a parama) {
    if (parama.c()) {
      c(((i)parama).G);
      return;
    } 
    if (parama.e()) {
      a(parama.f());
      return;
    } 
    a(cg.al);
  }
  
  private void a(String paramString1, String paramString2) {
    bk bk = new bk(this);
    setCurrentTask(bq.a(this.p, bk, this, paramString1, paramString2));
  }
  
  private void c(String paramString) {}
  
  private void d(Context paramContext) {
    if (!bx.e(paramContext))
      this.y.add("android.permission.READ_PHONE_STATE"); 
    if (!bx.b(paramContext))
      this.y.add("android.permission.WRITE_EXTERNAL_STORAGE"); 
    if (!bx.a(paramContext))
      this.y.add("android.permission.READ_EXTERNAL_STORAGE"); 
    if (this.y.size() > 0) {
      String[] arrayOfString = (String[])this.y.toArray((Object[])new String[this.y.size()]);
      bx.a((Activity)paramContext, arrayOfString);
    } 
  }
  
  private View v() {
    cv.a(this.f, findFocus());
    View view = null;
    if (this.x.size() > 1) {
      ((View)this.x.pop()).clearFocus();
      view = this.x.peek();
    } 
    return view;
  }
  
  private void w() {
    a(-1L, (String)null);
  }
  
  private void x() {
    w();
    a(cg.an);
  }
  
  private void y() {
    if (this.v)
      try {
        if (Build.VERSION.SDK_INT < 17 || !getActivity().isDestroyed()) {
          bn bn1 = new bn();
          this((Context)getActivity());
          this.w = bn1;
          this.w.show();
          this.A.postDelayed(this.B, 2000L);
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  private void z() {
    this.z = 0;
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    boolean bool4;
    boolean bool2 = true;
    this.o = 3;
    Boolean bool3 = (Boolean)paramParamChain.get("global.caller.login_douqu_enabled", Boolean.class);
    if (bool3 != null && bool3.booleanValue() && !a.a()) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    this.t = bool4;
    bool3 = (Boolean)paramParamChain.get("global.caller.login_auto_start", Boolean.class);
    if (bool3 != null && bool3.booleanValue()) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    this.v = bool4;
    Boolean bool1 = (Boolean)paramParamChain.get("global.caller.is_platform", Boolean.class);
    if (bool1 != null && bool1.booleanValue()) {
      bool4 = bool2;
    } else {
      bool4 = false;
    } 
    this.u = bool4;
    this.p = cq.a(paramContext);
  }
  
  public void a(ParamChain paramParamChain, int paramInt) {
    switch (paramInt) {
      default:
        b = -2;
        str = this.p.j();
        loginCallbackInfo = new LoginCallbackInfo();
        loginCallbackInfo.statusCode = b;
        loginCallbackInfo.loginName = str;
        loginCallbackInfo.sdkuserid = this.p.s();
        loginCallbackInfo.mAntiAddiciton = this.p.x();
        loginCallbackInfo.authCode = this.p.u();
        loginCallbackInfo.accessToken = this.p.v();
        a(0, paramInt, loginCallbackInfo);
        return;
      case 0:
        if (this.u) {
          paramInt = 4;
          b = 1;
        } else {
          b = 0;
        } 
        str = this.p.j();
        loginCallbackInfo = new LoginCallbackInfo();
        loginCallbackInfo.statusCode = b;
        loginCallbackInfo.loginName = str;
        loginCallbackInfo.sdkuserid = this.p.s();
        loginCallbackInfo.mAntiAddiciton = this.p.x();
        loginCallbackInfo.authCode = this.p.u();
        loginCallbackInfo.accessToken = this.p.v();
        a(0, paramInt, loginCallbackInfo);
        return;
      case 1:
        break;
    } 
    byte b = -1;
    String str = this.p.j();
    LoginCallbackInfo loginCallbackInfo = new LoginCallbackInfo();
    loginCallbackInfo.statusCode = b;
    loginCallbackInfo.loginName = str;
    loginCallbackInfo.sdkuserid = this.p.s();
    loginCallbackInfo.mAntiAddiciton = this.p.x();
    loginCallbackInfo.authCode = this.p.u();
    loginCallbackInfo.accessToken = this.p.v();
    a(0, paramInt, loginCallbackInfo);
  }
  
  protected void b(Context paramContext) {}
  
  public boolean j() {
    boolean bool = super.j();
    if (bool) {
      this.o = 2;
      setActivityControlInterface((a)new bj(this));
    } 
    return bool;
  }
  
  public boolean l() {
    return super.l();
  }
  
  protected void m() {
    if (this.o != 3)
      a(getEnv(), this.o); 
    a(0, 3, (Object)null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */