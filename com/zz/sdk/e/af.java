package com.zz.sdk.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.a.a.b.a;
import com.zz.sdk.b.q;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cv;
import java.util.List;

class af extends BaseAdapter {
  private Context b;
  
  private String c;
  
  private List d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  public af(x paramx, Context paramContext, String paramString, List paramList) {
    this.b = paramContext;
    this.c = paramString;
    this.d = paramList;
    this.e = cc.v.a();
    this.f = cc.w.a();
    this.g = cc.x.a();
  }
  
  private View a(Context paramContext) {
    ah ah = new ah(this, paramContext);
    ah.setOrientation(0);
    ah.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.C, ca.D));
    ag ag = new ag(this, null);
    ah.setTag(ag);
    ah.setPadding(this.g, this.g, this.g, this.g);
    ah.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -2));
    FrameLayout frameLayout = new FrameLayout(paramContext);
    ah.addView((View)frameLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(this.e, -1));
    a a = new a(paramContext);
    frameLayout.addView((View)a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(this.e, this.f, 16));
    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ag.b = (ImageView)a;
    LinearLayout linearLayout = new LinearLayout(paramContext);
    ah.addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1, 1.0F));
    linearLayout.setOrientation(1);
    linearLayout.setPadding(this.g, 0, this.g, 0);
    TextView textView = new TextView(paramContext);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1, 3.0F));
    textView.setGravity(16);
    cf.p.a(textView);
    ag.d = textView;
    textView = new TextView(paramContext);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1, 2.0F));
    textView.setGravity(16);
    cf.q.a(textView);
    ag.e = textView;
    ImageView imageView = new ImageView(paramContext);
    imageView.setImageDrawable((Drawable)ca.a(paramContext, ca.E, ca.F));
    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ah.addView((View)imageView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -1));
    ag.c = imageView;
    return (View)ah;
  }
  
  protected void a(List paramList) {
    this.d = paramList;
    notifyDataSetInvalidated();
  }
  
  public int getCount() {
    return this.d.size();
  }
  
  public Object getItem(int paramInt) {
    return (paramInt < 0 || paramInt >= this.d.size()) ? null : this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null) {
      paramView = a(this.b);
      view = paramView;
      if (paramView == null)
        return null; 
    } 
    ag ag = (ag)view.getTag();
    Object object = getItem(paramInt);
    if (object instanceof q) {
      object = object;
      x.a(this.a).a(((q)object).d, ag.b);
      ag.d.setText(((q)object).c);
      ag.e.setText(String.format(this.c, new Object[] { cv.a(((q)object).f) }));
    } 
    ag.a(null);
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */