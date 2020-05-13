package com.zz.sdk.e;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.a;
import com.zz.sdk.h;
import com.zz.sdk.i.ay;
import com.zz.sdk.i.bt;
import com.zz.sdk.i.bv;
import com.zz.sdk.i.bw;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import java.io.File;

public class fj extends k {
  private Handler A;
  
  private int p;
  
  private int q;
  
  private String r;
  
  private int s;
  
  private String t;
  
  private String u;
  
  private String v;
  
  private Object w;
  
  private Object x;
  
  private String y;
  
  private fs z;
  
  public fj(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
  }
  
  private void A() {
    if (this.y != null && this.w != null) {
      if (bv.a(getActivity(), this.w, this.y, this.r, this.x)) {
        a(cg.aS.a(), (h)null);
        return;
      } 
    } else {
      return;
    } 
    this.A.obtainMessage(2017, -1, 0, null);
  }
  
  private void B() {
    if (this.z != fs.b) {
      a(-1L, cg.aJ.a());
      return;
    } 
    a(-1L, (String)null);
  }
  
  private void C() {
    this.z = fs.f;
    fl fl = new fl(this);
    setCurrentTask(fr.a(getConnectionUtil(), fl, this, this.r, this.u));
    G();
  }
  
  private String D() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bt.a(String.valueOf(ay.g.nextDouble())));
    char c = File.pathSeparatorChar;
    stringBuilder.append(c).append(this.r).append('=').append(this.u);
    stringBuilder.append(c).append(bt.a(stringBuilder.toString() + "zzsdk"));
    return stringBuilder.toString();
  }
  
  private void E() {
    AlertDialog alertDialog = (new AlertDialog.Builder((Context)getActivity())).setIcon(ca.a(this.s).a(getContext())).setTitle(cg.aV.a()).setMessage(D()).setPositiveButton(17039370, new fn(this)).setNegativeButton(cg.aW.a(), new fm(this)).create();
    alertDialog.setCancelable(true);
    alertDialog.setCanceledOnTouchOutside(true);
    alertDialog.show();
  }
  
  private void F() {
    this.z = fs.g;
    this.p = 0;
    o();
    b();
  }
  
  private void G() {
    a(cg.aN.a(), new fo(this));
  }
  
  private void H() {
    this.z = fs.h;
    a(false, (CharSequence)Html.fromHtml(cg.aO.a()));
    B();
  }
  
  private void I() {
    if (this.p != 3) {
      ParamChain paramChain = getEnv().getParent(cr.class.getName());
      if (paramChain != null)
        paramChain.add("global.paymentlist.pay_result", Integer.valueOf(this.p), h.b); 
    } 
  }
  
  private void a(int paramInt, Object paramObject) {
    String str;
    Object object = null;
    if (paramObject instanceof bw) {
      paramObject = paramObject;
    } else {
      paramObject = null;
    } 
    if (paramObject == null) {
      str = null;
    } else {
      str = ((bw)paramObject).a;
    } 
    this.u = str;
    if (paramObject == null) {
      paramObject = object;
    } else {
      paramObject = ((bw)paramObject).d;
    } 
    this.v = (String)paramObject;
    if (bv.b(paramInt) && this.u != null) {
      F();
      return;
    } 
    if (bv.c(paramInt)) {
      c(cg.aU);
      return;
    } 
    b(String.format(cg.aT.a(), new Object[] { Integer.valueOf(paramInt) }));
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    paramFrameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2, 17));
    linearLayout.setId(fq.a.a());
    linearLayout.setVisibility(0);
    linearLayout.setOrientation(1);
    ProgressBar progressBar = new ProgressBar(paramContext);
    progressBar.setIndeterminate(true);
    progressBar.setId(fq.d.a());
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.gravity = 1;
    linearLayout.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams);
    TextView textView = a(paramContext, cg.aQ);
    textView.setGravity(17);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    textView.setTextColor(ce.h.a());
  }
  
  private void a(a parama) {
    if (parama != null && parama.e()) {
      F();
      return;
    } 
    this.z = fs.h;
    this.p = 1;
    B();
    a(false, eo.a(this.f, this.s, this, fq.f, fq.g));
  }
  
  private void a(fq paramfq) {
    a(fq.a, paramfq);
    a(fq.b, paramfq);
  }
  
  private void a(fq paramfq1, fq paramfq2) {
    byte b;
    if (paramfq1 == paramfq2) {
      b = 0;
    } else {
      b = 8;
    } 
    a(paramfq1, b);
  }
  
  private void b(int paramInt) {
    if (bv.a(paramInt)) {
      a(fq.c);
      this.z = fs.d;
      this.A.obtainMessage(2016).sendToTarget();
      return;
    } 
    b(String.format(cg.aR.a(), new Object[] { Integer.valueOf(paramInt) }));
  }
  
  private void b(Context paramContext, FrameLayout paramFrameLayout) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    paramFrameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)a(3));
    linearLayout.setOrientation(1);
    cd.q.a((View)linearLayout);
    TextView textView2 = c(paramContext, cg.h);
    linearLayout.addView((View)textView2, (ViewGroup.LayoutParams)a(2));
    textView2.setSingleLine(false);
    textView2.setGravity(17);
    ca ca = ca.a(this.s);
    if (ca != null) {
      textView2.setCompoundDrawablesWithIntrinsicBounds(ca.a(paramContext), null, null, null);
      textView2.setCompoundDrawablePadding(cc.a(8.0F));
    } 
    textView2.setTextSize(24.0F);
    cd.q.a((View)textView2);
    TextView textView1 = a(paramContext, (cg)null);
    linearLayout.addView((View)textView1, (ViewGroup.LayoutParams)a(3));
    textView1.setId(fq.e.a());
    textView1.setSingleLine(false);
    textView1.setBackgroundDrawable(ca.ac.a(paramContext));
    cd.q.a((View)textView1);
    textView1.setTextColor(ce.q.a());
    cf.l.a(textView1);
  }
  
  private void b(CharSequence paramCharSequence) {
    this.z = fs.h;
    this.p = 1;
    a(fq.b);
    g();
    a(fq.e, paramCharSequence);
    o();
  }
  
  private void c(cg paramcg) {
    b(paramcg.a());
  }
  
  private void y() {
    if (this.z == fs.b)
      this.A.obtainMessage(2014).sendToTarget(); 
  }
  
  private void z() {
    if (this.z == fs.b) {
      this.z = fs.c;
      if (this.y == null) {
        c(cg.aA);
        return;
      } 
    } else {
      return;
    } 
    this.w = bv.a(getActivity(), this.x);
    if (this.w == null)
      this.A.obtainMessage(2015, -1, 0).sendToTarget(); 
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    int i;
    super.a(paramContext, paramParamChain);
    this.p = 3;
    this.z = fs.b;
    this.r = (String)paramParamChain.get("global.paymentlist.pay_order_number", String.class);
    this.s = ((Integer)paramParamChain.get("global.paymentlist.pay_channel_type", Integer.class)).intValue();
    this.t = (String)paramParamChain.get("global.paymentlist.pay_channel_name", String.class);
    Double double_1 = (Double)paramParamChain.get("global.paymentlist.pay_amount", Double.class);
    Double double_2 = (Double)paramParamChain.get("global.paymentlist.pay_amount_defect", Double.class);
    if (double_2 != null)
      double_1 = double_2; 
    if (double_1 == null) {
      i = 0;
    } else {
      i = (int)(double_1.doubleValue() * 100.0D);
    } 
    this.q = i;
    this.y = bv.a(this.q / 100.0D);
    this.A = new fk(this);
    this.x = bv.a(this.A);
  }
  
  protected void b(Context paramContext) {
    FrameLayout frameLayout1 = getSubjectContainer();
    d(paramContext);
    a(paramContext, frameLayout1);
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    frameLayout1.addView((View)frameLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout2.setId(fq.b.a());
    frameLayout2.setVisibility(8);
    b(paramContext, frameLayout2);
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
    if (this.z == fs.f) {
      b(cg.aH);
      return false;
    } 
    return super.c(paramBoolean);
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (!bool)
      return false; 
    y();
    return bool;
  }
  
  protected void m() {
    I();
    super.m();
    this.s = -1;
    this.t = null;
    this.p = 3;
    this.r = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = fs.a;
  }
  
  public void onClick(View paramView) {
    fq fq = fq.a(paramView.getId());
    switch (fp.a[fq.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        C();
        return;
      case 2:
        break;
    } 
    E();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */