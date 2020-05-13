package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.model.f;
import com.unionpay.mobile.android.nocard.utils.b;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.z;
import org.json.JSONArray;
import org.json.JSONObject;

public final class at extends b implements a.b {
  private a A = null;
  
  private a B = null;
  
  private boolean C = false;
  
  private boolean D = false;
  
  private String E;
  
  private View.OnClickListener F = new au(this);
  
  private View.OnClickListener G = new av(this);
  
  private View.OnClickListener H = new aw(this);
  
  private View.OnClickListener I = new ax(this);
  
  private View.OnClickListener J = new ay(this);
  
  LinearLayout r = new LinearLayout(this.d);
  
  private String s = "00";
  
  private int t = 0;
  
  private int u = 0;
  
  private int v = 20;
  
  private int w = 5;
  
  private a x = null;
  
  private a y = null;
  
  private TextView z = null;
  
  public at(Context paramContext) {
    this(paramContext, (e)null);
  }
  
  public at(Context paramContext, e parame) {
    super(paramContext, parame);
    if (this.a.K) {
      this.q = "bankpay_phoneNO_change";
    } else {
      this.q = "bankpay";
    } 
    if (!this.a.K)
      bool = true; 
    this.D = bool;
    setBackgroundColor(-1052684);
    e();
  }
  
  private void d(String paramString) {
    a(paramString, new az(this), new ba(this));
  }
  
  private void d(String paramString1, String paramString2) {
    this.u = 9;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    } else {
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    } 
    this.w--;
  }
  
  private static boolean d(JSONObject paramJSONObject) {
    return "0".equalsIgnoreCase(j.a(paramJSONObject, "reopen_flag"));
  }
  
  private void e(String paramString) {
    String str2;
    this.j = false;
    this.u = 3;
    String str1 = bh.a(this.a.C);
    if (this.x != null) {
      str2 = this.x.a();
    } else {
      str2 = null;
    } 
    paramString = bh.c("1", "1", str2, paramString);
    this.e.c(str1, paramString);
  }
  
  private void f(int paramInt) {
    this.u = 4;
    this.t = paramInt;
    paramInt = this.v;
    this.e.a("query", this.a.aj, 3);
    this.v--;
  }
  
  private String v() {
    String str1 = "";
    String str2 = str1;
    if (this.B != null) {
      a.a a1 = this.B.b();
      str2 = str1;
      if (a1.a())
        str2 = "" + a1.b; 
    } 
    str1 = str2;
    if (this.A != null) {
      a.a a1 = this.A.b();
      str1 = str2;
      if (a1.a()) {
        String str = a1.b;
        str1 = str2;
        if (!TextUtils.isEmpty(str)) {
          str1 = str2;
          if (!TextUtils.isEmpty(str2))
            str1 = str2 + ","; 
          str1 = str1 + str;
        } 
      } 
    } 
    return str1;
  }
  
  public final void a(a.a parama) {
    if (!parama.a()) {
      a(parama.b);
      return;
    } 
    k.a("uppay", "sms elements:" + parama.b);
    this.j = false;
    this.b.a(c.bD.U);
    this.e.c("sms", parama.b);
    this.u = 1;
  }
  
  public final void a(JSONObject paramJSONObject) {
    e e2;
    int i;
    String str2;
    e e1;
    JSONArray jSONArray1;
    String str1;
    JSONObject jSONObject;
    int j;
    String str3;
    JSONArray jSONArray2;
    this.D = false;
    switch (this.u) {
      default:
        return;
      case 1:
        j();
        this.u = 0;
        this.B.a(b.p);
      case 6:
        j();
        j = f.a(this.a, paramJSONObject, true);
        if (j != 0) {
          b(j);
        } else {
          this.a.K = true;
          e2 = f.a(paramJSONObject);
          if (this.a.z != null && this.a.z.length() > 0) {
            a(6, e2);
          } else if (this.a.D != null && this.a.D.length() > 0) {
            d(5);
          } 
        } 
        this.u = 0;
      case 4:
        this.s = j.a((JSONObject)e2, "status");
        if (d((JSONObject)e2))
          d(j.a((JSONObject)e2, "fail_msg")); 
        if (this.v > 0 && this.s.equalsIgnoreCase("01"))
          f(this.t); 
        this.u = 0;
        if (this.s.equalsIgnoreCase("00")) {
          switch (this.t) {
            default:
              j();
              this.u = 0;
              this.a.H = j.d((JSONObject)e2, "result");
              this.a.P = j.a((JSONObject)e2, "openupgrade_flag");
              this.a.Q = j.a((JSONObject)e2, "temporary_pay_flag");
              this.a.R = j.a((JSONObject)e2, "temporary_pay_info");
              this.a.V = j.a((JSONObject)e2, "front_url");
              this.a.W = j.a((JSONObject)e2, "front_request");
              this.a.A = j.a((JSONObject)e2, "title");
              this.a.B = j.a((JSONObject)e2, "succ_info");
              b.b((JSONObject)e2, this.a);
              b.a((JSONObject)e2, this.a);
              if (this.B != null)
                this.B.f(); 
              a(this.d, this.q + "_succeed");
              if (this.a.f) {
                i = this.a.aQ;
                PreferenceUtils.c(this.d, i);
                this.a.I.f = "success";
                k();
              } 
              break;
            case 2:
              this.C = true;
              e(v());
          } 
          d(8);
        } 
        if (this.s.equalsIgnoreCase("03")) {
          str2 = j.a(i, "fail_msg");
          a(this.d, this.q + "_fail", p.j, (Object[])new String[] { this.s, str2 });
          if (this.t == 3)
            a(str2); 
          bb bb = new bb(this);
          bc bc = new bc(this);
          if (this.a.F) {
            this.b.a(bb, bc);
            this.b.a(c.bD.ab, str2, c.bD.ac, c.bD.ad);
          } 
          this.b.a(bb, null);
          this.b.a(c.bD.ab, str2, c.bD.ac);
        } 
        if (this.v <= 0) {
          String str = c(19);
          str2 = str;
          if (this.a.ak != null) {
            str2 = str;
            if (!TextUtils.isEmpty(this.a.ak))
              str2 = this.a.ak; 
          } 
          if (this.t == 3)
            a(str2, true); 
          a(str2);
        } 
      case 2:
      case 3:
        this.a.aj = i.a(str2.toString());
        str2 = j.a((JSONObject)str2, "qn");
        if (!TextUtils.isEmpty(str2))
          this.a.n = this.e.i(c.b(str2)); 
        if (this.a.aj == null || this.a.aj.length() <= 0)
          b(2); 
        this.v = 20;
        f(this.u);
      case 7:
        j();
        j = f.a(this.a, (JSONObject)str2, false);
        if (j != 0)
          b(j); 
        e1 = f.a((JSONObject)str2);
        if (this.a.z != null && this.a.z.length() > 0)
          a(6, e1); 
        if (this.a.D != null && this.a.D.length() > 0)
          d(5); 
      case 8:
        j();
        jSONArray1 = j.d((JSONObject)e1, "options");
        if (this.A != null)
          this.A.a(jSONArray1); 
      case 9:
        str3 = j.a((JSONObject)jSONArray1, "status");
        if (str3 != null && "01".equals(str3)) {
          str1 = j.a((JSONObject)jSONArray1, "uuid");
          if (this.w >= 0)
            d(this.E, str1); 
          str1 = c.bD.D;
          if (this.A != null)
            this.A.a(null, str1); 
        } 
        jSONArray2 = j.d((JSONObject)str1, "options");
        str1 = j.a((JSONObject)str1, "empty_info");
        if (this.A != null)
          this.A.a(jSONArray2, str1); 
      case 16:
        break;
    } 
    if (this.b.a())
      this.b.c(); 
    new JSONObject();
    if (TextUtils.isEmpty(j.a((JSONObject)str1, "instalment_empty_info")))
      jSONObject = j.c((JSONObject)str1, "instalment"); 
    this.A.a(jSONObject);
    this.u = 0;
  }
  
  public final void a(boolean paramBoolean) {
    if (this.z != null) {
      TextView textView = this.z;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      textView.setEnabled(paramBoolean);
    } 
  }
  
  protected final boolean a(String paramString, JSONObject paramJSONObject) {
    null = true;
    this.D = false;
    if (this.u == 1 && d(paramJSONObject)) {
      d(paramString);
      return null;
    } 
    return false;
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay ay = new ay(getContext(), this.a.A, this);
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final void b(int paramInt) {
    if (this.u == 16) {
      if (this.b != null)
        this.b.c(); 
      z z = this.A.c("instalment");
      if (z != null) {
        ((p)z).a(false);
        ((p)z).b(false);
      } 
    } 
    super.b(paramInt);
  }
  
  protected final void c() {
    z z;
    boolean bool;
    this.m.removeAllViews();
    this.o.a(this);
    this.r.setId(this.r.hashCode());
    this.r.setOrientation(1);
    this.r.setBackgroundColor(0);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    this.m.addView((View)this.r, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout2 = this.r;
    linearLayout2.removeAllViews();
    JSONArray jSONArray = new JSONArray();
    if (this.p != null) {
      f f = (f)this.p;
      jSONArray.put(f.a("promotion"));
      jSONArray.put(f.a("instalment"));
      this.a.aU = f.a("promotion_instalment_msgbox");
    } 
    if (jSONArray.length() > 0) {
      this.A = new a(this.d, jSONArray, this, this.q);
      this.A.a(this.b, this.a.aU);
      this.A.d(this.a.bt);
      this.A.a(this.G);
      this.A.b(this.H);
      this.A.c(this.I);
      LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
      layoutParams4.topMargin = a.f;
      linearLayout2.addView((View)this.A, (ViewGroup.LayoutParams)layoutParams4);
    } 
    jSONArray = null;
    if (this.A != null)
      z = this.A.c("instalment"); 
    this.B = new a(this.d, this.a.z, this.e.c(), this, this.a.aq, true, false, z, this.a.ad, this.q);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.topMargin = a.f;
    linearLayout2.addView((View)this.B, (ViewGroup.LayoutParams)layoutParams);
    LinearLayout linearLayout1 = new LinearLayout(this.d);
    linearLayout1.setOrientation(1);
    linearLayout1.setId(linearLayout1.hashCode());
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams3.addRule(3, this.r.getId());
    layoutParams3.leftMargin = a.f;
    layoutParams3.topMargin = layoutParams3.leftMargin;
    this.m.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams3);
    if (i() || this.a.al != null || this.a.am != null) {
      if (this.a.al != null) {
        this.y = new a(this.d, this.a.al, this.J, this.q + "_agree_user_protocol");
        linearLayout1.addView((View)this.y);
      } 
      if (this.a.am != null) {
        this.x = new a(this.d, this.a.am, null, this.q + "_remember_bankNO");
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = a.f;
        linearLayout1.addView((View)this.x, (ViewGroup.LayoutParams)layoutParams4);
      } 
    } 
    this.z = new TextView(this.d);
    this.z.setText(j.a(this.a.C, "label"));
    this.z.setTextSize(b.i);
    this.z.setTextColor(p());
    this.z.setGravity(17);
    TextView textView = this.z;
    if (this.B == null || this.B.e()) {
      bool = true;
    } else {
      bool = false;
    } 
    textView.setEnabled(bool);
    int i = a.n;
    Drawable drawable = this.c.a(2008);
    this.z.setBackgroundDrawable(drawable);
    this.z.setOnClickListener(this.F);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, i);
    layoutParams2.addRule(3, linearLayout1.getId());
    layoutParams2.topMargin = a.f;
    i = g.a(this.d, 10.0F);
    layoutParams2.rightMargin = i;
    layoutParams2.leftMargin = i;
    this.m.addView((View)this.z, (ViewGroup.LayoutParams)layoutParams2);
  }
  
  public final void c(String paramString) {
    String str;
    this.j = false;
    this.b.a(c.bD.U);
    if (i()) {
      str = "\"card\":\"" + this.a.aq + "\"";
    } else {
      str = "\"card\":\"" + ((c)this.a.q.get(this.a.N)).a() + "\"";
    } 
    k.a("uppay", "cmd:" + paramString + ", ele:" + str);
    this.e.c(paramString, str);
    this.u = 6;
  }
  
  public final void c(String paramString1, String paramString2) {
    a(paramString1, paramString2);
  }
  
  public final void l() {
    if (!this.B.d()) {
      if (this.a.L) {
        a(13);
        this.a.L = false;
        return;
      } 
      if (this.a.K && this.D) {
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
  
  protected final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.B.d();
  }
  
  public final void u() {
    String str;
    this.b.a(c.bD.U);
    z z = this.A.c("promotion");
    if (z != null) {
      str = "\"" + ((aj)z).g() + "\"";
    } else {
      str = "\"\"";
    } 
    this.e.c("instalment", "\"promotion\":" + str);
    this.u = 16;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */