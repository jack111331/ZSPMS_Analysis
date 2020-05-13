package com.zz.sdk.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cg;

public class i extends LinearLayout {
  public static final int a = 0;
  
  public static final int b = 1;
  
  public static final int c = 2;
  
  private RelativeLayout d;
  
  private View e;
  
  private TextView f;
  
  public i(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public i(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.d = new RelativeLayout(paramContext);
    int j = cc.a(12.0F);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13);
    this.f = new TextView(paramContext);
    this.f.setVisibility(8);
    this.f.setPadding(0, j, 0, j);
    this.f.setId(16908308);
    this.f.setLines(1);
    this.f.setGravity(17);
    this.f.setTextAppearance(paramContext, 16842817);
    this.f.setTextColor(-7829368);
    this.d.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams2);
    this.e = (View)new ProgressBar(paramContext, null, 16843279);
    this.e.setVisibility(8);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams1.rightMargin = j;
    layoutParams1.addRule(15);
    layoutParams1.addRule(0, this.f.getId());
    this.d.addView(this.e, (ViewGroup.LayoutParams)layoutParams1);
    addView((View)this.d, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
  }
  
  public void a() {
    this.f.setVisibility(0);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    layoutParams.height = 0;
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void b() {
    this.f.setVisibility(8);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    layoutParams.height = -2;
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public int getBottomMargin() {
    return ((LinearLayout.LayoutParams)this.d.getLayoutParams()).bottomMargin;
  }
  
  public RelativeLayout getContentView() {
    return this.d;
  }
  
  public void setBottomMargin(int paramInt) {
    if (paramInt >= 0) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      layoutParams.bottomMargin = paramInt;
      this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  public void setState(int paramInt) {
    this.f.setVisibility(0);
    if (paramInt == 1) {
      this.e.setVisibility(8);
      this.f.setText(cg.bG.a());
      return;
    } 
    if (paramInt == 2) {
      this.e.setVisibility(0);
      this.f.setText(cg.bH.a());
      return;
    } 
    this.e.setVisibility(8);
    this.f.setText(cg.bF.a());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */