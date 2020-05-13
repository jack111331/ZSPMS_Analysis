package com.zz.sdk.e;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.b.u;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;

class hd extends BaseAdapter {
  private Context a;
  
  private u[] b;
  
  private String c;
  
  private Rect d;
  
  private int e;
  
  hd(Context paramContext, String paramString, u[] paramArrayOfu) {
    this.a = paramContext;
    this.c = paramString;
    this.d = cd.p.a();
    b(paramArrayOfu);
  }
  
  private View a(Context paramContext, ViewGroup paramViewGroup) {
    hf hf = new hf(null);
    FrameLayout frameLayout = new FrameLayout(paramContext);
    frameLayout.setBackgroundDrawable((Drawable)ca.a(this.a, ca.ak, ca.B));
    frameLayout.setTag(hf);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setPadding(this.d.left, this.d.top, this.d.right, this.d.bottom);
    linearLayout.setOrientation(0);
    frameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    TextView textView2 = new TextView(paramContext);
    textView2.setGravity(17);
    linearLayout.addView((View)textView2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1, 1.0F));
    textView2.setText(cg.aE.a());
    textView2.setPadding(0, 0, this.d.right, 0);
    textView2.setTextColor(ce.r.a());
    cf.m.a(textView2);
    TextView textView1 = new TextView(paramContext);
    textView1.setGravity(17);
    linearLayout.addView((View)textView1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1, 1.0F));
    textView1.setTextColor(ce.s.a());
    cf.n.a(textView1);
    hf.a = textView1;
    return (View)frameLayout;
  }
  
  private void b(u[] paramArrayOfu) {
    if (paramArrayOfu == null) {
      this.b = new u[0];
      return;
    } 
    this.b = paramArrayOfu;
  }
  
  public u a(int paramInt) {
    return (paramInt < 0 || paramInt >= this.b.length) ? null : this.b[paramInt];
  }
  
  void a(u[] paramArrayOfu) {
    b(paramArrayOfu);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.b.length;
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null)
      view = a(this.a, paramViewGroup); 
    hf hf = (hf)view.getTag();
    u u1 = a(paramInt);
    if (u1 != null) {
      String str1 = cv.a(u1.d / 100.0D);
      hf.a.setText(String.format(this.c, new Object[] { str1 }));
      return view;
    } 
    String str = "??";
    hf.a.setText(String.format(this.c, new Object[] { str }));
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */