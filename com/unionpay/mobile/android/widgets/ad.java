package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.data.a;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class ad extends z {
  private int a = 0;
  
  private String b;
  
  private TextView c;
  
  private TextView o;
  
  public ad(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    this(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
  }
  
  private ad(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte) {
    super(paramContext, paramJSONObject, paramString);
    this.a = paramInt;
    if (paramJSONObject != null)
      this.b = j.a(paramJSONObject, "style"); 
    RelativeLayout relativeLayout = this.m;
    LinearLayout linearLayout = new LinearLayout(this.d);
    relativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
    linearLayout.setOrientation(0);
    paramInt = this.a;
    paramInt = this.a;
    paramInt = a.f;
    this.c = new TextView(this.d);
    this.c.setTextSize(b.k);
    this.c.setText(p());
    this.c.setGravity(3);
    this.c.setTextColor(-13421773);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 0.3F);
    layoutParams2.gravity = 3;
    linearLayout.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams2);
    this.o = new TextView(this.d);
    this.o.setGravity(16);
    this.o.setTextSize(b.k);
    SpannableString spannableString = a.a(i(), this.b);
    this.o.setText((CharSequence)spannableString);
    this.o.setPadding(0, 0, a.g, 0);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, -2, 0.7F);
    layoutParams1.gravity = 21;
    linearLayout.addView((View)this.o, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public ad(Context paramContext, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramJSONObject, paramString);
    int i = a.f;
    String str = p();
    if (str != null && str.length() > 0) {
      this.c = new TextView(this.d);
      this.c.setTextSize(b.k);
      this.c.setText(p());
      this.c.setTextColor(-7829368);
      addView((View)this.c);
    } 
    str = i();
    if (str != null && str.length() > 0) {
      this.o = new TextView(this.d);
      this.o.setTextSize(b.k);
      this.o.setTextColor(-7829368);
      this.o.setText(i());
      addView((View)this.o);
    } 
  }
  
  public final String a() {
    return null;
  }
  
  public final void a(float paramFloat) {
    this.o.setTextSize(paramFloat);
  }
  
  public final boolean b() {
    return true;
  }
  
  public final boolean c() {
    return true;
  }
  
  public final void g() {
    this.o.setTextColor(-6710887);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */