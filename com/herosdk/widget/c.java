package com.herosdk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class c extends Dialog implements View.OnClickListener {
  public static List a = new ArrayList();
  
  private static final String b = "frameLib.pd";
  
  private Activity c;
  
  private RadioGroup d;
  
  private f e;
  
  public c(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  private void a() {
    byte b = 0;
    try {
      Log.d("frameLib.pd", "iv");
      h h = new h();
      this((Context)this.c);
      i i = h.getDelegate();
      i.a(-1);
      i.c(5);
      i.d(1);
      i.e(Color.parseColor("#ffff0000"));
      LinearLayout linearLayout1 = new LinearLayout();
      this((Context)this.c);
      linearLayout1.setOrientation(1);
      TextView textView2 = new TextView();
      this((Context)this.c);
      textView2.setId(d.a.a());
      textView2.setText("登录遇到问题?");
      textView2.setTextSize(12.0F);
      textView2.setTextColor(Color.parseColor("#000000"));
      LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams();
      this(-1, -2);
      layoutParams2.setMargins(30, 26, 20, 10);
      linearLayout1.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams2);
      RadioGroup radioGroup = new RadioGroup();
      this((Context)this.c);
      this.d = radioGroup;
      this.d.setId(d.b.a());
      this.d.setOrientation(0);
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams();
      this(-1, -2);
      layoutParams1.setMargins(20, 0, 20, 0);
      linearLayout1.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams1);
      while (b < 3) {
        RadioButton radioButton = new RadioButton();
        this((Context)this.c);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        Log.d("frameLib.pd", stringBuilder.append("iv...msg:").append(String.valueOf(a.get(b))).toString());
        radioButton.setText(String.valueOf(a.get(b)));
        radioButton.setTextSize(11.0F);
        radioButton.setId(d.f.a() + b);
        this.d.addView((View)radioButton);
        b++;
      } 
      this.d.check(d.f.a());
      LinearLayout linearLayout2 = new LinearLayout();
      this((Context)this.c);
      linearLayout2.setOrientation(0);
      linearLayout2.setWeightSum(2.0F);
      layoutParams2 = new LinearLayout.LayoutParams();
      this(-1, -2);
      layoutParams2.setMargins(20, 10, 20, 20);
      linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams2);
      layoutParams2 = new LinearLayout.LayoutParams();
      this(0, -2);
      layoutParams2.setMargins(10, 0, 10, 0);
      layoutParams2.weight = 1.0F;
      FancyButton fancyButton = new FancyButton();
      this((Context)this.c);
      fancyButton.setTextSize(11);
      fancyButton.setTextColor(-1);
      fancyButton.setId(d.d.a());
      fancyButton.setOnClickListener(this);
      fancyButton.setRadius(a(10.0F));
      fancyButton.setBorderColor(Color.parseColor("#ffff0000"));
      fancyButton.setBackgroundColor(Color.parseColor("#ffff0000"));
      fancyButton.setFocusBackgroundColor(-65536);
      fancyButton.setPadding(10, 10, 10, 10);
      fancyButton.setText("提交问题");
      linearLayout2.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams2);
      fancyButton = new FancyButton();
      this((Context)this.c);
      fancyButton.setTextSize(11);
      fancyButton.setTextColor(Color.parseColor("#ffff0000"));
      fancyButton.setId(d.e.a());
      fancyButton.setOnClickListener(this);
      fancyButton.setRadius(a(10.0F));
      fancyButton.setBorderColor(Color.parseColor("#ffff0000"));
      fancyButton.setBorderWidth(a(1.0F));
      fancyButton.setBackgroundColor(-1);
      fancyButton.setFocusBackgroundColor(-65536);
      fancyButton.setPadding(10, 10, 10, 10);
      fancyButton.setText("没有问题");
      linearLayout2.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams2);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams();
      this(-1, -1);
      h.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
      TextView textView1 = new TextView();
      this((Context)this.c);
      textView1.setId(d.c.a());
      textView1.setOnClickListener(this);
      textView1.setText("X");
      textView1.setTextSize(16.0F);
      textView1.setTextColor(Color.parseColor("#ffff0000"));
      layoutParams = new FrameLayout.LayoutParams();
      this(-2, -2);
      layoutParams.gravity = 5;
      layoutParams.setMargins(0, 20, 20, 0);
      h.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams);
      setContentView((View)h);
    } catch (Exception exception) {}
  }
  
  private void a(Context paramContext) {
    try {
      getWindow().requestFeature(1);
      getWindow().getDecorView().setBackgroundColor(0);
      this.c = (Activity)paramContext;
      a();
    } catch (Exception exception) {}
  }
  
  protected int a(float paramFloat) {
    return (int)((this.c.getResources().getDisplayMetrics()).density * paramFloat + 0.5F);
  }
  
  public void a(f paramf) {
    this.e = paramf;
  }
  
  public void onClick(View paramView) {
    int i;
    boolean bool = false;
    try {
      i = paramView.getId();
      if (i == d.c.a()) {
        dismiss();
        return;
      } 
      if (i == d.d.a()) {
        if (this.d != null) {
          i = this.d.getCheckedRadioButtonId() - d.f.a();
        } else {
          i = 0;
        } 
        if (i < 0)
          i = bool; 
        if (this.e != null)
          this.e.a(i); 
        dismiss();
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    if (i == d.e.a())
      dismiss(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */