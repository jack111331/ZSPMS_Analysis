package com.zz.sdk.e;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.ae;
import com.zz.sdk.b.a.at;
import com.zz.sdk.h;
import com.zz.sdk.i.aq;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.dd;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import com.zz.sdk.lib.widget.roundview.RoundFrameLayout;
import com.zz.sdk.lib.widget.roundview.c;

public class fz extends k {
  private String A;
  
  private String B;
  
  private final int C = 100;
  
  at p;
  
  Handler q = new ga(this);
  
  private String r;
  
  private int s;
  
  private String t;
  
  private String u;
  
  private int v;
  
  private boolean w;
  
  private int x = 0;
  
  private double y;
  
  private double z;
  
  public fz(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    this.x = cv.t(this.f);
    c(paramContext);
  }
  
  private void A() {
    a(gf.c, 0);
    a(cg.aj.a(), new gc(this));
    (new gd(this, "check-order")).start();
  }
  
  private void B() {
    if (h()) {
      t t = getConnectionUtil();
      String str1 = this.u;
      String str2 = this.r;
      if (t != null && str1 != null && str2 != null) {
        ae ae = t.j(str1, str2);
      } else {
        str2 = null;
      } 
      Handler handler = this.q;
      if (h() && handler != null)
        Message.obtain(handler, 100, str2).sendToTarget(); 
    } 
  }
  
  private void C() {
    if (this.v != 3)
      getEnv().getParent(cr.class.getName()).add("global.paymentlist.pay_result", Integer.valueOf(this.v), h.b); 
  }
  
  private void a(LinearLayout paramLinearLayout) {
    RelativeLayout.LayoutParams layoutParams;
    if (this.x == 2) {
      RelativeLayout relativeLayout = new RelativeLayout(this.f);
      paramLinearLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      TextView textView1 = a(this.f, (cg)null);
      textView1.setTextColor(-13025984);
      textView1.setText(cv.s(this.f) + " · " + this.B);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams2.addRule(15);
      relativeLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
      TextView textView2 = a(this.f, (cg)null);
      textView2.setTextColor(-13025984);
      textView2.setText((CharSequence)Html.fromHtml(String.format(cg.ah.a(), new Object[] { Double.valueOf(this.z) })));
      layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(11);
      layoutParams.addRule(15);
      relativeLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams);
      return;
    } 
    TextView textView = a(this.f, (cg)null);
    textView.setTextColor(-13025984);
    textView.setText("游戏： " + cv.s(this.f));
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams1.setMargins(0, cc.a(10.0F), 0, 0);
    layoutParams.addView((View)textView, (ViewGroup.LayoutParams)layoutParams1);
    textView = a(this.f, (cg)null);
    textView.setTextColor(-13025984);
    textView.setText("商品： " + this.B);
    layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams1.setMargins(0, cc.a(10.0F), 0, 0);
    layoutParams.addView((View)textView, (ViewGroup.LayoutParams)layoutParams1);
    textView = a(this.f, (cg)null);
    textView.setTextColor(-13025984);
    textView.setText((CharSequence)Html.fromHtml(String.format(cg.ah.a(), new Object[] { Double.valueOf(this.z) })));
    layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams1.setMargins(0, cc.a(10.0F), 0, 0);
    layoutParams.addView((View)textView, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  private void a(ae paramae) {
    byte b = 1;
    if (paramae == null || !paramae.e()) {
      a(true, cg.al);
      c(1);
      return;
    } 
    aq aq = paramae.i();
    switch (ge.b[aq.ordinal()]) {
      default:
        b = 2;
      case 4:
      case 5:
        g();
        if (b == 2) {
          c(2);
          return;
        } 
        break;
      case 1:
      case 2:
      case 3:
        b = 0;
    } 
    b(b);
  }
  
  private void b(int paramInt) {
    this.w = false;
    this.v = paramInt;
    o();
    b();
  }
  
  private void b(LinearLayout paramLinearLayout) {
    LinearLayout.LayoutParams layoutParams1;
    if (this.x == 2) {
      LinearLayout linearLayout = new LinearLayout(this.f);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
      layoutParams.topMargin = cc.a(10.0F);
      paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
      FancyButton fancyButton1 = new FancyButton(this.f);
      fancyButton1.setId(gf.d.a());
      fancyButton1.setRadius(cc.a(25.0F));
      fancyButton1.setBorderColor(-236427);
      fancyButton1.setBackgroundColor(-236427);
      fancyButton1.setFocusBackgroundColor(-1421723);
      fancyButton1.setText("支付完成");
      fancyButton1.setTextColor(-1);
      fancyButton1.setTextSize(16);
      fancyButton1.setOnClickListener(this);
      cd.v.a((View)fancyButton1);
      layoutParams = new LinearLayout.LayoutParams(cc.a(100.0F), -2);
      layoutParams.weight = 1.0F;
      layoutParams.gravity = 1;
      layoutParams.rightMargin = cc.a(10.0F);
      layoutParams.leftMargin = cc.a(10.0F);
      linearLayout.addView((View)fancyButton1, (ViewGroup.LayoutParams)layoutParams);
      FancyButton fancyButton2 = new FancyButton(this.f);
      fancyButton2.setId(gf.e.a());
      fancyButton2.setRadius(cc.a(25.0F));
      fancyButton2.setBorderColor(-236427);
      fancyButton2.setBackgroundColor(-236427);
      fancyButton2.setFocusBackgroundColor(-1421723);
      fancyButton2.setText("返回游戏");
      fancyButton2.setTextColor(-1);
      fancyButton2.setTextSize(16);
      fancyButton2.setOnClickListener(this);
      cd.v.a((View)fancyButton2);
      layoutParams1 = new LinearLayout.LayoutParams(cc.a(100.0F), -2);
      layoutParams1.weight = 1.0F;
      layoutParams1.gravity = 1;
      layoutParams1.rightMargin = cc.a(10.0F);
      layoutParams1.leftMargin = cc.a(10.0F);
      linearLayout.addView((View)fancyButton2, (ViewGroup.LayoutParams)layoutParams1);
      return;
    } 
    FancyButton fancyButton = new FancyButton(this.f);
    fancyButton.setId(gf.d.a());
    fancyButton.setRadius(cc.a(25.0F));
    fancyButton.setBorderColor(-236427);
    fancyButton.setBackgroundColor(-236427);
    fancyButton.setFocusBackgroundColor(-1421723);
    fancyButton.setText("支付完成");
    fancyButton.setTextColor(-1);
    fancyButton.setTextSize(16);
    fancyButton.setOnClickListener(this);
    cd.v.a((View)fancyButton);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams2.topMargin = cc.a(10.0F);
    layoutParams2.gravity = 1;
    layoutParams1.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams2);
    fancyButton = new FancyButton(this.f);
    fancyButton.setId(gf.e.a());
    fancyButton.setRadius(cc.a(25.0F));
    fancyButton.setBorderColor(-236427);
    fancyButton.setBackgroundColor(-236427);
    fancyButton.setFocusBackgroundColor(-1421723);
    fancyButton.setText("返回游戏");
    fancyButton.setTextColor(-1);
    fancyButton.setTextSize(16);
    fancyButton.setOnClickListener(this);
    cd.v.a((View)fancyButton);
    layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams2.topMargin = cc.a(10.0F);
    layoutParams2.gravity = 1;
    layoutParams1.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams2);
  }
  
  private void c(int paramInt) {
    String str;
    if (paramInt == -1) {
      str = "启动支付失败，请检查是否安装微信客户端";
      a(gf.d, 8);
    } else if (paramInt == 1) {
      str = cg.al.a();
    } else if (paramInt == 2) {
      str = "订单状态未知，请稍候重试！\n如有疑问，请与客服联系！";
    } else {
      str = cg.ar.a();
    } 
    findViewById(gf.f.a()).setVisibility(4);
    findViewById(gf.g.a()).setVisibility(0);
    a(gf.b, str);
  }
  
  private void z() {
    boolean bool;
    if (this.p != null) {
      bool = dd.a(getContext(), this.p);
    } else {
      bool = false;
    } 
    if (bool) {
      a("正在启动支付……", new gb(this));
      this.w = true;
      y();
      c(0);
      return;
    } 
    g();
    c(-1);
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    double d;
    super.a(paramContext, paramParamChain);
    this.p = (at)paramParamChain.get("global.paymentlist.pay_args", at.class);
    this.r = (String)paramParamChain.get("global.user.login_name", String.class);
    this.s = ((Integer)paramParamChain.get("global.paymentlist.pay_channel_type", Integer.class)).intValue();
    this.t = (String)paramParamChain.get("global.paymentlist.pay_channel_name", String.class);
    this.u = (String)paramParamChain.get("global.paymentlist.pay_order_number", String.class);
    this.y = ((Double)paramParamChain.get("global.paymentlist.pay_amount", Double.class)).doubleValue();
    Double double_ = (Double)paramParamChain.get("global.paymentlist.pay_amount_defect", Double.class);
    if (double_ == null) {
      d = this.y;
    } else {
      d = double_.doubleValue();
    } 
    this.z = d;
    this.B = (String)paramParamChain.get("global.caller.prop_name", String.class);
    this.v = 2;
  }
  
  protected void b(Context paramContext) {
    d(paramContext);
    getHeaderContainer().setVisibility(8);
    Rect rect = cd.b.a();
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
    layoutParams.setMargins(rect.left, 0, rect.right, rect.bottom);
    linearLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout1.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    a(linearLayout1);
    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(this.f);
    c c = roundFrameLayout.getDelegate();
    c.c(5);
    c.d(1);
    c.e(-2762788);
    cd.b.a((View)roundFrameLayout);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams1.topMargin = cc.a(10.0F);
    linearLayout1.addView((View)roundFrameLayout, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout2 = new LinearLayout(this.f);
    linearLayout2.setId(gf.f.a());
    linearLayout2.setOrientation(1);
    roundFrameLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    ImageView imageView = new ImageView(this.f);
    imageView.setImageDrawable(ca.aJ.a(this.f));
    LinearLayout.LayoutParams layoutParams3 = a(2);
    layoutParams3.gravity = 1;
    linearLayout2.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams3);
    TextView textView2 = a(this.f, (cg)null);
    textView2.setText("正在确认订单中，请稍后..");
    textView2.setTextColor(-7367267);
    layoutParams3 = a(2);
    layoutParams3.topMargin = cc.a(10.0F);
    layoutParams3.gravity = 1;
    linearLayout2.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams3);
    linearLayout2 = new LinearLayout(this.f);
    linearLayout2.setVisibility(8);
    linearLayout2.setId(gf.g.a());
    linearLayout2.setOrientation(1);
    roundFrameLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    TextView textView1 = a(this.f, (cg)null);
    textView1.setTextColor(-13025984);
    textView1.setText("订单号：" + this.u);
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)a(2));
    textView1 = a(this.f, (cg)null);
    textView1.setId(gf.b.a());
    textView1.setTextColor(-13025984);
    textView1.setSingleLine(false);
    LinearLayout.LayoutParams layoutParams2 = a(2);
    layoutParams2.topMargin = cc.a(10.0F);
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
    b(linearLayout1);
    FrameLayout frameLayout = getSubjectContainer();
    ScrollView scrollView = new ScrollView(paramContext);
    scrollView.addView((View)linearLayout1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    frameLayout.addView((View)scrollView);
    cg cg = (cg)getEnv().get("global.paymentlist.pay_title", cg.class);
    if (cg != null) {
      String str;
      if (this.t != null) {
        str = String.format(cg.y.a(), new Object[] { cg.a(), this.t });
      } else {
        str = str.a();
      } 
      setTileTypeText(str);
    } 
  }
  
  public boolean c(boolean paramBoolean) {
    boolean bool = false;
    if (paramBoolean && f())
      return bool; 
    if (this.w) {
      b(cg.aH);
      return bool;
    } 
    return super.c(paramBoolean);
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (bool)
      z(); 
    return bool;
  }
  
  protected void m() {
    C();
    super.m();
    this.r = null;
    this.t = null;
    this.q = null;
    this.u = null;
  }
  
  public void onClick(View paramView) {
    gf gf = gf.a(paramView.getId());
    switch (ge.a[gf.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        A();
        return;
      case 2:
        break;
    } 
    b(2);
  }
  
  protected void y() {
    a(-1L, (String)null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */