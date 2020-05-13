package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.b;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONObject;

public final class bi extends b implements b.a, b.b {
  private static String w = "download://";
  
  private b r = null;
  
  private ViewGroup s = null;
  
  private int t = 0;
  
  private boolean u = false;
  
  private boolean v = false;
  
  public bi(Context paramContext) {
    this(paramContext, false, false);
  }
  
  public bi(Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramContext);
    this.t = a.t - a.k - a.b(this.d) - a.s * 3;
    this.u = paramBoolean1;
    this.v = paramBoolean2;
    this.k = a();
    b();
    d();
  }
  
  public final void a(JSONObject paramJSONObject) {}
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay ay = new ay(this.d, this.a.af, this);
    if (this.u)
      ay = new ay(this.d, this.a.af, this.c.a(1030), g.a(this.d, 20.0F), this); 
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final void c(String paramString) {
    if (paramString != null && paramString.length() > 0 && paramString.startsWith(w)) {
      String str = paramString.substring(w.length());
      Intent intent = new Intent();
      intent.setAction("android.intent.action.VIEW");
      intent.setData(Uri.parse(str));
      this.d.startActivity(intent);
    } 
  }
  
  protected final void d() {
    super.d();
    this.r = new b(this.d, this);
    this.r.setOnTouchListener(new bj(this));
    if (this.v)
      this.r.a(w); 
    if (this.t == 0) {
      layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    } else {
      layoutParams = new RelativeLayout.LayoutParams(-1, this.t);
    } 
    layoutParams.addRule(3, this.k.getId());
    layoutParams.addRule(12, -1);
    this.m.addView((View)this.r, (ViewGroup.LayoutParams)layoutParams);
    this.s = (ViewGroup)new RelativeLayout(this.d);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a.t - a.k);
    layoutParams.addRule(3, this.k.getId());
    layoutParams.addRule(12, -1);
    layoutParams.addRule(10, -1);
    layoutParams.bottomMargin = 0;
    layoutParams.topMargin = 0;
    this.m.addView((View)this.s, (ViewGroup.LayoutParams)layoutParams);
    ProgressBar progressBar = new ProgressBar(this.d);
    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(13, -1);
    this.s.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams);
    this.r.b(this.a.ag);
    if (this.u)
      a(this.a.bi, false); 
  }
  
  public final void l() {
    ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if (this.u) {
      bk bk = new bk(this);
      bl bl = new bl(this);
      this.b.a(bk, bl);
      this.b.a(c.bD.Y, c.bD.av, c.bD.W, c.bD.X);
      return;
    } 
    super.l();
  }
  
  public final void u() {
    this.r.setVisibility(8);
    this.s.setVisibility(0);
  }
  
  public final void v() {
    this.r.setVisibility(0);
    this.s.setVisibility(8);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */