package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.model.f;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.nocard.views.xlistview.a;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.c;
import com.unionpay.mobile.android.upwidget.g;
import com.unionpay.mobile.android.upwidget.w;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.z;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o extends b implements a.b {
  private int A = 20;
  
  private int B = 5;
  
  private com.unionpay.mobile.android.upwidget.a C = null;
  
  private a D = null;
  
  private b E;
  
  private String F;
  
  private View.OnClickListener G = new p(this);
  
  private View.OnClickListener H = new u(this);
  
  private boolean I = false;
  
  LinearLayout r = null;
  
  private int s = 0;
  
  private a t = null;
  
  private View.OnClickListener u = null;
  
  private View.OnClickListener v = null;
  
  private View.OnClickListener w = null;
  
  private TextView x = null;
  
  private int y = 0;
  
  private int z = 0;
  
  public o(Context paramContext, e parame) {
    super(paramContext, parame);
    if (this.a.K) {
      this.q = "loginpay_phoneNO_change";
    } else {
      this.q = "loginpay";
    } 
    this.u = new v(this);
    this.v = new w(this);
    this.w = new x(this);
    if (!q() && !w() && !this.a.aZ)
      this.I = true; 
    setBackgroundColor(-1052684);
    e();
    if (this.a.aF != null)
      c((JSONObject)null); 
  }
  
  private void a(LinearLayout paramLinearLayout) {
    JSONArray jSONArray = this.a.ac;
    if (jSONArray != null) {
      byte b1 = 0;
      while (true) {
        if (b1 < jSONArray.length()) {
          z z = a((JSONObject)j.b(jSONArray, b1), this.q);
          if (z != null)
            paramLinearLayout.addView((View)z); 
          b1++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void d(String paramString1, String paramString2) {
    this.s = 9;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    } else {
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    } 
    this.B--;
  }
  
  private void d(JSONObject paramJSONObject) {
    z z;
    e e2 = null;
    boolean bool1 = true;
    int i = f.a(this.a, paramJSONObject, false);
    if (i != 0) {
      b(i);
      if (1 == this.s)
        f(this.z); 
      return;
    } 
    e e1 = f.a(paramJSONObject);
    if (5 == this.s) {
      if (this.a.z != null && this.a.z.length() > 0) {
        a(6, e1);
        return;
      } 
      if (this.a.D != null && this.a.D.length() > 0)
        d(5); 
      return;
    } 
    this.p = e1;
    f(this.y);
    this.D.a(v(), this.a.aq, true, null, this.a.ad, this.q);
    this.D.a(this.G);
    this.D.b(this.H);
    this.D.a(this.b, this.a.aU);
    this.D.d(this.a.bt);
    e1 = e2;
    if (this.D != null)
      z = this.D.c("instalment"); 
    this.t.a(this.a.z, this.a.aq, true, z, this.a.ad, this.q);
    TextView textView = this.x;
    boolean bool2 = bool1;
    if (this.t != null)
      if (this.t.e()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    textView.setEnabled(bool2);
  }
  
  private void f(int paramInt) {
    this.y = paramInt;
    this.E.a(this.y);
  }
  
  private JSONArray v() {
    JSONArray jSONArray = new JSONArray();
    if (this.p != null) {
      f f = (f)this.p;
      jSONArray.put(f.a("promotion"));
      jSONArray.put(f.a("instalment"));
      this.a.aU = f.a("promotion_instalment_msgbox");
    } 
    return jSONArray;
  }
  
  private final boolean w() {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!this.a.aZ) {
      bool2 = bool1;
      if (this.a.ab != null) {
        bool2 = bool1;
        if (this.a.ab.size() > 0)
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  private void x() {
    this.s = 4;
    int i = this.A;
    this.e.a("query", this.a.aj, 3);
    this.A--;
  }
  
  public final void a(a.a parama) {
    this.t.d();
    if (!parama.a()) {
      a(parama.b);
      return;
    } 
    this.j = false;
    this.b.a(c.bD.U);
    this.e.c("sms", parama.b);
    this.s = 2;
  }
  
  public final void a(JSONObject paramJSONObject) {
    e e2;
    String str3;
    int i;
    String str2;
    e e1;
    JSONArray jSONArray1;
    String str1;
    JSONObject jSONObject;
    int j;
    String str4;
    JSONArray jSONArray2;
    switch (this.s) {
      default:
        return;
      case 2:
        j();
        this.t.a(com.unionpay.mobile.android.global.b.p);
      case 1:
      case 5:
        j();
        if (!b(paramJSONObject)) {
          if (this.s == 5)
            this.a.L = true; 
          d(paramJSONObject);
        } 
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
        this.s = 0;
      case 3:
        this.a.aj = i.a(e2.toString());
        str3 = j.a((JSONObject)e2, "qn");
        if (!TextUtils.isEmpty(str3))
          this.a.n = this.e.i(c.b(str3)); 
        if (this.a.aj == null)
          b(2); 
        this.A = 20;
        x();
      case 4:
        str4 = j.a((JSONObject)str3, "status");
        if (this.A > 0 && str4.equalsIgnoreCase("01"))
          x(); 
        j();
        if (str4.equalsIgnoreCase("00")) {
          this.s = 0;
          this.a.H = j.d((JSONObject)str3, "result");
          this.a.P = j.a((JSONObject)str3, "openupgrade_flag");
          this.a.Q = j.a((JSONObject)str3, "temporary_pay_flag");
          this.a.R = j.a((JSONObject)str3, "temporary_pay_info");
          this.a.V = j.a((JSONObject)str3, "front_url");
          this.a.W = j.a((JSONObject)str3, "front_request");
          this.a.A = j.a((JSONObject)str3, "title");
          this.a.B = j.a((JSONObject)str3, "succ_info");
          com.unionpay.mobile.android.nocard.utils.b.a((JSONObject)str3, this.a);
          com.unionpay.mobile.android.nocard.utils.b.b((JSONObject)str3, this.a);
          a(this.d, this.q + "_succeed");
          if (this.a.f) {
            i = this.a.aQ;
            PreferenceUtils.c(this.d, i);
            this.a.I.f = "success";
            k();
          } 
          d(8);
        } 
        if (str4.equalsIgnoreCase("03")) {
          str2 = j.a(i, "fail_msg");
          a(this.d, this.q + "_fail", p.j, (Object[])new String[] { str4, str2 });
          a(str2);
        } 
        if (this.A <= 0)
          b(19); 
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
        if (this.D != null)
          this.D.a(jSONArray1); 
      case 9:
        str4 = j.a((JSONObject)jSONArray1, "status");
        if (str4 != null && "01".equals(str4)) {
          str1 = j.a((JSONObject)jSONArray1, "uuid");
          if (this.B >= 0)
            d(this.F, str1); 
          str1 = c.bD.D;
          if (this.D != null)
            this.D.a(null, str1); 
        } 
        jSONArray2 = j.d((JSONObject)str1, "options");
        str1 = j.a((JSONObject)str1, "empty_info");
        if (this.D != null)
          this.D.a(jSONArray2, str1); 
      case 16:
        break;
    } 
    if (this.b.a())
      this.b.c(); 
    new JSONObject();
    if (TextUtils.isEmpty(j.a((JSONObject)str1, "instalment_empty_info")))
      jSONObject = j.c((JSONObject)str1, "instalment"); 
    this.D.a(jSONObject);
    this.s = 0;
  }
  
  public final void a(boolean paramBoolean) {
    TextView textView = this.x;
    if (!paramBoolean) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    textView.setEnabled(paramBoolean);
  }
  
  protected final boolean a(String paramString, JSONObject paramJSONObject) {
    null = true;
    if (this.s == 1) {
      f(this.z);
      j();
      a(paramString);
      return null;
    } 
    return false;
  }
  
  protected final void b() {
    // Byte code:
    //   0: new android/widget/RelativeLayout$LayoutParams
    //   3: dup
    //   4: iconst_m1
    //   5: bipush #-2
    //   7: invokespecial <init> : (II)V
    //   10: astore_1
    //   11: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   14: getfield o : Ljava/lang/String;
    //   17: astore_2
    //   18: new com/unionpay/mobile/android/widgets/ay
    //   21: dup
    //   22: aload_0
    //   23: getfield d : Landroid/content/Context;
    //   26: aload_2
    //   27: aload_0
    //   28: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Lcom/unionpay/mobile/android/widgets/ay$a;)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore #4
    //   35: aload_0
    //   36: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   39: getfield aC : Z
    //   42: ifeq -> 137
    //   45: aload_0
    //   46: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   49: getfield q : Ljava/util/List;
    //   52: ifnull -> 73
    //   55: aload_3
    //   56: astore #4
    //   58: aload_0
    //   59: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   62: getfield q : Ljava/util/List;
    //   65: invokeinterface size : ()I
    //   70: ifne -> 137
    //   73: aload_3
    //   74: astore #4
    //   76: aload_0
    //   77: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   80: getfield aZ : Z
    //   83: ifne -> 137
    //   86: aload_3
    //   87: astore #4
    //   89: aload_0
    //   90: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   93: getfield u : Ljava/lang/String;
    //   96: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   99: ifne -> 137
    //   102: new com/unionpay/mobile/android/widgets/ay
    //   105: dup
    //   106: aload_0
    //   107: getfield d : Landroid/content/Context;
    //   110: aload_2
    //   111: aload_0
    //   112: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   115: sipush #1030
    //   118: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   121: aload_0
    //   122: getfield d : Landroid/content/Context;
    //   125: ldc_w 20.0
    //   128: invokestatic a : (Landroid/content/Context;F)I
    //   131: aload_0
    //   132: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILcom/unionpay/mobile/android/widgets/ay$a;)V
    //   135: astore #4
    //   137: aload_1
    //   138: bipush #13
    //   140: iconst_m1
    //   141: invokevirtual addRule : (II)V
    //   144: aload_0
    //   145: getfield k : Landroid/widget/RelativeLayout;
    //   148: aload #4
    //   150: aload_1
    //   151: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   154: return
  }
  
  public final void b(int paramInt) {
    if (this.s == 16) {
      if (this.b != null)
        this.b.c(); 
      z z = this.D.c("instalment");
      if (z != null) {
        ((p)z).a(false);
        ((p)z).b(false);
      } 
    } 
    super.b(paramInt);
  }
  
  protected final void b(String paramString, JSONObject paramJSONObject) {
    if ("init".equals(paramString)) {
      a(2);
      return;
    } 
    if ("".equals(paramString)) {
      if (this.s == 5)
        this.a.L = true; 
      if (paramJSONObject != null)
        d(paramJSONObject); 
      return;
    } 
    this.b.a(c.bD.U);
    this.j = false;
    this.s = 7;
    this.e.c(paramString, "");
  }
  
  protected final void c() {
    this.m.removeAllViews();
    this.o.a(this);
    LinearLayout linearLayout1 = new LinearLayout(this.d);
    linearLayout1.setOrientation(1);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.topMargin = com.unionpay.mobile.android.global.a.f;
    layoutParams.addRule(10, -1);
    this.m.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
    a(linearLayout1);
    JSONArray jSONArray = v();
    if (jSONArray != null && jSONArray.length() > 0 && w()) {
      this.D = new a(this.d, jSONArray, this, this.q);
      this.D.a(this.G);
      this.D.b(this.H);
      this.D.a(this.b, this.a.aU);
      this.D.d(this.a.bt);
      LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
      layoutParams3.bottomMargin = com.unionpay.mobile.android.global.a.f;
      linearLayout1.addView((View)this.D, (ViewGroup.LayoutParams)layoutParams3);
    } 
    if (q()) {
      if (!w()) {
        if (!TextUtils.isEmpty(this.a.ae)) {
          LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
          layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f;
          TextView textView = new TextView(this.d);
          textView.setTextSize(com.unionpay.mobile.android.global.b.k);
          textView.setText(this.a.ae);
          linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)layoutParams3);
        } 
      } else {
        z z;
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setBackgroundColor(-3419943);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f;
        linearLayout1.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams3);
        layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        this.E = new b(this, this.d, new z(this), a.a(this.d, this.a.ab, false), (JSONArray)c.bD.bh, this.a.aY);
        linearLayout1.addView((View)this.E, (ViewGroup.LayoutParams)layoutParams3);
        linearLayout = null;
        if (this.D != null)
          z = this.D.c("instalment"); 
        this.t = new a(this.d, this.a.z, this.e.c(), this, this.a.aq, true, true, z, this.a.ad, this.q);
        linearLayout1.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams3);
      } 
    } else if (!w()) {
      if (TextUtils.isEmpty(this.a.aY)) {
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f;
        layoutParams3.leftMargin = g.a(this.d, 10.0F);
        TextView textView = new TextView(this.d);
        textView.setTextSize(com.unionpay.mobile.android.global.b.k);
        textView.setText(this.a.ae);
        linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)layoutParams3);
      } else {
        RelativeLayout relativeLayout = new RelativeLayout(this.d);
        TextView textView2 = new TextView(this.d);
        textView2.setTextSize(com.unionpay.mobile.android.global.b.k);
        textView2.setTextColor(-13421773);
        textView2.setText(c.bD.bA);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(9, -1);
        layoutParams5.addRule(15, -1);
        layoutParams5.leftMargin = g.a(this.d, 10.0F);
        relativeLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams5);
        TextView textView1 = new TextView(this.d);
        textView1.setText((CharSequence)Html.fromHtml(c.bD.j));
        textView1.setTextSize(com.unionpay.mobile.android.global.b.k);
        textView1.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
        textView1.setOnClickListener(new y(this));
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11, -1);
        layoutParams6.rightMargin = g.a(this.d, 10.0F);
        layoutParams6.addRule(15, -1);
        relativeLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams6);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = com.unionpay.mobile.android.global.a.f;
        linearLayout1.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams4);
        this.t = new a(this.d, this.a.t, this, this.q);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f;
        linearLayout1.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams3);
      } 
    } else {
      z z;
      LinearLayout linearLayout = new LinearLayout(this.d);
      linearLayout.setBackgroundColor(-3419943);
      linearLayout1.addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 1));
      LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
      this.E = new b(this, this.d, new aa(this), a.a(this.d, this.a.ab, false), (JSONArray)c.bD.bh, this.a.aY);
      linearLayout1.addView((View)this.E, (ViewGroup.LayoutParams)layoutParams4);
      layoutParams4 = null;
      if (this.D != null)
        z = this.D.c("instalment"); 
      this.t = new a(this.d, this.a.z, this.e.c(), this, this.a.aq, true, true, z, this.a.ad, this.q);
      LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
      linearLayout1.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams3);
    } 
    LinearLayout linearLayout2 = new LinearLayout(this.d);
    linearLayout2.setOrientation(1);
    linearLayout2.setId(linearLayout2.hashCode());
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams2.topMargin = com.unionpay.mobile.android.global.a.d;
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams2);
    if (this.a.Z != null && w()) {
      this.C = new com.unionpay.mobile.android.upwidget.a(this.d, a.a(this.a.Z, c.bD.s), new q(this), this.q + "_agree_user_protocol");
      linearLayout2.addView((View)this.C);
    } 
    w w = w.a(this.d, this.a.aa, this.c.a(1017));
    if (w != null) {
      w.a(new r(this, w.a()));
      layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f;
      linearLayout2.addView((View)w, (ViewGroup.LayoutParams)layoutParams2);
    } 
    this.x = new TextView(this.d);
    if (w()) {
      boolean bool;
      this.x.setText(c.bD.p);
      this.x.setOnClickListener(this.u);
      TextView textView = this.x;
      if (this.t == null || this.t.e()) {
        bool = true;
      } else {
        bool = false;
      } 
      textView.setEnabled(bool);
    } else if (q()) {
      this.x.setText(c.bD.q);
      this.x.setOnClickListener(new ab(this));
      this.x.setEnabled(true);
    } else if (TextUtils.isEmpty(this.a.aY) && !this.a.aZ) {
      if (this.a.q == null || this.a.q.size() == 0) {
        this.x.setText(c.bD.bu);
      } else {
        this.x.setText(c.bD.bv);
      } 
      this.x.setOnClickListener(this.w);
      this.x.setEnabled(true);
    } else {
      this.x.setText(c.bD.r);
      this.x.setOnClickListener(this.v);
      this.x.setEnabled(false);
    } 
    this.x.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.x.setTextColor(p());
    this.x.setGravity(17);
    int i = com.unionpay.mobile.android.global.a.n;
    Drawable drawable = this.c.a(2008);
    this.x.setBackgroundDrawable(drawable);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, i);
    layoutParams1.topMargin = com.unionpay.mobile.android.global.a.f;
    i = g.a(this.d, 10.0F);
    layoutParams1.rightMargin = i;
    layoutParams1.leftMargin = i;
    linearLayout1.addView((View)this.x, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final void c(String paramString) {
    String str;
    this.j = false;
    this.b.a(c.bD.U);
    if (this.a.aZ) {
      str = "\"card\":\"" + this.a.aq + "\"";
    } else {
      str = "\"card\":\"" + ((c)this.a.ab.get(this.y)).a() + "\"";
    } 
    k.a("uppay", "cmd:" + paramString + ", ele:" + str);
    this.e.c(paramString, str);
    this.s = 6;
  }
  
  public final void c(String paramString1, String paramString2) {
    a(paramString1, paramString2);
  }
  
  public final void l() {
    if (!TextUtils.isEmpty(this.a.u) && this.a.aC && (this.a.q == null || this.a.q.size() == 0)) {
      s s = new s(this);
      t t = new t(this);
      this.b.a(s, t);
      this.b.a(c.bD.Y, c.bD.av, c.bD.W, c.bD.X);
      return;
    } 
    if (this.a.aZ)
      this.a.aZ = false; 
    if (this.t == null || !this.t.d()) {
      if (this.a.u != null && this.a.u.length() > 0) {
        a(2);
        return;
      } 
      n();
    } 
  }
  
  protected final void onAttachedToWindow() {
    super.onAttachedToWindow();
    boolean bool = this.I;
  }
  
  public final void u() {
    String str;
    this.b.a(c.bD.U);
    z z = this.D.c("promotion");
    if (z != null) {
      str = "\"" + ((aj)z).g() + "\"";
    } else {
      str = "\"\"";
    } 
    this.e.c("instalment", "\"promotion\":" + str);
    this.s = 16;
  }
  
  public static interface a {
    void a(int param1Int);
  }
  
  private final class b extends LinearLayout {
    private PopupWindow b;
    
    private c c;
    
    private g d;
    
    private String e;
    
    private TextView f;
    
    private int g = 1;
    
    private final View.OnClickListener h = new ac(this);
    
    private final AdapterView.OnItemClickListener i = new ad(this);
    
    private List<Map<String, Object>> j;
    
    private o.a k;
    
    private String l;
    
    public b(o this$0, Context param1Context, o.a param1a, List<Map<String, Object>> param1List, JSONArray param1JSONArray, String param1String) {
      super(param1Context);
      setOrientation(1);
      this.k = param1a;
      this.j = param1List;
      this.e = (String)param1JSONArray;
      this.l = param1String;
      this.c = new c(this$0.d, this.j, this.e, this.l, "", this.g, 0);
      this.d = new g(this$0.d, this.c);
      this.d.a(this.i);
      this.d.a(this.h);
      if (param1List != null && param1List.size() > 0) {
        Drawable drawable = c.a(this.a.d).a(2014);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.d);
        relativeLayout.setBackgroundDrawable(drawable);
        relativeLayout.setOnClickListener(new ae(this));
        addView((View)relativeLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n));
        ImageView imageView = new ImageView(this.a.d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(c.a(this.a.d).a(1002));
        int i = g.a(this.a.d, 15.0F);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        layoutParams.rightMargin = g.a(this.a.d, 10.0F);
        relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
        this.f = new TextView(this.a.d);
        this.f.setTextSize(com.unionpay.mobile.android.global.b.k);
        this.f.setTextColor(-10066330);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f.setSingleLine(true);
        layoutParams.leftMargin = g.a(this.a.d, 10.0F);
        layoutParams.rightMargin = layoutParams.leftMargin;
        layoutParams.addRule(15, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(0, imageView.getId());
        relativeLayout.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
        a(0);
      } 
    }
    
    public final void a(int param1Int) {
      int i = this.c.c();
      if (this.f != null)
        this.f.setText((CharSequence)this.c.b(i + param1Int)); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */