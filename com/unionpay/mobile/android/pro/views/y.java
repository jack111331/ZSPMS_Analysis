package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.model.f;
import com.unionpay.mobile.android.nocard.utils.b;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.a;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class y extends b implements Handler.Callback, a.b {
  private a A = null;
  
  private String B;
  
  private boolean C = false;
  
  private Handler D = null;
  
  private View.OnClickListener E = new z(this);
  
  private View.OnClickListener F = new aa(this);
  
  private View.OnClickListener G = new ab(this);
  
  private View.OnClickListener H = new ac(this);
  
  private View.OnClickListener I = new ae(this);
  
  private String r = "00";
  
  private int s = 0;
  
  private int t = 0;
  
  private int u = 20;
  
  private int v = 5;
  
  private a w = null;
  
  private a x = null;
  
  private TextView y = null;
  
  private a z = null;
  
  public y(Context paramContext, e parame) {
    super(paramContext, parame);
    this.D = new Handler(this);
    this.C = this.a.K;
    setBackgroundColor(-1052684);
    e();
  }
  
  private void d(String paramString1, String paramString2) {
    this.t = 8;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    } else {
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    } 
    this.v--;
  }
  
  private void f(int paramInt) {
    this.t = 4;
    this.s = paramInt;
    paramInt = this.u;
    this.e.a("query", this.a.aj, 3);
    this.u--;
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
    this.t = 1;
  }
  
  public final void a(JSONObject paramJSONObject) {
    String str2;
    JSONArray jSONArray1;
    int i;
    this.C = false;
    switch (this.t) {
      default:
        return;
      case 1:
        j();
        this.t = 0;
        this.A.a(b.p);
      case 6:
        j();
        i = f.a(this.a, paramJSONObject, false);
        if (i != 0) {
          b(i);
        } else {
          this.a.K = true;
          if (this.a.z != null && this.a.z.length() > 0) {
            d(6);
          } else if (this.a.D != null && this.a.D.length() > 0) {
            d(5);
          } 
        } 
        this.t = 0;
      case 4:
        this.r = j.a(paramJSONObject, "status");
        if (this.u > 0 && this.r.equalsIgnoreCase("01"))
          f(this.s); 
        this.t = 0;
        if (this.r.equalsIgnoreCase("00")) {
          i = this.s;
          j();
          this.t = 0;
          this.a.H = j.d(paramJSONObject, "result");
          this.a.P = j.a(paramJSONObject, "openupgrade_flag");
          this.a.Q = j.a(paramJSONObject, "temporary_pay_flag");
          this.a.R = j.a(paramJSONObject, "temporary_pay_info");
          this.a.V = j.a(paramJSONObject, "front_url");
          this.a.W = j.a(paramJSONObject, "front_request");
          this.a.A = j.a(paramJSONObject, "title");
          this.a.B = j.a(paramJSONObject, "succ_info");
          b.b(paramJSONObject, this.a);
          b.a(paramJSONObject, this.a);
          if (this.A != null)
            this.A.f(); 
          a(this.d, this.q + "_succeed");
          if (this.a.f) {
            this.a.I.f = "success";
            k();
          } 
          d(8);
        } 
        if (this.r.equalsIgnoreCase("03")) {
          str2 = j.a(paramJSONObject, "fail_msg");
          a(this.d, this.q + "_fail", p.j, (Object[])new String[] { this.r, str2 });
          if (this.t == 3)
            a(str2); 
          af af = new af(this);
          ag ag = new ag(this);
          if (this.a.F) {
            this.b.a(af, ag);
            this.b.a(c.bD.Y, str2, c.bD.W, c.bD.X);
          } 
          this.b.a(af, null);
          this.b.a(c.bD.Y, str2, c.bD.W);
        } 
        if (this.u <= 0) {
          if (this.s == 3)
            a(this.a.ak, true); 
          a(this.a.ak);
        } 
      case 3:
        this.a.aj = i.a(str2.toString());
        str2 = j.a((JSONObject)str2, "qn");
        if (!TextUtils.isEmpty(str2))
          this.a.n = this.e.i(c.b(str2)); 
        if (this.a.aj == null || this.a.aj.length() <= 0)
          b(2); 
        this.u = 20;
        f(this.t);
      case 7:
        j();
        jSONArray1 = j.d((JSONObject)str2, "options");
        if (this.z != null)
          this.z.a(jSONArray1); 
      case 8:
        break;
    } 
    String str3 = j.a((JSONObject)jSONArray1, "status");
    if (str3 != null && "01".equals(str3)) {
      str1 = j.a((JSONObject)jSONArray1, "uuid");
      if (this.v >= 0)
        d(this.B, str1); 
      str1 = c.bD.D;
      if (this.z != null)
        this.z.a(null, str1); 
    } 
    JSONArray jSONArray2 = j.d((JSONObject)str1, "options");
    String str1 = j.a((JSONObject)str1, "empty_info");
    if (this.z != null)
      this.z.a(jSONArray2, str1); 
  }
  
  public final void a(boolean paramBoolean) {
    if (this.y != null) {
      TextView textView = this.y;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      textView.setEnabled(paramBoolean);
    } 
  }
  
  protected final boolean a(String paramString, JSONObject paramJSONObject) {
    this.C = false;
    return false;
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay ay = new ay(getContext(), this.a.A, (ay.a)this);
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  protected final void c() {
    boolean bool = false;
    LinearLayout linearLayout1 = new LinearLayout(this.d);
    linearLayout1.setId(linearLayout1.hashCode());
    linearLayout1.setOrientation(1);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    this.m.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams2);
    JSONArray jSONArray = new JSONArray();
    if (this.p != null) {
      f f = (f)this.p;
      jSONArray.put(f.a("promotion"));
      jSONArray.put(f.a("instalment"));
      this.a.aU = f.a("promotion_instalment_msgbox");
    } 
    if (jSONArray.length() > 0) {
      this.z = new a(this.d, jSONArray, this, this.q);
      this.z.a(this.b, this.a.aU);
      this.z.a(this.F);
      this.z.b(this.G);
      this.z.c(this.H);
      LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
      layoutParams4.topMargin = a.f;
      linearLayout1.addView((View)this.z, (ViewGroup.LayoutParams)layoutParams4);
    } 
    if (this.z != null)
      this.z.c("instalment"); 
    this.A = new a(this.d, this.a.z, this.e.c(), this, this.a.aq, false, this.q);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.topMargin = a.f;
    linearLayout1.addView((View)this.A, (ViewGroup.LayoutParams)layoutParams);
    LinearLayout linearLayout2 = new LinearLayout(this.d);
    linearLayout2.setOrientation(1);
    linearLayout2.setId(linearLayout2.hashCode());
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams3.addRule(3, linearLayout1.getId());
    layoutParams3.leftMargin = a.f;
    layoutParams3.topMargin = layoutParams3.leftMargin;
    this.m.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams3);
    if (i() || this.a.al != null || this.a.am != null) {
      if (this.a.al != null) {
        this.x = new a(this.d, this.a.al, this.I, this.q + "_agree_user_protocol");
        linearLayout2.addView((View)this.x);
      } 
      if (this.a.am != null) {
        this.w = new a(this.d, this.a.am, null, this.q + "_remember_bankNO");
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = a.f;
        linearLayout2.addView((View)this.w, (ViewGroup.LayoutParams)layoutParams4);
      } 
    } 
    this.y = new TextView(this.d);
    this.y.setText(j.a(this.a.C, "label"));
    this.y.setTextSize(b.i);
    this.y.setTextColor(p());
    this.y.setGravity(17);
    TextView textView = this.y;
    if (this.A == null || this.A.e())
      bool = true; 
    textView.setEnabled(bool);
    int i = a.n;
    Drawable drawable = this.c.a(2008);
    this.y.setBackgroundDrawable(drawable);
    this.y.setOnClickListener(this.E);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, i);
    layoutParams1.addRule(3, linearLayout2.getId());
    layoutParams1.topMargin = a.f;
    i = g.a(this.d, 10.0F);
    layoutParams1.rightMargin = i;
    layoutParams1.leftMargin = i;
    this.m.addView((View)this.y, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final void c(String paramString) {
    this.j = false;
    this.b.a(c.bD.U);
    String str = "\"card\":\"" + ((c)this.a.q.get(this.a.N)).a() + "\"";
    k.a("uppay", "cmd:" + paramString + ", ele:" + str);
    this.e.c(paramString, str);
    this.t = 6;
  }
  
  public final void c(String paramString1, String paramString2) {}
  
  public boolean handleMessage(Message paramMessage) {
    if (paramMessage.obj != null) {
      Bundle bundle = (Bundle)paramMessage.obj;
      String str1 = bundle.getString("action_resp_code");
      String str2 = bundle.getString("action_resp_message");
      if ("0000".equalsIgnoreCase(str1)) {
        if (str2 != null) {
          a(0, str2);
          return true;
        } 
        b(1);
        return true;
      } 
      a(this.a.ap, false);
      return true;
    } 
    b(1);
    return true;
  }
  
  public final void l() {
    if (!this.A.d()) {
      if (this.a.K && this.C) {
        this.a.K = false;
        n();
        return;
      } 
      this.a.K = false;
      this.a.br = false;
      a(2);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.A.d();
  }
  
  public final void u() {}
  
  public b v() {
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */