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
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONObject;

public final class g extends b implements a.b {
  private int r = 20;
  
  private int s = 100;
  
  private a t = null;
  
  private TextView u = null;
  
  private a v = null;
  
  private boolean w = false;
  
  private boolean x = true;
  
  private View.OnClickListener y = new h(this);
  
  private View.OnClickListener z = new i(this);
  
  public g(Context paramContext) {
    super(paramContext);
    if (this.a.K) {
      this.q = "entrust_phoneNO_change";
    } else {
      this.q = "entrust";
    } 
    if (this.a.K)
      bool = false; 
    this.x = bool;
    setBackgroundColor(-1052684);
    e();
  }
  
  private void d(JSONObject paramJSONObject) {
    j();
    this.a.z = j.d(paramJSONObject, "rules");
    this.a.A = j.a(paramJSONObject, "title");
    this.a.C = j.c(paramJSONObject, "followrules_button");
    this.a.al = j.c(paramJSONObject, "service_checkbox");
    this.a.am = j.c(paramJSONObject, "bind_card_checkbox");
    this.a.aq = j.a(paramJSONObject, "pan");
    if (this.a.z == null || this.a.z.length() <= 0) {
      b(2);
      return;
    } 
    if (this.v != null)
      this.v.f(); 
    e e = f.a(paramJSONObject);
    this.a.K = false;
    a(6, e);
  }
  
  private void v() {
    this.e.k(this.v.a("pan"));
    this.s = 104;
  }
  
  private void w() {
    this.s = 103;
    int i = this.r;
    this.e.a("query", this.a.aj, 3);
    this.r--;
  }
  
  public final void a(a.a parama) {
    if (parama.a()) {
      this.j = false;
      this.s = 101;
      this.b.a(c.bD.U);
      k.a("uppay", "sms elements:" + parama.b);
      this.e.c("sms", parama.b);
      return;
    } 
    a(parama.b);
  }
  
  public final void a(JSONObject paramJSONObject) {
    String str1;
    String str2;
    this.x = false;
    switch (this.s) {
      default:
        return;
      case 101:
        this.v.a(b.p);
        this.b.c();
        this.s = 100;
      case 102:
        this.a.aj = i.a(paramJSONObject.toString());
        if (this.a.aj == null || this.a.aj.length() <= 0)
          b(2); 
        this.r = 20;
        w();
      case 103:
        str2 = j.a(paramJSONObject, "status");
        str1 = j.a(paramJSONObject, "fail_msg");
        if (this.r > 0 && str2.equalsIgnoreCase("01"))
          w(); 
        this.s = 100;
        if (str2.equalsIgnoreCase("00")) {
          this.w = true;
          a(this.d, this.q + "_open_succeed");
          v();
        } 
        j();
        a(this.d, this.q + "_open_fail", p.j, (Object[])new String[] { str2, str1 });
        if (str2.equalsIgnoreCase("03")) {
          j j = new j(this);
          k k = new k(this);
          if (this.a.F) {
            this.b.a(j, k);
            this.b.a(c.bD.ab, str1, c.bD.ac, c.bD.ad);
          } 
          this.b.a(j, null);
          this.b.a(c.bD.ab, str1, c.bD.ac);
        } 
        if (this.r <= 0)
          a(this.a.ak); 
      case 104:
        if (!b((JSONObject)str1))
          d((JSONObject)str1); 
      case 105:
        break;
    } 
    j();
    int i = f.a(this.a, (JSONObject)str1, false);
    if (i != 0)
      b(i); 
    e e = f.a((JSONObject)str1);
    if (this.a.z != null && this.a.z.length() > 0)
      a(6, e); 
    if (this.a.D != null && this.a.D.length() > 0)
      d(5); 
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
  
  protected final boolean a(String paramString, JSONObject paramJSONObject) {
    this.x = false;
    return false;
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay ay = new ay(getContext(), this.a.A, this);
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  protected final void b(String paramString, JSONObject paramJSONObject) {
    if ("init".equals(paramString)) {
      a(2);
      return;
    } 
    if ("".equals(paramString)) {
      d(paramJSONObject);
      return;
    } 
    this.b.a(c.bD.U);
    this.j = false;
    this.s = 105;
    this.e.c(paramString, "");
  }
  
  protected final void c() {
    boolean bool1 = true;
    this.o.a(this);
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setOrientation(1);
    linearLayout.setId(linearLayout.hashCode());
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    int i = a.d;
    this.m.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams4);
    this.v = new a(this.d, this.a.D, this.e.c(), this, this.a.aq, true, this.q);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
    layoutParams3.topMargin = a.f;
    linearLayout.addView((View)this.v, (ViewGroup.LayoutParams)layoutParams3);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.topMargin = i;
    layoutParams2.leftMargin = a.f;
    layoutParams2.addRule(3, linearLayout.getId());
    linearLayout = new LinearLayout(this.d);
    linearLayout.setOrientation(0);
    linearLayout.setId(linearLayout.hashCode());
    this.t = new a(this.d, this.a.al, this.z, this.q + "_agree_user_protocol");
    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
    linearLayout.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams5);
    this.m.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    this.u = new TextView(this.d);
    this.u.setText(j.a(this.a.C, "label"));
    this.u.setTextSize(b.i);
    this.u.setTextColor(p());
    this.u.setGravity(17);
    i = a.n;
    Drawable drawable = this.c.a(2008);
    this.u.setBackgroundDrawable(drawable);
    this.u.setOnClickListener(this.y);
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
    layoutParams1.topMargin = a.f;
    i = com.unionpay.mobile.android.utils.g.a(this.d, 10.0F);
    layoutParams1.rightMargin = i;
    layoutParams1.leftMargin = i;
    layoutParams1.addRule(3, linearLayout.getId());
    this.m.addView((View)this.u, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final void l() {
    if (!this.v.d()) {
      if (this.a.L) {
        a(13);
        this.a.L = false;
        return;
      } 
      if (this.a.K && this.x) {
        this.a.K = false;
        f.a(this.a, this.a.G);
        n();
        return;
      } 
      this.a.K = false;
      this.a.G = null;
      a(2);
    } 
  }
  
  public final void u() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */