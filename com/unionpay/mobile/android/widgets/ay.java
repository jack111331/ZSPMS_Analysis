package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;

public final class ay extends RelativeLayout {
  private Context a = null;
  
  private TextView b = null;
  
  private ImageView c = null;
  
  private TextView d = null;
  
  private Drawable e = null;
  
  private ImageView f;
  
  private LinearLayout g;
  
  private int h = 0;
  
  private int i = 0;
  
  private int j = 0;
  
  private a k;
  
  public ay(Context paramContext, String paramString, Drawable paramDrawable, int paramInt, a parama) {
    super(paramContext);
    this.a = paramContext;
    this.k = parama;
    this.j = g.a(this.a, 10.0F);
    this.e = paramDrawable;
    this.h = paramInt;
    b(paramString);
  }
  
  public ay(Context paramContext, String paramString, a parama) {
    this(paramContext, paramString, parama, (byte)0);
  }
  
  private ay(Context paramContext, String paramString, a parama, byte paramByte) {
    super(paramContext);
    this.a = paramContext;
    this.k = parama;
    this.j = g.a(this.a, 10.0F);
    b(paramString);
  }
  
  private void b(String paramString) {
    this.i = com.unionpay.mobile.android.global.a.k;
    setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, this.i));
    setBackgroundColor(com.unionpay.mobile.android.global.a.M);
    c c = c.a(this.a);
    this.g = new LinearLayout(this.a);
    this.g.setOnClickListener(new az(this));
    this.g.setPadding(this.j, this.j, this.j, this.j);
    this.g.setGravity(16);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(9, -1);
    layoutParams2.addRule(15, -1);
    addView((View)this.g, (ViewGroup.LayoutParams)layoutParams2);
    int i = g.a(this.a, 20.0F);
    int j = g.a(this.a, 11.0F);
    if (this.h != 0)
      j = this.h; 
    ImageView imageView = new ImageView(this.a);
    if (this.e != null) {
      imageView.setBackgroundDrawable(this.e);
    } else {
      imageView.setBackgroundDrawable(c.a(1029));
    } 
    layoutParams2 = new RelativeLayout.LayoutParams(j, i);
    layoutParams2.addRule(15, -1);
    this.g.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
    layoutParams2 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.global.a.l, this.i);
    layoutParams2.addRule(13, -1);
    this.d = new TextView(this.a);
    this.d.setTextSize(20.0F);
    this.d.setTextColor(-1);
    this.d.setText(paramString);
    this.d.setGravity(17);
    this.d.setSingleLine(true);
    this.d.setEllipsize(TextUtils.TruncateAt.END);
    addView((View)this.d, (ViewGroup.LayoutParams)layoutParams2);
    if (!TextUtils.isEmpty(null)) {
      i = com.unionpay.mobile.android.global.a.e;
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.i);
      layoutParams.addRule(11, -1);
      layoutParams.addRule(15, -1);
      layoutParams.rightMargin = i;
      this.b = new TextView(this.a);
      this.b.setTextSize(16.0F);
      this.b.setTextColor(-1);
      this.b.setText(null);
      this.b.setGravity(16);
      this.b.setId(this.b.hashCode());
      addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
      j = com.unionpay.mobile.android.global.a.m;
      layoutParams = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.global.a.H, j);
      layoutParams.addRule(0, this.b.getId());
      layoutParams.addRule(15, -1);
      layoutParams.rightMargin = i;
      addView(new o(this.a, com.unionpay.mobile.android.global.a.N, 1), (ViewGroup.LayoutParams)layoutParams);
    } 
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.global.a.E, com.unionpay.mobile.android.global.a.D);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.rightMargin = this.j;
    Drawable drawable = c.a(1031);
    this.f = new ImageView(this.a);
    this.f.setBackgroundDrawable(drawable);
    addView((View)this.f, (ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.global.a.D, com.unionpay.mobile.android.global.a.D);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.rightMargin = this.j;
    this.c = new ImageView(this.a);
    addView((View)this.c, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final void a() {
    if (this.g != null)
      this.g.setVisibility(8); 
  }
  
  public final void a(int paramInt) {
    if (this.c != null) {
      if (paramInt == 0) {
        this.f.setVisibility(8);
        this.c.setVisibility(8);
      } else {
        this.c.setVisibility(8);
        this.f.setVisibility(0);
      } 
      this.c.setVisibility(paramInt);
    } 
  }
  
  public final void a(String paramString) {
    if (this.d != null)
      this.d.setText(paramString); 
  }
  
  public final void b() {
    setBackgroundColor(-16686660);
  }
  
  public static interface a {
    void m();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */