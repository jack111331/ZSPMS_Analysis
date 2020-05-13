package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.b.k;
import com.zz.sdk.i.a;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;

public class cq {
  cp a;
  
  TextView b;
  
  CheckBox c;
  
  ImageView d;
  
  @SuppressLint({"NewApi"})
  cq(co paramco, cp paramcp) {
    this.a = paramcp;
    this.a.setBackgroundDrawable(ca.ak.a(co.a(paramco)));
    AbsListView.LayoutParams layoutParams1 = new AbsListView.LayoutParams(-1, -2);
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.a.setOrientation(0);
    paramcp.setDescendantFocusability(393216);
    TextView textView = new TextView(co.a(paramco));
    textView.setGravity(16);
    cf.g.a(textView);
    textView.setTextColor(ce.x.a());
    textView.setSingleLine();
    cd.m.a((View)textView);
    this.b = textView;
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.weight = 1.0F;
    this.a.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    this.c = new CheckBox(co.a(paramco));
    this.c.setEnabled(false);
    this.a.a(this.c);
    this.d = new ImageView(co.a(paramco));
    cd.m.a((View)this.d);
    this.a.addView((View)this.d);
  }
  
  void a(k paramk, int paramInt) {
    if (a.a() && 7 == paramk.B) {
      this.b.setText(cg.V.a());
    } else {
      this.b.setText(paramk.x + "支付");
    } 
    ca ca = ca.a(paramk.B);
    if (ca != null) {
      this.b.setCompoundDrawablesWithIntrinsicBounds(ca.a(co.a(this.e)), null, null, null);
      this.b.setCompoundDrawablePadding(cc.a(4.0F));
    } 
    if (co.b(this.e) == paramInt) {
      this.d.setImageDrawable(ca.an.a(co.a(this.e)));
      return;
    } 
    this.d.setImageDrawable(ca.ao.a(co.a(this.e)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */