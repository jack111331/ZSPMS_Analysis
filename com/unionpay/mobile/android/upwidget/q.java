package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
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

public final class q extends RelativeLayout {
  private String a = "";
  
  private String b = "";
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private String i = "";
  
  private String j = "";
  
  private RelativeLayout k;
  
  private Button l = null;
  
  private boolean m = false;
  
  private Context n = null;
  
  private float o = 0.0F;
  
  private View.OnClickListener p = new r(this);
  
  private View.OnClickListener q = new s(this);
  
  private String r;
  
  private TextView s;
  
  private String t;
  
  private a u;
  
  public q(Context paramContext, JSONObject paramJSONObject, String paramString) {
    this(paramContext, paramJSONObject, paramString, (byte)0);
  }
  
  private q(Context paramContext, JSONObject paramJSONObject, String paramString, byte paramByte) {
    super(paramContext);
    this.n = paramContext;
    this.o = 16.0F;
    this.t = paramString;
    this.a = j.a(paramJSONObject, "name");
    this.b = j.a(paramJSONObject, "type");
    this.c = j.a(paramJSONObject, "value");
    this.d = j.a(paramJSONObject, "label");
    this.e = j.a(paramJSONObject, "href_label");
    this.f = j.a(paramJSONObject, "href_url");
    this.g = j.a(paramJSONObject, "href_title");
    this.h = j.a(paramJSONObject, "checked");
    this.i = j.a(paramJSONObject, "required");
    this.j = j.a(paramJSONObject, "error_info");
    this.r = j.a(paramJSONObject, "ckb_style");
    this.k = new RelativeLayout(this.n);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    addView((View)this.k, (ViewGroup.LayoutParams)layoutParams);
    if (a(this.d)) {
      this.s = new TextView(this.n);
      this.s.setId(this.s.hashCode());
      this.s.setText(this.d);
      this.s.setTextSize(this.o);
      this.s.setTextColor(-16777216);
      layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(9, -1);
      layoutParams.addRule(15, -1);
      this.k.addView((View)this.s, (ViewGroup.LayoutParams)layoutParams);
    } 
    this.l = new Button(this.n);
    this.l.setId(this.l.hashCode());
    if (a(this.h) && this.h.equalsIgnoreCase("0")) {
      this.m = true;
    } else {
      this.m = false;
    } 
    this.l.setOnClickListener(this.p);
    c();
    layoutParams = new RelativeLayout.LayoutParams(g.a(this.n, 60.0F), g.a(this.n, 34.0F));
    layoutParams.addRule(11, -1);
    layoutParams.addRule(15, -1);
    this.k.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams);
    if (this.u != null)
      this.u.a(this.b, this.m); 
    if (a(this.e) && a(this.f)) {
      TextView textView = new TextView(this.n);
      textView.setText((CharSequence)Html.fromHtml(this.e));
      textView.setTextSize(b.l);
      textView.setOnClickListener(this.q);
      textView.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
      layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(1, this.s.getId());
      layoutParams.addRule(15, -1);
      layoutParams.leftMargin = g.a(this.n, 10.0F);
      this.k.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private static boolean a(String paramString) {
    return (paramString != null && paramString.length() > 0);
  }
  
  private void c() {
    if (this.l != null) {
      char c;
      if (this.m) {
        c = 'ϲ';
      } else {
        c = 'ϱ';
      } 
      Drawable drawable = c.a(this.n).a(c, g.a(this.n, 60.0F), g.a(this.n, 34.0F));
      this.l.setBackgroundDrawable(drawable);
    } 
  }
  
  public final void a() {
    if (this.s != null)
      this.s.setTextColor(-13421773); 
  }
  
  public final void a(float paramFloat) {
    if (this.s != null)
      this.s.setTextSize(paramFloat); 
  }
  
  public final void a(a parama) {
    this.u = parama;
  }
  
  public final void a(boolean paramBoolean) {
    this.m = paramBoolean;
    c();
  }
  
  public final boolean b() {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (a(this.i)) {
      bool2 = bool1;
      if (this.i.equalsIgnoreCase("0"))
        bool2 = this.m; 
    } 
    return bool2;
  }
  
  public static interface a {
    void a(String param1String1, String param1String2);
    
    void a(String param1String, boolean param1Boolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */