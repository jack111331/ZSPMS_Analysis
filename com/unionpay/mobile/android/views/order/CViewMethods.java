package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.g;
import java.util.HashMap;

public class CViewMethods extends LinearLayout {
  private static final Integer a = Integer.valueOf(-1);
  
  private static final Integer b = Integer.valueOf(-2);
  
  private static final int c = b.a;
  
  private Context d;
  
  private int e;
  
  private TextView f;
  
  private HashMap<Integer, String> g;
  
  private HashMap<Integer, Drawable> h;
  
  private String i;
  
  private a j;
  
  private Drawable k;
  
  public CViewMethods(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public CViewMethods(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CViewMethods(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext);
    this.d = paramContext;
    this.e = l.a.intValue();
    setOrientation(1);
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt) {
    float f = b.k;
    RelativeLayout relativeLayout = new RelativeLayout(this.d);
    relativeLayout.setClickable(true);
    if (this.k != null)
      relativeLayout.setBackgroundDrawable(this.k.getConstantState().newDrawable()); 
    relativeLayout.setOnClickListener(new h(this, paramInt));
    paramLinearLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(a.intValue(), b.n));
    ImageView imageView = new ImageView(this.d);
    imageView.setId(imageView.hashCode());
    if (this.h != null) {
      Drawable drawable = this.h.get(Integer.valueOf(paramInt));
      if (drawable != null)
        imageView.setBackgroundDrawable(drawable); 
    } 
    int i = g.a(this.d, 15.0F);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(i, i);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(11, -1);
    layoutParams1.rightMargin = c;
    relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView(this.d);
    textView.setClickable(false);
    textView.setTextSize(f);
    textView.setTextColor(-13421773);
    if (this.g != null) {
      String str = this.g.get(Integer.valueOf(paramInt));
      if (str != null)
        textView.setText((CharSequence)Html.fromHtml(str)); 
    } 
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a.intValue(), b.intValue());
    layoutParams2.addRule(15, -1);
    layoutParams2.addRule(9, -1);
    layoutParams2.addRule(0, imageView.getId());
    layoutParams2.leftMargin = c;
    relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
  }
  
  public final CViewMethods a(int paramInt) {
    if (paramInt > 0)
      this.e = paramInt; 
    return this;
  }
  
  public final CViewMethods a(Drawable paramDrawable) {
    this.k = paramDrawable;
    return this;
  }
  
  public final CViewMethods a(a parama) {
    this.j = parama;
    return this;
  }
  
  public final CViewMethods a(String paramString) {
    this.i = paramString;
    return this;
  }
  
  public final CViewMethods a(HashMap<Integer, String> paramHashMap) {
    this.g = paramHashMap;
    return this;
  }
  
  public final void a() {
    removeAllViews();
    if (this.e == l.a.intValue()) {
      setVisibility(8);
      return;
    } 
    this.f = new TextView(this.d);
    this.f.setTextColor(-13421773);
    this.f.setTextSize(b.k);
    if (this.i != null) {
      String str = this.i;
      if (this.f != null)
        this.f.setText(str); 
      TextView textView = this.f;
    } 
    this.f.setGravity(19);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(a.intValue(), b.intValue());
    layoutParams1.gravity = 19;
    layoutParams1.topMargin = c;
    layoutParams1.leftMargin = g.a(this.d, 10.0F);
    addView((View)this.f, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setBackgroundColor(-3419943);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
    layoutParams2.topMargin = c;
    addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    linearLayout = new LinearLayout(this.d);
    linearLayout.setOrientation(1);
    linearLayout.setBackgroundColor(-1);
    addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    if (l.b.intValue() == (l.b.intValue() & this.e))
      a(linearLayout, l.b.intValue()); 
    if (l.c.intValue() == (l.c.intValue() & this.e))
      a(linearLayout, l.c.intValue()); 
    if (l.e.intValue() == (l.e.intValue() & this.e)) {
      LinearLayout linearLayout1 = new LinearLayout(this.d);
      linearLayout1.setBackgroundColor(-3419943);
      layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
      layoutParams2.leftMargin = g.a(this.d, 10.0F);
      linearLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams2);
      a(linearLayout, l.e.intValue());
    } 
    if (l.d.intValue() == (l.d.intValue() & this.e)) {
      LinearLayout linearLayout1 = new LinearLayout(this.d);
      linearLayout1.setBackgroundColor(-3419943);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
      layoutParams.leftMargin = g.a(this.d, 10.0F);
      linearLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
      a(linearLayout, l.d.intValue());
    } 
    if (l.f.intValue() == (l.f.intValue() & this.e)) {
      LinearLayout linearLayout1 = new LinearLayout(this.d);
      linearLayout1.setBackgroundColor(-3419943);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
      layoutParams.leftMargin = g.a(this.d, 10.0F);
      linearLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
      a(linearLayout, l.f.intValue());
    } 
    linearLayout = new LinearLayout(this.d);
    linearLayout.setBackgroundColor(-3419943);
    addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 1));
  }
  
  public final CViewMethods b(HashMap<Integer, Drawable> paramHashMap) {
    this.h = paramHashMap;
    return this;
  }
  
  public static interface a {
    void c(int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\CViewMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */