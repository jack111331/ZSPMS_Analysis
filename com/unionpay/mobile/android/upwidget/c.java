package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c extends BaseAdapter {
  private Drawable a;
  
  private Drawable b;
  
  private Drawable c;
  
  private Context d;
  
  private String e = null;
  
  private String f = null;
  
  private String g = null;
  
  private boolean h = false;
  
  private int i = 1;
  
  private int j = 0;
  
  private List<Map<String, Object>> k;
  
  private ArrayList<View.OnClickListener> l = new ArrayList<View.OnClickListener>();
  
  private View.OnClickListener m = new d(this);
  
  public c(Context paramContext, List<Map<String, Object>> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {
    this.d = paramContext;
    this.k = paramList;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.i = paramInt1;
    this.j = paramInt2;
    this.a = com.unionpay.mobile.android.resource.c.a(this.d).a(1015);
    this.b = com.unionpay.mobile.android.resource.c.a(this.d).a(1016);
    this.c = com.unionpay.mobile.android.resource.c.a(this.d).a(1002);
  }
  
  private boolean d() {
    return (this.e != null && !TextUtils.isEmpty(this.e));
  }
  
  private boolean d(int paramInt) {
    boolean bool = true;
    paramInt -= c();
    if (paramInt != this.k.size()) {
      Object object = ((Map)this.k.get(paramInt)).get("available");
      if (object != null && Boolean.FALSE == (Boolean)object)
        return false; 
      bool = true;
    } 
    return bool;
  }
  
  private boolean e() {
    return (this.f != null && !TextUtils.isEmpty(this.f));
  }
  
  public final void a() {
    boolean bool;
    if (!this.h) {
      bool = true;
    } else {
      bool = false;
    } 
    this.h = bool;
  }
  
  public final void a(int paramInt) {
    this.i = paramInt;
  }
  
  public final void a(View.OnClickListener paramOnClickListener) {
    this.l.add(paramOnClickListener);
  }
  
  public final void a(String paramString) {
    this.e = paramString;
  }
  
  public final Spanned b(int paramInt) {
    paramInt -= c();
    if (paramInt == this.k.size())
      return null; 
    Map map = this.k.get(paramInt);
    String str1 = (String)map.get("text1");
    String str2 = (String)map.get("text2");
    return Html.fromHtml(str1 + " " + str2);
  }
  
  public final void b(String paramString) {
    this.g = paramString;
  }
  
  public final boolean b() {
    return this.h;
  }
  
  public final int c() {
    return d() ? 1 : 0;
  }
  
  public final boolean c(int paramInt) {
    boolean bool = true;
    paramInt -= c();
    if (paramInt != this.k.size()) {
      Object object = ((Map)this.k.get(paramInt)).get("editable");
      if (object != null && Boolean.FALSE == (Boolean)object)
        return false; 
      bool = true;
    } 
    return bool;
  }
  
  public final int getCount() {
    int i = 0;
    int j = 0;
    if (this.k == null)
      return j; 
    j = this.k.size();
    int k = c();
    if (e())
      i = 1; 
    i += j + k;
    return i;
  }
  
  public final Object getItem(int paramInt) {
    Object object1 = null;
    Object object2 = object1;
    if (paramInt != 0) {
      object2 = object1;
      if (this.k != null) {
        object2 = object1;
        if (paramInt < this.k.size())
          object2 = this.k.get(paramInt - c()); 
      } 
    } 
    return object2;
  }
  
  public final long getItemId(int paramInt) {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    RelativeLayout.LayoutParams layoutParams;
    boolean bool;
    LinearLayout linearLayout1 = new LinearLayout(this.d);
    linearLayout1.setOrientation(1);
    RelativeLayout relativeLayout = new RelativeLayout(this.d);
    int i = b.g;
    relativeLayout.setPadding(i, i, i, i);
    linearLayout1.addView((View)relativeLayout);
    LinearLayout linearLayout2 = new LinearLayout(this.d);
    linearLayout2.setBackgroundColor(-3419943);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, 1);
    if (paramInt - c() == this.k.size()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (d() && paramInt == 0) {
      TextView textView1 = new TextView(this.d);
      textView1.setText(this.e);
      textView1.setTextSize(b.k);
      textView1.setTextColor(-13421773);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams2.addRule(9, -1);
      layoutParams2.addRule(15, -1);
      layoutParams2.leftMargin = b.f;
      relativeLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
      if (this.g != null && !TextUtils.isEmpty(this.g)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      if (paramInt != 0) {
        TextView textView2 = new TextView(this.d);
        textView2.setText(this.g);
        textView2.setTextSize(b.k);
        textView2.setTextColor(-13421773);
        textView2.setOnClickListener(this.m);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = b.f;
        relativeLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams3);
      } 
      linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams1);
      return (View)linearLayout1;
    } 
    if (e() && bool) {
      TextView textView1 = new TextView(this.d);
      textView1.setText(this.f);
      textView1.setTextSize(b.k);
      textView1.setTextColor(-10066330);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams2.addRule(15, -1);
      layoutParams2.addRule(9, -1);
      relativeLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
      ImageView imageView1 = new ImageView(this.d);
      imageView1.setBackgroundDrawable(this.c);
      paramInt = g.a(this.d, 20.0F);
      layoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
      layoutParams.addRule(15, -1);
      layoutParams.addRule(11, -1);
      relativeLayout.addView((View)imageView1, (ViewGroup.LayoutParams)layoutParams);
      return (View)linearLayout1;
    } 
    ImageView imageView = new ImageView(this.d);
    imageView.setVisibility(4);
    imageView.setId(imageView.hashCode());
    TextView textView = new TextView(this.d);
    textView.setSingleLine(true);
    textView.setEllipsize(TextUtils.TruncateAt.END);
    textView.setText((CharSequence)b(paramInt));
    textView.setTextSize(b.k);
    textView.setTextColor(-10066330);
    int j = g.a(this.d, 20.0F);
    if (this.j == 0) {
      Drawable drawable;
      if (this.h) {
        drawable = this.b;
      } else {
        drawable = this.a;
      } 
      if (!this.h && this.i == paramInt && drawable != null) {
        imageView.setVisibility(0);
        imageView.setBackgroundDrawable(drawable);
      } else if (c(paramInt) && this.h && drawable != null) {
        imageView.setVisibility(0);
        imageView.setBackgroundDrawable(drawable);
      } 
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(j, j);
      layoutParams2.addRule(15, -1);
      layoutParams2.addRule(9, -1);
      relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
      layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams2.addRule(15, -1);
      layoutParams2.addRule(1, imageView.hashCode());
      layoutParams2.leftMargin = b.g;
      relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
    } else if (this.j == 1) {
      char c1;
      if (this.i == paramInt) {
        c1 = 'ϰ';
      } else {
        c1 = 'ϯ';
      } 
      int k = g.a(this.d, 20.0F);
      Drawable drawable = com.unionpay.mobile.android.resource.c.a(this.d).a(c1, j, j);
      if (d(paramInt))
        imageView.setVisibility(0); 
      imageView.setBackgroundDrawable(drawable);
      if (this.h) {
        drawable = this.b;
      } else {
        drawable = this.a;
      } 
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(k, k);
      layoutParams2.addRule(15, -1);
      layoutParams2.addRule(11, -1);
      relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
      layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams2.addRule(15, -1);
      layoutParams2.addRule(9, -1);
      layoutParams2.addRule(0, imageView.hashCode());
      layoutParams2.rightMargin = b.g;
      relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
      ((LinearLayout.LayoutParams)layoutParams).leftMargin = i;
    } 
    if (!e() || !bool)
      linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams); 
    return (View)linearLayout1;
  }
  
  public final boolean isEnabled(int paramInt) {
    return ((d() && paramInt == 0) || !d(paramInt)) ? false : super.isEnabled(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */