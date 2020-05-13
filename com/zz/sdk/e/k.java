package com.zz.sdk.e;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.zz.sdk.ParamChain;
import com.zz.sdk.SDKManager;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.p;
import com.zz.sdk.g;
import com.zz.sdk.i.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.df;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;
import com.zz.sdk.lib.widget.roundview.c;

abstract class k extends a {
  static final boolean o = false;
  
  private String p;
  
  private Double q;
  
  private g r;
  
  public k(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
  }
  
  private void A() {
    View view = findViewById(o.c.a());
    if (view instanceof ViewSwitcher) {
      ViewSwitcher viewSwitcher = (ViewSwitcher)view;
    } else {
      view = null;
    } 
    if (n.a()) {
      if (view != null)
        view.setDisplayedChild(1); 
      n.a(this.r, this);
      return;
    } 
    if (view != null)
      view.setDisplayedChild(0); 
    setCoinBalance((Double)getEnv().get("global.user.coin_balance", Double.class));
  }
  
  private void a(a parama) {
    if (h()) {
      if (parama instanceof p && parama.c())
        setCoinBalance(((p)parama).n); 
      A();
    } 
  }
  
  private CharSequence getHelpTitle() {
    null = (String)getEnv().get("global.help_title", String.class);
    return (CharSequence)((null != null) ? Html.fromHtml(null) : null);
  }
  
  private CharSequence getHelpTopic() {
    null = (String)getEnv().get("global.help_topic", String.class);
    return (CharSequence)((null != null) ? Html.fromHtml(a(null)) : null);
  }
  
  private void y() {
    a(getCoinBalance());
  }
  
  private void z() {
    String str1 = (String)getEnv().get("global.user.login_name", String.class);
    String str2 = (String)getEnv().get("global.user.access_token", String.class);
    if (str1 == null) {
      bp.a("need login");
      return;
    } 
    n.a(getConnectionUtil(), this.r, this, str1, str2);
    A();
  }
  
  protected View a(Context paramContext) {
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)a(3));
    linearLayout2.setId(o.a.a());
    linearLayout2.setVisibility(8);
    linearLayout2.setOrientation(1);
    FrameLayout frameLayout = new FrameLayout(paramContext);
    frameLayout.setId(e.j.a());
    linearLayout1.addView((View)frameLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1, 1.0F));
    return (View)linearLayout1;
  }
  
  protected void a(double paramDouble) {
    String str = this.d.format(paramDouble);
    a(o.d, (CharSequence)Html.fromHtml(str));
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    String str;
    if (a.a()) {
      str = cg.c.a();
    } else {
      str = cg.b.a();
    } 
    this.p = str;
    this.q = (Double)paramParamChain.getParent(g.class.getName()).getOwned("global.user.coin_balance", Double.class);
    this.r = new l(this);
  }
  
  protected void a(Double paramDouble) {
    if (paramDouble == null) {
      z();
      return;
    } 
    A();
  }
  
  protected void b(Context paramContext, LinearLayout paramLinearLayout) {
    cg cg;
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout2.setGravity(16);
    paramLinearLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.c.a()));
    linearLayout2.setOrientation(0);
    linearLayout2.setId(o.b.a());
    linearLayout2.setOnClickListener(this);
    ImageView imageView = new ImageView(paramContext);
    imageView.setImageDrawable(ca.r.a(paramContext));
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cc.h.a(), cc.h.a());
    layoutParams2.leftMargin = df.a(paramContext, 10.0F);
    linearLayout2.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    relativeLayout.setGravity(16);
    linearLayout2.addView((View)relativeLayout);
    TextView textView3 = new TextView(paramContext);
    textView3.setText(SDKManager.getInstance(this.f).getGameUserName());
    textView3.setSingleLine();
    textView3.setTextColor(-16777216);
    cf.b.a(textView3);
    relativeLayout.addView((View)textView3);
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(11);
    relativeLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
    if (a.a()) {
      cg = cg.e;
    } else {
      cg = cg.d;
    } 
    TextView textView1 = a(paramContext, cg);
    linearLayout1.addView((View)textView1, (ViewGroup.LayoutParams)a(0));
    textView1.setTextColor(-16777216);
    cf.b.a(textView1);
    textView1.setGravity(17);
    ViewSwitcher viewSwitcher = new ViewSwitcher(paramContext);
    linearLayout1.addView((View)viewSwitcher, (ViewGroup.LayoutParams)a(2));
    viewSwitcher.setId(o.c.a());
    viewSwitcher.setMeasureAllChildren(true);
    AnimationSet animationSet = new AnimationSet(true);
    animationSet.addAnimation((Animation)new AlphaAnimation(0.2F, 1.0F));
    animationSet.setDuration(300L);
    viewSwitcher.setInAnimation((Animation)animationSet);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(250L);
    viewSwitcher.setOutAnimation((Animation)alphaAnimation);
    TextView textView2 = a(paramContext, (cg)null);
    viewSwitcher.addView((View)textView2, (ViewGroup.LayoutParams)a(2));
    textView2.setId(o.d.a());
    cf.b.a(textView2);
    textView2.setTextColor(ce.l.a());
    textView2.setGravity(17);
    ProgressBar progressBar = new ProgressBar(paramContext, null, 16843279);
    LinearLayout.LayoutParams layoutParams1 = a(2);
    layoutParams1.gravity = 16;
    viewSwitcher.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams1);
    progressBar.setId(o.e.a());
  }
  
  protected void c(Context paramContext) {
    super.c(paramContext);
    y();
  }
  
  protected void c(Context paramContext, LinearLayout paramLinearLayout) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(36.0F)));
    linearLayout.setOrientation(1);
    linearLayout.setId(o.g.a());
    linearLayout.setOnClickListener(this);
    TextView textView = a(paramContext, cg.bu);
    LinearLayout.LayoutParams layoutParams = a(0);
    layoutParams.gravity = 1;
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    textView.setTextColor(-236427);
    textView.setGravity(17);
    textView.getPaint().setFlags(8);
    textView.getPaint().setAntiAlias(true);
    cf.j.a(textView);
  }
  
  protected void d(Context paramContext) {
    LinearLayout linearLayout = getHeaderContainer();
    b(paramContext, linearLayout);
    linearLayout.setVisibility(0);
    linearLayout.setBackgroundDrawable(ca.aq.a(paramContext));
    cd.c.a((View)linearLayout);
  }
  
  protected double getCoinBalance() {
    return (this.q == null) ? 0.0D : this.q.doubleValue();
  }
  
  protected String getCoinName() {
    return this.p;
  }
  
  protected LinearLayout getFooterContainer() {
    return (LinearLayout)findViewById(o.f.a());
  }
  
  protected LinearLayout getHeaderContainer() {
    return (LinearLayout)findViewById(o.a.a());
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (bool)
      a(this.q); 
    return bool;
  }
  
  public boolean l() {
    boolean bool = super.l();
    if (bool) {
      if (this.q == null) {
        z();
        return bool;
      } 
    } else {
      return bool;
    } 
    A();
    return bool;
  }
  
  protected void m() {
    super.m();
    n.b(this.r, this);
    this.r = null;
    this.q = null;
  }
  
  public void onClick(View paramView) {
    o o = o.a(paramView.getId());
    switch (m.a[o.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        z();
        return;
      case 2:
        v();
        return;
      case 3:
        break;
    } 
    f();
  }
  
  protected void setCoinBalance(Double paramDouble) {
    if (paramDouble == null || paramDouble.equals(this.q)) {
      bp.a("D: balance unchanged!");
      return;
    } 
    getEnv().getParent(g.class.getName()).add("global.user.coin_balance", paramDouble);
    this.q = paramDouble;
    y();
  }
  
  protected void v() {
    Context context = this.f;
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setOrientation(1);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(cc.a(275.0F), -2, 17));
    AnimationSet animationSet = new AnimationSet(true);
    animationSet.addAnimation((Animation)new AlphaAnimation(0.0F, 0.8F));
    animationSet.addAnimation((Animation)new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F));
    animationSet.setDuration(400L);
    linearLayout.setAnimation((Animation)animationSet);
    RoundLinearLayout roundLinearLayout = new RoundLinearLayout(this.f);
    roundLinearLayout.setOrientation(1);
    c c = roundLinearLayout.getDelegate();
    c.a(-1);
    c.c(5);
    linearLayout.addView((View)roundLinearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    cd.b.a((View)roundLinearLayout);
    TextView textView2 = new TextView(context);
    LinearLayout.LayoutParams layoutParams2 = a(2);
    layoutParams2.gravity = 1;
    layoutParams2.bottomMargin = cc.a(10.0F);
    roundLinearLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams2);
    textView2.setTextColor(-13025984);
    cf.d.a(textView2);
    CharSequence charSequence = getHelpTitle();
    if (charSequence == null || charSequence.length() == 0) {
      textView2.setVisibility(8);
    } else {
      textView2.setText(charSequence);
    } 
    TextView textView1 = new TextView(context);
    roundLinearLayout.addView((View)textView1, (ViewGroup.LayoutParams)a(2));
    textView1.setTextSize(14.0F);
    textView1.setText(getHelpTopic());
    ImageView imageView = new ImageView(this.f);
    imageView.setId(o.h.a());
    imageView.setOnClickListener(this);
    imageView.setImageDrawable(ca.aK.a(this.f));
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams1.topMargin = cc.a(10.0F);
    layoutParams1.gravity = 1;
    linearLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    a((View)linearLayout);
  }
  
  protected void w() {
    a(o.a, 8);
  }
  
  protected void x() {
    a(o.f, 8);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */