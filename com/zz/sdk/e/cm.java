package com.zz.sdk.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.b.k;
import com.zz.sdk.i.a;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.df;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

class cm extends BaseAdapter {
  private int a = -1;
  
  private Context b;
  
  private k[] c;
  
  private int d;
  
  private int e;
  
  public cm(Context paramContext, k[] paramArrayOfk, int paramInt) {
    this.b = paramContext;
    this.d = cc.c.a();
    this.c = paramArrayOfk;
    this.e = paramInt;
  }
  
  protected void a(int paramInt) {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  protected void a(k[] paramArrayOfk) {
    this.c = paramArrayOfk;
    notifyDataSetInvalidated();
  }
  
  public int getCount() {
    return (this.c == null) ? 0 : this.c.length;
  }
  
  public Object getItem(int paramInt) {
    return (this.c == null || paramInt < 0 || paramInt >= this.c.length) ? null : this.c[paramInt];
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    RelativeLayout relativeLayout;
    if (this.c != null) {
      RelativeLayout relativeLayout1 = (RelativeLayout)paramView;
      if (relativeLayout1 == null) {
        cn cn1 = new cn(this);
        relativeLayout1 = new RelativeLayout(this.b);
        relativeLayout1.setTag(cn1);
        relativeLayout1.setGravity(16);
        relativeLayout1.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.d));
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -1));
        relativeLayout1.addView((View)linearLayout);
        cn1.a = linearLayout;
        ImageView imageView2 = new ImageView(this.b);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(cc.i.a(), cc.i.a());
        if (this.e == 2) {
          int i = df.a(this.b, 8.0F);
          layoutParams1.setMargins(i, 0, i, 0);
        } else {
          layoutParams1.setMargins(0, 0, df.a(this.b, 15.0F), 0);
        } 
        linearLayout.addView((View)imageView2, (ViewGroup.LayoutParams)layoutParams1);
        cn1.b = imageView2;
        TextView textView = new TextView(this.b);
        textView.setGravity(16);
        textView.setTextColor(-11840933);
        textView.setSingleLine();
        textView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-2, -1));
        cf.c.a(textView);
        linearLayout.addView((View)textView);
        cn1.c = textView;
        FancyButton fancyButton = new FancyButton(this.b);
        fancyButton.setRadius(cc.a(3.0F));
        fancyButton.setBorderColor(-236427);
        fancyButton.setBorderWidth(cc.a(1.0F));
        fancyButton.setBackgroundColor(-1);
        fancyButton.setFocusBackgroundColor(-1);
        fancyButton.setText("推荐");
        fancyButton.setTextColor(-236427);
        fancyButton.setTextSize(9);
        fancyButton.setClickable(false);
        fancyButton.setFocusable(false);
        cd.w.a((View)fancyButton);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = df.a(this.b, 8.0F);
        layoutParams2.gravity = 16;
        linearLayout.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams2);
        cn1.d = fancyButton;
        ImageView imageView1 = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cc.k.a(), cc.k.a());
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        if (this.e == 2) {
          layoutParams.rightMargin = df.a(this.b, 20.0F);
        } else {
          layoutParams.rightMargin = df.a(this.b, 10.0F);
        } 
        relativeLayout1.addView((View)imageView1, (ViewGroup.LayoutParams)layoutParams);
        cn1.e = imageView1;
        if (this.e == 2 && paramInt % 2 == 0) {
          TextView textView1 = new TextView(this.b);
          RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(cc.a(1.0F), -1);
          layoutParams3.addRule(11);
          layoutParams3.addRule(15);
          layoutParams3.topMargin = df.a(this.b, 8.0F);
          layoutParams3.bottomMargin = df.a(this.b, 8.0F);
          relativeLayout1.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams3);
        } 
        if (paramInt == this.a) {
          imageView1.setBackgroundDrawable(ca.ax.a(this.b));
        } else {
          imageView1.setBackgroundDrawable((Drawable)ca.a(this.b, ca.au, ca.ax));
        } 
        if (a.a() && 7 == (this.c[paramInt]).B) {
          textView.setText(cg.V.a());
        } else {
          textView.setText((this.c[paramInt]).x);
        } 
        ca ca1 = ca.a((this.c[paramInt]).B);
        RelativeLayout relativeLayout2 = relativeLayout1;
        if (ca1 != null) {
          imageView2.setBackgroundDrawable(ca1.a(this.b));
          if ((this.c[paramInt]).D == 1) {
            fancyButton.setVisibility(0);
          } else {
            fancyButton.setVisibility(8);
          } 
          textView.setCompoundDrawablePadding(cc.a(4.0F));
          relativeLayout2 = relativeLayout1;
        } 
        return (View)relativeLayout2;
      } 
      cn cn = (cn)relativeLayout1.getTag();
      if (paramInt == this.a) {
        cn.e.setBackgroundDrawable(ca.ax.a(this.b));
      } else {
        cn.e.setBackgroundDrawable((Drawable)ca.a(this.b, ca.au, ca.ax));
      } 
      if (a.a() && 7 == (this.c[paramInt]).B) {
        cn.c.setText(cg.V.a());
      } else {
        cn.c.setText((this.c[paramInt]).x);
      } 
      ca ca = ca.a((this.c[paramInt]).B);
      relativeLayout = relativeLayout1;
      if (ca != null) {
        cn.b.setBackgroundDrawable(ca.a(this.b));
        if ((this.c[paramInt]).D == 1) {
          cn.d.setVisibility(0);
        } else {
          cn.d.setVisibility(8);
        } 
        cn.c.setCompoundDrawablePadding(cc.a(4.0F));
        relativeLayout = relativeLayout1;
      } 
    } 
    return (View)relativeLayout;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */