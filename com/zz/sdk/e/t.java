package com.zz.sdk.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zz.a.a.b.a;
import com.zz.a.a.c.v;
import com.zz.a.a.c.x;
import com.zz.sdk.ParamChain;
import com.zz.sdk.activity.f;
import com.zz.sdk.b.q;
import com.zz.sdk.i.a;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;

class t extends k {
  static final boolean p = false;
  
  private static final String q = "images";
  
  private static final int r = 2102033;
  
  private v s;
  
  private q t;
  
  private ImageView u;
  
  private boolean v;
  
  private String w;
  
  private Handler x = new u(this);
  
  public t(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
  }
  
  private void A() {
    double d = getCoinBalance() - this.t.f;
    if (d < 0.0D) {
      a(w.j, 8);
      a(w.k, 0);
      return;
    } 
    a(w.j, 0);
    a(w.k, 8);
    a(w.j, String.format(cg.bA.a(), new Object[] { cv.a(this.t.f), cv.a(d) }));
  }
  
  private void B() {
    q q1 = this.t;
    setTileTypeText(String.format(cg.by.a(), new Object[] { q1.c }));
    a(w.e, q1.c);
    a(w.f, String.format(cg.bz.a(), new Object[] { cv.a(q1.f) }));
    a(w.g, q1.g);
    A();
    this.s.a(this.t.e, this.u);
  }
  
  private void e(Context paramContext) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    int i = displayMetrics.heightPixels;
    int j = displayMetrics.widthPixels;
    if (i > j)
      j = i; 
    j /= 2;
    com.zz.a.a.c.t t1 = new com.zz.a.a.c.t(paramContext, "images");
    t1.a(0.25F);
    this.s = new v(paramContext, j);
    this.s.a(getEnv(), t1);
    this.s.a(false);
  }
  
  private void y() {
    b("暂不支持!");
  }
  
  private void z() {
    ParamChain paramChain = getEnv().grow();
    paramChain.add("global.caller.msg_handler", this.x);
    paramChain.add("global.caller.msg_what", Integer.valueOf(2102033));
    if (this.t.f > getCoinBalance())
      paramChain.add("global.caller.amount", Integer.valueOf((int)(this.t.f * 100.0D))); 
    paramChain.add("global.caller.is_close_window", Boolean.valueOf(true));
    paramChain.add("global.caller.coin_count", Boolean.TRUE);
    paramChain.add("global.caller.payment_zycoin_disabled", Boolean.TRUE);
    paramChain.add("global.caller.pay_is_buy_mode", Boolean.FALSE);
    getHost().a(f.b, paramChain);
  }
  
  protected void a(double paramDouble) {
    super.a(paramDouble);
    A();
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    String str;
    super.a(paramContext, paramParamChain);
    this.t = (q)getEnv().get("global.exchangeLayout.info", q.class);
    this.v = false;
    if (a.a()) {
      str = cg.c.a();
    } else {
      str = cg.b.a();
    } 
    this.w = str;
  }
  
  protected void b(Context paramContext) {
    d(paramContext);
    FrameLayout frameLayout1 = getSubjectContainer();
    ScrollView scrollView = new ScrollView(paramContext);
    frameLayout1.addView((View)scrollView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    scrollView.addView((View)linearLayout1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    linearLayout1.setOrientation(1);
    cd.r.a((View)linearLayout1);
    LinearLayout linearLayout2 = a(paramContext, linearLayout1);
    linearLayout2.setOrientation(1);
    linearLayout2.setId(w.c.a());
    linearLayout2.setBackgroundDrawable(ca.ab.a(paramContext));
    FrameLayout frameLayout3 = new FrameLayout(paramContext);
    linearLayout2.addView((View)frameLayout3, (ViewGroup.LayoutParams)a(3));
    cd.s.a((View)linearLayout1);
    ProgressBar progressBar = new ProgressBar(paramContext);
    frameLayout3.addView((View)progressBar, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    progressBar.setIndeterminate(true);
    a a = new a(paramContext);
    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    frameLayout3.addView((View)a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    a.setId(w.d.a());
    this.u = (ImageView)a;
    TextView textView3 = a(paramContext, (cg)null);
    linearLayout2.addView((View)textView3, (ViewGroup.LayoutParams)a(3));
    textView3.setId(w.e.a());
    textView3.setGravity(17);
    textView3.setTextColor(ce.x.a());
    cf.r.a(textView3);
    TextPaint textPaint = textView3.getPaint();
    if (textPaint != null)
      textPaint.setFakeBoldText(true); 
    TextView textView2 = a(paramContext, (cg)null);
    linearLayout2.addView((View)textView2, (ViewGroup.LayoutParams)a(3));
    textView2.setId(w.f.a());
    textView2.setGravity(17);
    textView2.setTextColor(ce.y.a());
    cf.s.a(textView2);
    textView2 = a(paramContext, (cg)null);
    linearLayout2.addView((View)textView2, (ViewGroup.LayoutParams)a(3));
    textView2.setId(w.g.a());
    textView2.setSingleLine(false);
    textView2.setGravity(17);
    textView2.setTextColor(ce.y.a());
    cf.s.a(textView2);
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    linearLayout1.addView((View)frameLayout2, (ViewGroup.LayoutParams)a(3));
    linearLayout2 = new LinearLayout(paramContext);
    frameLayout2.addView((View)linearLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    linearLayout2.setOrientation(0);
    Button button = new Button(paramContext);
    button.setId(w.h.a());
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.setMargins(0, 0, cc.t.a(), 0);
    linearLayout2.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
    button.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.x, ca.y));
    button.setTextColor(ce.o.a());
    cd.l.a((View)button);
    cf.i.a((TextView)button);
    button.setOnClickListener(this);
    button.setText("先去充值");
    button = new Button(paramContext);
    button.setId(w.i.a());
    linearLayout2.addView((View)button, (ViewGroup.LayoutParams)a(2));
    button.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.v, ca.w));
    button.setTextColor(ce.o.a());
    cd.l.a((View)button);
    cf.i.a((TextView)button);
    button.setOnClickListener(this);
    button.setText("确认兑换");
    TextView textView1 = a(paramContext, (cg)null);
    textView1.setId(w.j.a());
    textView1.setSingleLine(false);
    textView1.setGravity(17);
    textView1.setTextColor(ce.y.a());
    cf.s.a(textView1);
    textView1.setVisibility(8);
    linearLayout1.addView((View)textView1, (ViewGroup.LayoutParams)a(3));
    textView1 = a(paramContext, (cg)null);
    textView1.setText(String.format(cg.bk.a(), new Object[] { this.w }));
    textView1.setId(w.k.a());
    textView1.setSingleLine(false);
    textView1.setGravity(17);
    textView1.setTextColor(ce.j.a());
    cf.s.a(textView1);
    linearLayout1.addView((View)textView1, (ViewGroup.LayoutParams)a(3));
    e(paramContext);
  }
  
  public boolean j() {
    boolean bool = super.j();
    null = bool;
    if (bool) {
      if (this.t == null)
        return false; 
    } else {
      return null;
    } 
    B();
    return bool;
  }
  
  public boolean k() {
    boolean bool = super.k();
    if (this.s != null) {
      this.s.b(true);
      this.s.h();
    } 
    return bool;
  }
  
  public boolean l() {
    boolean bool = super.l();
    if (this.s != null) {
      this.s.b(false);
      this.s.a(this.t.e, this.u);
    } 
    if (this.v) {
      a("充值成功，请点击刷新您的游戏币余额！");
      this.v = false;
    } 
    return bool;
  }
  
  protected void m() {
    super.m();
    this.t = null;
    this.s = null;
  }
  
  public boolean n() {
    boolean bool = super.n();
    if (bool) {
      if (this.u != null) {
        x.a(this.u);
        this.u.setImageDrawable(null);
      } 
      if (this.s != null)
        this.s.i(); 
    } 
    return bool;
  }
  
  public void onClick(View paramView) {
    w w = w.a(paramView.getId());
    switch (v.a[w.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        y();
        return;
      case 2:
        break;
    } 
    z();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */