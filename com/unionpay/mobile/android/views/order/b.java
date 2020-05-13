package com.unionpay.mobile.android.views.order;

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
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upwidget.c;
import com.unionpay.mobile.android.upwidget.g;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.k;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends AbstractMethod {
  private TextView A;
  
  private boolean B = false;
  
  private int C = l.b.intValue();
  
  private JSONObject g;
  
  private JSONArray h;
  
  private boolean i;
  
  private com.unionpay.mobile.android.upviews.a j;
  
  private List<Map<String, Object>> k;
  
  private Drawable l;
  
  private PopupWindow m;
  
  private g n;
  
  private c o;
  
  private String p;
  
  private final View.OnClickListener q = new c(this);
  
  private final View.OnClickListener r = new d(this);
  
  private final AdapterView.OnItemClickListener s = new e(this);
  
  private a t;
  
  private int u = -1;
  
  private int v = 1;
  
  private b w;
  
  private Drawable x;
  
  private Drawable y;
  
  private Drawable z;
  
  public b(Context paramContext, List<Map<String, Object>> paramList, String paramString) {
    super(paramContext);
    this.k = paramList;
    this.p = paramString;
    this.o = new c(this.b, this.k, c.bD.bh, this.p, c.bD.bi, this.v, 0);
    this.o.a(this.q);
    this.n = new g(this.b, this.o);
    this.n.a(this.s);
    this.n.a(this.r);
  }
  
  private final void c(int paramInt) {
    int i = paramInt - this.o.c();
    if (paramInt != 0) {
      if (this.k != null && paramInt == this.k.size() + this.o.c()) {
        k.a("direct", " new ");
        if (this.w != null)
          this.w.a(); 
        this.m.dismiss();
        return;
      } 
      if (this.o.b() && this.o.c(paramInt)) {
        k.a("direct", " delete " + paramInt);
        i();
        if (this.w != null) {
          this.u = i;
          this.w.a(i);
        } 
      } else {
        this.v = paramInt;
        this.o.a(this.v);
        k.a("direct", " pay with " + paramInt);
        if (this.t != null)
          this.t.b.setText((CharSequence)this.o.b(this.v)); 
        if (this.w != null)
          this.w.b(i); 
      } 
      this.m.dismiss();
    } 
  }
  
  private boolean h() {
    return (this.i || this.k == null || this.k.size() == 0);
  }
  
  private void i() {
    if (this.o != null) {
      String str1;
      String str2;
      this.o.a();
      if (this.o.b()) {
        str1 = c.bD.bj;
      } else {
        str1 = c.bD.bh;
      } 
      if (this.o.b()) {
        str2 = c.bD.bk;
      } else {
        str2 = c.bD.bi;
      } 
      this.o.a(str1);
      this.o.b(str2);
      this.o.notifyDataSetChanged();
    } 
  }
  
  public final b a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3) {
    this.x = paramDrawable1;
    this.y = paramDrawable2;
    this.z = paramDrawable3;
    return this;
  }
  
  public final b a(b paramb) {
    this.w = paramb;
    return this;
  }
  
  public final b a(JSONArray paramJSONArray) {
    this.h = paramJSONArray;
    return this;
  }
  
  public final b a(JSONObject paramJSONObject) {
    this.g = paramJSONObject;
    if (this.A != null)
      this.A.setText((CharSequence)Html.fromHtml(a(this.g, "label"))); 
    return this;
  }
  
  public final void a(int paramInt) {
    byte b1;
    if (this.k != null) {
      b1 = this.k.size();
    } else {
      b1 = 0;
    } 
    if (b1 && this.u >= 0 && this.u < b1) {
      this.k.remove(this.u);
      this.u = -1;
      this.o.notifyDataSetChanged();
    } 
    c(this.o.c() + paramInt);
  }
  
  public final void a(RelativeLayout paramRelativeLayout) {
    TextView textView = new TextView(this.b);
    textView.setTextSize(com.unionpay.mobile.android.global.b.k);
    textView.setTextColor(-13421773);
    textView.setText(this.c);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(9, -1);
    layoutParams.addRule(15, -1);
    layoutParams.leftMargin = g.a(this.b, 10.0F);
    paramRelativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    if (TextUtils.isEmpty(this.c))
      paramRelativeLayout.setVisibility(8); 
    if (h()) {
      String str = a(this.g, "label");
      this.A = new TextView(this.b);
      this.A.setOnClickListener(new f(this));
      if (!a(str))
        this.A.setText((CharSequence)Html.fromHtml(str)); 
      a(this.A);
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams1.addRule(11, -1);
      layoutParams1.rightMargin = g.a(this.b, 10.0F);
      layoutParams1.addRule(15, -1);
      paramRelativeLayout.addView((View)this.A, (ViewGroup.LayoutParams)layoutParams1);
    } 
  }
  
  public final int b() {
    return this.C;
  }
  
  public final b b(Drawable paramDrawable) {
    this.l = paramDrawable;
    return this;
  }
  
  public final b b(boolean paramBoolean) {
    this.B = paramBoolean;
    return this;
  }
  
  public final void b(int paramInt) {
    this.C = paramInt;
  }
  
  public final void b(RelativeLayout paramRelativeLayout) {
    if (h() || this.B) {
      if (this.B)
        g(); 
      this.j = new com.unionpay.mobile.android.upviews.a(this.b, this.h, this, "bankpay");
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
      layoutParams.topMargin = com.unionpay.mobile.android.global.a.f;
      paramRelativeLayout.addView((View)this.j, (ViewGroup.LayoutParams)layoutParams);
      return;
    } 
    LinearLayout linearLayout1 = new LinearLayout(this.b);
    linearLayout1.setId(linearLayout1.hashCode());
    linearLayout1.setBackgroundColor(-3419943);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, 1);
    layoutParams1.topMargin = com.unionpay.mobile.android.global.a.f;
    paramRelativeLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams1);
    RelativeLayout relativeLayout = new RelativeLayout(this.b);
    relativeLayout.setId(relativeLayout.hashCode());
    relativeLayout.setBackgroundDrawable(this.l);
    relativeLayout.setOnClickListener(new g(this));
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.b.n);
    layoutParams4.addRule(3, linearLayout1.getId());
    paramRelativeLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams4);
    ImageView imageView = new ImageView(this.b);
    imageView.setId(imageView.hashCode());
    imageView.setBackgroundDrawable(c.a(this.b).a(1002));
    int i = g.a(this.b, 15.0F);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
    layoutParams2.addRule(11, -1);
    layoutParams2.addRule(15, -1);
    layoutParams2.rightMargin = g.a(this.b, 10.0F);
    relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
    TextView textView = new TextView(this.b);
    textView.setText((CharSequence)this.o.b(this.v));
    textView.setTextSize(com.unionpay.mobile.android.global.b.k);
    textView.setTextColor(-10066330);
    textView.setSingleLine(true);
    textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams5.addRule(9, -1);
    layoutParams5.addRule(15, -1);
    layoutParams5.addRule(0, imageView.getId());
    layoutParams5.leftMargin = g.a(this.b, 10.0F);
    relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams5);
    LinearLayout linearLayout2 = new LinearLayout(this.b);
    linearLayout2.setBackgroundColor(-3419943);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
    layoutParams3.bottomMargin = com.unionpay.mobile.android.global.a.f;
    layoutParams3.addRule(3, relativeLayout.getId());
    paramRelativeLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams3);
    this.t = new a((byte)0);
    this.t.a = (View)relativeLayout;
    this.t.b = textView;
  }
  
  public final void b(String paramString) {
    if (this.t != null)
      this.t.b.setText(paramString); 
  }
  
  public final com.unionpay.mobile.android.upviews.a.a c() {
    return (this.j != null) ? this.j.b() : null;
  }
  
  public final void c(RelativeLayout paramRelativeLayout) {
    paramRelativeLayout.setVisibility(8);
  }
  
  public final int d() {
    return this.v - this.o.c();
  }
  
  public final b d(String paramString) {
    this.c = paramString;
    return this;
  }
  
  public final b e(String paramString) {
    this.d = paramString;
    return this;
  }
  
  public final String e() {
    return this.d;
  }
  
  public final void f(String paramString) {
    this.o.b(paramString);
  }
  
  public final boolean f() {
    return (this.j == null || this.j.e());
  }
  
  public final void u() {}
  
  private final class a {
    View a;
    
    TextView b;
    
    private a(b this$0) {}
  }
  
  public static interface b {
    int a();
    
    int a(int param1Int);
    
    int b(int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */