package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import java.lang.ref.WeakReference;

public final class m {
  private static final float k = b.k;
  
  private static final float l = b.k;
  
  private static final float m = b.j;
  
  private Context a = null;
  
  private TextView b = null;
  
  private WeakReference<View.OnClickListener> c = null;
  
  private TextView d = null;
  
  private WeakReference<View.OnClickListener> e = null;
  
  private int f = 0;
  
  private c g = null;
  
  private Dialog h = null;
  
  private Drawable i = null;
  
  private WeakReference<DialogInterface.OnDismissListener> j = null;
  
  public m(Context paramContext) {
    this(paramContext, (byte)0);
  }
  
  private m(Context paramContext, byte paramByte) {
    this.a = paramContext;
    this.j = new WeakReference<DialogInterface.OnDismissListener>(null);
    this.g = c.a(paramContext);
    this.f = a.I - a.b * 4;
    int i = this.f / 2;
    this.i = this.g.a(1028, i, -1);
  }
  
  private RelativeLayout a(Context paramContext) {
    c();
    this.h = new n(this, paramContext);
    if (this.j != null && this.j.get() != null)
      this.h.setOnDismissListener(this.j.get()); 
    this.h.setCanceledOnTouchOutside(false);
    this.h.setOwnerActivity((Activity)paramContext);
    this.h.requestWindowFeature(1);
    this.h.getWindow().setBackgroundDrawable(this.g.a(4004));
    RelativeLayout relativeLayout1 = new RelativeLayout(this.a);
    this.h.getWindow().setBackgroundDrawable(this.g.a(4004));
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(this.f, -2);
    this.h.setContentView((View)relativeLayout1, (ViewGroup.LayoutParams)layoutParams1);
    RelativeLayout relativeLayout2 = new RelativeLayout(this.a);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13, -1);
    relativeLayout1.addView((View)relativeLayout2, (ViewGroup.LayoutParams)layoutParams2);
    return relativeLayout1;
  }
  
  private boolean d() {
    return ((Activity)this.a).isFinishing();
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2) {
    this.c = new WeakReference<View.OnClickListener>(paramOnClickListener1);
    this.e = new WeakReference<View.OnClickListener>(paramOnClickListener2);
  }
  
  public final void a(String paramString) {
    int i = g.a(this.a, 12.0F);
    g.a(this.a, 20.0F);
    RelativeLayout relativeLayout = a(this.a);
    relativeLayout.setBackgroundColor(a.M);
    if (this.h != null) {
      WindowManager.LayoutParams layoutParams3 = this.h.getWindow().getAttributes();
      layoutParams3.alpha = 0.7F;
      this.h.getWindow().setAttributes(layoutParams3);
    } 
    LinearLayout linearLayout2 = new LinearLayout(this.a);
    linearLayout2.setOrientation(1);
    linearLayout2.setGravity(17);
    int j = a.j;
    int k = this.f;
    ImageView imageView = new ImageView(this.a);
    imageView.setImageDrawable(this.i);
    linearLayout2.addView((View)imageView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(k - (j << 1), -2));
    TextView textView = new TextView(this.a);
    textView.setTextSize(l);
    textView.setTextColor(-1);
    textView.setText(paramString);
    textView.setGravity(16);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams2.topMargin = i;
    linearLayout2.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
    LinearLayout linearLayout1 = new LinearLayout(this.a);
    linearLayout1.setOrientation(0);
    linearLayout1.setGravity(17);
    k = a.p;
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(k, k);
    layoutParams1.topMargin = i;
    linearLayout2.addView((View)new ProgressBar(this.a), (ViewGroup.LayoutParams)layoutParams1);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.addRule(10, -1);
    layoutParams.addRule(14, -1);
    i = g.a(this.a, 20.0F);
    relativeLayout.setPadding(i, i, i, i);
    relativeLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams);
    if (this.h != null && !this.h.isShowing() && !d())
      this.h.show(); 
  }
  
  public final void a(String paramString1, String paramString2, String paramString3) {
    RelativeLayout relativeLayout = a(this.a);
    int i = a.b;
    LinearLayout linearLayout2 = new LinearLayout(this.a);
    linearLayout2.setOrientation(1);
    linearLayout2.setGravity(1);
    relativeLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    if (paramString1 != null && paramString1.length() != 0) {
      TextView textView1 = new TextView(this.a);
      textView1.getPaint().setFakeBoldText(true);
      textView1.setTextSize(k);
      textView1.setTextColor(-13421773);
      textView1.setText(paramString1);
      textView1.setGravity(17);
      textView1.setPadding(i, i << 1, i, i);
      linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    } 
    TextView textView = new TextView(this.a);
    textView.setTextSize(l);
    textView.setTextColor(-13421773);
    textView.setText(paramString2);
    textView.setPadding(i, i, i, 0);
    textView.setGravity(17);
    linearLayout2.addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    FrameLayout frameLayout = new FrameLayout(this.a);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams1.topMargin = a.b << 1;
    linearLayout2.addView((View)frameLayout, (ViewGroup.LayoutParams)layoutParams1);
    linearLayout2 = new LinearLayout(this.a);
    linearLayout2.setOrientation(1);
    frameLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    LinearLayout linearLayout1 = new LinearLayout(this.a);
    linearLayout1.setOrientation(0);
    linearLayout1.setBackgroundColor(-7829368);
    new LinearLayout.LayoutParams(-1, -2);
    linearLayout2.addView((View)linearLayout1);
    linearLayout1 = new LinearLayout(this.a);
    linearLayout2.addView((View)linearLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    linearLayout1.setOrientation(0);
    linearLayout1.setGravity(17);
    this.b = new TextView(this.a);
    this.b.setPadding(5, 5, 5, 5);
    this.b.getPaint().setFakeBoldText(true);
    this.b.setText(paramString3);
    this.b.setTextSize(m);
    this.b.setTextColor(h.a(-15364869, -5846275));
    this.b.setGravity(17);
    i = a.o;
    if (this.c != null && this.c.get() != null)
      this.b.setOnClickListener(this.c.get()); 
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i);
    linearLayout1.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams2);
    frameLayout.addView(new o(this.a), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, a.H));
    if (this.h != null && !this.h.isShowing() && !d())
      this.h.show(); 
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    a(paramString1, paramString2, paramString3, paramString4, true);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    RelativeLayout relativeLayout = a(this.a);
    int i = a.b;
    LinearLayout linearLayout4 = new LinearLayout(this.a);
    linearLayout4.setOrientation(1);
    linearLayout4.setGravity(1);
    relativeLayout.addView((View)linearLayout4, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    if (paramString1 != null && paramString1.length() != 0) {
      TextView textView1 = new TextView(this.a);
      textView1.getPaint().setFakeBoldText(true);
      textView1.setTextSize(k);
      textView1.setTextColor(-13421773);
      textView1.setText(paramString1);
      textView1.setGravity(17);
      textView1.setPadding(i, i << 1, i, i);
      linearLayout4.addView((View)textView1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    } 
    TextView textView = new TextView(this.a);
    textView.setTextSize(l);
    textView.setTextColor(-13421773);
    textView.setText(paramString2);
    textView.setPadding(i, i, i, 0);
    textView.setGravity(17);
    linearLayout4.addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    int j = g.a(this.a, 1.0F);
    LinearLayout linearLayout3 = new LinearLayout(this.a);
    linearLayout3.setOrientation(0);
    linearLayout3.setBackgroundColor(-7829368);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, j);
    layoutParams1.topMargin = a.b << 1;
    linearLayout4.addView((View)linearLayout3, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout1 = new LinearLayout(this.a);
    linearLayout1.setBackgroundColor(-1);
    linearLayout4.addView((View)linearLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    linearLayout1.setOrientation(0);
    linearLayout1.setGravity(17);
    int k = this.f - a.H >> 1;
    this.b = new TextView(this.a);
    if (!paramBoolean)
      this.b.getPaint().setFakeBoldText(true); 
    this.b.setText(paramString3);
    this.b.setTextSize(m);
    this.b.setTextColor(h.a(-15364869, -5846275));
    this.b.setGravity(17);
    i = a.o;
    if (this.c != null && this.c.get() != null)
      this.b.setOnClickListener(this.c.get()); 
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(k, i);
    layoutParams3.leftMargin = 5;
    layoutParams3.bottomMargin = 5;
    linearLayout1.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams3);
    LinearLayout linearLayout2 = new LinearLayout(this.a);
    linearLayout2.setOrientation(1);
    linearLayout2.setBackgroundColor(-7829368);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(j, -1));
    this.d = new TextView(this.a);
    if (paramBoolean)
      this.d.getPaint().setFakeBoldText(true); 
    this.d.setText(paramString4);
    this.d.setTextSize(m);
    this.d.setTextColor(h.a(-15364869, -5846275));
    this.d.setGravity(17);
    if (this.e != null && this.e.get() != null)
      this.d.setOnClickListener(this.e.get()); 
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(k, i);
    layoutParams2.leftMargin = 5;
    layoutParams2.bottomMargin = 5;
    linearLayout1.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams2);
    if (this.h != null && !this.h.isShowing() && !d())
      this.h.show(); 
  }
  
  public final boolean a() {
    return (this.h != null && this.h.isShowing());
  }
  
  public final void b() {
    if (this.h != null) {
      this.h.hide();
      this.h.show();
    } 
  }
  
  public final void c() {
    if (this.h != null && this.h.isShowing()) {
      this.h.dismiss();
      this.h = null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */