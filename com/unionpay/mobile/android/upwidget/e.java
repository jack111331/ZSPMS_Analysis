package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class e extends BaseAdapter {
  private Drawable a;
  
  private Context b;
  
  private String c = null;
  
  private String d = null;
  
  private int e = 1;
  
  private List<Map<String, Object>> f;
  
  private ArrayList<View.OnClickListener> g = new ArrayList<View.OnClickListener>();
  
  private View.OnClickListener h = new f(this);
  
  public e(Context paramContext, List<Map<String, Object>> paramList, String paramString) {
    this.b = paramContext;
    this.f = paramList;
    this.c = paramString;
    this.e = 0;
    this.a = c.a(this.b).a(1015);
  }
  
  private boolean b() {
    return (this.c != null && !TextUtils.isEmpty(this.c));
  }
  
  private boolean b(int paramInt) {
    boolean bool = true;
    paramInt -= a();
    if (this.f != null && paramInt != this.f.size()) {
      Object object = ((Map)this.f.get(paramInt)).get("available");
      if (object != null && Boolean.FALSE == (Boolean)object)
        return false; 
      bool = true;
    } 
    return bool;
  }
  
  public final int a() {
    return b() ? 1 : 0;
  }
  
  public final void a(int paramInt) {
    this.e = paramInt;
  }
  
  public final int getCount() {
    byte b = 1;
    int i = 0;
    if (this.f != null) {
      int j = this.f.size();
      int k = a();
      if (this.d != null && !TextUtils.isEmpty(this.d)) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i) {
        i = b;
      } else {
        i = 0;
      } 
      i = k + j + i;
    } 
    return i;
  }
  
  public final Object getItem(int paramInt) {
    Object object1 = null;
    Object object2 = object1;
    if (paramInt != 0) {
      object2 = object1;
      if (this.f != null) {
        object2 = object1;
        if (paramInt < this.f.size())
          object2 = this.f.get(paramInt - a()); 
      } 
    } 
    return object2;
  }
  
  public final long getItemId(int paramInt) {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    char c;
    getItem(paramInt);
    Map map = this.f.get(paramInt - a());
    String str = (String)map.get("style");
    List<CharSequence> list1 = (List)map.get("keys");
    List<CharSequence> list2 = (List)map.get("values");
    LinearLayout linearLayout2 = new LinearLayout(this.b);
    linearLayout2.setOrientation(1);
    RelativeLayout relativeLayout = new RelativeLayout(this.b);
    int i = b.g;
    relativeLayout.setPadding(i, i, i, i);
    linearLayout2.addView((View)relativeLayout);
    LinearLayout linearLayout1 = new LinearLayout(this.b);
    linearLayout1.setBackgroundColor(-3419943);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
    ImageView imageView = new ImageView(this.b);
    imageView.setVisibility(4);
    imageView.setId(imageView.hashCode());
    TextView textView = new TextView(this.b);
    textView.setSingleLine(true);
    textView.setEllipsize(TextUtils.TruncateAt.END);
    textView.setText(str);
    textView.setTextSize(b.i);
    textView.setTextColor(-10066330);
    int j = g.a(this.b, 20.0F);
    if (this.e == paramInt) {
      c = 'ϰ';
    } else {
      c = 'ϯ';
    } 
    int k = g.a(this.b, 20.0F);
    Drawable drawable = c.a(this.b).a(c, j, j);
    if (b(paramInt))
      imageView.setVisibility(0); 
    imageView.setBackgroundDrawable(drawable);
    drawable = this.a;
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(k, k);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(9, -1);
    relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(1, imageView.hashCode());
    layoutParams1.leftMargin = b.g;
    relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout3 = new LinearLayout(this.b);
    linearLayout3.setOrientation(1);
    linearLayout3.setGravity(5);
    linearLayout3.setId(linearLayout3.hashCode());
    LinearLayout linearLayout4 = new LinearLayout(this.b);
    linearLayout4.setOrientation(1);
    linearLayout4.setGravity(5);
    linearLayout4.setId(linearLayout4.hashCode());
    for (paramInt = 0; paramInt < list1.size(); paramInt++) {
      TextView textView1 = new TextView(this.b);
      textView1.setSingleLine(true);
      textView1.setEllipsize(TextUtils.TruncateAt.END);
      textView1.setText(list1.get(paramInt));
      textView1.setTextSize(b.k);
      textView1.setTextColor(-6710887);
      LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams3.gravity = 5;
      linearLayout3.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams3);
      textView1 = new TextView(this.b);
      textView1.setSingleLine(true);
      textView1.setEllipsize(TextUtils.TruncateAt.END);
      textView1.setText(list2.get(paramInt));
      textView1.setTextSize(b.k);
      textView1.setTextColor(-6710887);
      linearLayout4.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams3);
    } 
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g.a(this.b, 120.0F), -2);
    layoutParams2.addRule(11, -1);
    relativeLayout.addView((View)linearLayout4, (ViewGroup.LayoutParams)layoutParams2);
    layoutParams2 = new RelativeLayout.LayoutParams(g.a(this.b, 100.0F), -2);
    layoutParams2.addRule(0, linearLayout4.getId());
    relativeLayout.addView((View)linearLayout3, (ViewGroup.LayoutParams)layoutParams2);
    layoutParams.rightMargin = i;
    layoutParams.leftMargin = i;
    linearLayout2.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
    return (View)linearLayout2;
  }
  
  public final boolean isEnabled(int paramInt) {
    return ((b() && paramInt == 0) || !b(paramInt)) ? false : super.isEnabled(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */