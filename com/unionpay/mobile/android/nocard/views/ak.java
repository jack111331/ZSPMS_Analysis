package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONObject;

public final class ak extends b implements a.b {
  private int r = 100;
  
  private int s = 20;
  
  private a t = null;
  
  private TextView u = null;
  
  private a v = null;
  
  private View.OnClickListener w = new al(this);
  
  private View.OnClickListener x = new am(this);
  
  public ak(Context paramContext) {
    super(paramContext);
    setBackgroundColor(-1052684);
    this.k = a();
    b();
    d();
    c();
  }
  
  private void v() {
    this.r = 103;
    k.c("uppay", this.s);
    int i = this.s;
    this.e.a("query", this.a.aj, 3);
    this.s--;
  }
  
  public final void a(a.a parama) {
    if (!parama.a()) {
      a(parama.b);
      return;
    } 
    this.j = false;
    this.r = 101;
    this.b.a(c.bD.U);
    k.a("uppay", "sms elements:" + parama.b);
    this.e.c("sms", parama.b);
  }
  
  public final void a(JSONObject paramJSONObject) {
    switch (this.r) {
      default:
        return;
      case 101:
        this.v.a(b.p);
        this.b.c();
        this.r = 100;
      case 102:
        this.a.aj = i.a(paramJSONObject.toString());
        if (this.a.aj == null || this.a.aj.length() <= 0)
          b(2); 
        this.s = 20;
        v();
      case 103:
        break;
    } 
    String str1 = j.a(paramJSONObject, "status");
    String str2 = j.a(paramJSONObject, "fail_msg");
    this.a.S = j.a(paramJSONObject, "open_info");
    this.a.A = j.a(paramJSONObject, "title");
    this.a.B = j.a(paramJSONObject, "succ_info");
    if (this.s > 0 && str1.equalsIgnoreCase("01"))
      v(); 
    this.r = 100;
    j();
    if (str1.equalsIgnoreCase("00")) {
      String str = this.a.S;
      d(11);
    } 
    if (str1.equalsIgnoreCase("03")) {
      an an = new an(this);
      this.b.a(an, null);
      this.b.a(c.bD.ab, str2, c.bD.ac);
    } 
    if (this.s <= 0)
      b(20); 
  }
  
  public final void a(boolean paramBoolean) {
    if (this.u != null) {
      TextView textView = this.u;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      textView.setEnabled(paramBoolean);
    } 
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay ay = new ay(getContext(), this.a.A, this);
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  protected final void c() {
    boolean bool1 = true;
    LinearLayout linearLayout1 = new LinearLayout(this.d);
    linearLayout1.setBackgroundColor(-1);
    linearLayout1.setOrientation(1);
    linearLayout1.setId(linearLayout1.hashCode());
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    int i = a.f;
    layoutParams2.rightMargin = i;
    layoutParams2.leftMargin = i;
    this.m.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams2);
    this.v = new a(this.d, this.a.T, this.e.c(), this, this.a.aq, true, this.q);
    (new LinearLayout.LayoutParams(-1, -1)).topMargin = a.f;
    linearLayout1.addView((View)this.v);
    LinearLayout linearLayout2 = new LinearLayout(this.d);
    linearLayout2.setOrientation(1);
    linearLayout2.setId(linearLayout2.hashCode());
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams3.topMargin = a.d;
    layoutParams3.leftMargin = a.d;
    layoutParams3.addRule(3, linearLayout1.getId());
    this.m.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams3);
    this.t = new a(this.d, this.a.al, this.x, this.q + "_agree_user_protocol");
    linearLayout2.addView((View)this.t);
    this.u = new TextView(this.d);
    this.u.setText(j.a(this.a.C, "label"));
    this.u.setTextSize(b.i);
    this.u.setTextColor(p());
    this.u.setGravity(17);
    i = a.n;
    Drawable drawable = this.c.a(2008);
    this.u.setBackgroundDrawable(drawable);
    this.u.setOnClickListener(this.w);
    TextView textView = this.u;
    boolean bool2 = bool1;
    if (this.v != null)
      if (this.v.e()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    textView.setEnabled(bool2);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, i);
    layoutParams1.topMargin = a.d;
    i = a.d;
    layoutParams1.rightMargin = i;
    layoutParams1.leftMargin = i;
    layoutParams1.addRule(3, linearLayout2.getId());
    this.m.addView((View)this.u, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final void l() {
    if (!this.v.d())
      n(); 
  }
  
  public final void u() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */