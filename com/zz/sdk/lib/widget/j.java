package com.zz.sdk.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cg;

public class j extends LinearLayout {
  public static final int h = 0;
  
  public static final int i = 1;
  
  public static final int j = 2;
  
  protected LinearLayout a;
  
  protected ImageView b;
  
  protected ProgressBar c;
  
  protected TextView d;
  
  protected RelativeLayout e;
  
  protected TextView f;
  
  protected LinearLayout g;
  
  private int k = 0;
  
  private Animation l;
  
  private Animation m;
  
  private final int n = 180;
  
  public j(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public j(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    setOrientation(1);
    setGravity(80);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
    this.a = new LinearLayout(paramContext);
    this.a.setGravity(80);
    addView((View)this.a, (ViewGroup.LayoutParams)layoutParams2);
    this.e = new RelativeLayout(paramContext);
    this.a.addView((View)this.e, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(60.0F)));
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams5.addRule(13);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setId(123);
    linearLayout.setOrientation(1);
    linearLayout.setGravity(1);
    this.e.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams5);
    this.d = new TextView(paramContext);
    this.d.setText(cg.bB.a());
    this.d.setTextColor(-7829368);
    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
    linearLayout.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams4);
    this.g = new LinearLayout(paramContext);
    layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
    this.g.setVisibility(8);
    layoutParams4.topMargin = cc.a(3.0F);
    linearLayout.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams4);
    TextView textView = new TextView(paramContext);
    textView.setTextColor(-7829368);
    textView.setTextSize(2, 13.0F);
    textView.setText(cg.bE.a());
    layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
    this.g.addView((View)textView, (ViewGroup.LayoutParams)layoutParams4);
    this.f = new TextView(paramContext);
    this.f.setTextColor(-7829368);
    this.f.setTextSize(2, 13.0F);
    layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
    this.g.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams4);
    this.b = new ImageView(paramContext);
    this.b.setImageDrawable(ca.aU.a(paramContext));
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.leftMargin = cc.a(50.0F);
    layoutParams3.rightMargin = cc.a(20.0F);
    layoutParams3.addRule(15);
    layoutParams3.addRule(0, linearLayout.getId());
    this.e.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams3);
    this.c = new ProgressBar(paramContext, null, 16843400);
    this.c.setVisibility(8);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams1.leftMargin = cc.a(50.0F);
    layoutParams1.rightMargin = cc.a(20.0F);
    layoutParams1.addRule(15);
    layoutParams1.addRule(0, linearLayout.getId());
    this.e.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams1);
    this.l = (Animation)new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.l.setDuration(180L);
    this.l.setFillAfter(true);
    this.m = (Animation)new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.m.setDuration(180L);
    this.m.setFillAfter(true);
  }
  
  public int getVisiableHeight() {
    return this.a.getHeight();
  }
  
  public void setState(int paramInt) {
    if (paramInt != this.k) {
      if (paramInt == 2) {
        this.b.clearAnimation();
        this.b.setVisibility(4);
        this.c.setVisibility(0);
      } else {
        this.b.setVisibility(0);
        this.c.setVisibility(4);
      } 
      switch (paramInt) {
        default:
          this.k = paramInt;
          return;
        case 0:
          if (this.k == 1)
            this.b.startAnimation(this.m); 
          if (this.k == 2)
            this.b.clearAnimation(); 
          this.d.setText(cg.bB.a());
        case 1:
          if (this.k != 1) {
            this.b.clearAnimation();
            this.b.startAnimation(this.l);
            this.d.setText(cg.bC.a());
          } 
        case 2:
          break;
      } 
      this.d.setText(cg.bD.a());
    } 
  }
  
  public void setVisiableHeight(int paramInt) {
    int i = paramInt;
    if (paramInt < 0)
      i = 0; 
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    layoutParams.height = i;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */