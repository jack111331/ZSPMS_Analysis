package com.zz.sdk.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.b.k;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.ce;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;
import com.zz.sdk.lib.widget.roundview.c;

class p extends BaseAdapter {
  private int a = -1;
  
  private Context b;
  
  private k[] c;
  
  private int d;
  
  public p(Context paramContext, k[] paramArrayOfk) {
    this.b = paramContext;
    this.c = paramArrayOfk;
    this.d = cc.c.a();
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  public String b(int paramInt) {
    return (this.c == null || paramInt < 0 || paramInt >= this.c.length) ? "" : (this.c[paramInt]).x;
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
    q q1;
    q q2;
    if (paramView == null) {
      RoundLinearLayout roundLinearLayout = new RoundLinearLayout(this.b);
      q1 = new q(this);
      roundLinearLayout.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.d));
      q1.a = roundLinearLayout;
      TextView textView = new TextView(this.b);
      textView.setGravity(17);
      textView.setTextSize(20.0F);
      textView.setTextColor(ce.l.a());
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)roundLinearLayout).addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
      q1.b = textView;
      roundLinearLayout.setTag(q1);
    } else {
      q q = (q)q1.getTag();
      q2 = q1;
      q1 = q;
    } 
    c c = q1.a.getDelegate();
    c.c(5);
    c.d(1);
    if (this.a == paramInt) {
      c.e(-236427);
    } else {
      c.e(-1118479);
    } 
    if (this.c != null && paramInt >= 0 && paramInt < this.c.length) {
      q1.b.setText((this.c[paramInt]).x);
      return (View)q2;
    } 
    q1.b.setText("??:" + paramInt);
    return (View)q2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */