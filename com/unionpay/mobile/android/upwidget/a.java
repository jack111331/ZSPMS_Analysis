package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.sdk.UPAgent;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends LinearLayout {
  private String a = "";
  
  private String b = "";
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private String i = "";
  
  private Button j = null;
  
  private boolean k = false;
  
  private Context l = null;
  
  private float m = 0.0F;
  
  private View.OnClickListener n = new b(this);
  
  private String o;
  
  private TextView p;
  
  private a q;
  
  private String r;
  
  public a(Context paramContext, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener, String paramString) {
    this(paramContext, paramJSONObject, paramOnClickListener, paramString, (byte)0);
  }
  
  private a(Context paramContext, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener, String paramString, byte paramByte) {
    super(paramContext);
    this.l = paramContext;
    this.m = 16.0F;
    this.r = paramString;
    this.a = j.a(paramJSONObject, "name");
    this.b = j.a(paramJSONObject, "value");
    this.c = j.a(paramJSONObject, "label");
    this.d = j.a(paramJSONObject, "href_label");
    this.e = j.a(paramJSONObject, "href_url");
    this.f = j.a(paramJSONObject, "href_title");
    this.g = j.a(paramJSONObject, "checked");
    this.h = j.a(paramJSONObject, "required");
    this.i = j.a(paramJSONObject, "error_info");
    this.o = j.a(paramJSONObject, "ckb_style");
    this.j = new Button(this.l);
    if (a(this.g) && this.g.equalsIgnoreCase("0")) {
      this.k = true;
    } else {
      this.k = false;
    } 
    this.j.setOnClickListener(this.n);
    g();
    f();
    int i = g.a(this.l, 20.0F);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
    layoutParams.gravity = 16;
    addView((View)this.j, (ViewGroup.LayoutParams)layoutParams);
    if (this.q != null) {
      a a1 = this.q;
      boolean bool = this.k;
    } 
    if (a(this.c)) {
      this.p = new TextView(this.l);
      this.p.setText(this.c);
      this.p.setTextSize(this.m);
      this.p.setTextColor(-16777216);
      this.p.setOnClickListener(this.n);
      layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.gravity = 16;
      layoutParams.leftMargin = com.unionpay.mobile.android.global.a.d;
      addView((View)this.p, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (a(this.d) && a(this.e)) {
      TextView textView = new TextView(this.l);
      textView.setText((CharSequence)Html.fromHtml(this.d));
      textView.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
      String.format("<u>%s</u>", new Object[] { this.d });
      textView.setTextSize(this.m);
      textView.setOnClickListener(paramOnClickListener);
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams1.gravity = 16;
      addView((View)textView, (ViewGroup.LayoutParams)layoutParams1);
    } 
  }
  
  private static boolean a(String paramString) {
    return (paramString != null && paramString.length() > 0);
  }
  
  private boolean f() {
    boolean bool = false;
    if ("small".equalsIgnoreCase(this.o))
      bool = true; 
    return bool;
  }
  
  private void g() {
    if (this.j != null) {
      char c;
      int i;
      if (this.k) {
        c = 'ϰ';
      } else {
        c = 'ϯ';
      } 
      if (f()) {
        i = g.a(this.l, 15.0F);
      } else {
        i = com.unionpay.mobile.android.global.a.w;
      } 
      Drawable drawable = c.a(this.l).a(c, i, i);
      this.j.setBackgroundDrawable(drawable);
    } 
  }
  
  public final String a() {
    if (this.k) {
      String str1 = this.b;
      return String.format("\"%s\":\"%s\"", new Object[] { this.a, str1 });
    } 
    String str = "";
    return String.format("\"%s\":\"%s\"", new Object[] { this.a, str });
  }
  
  public final String b() {
    return this.i;
  }
  
  public final String c() {
    return this.e;
  }
  
  public final String d() {
    return this.f;
  }
  
  public final boolean e() {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (a(this.h)) {
      bool2 = bool1;
      if (this.h.equalsIgnoreCase("0"))
        bool2 = this.k; 
    } 
    return bool2;
  }
  
  public static interface a {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */