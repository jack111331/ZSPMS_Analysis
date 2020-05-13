package com.zz.sdk.lib.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.df;

public class n extends RelativeLayout {
  TextView a;
  
  private Context b;
  
  private TextView c;
  
  private TextView d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  public n(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    a();
  }
  
  private void a() {
    int i = cc.a(5.0F);
    setBackgroundColor(-1);
    setPadding(i, i, i, i);
    ImageButton imageButton = new ImageButton(this.b);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(df.a(this.b, 7.0F), df.a(this.b, 12.0F));
    layoutParams1.addRule(11);
    layoutParams1.addRule(15);
    layoutParams1.leftMargin = cc.a(10.0F);
    imageButton.setBackgroundDrawable(ca.aD.a(this.b));
    imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    imageButton.setId(777);
    addView((View)imageButton, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout1 = new LinearLayout(this.b);
    linearLayout1.setId(1);
    linearLayout1.setOrientation(0);
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams4.addRule(0, imageButton.getId());
    addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams4);
    this.c = new TextView(this.b);
    this.c.setTextColor(-16777216);
    this.c.setTextSize(2, 14.0F);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
    linearLayout1.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams3);
    this.d = new TextView(this.b);
    this.d.setGravity(5);
    this.d.setTextSize(2, 14.0F);
    layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
    this.d.setTextColor(-7829368);
    linearLayout1.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams3);
    LinearLayout linearLayout2 = new LinearLayout(this.b);
    linearLayout2.setId(2);
    linearLayout2.setOrientation(0);
    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams6.topMargin = i;
    layoutParams6.addRule(3, linearLayout1.getId());
    layoutParams6.addRule(0, imageButton.getId());
    addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams6);
    this.e = new TextView(this.b);
    this.e.setTextColor(-16777216);
    this.e.setTextSize(2, 14.0F);
    this.e.setSingleLine();
    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
    linearLayout2.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams5);
    this.f = new TextView(this.b);
    this.f.setGravity(5);
    this.f.setTextSize(2, 14.0F);
    this.f.setTextColor(-7829368);
    linearLayout2.addView((View)this.f, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    linearLayout1 = new LinearLayout(this.b);
    linearLayout1.setOrientation(0);
    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams7.topMargin = i;
    layoutParams7.addRule(3, linearLayout2.getId());
    layoutParams7.addRule(0, imageButton.getId());
    addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams7);
    RelativeLayout relativeLayout = new RelativeLayout(this.b);
    linearLayout1.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams5);
    TextView textView = new TextView(this.b);
    textView.setTextColor(-16777216);
    textView.setId(1);
    textView.setText("订单状态：");
    relativeLayout.addView((View)textView);
    this.a = new TextView(this.b);
    this.a.setTextSize(2, 14.0F);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(1, textView.getId());
    relativeLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams2);
    this.g = new TextView(this.b);
    this.g.setTextColor(-13961);
    this.g.setTextSize(2, 14.0F);
    this.g.setText("状态查询");
    this.g.setGravity(5);
    linearLayout1.addView((View)this.g, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
  }
  
  public TextView getTxtNum() {
    return this.e;
  }
  
  public TextView getTxtTime() {
    return this.f;
  }
  
  public TextView getTxtTopright() {
    return this.d;
  }
  
  public TextView getTxtevent() {
    return this.c;
  }
  
  public TextView getTxtquery() {
    return this.g;
  }
  
  public TextView getTxts() {
    return this.a;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */