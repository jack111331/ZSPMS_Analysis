package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends AbstractMethod {
  private JSONObject g;
  
  private JSONObject h;
  
  private a i;
  
  private TextView j;
  
  private TextView k;
  
  private RelativeLayout l;
  
  public i(Context paramContext) {
    super(paramContext);
  }
  
  private static JSONArray e(String paramString) {
    JSONArray jSONArray = new JSONArray();
    try {
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("label", "");
      jSONObject2.put("name", "user_name");
      if (!a(paramString))
        jSONObject2.put("value", paramString); 
      jSONObject2.put("regexp", "[.@_A-Za-z0-9]{1,64}");
      jSONObject2.put("type", "user_name");
      jSONObject2.put("tip", "");
      jSONObject2.put("placeholder", c.bD.bw);
      jSONArray.put(jSONObject2);
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("label", "");
      jSONObject1.put("name", "password");
      jSONObject1.put("type", "password");
      jSONObject1.put("placeholder", c.bD.bx);
      jSONArray.put(jSONObject1);
    } catch (Exception exception) {}
    return jSONArray;
  }
  
  public final i a(JSONObject paramJSONObject) {
    this.g = paramJSONObject;
    if (this.j != null) {
      String str = a(this.g, "label");
      if (!TextUtils.isEmpty(str)) {
        this.j.setText((CharSequence)Html.fromHtml(str));
        if (this.l != null)
          this.l.setVisibility(0); 
      } 
    } 
    return this;
  }
  
  public final void a(RelativeLayout paramRelativeLayout) {
    TextView textView = new TextView(this.b);
    textView.setText(this.c);
    textView.setTextColor(-13421773);
    textView.setTextSize(b.k);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(9, -1);
    layoutParams.addRule(15, -1);
    layoutParams.leftMargin = g.a(this.b, 10.0F);
    paramRelativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final int b() {
    return l.c.intValue();
  }
  
  public final i b(String paramString) {
    this.c = paramString;
    return this;
  }
  
  public final i b(JSONObject paramJSONObject) {
    this.h = paramJSONObject;
    if (this.k != null) {
      String str = a(this.h, "label");
      if (!TextUtils.isEmpty(str)) {
        this.k.setText((CharSequence)Html.fromHtml(str));
        if (this.l != null)
          this.l.setVisibility(0); 
      } 
    } 
    return this;
  }
  
  public final void b(RelativeLayout paramRelativeLayout) {
    this.i = new a(this.b, e(PreferenceUtils.c(this.b)), this, "");
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams.topMargin = a.f;
    paramRelativeLayout.addView((View)this.i, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final a.a c() {
    return (this.i != null) ? this.i.b() : null;
  }
  
  public final void c(RelativeLayout paramRelativeLayout) {
    String str1 = a(this.g, "label");
    this.j = new TextView(this.b);
    a(this.j);
    if (!TextUtils.isEmpty(str1))
      this.j.setText((CharSequence)Html.fromHtml(str1)); 
    this.j.setOnClickListener(new j(this));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(9, -1);
    layoutParams.addRule(15, -1);
    layoutParams.leftMargin = g.a(this.b, 10.0F);
    paramRelativeLayout.addView((View)this.j, (ViewGroup.LayoutParams)layoutParams);
    String str2 = a(this.h, "label");
    this.k = new TextView(this.b);
    a(this.k);
    if (!TextUtils.isEmpty(str2))
      this.k.setText((CharSequence)Html.fromHtml(str2)); 
    this.k.setOnClickListener(new k(this));
    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(11, -1);
    layoutParams.addRule(15, -1);
    layoutParams.rightMargin = g.a(this.b, 10.0F);
    paramRelativeLayout.addView((View)this.k, (ViewGroup.LayoutParams)layoutParams);
    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str1))
      paramRelativeLayout.setVisibility(8); 
    this.l = paramRelativeLayout;
  }
  
  public final i d(String paramString) {
    this.d = paramString;
    return this;
  }
  
  public final String e() {
    return this.d;
  }
  
  public final boolean f() {
    return (this.i == null || this.i.e());
  }
  
  public final String h() {
    return (this.i != null) ? this.i.b("user_name") : "";
  }
  
  protected final void onAttachedToWindow() {
    super.onAttachedToWindow();
    TextUtils.isEmpty(h());
  }
  
  protected final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.i != null)
      this.i.f(); 
  }
  
  public final void u() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */