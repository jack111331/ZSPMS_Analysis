package com.zz.sdk.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unionpay.UPPayAssistEx;
import com.unionpay.uppay.PayActivity;
import com.zz.sdk.ParamChain;
import com.zz.sdk.g.a;
import com.zz.sdk.h;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;

class fu extends a {
  static final String o = "00";
  
  private int p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  private int t = 3;
  
  public fu(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
  }
  
  private void A() {
    UPPayAssistEx.installUPPayPlugin((Context)getActivity());
  }
  
  private void B() {
    a(getActivity(), this.r);
  }
  
  private void a(Activity paramActivity, String paramString) {
    UPPayAssistEx.startPayByJAR((Context)paramActivity, PayActivity.class, null, null, paramString, "00");
  }
  
  private void b(int paramInt) {
    this.t = paramInt;
    o();
    b();
  }
  
  private void v() {
    b(0);
  }
  
  private void w() {
    b(2);
  }
  
  private void x() {
    b(1);
  }
  
  private void y() {
    if (this.t != 3) {
      getEnv().getParent(cr.class.getName()).add("global.paymentlist.pay_result", Integer.valueOf(this.t), h.b);
      if (this.t != 0 && this.s != null)
        (new fv(this, "cancel-pay")).start(); 
    } 
  }
  
  private void z() {
    Rect rect = cd.b.a();
    Context context = this.f;
    LinearLayout linearLayout1 = new LinearLayout(context);
    linearLayout1.setOrientation(1);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -2, 17);
    layoutParams1.setMargins(rect.left, rect.top, rect.right, rect.bottom);
    linearLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    linearLayout1.setBackgroundDrawable(ca.t.a(context));
    linearLayout1.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    TextView textView = a(context, (cg)null);
    linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)a(2));
    textView.setSingleLine(false);
    textView.setGravity(17);
    textView.setText("提示");
    textView.setCompoundDrawablesWithIntrinsicBounds(ca.R.a(context), null, null, null);
    textView.setTextSize(24.0F);
    textView.setPadding(0, rect.top, 0, rect.bottom);
    textView = a(context, (cg)null);
    linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    textView.setSingleLine(false);
    textView.setBackgroundDrawable(ca.ac.a(context));
    textView.setText("完成购买需要安装银联支付控件，是否安装？");
    textView.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    FrameLayout frameLayout = new FrameLayout(context);
    linearLayout1.addView((View)frameLayout, (ViewGroup.LayoutParams)a(3));
    LinearLayout linearLayout2 = new LinearLayout(context);
    frameLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    linearLayout2.setOrientation(0);
    linearLayout2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    Button button2 = new Button(context);
    button2.setId(fx.e.a());
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.setMargins(0, 0, cc.t.a(), 0);
    linearLayout2.addView((View)button2, (ViewGroup.LayoutParams)layoutParams);
    button2.setBackgroundDrawable((Drawable)ca.a(context, ca.x, ca.y));
    button2.setTextColor(ce.o.a());
    cd.l.a((View)button2);
    cf.i.a((TextView)button2);
    button2.setOnClickListener(this);
    button2.setText("安装");
    Button button1 = new Button(context);
    button1.setId(fx.g.a());
    linearLayout2.addView((View)button1, (ViewGroup.LayoutParams)a(2));
    button1.setBackgroundDrawable((Drawable)ca.a(context, ca.v, ca.w));
    button1.setTextColor(ce.o.a());
    cd.l.a((View)button1);
    cf.i.a((TextView)button1);
    button1.setOnClickListener(this);
    button1.setText("重试");
    a(false, (View)linearLayout1);
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    this.p = ((Integer)paramParamChain.get("global.paymentlist.pay_channel_type", Integer.class)).intValue();
    this.q = (String)paramParamChain.get("global.paymentlist.pay_channel_name", String.class);
    this.s = (String)paramParamChain.get("global.paymentlist.pay_order_number", String.class);
    this.r = (String)paramParamChain.get("global.paymentlist.pay_union_tn", String.class);
  }
  
  protected void b(Context paramContext) {
    FrameLayout frameLayout1 = getSubjectContainer();
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    frameLayout1.addView((View)frameLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout2.setId(fx.b.a());
    frameLayout2.setVisibility(8);
    TextView textView = new TextView(paramContext);
    frameLayout2.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    textView.setId(fx.d.a());
    textView.setTextColor(-65536);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    frameLayout1.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    linearLayout.setId(fx.c.a());
    linearLayout.setVisibility(8);
    cg cg = (cg)getEnv().get("global.paymentlist.pay_title", cg.class);
    if (cg != null) {
      String str;
      if (this.q != null) {
        str = String.format(cg.y.a(), new Object[] { cg.a(), this.q });
      } else {
        str = str.a();
      } 
      setTileTypeText(str);
    } 
  }
  
  public void c(String paramString) {
    a(fx.b, 0);
    a(fx.c, 8);
    a(fx.d, paramString);
  }
  
  public boolean c(boolean paramBoolean) {
    paramBoolean = super.c(paramBoolean);
    if (paramBoolean);
    return paramBoolean;
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (!bool)
      return false; 
    this.t = 2;
    setActivityControlInterface((a)new fy(this, null));
    B();
    return bool;
  }
  
  protected void m() {
    y();
    super.m();
    this.p = -1;
    this.q = null;
    this.s = null;
    this.r = null;
  }
  
  public void onClick(View paramView) {
    fx fx = fx.a(paramView.getId());
    switch (fw.a[fx.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        A();
        return;
      case 2:
        break;
    } 
    B();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */