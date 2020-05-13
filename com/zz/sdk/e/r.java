package com.zz.sdk.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;
import com.zz.sdk.lib.widget.roundview.c;
import java.text.NumberFormat;

class r extends BaseAdapter {
  private int a = -1;
  
  private Context b;
  
  private NumberFormat c;
  
  private String d;
  
  private double[] e;
  
  public r(Context paramContext, NumberFormat paramNumberFormat, String paramString, double[] paramArrayOfdouble) {
    this.b = paramContext;
    this.c = paramNumberFormat;
    this.d = paramString;
    this.e = paramArrayOfdouble;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(double[] paramArrayOfdouble) {
    this.e = paramArrayOfdouble;
    notifyDataSetInvalidated();
  }
  
  public double b(int paramInt) {
    return (this.e == null || paramInt < 0 || paramInt >= this.e.length) ? 0.0D : this.e[paramInt];
  }
  
  public int getCount() {
    return (this.e == null) ? 0 : this.e.length;
  }
  
  public Object getItem(int paramInt) {
    return (this.e == null || paramInt < 0 || paramInt >= this.e.length) ? null : Double.valueOf(this.e[paramInt]);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    RoundLinearLayout roundLinearLayout;
    s s;
    if (paramView == null) {
      roundLinearLayout = new RoundLinearLayout(this.b);
      s = new s(this);
      roundLinearLayout.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -1));
      s.a = roundLinearLayout;
      TextView textView = new TextView(this.b);
      textView.setGravity(17);
      textView.setTextSize(20.0F);
      textView.setTextColor(ce.l.a());
      cd.o.a((View)textView);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)roundLinearLayout).addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
      s.b = textView;
      roundLinearLayout.setTag(s);
    } else {
      s = (s)roundLinearLayout.getTag();
    } 
    c c = s.a.getDelegate();
    c.c(5);
    c.d(1);
    if (this.a == paramInt) {
      c.e(-236427);
    } else {
      c.e(-1118479);
    } 
    if (this.e != null && paramInt >= 0 && paramInt < this.e.length) {
      s.b.setText(String.format(this.d, new Object[] { this.c.format(this.e[paramInt]) }));
      return (View)roundLinearLayout;
    } 
    s.b.setText("??:" + paramInt);
    return (View)roundLinearLayout;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */