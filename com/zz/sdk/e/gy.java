package com.zz.sdk.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;

final class gy extends BaseAdapter {
  public static final int a = -1;
  
  public static final int b = 0;
  
  public static final int c = 1;
  
  public static final int d = -1;
  
  private final int f;
  
  private final int g;
  
  private final int h;
  
  private final int i;
  
  private final Context j;
  
  private int k;
  
  private double[] l;
  
  private double m;
  
  public gy(go paramgo, Context paramContext, int paramInt) {
    this.j = paramContext;
    this.f = paramInt;
    this.g = cc.B.a();
    this.h = ce.i.a();
    this.i = ce.g.a();
    this.k = -1;
  }
  
  private View a(Context paramContext) {
    FrameLayout frameLayout = new FrameLayout(paramContext);
    frameLayout.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.g));
    gz gz = new gz(this, null);
    frameLayout.setTag(gz);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    frameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    linearLayout.setOrientation(0);
    TextView textView2 = new TextView(paramContext);
    linearLayout.addView((View)textView2);
    textView2.setGravity(81);
    cf.t.a(textView2);
    gz.a = textView2;
    TextView textView1 = new TextView(paramContext);
    linearLayout.addView((View)textView1);
    textView1.setText(cg.K.a());
    textView1.setGravity(81);
    cf.u.a(textView1);
    gz.b = textView1;
    return (View)frameLayout;
  }
  
  private int b(int paramInt) {
    byte b = 1;
    if (this.f == 6) {
      if (this.l[paramInt] < 50.0D || this.l[paramInt] < this.m)
        return -1; 
      if (paramInt != this.k)
        b = 0; 
      return b;
    } 
    if (this.l[paramInt] < this.m)
      return -1; 
    if (paramInt != this.k)
      b = 0; 
    return b;
  }
  
  public double a(double paramDouble) {
    int i = a();
    if (i != -1)
      paramDouble = this.l[i]; 
    return paramDouble;
  }
  
  public int a() {
    return (this.k >= 0 && this.k < getCount() && b(this.k) == 1) ? this.k : -1;
  }
  
  public void a(int paramInt) {
    if (b(paramInt) != -1) {
      this.k = paramInt;
      notifyDataSetInvalidated();
    } 
  }
  
  public void a(double[] paramArrayOfdouble, double paramDouble) {
    this.l = paramArrayOfdouble;
    this.m = paramDouble;
    this.k = -1;
    notifyDataSetInvalidated();
  }
  
  public int getCount() {
    return (this.l == null) ? 0 : this.l.length;
  }
  
  public Object getItem(int paramInt) {
    return (paramInt >= 0 && paramInt < getCount()) ? Double.valueOf(this.l[paramInt]) : null;
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    boolean bool;
    View view = paramView;
    if (paramView == null)
      view = a(this.j); 
    gz gz = (gz)view.getTag();
    gz.a.setText(cv.a(go.z()[paramInt]));
    int i = b(paramInt);
    if (i == 1) {
      view.setBackgroundDrawable(ca.bW.a(this.j));
    } else if (i == 0) {
      view.setBackgroundDrawable((Drawable)ca.a(this.j, ca.bV, ca.bW));
    } else {
      view.setBackgroundDrawable(ca.bX.a(this.j));
    } 
    if (i != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setEnabled(bool);
    view.setPadding(0, 0, 0, 0);
    TextView textView = gz.a;
    if (i == 1) {
      paramInt = this.h;
    } else {
      paramInt = this.i;
    } 
    textView.setTextColor(paramInt);
    textView = gz.b;
    if (i == 1) {
      paramInt = this.h;
      textView.setTextColor(paramInt);
      return view;
    } 
    paramInt = this.i;
    textView.setTextColor(paramInt);
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */