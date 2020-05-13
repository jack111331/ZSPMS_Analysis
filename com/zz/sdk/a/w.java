package com.zz.sdk.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.zz.sdk.d.b;
import com.zz.sdk.d.c;
import com.zz.sdk.e.bi;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;
import java.util.Map;

public abstract class w extends lj implements b, c {
  private Toast a;
  
  protected Activity b;
  
  protected View c;
  
  protected LinearLayout d;
  
  protected TextView e;
  
  protected View f;
  
  protected LinearLayout g;
  
  protected View h;
  
  protected FrameLayout i;
  
  protected RoundLinearLayout j;
  
  protected Handler k = new Handler();
  
  protected w l;
  
  @Deprecated
  protected bi m;
  
  private fc n;
  
  private boolean o = false;
  
  private Map p;
  
  private boolean q;
  
  private boolean r;
  
  private boolean s;
  
  private CharSequence t;
  
  private boolean u = false;
  
  private boolean x = true;
  
  public w(Activity paramActivity) {
    this(paramActivity, ci.a((Context)paramActivity, 2131230727));
  }
  
  public w(Activity paramActivity, int paramInt) {
    super((Context)paramActivity, paramInt);
    a(paramActivity);
  }
  
  private void a(Activity paramActivity) {
    getWindow().requestFeature(1);
    this.l = this;
    this.b = paramActivity;
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    super.setContentView(ci.a((Context)paramActivity, 2130903061));
  }
  
  private void b(View paramView) {
    this.h = paramView.findViewById(ci.a((Context)this.b, 2131296647));
    this.c = paramView.findViewById(ci.a((Context)this.b, 2131296649));
    this.c.setOnClickListener(new x(this));
    this.d = (LinearLayout)paramView.findViewById(ci.a((Context)this.b, 2131296648));
    this.e = (TextView)paramView.findViewById(ci.a((Context)this.b, 2131296650));
    this.f = paramView.findViewById(ci.a((Context)this.b, 2131296652));
    this.f.setOnClickListener(new y(this));
    this.g = (LinearLayout)paramView.findViewById(ci.a((Context)this.b, 2131296651));
  }
  
  protected void A() {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
    layoutParams.setMargins(0, 0, 0, 0);
    this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  protected void B() {
    bp.a("BaseViewDialog...showKlClose");
    ImageView imageView = (ImageView)findViewById(2131296401);
    imageView.setVisibility(0);
    imageView.setOnClickListener(new z(this));
  }
  
  protected boolean C() {
    boolean bool = false;
    bp.a("BaseViewDialog...isUserPlatform");
    if (this.m != null) {
      Boolean bool1 = (Boolean)this.m.getEnv().get("global.caller.is_platform", Boolean.class);
      if (bool1 == null)
        return false; 
      bool = bool1.booleanValue();
    } 
    return bool;
  }
  
  public int a(View paramView) {
    boolean bool2;
    boolean bool1 = false;
    Object object = paramView.getTag(paramView.getId());
    if (object == null)
      return bool1; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      bool2 = Integer.parseInt(stringBuilder.append(object).append("").toString());
    } catch (Exception exception) {
      exception.printStackTrace();
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public Object a(String paramString) {
    return a(paramString, (Object)null);
  }
  
  public Object a(String paramString, Object paramObject) {
    if (this.p != null) {
      paramString = (String)this.p.get(paramString);
      if (paramString != null)
        paramObject = paramString; 
    } 
    return paramObject;
  }
  
  abstract void a();
  
  public void a(int paramInt) {
    if (this.e != null)
      this.e.setTextColor(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(@StringRes int paramInt, boolean paramBoolean) {
    a(d(paramInt), 0, false);
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(CharSequence paramCharSequence) {
    a(paramCharSequence, 0);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt) {
    a(paramCharSequence, 0, false);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean) {
    if (!this.o && !TextUtils.isEmpty(paramCharSequence)) {
      if (paramBoolean) {
        Toast.makeText((Context)this.b, paramCharSequence, paramInt).show();
        return;
      } 
      if (this.a != null)
        this.a.cancel(); 
      this.a = Toast.makeText((Context)this.b, paramCharSequence, paramInt);
      this.a.show();
    } 
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean) {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void a(Runnable paramRunnable) {
    this.k.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong) {
    this.k.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(Map paramMap) {
    this.p = paramMap;
    this.q = ((Boolean)a("key_show_back", Boolean.valueOf(true))).booleanValue();
    this.r = ((Boolean)a("key_show_close", Boolean.valueOf(false))).booleanValue();
    this.s = ((Boolean)a("key_overlay", Boolean.valueOf(false))).booleanValue();
    this.t = (CharSequence)a("key_title", "");
    this.m = (bi)a("key_layout_main");
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.h.setVisibility(0);
      return;
    } 
    this.h.setVisibility(8);
  }
  
  public Dialog b(int paramInt, boolean paramBoolean) {
    return b(d(paramInt), paramBoolean);
  }
  
  public Dialog b(CharSequence paramCharSequence) {
    return b(paramCharSequence, false);
  }
  
  public Dialog b(CharSequence paramCharSequence, boolean paramBoolean) {
    try {
      if (this.n == null) {
        fc fc1 = new fc();
        this((Context)this.b, paramCharSequence);
        this.n = fc1;
      } else {
        this.n.setTitle(paramCharSequence);
      } 
      this.n.setOnCancelListener(null);
      this.n.setOnDismissListener(null);
      this.n.setOnKeyListener(null);
      this.n.setCancelable(paramBoolean);
      this.n.setCanceledOnTouchOutside(false);
      this.n.show();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.n;
  }
  
  public void b(@StringRes int paramInt) {
    a(d(paramInt));
  }
  
  public void b(Runnable paramRunnable) {
    this.k.removeCallbacks(paramRunnable);
  }
  
  public void b(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  protected boolean b() {
    return this.s;
  }
  
  abstract int c();
  
  public Dialog c(int paramInt) {
    return b(paramInt, false);
  }
  
  public void c(boolean paramBoolean) {
    if (this.c != null) {
      byte b1;
      View view = this.c;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 4;
      } 
      view.setVisibility(b1);
    } 
  }
  
  public CharSequence d(int paramInt) {
    return this.b.getText(ci.a((Context)this.b, paramInt));
  }
  
  public void d() {
    boolean bool;
    if (isShowing())
      dismiss(); 
    if (this.n != null && this.n.isShowing()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.u = bool;
  }
  
  public void d(boolean paramBoolean) {
    if (this.f != null) {
      byte b1;
      View view = this.f;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 4;
      } 
      view.setVisibility(b1);
    } 
  }
  
  public String e(int paramInt) {
    return this.b.getString(ci.a((Context)this.b, paramInt));
  }
  
  public void e() {
    if (!isShowing())
      show(); 
    if (this.u && this.n != null) {
      this.n.dismiss();
      this.n.show();
    } 
  }
  
  public void e(boolean paramBoolean) {
    if (this.d != null) {
      byte b1;
      LinearLayout linearLayout = this.d;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      linearLayout.setVisibility(b1);
    } 
  }
  
  public void f() {}
  
  public void f(boolean paramBoolean) {
    if (this.g != null) {
      byte b1;
      LinearLayout linearLayout = this.g;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      linearLayout.setVisibility(b1);
    } 
  }
  
  public View findViewById(int paramInt) {
    int i = ci.a((Context)this.b, paramInt);
    View view = super.findViewById(i);
    view.setTag(i, Integer.valueOf(paramInt));
    return view;
  }
  
  @Deprecated
  public bi g() {
    return this.m;
  }
  
  protected void h() {
    bp.a("BaseViewDialog...onClickBack");
    onBackPressed();
  }
  
  protected void i() {
    h();
  }
  
  protected int j() {
    return 2130903141;
  }
  
  protected View k() {
    View view = View.inflate((Context)this.b, ci.a((Context)this.b, j()), null);
    b(view);
    return view;
  }
  
  protected void l() {}
  
  protected final void m() {
    this.i = (FrameLayout)findViewById(2131296400);
    this.j = (RoundLinearLayout)findViewById(2131296396);
    FrameLayout frameLayout = (FrameLayout)findViewById(2131296399);
    View view = k();
    if (view != null)
      frameLayout.addView(view, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2)); 
    view = o();
    if (b()) {
      this.i = frameLayout;
      this.i.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    } 
    d(this.r);
    c(this.q);
    setTitle(this.t);
    if (view != null)
      setContentView(view); 
    a();
    n();
  }
  
  protected void n() {}
  
  protected View o() {
    View view = null;
    try {
      View view1 = View.inflate((Context)this.b, ci.a((Context)this.b, c()), null);
      view = view1;
    } catch (Exception exception) {}
    return view;
  }
  
  public void onBackPressed() {
    bp.a("BaseViewDialog...onBackPressed");
    bv.e(this.b);
  }
  
  public Dialog p() {
    return b((CharSequence)null);
  }
  
  public Dialog q() {
    return this.n;
  }
  
  public void r() {
    this.u = false;
    if (this.n != null)
      try {
        this.n.dismiss();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void s() {
    bp.a("BaseViewDialog...onDestroy");
    r();
  }
  
  public void setContentView(int paramInt) {
    setContentView(View.inflate((Context)this.b, ci.a((Context)this.b, paramInt), null));
  }
  
  public void setContentView(View paramView) {
    setContentView(paramView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    if (!b())
      this.i.removeAllViews(); 
    this.i.addView(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt) {
    setTitle(d(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (this.e != null)
      this.e.setText(paramCharSequence); 
  }
  
  public void show() {
    super.show();
    if ((v() || (this.j != null && bv.b(this.b) == 0)) && this.x) {
      this.x = false;
      this.j.startAnimation(AnimationUtils.loadAnimation((Context)this.b, 17432576));
    } 
  }
  
  public boolean t() {
    return this.o;
  }
  
  public void u() {
    this.o = true;
    dismiss();
  }
  
  protected boolean v() {
    return false;
  }
  
  public Activity w() {
    return this.b;
  }
  
  public View x() {
    return (View)this.j;
  }
  
  public View y() {
    return (View)this.i;
  }
  
  public bx z() {
    return bv.a().a("key_layout_main", this.m);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */