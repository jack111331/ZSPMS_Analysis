package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upwidget.j;
import com.unionpay.mobile.android.upwidget.q;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj extends z {
  private String A = "";
  
  private boolean B = true;
  
  private String C = "";
  
  private a D = null;
  
  private final View.OnClickListener a = new ak(this);
  
  private final View.OnClickListener b = new al(this);
  
  private final AdapterView.OnItemClickListener c = new am(this);
  
  private JSONArray o;
  
  private PopupWindow p;
  
  private j q;
  
  private int r;
  
  private int s = 0;
  
  private JSONArray t = null;
  
  private JSONArray u = null;
  
  private TextView v;
  
  private q w;
  
  private TextView x;
  
  private String y;
  
  private RelativeLayout z;
  
  public aj(Context paramContext, JSONObject paramJSONObject, String paramString, a parama) {
    super(paramContext, paramJSONObject, paramString);
    this.D = parama;
    this.r = 0;
    this.o = j.d(this.n, "items");
    this.y = j.a(paramJSONObject, "label");
    if (a(this.y))
      this.y = c.bD.bg; 
    if (!TextUtils.isEmpty(j.a(paramJSONObject, "default_item_idx")))
      this.s = Integer.parseInt(j.a(paramJSONObject, "default_item_idx")); 
    this.q = new j(paramContext, this.o, this.s, paramString);
    this.q.a(this.c);
    this.q.a(this.a);
    this.q.d(this.b);
    RelativeLayout relativeLayout = this.m;
    Drawable drawable = c.a(this.d).a(2014);
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setId(linearLayout.hashCode());
    linearLayout.setBackgroundColor(-3419943);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 1);
    j.a(this.n, "type");
    relativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    this.z = new RelativeLayout(this.d);
    this.z.setId(this.z.hashCode());
    this.z.setBackgroundDrawable(drawable);
    this.z.setOnClickListener(new an(this));
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(3, linearLayout.getId());
    relativeLayout.addView((View)this.z, (ViewGroup.LayoutParams)layoutParams1);
    ImageView imageView = new ImageView(this.d);
    imageView.setId(imageView.hashCode());
    imageView.setBackgroundDrawable(c.a(this.d).a(1002));
    int i = g.a(this.d, 15.0F);
    layoutParams1 = new RelativeLayout.LayoutParams(i, i);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.rightMargin = g.a(this.d, 10.0F);
    this.z.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    this.v = new TextView(this.d);
    this.v.setTextSize(b.k);
    this.v.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.v.setSingleLine(true);
    this.v.setTextColor(-10066330);
    layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(9, -1);
    layoutParams1.addRule(0, imageView.getId());
    layoutParams1.leftMargin = g.a(this.d, 10.0F);
    layoutParams1.rightMargin = layoutParams1.leftMargin;
    this.z.addView((View)this.v, (ViewGroup.LayoutParams)layoutParams1);
    if (!"instalment".equals("promotion")) {
      LinearLayout linearLayout1 = new LinearLayout(this.d);
      linearLayout1.setBackgroundColor(-3419943);
      layoutParams1 = new RelativeLayout.LayoutParams(-1, 1);
      layoutParams1.bottomMargin = com.unionpay.mobile.android.global.a.f;
      layoutParams1.addRule(3, this.z.getId());
      relativeLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams1);
    } 
    if (this.w != null)
      bool = this.w.b(); 
    a(bool);
    a(this.s, 0);
  }
  
  private String a(int paramInt1, int paramInt2, String paramString) {
    Object object = j.b(this.o, paramInt1);
    if (object != null) {
      object = object;
      String str = j.a((JSONObject)object, "type");
      if ("coupon".equals(str)) {
        object = this.t;
      } else if ("point".equals(str)) {
        object = this.u;
      } else {
        object = j.d((JSONObject)object, "options");
      } 
      object = j.b((JSONArray)object, paramInt2);
      if (object != null)
        return j.a((JSONObject)object, paramString); 
    } 
    return "";
  }
  
  private static JSONObject a(String paramString1, String paramString2, String paramString3) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", paramString1);
      jSONObject.put("label", paramString2);
      jSONObject.put("checked", paramString3);
      jSONObject.put("ckb_style", "small");
      jSONObject.put("required", "0");
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  private void a(int paramInt1, int paramInt2) {
    boolean bool2;
    boolean bool1 = false;
    this.s = paramInt1;
    this.r = paramInt2;
    if (this.v != null)
      this.v.setText(a(paramInt1, paramInt2, "label")); 
    String str1 = this.C;
    String str2 = a(paramInt1, paramInt2, "rel_label");
    String str3 = a(paramInt1, paramInt2, "rel_value");
    String str4 = a(paramInt1, paramInt2, "rel_value_style");
    this.C = str3;
    if (!this.B)
      this.D.g(); 
    this.B = false;
    this.A = a(paramInt1, paramInt2, "value");
    if (a(str2) && a(str3)) {
      this.x.setVisibility(8);
      return;
    } 
    str1 = str4;
    if (com.unionpay.mobile.android.data.a.a(str4)) {
      paramInt1 = Color.parseColor(str4);
      str1 = Integer.toString(paramInt1, 16);
    } 
    str4 = "#ff" + str1;
    TextView textView = this.x;
    int i = Color.parseColor(str4);
    paramInt2 = str2.length();
    if (TextUtils.isEmpty(str3)) {
      paramInt1 = 0;
    } else {
      paramInt1 = str3.length();
    } 
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2 + str3);
    ForegroundColorSpan foregroundColorSpan1 = new ForegroundColorSpan(-13421773);
    ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(i);
    spannableStringBuilder.setSpan(foregroundColorSpan1, 0, paramInt2, 33);
    spannableStringBuilder.setSpan(foregroundColorSpan2, paramInt2, paramInt1 + paramInt2, 18);
    textView.setText((CharSequence)spannableStringBuilder);
    if (this.w != null) {
      bool2 = this.w.b();
    } else {
      bool2 = true;
    } 
    if (bool2) {
      paramInt1 = bool1;
    } else {
      paramInt1 = 8;
    } 
    this.x.setVisibility(paramInt1);
  }
  
  public final String a() {
    String str1 = a(this.s, this.r, "value");
    String str2 = str1;
    if (str1 != null)
      str2 = str1.replace("\"", "\\\""); 
    str1 = str2;
    if (this.w != null) {
      str1 = str2;
      if (!this.w.b())
        str1 = null; 
    } 
    k.c("uppay", n() + " : " + str1);
    return str1;
  }
  
  public final void a(View.OnClickListener paramOnClickListener) {
    this.q.b(this.a);
    this.q.b(paramOnClickListener);
  }
  
  public final void a(q.a parama) {
    if (this.w != null)
      this.w.a(parama); 
  }
  
  public final void a(JSONArray paramJSONArray) {
    this.t = paramJSONArray;
    this.q.a(paramJSONArray);
  }
  
  public final void a(JSONArray paramJSONArray, String paramString) {
    this.u = paramJSONArray;
    this.q.a(paramJSONArray, paramString);
  }
  
  public final void a(boolean paramBoolean) {
    byte b;
    if (!paramBoolean) {
      this.A = "";
    } else {
      this.A = a(this.s, this.r, "value");
    } 
    if (this.w != null)
      this.w.a(paramBoolean); 
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    this.m.setVisibility(b);
    if (this.x != null) {
      if (TextUtils.isEmpty(this.x.getText().toString())) {
        this.x.setVisibility(8);
        return;
      } 
    } else {
      return;
    } 
    this.x.setVisibility(b);
  }
  
  protected final boolean a(LinearLayout paramLinearLayout, String paramString) {
    if (!a(paramString)) {
      LinearLayout linearLayout = new LinearLayout(this.d);
      linearLayout.setBackgroundColor(-1);
      linearLayout.setOrientation(1);
      paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n));
      JSONObject jSONObject = a(j.a(this.n, "type"), paramString, j.a(this.n, "checked"));
      this.w = new q(this.d, jSONObject, s() + "_agree_reduce_activity");
      this.w.a();
      this.w.a(b.k);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
      layoutParams.gravity = 16;
      int i = g.a(this.d, 10.0F);
      layoutParams.rightMargin = i;
      layoutParams.leftMargin = i;
      linearLayout.addView((View)this.w, (ViewGroup.LayoutParams)layoutParams);
    } 
    return true;
  }
  
  public final void b(View.OnClickListener paramOnClickListener) {
    this.q.e(paramOnClickListener);
  }
  
  public final boolean b() {
    return true;
  }
  
  protected final boolean b_() {
    this.x = new TextView(this.d);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.leftMargin = g.a(this.d, 10.0F);
    int i = g.a(this.d, 5.0F);
    layoutParams.bottomMargin = i;
    layoutParams.topMargin = i;
    this.x.setTextSize(b.k);
    addView((View)this.x, (ViewGroup.LayoutParams)layoutParams);
    this.x.setVisibility(8);
    return true;
  }
  
  public final void c(View.OnClickListener paramOnClickListener) {
    this.q.c(paramOnClickListener);
  }
  
  public final boolean c() {
    return true;
  }
  
  protected final String d() {
    return "_select_reduce_activity";
  }
  
  public final boolean f() {
    String str = a(this.s, this.r, "available");
    return !(!TextUtils.isEmpty(str) && "1".equals(str));
  }
  
  public final String g() {
    return this.A;
  }
  
  public static interface a {
    void g();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */