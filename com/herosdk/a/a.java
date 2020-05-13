package com.herosdk.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.herosdk.d.au;
import java.util.Map;

public abstract class a extends i implements j, k {
  protected Activity a;
  
  protected View b;
  
  protected LinearLayout c;
  
  protected TextView d;
  
  protected View e;
  
  protected LinearLayout f;
  
  protected View g;
  
  protected FrameLayout h;
  
  protected LinearLayout i;
  
  protected Handler j = new Handler();
  
  protected a k;
  
  private Toast n;
  
  private l o;
  
  private boolean p = false;
  
  private Map<String, Object> q;
  
  private boolean r;
  
  private boolean s;
  
  private boolean t;
  
  private CharSequence u;
  
  private boolean v = false;
  
  private boolean w = true;
  
  public a(Activity paramActivity) {
    this(paramActivity, au.d((Context)paramActivity, "HuThemeAppDialog"));
  }
  
  public a(Activity paramActivity, int paramInt) {
    super((Context)paramActivity, paramInt);
    a(paramActivity);
  }
  
  private void a(Activity paramActivity) {
    getWindow().requestFeature(1);
    this.k = this;
    this.a = paramActivity;
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    super.setContentView(au.h((Context)paramActivity, "hu_dialog_base_toolbar"));
  }
  
  private void b(View paramView) {
    this.g = paramView.findViewById(au.g((Context)this.a, "hut_layoutToolBar"));
    this.b = paramView.findViewById(au.g((Context)this.a, "hut_imgTBack"));
    this.b.setOnClickListener(new b(this));
    this.c = (LinearLayout)paramView.findViewById(au.g((Context)this.a, "hut_layoutToolBarLeft"));
    this.d = (TextView)paramView.findViewById(au.g((Context)this.a, "hut_txtTTitle"));
    this.e = paramView.findViewById(au.g((Context)this.a, "hut_imgTClose"));
    this.e.setOnClickListener(new c(this));
    this.f = (LinearLayout)paramView.findViewById(au.g((Context)this.a, "hut_layoutToolBarRight"));
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
  
  public <T> T a(String paramString) {
    return a(paramString, (T)null);
  }
  
  public <T> T a(String paramString, T paramT) {
    String str;
    if (this.q != null) {
      paramString = (String)this.q.get(paramString);
      if (paramString != null)
        str = paramString; 
    } 
    return (T)str;
  }
  
  public void a(int paramInt) {
    if (this.d != null)
      this.d.setTextColor(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, boolean paramBoolean) {
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
    if (!this.p && !TextUtils.isEmpty(paramCharSequence)) {
      if (paramBoolean) {
        Toast.makeText((Context)this.a, paramCharSequence, paramInt).show();
        return;
      } 
      if (this.n != null)
        this.n.cancel(); 
      this.n = Toast.makeText((Context)this.a, paramCharSequence, paramInt);
      this.n.show();
    } 
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean) {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void a(Runnable paramRunnable) {
    this.j.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong) {
    this.j.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(Map<String, Object> paramMap) {
    this.q = paramMap;
    this.r = ((Boolean)a("key_show_back", Boolean.valueOf(true))).booleanValue();
    this.s = ((Boolean)a("key_show_close", Boolean.valueOf(false))).booleanValue();
    this.t = ((Boolean)a("key_overlay", Boolean.valueOf(false))).booleanValue();
    this.u = a("key_title", "");
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.g.setVisibility(0);
      return;
    } 
    this.g.setVisibility(8);
  }
  
  protected void a_() {
    onBackPressed();
  }
  
  public Dialog b(int paramInt, boolean paramBoolean) {
    return b(d(paramInt), paramBoolean);
  }
  
  public Dialog b(CharSequence paramCharSequence) {
    return b(paramCharSequence, false);
  }
  
  public Dialog b(CharSequence paramCharSequence, boolean paramBoolean) {
    try {
      if (this.o == null) {
        l l1 = new l();
        this((Context)this.a, paramCharSequence);
        this.o = l1;
      } else {
        this.o.setTitle(paramCharSequence);
      } 
      this.o.setOnCancelListener(null);
      this.o.setOnDismissListener(null);
      this.o.setOnKeyListener(null);
      this.o.setCancelable(paramBoolean);
      this.o.setCanceledOnTouchOutside(false);
      this.o.show();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.o;
  }
  
  protected void b() {
    a_();
  }
  
  public void b(int paramInt) {
    a(d(paramInt));
  }
  
  public void b(Runnable paramRunnable) {
    this.j.removeCallbacks(paramRunnable);
  }
  
  public void b(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  protected int c() {
    return au.h((Context)this.a, "hu_layout_toolbar");
  }
  
  public Dialog c(int paramInt) {
    return b(paramInt, false);
  }
  
  public void c(boolean paramBoolean) {
    if (this.b != null) {
      byte b;
      View view = this.b;
      if (paramBoolean) {
        b = 0;
      } else {
        b = 4;
      } 
      view.setVisibility(b);
    } 
  }
  
  protected View d() {
    View view = View.inflate((Context)this.a, c(), null);
    b(view);
    return view;
  }
  
  public CharSequence d(int paramInt) {
    return this.a.getText(paramInt);
  }
  
  public void d(boolean paramBoolean) {
    if (this.e != null) {
      byte b;
      View view = this.e;
      if (paramBoolean) {
        b = 0;
      } else {
        b = 4;
      } 
      view.setVisibility(b);
    } 
  }
  
  public String e(int paramInt) {
    return this.a.getString(paramInt);
  }
  
  protected void e() {}
  
  protected final void f() {
    this.h = (FrameLayout)findViewById(au.g((Context)this.a, "hubt_layoutContent"));
    this.i = (LinearLayout)findViewById(au.g((Context)this.a, "hubt_layoutRoot"));
    FrameLayout frameLayout = (FrameLayout)findViewById(au.g((Context)this.a, "hubt_layoutToolBarParent"));
    View view = d();
    if (view != null)
      frameLayout.addView(view, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2)); 
    view = k();
    if (h()) {
      this.h = frameLayout;
      this.h.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    } 
    d(this.s);
    c(this.r);
    setTitle(this.u);
    if (view != null)
      setContentView(view); 
    i();
    g();
  }
  
  protected void g() {}
  
  protected boolean h() {
    return this.t;
  }
  
  abstract void i();
  
  abstract int j();
  
  protected View k() {
    View view = null;
    try {
      View view1 = View.inflate((Context)this.a, j(), null);
      view = view1;
    } catch (Exception exception) {}
    return view;
  }
  
  public Dialog l() {
    return b((CharSequence)null);
  }
  
  public Dialog m() {
    return this.o;
  }
  
  public void n() {
    this.v = false;
    if (this.o != null)
      try {
        this.o.dismiss();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void o() {
    if (!isShowing())
      show(); 
    if (this.v && this.o != null) {
      this.o.dismiss();
      this.o.show();
    } 
  }
  
  public void onBackPressed() {
    f.d(this.a);
  }
  
  public void p() {
    boolean bool;
    if (isShowing())
      dismiss(); 
    if (this.o != null && this.o.isShowing()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.v = bool;
  }
  
  public void q() {
    n();
  }
  
  public boolean r() {
    return this.p;
  }
  
  public void s() {
    this.p = true;
    dismiss();
  }
  
  public void setContentView(int paramInt) {
    setContentView(View.inflate((Context)this.a, paramInt, null));
  }
  
  public void setContentView(View paramView) {
    setContentView(paramView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    if (!h())
      this.h.removeAllViews(); 
    this.h.addView(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt) {
    setTitle(d(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (this.d != null)
      this.d.setText(paramCharSequence); 
  }
  
  public void show() {
    super.show();
    if ((t() || (this.i != null && f.b(this.a) == 0)) && this.w) {
      this.w = false;
      this.i.startAnimation(AnimationUtils.loadAnimation((Context)this.a, 17432576));
    } 
  }
  
  protected boolean t() {
    return false;
  }
  
  public void u() {}
  
  public Activity v() {
    return this.a;
  }
  
  public View w() {
    return (View)this.i;
  }
  
  public View x() {
    return (View)this.h;
  }
  
  public h<String, Object> y() {
    return f.a();
  }
  
  protected void z() {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.i.getLayoutParams();
    layoutParams.setMargins(0, 0, 0, 0);
    this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */