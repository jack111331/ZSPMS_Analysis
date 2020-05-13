package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONObject;

public final class ai extends b {
  private TextView r = null;
  
  private View.OnClickListener s = new aj(this);
  
  public ai(Context paramContext) {
    super(paramContext);
    b();
    d();
    c();
  }
  
  private void u() {
    this.a.I.f = "success";
    k();
  }
  
  public final void a(JSONObject paramJSONObject) {
    j();
    this.a.T = j.d(paramJSONObject, "open_rules");
    if (this.a.T == null || this.a.T.length() <= 0) {
      b(2);
      return;
    } 
    d(10);
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay ay = new ay(getContext(), this.a.A, this);
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  protected final void c() {
    int i = a.d;
    LinearLayout linearLayout1 = new LinearLayout(this.d);
    linearLayout1.setBackgroundColor(-1114114);
    linearLayout1.setOrientation(1);
    linearLayout1.setPadding(0, i, 0, i);
    linearLayout1.setId(linearLayout1.hashCode());
    TextView textView2 = new TextView(this.d);
    textView2.setText(this.a.B);
    textView2.setTextSize(24.0F);
    textView2.setTextColor(-15365480);
    textView2.setGravity(1);
    textView2.getPaint().setFakeBoldText(true);
    linearLayout1.addView((View)textView2);
    LinearLayout linearLayout3 = new LinearLayout(this.d);
    linearLayout3.setOrientation(0);
    linearLayout3.setBackgroundColor(-6958338);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 2);
    layoutParams3.addRule(14, -1);
    int j = a.d;
    layoutParams3.bottomMargin = j;
    layoutParams3.topMargin = j;
    linearLayout1.addView((View)linearLayout3);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(10, -1);
    this.m.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams2);
    LinearLayout linearLayout2 = new LinearLayout(this.d);
    linearLayout2.setPadding(i, i, i, i);
    linearLayout2.setOrientation(1);
    linearLayout2.setId(linearLayout2.hashCode());
    layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams3.addRule(3, linearLayout1.getId());
    this.m.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams3);
    TextView textView1 = new TextView(this.d);
    textView1.setTextSize(18.0F);
    textView1.setText(this.a.S);
    textView1.setTextColor(-10066330);
    textView1.setGravity(3);
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
    this.r = new TextView(this.d);
    this.r.setText(c.bD.E);
    this.r.setTextSize(22.0F);
    this.r.setTextColor(h.a(-1, -730710, -730710, -6745));
    this.r.setGravity(17);
    this.r.setOnClickListener(this.s);
    i = a.n;
    Drawable drawable = this.c.a(2008);
    this.r.setBackgroundDrawable(drawable);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, i);
    layoutParams1.addRule(3, linearLayout2.getId());
    layoutParams1.addRule(12, -1);
    layoutParams1.bottomMargin = a.b;
    layoutParams1.topMargin = a.b;
    i = a.d;
    layoutParams1.rightMargin = i;
    layoutParams1.leftMargin = i;
    this.m.addView((View)this.r, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final void l() {
    u();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */